package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int bufferSize;
    final long maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    static final class WindowExactBoundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        final int bufferSize;
        long count;
        final long maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;
        Subscription f365s;
        final Scheduler scheduler;
        volatile boolean terminated;
        final SequentialDisposable timer = new SequentialDisposable();
        final long timespan;
        final TimeUnit unit;
        UnicastProcessor<T> window;
        final Worker worker;

        static final class ConsumerIndexHolder implements Runnable {
            final long index;
            final WindowExactBoundedSubscriber<?> parent;

            ConsumerIndexHolder(long j, WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber) {
                this.index = j;
                this.parent = windowExactBoundedSubscriber;
            }

            public void run() {
                WindowExactBoundedSubscriber windowExactBoundedSubscriber = this.parent;
                if (windowExactBoundedSubscriber.cancelled) {
                    windowExactBoundedSubscriber.terminated = true;
                    windowExactBoundedSubscriber.dispose();
                } else {
                    windowExactBoundedSubscriber.queue.offer(this);
                }
                if (windowExactBoundedSubscriber.enter()) {
                    windowExactBoundedSubscriber.drainLoop();
                }
            }
        }

        WindowExactBoundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i, long j2, boolean z) {
            super(subscriber, new MpscLinkedQueue());
            this.timespan = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.bufferSize = i;
            this.maxSize = j2;
            this.restartTimerOnMaxSize = z;
            if (z) {
                this.worker = scheduler.createWorker();
            } else {
                this.worker = null;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f365s, subscription)) {
                this.f365s = subscription;
                Subscriber subscriber = this.actual;
                subscriber.onSubscribe(this);
                if (!this.cancelled) {
                    UnicastProcessor create = UnicastProcessor.create(this.bufferSize);
                    this.window = create;
                    long requested = requested();
                    if (requested != 0) {
                        Disposable schedulePeriodically;
                        subscriber.onNext(create);
                        if (requested != LongCompanionObject.MAX_VALUE) {
                            produced(1);
                        }
                        Runnable consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                        if (this.restartTimerOnMaxSize) {
                            schedulePeriodically = this.worker.schedulePeriodically(consumerIndexHolder, this.timespan, this.timespan, this.unit);
                        } else {
                            schedulePeriodically = this.scheduler.schedulePeriodicallyDirect(consumerIndexHolder, this.timespan, this.timespan, this.unit);
                        }
                        if (this.timer.replace(schedulePeriodically)) {
                            subscription.request(LongCompanionObject.MAX_VALUE);
                        }
                    } else {
                        this.cancelled = true;
                        subscription.cancel();
                        subscriber.onError(new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
                    }
                }
            }
        }

        public void onNext(T t) {
            if (!this.terminated) {
                if (fastEnter()) {
                    UnicastProcessor unicastProcessor = this.window;
                    unicastProcessor.onNext(t);
                    long j = this.count + 1;
                    if (j >= this.maxSize) {
                        this.producerIndex++;
                        this.count = 0;
                        unicastProcessor.onComplete();
                        j = requested();
                        if (j != 0) {
                            t = UnicastProcessor.create(this.bufferSize);
                            this.window = t;
                            this.actual.onNext(t);
                            if (j != LongCompanionObject.MAX_VALUE) {
                                produced(1);
                            }
                            if (this.restartTimerOnMaxSize != null) {
                                Disposable disposable = (Disposable) this.timer.get();
                                disposable.dispose();
                                Disposable schedulePeriodically = this.worker.schedulePeriodically(new ConsumerIndexHolder(this.producerIndex, this), this.timespan, this.timespan, this.unit);
                                if (this.timer.compareAndSet(disposable, schedulePeriodically) == null) {
                                    schedulePeriodically.dispose();
                                }
                            }
                        } else {
                            this.window = null;
                            this.f365s.cancel();
                            this.actual.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                            dispose();
                            return;
                        }
                    }
                    this.count = j;
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
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onError(th);
            dispose();
        }

        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onComplete();
            dispose();
        }

        public void request(long j) {
            requested(j);
        }

        public void cancel() {
            this.cancelled = true;
        }

        public void dispose() {
            DisposableHelper.dispose(this.timer);
            Worker worker = this.worker;
            if (worker != null) {
                worker.dispose();
            }
        }

        void drainLoop() {
            SimplePlainQueue simplePlainQueue = this.queue;
            Subscriber subscriber = this.actual;
            UnicastProcessor unicastProcessor = this.window;
            int i = 1;
            while (!r0.terminated) {
                boolean z = r0.done;
                Object poll = simplePlainQueue.poll();
                Object obj = poll == null ? 1 : null;
                boolean z2 = poll instanceof ConsumerIndexHolder;
                if (z && (obj != null || z2)) {
                    r0.window = null;
                    simplePlainQueue.clear();
                    Throwable th = r0.error;
                    if (th != null) {
                        unicastProcessor.onError(th);
                    } else {
                        unicastProcessor.onComplete();
                    }
                    dispose();
                    return;
                } else if (obj != null) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    int i2 = i;
                    long requested;
                    if (z2) {
                        ConsumerIndexHolder consumerIndexHolder = (ConsumerIndexHolder) poll;
                        if (!r0.restartTimerOnMaxSize) {
                            if (r0.producerIndex == consumerIndexHolder.index) {
                            }
                        }
                        unicastProcessor.onComplete();
                        r0.count = 0;
                        unicastProcessor = UnicastProcessor.create(r0.bufferSize);
                        r0.window = unicastProcessor;
                        requested = requested();
                        if (requested != 0) {
                            subscriber.onNext(unicastProcessor);
                            if (requested != LongCompanionObject.MAX_VALUE) {
                                produced(1);
                            }
                        } else {
                            r0.window = null;
                            r0.queue.clear();
                            r0.f365s.cancel();
                            subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                            dispose();
                            return;
                        }
                    }
                    unicastProcessor.onNext(NotificationLite.getValue(poll));
                    long j = r0.count + 1;
                    if (j >= r0.maxSize) {
                        r0.producerIndex++;
                        r0.count = 0;
                        unicastProcessor.onComplete();
                        requested = requested();
                        if (requested != 0) {
                            unicastProcessor = UnicastProcessor.create(r0.bufferSize);
                            r0.window = unicastProcessor;
                            r0.actual.onNext(unicastProcessor);
                            if (requested != LongCompanionObject.MAX_VALUE) {
                                produced(1);
                            }
                            if (r0.restartTimerOnMaxSize) {
                                Disposable disposable = (Disposable) r0.timer.get();
                                disposable.dispose();
                                Disposable schedulePeriodically = r0.worker.schedulePeriodically(new ConsumerIndexHolder(r0.producerIndex, r0), r0.timespan, r0.timespan, r0.unit);
                                if (!r0.timer.compareAndSet(disposable, schedulePeriodically)) {
                                    schedulePeriodically.dispose();
                                }
                            }
                        } else {
                            r0.window = null;
                            r0.f365s.cancel();
                            r0.actual.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                            dispose();
                            return;
                        }
                    }
                    r0.count = j;
                    i = i2;
                }
            }
            r0.f365s.cancel();
            simplePlainQueue.clear();
            dispose();
        }
    }

    static final class WindowExactUnboundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements FlowableSubscriber<T>, Subscription, Runnable {
        static final Object NEXT = new Object();
        final int bufferSize;
        Subscription f366s;
        final Scheduler scheduler;
        volatile boolean terminated;
        final SequentialDisposable timer = new SequentialDisposable();
        final long timespan;
        final TimeUnit unit;
        UnicastProcessor<T> window;

        WindowExactUnboundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.timespan = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.bufferSize = i;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f366s, subscription)) {
                this.f366s = subscription;
                this.window = UnicastProcessor.create(this.bufferSize);
                Subscriber subscriber = this.actual;
                subscriber.onSubscribe(this);
                long requested = requested();
                if (requested != 0) {
                    subscriber.onNext(this.window);
                    if (requested != LongCompanionObject.MAX_VALUE) {
                        produced(1);
                    }
                    if (!this.cancelled && this.timer.replace(this.scheduler.schedulePeriodicallyDirect(this, this.timespan, this.timespan, this.unit))) {
                        subscription.request(LongCompanionObject.MAX_VALUE);
                    }
                } else {
                    this.cancelled = true;
                    subscription.cancel();
                    subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                }
            }
        }

        public void onNext(T t) {
            if (!this.terminated) {
                if (fastEnter()) {
                    this.window.onNext(t);
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
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onError(th);
            dispose();
        }

        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onComplete();
            dispose();
        }

        public void request(long j) {
            requested(j);
        }

        public void cancel() {
            this.cancelled = true;
        }

        public void dispose() {
            DisposableHelper.dispose(this.timer);
        }

        public void run() {
            if (this.cancelled) {
                this.terminated = true;
                dispose();
            }
            this.queue.offer(NEXT);
            if (enter()) {
                drainLoop();
            }
        }

        void drainLoop() {
            SimplePlainQueue simplePlainQueue = this.queue;
            Subscriber subscriber = this.actual;
            UnicastProcessor unicastProcessor = this.window;
            int i = 1;
            while (true) {
                boolean z = this.terminated;
                boolean z2 = this.done;
                Object poll = simplePlainQueue.poll();
                if (!(z2 && (poll == null || poll == NEXT))) {
                    if (poll == null) {
                        i = leave(-i);
                        if (i == 0) {
                            return;
                        }
                    } else if (poll == NEXT) {
                        unicastProcessor.onComplete();
                        if (z) {
                            this.f366s.cancel();
                        } else {
                            unicastProcessor = UnicastProcessor.create(this.bufferSize);
                            this.window = unicastProcessor;
                            long requested = requested();
                            if (requested != 0) {
                                subscriber.onNext(unicastProcessor);
                                if (requested != LongCompanionObject.MAX_VALUE) {
                                    produced(1);
                                }
                            } else {
                                this.window = null;
                                this.queue.clear();
                                this.f366s.cancel();
                                dispose();
                                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                                return;
                            }
                        }
                    } else {
                        unicastProcessor.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
            this.window = null;
            simplePlainQueue.clear();
            dispose();
            Throwable th = this.error;
            if (th != null) {
                unicastProcessor.onError(th);
            } else {
                unicastProcessor.onComplete();
            }
        }
    }

    static final class WindowSkipSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription, Runnable {
        final int bufferSize;
        Subscription f367s;
        volatile boolean terminated;
        final long timeskip;
        final long timespan;
        final TimeUnit unit;
        final List<UnicastProcessor<T>> windows = new LinkedList();
        final Worker worker;

        final class Completion implements Runnable {
            private final UnicastProcessor<T> processor;

            Completion(UnicastProcessor<T> unicastProcessor) {
                this.processor = unicastProcessor;
            }

            public void run() {
                WindowSkipSubscriber.this.complete(this.processor);
            }
        }

        static final class SubjectWork<T> {
            final boolean open;
            final UnicastProcessor<T> f29w;

            SubjectWork(UnicastProcessor<T> unicastProcessor, boolean z) {
                this.f29w = unicastProcessor;
                this.open = z;
            }
        }

        WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, long j2, TimeUnit timeUnit, Worker worker, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.timespan = j;
            this.timeskip = j2;
            this.unit = timeUnit;
            this.worker = worker;
            this.bufferSize = i;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f367s, subscription)) {
                this.f367s = subscription;
                this.actual.onSubscribe(this);
                if (!this.cancelled) {
                    long requested = requested();
                    if (requested != 0) {
                        UnicastProcessor create = UnicastProcessor.create(this.bufferSize);
                        this.windows.add(create);
                        this.actual.onNext(create);
                        if (requested != LongCompanionObject.MAX_VALUE) {
                            produced(1);
                        }
                        this.worker.schedule(new Completion(create), this.timespan, this.unit);
                        this.worker.schedulePeriodically(this, this.timeskip, this.timeskip, this.unit);
                        subscription.request(LongCompanionObject.MAX_VALUE);
                    } else {
                        subscription.cancel();
                        this.actual.onError(new MissingBackpressureException("Could not emit the first window due to lack of requests"));
                    }
                }
            }
        }

        public void onNext(T t) {
            if (fastEnter()) {
                for (UnicastProcessor onNext : this.windows) {
                    onNext.onNext(t);
                }
                if (leave(-1) == null) {
                    return;
                }
            }
            this.queue.offer(t);
            if (enter() == null) {
                return;
            }
            drainLoop();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onError(th);
            dispose();
        }

        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onComplete();
            dispose();
        }

        public void request(long j) {
            requested(j);
        }

        public void cancel() {
            this.cancelled = true;
        }

        public void dispose() {
            this.worker.dispose();
        }

        void complete(UnicastProcessor<T> unicastProcessor) {
            this.queue.offer(new SubjectWork(unicastProcessor, false));
            if (enter() != null) {
                drainLoop();
            }
        }

        void drainLoop() {
            SimplePlainQueue simplePlainQueue = this.queue;
            Subscriber subscriber = this.actual;
            List<UnicastProcessor> list = this.windows;
            int i = 1;
            while (!this.terminated) {
                boolean z = this.done;
                Object poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof SubjectWork;
                if (z && (z2 || z3)) {
                    simplePlainQueue.clear();
                    Throwable th = this.error;
                    if (th != null) {
                        for (UnicastProcessor onError : list) {
                            onError.onError(th);
                        }
                    } else {
                        for (UnicastProcessor onComplete : list) {
                            onComplete.onComplete();
                        }
                    }
                    list.clear();
                    dispose();
                    return;
                } else if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    SubjectWork subjectWork = (SubjectWork) poll;
                    if (!subjectWork.open) {
                        list.remove(subjectWork.f29w);
                        subjectWork.f29w.onComplete();
                        if (list.isEmpty() && this.cancelled) {
                            this.terminated = true;
                        }
                    } else if (!this.cancelled) {
                        long requested = requested();
                        if (requested != 0) {
                            r7 = UnicastProcessor.create(this.bufferSize);
                            list.add(r7);
                            subscriber.onNext(r7);
                            if (requested != LongCompanionObject.MAX_VALUE) {
                                produced(1);
                            }
                            this.worker.schedule(new Completion(r7), this.timespan, this.unit);
                        } else {
                            subscriber.onError(new MissingBackpressureException("Can't emit window due to lack of requests"));
                        }
                    }
                } else {
                    for (UnicastProcessor onNext : list) {
                        onNext.onNext(poll);
                    }
                }
            }
            this.f367s.cancel();
            dispose();
            simplePlainQueue.clear();
            list.clear();
        }

        public void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastProcessor.create(this.bufferSize), true);
            if (!this.cancelled) {
                this.queue.offer(subjectWork);
            }
            if (enter()) {
                drainLoop();
            }
        }
    }

    public FlowableWindowTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, int i, boolean z) {
        super(flowable);
        this.timespan = j;
        this.timeskip = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.maxSize = j3;
        this.bufferSize = i;
        this.restartTimerOnMaxSize = z;
    }

    protected void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        Subscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.timespan != this.timeskip) {
            this.source.subscribe(new WindowSkipSubscriber(serializedSubscriber, this.timespan, this.timeskip, this.unit, this.scheduler.createWorker(), this.bufferSize));
        } else if (this.maxSize == LongCompanionObject.MAX_VALUE) {
            this.source.subscribe(new WindowExactUnboundedSubscriber(serializedSubscriber, this.timespan, this.unit, this.scheduler, this.bufferSize));
        } else {
            this.source.subscribe(new WindowExactBoundedSubscriber(serializedSubscriber, this.timespan, this.unit, this.scheduler, this.bufferSize, this.maxSize, this.restartTimerOnMaxSize));
        }
    }
}
