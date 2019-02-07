package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 1}, k = 3, mv = {1, 1, 6})
/* compiled from: Channels.kt */
final class ChannelsKt$consumeEach$2 extends CoroutineImpl {
    final /* synthetic */ Function2 $action;
    private int I$0;
    private Object L$0;
    private Object L$1;
    private Object L$2;
    private Object L$3;
    private BroadcastChannel p$;
    private Function2 p$0;
    final /* synthetic */ BroadcastChannel receiver$0;

    ChannelsKt$consumeEach$2(BroadcastChannel broadcastChannel, Function2 function2, Continuation continuation) {
        this.receiver$0 = broadcastChannel;
        this.$action = function2;
        super(2, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Object doResume(@org.jetbrains.annotations.Nullable java.lang.Object r11, @org.jetbrains.annotations.Nullable java.lang.Throwable r12) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:kotlinx.coroutines.experimental.channels.ChannelsKt$consumeEach$2.doResume(java.lang.Object, java.lang.Throwable):java.lang.Object. bs: [B:7:0x0029, B:36:0x0095]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r10 = this;
        r0 = kotlin.coroutines.experimental.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r1 = r10.label;
        r2 = 1;
        switch(r1) {
            case 0: goto L_0x0069;
            case 1: goto L_0x0049;
            case 2: goto L_0x002e;
            case 3: goto L_0x0012;
            default: goto L_0x000a;
        };
    L_0x000a:
        r11 = new java.lang.IllegalStateException;
        r12 = "call to 'resume' before 'invoke' with coroutine";
        r11.<init>(r12);
        throw r11;
    L_0x0012:
        r11 = r10.L$3;
        r11 = r10.L$2;
        r11 = (kotlinx.coroutines.experimental.channels.ChannelIterator) r11;
        r1 = r10.L$1;
        r1 = (kotlinx.coroutines.experimental.channels.SubscriptionReceiveChannel) r1;
        r3 = r10.I$0;
        r4 = r10.L$0;
        r4 = (java.io.Closeable) r4;
        if (r12 != 0) goto L_0x0029;
    L_0x0024:
        r12 = r3;
        r3 = r1;
        r1 = r11;
        goto L_0x007e;
    L_0x0029:
        throw r12;	 Catch:{ Exception -> 0x00e4, all -> 0x002a }
    L_0x002a:
        r11 = move-exception;
        r0 = r3;
        goto L_0x00f1;
    L_0x002e:
        r1 = r10.L$2;
        r1 = (kotlinx.coroutines.experimental.channels.ChannelIterator) r1;
        r3 = r10.L$1;
        r3 = (kotlinx.coroutines.experimental.channels.SubscriptionReceiveChannel) r3;
        r4 = r10.I$0;
        r5 = r10.L$0;
        r5 = (java.io.Closeable) r5;
        if (r12 != 0) goto L_0x0048;
    L_0x003e:
        r12 = r10;
        r8 = r5;
        r5 = r0;
        r0 = r4;
        r4 = r8;
        r9 = r3;
        r3 = r1;
        r1 = r9;
        goto L_0x00b2;
    L_0x0048:
        throw r12;	 Catch:{ Exception -> 0x0065, all -> 0x0060 }
    L_0x0049:
        r1 = r10.L$2;
        r1 = (kotlinx.coroutines.experimental.channels.ChannelIterator) r1;
        r3 = r10.L$1;
        r3 = (kotlinx.coroutines.experimental.channels.SubscriptionReceiveChannel) r3;
        r4 = r10.I$0;
        r5 = r10.L$0;
        r5 = (java.io.Closeable) r5;
        if (r12 != 0) goto L_0x005f;
    L_0x0059:
        r12 = r10;
        r8 = r5;
        r5 = r0;
        r0 = r4;
        r4 = r8;
        goto L_0x0095;
    L_0x005f:
        throw r12;	 Catch:{ Exception -> 0x0065, all -> 0x0060 }
    L_0x0060:
        r11 = move-exception;
        r0 = r4;
        r4 = r5;
        goto L_0x00f1;
    L_0x0065:
        r11 = move-exception;
        r4 = r5;
        goto L_0x00e5;
    L_0x0069:
        if (r12 != 0) goto L_0x00f9;
    L_0x006b:
        r11 = r10.receiver$0;
        r11 = r11.open();
        r4 = r11;
        r4 = (java.io.Closeable) r4;
        r11 = 0;
        r12 = r4;	 Catch:{ Exception -> 0x00e4, all -> 0x00e0 }
        r12 = (kotlinx.coroutines.experimental.channels.SubscriptionReceiveChannel) r12;	 Catch:{ Exception -> 0x00e4, all -> 0x00e0 }
        r1 = r12.iterator();	 Catch:{ Exception -> 0x00e4, all -> 0x00e0 }
        r3 = r12;
        r12 = r11;
    L_0x007e:
        r11 = r10;
    L_0x007f:
        r11.L$0 = r4;	 Catch:{ Exception -> 0x00e4, all -> 0x00dd }
        r11.I$0 = r12;	 Catch:{ Exception -> 0x00e4, all -> 0x00dd }
        r11.L$1 = r3;	 Catch:{ Exception -> 0x00e4, all -> 0x00dd }
        r11.L$2 = r1;	 Catch:{ Exception -> 0x00e4, all -> 0x00dd }
        r11.label = r2;	 Catch:{ Exception -> 0x00e4, all -> 0x00dd }
        r5 = r1.hasNext(r11);	 Catch:{ Exception -> 0x00e4, all -> 0x00dd }
        if (r5 != r0) goto L_0x0090;
    L_0x008f:
        return r0;
    L_0x0090:
        r8 = r12;
        r12 = r11;
        r11 = r5;
        r5 = r0;
        r0 = r8;
    L_0x0095:
        r11 = (java.lang.Boolean) r11;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r11 = r11.booleanValue();	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        if (r11 == 0) goto L_0x00cf;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
    L_0x009d:
        r12.L$0 = r4;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r12.I$0 = r0;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r12.L$1 = r3;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r12.L$2 = r1;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r11 = 2;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r12.label = r11;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r11 = r1.next(r12);	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        if (r11 != r5) goto L_0x00af;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
    L_0x00ae:
        return r5;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
    L_0x00af:
        r8 = r3;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r3 = r1;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r1 = r8;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
    L_0x00b2:
        r6 = r12.$action;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r12.L$0 = r4;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r12.I$0 = r0;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r12.L$1 = r1;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r12.L$2 = r3;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r12.L$3 = r11;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r7 = 3;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r12.label = r7;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r11 = r6.invoke(r11, r12);	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        if (r11 != r5) goto L_0x00c8;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
    L_0x00c7:
        return r5;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
    L_0x00c8:
        r11 = r12;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r12 = r0;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r0 = r5;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r8 = r3;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r3 = r1;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        r1 = r8;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        goto L_0x007f;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
    L_0x00cf:
        r11 = kotlin.Unit.INSTANCE;	 Catch:{ Exception -> 0x00e4, all -> 0x00db }
        if (r0 != 0) goto L_0x00d8;
    L_0x00d3:
        if (r4 == 0) goto L_0x00d8;
    L_0x00d5:
        r4.close();
    L_0x00d8:
        r11 = kotlin.Unit.INSTANCE;
        return r11;
    L_0x00db:
        r11 = move-exception;
        goto L_0x00f1;
    L_0x00dd:
        r11 = move-exception;
        r0 = r12;
        goto L_0x00f1;
    L_0x00e0:
        r12 = move-exception;
        r0 = r11;
        r11 = r12;
        goto L_0x00f1;
    L_0x00e4:
        r11 = move-exception;
    L_0x00e5:
        if (r4 == 0) goto L_0x00ee;
    L_0x00e7:
        r4.close();	 Catch:{ Exception -> 0x00ee }
        goto L_0x00ee;
    L_0x00eb:
        r11 = move-exception;
        r0 = r2;
        goto L_0x00f1;
    L_0x00ee:
        r11 = (java.lang.Throwable) r11;	 Catch:{ all -> 0x00eb }
        throw r11;	 Catch:{ all -> 0x00eb }
    L_0x00f1:
        if (r0 != 0) goto L_0x00f8;
    L_0x00f3:
        if (r4 == 0) goto L_0x00f8;
    L_0x00f5:
        r4.close();
    L_0x00f8:
        throw r11;
    L_0x00f9:
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.experimental.channels.ChannelsKt$consumeEach$2.doResume(java.lang.Object, java.lang.Throwable):java.lang.Object");
    }
}
