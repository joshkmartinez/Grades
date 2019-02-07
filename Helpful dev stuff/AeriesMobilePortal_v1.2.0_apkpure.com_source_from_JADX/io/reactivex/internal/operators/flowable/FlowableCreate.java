package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCreate<T> extends Flowable<T> {
    final BackpressureStrategy backpressure;
    final FlowableOnSubscribe<T> source;

    static abstract class BaseEmitter<T> extends AtomicLong implements FlowableEmitter<T>, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;
        final Subscriber<? super T> actual;
        final SequentialDisposable serial = new SequentialDisposable();

        void onRequested() {
        }

        void onUnsubscribed() {
        }

        BaseEmitter(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        public void onComplete() {
            complete();
        }

        protected void complete() {
            if (!isCancelled()) {
                try {
                    this.actual.onComplete();
                } finally {
                    this.serial.dispose();
                }
            }
        }

        public final void onError(Throwable th) {
            if (!tryOnError(th)) {
                RxJavaPlugins.onError(th);
            }
        }

        public boolean tryOnError(Throwable th) {
            return error(th);
        }

        protected boolean error(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isCancelled()) {
                return null;
            }
            try {
                this.actual.onError(th);
                return true;
            } finally {
                this.serial.dispose();
            }
        }

        public final void cancel() {
            this.serial.dispose();
            onUnsubscribed();
        }

        public final boolean isCancelled() {
            return this.serial.isDisposed();
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this, j);
                onRequested();
            }
        }

        public final void setDisposable(Disposable disposable) {
            this.serial.update(disposable);
        }

        public final void setCancellable(Cancellable cancellable) {
            setDisposable(new CancellableDisposable(cancellable));
        }

        public final long requested() {
            return get();
        }

        public final FlowableEmitter<T> serialize() {
            return new SerializedEmitter(this);
        }
    }

    static final class SerializedEmitter<T> extends AtomicInteger implements FlowableEmitter<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final BaseEmitter<T> emitter;
        final AtomicThrowable error = new AtomicThrowable();
        final SimplePlainQueue<T> queue = new SpscLinkedArrayQueue(16);

        public FlowableEmitter<T> serialize() {
            return this;
        }

        SerializedEmitter(BaseEmitter<T> baseEmitter) {
            this.emitter = baseEmitter;
        }

        public void onNext(T t) {
            if (!this.emitter.isCancelled()) {
                if (!this.done) {
                    if (t == null) {
                        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                        return;
                    }
                    if (get() == 0 && compareAndSet(0, 1)) {
                        this.emitter.onNext(t);
                        if (decrementAndGet() == null) {
                            return;
                        }
                    }
                    SimplePlainQueue simplePlainQueue = this.queue;
                    synchronized (simplePlainQueue) {
                        simplePlainQueue.offer(t);
                    }
                    if (getAndIncrement() != null) {
                        return;
                    }
                    drainLoop();
                }
            }
        }

        public void onError(Throwable th) {
            if (!tryOnError(th)) {
                RxJavaPlugins.onError(th);
            }
        }

        public boolean tryOnError(Throwable th) {
            if (!this.emitter.isCancelled()) {
                if (!this.done) {
                    if (th == null) {
                        th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                    }
                    if (this.error.addThrowable(th) == null) {
                        return false;
                    }
                    this.done = true;
                    drain();
                    return true;
                }
            }
            return false;
        }

        public void onComplete() {
            if (!this.emitter.isCancelled()) {
                if (!this.done) {
                    this.done = true;
                    drain();
                }
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            BaseEmitter baseEmitter = this.emitter;
            SimplePlainQueue simplePlainQueue = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            int i = 1;
            while (!baseEmitter.isCancelled()) {
                if (atomicThrowable.get() != null) {
                    simplePlainQueue.clear();
                    baseEmitter.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.done;
                Object poll = simplePlainQueue.poll();
                Object obj = poll == null ? 1 : null;
                if (z && obj != null) {
                    baseEmitter.onComplete();
                    return;
                } else if (obj != null) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    baseEmitter.onNext(poll);
                }
            }
            simplePlainQueue.clear();
        }

        public void setDisposable(Disposable disposable) {
            this.emitter.setDisposable(disposable);
        }

        public void setCancellable(Cancellable cancellable) {
            this.emitter.setCancellable(cancellable);
        }

        public long requested() {
            return this.emitter.requested();
        }

        public boolean isCancelled() {
            return this.emitter.isCancelled();
        }
    }

    static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final SpscLinkedArrayQueue<T> queue;
        final AtomicInteger wip = new AtomicInteger();

        BufferAsyncEmitter(Subscriber<? super T> subscriber, int i) {
            super(subscriber);
            this.queue = new SpscLinkedArrayQueue(i);
        }

        public void onNext(T t) {
            if (!this.done) {
                if (!isCancelled()) {
                    if (t == null) {
                        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                        return;
                    }
                    this.queue.offer(t);
                    drain();
                }
            }
        }

        public boolean tryOnError(Throwable th) {
            if (!this.done) {
                if (!isCancelled()) {
                    if (th == null) {
                        th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                    }
                    this.error = th;
                    this.done = true;
                    drain();
                    return true;
                }
            }
            return null;
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        void onRequested() {
            drain();
        }

        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                Subscriber subscriber = this.actual;
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
                int i = 1;
                do {
                    Throwable th;
                    long j = get();
                    long j2 = 0;
                    while (j2 != j) {
                        if (isCancelled()) {
                            spscLinkedArrayQueue.clear();
                            return;
                        }
                        boolean z = this.done;
                        Object poll = spscLinkedArrayQueue.poll();
                        Object obj = poll == null ? 1 : null;
                        if (z && obj != null) {
                            th = this.error;
                            if (th != null) {
                                error(th);
                            } else {
                                complete();
                            }
                            return;
                        } else if (obj != null) {
                            break;
                        } else {
                            subscriber.onNext(poll);
                            j2++;
                        }
                    }
                    if (j2 == j) {
                        if (isCancelled()) {
                            spscLinkedArrayQueue.clear();
                            return;
                        }
                        boolean z2 = this.done;
                        boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                        if (z2 && isEmpty) {
                            th = this.error;
                            if (th != null) {
                                error(th);
                            } else {
                                complete();
                            }
                            return;
                        }
                    }
                    if (j2 != 0) {
                        BackpressureHelper.produced(this, j2);
                    }
                    i = this.wip.addAndGet(-i);
                } while (i != 0);
            }
        }
    }

    static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<T> queue = new AtomicReference();
        final AtomicInteger wip = new AtomicInteger();

        LatestAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void onNext(T t) {
            if (!this.done) {
                if (!isCancelled()) {
                    if (t == null) {
                        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                        return;
                    }
                    this.queue.set(t);
                    drain();
                }
            }
        }

        public boolean tryOnError(Throwable th) {
            if (!this.done) {
                if (!isCancelled()) {
                    if (th == null) {
                        onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
                    }
                    this.error = th;
                    this.done = true;
                    drain();
                    return true;
                }
            }
            return null;
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        void onRequested() {
            drain();
        }

        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void drain() {
            /*
            r15 = this;
            r0 = r15.wip;
            r0 = r0.getAndIncrement();
            if (r0 == 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r0 = r15.actual;
            r1 = r15.queue;
            r2 = 1;
            r3 = r2;
        L_0x000f:
            r4 = r15.get();
            r6 = 0;
            r8 = r6;
        L_0x0016:
            r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
            r11 = 0;
            r12 = 0;
            if (r10 == 0) goto L_0x004d;
        L_0x001c:
            r10 = r15.isCancelled();
            if (r10 == 0) goto L_0x0026;
        L_0x0022:
            r1.lazySet(r12);
            return;
        L_0x0026:
            r10 = r15.done;
            r13 = r1.getAndSet(r12);
            if (r13 != 0) goto L_0x0030;
        L_0x002e:
            r14 = r2;
            goto L_0x0031;
        L_0x0030:
            r14 = r11;
        L_0x0031:
            if (r10 == 0) goto L_0x0041;
        L_0x0033:
            if (r14 == 0) goto L_0x0041;
        L_0x0035:
            r0 = r15.error;
            if (r0 == 0) goto L_0x003d;
        L_0x0039:
            r15.error(r0);
            goto L_0x0040;
        L_0x003d:
            r15.complete();
        L_0x0040:
            return;
        L_0x0041:
            if (r14 == 0) goto L_0x0044;
        L_0x0043:
            goto L_0x004d;
        L_0x0044:
            r0.onNext(r13);
            r10 = 1;
            r12 = r8 + r10;
            r8 = r12;
            goto L_0x0016;
        L_0x004d:
            r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
            if (r10 != 0) goto L_0x0074;
        L_0x0051:
            r4 = r15.isCancelled();
            if (r4 == 0) goto L_0x005b;
        L_0x0057:
            r1.lazySet(r12);
            return;
        L_0x005b:
            r4 = r15.done;
            r5 = r1.get();
            if (r5 != 0) goto L_0x0064;
        L_0x0063:
            r11 = r2;
        L_0x0064:
            if (r4 == 0) goto L_0x0074;
        L_0x0066:
            if (r11 == 0) goto L_0x0074;
        L_0x0068:
            r0 = r15.error;
            if (r0 == 0) goto L_0x0070;
        L_0x006c:
            r15.error(r0);
            goto L_0x0073;
        L_0x0070:
            r15.complete();
        L_0x0073:
            return;
        L_0x0074:
            r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
            if (r4 == 0) goto L_0x007b;
        L_0x0078:
            io.reactivex.internal.util.BackpressureHelper.produced(r15, r8);
        L_0x007b:
            r4 = r15.wip;
            r3 = -r3;
            r3 = r4.addAndGet(r3);
            if (r3 != 0) goto L_0x000f;
        L_0x0084:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableCreate.LatestAsyncEmitter.drain():void");
        }
    }

    static final class MissingEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        MissingEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void onNext(T t) {
            if (!isCancelled()) {
                if (t != null) {
                    this.actual.onNext(t);
                    long j;
                    do {
                        j = get();
                        if (j == 0) {
                            break;
                        }
                    } while (compareAndSet(j, j - 1) == null);
                    return;
                }
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
        }
    }

    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        abstract void onOverflow();

        NoOverflowBaseAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public final void onNext(T t) {
            if (!isCancelled()) {
                if (t == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                if (get() != 0) {
                    this.actual.onNext(t);
                    BackpressureHelper.produced(this, 1);
                } else {
                    onOverflow();
                }
            }
        }
    }

    static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        void onOverflow() {
        }

        DropAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }
    }

    static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        ErrorAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        void onOverflow() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    public FlowableCreate(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        this.source = flowableOnSubscribe;
        this.backpressure = backpressureStrategy;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        BaseEmitter missingEmitter;
        switch (this.backpressure) {
            case MISSING:
                missingEmitter = new MissingEmitter(subscriber);
                break;
            case ERROR:
                missingEmitter = new ErrorAsyncEmitter(subscriber);
                break;
            case DROP:
                missingEmitter = new DropAsyncEmitter(subscriber);
                break;
            case LATEST:
                missingEmitter = new LatestAsyncEmitter(subscriber);
                break;
            default:
                missingEmitter = new BufferAsyncEmitter(subscriber, Flowable.bufferSize());
                break;
        }
        subscriber.onSubscribe(missingEmitter);
        try {
            this.source.subscribe(missingEmitter);
        } catch (Subscriber<? super T> subscriber2) {
            Exceptions.throwIfFatal(subscriber2);
            missingEmitter.onError(subscriber2);
        }
    }
}
