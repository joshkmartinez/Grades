package kotlinx.coroutines.experimental.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/experimental/internal/Removed;", "", "ref", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/internal/Node;", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: LockFreeLinkedList.kt */
final class Removed {
    @NotNull
    @JvmField
    public final LockFreeLinkedListNode ref;

    public Removed(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "ref");
        this.ref = lockFreeLinkedListNode;
    }

    @NotNull
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Removed[");
        stringBuilder.append(this.ref);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
