package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCount<T> extends AbstractFlowableWithUpstream<T, Long> {

    static final class CountSubscriber extends DeferredScalarSubscription<Long> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 4973004223787171406L;
        long count;
        Subscription f345s;

        CountSubscriber(Subscriber<? super Long> subscriber) {
            super(subscriber);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f345s, subscription)) {
                this.f345s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void onNext(Object obj) {
            this.count++;
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            complete(Long.valueOf(this.count));
        }

        public void cancel() {
            super.cancel();
            this.f345s.cancel();
        }
    }

    public FlowableCount(Flowable<T> flowable) {
        super(flowable);
    }

    protected void subscribeActual(Subscriber<? super Long> subscriber) {
        this.source.subscribe(new CountSubscriber(subscriber));
    }
}
