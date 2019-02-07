package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/experimental/EventLoop;", "", "processNextEvent", "", "Factory", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: EventLoop.kt */
public interface EventLoop {
    public static final Factory Factory = new Factory();

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/experimental/EventLoop$Factory;", "", "()V", "invoke", "Lkotlinx/coroutines/experimental/CoroutineDispatcher;", "thread", "Ljava/lang/Thread;", "parentJob", "Lkotlinx/coroutines/experimental/Job;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: EventLoop.kt */
    public static final class Factory {
        private Factory() {
        }

        @NotNull
        public static /* bridge */ /* synthetic */ CoroutineDispatcher invoke$default(Factory factory, Thread thread, Job job, int i, Object obj) {
            if ((i & 1) != null) {
                thread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(thread, "Thread.currentThread()");
            }
            if ((i & 2) != 0) {
                job = null;
            }
            return factory.invoke(thread, job);
        }

        @NotNull
        public final CoroutineDispatcher invoke(@NotNull Thread thread, @Nullable Job job) {
            Intrinsics.checkParameterIsNotNull(thread, "thread");
            EventLoopImpl eventLoopImpl = new EventLoopImpl(thread);
            if (job != null) {
                eventLoopImpl.initParentJob(job);
            }
            return eventLoopImpl;
        }
    }

    long processNextEvent();
}
