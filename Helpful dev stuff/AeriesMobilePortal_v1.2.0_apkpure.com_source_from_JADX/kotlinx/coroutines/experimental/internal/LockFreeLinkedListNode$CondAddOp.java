package kotlinx.coroutines.experimental.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@PublishedApi
@Metadata(bv = {1, 0, 1}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b!\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/experimental/internal/AtomicOp;", "newNode", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/internal/Node;", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "", "failure", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: LockFreeLinkedList.kt */
public abstract class LockFreeLinkedListNode$CondAddOp extends AtomicOp {
    @NotNull
    @JvmField
    public final LockFreeLinkedListNode newNode;
    @Nullable
    @JvmField
    public LockFreeLinkedListNode oldNext;

    public LockFreeLinkedListNode$CondAddOp(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "newNode");
        this.newNode = lockFreeLinkedListNode;
    }

    public void complete(@Nullable Object obj, @Nullable Object obj2) {
        if (obj != null) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
            obj2 = obj2 == null ? true : null;
            if (LockFreeLinkedListNode.NEXT.compareAndSet(obj, this, obj2 != null ? this.newNode : this.oldNext) != null && obj2 != null) {
                obj = this.newNode;
                obj2 = this.oldNext;
                if (obj2 == null) {
                    Intrinsics.throwNpe();
                }
                LockFreeLinkedListNode.access$finishAdd(obj, obj2);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
    }
}
