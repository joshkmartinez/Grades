package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class FutureObserver<T> extends CountDownLatch implements Observer<T>, Future<T>, Disposable {
    Throwable error;
    final AtomicReference<Disposable> f58s = new AtomicReference();
    T value;

    public void dispose() {
    }

    public FutureObserver() {
        super(1);
    }

    public boolean cancel(boolean z) {
        DisposableHelper disposableHelper;
        do {
            disposableHelper = (Disposable) this.f58s.get();
            if (disposableHelper != this) {
                if (disposableHelper == DisposableHelper.DISPOSED) {
                }
            }
            return false;
        } while (!this.f58s.compareAndSet(disposableHelper, DisposableHelper.DISPOSED));
        if (disposableHelper != null) {
            disposableHelper.dispose();
        }
        countDown();
        return true;
    }

    public boolean isCancelled() {
        return DisposableHelper.isDisposed((Disposable) this.f58s.get());
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
        DisposableHelper.setOnce(this.f58s, disposable);
    }

    public void onNext(T t) {
        if (this.value != null) {
            ((Disposable) this.f58s.get()).dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.value = t;
    }

    public void onError(Throwable th) {
        if (this.error == null) {
            this.error = th;
            DisposableHelper disposableHelper;
            do {
                disposableHelper = (Disposable) this.f58s.get();
                if (disposableHelper != this) {
                    if (disposableHelper == DisposableHelper.DISPOSED) {
                    }
                }
                RxJavaPlugins.onError(th);
                return;
            } while (!this.f58s.compareAndSet(disposableHelper, this));
            countDown();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    public void onComplete() {
        if (this.value == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        DisposableHelper disposableHelper;
        do {
            disposableHelper = (Disposable) this.f58s.get();
            if (disposableHelper != this) {
                if (disposableHelper == DisposableHelper.DISPOSED) {
                }
            }
            return;
        } while (!this.f58s.compareAndSet(disposableHelper, this));
        countDown();
    }

    public boolean isDisposed() {
        return isDone();
    }
}
