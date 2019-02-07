package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    static final class DelayObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;
        final long delay;
        final boolean delayError;
        Disposable f120s;
        final TimeUnit unit;
        final Worker f121w;

        final class OnComplete implements Runnable {
            OnComplete() {
            }

            public void run() {
                try {
                    DelayObserver.this.actual.onComplete();
                } finally {
                    DelayObserver.this.f121w.dispose();
                }
            }
        }

        final class OnError implements Runnable {
            private final Throwable throwable;

            OnError(Throwable th) {
                this.throwable = th;
            }

            public void run() {
                try {
                    DelayObserver.this.actual.onError(this.throwable);
                } finally {
                    DelayObserver.this.f121w.dispose();
                }
            }
        }

        final class OnNext implements Runnable {
            private final T f31t;

            OnNext(T t) {
                this.f31t = t;
            }

            public void run() {
                DelayObserver.this.actual.onNext(this.f31t);
            }
        }

        DelayObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Worker worker, boolean z) {
            this.actual = observer;
            this.delay = j;
            this.unit = timeUnit;
            this.f121w = worker;
            this.delayError = z;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f120s, disposable)) {
                this.f120s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f121w.schedule(new OnNext(t), this.delay, this.unit);
        }

        public void onError(Throwable th) {
            this.f121w.schedule(new OnError(th), this.delayError != null ? this.delay : 0, this.unit);
        }

        public void onComplete() {
            this.f121w.schedule(new OnComplete(), this.delay, this.unit);
        }

        public void dispose() {
            this.f120s.dispose();
            this.f121w.dispose();
        }

        public boolean isDisposed() {
            return this.f121w.isDisposed();
        }
    }

    public ObservableDelay(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observableSource);
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        Observer observer2;
        if (this.delayError) {
            observer2 = observer;
        } else {
            observer2 = new SerializedObserver(observer);
        }
        this.source.subscribe(new DelayObserver(observer2, this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }
}
