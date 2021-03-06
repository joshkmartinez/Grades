package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {
    final Function<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
    final Publisher<? extends TRight> other;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
    final Function<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;

    static final class JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, JoinSupport {
        static final Integer LEFT_CLOSE = Integer.valueOf(3);
        static final Integer LEFT_VALUE = Integer.valueOf(1);
        static final Integer RIGHT_CLOSE = Integer.valueOf(4);
        static final Integer RIGHT_VALUE = Integer.valueOf(2);
        private static final long serialVersionUID = -6071216598687999801L;
        final AtomicInteger active;
        final Subscriber<? super R> actual;
        volatile boolean cancelled;
        final CompositeDisposable disposables = new CompositeDisposable();
        final AtomicReference<Throwable> error = new AtomicReference();
        final Function<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
        int leftIndex;
        final Map<Integer, TLeft> lefts = new LinkedHashMap();
        final SpscLinkedArrayQueue<Object> queue = new SpscLinkedArrayQueue(Flowable.bufferSize());
        final AtomicLong requested = new AtomicLong();
        final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final Function<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;
        int rightIndex;
        final Map<Integer, TRight> rights = new LinkedHashMap();

        JoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.actual = subscriber;
            this.leftEnd = function;
            this.rightEnd = function2;
            this.resultSelector = biFunction;
            this.active = new AtomicInteger(2);
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        void cancelAll() {
            this.disposables.dispose();
        }

        void errorAll(Subscriber<?> subscriber) {
            Throwable terminate = ExceptionHelper.terminate(this.error);
            this.lefts.clear();
            this.rights.clear();
            subscriber.onError(terminate);
        }

        void fail(Throwable th, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            Exceptions.throwIfFatal(th);
            ExceptionHelper.addThrowable(this.error, th);
            simpleQueue.clear();
            cancelAll();
            errorAll(subscriber);
        }

        void drain() {
            JoinSubscription joinSubscription = this;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = joinSubscription.queue;
                Subscriber subscriber = joinSubscription.actual;
                boolean z = true;
                int i = 1;
                while (!joinSubscription.cancelled) {
                    if (((Throwable) joinSubscription.error.get()) != null) {
                        spscLinkedArrayQueue.clear();
                        cancelAll();
                        errorAll(subscriber);
                        return;
                    }
                    boolean z2 = joinSubscription.active.get() == 0 ? z : false;
                    Integer num = (Integer) spscLinkedArrayQueue.poll();
                    boolean z3 = num == null ? z : false;
                    if (z2 && z3) {
                        joinSubscription.lefts.clear();
                        joinSubscription.rights.clear();
                        joinSubscription.disposables.dispose();
                        subscriber.onComplete();
                        return;
                    } else if (z3) {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        Publisher publisher;
                        Object leftRightEndSubscriber;
                        long j;
                        long j2;
                        if (num == LEFT_VALUE) {
                            int i2 = joinSubscription.leftIndex;
                            joinSubscription.leftIndex = i2 + 1;
                            joinSubscription.lefts.put(Integer.valueOf(i2), poll);
                            try {
                                publisher = (Publisher) ObjectHelper.requireNonNull(joinSubscription.leftEnd.apply(poll), "The leftEnd returned a null Publisher");
                                leftRightEndSubscriber = new LeftRightEndSubscriber(joinSubscription, z, i2);
                                joinSubscription.disposables.add(leftRightEndSubscriber);
                                publisher.subscribe(leftRightEndSubscriber);
                                if (((Throwable) joinSubscription.error.get()) != null) {
                                    spscLinkedArrayQueue.clear();
                                    cancelAll();
                                    errorAll(subscriber);
                                    return;
                                }
                                j = joinSubscription.requested.get();
                                j2 = 0;
                                for (Object apply : joinSubscription.rights.values()) {
                                    try {
                                        Object requireNonNull = ObjectHelper.requireNonNull(joinSubscription.resultSelector.apply(poll, apply), "The resultSelector returned a null value");
                                        if (j2 != j) {
                                            subscriber.onNext(requireNonNull);
                                            j2++;
                                        } else {
                                            ExceptionHelper.addThrowable(joinSubscription.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                            spscLinkedArrayQueue.clear();
                                            cancelAll();
                                            errorAll(subscriber);
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        fail(th, subscriber, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                                if (j2 != 0) {
                                    BackpressureHelper.produced(joinSubscription.requested, j2);
                                }
                            } catch (Throwable th2) {
                                fail(th2, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == RIGHT_VALUE) {
                            int i3 = joinSubscription.rightIndex;
                            joinSubscription.rightIndex = i3 + 1;
                            joinSubscription.rights.put(Integer.valueOf(i3), poll);
                            try {
                                publisher = (Publisher) ObjectHelper.requireNonNull(joinSubscription.rightEnd.apply(poll), "The rightEnd returned a null Publisher");
                                leftRightEndSubscriber = new LeftRightEndSubscriber(joinSubscription, false, i3);
                                joinSubscription.disposables.add(leftRightEndSubscriber);
                                publisher.subscribe(leftRightEndSubscriber);
                                if (((Throwable) joinSubscription.error.get()) != null) {
                                    spscLinkedArrayQueue.clear();
                                    cancelAll();
                                    errorAll(subscriber);
                                    return;
                                }
                                j = joinSubscription.requested.get();
                                j2 = 0;
                                for (Object leftRightEndSubscriber2 : joinSubscription.lefts.values()) {
                                    try {
                                        leftRightEndSubscriber2 = ObjectHelper.requireNonNull(joinSubscription.resultSelector.apply(leftRightEndSubscriber2, poll), "The resultSelector returned a null value");
                                        if (j2 != j) {
                                            subscriber.onNext(leftRightEndSubscriber2);
                                            j2++;
                                        } else {
                                            ExceptionHelper.addThrowable(joinSubscription.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                            spscLinkedArrayQueue.clear();
                                            cancelAll();
                                            errorAll(subscriber);
                                            return;
                                        }
                                    } catch (Throwable th22) {
                                        fail(th22, subscriber, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                                if (j2 != 0) {
                                    BackpressureHelper.produced(joinSubscription.requested, j2);
                                }
                            } catch (Throwable th222) {
                                fail(th222, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == LEFT_CLOSE) {
                            r5 = (LeftRightEndSubscriber) poll;
                            joinSubscription.lefts.remove(Integer.valueOf(r5.index));
                            joinSubscription.disposables.remove(r5);
                        } else if (num == RIGHT_CLOSE) {
                            r5 = (LeftRightEndSubscriber) poll;
                            joinSubscription.rights.remove(Integer.valueOf(r5.index));
                            joinSubscription.disposables.remove(r5);
                        }
                        z = true;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void innerError(Throwable th) {
            if (ExceptionHelper.addThrowable(this.error, th)) {
                this.active.decrementAndGet();
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void innerComplete(LeftRightSubscriber leftRightSubscriber) {
            this.disposables.delete(leftRightSubscriber);
            this.active.decrementAndGet();
            drain();
        }

        public void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            drain();
        }

        public void innerClose(boolean z, LeftRightEndSubscriber leftRightEndSubscriber) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_CLOSE : RIGHT_CLOSE, leftRightEndSubscriber);
            }
            drain();
        }

        public void innerCloseError(Throwable th) {
            if (ExceptionHelper.addThrowable(this.error, th)) {
                drain();
            } else {
                RxJavaPlugins.onError(th);
            }
        }
    }

    public FlowableJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(flowable);
        this.other = publisher;
        this.leftEnd = function;
        this.rightEnd = function2;
        this.resultSelector = biFunction;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        Object joinSubscription = new JoinSubscription(subscriber, this.leftEnd, this.rightEnd, this.resultSelector);
        subscriber.onSubscribe(joinSubscription);
        FlowableSubscriber leftRightSubscriber = new LeftRightSubscriber(joinSubscription, true);
        joinSubscription.disposables.add(leftRightSubscriber);
        Object leftRightSubscriber2 = new LeftRightSubscriber(joinSubscription, false);
        joinSubscription.disposables.add(leftRightSubscriber2);
        this.source.subscribe(leftRightSubscriber);
        this.other.subscribe(leftRightSubscriber2);
    }
}
