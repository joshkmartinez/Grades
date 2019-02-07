package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final int bufferSize;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    static final class SkipLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested = new AtomicLong();
        Subscription f263s;
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;

        SkipLastTimedSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
            this.actual = subscriber;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.queue = new SpscLinkedArrayQueue(i);
            this.delayError = z;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f263s, subscription)) {
                this.f263s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            this.queue.offer(Long.valueOf(this.scheduler.now(this.unit)), t);
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.f263s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        void drain() {
            SkipLastTimedSubscriber skipLastTimedSubscriber = this;
            if (getAndIncrement() == 0) {
                Subscriber subscriber = skipLastTimedSubscriber.actual;
                SpscLinkedArrayQueue spscLinkedArrayQueue = skipLastTimedSubscriber.queue;
                boolean z = skipLastTimedSubscriber.delayError;
                TimeUnit timeUnit = skipLastTimedSubscriber.unit;
                Scheduler scheduler = skipLastTimedSubscriber.scheduler;
                long j = skipLastTimedSubscriber.time;
                int i = 1;
                do {
                    long j2 = skipLastTimedSubscriber.requested.get();
                    long j3 = 0;
                    while (j3 != j2) {
                        boolean z2 = skipLastTimedSubscriber.done;
                        Long l = (Long) spscLinkedArrayQueue.peek();
                        boolean z3 = l == null;
                        long now = scheduler.now(timeUnit);
                        if (!z3 && l.longValue() > now - j) {
                            z3 = true;
                        }
                        if (!checkTerminated(z2, z3, subscriber, z)) {
                            if (z3) {
                                break;
                            }
                            spscLinkedArrayQueue.poll();
                            subscriber.onNext(spscLinkedArrayQueue.poll());
                            j3++;
                        } else {
                            return;
                        }
                    }
                    if (j3 != 0) {
                        BackpressureHelper.produced(skipLastTimedSubscriber.requested, j3);
                    }
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }

        boolean checkTerminated(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (z) {
                if (!z3) {
                    z = this.error;
                    if (z) {
                        this.queue.clear();
                        subscriber.onError(z);
                        return true;
                    } else if (z2) {
                        subscriber.onComplete();
                        return true;
                    }
                } else if (z2) {
                    z = this.error;
                    if (z) {
                        subscriber.onError(z);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public FlowableSkipLastTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(flowable);
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSize = i;
        this.delayError = z;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SkipLastTimedSubscriber(subscriber, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }
}
