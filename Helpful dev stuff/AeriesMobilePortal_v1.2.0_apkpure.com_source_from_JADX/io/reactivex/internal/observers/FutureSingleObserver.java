package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class FutureSingleObserver<T> extends CountDownLatch implements SingleObserver<T>, Future<T>, Disposable {
    Throwable error;
    final AtomicReference<Disposable> f59s = new AtomicReference();
    T value;

    public void dispose() {
    }

    public FutureSingleObserver() {
        super(1);
    }

    public boolean cancel(boolean z) {
        DisposableHelper disposableHelper;
        do {
            disposableHelper = (Disposable) this.f59s.get();
            if (disposableHelper != this) {
                if (disposableHelper == DisposableHelper.DISPOSED) {
                }
            }
            return false;
        } while (!this.f59s.compareAndSet(disposableHelper, DisposableHelper.DISPOSED));
        if (disposableHelper != null) {
            disposableHelper.dispose();
        }
        countDown();
        return true;
    }

    public boolean isCancelled() {
        return DisposableHelper.isDisposed((Disposable) this.f59s.get());
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.error;
        if (th == null) {
            return this.value;
        }
        throw new ExecutionException(th);
    }

    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            if (await(j, timeUnit) == null) {
                throw new TimeoutException();
            }
        }
        if (isCancelled() == null) {
            j = this.error;
            if (j == null) {
                return this.value;
            }
            throw new ExecutionException(j);
        }
        throw new CancellationException();
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f59s, disposable);
    }

    public void onSuccess(T t) {
        Disposable disposable = (Disposable) this.f59s.get();
        if (disposable != DisposableHelper.DISPOSED) {
            this.value = t;
            this.f59s.compareAndSet(disposable, this);
            countDown();
        }
    }

    public void onError(Throwable th) {
        Disposable disposable;
        do {
            disposable = (Disposable) this.f59s.get();
            if (disposable == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
        } while (!this.f59s.compareAndSet(disposable, this));
        countDown();
    }

    public boolean isDisposed() {
        return isDone();
    }
}
