package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

@Experimental
public final class SingleDoAfterSuccess<T> extends Single<T> {
    final Consumer<? super T> onAfterSuccess;
    final SingleSource<T> source;

    static final class DoAfterObserver<T> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> actual;
        Disposable f191d;
        final Consumer<? super T> onAfterSuccess;

        DoAfterObserver(SingleObserver<? super T> singleObserver, Consumer<? super T> consumer) {
            this.actual = singleObserver;
            this.onAfterSuccess = consumer;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f191d, disposable)) {
                this.f191d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.actual.onSuccess(t);
            try {
                this.onAfterSuccess.accept(t);
            } catch (T t2) {
                Exceptions.throwIfFatal(t2);
                RxJavaPlugins.onError(t2);
            }
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void dispose() {
            this.f191d.dispose();
        }

        public boolean isDisposed() {
            return this.f191d.isDisposed();
        }
    }

    public SingleDoAfterSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.source = singleSource;
        this.onAfterSuccess = consumer;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DoAfterObserver(singleObserver, this.onAfterSuccess));
    }
}
