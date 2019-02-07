package kotlinx.coroutines.experimental;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.AbstractCoroutineContextElement;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.experimental.Job.DefaultImpls;
import kotlinx.coroutines.experimental.JobSupport$invokeOnCompletion$.inlined.addLastIf.1;
import kotlinx.coroutines.experimental.internal.AtomicDesc;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode.CondAddOp;
import kotlinx.coroutines.experimental.internal.OpDescriptor;
import kotlinx.coroutines.experimental.intrinsics.UndispatchedKt;
import kotlinx.coroutines.experimental.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\b\u0016\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0007CDEFGHIB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\"\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0004J\u0006\u0010\u001b\u001a\u00020\u0017J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0017H\u0014J\u0010\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002J \u0010 \u001a\u00020\r2\u0018\u0010!\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00120\"j\u0002`#J\u0011\u0010$\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0011\u0010&\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010%J&\u0010'\u001a\u0006\u0012\u0002\b\u00030(2\u0018\u0010!\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00120\"j\u0002`#H\u0002J\u0017\u0010)\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0010¢\u0006\u0002\b*J\b\u0010+\u001a\u00020\u0012H\u0014J\u0010\u0010,\u001a\u0004\u0018\u00010\u00072\u0006\u0010-\u001a\u00020.J\u0010\u0010/\u001a\u0004\u0018\u00010\u00072\u0006\u0010-\u001a\u00020.JB\u00100\u001a\u00020\u0012\"\u0004\b\u0000\u001012\f\u00102\u001a\b\u0012\u0004\u0012\u0002H1032\u001c\u00104\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H105\u0012\u0006\u0012\u0004\u0018\u00010\u00070\"H\u0016ø\u0001\u0000¢\u0006\u0002\u00106J\u0019\u00107\u001a\u00020\u00122\n\u00108\u001a\u0006\u0012\u0002\b\u00030(H\u0000¢\u0006\u0002\b9J\u0006\u0010:\u001a\u00020\u0004J\u0017\u0010;\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b<J\b\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020\u00042\b\u0010@\u001a\u0004\u0018\u00010\u0007J\u001a\u0010A\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0004J\"\u0010B\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0004R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078DX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\t¨\u0006J"}, d2 = {"Lkotlinx/coroutines/experimental/JobSupport;", "Lkotlin/coroutines/experimental/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/experimental/Job;", "active", "", "(Z)V", "_state", "", "isActive", "()Z", "isCompleted", "isSelected", "parentHandle", "Lkotlinx/coroutines/experimental/DisposableHandle;", "state", "getState", "()Ljava/lang/Object;", "afterCompletion", "", "mode", "", "cancel", "cause", "", "completeUpdateState", "expect", "update", "getCompletionException", "handleCompletionException", "closeException", "initParentJob", "parent", "invokeOnCompletion", "handler", "Lkotlin/Function1;", "Lkotlinx/coroutines/experimental/CompletionHandler;", "join", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "joinSuspend", "makeNode", "Lkotlinx/coroutines/experimental/JobNode;", "onParentCompletion", "onParentCompletion$kotlinx_coroutines_core", "onStart", "performAtomicIfNotSelected", "desc", "Lkotlinx/coroutines/experimental/internal/AtomicDesc;", "performAtomicTrySelect", "registerSelectJoin", "R", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "block", "Lkotlin/coroutines/experimental/Continuation;", "(Lkotlinx/coroutines/experimental/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "removeNode", "node", "removeNode$kotlinx_coroutines_core", "start", "startInternal", "startInternal$kotlinx_coroutines_core", "toString", "", "trySelect", "idempotent", "tryUpdateState", "updateState", "AtomicSelectOp", "Cancelled", "Companion", "CompletedExceptionally", "CompletedIdempotentStart", "Incomplete", "NodeList", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: Job.kt */
public class JobSupport extends AbstractCoroutineContextElement implements Job {
    public static final Companion Companion = new Companion(null);
    private static final AtomicReferenceFieldUpdater<JobSupport, Object> STATE;
    private volatile Object _state;
    private volatile DisposableHandle parentHandle;

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/experimental/JobSupport$Incomplete;", "", "idempotentStart", "getIdempotentStart", "()Ljava/lang/Object;", "isActive", "", "()Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: Job.kt */
    public interface Incomplete {
        @Nullable
        Object getIdempotentStart();

        boolean isActive();
    }

    protected void afterCompletion(@Nullable Object obj, int i) {
    }

    protected void onStart() {
    }

    public JobSupport(boolean z) {
        super(Job.Key);
        this._state = z ? JobKt.EmptyActive : JobKt.EmptyNew;
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public Job plus(@NotNull Job job) {
        Intrinsics.checkParameterIsNotNull(job, "other");
        return DefaultImpls.plus(this, job);
    }

    static {
        AtomicReferenceFieldUpdater newUpdater = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
        Intrinsics.checkExpressionValueIsNotNull(newUpdater, "AtomicReferenceFieldUpda…ny::class.java, \"_state\")");
        STATE = newUpdater;
    }

    public final void initParentJob(@Nullable Job job) {
        if ((this.parentHandle == null ? 1 : null) == null) {
            throw ((Throwable) new IllegalStateException("Check failed.".toString()));
        } else if (job == null) {
            this.parentHandle = (DisposableHandle) NonDisposableHandle.INSTANCE;
        } else {
            job = job.invokeOnCompletion(new ParentOnCompletion(job, this));
            this.parentHandle = job;
            if (isCompleted()) {
                job.dispose();
            }
        }
    }

    public void onParentCompletion$kotlinx_coroutines_core(@Nullable Throwable th) {
        if (!(th instanceof CancellationException)) {
            th = null;
        }
        cancel((CancellationException) th);
    }

    @Nullable
    protected final Object getState() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    protected final boolean updateState(@NotNull Object obj, @Nullable Object obj2, int i) {
        Intrinsics.checkParameterIsNotNull(obj, "expect");
        if (!tryUpdateState(obj, obj2)) {
            return null;
        }
        completeUpdateState(obj, obj2, i);
        return true;
    }

    protected final boolean tryUpdateState(@NotNull Object obj, @Nullable Object obj2) {
        Intrinsics.checkParameterIsNotNull(obj, "expect");
        boolean z = (obj instanceof Incomplete) && !(obj2 instanceof Incomplete);
        if (!z) {
            throw ((Throwable) new IllegalArgumentException("Failed requirement.".toString()));
        } else if (Companion.access$getSTATE$p(Companion).compareAndSet(this, obj, obj2) == null) {
            return false;
        } else {
            obj = this.parentHandle;
            if (obj != null) {
                obj.dispose();
            }
            return true;
        }
    }

    protected final void completeUpdateState(@NotNull Object obj, @Nullable Object obj2, int i) {
        Intrinsics.checkParameterIsNotNull(obj, "expect");
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) (!(obj2 instanceof CompletedExceptionally) ? null : obj2);
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        ObjectRef objectRef = new ObjectRef();
        objectRef.element = (Throwable) null;
        if (obj instanceof JobNode) {
            try {
                ((JobNode) obj).invoke(th);
            } catch (Object obj3) {
                objectRef.element = obj3;
            }
        } else if (obj3 instanceof NodeList) {
            NodeList nodeList = (NodeList) obj3;
            Object next = nodeList.getNext();
            if (next != null) {
                for (next = (LockFreeLinkedListNode) next; (Intrinsics.areEqual(next, (Object) nodeList) ^ 1) != 0; next = LockFreeLinkedListKt.unwrap(next.getNext())) {
                    if (next instanceof JobNode) {
                        try {
                            ((JobNode) next).invoke(th);
                        } catch (Throwable th2) {
                            Throwable th3 = (Throwable) objectRef.element;
                            if (th3 != null) {
                                ExceptionsKt.addSuppressed(th3, th2);
                                if (th3 != null) {
                                }
                            }
                            JobSupport jobSupport = this;
                            objectRef.element = th2;
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        } else if ((obj3 instanceof Empty) == null) {
            throw ((Throwable) new IllegalStateException("Check failed.".toString()));
        }
        Throwable th4 = (Throwable) objectRef.element;
        if (th4 != null) {
            handleCompletionException(th4);
        }
        afterCompletion(obj2, i);
    }

    public final boolean isActive() {
        Object state = getState();
        return (state instanceof Incomplete) && ((Incomplete) state).isActive();
    }

    public final boolean isCompleted() {
        return !(getState() instanceof Incomplete);
    }

    public final boolean isSelected() {
        Object state = getState();
        if (state instanceof Incomplete) {
            if (!((Incomplete) state).isActive()) {
                return false;
            }
        }
        return true;
    }

    public final boolean start() {
        while (true) {
            switch (startInternal$kotlinx_coroutines_core(getState())) {
                case 0:
                    return false;
                case 1:
                    return true;
                default:
            }
        }
    }

    public final int startInternal$kotlinx_coroutines_core(@Nullable Object obj) {
        if (obj == JobKt.EmptyNew) {
            if (Companion.access$getSTATE$p(Companion).compareAndSet(this, obj, JobKt.EmptyActive) == null) {
                return -1;
            }
            onStart();
            return 1;
        } else if (!(obj instanceof NodeList) || ((NodeList) obj).isActive()) {
            return 0;
        } else {
            if (NodeList.ACTIVE.compareAndSet(obj, null, NodeList.ACTIVE_STATE) == null) {
                return -1;
            }
            onStart();
            return 1;
        }
    }

    public final boolean trySelect(@Nullable Object obj) {
        if (obj == null) {
            return start();
        }
        boolean z = true;
        if (!(obj instanceof OpDescriptor)) {
            Empty state;
            while (true) {
                state = getState();
                if (state != JobKt.EmptyNew) {
                    if (!(state instanceof NodeList)) {
                        break;
                    }
                    Object active = ((NodeList) state).getActive();
                    if (active == obj) {
                        return true;
                    }
                    if (active != null) {
                        return false;
                    }
                    if (NodeList.ACTIVE.compareAndSet(state, null, obj)) {
                        onStart();
                        return true;
                    }
                } else {
                    Companion.access$getSTATE$p(Companion).compareAndSet(this, state, new NodeList(false));
                }
            }
            if (!(state instanceof CompletedIdempotentStart)) {
                return false;
            }
            if (((CompletedIdempotentStart) state).idempotentStart != obj) {
                z = false;
            }
            return z;
        }
        throw ((Throwable) new IllegalStateException("cannot use OpDescriptor as idempotent marker".toString()));
    }

    @Nullable
    public final Object performAtomicTrySelect(@NotNull AtomicDesc atomicDesc) {
        Intrinsics.checkParameterIsNotNull(atomicDesc, "desc");
        return new AtomicSelectOp(this, atomicDesc, true).perform(null);
    }

    @Nullable
    public final Object performAtomicIfNotSelected(@NotNull AtomicDesc atomicDesc) {
        Intrinsics.checkParameterIsNotNull(atomicDesc, "desc");
        return new AtomicSelectOp(this, atomicDesc, false).perform(null);
    }

    @NotNull
    public final Throwable getCompletionException() {
        Object state = getState();
        if (state instanceof Incomplete) {
            throw new IllegalStateException("Job has not completed yet");
        } else if (state instanceof CompletedExceptionally) {
            return ((CompletedExceptionally) state).getException();
        } else {
            return new CancellationException("Job has completed normally");
        }
    }

    @NotNull
    public final DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        ObjectRef objectRef = new ObjectRef();
        Object obj = null;
        objectRef.element = (JobNode) null;
        while (true) {
            Object state = getState();
            if (state == JobKt.EmptyActive) {
                Object obj2 = (JobNode) objectRef.element;
                if (obj2 == null) {
                    obj2 = makeNode(function1);
                    objectRef.element = obj2;
                }
                if (Companion.access$getSTATE$p(Companion).compareAndSet(this, state, obj2)) {
                    return (DisposableHandle) obj2;
                }
            } else {
                boolean z = false;
                if (state == JobKt.EmptyNew) {
                    Companion.access$getSTATE$p(Companion).compareAndSet(this, state, new NodeList(false));
                } else if (state instanceof JobNode) {
                    r3 = (JobNode) state;
                    r3.addOneIfEmpty(new NodeList(true));
                    Companion.access$getSTATE$p(Companion).compareAndSet(this, state, r3.getNext());
                } else if (state instanceof NodeList) {
                    r3 = (JobNode) objectRef.element;
                    if (r3 == null) {
                        r3 = makeNode(function1);
                        objectRef.element = r3;
                    }
                    NodeList nodeList = (NodeList) state;
                    LockFreeLinkedListNode lockFreeLinkedListNode = r3;
                    CondAddOp 1 = new 1(lockFreeLinkedListNode, lockFreeLinkedListNode, this, state);
                    while (true) {
                        state = nodeList.getPrev();
                        if (state != null) {
                            switch (((LockFreeLinkedListNode) state).tryCondAddNext(lockFreeLinkedListNode, nodeList, 1)) {
                                case 1:
                                    z = true;
                                    break;
                                case 2:
                                    break;
                                default:
                            }
                            if (z) {
                                return r3;
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
                        }
                    }
                } else {
                    if (!(state instanceof CompletedExceptionally)) {
                        state = null;
                    }
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) state;
                    if (completedExceptionally != null) {
                        obj = completedExceptionally.getException();
                    }
                    function1.invoke(obj);
                    return (DisposableHandle) NonDisposableHandle.INSTANCE;
                }
            }
        }
    }

    @Nullable
    public final Object join(@NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
        Incomplete incomplete;
        do {
            Object state = getState();
            if (!(state instanceof Incomplete)) {
                state = null;
            }
            incomplete = (Incomplete) state;
            if (incomplete == null) {
                return Unit.INSTANCE;
            }
        } while (startInternal$kotlinx_coroutines_core(incomplete) < 0);
        return joinSuspend(continuation);
    }

    public <R> void registerSelectJoin(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        while (!selectInstance.isSelected()) {
            Object state = getState();
            if (!(state instanceof Incomplete)) {
                if (selectInstance.trySelect(null)) {
                    UndispatchedKt.startCoroutineUndispatched(function1, selectInstance.getCompletion());
                }
                return;
            } else if (startInternal$kotlinx_coroutines_core(state) == 0) {
                selectInstance.disposeOnSelect(invokeOnCompletion(new SelectJoinOnCompletion(this, selectInstance, function1)));
                return;
            }
        }
    }

    public final void removeNode$kotlinx_coroutines_core(@NotNull JobNode<?> jobNode) {
        Intrinsics.checkParameterIsNotNull(jobNode, "node");
        JobSupport state;
        do {
            state = getState();
            if (state instanceof JobNode) {
                if (state != this) {
                    return;
                }
            } else if (state instanceof NodeList) {
                jobNode.remove();
                return;
            } else {
                return;
            }
        } while (!Companion.access$getSTATE$p(Companion).compareAndSet(this, state, JobKt.EmptyActive));
    }

    public final boolean cancel(@Nullable Throwable th) {
        Incomplete incomplete;
        do {
            Object state = getState();
            if (!(state instanceof Incomplete)) {
                state = null;
            }
            incomplete = (Incomplete) state;
            if (incomplete == null) {
                return false;
            }
        } while (!updateState(incomplete, new Cancelled(incomplete.getIdempotentStart(), th), 0));
        return true;
    }

    protected void handleCompletionException(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "closeException");
        throw th;
    }

    private final JobNode<?> makeNode(Function1<? super Throwable, Unit> function1) {
        JobNode<?> jobNode = (JobNode) (!(function1 instanceof JobNode) ? null : function1);
        if (jobNode != null) {
            if ((jobNode.job == ((JobSupport) this) ? 1 : null) == null) {
                throw ((Throwable) new IllegalArgumentException("Failed requirement.".toString()));
            } else if (jobNode != null) {
                return jobNode;
            }
        }
        return new InvokeOnCompletion(this, function1);
    }

    @NotNull
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("{");
        stringBuilder.append(Companion.stateToString(getState()));
        stringBuilder.append("}@");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        return stringBuilder.toString();
    }

    private final Object joinSuspend(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), true);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        JobKt.disposeOnCompletion(cancellableContinuation, invokeOnCompletion(new ResumeOnCompletion(this, cancellableContinuation)));
        return cancellableContinuationImpl.getResult();
    }
}
