package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {
    private Subscription f373s;

    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.validate(this.f373s, subscription, getClass())) {
            this.f373s = subscription;
            onStart();
        }
    }

    protected final void request(long j) {
        Subscription subscription = this.f373s;
        if (subscription != null) {
            subscription.request(j);
        }
    }

    protected final void cancel() {
        Subscription subscription = this.f373s;
        this.f373s = SubscriptionHelper.CANCELLED;
        subscription.cancel();
    }

    protected void onStart() {
        request(LongCompanionObject.MAX_VALUE);
    }
}
