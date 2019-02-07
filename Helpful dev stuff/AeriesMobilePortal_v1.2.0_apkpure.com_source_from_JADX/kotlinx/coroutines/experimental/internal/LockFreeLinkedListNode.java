package kotlinx.coroutines.experimental.internal;

import android.support.media.ExifInterface;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0017\u0018\u0000 <2\u00020\u0001:\u0005:;<=>B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0012J%\u0010\u0013\u001a\u00020\b2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00122\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0015H\bJ-\u0010\u0016\u001a\u00020\b2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00122\u0016\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0012\u0012\u0004\u0012\u00020\b0\u0018H\bJ=\u0010\u0019\u001a\u00020\b2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00122\u0016\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0012\u0012\u0004\u0012\u00020\b0\u00182\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0015H\bJ \u0010\u001a\u001a\u00020\b2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00122\n\u0010\n\u001a\u00060\u0000j\u0002`\u0012H\u0001J\u0012\u0010\u001b\u001a\u00020\b2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0012J'\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u001d\"\f\b\u0000\u0010\u001e*\u00060\u0000j\u0002`\u00122\u0006\u0010\u0011\u001a\u0002H\u001e¢\u0006\u0002\u0010\u001fJ\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u00120#J\u0014\u0010$\u001a\u00020\u00102\n\u0010\n\u001a\u00060\u0000j\u0002`\u0012H\u0002J\u0014\u0010%\u001a\u00020\u00102\n\u0010\n\u001a\u00060\u0000j\u0002`\u0012H\u0002J\b\u0010&\u001a\u00020\u0010H\u0001J\u001e\u0010'\u001a\u00020\u00102\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00122\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J%\u0010*\u001a\u00020+2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00122\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0015H\bJ\f\u0010,\u001a\u00060\u0000j\u0002`\u0012H\u0002J\b\u0010-\u001a\u00020\bH\u0016J\u0018\u0010.\u001a\u0004\u0018\u0001H\u001e\"\u0006\b\u0000\u0010\u001e\u0018\u0001H\b¢\u0006\u0002\u0010\fJ,\u0010/\u001a\u0004\u0018\u0001H\u001e\"\u0006\b\u0000\u0010\u001e\u0018\u00012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\b0\u0018H\b¢\u0006\u0002\u00100J\u000e\u00101\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0012J\b\u00102\u001a\u00020\u0006H\u0002J\b\u00103\u001a\u000204H\u0016J(\u00105\u001a\u0002062\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00122\n\u0010\n\u001a\u00060\u0000j\u0002`\u00122\u0006\u00107\u001a\u00020+H\u0001J%\u00108\u001a\u00020\u00102\n\u0010\r\u001a\u00060\u0000j\u0002`\u00122\n\u0010\n\u001a\u00060\u0000j\u0002`\u0012H\u0000¢\u0006\u0002\b9R\u0012\u0010\u0003\u001a\u00020\u00018\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006?"}, d2 = {"Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "", "()V", "_next", "_prev", "_removedRef", "Lkotlinx/coroutines/experimental/internal/Removed;", "isRemoved", "", "()Z", "next", "getNext", "()Ljava/lang/Object;", "prev", "getPrev", "addLast", "", "node", "Lkotlinx/coroutines/experimental/internal/Node;", "addLastIf", "condition", "Lkotlin/Function0;", "addLastIfPrev", "predicate", "Lkotlin/Function1;", "addLastIfPrevAndIf", "addNext", "addOneIfEmpty", "describeAddLast", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AddLastDesc;", "T", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AddLastDesc;", "describeRemove", "Lkotlinx/coroutines/experimental/internal/AtomicDesc;", "describeRemoveFirst", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "finishAdd", "finishRemove", "helpDelete", "helpInsert", "op", "Lkotlinx/coroutines/experimental/internal/OpDescriptor;", "makeCondAddOp", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$CondAddOp;", "markPrev", "remove", "removeFirstIfIsInstanceOf", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removed", "toString", "", "tryCondAddNext", "", "condAdd", "validateNode", "validateNode$kotlinx_coroutines_core", "AbstractAtomicDesc", "AddLastDesc", "Companion", "CondAddOp", "RemoveFirstDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: LockFreeLinkedList.kt */
public class LockFreeLinkedListNode {
    public static final Companion Companion = new Companion(null);
    @NotNull
    @JvmField
    public static final AtomicReferenceFieldUpdater<LockFreeLinkedListNode, Object> NEXT;
    @NotNull
    @JvmField
    public static final AtomicReferenceFieldUpdater<LockFreeLinkedListNode, Object> PREV;
    @NotNull
    @JvmField
    public static final AtomicReferenceFieldUpdater<LockFreeLinkedListNode, Removed> REMOVED_REF;
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Removed _removedRef;

    static {
        AtomicReferenceFieldUpdater newUpdater = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
        Intrinsics.checkExpressionValueIsNotNull(newUpdater, "AtomicReferenceFieldUpda…Any::class.java, \"_next\")");
        NEXT = newUpdater;
        newUpdater = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
        Intrinsics.checkExpressionValueIsNotNull(newUpdater, "AtomicReferenceFieldUpda…Any::class.java, \"_prev\")");
        PREV = newUpdater;
        newUpdater = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Removed.class, "_removedRef");
        Intrinsics.checkExpressionValueIsNotNull(newUpdater, "AtomicReferenceFieldUpda…lass.java, \"_removedRef\")");
        REMOVED_REF = newUpdater;
    }

    private final Removed removed() {
        Removed removed = this._removedRef;
        if (removed != null) {
            return removed;
        }
        removed = new Removed(this);
        REMOVED_REF.lazySet(this, removed);
        return removed;
    }

    @NotNull
    @PublishedApi
    public final CondAddOp makeCondAddOp(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(function0, "condition");
        return new 1(function0, lockFreeLinkedListNode, lockFreeLinkedListNode);
    }

    public final boolean isRemoved() {
        return getNext() instanceof Removed;
    }

    @NotNull
    public final Object getNext() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    @NotNull
    public final Object getPrev() {
        while (true) {
            Object obj = this._prev;
            if (obj instanceof Removed) {
                return obj;
            }
            if (obj != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                if (lockFreeLinkedListNode.getNext() == this) {
                    return obj;
                }
                helpInsert(lockFreeLinkedListNode, null);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        }
    }

    public final boolean addOneIfEmpty(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        PREV.lazySet(lockFreeLinkedListNode, this);
        NEXT.lazySet(lockFreeLinkedListNode, this);
        while (getNext() == this) {
            if (NEXT.compareAndSet(this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.finishAdd(this);
                return true;
            }
        }
        return null;
    }

    public final void addLast(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Object prev;
        do {
            prev = getPrev();
            if (prev == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        } while (!((LockFreeLinkedListNode) prev).addNext(lockFreeLinkedListNode, this));
    }

    @NotNull
    public final <T extends LockFreeLinkedListNode> AddLastDesc<T> describeAddLast(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "node");
        return new AddLastDesc(this, t);
    }

    public final boolean addLastIfPrev(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Function1<? super LockFreeLinkedListNode, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        do {
            Object prev = getPrev();
            if (prev != null) {
                lockFreeLinkedListNode2 = (LockFreeLinkedListNode) prev;
                if (!((Boolean) function1.invoke(lockFreeLinkedListNode2)).booleanValue()) {
                    return null;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        } while (!lockFreeLinkedListNode2.addNext(lockFreeLinkedListNode, this));
        return true;
    }

    @PublishedApi
    public final boolean addNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        PREV.lazySet(lockFreeLinkedListNode, this);
        NEXT.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        if (!NEXT.compareAndSet(this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
            return null;
        }
        lockFreeLinkedListNode.finishAdd(lockFreeLinkedListNode2);
        return true;
    }

    @PublishedApi
    public final int tryCondAddNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2, @NotNull CondAddOp condAddOp) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        Intrinsics.checkParameterIsNotNull(condAddOp, "condAdd");
        PREV.lazySet(lockFreeLinkedListNode, this);
        NEXT.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        condAddOp.oldNext = lockFreeLinkedListNode2;
        if (NEXT.compareAndSet(this, lockFreeLinkedListNode2, condAddOp) == null) {
            return null;
        }
        return condAddOp.perform(this) == null ? true : 2;
    }

    public boolean remove() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListNode next;
        do {
            next = getNext();
            boolean z = false;
            if (next instanceof Removed) {
                return false;
            }
            if (next != this) {
                z = true;
            }
            if (!z) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (next != null) {
                lockFreeLinkedListNode = next;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        } while (!NEXT.compareAndSet(this, next, lockFreeLinkedListNode.removed()));
        finishRemove(lockFreeLinkedListNode);
        return true;
    }

    @Nullable
    public AtomicDesc describeRemove() {
        if (isRemoved()) {
            return null;
        }
        return new 1(this);
    }

    @Nullable
    public final LockFreeLinkedListNode removeFirstOrNull() {
        while (true) {
            Object next = getNext();
            if (next != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                if (lockFreeLinkedListNode == this) {
                    return null;
                }
                if (lockFreeLinkedListNode.remove()) {
                    return lockFreeLinkedListNode;
                }
                lockFreeLinkedListNode.helpDelete();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        }
    }

    @NotNull
    public final RemoveFirstDesc<LockFreeLinkedListNode> describeRemoveFirst() {
        return new RemoveFirstDesc(this);
    }

    private final <T> T removeFirstIfIsInstanceOf() {
        while (true) {
            Object next = getNext();
            if (next != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                if (lockFreeLinkedListNode == this) {
                    return null;
                }
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (!(lockFreeLinkedListNode instanceof Object)) {
                    return null;
                }
                if (lockFreeLinkedListNode.remove()) {
                    return lockFreeLinkedListNode;
                }
                lockFreeLinkedListNode.helpDelete();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        }
    }

    private final <T> T removeFirstIfIsInstanceOfOrPeekIf(Function1<? super T, Boolean> function1) {
        while (true) {
            Object next = getNext();
            if (next != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                if (lockFreeLinkedListNode == this) {
                    return null;
                }
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (!(lockFreeLinkedListNode instanceof Object)) {
                    return null;
                }
                if (((Boolean) function1.invoke(lockFreeLinkedListNode)).booleanValue() || lockFreeLinkedListNode.remove()) {
                    return lockFreeLinkedListNode;
                }
                lockFreeLinkedListNode.helpDelete();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        }
    }

    private final void finishAdd(LockFreeLinkedListNode lockFreeLinkedListNode) {
        Object obj;
        do {
            obj = lockFreeLinkedListNode._prev;
            if (!(obj instanceof Removed)) {
                if (getNext() != lockFreeLinkedListNode) {
                }
            }
            return;
        } while (!PREV.compareAndSet(lockFreeLinkedListNode, obj, this));
        if (getNext() instanceof Removed) {
            if (obj != null) {
                lockFreeLinkedListNode.helpInsert((LockFreeLinkedListNode) obj, null);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        }
    }

    private final void finishRemove(LockFreeLinkedListNode lockFreeLinkedListNode) {
        helpDelete();
        lockFreeLinkedListNode.helpInsert(LockFreeLinkedListKt.unwrap(this._prev), null);
    }

    private final LockFreeLinkedListNode markPrev() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        do {
            obj = this._prev;
            if (obj instanceof Removed) {
                return ((Removed) obj).ref;
            }
            atomicReferenceFieldUpdater = PREV;
            if (obj != null) {
                lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, lockFreeLinkedListNode.removed()));
        return lockFreeLinkedListNode;
    }

    @PublishedApi
    public final void helpDelete() {
        LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) null;
        LockFreeLinkedListNode markPrev = markPrev();
        Object obj = this._next;
        if (obj != null) {
            LockFreeLinkedListNode lockFreeLinkedListNode2 = ((Removed) obj).ref;
            while (true) {
                LockFreeLinkedListNode next;
                Object obj2 = lockFreeLinkedListNode;
                while (true) {
                    Object next2 = lockFreeLinkedListNode2.getNext();
                    if (next2 instanceof Removed) {
                        lockFreeLinkedListNode2.markPrev();
                        lockFreeLinkedListNode2 = ((Removed) next2).ref;
                    } else {
                        next = markPrev.getNext();
                        if (next instanceof Removed) {
                            if (obj2 != null) {
                                break;
                            }
                            markPrev = LockFreeLinkedListKt.unwrap(markPrev._prev);
                        } else if (next != this) {
                            if (next != null) {
                                LockFreeLinkedListNode lockFreeLinkedListNode3 = next;
                                if (lockFreeLinkedListNode3 != lockFreeLinkedListNode2) {
                                    LockFreeLinkedListNode lockFreeLinkedListNode4 = lockFreeLinkedListNode3;
                                    obj2 = markPrev;
                                    markPrev = lockFreeLinkedListNode4;
                                } else {
                                    return;
                                }
                            }
                            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
                        } else if (NEXT.compareAndSet(markPrev, this, lockFreeLinkedListNode2)) {
                            return;
                        }
                    }
                }
                markPrev.markPrev();
                NEXT.compareAndSet(obj2, markPrev, ((Removed) next).ref);
                markPrev = obj2;
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Removed");
        }
    }

    private final void helpInsert(LockFreeLinkedListNode lockFreeLinkedListNode, OpDescriptor opDescriptor) {
        LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) null;
        while (true) {
            OpDescriptor opDescriptor2;
            Object obj = lockFreeLinkedListNode2;
            while (true) {
                opDescriptor2 = lockFreeLinkedListNode._next;
                if (opDescriptor2 != opDescriptor) {
                    if (opDescriptor2 instanceof OpDescriptor) {
                        opDescriptor2.perform(lockFreeLinkedListNode);
                    } else if (!(opDescriptor2 instanceof Removed)) {
                        LockFreeLinkedListNode lockFreeLinkedListNode3 = this._prev;
                        if (!(lockFreeLinkedListNode3 instanceof Removed)) {
                            if (opDescriptor2 != this) {
                                if (opDescriptor2 != null) {
                                    obj = lockFreeLinkedListNode;
                                    lockFreeLinkedListNode = (LockFreeLinkedListNode) opDescriptor2;
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
                                }
                            } else if (lockFreeLinkedListNode3 != lockFreeLinkedListNode) {
                                if (PREV.compareAndSet(this, lockFreeLinkedListNode3, lockFreeLinkedListNode) && !(lockFreeLinkedListNode._prev instanceof Removed)) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        return;
                    } else if (obj != null) {
                        break;
                    } else {
                        lockFreeLinkedListNode = LockFreeLinkedListKt.unwrap(lockFreeLinkedListNode._prev);
                    }
                } else {
                    return;
                }
            }
            lockFreeLinkedListNode.markPrev();
            NEXT.compareAndSet(obj, lockFreeLinkedListNode, ((Removed) opDescriptor2).ref);
            lockFreeLinkedListNode = obj;
        }
    }

    public final void validateNode$kotlinx_coroutines_core(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "prev");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        Object obj = null;
        if ((lockFreeLinkedListNode == this._prev ? 1 : null) != null) {
            if (lockFreeLinkedListNode2 == this._next) {
                obj = 1;
            }
            if (obj == null) {
                throw ((Throwable) new IllegalStateException("Check failed.".toString()));
            }
            return;
        }
        throw ((Throwable) new IllegalStateException("Check failed.".toString()));
    }

    @NotNull
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        return stringBuilder.toString();
    }

    public final boolean addLastIf(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(function0, "condition");
        CondAddOp 1 = new 1(function0, lockFreeLinkedListNode, lockFreeLinkedListNode);
        while (true) {
            function0 = getPrev();
            if (function0 != null) {
                switch (((LockFreeLinkedListNode) function0).tryCondAddNext(lockFreeLinkedListNode, this, 1)) {
                    case 1:
                        return true;
                    case 2:
                        return null;
                    default:
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        }
    }

    public final boolean addLastIfPrevAndIf(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Function1<? super LockFreeLinkedListNode, Boolean> function1, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Intrinsics.checkParameterIsNotNull(function0, "condition");
        CondAddOp 1 = new 1(function0, lockFreeLinkedListNode, lockFreeLinkedListNode);
        while (true) {
            function0 = getPrev();
            if (function0 != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) function0;
                if (!((Boolean) function1.invoke(lockFreeLinkedListNode2)).booleanValue()) {
                    return false;
                }
                switch (lockFreeLinkedListNode2.tryCondAddNext(lockFreeLinkedListNode, this, 1)) {
                    case 1:
                        return true;
                    case 2:
                        return false;
                    default:
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        }
    }
}
