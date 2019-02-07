package kotlinx.coroutines.experimental;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007\u001a\b\u0010\t\u001a\u00020\nH\u0000\u001a\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0001\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0001\u001a*\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0011H\b¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000*8\b\u0007\u0010\u0013\"\u00020\u00142\u00020\u0014B*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\u0006\b\u001a\u0012\u0002\b\f\u0012\b\b\u001b\u0012\u0004\b\b(\u001c¨\u0006\u001d"}, d2 = {"COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG", "", "DEBUG_PROPERTY_NAME", "", "newCoroutineContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "context", "resetCoroutineId", "", "restoreContext", "oldName", "updateContext", "withCoroutineContext", "T", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Here", "Lkotlinx/coroutines/experimental/Unconfined;", "Lkotlin/Deprecated;", "message", "`Here` was renamed to `Unconfined`", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "Unconfined", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 6})
/* compiled from: CoroutineContext.kt */
public final class CoroutineContextKt {
    private static final AtomicLong COROUTINE_ID = new AtomicLong();
    private static final boolean DEBUG;
    private static final String DEBUG_PROPERTY_NAME = "kotlinx.coroutines.debug";

    @Deprecated(message = "`Here` was renamed to `Unconfined`", replaceWith = @ReplaceWith(expression = "Unconfined", imports = {}))
    public static /* synthetic */ void Here$annotations() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = "kotlinx.coroutines.debug";
        r0 = java.lang.System.getProperty(r0);
        r1 = 0;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0026;
    L_0x000a:
        r2 = r0.hashCode();
        if (r2 == 0) goto L_0x003b;
    L_0x0010:
        r3 = 3551; // 0xddf float:4.976E-42 double:1.7544E-320;
        if (r2 == r3) goto L_0x0032;
    L_0x0014:
        r3 = 109935; // 0x1ad6f float:1.54052E-40 double:5.4315E-319;
        if (r2 == r3) goto L_0x0029;
    L_0x0019:
        r3 = 3005871; // 0x2dddaf float:4.212122E-39 double:1.4850976E-317;
        if (r2 != r3) goto L_0x004e;
    L_0x001e:
        r2 = "auto";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x004e;
    L_0x0026:
        r0 = kotlinx.coroutines.experimental.CoroutineId.class;
        goto L_0x0044;
    L_0x0029:
        r2 = "off";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x004e;
    L_0x0031:
        goto L_0x0044;
    L_0x0032:
        r1 = "on";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x004e;
    L_0x003a:
        goto L_0x0043;
    L_0x003b:
        r1 = "";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x004e;
    L_0x0043:
        r1 = 1;
    L_0x0044:
        DEBUG = r1;
        r0 = new java.util.concurrent.atomic.AtomicLong;
        r0.<init>();
        COROUTINE_ID = r0;
        return;
    L_0x004e:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "System property '";
        r1.append(r2);
        r2 = "kotlinx.coroutines.debug";
        r1.append(r2);
        r2 = "' has unrecognized value '";
        r1.append(r2);
        r1.append(r0);
        r0 = "'";
        r1.append(r0);
        r0 = r1.toString();
        r1 = new java.lang.IllegalStateException;
        r0 = r0.toString();
        r1.<init>(r0);
        r1 = (java.lang.Throwable) r1;
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.experimental.CoroutineContextKt.<clinit>():void");
    }

    public static final void resetCoroutineId() {
        COROUTINE_ID.set(0);
    }

    @NotNull
    public static final CoroutineContext newCoroutineContext(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        return DEBUG ? coroutineContext.plus(new CoroutineId(COROUTINE_ID.incrementAndGet())) : coroutineContext;
    }

    public static final <T> T withCoroutineContext(@NotNull CoroutineContext coroutineContext, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        coroutineContext = updateContext(coroutineContext);
        try {
            function0 = function0.invoke();
            return function0;
        } finally {
            InlineMarker.finallyStart(1);
            restoreContext(coroutineContext);
            InlineMarker.finallyEnd(1);
        }
    }

    @Nullable
    @PublishedApi
    public static final String updateContext(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        if (!DEBUG) {
            return null;
        }
        CoroutineId coroutineId = (CoroutineId) coroutineContext.get(CoroutineId.Key);
        if (coroutineId == null) {
            return null;
        }
        StringBuilder stringBuilder;
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.Key);
        if (coroutineName != null) {
            coroutineContext = coroutineName.getName();
            if (coroutineContext != null) {
                stringBuilder = new StringBuilder((name.length() + coroutineContext.length()) + 10);
                stringBuilder.append(name);
                stringBuilder.append(" @");
                stringBuilder.append(coroutineContext);
                stringBuilder.append('#');
                stringBuilder.append(coroutineId.getId());
                coroutineContext = stringBuilder.toString();
                Intrinsics.checkExpressionValueIsNotNull(coroutineContext, "StringBuilder(capacity).…builderAction).toString()");
                currentThread.setName(coroutineContext);
                return name;
            }
        }
        coroutineContext = "coroutine";
        stringBuilder = new StringBuilder((name.length() + coroutineContext.length()) + 10);
        stringBuilder.append(name);
        stringBuilder.append(" @");
        stringBuilder.append(coroutineContext);
        stringBuilder.append('#');
        stringBuilder.append(coroutineId.getId());
        coroutineContext = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(coroutineContext, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(coroutineContext);
        return name;
    }

    @PublishedApi
    public static final void restoreContext(@Nullable String str) {
        if (str != null) {
            Thread.currentThread().setName(str);
        }
    }
}
