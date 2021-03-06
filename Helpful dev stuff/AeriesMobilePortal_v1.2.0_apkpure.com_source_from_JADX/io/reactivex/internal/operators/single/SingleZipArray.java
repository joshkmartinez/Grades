package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleZipArray<T, R> extends Single<R> {
    final SingleSource<? extends T>[] sources;
    final Function<? super Object[], ? extends R> zipper;

    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        public R apply(T t) throws Exception {
            return ObjectHelper.requireNonNull(SingleZipArray.this.zipper.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -5556924161382950569L;
        final SingleObserver<? super R> actual;
        final ZipSingleObserver<T>[] observers;
        final Object[] values;
        final Function<? super Object[], ? extends R> zipper;

        ZipCoordinator(SingleObserver<? super R> singleObserver, int i, Function<? super Object[], ? extends R> function) {
            super(i);
            this.actual = singleObserver;
            this.zipper = function;
            singleObserver = new ZipSingleObserver[i];
            for (function = null; function < i; function++) {
                singleObserver[function] = new ZipSingleObserver(this, function);
            }
            this.observers = singleObserver;
            this.values = new Object[i];
        }

        public boolean isDisposed() {
            return get() <= 0;
        }

        public void dispose() {
            int i = 0;
            if (getAndSet(0) > 0) {
                ZipSingleObserver[] zipSingleObserverArr = this.observers;
                int length = zipSingleObserverArr.length;
                while (i < length) {
                    zipSingleObserverArr[i].dispose();
                    i++;
                }
            }
        }

        void innerSuccess(T t, int i) {
            this.values[i] = t;
            if (decrementAndGet() == null) {
                try {
                    this.actual.onSuccess(ObjectHelper.requireNonNull(this.zipper.apply(this.values), "The zipper returned a null value"));
                } catch (T t2) {
                    Exceptions.throwIfFatal(t2);
                    this.actual.onError(t2);
                }
            }
        }

        void disposeExcept(int i) {
            ZipSingleObserver[] zipSingleObserverArr = this.observers;
            int length = zipSingleObserverArr.length;
            for (int i2 = 0; i2 < i; i2++) {
                zipSingleObserverArr[i2].dispose();
            }
            while (true) {
                i++;
                if (i < length) {
                    zipSingleObserverArr[i].dispose();
                } else {
                    return;
                }
            }
        }

        void innerError(Throwable th, int i) {
            if (getAndSet(0) > 0) {
                disposeExcept(i);
                this.actual.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }
    }

    static final class ZipSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final ZipCoordinator<T, ?> parent;

        ZipSingleObserver(ZipCoordinator<T, ?> zipCoordinator, int i) {
            this.parent = zipCoordinator;
            this.index = i;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t) {
            this.parent.innerSuccess(t, this.index);
        }

        public void onError(Throwable th) {
            this.parent.innerError(th, this.index);
        }
    }

    public SingleZipArray(SingleSource<? extends T>[] singleSourceArr, Function<? super Object[], ? extends R> function) {
        this.sources = singleSourceArr;
        this.zipper = function;
    }

    protected void subscribeActual(SingleObserver<? super R> singleObserver) {
        SingleSource[] singleSourceArr = this.sources;
        int i = 0;
        int length = singleSourceArr.length;
        if (length == 1) {
            singleSourceArr[0].subscribe(new MapSingleObserver(singleObserver, new SingletonArrayFunc()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(singleObserver, length, this.zipper);
        singleObserver.onSubscribe(zipCoordinator);
        while (i < length && zipCoordinator.isDisposed() == null) {
            singleObserver = singleSourceArr[i];
            if (singleObserver == null) {
                zipCoordinator.innerError(new NullPointerException("One of the sources is null"), i);
                return;
            } else {
                singleObserver.subscribe(zipCoordinator.observers[i]);
                i++;
            }
        }
    }
}
