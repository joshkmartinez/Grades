package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

public final class CompletableDelay extends Completable {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final CompletableSource source;
    final TimeUnit unit;

    final class Delay implements CompletableObserver {
        final CompletableObserver f62s;
        private final CompositeDisposable set;

        final class OnComplete implements Runnable {
            OnComplete() {
            }

            public void run() {
                Delay.this.f62s.onComplete();
            }
        }

        final class OnError implements Runnable {
            private final Throwable f22e;

            OnError(Throwable th) {
                this.f22e = th;
            }

            public void run() {
                Delay.this.f62s.onError(this.f22e);
            }
        }

        Delay(CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.set = compositeDisposable;
            this.f62s = completableObserver;
        }

        public void onComplete() {
            this.set.add(CompletableDelay.this.scheduler.scheduleDirect(new OnComplete(), CompletableDelay.this.delay, CompletableDelay.this.unit));
        }

        public void onError(Throwable th) {
            this.set.add(CompletableDelay.this.scheduler.scheduleDirect(new OnError(th), CompletableDelay.this.delayError != null ? CompletableDelay.this.delay : 0, CompletableDelay.this.unit));
        }

        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
            this.f62s.onSubscribe(this.set);
        }
    }

    public CompletableDelay(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.source = completableSource;
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new Delay(new CompositeDisposable(), completableObserver));
    }
}
