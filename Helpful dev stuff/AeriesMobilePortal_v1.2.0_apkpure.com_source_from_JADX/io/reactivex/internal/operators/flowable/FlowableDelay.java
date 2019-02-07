package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    static final class DelaySubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> actual;
        final long delay;
        final boolean delayError;
        Subscription f232s;
        final TimeUnit unit;
        final Worker f233w;

        final class OnComplete implements Runnable {
            OnComplete() {
            }

            public void run() {
                try {
                    DelaySubscriber.this.actual.onComplete();
                } finally {
                    DelaySubscriber.this.f233w.dispose();
                }
            }
        }

        final class OnError implements Runnable {
            private final Throwable f24t;

            OnError(Throwable th) {
                this.f24t = th;
            }

            public void run() {
                try {
                    DelaySubscriber.this.actual.onError(this.f24t);
                } finally {
                    DelaySubscriber.this.f233w.dispose();
                }
            }
        }

        final class OnNext implements Runnable {
            private final T f25t;

            OnNext(T t) {
                this.f25t = t;
            }

            public void run() {
                DelaySubscriber.this.actual.onNext(this.f25t);
            }
        }

        DelaySubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Worker worker, boolean z) {
            this.actual = subscriber;
            this.delay = j;
            this.unit = timeUnit;
            this.f233w = worker;
            this.delayError = z;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f232s, subscription)) {
                this.f232s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f233w.schedule(new OnNext(t), this.delay, this.unit);
        }

        public void onError(Throwable th) {
            this.f233w.schedule(new OnError(th), this.delayError != null ? this.delay : 0, this.unit);
        }

        public void onComplete() {
            this.f233w.schedule(new OnComplete(), this.delay, this.unit);
        }

        public void request(long j) {
            this.f232s.request(j);
        }

        public void cancel() {
            this.f232s.cancel();
            this.f233w.dispose();
        }
    }

    public FlowableDelay(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Subscriber subscriber2;
        if (this.delayError) {
            subscriber2 = subscriber;
        } else {
            subscriber2 = new SerializedSubscriber(subscriber);
        }
        this.source.subscribe(new DelaySubscriber(subscriber2, this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }
}
