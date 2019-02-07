package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelDoOnNextTry<T> extends ParallelFlowable<T> {
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    final Consumer<? super T> onNext;
    final ParallelFlowable<T> source;

    static final class ParallelDoOnNextConditionalSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        final ConditionalSubscriber<? super T> actual;
        boolean done;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        final Consumer<? super T> onNext;
        Subscription f304s;

        ParallelDoOnNextConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.actual = conditionalSubscriber;
            this.onNext = consumer;
            this.errorHandler = biFunction;
        }

        public void request(long j) {
            this.f304s.request(j);
        }

        public void cancel() {
            this.f304s.cancel();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f304s, subscription)) {
                this.f304s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (tryOnNext(t) == null && this.done == null) {
                this.f304s.request(1);
            }
        }

        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            long j = 0;
            while (true) {
                try {
                    this.onNext.accept(t);
                    break;
                } catch (T t2) {
                    Exceptions.throwIfFatal(t2);
                    cancel();
                    onError(new CompositeException(th, t2));
                    return false;
                }
            }
            return this.actual.tryOnNext(t2);
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.actual.onComplete();
            }
        }
    }

    static final class ParallelDoOnNextSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        final Subscriber<? super T> actual;
        boolean done;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        final Consumer<? super T> onNext;
        Subscription f305s;

        ParallelDoOnNextSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.actual = subscriber;
            this.onNext = consumer;
            this.errorHandler = biFunction;
        }

        public void request(long j) {
            this.f305s.request(j);
        }

        public void cancel() {
            this.f305s.cancel();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f305s, subscription)) {
                this.f305s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (tryOnNext(t) == null) {
                this.f305s.request(1);
            }
        }

        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            long j = 0;
            while (true) {
                try {
                    this.onNext.accept(t);
                    break;
                } catch (T t2) {
                    Exceptions.throwIfFatal(t2);
                    cancel();
                    onError(new CompositeException(th, t2));
                    return false;
                }
            }
            this.actual.onNext(t2);
            return true;
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.actual.onComplete();
            }
        }
    }

    public ParallelDoOnNextTry(ParallelFlowable<T> parallelFlowable, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.source = parallelFlowable;
        this.onNext = consumer;
        this.errorHandler = biFunction;
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                Subscriber subscriber = subscriberArr[i];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i] = new ParallelDoOnNextConditionalSubscriber((ConditionalSubscriber) subscriber, this.onNext, this.errorHandler);
                } else {
                    subscriberArr2[i] = new ParallelDoOnNextSubscriber(subscriber, this.onNext, this.errorHandler);
                }
            }
            this.source.subscribe(subscriberArr2);
        }
    }

    public int parallelism() {
        return this.source.parallelism();
    }
}
