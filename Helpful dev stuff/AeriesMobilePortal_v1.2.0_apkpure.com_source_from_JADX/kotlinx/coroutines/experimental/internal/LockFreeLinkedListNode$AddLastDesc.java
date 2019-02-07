package kotlinx.coroutines.experimental.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\u000e\b\u0000\u0010\u0001 \u0001*\u00060\u0002j\u0002`\u00032\u00020\u0004B\u0019\u0012\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J \u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003H\u0014J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003H\u0014J\u001c\u0010\u0016\u001a\u00020\u00172\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0013\u001a\u00020\u0015H\u0014J\u0014\u0010\u0018\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0004J \u0010\u001b\u001a\u00020\u00152\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003H\u0014R$\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0012\u0010\u0006\u001a\u00028\u00008\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001c\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038DX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\nR\u0014\u0010\u0005\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AddLastDesc;", "T", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/internal/Node;", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "queue", "node", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;)V", "affectedNode", "getAffectedNode", "()Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "setAffectedNode", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "originalNext", "getOriginalNext", "finishOnSuccess", "", "affected", "next", "onPrepare", "", "retry", "", "takeAffectedNode", "op", "Lkotlinx/coroutines/experimental/internal/OpDescriptor;", "updatedNext", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: LockFreeLinkedList.kt */
public class LockFreeLinkedListNode$AddLastDesc<T extends LockFreeLinkedListNode> extends LockFreeLinkedListNode$AbstractAtomicDesc {
    @Nullable
    private LockFreeLinkedListNode affectedNode;
    @NotNull
    @JvmField
    public final T node;
    @NotNull
    @JvmField
    public final LockFreeLinkedListNode queue;

    public LockFreeLinkedListNode$AddLastDesc(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull T t) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "queue");
        Intrinsics.checkParameterIsNotNull(t, "node");
        this.queue = lockFreeLinkedListNode;
        this.node = t;
        lockFreeLinkedListNode = (LockFreeLinkedListNode.access$get_next$p(this.node) == this.node && LockFreeLinkedListNode.access$get_prev$p(this.node) == this.node) ? true : null;
        if (lockFreeLinkedListNode == null) {
            throw ((Throwable) new IllegalStateException("Check failed.".toString()));
        }
    }

    @NotNull
    protected final LockFreeLinkedListNode takeAffectedNode(@NotNull OpDescriptor opDescriptor) {
        Intrinsics.checkParameterIsNotNull(opDescriptor, "op");
        while (true) {
            Object access$get_prev$p = LockFreeLinkedListNode.access$get_prev$p(this.queue);
            if (access$get_prev$p != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) access$get_prev$p;
                Object access$get_next$p = LockFreeLinkedListNode.access$get_next$p(lockFreeLinkedListNode);
                if (access$get_next$p == this.queue || access$get_next$p == opDescriptor) {
                    return lockFreeLinkedListNode;
                }
                if (access$get_next$p instanceof OpDescriptor) {
                    ((OpDescriptor) access$get_next$p).perform(lockFreeLinkedListNode);
                } else {
                    LockFreeLinkedListNode.access$helpInsert(this.queue, lockFreeLinkedListNode, opDescriptor);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        }
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
        return this.queue;
    }

    protected boolean retry(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(obj, "next");
        return obj != this.queue ? true : null;
    }

    @Nullable
    protected Object onPrepare(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        this.affectedNode = lockFreeLinkedListNode;
        return null;
    }

    @NotNull
    protected Object updatedNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        LockFreeLinkedListNode.PREV.compareAndSet(this.node, this.node, lockFreeLinkedListNode);
        LockFreeLinkedListNode.NEXT.compareAndSet(this.node, this.node, this.queue);
        return this.node;
    }

    protected void finishOnSuccess(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        LockFreeLinkedListNode.access$finishAdd(this.node, this.queue);
    }
}
