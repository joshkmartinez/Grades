package kotlinx.coroutines.experimental.selects;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.ContinuationInterceptor;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CancellableContinuationImpl;
import kotlinx.coroutines.experimental.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.experimental.Deferred;
import kotlinx.coroutines.experimental.Delay;
import kotlinx.coroutines.experimental.DisposableHandle;
import kotlinx.coroutines.experimental.DisposeOnCompletion;
import kotlinx.coroutines.experimental.Job;
import kotlinx.coroutines.experimental.JobKt;
import kotlinx.coroutines.experimental.ScheduledKt;
import kotlinx.coroutines.experimental.channels.ReceiveChannel;
import kotlinx.coroutines.experimental.channels.SendChannel;
import kotlinx.coroutines.experimental.intrinsics.UndispatchedKt;
import kotlinx.coroutines.experimental.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@PublishedApi
@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0001J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0001J\u0017\u0010\u001a\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0010¢\u0006\u0002\b\u001cJ>\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u001c\u0010\"\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00190#H\u0016ø\u0001\u0000¢\u0006\u0002\u0010$J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\fH\u0016JD\u0010(\u001a\u00020\u0012\"\u0004\b\u0001\u0010)*\b\u0012\u0004\u0012\u0002H)0*2\"\u0010\"\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H)\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00190+H\u0016ø\u0001\u0000¢\u0006\u0002\u0010,J2\u0010-\u001a\u00020\u0012*\u00020.2\u001c\u0010\"\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00190#H\u0016ø\u0001\u0000¢\u0006\u0002\u0010/J<\u00100\u001a\u00020\u0012*\u0002012\b\u00102\u001a\u0004\u0018\u00010\u00192\u001c\u0010\"\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00190#H\u0016ø\u0001\u0000¢\u0006\u0002\u00103JD\u00104\u001a\u00020\u0012\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H5062\"\u0010\"\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H5\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00190+H\u0016ø\u0001\u0000¢\u0006\u0002\u00107JF\u00108\u001a\u00020\u0012\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H5062$\u0010\"\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u0001H5\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00190+H\u0016ø\u0001\u0000¢\u0006\u0002\u00107JF\u00109\u001a\u00020\u0012\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H50:2\u0006\u0010;\u001a\u0002H52\u001c\u0010\"\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00190#H\u0016ø\u0001\u0000¢\u0006\u0002\u0010<R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8TX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\t¨\u0006="}, d2 = {"Lkotlinx/coroutines/experimental/selects/SelectBuilderImpl;", "R", "Lkotlinx/coroutines/experimental/CancellableContinuationImpl;", "Lkotlinx/coroutines/experimental/selects/SelectBuilder;", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "delegate", "Lkotlin/coroutines/experimental/Continuation;", "(Lkotlin/coroutines/experimental/Continuation;)V", "completion", "getCompletion", "()Lkotlin/coroutines/experimental/Continuation;", "defaultResumeMode", "", "getDefaultResumeMode", "()I", "createContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "disposeOnSelect", "", "handle", "Lkotlinx/coroutines/experimental/DisposableHandle;", "handleBuilderException", "e", "", "initSelectResult", "", "onParentCompletion", "cause", "onParentCompletion$kotlinx_coroutines_core", "onTimeout", "time", "", "unit", "Ljava/util/concurrent/TimeUnit;", "block", "Lkotlin/Function1;", "(JLjava/util/concurrent/TimeUnit;Lkotlin/jvm/functions/Function1;)V", "resumeSelectWithException", "exception", "mode", "onAwait", "T", "Lkotlinx/coroutines/experimental/Deferred;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/experimental/Deferred;Lkotlin/jvm/functions/Function2;)V", "onJoin", "Lkotlinx/coroutines/experimental/Job;", "(Lkotlinx/coroutines/experimental/Job;Lkotlin/jvm/functions/Function1;)V", "onLock", "Lkotlinx/coroutines/experimental/sync/Mutex;", "owner", "(Lkotlinx/coroutines/experimental/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "onReceive", "E", "Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "(Lkotlinx/coroutines/experimental/channels/ReceiveChannel;Lkotlin/jvm/functions/Function2;)V", "onReceiveOrNull", "onSend", "Lkotlinx/coroutines/experimental/channels/SendChannel;", "element", "(Lkotlinx/coroutines/experimental/channels/SendChannel;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: Select.kt */
public final class SelectBuilderImpl<R> extends CancellableContinuationImpl<R> implements SelectBuilder<R>, SelectInstance<R> {
    protected int getDefaultResumeMode() {
        return 2;
    }

    public SelectBuilderImpl(@NotNull Continuation<? super R> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "delegate");
        super(continuation, false);
    }

    @PublishedApi
    public final void handleBuilderException(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        if (trySelect(null)) {
            Object tryResumeWithException = tryResumeWithException(th);
            if (tryResumeWithException != null) {
                completeResume(tryResumeWithException);
            } else {
                CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
            }
        }
    }

    @Nullable
    @PublishedApi
    public final Object initSelectResult() {
        if (!isSelected()) {
            initCancellability();
        }
        return getResult();
    }

    @NotNull
    protected CoroutineContext createContext() {
        return this.delegate.getContext();
    }

    public void onParentCompletion$kotlinx_coroutines_core(@Nullable Throwable th) {
        if (trySelect(null)) {
            cancel(th);
        }
    }

    @NotNull
    public Continuation<R> getCompletion() {
        if (isSelected()) {
            return this;
        }
        throw new IllegalStateException("Must be selected first".toString());
    }

    public void resumeSelectWithException(@NotNull Throwable th, int i) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        if (isSelected()) {
            resumeWithException(th, i);
            return;
        }
        throw new IllegalStateException("Must be selected first".toString());
    }

    public void onJoin(@NotNull Job job, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(job, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        job.registerSelectJoin(this, function1);
    }

    public <T> void onAwait(@NotNull Deferred<? extends T> deferred, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(deferred, "$receiver");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        deferred.registerSelectAwait(this, function2);
    }

    public <E> void onSend(@NotNull SendChannel<? super E> sendChannel, E e, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(sendChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        sendChannel.registerSelectSend(this, e, function1);
    }

    public <E> void onReceive(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        receiveChannel.registerSelectReceive(this, function2);
    }

    public <E> void onReceiveOrNull(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$receiver");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        receiveChannel.registerSelectReceiveOrNull(this, function2);
    }

    public void onLock(@NotNull Mutex mutex, @Nullable Object obj, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(mutex, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        mutex.registerSelectLock(this, obj, function1);
    }

    public void onTimeout(long j, @NotNull TimeUnit timeUnit, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int i = 0;
        if (j >= ((long) null)) {
            i = 1;
        }
        if (i == 0) {
            timeUnit = new StringBuilder();
            timeUnit.append("Timeout time ");
            timeUnit.append(j);
            timeUnit.append(" cannot be negative");
            throw new IllegalArgumentException(timeUnit.toString().toString());
        } else if (j == 0) {
            if (trySelect(null) != null) {
                UndispatchedKt.startCoroutineUndispatched(function1, getCompletion());
            }
        } else {
            Runnable selectBuilderImpl$onTimeout$action$1 = new SelectBuilderImpl$onTimeout$action$1(this, function1);
            function1 = getContext().get(ContinuationInterceptor.Key);
            if (!(function1 instanceof Delay)) {
                function1 = null;
            }
            Delay delay = (Delay) function1;
            if (delay != null) {
                disposeOnSelect(delay.invokeOnTimeout(j, timeUnit, selectBuilderImpl$onTimeout$action$1));
            } else {
                j = ScheduledKt.getScheduledExecutor().schedule(selectBuilderImpl$onTimeout$action$1, j, timeUnit);
                Intrinsics.checkExpressionValueIsNotNull(j, "scheduledExecutor.schedule(action, time, unit)");
                JobKt.cancelFutureOnCompletion(this, (Future) j);
            }
        }
    }

    public void disposeOnSelect(@NotNull DisposableHandle disposableHandle) {
        Intrinsics.checkParameterIsNotNull(disposableHandle, "handle");
        invokeOnCompletion(new DisposeOnCompletion(this, disposableHandle));
    }
}
