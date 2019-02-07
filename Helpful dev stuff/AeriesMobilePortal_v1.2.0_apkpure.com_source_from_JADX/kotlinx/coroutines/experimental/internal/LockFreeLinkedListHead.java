package kotlinx.coroutines.experimental.internal;

import android.support.media.ExifInterface;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J-\u0010\b\u001a\u00020\t\"\u000e\b\u0000\u0010\n\u0018\u0001*\u00060\u0001j\u0002`\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\t0\rH\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\r\u0010\u0010\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "()V", "isEmpty", "", "()Z", "describeRemove", "Lkotlinx/coroutines/experimental/internal/AtomicDesc;", "forEach", "", "T", "Lkotlinx/coroutines/experimental/internal/Node;", "block", "Lkotlin/Function1;", "remove", "", "validate", "validate$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: LockFreeLinkedList.kt */
public class LockFreeLinkedListHead extends LockFreeLinkedListNode {
    public final boolean isEmpty() {
        return getNext() == ((LockFreeLinkedListHead) this);
    }

    private final <T extends LockFreeLinkedListNode> void forEach(Function1<? super T, Unit> function1) {
        Object next = getNext();
        if (next != null) {
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; (Intrinsics.areEqual(lockFreeLinkedListNode, this) ^ 1) != 0; lockFreeLinkedListNode = LockFreeLinkedListKt.unwrap(lockFreeLinkedListNode.getNext())) {
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                    function1.invoke(lockFreeLinkedListNode);
                }
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
    }

    @NotNull
    public final Void remove() {
        throw new UnsupportedOperationException();
    }

    @Nullable
    public final AtomicDesc describeRemove() {
        throw new UnsupportedOperationException();
    }

    public final void validate$kotlinx_coroutines_core() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        Object next = getNext();
        if (next != null) {
            LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) next;
            LockFreeLinkedListNode lockFreeLinkedListNode3 = lockFreeLinkedListNode;
            lockFreeLinkedListNode = lockFreeLinkedListNode2;
            while ((Intrinsics.areEqual(lockFreeLinkedListNode, this) ^ 1) != 0) {
                LockFreeLinkedListNode unwrap = LockFreeLinkedListKt.unwrap(lockFreeLinkedListNode.getNext());
                lockFreeLinkedListNode.validateNode$kotlinx_coroutines_core(lockFreeLinkedListNode3, unwrap);
                lockFreeLinkedListNode3 = lockFreeLinkedListNode;
                lockFreeLinkedListNode = unwrap;
            }
            Object next2 = getNext();
            if (next2 != null) {
                validateNode$kotlinx_coroutines_core(lockFreeLinkedListNode3, (LockFreeLinkedListNode) next2);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
    }
}
