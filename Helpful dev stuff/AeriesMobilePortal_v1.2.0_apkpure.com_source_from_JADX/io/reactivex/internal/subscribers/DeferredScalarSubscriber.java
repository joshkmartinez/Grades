package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    protected boolean hasValue;
    protected Subscription f354s;

    public DeferredScalarSubscriber(Subscriber<? super R> subscriber) {
        super(subscriber);
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f354s, subscription)) {
            this.f354s = subscription;
            this.actual.onSubscribe(this);
            subscription.request(LongCompanionObject.MAX_VALUE);
        }
    }

    public void onError(Throwable th) {
        this.value = null;
        this.actual.onError(th);
    }

    public void onComplete() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            this.actual.onComplete();
        }
    }

    public void cancel() {
        super.cancel();
        this.f354s.cancel();
    }
}
