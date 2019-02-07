package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableScanSeed<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final BiFunction<R, ? super T, R> accumulator;
    final Callable<R> seedSupplier;

    static final class ScanSeedSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -1776795561228106469L;
        final BiFunction<R, ? super T, R> accumulator;
        final Subscriber<? super R> actual;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final SimplePlainQueue<R> queue;
        final AtomicLong requested = new AtomicLong();
        Subscription f258s;
        R value;

        ScanSeedSubscriber(Subscriber<? super R> subscriber, BiFunction<R, ? super T, R> biFunction, R r, int i) {
            this.actual = subscriber;
            this.accumulator = biFunction;
            this.value = r;
            this.prefetch = i;
            this.limit = i - (i >> 2);
            this.queue = new SpscArrayQueue(i);
            this.queue.offer(r);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f258s, subscription)) {
                this.f258s = subscription;
                this.actual.onSubscribe(this);
                subscription.request((long) (this.prefetch - 1));
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    t = ObjectHelper.requireNonNull(this.accumulator.apply(this.value, t), "The accumulator returned a null value");
                    this.value = t;
                    this.queue.offer(t);
                    drain();
                } catch (T t2) {
                    Exceptions.throwIfFatal(t2);
                    this.f258s.cancel();
                    onError(t2);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        public void cancel() {
            this.cancelled = true;
            this.f258s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        void drain() {
            ScanSeedSubscriber scanSeedSubscriber = this;
            if (getAndIncrement() == 0) {
                Subscriber subscriber = scanSeedSubscriber.actual;
                SimplePlainQueue simplePlainQueue = scanSeedSubscriber.queue;
                int i = scanSeedSubscriber.limit;
                int i2 = scanSeedSubscriber.consumed;
                int i3 = 1;
                do {
                    long j = scanSeedSubscriber.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        if (scanSeedSubscriber.cancelled) {
                            simplePlainQueue.clear();
                            return;
                        }
                        boolean z = scanSeedSubscriber.done;
                        if (z) {
                            Throwable th = scanSeedSubscriber.error;
                            if (th != null) {
                                simplePlainQueue.clear();
                                subscriber.onError(th);
                                return;
                            }
                        }
                        Object poll = simplePlainQueue.poll();
                        Object obj = poll == null ? 1 : null;
                        if (z && obj != null) {
                            subscriber.onComplete();
                            return;
                        } else if (obj != null) {
                            break;
                        } else {
                            subscriber.onNext(poll);
                            long j3 = j2 + 1;
                            i2++;
                            if (i2 == i) {
                                scanSeedSubscriber.f258s.request((long) i);
                                i2 = 0;
                            }
                            j2 = j3;
                        }
                    }
                    if (j2 == j && scanSeedSubscriber.done) {
                        Throwable th2 = scanSeedSubscriber.error;
                        if (th2 != null) {
                            simplePlainQueue.clear();
                            subscriber.onError(th2);
                            return;
                        } else if (simplePlainQueue.isEmpty()) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    if (j2 != 0) {
                        BackpressureHelper.produced(scanSeedSubscriber.requested, j2);
                    }
                    scanSeedSubscriber.consumed = i2;
                    i3 = addAndGet(-i3);
                } while (i3 != 0);
            }
        }
    }

    public FlowableScanSeed(Flowable<T> flowable, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        super(flowable);
        this.accumulator = biFunction;
        this.seedSupplier = callable;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            this.source.subscribe(new ScanSeedSubscriber(subscriber, this.accumulator, ObjectHelper.requireNonNull(this.seedSupplier.call(), "The seed supplied is null"), Flowable.bufferSize()));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
