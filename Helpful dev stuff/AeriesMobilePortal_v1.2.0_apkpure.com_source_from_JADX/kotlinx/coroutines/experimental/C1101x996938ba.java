package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.experimental.JobSupport.Incomplete;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 1, 6})
/* compiled from: Deferred.kt */
final class C1101x996938ba extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CancellableContinuation $cont;
    final /* synthetic */ DeferredCoroutine this$0;

    C1101x996938ba(CancellableContinuation cancellableContinuation, DeferredCoroutine deferredCoroutine) {
        this.$cont = cancellableContinuation;
        this.this$0 = deferredCoroutine;
        super(1);
    }

    public final void invoke(Throwable th) {
        th = this.this$0.getState();
        if ((!(th instanceof Incomplete) ? 1 : null) == null) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (th instanceof JobSupport$CompletedExceptionally) {
            this.$cont.resumeWithException(((JobSupport$CompletedExceptionally) th).getException());
        } else {
            this.$cont.resume(th);
        }
    }
}
