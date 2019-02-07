package kotlinx.coroutines.experimental;

import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.DisposableHandle.DefaultImpls;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b¢\u0004\u0018\u00002\u00020\u00012\f\u0012\b\u0012\u00060\u0000R\u00020\u00030\u00022\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\u0015\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0000R\u00020\u0003H\u0002J\u0006\u0010\u0011\u001a\u00020\rR\u0010\u0010\n\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/experimental/EventLoopImpl$DelayedTask;", "Lkotlinx/coroutines/experimental/EventLoopImpl$QueuedTask;", "", "Lkotlinx/coroutines/experimental/EventLoopImpl;", "Lkotlinx/coroutines/experimental/DisposableHandle;", "time", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(Lkotlinx/coroutines/experimental/EventLoopImpl;JLjava/util/concurrent/TimeUnit;)V", "nanoTime", "sequence", "cancel", "", "compareTo", "", "other", "dispose", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: EventLoop.kt */
abstract class EventLoopImpl$DelayedTask extends EventLoopImpl$QueuedTask implements Comparable<EventLoopImpl$DelayedTask>, DisposableHandle {
    @JvmField
    public final long nanoTime;
    @JvmField
    public final long sequence;
    final /* synthetic */ EventLoopImpl this$0;

    public void cancel() {
    }

    public EventLoopImpl$DelayedTask(EventLoopImpl eventLoopImpl, @NotNull long j, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
        this.this$0 = eventLoopImpl;
        this.nanoTime = System.nanoTime() + timeUnit.toNanos(j);
        this.sequence = EventLoopImpl.access$getNextSequence$p(eventLoopImpl).getAndIncrement();
    }

    @Deprecated(message = "Replace with `dispose`", replaceWith = @ReplaceWith(expression = "dispose()", imports = {}))
    public void unregister() {
        DefaultImpls.unregister(this);
    }

    public int compareTo(@NotNull EventLoopImpl$DelayedTask eventLoopImpl$DelayedTask) {
        Intrinsics.checkParameterIsNotNull(eventLoopImpl$DelayedTask, "other");
        long j = this.nanoTime - eventLoopImpl$DelayedTask.nanoTime;
        int i = 0;
        long j2 = (long) null;
        if (j > j2) {
            return 1;
        }
        if (j < j2) {
            return -1;
        }
        long j3 = this.sequence - eventLoopImpl$DelayedTask.sequence;
        if (j3 > j2) {
            i = 1;
        } else if (j3 < j2) {
            i = -1;
        }
        return i;
    }

    public final void dispose() {
        EventLoopImpl.access$getDelayed$p(this.this$0).remove(this);
        cancel();
    }
}
