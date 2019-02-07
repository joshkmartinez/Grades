package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler.Worker;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class NewThreadWorker extends Worker implements Disposable {
    volatile boolean disposed;
    private final ScheduledExecutorService executor;

    public NewThreadWorker(ThreadFactory threadFactory) {
        this.executor = SchedulerPoolFactory.create(threadFactory);
    }

    @NonNull
    public Disposable schedule(@NonNull Runnable runnable) {
        return schedule(runnable, 0, null);
    }

    @NonNull
    public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
        if (this.disposed) {
            return EmptyDisposable.INSTANCE;
        }
        return scheduleActual(runnable, j, timeUnit, null);
    }

    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Disposable scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.onSchedule(runnable));
        if (j <= 0) {
            try {
                runnable = this.executor.submit(scheduledDirectTask);
            } catch (Runnable runnable2) {
                RxJavaPlugins.onError(runnable2);
                return EmptyDisposable.INSTANCE;
            }
        }
        runnable2 = this.executor.schedule(scheduledDirectTask, j, timeUnit);
        scheduledDirectTask.setFuture(runnable2);
        return scheduledDirectTask;
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        runnable = RxJavaPlugins.onSchedule(runnable);
        if (j2 <= 0) {
            j2 = new InstantPeriodicTask(runnable, this.executor);
            if (j <= 0) {
                try {
                    runnable = this.executor.submit(j2);
                } catch (Runnable runnable2) {
                    RxJavaPlugins.onError(runnable2);
                    return EmptyDisposable.INSTANCE;
                }
            }
            runnable2 = this.executor.schedule(j2, j, timeUnit);
            j2.setFirst(runnable2);
            return j2;
        }
        Disposable scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnable2);
        try {
            scheduledDirectPeriodicTask.setFuture(this.executor.scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (Runnable runnable22) {
            RxJavaPlugins.onError(runnable22);
            return EmptyDisposable.INSTANCE;
        }
    }

    @NonNull
    public ScheduledRunnable scheduleActual(Runnable runnable, long j, @NonNull TimeUnit timeUnit, @Nullable DisposableContainer disposableContainer) {
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.onSchedule(runnable), disposableContainer);
        if (disposableContainer != null && disposableContainer.add(scheduledRunnable) == null) {
            return scheduledRunnable;
        }
        if (j <= 0) {
            try {
                runnable = this.executor.submit(scheduledRunnable);
            } catch (Runnable runnable2) {
                if (disposableContainer != null) {
                    disposableContainer.remove(scheduledRunnable);
                }
                RxJavaPlugins.onError(runnable2);
            }
        } else {
            runnable2 = this.executor.schedule(scheduledRunnable, j, timeUnit);
        }
        scheduledRunnable.setFuture(runnable2);
        return scheduledRunnable;
    }

    public void dispose() {
        if (!this.disposed) {
            this.disposed = true;
            this.executor.shutdownNow();
        }
    }

    public void shutdown() {
        if (!this.disposed) {
            this.disposed = true;
            this.executor.shutdown();
        }
    }

    public boolean isDisposed() {
        return this.disposed;
    }
}
