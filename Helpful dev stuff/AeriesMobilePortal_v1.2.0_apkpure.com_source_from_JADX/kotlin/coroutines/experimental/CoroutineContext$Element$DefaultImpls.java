package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.experimental.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
/* compiled from: CoroutineContext.kt */
public final class CoroutineContext$Element$DefaultImpls {
    @NotNull
    public static CoroutineContext plus(Element element, @NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        return CoroutineContext$DefaultImpls.plus(element, coroutineContext);
    }

    @Nullable
    public static <E extends Element> E get(Element element, @NotNull CoroutineContext$Key<E> coroutineContext$Key) {
        Intrinsics.checkParameterIsNotNull(coroutineContext$Key, "key");
        if (element.getKey() != coroutineContext$Key) {
            return null;
        }
        if (element != null) {
            return element;
        }
        throw new TypeCastException("null cannot be cast to non-null type E");
    }

    public static <R> R fold(Element element, R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        return function2.invoke(r, element);
    }

    @NotNull
    public static CoroutineContext minusKey(Element element, @NotNull CoroutineContext$Key<?> coroutineContext$Key) {
        Intrinsics.checkParameterIsNotNull(coroutineContext$Key, "key");
        if (element.getKey() == coroutineContext$Key) {
            element = EmptyCoroutineContext.INSTANCE;
        }
        return element;
    }
}
