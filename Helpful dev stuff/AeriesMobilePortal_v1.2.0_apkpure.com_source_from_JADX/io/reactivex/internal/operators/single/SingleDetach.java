package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

@Experimental
public final class SingleDetach<T> extends Single<T> {
    final SingleSource<T> source;

    static final class DetachSingleObserver<T> implements SingleObserver<T>, Disposable {
        SingleObserver<? super T> actual;
        Disposable f190d;

        DetachSingleObserver(SingleObserver<? super T> singleObserver) {
            this.actual = singleObserver;
        }

        public void dispose() {
            this.actual = null;
            this.f190d.dispose();
            this.f190d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f190d.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f190d, disposable)) {
                this.f190d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.f190d = DisposableHelper.DISPOSED;
            SingleObserver singleObserver = this.actual;
            if (singleObserver != null) {
                this.actual = null;
                singleObserver.onSuccess(t);
            }
        }

        public void onError(Throwable th) {
            this.f190d = DisposableHelper.DISPOSED;
            SingleObserver singleObserver = this.actual;
            if (singleObserver != null) {
                this.actual = null;
                singleObserver.onError(th);
            }
        }
    }

    public SingleDetach(SingleSource<T> singleSource) {
        this.source = singleSource;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DetachSingleObserver(singleObserver));
    }
}
