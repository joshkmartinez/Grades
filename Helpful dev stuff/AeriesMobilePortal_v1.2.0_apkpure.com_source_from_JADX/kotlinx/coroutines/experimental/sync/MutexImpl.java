package kotlinx.coroutines.experimental.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutinesKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CancellableContinuation;
import kotlinx.coroutines.experimental.CancellableContinuation.DefaultImpls;
import kotlinx.coroutines.experimental.CancellableContinuationImpl;
import kotlinx.coroutines.experimental.CancellableContinuationKt;
import kotlinx.coroutines.experimental.DisposableHandle;
import kotlinx.coroutines.experimental.JobKt;
import kotlinx.coroutines.experimental.internal.AtomicDesc;
import kotlinx.coroutines.experimental.internal.AtomicOp;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode$AddLastDesc;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode$CondAddOp;
import kotlinx.coroutines.experimental.internal.OpDescriptor;
import kotlinx.coroutines.experimental.internal.Symbol;
import kotlinx.coroutines.experimental.intrinsics.UndispatchedKt;
import kotlinx.coroutines.experimental.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\t\u001c\u001d\u001e\u001f !\"#$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJL\u0010\u0010\u001a\u00020\f\"\u0004\b\u0000\u0010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u001c\u0010\u0014\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0015H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u001b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b\u0002\u0004\n\u0002\b\t¨\u0006%"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl;", "Lkotlinx/coroutines/experimental/sync/Mutex;", "locked", "", "(Z)V", "_state", "", "isLocked", "()Z", "isLockedEmptyQueueState", "isLockedEmptyQueueState$kotlinx_coroutines_core", "lock", "", "owner", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "lockSuspend", "registerSelectLock", "R", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "(Lkotlinx/coroutines/experimental/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "toString", "", "tryLock", "unlock", "Companion", "Empty", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "TryEnqueueLockDesc", "TryLockDesc", "UnlockOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: Mutex.kt */
public final class MutexImpl implements Mutex {
    public static final Companion Companion = new Companion();
    @NotNull
    @JvmField
    public static final Symbol ENQUEUE_FAIL = new Symbol("ENQUEUE_FAIL");
    @NotNull
    @JvmField
    public static final Empty EmptyLocked = new Empty(LOCKED);
    @NotNull
    @JvmField
    public static final Empty EmptyUnlocked = new Empty(UNLOCKED);
    @NotNull
    @JvmField
    public static final Symbol LOCKED = new Symbol("LOCKED");
    @NotNull
    @JvmField
    public static final Symbol LOCK_FAIL = new Symbol("LOCK_FAIL");
    @NotNull
    @JvmField
    public static final Symbol SELECT_SUCCESS = new Symbol("SELECT_SUCCESS");
    @NotNull
    @JvmField
    public static final AtomicReferenceFieldUpdater<MutexImpl, Object> STATE;
    @NotNull
    @JvmField
    public static final Symbol UNLOCKED = new Symbol("UNLOCKED");
    @NotNull
    @JvmField
    public static final Symbol UNLOCK_FAIL = new Symbol("UNLOCK_FAIL");
    private volatile Object _state;

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$Companion;", "", "()V", "ENQUEUE_FAIL", "Lkotlinx/coroutines/experimental/internal/Symbol;", "EmptyLocked", "Lkotlinx/coroutines/experimental/sync/MutexImpl$Empty;", "EmptyUnlocked", "LOCKED", "LOCK_FAIL", "SELECT_SUCCESS", "STATE", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlinx/coroutines/experimental/sync/MutexImpl;", "UNLOCKED", "UNLOCK_FAIL", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: Mutex.kt */
    private static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u0010\u0010\u0002\u001a\u00020\u00018\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$Empty;", "", "locked", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: Mutex.kt */
    private static final class Empty {
        @NotNull
        @JvmField
        public final Object locked;

        public Empty(@NotNull Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "locked");
            this.locked = obj;
        }

        @NotNull
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Empty[");
            stringBuilder.append(this.locked);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$TryLockDesc;", "Lkotlinx/coroutines/experimental/internal/AtomicDesc;", "mutex", "Lkotlinx/coroutines/experimental/sync/MutexImpl;", "owner", "", "(Lkotlinx/coroutines/experimental/sync/MutexImpl;Ljava/lang/Object;)V", "complete", "", "op", "Lkotlinx/coroutines/experimental/internal/AtomicOp;", "failure", "prepare", "PrepareOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: Mutex.kt */
    private static final class TryLockDesc extends AtomicDesc {
        @NotNull
        @JvmField
        public final MutexImpl mutex;
        @Nullable
        @JvmField
        public final Object owner;

        @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$TryLockDesc$PrepareOp;", "Lkotlinx/coroutines/experimental/internal/OpDescriptor;", "op", "Lkotlinx/coroutines/experimental/internal/AtomicOp;", "(Lkotlinx/coroutines/experimental/sync/MutexImpl$TryLockDesc;Lkotlinx/coroutines/experimental/internal/AtomicOp;)V", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
        /* compiled from: Mutex.kt */
        private final class PrepareOp extends OpDescriptor {
            private final AtomicOp op;
            final /* synthetic */ TryLockDesc this$0;

            public PrepareOp(@NotNull TryLockDesc tryLockDesc, AtomicOp atomicOp) {
                Intrinsics.checkParameterIsNotNull(atomicOp, "op");
                this.this$0 = tryLockDesc;
                this.op = atomicOp;
            }

            @Nullable
            public Object perform(@Nullable Object obj) {
                Object obj2 = this.op.isDecided() ? MutexImpl.EmptyUnlocked : this.op;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl.STATE;
                if (obj != null) {
                    atomicReferenceFieldUpdater.compareAndSet((MutexImpl) obj, this, obj2);
                    return null;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.sync.MutexImpl");
            }
        }

        public TryLockDesc(@NotNull MutexImpl mutexImpl, @Nullable Object obj) {
            Intrinsics.checkParameterIsNotNull(mutexImpl, "mutex");
            this.mutex = mutexImpl;
            this.owner = obj;
        }

        @Nullable
        public Object prepare(@NotNull AtomicOp atomicOp) {
            Intrinsics.checkParameterIsNotNull(atomicOp, "op");
            PrepareOp prepareOp = new PrepareOp(this, atomicOp);
            if (MutexImpl.STATE.compareAndSet(this.mutex, MutexImpl.EmptyUnlocked, prepareOp) == null) {
                return MutexImpl.LOCK_FAIL;
            }
            return prepareOp.perform(this.mutex);
        }

        public void complete(@NotNull AtomicOp atomicOp, @Nullable Object obj) {
            Intrinsics.checkParameterIsNotNull(atomicOp, "op");
            obj = obj != null ? MutexImpl.EmptyUnlocked : this.owner == null ? MutexImpl.EmptyLocked : new Empty(this.owner);
            MutexImpl.STATE.compareAndSet(this.mutex, atomicOp, obj);
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$UnlockOp;", "Lkotlinx/coroutines/experimental/internal/OpDescriptor;", "queue", "Lkotlinx/coroutines/experimental/sync/MutexImpl$LockedQueue;", "(Lkotlinx/coroutines/experimental/sync/MutexImpl$LockedQueue;)V", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: Mutex.kt */
    private static final class UnlockOp extends OpDescriptor {
        @NotNull
        @JvmField
        public final LockedQueue queue;

        public UnlockOp(@NotNull LockedQueue lockedQueue) {
            Intrinsics.checkParameterIsNotNull(lockedQueue, "queue");
            this.queue = lockedQueue;
        }

        @Nullable
        public Object perform(@Nullable Object obj) {
            Object obj2 = this.queue.isEmpty() ? MutexImpl.EmptyUnlocked : this.queue;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl.STATE;
            if (obj != null) {
                MutexImpl mutexImpl = (MutexImpl) obj;
                atomicReferenceFieldUpdater.compareAndSet(mutexImpl, this, obj2);
                return mutexImpl._state == this.queue ? MutexImpl.UNLOCK_FAIL : null;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.sync.MutexImpl");
            }
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;", "owner", "", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: Mutex.kt */
    private static final class LockedQueue extends LockFreeLinkedListHead {
        @NotNull
        @JvmField
        public Object owner;

        public LockedQueue(@NotNull Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "owner");
            this.owner = obj;
        }

        @NotNull
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LockedQueue[");
            stringBuilder.append(this.owner);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/experimental/sync/MutexImpl$LockWaiter;", "owner", "", "cont", "Lkotlinx/coroutines/experimental/CancellableContinuation;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/experimental/CancellableContinuation;)V", "completeResumeLockWaiter", "token", "toString", "", "tryResumeLockWaiter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: Mutex.kt */
    private static final class LockCont extends LockWaiter {
        @NotNull
        @JvmField
        public final CancellableContinuation<Unit> cont;

        public LockCont(@Nullable Object obj, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
            Intrinsics.checkParameterIsNotNull(cancellableContinuation, "cont");
            super(obj);
            this.cont = cancellableContinuation;
        }

        @Nullable
        public Object tryResumeLockWaiter() {
            return DefaultImpls.tryResume$default(this.cont, Unit.INSTANCE, null, 2, null);
        }

        public void completeResumeLockWaiter(@NotNull Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "token");
            this.cont.completeResume(obj);
        }

        @NotNull
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LockCont[");
            stringBuilder.append(this.owner);
            stringBuilder.append(", ");
            stringBuilder.append(this.cont);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B>\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0016R+\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b8\u0006X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$LockSelect;", "R", "Lkotlinx/coroutines/experimental/sync/MutexImpl$LockWaiter;", "owner", "", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/experimental/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "completeResumeLockWaiter", "", "token", "toString", "", "tryResumeLockWaiter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: Mutex.kt */
    private static final class LockSelect<R> extends LockWaiter {
        @NotNull
        @JvmField
        public final Function1<Continuation<? super R>, Object> block;
        @NotNull
        @JvmField
        public final SelectInstance<R> select;

        public LockSelect(@Nullable Object obj, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
            Intrinsics.checkParameterIsNotNull(selectInstance, "select");
            Intrinsics.checkParameterIsNotNull(function1, "block");
            super(obj);
            this.select = selectInstance;
            this.block = function1;
        }

        @Nullable
        public Object tryResumeLockWaiter() {
            return this.select.trySelect(null) ? MutexImpl.SELECT_SUCCESS : null;
        }

        public void completeResumeLockWaiter(@NotNull Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "token");
            if ((obj == MutexImpl.SELECT_SUCCESS ? true : null) != null) {
                CoroutinesKt.startCoroutine(this.block, this.select.getCompletion());
                return;
            }
            throw ((Throwable) new IllegalStateException("Check failed.".toString()));
        }

        @NotNull
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LockSelect[");
            stringBuilder.append(this.owner);
            stringBuilder.append(", ");
            stringBuilder.append(this.select);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004BN\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0014R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$TryEnqueueLockDesc;", "R", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/experimental/sync/MutexImpl$LockSelect;", "Lkotlinx/coroutines/experimental/internal/AddLastDesc;", "mutex", "Lkotlinx/coroutines/experimental/sync/MutexImpl;", "owner", "", "queue", "Lkotlinx/coroutines/experimental/sync/MutexImpl$LockedQueue;", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "(Lkotlinx/coroutines/experimental/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/experimental/sync/MutexImpl$LockedQueue;Lkotlinx/coroutines/experimental/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "onPrepare", "affected", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: Mutex.kt */
    private static final class TryEnqueueLockDesc<R> extends LockFreeLinkedListNode$AddLastDesc<LockSelect<R>> {
        @NotNull
        @JvmField
        public final MutexImpl mutex;

        public TryEnqueueLockDesc(@NotNull MutexImpl mutexImpl, @Nullable Object obj, @NotNull LockedQueue lockedQueue, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
            Intrinsics.checkParameterIsNotNull(mutexImpl, "mutex");
            Intrinsics.checkParameterIsNotNull(lockedQueue, "queue");
            Intrinsics.checkParameterIsNotNull(selectInstance, "select");
            Intrinsics.checkParameterIsNotNull(function1, "block");
            super(lockedQueue, new LockSelect(obj, selectInstance, function1));
            this.mutex = mutexImpl;
        }

        @Nullable
        protected Object onPrepare(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            if (this.mutex._state != this.queue) {
                return MutexImpl.ENQUEUE_FAIL;
            }
            return super.onPrepare(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        }
    }

    public MutexImpl(boolean z) {
        this._state = z ? EmptyLocked : EmptyUnlocked;
    }

    static {
        AtomicReferenceFieldUpdater newUpdater = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
        Intrinsics.checkExpressionValueIsNotNull(newUpdater, "AtomicReferenceFieldUpda…ny::class.java, \"_state\")");
        STATE = newUpdater;
    }

    public boolean isLocked() {
        boolean z;
        while (true) {
            Object obj = this._state;
            z = true;
            if (obj instanceof Empty) {
                break;
            } else if (obj instanceof LockedQueue) {
                return true;
            } else {
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(this);
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Illegal state ");
                    stringBuilder.append(obj);
                    throw new IllegalStateException(stringBuilder.toString().toString());
                }
            }
        }
        if (((Empty) obj).locked == UNLOCKED) {
            z = false;
        }
        return z;
    }

    public final boolean isLockedEmptyQueueState$kotlinx_coroutines_core() {
        Object obj = this._state;
        return (obj instanceof LockedQueue) && ((LockedQueue) obj).isEmpty();
    }

    public boolean tryLock(@Nullable Object obj) {
        while (true) {
            Object obj2 = this._state;
            boolean z = true;
            if (obj2 instanceof Empty) {
                if (((Empty) obj2).locked != UNLOCKED) {
                    return false;
                }
                if (STATE.compareAndSet(this, obj2, obj == null ? EmptyLocked : new Empty(obj))) {
                    return true;
                }
            } else if (obj2 instanceof LockedQueue) {
                break;
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else {
                obj = new StringBuilder();
                obj.append("Illegal state ");
                obj.append(obj2);
                throw new IllegalStateException(obj.toString().toString());
            }
        }
        if (((LockedQueue) obj2).owner == obj) {
            z = false;
        }
        if (z) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Already locked by ");
        stringBuilder.append(obj);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    @Nullable
    public Object lock(@Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
        if (tryLock(obj)) {
            return Unit.INSTANCE;
        }
        return lockSuspend(obj, continuation);
    }

    public <R> void registerSelectLock(@NotNull SelectInstance<? super R> selectInstance, @Nullable Object obj, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        while (!selectInstance.isSelected()) {
            Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                Empty empty = (Empty) obj2;
                if (empty.locked != UNLOCKED) {
                    STATE.compareAndSet(this, obj2, new LockedQueue(empty.locked));
                } else {
                    Symbol performAtomicTrySelect = selectInstance.performAtomicTrySelect(new TryLockDesc(this, obj));
                    if (performAtomicTrySelect == null) {
                        UndispatchedKt.startCoroutineUndispatched(function1, selectInstance.getCompletion());
                        return;
                    } else if (performAtomicTrySelect != JobKt.getALREADY_SELECTED()) {
                        if (performAtomicTrySelect != LOCK_FAIL) {
                            selectInstance = new StringBuilder();
                            selectInstance.append("performAtomicTrySelect(TryLockDesc) returned ");
                            selectInstance.append(performAtomicTrySelect);
                            throw ((Throwable) new IllegalStateException(selectInstance.toString().toString()));
                        }
                    } else {
                        return;
                    }
                }
            } else if (obj2 instanceof LockedQueue) {
                LockedQueue lockedQueue = (LockedQueue) obj2;
                if ((lockedQueue.owner != obj ? 1 : null) != null) {
                    TryEnqueueLockDesc tryEnqueueLockDesc = new TryEnqueueLockDesc(this, obj, lockedQueue, selectInstance, function1);
                    Symbol performAtomicIfNotSelected = selectInstance.performAtomicIfNotSelected(tryEnqueueLockDesc);
                    if (performAtomicIfNotSelected == null) {
                        selectInstance.disposeOnSelect((DisposableHandle) tryEnqueueLockDesc.node);
                        return;
                    } else if (performAtomicIfNotSelected != JobKt.getALREADY_SELECTED()) {
                        if (performAtomicIfNotSelected != ENQUEUE_FAIL) {
                            selectInstance = new StringBuilder();
                            selectInstance.append("performAtomicIfNotSelected(TryEnqueueLockDesc) returned ");
                            selectInstance.append(performAtomicIfNotSelected);
                            throw ((Throwable) new IllegalStateException(selectInstance.toString().toString()));
                        }
                    } else {
                        return;
                    }
                }
                selectInstance = new StringBuilder();
                selectInstance.append("Already locked by ");
                selectInstance.append(obj);
                throw ((Throwable) new IllegalStateException(selectInstance.toString().toString()));
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else {
                selectInstance = new StringBuilder();
                selectInstance.append("Illegal state ");
                selectInstance.append(obj2);
                throw ((Throwable) new IllegalStateException(selectInstance.toString().toString()));
            }
        }
    }

    public void unlock(@Nullable Object obj) {
        Object obj2;
        LockedQueue lockedQueue;
        LockWaiter lockWaiter;
        while (true) {
            obj2 = this._state;
            Object obj3 = null;
            StringBuilder stringBuilder;
            if (obj2 instanceof Empty) {
                if (obj == null) {
                    if (((Empty) obj2).locked != UNLOCKED) {
                        obj3 = 1;
                    }
                    if (obj3 == null) {
                        throw ((Throwable) new IllegalStateException("Mutex is not locked".toString()));
                    }
                } else {
                    Empty empty = (Empty) obj2;
                    if (empty.locked == obj) {
                        obj3 = 1;
                    }
                    if (obj3 == null) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Mutex is locked by ");
                        stringBuilder.append(empty.locked);
                        stringBuilder.append(" but expected ");
                        stringBuilder.append(obj);
                        throw new IllegalStateException(stringBuilder.toString().toString());
                    }
                }
                if (STATE.compareAndSet(this, obj2, EmptyUnlocked)) {
                    return;
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else if (obj2 instanceof LockedQueue) {
                if (obj != null) {
                    lockedQueue = (LockedQueue) obj2;
                    if (lockedQueue.owner == obj) {
                        obj3 = 1;
                    }
                    if (obj3 == null) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Mutex is locked by ");
                        stringBuilder.append(lockedQueue.owner);
                        stringBuilder.append(" but expected ");
                        stringBuilder.append(obj);
                        throw new IllegalStateException(stringBuilder.toString().toString());
                    }
                }
                lockedQueue = (LockedQueue) obj2;
                LockFreeLinkedListNode removeFirstOrNull = lockedQueue.removeFirstOrNull();
                if (removeFirstOrNull == null) {
                    UnlockOp unlockOp = new UnlockOp(lockedQueue);
                    if (STATE.compareAndSet(this, obj2, unlockOp) && unlockOp.perform(this) == null) {
                        return;
                    }
                }
                lockWaiter = (LockWaiter) removeFirstOrNull;
                obj2 = lockWaiter.tryResumeLockWaiter();
                if (obj2 != null) {
                    break;
                }
            } else {
                obj = new StringBuilder();
                obj.append("Illegal state ");
                obj.append(obj2);
                throw new IllegalStateException(obj.toString().toString());
            }
        }
        obj = lockWaiter.owner;
        if (obj == null) {
            obj = LOCKED;
        }
        lockedQueue.owner = obj;
        lockWaiter.completeResumeLockWaiter(obj2);
    }

    @NotNull
    public String toString() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof Empty)) {
                if (!(obj instanceof OpDescriptor)) {
                    break;
                }
                ((OpDescriptor) obj).perform(this);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Mutex[");
                stringBuilder.append(((Empty) obj).locked);
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
        }
        if (obj instanceof LockedQueue) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Mutex[");
            stringBuilder.append(((LockedQueue) obj).owner);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Illegal state ");
        stringBuilder.append(obj);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    private final Object lockSuspend(Object obj, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), true);
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        LockCont lockCont = new LockCont(obj, cancellableContinuation);
        while (true) {
            Object access$get_state$p = this._state;
            if (access$get_state$p instanceof Empty) {
                Empty empty = (Empty) access$get_state$p;
                if (empty.locked != UNLOCKED) {
                    STATE.compareAndSet(this, access$get_state$p, new LockedQueue(empty.locked));
                } else {
                    if (STATE.compareAndSet(this, access$get_state$p, obj == null ? EmptyLocked : new Empty(obj))) {
                        cancellableContinuation.resume(Unit.INSTANCE);
                    }
                }
            } else if (access$get_state$p instanceof LockedQueue) {
                LockedQueue lockedQueue = (LockedQueue) access$get_state$p;
                boolean z = false;
                if (lockedQueue.owner != obj) {
                    LockFreeLinkedListNode lockFreeLinkedListNode = lockCont;
                    LockFreeLinkedListNode$CondAddOp c1103xedea91d5 = new C1103xedea91d5(lockFreeLinkedListNode, lockFreeLinkedListNode, access$get_state$p, this, obj);
                    while (true) {
                        Object prev = lockedQueue.getPrev();
                        if (prev != null) {
                            switch (((LockFreeLinkedListNode) prev).tryCondAddNext(lockFreeLinkedListNode, lockedQueue, c1103xedea91d5)) {
                                case 1:
                                    z = true;
                                    break;
                                case 2:
                                    break;
                                default:
                            }
                            if (z) {
                                cancellableContinuation.initCancellability();
                                CancellableContinuationKt.removeOnCancel(cancellableContinuation, lockFreeLinkedListNode);
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
                        }
                    }
                }
                continuation = new StringBuilder();
                continuation.append("Already locked by ");
                continuation.append(obj);
                throw ((Throwable) new IllegalStateException(continuation.toString().toString()));
            } else if (access$get_state$p instanceof OpDescriptor) {
                ((OpDescriptor) access$get_state$p).perform(this);
            } else {
                obj = new StringBuilder();
                obj.append("Illegal state ");
                obj.append(access$get_state$p);
                throw ((Throwable) new IllegalStateException(obj.toString().toString()));
            }
            return cancellableContinuationImpl.getResult();
        }
    }
}
