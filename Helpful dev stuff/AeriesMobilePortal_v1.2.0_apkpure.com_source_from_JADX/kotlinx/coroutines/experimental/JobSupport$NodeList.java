package kotlinx.coroutines.experimental;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlinx.coroutines.experimental.JobSupport.Incomplete;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.experimental.internal.OpDescriptor;
import kotlinx.coroutines.experimental.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/experimental/JobSupport$NodeList;", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/experimental/JobSupport$Incomplete;", "active", "", "(Z)V", "_active", "", "getActive", "()Ljava/lang/Object;", "idempotentStart", "getIdempotentStart", "isActive", "()Z", "toString", "", "Companion", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: Job.kt */
final class JobSupport$NodeList extends LockFreeLinkedListHead implements Incomplete {
    @NotNull
    @JvmField
    public static final AtomicReferenceFieldUpdater<JobSupport$NodeList, Object> ACTIVE;
    @NotNull
    @JvmField
    public static final Symbol ACTIVE_STATE = new Symbol("ACTIVE_STATE");
    public static final Companion Companion = new Companion();
    @Nullable
    @JvmField
    public volatile Object _active;

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/experimental/JobSupport$NodeList$Companion;", "", "()V", "ACTIVE", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlinx/coroutines/experimental/JobSupport$NodeList;", "ACTIVE_STATE", "Lkotlinx/coroutines/experimental/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: Job.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public JobSupport$NodeList(boolean z) {
        this._active = z ? ACTIVE_STATE : false;
    }

    @Nullable
    public final Object getActive() {
        while (true) {
            Object obj = this._active;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    public boolean isActive() {
        return getActive() != null;
    }

    @Nullable
    public Object getIdempotentStart() {
        Symbol active = getActive();
        return active == ACTIVE_STATE ? null : active;
    }

    static {
        AtomicReferenceFieldUpdater newUpdater = AtomicReferenceFieldUpdater.newUpdater(JobSupport$NodeList.class, Object.class, "_active");
        Intrinsics.checkExpressionValueIsNotNull(newUpdater, "AtomicReferenceFieldUpda…y::class.java, \"_active\")");
        ACTIVE = newUpdater;
    }

    @NotNull
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List");
        stringBuilder.append(isActive() ? "{Active}" : "{New}");
        stringBuilder.append("[");
        BooleanRef booleanRef = new BooleanRef();
        booleanRef.element = true;
        Object next = getNext();
        if (next != null) {
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; (Intrinsics.areEqual(lockFreeLinkedListNode, this) ^ 1) != 0; lockFreeLinkedListNode = LockFreeLinkedListKt.unwrap(lockFreeLinkedListNode.getNext())) {
                if (lockFreeLinkedListNode instanceof JobNode) {
                    JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                    if (booleanRef.element) {
                        booleanRef.element = false;
                    } else {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(jobNode);
                }
            }
            stringBuilder.append("]");
            String stringBuilder2 = stringBuilder.toString();
            Intrinsics.checkExpressionValueIsNotNull(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
            return stringBuilder2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
    }
}
