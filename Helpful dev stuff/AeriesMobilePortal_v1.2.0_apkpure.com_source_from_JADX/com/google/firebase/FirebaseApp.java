package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.components.Component;
import com.google.firebase.components.zzc;
import com.google.firebase.components.zzg;
import com.google.firebase.internal.InternalTokenProvider;
import com.google.firebase.internal.InternalTokenResult;
import com.google.firebase.internal.zzb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

public class FirebaseApp {
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";
    private static final Object sLock = new Object();
    private static final List<String> zza = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> zzb = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> zzc = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final List<String> zzd = Arrays.asList(new String[0]);
    private static final Set<String> zze = Collections.emptySet();
    @GuardedBy("sLock")
    static final Map<String, FirebaseApp> zzf = new ArrayMap();
    private final String mName;
    private final Context zzg;
    private final FirebaseOptions zzh;
    private final zzg zzi;
    private final AtomicBoolean zzj = new AtomicBoolean(false);
    private final AtomicBoolean zzk = new AtomicBoolean();
    private final List<IdTokenListener> zzl = new CopyOnWriteArrayList();
    private final List<BackgroundStateChangeListener> zzm = new CopyOnWriteArrayList();
    private final List<Object> zzn = new CopyOnWriteArrayList();
    private InternalTokenProvider zzo;
    private IdTokenListenersCountChangedListener zzp;

    @KeepForSdk
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    @KeepForSdk
    public interface IdTokenListener {
        @KeepForSdk
        void onIdTokenChanged(@NonNull InternalTokenResult internalTokenResult);
    }

    @KeepForSdk
    public interface IdTokenListenersCountChangedListener {
        @KeepForSdk
        void onListenerCountChanged(int i);
    }

    @TargetApi(24)
    private static class zza extends BroadcastReceiver {
        private static AtomicReference<zza> zzq = new AtomicReference();
        private final Context zzg;

        private zza(Context context) {
            this.zzg = context;
        }

        private static void zza(Context context) {
            if (zzq.get() == null) {
                BroadcastReceiver com_google_firebase_FirebaseApp_zza = new zza(context);
                if (zzq.compareAndSet(null, com_google_firebase_FirebaseApp_zza)) {
                    context.registerReceiver(com_google_firebase_FirebaseApp_zza, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public final void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.sLock) {
                for (FirebaseApp zza : FirebaseApp.zzf.values()) {
                    zza.zzc();
                }
            }
            this.zzg.unregisterReceiver(this);
        }
    }

    private FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.zzg = (Context) Preconditions.checkNotNull(context);
        this.mName = Preconditions.checkNotEmpty(str);
        this.zzh = (FirebaseOptions) Preconditions.checkNotNull(firebaseOptions);
        this.zzp = new com.google.firebase.internal.zza();
        this.zzi = new zzg(new zzc(this.zzg).zzj(), Component.of(Context.class, this.zzg), Component.of(FirebaseApp.class, this), Component.of(FirebaseOptions.class, this.zzh));
    }

    public static List<FirebaseApp> getApps(Context context) {
        List<FirebaseApp> arrayList;
        zzb.zze(context);
        synchronized (sLock) {
            arrayList = new ArrayList(zzf.values());
            zzb.zzq();
            Set<String> zzr = zzb.zzr();
            zzr.removeAll(zzf.keySet());
            for (String str : zzr) {
                zzb.zzb(str);
                arrayList.add(initializeApp(context, null, str));
            }
        }
        return arrayList;
    }

    @Nullable
    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (sLock) {
            firebaseApp = (FirebaseApp) zzf.get(DEFAULT_APP_NAME);
            if (firebaseApp != null) {
            } else {
                String myProcessName = ProcessUtils.getMyProcessName();
                StringBuilder stringBuilder = new StringBuilder(116 + String.valueOf(myProcessName).length());
                stringBuilder.append("Default FirebaseApp is not initialized in this process ");
                stringBuilder.append(myProcessName);
                stringBuilder.append(". Make sure to call FirebaseApp.initializeApp(Context) first.");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp getInstance(@NonNull String str) {
        FirebaseApp firebaseApp;
        synchronized (sLock) {
            firebaseApp = (FirebaseApp) zzf.get(str.trim());
            if (firebaseApp != null) {
            } else {
                String str2;
                Iterable zzb = zzb();
                if (zzb.isEmpty()) {
                    str2 = "";
                } else {
                    String str3 = "Available app names: ";
                    str2 = String.valueOf(TextUtils.join(", ", zzb));
                    str2 = str2.length() != 0 ? str3.concat(str2) : new String(str3);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
            }
        }
        return firebaseApp;
    }

    @Nullable
    public static FirebaseApp initializeApp(Context context) {
        synchronized (sLock) {
            if (zzf.containsKey(DEFAULT_APP_NAME)) {
                FirebaseApp instance = getInstance();
                return instance;
            }
            FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
            if (fromResource == null) {
                return null;
            }
            instance = initializeApp(context, fromResource);
            return instance;
        }
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, DEFAULT_APP_NAME);
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions, String str) {
        FirebaseApp firebaseApp;
        zzb.zze(context);
        if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
            BackgroundDetector.initialize((Application) context.getApplicationContext());
            BackgroundDetector.getInstance().addListener(new zza());
        }
        str = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (sLock) {
            boolean containsKey = zzf.containsKey(str) ^ 1;
            StringBuilder stringBuilder = new StringBuilder(33 + String.valueOf(str).length());
            stringBuilder.append("FirebaseApp name ");
            stringBuilder.append(str);
            stringBuilder.append(" already exists!");
            Preconditions.checkState(containsKey, stringBuilder.toString());
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, str, firebaseOptions);
            zzf.put(str, firebaseApp);
        }
        zzb.zzb(firebaseApp);
        firebaseApp.zzc();
        return firebaseApp;
    }

    @KeepForSdk
    public static void onBackgroundStateChanged(boolean z) {
        synchronized (sLock) {
            ArrayList arrayList = new ArrayList(zzf.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                FirebaseApp firebaseApp = (FirebaseApp) obj;
                if (firebaseApp.zzj.get()) {
                    firebaseApp.zza(z);
                }
            }
        }
    }

    private final void zza() {
        Preconditions.checkState(this.zzk.get() ^ 1, "FirebaseApp was deleted");
    }

    private static <T> void zza(java.lang.Class<T> r6, T r7, java.lang.Iterable<java.lang.String> r8, boolean r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = r8.iterator();
    L_0x0004:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x00a5;
    L_0x000a:
        r0 = r8.next();
        r0 = (java.lang.String) r0;
        if (r9 == 0) goto L_0x001f;
    L_0x0012:
        r1 = zzd;	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r1 = r1.contains(r0);	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        if (r1 == 0) goto L_0x0004;	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
    L_0x001a:
        goto L_0x001f;	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
    L_0x001b:
        r1 = move-exception;	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        goto L_0x0048;	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
    L_0x001d:
        r0 = move-exception;	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        goto L_0x0064;	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
    L_0x001f:
        r1 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r2 = "getInstance";	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r3 = 1;	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r4 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r5 = 0;	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r4[r5] = r6;	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r1 = r1.getMethod(r2, r4);	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r2 = r1.getModifiers();	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r4 = java.lang.reflect.Modifier.isPublic(r2);	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        if (r4 == 0) goto L_0x0004;	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
    L_0x0039:
        r2 = java.lang.reflect.Modifier.isStatic(r2);	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        if (r2 == 0) goto L_0x0004;	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
    L_0x003f:
        r2 = 0;	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r3 = new java.lang.Object[r3];	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r3[r5] = r7;	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        r1.invoke(r2, r3);	 Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x006c, InvocationTargetException -> 0x001d, IllegalAccessException -> 0x001b }
        goto L_0x0004;
    L_0x0048:
        r2 = "FirebaseApp";
        r3 = "Failed to initialize ";
        r0 = java.lang.String.valueOf(r0);
        r4 = r0.length();
        if (r4 == 0) goto L_0x005b;
    L_0x0056:
        r0 = r3.concat(r0);
        goto L_0x0060;
    L_0x005b:
        r0 = new java.lang.String;
        r0.<init>(r3);
    L_0x0060:
        android.util.Log.wtf(r2, r0, r1);
        goto L_0x0004;
    L_0x0064:
        r1 = "FirebaseApp";
        r2 = "Firebase API initialization failure.";
        android.util.Log.wtf(r1, r2, r0);
        goto L_0x0004;
    L_0x006c:
        r6 = new java.lang.IllegalStateException;
        r7 = java.lang.String.valueOf(r0);
        r8 = "#getInstance has been removed by Proguard. Add keep rule to prevent it.";
        r7 = r7.concat(r8);
        r6.<init>(r7);
        throw r6;
    L_0x007c:
        r1 = zze;
        r1 = r1.contains(r0);
        if (r1 != 0) goto L_0x0095;
    L_0x0084:
        r1 = "FirebaseApp";
        r0 = java.lang.String.valueOf(r0);
        r2 = " is not linked. Skipping initialization.";
        r0 = r0.concat(r2);
        android.util.Log.d(r1, r0);
        goto L_0x0004;
    L_0x0095:
        r6 = new java.lang.IllegalStateException;
        r7 = java.lang.String.valueOf(r0);
        r8 = " is missing, but is required. Check if it has been removed by Proguard.";
        r7 = r7.concat(r8);
        r6.<init>(r7);
        throw r6;
    L_0x00a5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.FirebaseApp.zza(java.lang.Class, java.lang.Object, java.lang.Iterable, boolean):void");
    }

    private final void zza(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (BackgroundStateChangeListener onBackgroundStateChanged : this.zzm) {
            onBackgroundStateChanged.onBackgroundStateChanged(z);
        }
    }

    private static List<String> zzb() {
        Collection arraySet = new ArraySet();
        synchronized (sLock) {
            for (FirebaseApp name : zzf.values()) {
                arraySet.add(name.getName());
            }
            if (zzb.zzq() != null) {
                arraySet.addAll(zzb.zzr());
            }
        }
        List<String> arrayList = new ArrayList(arraySet);
        Collections.sort(arrayList);
        return arrayList;
    }

    private final void zzc() {
        boolean isDeviceProtectedStorage = ContextCompat.isDeviceProtectedStorage(this.zzg);
        if (isDeviceProtectedStorage) {
            zza.zza(this.zzg);
        } else {
            this.zzi.zzb(isDefaultApp());
        }
        zza(FirebaseApp.class, this, zza, isDeviceProtectedStorage);
        if (isDefaultApp()) {
            zza(FirebaseApp.class, this, zzb, isDeviceProtectedStorage);
            zza(Context.class, this.zzg, zzc, isDeviceProtectedStorage);
        }
    }

    @KeepForSdk
    public void addBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        zza();
        if (this.zzj.get() && BackgroundDetector.getInstance().isInBackground()) {
            backgroundStateChangeListener.onBackgroundStateChanged(true);
        }
        this.zzm.add(backgroundStateChangeListener);
    }

    @KeepForSdk
    public void addIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        zza();
        Preconditions.checkNotNull(idTokenListener);
        this.zzl.add(idTokenListener);
        this.zzp.onListenerCountChanged(this.zzl.size());
    }

    public boolean equals(Object obj) {
        return !(obj instanceof FirebaseApp) ? false : this.mName.equals(((FirebaseApp) obj).getName());
    }

    @KeepForSdk
    public <T> T get(Class<T> cls) {
        zza();
        return this.zzi.get(cls);
    }

    @NonNull
    public Context getApplicationContext() {
        zza();
        return this.zzg;
    }

    @NonNull
    public String getName() {
        zza();
        return this.mName;
    }

    @NonNull
    public FirebaseOptions getOptions() {
        zza();
        return this.zzh;
    }

    @KeepForSdk
    public String getPersistenceKey() {
        String encodeUrlSafeNoPadding = Base64Utils.encodeUrlSafeNoPadding(getName().getBytes());
        String encodeUrlSafeNoPadding2 = Base64Utils.encodeUrlSafeNoPadding(getOptions().getApplicationId().getBytes());
        StringBuilder stringBuilder = new StringBuilder((1 + String.valueOf(encodeUrlSafeNoPadding).length()) + String.valueOf(encodeUrlSafeNoPadding2).length());
        stringBuilder.append(encodeUrlSafeNoPadding);
        stringBuilder.append("+");
        stringBuilder.append(encodeUrlSafeNoPadding2);
        return stringBuilder.toString();
    }

    @KeepForSdk
    public Task<GetTokenResult> getToken(boolean z) {
        zza();
        return this.zzo == null ? Tasks.forException(new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode.")) : this.zzo.getAccessToken(z);
    }

    @Nullable
    public final String getUid() throws FirebaseApiNotAvailableException {
        zza();
        if (this.zzo != null) {
            return this.zzo.getUid();
        }
        throw new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode.");
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    @KeepForSdk
    @VisibleForTesting
    public boolean isDefaultApp() {
        return DEFAULT_APP_NAME.equals(getName());
    }

    @UiThread
    @KeepForSdk
    public void notifyIdTokenListeners(@NonNull InternalTokenResult internalTokenResult) {
        Log.d("FirebaseApp", "Notifying auth state listeners.");
        int i = 0;
        for (IdTokenListener onIdTokenChanged : this.zzl) {
            onIdTokenChanged.onIdTokenChanged(internalTokenResult);
            i++;
        }
        Log.d("FirebaseApp", String.format("Notified %d auth state listeners.", new Object[]{Integer.valueOf(i)}));
    }

    @KeepForSdk
    public void removeBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        zza();
        this.zzm.remove(backgroundStateChangeListener);
    }

    public void setAutomaticResourceManagementEnabled(boolean z) {
        zza();
        if (this.zzj.compareAndSet(z ^ 1, z)) {
            boolean isInBackground = BackgroundDetector.getInstance().isInBackground();
            if (z && isInBackground) {
                zza(true);
            } else if (!z && isInBackground) {
                zza(false);
            }
        }
    }

    @KeepForSdk
    public void setIdTokenListenersCountChangedListener(@NonNull IdTokenListenersCountChangedListener idTokenListenersCountChangedListener) {
        this.zzp = (IdTokenListenersCountChangedListener) Preconditions.checkNotNull(idTokenListenersCountChangedListener);
        this.zzp.onListenerCountChanged(this.zzl.size());
    }

    @KeepForSdk
    public void setTokenProvider(@NonNull InternalTokenProvider internalTokenProvider) {
        this.zzo = (InternalTokenProvider) Preconditions.checkNotNull(internalTokenProvider);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.mName).add("options", this.zzh).toString();
    }

    public final void zza(@NonNull IdTokenListener idTokenListener) {
        zza();
        Preconditions.checkNotNull(idTokenListener);
        this.zzl.remove(idTokenListener);
        this.zzp.onListenerCountChanged(this.zzl.size());
    }
}
