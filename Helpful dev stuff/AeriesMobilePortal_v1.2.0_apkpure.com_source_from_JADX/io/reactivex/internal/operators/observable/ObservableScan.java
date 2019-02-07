package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableScan<T> extends AbstractObservableWithUpstream<T, T> {
    final BiFunction<T, T, T> accumulator;

    static final class ScanObserver<T> implements Observer<T>, Disposable {
        final BiFunction<T, T, T> accumulator;
        final Observer<? super T> actual;
        boolean done;
        Disposable f151s;
        T value;

        ScanObserver(Observer<? super T> observer, BiFunction<T, T, T> biFunction) {
            this.actual = observer;
            this.accumulator = biFunction;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f151s, disposable)) {
                this.f151s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f151s.dispose();
        }

        public boolean isDisposed() {
            return this.f151s.isDisposed();
        }

        public void onNext(T t) {
            if (!this.done) {
                Observer observer = this.actual;
                Object obj = this.value;
                if (obj == null) {
                    this.value = t;
                    observer.onNext(t);
                } else {
                    try {
                        t = ObjectHelper.requireNonNull(this.accumulator.apply(obj, t), "The value returned by the accumulator is null");
                        this.value = t;
                        observer.onNext(t);
                    } catch (T t2) {
                        Exceptions.throwIfFatal(t2);
                        this.f151s.dispose();
                        onError(t2);
                    }
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
                this.actual.onComplete();
            }
        }
    }

    public ObservableScan(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        super(observableSource);
        this.accumulator = biFunction;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ScanObserver(observer, this.accumulator));
    }
}
