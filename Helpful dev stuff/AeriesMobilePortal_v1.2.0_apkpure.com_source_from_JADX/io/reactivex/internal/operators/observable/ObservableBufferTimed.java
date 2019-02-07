package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferTimed<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final Callable<U> bufferSupplier;
    final int maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    static final class BufferExactBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        U buffer;
        final Callable<U> bufferSupplier;
        long consumerIndex;
        final int maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;
        Disposable f324s;
        Disposable timer;
        final long timespan;
        final TimeUnit unit;
        final Worker f325w;

        BufferExactBoundedObserver(Observer<? super U> observer, Callable<U> callable, long j, TimeUnit timeUnit, int i, boolean z, Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.bufferSupplier = callable;
            this.timespan = j;
            this.unit = timeUnit;
            this.maxSize = i;
            this.restartTimerOnMaxSize = z;
            this.f325w = worker;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f324s, disposable)) {
                this.f324s = disposable;
                try {
                    this.buffer = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
                    this.actual.onSubscribe(this);
                    this.timer = this.f325w.schedulePeriodically(this, this.timespan, this.timespan, this.unit);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    disposable.dispose();
                    EmptyDisposable.error(th, this.actual);
                    this.f325w.dispose();
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r8) {
            /*
            r7 = this;
            monitor-enter(r7);
            r0 = r7.buffer;	 Catch:{ all -> 0x0069 }
            if (r0 != 0) goto L_0x0007;
        L_0x0005:
            monitor-exit(r7);	 Catch:{ all -> 0x0069 }
            return;
        L_0x0007:
            r0.add(r8);	 Catch:{ all -> 0x0069 }
            r8 = r0.size();	 Catch:{ all -> 0x0069 }
            r1 = r7.maxSize;	 Catch:{ all -> 0x0069 }
            if (r8 >= r1) goto L_0x0014;
        L_0x0012:
            monitor-exit(r7);	 Catch:{ all -> 0x0069 }
            return;
        L_0x0014:
            r8 = 0;
            r7.buffer = r8;	 Catch:{ all -> 0x0069 }
            r1 = r7.producerIndex;	 Catch:{ all -> 0x0069 }
            r3 = 1;
            r5 = r1 + r3;
            r7.producerIndex = r5;	 Catch:{ all -> 0x0069 }
            monitor-exit(r7);	 Catch:{ all -> 0x0069 }
            r8 = r7.restartTimerOnMaxSize;
            if (r8 == 0) goto L_0x0029;
        L_0x0024:
            r8 = r7.timer;
            r8.dispose();
        L_0x0029:
            r8 = 0;
            r7.fastPathOrderedEmit(r0, r8, r7);
            r8 = r7.bufferSupplier;	 Catch:{ Throwable -> 0x005c }
            r8 = r8.call();	 Catch:{ Throwable -> 0x005c }
            r0 = "The buffer supplied is null";
            r8 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r8, r0);	 Catch:{ Throwable -> 0x005c }
            r8 = (java.util.Collection) r8;	 Catch:{ Throwable -> 0x005c }
            monitor-enter(r7);
            r7.buffer = r8;	 Catch:{ all -> 0x0059 }
            r0 = r7.consumerIndex;	 Catch:{ all -> 0x0059 }
            r5 = r0 + r3;
            r7.consumerIndex = r5;	 Catch:{ all -> 0x0059 }
            monitor-exit(r7);	 Catch:{ all -> 0x0059 }
            r8 = r7.restartTimerOnMaxSize;
            if (r8 == 0) goto L_0x0058;
        L_0x0049:
            r0 = r7.f325w;
            r2 = r7.timespan;
            r4 = r7.timespan;
            r6 = r7.unit;
            r1 = r7;
            r8 = r0.schedulePeriodically(r1, r2, r4, r6);
            r7.timer = r8;
        L_0x0058:
            return;
        L_0x0059:
            r8 = move-exception;
            monitor-exit(r7);	 Catch:{ all -> 0x0059 }
            throw r8;
        L_0x005c:
            r8 = move-exception;
            io.reactivex.exceptions.Exceptions.throwIfFatal(r8);
            r0 = r7.actual;
            r0.onError(r8);
            r7.dispose();
            return;
        L_0x0069:
            r8 = move-exception;
            monitor-exit(r7);	 Catch:{ all -> 0x0069 }
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferExactBoundedObserver.onNext(java.lang.Object):void");
        }

        public void onError(Throwable th) {
            synchronized (this) {
                this.buffer = null;
            }
            this.actual.onError(th);
            this.f325w.dispose();
        }

        public void onComplete() {
            Collection collection;
            this.f325w.dispose();
            synchronized (this) {
                collection = this.buffer;
                this.buffer = null;
            }
            this.queue.offer(collection);
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainLoop(this.queue, this.actual, false, this, this);
            }
        }

        public void accept(Observer<? super U> observer, U u) {
            observer.onNext(u);
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.f324s.dispose();
                this.f325w.dispose();
                synchronized (this) {
                    this.buffer = null;
                }
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public void run() {
            try {
                Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    Collection collection2 = this.buffer;
                    if (collection2 != null) {
                        if (this.producerIndex == this.consumerIndex) {
                            this.buffer = collection;
                            fastPathOrderedEmit(collection2, false, this);
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                this.actual.onError(th);
            }
        }
    }

    static final class BufferExactUnboundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        U buffer;
        final Callable<U> bufferSupplier;
        Disposable f326s;
        final Scheduler scheduler;
        final AtomicReference<Disposable> timer = new AtomicReference();
        final long timespan;
        final TimeUnit unit;

        BufferExactUnboundedObserver(Observer<? super U> observer, Callable<U> callable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, new MpscLinkedQueue());
            this.bufferSupplier = callable;
            this.timespan = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f326s, disposable)) {
                this.f326s = disposable;
                try {
                    this.buffer = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
                    this.actual.onSubscribe(this);
                    if (this.cancelled == null) {
                        disposable = this.scheduler.schedulePeriodicallyDirect(this, this.timespan, this.timespan, this.unit);
                        if (!this.timer.compareAndSet(null, disposable)) {
                            disposable.dispose();
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    dispose();
                    EmptyDisposable.error(th, this.actual);
                }
            }
        }

        public void onNext(T t) {
            synchronized (this) {
                Collection collection = this.buffer;
                if (collection == null) {
                    return;
                }
                collection.add(t);
            }
        }

        public void onError(Throwable th) {
            synchronized (this) {
                this.buffer = null;
            }
            this.actual.onError(th);
            DisposableHelper.dispose(this.timer);
        }

        public void onComplete() {
            synchronized (this) {
                Collection collection = this.buffer;
                this.buffer = null;
            }
            if (collection != null) {
                this.queue.offer(collection);
                this.done = true;
                if (enter()) {
                    QueueDrainHelper.drainLoop(this.queue, this.actual, false, null, this);
                }
            }
            DisposableHelper.dispose(this.timer);
        }

        public void dispose() {
            DisposableHelper.dispose(this.timer);
            this.f326s.dispose();
        }

        public boolean isDisposed() {
            return this.timer.get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            try {
                Collection collection;
                Collection collection2 = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    collection = this.buffer;
                    if (collection != null) {
                        this.buffer = collection2;
                    }
                }
                if (collection == null) {
                    DisposableHelper.dispose(this.timer);
                } else {
                    fastPathEmit(collection, false, this);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.actual.onError(th);
                dispose();
            }
        }

        public void accept(Observer<? super U> observer, U u) {
            this.actual.onNext(u);
        }
    }

    static final class BufferSkipBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        final Callable<U> bufferSupplier;
        final List<U> buffers = new LinkedList();
        Disposable f327s;
        final long timeskip;
        final long timespan;
        final TimeUnit unit;
        final Worker f328w;

        final class RemoveFromBuffer implements Runnable {
            private final U f30b;

            RemoveFromBuffer(U u) {
                this.f30b = u;
            }

            public void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.buffers.remove(this.f30b);
                }
                BufferSkipBoundedObserver.this.fastPathOrderedEmit(this.f30b, false, BufferSkipBoundedObserver.this.f328w);
            }
        }

        final class RemoveFromBufferEmit implements Runnable {
            private final U buffer;

            RemoveFromBufferEmit(U u) {
                this.buffer = u;
            }

            public void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.buffers.remove(this.buffer);
                }
                BufferSkipBoundedObserver.this.fastPathOrderedEmit(this.buffer, false, BufferSkipBoundedObserver.this.f328w);
            }
        }

        BufferSkipBoundedObserver(Observer<? super U> observer, Callable<U> callable, long j, long j2, TimeUnit timeUnit, Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.bufferSupplier = callable;
            this.timespan = j;
            this.timeskip = j2;
            this.unit = timeUnit;
            this.f328w = worker;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f327s, disposable)) {
                this.f327s = disposable;
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
                    this.buffers.add(collection);
                    this.actual.onSubscribe(this);
                    this.f328w.schedulePeriodically(this, this.timeskip, this.timeskip, this.unit);
                    this.f328w.schedule(new RemoveFromBufferEmit(collection), this.timespan, this.unit);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    disposable.dispose();
                    EmptyDisposable.error(th, this.actual);
                    this.f328w.dispose();
                }
            }
        }

        public void onNext(T t) {
            synchronized (this) {
                for (Collection add : this.buffers) {
                    add.add(t);
                }
            }
        }

        public void onError(Throwable th) {
            this.done = true;
            clear();
            this.actual.onError(th);
            this.f328w.dispose();
        }

        public void onComplete() {
            synchronized (this) {
                List<Collection> arrayList = new ArrayList(this.buffers);
                this.buffers.clear();
            }
            for (Collection offer : arrayList) {
                this.queue.offer(offer);
            }
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainLoop(this.queue, this.actual, false, this.f328w, this);
            }
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                clear();
                this.f327s.dispose();
                this.f328w.dispose();
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        void clear() {
            synchronized (this) {
                this.buffers.clear();
            }
        }

        public void run() {
            if (!this.cancelled) {
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                    synchronized (this) {
                        if (this.cancelled) {
                            return;
                        }
                        this.buffers.add(collection);
                        this.f328w.schedule(new RemoveFromBuffer(collection), this.timespan, this.unit);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.actual.onError(th);
                    dispose();
                }
            }
        }

        public void accept(Observer<? super U> observer, U u) {
            observer.onNext(u);
        }
    }

    public ObservableBufferTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable, int i, boolean z) {
        super(observableSource);
        this.timespan = j;
        this.timeskip = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSupplier = callable;
        this.maxSize = i;
        this.restartTimerOnMaxSize = z;
    }

    protected void subscribeActual(Observer<? super U> observer) {
        if (this.timespan == this.timeskip && this.maxSize == Integer.MAX_VALUE) {
            this.source.subscribe(new BufferExactUnboundedObserver(new SerializedObserver(observer), this.bufferSupplier, this.timespan, this.unit, this.scheduler));
            return;
        }
        Worker createWorker = this.scheduler.createWorker();
        if (this.timespan == this.timeskip) {
            this.source.subscribe(new BufferExactBoundedObserver(new SerializedObserver(observer), this.bufferSupplier, this.timespan, this.unit, this.maxSize, this.restartTimerOnMaxSize, createWorker));
        } else {
            this.source.subscribe(new BufferSkipBoundedObserver(new SerializedObserver(observer), this.bufferSupplier, this.timespan, this.timeskip, this.unit, createWorker));
        }
    }
}
