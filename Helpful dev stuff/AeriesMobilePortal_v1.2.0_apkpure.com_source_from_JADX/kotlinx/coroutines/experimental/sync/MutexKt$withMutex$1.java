package kotlinx.coroutines.experimental.sync;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.experimental.sync.Mutex.DefaultImpls;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, k = 3, mv = {1, 1, 6})
/* compiled from: Mutex.kt */
final class MutexKt$withMutex$1 extends CoroutineImpl {
    final /* synthetic */ Function1 $action;
    private Mutex p$;
    private Function1 p$0;
    final /* synthetic */ Mutex receiver$0;

    MutexKt$withMutex$1(Mutex mutex, Function1 function1, Continuation continuation) {
        this.receiver$0 = mutex;
        this.$action = function1;
        super(2, continuation);
    }

    @Nullable
    public final Object doResume(@Nullable Object obj, @Nullable Throwable th) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                if (th == null) {
                    obj = this.receiver$0;
                    this.label = 1;
                    if (DefaultImpls.lock$default(obj, null, this, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                throw th;
                break;
            case 1:
                if (th == null) {
                    break;
                }
                throw th;
            case 2:
                if (th == null) {
                    break;
                }
                try {
                    throw th;
                } catch (Throwable th2) {
                    DefaultImpls.unlock$default(this.receiver$0, null, 1, null);
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj = this.$action;
        this.label = 2;
        obj = obj.invoke(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        DefaultImpls.unlock$default(this.receiver$0, null, 1, null);
        return obj;
    }
}
