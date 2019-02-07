package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

public abstract class BlockingBaseSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T> {
    volatile boolean cancelled;
    Throwable error;
    Subscription f290s;
    T value;

    public BlockingBaseSubscriber() {
        super(1);
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f290s, subscription)) {
            this.f290s = subscription;
            if (!this.cancelled) {
                subscription.request(LongCompanionObject.MAX_VALUE);
                if (this.cancelled) {
                    this.f290s = SubscriptionHelper.CANCELLED;
                    subscription.cancel();
                }
            }
        }
    }

    public final void onComplete() {
        countDown();
    }

    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (Throwable e) {
                Subscription subscription = this.f290s;
                this.f290s = SubscriptionHelper.CANCELLED;
                if (subscription != null) {
                    subscription.cancel();
                }
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable e2 = this.error;
        if (e2 == null) {
            return this.value;
        }
        throw ExceptionHelper.wrapOrThrow(e2);
    }
}
