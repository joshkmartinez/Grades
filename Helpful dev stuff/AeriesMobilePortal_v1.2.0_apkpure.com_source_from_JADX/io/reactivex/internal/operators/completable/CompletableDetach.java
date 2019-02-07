package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

@Experimental
public final class CompletableDetach extends Completable {
    final CompletableSource source;

    static final class DetachCompletableObserver implements CompletableObserver, Disposable {
        CompletableObserver actual;
        Disposable f63d;

        DetachCompletableObserver(CompletableObserver completableObserver) {
            this.actual = completableObserver;
        }

        public void dispose() {
            this.actual = null;
            this.f63d.dispose();
            this.f63d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f63d.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f63d, disposable)) {
                this.f63d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onError(Throwable th) {
            this.f63d = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.actual;
            if (completableObserver != null) {
                this.actual = null;
                completableObserver.onError(th);
            }
        }

        public void onComplete() {
            this.f63d = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.actual;
            if (completableObserver != null) {
                this.actual = null;
                completableObserver.onComplete();
            }
        }
    }

    public CompletableDetach(CompletableSource completableSource) {
        this.source = completableSource;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new DetachCompletableObserver(completableObserver));
    }
}
