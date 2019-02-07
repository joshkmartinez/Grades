package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableReplay<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T>, Disposable {
    static final BufferSupplier DEFAULT_UNBOUNDED_FACTORY = new UnBoundedFactory();
    final BufferSupplier<T> bufferFactory;
    final AtomicReference<ReplayObserver<T>> current;
    final ObservableSource<T> onSubscribe;
    final ObservableSource<T> source;

    interface BufferSupplier<T> {
        ReplayBuffer<T> call();
    }

    static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final Object value;

        Node(Object obj) {
            this.value = obj;
        }
    }

    interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerDisposable<T> innerDisposable);
    }

    static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        int size;
        Node tail;

        Object enterTransform(Object obj) {
            return obj;
        }

        Object leaveTransform(Object obj) {
            return obj;
        }

        abstract void truncate();

        void truncateFinal() {
        }

        BoundedReplayBuffer() {
            Node node = new Node(null);
            this.tail = node;
            set(node);
        }

        final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        final void removeFirst() {
            Node node = (Node) ((Node) get()).get();
            this.size--;
            setFirst(node);
        }

        final void removeSome(int i) {
            Node node = (Node) get();
            while (i > 0) {
                node = (Node) node.get();
                i--;
                this.size--;
            }
            setFirst(node);
        }

        final void setFirst(Node node) {
            set(node);
        }

        public final void next(T t) {
            addLast(new Node(enterTransform(NotificationLite.next(t))));
            truncate();
        }

        public final void error(Throwable th) {
            addLast(new Node(enterTransform(NotificationLite.error(th))));
            truncateFinal();
        }

        public final void complete() {
            addLast(new Node(enterTransform(NotificationLite.complete())));
            truncateFinal();
        }

        public final void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() == 0) {
                int i = 1;
                do {
                    Node node = (Node) innerDisposable.index();
                    if (node == null) {
                        node = getHead();
                        innerDisposable.index = node;
                    }
                    while (!innerDisposable.isDisposed()) {
                        Node node2 = (Node) node.get();
                        if (node2 == null) {
                            innerDisposable.index = node;
                            i = innerDisposable.addAndGet(-i);
                        } else if (NotificationLite.accept(leaveTransform(node2.value), innerDisposable.child)) {
                            innerDisposable.index = null;
                            return;
                        } else {
                            node = node2;
                        }
                    }
                    return;
                } while (i != 0);
            }
        }

        final void collect(Collection<? super T> collection) {
            Node head = getHead();
            while (true) {
                head = (Node) head.get();
                if (head != null) {
                    Object leaveTransform = leaveTransform(head.value);
                    if (!NotificationLite.isComplete(leaveTransform)) {
                        if (!NotificationLite.isError(leaveTransform)) {
                            collection.add(NotificationLite.getValue(leaveTransform));
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            }
        }

        boolean hasError() {
            return this.tail.value != null && NotificationLite.isError(leaveTransform(this.tail.value));
        }

        boolean hasCompleted() {
            return this.tail.value != null && NotificationLite.isComplete(leaveTransform(this.tail.value));
        }

        Node getHead() {
            return (Node) get();
        }
    }

    static final class DisposeConsumer<R> implements Consumer<Disposable> {
        private final ObserverResourceWrapper<R> srw;

        DisposeConsumer(ObserverResourceWrapper<R> observerResourceWrapper) {
            this.srw = observerResourceWrapper;
        }

        public void accept(Disposable disposable) {
            this.srw.setResource(disposable);
        }
    }

    static final class InnerDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 2728361546769921047L;
        volatile boolean cancelled;
        final Observer<? super T> child;
        Object index;
        final ReplayObserver<T> parent;

        InnerDisposable(ReplayObserver<T> replayObserver, Observer<? super T> observer) {
            this.parent = replayObserver;
            this.child = observer;
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.parent.remove(this);
            }
        }

        <U> U index() {
            return this.index;
        }
    }

    static final class ReplayBufferSupplier<T> implements BufferSupplier<T> {
        private final int bufferSize;

        ReplayBufferSupplier(int i) {
            this.bufferSize = i;
        }

        public ReplayBuffer<T> call() {
            return new SizeBoundReplayBuffer(this.bufferSize);
        }
    }

    static final class ReplayObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        static final InnerDisposable[] EMPTY = new InnerDisposable[0];
        static final InnerDisposable[] TERMINATED = new InnerDisposable[0];
        private static final long serialVersionUID = -533785617179540163L;
        final ReplayBuffer<T> buffer;
        boolean done;
        final AtomicReference<InnerDisposable[]> observers = new AtomicReference(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        ReplayObserver(ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
        }

        public boolean isDisposed() {
            return this.observers.get() == TERMINATED;
        }

        public void dispose() {
            this.observers.set(TERMINATED);
            DisposableHelper.dispose(this);
        }

        boolean add(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            Object obj;
            do {
                innerDisposableArr = (InnerDisposable[]) this.observers.get();
                if (innerDisposableArr == TERMINATED) {
                    return false;
                }
                int length = innerDisposableArr.length;
                obj = new InnerDisposable[(length + 1)];
                System.arraycopy(innerDisposableArr, 0, obj, 0, length);
                obj[length] = innerDisposable;
            } while (!this.observers.compareAndSet(innerDisposableArr, obj));
            return true;
        }

        void remove(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            Object obj;
            do {
                innerDisposableArr = (InnerDisposable[]) this.observers.get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i = -1;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (innerDisposableArr[i2].equals(innerDisposable)) {
                            i = i2;
                            break;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            obj = EMPTY;
                        } else {
                            Object obj2 = new InnerDisposable[(length - 1)];
                            System.arraycopy(innerDisposableArr, 0, obj2, 0, i);
                            System.arraycopy(innerDisposableArr, i + 1, obj2, i, (length - i) - 1);
                            obj = obj2;
                        }
                    } else {
                        return;
                    }
                }
                return;
            } while (!this.observers.compareAndSet(innerDisposableArr, obj));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) != null) {
                replay();
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                this.buffer.next(t);
                replay();
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.buffer.error(th);
            replayFinal();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.buffer.complete();
                replayFinal();
            }
        }

        void replay() {
            for (InnerDisposable replay : (InnerDisposable[]) this.observers.get()) {
                this.buffer.replay(replay);
            }
        }

        void replayFinal() {
            for (InnerDisposable replay : (InnerDisposable[]) this.observers.getAndSet(TERMINATED)) {
                this.buffer.replay(replay);
            }
        }
    }

    static final class ReplaySource<T> implements ObservableSource<T> {
        private final BufferSupplier<T> bufferFactory;
        private final AtomicReference<ReplayObserver<T>> curr;

        ReplaySource(AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
            this.curr = atomicReference;
            this.bufferFactory = bufferSupplier;
        }

        public void subscribe(Observer<? super T> observer) {
            ReplayObserver replayObserver;
            ReplayObserver replayObserver2;
            while (true) {
                replayObserver = (ReplayObserver) this.curr.get();
                if (replayObserver != null) {
                    break;
                }
                replayObserver2 = new ReplayObserver(this.bufferFactory.call());
                if (this.curr.compareAndSet(null, replayObserver2)) {
                    break;
                }
            }
            replayObserver = replayObserver2;
            InnerDisposable innerDisposable = new InnerDisposable(replayObserver, observer);
            observer.onSubscribe(innerDisposable);
            replayObserver.add(innerDisposable);
            if (innerDisposable.isDisposed() != null) {
                replayObserver.remove(innerDisposable);
            } else {
                replayObserver.buffer.replay(innerDisposable);
            }
        }
    }

    static final class ScheduledReplaySupplier<T> implements BufferSupplier<T> {
        private final int bufferSize;
        private final long maxAge;
        private final Scheduler scheduler;
        private final TimeUnit unit;

        ScheduledReplaySupplier(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.bufferSize = i;
            this.maxAge = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        public ReplayBuffer<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler);
        }
    }

    static final class UnBoundedFactory implements BufferSupplier<Object> {
        UnBoundedFactory() {
        }

        public ReplayBuffer<Object> call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        UnboundedReplayBuffer(int i) {
            super(i);
        }

        public void next(T t) {
            add(NotificationLite.next(t));
            this.size++;
        }

        public void error(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        public void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() == 0) {
                Observer observer = innerDisposable.child;
                int i = 1;
                while (!innerDisposable.isDisposed()) {
                    int i2 = this.size;
                    Integer num = (Integer) innerDisposable.index();
                    int intValue = num != null ? num.intValue() : 0;
                    while (intValue < i2) {
                        if (!NotificationLite.accept(get(intValue), observer) && !innerDisposable.isDisposed()) {
                            intValue++;
                        } else {
                            return;
                        }
                    }
                    innerDisposable.index = Integer.valueOf(intValue);
                    i = innerDisposable.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    static final class MulticastReplay<R, U> extends Observable<R> {
        private final Callable<? extends ConnectableObservable<U>> connectableFactory;
        private final Function<? super Observable<U>, ? extends ObservableSource<R>> selector;

        MulticastReplay(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
            this.connectableFactory = callable;
            this.selector = function;
        }

        protected void subscribeActual(Observer<? super R> observer) {
            try {
                ConnectableObservable connectableObservable = (ConnectableObservable) ObjectHelper.requireNonNull(this.connectableFactory.call(), "The connectableFactory returned a null ConnectableObservable");
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.selector.apply(connectableObservable), "The selector returned a null ObservableSource");
                Object observerResourceWrapper = new ObserverResourceWrapper(observer);
                observableSource.subscribe(observerResourceWrapper);
                connectableObservable.connect(new DisposeConsumer(observerResourceWrapper));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, (Observer) observer);
            }
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final Scheduler scheduler;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.scheduler = scheduler;
            this.limit = i;
            this.maxAge = j;
            this.unit = timeUnit;
        }

        Object enterTransform(Object obj) {
            return new Timed(obj, this.scheduler.now(this.unit), this.unit);
        }

        Object leaveTransform(Object obj) {
            return ((Timed) obj).value();
        }

        void truncate() {
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node = (Node) get();
            Node node2 = (Node) node.get();
            int i = 0;
            while (true) {
                Node node3 = node2;
                node2 = node;
                node = node3;
                if (node != null) {
                    if (this.size <= this.limit) {
                        if (((Timed) node.value).time() > now) {
                            break;
                        }
                        i++;
                        this.size--;
                        node2 = (Node) node.get();
                    } else {
                        i++;
                        this.size--;
                        node2 = (Node) node.get();
                    }
                } else {
                    break;
                }
            }
            if (i != 0) {
                setFirst(node2);
            }
        }

        void truncateFinal() {
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node = (Node) get();
            Node node2 = (Node) node.get();
            int i = 0;
            while (true) {
                Node node3 = node2;
                node2 = node;
                node = node3;
                if (node != null && this.size > 1 && ((Timed) node.value).time() <= now) {
                    i++;
                    this.size--;
                    node2 = (Node) node.get();
                } else if (i != 0) {
                    setFirst(node2);
                }
            }
            if (i != 0) {
                setFirst(node2);
            }
        }

        Node getHead() {
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node = (Node) get();
            Node node2 = (Node) node.get();
            while (true) {
                Node node3 = node2;
                node2 = node;
                node = node3;
                if (node != null) {
                    Timed timed = (Timed) node.value;
                    if (!NotificationLite.isComplete(timed.value())) {
                        if (!NotificationLite.isError(timed.value())) {
                            if (timed.time() > now) {
                                break;
                            }
                            node2 = (Node) node.get();
                        } else {
                            break;
                        }
                    }
                    break;
                }
                break;
            }
            return node2;
        }
    }

    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        SizeBoundReplayBuffer(int i) {
            this.limit = i;
        }

        void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    static final class Replay<T> extends ConnectableObservable<T> {
        private final ConnectableObservable<T> co;
        private final Observable<T> observable;

        Replay(ConnectableObservable<T> connectableObservable, Observable<T> observable) {
            this.co = connectableObservable;
            this.observable = observable;
        }

        public void connect(Consumer<? super Disposable> consumer) {
            this.co.connect(consumer);
        }

        protected void subscribeActual(Observer<? super T> observer) {
            this.observable.subscribe((Observer) observer);
        }
    }

    public static <U, R> Observable<R> multicastSelector(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
        return RxJavaPlugins.onAssembly(new MulticastReplay(callable, function));
    }

    public static <T> ConnectableObservable<T> observeOn(ConnectableObservable<T> connectableObservable, Scheduler scheduler) {
        return RxJavaPlugins.onAssembly(new Replay(connectableObservable, connectableObservable.observeOn(scheduler)));
    }

    public static <T> ConnectableObservable<T> createFrom(ObservableSource<? extends T> observableSource) {
        return create((ObservableSource) observableSource, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, int i) {
        if (i == Integer.MAX_VALUE) {
            return createFrom(observableSource);
        }
        return create((ObservableSource) observableSource, new ReplayBufferSupplier(i));
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return create(observableSource, j, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return create((ObservableSource) observableSource, new ScheduledReplaySupplier(i, j, timeUnit, scheduler));
    }

    static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, BufferSupplier<T> bufferSupplier) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly(new ObservableReplay(new ReplaySource(atomicReference, bufferSupplier), observableSource, atomicReference, bufferSupplier));
    }

    private ObservableReplay(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
        this.onSubscribe = observableSource;
        this.source = observableSource2;
        this.current = atomicReference;
        this.bufferFactory = bufferSupplier;
    }

    public ObservableSource<T> source() {
        return this.source;
    }

    public void dispose() {
        this.current.lazySet(null);
    }

    public boolean isDisposed() {
        Disposable disposable = (Disposable) this.current.get();
        if (disposable != null) {
            if (!disposable.isDisposed()) {
                return false;
            }
        }
        return true;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.onSubscribe.subscribe(observer);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> r5) {
        /*
        r4 = this;
    L_0x0000:
        r0 = r4.current;
        r0 = r0.get();
        r0 = (io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver) r0;
        if (r0 == 0) goto L_0x0010;
    L_0x000a:
        r1 = r0.isDisposed();
        if (r1 == 0) goto L_0x0025;
    L_0x0010:
        r1 = r4.bufferFactory;
        r1 = r1.call();
        r2 = new io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver;
        r2.<init>(r1);
        r1 = r4.current;
        r0 = r1.compareAndSet(r0, r2);
        if (r0 != 0) goto L_0x0024;
    L_0x0023:
        goto L_0x0000;
    L_0x0024:
        r0 = r2;
    L_0x0025:
        r1 = r0.shouldConnect;
        r1 = r1.get();
        r2 = 1;
        r3 = 0;
        if (r1 != 0) goto L_0x0039;
    L_0x002f:
        r1 = r0.shouldConnect;
        r1 = r1.compareAndSet(r3, r2);
        if (r1 == 0) goto L_0x0039;
    L_0x0037:
        r1 = r2;
        goto L_0x003a;
    L_0x0039:
        r1 = r3;
    L_0x003a:
        r5.accept(r0);	 Catch:{ Throwable -> 0x0045 }
        if (r1 == 0) goto L_0x0044;
    L_0x003f:
        r5 = r4.source;
        r5.subscribe(r0);
    L_0x0044:
        return;
    L_0x0045:
        r5 = move-exception;
        if (r1 == 0) goto L_0x004d;
    L_0x0048:
        r0 = r0.shouldConnect;
        r0.compareAndSet(r2, r3);
    L_0x004d:
        io.reactivex.exceptions.Exceptions.throwIfFatal(r5);
        r5 = io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(r5);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay.connect(io.reactivex.functions.Consumer):void");
    }
}
