package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSkipLastTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final int bufferSize;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    static final class SkipLastTimedObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;
        final Observer<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final SpscLinkedArrayQueue<Object> queue;
        Disposable f157s;
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;

        SkipLastTimedObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
            this.actual = observer;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.queue = new SpscLinkedArrayQueue(i);
            this.delayError = z;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f157s, disposable)) {
                this.f157s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.queue.offer(Long.valueOf(this.scheduler.now(this.unit)), t);
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.f157s.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        void drain() {
            SkipLastTimedObserver skipLastTimedObserver = this;
            if (getAndIncrement() == 0) {
                Observer observer = skipLastTimedObserver.actual;
                SpscLinkedArrayQueue spscLinkedArrayQueue = skipLastTimedObserver.queue;
                boolean z = skipLastTimedObserver.delayError;
                TimeUnit timeUnit = skipLastTimedObserver.unit;
                Scheduler scheduler = skipLastTimedObserver.scheduler;
                long j = skipLastTimedObserver.time;
                int i = 1;
                while (!skipLastTimedObserver.cancelled) {
                    boolean z2 = skipLastTimedObserver.done;
                    Long l = (Long) spscLinkedArrayQueue.peek();
                    Object obj = l == null ? 1 : null;
                    long now = scheduler.now(timeUnit);
                    if (obj == null && l.longValue() > now - j) {
                        obj = 1;
                    }
                    if (z2) {
                        if (!z) {
                            Throwable th = skipLastTimedObserver.error;
                            if (th != null) {
                                skipLastTimedObserver.queue.clear();
                                observer.onError(th);
                                return;
                            } else if (obj != null) {
                                observer.onComplete();
                                return;
                            }
                        } else if (obj != null) {
                            Throwable th2 = skipLastTimedObserver.error;
                            if (th2 != null) {
                                observer.onError(th2);
                            } else {
                                observer.onComplete();
                            }
                            return;
                        }
                    }
                    if (obj != null) {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        spscLinkedArrayQueue.poll();
                        observer.onNext(spscLinkedArrayQueue.poll());
                    }
                }
                skipLastTimedObserver.queue.clear();
            }
        }
    }

    public ObservableSkipLastTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(observableSource);
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSize = i;
        this.delayError = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SkipLastTimedObserver(observer, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }
}
