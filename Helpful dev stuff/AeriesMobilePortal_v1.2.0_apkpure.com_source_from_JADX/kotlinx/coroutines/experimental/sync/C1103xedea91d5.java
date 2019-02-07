package kotlinx.coroutines.experimental.sync;

import kotlin.Metadata;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode$CondAddOp;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0005"}, d2 = {"kotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$CondAddOp;", "(Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;)V", "prepare", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: LockFreeLinkedList.kt */
public final class C1103xedea91d5 extends LockFreeLinkedListNode$CondAddOp {
    final /* synthetic */ LockFreeLinkedListNode $node;
    final /* synthetic */ Object $owner$inlined;
    final /* synthetic */ Object $state$inlined;
    final /* synthetic */ MutexImpl this$0;

    public C1103xedea91d5(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, Object obj, MutexImpl mutexImpl, Object obj2) {
        this.$node = lockFreeLinkedListNode;
        this.$state$inlined = obj;
        this.this$0 = mutexImpl;
        this.$owner$inlined = obj2;
        super(lockFreeLinkedListNode2);
    }

    public Object prepare() {
        return (this.this$0._state == this.$state$inlined ? 1 : null) != null ? null : LockFreeLinkedListKt.getCONDITION_FALSE();
    }
}
