package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.events.EventsStorageListener;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.util.concurrent.ScheduledExecutorService;

class AnswersEventsHandler implements EventsStorageListener {
    private final Context context;
    final ScheduledExecutorService executor;
    private final AnswersFilesManagerProvider filesManagerProvider;
    private final FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter;
    private final Kit kit;
    private final SessionMetadataCollector metadataCollector;
    private final HttpRequestFactory requestFactory;
    SessionAnalyticsManagerStrategy strategy = new DisabledSessionAnalyticsManagerStrategy();

    class C03652 implements Runnable {
        C03652() {
        }

        public void run() {
            try {
                SessionAnalyticsManagerStrategy sessionAnalyticsManagerStrategy = AnswersEventsHandler.this.strategy;
                AnswersEventsHandler.this.strategy = new DisabledSessionAnalyticsManagerStrategy();
                sessionAnalyticsManagerStrategy.deleteAllEvents();
            } catch (Throwable e) {
                Fabric.getLogger().mo2304e(Answers.TAG, "Failed to disable events", e);
            }
        }
    }

    class C03663 implements Runnable {
        C03663() {
        }

        public void run() {
            try {
                AnswersEventsHandler.this.strategy.sendEvents();
            } catch (Throwable e) {
                Fabric.getLogger().mo2304e(Answers.TAG, "Failed to send events files", e);
            }
        }
    }

    class C03674 implements Runnable {
        C03674() {
        }

        public void run() {
            try {
                SessionEventMetadata metadata = AnswersEventsHandler.this.metadataCollector.getMetadata();
                SessionAnalyticsFilesManager analyticsFilesManager = AnswersEventsHandler.this.filesManagerProvider.getAnalyticsFilesManager();
                analyticsFilesManager.registerRollOverListener(AnswersEventsHandler.this);
                AnswersEventsHandler.this.strategy = new EnabledSessionAnalyticsManagerStrategy(AnswersEventsHandler.this.kit, AnswersEventsHandler.this.context, AnswersEventsHandler.this.executor, analyticsFilesManager, AnswersEventsHandler.this.requestFactory, metadata, AnswersEventsHandler.this.firebaseAnalyticsApiAdapter);
            } catch (Throwable e) {
                Fabric.getLogger().mo2304e(Answers.TAG, "Failed to enable events", e);
            }
        }
    }

    class C03685 implements Runnable {
        C03685() {
        }

        public void run() {
            try {
                AnswersEventsHandler.this.strategy.rollFileOver();
            } catch (Throwable e) {
                Fabric.getLogger().mo2304e(Answers.TAG, "Failed to flush events", e);
            }
        }
    }

    public AnswersEventsHandler(Kit kit, Context context, AnswersFilesManagerProvider answersFilesManagerProvider, SessionMetadataCollector sessionMetadataCollector, HttpRequestFactory httpRequestFactory, ScheduledExecutorService scheduledExecutorService, FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter) {
        this.kit = kit;
        this.context = context;
        this.filesManagerProvider = answersFilesManagerProvider;
        this.metadataCollector = sessionMetadataCollector;
        this.requestFactory = httpRequestFactory;
        this.executor = scheduledExecutorService;
        this.firebaseAnalyticsApiAdapter = firebaseAnalyticsApiAdapter;
    }

    public void processEventAsync(Builder builder) {
        processEvent(builder, false, false);
    }

    public void processEventAsyncAndFlush(Builder builder) {
        processEvent(builder, false, true);
    }

    public void processEventSync(Builder builder) {
        processEvent(builder, true, false);
    }

    public void setAnalyticsSettingsData(final AnalyticsSettingsData analyticsSettingsData, final String str) {
        executeAsync(new Runnable() {
            public void run() {
                try {
                    AnswersEventsHandler.this.strategy.setAnalyticsSettingsData(analyticsSettingsData, str);
                } catch (Throwable e) {
                    Fabric.getLogger().mo2304e(Answers.TAG, "Failed to set analytics settings data", e);
                }
            }
        });
    }

    public void disable() {
        executeAsync(new C03652());
    }

    public void onRollOver(String str) {
        executeAsync(new C03663());
    }

    public void enable() {
        executeAsync(new C03674());
    }

    public void flushEvents() {
        executeAsync(new C03685());
    }

    void processEvent(final Builder builder, boolean z, final boolean z2) {
        Runnable c03696 = new Runnable() {
            public void run() {
                try {
                    AnswersEventsHandler.this.strategy.processEvent(builder);
                    if (z2) {
                        AnswersEventsHandler.this.strategy.rollFileOver();
                    }
                } catch (Throwable e) {
                    Fabric.getLogger().mo2304e(Answers.TAG, "Failed to process event", e);
                }
            }
        };
        if (z) {
            executeSync(c03696);
        } else {
            executeAsync(c03696);
        }
    }

    private void executeSync(Runnable runnable) {
        try {
            this.executor.submit(runnable).get();
        } catch (Runnable runnable2) {
            Fabric.getLogger().mo2304e(Answers.TAG, "Failed to run events task", runnable2);
        }
    }

    private void executeAsync(Runnable runnable) {
        try {
            this.executor.submit(runnable);
        } catch (Runnable runnable2) {
            Fabric.getLogger().mo2304e(Answers.TAG, "Failed to submit events task", runnable2);
        }
    }
}
