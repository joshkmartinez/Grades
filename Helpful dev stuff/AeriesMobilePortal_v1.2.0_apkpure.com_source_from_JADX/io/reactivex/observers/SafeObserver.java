package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class SafeObserver<T> implements Observer<T>, Disposable {
    final Observer<? super T> actual;
    boolean done;
    Disposable f213s;

    public SafeObserver(@NonNull Observer<? super T> observer) {
        this.actual = observer;
    }

    public void onSubscribe(@NonNull Disposable disposable) {
        if (DisposableHelper.validate(this.f213s, disposable)) {
            this.f213s = disposable;
            try {
                this.actual.onSubscribe(this);
            } catch (Disposable disposable2) {
                Exceptions.throwIfFatal(disposable2);
                RxJavaPlugins.onError(new CompositeException(th, disposable2));
            }
        }
    }

    public void dispose() {
        this.f213s.dispose();
    }

    public boolean isDisposed() {
        return this.f213s.isDisposed();
    }

    public void onNext(@NonNull T t) {
        if (!this.done) {
            if (this.f213s == null) {
                onNextNoSubscription();
            } else if (t == null) {
                t = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.f213s.dispose();
                    onError(t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    onError(new CompositeException(t, th));
                }
            } else {
                try {
                    this.actual.onNext(t);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    onError(new CompositeException(t, th2));
                }
            }
        }
    }

    void onNextNoSubscription() {
        this.done = true;
        Throwable nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.actual.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.actual.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
        }
    }

    public void onError(@NonNull Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.done = true;
        if (this.f213s == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.actual.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    this.actual.onError(new CompositeException(th, nullPointerException));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(th, nullPointerException, th2));
                }
                return;
            } catch (Throwable th22) {
                Exceptions.throwIfFatal(th22);
                RxJavaPlugins.onError(new CompositeException(th, nullPointerException, th22));
                return;
            }
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        try {
            this.actual.onError(th);
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(new CompositeException(th, th3));
        }
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            if (this.f213s == null) {
                onCompleteNoSubscription();
                return;
            }
            try {
                this.actual.onComplete();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    void onCompleteNoSubscription() {
        Throwable nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.actual.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.actual.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
        }
    }
}
