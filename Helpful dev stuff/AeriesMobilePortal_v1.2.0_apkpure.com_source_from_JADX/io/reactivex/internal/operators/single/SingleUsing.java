package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleUsing<T, U> extends Single<T> {
    final Consumer<? super U> disposer;
    final boolean eager;
    final Callable<U> resourceSupplier;
    final Function<? super U, ? extends SingleSource<? extends T>> singleFunction;

    static final class UsingSingleObserver<T, U> extends AtomicReference<Object> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -5331524057054083935L;
        final SingleObserver<? super T> actual;
        Disposable f202d;
        final Consumer<? super U> disposer;
        final boolean eager;

        UsingSingleObserver(SingleObserver<? super T> singleObserver, U u, boolean z, Consumer<? super U> consumer) {
            super(u);
            this.actual = singleObserver;
            this.eager = z;
            this.disposer = consumer;
        }

        public void dispose() {
            this.f202d.dispose();
            this.f202d = DisposableHelper.DISPOSED;
            disposeAfter();
        }

        public boolean isDisposed() {
            return this.f202d.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f202d, disposable)) {
                this.f202d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.f202d = DisposableHelper.DISPOSED;
            if (this.eager) {
                UsingSingleObserver andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.disposer.accept(andSet);
                    } catch (T t2) {
                        Exceptions.throwIfFatal(t2);
                        this.actual.onError(t2);
                        return;
                    }
                }
                return;
            }
            this.actual.onSuccess(t2);
            if (this.eager == null) {
                disposeAfter();
            }
        }

        public void onError(Throwable th) {
            this.f202d = DisposableHelper.DISPOSED;
            if (this.eager) {
                UsingSingleObserver andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.disposer.accept(andSet);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        th = new CompositeException(th, th2);
                    }
                } else {
                    return;
                }
            }
            this.actual.onError(th);
            if (this.eager == null) {
                disposeAfter();
            }
        }

        void disposeAfter() {
            UsingSingleObserver andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }

    public SingleUsing(Callable<U> callable, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer, boolean z) {
        this.resourceSupplier = callable;
        this.singleFunction = function;
        this.disposer = consumer;
        this.eager = z;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            Throwable th;
            Object call = this.resourceSupplier.call();
            try {
                ((SingleSource) ObjectHelper.requireNonNull(this.singleFunction.apply(call), "The singleFunction returned a null SingleSource")).subscribe(new UsingSingleObserver(singleObserver, call, this.eager, this.disposer));
                return;
            } catch (SingleObserver<? super T> singleObserver2) {
                Exceptions.throwIfFatal(singleObserver2);
                RxJavaPlugins.onError(singleObserver2);
            }
            EmptyDisposable.error(th, (SingleObserver) singleObserver2);
            if (this.eager == null) {
                this.disposer.accept(call);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (SingleObserver) singleObserver2);
        }
    }
}
