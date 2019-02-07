package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableScan<T> extends AbstractFlowableWithUpstream<T, T> {
    final BiFunction<T, T, T> accumulator;

    static final class ScanSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final BiFunction<T, T, T> accumulator;
        final Subscriber<? super T> actual;
        boolean done;
        Subscription f257s;
        T value;

        ScanSubscriber(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
            this.actual = subscriber;
            this.accumulator = biFunction;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f257s, subscription)) {
                this.f257s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                Subscriber subscriber = this.actual;
                Object obj = this.value;
                if (obj == null) {
                    this.value = t;
                    subscriber.onNext(t);
                } else {
                    try {
                        t = ObjectHelper.requireNonNull(this.accumulator.apply(obj, t), "The value returned by the accumulator is null");
                        this.value = t;
                        subscriber.onNext(t);
                    } catch (T t2) {
                        Exceptions.throwIfFatal(t2);
                        this.f257s.cancel();
                        onError(t2);
                    }
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
                this.actual.onComplete();
            }
        }

        public void request(long j) {
            this.f257s.request(j);
        }

        public void cancel() {
            this.f257s.cancel();
        }
    }

    public FlowableScan(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.accumulator = biFunction;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new ScanSubscriber(subscriber, this.accumulator));
    }
}
