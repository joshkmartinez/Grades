package kotlinx.coroutines.experimental;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlinx.coroutines.experimental.DisposableHandle.DefaultImpls;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/experimental/NonDisposableHandle;", "Lkotlinx/coroutines/experimental/DisposableHandle;", "()V", "dispose", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: Job.kt */
public final class NonDisposableHandle implements DisposableHandle {
    public static final NonDisposableHandle INSTANCE = null;

    public void dispose() {
    }

    @NotNull
    public String toString() {
        return "NonDisposableHandle";
    }

    static {
        NonDisposableHandle nonDisposableHandle = new NonDisposableHandle();
    }

    private NonDisposableHandle() {
        INSTANCE = this;
    }

    @Deprecated(message = "Replace with `dispose`", replaceWith = @ReplaceWith(expression = "dispose()", imports = {}))
    public void unregister() {
        DefaultImpls.unregister(this);
    }
}
