package kotlinx.coroutines.experimental.channels;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.experimental.JobKt;
import kotlinx.coroutines.experimental.internal.AtomicDesc;
import kotlinx.coroutines.experimental.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0018J!\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00028\u00002\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0014¢\u0006\u0002\u0010\u001cJ\n\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0014J\u0016\u0010\u001e\u001a\u0004\u0018\u00010\b2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0014R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8DX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000e8DX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u000e8DX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u000e8DX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000fR\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ArrayChannel;", "E", "Lkotlinx/coroutines/experimental/channels/AbstractChannel;", "capacity", "", "(I)V", "buffer", "", "", "[Ljava/lang/Object;", "getCapacity", "()I", "head", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "size", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/experimental/selects/SelectInstance;)Ljava/lang/Object;", "pollInternal", "pollSelectInternal", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: ArrayChannel.kt */
public class ArrayChannel<E> extends AbstractChannel<E> {
    private final Object[] buffer;
    private final int capacity;
    private int head;
    private final ReentrantLock lock;
    private volatile int size;

    protected final boolean isBufferAlwaysEmpty() {
        return false;
    }

    protected final boolean isBufferAlwaysFull() {
        return false;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public ArrayChannel(int i) {
        this.capacity = i;
        Object obj = 1;
        if (this.capacity < 1) {
            obj = null;
        }
        if (obj != null) {
            this.lock = new ReentrantLock();
            this.buffer = new Object[this.capacity];
            return;
        }
        i = new StringBuilder();
        i.append("ArrayChannel capacity must be at least 1, but ");
        i.append(this.capacity);
        i.append(" was specified");
        throw new IllegalStateException(i.toString().toString());
    }

    protected final boolean isBufferEmpty() {
        return this.size == 0;
    }

    protected final boolean isBufferFull() {
        return this.size == this.capacity;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @org.jetbrains.annotations.NotNull
    protected java.lang.Object offerInternal(E r7) {
        /*
        r6 = this;
        r0 = new kotlin.jvm.internal.Ref$ObjectRef;
        r0.<init>();
        r1 = 0;
        r2 = r1;
        r2 = (kotlinx.coroutines.experimental.channels.ReceiveOrClosed) r2;
        r0.element = r2;
        r2 = new kotlin.jvm.internal.Ref$ObjectRef;
        r2.<init>();
        r2.element = r1;
        r3 = r6.lock;
        r3 = (java.util.concurrent.locks.Lock) r3;
        r3.lock();
        r4 = r6.size;	 Catch:{ all -> 0x009f }
        r5 = r6.getClosedForSend();	 Catch:{ all -> 0x009f }
        if (r5 == 0) goto L_0x0025;
    L_0x0021:
        r3.unlock();
        return r5;
    L_0x0025:
        r5 = r6.capacity;	 Catch:{ all -> 0x009f }
        if (r4 >= r5) goto L_0x0099;
    L_0x0029:
        r5 = r4 + 1;
        r6.size = r5;	 Catch:{ all -> 0x009f }
        if (r4 != 0) goto L_0x0089;
    L_0x002f:
        r5 = r6.takeFirstReceiveOrPeekClosed();	 Catch:{ all -> 0x009f }
        if (r5 == 0) goto L_0x0089;
    L_0x0035:
        r0.element = r5;	 Catch:{ all -> 0x009f }
        r5 = r0.element;	 Catch:{ all -> 0x009f }
        r5 = (kotlinx.coroutines.experimental.channels.ReceiveOrClosed) r5;	 Catch:{ all -> 0x009f }
        r5 = r5 instanceof kotlinx.coroutines.experimental.channels.Closed;	 Catch:{ all -> 0x009f }
        if (r5 == 0) goto L_0x004e;
    L_0x003f:
        r6.size = r4;	 Catch:{ all -> 0x009f }
        r7 = r0.element;	 Catch:{ all -> 0x009f }
        r7 = (kotlinx.coroutines.experimental.channels.ReceiveOrClosed) r7;	 Catch:{ all -> 0x009f }
        if (r7 != 0) goto L_0x004a;
    L_0x0047:
        kotlin.jvm.internal.Intrinsics.throwNpe();	 Catch:{ all -> 0x009f }
    L_0x004a:
        r3.unlock();
        return r7;
    L_0x004e:
        r5 = r0.element;	 Catch:{ all -> 0x009f }
        r5 = (kotlinx.coroutines.experimental.channels.ReceiveOrClosed) r5;	 Catch:{ all -> 0x009f }
        if (r5 != 0) goto L_0x0057;
    L_0x0054:
        kotlin.jvm.internal.Intrinsics.throwNpe();	 Catch:{ all -> 0x009f }
    L_0x0057:
        r5 = r5.tryResumeReceive(r7, r1);	 Catch:{ all -> 0x009f }
        r2.element = r5;	 Catch:{ all -> 0x009f }
        r5 = r2.element;	 Catch:{ all -> 0x009f }
        if (r5 == 0) goto L_0x002f;
    L_0x0061:
        r6.size = r4;	 Catch:{ all -> 0x009f }
        r7 = kotlin.Unit.INSTANCE;	 Catch:{ all -> 0x009f }
        r3.unlock();
        r7 = r0.element;
        r7 = (kotlinx.coroutines.experimental.channels.ReceiveOrClosed) r7;
        if (r7 != 0) goto L_0x0071;
    L_0x006e:
        kotlin.jvm.internal.Intrinsics.throwNpe();
    L_0x0071:
        r1 = r2.element;
        if (r1 != 0) goto L_0x0078;
    L_0x0075:
        kotlin.jvm.internal.Intrinsics.throwNpe();
    L_0x0078:
        r7.completeResumeReceive(r1);
        r7 = r0.element;
        r7 = (kotlinx.coroutines.experimental.channels.ReceiveOrClosed) r7;
        if (r7 != 0) goto L_0x0084;
    L_0x0081:
        kotlin.jvm.internal.Intrinsics.throwNpe();
    L_0x0084:
        r7 = r7.getOfferResult();
        return r7;
    L_0x0089:
        r0 = r6.buffer;	 Catch:{ all -> 0x009f }
        r1 = r6.head;	 Catch:{ all -> 0x009f }
        r1 = r1 + r4;
        r2 = r6.capacity;	 Catch:{ all -> 0x009f }
        r1 = r1 % r2;
        r0[r1] = r7;	 Catch:{ all -> 0x009f }
        r7 = kotlinx.coroutines.experimental.channels.AbstractChannelKt.OFFER_SUCCESS;	 Catch:{ all -> 0x009f }
        r3.unlock();
        return r7;
    L_0x0099:
        r7 = kotlinx.coroutines.experimental.channels.AbstractChannelKt.OFFER_FAILED;	 Catch:{ all -> 0x009f }
        r3.unlock();
        return r7;
    L_0x009f:
        r7 = move-exception;
        r3.unlock();
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.experimental.channels.ArrayChannel.offerInternal(java.lang.Object):java.lang.Object");
    }

    @NotNull
    protected Object offerSelectInternal(E e, @NotNull SelectInstance<?> selectInstance) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        ObjectRef objectRef = new ObjectRef();
        objectRef.element = (ReceiveOrClosed) null;
        ObjectRef objectRef2 = new ObjectRef();
        objectRef2.element = null;
        Lock lock = this.lock;
        lock.lock();
        try {
            int i = this.size;
            Object closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            closedForSend = this.capacity;
            if (i < closedForSend) {
                closedForSend = i + 1;
                this.size = closedForSend;
                if (i == 0) {
                    closedForSend = describeTryOffer(e);
                    E performAtomicTrySelect = selectInstance.performAtomicTrySelect((AtomicDesc) closedForSend);
                    if (performAtomicTrySelect == null) {
                        this.size = i;
                        objectRef.element = (ReceiveOrClosed) closedForSend.getResult();
                        objectRef2.element = closedForSend.resumeToken;
                        if ((objectRef2.element != null ? true : null) != null) {
                            e = Unit.INSTANCE;
                            lock.unlock();
                            ReceiveOrClosed receiveOrClosed = (ReceiveOrClosed) objectRef.element;
                            if (receiveOrClosed == null) {
                                Intrinsics.throwNpe();
                            }
                            selectInstance = objectRef2.element;
                            if (selectInstance == null) {
                                Intrinsics.throwNpe();
                            }
                            receiveOrClosed.completeResumeReceive(selectInstance);
                            receiveOrClosed = (ReceiveOrClosed) objectRef.element;
                            if (receiveOrClosed == null) {
                                Intrinsics.throwNpe();
                            }
                            return receiveOrClosed.getOfferResult();
                        }
                        throw ((Throwable) new IllegalStateException("Check failed.".toString()));
                    } else if (performAtomicTrySelect != AbstractChannelKt.OFFER_FAILED) {
                        if (performAtomicTrySelect != JobKt.getALREADY_SELECTED()) {
                            if ((performAtomicTrySelect instanceof Closed) == null) {
                                e = new StringBuilder();
                                e.append("performAtomicTrySelect(describeTryOffer) returned ");
                                e.append(performAtomicTrySelect);
                                throw ((Throwable) new IllegalStateException(e.toString().toString()));
                            }
                        }
                        this.size = i;
                        lock.unlock();
                        return performAtomicTrySelect;
                    }
                }
                if (selectInstance.trySelect(null) == null) {
                    this.size = i;
                    e = JobKt.getALREADY_SELECTED();
                    lock.unlock();
                    return e;
                }
                this.buffer[(this.head + i) % this.capacity] = e;
                e = AbstractChannelKt.OFFER_SUCCESS;
                lock.unlock();
                return e;
            }
            e = AbstractChannelKt.OFFER_FAILED;
            lock.unlock();
            return e;
        } finally {
            lock.unlock();
        }
    }

    @Nullable
    protected Object pollInternal() {
        ObjectRef objectRef = new ObjectRef();
        objectRef.element = (Send) null;
        ObjectRef objectRef2 = new ObjectRef();
        objectRef2.element = null;
        ObjectRef objectRef3 = new ObjectRef();
        objectRef3.element = null;
        Lock lock = this.lock;
        lock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                lock.unlock();
                return closedForSend;
            }
            objectRef3.element = this.buffer[this.head];
            this.buffer[this.head] = null;
            this.size = i - 1;
            Object obj = AbstractChannelKt.POLL_FAILED;
            if (i == this.capacity) {
                do {
                    Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                    if (takeFirstSendOrPeekClosed == null) {
                        break;
                    }
                    objectRef.element = takeFirstSendOrPeekClosed;
                    takeFirstSendOrPeekClosed = (Send) objectRef.element;
                    if (takeFirstSendOrPeekClosed == null) {
                        Intrinsics.throwNpe();
                    }
                    objectRef2.element = takeFirstSendOrPeekClosed.tryResumeSend(null);
                } while (objectRef2.element == null);
                Send send = (Send) objectRef.element;
                if (send == null) {
                    Intrinsics.throwNpe();
                }
                obj = send.getPollResult();
            }
            if (!(obj == AbstractChannelKt.POLL_FAILED || (obj instanceof Closed))) {
                this.size = i;
                this.buffer[(this.head + i) % this.capacity] = obj;
            }
            this.head = (this.head + 1) % this.capacity;
            Unit unit = Unit.INSTANCE;
            lock.unlock();
            if (objectRef2.element != null) {
                Send send2 = (Send) objectRef.element;
                if (send2 == null) {
                    Intrinsics.throwNpe();
                }
                Object obj2 = objectRef2.element;
                if (obj2 == null) {
                    Intrinsics.throwNpe();
                }
                send2.completeResumeSend(obj2);
            }
            return objectRef3.element;
        } catch (Throwable th) {
            lock.unlock();
        }
    }

    @Nullable
    protected Object pollSelectInternal(@NotNull SelectInstance<?> selectInstance) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        ObjectRef objectRef = new ObjectRef();
        objectRef.element = (Send) null;
        ObjectRef objectRef2 = new ObjectRef();
        objectRef2.element = null;
        ObjectRef objectRef3 = new ObjectRef();
        objectRef3.element = null;
        Lock lock = this.lock;
        lock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                selectInstance = getClosedForSend();
                if (selectInstance == null) {
                    selectInstance = AbstractChannelKt.POLL_FAILED;
                }
                lock.unlock();
                return selectInstance;
            }
            objectRef3.element = this.buffer[this.head];
            this.buffer[this.head] = null;
            this.size = i - 1;
            Object obj = AbstractChannelKt.POLL_FAILED;
            if (i == this.capacity) {
                TryPollDesc describeTryPoll = describeTryPoll();
                Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(describeTryPoll);
                if (performAtomicTrySelect == null) {
                    objectRef.element = (Send) describeTryPoll.getResult();
                    objectRef2.element = describeTryPoll.resumeToken;
                    if ((objectRef2.element != null ? 1 : 0) != 0) {
                        Send send = (Send) objectRef.element;
                        if (send == null) {
                            Intrinsics.throwNpe();
                        }
                        obj = send.getPollResult();
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else if (performAtomicTrySelect != AbstractChannelKt.POLL_FAILED) {
                    if (performAtomicTrySelect == JobKt.getALREADY_SELECTED()) {
                        this.size = i;
                        this.buffer[this.head] = objectRef3.element;
                        lock.unlock();
                        return performAtomicTrySelect;
                    } else if (performAtomicTrySelect instanceof Closed) {
                        objectRef.element = (Send) performAtomicTrySelect;
                        objectRef2.element = ((Closed) performAtomicTrySelect).tryResumeSend(null);
                        obj = performAtomicTrySelect;
                    } else {
                        selectInstance = new StringBuilder();
                        selectInstance.append("performAtomicTrySelect(describeTryOffer) returned ");
                        selectInstance.append(performAtomicTrySelect);
                        throw new IllegalStateException(selectInstance.toString().toString());
                    }
                }
            }
            if (obj != AbstractChannelKt.POLL_FAILED && !(obj instanceof Closed)) {
                this.size = i;
                this.buffer[(this.head + i) % this.capacity] = obj;
            } else if (selectInstance.trySelect(null) == null) {
                this.size = i;
                this.buffer[this.head] = objectRef3.element;
                selectInstance = JobKt.getALREADY_SELECTED();
                lock.unlock();
                return selectInstance;
            }
            this.head = (this.head + 1) % this.capacity;
            selectInstance = Unit.INSTANCE;
            lock.unlock();
            if (objectRef2.element != null) {
                Send send2 = (Send) objectRef.element;
                if (send2 == null) {
                    Intrinsics.throwNpe();
                }
                Object obj2 = objectRef2.element;
                if (obj2 == null) {
                    Intrinsics.throwNpe();
                }
                send2.completeResumeSend(obj2);
            }
            return objectRef3.element;
        } catch (Throwable th) {
            lock.unlock();
        }
    }
}
