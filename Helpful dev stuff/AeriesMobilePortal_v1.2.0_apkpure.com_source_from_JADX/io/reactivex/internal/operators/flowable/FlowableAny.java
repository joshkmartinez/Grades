package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableAny<T> extends AbstractFlowableWithUpstream<T, Boolean> {
    final Predicate<? super T> predicate;

    static final class AnySubscriber<T> extends DeferredScalarSubscription<Boolean> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -2311252482644620661L;
        boolean done;
        final Predicate<? super T> predicate;
        Subscription f342s;

        AnySubscriber(Subscriber<? super Boolean> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.predicate = predicate;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f342s, subscription)) {
                this.f342s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    if (this.predicate.test(t) != null) {
                        this.done = true;
                        this.f342s.cancel();
                        complete(Boolean.valueOf(true));
                    }
                } catch (T t2) {
                    Exceptions.throwIfFatal(t2);
                    this.f342s.cancel();
                    onError(t2);
                }
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
                complete(Boolean.valueOf(false));
            }
        }

        public void cancel() {
            super.cancel();
            this.f342s.cancel();
        }
    }

    public FlowableAny(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.predicate = predicate;
    }

    protected void subscribeActual(Subscriber<? super Boolean> subscriber) {
        this.source.subscribe(new AnySubscriber(subscriber, this.predicate));
    }
}
