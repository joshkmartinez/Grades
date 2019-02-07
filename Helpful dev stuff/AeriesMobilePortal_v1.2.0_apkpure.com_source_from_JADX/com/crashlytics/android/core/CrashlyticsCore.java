package com.crashlytics.android.core;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.vision.face.Face;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.common.FirebaseInfo;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityCallable;
import io.fabric.sdk.android.services.concurrency.Task;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.network.PinningInfoProvider;
import io.fabric.sdk.android.services.persistence.FileStore;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;

@DependsOn({CrashlyticsNdkDataProvider.class})
public class CrashlyticsCore extends Kit<Void> {
    static final float CLS_DEFAULT_PROCESS_DELAY = 1.0f;
    static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
    static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
    static final String CRASH_MARKER_FILE_NAME = "crash_marker";
    static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 4;
    private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
    static final int MAX_ATTRIBUTES = 64;
    static final int MAX_ATTRIBUTE_SIZE = 1024;
    private static final String MISSING_BUILD_ID_MSG = "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.";
    private static final String PREFERENCE_STORE_NAME = "com.crashlytics.android.core.CrashlyticsCore";
    public static final String TAG = "CrashlyticsCore";
    private final ConcurrentHashMap<String, String> attributes;
    private CrashlyticsBackgroundWorker backgroundWorker;
    private CrashlyticsController controller;
    private CrashlyticsFileMarker crashMarker;
    private CrashlyticsNdkDataProvider crashlyticsNdkDataProvider;
    private float delay;
    private boolean disabled;
    private HttpRequestFactory httpRequestFactory;
    private CrashlyticsFileMarker initializationMarker;
    private CrashlyticsListener listener;
    private final PinningInfoProvider pinningInfo;
    private final long startTime;
    private String userEmail;
    private String userId;
    private String userName;

    class C03972 implements Callable<Void> {
        C03972() {
        }

        public Void call() throws Exception {
            CrashlyticsCore.this.initializationMarker.create();
            Fabric.getLogger().mo2301d(CrashlyticsCore.TAG, "Initialization marker file created.");
            return null;
        }
    }

    class C03983 implements Callable<Boolean> {
        C03983() {
        }

        public Boolean call() throws Exception {
            try {
                boolean remove = CrashlyticsCore.this.initializationMarker.remove();
                Logger logger = Fabric.getLogger();
                String str = CrashlyticsCore.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Initialization marker file removed: ");
                stringBuilder.append(remove);
                logger.mo2301d(str, stringBuilder.toString());
                return Boolean.valueOf(remove);
            } catch (Throwable e) {
                Fabric.getLogger().mo2304e(CrashlyticsCore.TAG, "Problem encountered deleting Crashlytics initialization marker.", e);
                return Boolean.valueOf(false);
            }
        }
    }

    class C03994 implements Callable<Boolean> {
        C03994() {
        }

        public Boolean call() throws Exception {
            return Boolean.valueOf(CrashlyticsCore.this.initializationMarker.isPresent());
        }
    }

    public static class Builder {
        private float delay = Face.UNCOMPUTED_PROBABILITY;
        private boolean disabled = false;
        private CrashlyticsListener listener;
        private PinningInfoProvider pinningInfoProvider;

        public Builder delay(float f) {
            if (f <= 0.0f) {
                throw new IllegalArgumentException("delay must be greater than 0");
            } else if (this.delay <= 0.0f) {
                this.delay = f;
                return this;
            } else {
                throw new IllegalStateException("delay already set.");
            }
        }

        public Builder listener(CrashlyticsListener crashlyticsListener) {
            if (crashlyticsListener == null) {
                throw new IllegalArgumentException("listener must not be null.");
            } else if (this.listener == null) {
                this.listener = crashlyticsListener;
                return this;
            } else {
                throw new IllegalStateException("listener already set.");
            }
        }

        @Deprecated
        public Builder pinningInfo(PinningInfoProvider pinningInfoProvider) {
            if (pinningInfoProvider == null) {
                throw new IllegalArgumentException("pinningInfoProvider must not be null.");
            } else if (this.pinningInfoProvider == null) {
                this.pinningInfoProvider = pinningInfoProvider;
                return this;
            } else {
                throw new IllegalStateException("pinningInfoProvider already set.");
            }
        }

        public Builder disabled(boolean z) {
            this.disabled = z;
            return this;
        }

        public CrashlyticsCore build() {
            if (this.delay < 0.0f) {
                this.delay = CrashlyticsCore.CLS_DEFAULT_PROCESS_DELAY;
            }
            return new CrashlyticsCore(this.delay, this.listener, this.pinningInfoProvider, this.disabled);
        }
    }

    private static final class CrashMarkerCheck implements Callable<Boolean> {
        private final CrashlyticsFileMarker crashMarker;

        public CrashMarkerCheck(CrashlyticsFileMarker crashlyticsFileMarker) {
            this.crashMarker = crashlyticsFileMarker;
        }

        public Boolean call() throws Exception {
            if (!this.crashMarker.isPresent()) {
                return Boolean.FALSE;
            }
            Fabric.getLogger().mo2301d(CrashlyticsCore.TAG, "Found previous crash marker.");
            this.crashMarker.remove();
            return Boolean.TRUE;
        }
    }

    private static final class NoOpListener implements CrashlyticsListener {
        public void crashlyticsDidDetectCrashDuringPreviousExecution() {
        }

        private NoOpListener() {
        }
    }

    class C09801 extends PriorityCallable<Void> {
        C09801() {
        }

        public Void call() throws Exception {
            return CrashlyticsCore.this.doInBackground();
        }

        public Priority getPriority() {
            return Priority.IMMEDIATE;
        }
    }

    public String getIdentifier() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    public String getVersion() {
        return "2.5.0.20";
    }

    public CrashlyticsCore() {
        this(CLS_DEFAULT_PROCESS_DELAY, null, null, false);
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z) {
        this(f, crashlyticsListener, pinningInfoProvider, z, ExecutorUtils.buildSingleThreadExecutorService("Crashlytics Exception Handler"));
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z, ExecutorService executorService) {
        this.userId = null;
        this.userEmail = null;
        this.userName = null;
        this.delay = f;
        if (crashlyticsListener == null) {
            crashlyticsListener = new NoOpListener();
        }
        this.listener = crashlyticsListener;
        this.pinningInfo = pinningInfoProvider;
        this.disabled = z;
        this.backgroundWorker = new CrashlyticsBackgroundWorker(executorService);
        this.attributes = new ConcurrentHashMap();
        this.startTime = System.currentTimeMillis();
    }

    protected boolean onPreExecute() {
        return onPreExecute(super.getContext());
    }

    boolean onPreExecute(Context context) {
        Context context2 = context;
        if (this.disabled) {
            return false;
        }
        String value = new ApiKey().getValue(context2);
        if (value == null) {
            return false;
        }
        String resolveBuildId = CommonUtils.resolveBuildId(context);
        if (isBuildIdValid(resolveBuildId, CommonUtils.getBooleanResourceValue(context2, CRASHLYTICS_REQUIRE_BUILD_ID, true))) {
            try {
                Logger logger = Fabric.getLogger();
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Initializing Crashlytics ");
                stringBuilder.append(getVersion());
                logger.mo2306i(str, stringBuilder.toString());
                FileStore fileStoreImpl = new FileStoreImpl(r11);
                r11.crashMarker = new CrashlyticsFileMarker(CRASH_MARKER_FILE_NAME, fileStoreImpl);
                r11.initializationMarker = new CrashlyticsFileMarker(INITIALIZATION_MARKER_FILE_NAME, fileStoreImpl);
                PreferenceManager create = PreferenceManager.create(new PreferenceStoreImpl(getContext(), PREFERENCE_STORE_NAME), r11);
                PinningInfoProvider crashlyticsPinningInfoProvider = r11.pinningInfo != null ? new CrashlyticsPinningInfoProvider(r11.pinningInfo) : null;
                r11.httpRequestFactory = new DefaultHttpRequestFactory(Fabric.getLogger());
                r11.httpRequestFactory.setPinningInfoProvider(crashlyticsPinningInfoProvider);
                IdManager idManager = getIdManager();
                AppData create2 = AppData.create(context2, idManager, value, resolveBuildId);
                UnityVersionProvider manifestUnityVersionProvider = new ManifestUnityVersionProvider(context2, create2.packageName);
                Logger logger2 = Fabric.getLogger();
                resolveBuildId = TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Installer package name is: ");
                stringBuilder2.append(create2.installerPackageName);
                logger2.mo2301d(resolveBuildId, stringBuilder2.toString());
                r11.controller = new CrashlyticsController(this, r11.backgroundWorker, r11.httpRequestFactory, idManager, create, fileStoreImpl, create2, manifestUnityVersionProvider, new FirebaseInfo().isFirebaseCrashlyticsEnabled(context2));
                boolean didPreviousInitializationFail = didPreviousInitializationFail();
                checkForPreviousCrash();
                r11.controller.enableExceptionHandling(Thread.getDefaultUncaughtExceptionHandler());
                if (didPreviousInitializationFail && CommonUtils.canTryConnection(context)) {
                    Fabric.getLogger().mo2301d(TAG, "Crashlytics did not finish previous background initialization. Initializing synchronously.");
                    finishInitSynchronously();
                    return false;
                }
                Fabric.getLogger().mo2301d(TAG, "Exception handling initialization successful");
                return true;
            } catch (Throwable e) {
                Fabric.getLogger().mo2304e(TAG, "Crashlytics was not started due to an exception during initialization", e);
                r11.controller = null;
                return false;
            }
        }
        throw new UnmetDependencyException(MISSING_BUILD_ID_MSG);
    }

    protected Void doInBackground() {
        markInitializationStarted();
        this.controller.cleanInvalidTempFiles();
        try {
            SettingsData awaitSettingsData = Settings.getInstance().awaitSettingsData();
            if (awaitSettingsData == null) {
                Fabric.getLogger().mo2314w(TAG, "Received null settings, skipping report submission!");
                markInitializationComplete();
                return null;
            } else if (awaitSettingsData.featuresData.collectReports) {
                CrashlyticsNdkData nativeCrashData = getNativeCrashData();
                if (!(nativeCrashData == null || this.controller.finalizeNativeReport(nativeCrashData))) {
                    Fabric.getLogger().mo2301d(TAG, "Could not finalize previous NDK sessions.");
                }
                if (!this.controller.finalizeSessions(awaitSettingsData.sessionData)) {
                    Fabric.getLogger().mo2301d(TAG, "Could not finalize previous sessions.");
                }
                this.controller.submitAllReports(this.delay, awaitSettingsData);
                markInitializationComplete();
                return null;
            } else {
                Fabric.getLogger().mo2301d(TAG, "Collection of crash reports disabled in Crashlytics settings.");
                markInitializationComplete();
                return null;
            }
        } catch (Throwable e) {
            Fabric.getLogger().mo2304e(TAG, "Crashlytics encountered a problem during asynchronous initialization.", e);
        } catch (Throwable th) {
            markInitializationComplete();
        }
    }

    public static CrashlyticsCore getInstance() {
        return (CrashlyticsCore) Fabric.getKit(CrashlyticsCore.class);
    }

    public PinningInfoProvider getPinningInfoProvider() {
        return !this.disabled ? this.pinningInfo : null;
    }

    public void logException(Throwable th) {
        if (this.disabled || !ensureFabricWithCalled("prior to logging exceptions.")) {
            return;
        }
        if (th == null) {
            Fabric.getLogger().log(5, TAG, "Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.controller.writeNonFatalException(Thread.currentThread(), th);
        }
    }

    public void log(String str) {
        doLog(3, TAG, str);
    }

    private void doLog(int i, String str, String str2) {
        if (!this.disabled && ensureFabricWithCalled("prior to logging messages.")) {
            this.controller.writeToLog(System.currentTimeMillis() - this.startTime, formatLogMessage(i, str, str2));
        }
    }

    public void log(int i, String str, String str2) {
        doLog(i, str, str2);
        Logger logger = Fabric.getLogger();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(str);
        str = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(str2);
        logger.log(i, str, stringBuilder.toString(), true);
    }

    public void setUserIdentifier(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userId = sanitizeAttribute(str);
            this.controller.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public void setUserName(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userName = sanitizeAttribute(str);
            this.controller.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public void setUserEmail(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userEmail = sanitizeAttribute(str);
            this.controller.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public void setString(String str, String str2) {
        if (this.disabled || !ensureFabricWithCalled("prior to setting keys.")) {
            return;
        }
        if (str == null) {
            str = getContext();
            if (str != null) {
                if (CommonUtils.isAppDebuggable(str) != null) {
                    throw new IllegalArgumentException("Custom attribute key must not be null.");
                }
            }
            Fabric.getLogger().mo2304e(TAG, "Attempting to set custom attribute with null key, ignoring.", null);
            return;
        }
        str = sanitizeAttribute(str);
        if (this.attributes.size() < 64 || this.attributes.containsKey(str)) {
            if (str2 == null) {
                str2 = "";
            } else {
                str2 = sanitizeAttribute(str2);
            }
            this.attributes.put(str, str2);
            this.controller.cacheKeyData(this.attributes);
            return;
        }
        Fabric.getLogger().mo2301d(TAG, "Exceeded maximum number of custom attributes (64)");
    }

    public void setBool(String str, boolean z) {
        setString(str, Boolean.toString(z));
    }

    public void setDouble(String str, double d) {
        setString(str, Double.toString(d));
    }

    public void setFloat(String str, float f) {
        setString(str, Float.toString(f));
    }

    public void setInt(String str, int i) {
        setString(str, Integer.toString(i));
    }

    public void setLong(String str, long j) {
        setString(str, Long.toString(j));
    }

    public void crash() {
        new CrashTest().indexOutOfBounds();
    }

    public boolean verifyPinning(URL url) {
        try {
            return internalVerifyPinning(url);
        } catch (URL url2) {
            Fabric.getLogger().mo2304e(TAG, "Could not verify SSL pinning", url2);
            return null;
        }
    }

    @Deprecated
    public synchronized void setListener(CrashlyticsListener crashlyticsListener) {
        Fabric.getLogger().mo2314w(TAG, "Use of setListener is deprecated.");
        if (crashlyticsListener != null) {
            this.listener = crashlyticsListener;
        } else {
            throw new IllegalArgumentException("listener must not be null.");
        }
    }

    Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(this.attributes);
    }

    CrashlyticsController getController() {
        return this.controller;
    }

    String getUserIdentifier() {
        return getIdManager().canCollectUserIds() ? this.userId : null;
    }

    String getUserEmail() {
        return getIdManager().canCollectUserIds() ? this.userEmail : null;
    }

    String getUserName() {
        return getIdManager().canCollectUserIds() ? this.userName : null;
    }

    private void finishInitSynchronously() {
        Callable c09801 = new C09801();
        for (Task addDependency : getDependencies()) {
            c09801.addDependency(addDependency);
        }
        Future submit = getFabric().getExecutorService().submit(c09801);
        Fabric.getLogger().mo2301d(TAG, "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (Throwable e) {
            Fabric.getLogger().mo2304e(TAG, "Crashlytics was interrupted during initialization.", e);
        } catch (Throwable e2) {
            Fabric.getLogger().mo2304e(TAG, "Problem encountered during Crashlytics initialization.", e2);
        } catch (Throwable e22) {
            Fabric.getLogger().mo2304e(TAG, "Crashlytics timed out during initialization.", e22);
        }
    }

    void markInitializationStarted() {
        this.backgroundWorker.submitAndWait(new C03972());
    }

    void markInitializationComplete() {
        this.backgroundWorker.submit(new C03983());
    }

    boolean didPreviousInitializationFail() {
        return ((Boolean) this.backgroundWorker.submitAndWait(new C03994())).booleanValue();
    }

    void setCrashlyticsNdkDataProvider(CrashlyticsNdkDataProvider crashlyticsNdkDataProvider) {
        this.crashlyticsNdkDataProvider = crashlyticsNdkDataProvider;
    }

    CrashlyticsNdkData getNativeCrashData() {
        return this.crashlyticsNdkDataProvider != null ? this.crashlyticsNdkDataProvider.getCrashlyticsNdkData() : null;
    }

    boolean internalVerifyPinning(URL url) {
        if (getPinningInfoProvider() == null) {
            return false;
        }
        url = this.httpRequestFactory.buildHttpRequest(HttpMethod.GET, url.toString());
        ((HttpsURLConnection) url.getConnection()).setInstanceFollowRedirects(false);
        url.code();
        return true;
    }

    private void checkForPreviousCrash() {
        if (Boolean.TRUE.equals((Boolean) this.backgroundWorker.submitAndWait(new CrashMarkerCheck(this.crashMarker)))) {
            try {
                this.listener.crashlyticsDidDetectCrashDuringPreviousExecution();
            } catch (Throwable e) {
                Fabric.getLogger().mo2304e(TAG, "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    void createCrashMarker() {
        this.crashMarker.create();
    }

    private static String formatLogMessage(int i, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CommonUtils.logPriorityToString(i));
        stringBuilder.append("/");
        stringBuilder.append(str);
        stringBuilder.append(" ");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    private static boolean ensureFabricWithCalled(String str) {
        CrashlyticsCore instance = getInstance();
        if (instance != null) {
            if (instance.controller != null) {
                return true;
            }
        }
        Logger logger = Fabric.getLogger();
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Crashlytics must be initialized by calling Fabric.with(Context) ");
        stringBuilder.append(str);
        logger.mo2304e(str2, stringBuilder.toString(), null);
        return null;
    }

    private static String sanitizeAttribute(String str) {
        if (str == null) {
            return str;
        }
        str = str.trim();
        return str.length() > 1024 ? str.substring(0, 1024) : str;
    }

    static boolean isBuildIdValid(String str, boolean z) {
        if (!z) {
            Fabric.getLogger().mo2301d(TAG, "Configured not to require a build ID.");
            return true;
        } else if (CommonUtils.isNullOrEmpty(str) == null) {
            return true;
        } else {
            Log.e(TAG, ".");
            Log.e(TAG, ".     |  | ");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".   \\ |  | /");
            Log.e(TAG, ".    \\    /");
            Log.e(TAG, ".     \\  /");
            Log.e(TAG, ".      \\/");
            Log.e(TAG, ".");
            Log.e(TAG, MISSING_BUILD_ID_MSG);
            Log.e(TAG, ".");
            Log.e(TAG, ".      /\\");
            Log.e(TAG, ".     /  \\");
            Log.e(TAG, ".    /    \\");
            Log.e(TAG, ".   / |  | \\");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".");
            return null;
        }
    }
}
