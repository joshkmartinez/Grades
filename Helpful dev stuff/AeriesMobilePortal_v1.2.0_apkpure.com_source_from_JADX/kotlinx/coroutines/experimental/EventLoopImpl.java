package kotlinx.coroutines.experimental;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.experimental.Delay.DefaultImpls;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode$CondAddOp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0005*+,-.B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\rJ \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\u0014\u0010\u001f\u001a\u00020 2\n\u0010!\u001a\u00060\tR\u00020\u0000H\u0002J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0002J&\u0010%\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110'H\u0016J\u0006\u0010(\u001a\u00020\u0011J\b\u0010)\u001a\u00020\u0011H\u0002R\"\u0010\u0007\u001a\u0016\u0012\b\u0012\u00060\tR\u00020\u0000\u0012\b\u0012\u00060\tR\u00020\u00000\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lkotlinx/coroutines/experimental/EventLoopImpl;", "Lkotlinx/coroutines/experimental/CoroutineDispatcher;", "Lkotlinx/coroutines/experimental/EventLoop;", "Lkotlinx/coroutines/experimental/Delay;", "thread", "Ljava/lang/Thread;", "(Ljava/lang/Thread;)V", "delayed", "Ljava/util/concurrent/ConcurrentSkipListMap;", "Lkotlinx/coroutines/experimental/EventLoopImpl$DelayedTask;", "nextSequence", "Ljava/util/concurrent/atomic/AtomicLong;", "parentJob", "Lkotlinx/coroutines/experimental/Job;", "queue", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;", "dispatch", "", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "block", "Ljava/lang/Runnable;", "initParentJob", "coroutine", "invokeOnTimeout", "Lkotlinx/coroutines/experimental/DisposableHandle;", "time", "", "unit", "Ljava/util/concurrent/TimeUnit;", "processNextEvent", "scheduleDelayed", "", "delayedTask", "scheduleQueued", "queuedTask", "Lkotlinx/coroutines/experimental/EventLoopImpl$QueuedTask;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/experimental/CancellableContinuation;", "shutdown", "unpark", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "QueuedRunnableTask", "QueuedTask", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: EventLoop.kt */
public final class EventLoopImpl extends CoroutineDispatcher implements EventLoop, Delay {
    private final ConcurrentSkipListMap<DelayedTask, DelayedTask> delayed = new ConcurrentSkipListMap();
    private final AtomicLong nextSequence = new AtomicLong();
    private Job parentJob;
    private final LockFreeLinkedListHead queue = new LockFreeLinkedListHead();
    private final Thread thread;

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/experimental/EventLoopImpl$QueuedRunnableTask;", "Lkotlinx/coroutines/experimental/EventLoopImpl$QueuedTask;", "block", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "invoke", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: EventLoop.kt */
    private static final class QueuedRunnableTask extends QueuedTask {
        private final Runnable block;

        public QueuedRunnableTask(@NotNull Runnable runnable) {
            Intrinsics.checkParameterIsNotNull(runnable, "block");
            this.block = runnable;
        }

        public void invoke() {
            this.block.run();
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\tH\u0016J\t\u0010\f\u001a\u00020\tH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/experimental/EventLoopImpl$DelayedResumeTask;", "Lkotlinx/coroutines/experimental/EventLoopImpl$DelayedTask;", "Lkotlinx/coroutines/experimental/EventLoopImpl;", "time", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "cont", "Lkotlinx/coroutines/experimental/CancellableContinuation;", "", "(Lkotlinx/coroutines/experimental/EventLoopImpl;JLjava/util/concurrent/TimeUnit;Lkotlinx/coroutines/experimental/CancellableContinuation;)V", "cancel", "invoke", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: EventLoop.kt */
    private final class DelayedResumeTask extends DelayedTask {
        private final CancellableContinuation<Unit> cont;
        final /* synthetic */ EventLoopImpl this$0;

        public DelayedResumeTask(EventLoopImpl eventLoopImpl, @NotNull long j, @NotNull TimeUnit timeUnit, CancellableContinuation<? super Unit> cancellableContinuation) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
            Intrinsics.checkParameterIsNotNull(cancellableContinuation, "cont");
            this.this$0 = eventLoopImpl;
            super(eventLoopImpl, j, timeUnit);
            this.cont = cancellableContinuation;
        }

        public void invoke() {
            this.cont.resumeUndispatched(this.this$0, Unit.INSTANCE);
        }

        public void cancel() {
            if (this.cont.isActive()) {
                ScheduledKt.getScheduledExecutor().schedule(new ResumeRunnable(this.cont), this.nanoTime - System.nanoTime(), TimeUnit.NANOSECONDS);
            }
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/experimental/EventLoopImpl$DelayedRunnableTask;", "Lkotlinx/coroutines/experimental/EventLoopImpl$DelayedTask;", "Lkotlinx/coroutines/experimental/EventLoopImpl;", "time", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "block", "Ljava/lang/Runnable;", "(Lkotlinx/coroutines/experimental/EventLoopImpl;JLjava/util/concurrent/TimeUnit;Ljava/lang/Runnable;)V", "invoke", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: EventLoop.kt */
    private final class DelayedRunnableTask extends DelayedTask {
        private final Runnable block;
        final /* synthetic */ EventLoopImpl this$0;

        public DelayedRunnableTask(EventLoopImpl eventLoopImpl, @NotNull long j, @NotNull TimeUnit timeUnit, Runnable runnable) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
            Intrinsics.checkParameterIsNotNull(runnable, "block");
            this.this$0 = eventLoopImpl;
            super(eventLoopImpl, j, timeUnit);
            this.block = runnable;
        }

        public void invoke() {
            this.block.run();
        }
    }

    @Nullable
    public Object delay(long j, @NotNull TimeUnit timeUnit, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
        return DefaultImpls.delay(this, j, timeUnit, continuation);
    }

    public EventLoopImpl(@NotNull Thread thread) {
        Intrinsics.checkParameterIsNotNull(thread, "thread");
        this.thread = thread;
    }

    public final void initParentJob(@NotNull Job job) {
        Intrinsics.checkParameterIsNotNull(job, "coroutine");
        if ((this.parentJob == null ? 1 : null) != null) {
            this.parentJob = job;
            return;
        }
        throw ((Throwable) new IllegalArgumentException("Failed requirement.".toString()));
    }

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        if (scheduleQueued((QueuedTask) new QueuedRunnableTask(runnable)) != null) {
            unpark();
        } else {
            runnable.run();
        }
    }

    public void scheduleResumeAfterDelay(long j, @NotNull TimeUnit timeUnit, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "continuation");
        if (scheduleDelayed(new DelayedResumeTask(this, j, timeUnit, cancellableContinuation))) {
            unpark();
        } else {
            ScheduledKt.getScheduledExecutor().schedule(new ResumeRunnable(cancellableContinuation), j, timeUnit);
        }
    }

    @NotNull
    public DisposableHandle invokeOnTimeout(long j, @NotNull TimeUnit timeUnit, @NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(this, j, timeUnit, runnable);
        scheduleDelayed(delayedRunnableTask);
        return delayedRunnableTask;
    }

    public long processNextEvent() {
        if (Thread.currentThread() != this.thread) {
            return LongCompanionObject.MAX_VALUE;
        }
        while (true) {
            Entry firstEntry = this.delayed.firstEntry();
            if (firstEntry == null) {
                break;
            }
            DelayedTask delayedTask = (DelayedTask) firstEntry.getKey();
            if (delayedTask == null) {
                break;
            }
            if (delayedTask.nanoTime - System.nanoTime() > ((long) 0)) {
                break;
            } else if (!scheduleQueued(delayedTask)) {
                break;
            } else {
                this.delayed.remove(delayedTask);
            }
        }
        LockFreeLinkedListNode removeFirstOrNull = this.queue.removeFirstOrNull();
        if (!(removeFirstOrNull instanceof QueuedTask)) {
            removeFirstOrNull = null;
        }
        QueuedTask queuedTask = (QueuedTask) removeFirstOrNull;
        if (queuedTask != null) {
            queuedTask.invoke();
        }
        if (!this.queue.isEmpty()) {
            return 0;
        }
        firstEntry = this.delayed.firstEntry();
        if (firstEntry != null) {
            delayedTask = (DelayedTask) firstEntry.getKey();
            if (delayedTask != null) {
                return delayedTask.nanoTime - System.nanoTime();
            }
        }
        return LongCompanionObject.MAX_VALUE;
    }

    public final void shutdown() {
        while (true) {
            LockFreeLinkedListNode removeFirstOrNull = this.queue.removeFirstOrNull();
            if (removeFirstOrNull == null) {
                break;
            } else if (removeFirstOrNull != null) {
                ((QueuedTask) removeFirstOrNull).invoke();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.EventLoopImpl.QueuedTask");
            }
        }
        while (true) {
            Entry pollFirstEntry = this.delayed.pollFirstEntry();
            if (pollFirstEntry != null) {
                DelayedTask delayedTask = (DelayedTask) pollFirstEntry.getKey();
                if (delayedTask != null) {
                    delayedTask.cancel();
                } else {
                    return;
                }
            }
            return;
        }
    }

    private final boolean scheduleQueued(QueuedTask queuedTask) {
        boolean z = true;
        if (this.parentJob == null) {
            this.queue.addLast(queuedTask);
            return true;
        }
        LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
        LockFreeLinkedListNode lockFreeLinkedListNode2 = queuedTask;
        LockFreeLinkedListNode$CondAddOp eventLoopImpl$scheduleQueued$$inlined$addLastIf$1 = new EventLoopImpl$scheduleQueued$$inlined$addLastIf$1(lockFreeLinkedListNode2, lockFreeLinkedListNode2, this);
        while (true) {
            Object prev = lockFreeLinkedListNode.getPrev();
            if (prev != null) {
                switch (((LockFreeLinkedListNode) prev).tryCondAddNext(lockFreeLinkedListNode2, lockFreeLinkedListNode, eventLoopImpl$scheduleQueued$$inlined$addLastIf$1)) {
                    case 1:
                        break;
                    case 2:
                        z = false;
                        break;
                    default:
                }
                return z;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
        }
    }

    private final boolean scheduleDelayed(DelayedTask delayedTask) {
        this.delayed.put(delayedTask, delayedTask);
        Job job = this.parentJob;
        if ((Intrinsics.areEqual(job != null ? Boolean.valueOf(job.isActive()) : null, Boolean.valueOf(false)) ^ 1) != 0) {
            return true;
        }
        delayedTask.dispose();
        return false;
    }

    private final void unpark() {
        if (Thread.currentThread() != this.thread) {
            LockSupport.unpark(this.thread);
        }
    }
}
