package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableReduceSeedSingle<T, R> extends Single<R> {
    final BiFunction<R, ? super T, R> reducer;
    final R seed;
    final Publisher<T> source;

    static final class ReduceSeedObserver<T, R> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super R> actual;
        final BiFunction<R, ? super T, R> reducer;
        Subscription f254s;
        R value;

        ReduceSeedObserver(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r) {
            this.actual = singleObserver;
            this.value = r;
            this.reducer = biFunction;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f254s, subscription)) {
                this.f254s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            try {
                this.value = ObjectHelper.requireNonNull(this.reducer.apply(this.value, t), "The reducer returned a null value");
            } catch (T t2) {
                Exceptions.throwIfFatal(t2);
                this.f254s.cancel();
                onError(t2);
            }
        }

        public void onError(Throwable th) {
            this.value = null;
            this.f254s = SubscriptionHelper.CANCELLED;
            this.actual.onError(th);
        }

        public void onComplete() {
            Object obj = this.value;
            this.value = null;
            this.f254s = SubscriptionHelper.CANCELLED;
            this.actual.onSuccess(obj);
        }

        public void dispose() {
            this.f254s.cancel();
            this.f254s = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f254s == SubscriptionHelper.CANCELLED;
        }
    }

    public FlowableReduceSeedSingle(Publisher<T> publisher, R r, BiFunction<R, ? super T, R> biFunction) {
        this.source = publisher;
        this.seed = r;
        this.reducer = biFunction;
    }

    protected void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.source.subscribe(new ReduceSeedObserver(singleObserver, this.reducer, this.seed));
    }
}
