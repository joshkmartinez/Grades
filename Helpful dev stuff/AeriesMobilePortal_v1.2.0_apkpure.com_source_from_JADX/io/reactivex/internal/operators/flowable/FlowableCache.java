package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.LinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> {
    final AtomicBoolean once = new AtomicBoolean();
    final CacheState<T> state;

    static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long CANCELLED = -1;
        private static final long serialVersionUID = -2557562030197141021L;
        final Subscriber<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        int index;
        final AtomicLong requested = new AtomicLong();
        final CacheState<T> state;

        ReplaySubscription(Subscriber<? super T> subscriber, CacheState<T> cacheState) {
            this.child = subscriber;
            this.state = cacheState;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                long j2;
                do {
                    j2 = this.requested.get();
                    if (j2 != -1) {
                    } else {
                        return;
                    }
                } while (!this.requested.compareAndSet(j2, BackpressureHelper.addCap(j2, j)));
                replay();
            }
        }

        public void cancel() {
            if (this.requested.getAndSet(-1) != -1) {
                this.state.removeChild(this);
            }
        }

        public void replay() {
            ReplaySubscription replaySubscription = this;
            if (getAndIncrement() == 0) {
                Subscriber subscriber = replaySubscription.child;
                AtomicLong atomicLong = replaySubscription.requested;
                int i = 1;
                int i2 = 1;
                while (true) {
                    long j = atomicLong.get();
                    if (j >= 0) {
                        int size = replaySubscription.state.size();
                        if (size != 0) {
                            Object[] objArr = replaySubscription.currentBuffer;
                            if (objArr == null) {
                                objArr = replaySubscription.state.head();
                                replaySubscription.currentBuffer = objArr;
                            }
                            int length = objArr.length - i;
                            int i3 = replaySubscription.index;
                            int i4 = replaySubscription.currentIndexInBuffer;
                            int i5 = 0;
                            while (i3 < size && j > 0) {
                                if (atomicLong.get() != -1) {
                                    if (i4 == length) {
                                        objArr = (Object[]) objArr[length];
                                        i4 = 0;
                                    }
                                    if (!NotificationLite.accept(objArr[i4], subscriber)) {
                                        i4++;
                                        i3++;
                                        i5++;
                                        j--;
                                    } else {
                                        return;
                                    }
                                }
                                return;
                            }
                            if (atomicLong.get() != -1) {
                                if (j == 0) {
                                    Object obj = objArr[i4];
                                    if (NotificationLite.isComplete(obj)) {
                                        subscriber.onComplete();
                                        return;
                                    } else if (NotificationLite.isError(obj)) {
                                        subscriber.onError(NotificationLite.getError(obj));
                                        return;
                                    }
                                }
                                if (i5 != 0) {
                                    BackpressureHelper.producedCancel(atomicLong, (long) i5);
                                }
                                replaySubscription.index = i3;
                                replaySubscription.currentIndexInBuffer = i4;
                                replaySubscription.currentBuffer = objArr;
                            } else {
                                return;
                            }
                        }
                        i2 = addAndGet(-i2);
                        if (i2 != 0) {
                            i = 1;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
        }
    }

    static final class CacheState<T> extends LinkedArrayList implements FlowableSubscriber<T> {
        static final ReplaySubscription[] EMPTY = new ReplaySubscription[0];
        static final ReplaySubscription[] TERMINATED = new ReplaySubscription[0];
        final AtomicReference<Subscription> connection = new AtomicReference();
        volatile boolean isConnected;
        final Flowable<T> source;
        boolean sourceDone;
        final AtomicReference<ReplaySubscription<T>[]> subscribers;

        CacheState(Flowable<T> flowable, int i) {
            super(i);
            this.source = flowable;
            this.subscribers = new AtomicReference(EMPTY);
        }

        public void addChild(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription[] replaySubscriptionArr;
            Object obj;
            do {
                replaySubscriptionArr = (ReplaySubscription[]) this.subscribers.get();
                if (replaySubscriptionArr != TERMINATED) {
                    int length = replaySubscriptionArr.length;
                    obj = new ReplaySubscription[(length + 1)];
                    System.arraycopy(replaySubscriptionArr, 0, obj, 0, length);
                    obj[length] = replaySubscription;
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(replaySubscriptionArr, obj));
        }

        public void removeChild(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription[] replaySubscriptionArr;
            Object obj;
            do {
                replaySubscriptionArr = (ReplaySubscription[]) this.subscribers.get();
                int length = replaySubscriptionArr.length;
                if (length != 0) {
                    int i = -1;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (replaySubscriptionArr[i2].equals(replaySubscription)) {
                            i = i2;
                            break;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            obj = EMPTY;
                        } else {
                            Object obj2 = new ReplaySubscription[(length - 1)];
                            System.arraycopy(replaySubscriptionArr, 0, obj2, 0, i);
                            System.arraycopy(replaySubscriptionArr, i + 1, obj2, i, (length - i) - 1);
                            obj = obj2;
                        }
                    } else {
                        return;
                    }
                }
                return;
            } while (!this.subscribers.compareAndSet(replaySubscriptionArr, obj));
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.connection, subscription)) {
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void connect() {
            this.source.subscribe((FlowableSubscriber) this);
            this.isConnected = true;
        }

        public void onNext(T t) {
            if (!this.sourceDone) {
                add(NotificationLite.next(t));
                for (ReplaySubscription replay : (ReplaySubscription[]) this.subscribers.get()) {
                    replay.replay();
                }
            }
        }

        public void onError(Throwable th) {
            if (this.sourceDone) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.sourceDone = true;
            add(NotificationLite.error(th));
            SubscriptionHelper.cancel(this.connection);
            for (ReplaySubscription replay : (ReplaySubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                replay.replay();
            }
        }

        public void onComplete() {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.complete());
                SubscriptionHelper.cancel(this.connection);
                for (ReplaySubscription replay : (ReplaySubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                    replay.replay();
                }
            }
        }
    }

    public FlowableCache(Flowable<T> flowable, int i) {
        super(flowable);
        this.state = new CacheState(flowable, i);
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Subscription replaySubscription = new ReplaySubscription(subscriber, this.state);
        this.state.addChild(replaySubscription);
        subscriber.onSubscribe(replaySubscription);
        if (this.once.get() == null && this.once.compareAndSet(false, true) != null) {
            this.state.connect();
        }
    }

    boolean isConnected() {
        return this.state.isConnected;
    }

    boolean hasSubscribers() {
        return ((ReplaySubscription[]) this.state.subscribers.get()).length != 0;
    }

    int cachedEventCount() {
        return this.state.size();
    }
}
