package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableLastMaybe<T> extends Maybe<T> {
    final Publisher<T> source;

    static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final MaybeObserver<? super T> actual;
        T item;
        Subscription f244s;

        LastSubscriber(MaybeObserver<? super T> maybeObserver) {
            this.actual = maybeObserver;
        }

        public void dispose() {
            this.f244s.cancel();
            this.f244s = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f244s == SubscriptionHelper.CANCELLED;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f244s, subscription)) {
                this.f244s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            this.item = t;
        }

        public void onError(Throwable th) {
            this.f244s = SubscriptionHelper.CANCELLED;
            this.item = null;
            this.actual.onError(th);
        }

        public void onComplete() {
            this.f244s = SubscriptionHelper.CANCELLED;
            Object obj = this.item;
            if (obj != null) {
                this.item = null;
                this.actual.onSuccess(obj);
                return;
            }
            this.actual.onComplete();
        }
    }

    public FlowableLastMaybe(Publisher<T> publisher) {
        this.source = publisher;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new LastSubscriber(maybeObserver));
    }
}
