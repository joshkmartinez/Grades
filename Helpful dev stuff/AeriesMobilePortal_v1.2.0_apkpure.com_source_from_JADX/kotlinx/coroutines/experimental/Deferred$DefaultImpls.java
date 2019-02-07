package kotlinx.coroutines.experimental;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.Job.DefaultImpls;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, k = 3, mv = {1, 1, 6})
/* compiled from: Deferred.kt */
public final class Deferred$DefaultImpls {
    @Deprecated(message = "Use `isActive`", replaceWith = @ReplaceWith(expression = "isActive", imports = {}))
    public static /* synthetic */ void isComputing$annotations() {
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public static <T> Job plus(@NotNull Deferred<? extends T> deferred, Job job) {
        Intrinsics.checkParameterIsNotNull(job, "other");
        return DefaultImpls.plus(deferred, job);
    }

    public static <T> boolean isComputing(Deferred<? extends T> deferred) {
        return deferred.isActive();
    }
}
