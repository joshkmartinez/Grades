package kotlinx.coroutines.experimental;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.ContinuationInterceptor;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.CoroutineContext.Element;
import kotlin.coroutines.experimental.CoroutinesKt;
import kotlin.coroutines.experimental.EmptyCoroutineContext;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aI\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\r\u001aI\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u000e2'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a=\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aI\u0010\u0014\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\b\b\u0002\u0010\u0002\u001a\u00020\u00032'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0002\u0004\n\u0002\b\t¨\u0006\u0016"}, d2 = {"launch", "Lkotlinx/coroutines/experimental/Job;", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "start", "", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/experimental/CoroutineScope;", "Lkotlin/coroutines/experimental/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/experimental/CoroutineContext;ZLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/Job;", "Lkotlinx/coroutines/experimental/CoroutineStart;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlinx/coroutines/experimental/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/experimental/Job;", "run", "T", "Lkotlin/Function1;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "runBlocking", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 6})
/* compiled from: Builders.kt */
public final class BuildersKt {
    @NotNull
    public static /* bridge */ /* synthetic */ Job launch$default(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return launch(coroutineContext, coroutineStart, function2);
    }

    @NotNull
    public static final Job launch(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        StandaloneCoroutine lazyStandaloneCoroutine;
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(coroutineStart, "start");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineContext);
        if (coroutineStart.isLazy()) {
            lazyStandaloneCoroutine = new LazyStandaloneCoroutine(newCoroutineContext, function2);
        } else {
            lazyStandaloneCoroutine = new StandaloneCoroutine(newCoroutineContext, true);
        }
        lazyStandaloneCoroutine.initParentJob((Job) coroutineContext.get(Job.Key));
        coroutineStart.invoke(function2, lazyStandaloneCoroutine, lazyStandaloneCoroutine);
        return lazyStandaloneCoroutine;
    }

    @NotNull
    @Deprecated(message = "Use `start = CoroutineStart.XXX` parameter", replaceWith = @ReplaceWith(expression = "launch(context, if (start) CoroutineStart.DEFAULT else CoroutineStart.LAZY, block)", imports = {}))
    public static final Job launch(@NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        return launch(coroutineContext, z ? CoroutineStart.DEFAULT : CoroutineStart.LAZY, (Function2) function2);
    }

    @Nullable
    public static final <T> Object run(@NotNull CoroutineContext coroutineContext, @NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
        continuation = CoroutineIntrinsics.normalizeContinuation(continuation);
        CoroutineContext context = continuation.getContext();
        if (coroutineContext != context) {
            if (!(coroutineContext instanceof Element) || context.get(((Element) coroutineContext).getKey()) != coroutineContext) {
                coroutineContext = context.plus(coroutineContext);
                if (coroutineContext == context) {
                    return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(continuation);
                }
                if (Intrinsics.areEqual((ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key), (ContinuationInterceptor) context.get(ContinuationInterceptor.Key))) {
                    return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(new RunContinuationDirect(coroutineContext, continuation));
                }
                RunContinuationCoroutine runContinuationCoroutine = new RunContinuationCoroutine(coroutineContext, continuation);
                runContinuationCoroutine.initCancellability();
                CoroutinesKt.startCoroutine(function1, runContinuationCoroutine);
                return runContinuationCoroutine.getResult();
            }
        }
        return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(continuation);
    }

    public static /* bridge */ /* synthetic */ Object runBlocking$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) throws InterruptedException {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return runBlocking(coroutineContext, function2);
    }

    public static final <T> T runBlocking(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        EventLoopImpl eventLoopImpl;
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        Thread currentThread = Thread.currentThread();
        if (coroutineContext.get(ContinuationInterceptor.Key) == null) {
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "currentThread");
            eventLoopImpl = new EventLoopImpl(currentThread);
        } else {
            eventLoopImpl = null;
        }
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineContext.plus(eventLoopImpl != null ? eventLoopImpl : EmptyCoroutineContext.INSTANCE));
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "currentThread");
        BlockingCoroutine blockingCoroutine = new BlockingCoroutine(newCoroutineContext, currentThread, eventLoopImpl != null);
        blockingCoroutine.initParentJob((Job) coroutineContext.get(Job.Key));
        if (eventLoopImpl != null) {
            eventLoopImpl.initParentJob(blockingCoroutine);
        }
        CoroutinesKt.startCoroutine(function2, blockingCoroutine, blockingCoroutine);
        return blockingCoroutine.joinBlocking();
    }
}
