package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableZip<T, R> extends Flowable<R> {
    final int bufferSize;
    final boolean delayError;
    final Publisher<? extends T>[] sources;
    final Iterable<? extends Publisher<? extends T>> sourcesIterable;
    final Function<? super Object[], ? extends R> zipper;

    static final class ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = -2434867452883857743L;
        final Subscriber<? super R> actual;
        volatile boolean cancelled;
        final Object[] current;
        final boolean delayErrors;
        final AtomicThrowable errors;
        final AtomicLong requested;
        final ZipSubscriber<T, R>[] subscribers;
        final Function<? super Object[], ? extends R> zipper;

        ZipCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.actual = subscriber;
            this.zipper = function;
            this.delayErrors = z;
            subscriber = new ZipSubscriber[i];
            for (function = null; function < i; function++) {
                subscriber[function] = new ZipSubscriber(this, i2);
            }
            this.current = new Object[i];
            this.subscribers = subscriber;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
        }

        void subscribe(Publisher<? extends T>[] publisherArr, int i) {
            ZipSubscriber[] zipSubscriberArr = this.subscribers;
            for (int i2 = 0; i2 < i && !this.cancelled; i2++) {
                if (!this.delayErrors && this.errors.get() != null) {
                    break;
                }
                publisherArr[i2].subscribe(zipSubscriberArr[i2]);
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
                cancelAll();
            }
        }

        void error(ZipSubscriber<T, R> zipSubscriber, Throwable th) {
            if (this.errors.addThrowable(th)) {
                zipSubscriber.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        void cancelAll() {
            for (ZipSubscriber cancel : this.subscribers) {
                cancel.cancel();
            }
        }

        void drain() {
            ZipCoordinator zipCoordinator = this;
            if (getAndIncrement() == 0) {
                Subscriber subscriber = zipCoordinator.actual;
                ZipSubscriber[] zipSubscriberArr = zipCoordinator.subscribers;
                int length = zipSubscriberArr.length;
                Object obj = zipCoordinator.current;
                int i = 1;
                do {
                    Object obj2;
                    int i2;
                    boolean z;
                    Object poll;
                    long j = zipCoordinator.requested.get();
                    long j2 = 0;
                    while (j != j2) {
                        if (!zipCoordinator.cancelled) {
                            if (zipCoordinator.delayErrors || zipCoordinator.errors.get() == null) {
                                obj2 = null;
                                for (i2 = 0; i2 < length; i2++) {
                                    ZipSubscriber zipSubscriber = zipSubscriberArr[i2];
                                    if (obj[i2] == null) {
                                        try {
                                            z = zipSubscriber.done;
                                            SimpleQueue simpleQueue = zipSubscriber.queue;
                                            poll = simpleQueue != null ? simpleQueue.poll() : null;
                                            Object obj3 = poll == null ? 1 : null;
                                            if (!z || obj3 == null) {
                                                if (obj3 == null) {
                                                    obj[i2] = poll;
                                                }
                                                obj2 = 1;
                                            } else {
                                                cancelAll();
                                                if (((Throwable) zipCoordinator.errors.get()) != null) {
                                                    subscriber.onError(zipCoordinator.errors.terminate());
                                                } else {
                                                    subscriber.onComplete();
                                                }
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.throwIfFatal(th);
                                            zipCoordinator.errors.addThrowable(th);
                                            if (!zipCoordinator.delayErrors) {
                                                cancelAll();
                                                subscriber.onError(zipCoordinator.errors.terminate());
                                                return;
                                            }
                                        }
                                    }
                                }
                                if (obj2 != null) {
                                    break;
                                }
                                try {
                                    subscriber.onNext(ObjectHelper.requireNonNull(zipCoordinator.zipper.apply(obj.clone()), "The zipper returned a null value"));
                                    long j3 = j2 + 1;
                                    Arrays.fill(obj, null);
                                    j2 = j3;
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    cancelAll();
                                    zipCoordinator.errors.addThrowable(th2);
                                    subscriber.onError(zipCoordinator.errors.terminate());
                                    return;
                                }
                            }
                            cancelAll();
                            subscriber.onError(zipCoordinator.errors.terminate());
                            return;
                        }
                        return;
                    }
                    if (j == j2) {
                        if (!zipCoordinator.cancelled) {
                            if (zipCoordinator.delayErrors || zipCoordinator.errors.get() == null) {
                                for (i2 = 0; i2 < length; i2++) {
                                    ZipSubscriber zipSubscriber2 = zipSubscriberArr[i2];
                                    if (obj[i2] == null) {
                                        try {
                                            z = zipSubscriber2.done;
                                            SimpleQueue simpleQueue2 = zipSubscriber2.queue;
                                            obj2 = simpleQueue2 != null ? simpleQueue2.poll() : null;
                                            poll = obj2 == null ? 1 : null;
                                            if (z && poll != null) {
                                                cancelAll();
                                                if (((Throwable) zipCoordinator.errors.get()) != null) {
                                                    subscriber.onError(zipCoordinator.errors.terminate());
                                                } else {
                                                    subscriber.onComplete();
                                                }
                                                return;
                                            } else if (poll == null) {
                                                obj[i2] = obj2;
                                            }
                                        } catch (Throwable th22) {
                                            Exceptions.throwIfFatal(th22);
                                            zipCoordinator.errors.addThrowable(th22);
                                            if (!zipCoordinator.delayErrors) {
                                                cancelAll();
                                                subscriber.onError(zipCoordinator.errors.terminate());
                                                return;
                                            }
                                        }
                                    }
                                }
                            } else {
                                cancelAll();
                                subscriber.onError(zipCoordinator.errors.terminate());
                                return;
                            }
                        }
                        return;
                    }
                    if (j2 != 0) {
                        for (ZipSubscriber request : zipSubscriberArr) {
                            request.request(j2);
                        }
                        if (j != LongCompanionObject.MAX_VALUE) {
                            zipCoordinator.requested.addAndGet(-j2);
                        }
                    }
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }
    }

    static final class ZipSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4627193790118206028L;
        volatile boolean done;
        final int limit;
        final ZipCoordinator<T, R> parent;
        final int prefetch;
        long produced;
        SimpleQueue<T> queue;
        int sourceMode;

        ZipSubscriber(ZipCoordinator<T, R> zipCoordinator, int i) {
            this.parent = zipCoordinator;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                subscription.request((long) this.prefetch);
            }
        }

        public void onNext(T t) {
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            this.parent.drain();
        }

        public void onError(Throwable th) {
            this.parent.error(this, th);
        }

        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void request(long j) {
            if (this.sourceMode != 1) {
                long j2 = this.produced + j;
                if (j2 >= ((long) this.limit)) {
                    this.produced = 0;
                    ((Subscription) get()).request(j2);
                    return;
                }
                this.produced = j2;
            }
        }
    }

    public FlowableZip(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.sources = publisherArr;
        this.sourcesIterable = iterable;
        this.zipper = function;
        this.bufferSize = i;
        this.delayError = z;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        int i;
        Publisher[] publisherArr;
        Publisher[] publisherArr2 = this.sources;
        if (publisherArr2 == null) {
            Object obj = new Publisher[8];
            Object obj2 = obj;
            i = 0;
            for (Publisher publisher : this.sourcesIterable) {
                if (i == obj2.length) {
                    Object obj3 = new Publisher[((i >> 2) + i)];
                    System.arraycopy(obj2, 0, obj3, 0, i);
                    obj2 = obj3;
                }
                int i2 = i + 1;
                obj2[i] = publisher;
                i = i2;
            }
            publisherArr = obj2;
        } else {
            publisherArr = publisherArr2;
            i = publisherArr2.length;
        }
        if (i == 0) {
            EmptySubscription.complete(subscriber);
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(subscriber, this.zipper, i, this.bufferSize, this.delayError);
        subscriber.onSubscribe(zipCoordinator);
        zipCoordinator.subscribe(publisherArr, i);
    }
}
