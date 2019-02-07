package kotlinx.coroutines.experimental;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/experimental/JobSupport$CompletedExceptionally;", "Lkotlinx/coroutines/experimental/JobSupport$CompletedIdempotentStart;", "idempotentStart", "", "cause", "", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "_exception", "exception", "getException", "()Ljava/lang/Throwable;", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: Job.kt */
public class JobSupport$CompletedExceptionally extends JobSupport$CompletedIdempotentStart {
    private volatile Throwable _exception = this.cause;
    @Nullable
    @JvmField
    public final Throwable cause;

    public JobSupport$CompletedExceptionally(@Nullable Object obj, @Nullable Throwable th) {
        super(obj);
        this.cause = th;
    }

    @NotNull
    public final Throwable getException() {
        Throwable th = this._exception;
        if (th != null) {
            return th;
        }
        th = new CancellationException("Job was cancelled");
        this._exception = th;
        return th;
    }

    @NotNull
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("[");
        stringBuilder.append(getException());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
