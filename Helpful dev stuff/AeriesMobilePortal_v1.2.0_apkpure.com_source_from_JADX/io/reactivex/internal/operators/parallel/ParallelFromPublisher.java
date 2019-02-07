package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelFromPublisher<T> extends ParallelFlowable<T> {
    final int parallelism;
    final int prefetch;
    final Publisher<? extends T> source;

    static final class ParallelDispatcher<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4470634016609963609L;
        volatile boolean cancelled;
        volatile boolean done;
        final long[] emissions;
        Throwable error;
        int index;
        final int limit;
        final int prefetch;
        int produced;
        SimpleQueue<T> queue;
        final AtomicLongArray requests;
        Subscription f284s;
        int sourceMode;
        final AtomicInteger subscriberCount = new AtomicInteger();
        final Subscriber<? super T>[] subscribers;

        final class RailSubscription implements Subscription {
            final int f185j;
            final int f186m;

            RailSubscription(int i, int i2) {
                this.f185j = i;
                this.f186m = i2;
            }

            public void request(long j) {
                if (SubscriptionHelper.validate(j)) {
                    AtomicLongArray atomicLongArray = ParallelDispatcher.this.requests;
                    long j2;
                    do {
                        j2 = atomicLongArray.get(this.f185j);
                        if (j2 != LongCompanionObject.MAX_VALUE) {
                        } else {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.f185j, j2, BackpressureHelper.addCap(j2, j)));
                    if (ParallelDispatcher.this.subscriberCount.get() == this.f186m) {
                        ParallelDispatcher.this.drain();
                    }
                }
            }

            public void cancel() {
                if (ParallelDispatcher.this.requests.compareAndSet(this.f185j + this.f186m, 0, 1)) {
                    ParallelDispatcher.this.cancel(this.f186m + this.f186m);
                }
            }
        }

        ParallelDispatcher(Subscriber<? super T>[] subscriberArr, int i) {
            this.subscribers = subscriberArr;
            this.prefetch = i;
            this.limit = i - (i >> 2);
            subscriberArr = subscriberArr.length;
            int i2 = subscriberArr + subscriberArr;
            this.requests = new AtomicLongArray(i2 + 1);
            this.requests.lazySet(i2, (long) subscriberArr);
            this.emissions = new long[subscriberArr];
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f284s, subscription)) {
                this.f284s = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        setupSubscribers();
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        setupSubscribers();
                        subscription.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                setupSubscribers();
                subscription.request((long) this.prefetch);
            }
        }

        void setupSubscribers() {
            Subscriber[] subscriberArr = this.subscribers;
            int i = 0;
            int length = subscriberArr.length;
            while (i < length && !this.cancelled) {
                int i2 = i + 1;
                this.subscriberCount.lazySet(i2);
                subscriberArr[i].onSubscribe(new RailSubscription(i, length));
                i = i2;
            }
        }

        public void onNext(T t) {
            if (this.sourceMode == 0 && this.queue.offer(t) == null) {
                this.f284s.cancel();
                onError(new MissingBackpressureException("Queue is full?"));
                return;
            }
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

        void cancel(int i) {
            if (this.requests.decrementAndGet(i) == 0) {
                this.cancelled = true;
                this.f284s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void drainAsync() {
            /*
            r19 = this;
            r1 = r19;
            r0 = r1.queue;
            r2 = r1.subscribers;
            r3 = r1.requests;
            r4 = r1.emissions;
            r5 = 1;
            r6 = r4.length;
            r7 = r1.index;
            r8 = r1.produced;
            r9 = r8;
            r8 = r5;
        L_0x0012:
            r10 = 0;
            r11 = r9;
            r9 = r10;
        L_0x0015:
            r12 = r1.cancelled;
            if (r12 == 0) goto L_0x001d;
        L_0x0019:
            r0.clear();
            return;
        L_0x001d:
            r12 = r1.done;
            if (r12 == 0) goto L_0x0034;
        L_0x0021:
            r13 = r1.error;
            if (r13 == 0) goto L_0x0034;
        L_0x0025:
            r0.clear();
            r0 = r2.length;
        L_0x0029:
            if (r10 >= r0) goto L_0x0033;
        L_0x002b:
            r3 = r2[r10];
            r3.onError(r13);
            r10 = r10 + 1;
            goto L_0x0029;
        L_0x0033:
            return;
        L_0x0034:
            r13 = r0.isEmpty();
            if (r12 == 0) goto L_0x0048;
        L_0x003a:
            if (r13 == 0) goto L_0x0048;
        L_0x003c:
            r0 = r2.length;
        L_0x003d:
            if (r10 >= r0) goto L_0x0047;
        L_0x003f:
            r3 = r2[r10];
            r3.onComplete();
            r10 = r10 + 1;
            goto L_0x003d;
        L_0x0047:
            return;
        L_0x0048:
            if (r13 == 0) goto L_0x004b;
        L_0x004a:
            goto L_0x0067;
        L_0x004b:
            r12 = r3.get(r7);
            r14 = r4[r7];
            r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
            if (r16 == 0) goto L_0x009a;
        L_0x0055:
            r12 = r6 + r7;
            r12 = r3.get(r12);
            r16 = 0;
            r18 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1));
            if (r18 != 0) goto L_0x009a;
        L_0x0061:
            r9 = r0.poll();	 Catch:{ Throwable -> 0x0084 }
            if (r9 != 0) goto L_0x0069;
        L_0x0067:
            r9 = r11;
            goto L_0x00a3;
        L_0x0069:
            r12 = r2[r7];
            r12.onNext(r9);
            r12 = 1;
            r16 = r14 + r12;
            r4[r7] = r16;
            r9 = r11 + 1;
            r11 = r1.limit;
            if (r9 != r11) goto L_0x0081;
        L_0x007a:
            r11 = r1.f284s;
            r12 = (long) r9;
            r11.request(r12);
            r9 = r10;
        L_0x0081:
            r11 = r9;
            r9 = r10;
            goto L_0x009b;
        L_0x0084:
            r0 = move-exception;
            r3 = r0;
            io.reactivex.exceptions.Exceptions.throwIfFatal(r3);
            r0 = r1.f284s;
            r0.cancel();
            r0 = r2.length;
        L_0x008f:
            if (r10 >= r0) goto L_0x0099;
        L_0x0091:
            r4 = r2[r10];
            r4.onError(r3);
            r10 = r10 + 1;
            goto L_0x008f;
        L_0x0099:
            return;
        L_0x009a:
            r9 = r9 + r5;
        L_0x009b:
            r7 = r7 + 1;
            if (r7 != r6) goto L_0x00a0;
        L_0x009f:
            r7 = r10;
        L_0x00a0:
            if (r9 != r6) goto L_0x0015;
        L_0x00a2:
            goto L_0x0067;
        L_0x00a3:
            r10 = r19.get();
            if (r10 != r8) goto L_0x00b5;
        L_0x00a9:
            r1.index = r7;
            r1.produced = r9;
            r8 = -r8;
            r8 = r1.addAndGet(r8);
            if (r8 != 0) goto L_0x0012;
        L_0x00b4:
            return;
        L_0x00b5:
            r8 = r10;
            goto L_0x0012;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelFromPublisher.ParallelDispatcher.drainAsync():void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void drainSync() {
            /*
            r18 = this;
            r1 = r18;
            r0 = r1.queue;
            r2 = r1.subscribers;
            r3 = r1.requests;
            r4 = r1.emissions;
            r5 = 1;
            r6 = r4.length;
            r7 = r1.index;
            r8 = r5;
        L_0x000f:
            r9 = 0;
            r10 = r9;
        L_0x0011:
            r11 = r1.cancelled;
            if (r11 == 0) goto L_0x0019;
        L_0x0015:
            r0.clear();
            return;
        L_0x0019:
            r11 = r0.isEmpty();
            if (r11 == 0) goto L_0x002b;
        L_0x001f:
            r0 = r2.length;
        L_0x0020:
            if (r9 >= r0) goto L_0x002a;
        L_0x0022:
            r3 = r2[r9];
            r3.onComplete();
            r9 = r9 + 1;
            goto L_0x0020;
        L_0x002a:
            return;
        L_0x002b:
            r11 = r3.get(r7);
            r13 = r4[r7];
            r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1));
            if (r15 == 0) goto L_0x0076;
        L_0x0035:
            r11 = r6 + r7;
            r11 = r3.get(r11);
            r15 = 0;
            r17 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1));
            if (r17 != 0) goto L_0x0076;
        L_0x0041:
            r10 = r0.poll();	 Catch:{ Throwable -> 0x0060 }
            if (r10 != 0) goto L_0x0053;
        L_0x0047:
            r0 = r2.length;
        L_0x0048:
            if (r9 >= r0) goto L_0x0052;
        L_0x004a:
            r3 = r2[r9];
            r3.onComplete();
            r9 = r9 + 1;
            goto L_0x0048;
        L_0x0052:
            return;
        L_0x0053:
            r11 = r2[r7];
            r11.onNext(r10);
            r10 = 1;
            r15 = r13 + r10;
            r4[r7] = r15;
            r10 = r9;
            goto L_0x0077;
        L_0x0060:
            r0 = move-exception;
            r3 = r0;
            io.reactivex.exceptions.Exceptions.throwIfFatal(r3);
            r0 = r1.f284s;
            r0.cancel();
            r0 = r2.length;
        L_0x006b:
            if (r9 >= r0) goto L_0x0075;
        L_0x006d:
            r4 = r2[r9];
            r4.onError(r3);
            r9 = r9 + 1;
            goto L_0x006b;
        L_0x0075:
            return;
        L_0x0076:
            r10 = r10 + r5;
        L_0x0077:
            r7 = r7 + 1;
            if (r7 != r6) goto L_0x007c;
        L_0x007b:
            r7 = r9;
        L_0x007c:
            if (r10 != r6) goto L_0x0011;
        L_0x007e:
            r9 = r18.get();
            if (r9 != r8) goto L_0x008e;
        L_0x0084:
            r1.index = r7;
            r8 = -r8;
            r8 = r1.addAndGet(r8);
            if (r8 != 0) goto L_0x000f;
        L_0x008d:
            return;
        L_0x008e:
            r8 = r9;
            goto L_0x000f;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelFromPublisher.ParallelDispatcher.drainSync():void");
        }

        void drain() {
            if (getAndIncrement() == 0) {
                if (this.sourceMode == 1) {
                    drainSync();
                } else {
                    drainAsync();
                }
            }
        }
    }

    public ParallelFromPublisher(Publisher<? extends T> publisher, int i, int i2) {
        this.source = publisher;
        this.parallelism = i;
        this.prefetch = i2;
    }

    public int parallelism() {
        return this.parallelism;
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            this.source.subscribe(new ParallelDispatcher(subscriberArr, this.prefetch));
        }
    }
}
