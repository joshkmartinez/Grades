package kotlinx.coroutines.experimental;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.JobSupport.Incomplete;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@PublishedApi
@Metadata(bv = {1, 0, 1}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u0000 %*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0002%&B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0014J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0001J\b\u0010\u0019\u001a\u00020\u0012H\u0016J!\u0010\u001a\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00028\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0019\u0010!\u001a\u00020\u0012*\u00020\"2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\u00020\u0012*\u00020\"2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0012\u0010\t\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8TX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006'"}, d2 = {"Lkotlinx/coroutines/experimental/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/experimental/AbstractCoroutine;", "Lkotlinx/coroutines/experimental/CancellableContinuation;", "delegate", "Lkotlin/coroutines/experimental/Continuation;", "active", "", "(Lkotlin/coroutines/experimental/Continuation;Z)V", "decision", "", "isCancelled", "()Z", "parentContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "getParentContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "afterCompletion", "", "state", "", "mode", "completeResume", "token", "getResult", "initCancellability", "tryResume", "value", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryResumeWithException", "exception", "", "resumeUndispatched", "Lkotlinx/coroutines/experimental/CoroutineDispatcher;", "(Lkotlinx/coroutines/experimental/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "Companion", "CompletedIdempotentResult", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: CancellableContinuation.kt */
public class CancellableContinuationImpl<T> extends AbstractCoroutine<T> implements CancellableContinuation<T> {
    public static final Companion Companion = new Companion();
    @NotNull
    @JvmField
    public static final AtomicIntegerFieldUpdater<CancellableContinuationImpl<?>> DECISION;
    public static final int RESUMED = 2;
    public static final int SUSPENDED = 1;
    public static final int UNDECIDED = 0;
    private volatile int decision;
    @NotNull
    @JvmField
    protected final Continuation<T> delegate;

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0001\u0010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\rR\u001a\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/experimental/CancellableContinuationImpl$Companion;", "", "()V", "DECISION", "Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;", "Lkotlinx/coroutines/experimental/CancellableContinuationImpl;", "RESUMED", "", "SUSPENDED", "UNDECIDED", "getSuccessfulResult", "T", "state", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: CancellableContinuation.kt */
    protected static final class Companion {
        private Companion() {
        }

        public final <T> T getSuccessfulResult(@Nullable Object obj) {
            return obj instanceof CompletedIdempotentResult ? ((CompletedIdempotentResult) obj).result : obj;
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/experimental/CancellableContinuationImpl$CompletedIdempotentResult;", "Lkotlinx/coroutines/experimental/JobSupport$CompletedIdempotentStart;", "idempotentStart", "", "idempotentResume", "result", "token", "Lkotlinx/coroutines/experimental/JobSupport$Incomplete;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/experimental/JobSupport$Incomplete;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: CancellableContinuation.kt */
    private static final class CompletedIdempotentResult extends JobSupport$CompletedIdempotentStart {
        @Nullable
        @JvmField
        public final Object idempotentResume;
        @Nullable
        @JvmField
        public final Object result;
        @NotNull
        @JvmField
        public final Incomplete token;

        public CompletedIdempotentResult(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @NotNull Incomplete incomplete) {
            Intrinsics.checkParameterIsNotNull(incomplete, "token");
            super(obj);
            this.idempotentResume = obj2;
            this.result = obj3;
            this.token = incomplete;
        }

        @NotNull
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CompletedIdempotentResult[");
            stringBuilder.append(this.result);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public CancellableContinuationImpl(@NotNull Continuation<? super T> continuation, boolean z) {
        Intrinsics.checkParameterIsNotNull(continuation, "delegate");
        super(z);
        this.delegate = continuation;
    }

    @NotNull
    protected CoroutineContext getParentContext() {
        return this.delegate.getContext();
    }

    static {
        AtomicIntegerFieldUpdater newUpdater = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "decision");
        Intrinsics.checkExpressionValueIsNotNull(newUpdater, "AtomicIntegerFieldUpdate…::class.java, \"decision\")");
        DECISION = newUpdater;
    }

    public void initCancellability() {
        initParentJob((Job) getParentContext().get(Job.Key));
    }

    @Nullable
    @PublishedApi
    public final Object getResult() {
        if (this.decision == 0 && DECISION.compareAndSet(this, 0, 1)) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object state = getState();
        if (!(state instanceof JobSupport$CompletedExceptionally)) {
            return Companion.getSuccessfulResult(state);
        }
        throw ((JobSupport$CompletedExceptionally) state).getException();
    }

    public boolean isCancelled() {
        return getState() instanceof JobSupport$Cancelled;
    }

    @Nullable
    public Object tryResume(T t, @Nullable Object obj) {
        Object state;
        Object obj2;
        do {
            state = getState();
            if (state instanceof Incomplete) {
                Incomplete incomplete = (Incomplete) state;
                Object idempotentStart = incomplete.getIdempotentStart();
                if (obj == null && idempotentStart == null) {
                    obj2 = t;
                } else {
                    obj2 = new CompletedIdempotentResult(idempotentStart, obj, t, incomplete);
                }
            } else if (!(state instanceof CompletedIdempotentResult)) {
                return null;
            } else {
                CompletedIdempotentResult completedIdempotentResult = (CompletedIdempotentResult) state;
                if (completedIdempotentResult.idempotentResume != obj) {
                    return null;
                }
                if ((completedIdempotentResult.result == t ? true : null) != null) {
                    return completedIdempotentResult.token;
                }
                throw ((Throwable) new IllegalStateException("Non-idempotent resume".toString()));
            }
        } while (!tryUpdateState(state, obj2));
        return state;
    }

    @Nullable
    public Object tryResumeWithException(@NotNull Throwable th) {
        Object state;
        Intrinsics.checkParameterIsNotNull(th, "exception");
        do {
            state = getState();
            if (!(state instanceof Incomplete)) {
                return null;
            }
        } while (!tryUpdateState(state, new JobSupport$CompletedExceptionally(((Incomplete) state).getIdempotentStart(), th)));
        return state;
    }

    public void completeResume(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "token");
        completeUpdateState(obj, getState(), getDefaultResumeMode());
    }

    protected void afterCompletion(@Nullable Object obj, int i) {
        String updateContext;
        if (this.decision != 0 || !DECISION.compareAndSet(this, 0, 2)) {
            DispatchedContinuation dispatchedContinuation;
            if (obj instanceof JobSupport$CompletedExceptionally) {
                obj = ((JobSupport$CompletedExceptionally) obj).getException();
                switch (i) {
                    case 0:
                        this.delegate.resumeWithException(obj);
                        break;
                    case 1:
                        i = this.delegate;
                        if (i != 0) {
                            dispatchedContinuation = (DispatchedContinuation) i;
                            updateContext = CoroutineContextKt.updateContext(dispatchedContinuation.getContext());
                            try {
                                dispatchedContinuation.continuation.resumeWithException(obj);
                                obj = Unit.INSTANCE;
                                break;
                            } finally {
                                CoroutineContextKt.restoreContext(updateContext);
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.DispatchedContinuation<T>");
                        }
                    case 2:
                        CoroutineDispatcherKt.resumeDirectWithException(this.delegate, obj);
                        break;
                    default:
                        obj = new StringBuilder();
                        obj.append("Invalid mode ");
                        obj.append(i);
                        throw ((Throwable) new IllegalStateException(obj.toString().toString()));
                }
            }
            obj = Companion.getSuccessfulResult(obj);
            switch (i) {
                case 0:
                    this.delegate.resume(obj);
                    break;
                case 1:
                    i = this.delegate;
                    if (i != 0) {
                        dispatchedContinuation = (DispatchedContinuation) i;
                        updateContext = CoroutineContextKt.updateContext(dispatchedContinuation.getContext());
                        try {
                            dispatchedContinuation.continuation.resume(obj);
                            obj = Unit.INSTANCE;
                            break;
                        } finally {
                            CoroutineContextKt.restoreContext(updateContext);
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.DispatchedContinuation<T>");
                    }
                case 2:
                    CoroutineDispatcherKt.resumeDirect(this.delegate, obj);
                    break;
                default:
                    obj = new StringBuilder();
                    obj.append("Invalid mode ");
                    obj.append(i);
                    throw ((Throwable) new IllegalStateException(obj.toString().toString()));
            }
        }
    }

    public void resumeUndispatched(@NotNull CoroutineDispatcher coroutineDispatcher, T t) {
        Intrinsics.checkParameterIsNotNull(coroutineDispatcher, "$receiver");
        Continuation continuation = this.delegate;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        if (dispatchedContinuation != null) {
            if ((dispatchedContinuation.dispatcher == coroutineDispatcher ? 1 : null) != null) {
                resume(t, 1);
                return;
            }
            throw ((Throwable) new IllegalStateException("Must be invoked from the context CoroutineDispatcher".toString()));
        }
        throw ((Throwable) new IllegalArgumentException("Must be used with DispatchedContinuation"));
    }

    public void resumeUndispatchedWithException(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(coroutineDispatcher, "$receiver");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        Continuation continuation = this.delegate;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        if (dispatchedContinuation != null) {
            if ((dispatchedContinuation.dispatcher == coroutineDispatcher ? 1 : null) != null) {
                resumeWithException(th, 1);
                return;
            }
            throw ((Throwable) new IllegalStateException("Must be invoked from the context CoroutineDispatcher".toString()));
        }
        throw ((Throwable) new IllegalArgumentException("Must be used with DispatchedContinuation"));
    }
}
