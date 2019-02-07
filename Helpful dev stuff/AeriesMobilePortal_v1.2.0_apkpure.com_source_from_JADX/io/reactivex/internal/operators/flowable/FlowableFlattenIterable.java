package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlattenIterable<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;

    static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3096000382929934955L;
        final Subscriber<? super R> actual;
        volatile boolean cancelled;
        int consumed;
        Iterator<? extends R> current;
        volatile boolean done;
        final AtomicReference<Throwable> error = new AtomicReference();
        int fusionMode;
        final int limit;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        final int prefetch;
        SimpleQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        Subscription f316s;

        FlattenIterableSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
            this.actual = subscriber;
            this.mapper = function;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f316s, subscription)) {
                this.f316s = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.actual.onSubscribe(this);
                        subscription.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.actual.onSubscribe(this);
                subscription.request((long) this.prefetch);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.fusionMode == 0 && this.queue.offer(t) == null) {
                    onError(new MissingBackpressureException("Queue is full?!"));
                } else {
                    drain();
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done || !ExceptionHelper.addThrowable(this.error, th)) {
                RxJavaPlugins.onError(th);
                return;
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
                drain();
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.f316s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        void drain() {
            Throwable th;
            FlattenIterableSubscriber flattenIterableSubscriber = this;
            if (getAndIncrement() == 0) {
                Subscriber subscriber = flattenIterableSubscriber.actual;
                SimpleQueue simpleQueue = flattenIterableSubscriber.queue;
                boolean z = true;
                boolean z2 = flattenIterableSubscriber.fusionMode != 1;
                Iterator it = flattenIterableSubscriber.current;
                int i = 1;
                while (true) {
                    if (it == null) {
                        boolean z3 = flattenIterableSubscriber.done;
                        try {
                            Object poll = simpleQueue.poll();
                            if (!checkTerminated(z3, poll == null ? z : false, subscriber, simpleQueue)) {
                                if (poll != null) {
                                    try {
                                        it = ((Iterable) flattenIterableSubscriber.mapper.apply(poll)).iterator();
                                        if (it.hasNext()) {
                                            flattenIterableSubscriber.current = it;
                                        } else {
                                            consumedOne(z2);
                                            it = null;
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        flattenIterableSubscriber.f316s.cancel();
                                        ExceptionHelper.addThrowable(flattenIterableSubscriber.error, th2);
                                        subscriber.onError(ExceptionHelper.terminate(flattenIterableSubscriber.error));
                                        return;
                                    }
                                }
                            }
                            return;
                        } catch (Throwable th22) {
                            Throwable th3 = th22;
                            Exceptions.throwIfFatal(th3);
                            flattenIterableSubscriber.f316s.cancel();
                            ExceptionHelper.addThrowable(flattenIterableSubscriber.error, th3);
                            th22 = ExceptionHelper.terminate(flattenIterableSubscriber.error);
                            flattenIterableSubscriber.current = null;
                            simpleQueue.clear();
                            subscriber.onError(th22);
                            return;
                        }
                    }
                    if (it != null) {
                        long j = flattenIterableSubscriber.requested.get();
                        long j2 = 0;
                        while (j2 != j) {
                            if (!checkTerminated(flattenIterableSubscriber.done, false, subscriber, simpleQueue)) {
                                try {
                                    subscriber.onNext(ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value"));
                                    if (!checkTerminated(flattenIterableSubscriber.done, false, subscriber, simpleQueue)) {
                                        long j3 = j2 + 1;
                                        try {
                                            if (!it.hasNext()) {
                                                consumedOne(z2);
                                                flattenIterableSubscriber.current = null;
                                                it = null;
                                                j2 = j3;
                                                break;
                                            }
                                            j2 = j3;
                                        } catch (Throwable th222) {
                                            Throwable th4 = th222;
                                            Exceptions.throwIfFatal(th4);
                                            flattenIterableSubscriber.current = null;
                                            flattenIterableSubscriber.f316s.cancel();
                                            ExceptionHelper.addThrowable(flattenIterableSubscriber.error, th4);
                                            subscriber.onError(ExceptionHelper.terminate(flattenIterableSubscriber.error));
                                            return;
                                        }
                                    }
                                    return;
                                } catch (Throwable th2222) {
                                    Exceptions.throwIfFatal(th2222);
                                    flattenIterableSubscriber.current = null;
                                    flattenIterableSubscriber.f316s.cancel();
                                    ExceptionHelper.addThrowable(flattenIterableSubscriber.error, th2222);
                                    subscriber.onError(ExceptionHelper.terminate(flattenIterableSubscriber.error));
                                    return;
                                }
                            }
                            return;
                        }
                        if (j2 == j) {
                            z = flattenIterableSubscriber.done;
                            boolean z4 = simpleQueue.isEmpty() && it == null;
                            if (checkTerminated(z, z4, subscriber, simpleQueue)) {
                                return;
                            }
                        }
                        if (!(j2 == 0 || j == LongCompanionObject.MAX_VALUE)) {
                            flattenIterableSubscriber.requested.addAndGet(-j2);
                        }
                        if (it == null) {
                            z = true;
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                    z = true;
                }
            }
        }

        void consumedOne(boolean z) {
            if (z) {
                z = this.consumed + 1;
                if (z == this.limit) {
                    this.consumed = 0;
                    this.f316s.request((long) z);
                    return;
                }
                this.consumed = z;
            }
        }

        boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            if (this.cancelled) {
                this.current = null;
                simpleQueue.clear();
                return true;
            }
            if (z) {
                if (((Throwable) this.error.get()) != null) {
                    z = ExceptionHelper.terminate(this.error);
                    this.current = null;
                    simpleQueue.clear();
                    subscriber.onError(z);
                    return true;
                } else if (z2) {
                    subscriber.onComplete();
                    return true;
                }
            }
            return false;
        }

        public void clear() {
            this.current = null;
            this.queue.clear();
        }

        public boolean isEmpty() {
            Iterator it = this.current;
            if (it == null) {
                return this.queue.isEmpty();
            }
            return it.hasNext() ^ 1;
        }

        @Nullable
        public R poll() throws Exception {
            Iterator it = this.current;
            while (it == null) {
                Object poll = this.queue.poll();
                if (poll != null) {
                    it = ((Iterable) this.mapper.apply(poll)).iterator();
                    if (it.hasNext()) {
                        this.current = it;
                        break;
                    }
                    it = null;
                } else {
                    return null;
                }
            }
            R requireNonNull = ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.current = null;
            }
            return requireNonNull;
        }

        public int requestFusion(int i) {
            return ((i & 1) == 0 || this.fusionMode != 1) ? 0 : 1;
        }
    }

    public FlowableFlattenIterable(Flowable<T> flowable, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
        super(flowable);
        this.mapper = function;
        this.prefetch = i;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (this.source instanceof Callable) {
            try {
                Object call = ((Callable) this.source).call();
                if (call == null) {
                    EmptySubscription.complete(subscriber);
                    return;
                }
                try {
                    FlowableFromIterable.subscribe(subscriber, ((Iterable) this.mapper.apply(call)).iterator());
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, subscriber);
                    return;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, subscriber);
                return;
            }
        }
        this.source.subscribe(new FlattenIterableSubscriber(subscriber, this.mapper, this.prefetch));
    }
}
