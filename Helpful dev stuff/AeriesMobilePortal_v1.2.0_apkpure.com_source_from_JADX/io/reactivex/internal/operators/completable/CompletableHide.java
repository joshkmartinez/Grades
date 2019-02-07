package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class CompletableHide extends Completable {
    final CompletableSource source;

    static final class HideCompletableObserver implements CompletableObserver, Disposable {
        final CompletableObserver actual;
        Disposable f67d;

        HideCompletableObserver(CompletableObserver completableObserver) {
            this.actual = completableObserver;
        }

        public void dispose() {
            this.f67d.dispose();
            this.f67d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f67d.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f67d, disposable)) {
                this.f67d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }
    }

    public CompletableHide(CompletableSource completableSource) {
        this.source = completableSource;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new HideCompletableObserver(completableObserver));
    }
}
