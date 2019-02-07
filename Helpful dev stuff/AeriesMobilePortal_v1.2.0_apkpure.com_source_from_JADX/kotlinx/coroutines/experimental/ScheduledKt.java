package kotlinx.coroutines.experimental;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.ContinuationInterceptor;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.CoroutineContext$Key;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u00000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\b\u0010\t\u001a\u00020\u0005H\u0003\u001a\b\u0010\n\u001a\u00020\u000bH\u0001\u001a\b\u0010\f\u001a\u00020\u000bH\u0001\u001aG\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001aI\u0010\u0017\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\"\u0018\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000\"\u0014\u0010\u0006\u001a\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\t¨\u0006\u0018"}, d2 = {"KEEP_ALIVE", "", "kotlin.jvm.PlatformType", "Ljava/lang/Long;", "_scheduledExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "scheduledExecutor", "getScheduledExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "getOrCreateScheduledExecutorSync", "scheduledExecutorShutdownNow", "", "scheduledExecutorShutdownNowAndRelease", "withTimeout", "T", "time", "unit", "Ljava/util/concurrent/TimeUnit;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "", "(JLjava/util/concurrent/TimeUnit;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 6})
/* compiled from: Scheduled.kt */
public final class ScheduledKt {
    private static final Long KEEP_ALIVE = Long.getLong("kotlinx.coroutines.ScheduledExecutor.keepAlive", 1000);
    private static volatile ScheduledExecutorService _scheduledExecutor;

    @NotNull
    public static final ScheduledExecutorService getScheduledExecutor() {
        ScheduledExecutorService scheduledExecutorService = _scheduledExecutor;
        return scheduledExecutorService != null ? scheduledExecutorService : getOrCreateScheduledExecutorSync();
    }

    private static final synchronized java.util.concurrent.ScheduledExecutorService getOrCreateScheduledExecutorSync() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = kotlinx.coroutines.experimental.ScheduledKt.class;
        monitor-enter(r0);
        r1 = _scheduledExecutor;	 Catch:{ all -> 0x0055 }
        if (r1 == 0) goto L_0x0008;	 Catch:{ all -> 0x0055 }
    L_0x0007:
        goto L_0x0053;	 Catch:{ all -> 0x0055 }
    L_0x0008:
        r1 = new java.util.concurrent.ScheduledThreadPoolExecutor;	 Catch:{ all -> 0x0055 }
        r2 = kotlinx.coroutines.experimental.ScheduledKt$getOrCreateScheduledExecutorSync$1.INSTANCE;	 Catch:{ all -> 0x0055 }
        r2 = (java.util.concurrent.ThreadFactory) r2;	 Catch:{ all -> 0x0055 }
        r3 = 1;	 Catch:{ all -> 0x0055 }
        r1.<init>(r3, r2);	 Catch:{ all -> 0x0055 }
        r2 = KEEP_ALIVE;	 Catch:{ all -> 0x0055 }
        r4 = "KEEP_ALIVE";	 Catch:{ all -> 0x0055 }
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4);	 Catch:{ all -> 0x0055 }
        r4 = r2.longValue();	 Catch:{ all -> 0x0055 }
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x0055 }
        r1.setKeepAliveTime(r4, r2);	 Catch:{ all -> 0x0055 }
        r1.allowCoreThreadTimeOut(r3);	 Catch:{ all -> 0x0055 }
        r2 = 0;	 Catch:{ all -> 0x0055 }
        r1.setExecuteExistingDelayedTasksAfterShutdownPolicy(r2);	 Catch:{ all -> 0x0055 }
        r4 = r1.getClass();	 Catch:{ Throwable -> 0x004c }
        r5 = "setRemoveOnCancelPolicy";	 Catch:{ Throwable -> 0x004c }
        r6 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x004c }
        r7 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x004c }
        r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7);	 Catch:{ Throwable -> 0x004c }
        r7 = kotlin.jvm.JvmClassMappingKt.getJavaPrimitiveType(r7);	 Catch:{ Throwable -> 0x004c }
        r6[r2] = r7;	 Catch:{ Throwable -> 0x004c }
        r4 = r4.getMethod(r5, r6);	 Catch:{ Throwable -> 0x004c }
        r5 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x004c }
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ Throwable -> 0x004c }
        r5[r2] = r3;	 Catch:{ Throwable -> 0x004c }
        r4.invoke(r1, r5);	 Catch:{ Throwable -> 0x004c }
    L_0x004c:
        r2 = r1;	 Catch:{ all -> 0x0055 }
        r2 = (java.util.concurrent.ScheduledExecutorService) r2;	 Catch:{ all -> 0x0055 }
        _scheduledExecutor = r2;	 Catch:{ all -> 0x0055 }
        r1 = (java.util.concurrent.ScheduledExecutorService) r1;	 Catch:{ all -> 0x0055 }
    L_0x0053:
        monitor-exit(r0);
        return r1;
    L_0x0055:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.experimental.ScheduledKt.getOrCreateScheduledExecutorSync():java.util.concurrent.ScheduledExecutorService");
    }

    public static final synchronized void scheduledExecutorShutdownNow() {
        synchronized (ScheduledKt.class) {
            ScheduledExecutorService scheduledExecutorService = _scheduledExecutor;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    public static final synchronized void scheduledExecutorShutdownNowAndRelease() {
        synchronized (ScheduledKt.class) {
            ScheduledExecutorService scheduledExecutorService = _scheduledExecutor;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
                _scheduledExecutor = (ScheduledExecutorService) null;
            }
        }
    }

    @Nullable
    public static /* bridge */ /* synthetic */ Object withTimeout$default(long j, TimeUnit timeUnit, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return withTimeout(j, timeUnit, function1, continuation);
    }

    @Nullable
    public static final <T> Object withTimeout(long j, @NotNull TimeUnit timeUnit, @NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
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
        } else if (j > 0) {
            continuation = CoroutineIntrinsics.normalizeContinuation(continuation);
            CoroutineContext context = continuation.getContext();
            TimeoutExceptionCoroutine timeoutExceptionCoroutine = new TimeoutExceptionCoroutine(j, timeUnit, continuation);
            continuation = context.get((CoroutineContext$Key) ContinuationInterceptor.Key);
            if (!(continuation instanceof Delay)) {
                continuation = null;
            }
            Delay delay = (Delay) continuation;
            if (delay != null) {
                JobKt.disposeOnCompletion(timeoutExceptionCoroutine, delay.invokeOnTimeout(j, timeUnit, timeoutExceptionCoroutine));
            } else {
                Job job = timeoutExceptionCoroutine;
                j = getScheduledExecutor().schedule(timeoutExceptionCoroutine, j, timeUnit);
                Intrinsics.checkExpressionValueIsNotNull(j, "scheduledExecutor.schedule(coroutine, time, unit)");
                JobKt.cancelFutureOnCompletion(job, (Future) j);
            }
            timeoutExceptionCoroutine.initParentJob((Job) context.get((CoroutineContext$Key) Job.Key));
            return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(timeoutExceptionCoroutine);
        } else {
            throw ((Throwable) new CancellationException("Timed out immediately"));
        }
    }

    @Nullable
    public static /* bridge */ /* synthetic */ Object withTimeoutOrNull$default(long j, TimeUnit timeUnit, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return withTimeoutOrNull(j, timeUnit, function1, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object withTimeoutOrNull(long r6, @org.jetbrains.annotations.NotNull java.util.concurrent.TimeUnit r8, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.experimental.Continuation<? super T>, ? extends java.lang.Object> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.experimental.Continuation<? super T> r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "unit";
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0);
        r0 = "block";
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0);
        r0 = "$continuation";
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0);
        r0 = 0;
        r1 = (long) r0;
        r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1));
        r1 = 1;
        if (r3 < 0) goto L_0x0017;
    L_0x0016:
        r0 = r1;
    L_0x0017:
        if (r0 == 0) goto L_0x0081;
    L_0x0019:
        r2 = 0;
        r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        r2 = 0;
        if (r0 > 0) goto L_0x0021;
    L_0x0020:
        return r2;
    L_0x0021:
        r10 = kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics.normalizeContinuation(r10);
        r0 = r10.getContext();
        r3 = new kotlinx.coroutines.experimental.TimeoutNullCoroutine;
        r3.<init>(r6, r8, r10);
        r10 = kotlin.coroutines.experimental.ContinuationInterceptor.Key;
        r10 = (kotlin.coroutines.experimental.CoroutineContext$Key) r10;
        r10 = r0.get(r10);
        r4 = r10 instanceof kotlinx.coroutines.experimental.Delay;
        if (r4 != 0) goto L_0x003b;
    L_0x003a:
        r10 = r2;
    L_0x003b:
        r10 = (kotlinx.coroutines.experimental.Delay) r10;
        if (r10 == 0) goto L_0x004d;
    L_0x003f:
        r4 = r3;
        r4 = (kotlinx.coroutines.experimental.Job) r4;
        r5 = r3;
        r5 = (java.lang.Runnable) r5;
        r6 = r10.invokeOnTimeout(r6, r8, r5);
        kotlinx.coroutines.experimental.JobKt.disposeOnCompletion(r4, r6);
        goto L_0x0065;
    L_0x004d:
        r10 = r3;
        r10 = (kotlinx.coroutines.experimental.Job) r10;
        r4 = getScheduledExecutor();
        r5 = r3;
        r5 = (java.lang.Runnable) r5;
        r6 = r4.schedule(r5, r6, r8);
        r7 = "scheduledExecutor.schedule(coroutine, time, unit)";
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7);
        r6 = (java.util.concurrent.Future) r6;
        kotlinx.coroutines.experimental.JobKt.cancelFutureOnCompletion(r10, r6);
    L_0x0065:
        r6 = kotlinx.coroutines.experimental.Job.Key;
        r6 = (kotlin.coroutines.experimental.CoroutineContext$Key) r6;
        r6 = r0.get(r6);
        r6 = (kotlinx.coroutines.experimental.Job) r6;
        r3.initParentJob(r6);
        r6 = kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(r9, r1);	 Catch:{ TimeoutException -> 0x007f }
        r6 = (kotlin.jvm.functions.Function1) r6;	 Catch:{ TimeoutException -> 0x007f }
        r3 = (kotlin.coroutines.experimental.Continuation) r3;	 Catch:{ TimeoutException -> 0x007f }
        r6 = r6.invoke(r3);	 Catch:{ TimeoutException -> 0x007f }
        goto L_0x0080;
    L_0x007f:
        r6 = r2;
    L_0x0080:
        return r6;
    L_0x0081:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Timeout time ";
        r8.append(r9);
        r8.append(r6);
        r6 = " cannot be negative";
        r8.append(r6);
        r6 = r8.toString();
        r7 = new java.lang.IllegalArgumentException;
        r6 = r6.toString();
        r7.<init>(r6);
        r7 = (java.lang.Throwable) r7;
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.experimental.ScheduledKt.withTimeoutOrNull(long, java.util.concurrent.TimeUnit, kotlin.jvm.functions.Function1, kotlin.coroutines.experimental.Continuation):java.lang.Object");
    }
}
