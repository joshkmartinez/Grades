package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublish<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {
    static final long CANCELLED = Long.MIN_VALUE;
    final int bufferSize;
    final AtomicReference<PublishSubscriber<T>> current;
    final Publisher<T> onSubscribe;
    final Flowable<T> source;

    static final class FlowablePublisher<T> implements Publisher<T> {
        private final int bufferSize;
        private final AtomicReference<PublishSubscriber<T>> curr;

        FlowablePublisher(AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
            this.curr = atomicReference;
            this.bufferSize = i;
        }

        public void subscribe(Subscriber<? super T> subscriber) {
            InnerSubscriber innerSubscriber = new InnerSubscriber(subscriber);
            subscriber.onSubscribe(innerSubscriber);
            while (true) {
                subscriber = (PublishSubscriber) this.curr.get();
                if (subscriber == null || subscriber.isDisposed()) {
                    PublishSubscriber publishSubscriber = new PublishSubscriber(this.curr, this.bufferSize);
                    if (this.curr.compareAndSet(subscriber, publishSubscriber) != null) {
                        subscriber = publishSubscriber;
                    }
                }
                if (subscriber.add(innerSubscriber)) {
                    break;
                }
            }
            if (innerSubscriber.get() == Long.MIN_VALUE) {
                subscriber.remove(innerSubscriber);
            } else {
                innerSubscriber.parent = subscriber;
            }
            subscriber.dispatch();
        }
    }

    static final class InnerSubscriber<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        volatile PublishSubscriber<T> parent;

        InnerSubscriber(Subscriber<? super T> subscriber) {
            this.child = subscriber;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
                j = this.parent;
                if (j != null) {
                    j.dispatch();
                }
            }
        }

        public long produced(long j) {
            return BackpressureHelper.producedCancel(this, j);
        }

        public void cancel() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                PublishSubscriber publishSubscriber = this.parent;
                if (publishSubscriber != null) {
                    publishSubscriber.remove(this);
                    publishSubscriber.dispatch();
                }
            }
        }
    }

    static final class PublishSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscriber[] EMPTY = new InnerSubscriber[0];
        static final InnerSubscriber[] TERMINATED = new InnerSubscriber[0];
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final AtomicReference<PublishSubscriber<T>> current;
        volatile SimpleQueue<T> queue;
        final AtomicReference<Subscription> f250s = new AtomicReference();
        final AtomicBoolean shouldConnect;
        int sourceMode;
        final AtomicReference<InnerSubscriber[]> subscribers = new AtomicReference(EMPTY);
        volatile Object terminalEvent;

        PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
            this.current = atomicReference;
            this.shouldConnect = new AtomicBoolean();
            this.bufferSize = i;
        }

        public void dispose() {
            if (this.subscribers.get() != TERMINATED && ((InnerSubscriber[]) this.subscribers.getAndSet(TERMINATED)) != TERMINATED) {
                this.current.compareAndSet(this, null);
                SubscriptionHelper.cancel(this.f250s);
            }
        }

        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f250s, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.terminalEvent = NotificationLite.complete();
                        dispatch();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request((long) this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                subscription.request((long) this.bufferSize);
            }
        }

        public void onNext(T t) {
            if (this.sourceMode == 0 && this.queue.offer(t) == null) {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            } else {
                dispatch();
            }
        }

        public void onError(Throwable th) {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.error(th);
                dispatch();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.complete();
                dispatch();
            }
        }

        boolean add(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            Object obj;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.subscribers.get();
                if (innerSubscriberArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriberArr.length;
                obj = new InnerSubscriber[(length + 1)];
                System.arraycopy(innerSubscriberArr, 0, obj, 0, length);
                obj[length] = innerSubscriber;
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, obj));
            return true;
        }

        void remove(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            Object obj;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    break;
                }
                int i = -1;
                for (int i2 = 0; i2 < length; i2++) {
                    if (innerSubscriberArr[i2].equals(innerSubscriber)) {
                        i = i2;
                        break;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        obj = EMPTY;
                    } else {
                        Object obj2 = new InnerSubscriber[(length - 1)];
                        System.arraycopy(innerSubscriberArr, 0, obj2, 0, i);
                        System.arraycopy(innerSubscriberArr, i + 1, obj2, i, (length - i) - 1);
                        obj = obj2;
                    }
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, obj));
        }

        boolean checkTerminated(Object obj, boolean z) {
            int i = 0;
            if (obj != null) {
                if (!NotificationLite.isComplete(obj)) {
                    obj = NotificationLite.getError(obj);
                    this.current.compareAndSet(this, null);
                    InnerSubscriber[] innerSubscriberArr = (InnerSubscriber[]) this.subscribers.getAndSet(TERMINATED);
                    if (innerSubscriberArr.length != 0) {
                        int length = innerSubscriberArr.length;
                        while (i < length) {
                            innerSubscriberArr[i].child.onError(obj);
                            i++;
                        }
                    } else {
                        RxJavaPlugins.onError(obj);
                    }
                    return true;
                } else if (z) {
                    this.current.compareAndSet(this, null);
                    InnerSubscriber[] innerSubscriberArr2 = (InnerSubscriber[]) this.subscribers.getAndSet(TERMINATED);
                    z = innerSubscriberArr2.length;
                    boolean z2;
                    while (z2 < z) {
                        innerSubscriberArr2[z2].child.onComplete();
                        z2++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void dispatch() {
            /*
            r21 = this;
            r1 = r21;
            r0 = r21.getAndIncrement();
            if (r0 == 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r2 = 1;
            r3 = r2;
        L_0x000b:
            r0 = r1.terminalEvent;
            r4 = r1.queue;
            if (r4 == 0) goto L_0x001a;
        L_0x0011:
            r6 = r4.isEmpty();
            if (r6 == 0) goto L_0x0018;
        L_0x0017:
            goto L_0x001a;
        L_0x0018:
            r6 = 0;
            goto L_0x001b;
        L_0x001a:
            r6 = r2;
        L_0x001b:
            r0 = r1.checkTerminated(r0, r6);
            if (r0 == 0) goto L_0x0022;
        L_0x0021:
            return;
        L_0x0022:
            if (r6 != 0) goto L_0x0119;
        L_0x0024:
            r0 = r1.subscribers;
            r0 = r0.get();
            r7 = r0;
            r7 = (io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[]) r7;
            r0 = r7.length;
            r8 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r10 = r7.length;
            r11 = r8;
            r8 = 0;
            r9 = 0;
        L_0x0037:
            r13 = 0;
            if (r8 >= r10) goto L_0x005a;
        L_0x003b:
            r15 = r7[r8];
            r16 = r6;
            r5 = r15.get();
            r15 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1));
            if (r15 < 0) goto L_0x004d;
        L_0x0047:
            r5 = java.lang.Math.min(r11, r5);
            r11 = r5;
            goto L_0x0055;
        L_0x004d:
            r13 = -9223372036854775808;
            r15 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1));
            if (r15 != 0) goto L_0x0055;
        L_0x0053:
            r9 = r9 + 1;
        L_0x0055:
            r8 = r8 + 1;
            r6 = r16;
            goto L_0x0037;
        L_0x005a:
            r16 = r6;
            r5 = 1;
            if (r0 != r9) goto L_0x009e;
        L_0x0060:
            r0 = r1.terminalEvent;
            r4 = r4.poll();	 Catch:{ Throwable -> 0x0067 }
            goto L_0x007e;
        L_0x0067:
            r0 = move-exception;
            r4 = r0;
            io.reactivex.exceptions.Exceptions.throwIfFatal(r4);
            r0 = r1.f250s;
            r0 = r0.get();
            r0 = (org.reactivestreams.Subscription) r0;
            r0.cancel();
            r0 = io.reactivex.internal.util.NotificationLite.error(r4);
            r1.terminalEvent = r0;
            r4 = 0;
        L_0x007e:
            if (r4 != 0) goto L_0x0082;
        L_0x0080:
            r4 = r2;
            goto L_0x0083;
        L_0x0082:
            r4 = 0;
        L_0x0083:
            r0 = r1.checkTerminated(r0, r4);
            if (r0 == 0) goto L_0x008a;
        L_0x0089:
            return;
        L_0x008a:
            r0 = r1.sourceMode;
            if (r0 == r2) goto L_0x0099;
        L_0x008e:
            r0 = r1.f250s;
            r0 = r0.get();
            r0 = (org.reactivestreams.Subscription) r0;
            r0.request(r5);
        L_0x0099:
            r4 = r2;
            r17 = r3;
            goto L_0x0111;
        L_0x009e:
            r17 = r3;
            r9 = 0;
        L_0x00a1:
            r2 = (long) r9;
            r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1));
            if (r0 >= 0) goto L_0x00f5;
        L_0x00a6:
            r0 = r1.terminalEvent;
            r10 = r4.poll();	 Catch:{ Throwable -> 0x00ad }
            goto L_0x00c4;
        L_0x00ad:
            r0 = move-exception;
            r10 = r0;
            io.reactivex.exceptions.Exceptions.throwIfFatal(r10);
            r0 = r1.f250s;
            r0 = r0.get();
            r0 = (org.reactivestreams.Subscription) r0;
            r0.cancel();
            r0 = io.reactivex.internal.util.NotificationLite.error(r10);
            r1.terminalEvent = r0;
            r10 = 0;
        L_0x00c4:
            if (r10 != 0) goto L_0x00c8;
        L_0x00c6:
            r15 = 1;
            goto L_0x00c9;
        L_0x00c8:
            r15 = 0;
        L_0x00c9:
            r0 = r1.checkTerminated(r0, r15);
            if (r0 == 0) goto L_0x00d0;
        L_0x00cf:
            return;
        L_0x00d0:
            if (r15 == 0) goto L_0x00d3;
        L_0x00d2:
            goto L_0x00f7;
        L_0x00d3:
            r0 = io.reactivex.internal.util.NotificationLite.getValue(r10);
            r2 = r7.length;
            r3 = 0;
        L_0x00d9:
            if (r3 >= r2) goto L_0x00f0;
        L_0x00db:
            r10 = r7[r3];
            r18 = r10.get();
            r16 = (r18 > r13 ? 1 : (r18 == r13 ? 0 : -1));
            if (r16 <= 0) goto L_0x00ed;
        L_0x00e5:
            r8 = r10.child;
            r8.onNext(r0);
            r10.produced(r5);
        L_0x00ed:
            r3 = r3 + 1;
            goto L_0x00d9;
        L_0x00f0:
            r9 = r9 + 1;
            r16 = r15;
            goto L_0x00a1;
        L_0x00f5:
            r15 = r16;
        L_0x00f7:
            if (r9 <= 0) goto L_0x010a;
        L_0x00f9:
            r0 = r1.sourceMode;
            r4 = 1;
            if (r0 == r4) goto L_0x010b;
        L_0x00fe:
            r0 = r1.f250s;
            r0 = r0.get();
            r0 = (org.reactivestreams.Subscription) r0;
            r0.request(r2);
            goto L_0x010b;
        L_0x010a:
            r4 = 1;
        L_0x010b:
            r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1));
            if (r0 == 0) goto L_0x0116;
        L_0x010f:
            if (r15 != 0) goto L_0x0116;
        L_0x0111:
            r2 = r4;
            r3 = r17;
            goto L_0x000b;
        L_0x0116:
            r2 = r17;
            goto L_0x011b;
        L_0x0119:
            r4 = r2;
            r2 = r3;
        L_0x011b:
            r0 = -r2;
            r3 = r1.addAndGet(r0);
            if (r3 != 0) goto L_0x0123;
        L_0x0122:
            return;
        L_0x0123:
            r2 = r4;
            goto L_0x000b;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber.dispatch():void");
        }
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, int i) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly(new FlowablePublish(new FlowablePublisher(atomicReference, i), flowable, atomicReference, i));
    }

    private FlowablePublish(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
        this.onSubscribe = publisher;
        this.source = flowable;
        this.current = atomicReference;
        this.bufferSize = i;
    }

    public Publisher<T> source() {
        return this.source;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.onSubscribe.subscribe(subscriber);
    }

    public void connect(Consumer<? super Disposable> consumer) {
        FlowableSubscriber flowableSubscriber;
        PublishSubscriber publishSubscriber;
        while (true) {
            flowableSubscriber = (PublishSubscriber) this.current.get();
            if (flowableSubscriber != null && !flowableSubscriber.isDisposed()) {
                break;
            }
            publishSubscriber = new PublishSubscriber(this.current, this.bufferSize);
            if (this.current.compareAndSet(flowableSubscriber, publishSubscriber)) {
                break;
            }
        }
        flowableSubscriber = publishSubscriber;
        boolean z = true;
        if (flowableSubscriber.shouldConnect.get() || !flowableSubscriber.shouldConnect.compareAndSet(false, true)) {
            z = false;
        }
        try {
            consumer.accept(flowableSubscriber);
            if (z) {
                this.source.subscribe(flowableSubscriber);
            }
        } catch (Consumer<? super Disposable> consumer2) {
            Exceptions.throwIfFatal(consumer2);
            consumer2 = ExceptionHelper.wrapOrThrow(consumer2);
        }
    }
}
