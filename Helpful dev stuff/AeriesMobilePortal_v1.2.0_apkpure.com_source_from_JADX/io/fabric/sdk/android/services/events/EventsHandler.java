package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.util.concurrent.ScheduledExecutorService;

public abstract class EventsHandler<T> implements EventsStorageListener {
    protected final Context context;
    protected final ScheduledExecutorService executor;
    protected EventsStrategy<T> strategy;

    class C05123 implements Runnable {
        C05123() {
        }

        public void run() {
            try {
                EventsHandler.this.strategy.sendEvents();
            } catch (Throwable e) {
                CommonUtils.logControlledError(EventsHandler.this.context, "Failed to send events files.", e);
            }
        }
    }

    class C05134 implements Runnable {
        C05134() {
        }

        public void run() {
            try {
                EventsStrategy eventsStrategy = EventsHandler.this.strategy;
                EventsHandler.this.strategy = EventsHandler.this.getDisabledEventsStrategy();
                eventsStrategy.deleteAllEvents();
            } catch (Throwable e) {
                CommonUtils.logControlledError(EventsHandler.this.context, "Failed to disable events.", e);
            }
        }
    }

    protected abstract EventsStrategy<T> getDisabledEventsStrategy();

    public EventsHandler(Context context, EventsStrategy<T> eventsStrategy, EventsFilesManager eventsFilesManager, ScheduledExecutorService scheduledExecutorService) {
        this.context = context.getApplicationContext();
        this.executor = scheduledExecutorService;
        this.strategy = eventsStrategy;
        eventsFilesManager.registerRollOverListener(this);
    }

    public void recordEventAsync(final T t, final boolean z) {
        executeAsync(new Runnable() {
            public void run() {
                try {
                    EventsHandler.this.strategy.recordEvent(t);
                    if (z) {
                        EventsHandler.this.strategy.rollFileOver();
                    }
                } catch (Throwable e) {
                    CommonUtils.logControlledError(EventsHandler.this.context, "Failed to record event.", e);
                }
            }
        });
    }

    public void recordEventSync(final T t) {
        executeSync(new Runnable() {
            public void run() {
                try {
                    EventsHandler.this.strategy.recordEvent(t);
                } catch (Throwable e) {
                    CommonUtils.logControlledError(EventsHandler.this.context, "Crashlytics failed to record event", e);
                }
            }
        });
    }

    public void onRollOver(String str) {
        executeAsync(new C05123());
    }

    public void disable() {
        executeAsync(new C05134());
    }

    protected void executeSync(Runnable runnable) {
        try {
            this.executor.submit(runnable).get();
        } catch (Runnable runnable2) {
            CommonUtils.logControlledError(this.context, "Failed to run events task", runnable2);
        }
    }

    protected void executeAsync(Runnable runnable) {
        try {
            this.executor.submit(runnable);
        } catch (Runnable runnable2) {
            CommonUtils.logControlledError(this.context, "Failed to submit events task", runnable2);
        }
    }
}
