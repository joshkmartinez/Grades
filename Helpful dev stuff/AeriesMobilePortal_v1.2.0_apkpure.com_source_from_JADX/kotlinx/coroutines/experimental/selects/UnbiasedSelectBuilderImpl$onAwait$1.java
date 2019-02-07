package kotlinx.coroutines.experimental.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.experimental.Deferred;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u0000H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "R", "invoke"}, k = 3, mv = {1, 1, 6})
/* compiled from: SelectUnbiased.kt */
final class UnbiasedSelectBuilderImpl$onAwait$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function2 $block;
    final /* synthetic */ Deferred receiver$0;
    final /* synthetic */ UnbiasedSelectBuilderImpl this$0;

    UnbiasedSelectBuilderImpl$onAwait$1(UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl, Deferred deferred, Function2 function2) {
        this.this$0 = unbiasedSelectBuilderImpl;
        this.receiver$0 = deferred;
        this.$block = function2;
        super(0);
    }

    public final void invoke() {
        this.receiver$0.registerSelectAwait(this.this$0.getInstance(), this.$block);
    }
}