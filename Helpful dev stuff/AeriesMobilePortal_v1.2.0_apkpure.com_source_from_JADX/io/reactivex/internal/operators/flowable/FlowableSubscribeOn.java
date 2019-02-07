package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean nonScheduledRequests;
    final Scheduler scheduler;

    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        final Subscriber<? super T> actual;
        final boolean nonScheduledRequests;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<Subscription> f265s = new AtomicReference();
        Publisher<T> source;
        final Worker worker;

        static final class Request implements Runnable {
            private final long f26n;
            private final Subscription f27s;

            Request(Subscription subscription, long j) {
                this.f27s = subscription;
                this.f26n = j;
            }

            public void run() {
                this.f27s.request(this.f26n);
            }
        }

        SubscribeOnSubscriber(Subscriber<? super T> subscriber, Worker worker, Publisher<T> publisher, boolean z) {
            this.actual = subscriber;
            this.worker = worker;
            this.source = publisher;
            this.nonScheduledRequests = z ^ 1;
        }

        public void run() {
            lazySet(Thread.currentThread());
            Publisher publisher = this.source;
            this.source = null;
            publisher.subscribe(this);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f265s, subscription)) {
                long andSet = this.requested.getAndSet(0);
                if (andSet != 0) {
                    requestUpstream(andSet, subscription);
                }
            }
        }

        public void onNext(T t) {
            this.actual.onNext(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
            this.worker.dispose();
        }

        public void onComplete() {
            this.actual.onComplete();
            this.worker.dispose();
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                Subscription subscription = (Subscription) this.f265s.get();
                if (subscription != null) {
                    requestUpstream(j, subscription);
                    return;
                }
                BackpressureHelper.add(this.requested, j);
                Subscription subscription2 = (Subscription) this.f265s.get();
                if (subscription2 != null) {
                    long andSet = this.requested.getAndSet(0);
                    if (andSet != 0) {
                        requestUpstream(andSet, subscription2);
                    }
                }
            }
        }

        void requestUpstream(long j, Subscription subscription) {
            if (!this.nonScheduledRequests) {
                if (Thread.currentThread() != get()) {
                    this.worker.schedule(new Request(subscription, j));
                    return;
                }
            }
            subscription.request(j);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f265s);
            this.worker.dispose();
        }
    }

    public FlowableSubscribeOn(Flowable<T> flowable, Scheduler scheduler, boolean z) {
        super(flowable);
        this.scheduler = scheduler;
        this.nonScheduledRequests = z;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        Worker createWorker = this.scheduler.createWorker();
        Object subscribeOnSubscriber = new SubscribeOnSubscriber(subscriber, createWorker, this.source, this.nonScheduledRequests);
        subscriber.onSubscribe(subscribeOnSubscriber);
        createWorker.schedule(subscribeOnSubscriber);
    }
}
