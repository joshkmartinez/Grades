package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableAll<T> extends AbstractObservableWithUpstream<T, Boolean> {
    final Predicate<? super T> predicate;

    static final class AllObserver<T> implements Observer<T>, Disposable {
        final Observer<? super Boolean> actual;
        boolean done;
        final Predicate<? super T> predicate;
        Disposable f102s;

        AllObserver(Observer<? super Boolean> observer, Predicate<? super T> predicate) {
            this.actual = observer;
            this.predicate = predicate;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f102s, disposable)) {
                this.f102s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    if (this.predicate.test(t) == null) {
                        this.done = true;
                        this.f102s.dispose();
                        this.actual.onNext(Boolean.valueOf(false));
                        this.actual.onComplete();
                    }
                } catch (T t2) {
                    Exceptions.throwIfFatal(t2);
                    this.f102s.dispose();
                    onError(t2);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.actual.onNext(Boolean.valueOf(true));
                this.actual.onComplete();
            }
        }

        public void dispose() {
            this.f102s.dispose();
        }

        public boolean isDisposed() {
            return this.f102s.isDisposed();
        }
    }

    public ObservableAll(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.predicate = predicate;
    }

    protected void subscribeActual(Observer<? super Boolean> observer) {
        this.source.subscribe(new AllObserver(observer, this.predicate));
    }
}
