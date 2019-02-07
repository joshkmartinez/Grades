package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkip<T> extends AbstractFlowableWithUpstream<T, T> {
    final long f298n;

    static final class SkipSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> actual;
        long remaining;
        Subscription f261s;

        SkipSubscriber(Subscriber<? super T> subscriber, long j) {
            this.actual = subscriber;
            this.remaining = j;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f261s, subscription)) {
                long j = this.remaining;
                this.f261s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(j);
            }
        }

        public void onNext(T t) {
            if (this.remaining != 0) {
                this.remaining--;
            } else {
                this.actual.onNext(t);
            }
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }

        public void request(long j) {
            this.f261s.request(j);
        }

        public void cancel() {
            this.f261s.cancel();
        }
    }

    public FlowableSkip(Flowable<T> flowable, long j) {
        super(flowable);
        this.f298n = j;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SkipSubscriber(subscriber, this.f298n));
    }
}
