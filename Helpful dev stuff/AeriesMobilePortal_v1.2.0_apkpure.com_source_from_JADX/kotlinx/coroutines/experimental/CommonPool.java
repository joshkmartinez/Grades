package kotlinx.coroutines.experimental;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\b¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0003J\u0015\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\r\u0010\u0005\u001a\u00020\u0011H\u0001¢\u0006\u0002\b\u001cR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/experimental/CommonPool;", "Lkotlinx/coroutines/experimental/CoroutineDispatcher;", "()V", "_pool", "Ljava/util/concurrent/ExecutorService;", "usePrivatePool", "", "Try", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "createPlainPool", "createPool", "defaultParallelism", "", "dispatch", "", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "Ljava/lang/Runnable;", "getOrCreatePoolSync", "shutdownAndRelease", "timeout", "", "shutdownAndRelease$kotlinx_coroutines_core", "toString", "", "usePrivatePool$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: CommonPool.kt */
public final class CommonPool extends CoroutineDispatcher {
    public static final CommonPool INSTANCE = null;
    private static volatile ExecutorService _pool;
    private static boolean usePrivatePool;

    @NotNull
    public String toString() {
        return "CommonPool";
    }

    static {
        CommonPool commonPool = new CommonPool();
    }

    private CommonPool() {
        INSTANCE = this;
    }

    private final <T> T Try(kotlin.jvm.functions.Function0<? extends T> r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r1 = r1.invoke();	 Catch:{ Throwable -> 0x0005 }
        goto L_0x0006;
    L_0x0005:
        r1 = 0;
    L_0x0006:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.experimental.CommonPool.Try(kotlin.jvm.functions.Function0):T");
    }

    private final java.util.concurrent.ExecutorService createPool() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = 0;
        r1 = "java.util.concurrent.ForkJoinPool";	 Catch:{ Throwable -> 0x0008 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x0008 }
        goto L_0x0009;
    L_0x0008:
        r1 = r0;
    L_0x0009:
        if (r1 == 0) goto L_0x005b;
    L_0x000b:
        r2 = usePrivatePool;
        r3 = 0;
        if (r2 != 0) goto L_0x002e;
    L_0x0010:
        r2 = "commonPool";	 Catch:{ Throwable -> 0x002a }
        r4 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x002a }
        r2 = r1.getMethod(r2, r4);	 Catch:{ Throwable -> 0x002a }
        if (r2 == 0) goto L_0x0021;	 Catch:{ Throwable -> 0x002a }
    L_0x001a:
        r4 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x002a }
        r2 = r2.invoke(r0, r4);	 Catch:{ Throwable -> 0x002a }
        goto L_0x0022;	 Catch:{ Throwable -> 0x002a }
    L_0x0021:
        r2 = r0;	 Catch:{ Throwable -> 0x002a }
    L_0x0022:
        r4 = r2 instanceof java.util.concurrent.ExecutorService;	 Catch:{ Throwable -> 0x002a }
        if (r4 != 0) goto L_0x0027;	 Catch:{ Throwable -> 0x002a }
    L_0x0026:
        r2 = r0;	 Catch:{ Throwable -> 0x002a }
    L_0x0027:
        r2 = (java.util.concurrent.ExecutorService) r2;	 Catch:{ Throwable -> 0x002a }
        goto L_0x002b;
    L_0x002a:
        r2 = r0;
    L_0x002b:
        if (r2 == 0) goto L_0x002e;
    L_0x002d:
        return r2;
    L_0x002e:
        r2 = 1;
        r4 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0053 }
        r5 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x0053 }
        r4[r3] = r5;	 Catch:{ Throwable -> 0x0053 }
        r1 = r1.getConstructor(r4);	 Catch:{ Throwable -> 0x0053 }
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0053 }
        r4 = INSTANCE;	 Catch:{ Throwable -> 0x0053 }
        r4 = r4.defaultParallelism();	 Catch:{ Throwable -> 0x0053 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0053 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0053 }
        r1 = r1.newInstance(r2);	 Catch:{ Throwable -> 0x0053 }
        r2 = r1 instanceof java.util.concurrent.ExecutorService;	 Catch:{ Throwable -> 0x0053 }
        if (r2 != 0) goto L_0x0050;	 Catch:{ Throwable -> 0x0053 }
    L_0x004f:
        r1 = r0;	 Catch:{ Throwable -> 0x0053 }
    L_0x0050:
        r1 = (java.util.concurrent.ExecutorService) r1;	 Catch:{ Throwable -> 0x0053 }
        r0 = r1;
    L_0x0053:
        if (r0 == 0) goto L_0x0056;
    L_0x0055:
        return r0;
    L_0x0056:
        r0 = r6.createPlainPool();
        return r0;
    L_0x005b:
        r0 = r6.createPlainPool();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.experimental.CommonPool.createPool():java.util.concurrent.ExecutorService");
    }

    private final ExecutorService createPlainPool() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(defaultParallelism(), new CommonPool$createPlainPool$1(new AtomicInteger()));
        Intrinsics.checkExpressionValueIsNotNull(newFixedThreadPool, "Executors.newFixedThread…Daemon = true }\n        }");
        return newFixedThreadPool;
    }

    private final int defaultParallelism() {
        return RangesKt___RangesKt.coerceAtLeast(Runtime.getRuntime().availableProcessors() - 1, 1);
    }

    private final synchronized ExecutorService getOrCreatePoolSync() {
        ExecutorService executorService;
        executorService = _pool;
        if (executorService == null) {
            executorService = createPool();
            _pool = executorService;
        }
        return executorService;
    }

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        coroutineContext = _pool;
        if (coroutineContext == null) {
            coroutineContext = getOrCreatePoolSync();
        }
        coroutineContext.execute(runnable);
    }

    public final synchronized void usePrivatePool$kotlinx_coroutines_core() {
        shutdownAndRelease$kotlinx_coroutines_core(0);
        usePrivatePool = true;
    }

    public final synchronized void shutdownAndRelease$kotlinx_coroutines_core(long j) {
        ExecutorService executorService = _pool;
        if (executorService != null) {
            executorService.shutdown();
            if (j > ((long) null)) {
                executorService.awaitTermination(j, TimeUnit.MILLISECONDS);
            }
            _pool = (ExecutorService) 0;
        }
        usePrivatePool = false;
    }
}
