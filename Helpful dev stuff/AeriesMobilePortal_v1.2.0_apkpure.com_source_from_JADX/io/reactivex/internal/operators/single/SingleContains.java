package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;

public final class SingleContains<T> extends io.reactivex.Single<Boolean> {
    final BiPredicate<Object, Object> comparer;
    final SingleSource<T> source;
    final Object value;

    final class Single implements SingleObserver<T> {
        private final SingleObserver<? super Boolean> f188s;

        Single(SingleObserver<? super Boolean> singleObserver) {
            this.f188s = singleObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.f188s.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            try {
                this.f188s.onSuccess(Boolean.valueOf(SingleContains.this.comparer.test(t, SingleContains.this.value)));
            } catch (T t2) {
                Exceptions.throwIfFatal(t2);
                this.f188s.onError(t2);
            }
        }

        public void onError(Throwable th) {
            this.f188s.onError(th);
        }
    }

    public SingleContains(SingleSource<T> singleSource, Object obj, BiPredicate<Object, Object> biPredicate) {
        this.source = singleSource;
        this.value = obj;
        this.comparer = biPredicate;
    }

    protected void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.source.subscribe(new Single(singleObserver));
    }
}
