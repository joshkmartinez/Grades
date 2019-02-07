package kotlinx.coroutines.experimental;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.experimental.JobSupport.Incomplete;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001R\"\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/experimental/JobSupport$Companion;", "", "()V", "STATE", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlinx/coroutines/experimental/JobSupport;", "getSTATE", "()Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "stateToString", "", "state", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: Job.kt */
protected final class JobSupport$Companion {
    private JobSupport$Companion() {
    }

    private final AtomicReferenceFieldUpdater<JobSupport, Object> getSTATE() {
        return JobSupport.access$getSTATE$cp();
    }

    @NotNull
    public final String stateToString(@Nullable Object obj) {
        if (obj instanceof Incomplete) {
            return ((Incomplete) obj).isActive() != null ? "Active" : "New";
        } else {
            return "Completed";
        }
    }
}
