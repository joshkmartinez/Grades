package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeHide<T> extends AbstractMaybeWithUpstream<T, T> {

    static final class HideMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> actual;
        Disposable f90d;

        HideMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.actual = maybeObserver;
        }

        public void dispose() {
            this.f90d.dispose();
            this.f90d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f90d.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f90d, disposable)) {
                this.f90d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }
    }

    public MaybeHide(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new HideMaybeObserver(maybeObserver));
    }
}
