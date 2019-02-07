package io.reactivex.processors;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class BehaviorProcessor<T> extends FlowableProcessor<T> {
    static final BehaviorSubscription[] EMPTY = new BehaviorSubscription[0];
    static final Object[] EMPTY_ARRAY = new Object[0];
    static final BehaviorSubscription[] TERMINATED = new BehaviorSubscription[0];
    long index;
    final ReadWriteLock lock;
    final Lock readLock;
    final AtomicReference<BehaviorSubscription<T>[]> subscribers;
    final AtomicReference<Throwable> terminalEvent;
    final AtomicReference<Object> value;
    final Lock writeLock;

    static final class BehaviorSubscription<T> extends AtomicLong implements Subscription, NonThrowingPredicate<Object> {
        private static final long serialVersionUID = 3293175281126227086L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        AppendOnlyLinkedArrayList<Object> queue;
        final BehaviorProcessor<T> state;

        BehaviorSubscription(Subscriber<? super T> subscriber, BehaviorProcessor<T> behaviorProcessor) {
            this.actual = subscriber;
            this.state = behaviorProcessor;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this, j);
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.remove(this);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void emitFirst() {
            /*
            r4 = this;
            r0 = r4.cancelled;
            if (r0 == 0) goto L_0x0005;
        L_0x0004:
            return;
        L_0x0005:
            monitor-enter(r4);
            r0 = r4.cancelled;	 Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x000c;
        L_0x000a:
            monitor-exit(r4);	 Catch:{ all -> 0x003e }
            return;
        L_0x000c:
            r0 = r4.next;	 Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x0012;
        L_0x0010:
            monitor-exit(r4);	 Catch:{ all -> 0x003e }
            return;
        L_0x0012:
            r0 = r4.state;	 Catch:{ all -> 0x003e }
            r1 = r0.readLock;	 Catch:{ all -> 0x003e }
            r1.lock();	 Catch:{ all -> 0x003e }
            r2 = r0.index;	 Catch:{ all -> 0x003e }
            r4.index = r2;	 Catch:{ all -> 0x003e }
            r0 = r0.value;	 Catch:{ all -> 0x003e }
            r0 = r0.get();	 Catch:{ all -> 0x003e }
            r1.unlock();	 Catch:{ all -> 0x003e }
            r1 = 1;
            if (r0 == 0) goto L_0x002b;
        L_0x0029:
            r2 = r1;
            goto L_0x002c;
        L_0x002b:
            r2 = 0;
        L_0x002c:
            r4.emitting = r2;	 Catch:{ all -> 0x003e }
            r4.next = r1;	 Catch:{ all -> 0x003e }
            monitor-exit(r4);	 Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x003d;
        L_0x0033:
            r0 = r4.test(r0);
            if (r0 == 0) goto L_0x003a;
        L_0x0039:
            return;
        L_0x003a:
            r4.emitLoop();
        L_0x003d:
            return;
        L_0x003e:
            r0 = move-exception;
            monitor-exit(r4);	 Catch:{ all -> 0x003e }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.BehaviorProcessor.BehaviorSubscription.emitFirst():void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void emitNext(java.lang.Object r4, long r5) {
            /*
            r3 = this;
            r0 = r3.cancelled;
            if (r0 == 0) goto L_0x0005;
        L_0x0004:
            return;
        L_0x0005:
            r0 = r3.fastPath;
            if (r0 != 0) goto L_0x0037;
        L_0x0009:
            monitor-enter(r3);
            r0 = r3.cancelled;	 Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0010;
        L_0x000e:
            monitor-exit(r3);	 Catch:{ all -> 0x0034 }
            return;
        L_0x0010:
            r0 = r3.index;	 Catch:{ all -> 0x0034 }
            r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
            if (r2 != 0) goto L_0x0018;
        L_0x0016:
            monitor-exit(r3);	 Catch:{ all -> 0x0034 }
            return;
        L_0x0018:
            r5 = r3.emitting;	 Catch:{ all -> 0x0034 }
            if (r5 == 0) goto L_0x002d;
        L_0x001c:
            r5 = r3.queue;	 Catch:{ all -> 0x0034 }
            if (r5 != 0) goto L_0x0028;
        L_0x0020:
            r5 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList;	 Catch:{ all -> 0x0034 }
            r6 = 4;
            r5.<init>(r6);	 Catch:{ all -> 0x0034 }
            r3.queue = r5;	 Catch:{ all -> 0x0034 }
        L_0x0028:
            r5.add(r4);	 Catch:{ all -> 0x0034 }
            monitor-exit(r3);	 Catch:{ all -> 0x0034 }
            return;
        L_0x002d:
            r5 = 1;
            r3.next = r5;	 Catch:{ all -> 0x0034 }
            monitor-exit(r3);	 Catch:{ all -> 0x0034 }
            r3.fastPath = r5;
            goto L_0x0037;
        L_0x0034:
            r4 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0034 }
            throw r4;
        L_0x0037:
            r3.test(r4);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.BehaviorProcessor.BehaviorSubscription.emitNext(java.lang.Object, long):void");
        }

        public boolean test(Object obj) {
            if (this.cancelled) {
                return true;
            }
            if (NotificationLite.isComplete(obj)) {
                this.actual.onComplete();
                return true;
            } else if (NotificationLite.isError(obj)) {
                this.actual.onError(NotificationLite.getError(obj));
                return true;
            } else {
                long j = get();
                if (j != 0) {
                    this.actual.onNext(NotificationLite.getValue(obj));
                    if (j != LongCompanionObject.MAX_VALUE) {
                        decrementAndGet();
                    }
                    return null;
                }
                cancel();
                this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                return true;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void emitLoop() {
            /*
            r2 = this;
        L_0x0000:
            r0 = r2.cancelled;
            if (r0 == 0) goto L_0x0005;
        L_0x0004:
            return;
        L_0x0005:
            monitor-enter(r2);
            r0 = r2.queue;	 Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x000f;
        L_0x000a:
            r0 = 0;
            r2.emitting = r0;	 Catch:{ all -> 0x0017 }
            monitor-exit(r2);	 Catch:{ all -> 0x0017 }
            return;
        L_0x000f:
            r1 = 0;
            r2.queue = r1;	 Catch:{ all -> 0x0017 }
            monitor-exit(r2);	 Catch:{ all -> 0x0017 }
            r0.forEachWhile(r2);
            goto L_0x0000;
        L_0x0017:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0017 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.BehaviorProcessor.BehaviorSubscription.emitLoop():void");
        }

        public boolean isFull() {
            return get() == 0;
        }
    }

    @CheckReturnValue
    public static <T> BehaviorProcessor<T> create() {
        return new BehaviorProcessor();
    }

    @CheckReturnValue
    public static <T> BehaviorProcessor<T> createDefault(T t) {
        ObjectHelper.requireNonNull(t, "defaultValue is null");
        return new BehaviorProcessor(t);
    }

    BehaviorProcessor() {
        this.value = new AtomicReference();
        this.lock = new ReentrantReadWriteLock();
        this.readLock = this.lock.readLock();
        this.writeLock = this.lock.writeLock();
        this.subscribers = new AtomicReference(EMPTY);
        this.terminalEvent = new AtomicReference();
    }

    BehaviorProcessor(T t) {
        this();
        this.value.lazySet(ObjectHelper.requireNonNull(t, "defaultValue is null"));
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        BehaviorSubscription behaviorSubscription = new BehaviorSubscription(subscriber, this);
        subscriber.onSubscribe(behaviorSubscription);
        if (!add(behaviorSubscription)) {
            Throwable th = (Throwable) this.terminalEvent.get();
            if (th == ExceptionHelper.TERMINATED) {
                subscriber.onComplete();
            } else {
                subscriber.onError(th);
            }
        } else if (behaviorSubscription.cancelled != null) {
            remove(behaviorSubscription);
        } else {
            behaviorSubscription.emitFirst();
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (this.terminalEvent.get() != null) {
            subscription.cancel();
        } else {
            subscription.request(LongCompanionObject.MAX_VALUE);
        }
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.terminalEvent.get() == null) {
            t = NotificationLite.next(t);
            setCurrent(t);
            for (BehaviorSubscription emitNext : (BehaviorSubscription[]) this.subscribers.get()) {
                emitNext.emitNext(t, this.index);
            }
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.terminalEvent.compareAndSet(null, th)) {
            th = NotificationLite.error(th);
            for (BehaviorSubscription emitNext : terminate(th)) {
                emitNext.emitNext(th, this.index);
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    public void onComplete() {
        if (this.terminalEvent.compareAndSet(null, ExceptionHelper.TERMINATED)) {
            Object complete = NotificationLite.complete();
            for (BehaviorSubscription emitNext : terminate(complete)) {
                emitNext.emitNext(complete, this.index);
            }
        }
    }

    @Experimental
    public boolean offer(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return true;
        }
        BehaviorSubscription[] behaviorSubscriptionArr = (BehaviorSubscription[]) this.subscribers.get();
        int i = 0;
        for (BehaviorSubscription isFull : behaviorSubscriptionArr) {
            if (isFull.isFull()) {
                return false;
            }
        }
        t = NotificationLite.next(t);
        setCurrent(t);
        int length = behaviorSubscriptionArr.length;
        while (i < length) {
            behaviorSubscriptionArr[i].emitNext(t, this.index);
            i++;
        }
        return true;
    }

    public boolean hasSubscribers() {
        return ((BehaviorSubscription[]) this.subscribers.get()).length != 0;
    }

    int subscriberCount() {
        return ((BehaviorSubscription[]) this.subscribers.get()).length;
    }

    public Throwable getThrowable() {
        Object obj = this.value.get();
        return NotificationLite.isError(obj) ? NotificationLite.getError(obj) : null;
    }

    public T getValue() {
        Object obj = this.value.get();
        if (!NotificationLite.isComplete(obj)) {
            if (!NotificationLite.isError(obj)) {
                return NotificationLite.getValue(obj);
            }
        }
        return null;
    }

    public Object[] getValues() {
        Object[] values = getValues(EMPTY_ARRAY);
        return values == EMPTY_ARRAY ? new Object[0] : values;
    }

    public T[] getValues(T[] tArr) {
        Object obj = this.value.get();
        if (!(obj == null || NotificationLite.isComplete(obj))) {
            if (!NotificationLite.isError(obj)) {
                obj = NotificationLite.getValue(obj);
                if (tArr.length != 0) {
                    tArr[0] = obj;
                    if (tArr.length != 1) {
                        tArr[1] = null;
                    }
                } else {
                    tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1);
                    tArr[0] = obj;
                }
                return tArr;
            }
        }
        if (tArr.length != 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    public boolean hasComplete() {
        return NotificationLite.isComplete(this.value.get());
    }

    public boolean hasThrowable() {
        return NotificationLite.isError(this.value.get());
    }

    public boolean hasValue() {
        Object obj = this.value.get();
        return (obj == null || NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? false : true;
    }

    boolean add(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription[] behaviorSubscriptionArr;
        Object obj;
        do {
            behaviorSubscriptionArr = (BehaviorSubscription[]) this.subscribers.get();
            if (behaviorSubscriptionArr == TERMINATED) {
                return false;
            }
            int length = behaviorSubscriptionArr.length;
            obj = new BehaviorSubscription[(length + 1)];
            System.arraycopy(behaviorSubscriptionArr, 0, obj, 0, length);
            obj[length] = behaviorSubscription;
        } while (!this.subscribers.compareAndSet(behaviorSubscriptionArr, obj));
        return true;
    }

    void remove(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription[] behaviorSubscriptionArr;
        Object obj;
        do {
            behaviorSubscriptionArr = (BehaviorSubscription[]) this.subscribers.get();
            if (behaviorSubscriptionArr != TERMINATED) {
                if (behaviorSubscriptionArr != EMPTY) {
                    int length = behaviorSubscriptionArr.length;
                    int i = -1;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (behaviorSubscriptionArr[i2] == behaviorSubscription) {
                            i = i2;
                            break;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            obj = EMPTY;
                        } else {
                            Object obj2 = new BehaviorSubscription[(length - 1)];
                            System.arraycopy(behaviorSubscriptionArr, 0, obj2, 0, i);
                            System.arraycopy(behaviorSubscriptionArr, i + 1, obj2, i, (length - i) - 1);
                            obj = obj2;
                        }
                    } else {
                        return;
                    }
                }
            }
            return;
        } while (!this.subscribers.compareAndSet(behaviorSubscriptionArr, obj));
    }

    BehaviorSubscription<T>[] terminate(Object obj) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr = (BehaviorSubscription[]) this.subscribers.get();
        if (behaviorSubscriptionArr != TERMINATED) {
            behaviorSubscriptionArr = (BehaviorSubscription[]) this.subscribers.getAndSet(TERMINATED);
            if (behaviorSubscriptionArr != TERMINATED) {
                setCurrent(obj);
            }
        }
        return behaviorSubscriptionArr;
    }

    void setCurrent(Object obj) {
        Lock lock = this.writeLock;
        lock.lock();
        this.index++;
        this.value.lazySet(obj);
        lock.unlock();
    }
}
