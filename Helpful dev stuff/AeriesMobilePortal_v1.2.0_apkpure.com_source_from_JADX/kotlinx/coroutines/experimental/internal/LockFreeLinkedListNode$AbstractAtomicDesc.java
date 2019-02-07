package kotlinx.coroutines.experimental.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0011\u001a\u00020\u000fH\u0014J \u0010\u0012\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0011\u001a\u00060\u0004j\u0002`\u0005H$J\"\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0011\u001a\u00060\u0004j\u0002`\u0005H$J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0011\u001a\u00020\u000fH\u0014J\u0014\u0010\u0017\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\f\u001a\u00020\u0018H\u0014J \u0010\u0019\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0011\u001a\u00060\u0004j\u0002`\u0005H$R\u001a\u0010\u0003\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/experimental/internal/AtomicDesc;", "()V", "affectedNode", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/internal/Node;", "getAffectedNode", "()Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "originalNext", "getOriginalNext", "complete", "", "op", "Lkotlinx/coroutines/experimental/internal/AtomicOp;", "failure", "", "affected", "next", "finishOnSuccess", "onPrepare", "prepare", "retry", "", "takeAffectedNode", "Lkotlinx/coroutines/experimental/internal/OpDescriptor;", "updatedNext", "PrepareOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: LockFreeLinkedList.kt */
public abstract class LockFreeLinkedListNode$AbstractAtomicDesc extends AtomicDesc {

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AbstractAtomicDesc$PrepareOp;", "Lkotlinx/coroutines/experimental/internal/OpDescriptor;", "next", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/internal/Node;", "op", "Lkotlinx/coroutines/experimental/internal/AtomicOp;", "desc", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/experimental/internal/AtomicOp;Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AbstractAtomicDesc;)V", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: LockFreeLinkedList.kt */
    private static final class PrepareOp extends OpDescriptor {
        @NotNull
        @JvmField
        public final LockFreeLinkedListNode$AbstractAtomicDesc desc;
        @NotNull
        @JvmField
        public final LockFreeLinkedListNode next;
        @NotNull
        @JvmField
        public final AtomicOp op;

        public PrepareOp(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull AtomicOp atomicOp, @NotNull LockFreeLinkedListNode$AbstractAtomicDesc lockFreeLinkedListNode$AbstractAtomicDesc) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "next");
            Intrinsics.checkParameterIsNotNull(atomicOp, "op");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode$AbstractAtomicDesc, "desc");
            this.next = lockFreeLinkedListNode;
            this.op = atomicOp;
            this.desc = lockFreeLinkedListNode$AbstractAtomicDesc;
        }

        @Nullable
        public Object perform(@Nullable Object obj) {
            if (obj != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                Object onPrepare = this.desc.onPrepare(lockFreeLinkedListNode, this.next);
                if (onPrepare != null) {
                    if (onPrepare == LockFreeLinkedListKt.REMOVE_PREPARED) {
                        if (LockFreeLinkedListNode.NEXT.compareAndSet(obj, this, LockFreeLinkedListNode.access$removed(this.next)) != null) {
                            lockFreeLinkedListNode.helpDelete();
                        }
                    } else {
                        this.op.tryDecide(onPrepare);
                        LockFreeLinkedListNode.NEXT.compareAndSet(obj, this, this.next);
                    }
                    return onPrepare;
                }
                onPrepare = null;
                if ((this.desc.getAffectedNode() == obj ? 1 : null) != null) {
                    if (this.desc.getOriginalNext() == this.next) {
                        onPrepare = 1;
                    }
                    if (onPrepare != null) {
                        LockFreeLinkedListNode.NEXT.compareAndSet(obj, this, this.op.isDecided() ? this.next : this.op);
                        return null;
                    }
                    throw ((Throwable) new IllegalStateException("Check failed.".toString()));
                }
                throw ((Throwable) new IllegalStateException("Check failed.".toString()));
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
        }
    }

    @Nullable
    protected Object failure(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(obj, "next");
        return null;
    }

    protected abstract void finishOnSuccess(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2);

    @Nullable
    protected abstract LockFreeLinkedListNode getAffectedNode();

    @Nullable
    protected abstract LockFreeLinkedListNode getOriginalNext();

    @Nullable
    protected abstract Object onPrepare(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2);

    protected boolean retry(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(obj, "next");
        return false;
    }

    @NotNull
    protected abstract Object updatedNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2);

    @NotNull
    protected LockFreeLinkedListNode takeAffectedNode(@NotNull OpDescriptor opDescriptor) {
        Intrinsics.checkParameterIsNotNull(opDescriptor, "op");
        opDescriptor = getAffectedNode();
        if (opDescriptor == null) {
            Intrinsics.throwNpe();
        }
        return opDescriptor;
    }

    @Nullable
    public final Object prepare(@NotNull AtomicOp atomicOp) {
        Intrinsics.checkParameterIsNotNull(atomicOp, "op");
        while (true) {
            LockFreeLinkedListNode takeAffectedNode = takeAffectedNode(atomicOp);
            AtomicOp access$get_next$p = LockFreeLinkedListNode.access$get_next$p(takeAffectedNode);
            if (atomicOp.isDecided() || access$get_next$p == atomicOp) {
                return null;
            }
            if (access$get_next$p instanceof OpDescriptor) {
                access$get_next$p.perform(takeAffectedNode);
            } else {
                Object failure = failure(takeAffectedNode, access$get_next$p);
                if (failure != null) {
                    return failure;
                }
                if (!retry(takeAffectedNode, access$get_next$p)) {
                    if (access$get_next$p != null) {
                        PrepareOp prepareOp = new PrepareOp((LockFreeLinkedListNode) access$get_next$p, atomicOp, this);
                        if (LockFreeLinkedListNode.NEXT.compareAndSet(takeAffectedNode, access$get_next$p, prepareOp)) {
                            Object perform = prepareOp.perform(takeAffectedNode);
                            if (perform != LockFreeLinkedListKt.REMOVE_PREPARED) {
                                return perform;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
                    }
                }
            }
        }
    }

    public final void complete(@NotNull AtomicOp atomicOp, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(atomicOp, "op");
        obj = obj == null ? 1 : null;
        LockFreeLinkedListNode affectedNode = getAffectedNode();
        if (affectedNode != null) {
            LockFreeLinkedListNode originalNext = getOriginalNext();
            if (originalNext != null) {
                if (!(LockFreeLinkedListNode.NEXT.compareAndSet(affectedNode, atomicOp, obj != null ? updatedNext(affectedNode, originalNext) : originalNext) == null || obj == null)) {
                    finishOnSuccess(affectedNode, originalNext);
                }
                return;
            }
            LockFreeLinkedListNode$AbstractAtomicDesc lockFreeLinkedListNode$AbstractAtomicDesc = this;
            if ((obj ^ 1) == null) {
                throw ((Throwable) new IllegalStateException("Check failed.".toString()));
            }
            return;
        }
        lockFreeLinkedListNode$AbstractAtomicDesc = this;
        if ((obj ^ 1) == null) {
            throw ((Throwable) new IllegalStateException("Check failed.".toString()));
        }
    }
}
