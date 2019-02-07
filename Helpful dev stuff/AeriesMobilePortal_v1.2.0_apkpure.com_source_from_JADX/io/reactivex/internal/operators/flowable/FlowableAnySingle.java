package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

public final class FlowableAnySingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {
    final Predicate<? super T> predicate;
    final Flowable<T> source;

    static final class AnySubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super Boolean> actual;
        boolean done;
        final Predicate<? super T> predicate;
        Subscription f221s;

        AnySubscriber(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.actual = singleObserver;
            this.predicate = predicate;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f221s, subscription)) {
                this.f221s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    if (this.predicate.test(t) != null) {
                        this.done = true;
                        this.f221s.cancel();
                        this.f221s = SubscriptionHelper.CANCELLED;
                        this.actual.onSuccess(Boolean.valueOf(true));
                    }
                } catch (T t2) {
                    Exceptions.throwIfFatal(t2);
                    this.f221s.cancel();
                    this.f221s = SubscriptionHelper.CANCELLED;
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
            this.f221s = SubscriptionHelper.CANCELLED;
            this.actual.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.f221s = SubscriptionHelper.CANCELLED;
                this.actual.onSuccess(Boolean.valueOf(false));
            }
        }

        public void dispose() {
            this.f221s.cancel();
            this.f221s = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f221s == SubscriptionHelper.CANCELLED;
        }
    }

    public FlowableAnySingle(Flowable<T> flowable, Predicate<? super T> predicate) {
        this.source = flowable;
        this.predicate = predicate;
    }

    protected void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.source.subscribe(new AnySubscriber(singleObserver, this.predicate));
    }

    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableAny(this.source, this.predicate));
    }
}
