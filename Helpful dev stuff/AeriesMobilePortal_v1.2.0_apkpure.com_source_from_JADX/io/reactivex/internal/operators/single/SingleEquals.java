package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class SingleEquals<T> extends Single<Boolean> {
    final SingleSource<? extends T> first;
    final SingleSource<? extends T> second;

    static class InnerObserver<T> implements SingleObserver<T> {
        final AtomicInteger count;
        final int index;
        final SingleObserver<? super Boolean> f198s;
        final CompositeDisposable set;
        final Object[] values;

        InnerObserver(int i, CompositeDisposable compositeDisposable, Object[] objArr, SingleObserver<? super Boolean> singleObserver, AtomicInteger atomicInteger) {
            this.index = i;
            this.set = compositeDisposable;
            this.values = objArr;
            this.f198s = singleObserver;
            this.count = atomicInteger;
        }

        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }

        public void onSuccess(T t) {
            this.values[this.index] = t;
            if (this.count.incrementAndGet() == 2) {
                this.f198s.onSuccess(Boolean.valueOf(ObjectHelper.equals(this.values[0], this.values[1])));
            }
        }

        public void onError(Throwable th) {
            int i;
            do {
                i = this.count.get();
                if (i >= 2) {
                    RxJavaPlugins.onError(th);
                    return;
                }
            } while (!this.count.compareAndSet(i, 2));
            this.set.dispose();
            this.f198s.onError(th);
        }
    }

    public SingleEquals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        this.first = singleSource;
        this.second = singleSource2;
    }

    protected void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = new Object[]{null, null};
        Disposable compositeDisposable = new CompositeDisposable();
        singleObserver.onSubscribe(compositeDisposable);
        Disposable disposable = compositeDisposable;
        Object[] objArr2 = objArr;
        SingleObserver<? super Boolean> singleObserver2 = singleObserver;
        AtomicInteger atomicInteger2 = atomicInteger;
        this.first.subscribe(new InnerObserver(0, disposable, objArr2, singleObserver2, atomicInteger2));
        this.second.subscribe(new InnerObserver(1, disposable, objArr2, singleObserver2, atomicInteger2));
    }
}
