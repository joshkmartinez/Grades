package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {
    static final Object ASYNC_DISPOSED = new Object();
    static final Object DONE = new Object();
    static final int FUTURE_INDEX = 1;
    static final Object PARENT_DISPOSED = new Object();
    static final int PARENT_INDEX = 0;
    static final Object SYNC_DISPOSED = new Object();
    static final int THREAD_INDEX = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;

    public ScheduledRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        super(3);
        this.actual = runnable;
        lazySet(null, disposableContainer);
    }

    public Object call() {
        run();
        return null;
    }

    public void run() {
        Object obj;
        lazySet(2, Thread.currentThread());
        try {
            this.actual.run();
        } catch (Throwable th) {
            lazySet(2, null);
            obj = get(0);
            if (!(obj == PARENT_DISPOSED || !compareAndSet(0, obj, DONE) || obj == null)) {
                ((DisposableContainer) obj).delete(this);
            }
            while (true) {
                obj = get(1);
                if (obj == SYNC_DISPOSED || obj == ASYNC_DISPOSED || compareAndSet(1, obj, DONE)) {
                }
            }
        }
        lazySet(2, null);
        obj = get(0);
        if (!(obj == PARENT_DISPOSED || !compareAndSet(0, obj, DONE) || obj == null)) {
            ((DisposableContainer) obj).delete(this);
        }
        do {
            obj = get(1);
            if (obj == SYNC_DISPOSED || obj == ASYNC_DISPOSED) {
                return;
            }
        } while (!compareAndSet(1, obj, DONE));
    }

    public void setFuture(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj != DONE) {
                if (obj == SYNC_DISPOSED) {
                    future.cancel(false);
                    return;
                } else if (obj == ASYNC_DISPOSED) {
                    future.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    public void dispose() {
        Object obj;
        Object obj2;
        boolean z;
        do {
            obj2 = get(1);
            if (obj2 == DONE || obj2 == SYNC_DISPOSED) {
                break;
            } else if (obj2 == ASYNC_DISPOSED) {
                break;
            } else {
                z = get(2) != Thread.currentThread();
            }
        } while (!compareAndSet(1, obj2, z ? ASYNC_DISPOSED : SYNC_DISPOSED));
        if (obj2 != null) {
            ((Future) obj2).cancel(z);
        }
        do {
            obj = get(0);
            if (!(obj == DONE || obj == PARENT_DISPOSED)) {
                if (obj == null) {
                }
            }
            return;
        } while (!compareAndSet(0, obj, PARENT_DISPOSED));
        ((DisposableContainer) obj).delete(this);
    }

    public boolean isDisposed() {
        Object obj = get(0);
        if (obj == PARENT_DISPOSED || obj == DONE) {
            return true;
        }
        return false;
    }
}
