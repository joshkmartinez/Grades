package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport.WorkerCallback;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelRunOn<T> extends ParallelFlowable<T> {
    final int prefetch;
    final Scheduler scheduler;
    final ParallelFlowable<? extends T> source;

    final class MultiWorkerCallback implements WorkerCallback {
        final Subscriber<T>[] parents;
        final Subscriber<? super T>[] subscribers;

        MultiWorkerCallback(Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2) {
            this.subscribers = subscriberArr;
            this.parents = subscriberArr2;
        }

        public void onWorker(int i, Worker worker) {
            ParallelRunOn.this.createSubscriber(i, this.subscribers, this.parents, worker);
        }
    }

    static abstract class BaseRunOnSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 9222303586456402150L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final SpscArrayQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        Subscription f287s;
        final Worker worker;

        BaseRunOnSubscriber(int i, SpscArrayQueue<T> spscArrayQueue, Worker worker) {
            this.prefetch = i;
            this.queue = spscArrayQueue;
            this.limit = i - (i >> 2);
            this.worker = worker;
        }

        public final void onNext(T t) {
            if (!this.done) {
                if (this.queue.offer(t) == null) {
                    this.f287s.cancel();
                    onError(new MissingBackpressureException("Queue is full?!"));
                    return;
                }
                schedule();
            }
        }

        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                schedule();
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                schedule();
            }
        }

        public final void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.f287s.cancel();
                this.worker.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        final void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.schedule(this);
            }
        }
    }

    static final class RunOnConditionalSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final ConditionalSubscriber<? super T> actual;

        RunOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, int i, SpscArrayQueue<T> spscArrayQueue, Worker worker) {
            super(i, spscArrayQueue, worker);
            this.actual = conditionalSubscriber;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request((long) this.prefetch);
            }
        }

        public void run() {
            int i = this.consumed;
            SpscArrayQueue spscArrayQueue = this.queue;
            ConditionalSubscriber conditionalSubscriber = this.actual;
            int i2 = this.limit;
            int i3 = 1;
            while (true) {
                int i4;
                long j = r0.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (r0.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    boolean z = r0.done;
                    if (z) {
                        Throwable th = r0.error;
                        if (th != null) {
                            spscArrayQueue.clear();
                            conditionalSubscriber.onError(th);
                            r0.worker.dispose();
                            return;
                        }
                    }
                    Object poll = spscArrayQueue.poll();
                    Object obj = poll == null ? 1 : null;
                    if (z && obj != null) {
                        conditionalSubscriber.onComplete();
                        r0.worker.dispose();
                        return;
                    } else if (obj != null) {
                        break;
                    } else {
                        if (conditionalSubscriber.tryOnNext(poll)) {
                            j2++;
                        }
                        i++;
                        if (i == i2) {
                            i4 = i3;
                            r0.s.request((long) i);
                            i = 0;
                        } else {
                            i4 = i3;
                        }
                        i3 = i4;
                    }
                }
                i4 = i3;
                if (j2 == j) {
                    if (r0.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    } else if (r0.done) {
                        Throwable th2 = r0.error;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            conditionalSubscriber.onError(th2);
                            r0.worker.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            conditionalSubscriber.onComplete();
                            r0.worker.dispose();
                            return;
                        }
                    }
                }
                if (!(j2 == 0 || j == LongCompanionObject.MAX_VALUE)) {
                    r0.requested.addAndGet(-j2);
                }
                int i5 = get();
                i3 = i4;
                if (i5 == i3) {
                    r0.consumed = i;
                    i5 = addAndGet(-i3);
                    if (i5 == 0) {
                        return;
                    }
                }
                i3 = i5;
            }
        }
    }

    static final class RunOnSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final Subscriber<? super T> actual;

        RunOnSubscriber(Subscriber<? super T> subscriber, int i, SpscArrayQueue<T> spscArrayQueue, Worker worker) {
            super(i, spscArrayQueue, worker);
            this.actual = subscriber;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request((long) this.prefetch);
            }
        }

        public void run() {
            int i = this.consumed;
            SpscArrayQueue spscArrayQueue = this.queue;
            Subscriber subscriber = this.actual;
            int i2 = this.limit;
            int i3 = 1;
            while (true) {
                long j = r0.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (r0.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    boolean z = r0.done;
                    if (z) {
                        Throwable th = r0.error;
                        if (th != null) {
                            spscArrayQueue.clear();
                            subscriber.onError(th);
                            r0.worker.dispose();
                            return;
                        }
                    }
                    Object poll = spscArrayQueue.poll();
                    Object obj = poll == null ? 1 : null;
                    if (z && obj != null) {
                        subscriber.onComplete();
                        r0.worker.dispose();
                        return;
                    } else if (obj != null) {
                        break;
                    } else {
                        subscriber.onNext(poll);
                        long j3 = j2 + 1;
                        i++;
                        if (i == i2) {
                            r0.s.request((long) i);
                            i = 0;
                        }
                        j2 = j3;
                    }
                }
                if (j2 == j) {
                    if (r0.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    } else if (r0.done) {
                        Throwable th2 = r0.error;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            subscriber.onError(th2);
                            r0.worker.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            subscriber.onComplete();
                            r0.worker.dispose();
                            return;
                        }
                    }
                }
                if (!(j2 == 0 || j == LongCompanionObject.MAX_VALUE)) {
                    r0.requested.addAndGet(-j2);
                }
                int i4 = get();
                if (i4 == i3) {
                    r0.consumed = i;
                    i3 = addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                } else {
                    i3 = i4;
                }
            }
        }
    }

    public ParallelRunOn(ParallelFlowable<? extends T> parallelFlowable, Scheduler scheduler, int i) {
        this.source = parallelFlowable;
        this.scheduler = scheduler;
        this.prefetch = i;
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            if (this.scheduler instanceof SchedulerMultiWorkerSupport) {
                ((SchedulerMultiWorkerSupport) this.scheduler).createWorkers(length, new MultiWorkerCallback(subscriberArr, subscriberArr2));
            } else {
                for (int i = 0; i < length; i++) {
                    createSubscriber(i, subscriberArr, subscriberArr2, this.scheduler.createWorker());
                }
            }
            this.source.subscribe(subscriberArr2);
        }
    }

    void createSubscriber(int i, Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2, Worker worker) {
        subscriberArr = subscriberArr[i];
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
        if (subscriberArr instanceof ConditionalSubscriber) {
            subscriberArr2[i] = new RunOnConditionalSubscriber((ConditionalSubscriber) subscriberArr, this.prefetch, spscArrayQueue, worker);
        } else {
            subscriberArr2[i] = new RunOnSubscriber(subscriberArr, this.prefetch, spscArrayQueue, worker);
        }
    }

    public int parallelism() {
        return this.source.parallelism();
    }
}
