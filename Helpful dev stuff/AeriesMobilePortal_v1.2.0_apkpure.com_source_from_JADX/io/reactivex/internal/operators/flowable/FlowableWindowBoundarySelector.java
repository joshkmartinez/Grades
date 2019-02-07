package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundarySelector<T, B, V> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int bufferSize;
    final Function<? super B, ? extends Publisher<V>> close;
    final Publisher<B> open;

    static final class WindowOperation<T, B> {
        final B open;
        final UnicastProcessor<T> f28w;

        WindowOperation(UnicastProcessor<T> unicastProcessor, B b) {
            this.f28w = unicastProcessor;
            this.open = b;
        }
    }

    static final class OperatorWindowBoundaryCloseSubscriber<T, V> extends DisposableSubscriber<V> {
        boolean done;
        final WindowBoundaryMainSubscriber<T, ?, V> parent;
        final UnicastProcessor<T> f300w;

        OperatorWindowBoundaryCloseSubscriber(WindowBoundaryMainSubscriber<T, ?, V> windowBoundaryMainSubscriber, UnicastProcessor<T> unicastProcessor) {
            this.parent = windowBoundaryMainSubscriber;
            this.f300w = unicastProcessor;
        }

        public void onNext(V v) {
            if (this.done == null) {
                this.done = true;
                cancel();
                this.parent.close(this);
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.parent.error(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.parent.close(this);
            }
        }
    }

    static final class OperatorWindowBoundaryOpenSubscriber<T, B> extends DisposableSubscriber<B> {
        boolean done;
        final WindowBoundaryMainSubscriber<T, B, ?> parent;

        OperatorWindowBoundaryOpenSubscriber(WindowBoundaryMainSubscriber<T, B, ?> windowBoundaryMainSubscriber) {
            this.parent = windowBoundaryMainSubscriber;
        }

        public void onNext(B b) {
            if (!this.done) {
                this.parent.open(b);
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.parent.error(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.parent.onComplete();
            }
        }
    }

    static final class WindowBoundaryMainSubscriber<T, B, V> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        final AtomicReference<Disposable> boundary = new AtomicReference();
        final int bufferSize;
        final Function<? super B, ? extends Publisher<V>> close;
        final Publisher<B> open;
        final CompositeDisposable resources;
        Subscription f363s;
        final AtomicLong windows = new AtomicLong();
        final List<UnicastProcessor<T>> ws;

        public boolean accept(Subscriber<? super Flowable<T>> subscriber, Object obj) {
            return false;
        }

        WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.open = publisher;
            this.close = function;
            this.bufferSize = i;
            this.resources = new CompositeDisposable();
            this.ws = new ArrayList();
            this.windows.lazySet(1);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f363s, subscription)) {
                this.f363s = subscription;
                this.actual.onSubscribe(this);
                if (!this.cancelled) {
                    Subscriber operatorWindowBoundaryOpenSubscriber = new OperatorWindowBoundaryOpenSubscriber(this);
                    if (this.boundary.compareAndSet(null, operatorWindowBoundaryOpenSubscriber)) {
                        this.windows.getAndIncrement();
                        subscription.request(LongCompanionObject.MAX_VALUE);
                        this.open.subscribe(operatorWindowBoundaryOpenSubscriber);
                    }
                }
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                if (fastEnter()) {
                    for (UnicastProcessor onNext : this.ws) {
                        onNext.onNext(t);
                    }
                    if (leave(-1) == null) {
                        return;
                    }
                }
                this.queue.offer(NotificationLite.next(t));
                if (enter() == null) {
                    return;
                }
                drainLoop();
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            if (this.windows.decrementAndGet() == 0) {
                this.resources.dispose();
            }
            this.actual.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                if (enter()) {
                    drainLoop();
                }
                if (this.windows.decrementAndGet() == 0) {
                    this.resources.dispose();
                }
                this.actual.onComplete();
            }
        }

        void error(Throwable th) {
            this.f363s.cancel();
            this.resources.dispose();
            DisposableHelper.dispose(this.boundary);
            this.actual.onError(th);
        }

        public void request(long j) {
            requested(j);
        }

        public void cancel() {
            this.cancelled = true;
        }

        void dispose() {
            this.resources.dispose();
            DisposableHelper.dispose(this.boundary);
        }

        void drainLoop() {
            SimplePlainQueue simplePlainQueue = this.queue;
            Subscriber subscriber = this.actual;
            List<UnicastProcessor> list = this.ws;
            int i = 1;
            while (true) {
                boolean z = this.done;
                Object poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    break;
                } else if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll instanceof WindowOperation) {
                    WindowOperation windowOperation = (WindowOperation) poll;
                    if (windowOperation.f28w != null) {
                        if (list.remove(windowOperation.f28w)) {
                            windowOperation.f28w.onComplete();
                            if (this.windows.decrementAndGet() == 0) {
                                dispose();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.cancelled) {
                        UnicastProcessor create = UnicastProcessor.create(this.bufferSize);
                        long requested = requested();
                        if (requested != 0) {
                            list.add(create);
                            subscriber.onNext(create);
                            if (requested != LongCompanionObject.MAX_VALUE) {
                                produced(1);
                            }
                            try {
                                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.close.apply(windowOperation.open), "The publisher supplied is null");
                                Object operatorWindowBoundaryCloseSubscriber = new OperatorWindowBoundaryCloseSubscriber(this, create);
                                if (this.resources.add(operatorWindowBoundaryCloseSubscriber)) {
                                    this.windows.getAndIncrement();
                                    publisher.subscribe(operatorWindowBoundaryCloseSubscriber);
                                }
                            } catch (Throwable th) {
                                this.cancelled = true;
                                subscriber.onError(th);
                            }
                        } else {
                            this.cancelled = true;
                            subscriber.onError(new MissingBackpressureException("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    for (UnicastProcessor onNext : list) {
                        onNext.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
            dispose();
            Throwable th2 = this.error;
            if (th2 != null) {
                for (UnicastProcessor onError : list) {
                    onError.onError(th2);
                }
            } else {
                for (UnicastProcessor onComplete : list) {
                    onComplete.onComplete();
                }
            }
            list.clear();
        }

        void open(B b) {
            this.queue.offer(new WindowOperation(null, b));
            if (enter() != null) {
                drainLoop();
            }
        }

        void close(OperatorWindowBoundaryCloseSubscriber<T, V> operatorWindowBoundaryCloseSubscriber) {
            this.resources.delete(operatorWindowBoundaryCloseSubscriber);
            this.queue.offer(new WindowOperation(operatorWindowBoundaryCloseSubscriber.f300w, null));
            if (enter() != null) {
                drainLoop();
            }
        }
    }

    public FlowableWindowBoundarySelector(Flowable<T> flowable, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
        super(flowable);
        this.open = publisher;
        this.close = function;
        this.bufferSize = i;
    }

    protected void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.source.subscribe(new WindowBoundaryMainSubscriber(new SerializedSubscriber(subscriber), this.open, this.close, this.bufferSize));
    }
}
