package io.reactivex.processors;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class UnicastProcessor<T> extends FlowableProcessor<T> {
    final AtomicReference<Subscriber<? super T>> actual;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    boolean enableOperatorFusion;
    Throwable error;
    final AtomicReference<Runnable> onTerminate;
    final AtomicBoolean once;
    final SpscLinkedArrayQueue<T> queue;
    final AtomicLong requested;
    final BasicIntQueueSubscription<T> wip;

    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        UnicastQueueSubscription() {
        }

        @Nullable
        public T poll() {
            return UnicastProcessor.this.queue.poll();
        }

        public boolean isEmpty() {
            return UnicastProcessor.this.queue.isEmpty();
        }

        public void clear() {
            UnicastProcessor.this.queue.clear();
        }

        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.enableOperatorFusion = true;
            return 2;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(UnicastProcessor.this.requested, j);
                UnicastProcessor.this.drain();
            }
        }

        public void cancel() {
            if (!UnicastProcessor.this.cancelled) {
                UnicastProcessor.this.cancelled = true;
                UnicastProcessor.this.doTerminate();
                if (!UnicastProcessor.this.enableOperatorFusion && UnicastProcessor.this.wip.getAndIncrement() == 0) {
                    UnicastProcessor.this.queue.clear();
                    UnicastProcessor.this.actual.lazySet(null);
                }
            }
        }
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create() {
        return new UnicastProcessor(bufferSize());
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i) {
        return new UnicastProcessor(i);
    }

    @CheckReturnValue
    @Experimental
    public static <T> UnicastProcessor<T> create(boolean z) {
        return new UnicastProcessor(bufferSize(), null, z);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i, Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor(i, runnable);
    }

    @CheckReturnValue
    @Experimental
    public static <T> UnicastProcessor<T> create(int i, Runnable runnable, boolean z) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor(i, runnable, z);
    }

    UnicastProcessor(int i) {
        this(i, null, true);
    }

    UnicastProcessor(int i, Runnable runnable) {
        this(i, runnable, true);
    }

    UnicastProcessor(int i, Runnable runnable, boolean z) {
        this.queue = new SpscLinkedArrayQueue(ObjectHelper.verifyPositive(i, "capacityHint"));
        this.onTerminate = new AtomicReference(runnable);
        this.delayError = z;
        this.actual = new AtomicReference();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueSubscription();
        this.requested = new AtomicLong();
    }

    void doTerminate() {
        Runnable runnable = (Runnable) this.onTerminate.get();
        if (runnable != null && this.onTerminate.compareAndSet(runnable, null)) {
            runnable.run();
        }
    }

    void drainRegular(Subscriber<? super T> subscriber) {
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
        boolean z = this.delayError ^ 1;
        int i = 1;
        do {
            long j;
            long j2 = r6.requested.get();
            long j3 = 0;
            while (j2 != j3) {
                boolean z2 = r6.done;
                Object poll = spscLinkedArrayQueue.poll();
                boolean z3 = poll == null;
                j = j3;
                if (!checkTerminated(z, z2, z3, subscriber, spscLinkedArrayQueue)) {
                    if (z3) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j3 = j + 1;
                } else {
                    return;
                }
            }
            j = j3;
            Subscriber<? super T> subscriber2 = subscriber;
            if (j2 == j) {
                if (checkTerminated(z, r6.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
            }
            if (!(j == 0 || j2 == LongCompanionObject.MAX_VALUE)) {
                r6.requested.addAndGet(-j);
            }
            i = r6.wip.addAndGet(-i);
        } while (i != 0);
    }

    void drainFused(Subscriber<? super T> subscriber) {
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
        int i = 1;
        int i2 = this.delayError ^ 1;
        while (!this.cancelled) {
            boolean z = this.done;
            if (i2 == 0 || !z || this.error == null) {
                subscriber.onNext(null);
                if (z) {
                    this.actual.lazySet(null);
                    Throwable th = this.error;
                    if (th != null) {
                        subscriber.onError(th);
                    } else {
                        subscriber.onComplete();
                    }
                    return;
                }
                i = this.wip.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
            spscLinkedArrayQueue.clear();
            this.actual.lazySet(null);
            subscriber.onError(this.error);
            return;
        }
        spscLinkedArrayQueue.clear();
        this.actual.lazySet(null);
    }

    void drain() {
        if (this.wip.getAndIncrement() == 0) {
            int i = 1;
            Subscriber subscriber = (Subscriber) this.actual.get();
            while (subscriber == null) {
                i = this.wip.addAndGet(-i);
                if (i != 0) {
                    subscriber = (Subscriber) this.actual.get();
                } else {
                    return;
                }
            }
            if (this.enableOperatorFusion) {
                drainFused(subscriber);
            } else {
                drainRegular(subscriber);
            }
        }
    }

    boolean checkTerminated(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.cancelled) {
            spscLinkedArrayQueue.clear();
            this.actual.lazySet(null);
            return true;
        }
        if (z2) {
            if (z && this.error) {
                spscLinkedArrayQueue.clear();
                this.actual.lazySet(null);
                subscriber.onError(this.error);
                return true;
            } else if (z3) {
                z = this.error;
                this.actual.lazySet(null);
                if (z) {
                    subscriber.onError(z);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }
        return false;
    }

    public void onSubscribe(Subscription subscription) {
        if (!this.done) {
            if (!this.cancelled) {
                subscription.request(LongCompanionObject.MAX_VALUE);
                return;
            }
        }
        subscription.cancel();
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.done) {
            if (!this.cancelled) {
                this.queue.offer(t);
                drain();
            }
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.done) {
            if (!this.cancelled) {
                this.error = th;
                this.done = true;
                doTerminate();
                drain();
                return;
            }
        }
        RxJavaPlugins.onError(th);
    }

    public void onComplete() {
        if (!this.done) {
            if (!this.cancelled) {
                this.done = true;
                doTerminate();
                drain();
            }
        }
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.once.get() || !this.once.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
            return;
        }
        subscriber.onSubscribe(this.wip);
        this.actual.set(subscriber);
        if (this.cancelled != null) {
            this.actual.lazySet(null);
        } else {
            drain();
        }
    }

    public boolean hasSubscribers() {
        return this.actual.get() != null;
    }

    public Throwable getThrowable() {
        return this.done ? this.error : null;
    }

    public boolean hasComplete() {
        return this.done && this.error == null;
    }

    public boolean hasThrowable() {
        return this.done && this.error != null;
    }
}
