package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {
    final long f303n;

    static final class SkipObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;
        Disposable f155d;
        long remaining;

        SkipObserver(Observer<? super T> observer, long j) {
            this.actual = observer;
            this.remaining = j;
        }

        public void onSubscribe(Disposable disposable) {
            this.f155d = disposable;
            this.actual.onSubscribe(this);
        }

        public void onNext(T t) {
            if (this.remaining != 0) {
                this.remaining--;
            } else {
                this.actual.onNext(t);
            }
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }

        public void dispose() {
            this.f155d.dispose();
        }

        public boolean isDisposed() {
            return this.f155d.isDisposed();
        }
    }

    public ObservableSkip(ObservableSource<T> observableSource, long j) {
        super(observableSource);
        this.f303n = j;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SkipObserver(observer, this.f303n));
    }
}
