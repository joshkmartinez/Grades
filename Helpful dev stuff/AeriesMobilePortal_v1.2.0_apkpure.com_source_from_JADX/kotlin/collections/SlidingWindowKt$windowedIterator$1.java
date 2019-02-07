package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.SequenceBuilder;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "Lkotlin/coroutines/experimental/SequenceBuilder;", "", "invoke", "(Lkotlin/coroutines/experimental/SequenceBuilder;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 10})
/* compiled from: SlidingWindow.kt */
final class SlidingWindowKt$windowedIterator$1 extends CoroutineImpl implements Function2<SequenceBuilder<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Iterator $iterator;
    final /* synthetic */ boolean $partialWindows;
    final /* synthetic */ boolean $reuseBuffer;
    final /* synthetic */ int $size;
    final /* synthetic */ int $step;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    private SequenceBuilder p$;

    SlidingWindowKt$windowedIterator$1(int i, int i2, Iterator it, boolean z, boolean z2, Continuation continuation) {
        this.$step = i;
        this.$size = i2;
        this.$iterator = it;
        this.$reuseBuffer = z;
        this.$partialWindows = z2;
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull SequenceBuilder<? super List<? extends T>> sequenceBuilder, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(sequenceBuilder, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        Continuation slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$step, this.$size, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
        slidingWindowKt$windowedIterator$1.p$ = sequenceBuilder;
        return slidingWindowKt$windowedIterator$1;
    }

    @Nullable
    public final Object invoke(@NotNull SequenceBuilder<? super List<? extends T>> sequenceBuilder, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(sequenceBuilder, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return ((SlidingWindowKt$windowedIterator$1) create((SequenceBuilder) sequenceBuilder, (Continuation) continuation)).doResume(Unit.INSTANCE, null);
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Object doResume(@org.jetbrains.annotations.Nullable java.lang.Object r12, @org.jetbrains.annotations.Nullable java.lang.Throwable r13) {
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
        r11 = this;
        r12 = kotlin.coroutines.experimental.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r0 = r11.label;
        r1 = 1;
        r2 = 2;
        switch(r0) {
            case 0: goto L_0x006c;
            case 1: goto L_0x0053;
            case 2: goto L_0x0046;
            case 3: goto L_0x002f;
            case 4: goto L_0x001e;
            case 5: goto L_0x0013;
            default: goto L_0x000b;
        };
    L_0x000b:
        r12 = new java.lang.IllegalStateException;
        r13 = "call to 'resume' before 'invoke' with coroutine";
        r12.<init>(r13);
        throw r12;
    L_0x0013:
        r12 = r11.L$0;
        r12 = (kotlin.collections.RingBuffer) r12;
        r12 = r11.I$0;
        if (r13 != 0) goto L_0x001d;
    L_0x001b:
        goto L_0x0198;
    L_0x001d:
        throw r13;
    L_0x001e:
        r0 = r11.L$1;
        r0 = (kotlin.collections.RingBuffer) r0;
        r3 = r11.I$0;
        r4 = r11.L$0;
        r4 = (kotlin.coroutines.experimental.SequenceBuilder) r4;
        if (r13 != 0) goto L_0x002e;
    L_0x002a:
        r13 = r12;
        r12 = r11;
        goto L_0x0177;
    L_0x002e:
        throw r13;
    L_0x002f:
        r0 = r11.L$3;
        r0 = (java.util.Iterator) r0;
        r3 = r11.L$2;
        r3 = r11.L$1;
        r3 = (kotlin.collections.RingBuffer) r3;
        r4 = r11.I$0;
        r5 = r11.L$0;
        r5 = (kotlin.coroutines.experimental.SequenceBuilder) r5;
        if (r13 != 0) goto L_0x0045;
    L_0x0041:
        r13 = r12;
        r12 = r11;
        goto L_0x013d;
    L_0x0045:
        throw r13;
    L_0x0046:
        r12 = r11.I$1;
        r12 = r11.L$0;
        r12 = (java.util.ArrayList) r12;
        r12 = r11.I$0;
        if (r13 != 0) goto L_0x0052;
    L_0x0050:
        goto L_0x0198;
    L_0x0052:
        throw r13;
    L_0x0053:
        r0 = r11.L$3;
        r0 = (java.util.Iterator) r0;
        r3 = r11.L$2;
        r3 = r11.I$1;
        r3 = r11.L$1;
        r3 = (java.util.ArrayList) r3;
        r4 = r11.I$0;
        r5 = r11.L$0;
        r5 = (kotlin.coroutines.experimental.SequenceBuilder) r5;
        if (r13 != 0) goto L_0x006b;
    L_0x0067:
        r6 = r12;
        r13 = r4;
        r12 = r11;
        goto L_0x00b9;
    L_0x006b:
        throw r13;
    L_0x006c:
        if (r13 != 0) goto L_0x019b;
    L_0x006e:
        r13 = r11.p$;
        r0 = r11.$step;
        r3 = r11.$size;
        r0 = r0 - r3;
        if (r0 < 0) goto L_0x00f2;
    L_0x0077:
        r3 = new java.util.ArrayList;
        r4 = r11.$size;
        r3.<init>(r4);
        r4 = 0;
        r5 = r11.$iterator;
        r6 = r12;
        r12 = r11;
        r10 = r5;
        r5 = r13;
        r13 = r0;
        r0 = r10;
    L_0x0087:
        r7 = r0.hasNext();
        if (r7 == 0) goto L_0x00ca;
    L_0x008d:
        r7 = r0.next();
        if (r4 <= 0) goto L_0x0096;
    L_0x0093:
        r4 = r4 + -1;
        goto L_0x0087;
    L_0x0096:
        r3.add(r7);
        r8 = r3.size();
        r9 = r12.$size;
        if (r8 != r9) goto L_0x0087;
    L_0x00a1:
        r12.L$0 = r5;
        r12.I$0 = r13;
        r12.L$1 = r3;
        r12.I$1 = r4;
        r12.L$2 = r7;
        r12.L$3 = r0;
        r12.label = r1;
        r4 = r5.yield(r3, r12);
        kotlin.jvm.internal.InlineMarker.mark(r2);
        if (r4 != r6) goto L_0x00b9;
    L_0x00b8:
        return r6;
    L_0x00b9:
        r4 = r12.$reuseBuffer;
        if (r4 == 0) goto L_0x00c1;
    L_0x00bd:
        r3.clear();
        goto L_0x00c8;
    L_0x00c1:
        r3 = new java.util.ArrayList;
        r4 = r12.$size;
        r3.<init>(r4);
    L_0x00c8:
        r4 = r13;
        goto L_0x0087;
    L_0x00ca:
        r0 = r3;
        r0 = (java.util.Collection) r0;
        r0 = r0.isEmpty();
        r0 = r0 ^ r1;
        if (r0 == 0) goto L_0x0198;
    L_0x00d4:
        r0 = r12.$partialWindows;
        if (r0 != 0) goto L_0x00e0;
    L_0x00d8:
        r0 = r3.size();
        r1 = r12.$size;
        if (r0 != r1) goto L_0x0198;
    L_0x00e0:
        r12.I$0 = r13;
        r12.L$0 = r3;
        r12.I$1 = r4;
        r12.label = r2;
        r12 = r5.yield(r3, r12);
        kotlin.jvm.internal.InlineMarker.mark(r2);
        if (r12 != r6) goto L_0x0198;
    L_0x00f1:
        return r6;
    L_0x00f2:
        r3 = new kotlin.collections.RingBuffer;
        r4 = r11.$size;
        r3.<init>(r4);
        r4 = r11.$iterator;
        r5 = r13;
        r13 = r12;
        r12 = r11;
        r10 = r4;
        r4 = r0;
        r0 = r10;
    L_0x0101:
        r6 = r0.hasNext();
        if (r6 == 0) goto L_0x0143;
    L_0x0107:
        r6 = r0.next();
        r3.add(r6);
        r7 = r3.isFull();
        if (r7 == 0) goto L_0x0101;
    L_0x0114:
        r7 = r12.$reuseBuffer;
        if (r7 == 0) goto L_0x011c;
    L_0x0118:
        r7 = r3;
        r7 = (java.util.List) r7;
        goto L_0x0126;
    L_0x011c:
        r7 = new java.util.ArrayList;
        r8 = r3;
        r8 = (java.util.Collection) r8;
        r7.<init>(r8);
        r7 = (java.util.List) r7;
    L_0x0126:
        r12.L$0 = r5;
        r12.I$0 = r4;
        r12.L$1 = r3;
        r12.L$2 = r6;
        r12.L$3 = r0;
        r6 = 3;
        r12.label = r6;
        r6 = r5.yield(r7, r12);
        kotlin.jvm.internal.InlineMarker.mark(r2);
        if (r6 != r13) goto L_0x013d;
    L_0x013c:
        return r13;
    L_0x013d:
        r6 = r12.$step;
        r3.removeFirst(r6);
        goto L_0x0101;
    L_0x0143:
        r0 = r12.$partialWindows;
        if (r0 == 0) goto L_0x0198;
    L_0x0147:
        r0 = r3;
        r3 = r4;
        r4 = r5;
    L_0x014a:
        r5 = r0.size();
        r6 = r12.$step;
        if (r5 <= r6) goto L_0x017d;
    L_0x0152:
        r5 = r12.$reuseBuffer;
        if (r5 == 0) goto L_0x015a;
    L_0x0156:
        r5 = r0;
        r5 = (java.util.List) r5;
        goto L_0x0164;
    L_0x015a:
        r5 = new java.util.ArrayList;
        r6 = r0;
        r6 = (java.util.Collection) r6;
        r5.<init>(r6);
        r5 = (java.util.List) r5;
    L_0x0164:
        r12.L$0 = r4;
        r12.I$0 = r3;
        r12.L$1 = r0;
        r6 = 4;
        r12.label = r6;
        r5 = r4.yield(r5, r12);
        kotlin.jvm.internal.InlineMarker.mark(r2);
        if (r5 != r13) goto L_0x0177;
    L_0x0176:
        return r13;
    L_0x0177:
        r5 = r12.$step;
        r0.removeFirst(r5);
        goto L_0x014a;
    L_0x017d:
        r5 = r0;
        r5 = (java.util.Collection) r5;
        r5 = r5.isEmpty();
        r1 = r1 ^ r5;
        if (r1 == 0) goto L_0x0198;
    L_0x0187:
        r12.I$0 = r3;
        r12.L$0 = r0;
        r1 = 5;
        r12.label = r1;
        r12 = r4.yield(r0, r12);
        kotlin.jvm.internal.InlineMarker.mark(r2);
        if (r12 != r13) goto L_0x0198;
    L_0x0197:
        return r13;
    L_0x0198:
        r12 = kotlin.Unit.INSTANCE;
        return r12;
    L_0x019b:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.SlidingWindowKt$windowedIterator$1.doResume(java.lang.Object, java.lang.Throwable):java.lang.Object");
    }
}
