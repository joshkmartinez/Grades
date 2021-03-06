package kotlinx.coroutines.experimental;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.ContinuationInterceptor;
import kotlin.coroutines.experimental.CoroutineContext.Element;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\t¨\u0006\u0007"}, d2 = {"delay", "", "time", "", "unit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 6})
/* compiled from: Delay.kt */
public final class DelayKt {
    @Nullable
    public static /* bridge */ /* synthetic */ Object delay$default(long j, TimeUnit timeUnit, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return delay(j, timeUnit, continuation);
    }

    @Nullable
    public static final Object delay(long j, @NotNull TimeUnit timeUnit, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
        int i = 0;
        long j2 = (long) null;
        if (j >= j2) {
            i = 1;
        }
        if (i == 0) {
            timeUnit = new StringBuilder();
            timeUnit.append("Delay time ");
            timeUnit.append(j);
            timeUnit.append(" cannot be negative");
            throw new IllegalArgumentException(timeUnit.toString().toString());
        } else if (j <= j2) {
            return Unit.INSTANCE;
        } else {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), true);
            cancellableContinuationImpl.initCancellability();
            CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
            Element element = cancellableContinuation.getContext().get(ContinuationInterceptor.Key);
            if (!(element instanceof Delay)) {
                element = null;
            }
            Delay delay = (Delay) element;
            if (delay != null) {
                delay.scheduleResumeAfterDelay(j, timeUnit, cancellableContinuation);
            } else {
                Job job = cancellableContinuation;
                j = ScheduledKt.getScheduledExecutor().schedule(new ResumeRunnable(cancellableContinuation), j, timeUnit);
                Intrinsics.checkExpressionValueIsNotNull(j, "scheduledExecutor.schedu…nnable(cont), time, unit)");
                JobKt.cancelFutureOnCompletion(job, (Future) j);
            }
            return cancellableContinuationImpl.getResult();
        }
    }
}
