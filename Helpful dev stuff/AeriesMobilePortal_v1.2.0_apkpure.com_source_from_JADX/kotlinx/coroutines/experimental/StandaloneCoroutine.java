package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/experimental/StandaloneCoroutine;", "Lkotlinx/coroutines/experimental/AbstractCoroutine;", "", "parentContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "active", "", "(Lkotlin/coroutines/experimental/CoroutineContext;Z)V", "getParentContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "afterCompletion", "state", "", "mode", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: Builders.kt */
class StandaloneCoroutine extends AbstractCoroutine<Unit> {
    @NotNull
    private final CoroutineContext parentContext;

    @NotNull
    protected CoroutineContext getParentContext() {
        return this.parentContext;
    }

    public StandaloneCoroutine(@NotNull CoroutineContext coroutineContext, boolean z) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
        super(z);
        this.parentContext = coroutineContext;
    }

    protected void afterCompletion(@Nullable Object obj, int i) {
        if ((obj instanceof JobSupport$CompletedExceptionally) != 0) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getParentContext(), ((JobSupport$CompletedExceptionally) obj).getException());
        }
    }
}
