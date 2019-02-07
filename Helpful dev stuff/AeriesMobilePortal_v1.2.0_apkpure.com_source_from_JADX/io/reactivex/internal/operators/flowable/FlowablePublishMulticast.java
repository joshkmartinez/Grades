package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublishMulticast<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final boolean delayError;
    final int prefetch;
    final Function<? super Flowable<T>, ? extends Publisher<? extends R>> selector;

    static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 8664815189257569791L;
        final Subscriber<? super T> actual;
        final MulticastProcessor<T> parent;

        MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.actual = subscriber;
            this.parent = multicastProcessor;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
                this.parent.drain();
            }
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.drain();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }
    }

    static final class MulticastProcessor<T> extends Flowable<T> implements FlowableSubscriber<T>, Disposable {
        static final MulticastSubscription[] EMPTY = new MulticastSubscription[0];
        static final MulticastSubscription[] TERMINATED = new MulticastSubscription[0];
        int consumed;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        volatile SimpleQueue<T> queue;
        final AtomicReference<Subscription> f251s = new AtomicReference();
        int sourceMode;
        final AtomicReference<MulticastSubscription<T>[]> subscribers = new AtomicReference(EMPTY);
        final AtomicInteger wip = new AtomicInteger();

        MulticastProcessor(int i, boolean z) {
            this.prefetch = i;
            this.limit = i - (i >> 2);
            this.delayError = z;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f251s, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        QueueDrainHelper.request(subscription, this.prefetch);
                        return;
                    }
                }
                this.queue = QueueDrainHelper.createQueue(this.prefetch);
                QueueDrainHelper.request(subscription, this.prefetch);
            }
        }

        public void dispose() {
            SubscriptionHelper.cancel(this.f251s);
            if (this.wip.getAndIncrement() == 0) {
                SimpleQueue simpleQueue = this.queue;
                if (simpleQueue != null) {
                    simpleQueue.clear();
                }
            }
        }

        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled((Subscription) this.f251s.get());
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode == 0 && this.queue.offer(t) == null) {
                    ((Subscription) this.f251s.get()).cancel();
                    onError(new MissingBackpressureException());
                    return;
                }
                drain();
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

        boolean add(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription[] multicastSubscriptionArr;
            Object obj;
            do {
                multicastSubscriptionArr = (MulticastSubscription[]) this.subscribers.get();
                if (multicastSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = multicastSubscriptionArr.length;
                obj = new MulticastSubscription[(length + 1)];
                System.arraycopy(multicastSubscriptionArr, 0, obj, 0, length);
                obj[length] = multicastSubscription;
            } while (!this.subscribers.compareAndSet(multicastSubscriptionArr, obj));
            return true;
        }

        void remove(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription[] multicastSubscriptionArr;
            Object obj;
            do {
                multicastSubscriptionArr = (MulticastSubscription[]) this.subscribers.get();
                if (multicastSubscriptionArr != TERMINATED) {
                    if (multicastSubscriptionArr != EMPTY) {
                        int length = multicastSubscriptionArr.length;
                        int i = -1;
                        for (int i2 = 0; i2 < length; i2++) {
                            if (multicastSubscriptionArr[i2] == multicastSubscription) {
                                i = i2;
                                break;
                            }
                        }
                        if (i >= 0) {
                            if (length == 1) {
                                obj = EMPTY;
                            } else {
                                Object obj2 = new MulticastSubscription[(length - 1)];
                                System.arraycopy(multicastSubscriptionArr, 0, obj2, 0, i);
                                System.arraycopy(multicastSubscriptionArr, i + 1, obj2, i, (length - i) - 1);
                                obj = obj2;
                            }
                        } else {
                            return;
                        }
                    }
                }
                return;
            } while (!this.subscribers.compareAndSet(multicastSubscriptionArr, obj));
        }

        protected void subscribeActual(Subscriber<? super T> subscriber) {
            MulticastSubscription multicastSubscription = new MulticastSubscription(subscriber, this);
            subscriber.onSubscribe(multicastSubscription);
            if (!add(multicastSubscription)) {
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
            } else if (multicastSubscription.isCancelled() != null) {
                remove(multicastSubscription);
            } else {
                drain();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void drain() {
            /*
            r20 = this;
            r1 = r20;
            r0 = r1.wip;
            r0 = r0.getAndIncrement();
            if (r0 == 0) goto L_0x000b;
        L_0x000a:
            return;
        L_0x000b:
            r0 = r1.queue;
            r2 = r1.consumed;
            r3 = r1.limit;
            r4 = r1.sourceMode;
            r6 = 1;
            if (r4 == r6) goto L_0x0018;
        L_0x0016:
            r4 = r6;
            goto L_0x0019;
        L_0x0018:
            r4 = 0;
        L_0x0019:
            r7 = r2;
            r2 = r6;
        L_0x001b:
            r8 = r1.subscribers;
            r8 = r8.get();
            r8 = (io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r8;
            r9 = r8.length;
            if (r0 == 0) goto L_0x0108;
        L_0x0026:
            if (r9 == 0) goto L_0x0108;
        L_0x0028:
            r9 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r11 = r8.length;
            r12 = r9;
            r9 = 0;
        L_0x0030:
            r14 = -9223372036854775808;
            if (r9 >= r11) goto L_0x0047;
        L_0x0034:
            r10 = r8[r9];
            r16 = r10.get();
            r10 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1));
            if (r10 == 0) goto L_0x0044;
        L_0x003e:
            r10 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1));
            if (r10 <= 0) goto L_0x0044;
        L_0x0042:
            r12 = r16;
        L_0x0044:
            r9 = r9 + 1;
            goto L_0x0030;
        L_0x0047:
            r9 = 0;
        L_0x0049:
            r11 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1));
            if (r11 == 0) goto L_0x00ca;
        L_0x004d:
            r11 = r20.isDisposed();
            if (r11 == 0) goto L_0x0057;
        L_0x0053:
            r0.clear();
            return;
        L_0x0057:
            r11 = r1.done;
            if (r11 == 0) goto L_0x0067;
        L_0x005b:
            r5 = r1.delayError;
            if (r5 != 0) goto L_0x0067;
        L_0x005f:
            r5 = r1.error;
            if (r5 == 0) goto L_0x0067;
        L_0x0063:
            r1.errorAll(r5);
            return;
        L_0x0067:
            r5 = r0.poll();	 Catch:{ Throwable -> 0x00bc }
            if (r5 != 0) goto L_0x0070;
        L_0x006d:
            r16 = r6;
            goto L_0x0072;
        L_0x0070:
            r16 = 0;
        L_0x0072:
            if (r11 == 0) goto L_0x0082;
        L_0x0074:
            if (r16 == 0) goto L_0x0082;
        L_0x0076:
            r0 = r1.error;
            if (r0 == 0) goto L_0x007e;
        L_0x007a:
            r1.errorAll(r0);
            goto L_0x0081;
        L_0x007e:
            r20.completeAll();
        L_0x0081:
            return;
        L_0x0082:
            if (r16 == 0) goto L_0x0085;
        L_0x0084:
            goto L_0x00ca;
        L_0x0085:
            r11 = r8.length;
            r6 = 0;
        L_0x0087:
            if (r6 >= r11) goto L_0x009f;
        L_0x0089:
            r18 = r11;
            r11 = r8[r6];
            r16 = r11.get();
            r19 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1));
            if (r19 == 0) goto L_0x009a;
        L_0x0095:
            r11 = r11.actual;
            r11.onNext(r5);
        L_0x009a:
            r6 = r6 + 1;
            r11 = r18;
            goto L_0x0087;
        L_0x009f:
            r5 = 1;
            r16 = r9 + r5;
            if (r4 == 0) goto L_0x00b8;
        L_0x00a5:
            r5 = r7 + 1;
            if (r5 != r3) goto L_0x00b7;
        L_0x00a9:
            r5 = r1.f251s;
            r5 = r5.get();
            r5 = (org.reactivestreams.Subscription) r5;
            r6 = (long) r3;
            r5.request(r6);
            r7 = 0;
            goto L_0x00b8;
        L_0x00b7:
            r7 = r5;
        L_0x00b8:
            r9 = r16;
            r6 = 1;
            goto L_0x0049;
        L_0x00bc:
            r0 = move-exception;
            r2 = r0;
            io.reactivex.exceptions.Exceptions.throwIfFatal(r2);
            r0 = r1.f251s;
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(r0);
            r1.errorAll(r2);
            return;
        L_0x00ca:
            r5 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1));
            if (r5 != 0) goto L_0x00fc;
        L_0x00ce:
            r5 = r20.isDisposed();
            if (r5 == 0) goto L_0x00d8;
        L_0x00d4:
            r0.clear();
            return;
        L_0x00d8:
            r5 = r1.done;
            if (r5 == 0) goto L_0x00e8;
        L_0x00dc:
            r6 = r1.delayError;
            if (r6 != 0) goto L_0x00e8;
        L_0x00e0:
            r6 = r1.error;
            if (r6 == 0) goto L_0x00e8;
        L_0x00e4:
            r1.errorAll(r6);
            return;
        L_0x00e8:
            if (r5 == 0) goto L_0x00fc;
        L_0x00ea:
            r5 = r0.isEmpty();
            if (r5 == 0) goto L_0x00fc;
        L_0x00f0:
            r0 = r1.error;
            if (r0 == 0) goto L_0x00f8;
        L_0x00f4:
            r1.errorAll(r0);
            goto L_0x00fb;
        L_0x00f8:
            r20.completeAll();
        L_0x00fb:
            return;
        L_0x00fc:
            r5 = r8.length;
            r6 = 0;
        L_0x00fe:
            if (r6 >= r5) goto L_0x0108;
        L_0x0100:
            r11 = r8[r6];
            io.reactivex.internal.util.BackpressureHelper.produced(r11, r9);
            r6 = r6 + 1;
            goto L_0x00fe;
        L_0x0108:
            r1.consumed = r7;
            r5 = r1.wip;
            r2 = -r2;
            r2 = r5.addAndGet(r2);
            if (r2 != 0) goto L_0x0114;
        L_0x0113:
            return;
        L_0x0114:
            if (r0 != 0) goto L_0x0118;
        L_0x0116:
            r0 = r1.queue;
        L_0x0118:
            r6 = 1;
            goto L_0x001b;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastProcessor.drain():void");
        }

        void errorAll(Throwable th) {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.actual.onError(th);
                }
            }
        }

        void completeAll() {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.actual.onComplete();
                }
            }
        }
    }

    static final class OutputCanceller<R> implements FlowableSubscriber<R>, Subscription {
        final Subscriber<? super R> actual;
        final MulticastProcessor<?> processor;
        Subscription f252s;

        OutputCanceller(Subscriber<? super R> subscriber, MulticastProcessor<?> multicastProcessor) {
            this.actual = subscriber;
            this.processor = multicastProcessor;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f252s, subscription)) {
                this.f252s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(R r) {
            this.actual.onNext(r);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
            this.processor.dispose();
        }

        public void onComplete() {
            this.actual.onComplete();
            this.processor.dispose();
        }

        public void request(long j) {
            this.f252s.request(j);
        }

        public void cancel() {
            this.f252s.cancel();
            this.processor.dispose();
        }
    }

    public FlowablePublishMulticast(Flowable<T> flowable, Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i, boolean z) {
        super(flowable);
        this.selector = function;
        this.prefetch = i;
        this.delayError = z;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        FlowableSubscriber multicastProcessor = new MulticastProcessor(this.prefetch, this.delayError);
        try {
            ((Publisher) ObjectHelper.requireNonNull(this.selector.apply(multicastProcessor), "selector returned a null Publisher")).subscribe(new OutputCanceller(subscriber, multicastProcessor));
            this.source.subscribe(multicastProcessor);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
