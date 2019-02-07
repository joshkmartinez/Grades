package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {
    protected final Observer<? super R> actual;
    protected boolean done;
    protected QueueDisposable<T> qs;
    protected Disposable f295s;
    protected int sourceMode;

    protected void afterDownstream() {
    }

    protected boolean beforeDownstream() {
        return true;
    }

    public BasicFuseableObserver(Observer<? super R> observer) {
        this.actual = observer;
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f295s, disposable)) {
            this.f295s = disposable;
            if (disposable instanceof QueueDisposable) {
                this.qs = (QueueDisposable) disposable;
            }
            if (beforeDownstream() != null) {
                this.actual.onSubscribe(this);
                afterDownstream();
            }
        }
    }

    public void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.done = true;
        this.actual.onError(th);
    }

    protected final void fail(Throwable th) {
        Exceptions.throwIfFatal(th);
        this.f295s.dispose();
        onError(th);
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.actual.onComplete();
        }
    }

    protected final int transitiveBoundaryFusion(int i) {
        QueueDisposable queueDisposable = this.qs;
        if (queueDisposable == null || (i & 4) != 0) {
            return 0;
        }
        i = queueDisposable.requestFusion(i);
        if (i != 0) {
            this.sourceMode = i;
        }
        return i;
    }

    public void dispose() {
        this.f295s.dispose();
    }

    public boolean isDisposed() {
        return this.f295s.isDisposed();
    }

    public boolean isEmpty() {
        return this.qs.isEmpty();
    }

    public void clear() {
        this.qs.clear();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
