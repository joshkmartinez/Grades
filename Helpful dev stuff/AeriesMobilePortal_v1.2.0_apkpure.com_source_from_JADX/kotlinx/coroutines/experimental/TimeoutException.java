package kotlinx.coroutines.experimental;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/experimental/TimeoutException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/experimental/CancellationException;", "time", "", "unit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: Scheduled.kt */
final class TimeoutException extends CancellationException {
    public TimeoutException(long j, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Timed out waiting for ");
        stringBuilder.append(j);
        stringBuilder.append(" ");
        stringBuilder.append(timeUnit);
        super(stringBuilder.toString());
    }
}
