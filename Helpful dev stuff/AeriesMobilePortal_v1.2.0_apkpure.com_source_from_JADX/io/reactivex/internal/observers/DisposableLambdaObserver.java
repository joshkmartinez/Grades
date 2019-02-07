package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {
    final Observer<? super T> actual;
    final Action onDispose;
    final Consumer<? super Disposable> onSubscribe;
    Disposable f56s;

    public DisposableLambdaObserver(Observer<? super T> observer, Consumer<? super Disposable> consumer, Action action) {
        this.actual = observer;
        this.onSubscribe = consumer;
        this.onDispose = action;
    }

    public void onSubscribe(Disposable disposable) {
        try {
            this.onSubscribe.accept(disposable);
            if (DisposableHelper.validate(this.f56s, disposable)) {
                this.f56s = disposable;
                this.actual.onSubscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            disposable.dispose();
            this.f56s = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th, this.actual);
        }
    }

    public void onNext(T t) {
        this.actual.onNext(t);
    }

    public void onError(Throwable th) {
        if (this.f56s != DisposableHelper.DISPOSED) {
            this.actual.onError(th);
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    public void onComplete() {
        if (this.f56s != DisposableHelper.DISPOSED) {
            this.actual.onComplete();
        }
    }

    public void dispose() {
        try {
            this.onDispose.run();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
        this.f56s.dispose();
    }

    public boolean isDisposed() {
        return this.f56s.isDisposed();
    }
}
