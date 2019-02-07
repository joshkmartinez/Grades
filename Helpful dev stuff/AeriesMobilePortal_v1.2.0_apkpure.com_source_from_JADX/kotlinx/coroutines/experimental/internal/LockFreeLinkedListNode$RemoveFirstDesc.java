package kotlinx.coroutines.experimental.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\u0010\u0015\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0016\u001a\u00020\u0014H\u0014J \u0010\u0017\u001a\u00020\u00182\n\u0010\u0015\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0016\u001a\u00060\u0004j\u0002`\u0005H\u0004J\"\u0010\u0019\u001a\u0004\u0018\u00010\u00142\n\u0010\u0015\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0016\u001a\u00060\u0004j\u0002`\u0005H\u0005J\u001c\u0010\u001a\u001a\u00020\u001b2\n\u0010\u0015\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0016\u001a\u00020\u0014H\u0004J\u0014\u0010\u001c\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0004J \u0010\u001f\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0016\u001a\u00060\u0004j\u0002`\u0005H\u0004J\u0015\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\"R$\u0010\u0007\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0006R$\u0010\u000b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u0006R\u0014\u0010\u0003\u001a\u00060\u0004j\u0002`\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00028\u00008FX\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2 = {"Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "T", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "queue", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/internal/Node;", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;)V", "affectedNode", "getAffectedNode", "()Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "setAffectedNode", "originalNext", "getOriginalNext", "setOriginalNext", "result", "result$annotations", "()V", "getResult", "()Ljava/lang/Object;", "failure", "", "affected", "next", "finishOnSuccess", "", "onPrepare", "retry", "", "takeAffectedNode", "op", "Lkotlinx/coroutines/experimental/internal/OpDescriptor;", "updatedNext", "validatePrepared", "node", "(Ljava/lang/Object;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: LockFreeLinkedList.kt */
public class LockFreeLinkedListNode$RemoveFirstDesc<T> extends LockFreeLinkedListNode$AbstractAtomicDesc {
    @Nullable
    private LockFreeLinkedListNode affectedNode;
    @Nullable
    private LockFreeLinkedListNode originalNext;
    @NotNull
    @JvmField
    public final LockFreeLinkedListNode queue;

    public static /* synthetic */ void result$annotations() {
    }

    protected boolean validatePrepared(T t) {
        return true;
    }

    public LockFreeLinkedListNode$RemoveFirstDesc(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "queue");
        this.queue = lockFreeLinkedListNode;
    }

    public final T getResult() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this.affectedNode;
        if (lockFreeLinkedListNode == null) {
            Intrinsics.throwNpe();
        }
        return lockFreeLinkedListNode;
    }

    @NotNull
    protected final LockFreeLinkedListNode takeAffectedNode(@NotNull OpDescriptor opDescriptor) {
        Intrinsics.checkParameterIsNotNull(opDescriptor, "op");
        opDescriptor = this.queue.getNext();
        if (opDescriptor != null) {
            return (LockFreeLinkedListNode) opDescriptor;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
    }

    @Nullable
    protected final LockFreeLinkedListNode getAffectedNode() {
        return this.affectedNode;
    }

    public final void setAffectedNode(@Nullable LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.affectedNode = lockFreeLinkedListNode;
    }

    @Nullable
    protected final LockFreeLinkedListNode getOriginalNext() {
        return this.originalNext;
    }

    public final void setOriginalNext(@Nullable LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.originalNext = lockFreeLinkedListNode;
    }

    @Nullable
    protected Object failure(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(obj, "next");
        return lockFreeLinkedListNode == this.queue ? LockFreeLinkedListKt.getLIST_EMPTY() : null;
    }

    protected final boolean retry(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(obj, "next");
        if ((obj instanceof Removed) == null) {
            return null;
        }
        lockFreeLinkedListNode.helpDelete();
        return true;
    }

    @Nullable
    protected final Object onPrepare(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        if ((!(lockFreeLinkedListNode instanceof LockFreeLinkedListHead) ? 1 : null) == null) {
            throw ((Throwable) new IllegalStateException("Check failed.".toString()));
        } else if (!validatePrepared(lockFreeLinkedListNode)) {
            return LockFreeLinkedListKt.REMOVE_PREPARED;
        } else {
            this.affectedNode = lockFreeLinkedListNode;
            this.originalNext = lockFreeLinkedListNode2;
            return null;
        }
    }

    @NotNull
    protected final Object updatedNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        return LockFreeLinkedListNode.access$removed(lockFreeLinkedListNode2);
    }

    protected final void finishOnSuccess(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        LockFreeLinkedListNode.access$finishRemove(lockFreeLinkedListNode, lockFreeLinkedListNode2);
    }
}
