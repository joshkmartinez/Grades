package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SingleAmb<T> extends Single<T> {
    private final SingleSource<? extends T>[] sources;
    private final Iterable<? extends SingleSource<? extends T>> sourcesIterable;

    static final class AmbSingleObserver<T> extends AtomicBoolean implements SingleObserver<T> {
        private static final long serialVersionUID = -1944085461036028108L;
        final SingleObserver<? super T> f187s;
        final CompositeDisposable set;

        AmbSingleObserver(SingleObserver<? super T> singleObserver, CompositeDisposable compositeDisposable) {
            this.f187s = singleObserver;
            this.set = compositeDisposable;
        }

        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }

        public void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.f187s.onSuccess(t);
            }
        }

        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.f187s.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }
    }

    public SingleAmb(SingleSource<? extends T>[] singleSourceArr, Iterable<? extends SingleSource<? extends T>> iterable) {
        this.sources = singleSourceArr;
        this.sourcesIterable = iterable;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        int i;
        Object obj = this.sources;
        int i2;
        if (obj == null) {
            obj = new SingleSource[8];
            try {
                i2 = 0;
                for (SingleSource singleSource : this.sourcesIterable) {
                    if (singleSource == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), (SingleObserver) singleObserver);
                        return;
                    }
                    if (i2 == obj.length) {
                        Object obj2 = new SingleSource[((i2 >> 2) + i2)];
                        System.arraycopy(obj, 0, obj2, 0, i2);
                        obj = obj2;
                    }
                    i = i2 + 1;
                    obj[i2] = singleSource;
                    i2 = i;
                }
            } catch (Throwable th) {
                Throwable th2;
                Exceptions.throwIfFatal(th2);
                EmptyDisposable.error(th2, (SingleObserver) singleObserver);
                return;
            }
        }
        i2 = obj.length;
        Object compositeDisposable = new CompositeDisposable();
        Object ambSingleObserver = new AmbSingleObserver(singleObserver, compositeDisposable);
        singleObserver.onSubscribe(compositeDisposable);
        i = 0;
        while (i < i2) {
            SingleSource singleSource2 = obj[i];
            if (!ambSingleObserver.get()) {
                if (singleSource2 == null) {
                    compositeDisposable.dispose();
                    th2 = new NullPointerException("One of the sources is null");
                    if (ambSingleObserver.compareAndSet(false, true)) {
                        singleObserver.onError(th2);
                    } else {
                        RxJavaPlugins.onError(th2);
                    }
                    return;
                }
                singleSource2.subscribe(ambSingleObserver);
                i++;
            } else {
                return;
            }
        }
    }
}
