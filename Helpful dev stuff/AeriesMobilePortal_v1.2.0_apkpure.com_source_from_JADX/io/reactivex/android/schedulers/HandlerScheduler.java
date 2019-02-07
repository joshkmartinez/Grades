package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

final class HandlerScheduler extends Scheduler {
    private final Handler handler;

    private static final class ScheduledRunnable implements Runnable, Disposable {
        private final Runnable delegate;
        private volatile boolean disposed;
        private final Handler handler;

        ScheduledRunnable(Handler handler, Runnable runnable) {
            this.handler = handler;
            this.delegate = runnable;
        }

        public void run() {
            try {
                this.delegate.run();
            } catch (Throwable th) {
                Throwable illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.", th);
                RxJavaPlugins.onError(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }

        public void dispose() {
            this.disposed = true;
            this.handler.removeCallbacks(this);
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    private static final class HandlerWorker extends Worker {
        private volatile boolean disposed;
        private final Handler handler;

        HandlerWorker(Handler handler) {
            this.handler = handler;
        }

        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.disposed) {
                return Disposables.disposed();
            } else {
                Object scheduledRunnable = new ScheduledRunnable(this.handler, RxJavaPlugins.onSchedule(runnable));
                runnable = Message.obtain(this.handler, scheduledRunnable);
                runnable.obj = this;
                this.handler.sendMessageDelayed(runnable, Math.max(0, timeUnit.toMillis(j)));
                if (this.disposed == null) {
                    return scheduledRunnable;
                }
                this.handler.removeCallbacks(scheduledRunnable);
                return Disposables.disposed();
            }
        }

        public void dispose() {
            this.disposed = true;
            this.handler.removeCallbacksAndMessages(this);
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    HandlerScheduler(Handler handler) {
        this.handler = handler;
    }

    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit != null) {
            Object scheduledRunnable = new ScheduledRunnable(this.handler, RxJavaPlugins.onSchedule(runnable));
            this.handler.postDelayed(scheduledRunnable, Math.max(0, timeUnit.toMillis(j)));
            return scheduledRunnable;
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public Worker createWorker() {
        return new HandlerWorker(this.handler);
    }
}
