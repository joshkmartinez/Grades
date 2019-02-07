package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
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
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

public final class FutureSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T>, Future<T>, Subscription {
    Throwable error;
    final AtomicReference<Subscription> f291s = new AtomicReference();
    T value;

    public void cancel() {
    }

    public void request(long j) {
    }

    public FutureSubscriber() {
        super(1);
    }

    public boolean cancel(boolean z) {
        SubscriptionHelper subscriptionHelper;
        do {
            subscriptionHelper = (Subscription) this.f291s.get();
            if (subscriptionHelper != this) {
                if (subscriptionHelper == SubscriptionHelper.CANCELLED) {
                }
            }
            return false;
        } while (!this.f291s.compareAndSet(subscriptionHelper, SubscriptionHelper.CANCELLED));
        if (subscriptionHelper != null) {
            subscriptionHelper.cancel();
        }
        countDown();
        return true;
    }

    public boolean isCancelled() {
        return SubscriptionHelper.isCancelled((Subscription) this.f291s.get());
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

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f291s, subscription)) {
            subscription.request(LongCompanionObject.MAX_VALUE);
        }
    }

    public void onNext(T t) {
        if (this.value != null) {
            ((Subscription) this.f291s.get()).cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.value = t;
    }

    public void onError(Throwable th) {
        SubscriptionHelper subscriptionHelper;
        do {
            subscriptionHelper = (Subscription) this.f291s.get();
            if (subscriptionHelper != this) {
                if (subscriptionHelper != SubscriptionHelper.CANCELLED) {
                    this.error = th;
                }
            }
            RxJavaPlugins.onError(th);
            return;
        } while (!this.f291s.compareAndSet(subscriptionHelper, this));
        countDown();
    }

    public void onComplete() {
        if (this.value == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        SubscriptionHelper subscriptionHelper;
        do {
            subscriptionHelper = (Subscription) this.f291s.get();
            if (subscriptionHelper != this) {
                if (subscriptionHelper == SubscriptionHelper.CANCELLED) {
                }
            }
            return;
        } while (!this.f291s.compareAndSet(subscriptionHelper, this));
        countDown();
    }
}
