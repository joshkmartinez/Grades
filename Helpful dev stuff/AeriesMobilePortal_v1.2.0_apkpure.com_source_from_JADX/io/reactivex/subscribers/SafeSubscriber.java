package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SafeSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    final Subscriber<? super T> actual;
    boolean done;
    Subscription f376s;

    public SafeSubscriber(Subscriber<? super T> subscriber) {
        this.actual = subscriber;
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f376s, subscription)) {
            this.f376s = subscription;
            try {
                this.actual.onSubscribe(this);
            } catch (Subscription subscription2) {
                Exceptions.throwIfFatal(subscription2);
                RxJavaPlugins.onError(new CompositeException(new Throwable[]{th, subscription2}));
            }
        }
    }

    public void onNext(T t) {
        if (!this.done) {
            if (this.f376s == null) {
                onNextNoSubscription();
            } else if (t == null) {
                t = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.f376s.cancel();
                    onError(t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    onError(new CompositeException(new Throwable[]{t, th}));
                }
            } else {
                try {
                    this.actual.onNext(t);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    onError(new CompositeException(new Throwable[]{t, th2}));
                }
            }
        }
    }

    void onNextNoSubscription() {
        this.done = true;
        Throwable nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.actual.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.actual.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(new Throwable[]{nullPointerException, th}));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(new Throwable[]{nullPointerException, th2}));
        }
    }

    public void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.done = true;
        if (this.f376s == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.actual.onSubscribe(EmptySubscription.INSTANCE);
                try {
                    this.actual.onError(new CompositeException(new Throwable[]{th, nullPointerException}));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(new Throwable[]{th, nullPointerException, th2}));
                }
                return;
            } catch (Throwable th22) {
                Exceptions.throwIfFatal(th22);
                RxJavaPlugins.onError(new CompositeException(new Throwable[]{th, nullPointerException, th22}));
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
            RxJavaPlugins.onError(new CompositeException(new Throwable[]{th, th3}));
        }
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            if (this.f376s == null) {
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
            this.actual.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.actual.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(new Throwable[]{nullPointerException, th}));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(new Throwable[]{nullPointerException, th2}));
        }
    }

    public void request(long j) {
        try {
            this.f376s.request(j);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(new CompositeException(new Throwable[]{j, th}));
        }
    }

    public void cancel() {
        try {
            this.f376s.cancel();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }
}
