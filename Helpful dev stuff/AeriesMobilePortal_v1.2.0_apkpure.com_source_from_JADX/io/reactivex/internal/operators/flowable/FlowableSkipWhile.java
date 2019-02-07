package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipWhile<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> predicate;

    static final class SkipWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> actual;
        boolean notSkipping;
        final Predicate<? super T> predicate;
        Subscription f264s;

        SkipWhileSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            this.actual = subscriber;
            this.predicate = predicate;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f264s, subscription)) {
                this.f264s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (this.notSkipping) {
                this.actual.onNext(t);
            } else {
                try {
                    if (this.predicate.test(t)) {
                        this.f264s.request(1);
                    } else {
                        this.notSkipping = true;
                        this.actual.onNext(t);
                    }
                } catch (T t2) {
                    Exceptions.throwIfFatal(t2);
                    this.f264s.cancel();
                    this.actual.onError(t2);
                }
            }
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }

        public void request(long j) {
            this.f264s.request(j);
        }

        public void cancel() {
            this.f264s.cancel();
        }
    }

    public FlowableSkipWhile(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.predicate = predicate;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SkipWhileSubscriber(subscriber, this.predicate));
    }
}
