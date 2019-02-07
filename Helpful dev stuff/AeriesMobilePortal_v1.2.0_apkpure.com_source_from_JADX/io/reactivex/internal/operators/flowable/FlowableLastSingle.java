package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableLastSingle<T> extends Single<T> {
    final T defaultItem;
    final Publisher<T> source;

    static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super T> actual;
        final T defaultItem;
        T item;
        Subscription f245s;

        LastSubscriber(SingleObserver<? super T> singleObserver, T t) {
            this.actual = singleObserver;
            this.defaultItem = t;
        }

        public void dispose() {
            this.f245s.cancel();
            this.f245s = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f245s == SubscriptionHelper.CANCELLED;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f245s, subscription)) {
                this.f245s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            this.item = t;
        }

        public void onError(Throwable th) {
            this.f245s = SubscriptionHelper.CANCELLED;
            this.item = null;
            this.actual.onError(th);
        }

        public void onComplete() {
            this.f245s = SubscriptionHelper.CANCELLED;
            Object obj = this.item;
            if (obj != null) {
                this.item = null;
                this.actual.onSuccess(obj);
                return;
            }
            obj = this.defaultItem;
            if (obj != null) {
                this.actual.onSuccess(obj);
            } else {
                this.actual.onError(new NoSuchElementException());
            }
        }
    }

    public FlowableLastSingle(Publisher<T> publisher, T t) {
        this.source = publisher;
        this.defaultItem = t;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new LastSubscriber(singleObserver, this.defaultItem));
    }
}
