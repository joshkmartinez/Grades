package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, Disposable {
    static final Callable DEFAULT_UNBOUNDED_FACTORY = new DefaultUnboundedFactory();
    final Callable<? extends ReplayBuffer<T>> bufferFactory;
    final AtomicReference<ReplaySubscriber<T>> current;
    final Publisher<T> onSubscribe;
    final Flowable<T> source;

    static final class DefaultUnboundedFactory implements Callable<Object> {
        DefaultUnboundedFactory() {
        }

        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        Node(Object obj, long j) {
            this.value = obj;
            this.index = j;
        }
    }

    interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerSubscription<T> innerSubscription);
    }

    static final class ReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        private final int bufferSize;

        ReplayBufferTask(int i) {
            this.bufferSize = i;
        }

        public ReplayBuffer<T> call() {
            return new SizeBoundReplayBuffer(this.bufferSize);
        }
    }

    static final class ScheduledReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        private final int bufferSize;
        private final long maxAge;
        private final Scheduler scheduler;
        private final TimeUnit unit;

        ScheduledReplayBufferTask(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.bufferSize = i;
            this.maxAge = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        public ReplayBuffer<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler);
        }
    }

    static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        Node tail;

        Object enterTransform(Object obj) {
            return obj;
        }

        Object leaveTransform(Object obj) {
            return obj;
        }

        public final void replay(io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> r18) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.fixSplitterBlock(BlockFinish.java:63)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:34)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r17 = this;
            r1 = r18;
            monitor-enter(r18);
            r0 = r1.emitting;	 Catch:{ all -> 0x00a9 }
            r2 = 1;	 Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x000c;	 Catch:{ all -> 0x00a9 }
        L_0x0008:
            r1.missed = r2;	 Catch:{ all -> 0x00a9 }
            monitor-exit(r18);	 Catch:{ all -> 0x00a9 }
            return;	 Catch:{ all -> 0x00a9 }
        L_0x000c:
            r1.emitting = r2;	 Catch:{ all -> 0x00a9 }
            monitor-exit(r18);	 Catch:{ all -> 0x00a9 }
        L_0x000f:
            r0 = r18.isDisposed();
            if (r0 == 0) goto L_0x0016;
        L_0x0015:
            return;
        L_0x0016:
            r3 = r18.get();
            r5 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
            r5 = 0;
            if (r0 != 0) goto L_0x0026;
        L_0x0024:
            r0 = r2;
            goto L_0x0027;
        L_0x0026:
            r0 = r5;
        L_0x0027:
            r6 = r18.index();
            r6 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r6;
            r7 = 0;
            if (r6 != 0) goto L_0x003e;
        L_0x0031:
            r6 = r17.getHead();
            r1.index = r6;
            r9 = r1.totalRequested;
            r10 = r6.index;
            io.reactivex.internal.util.BackpressureHelper.add(r9, r10);
        L_0x003e:
            r9 = r7;
        L_0x003f:
            r11 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
            if (r11 == 0) goto L_0x008b;
        L_0x0043:
            r11 = r6.get();
            r11 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r11;
            if (r11 == 0) goto L_0x008b;
        L_0x004b:
            r6 = r11.value;
            r12 = r17;
            r6 = r12.leaveTransform(r6);
            r13 = 0;
            r14 = r1.child;	 Catch:{ Throwable -> 0x0070 }
            r14 = io.reactivex.internal.util.NotificationLite.accept(r6, r14);	 Catch:{ Throwable -> 0x0070 }
            if (r14 == 0) goto L_0x005f;	 Catch:{ Throwable -> 0x0070 }
        L_0x005c:
            r1.index = r13;	 Catch:{ Throwable -> 0x0070 }
            return;
        L_0x005f:
            r13 = 1;
            r15 = r9 + r13;
            r9 = r3 - r13;
            r3 = r18.isDisposed();
            if (r3 == 0) goto L_0x006c;
        L_0x006b:
            return;
        L_0x006c:
            r3 = r9;
            r6 = r11;
            r9 = r15;
            goto L_0x003f;
        L_0x0070:
            r0 = move-exception;
            io.reactivex.exceptions.Exceptions.throwIfFatal(r0);
            r1.index = r13;
            r18.dispose();
            r2 = io.reactivex.internal.util.NotificationLite.isError(r6);
            if (r2 != 0) goto L_0x008a;
        L_0x007f:
            r2 = io.reactivex.internal.util.NotificationLite.isComplete(r6);
            if (r2 != 0) goto L_0x008a;
        L_0x0085:
            r1 = r1.child;
            r1.onError(r0);
        L_0x008a:
            return;
        L_0x008b:
            r12 = r17;
            r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));
            if (r3 == 0) goto L_0x0098;
        L_0x0091:
            r1.index = r6;
            if (r0 != 0) goto L_0x0098;
        L_0x0095:
            r1.produced(r9);
        L_0x0098:
            monitor-enter(r18);
            r0 = r1.missed;
            if (r0 != 0) goto L_0x00a1;
        L_0x009d:
            r1.emitting = r5;
            monitor-exit(r18);
            return;
        L_0x00a1:
            r1.missed = r5;
            monitor-exit(r18);
            goto L_0x000f;
        L_0x00a6:
            r0 = move-exception;
            monitor-exit(r18);
            throw r0;
        L_0x00a9:
            r0 = move-exception;
            r12 = r17;
        L_0x00ac:
            monitor-exit(r18);	 Catch:{ all -> 0x00ae }
            throw r0;
        L_0x00ae:
            r0 = move-exception;
            goto L_0x00ac;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer.replay(io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
        }

        void truncate() {
        }

        void truncateFinal() {
        }

        BoundedReplayBuffer() {
            Node node = new Node(null, 0);
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
            if (node != null) {
                this.size--;
                setFirst(node);
                return;
            }
            throw new IllegalStateException("Empty list!");
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
            t = enterTransform(NotificationLite.next(t));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(t, j));
            truncate();
        }

        public final void error(Throwable th) {
            th = enterTransform(NotificationLite.error(th));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(th, j));
            truncateFinal();
        }

        public final void complete() {
            Object enterTransform = enterTransform(NotificationLite.complete());
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
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

    static final class InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
        static final long CANCELLED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        InnerSubscription(ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
            this.parent = replaySubscriber;
            this.child = subscriber;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                long j2;
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        if (j2 >= 0 && j == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, BackpressureHelper.addCap(j2, j)));
                BackpressureHelper.add(this.totalRequested, j);
                this.parent.manageRequests();
                this.parent.buffer.replay(this);
            }
        }

        public long produced(long j) {
            return BackpressureHelper.producedCancel(this, j);
        }

        public boolean isDisposed() {
            return get() == Long.MIN_VALUE;
        }

        public void cancel() {
            dispose();
        }

        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.manageRequests();
            }
        }

        <U> U index() {
            return this.index;
        }
    }

    static final class MultiCastPublisher<R, U> implements Publisher<R> {
        private final Callable<? extends ConnectableFlowable<U>> connectableFactory;
        private final Function<? super Flowable<U>, ? extends Publisher<R>> selector;

        final class DisposableConsumer implements Consumer<Disposable> {
            private final SubscriberResourceWrapper<R> srw;

            DisposableConsumer(SubscriberResourceWrapper<R> subscriberResourceWrapper) {
                this.srw = subscriberResourceWrapper;
            }

            public void accept(Disposable disposable) {
                this.srw.setResource(disposable);
            }
        }

        MultiCastPublisher(Callable<? extends ConnectableFlowable<U>> callable, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
            this.connectableFactory = callable;
            this.selector = function;
        }

        public void subscribe(Subscriber<? super R> subscriber) {
            try {
                ConnectableFlowable connectableFlowable = (ConnectableFlowable) ObjectHelper.requireNonNull(this.connectableFactory.call(), "The connectableFactory returned null");
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.selector.apply(connectableFlowable), "The selector returned a null Publisher");
                    Object subscriberResourceWrapper = new SubscriberResourceWrapper(subscriber);
                    publisher.subscribe(subscriberResourceWrapper);
                    connectableFlowable.connect(new DisposableConsumer(subscriberResourceWrapper));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, subscriber);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, subscriber);
            }
        }
    }

    static final class ReplayPublisher<T> implements Publisher<T> {
        private final Callable<? extends ReplayBuffer<T>> bufferFactory;
        private final AtomicReference<ReplaySubscriber<T>> curr;

        ReplayPublisher(AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends ReplayBuffer<T>> callable) {
            this.curr = atomicReference;
            this.bufferFactory = callable;
        }

        public void subscribe(Subscriber<? super T> subscriber) {
            ReplaySubscriber replaySubscriber;
            ReplaySubscriber replaySubscriber2;
            while (true) {
                replaySubscriber = (ReplaySubscriber) this.curr.get();
                if (replaySubscriber != null) {
                    break;
                }
                try {
                    replaySubscriber2 = new ReplaySubscriber((ReplayBuffer) this.bufferFactory.call());
                    if (this.curr.compareAndSet(null, replaySubscriber2)) {
                        break;
                    }
                } catch (Subscriber<? super T> subscriber2) {
                    Exceptions.throwIfFatal(subscriber2);
                    subscriber2 = ExceptionHelper.wrapOrThrow(subscriber2);
                }
            }
            replaySubscriber = replaySubscriber2;
            InnerSubscription innerSubscription = new InnerSubscription(replaySubscriber, subscriber2);
            subscriber2.onSubscribe(innerSubscription);
            replaySubscriber.add(innerSubscription);
            if (innerSubscription.isDisposed() != null) {
                replaySubscriber.remove(innerSubscription);
                return;
            }
            replaySubscriber.manageRequests();
            replaySubscriber.buffer.replay(innerSubscription);
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

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replay(io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> r19) {
            /*
            r18 = this;
            r1 = r18;
            r2 = r19;
            monitor-enter(r19);
            r0 = r2.emitting;	 Catch:{ all -> 0x0095 }
            r3 = 1;
            if (r0 == 0) goto L_0x000e;
        L_0x000a:
            r2.missed = r3;	 Catch:{ all -> 0x0095 }
            monitor-exit(r19);	 Catch:{ all -> 0x0095 }
            return;
        L_0x000e:
            r2.emitting = r3;	 Catch:{ all -> 0x0095 }
            monitor-exit(r19);	 Catch:{ all -> 0x0095 }
            r3 = r2.child;
        L_0x0013:
            r0 = r19.isDisposed();
            if (r0 == 0) goto L_0x001a;
        L_0x0019:
            return;
        L_0x001a:
            r0 = r1.size;
            r4 = r19.index();
            r4 = (java.lang.Integer) r4;
            r5 = 0;
            if (r4 == 0) goto L_0x002a;
        L_0x0025:
            r4 = r4.intValue();
            goto L_0x002b;
        L_0x002a:
            r4 = r5;
        L_0x002b:
            r6 = r19.get();
            r8 = 0;
            r10 = r6;
            r12 = r8;
        L_0x0033:
            r14 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
            if (r14 == 0) goto L_0x006f;
        L_0x0037:
            if (r4 >= r0) goto L_0x006f;
        L_0x0039:
            r14 = r1.get(r4);
            r15 = io.reactivex.internal.util.NotificationLite.accept(r14, r3);	 Catch:{ Throwable -> 0x0057 }
            if (r15 == 0) goto L_0x0044;
        L_0x0043:
            return;
        L_0x0044:
            r14 = r19.isDisposed();
            if (r14 == 0) goto L_0x004b;
        L_0x004a:
            return;
        L_0x004b:
            r4 = r4 + 1;
            r14 = 1;
            r16 = r10 - r14;
            r10 = r12 + r14;
            r12 = r10;
            r10 = r16;
            goto L_0x0033;
        L_0x0057:
            r0 = move-exception;
            r4 = r0;
            io.reactivex.exceptions.Exceptions.throwIfFatal(r4);
            r19.dispose();
            r0 = io.reactivex.internal.util.NotificationLite.isError(r14);
            if (r0 != 0) goto L_0x006e;
        L_0x0065:
            r0 = io.reactivex.internal.util.NotificationLite.isComplete(r14);
            if (r0 != 0) goto L_0x006e;
        L_0x006b:
            r3.onError(r4);
        L_0x006e:
            return;
        L_0x006f:
            r0 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1));
            if (r0 == 0) goto L_0x0085;
        L_0x0073:
            r0 = java.lang.Integer.valueOf(r4);
            r2.index = r0;
            r8 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
            if (r0 == 0) goto L_0x0085;
        L_0x0082:
            r2.produced(r12);
        L_0x0085:
            monitor-enter(r19);
            r0 = r2.missed;	 Catch:{ all -> 0x0092 }
            if (r0 != 0) goto L_0x008e;
        L_0x008a:
            r2.emitting = r5;	 Catch:{ all -> 0x0092 }
            monitor-exit(r19);	 Catch:{ all -> 0x0092 }
            return;
        L_0x008e:
            r2.missed = r5;	 Catch:{ all -> 0x0092 }
            monitor-exit(r19);	 Catch:{ all -> 0x0092 }
            goto L_0x0013;
        L_0x0092:
            r0 = move-exception;
            monitor-exit(r19);	 Catch:{ all -> 0x0092 }
            throw r0;
        L_0x0095:
            r0 = move-exception;
            monitor-exit(r19);	 Catch:{ all -> 0x0095 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.UnboundedReplayBuffer.replay(io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
        }
    }

    static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscription[] EMPTY = new InnerSubscription[0];
        static final InnerSubscription[] TERMINATED = new InnerSubscription[0];
        private static final long serialVersionUID = 7224554242710036740L;
        final ReplayBuffer<T> buffer;
        boolean done;
        final AtomicInteger management = new AtomicInteger();
        long maxChildRequested;
        long maxUpstreamRequested;
        final AtomicBoolean shouldConnect = new AtomicBoolean();
        final AtomicReference<InnerSubscription<T>[]> subscribers = new AtomicReference(EMPTY);

        ReplaySubscriber(ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
        }

        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        public void dispose() {
            this.subscribers.set(TERMINATED);
            SubscriptionHelper.cancel(this);
        }

        boolean add(InnerSubscription<T> innerSubscription) {
            if (innerSubscription != null) {
                InnerSubscription[] innerSubscriptionArr;
                Object obj;
                do {
                    innerSubscriptionArr = (InnerSubscription[]) this.subscribers.get();
                    if (innerSubscriptionArr == TERMINATED) {
                        return false;
                    }
                    int length = innerSubscriptionArr.length;
                    obj = new InnerSubscription[(length + 1)];
                    System.arraycopy(innerSubscriptionArr, 0, obj, 0, length);
                    obj[length] = innerSubscription;
                } while (!this.subscribers.compareAndSet(innerSubscriptionArr, obj));
                return true;
            }
            throw new NullPointerException();
        }

        void remove(InnerSubscription<T> innerSubscription) {
            InnerSubscription[] innerSubscriptionArr;
            Object obj;
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.subscribers.get();
                int length = innerSubscriptionArr.length;
                if (length != 0) {
                    int i = -1;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (innerSubscriptionArr[i2].equals(innerSubscription)) {
                            i = i2;
                            break;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            obj = EMPTY;
                        } else {
                            Object obj2 = new InnerSubscription[(length - 1)];
                            System.arraycopy(innerSubscriptionArr, 0, obj2, 0, i);
                            System.arraycopy(innerSubscriptionArr, i + 1, obj2, i, (length - i) - 1);
                            obj = obj2;
                        }
                    } else {
                        return;
                    }
                }
                return;
            } while (!this.subscribers.compareAndSet(innerSubscriptionArr, obj));
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription) != null) {
                manageRequests();
                for (InnerSubscription replay : (InnerSubscription[]) this.subscribers.get()) {
                    this.buffer.replay(replay);
                }
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                this.buffer.next(t);
                for (InnerSubscription replay : (InnerSubscription[]) this.subscribers.get()) {
                    this.buffer.replay(replay);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.buffer.error(th);
            for (InnerSubscription replay : (InnerSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                this.buffer.replay(replay);
            }
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.buffer.complete();
                for (InnerSubscription replay : (InnerSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                    this.buffer.replay(replay);
                }
            }
        }

        void manageRequests() {
            if (this.management.getAndIncrement() == 0) {
                int i = 1;
                while (!isDisposed()) {
                    InnerSubscription[] innerSubscriptionArr = (InnerSubscription[]) this.subscribers.get();
                    long j = this.maxChildRequested;
                    long j2 = j;
                    for (InnerSubscription innerSubscription : innerSubscriptionArr) {
                        j2 = Math.max(j2, innerSubscription.totalRequested.get());
                    }
                    long j3 = this.maxUpstreamRequested;
                    Subscription subscription = (Subscription) get();
                    long j4 = j2 - j;
                    if (j4 != 0) {
                        this.maxChildRequested = j2;
                        if (subscription == null) {
                            j2 = j3 + j4;
                            if (j2 < 0) {
                                j2 = LongCompanionObject.MAX_VALUE;
                            }
                            this.maxUpstreamRequested = j2;
                        } else if (j3 != 0) {
                            this.maxUpstreamRequested = 0;
                            subscription.request(j3 + j4);
                        } else {
                            subscription.request(j4);
                        }
                    } else if (!(j3 == 0 || subscription == null)) {
                        this.maxUpstreamRequested = 0;
                        subscription.request(j3);
                    }
                    i = this.management.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
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

    static final class ConnectableFlowableReplay<T> extends ConnectableFlowable<T> {
        private final ConnectableFlowable<T> co;
        private final Flowable<T> observable;

        ConnectableFlowableReplay(ConnectableFlowable<T> connectableFlowable, Flowable<T> flowable) {
            this.co = connectableFlowable;
            this.observable = flowable;
        }

        public void connect(Consumer<? super Disposable> consumer) {
            this.co.connect(consumer);
        }

        protected void subscribeActual(Subscriber<? super T> subscriber) {
            this.observable.subscribe((Subscriber) subscriber);
        }
    }

    public static <U, R> Flowable<R> multicastSelector(Callable<? extends ConnectableFlowable<U>> callable, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
        return Flowable.unsafeCreate(new MultiCastPublisher(callable, function));
    }

    public static <T> ConnectableFlowable<T> observeOn(ConnectableFlowable<T> connectableFlowable, Scheduler scheduler) {
        return RxJavaPlugins.onAssembly(new ConnectableFlowableReplay(connectableFlowable, connectableFlowable.observeOn(scheduler)));
    }

    public static <T> ConnectableFlowable<T> createFrom(Flowable<? extends T> flowable) {
        return create((Flowable) flowable, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, int i) {
        if (i == Integer.MAX_VALUE) {
            return createFrom(flowable);
        }
        return create((Flowable) flowable, new ReplayBufferTask(i));
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return create(flowable, j, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return create((Flowable) flowable, new ScheduledReplayBufferTask(i, j, timeUnit, scheduler));
    }

    static <T> ConnectableFlowable<T> create(Flowable<T> flowable, Callable<? extends ReplayBuffer<T>> callable) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly(new FlowableReplay(new ReplayPublisher(atomicReference, callable), flowable, atomicReference, callable));
    }

    private FlowableReplay(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends ReplayBuffer<T>> callable) {
        this.onSubscribe = publisher;
        this.source = flowable;
        this.current = atomicReference;
        this.bufferFactory = callable;
    }

    public Publisher<T> source() {
        return this.source;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.onSubscribe.subscribe(subscriber);
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

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> r5) {
        /*
        r4 = this;
    L_0x0000:
        r0 = r4.current;
        r0 = r0.get();
        r0 = (io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber) r0;
        if (r0 == 0) goto L_0x0010;
    L_0x000a:
        r1 = r0.isDisposed();
        if (r1 == 0) goto L_0x0027;
    L_0x0010:
        r1 = r4.bufferFactory;	 Catch:{ Throwable -> 0x0057 }
        r1 = r1.call();	 Catch:{ Throwable -> 0x0057 }
        r1 = (io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer) r1;	 Catch:{ Throwable -> 0x0057 }
        r2 = new io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber;
        r2.<init>(r1);
        r1 = r4.current;
        r0 = r1.compareAndSet(r0, r2);
        if (r0 != 0) goto L_0x0026;
    L_0x0025:
        goto L_0x0000;
    L_0x0026:
        r0 = r2;
    L_0x0027:
        r1 = r0.shouldConnect;
        r1 = r1.get();
        r2 = 1;
        r3 = 0;
        if (r1 != 0) goto L_0x003b;
    L_0x0031:
        r1 = r0.shouldConnect;
        r1 = r1.compareAndSet(r3, r2);
        if (r1 == 0) goto L_0x003b;
    L_0x0039:
        r1 = r2;
        goto L_0x003c;
    L_0x003b:
        r1 = r3;
    L_0x003c:
        r5.accept(r0);	 Catch:{ Throwable -> 0x0047 }
        if (r1 == 0) goto L_0x0046;
    L_0x0041:
        r5 = r4.source;
        r5.subscribe(r0);
    L_0x0046:
        return;
    L_0x0047:
        r5 = move-exception;
        if (r1 == 0) goto L_0x004f;
    L_0x004a:
        r0 = r0.shouldConnect;
        r0.compareAndSet(r2, r3);
    L_0x004f:
        io.reactivex.exceptions.Exceptions.throwIfFatal(r5);
        r5 = io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(r5);
        throw r5;
    L_0x0057:
        r5 = move-exception;
        io.reactivex.exceptions.Exceptions.throwIfFatal(r5);
        r5 = io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(r5);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.connect(io.reactivex.functions.Consumer):void");
    }
}
