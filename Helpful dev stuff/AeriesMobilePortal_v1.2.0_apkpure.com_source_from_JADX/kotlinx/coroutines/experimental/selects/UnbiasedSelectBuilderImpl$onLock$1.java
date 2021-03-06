package kotlinx.coroutines.experimental.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.experimental.sync.Mutex;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0000H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "R", "invoke"}, k = 3, mv = {1, 1, 6})
/* compiled from: SelectUnbiased.kt */
final class UnbiasedSelectBuilderImpl$onLock$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $block;
    final /* synthetic */ Object $owner;
    final /* synthetic */ Mutex receiver$0;
    final /* synthetic */ UnbiasedSelectBuilderImpl this$0;

    UnbiasedSelectBuilderImpl$onLock$1(UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl, Mutex mutex, Object obj, Function1 function1) {
        this.this$0 = unbiasedSelectBuilderImpl;
        this.receiver$0 = mutex;
        this.$owner = obj;
        this.$block = function1;
        super(0);
    }

    public final void invoke() {
        this.receiver$0.registerSelectLock(this.this$0.getInstance(), this.$owner, this.$block);
    }
}
