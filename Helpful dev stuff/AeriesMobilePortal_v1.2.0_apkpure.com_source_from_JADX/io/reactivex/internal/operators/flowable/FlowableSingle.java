package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSingle<T> extends AbstractFlowableWithUpstream<T, T> {
    final T defaultValue;

    static final class SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5526049321428043809L;
        final T defaultValue;
        boolean done;
        Subscription f348s;

        SingleElementSubscriber(Subscriber<? super T> subscriber, T t) {
            super(subscriber);
            this.defaultValue = t;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f348s, subscription)) {
                this.f348s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.value != null) {
                    this.done = true;
                    this.f348s.cancel();
                    this.actual.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.value = t;
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

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                Object obj = this.value;
                this.value = null;
                if (obj == null) {
                    obj = this.defaultValue;
                }
                if (obj == null) {
                    this.actual.onComplete();
                } else {
                    complete(obj);
                }
            }
        }

        public void cancel() {
            super.cancel();
            this.f348s.cancel();
        }
    }

    public FlowableSingle(Flowable<T> flowable, T t) {
        super(flowable);
        this.defaultValue = t;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SingleElementSubscriber(subscriber, this.defaultValue));
    }
}
