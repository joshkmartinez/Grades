package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a\u001a\u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\t"}, d2 = {"newFixedThreadPoolContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "nThreads", "", "name", "", "parent", "Lkotlinx/coroutines/experimental/Job;", "newSingleThreadContext", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 6})
/* compiled from: ThreadPoolDispatcher.kt */
public final class ThreadPoolDispatcherKt {
    @NotNull
    public static /* bridge */ /* synthetic */ CoroutineContext newSingleThreadContext$default(String str, Job job, int i, Object obj) {
        if ((i & 2) != 0) {
            job = null;
        }
        return newSingleThreadContext(str, job);
    }

    @NotNull
    public static final CoroutineContext newSingleThreadContext(@NotNull String str, @Nullable Job job) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        return newFixedThreadPoolContext(1, str, job);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ CoroutineContext newFixedThreadPoolContext$default(int i, String str, Job job, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            job = null;
        }
        return newFixedThreadPoolContext(i, str, job);
    }

    @NotNull
    public static final CoroutineContext newFixedThreadPoolContext(int i, @NotNull String str, @Nullable Job job) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Object obj = 1;
        if (i < 1) {
            obj = null;
        }
        if (obj != null) {
            job = Job.Key.invoke(job);
            return job.plus(new ThreadPoolDispatcher(i, str, job));
        }
        str = new StringBuilder();
        str.append("Expected at least one thread, but ");
        str.append(i);
        str.append(" specified");
        throw ((Throwable) new IllegalArgumentException(str.toString().toString()));
    }
}
