package kotlinx.coroutines.experimental.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\u0010\r\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u000e\u001a\u00020\fH\u0014J \u0010\u000f\u001a\u00020\u00102\n\u0010\r\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u000e\u001a\u00060\u0004j\u0002`\u0005H\u0014J\"\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\u0010\r\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u000e\u001a\u00060\u0004j\u0002`\u0005H\u0014J \u0010\u0012\u001a\u00020\u00132\n\u0010\r\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u000e\u001a\u00060\u0004j\u0002`\u0005H\u0014R\u001c\u0010\u0003\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058TX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u0002¨\u0006\u0014"}, d2 = {"kotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$describeRemove$1", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;)V", "affectedNode", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/internal/Node;", "getAffectedNode", "()Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "originalNext", "getOriginalNext", "setOriginalNext", "failure", "", "affected", "next", "finishOnSuccess", "", "onPrepare", "updatedNext", "Lkotlinx/coroutines/experimental/internal/Removed;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: LockFreeLinkedList.kt */
public final class LockFreeLinkedListNode$describeRemove$1 extends LockFreeLinkedListNode$AbstractAtomicDesc {
    @Nullable
    private LockFreeLinkedListNode originalNext;
    final /* synthetic */ LockFreeLinkedListNode this$0;

    LockFreeLinkedListNode$describeRemove$1(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.this$0 = lockFreeLinkedListNode;
    }

    @Nullable
    protected LockFreeLinkedListNode getAffectedNode() {
        return this.this$0;
    }

    @Nullable
    protected LockFreeLinkedListNode getOriginalNext() {
        return this.originalNext;
    }

    public void setOriginalNext(@Nullable LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.originalNext = lockFreeLinkedListNode;
    }

    @Nullable
    protected Object failure(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(obj, "next");
        return (obj instanceof Removed) != null ? LockFreeLinkedListKt.getALREADY_REMOVED() : null;
    }

    @Nullable
    protected Object onPrepare(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        setOriginalNext(lockFreeLinkedListNode2);
        return null;
    }

    @NotNull
    protected Removed updatedNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        return LockFreeLinkedListNode.access$removed(lockFreeLinkedListNode2);
    }

    protected void finishOnSuccess(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        LockFreeLinkedListNode.access$finishRemove(this.this$0, lockFreeLinkedListNode2);
    }
}
