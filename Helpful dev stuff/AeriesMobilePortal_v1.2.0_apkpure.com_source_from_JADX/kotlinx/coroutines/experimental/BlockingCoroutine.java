package kotlinx.coroutines.experimental;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.experimental.ContinuationInterceptor;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.CoroutineContext$Key;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\r\u0010\u0016\u001a\u00028\u0000H\u0007¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/experimental/BlockingCoroutine;", "T", "Lkotlinx/coroutines/experimental/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "blockedThread", "Ljava/lang/Thread;", "privateEventLoop", "", "(Lkotlin/coroutines/experimental/CoroutineContext;Ljava/lang/Thread;Z)V", "eventLoop", "Lkotlinx/coroutines/experimental/EventLoop;", "getEventLoop", "()Lkotlinx/coroutines/experimental/EventLoop;", "getParentContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "afterCompletion", "", "state", "", "mode", "", "joinBlocking", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: Builders.kt */
final class BlockingCoroutine<T> extends AbstractCoroutine<T> {
    private final Thread blockedThread;
    @Nullable
    private final EventLoop eventLoop;
    @NotNull
    private final CoroutineContext parentContext;
    private final boolean privateEventLoop;

    @NotNull
    protected CoroutineContext getParentContext() {
        return this.parentContext;
    }

    public BlockingCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull Thread thread, boolean z) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
        Intrinsics.checkParameterIsNotNull(thread, "blockedThread");
        super(true);
        this.parentContext = coroutineContext;
        this.blockedThread = thread;
        this.privateEventLoop = z;
        coroutineContext = getParentContext().get((CoroutineContext$Key) ContinuationInterceptor.Key);
        if ((coroutineContext instanceof EventLoop) == null) {
            coroutineContext = null;
        }
        this.eventLoop = (EventLoop) coroutineContext;
        if (this.privateEventLoop == null) {
            return;
        }
        if ((this.eventLoop instanceof EventLoopImpl) == null) {
            throw ((Throwable) new IllegalArgumentException("Failed requirement.".toString()));
        }
    }

    @Nullable
    public final EventLoop getEventLoop() {
        return this.eventLoop;
    }

    protected void afterCompletion(@Nullable Object obj, int i) {
        if ((Intrinsics.areEqual(Thread.currentThread(), this.blockedThread) ^ 1) != null) {
            LockSupport.unpark(this.blockedThread);
        }
    }

    public final T joinBlocking() {
        while (!Thread.interrupted()) {
            EventLoop eventLoop = this.eventLoop;
            long processNextEvent = eventLoop != null ? eventLoop.processNextEvent() : LongCompanionObject.MAX_VALUE;
            if (isActive()) {
                LockSupport.parkNanos(this, processNextEvent);
            } else {
                if (this.privateEventLoop) {
                    eventLoop = this.eventLoop;
                    if (eventLoop != null) {
                        ((EventLoopImpl) eventLoop).shutdown();
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.EventLoopImpl");
                    }
                }
                T state = getState();
                JobSupport$CompletedExceptionally jobSupport$CompletedExceptionally = (JobSupport$CompletedExceptionally) (!(state instanceof JobSupport$CompletedExceptionally) ? null : state);
                if (jobSupport$CompletedExceptionally == null) {
                    return state;
                }
                throw jobSupport$CompletedExceptionally.getException();
            }
        }
        Throwable interruptedException = new InterruptedException();
        cancel(interruptedException);
        throw interruptedException;
    }
}
