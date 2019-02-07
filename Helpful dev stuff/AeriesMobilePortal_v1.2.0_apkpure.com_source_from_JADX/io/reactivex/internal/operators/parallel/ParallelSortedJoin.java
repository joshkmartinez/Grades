package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelSortedJoin<T> extends Flowable<T> {
    final Comparator<? super T> comparator;
    final ParallelFlowable<List<T>> source;

    static final class SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3481980673745556697L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        final Comparator<? super T> comparator;
        final AtomicReference<Throwable> error = new AtomicReference();
        final int[] indexes;
        final List<T>[] lists;
        final AtomicInteger remaining = new AtomicInteger();
        final AtomicLong requested = new AtomicLong();
        final SortedJoinInnerSubscriber<T>[] subscribers;

        SortedJoinSubscription(Subscriber<? super T> subscriber, int i, Comparator<? super T> comparator) {
            this.actual = subscriber;
            this.comparator = comparator;
            subscriber = new SortedJoinInnerSubscriber[i];
            for (comparator = null; comparator < i; comparator++) {
                subscriber[comparator] = new SortedJoinInnerSubscriber(this, comparator);
            }
            this.subscribers = subscriber;
            this.lists = new List[i];
            this.indexes = new int[i];
            this.remaining.lazySet(i);
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                if (this.remaining.get() == null) {
                    drain();
                }
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    Arrays.fill(this.lists, null);
                }
            }
        }

        void cancelAll() {
            for (SortedJoinInnerSubscriber cancel : this.subscribers) {
                cancel.cancel();
            }
        }

        void innerNext(List<T> list, int i) {
            this.lists[i] = list;
            if (this.remaining.decrementAndGet() == null) {
                drain();
            }
        }

        void innerError(Throwable th) {
            if (this.error.compareAndSet(null, th)) {
                drain();
            } else if (th != this.error.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        void drain() {
            SortedJoinSubscription sortedJoinSubscription = this;
            if (getAndIncrement() == 0) {
                Subscriber subscriber = sortedJoinSubscription.actual;
                List[] listArr = sortedJoinSubscription.lists;
                int[] iArr = sortedJoinSubscription.indexes;
                int length = iArr.length;
                int i = 1;
                while (true) {
                    int i2;
                    long j = sortedJoinSubscription.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        if (sortedJoinSubscription.cancelled) {
                            Arrays.fill(listArr, null);
                            return;
                        }
                        Throwable th = (Throwable) sortedJoinSubscription.error.get();
                        if (th != null) {
                            cancelAll();
                            Arrays.fill(listArr, null);
                            subscriber.onError(th);
                            return;
                        }
                        int i3 = -1;
                        Object obj = null;
                        for (int i4 = 0; i4 < length; i4++) {
                            List list = listArr[i4];
                            int i5 = iArr[i4];
                            if (list.size() != i5) {
                                Object obj2;
                                if (obj == null) {
                                    obj2 = list.get(i5);
                                } else {
                                    obj2 = list.get(i5);
                                    try {
                                        if ((sortedJoinSubscription.comparator.compare(obj, obj2) > 0 ? 1 : null) != null) {
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        cancelAll();
                                        Arrays.fill(listArr, null);
                                        if (!sortedJoinSubscription.error.compareAndSet(null, th2)) {
                                            RxJavaPlugins.onError(th2);
                                        }
                                        subscriber.onError((Throwable) sortedJoinSubscription.error.get());
                                        return;
                                    }
                                }
                                obj = obj2;
                                i3 = i4;
                            }
                        }
                        if (obj == null) {
                            Arrays.fill(listArr, null);
                            subscriber.onComplete();
                            return;
                        }
                        subscriber.onNext(obj);
                        iArr[i3] = iArr[i3] + 1;
                        j2++;
                    }
                    if (j2 == j) {
                        if (sortedJoinSubscription.cancelled) {
                            Arrays.fill(listArr, null);
                            return;
                        }
                        Throwable th3 = (Throwable) sortedJoinSubscription.error.get();
                        if (th3 != null) {
                            cancelAll();
                            Arrays.fill(listArr, null);
                            subscriber.onError(th3);
                            return;
                        }
                        Object obj3;
                        for (i2 = 0; i2 < length; i2++) {
                            if (iArr[i2] != listArr[i2].size()) {
                                obj3 = null;
                                break;
                            }
                        }
                        obj3 = 1;
                        if (obj3 != null) {
                            Arrays.fill(listArr, null);
                            subscriber.onComplete();
                            return;
                        }
                    }
                    if (!(j2 == 0 || j == LongCompanionObject.MAX_VALUE)) {
                        sortedJoinSubscription.requested.addAndGet(-j2);
                    }
                    i2 = get();
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
    }

    static final class SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        final int index;
        final SortedJoinSubscription<T> parent;

        public void onComplete() {
        }

        SortedJoinInnerSubscriber(SortedJoinSubscription<T> sortedJoinSubscription, int i) {
            this.parent = sortedJoinSubscription;
            this.index = i;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void onNext(List<T> list) {
            this.parent.innerNext(list, this.index);
        }

        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }

    public ParallelSortedJoin(ParallelFlowable<List<T>> parallelFlowable, Comparator<? super T> comparator) {
        this.source = parallelFlowable;
        this.comparator = comparator;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Object sortedJoinSubscription = new SortedJoinSubscription(subscriber, this.source.parallelism(), this.comparator);
        subscriber.onSubscribe(sortedJoinSubscription);
        this.source.subscribe(sortedJoinSubscription.subscribers);
    }
}
