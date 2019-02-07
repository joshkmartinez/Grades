package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.internal.AtomicDesc;
import kotlinx.coroutines.experimental.internal.AtomicOp;
import kotlinx.coroutines.experimental.internal.OpDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u0004\u0018\u00010\nR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/experimental/JobSupport$AtomicSelectOp;", "Lkotlinx/coroutines/experimental/internal/AtomicOp;", "desc", "Lkotlinx/coroutines/experimental/internal/AtomicDesc;", "activate", "", "(Lkotlinx/coroutines/experimental/JobSupport;Lkotlinx/coroutines/experimental/internal/AtomicDesc;Z)V", "complete", "", "affected", "", "failure", "completeSelect", "prepare", "prepareIfNotSelected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: Job.kt */
final class JobSupport$AtomicSelectOp extends AtomicOp {
    @JvmField
    public final boolean activate;
    @NotNull
    @JvmField
    public final AtomicDesc desc;
    final /* synthetic */ JobSupport this$0;

    public JobSupport$AtomicSelectOp(@NotNull JobSupport jobSupport, AtomicDesc atomicDesc, boolean z) {
        Intrinsics.checkParameterIsNotNull(atomicDesc, "desc");
        this.this$0 = jobSupport;
        this.desc = atomicDesc;
        this.activate = z;
    }

    @Nullable
    public Object prepare() {
        Object prepareIfNotSelected = prepareIfNotSelected();
        return prepareIfNotSelected != null ? prepareIfNotSelected : this.desc.prepare(this);
    }

    public void complete(@Nullable Object obj, @Nullable Object obj2) {
        completeSelect(obj2);
        this.desc.complete(this, obj2);
    }

    @Nullable
    public final Object prepareIfNotSelected() {
        while (true) {
            JobSupport$AtomicSelectOp access$get_state$p = JobSupport.access$get_state$p(this.this$0);
            JobSupport$AtomicSelectOp jobSupport$AtomicSelectOp = this;
            if (access$get_state$p == jobSupport$AtomicSelectOp) {
                return null;
            }
            if (access$get_state$p instanceof OpDescriptor) {
                access$get_state$p.perform(this.this$0);
            } else if (access$get_state$p == JobKt.access$getEmptyNew$p()) {
                if (JobSupport.Companion.getSTATE().compareAndSet(this.this$0, access$get_state$p, this)) {
                    return null;
                }
            } else if (!(access$get_state$p instanceof JobSupport$NodeList)) {
                return JobKt.getALREADY_SELECTED();
            } else {
                JobSupport$AtomicSelectOp jobSupport$AtomicSelectOp2 = ((JobSupport$NodeList) access$get_state$p)._active;
                if (jobSupport$AtomicSelectOp2 == null) {
                    if (JobSupport$NodeList.ACTIVE.compareAndSet(access$get_state$p, null, this)) {
                        return null;
                    }
                } else if (jobSupport$AtomicSelectOp2 == jobSupport$AtomicSelectOp) {
                    return null;
                } else {
                    if (!(jobSupport$AtomicSelectOp2 instanceof OpDescriptor)) {
                        return JobKt.getALREADY_SELECTED();
                    }
                    jobSupport$AtomicSelectOp2.perform(access$get_state$p);
                }
            }
        }
    }

    private final void completeSelect(Object obj) {
        obj = obj == null ? true : null;
        JobSupport$AtomicSelectOp access$get_state$p = JobSupport.access$get_state$p(this.this$0);
        JobSupport$AtomicSelectOp jobSupport$AtomicSelectOp = this;
        if (access$get_state$p == jobSupport$AtomicSelectOp) {
            Object access$getEmptyNew$p = (obj == null || !this.activate) ? JobKt.access$getEmptyNew$p() : JobKt.access$getEmptyActive$p();
            if (JobSupport.Companion.getSTATE().compareAndSet(this.this$0, this, access$getEmptyNew$p) && obj != null) {
                this.this$0.onStart();
            }
        } else if ((access$get_state$p instanceof JobSupport$NodeList) && ((JobSupport$NodeList) access$get_state$p)._active == jobSupport$AtomicSelectOp) {
            Object obj2 = (obj == null || !this.activate) ? null : JobSupport$NodeList.ACTIVE_STATE;
            if (JobSupport$NodeList.ACTIVE.compareAndSet(access$get_state$p, this, obj2) && obj != null) {
                this.this$0.onStart();
            }
        }
    }
}
