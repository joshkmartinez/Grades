package kotlinx.coroutines.experimental.sync;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.experimental.DisposableHandle;
import kotlinx.coroutines.experimental.DisposableHandle.DefaultImpls;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\"\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H&J\u0006\u0010\t\u001a\u00020\u0007J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H&R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/experimental/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/DisposableHandle;", "owner", "", "(Ljava/lang/Object;)V", "completeResumeLockWaiter", "", "token", "dispose", "tryResumeLockWaiter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: Mutex.kt */
abstract class MutexImpl$LockWaiter extends LockFreeLinkedListNode implements DisposableHandle {
    @Nullable
    @JvmField
    public final Object owner;

    public abstract void completeResumeLockWaiter(@NotNull Object obj);

    @Nullable
    public abstract Object tryResumeLockWaiter();

    @Deprecated(message = "Replace with `dispose`", replaceWith = @ReplaceWith(expression = "dispose()", imports = {}))
    public void unregister() {
        DefaultImpls.unregister(this);
    }

    public MutexImpl$LockWaiter(@Nullable Object obj) {
        this.owner = obj;
    }

    public final void dispose() {
        remove();
    }
}
