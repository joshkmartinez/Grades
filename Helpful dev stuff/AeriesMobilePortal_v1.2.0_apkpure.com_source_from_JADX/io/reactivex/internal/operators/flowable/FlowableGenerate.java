package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGenerate<T, S> extends Flowable<T> {
    final Consumer<? super S> disposeState;
    final BiFunction<S, Emitter<T>, S> generator;
    final Callable<S> stateSupplier;

    static final class GeneratorSubscription<T, S> extends AtomicLong implements Emitter<T>, Subscription {
        private static final long serialVersionUID = 7565982551505011832L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        final Consumer<? super S> disposeState;
        final BiFunction<S, ? super Emitter<T>, S> generator;
        boolean hasNext;
        S state;
        boolean terminate;

        GeneratorSubscription(Subscriber<? super T> subscriber, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s) {
            this.actual = subscriber;
            this.generator = biFunction;
            this.disposeState = consumer;
            this.state = s;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                Object obj = this.state;
                BiFunction biFunction = this.generator;
                long j2 = j;
                do {
                    j = 0;
                    while (true) {
                        if (j == j2) {
                            j2 = get();
                            if (j == j2) {
                                this.state = obj;
                                j2 = addAndGet(-j);
                            }
                        } else if (this.cancelled) {
                            this.state = null;
                            dispose(obj);
                            return;
                        } else {
                            this.hasNext = false;
                            try {
                                Object apply = biFunction.apply(obj, this);
                                if (this.terminate) {
                                    this.cancelled = true;
                                    this.state = null;
                                    dispose(apply);
                                    return;
                                }
                                obj = apply;
                                j++;
                            } catch (long j3) {
                                Exceptions.throwIfFatal(j3);
                                this.cancelled = true;
                                this.state = null;
                                onError(j3);
                                dispose(obj);
                                return;
                            }
                        }
                    }
                } while (j2 != 0);
            }
        }

        private void dispose(S s) {
            try {
                this.disposeState.accept(s);
            } catch (S s2) {
                Exceptions.throwIfFatal(s2);
                RxJavaPlugins.onError(s2);
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (BackpressureHelper.add(this, 1) == 0) {
                    Object obj = this.state;
                    this.state = null;
                    dispose(obj);
                }
            }
        }

        public void onNext(T t) {
            if (!this.terminate) {
                if (this.hasNext) {
                    onError(new IllegalStateException("onNext already called in this generate turn"));
                } else if (t == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    this.hasNext = true;
                    this.actual.onNext(t);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.terminate) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.terminate = true;
            this.actual.onError(th);
        }

        public void onComplete() {
            if (!this.terminate) {
                this.terminate = true;
                this.actual.onComplete();
            }
        }
    }

    public FlowableGenerate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.stateSupplier = callable;
        this.generator = biFunction;
        this.disposeState = consumer;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            subscriber.onSubscribe(new GeneratorSubscription(subscriber, this.generator, this.disposeState, this.stateSupplier.call()));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
