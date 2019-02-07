package kotlinx.coroutines.experimental.channels;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.experimental.JobKt;
import kotlinx.coroutines.experimental.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001/B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0016\u0010\u001f\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0002J\b\u0010!\u001a\u00020\u0010H\u0002J\u0015\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010$J\u0015\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010'J!\u0010(\u001a\u00020\t2\u0006\u0010&\u001a\u00028\u00002\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0014¢\u0006\u0002\u0010+J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0016J\b\u0010.\u001a\u00020\u001bH\u0002R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128TX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00128TX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u0012\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u0017X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ArrayBroadcastChannel;", "E", "Lkotlinx/coroutines/experimental/channels/AbstractSendChannel;", "Lkotlinx/coroutines/experimental/channels/BroadcastChannel;", "capacity", "", "(I)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getCapacity", "()I", "head", "", "isBufferAlwaysFull", "", "()Z", "isBufferFull", "size", "subs", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlinx/coroutines/experimental/channels/ArrayBroadcastChannel$Subscriber;", "tail", "checkSubOffers", "", "close", "cause", "", "closeSubscriber", "sub", "computeMinHead", "elementAt", "index", "(J)Ljava/lang/Object;", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/experimental/selects/SelectInstance;)Ljava/lang/Object;", "open", "Lkotlinx/coroutines/experimental/channels/SubscriptionReceiveChannel;", "updateHead", "Subscriber", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: ArrayBroadcastChannel.kt */
public final class ArrayBroadcastChannel<E> extends AbstractSendChannel<E> implements BroadcastChannel<E> {
    private final Object[] buffer;
    private final ReentrantLock bufferLock;
    private final int capacity;
    private volatile long head;
    private volatile int size;
    private final CopyOnWriteArrayList<Subscriber<E>> subs;
    private volatile long tail;

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\nH\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014J\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00162\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8TX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\f\u001a\u00020\n8TX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\n8TX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\n8TX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ArrayBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/experimental/channels/AbstractChannel;", "Lkotlinx/coroutines/experimental/channels/SubscriptionReceiveChannel;", "broadcastChannel", "Lkotlinx/coroutines/experimental/channels/ArrayBroadcastChannel;", "subHead", "", "(Lkotlinx/coroutines/experimental/channels/ArrayBroadcastChannel;J)V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "checkOffer", "close", "", "needsToCheckOfferWithoutLock", "peekUnderLock", "", "pollInternal", "pollSelectInternal", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: ArrayBroadcastChannel.kt */
    private static final class Subscriber<E> extends AbstractChannel<E> implements SubscriptionReceiveChannel<E> {
        private final ArrayBroadcastChannel<E> broadcastChannel;
        private final ReentrantLock lock = new ReentrantLock();
        @JvmField
        public volatile long subHead;

        protected boolean isBufferAlwaysEmpty() {
            return false;
        }

        public Subscriber(@NotNull ArrayBroadcastChannel<E> arrayBroadcastChannel, long j) {
            Intrinsics.checkParameterIsNotNull(arrayBroadcastChannel, "broadcastChannel");
            this.broadcastChannel = arrayBroadcastChannel;
            this.subHead = j;
        }

        protected boolean isBufferEmpty() {
            return this.subHead >= this.broadcastChannel.tail;
        }

        protected boolean isBufferAlwaysFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        protected boolean isBufferFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        public void close() {
            if (close(null)) {
                this.broadcastChannel.closeSubscriber(this);
            }
        }

        public final boolean checkOffer() {
            Closed closed = (Closed) null;
            boolean z = false;
            while (needsToCheckOfferWithoutLock()) {
                if (!this.lock.tryLock()) {
                    break;
                }
                Object peekUnderLock = peekUnderLock();
                if (peekUnderLock != AbstractChannelKt.POLL_FAILED) {
                    if (peekUnderLock instanceof Closed) {
                        closed = (Closed) peekUnderLock;
                    } else {
                        try {
                            ReceiveOrClosed takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                            if (takeFirstReceiveOrPeekClosed != null) {
                                if (!(takeFirstReceiveOrPeekClosed instanceof Closed)) {
                                    peekUnderLock = takeFirstReceiveOrPeekClosed.tryResumeReceive(peekUnderLock, null);
                                    if (peekUnderLock != null) {
                                        this.subHead += (long) 1;
                                        this.lock.unlock();
                                        if (takeFirstReceiveOrPeekClosed == null) {
                                            Intrinsics.throwNpe();
                                        }
                                        takeFirstReceiveOrPeekClosed.completeResumeReceive(peekUnderLock);
                                        z = true;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            this.lock.unlock();
                        }
                    }
                    this.lock.unlock();
                    break;
                }
                this.lock.unlock();
            }
            if (closed != null) {
                close(closed.closeCause);
            }
            return z;
        }

        @Nullable
        protected Object pollInternal() {
            this.lock.lock();
            try {
                int i;
                Closed closed;
                Object peekUnderLock = peekUnderLock();
                if (!(peekUnderLock instanceof Closed)) {
                    if (peekUnderLock != AbstractChannelKt.POLL_FAILED) {
                        this.subHead += (long) 1;
                        i = 1;
                        this.lock.unlock();
                        closed = (Closed) (peekUnderLock instanceof Closed ? null : peekUnderLock);
                        if (closed != null) {
                            close(closed.closeCause);
                        }
                        if (checkOffer()) {
                            i = 1;
                        }
                        if (i != 0) {
                            this.broadcastChannel.updateHead();
                        }
                        return peekUnderLock;
                    }
                }
                i = 0;
                this.lock.unlock();
                if (peekUnderLock instanceof Closed) {
                }
                closed = (Closed) (peekUnderLock instanceof Closed ? null : peekUnderLock);
                if (closed != null) {
                    close(closed.closeCause);
                }
                if (checkOffer()) {
                    i = 1;
                }
                if (i != 0) {
                    this.broadcastChannel.updateHead();
                }
                return peekUnderLock;
            } catch (Throwable th) {
                this.lock.unlock();
            }
        }

        @Nullable
        protected Object pollSelectInternal(@NotNull SelectInstance<?> selectInstance) {
            Intrinsics.checkParameterIsNotNull(selectInstance, "select");
            this.lock.lock();
            try {
                Object peekUnderLock = peekUnderLock();
                Object obj = null;
                int i = 1;
                int i2 = 0;
                if (!(peekUnderLock instanceof Closed)) {
                    if (peekUnderLock != AbstractChannelKt.POLL_FAILED) {
                        if (selectInstance.trySelect(null) == null) {
                            peekUnderLock = JobKt.getALREADY_SELECTED();
                        } else {
                            this.subHead += (long) 1;
                            i2 = 1;
                        }
                    }
                }
                this.lock.unlock();
                if ((peekUnderLock instanceof Closed) != null) {
                    obj = peekUnderLock;
                }
                Closed closed = (Closed) obj;
                if (closed != null) {
                    close(closed.closeCause);
                }
                if (checkOffer() == null) {
                    i = i2;
                }
                if (i != 0) {
                    this.broadcastChannel.updateHead();
                }
                return peekUnderLock;
            } catch (Throwable th) {
                this.lock.unlock();
            }
        }

        private final boolean needsToCheckOfferWithoutLock() {
            if (getClosedForReceive() != null) {
                return false;
            }
            if (isBufferEmpty() && this.broadcastChannel.getClosedForReceive() == null) {
                return false;
            }
            return true;
        }

        private final Object peekUnderLock() {
            long j = this.subHead;
            Object closedForReceive = this.broadcastChannel.getClosedForReceive();
            if (j < this.broadcastChannel.tail) {
                return this.broadcastChannel.elementAt(j);
            }
            if (closedForReceive == null) {
                closedForReceive = AbstractChannelKt.POLL_FAILED;
            }
            return closedForReceive;
        }
    }

    protected boolean isBufferAlwaysFull() {
        return false;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public ArrayBroadcastChannel(int i) {
        this.capacity = i;
        Object obj = 1;
        if (this.capacity < 1) {
            obj = null;
        }
        if (obj != null) {
            this.bufferLock = new ReentrantLock();
            this.buffer = new Object[this.capacity];
            this.subs = new CopyOnWriteArrayList();
            return;
        }
        i = new StringBuilder();
        i.append("ArrayBroadcastChannel capacity must be at least 1, but ");
        i.append(this.capacity);
        i.append(" was specified");
        throw new IllegalStateException(i.toString().toString());
    }

    protected boolean isBufferFull() {
        return this.size >= this.capacity;
    }

    @NotNull
    public SubscriptionReceiveChannel<E> open() {
        Subscriber subscriber = new Subscriber(this, this.head);
        this.subs.add(subscriber);
        long j = this.head;
        if (j != subscriber.subHead) {
            subscriber.subHead = j;
            updateHead();
        }
        return subscriber;
    }

    public boolean close(@Nullable Throwable th) {
        if (super.close(th) == null) {
            return null;
        }
        checkSubOffers();
        return true;
    }

    @NotNull
    protected Object offerInternal(E e) {
        Lock lock = this.bufferLock;
        lock.lock();
        try {
            Object closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            closedForSend = this.size;
            if (closedForSend >= this.capacity) {
                e = AbstractChannelKt.OFFER_FAILED;
                lock.unlock();
                return e;
            }
            long j = this.tail;
            this.buffer[(int) (j % ((long) this.capacity))] = e;
            closedForSend += 1;
            this.size = closedForSend;
            this.tail = j + ((long) 1);
            e = Unit.INSTANCE;
            lock.unlock();
            checkSubOffers();
            return AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            lock.unlock();
        }
    }

    @NotNull
    protected Object offerSelectInternal(E e, @NotNull SelectInstance<?> selectInstance) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Lock lock = this.bufferLock;
        lock.lock();
        try {
            Object closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            closedForSend = this.size;
            if (closedForSend >= this.capacity) {
                e = AbstractChannelKt.OFFER_FAILED;
                lock.unlock();
                return e;
            } else if (selectInstance.trySelect(null) == null) {
                e = JobKt.getALREADY_SELECTED();
                lock.unlock();
                return e;
            } else {
                long j = this.tail;
                this.buffer[(int) (j % ((long) this.capacity))] = e;
                closedForSend += 1;
                this.size = closedForSend;
                this.tail = j + ((long) 1);
                e = Unit.INSTANCE;
                lock.unlock();
                checkSubOffers();
                return AbstractChannelKt.OFFER_SUCCESS;
            }
        } finally {
            lock.unlock();
        }
    }

    private final void closeSubscriber(Subscriber<E> subscriber) {
        this.subs.remove(subscriber);
        if (this.head == subscriber.subHead) {
            updateHead();
        }
    }

    private final void checkSubOffers() {
        Iterator it = this.subs.iterator();
        Object obj = null;
        while (it.hasNext()) {
            if (((Subscriber) it.next()).checkOffer()) {
                obj = 1;
            }
        }
        if (obj != null) {
            updateHead();
        }
    }

    private final void updateHead() {
        Lock lock;
        Throwable th;
        ArrayBroadcastChannel arrayBroadcastChannel = this;
        long computeMinHead = computeMinHead();
        while (true) {
            ObjectRef objectRef = new ObjectRef();
            objectRef.element = (Send) null;
            ObjectRef objectRef2 = new ObjectRef();
            objectRef2.element = null;
            Lock lock2 = arrayBroadcastChannel.bufferLock;
            lock2.lock();
            try {
                long j = arrayBroadcastChannel.tail;
                long j2 = arrayBroadcastChannel.head;
                long coerceAtMost = RangesKt___RangesKt.coerceAtMost(computeMinHead, j);
                if (coerceAtMost <= j2) {
                    lock2.unlock();
                    return;
                }
                int i = arrayBroadcastChannel.size;
                while (j2 < coerceAtMost) {
                    ObjectRef objectRef3 = objectRef2;
                    arrayBroadcastChannel.buffer[(int) (j2 % ((long) arrayBroadcastChannel.capacity))] = null;
                    Object obj = i >= arrayBroadcastChannel.capacity ? 1 : null;
                    Lock lock3 = lock2;
                    long j3 = j2 + 1;
                    try {
                        arrayBroadcastChannel.head = j3;
                        i--;
                        arrayBroadcastChannel.size = i;
                        if (obj != null) {
                            ObjectRef objectRef4;
                            while (true) {
                                Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                                if (takeFirstSendOrPeekClosed == null) {
                                    continue;
                                    break;
                                }
                                objectRef.element = takeFirstSendOrPeekClosed;
                                if (((Send) objectRef.element) instanceof Closed) {
                                    break;
                                }
                                takeFirstSendOrPeekClosed = (Send) objectRef.element;
                                if (takeFirstSendOrPeekClosed == null) {
                                    Intrinsics.throwNpe();
                                }
                                objectRef4 = objectRef3;
                                objectRef4.element = takeFirstSendOrPeekClosed.tryResumeSend(null);
                                if (objectRef4.element != null) {
                                    break;
                                }
                                objectRef3 = objectRef4;
                            }
                            Object[] objArr = arrayBroadcastChannel.buffer;
                            int i2 = (int) (j % ((long) arrayBroadcastChannel.capacity));
                            Send send = (Send) objectRef.element;
                            if (send != null) {
                                objArr[i2] = send.getPollResult();
                                arrayBroadcastChannel.size = i + 1;
                                arrayBroadcastChannel.tail = j + ((long) 1);
                                Unit unit = Unit.INSTANCE;
                                lock3.unlock();
                                Send send2 = (Send) objectRef.element;
                                if (send2 == null) {
                                    Intrinsics.throwNpe();
                                }
                                obj = objectRef4.element;
                                if (obj == null) {
                                    Intrinsics.throwNpe();
                                }
                                send2.completeResumeSend(obj);
                                checkSubOffers();
                            } else {
                                lock = lock3;
                                try {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.channels.Send");
                                } catch (Throwable th2) {
                                    th = th2;
                                    lock.unlock();
                                    throw th;
                                }
                            }
                        }
                        obj = null;
                        long j4 = j3;
                        objectRef2 = objectRef3;
                        j2 = j4;
                        lock2 = lock3;
                    } catch (Throwable th3) {
                        th = th3;
                        lock = lock3;
                    }
                }
                lock2.unlock();
                return;
            } catch (Throwable th4) {
                th = th4;
                lock = lock2;
            }
        }
    }

    private final long computeMinHead() {
        Iterator it = this.subs.iterator();
        long j = LongCompanionObject.MAX_VALUE;
        while (it.hasNext()) {
            j = RangesKt___RangesKt.coerceAtMost(j, ((Subscriber) it.next()).subHead);
        }
        return j;
    }

    private final E elementAt(long j) {
        return this.buffer[(int) (j % ((long) this.capacity))];
    }
}
