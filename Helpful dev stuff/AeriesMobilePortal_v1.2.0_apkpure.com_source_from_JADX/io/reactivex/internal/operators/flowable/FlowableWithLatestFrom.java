package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWithLatestFrom<T, U, R> extends AbstractFlowableWithUpstream<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    final Publisher<? extends U> other;

    final class FlowableWithLatestSubscriber implements FlowableSubscriber<U> {
        private final WithLatestFromSubscriber<T, U, R> wlf;

        public void onComplete() {
        }

        FlowableWithLatestSubscriber(WithLatestFromSubscriber<T, U, R> withLatestFromSubscriber) {
            this.wlf = withLatestFromSubscriber;
        }

        public void onSubscribe(Subscription subscription) {
            if (this.wlf.setOther(subscription)) {
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void onNext(U u) {
            this.wlf.lazySet(u);
        }

        public void onError(Throwable th) {
            this.wlf.otherError(th);
        }
    }

    static final class WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = -312246233408980075L;
        final Subscriber<? super R> actual;
        final BiFunction<? super T, ? super U, ? extends R> combiner;
        final AtomicReference<Subscription> other = new AtomicReference();
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<Subscription> f301s = new AtomicReference();

        WithLatestFromSubscriber(Subscriber<? super R> subscriber, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.actual = subscriber;
            this.combiner = biFunction;
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f301s, this.requested, subscription);
        }

        public void onNext(T t) {
            if (tryOnNext(t) == null) {
                ((Subscription) this.f301s.get()).request(1);
            }
        }

        public boolean tryOnNext(T t) {
            Object obj = get();
            if (obj == null) {
                return false;
            }
            try {
                this.actual.onNext(ObjectHelper.requireNonNull(this.combiner.apply(t, obj), "The combiner returned a null value"));
                return true;
            } catch (T t2) {
                Exceptions.throwIfFatal(t2);
                cancel();
                this.actual.onError(t2);
                return false;
            }
        }

        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.other);
            this.actual.onError(th);
        }

        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            this.actual.onComplete();
        }

        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.f301s, this.requested, j);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f301s);
            SubscriptionHelper.cancel(this.other);
        }

        public boolean setOther(Subscription subscription) {
            return SubscriptionHelper.setOnce(this.other, subscription);
        }

        public void otherError(Throwable th) {
            SubscriptionHelper.cancel(this.f301s);
            this.actual.onError(th);
        }
    }

    public FlowableWithLatestFrom(Flowable<T> flowable, BiFunction<? super T, ? super U, ? extends R> biFunction, Publisher<? extends U> publisher) {
        super(flowable);
        this.combiner = biFunction;
        this.other = publisher;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        Object serializedSubscriber = new SerializedSubscriber(subscriber);
        FlowableSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(serializedSubscriber, this.combiner);
        serializedSubscriber.onSubscribe(withLatestFromSubscriber);
        this.other.subscribe(new FlowableWithLatestSubscriber(withLatestFromSubscriber));
        this.source.subscribe(withLatestFromSubscriber);
    }
}
