package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
/* compiled from: CoroutineContext.kt */
public final class CoroutineContext$DefaultImpls {
    @NotNull
    public static CoroutineContext plus(CoroutineContext coroutineContext, @NotNull CoroutineContext coroutineContext2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext2, "context");
        return coroutineContext2 == EmptyCoroutineContext.INSTANCE ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, CoroutineContext$plus$1.INSTANCE);
    }
}
