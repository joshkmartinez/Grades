package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureBuffer<T> extends AbstractFlowableWithUpstream<T, T> {
    final int bufferSize;
    final boolean delayError;
    final Action onOverflow;
    final boolean unbounded;

    static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final Action onOverflow;
        boolean outputFused;
        final SimplePlainQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        Subscription f319s;

        BackpressureBufferSubscriber(Subscriber<? super T> subscriber, int i, boolean z, boolean z2, Action action) {
            this.actual = subscriber;
            this.onOverflow = action;
            this.delayError = z2;
            if (z) {
                subscriber = new SpscLinkedArrayQueue(i);
            } else {
                subscriber = new SpscArrayQueue(i);
            }
            this.queue = subscriber;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f319s, subscription)) {
                this.f319s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (this.queue.offer(t) == null) {
                this.f319s.cancel();
                t = new MissingBackpressureException("Buffer is full");
                try {
                    this.onOverflow.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    t.initCause(th);
                }
                onError(t);
                return;
            }
            if (this.outputFused != null) {
                this.actual.onNext(null);
            } else {
                drain();
            }
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (this.outputFused) {
                this.actual.onError(th);
            } else {
                drain();
            }
        }

        public void onComplete() {
            this.done = true;
            if (this.outputFused) {
                this.actual.onComplete();
            } else {
                drain();
            }
        }

        public void request(long j) {
            if (!this.outputFused && SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.f319s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue simplePlainQueue = this.queue;
                Subscriber subscriber = this.actual;
                int i = 1;
                while (!checkTerminated(this.done, simplePlainQueue.isEmpty(), subscriber)) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z = this.done;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (!checkTerminated(z, z2, subscriber)) {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (j2 != j || !checkTerminated(this.done, simplePlainQueue.isEmpty(), subscriber)) {
                        if (!(j2 == 0 || j == LongCompanionObject.MAX_VALUE)) {
                            this.requested.addAndGet(-j2);
                        }
                        i = addAndGet(-i);
                        if (i == 0) {
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        boolean checkTerminated(boolean z, boolean z2, Subscriber<? super T> subscriber) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (z) {
                if (!this.delayError) {
                    z = this.error;
                    if (z) {
                        this.queue.clear();
                        subscriber.onError(z);
                        return true;
                    } else if (z2) {
                        subscriber.onComplete();
                        return true;
                    }
                } else if (z2) {
                    z = this.error;
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

        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Nullable
        public T poll() throws Exception {
            return this.queue.poll();
        }

        public void clear() {
            this.queue.clear();
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    public FlowableOnBackpressureBuffer(Flowable<T> flowable, int i, boolean z, boolean z2, Action action) {
        super(flowable);
        this.bufferSize = i;
        this.unbounded = z;
        this.delayError = z2;
        this.onOverflow = action;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new BackpressureBufferSubscriber(subscriber, this.bufferSize, this.unbounded, this.delayError, this.onOverflow));
    }
}
