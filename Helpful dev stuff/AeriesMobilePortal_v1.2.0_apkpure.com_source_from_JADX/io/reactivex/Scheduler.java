package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.TimeUnit;

public abstract class Scheduler {
    static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    static final class DisposeTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        final Runnable decoratedRun;
        Thread runner;
        final Worker f45w;

        DisposeTask(Runnable runnable, Worker worker) {
            this.decoratedRun = runnable;
            this.f45w = worker;
        }

        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.decoratedRun.run();
            } finally {
                dispose();
                this.runner = null;
            }
        }

        public void dispose() {
            if (this.runner == Thread.currentThread() && (this.f45w instanceof NewThreadWorker)) {
                ((NewThreadWorker) this.f45w).shutdown();
            } else {
                this.f45w.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f45w.isDisposed();
        }

        public Runnable getWrappedRunnable() {
            return this.decoratedRun;
        }
    }

    static class PeriodicDirectTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        @NonNull
        volatile boolean disposed;
        final Runnable run;
        @NonNull
        final Worker worker;

        PeriodicDirectTask(@NonNull Runnable runnable, @NonNull Worker worker) {
            this.run = runnable;
            this.worker = worker;
        }

        public void run() {
            if (!this.disposed) {
                try {
                    this.run.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.worker.dispose();
                    RuntimeException wrapOrThrow = ExceptionHelper.wrapOrThrow(th);
                }
            }
        }

        public void dispose() {
            this.disposed = true;
            this.worker.dispose();
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public Runnable getWrappedRunnable() {
            return this.run;
        }
    }

    public static abstract class Worker implements Disposable {

        final class PeriodicTask implements Runnable, SchedulerRunnableIntrospection {
            long count;
            @NonNull
            final Runnable decoratedRun;
            long lastNowNanoseconds;
            final long periodInNanoseconds;
            @NonNull
            final SequentialDisposable sd;
            long startInNanoseconds;

            PeriodicTask(long j, @NonNull Runnable runnable, long j2, @NonNull SequentialDisposable sequentialDisposable, long j3) {
                this.decoratedRun = runnable;
                this.sd = sequentialDisposable;
                this.periodInNanoseconds = j3;
                this.lastNowNanoseconds = j2;
                this.startInNanoseconds = j;
            }

            public void run() {
                this.decoratedRun.run();
                if (!this.sd.isDisposed()) {
                    long j;
                    long j2;
                    long now = Worker.this.now(TimeUnit.NANOSECONDS);
                    if (now + Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS >= this.lastNowNanoseconds) {
                        if (now < (this.lastNowNanoseconds + this.periodInNanoseconds) + Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS) {
                            j = this.startInNanoseconds;
                            long j3 = this.count + 1;
                            this.count = j3;
                            j2 = j + (j3 * this.periodInNanoseconds);
                            this.lastNowNanoseconds = now;
                            this.sd.replace(Worker.this.schedule(this, j2 - now, TimeUnit.NANOSECONDS));
                        }
                    }
                    long j4 = now + this.periodInNanoseconds;
                    j = this.periodInNanoseconds;
                    long j5 = this.count + 1;
                    this.count = j5;
                    this.startInNanoseconds = j4 - (j * j5);
                    j2 = j4;
                    this.lastNowNanoseconds = now;
                    this.sd.replace(Worker.this.schedule(this, j2 - now, TimeUnit.NANOSECONDS));
                }
            }

            public Runnable getWrappedRunnable() {
                return this.decoratedRun;
            }
        }

        @NonNull
        public abstract Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit);

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            return schedule(runnable, 0, TimeUnit.NANOSECONDS);
        }

        @NonNull
        public Disposable schedulePeriodically(@NonNull Runnable runnable, long j, long j2, @NonNull TimeUnit timeUnit) {
            long j3 = j;
            TimeUnit timeUnit2 = timeUnit;
            Disposable sequentialDisposable = new SequentialDisposable();
            Disposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            long toNanos = timeUnit2.toNanos(j2);
            long now = now(TimeUnit.NANOSECONDS);
            Disposable disposable = sequentialDisposable;
            PeriodicTask periodicTask = r0;
            PeriodicTask periodicTask2 = new PeriodicTask(now + timeUnit2.toNanos(j3), onSchedule, now, sequentialDisposable2, toNanos);
            Disposable schedule = schedule(periodicTask, j3, timeUnit2);
            if (schedule == EmptyDisposable.INSTANCE) {
                return schedule;
            }
            disposable.replace(schedule);
            return sequentialDisposable2;
        }

        public long now(@NonNull TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    @NonNull
    public abstract Worker createWorker();

    public void shutdown() {
    }

    public void start() {
    }

    public static long clockDriftTolerance() {
        return CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
    }

    public long now(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        return scheduleDirect(runnable, 0, TimeUnit.NANOSECONDS);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        Object disposeTask = new DisposeTask(RxJavaPlugins.onSchedule(runnable), createWorker);
        createWorker.schedule(disposeTask, j, timeUnit);
        return disposeTask;
    }

    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, @NonNull TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        Disposable periodicDirectTask = new PeriodicDirectTask(RxJavaPlugins.onSchedule(runnable), createWorker);
        runnable = createWorker.schedulePeriodically(periodicDirectTask, j, j2, timeUnit);
        return runnable == EmptyDisposable.INSTANCE ? runnable : periodicDirectTask;
    }

    @NonNull
    public <S extends Scheduler & Disposable> S when(@NonNull Function<Flowable<Flowable<Completable>>, Completable> function) {
        return new SchedulerWhen(function, this);
    }
}
