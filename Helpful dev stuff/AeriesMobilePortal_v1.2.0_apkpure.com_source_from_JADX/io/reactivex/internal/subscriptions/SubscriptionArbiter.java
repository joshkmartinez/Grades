package io.reactivex.internal.subscriptions;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

public class SubscriptionArbiter extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = -2189523197179400958L;
    Subscription actual;
    volatile boolean cancelled;
    final AtomicLong missedProduced = new AtomicLong();
    final AtomicLong missedRequested = new AtomicLong();
    final AtomicReference<Subscription> missedSubscription = new AtomicReference();
    long requested;
    protected boolean unbounded;

    public final void setSubscription(Subscription subscription) {
        if (this.cancelled) {
            subscription.cancel();
            return;
        }
        ObjectHelper.requireNonNull(subscription, "s is null");
        if (get() == 0 && compareAndSet(0, 1)) {
            Subscription subscription2 = this.actual;
            if (subscription2 != null) {
                subscription2.cancel();
            }
            this.actual = subscription;
            long j = this.requested;
            if (decrementAndGet() != 0) {
                drainLoop();
            }
            if (j != 0) {
                subscription.request(j);
            }
            return;
        }
        subscription = (Subscription) this.missedSubscription.getAndSet(subscription);
        if (subscription != null) {
            subscription.cancel();
        }
        drain();
    }

    public final void request(long j) {
        if (SubscriptionHelper.validate(j) && !this.unbounded) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j2 = this.requested;
                if (j2 != LongCompanionObject.MAX_VALUE) {
                    j2 = BackpressureHelper.addCap(j2, j);
                    this.requested = j2;
                    if (j2 == LongCompanionObject.MAX_VALUE) {
                        this.unbounded = true;
                    }
                }
                Subscription subscription = this.actual;
                if (decrementAndGet() != 0) {
                    drainLoop();
                }
                if (subscription != null) {
                    subscription.request(j);
                }
                return;
            }
            BackpressureHelper.add(this.missedRequested, j);
            drain();
        }
    }

    public final void produced(long j) {
        if (!this.unbounded) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j2 = this.requested;
                if (j2 != LongCompanionObject.MAX_VALUE) {
                    long j3 = j2 - j;
                    j = 0;
                    if (j3 < 0) {
                        SubscriptionHelper.reportMoreProduced(j3);
                    } else {
                        j = j3;
                    }
                    this.requested = j;
                }
                if (decrementAndGet() != null) {
                    drainLoop();
                    return;
                }
                return;
            }
            BackpressureHelper.add(this.missedProduced, j);
            drain();
        }
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            drain();
        }
    }

    final void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    final void drainLoop() {
        SubscriptionArbiter subscriptionArbiter = this;
        Subscription subscription = null;
        int i = 1;
        long j = 0;
        do {
            int i2;
            Subscription subscription2;
            Subscription subscription3 = (Subscription) subscriptionArbiter.missedSubscription.get();
            if (subscription3 != null) {
                subscription3 = (Subscription) subscriptionArbiter.missedSubscription.getAndSet(null);
            }
            long j2 = subscriptionArbiter.missedRequested.get();
            if (j2 != 0) {
                j2 = subscriptionArbiter.missedRequested.getAndSet(0);
            }
            long j3 = subscriptionArbiter.missedProduced.get();
            if (j3 != 0) {
                j3 = subscriptionArbiter.missedProduced.getAndSet(0);
            }
            Subscription subscription4 = subscriptionArbiter.actual;
            if (subscriptionArbiter.cancelled) {
                if (subscription4 != null) {
                    subscription4.cancel();
                    subscriptionArbiter.actual = null;
                }
                if (subscription3 != null) {
                    subscription3.cancel();
                }
                i2 = i;
                subscription2 = subscription;
            } else {
                long j4 = subscriptionArbiter.requested;
                if (j4 != LongCompanionObject.MAX_VALUE) {
                    j4 = BackpressureHelper.addCap(j4, j2);
                    if (j4 != LongCompanionObject.MAX_VALUE) {
                        i2 = i;
                        subscription2 = subscription;
                        long j5 = j4 - j3;
                        if (j5 < 0) {
                            SubscriptionHelper.reportMoreProduced(j5);
                            j5 = 0;
                        }
                        j4 = j5;
                    } else {
                        i2 = i;
                        subscription2 = subscription;
                    }
                    subscriptionArbiter.requested = j4;
                } else {
                    i2 = i;
                    subscription2 = subscription;
                }
                if (subscription3 != null) {
                    if (subscription4 != null) {
                        subscription4.cancel();
                    }
                    subscriptionArbiter.actual = subscription3;
                    if (j4 != 0) {
                        j = BackpressureHelper.addCap(j, j4);
                        subscription = subscription3;
                    }
                } else if (!(subscription4 == null || j2 == 0)) {
                    j = BackpressureHelper.addCap(j, j2);
                    subscription = subscription4;
                }
                i = i2;
                i = addAndGet(-i);
            }
            i = i2;
            subscription = subscription2;
            i = addAndGet(-i);
        } while (i != 0);
        if (j != 0) {
            subscription.request(j);
        }
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }
}
