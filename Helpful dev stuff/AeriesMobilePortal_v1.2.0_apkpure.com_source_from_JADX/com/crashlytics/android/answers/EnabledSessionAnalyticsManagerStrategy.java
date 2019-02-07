package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.events.FilesSender;
import io.fabric.sdk.android.services.events.TimeBasedFileRollOverRunnable;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class EnabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
    static final int UNDEFINED_ROLLOVER_INTERVAL_SECONDS = -1;
    ApiKey apiKey = new ApiKey();
    private final Context context;
    boolean customEventsEnabled = true;
    EventFilter eventFilter = new KeepAllEventFilter();
    private final ScheduledExecutorService executorService;
    private final SessionAnalyticsFilesManager filesManager;
    FilesSender filesSender;
    private final FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter;
    boolean forwardToFirebaseAnalyticsEnabled = false;
    private final HttpRequestFactory httpRequestFactory;
    boolean includePurchaseEventsInForwardedEvents = false;
    private final Kit kit;
    final SessionEventMetadata metadata;
    boolean predefinedEventsEnabled = true;
    private final AtomicReference<ScheduledFuture<?>> rolloverFutureRef = new AtomicReference();
    volatile int rolloverIntervalSeconds = -1;

    public EnabledSessionAnalyticsManagerStrategy(Kit kit, Context context, ScheduledExecutorService scheduledExecutorService, SessionAnalyticsFilesManager sessionAnalyticsFilesManager, HttpRequestFactory httpRequestFactory, SessionEventMetadata sessionEventMetadata, FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter) {
        this.kit = kit;
        this.context = context;
        this.executorService = scheduledExecutorService;
        this.filesManager = sessionAnalyticsFilesManager;
        this.httpRequestFactory = httpRequestFactory;
        this.metadata = sessionEventMetadata;
        this.firebaseAnalyticsApiAdapter = firebaseAnalyticsApiAdapter;
    }

    public void setAnalyticsSettingsData(AnalyticsSettingsData analyticsSettingsData, String str) {
        this.filesSender = AnswersRetryFilesSender.build(new SessionAnalyticsFilesSender(this.kit, str, analyticsSettingsData.analyticsURL, this.httpRequestFactory, this.apiKey.getValue(this.context)));
        this.filesManager.setAnalyticsSettingsData(analyticsSettingsData);
        this.forwardToFirebaseAnalyticsEnabled = analyticsSettingsData.forwardToFirebaseAnalytics;
        this.includePurchaseEventsInForwardedEvents = analyticsSettingsData.includePurchaseEventsInForwardedEvents;
        str = Fabric.getLogger();
        String str2 = Answers.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Firebase analytics forwarding ");
        stringBuilder.append(this.forwardToFirebaseAnalyticsEnabled ? "enabled" : "disabled");
        str.mo2301d(str2, stringBuilder.toString());
        str = Fabric.getLogger();
        str2 = Answers.TAG;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Firebase analytics including purchase events ");
        stringBuilder.append(this.includePurchaseEventsInForwardedEvents ? "enabled" : "disabled");
        str.mo2301d(str2, stringBuilder.toString());
        this.customEventsEnabled = analyticsSettingsData.trackCustomEvents;
        str = Fabric.getLogger();
        str2 = Answers.TAG;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Custom event tracking ");
        stringBuilder.append(this.customEventsEnabled ? "enabled" : "disabled");
        str.mo2301d(str2, stringBuilder.toString());
        this.predefinedEventsEnabled = analyticsSettingsData.trackPredefinedEvents;
        str = Fabric.getLogger();
        str2 = Answers.TAG;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Predefined event tracking ");
        stringBuilder.append(this.predefinedEventsEnabled ? "enabled" : "disabled");
        str.mo2301d(str2, stringBuilder.toString());
        if (analyticsSettingsData.samplingRate > 1) {
            Fabric.getLogger().mo2301d(Answers.TAG, "Event sampling enabled");
            this.eventFilter = new SamplingEventFilter(analyticsSettingsData.samplingRate);
        }
        this.rolloverIntervalSeconds = analyticsSettingsData.flushIntervalSeconds;
        scheduleTimeBasedFileRollOver(null, (long) this.rolloverIntervalSeconds);
    }

    public void processEvent(Builder builder) {
        Logger logger;
        String str;
        StringBuilder stringBuilder;
        builder = builder.build(this.metadata);
        Logger logger2;
        String str2;
        StringBuilder stringBuilder2;
        if (!this.customEventsEnabled && Type.CUSTOM.equals(builder.type)) {
            logger2 = Fabric.getLogger();
            str2 = Answers.TAG;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Custom events tracking disabled - skipping event: ");
            stringBuilder2.append(builder);
            logger2.mo2301d(str2, stringBuilder2.toString());
        } else if (!this.predefinedEventsEnabled && Type.PREDEFINED.equals(builder.type)) {
            logger2 = Fabric.getLogger();
            str2 = Answers.TAG;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Predefined events tracking disabled - skipping event: ");
            stringBuilder2.append(builder);
            logger2.mo2301d(str2, stringBuilder2.toString());
        } else if (this.eventFilter.skipEvent(builder)) {
            logger2 = Fabric.getLogger();
            str2 = Answers.TAG;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Skipping filtered event: ");
            stringBuilder2.append(builder);
            logger2.mo2301d(str2, stringBuilder2.toString());
        } else {
            Object obj;
            boolean equals;
            try {
                this.filesManager.writeEvent(builder);
            } catch (Throwable e) {
                logger = Fabric.getLogger();
                str = Answers.TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to write event: ");
                stringBuilder.append(builder);
                logger.mo2304e(str, stringBuilder.toString(), e);
            }
            scheduleTimeBasedRollOverIfNeeded();
            if (!Type.CUSTOM.equals(builder.type)) {
                if (!Type.PREDEFINED.equals(builder.type)) {
                    obj = null;
                    equals = "purchase".equals(builder.predefinedType);
                    if (this.forwardToFirebaseAnalyticsEnabled) {
                        if (obj == null) {
                            if (equals || this.includePurchaseEventsInForwardedEvents) {
                                try {
                                    this.firebaseAnalyticsApiAdapter.processEvent(builder);
                                } catch (Throwable e2) {
                                    logger = Fabric.getLogger();
                                    str = Answers.TAG;
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Failed to map event to Firebase: ");
                                    stringBuilder.append(builder);
                                    logger.mo2304e(str, stringBuilder.toString(), e2);
                                }
                            }
                            return;
                        }
                    }
                }
            }
            obj = 1;
            equals = "purchase".equals(builder.predefinedType);
            if (this.forwardToFirebaseAnalyticsEnabled) {
                if (obj == null) {
                    if (equals) {
                    }
                    this.firebaseAnalyticsApiAdapter.processEvent(builder);
                }
            }
        }
    }

    public void scheduleTimeBasedRollOverIfNeeded() {
        if ((this.rolloverIntervalSeconds != -1 ? 1 : null) != null) {
            scheduleTimeBasedFileRollOver((long) this.rolloverIntervalSeconds, (long) this.rolloverIntervalSeconds);
        }
    }

    public void sendEvents() {
        if (this.filesSender == null) {
            CommonUtils.logControlled(this.context, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        CommonUtils.logControlled(this.context, "Sending all files");
        List batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
        int i = 0;
        while (batchOfFilesToSend.size() > 0) {
            try {
                CommonUtils.logControlled(this.context, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(batchOfFilesToSend.size())}));
                boolean send = this.filesSender.send(batchOfFilesToSend);
                if (send) {
                    i += batchOfFilesToSend.size();
                    this.filesManager.deleteSentFiles(batchOfFilesToSend);
                }
                if (!send) {
                    break;
                }
                batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
            } catch (Throwable e) {
                Context context = this.context;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to send batch of analytics files to server: ");
                stringBuilder.append(e.getMessage());
                CommonUtils.logControlledError(context, stringBuilder.toString(), e);
            }
        }
        if (i == 0) {
            this.filesManager.deleteOldestInRollOverIfOverMax();
        }
    }

    public void cancelTimeBasedFileRollOver() {
        if (this.rolloverFutureRef.get() != null) {
            CommonUtils.logControlled(this.context, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.rolloverFutureRef.get()).cancel(false);
            this.rolloverFutureRef.set(null);
        }
    }

    public void deleteAllEvents() {
        this.filesManager.deleteAllEventsFiles();
    }

    public boolean rollFileOver() {
        try {
            return this.filesManager.rollFileOver();
        } catch (Throwable e) {
            CommonUtils.logControlledError(this.context, "Failed to roll file over.", e);
            return false;
        }
    }

    void scheduleTimeBasedFileRollOver(long j, long j2) {
        if ((this.rolloverFutureRef.get() == null ? 1 : null) != null) {
            Runnable timeBasedFileRollOverRunnable = new TimeBasedFileRollOverRunnable(this.context, this);
            Context context = this.context;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scheduling time based file roll over every ");
            stringBuilder.append(j2);
            stringBuilder.append(" seconds");
            CommonUtils.logControlled(context, stringBuilder.toString());
            try {
                this.rolloverFutureRef.set(this.executorService.scheduleAtFixedRate(timeBasedFileRollOverRunnable, j, j2, TimeUnit.SECONDS));
            } catch (long j3) {
                CommonUtils.logControlledError(this.context, "Failed to schedule time based file roll over", j3);
            }
        }
    }
}
