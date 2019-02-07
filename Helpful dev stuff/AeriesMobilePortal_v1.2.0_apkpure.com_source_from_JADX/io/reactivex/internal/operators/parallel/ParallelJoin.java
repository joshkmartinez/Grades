package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelJoin<T> extends Flowable<T> {
    final boolean delayErrors;
    final int prefetch;
    final ParallelFlowable<? extends T> source;

    static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3100232009247827843L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        final AtomicInteger done = new AtomicInteger();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();
        final JoinInnerSubscriber<T>[] subscribers;

        abstract void drain();

        abstract void onComplete();

        abstract void onError(Throwable th);

        abstract void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t);

        JoinSubscriptionBase(Subscriber<? super T> subscriber, int i, int i2) {
            this.actual = subscriber;
            subscriber = new JoinInnerSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                subscriber[i3] = new JoinInnerSubscriber(this, i2);
            }
            this.subscribers = subscriber;
            this.done.lazySet(i);
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
                cancelAll();
                if (getAndIncrement() == 0) {
                    cleanup();
                }
            }
        }

        void cancelAll() {
            for (JoinInnerSubscriber cancel : this.subscribers) {
                cancel.cancel();
            }
        }

        void cleanup() {
            for (JoinInnerSubscriber joinInnerSubscriber : this.subscribers) {
                joinInnerSubscriber.queue = null;
            }
        }
    }

    static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        final int limit;
        final JoinSubscriptionBase<T> parent;
        final int prefetch;
        long produced;
        volatile SimplePlainQueue<T> queue;

        JoinInnerSubscriber(JoinSubscriptionBase<T> joinSubscriptionBase, int i) {
            this.parent = joinSubscriptionBase;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                subscription.request((long) this.prefetch);
            }
        }

        public void onNext(T t) {
            this.parent.onNext(this, t);
        }

        public void onError(Throwable th) {
            this.parent.onError(th);
        }

        public void onComplete() {
            this.parent.onComplete();
        }

        public void requestOne() {
            long j = this.produced + 1;
            if (j == ((long) this.limit)) {
                this.produced = 0;
                ((Subscription) get()).request(j);
                return;
            }
            this.produced = j;
        }

        public void request(long j) {
            long j2 = this.produced + j;
            if (j2 >= ((long) this.limit)) {
                this.produced = 0;
                ((Subscription) get()).request(j2);
                return;
            }
            this.produced = j2;
        }

        public boolean cancel() {
            return SubscriptionHelper.cancel(this);
        }

        SimplePlainQueue<T> getQueue() {
            SimplePlainQueue<T> simplePlainQueue = this.queue;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            simplePlainQueue = new SpscArrayQueue(this.prefetch);
            this.queue = simplePlainQueue;
            return simplePlainQueue;
        }
    }

    static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        JoinSubscription(Subscriber<? super T> subscriber, int i, int i2) {
            super(subscriber, i, i2);
        }

        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(t);
                    if (this.requested.get() != LongCompanionObject.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1);
                } else if (joinInnerSubscriber.getQueue().offer(t) == null) {
                    cancelAll();
                    joinInnerSubscriber = new MissingBackpressureException("Queue full?!");
                    if (this.errors.compareAndSet(null, joinInnerSubscriber) != null) {
                        this.actual.onError(joinInnerSubscriber);
                    } else {
                        RxJavaPlugins.onError(joinInnerSubscriber);
                    }
                    return;
                }
                if (decrementAndGet() == null) {
                    return;
                }
            } else if (joinInnerSubscriber.getQueue().offer(t) == null) {
                cancelAll();
                onError(new MissingBackpressureException("Queue full?!"));
                return;
            } else if (getAndIncrement() != null) {
                return;
            }
            drainLoop();
        }

        public void onError(Throwable th) {
            if (this.errors.compareAndSet(null, th)) {
                cancelAll();
                drain();
            } else if (th != this.errors.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            JoinInnerSubscriber[] joinInnerSubscriberArr = this.subscribers;
            Subscriber subscriber = this.actual;
            int i = 1;
            while (true) {
                long j;
                long j2 = r0.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    if (r0.cancelled) {
                        cleanup();
                        return;
                    }
                    Throwable th = (Throwable) r0.errors.get();
                    if (th != null) {
                        cleanup();
                        subscriber.onError(th);
                        return;
                    }
                    Object obj = r0.done.get() == 0 ? 1 : null;
                    j = j3;
                    Object obj2 = 1;
                    for (JoinInnerSubscriber joinInnerSubscriber : joinInnerSubscriberArr) {
                        SimplePlainQueue simplePlainQueue = joinInnerSubscriber.queue;
                        if (simplePlainQueue != null) {
                            Object poll = simplePlainQueue.poll();
                            if (poll != null) {
                                subscriber.onNext(poll);
                                joinInnerSubscriber.requestOne();
                                long j4 = j + 1;
                                if (j4 == j2) {
                                    j = j4;
                                    break;
                                } else {
                                    j = j4;
                                    obj2 = null;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    if (obj != null && obj2 != null) {
                        subscriber.onComplete();
                        return;
                    } else if (obj2 != null) {
                        break;
                    } else {
                        j3 = j;
                    }
                }
                j = j3;
                if (j == j2) {
                    if (r0.cancelled) {
                        cleanup();
                        return;
                    }
                    Throwable th2 = (Throwable) r0.errors.get();
                    if (th2 != null) {
                        cleanup();
                        subscriber.onError(th2);
                        return;
                    }
                    Object obj3;
                    Object obj4 = r0.done.get() == 0 ? 1 : null;
                    for (JoinInnerSubscriber joinInnerSubscriber2 : joinInnerSubscriberArr) {
                        SimpleQueue simpleQueue = joinInnerSubscriber2.queue;
                        if (simpleQueue != null && !simpleQueue.isEmpty()) {
                            obj3 = null;
                            break;
                        }
                    }
                    obj3 = 1;
                    if (!(obj4 == null || r16 == null)) {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (!(j == 0 || j2 == LongCompanionObject.MAX_VALUE)) {
                    r0.requested.addAndGet(-j);
                }
                int i2 = get();
                if (i2 == i) {
                    i2 = addAndGet(-i);
                    if (i2 == 0) {
                        return;
                    }
                }
                i = i2;
            }
        }
    }

    static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        JoinSubscriptionDelayError(Subscriber<? super T> subscriber, int i, int i2) {
            super(subscriber, i, i2);
        }

        void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(t);
                    if (this.requested.get() != LongCompanionObject.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1);
                } else if (joinInnerSubscriber.getQueue().offer(t) == null) {
                    joinInnerSubscriber.cancel();
                    this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                    this.done.decrementAndGet();
                    drainLoop();
                    return;
                }
                if (decrementAndGet() == null) {
                    return;
                }
            }
            if (joinInnerSubscriber.getQueue().offer(t) == null && joinInnerSubscriber.cancel() != null) {
                this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                this.done.decrementAndGet();
            }
            if (getAndIncrement() != null) {
                return;
            }
            drainLoop();
        }

        void onError(Throwable th) {
            this.errors.addThrowable(th);
            this.done.decrementAndGet();
            drain();
        }

        void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void drainLoop() {
            /*
            r21 = this;
            r0 = r21;
            r1 = r0.subscribers;
            r3 = r1.length;
            r4 = r0.actual;
            r5 = 1;
        L_0x0008:
            r6 = r0.requested;
            r6 = r6.get();
            r8 = 0;
            r10 = r8;
        L_0x0011:
            r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
            if (r12 == 0) goto L_0x0071;
        L_0x0015:
            r12 = r0.cancelled;
            if (r12 == 0) goto L_0x001d;
        L_0x0019:
            r21.cleanup();
            return;
        L_0x001d:
            r12 = r0.done;
            r12 = r12.get();
            if (r12 != 0) goto L_0x0027;
        L_0x0025:
            r12 = 1;
            goto L_0x0028;
        L_0x0027:
            r12 = 0;
        L_0x0028:
            r14 = r10;
            r10 = 0;
            r11 = 1;
        L_0x002b:
            if (r10 >= r3) goto L_0x0050;
        L_0x002d:
            r2 = r1[r10];
            r13 = r2.queue;
            if (r13 == 0) goto L_0x004d;
        L_0x0033:
            r13 = r13.poll();
            if (r13 == 0) goto L_0x004d;
        L_0x0039:
            r4.onNext(r13);
            r2.requestOne();
            r17 = 1;
            r19 = r14 + r17;
            r2 = (r19 > r6 ? 1 : (r19 == r6 ? 0 : -1));
            if (r2 != 0) goto L_0x004a;
        L_0x0047:
            r14 = r19;
            goto L_0x0072;
        L_0x004a:
            r14 = r19;
            r11 = 0;
        L_0x004d:
            r10 = r10 + 1;
            goto L_0x002b;
        L_0x0050:
            if (r12 == 0) goto L_0x006c;
        L_0x0052:
            if (r11 == 0) goto L_0x006c;
        L_0x0054:
            r1 = r0.errors;
            r1 = r1.get();
            r1 = (java.lang.Throwable) r1;
            if (r1 == 0) goto L_0x0068;
        L_0x005e:
            r1 = r0.errors;
            r1 = r1.terminate();
            r4.onError(r1);
            goto L_0x006b;
        L_0x0068:
            r4.onComplete();
        L_0x006b:
            return;
        L_0x006c:
            if (r11 == 0) goto L_0x006f;
        L_0x006e:
            goto L_0x0072;
        L_0x006f:
            r10 = r14;
            goto L_0x0011;
        L_0x0071:
            r14 = r10;
        L_0x0072:
            r2 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1));
            if (r2 != 0) goto L_0x00bc;
        L_0x0076:
            r2 = r0.cancelled;
            if (r2 == 0) goto L_0x007e;
        L_0x007a:
            r21.cleanup();
            return;
        L_0x007e:
            r2 = r0.done;
            r2 = r2.get();
            if (r2 != 0) goto L_0x0088;
        L_0x0086:
            r2 = 1;
            goto L_0x0089;
        L_0x0088:
            r2 = 0;
        L_0x0089:
            r10 = 0;
        L_0x008a:
            if (r10 >= r3) goto L_0x009e;
        L_0x008c:
            r11 = r1[r10];
            r11 = r11.queue;
            if (r11 == 0) goto L_0x009b;
        L_0x0092:
            r11 = r11.isEmpty();
            if (r11 != 0) goto L_0x009b;
        L_0x0098:
            r16 = 0;
            goto L_0x00a0;
        L_0x009b:
            r10 = r10 + 1;
            goto L_0x008a;
        L_0x009e:
            r16 = 1;
        L_0x00a0:
            if (r2 == 0) goto L_0x00bc;
        L_0x00a2:
            if (r16 == 0) goto L_0x00bc;
        L_0x00a4:
            r1 = r0.errors;
            r1 = r1.get();
            r1 = (java.lang.Throwable) r1;
            if (r1 == 0) goto L_0x00b8;
        L_0x00ae:
            r1 = r0.errors;
            r1 = r1.terminate();
            r4.onError(r1);
            goto L_0x00bb;
        L_0x00b8:
            r4.onComplete();
        L_0x00bb:
            return;
        L_0x00bc:
            r2 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1));
            if (r2 == 0) goto L_0x00cf;
        L_0x00c0:
            r8 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
            if (r2 == 0) goto L_0x00cf;
        L_0x00c9:
            r2 = r0.requested;
            r6 = -r14;
            r2.addAndGet(r6);
        L_0x00cf:
            r2 = r21.get();
            if (r2 != r5) goto L_0x00dd;
        L_0x00d5:
            r2 = -r5;
            r2 = r0.addAndGet(r2);
            if (r2 != 0) goto L_0x00dd;
        L_0x00dc:
            return;
        L_0x00dd:
            r5 = r2;
            goto L_0x0008;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionDelayError.drainLoop():void");
        }
    }

    public ParallelJoin(ParallelFlowable<? extends T> parallelFlowable, int i, boolean z) {
        this.source = parallelFlowable;
        this.prefetch = i;
        this.delayErrors = z;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Object joinSubscriptionDelayError;
        if (this.delayErrors) {
            joinSubscriptionDelayError = new JoinSubscriptionDelayError(subscriber, this.source.parallelism(), this.prefetch);
        } else {
            joinSubscriptionDelayError = new JoinSubscription(subscriber, this.source.parallelism(), this.prefetch);
        }
        subscriber.onSubscribe(joinSubscriptionDelayError);
        this.source.subscribe(joinSubscriptionDelayError.subscribers);
    }
}
