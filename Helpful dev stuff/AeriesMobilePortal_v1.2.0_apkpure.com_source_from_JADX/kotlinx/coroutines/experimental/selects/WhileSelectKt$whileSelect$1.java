package kotlinx.coroutines.experimental.selects;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 1}, k = 3, mv = {1, 1, 6})
/* compiled from: WhileSelect.kt */
final class WhileSelectKt$whileSelect$1 extends CoroutineImpl {
    final /* synthetic */ Function1 $builder;
    private Object L$0;
    private Object L$1;
    private Function1 p$0;

    WhileSelectKt$whileSelect$1(Function1 function1, Continuation continuation) {
        this.$builder = function1;
        super(1, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Object doResume(@org.jetbrains.annotations.Nullable java.lang.Object r5, @org.jetbrains.annotations.Nullable java.lang.Throwable r6) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = kotlin.coroutines.experimental.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r1 = r4.label;
        switch(r1) {
            case 0: goto L_0x001e;
            case 1: goto L_0x0011;
            default: goto L_0x0009;
        };
    L_0x0009:
        r5 = new java.lang.IllegalStateException;
        r6 = "call to 'resume' before 'invoke' with coroutine";
        r5.<init>(r6);
        throw r5;
    L_0x0011:
        r1 = r4.L$1;
        r1 = (kotlinx.coroutines.experimental.selects.WhileSelectKt$whileSelect$1) r1;
        r1 = r4.L$0;
        r1 = (kotlin.jvm.functions.Function1) r1;
        if (r6 != 0) goto L_0x001d;
    L_0x001b:
        r6 = r4;
        goto L_0x0045;
    L_0x001d:
        throw r6;
    L_0x001e:
        if (r6 != 0) goto L_0x0052;
    L_0x0020:
        r5 = r4;
    L_0x0021:
        r6 = r5.$builder;
        r5.L$0 = r6;
        r5.L$1 = r5;
        r1 = 1;
        r5.label = r1;
        r1 = kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics.normalizeContinuation(r5);
        r2 = new kotlinx.coroutines.experimental.selects.SelectBuilderImpl;
        r2.<init>(r1);
        r6.invoke(r2);	 Catch:{ Throwable -> 0x0037 }
        goto L_0x003b;
    L_0x0037:
        r6 = move-exception;
        r2.handleBuilderException(r6);
    L_0x003b:
        r6 = r2.initSelectResult();
        if (r6 != r0) goto L_0x0042;
    L_0x0041:
        return r0;
    L_0x0042:
        r3 = r6;
        r6 = r5;
        r5 = r3;
    L_0x0045:
        r5 = (java.lang.Boolean) r5;
        r5 = r5.booleanValue();
        if (r5 == 0) goto L_0x004f;
    L_0x004d:
        r5 = r6;
        goto L_0x0021;
    L_0x004f:
        r5 = kotlin.Unit.INSTANCE;
        return r5;
    L_0x0052:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.experimental.selects.WhileSelectKt$whileSelect$1.doResume(java.lang.Object, java.lang.Throwable):java.lang.Object");
    }
}
