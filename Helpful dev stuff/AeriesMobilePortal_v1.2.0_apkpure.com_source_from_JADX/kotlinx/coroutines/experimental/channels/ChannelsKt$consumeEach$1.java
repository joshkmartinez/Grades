package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 1}, k = 3, mv = {1, 1, 6})
/* compiled from: Channels.kt */
final class ChannelsKt$consumeEach$1 extends CoroutineImpl {
    final /* synthetic */ Function2 $action;
    private Object L$0;
    private Object L$1;
    private ReceiveChannel p$;
    private Function2 p$0;
    final /* synthetic */ ReceiveChannel receiver$0;

    ChannelsKt$consumeEach$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        this.receiver$0 = receiveChannel;
        this.$action = function2;
        super(2, continuation);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object doResume(@org.jetbrains.annotations.Nullable java.lang.Object r6, @org.jetbrains.annotations.Nullable java.lang.Throwable r7) {
        /*
        r5 = this;
        r0 = kotlin.coroutines.experimental.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r1 = r5.label;
        switch(r1) {
            case 0: goto L_0x002d;
            case 1: goto L_0x0024;
            case 2: goto L_0x001b;
            case 3: goto L_0x0011;
            default: goto L_0x0009;
        };
    L_0x0009:
        r6 = new java.lang.IllegalStateException;
        r7 = "call to 'resume' before 'invoke' with coroutine";
        r6.<init>(r7);
        throw r6;
    L_0x0011:
        r6 = r5.L$1;
        r6 = (kotlinx.coroutines.experimental.channels.ChannelIterator) r6;
        r1 = r5.L$0;
        if (r7 != 0) goto L_0x001a;
    L_0x0019:
        goto L_0x0035;
    L_0x001a:
        throw r7;
    L_0x001b:
        r1 = r5.L$0;
        r1 = (kotlinx.coroutines.experimental.channels.ChannelIterator) r1;
        if (r7 != 0) goto L_0x0023;
    L_0x0021:
        r7 = r5;
        goto L_0x005a;
    L_0x0023:
        throw r7;
    L_0x0024:
        r1 = r5.L$0;
        r1 = (kotlinx.coroutines.experimental.channels.ChannelIterator) r1;
        if (r7 != 0) goto L_0x002c;
    L_0x002a:
        r7 = r5;
        goto L_0x0046;
    L_0x002c:
        throw r7;
    L_0x002d:
        if (r7 != 0) goto L_0x006f;
    L_0x002f:
        r6 = r5.receiver$0;
        r6 = r6.iterator();
    L_0x0035:
        r1 = r6;
        r6 = r5;
    L_0x0037:
        r6.L$0 = r1;
        r7 = 1;
        r6.label = r7;
        r7 = r1.hasNext(r6);
        if (r7 != r0) goto L_0x0043;
    L_0x0042:
        return r0;
    L_0x0043:
        r4 = r7;
        r7 = r6;
        r6 = r4;
    L_0x0046:
        r6 = (java.lang.Boolean) r6;
        r6 = r6.booleanValue();
        if (r6 == 0) goto L_0x006c;
    L_0x004e:
        r7.L$0 = r1;
        r6 = 2;
        r7.label = r6;
        r6 = r1.next(r7);
        if (r6 != r0) goto L_0x005a;
    L_0x0059:
        return r0;
    L_0x005a:
        r2 = r7.$action;
        r7.L$0 = r6;
        r7.L$1 = r1;
        r3 = 3;
        r7.label = r3;
        r6 = r2.invoke(r6, r7);
        if (r6 != r0) goto L_0x006a;
    L_0x0069:
        return r0;
    L_0x006a:
        r6 = r7;
        goto L_0x0037;
    L_0x006c:
        r6 = kotlin.Unit.INSTANCE;
        return r6;
    L_0x006f:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.experimental.channels.ChannelsKt$consumeEach$1.doResume(java.lang.Object, java.lang.Throwable):java.lang.Object");
    }
}
