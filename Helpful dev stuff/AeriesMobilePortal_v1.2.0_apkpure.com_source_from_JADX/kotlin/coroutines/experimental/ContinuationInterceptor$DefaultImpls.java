package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.coroutines.experimental.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
/* compiled from: ContinuationInterceptor.kt */
public final class ContinuationInterceptor$DefaultImpls {
    public static <R> R fold(ContinuationInterceptor continuationInterceptor, R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        return CoroutineContext$Element$DefaultImpls.fold(continuationInterceptor, r, function2);
    }

    @Nullable
    public static <E extends Element> E get(ContinuationInterceptor continuationInterceptor, @NotNull CoroutineContext$Key<E> coroutineContext$Key) {
        Intrinsics.checkParameterIsNotNull(coroutineContext$Key, "key");
        return CoroutineContext$Element$DefaultImpls.get(continuationInterceptor, coroutineContext$Key);
    }

    @NotNull
    public static CoroutineContext minusKey(ContinuationInterceptor continuationInterceptor, @NotNull CoroutineContext$Key<?> coroutineContext$Key) {
        Intrinsics.checkParameterIsNotNull(coroutineContext$Key, "key");
        return CoroutineContext$Element$DefaultImpls.minusKey(continuationInterceptor, coroutineContext$Key);
    }

    @NotNull
    public static CoroutineContext plus(ContinuationInterceptor continuationInterceptor, @NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        return CoroutineContext$Element$DefaultImpls.plus(continuationInterceptor, coroutineContext);
    }
}
