package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\u0002\u0002\u0004\n\u0002\b\t¨\u0006\u0003"}, d2 = {"yield", "", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 6})
/* compiled from: Yield.kt */
public final class YieldKt {
    @Nullable
    public static final Object yield(@NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
        continuation = CoroutineIntrinsics.normalizeContinuation(continuation);
        CoroutineContext context = continuation.getContext();
        Job job = (Job) context.get(Job.Key);
        if (job != null) {
            if (job.isCompleted()) {
                throw job.getCompletionException();
            }
        }
        if (!(continuation instanceof DispatchedContinuation)) {
            return Unit.INSTANCE;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        if (!dispatchedContinuation.dispatcher.isDispatchNeeded(context)) {
            return Unit.INSTANCE;
        }
        dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(job, Unit.INSTANCE);
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}
