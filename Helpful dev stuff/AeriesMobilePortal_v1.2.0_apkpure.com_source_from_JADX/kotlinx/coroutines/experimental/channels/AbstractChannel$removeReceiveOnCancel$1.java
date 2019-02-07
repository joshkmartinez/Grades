package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.experimental.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "E", "it", "", "invoke"}, k = 3, mv = {1, 1, 6})
/* compiled from: AbstractChannel.kt */
final class AbstractChannel$removeReceiveOnCancel$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CancellableContinuation $cont;
    final /* synthetic */ Receive $receive;
    final /* synthetic */ AbstractChannel this$0;

    AbstractChannel$removeReceiveOnCancel$1(AbstractChannel abstractChannel, CancellableContinuation cancellableContinuation, Receive receive) {
        this.this$0 = abstractChannel;
        this.$cont = cancellableContinuation;
        this.$receive = receive;
        super(1);
    }

    public final void invoke(@Nullable Throwable th) {
        if (this.$cont.isCancelled() != null && this.$receive.remove() != null) {
            this.this$0.onCancelledReceive();
        }
    }
}
