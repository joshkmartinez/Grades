package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class CompletableDisposeOn extends Completable {
    final Scheduler scheduler;
    final CompletableSource source;

    static final class CompletableObserverImplementation implements CompletableObserver, Disposable, Runnable {
        Disposable f64d;
        volatile boolean disposed;
        final CompletableObserver f65s;
        final Scheduler scheduler;

        CompletableObserverImplementation(CompletableObserver completableObserver, Scheduler scheduler) {
            this.f65s = completableObserver;
            this.scheduler = scheduler;
        }

        public void onComplete() {
            if (!this.disposed) {
                this.f65s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.disposed) {
                RxJavaPlugins.onError(th);
            } else {
                this.f65s.onError(th);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f64d, disposable)) {
                this.f64d = disposable;
                this.f65s.onSubscribe(this);
            }
        }

        public void dispose() {
            this.disposed = true;
            this.scheduler.scheduleDirect(this);
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public void run() {
            this.f64d.dispose();
            this.f64d = DisposableHelper.DISPOSED;
        }
    }

    public CompletableDisposeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.source = completableSource;
        this.scheduler = scheduler;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new CompletableObserverImplementation(completableObserver, this.scheduler));
    }
}
