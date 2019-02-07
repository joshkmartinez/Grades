package kotlinx.coroutines.experimental.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.Job;
import kotlinx.coroutines.experimental.Job.DefaultImpls;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, k = 3, mv = {1, 1, 6})
/* compiled from: Produce.kt */
public final class ProducerJob$DefaultImpls {
    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public static <E> Job plus(@NotNull ProducerJob<? extends E> producerJob, Job job) {
        Intrinsics.checkParameterIsNotNull(job, "other");
        return DefaultImpls.plus(producerJob, job);
    }
}
