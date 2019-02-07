package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleScheduler extends Scheduler {
    private static final String KEY_SINGLE_PRIORITY = "rx2.single-priority";
    static final ScheduledExecutorService SHUTDOWN = Executors.newScheduledThreadPool(0);
    static final RxThreadFactory SINGLE_THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX, Math.max(1, Math.min(10, Integer.getInteger(KEY_SINGLE_PRIORITY, 5).intValue())), true);
    private static final String THREAD_NAME_PREFIX = "RxSingleScheduler";
    final AtomicReference<ScheduledExecutorService> executor;
    final ThreadFactory threadFactory;

    static final class ScheduledWorker extends Worker {
        volatile boolean disposed;
        final ScheduledExecutorService executor;
        final CompositeDisposable tasks = new CompositeDisposable();

        ScheduledWorker(ScheduledExecutorService scheduledExecutorService) {
            this.executor = scheduledExecutorService;
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            Disposable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.onSchedule(runnable), this.tasks);
            this.tasks.add(scheduledRunnable);
            if (j <= 0) {
                try {
                    runnable = this.executor.submit(scheduledRunnable);
                } catch (Runnable runnable2) {
                    dispose();
                    RxJavaPlugins.onError(runnable2);
                    return EmptyDisposable.INSTANCE;
                }
            }
            runnable2 = this.executor.schedule(scheduledRunnable, j, timeUnit);
            scheduledRunnable.setFuture(runnable2);
            return scheduledRunnable;
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.tasks.dispose();
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    static {
        SHUTDOWN.shutdown();
    }

    public SingleScheduler() {
        this(SINGLE_THREAD_FACTORY);
    }

    public SingleScheduler(ThreadFactory threadFactory) {
        this.executor = new AtomicReference();
        this.threadFactory = threadFactory;
        this.executor.lazySet(createExecutor(threadFactory));
    }

    static ScheduledExecutorService createExecutor(ThreadFactory threadFactory) {
        return SchedulerPoolFactory.create(threadFactory);
    }

    public void start() {
        ScheduledExecutorService scheduledExecutorService = null;
        ScheduledExecutorService scheduledExecutorService2;
        do {
            scheduledExecutorService2 = (ScheduledExecutorService) this.executor.get();
            if (scheduledExecutorService2 != SHUTDOWN) {
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdown();
                }
                return;
            } else if (scheduledExecutorService == null) {
                scheduledExecutorService = createExecutor(this.threadFactory);
            }
        } while (!this.executor.compareAndSet(scheduledExecutorService2, scheduledExecutorService));
    }

    public void shutdown() {
        if (((ScheduledExecutorService) this.executor.get()) != SHUTDOWN) {
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.executor.getAndSet(SHUTDOWN);
            if (scheduledExecutorService != SHUTDOWN) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    @NonNull
    public Worker createWorker() {
        return new ScheduledWorker((ScheduledExecutorService) this.executor.get());
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        Disposable scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.onSchedule(runnable));
        if (j <= 0) {
            try {
                runnable = ((ScheduledExecutorService) this.executor.get()).submit(scheduledDirectTask);
            } catch (Runnable runnable2) {
                RxJavaPlugins.onError(runnable2);
                return EmptyDisposable.INSTANCE;
            }
        }
        runnable2 = ((ScheduledExecutorService) this.executor.get()).schedule(scheduledDirectTask, j, timeUnit);
        scheduledDirectTask.setFuture(runnable2);
        return scheduledDirectTask;
    }

    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        runnable = RxJavaPlugins.onSchedule(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.executor.get();
            Disposable instantPeriodicTask = new InstantPeriodicTask(runnable, scheduledExecutorService);
            if (j <= 0) {
                try {
                    runnable = scheduledExecutorService.submit(instantPeriodicTask);
                } catch (Runnable runnable2) {
                    RxJavaPlugins.onError(runnable2);
                    return EmptyDisposable.INSTANCE;
                }
            }
            runnable2 = scheduledExecutorService.schedule(instantPeriodicTask, j, timeUnit);
            instantPeriodicTask.setFirst(runnable2);
            return instantPeriodicTask;
        }
        Disposable scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnable2);
        try {
            scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.executor.get()).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (Runnable runnable22) {
            RxJavaPlugins.onError(runnable22);
            return EmptyDisposable.INSTANCE;
        }
    }
}
