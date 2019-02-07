package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;

    static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        final Subscriber<? super R> actual;
        volatile boolean cancelled;
        volatile InnerQueuedSubscriber<R> current;
        volatile boolean done;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        final AtomicLong requested = new AtomicLong();
        Subscription f228s;
        final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> subscribers;

        ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode) {
            this.actual = subscriber;
            this.mapper = function;
            this.maxConcurrency = i;
            this.prefetch = i2;
            this.errorMode = errorMode;
            this.subscribers = new SpscLinkedArrayQueue(Math.min(i2, i));
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f228s, subscription)) {
                this.f228s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(this.maxConcurrency == Integer.MAX_VALUE ? LongCompanionObject.MAX_VALUE : (long) this.maxConcurrency);
            }
        }

        public void onNext(T t) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher");
                Object innerQueuedSubscriber = new InnerQueuedSubscriber(this, this.prefetch);
                if (!this.cancelled) {
                    this.subscribers.offer(innerQueuedSubscriber);
                    if (!this.cancelled) {
                        publisher.subscribe(innerQueuedSubscriber);
                        if (this.cancelled != null) {
                            innerQueuedSubscriber.cancel();
                            drainAndCancel();
                        }
                    }
                }
            } catch (T t2) {
                Exceptions.throwIfFatal(t2);
                this.f228s.cancel();
                onError(t2);
            }
        }

        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.f228s.cancel();
                drainAndCancel();
            }
        }

        void drainAndCancel() {
            if (getAndIncrement() == 0) {
                do {
                    cancelAll();
                } while (decrementAndGet() != 0);
            }
        }

        void cancelAll() {
            while (true) {
                InnerQueuedSubscriber innerQueuedSubscriber = (InnerQueuedSubscriber) this.subscribers.poll();
                if (innerQueuedSubscriber != null) {
                    innerQueuedSubscriber.cancel();
                } else {
                    return;
                }
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r) {
            if (innerQueuedSubscriber.queue().offer(r) != null) {
                drain();
                return;
            }
            innerQueuedSubscriber.cancel();
            innerError(innerQueuedSubscriber, new MissingBackpressureException());
        }

        public void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th) {
            if (this.errors.addThrowable(th)) {
                innerQueuedSubscriber.setDone();
                if (this.errorMode != ErrorMode.END) {
                    this.f228s.cancel();
                }
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
            innerQueuedSubscriber.setDone();
            drain();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain() {
            /*
            r20 = this;
            r1 = r20;
            r0 = r20.getAndIncrement();
            if (r0 == 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r0 = r1.current;
            r2 = r1.actual;
            r3 = r1.errorMode;
            r5 = 1;
        L_0x0010:
            r6 = r1.requested;
            r6 = r6.get();
            if (r0 != 0) goto L_0x0056;
        L_0x0018:
            r0 = io.reactivex.internal.util.ErrorMode.END;
            if (r3 == r0) goto L_0x0033;
        L_0x001c:
            r0 = r1.errors;
            r0 = r0.get();
            r0 = (java.lang.Throwable) r0;
            if (r0 == 0) goto L_0x0033;
        L_0x0026:
            r20.cancelAll();
            r0 = r1.errors;
            r0 = r0.terminate();
            r2.onError(r0);
            return;
        L_0x0033:
            r0 = r1.done;
            r8 = r1.subscribers;
            r8 = r8.poll();
            r8 = (io.reactivex.internal.subscribers.InnerQueuedSubscriber) r8;
            if (r0 == 0) goto L_0x0051;
        L_0x003f:
            if (r8 != 0) goto L_0x0051;
        L_0x0041:
            r0 = r1.errors;
            r0 = r0.terminate();
            if (r0 == 0) goto L_0x004d;
        L_0x0049:
            r2.onError(r0);
            goto L_0x0050;
        L_0x004d:
            r2.onComplete();
        L_0x0050:
            return;
        L_0x0051:
            if (r8 == 0) goto L_0x0057;
        L_0x0053:
            r1.current = r8;
            goto L_0x0057;
        L_0x0056:
            r8 = r0;
        L_0x0057:
            r9 = 0;
            r11 = 0;
            if (r8 == 0) goto L_0x0119;
        L_0x005c:
            r12 = r8.queue();
            if (r12 == 0) goto L_0x0119;
        L_0x0062:
            r13 = r9;
        L_0x0063:
            r15 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1));
            r16 = r5;
            r4 = 1;
            if (r15 == 0) goto L_0x00d2;
        L_0x006b:
            r15 = r1.cancelled;
            if (r15 == 0) goto L_0x0073;
        L_0x006f:
            r20.cancelAll();
            return;
        L_0x0073:
            r15 = io.reactivex.internal.util.ErrorMode.IMMEDIATE;
            if (r3 != r15) goto L_0x0093;
        L_0x0077:
            r15 = r1.errors;
            r15 = r15.get();
            r15 = (java.lang.Throwable) r15;
            if (r15 == 0) goto L_0x0093;
        L_0x0081:
            r1.current = r11;
            r8.cancel();
            r20.cancelAll();
            r0 = r1.errors;
            r0 = r0.terminate();
            r2.onError(r0);
            return;
        L_0x0093:
            r15 = r8.isDone();
            r0 = r12.poll();	 Catch:{ Throwable -> 0x00c1 }
            if (r0 != 0) goto L_0x00a0;
        L_0x009d:
            r18 = 1;
            goto L_0x00a2;
        L_0x00a0:
            r18 = 0;
        L_0x00a2:
            if (r15 == 0) goto L_0x00b1;
        L_0x00a4:
            if (r18 == 0) goto L_0x00b1;
        L_0x00a6:
            r1.current = r11;
            r0 = r1.f228s;
            r0.request(r4);
            r8 = r11;
            r17 = 1;
            goto L_0x00d4;
        L_0x00b1:
            if (r18 == 0) goto L_0x00b4;
        L_0x00b3:
            goto L_0x00d2;
        L_0x00b4:
            r2.onNext(r0);
            r18 = r13 + r4;
            r8.requestOne();
            r5 = r16;
            r13 = r18;
            goto L_0x0063;
        L_0x00c1:
            r0 = move-exception;
            r3 = r0;
            io.reactivex.exceptions.Exceptions.throwIfFatal(r3);
            r1.current = r11;
            r8.cancel();
            r20.cancelAll();
            r2.onError(r3);
            return;
        L_0x00d2:
            r17 = 0;
        L_0x00d4:
            r0 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1));
            if (r0 != 0) goto L_0x0117;
        L_0x00d8:
            r0 = r1.cancelled;
            if (r0 == 0) goto L_0x00e0;
        L_0x00dc:
            r20.cancelAll();
            return;
        L_0x00e0:
            r0 = io.reactivex.internal.util.ErrorMode.IMMEDIATE;
            if (r3 != r0) goto L_0x0100;
        L_0x00e4:
            r0 = r1.errors;
            r0 = r0.get();
            r0 = (java.lang.Throwable) r0;
            if (r0 == 0) goto L_0x0100;
        L_0x00ee:
            r1.current = r11;
            r8.cancel();
            r20.cancelAll();
            r0 = r1.errors;
            r0 = r0.terminate();
            r2.onError(r0);
            return;
        L_0x0100:
            r0 = r8.isDone();
            r12 = r12.isEmpty();
            if (r0 == 0) goto L_0x0117;
        L_0x010a:
            if (r12 == 0) goto L_0x0117;
        L_0x010c:
            r1.current = r11;
            r0 = r1.f228s;
            r0.request(r4);
            r0 = r11;
            r17 = 1;
            goto L_0x011f;
        L_0x0117:
            r0 = r8;
            goto L_0x011f;
        L_0x0119:
            r16 = r5;
            r0 = r8;
            r13 = r9;
            r17 = 0;
        L_0x011f:
            r4 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1));
            if (r4 == 0) goto L_0x0132;
        L_0x0123:
            r4 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
            if (r8 == 0) goto L_0x0132;
        L_0x012c:
            r4 = r1.requested;
            r5 = -r13;
            r4.addAndGet(r5);
        L_0x0132:
            if (r17 == 0) goto L_0x0138;
        L_0x0134:
            r5 = r16;
            goto L_0x0010;
        L_0x0138:
            r4 = r16;
            r4 = -r4;
            r5 = r1.addAndGet(r4);
            if (r5 != 0) goto L_0x0010;
        L_0x0141:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber.drain():void");
        }
    }

    public FlowableConcatMapEager(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode) {
        super(flowable);
        this.mapper = function;
        this.maxConcurrency = i;
        this.prefetch = i2;
        this.errorMode = errorMode;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe(new ConcatMapEagerDelayErrorSubscriber(subscriber, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }
}
