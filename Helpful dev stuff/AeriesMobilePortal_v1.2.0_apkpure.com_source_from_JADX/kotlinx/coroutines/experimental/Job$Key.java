package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.coroutines.experimental.CoroutineContext$Key;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/experimental/Job$Key;", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "Lkotlinx/coroutines/experimental/Job;", "()V", "invoke", "parent", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: Job.kt */
public final class Job$Key implements CoroutineContext$Key<Job> {
    private Job$Key() {
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Job invoke$default(Job$Key job$Key, Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return job$Key.invoke(job);
    }

    @NotNull
    public final Job invoke(@Nullable Job job) {
        return new JobImpl(job);
    }
}
