package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/experimental/JobSupport$Cancelled;", "Lkotlinx/coroutines/experimental/JobSupport$CompletedExceptionally;", "idempotentStart", "", "cause", "", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: Job.kt */
public final class JobSupport$Cancelled extends JobSupport$CompletedExceptionally {
    public JobSupport$Cancelled(@Nullable Object obj, @Nullable Throwable th) {
        super(obj, th);
    }
}
