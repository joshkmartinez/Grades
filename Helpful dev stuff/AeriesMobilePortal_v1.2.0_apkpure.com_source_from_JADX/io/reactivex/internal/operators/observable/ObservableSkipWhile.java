package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableSkipWhile<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super T> predicate;

    static final class SkipWhileObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;
        boolean notSkipping;
        final Predicate<? super T> predicate;
        Disposable f160s;

        SkipWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.actual = observer;
            this.predicate = predicate;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f160s, disposable)) {
                this.f160s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f160s.dispose();
        }

        public boolean isDisposed() {
            return this.f160s.isDisposed();
        }

        public void onNext(T t) {
            if (this.notSkipping) {
                this.actual.onNext(t);
            } else {
                try {
                    if (!this.predicate.test(t)) {
                        this.notSkipping = true;
                        this.actual.onNext(t);
                    }
                } catch (T t2) {
                    Exceptions.throwIfFatal(t2);
                    this.f160s.dispose();
                    this.actual.onError(t2);
                }
            }
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }
    }

    public ObservableSkipWhile(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.predicate = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SkipWhileObserver(observer, this.predicate));
    }
}