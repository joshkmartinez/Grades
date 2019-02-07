package kotlinx.coroutines.experimental;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.Job.DefaultImpls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, k = 3, mv = {1, 1, 6})
/* compiled from: CancellableContinuation.kt */
public final class CancellableContinuation$DefaultImpls {
    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public static <T> Job plus(@NotNull CancellableContinuation<? super T> cancellableContinuation, Job job) {
        Intrinsics.checkParameterIsNotNull(job, "other");
        return DefaultImpls.plus(cancellableContinuation, job);
    }

    @Nullable
    public static /* bridge */ /* synthetic */ Object tryResume$default(CancellableContinuation cancellableContinuation, Object obj, Object obj2, int i, Object obj3) {
        if (obj3 == null) {
            if ((i & 2) != 0) {
                obj2 = null;
            }
            return cancellableContinuation.tryResume(obj, obj2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
    }
}
