package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;

    static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long index;
        final SwitchMapSubscriber<T, R> parent;
        volatile SimpleQueue<R> queue;

        SwitchMapInnerSubscriber(SwitchMapSubscriber<T, R> switchMapSubscriber, long j, int i) {
            this.parent = switchMapSubscriber;
            this.index = j;
            this.bufferSize = i;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request((long) this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                subscription.request((long) this.bufferSize);
            }
        }

        public void onNext(R r) {
            SwitchMapSubscriber switchMapSubscriber = this.parent;
            if (this.index == switchMapSubscriber.unique) {
                if (this.fusionMode == 0 && this.queue.offer(r) == null) {
                    onError(new MissingBackpressureException("Queue full?!"));
                    return;
                }
                switchMapSubscriber.drain();
            }
        }

        public void onError(Throwable th) {
            SwitchMapSubscriber switchMapSubscriber = this.parent;
            if (this.index == switchMapSubscriber.unique && switchMapSubscriber.error.addThrowable(th)) {
                if (switchMapSubscriber.delayErrors == null) {
                    switchMapSubscriber.f266s.cancel();
                }
                this.done = true;
                switchMapSubscriber.drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onComplete() {
            SwitchMapSubscriber switchMapSubscriber = this.parent;
            if (this.index == switchMapSubscriber.unique) {
                this.done = true;
                switchMapSubscriber.drain();
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }

    static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final SwitchMapInnerSubscriber<Object, Object> CANCELLED = new SwitchMapInnerSubscriber(null, -1, 1);
        private static final long serialVersionUID = -3491074160481096299L;
        final AtomicReference<SwitchMapInnerSubscriber<T, R>> active = new AtomicReference();
        final Subscriber<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final AtomicThrowable error;
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final AtomicLong requested = new AtomicLong();
        Subscription f266s;
        volatile long unique;

        static {
            CANCELLED.cancel();
        }

        SwitchMapSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
            this.actual = subscriber;
            this.mapper = function;
            this.bufferSize = i;
            this.delayErrors = z;
            this.error = new AtomicThrowable();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f266s, subscription)) {
                this.f266s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                long j = this.unique + 1;
                this.unique = j;
                SwitchMapInnerSubscriber switchMapInnerSubscriber = (SwitchMapInnerSubscriber) this.active.get();
                if (switchMapInnerSubscriber != null) {
                    switchMapInnerSubscriber.cancel();
                }
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t), "The publisher returned is null");
                    Subscriber switchMapInnerSubscriber2 = new SwitchMapInnerSubscriber(this, j, this.bufferSize);
                    SwitchMapInnerSubscriber switchMapInnerSubscriber3;
                    do {
                        switchMapInnerSubscriber3 = (SwitchMapInnerSubscriber) this.active.get();
                        if (switchMapInnerSubscriber3 == CANCELLED) {
                            break;
                        }
                    } while (!this.active.compareAndSet(switchMapInnerSubscriber3, switchMapInnerSubscriber2));
                    publisher.subscribe(switchMapInnerSubscriber2);
                } catch (T t2) {
                    Exceptions.throwIfFatal(t2);
                    this.f266s.cancel();
                    onError(t2);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done || !this.error.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (this.delayErrors == null) {
                disposeInner();
            }
            this.done = true;
            drain();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                if (this.unique == 0) {
                    this.f266s.request(LongCompanionObject.MAX_VALUE);
                } else {
                    drain();
                }
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.f266s.cancel();
                disposeInner();
            }
        }

        void disposeInner() {
            if (((SwitchMapInnerSubscriber) this.active.get()) != CANCELLED) {
                SwitchMapInnerSubscriber switchMapInnerSubscriber = (SwitchMapInnerSubscriber) this.active.getAndSet(CANCELLED);
                if (switchMapInnerSubscriber != CANCELLED && switchMapInnerSubscriber != null) {
                    switchMapInnerSubscriber.cancel();
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void drain() {
            /*
            r19 = this;
            r1 = r19;
            r0 = r19.getAndIncrement();
            if (r0 == 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r2 = r1.actual;
            r4 = 1;
        L_0x000c:
            r0 = r1.cancelled;
            r5 = 0;
            if (r0 == 0) goto L_0x0017;
        L_0x0011:
            r0 = r1.active;
            r0.lazySet(r5);
            return;
        L_0x0017:
            r0 = r1.done;
            if (r0 == 0) goto L_0x0062;
        L_0x001b:
            r0 = r1.delayErrors;
            if (r0 == 0) goto L_0x003f;
        L_0x001f:
            r0 = r1.active;
            r0 = r0.get();
            if (r0 != 0) goto L_0x0062;
        L_0x0027:
            r0 = r1.error;
            r0 = r0.get();
            r0 = (java.lang.Throwable) r0;
            if (r0 == 0) goto L_0x003b;
        L_0x0031:
            r0 = r1.error;
            r0 = r0.terminate();
            r2.onError(r0);
            goto L_0x003e;
        L_0x003b:
            r2.onComplete();
        L_0x003e:
            return;
        L_0x003f:
            r0 = r1.error;
            r0 = r0.get();
            r0 = (java.lang.Throwable) r0;
            if (r0 == 0) goto L_0x0056;
        L_0x0049:
            r19.disposeInner();
            r0 = r1.error;
            r0 = r0.terminate();
            r2.onError(r0);
            return;
        L_0x0056:
            r0 = r1.active;
            r0 = r0.get();
            if (r0 != 0) goto L_0x0062;
        L_0x005e:
            r2.onComplete();
            return;
        L_0x0062:
            r0 = r1.active;
            r0 = r0.get();
            r6 = r0;
            r6 = (io.reactivex.internal.operators.flowable.FlowableSwitchMap.SwitchMapInnerSubscriber) r6;
            if (r6 == 0) goto L_0x0071;
        L_0x006d:
            r0 = r6.queue;
            r7 = r0;
            goto L_0x0072;
        L_0x0071:
            r7 = r5;
        L_0x0072:
            if (r7 == 0) goto L_0x0142;
        L_0x0074:
            r0 = r6.done;
            if (r0 == 0) goto L_0x00ad;
        L_0x0078:
            r0 = r1.delayErrors;
            if (r0 != 0) goto L_0x00a0;
        L_0x007c:
            r0 = r1.error;
            r0 = r0.get();
            r0 = (java.lang.Throwable) r0;
            if (r0 == 0) goto L_0x0093;
        L_0x0086:
            r19.disposeInner();
            r0 = r1.error;
            r0 = r0.terminate();
            r2.onError(r0);
            return;
        L_0x0093:
            r0 = r7.isEmpty();
            if (r0 == 0) goto L_0x00ad;
        L_0x0099:
            r0 = r1.active;
            r0.compareAndSet(r6, r5);
            goto L_0x000c;
        L_0x00a0:
            r0 = r7.isEmpty();
            if (r0 == 0) goto L_0x00ad;
        L_0x00a6:
            r0 = r1.active;
            r0.compareAndSet(r6, r5);
            goto L_0x000c;
        L_0x00ad:
            r0 = r1.requested;
            r8 = r0.get();
            r10 = 0;
            r12 = r10;
        L_0x00b6:
            r0 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1));
            r14 = 0;
            if (r0 == 0) goto L_0x011e;
        L_0x00bb:
            r0 = r1.cancelled;
            if (r0 == 0) goto L_0x00c0;
        L_0x00bf:
            return;
        L_0x00c0:
            r0 = r6.done;
            r15 = r7.poll();	 Catch:{ Throwable -> 0x00c7 }
            goto L_0x00d6;
        L_0x00c7:
            r0 = move-exception;
            r15 = r0;
            io.reactivex.exceptions.Exceptions.throwIfFatal(r15);
            r6.cancel();
            r0 = r1.error;
            r0.addThrowable(r15);
            r15 = r5;
            r0 = 1;
        L_0x00d6:
            if (r15 != 0) goto L_0x00db;
        L_0x00d8:
            r16 = 1;
            goto L_0x00dd;
        L_0x00db:
            r16 = r14;
        L_0x00dd:
            r3 = r1.active;
            r3 = r3.get();
            if (r6 == r3) goto L_0x00e7;
        L_0x00e5:
            r14 = 1;
            goto L_0x011e;
        L_0x00e7:
            if (r0 == 0) goto L_0x0111;
        L_0x00e9:
            r0 = r1.delayErrors;
            if (r0 != 0) goto L_0x0109;
        L_0x00ed:
            r0 = r1.error;
            r0 = r0.get();
            r0 = (java.lang.Throwable) r0;
            if (r0 == 0) goto L_0x0101;
        L_0x00f7:
            r0 = r1.error;
            r0 = r0.terminate();
            r2.onError(r0);
            return;
        L_0x0101:
            if (r16 == 0) goto L_0x0111;
        L_0x0103:
            r0 = r1.active;
            r0.compareAndSet(r6, r5);
            goto L_0x00e5;
        L_0x0109:
            if (r16 == 0) goto L_0x0111;
        L_0x010b:
            r0 = r1.active;
            r0.compareAndSet(r6, r5);
            goto L_0x00e5;
        L_0x0111:
            if (r16 == 0) goto L_0x0114;
        L_0x0113:
            goto L_0x011e;
        L_0x0114:
            r2.onNext(r15);
            r14 = 1;
            r17 = r12 + r14;
            r12 = r17;
            goto L_0x00b6;
        L_0x011e:
            r0 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
            if (r0 == 0) goto L_0x013e;
        L_0x0122:
            r0 = r1.cancelled;
            if (r0 != 0) goto L_0x013e;
        L_0x0126:
            r10 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
            if (r0 == 0) goto L_0x0135;
        L_0x012f:
            r0 = r1.requested;
            r7 = -r12;
            r0.addAndGet(r7);
        L_0x0135:
            r0 = r6.get();
            r0 = (org.reactivestreams.Subscription) r0;
            r0.request(r12);
        L_0x013e:
            if (r14 == 0) goto L_0x0142;
        L_0x0140:
            goto L_0x000c;
        L_0x0142:
            r0 = -r4;
            r4 = r1.addAndGet(r0);
            if (r4 != 0) goto L_0x000c;
        L_0x0149:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableSwitchMap.SwitchMapSubscriber.drain():void");
        }
    }

    public FlowableSwitchMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
        super(flowable);
        this.mapper = function;
        this.bufferSize = i;
        this.delayErrors = z;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.source, subscriber, this.mapper)) {
            this.source.subscribe(new SwitchMapSubscriber(subscriber, this.mapper, this.bufferSize, this.delayErrors));
        }
    }
}
