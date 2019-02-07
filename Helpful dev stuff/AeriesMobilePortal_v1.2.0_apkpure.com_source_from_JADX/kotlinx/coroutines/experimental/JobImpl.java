package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/experimental/JobImpl;", "Lkotlinx/coroutines/experimental/JobSupport;", "parent", "Lkotlinx/coroutines/experimental/Job;", "(Lkotlinx/coroutines/experimental/Job;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: Job.kt */
final class JobImpl extends JobSupport {
    public JobImpl() {
        this(null, 1, null);
    }

    public JobImpl(@Nullable Job job) {
        super(true);
        initParentJob(job);
    }

    public /* synthetic */ JobImpl(Job job, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            job = null;
        }
        this(job);
    }
}
