package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableFlattenIterable<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;

    static final class FlattenIterableObserver<T, R> implements Observer<T>, Disposable {
        final Observer<? super R> actual;
        Disposable f132d;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;

        FlattenIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.actual = observer;
            this.mapper = function;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f132d, disposable)) {
                this.f132d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (this.f132d != DisposableHelper.DISPOSED) {
                try {
                    Observer observer = this.actual;
                    for (Object requireNonNull : (Iterable) this.mapper.apply(t)) {
                        try {
                            try {
                                observer.onNext(ObjectHelper.requireNonNull(requireNonNull, "The iterator returned a null value"));
                            } catch (T t2) {
                                Exceptions.throwIfFatal(t2);
                                this.f132d.dispose();
                                onError(t2);
                                return;
                            }
                        } catch (T t22) {
                            Exceptions.throwIfFatal(t22);
                            this.f132d.dispose();
                            onError(t22);
                            return;
                        }
                    }
                } catch (T t222) {
                    Exceptions.throwIfFatal(t222);
                    this.f132d.dispose();
                    onError(t222);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.f132d == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.f132d = DisposableHelper.DISPOSED;
            this.actual.onError(th);
        }

        public void onComplete() {
            if (this.f132d != DisposableHelper.DISPOSED) {
                this.f132d = DisposableHelper.DISPOSED;
                this.actual.onComplete();
            }
        }

        public boolean isDisposed() {
            return this.f132d.isDisposed();
        }

        public void dispose() {
            this.f132d.dispose();
            this.f132d = DisposableHelper.DISPOSED;
        }
    }

    public ObservableFlattenIterable(ObservableSource<T> observableSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        super(observableSource);
        this.mapper = function;
    }

    protected void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new FlattenIterableObserver(observer, this.mapper));
    }
}
