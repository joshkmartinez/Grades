package kotlinx.coroutines.experimental.channels;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutinesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.DisposableHandle;
import kotlinx.coroutines.experimental.DisposableHandle.DefaultImpls;
import kotlinx.coroutines.experimental.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0006\b\u0002\u0010\u0002 \u00002\b\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004BD\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012$\u0010\u0007\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0012\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0017J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0006\u0010\u0013\u001a\u00020\u0010J\u0014\u0010\u0014\u001a\u00020\u00102\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J!\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00028\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u001cR3\u0010\u0007\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b8\u0006X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/experimental/channels/AbstractChannel$ReceiveSelect;", "R", "E", "Lkotlinx/coroutines/experimental/channels/Receive;", "Lkotlinx/coroutines/experimental/DisposableHandle;", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/Continuation;", "", "nullOnClose", "", "(Lkotlinx/coroutines/experimental/channels/AbstractChannel;Lkotlinx/coroutines/experimental/selects/SelectInstance;Lkotlin/jvm/functions/Function2;Z)V", "Lkotlin/jvm/functions/Function2;", "completeResumeReceive", "", "token", "dispose", "removeOnSelectCompletion", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/experimental/channels/Closed;", "toString", "", "tryResumeReceive", "value", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: AbstractChannel.kt */
final class AbstractChannel$ReceiveSelect<R, E> extends Receive<E> implements DisposableHandle {
    @NotNull
    @JvmField
    public final Function2<E, Continuation<? super R>, Object> block;
    @JvmField
    public final boolean nullOnClose;
    @NotNull
    @JvmField
    public final SelectInstance<R> select;
    final /* synthetic */ AbstractChannel this$0;

    public AbstractChannel$ReceiveSelect(@NotNull AbstractChannel abstractChannel, @NotNull SelectInstance<? super R> selectInstance, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2, boolean z) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        this.this$0 = abstractChannel;
        this.select = selectInstance;
        this.block = function2;
        this.nullOnClose = z;
    }

    @Deprecated(message = "Replace with `dispose`", replaceWith = @ReplaceWith(expression = "dispose()", imports = {}))
    public void unregister() {
        DefaultImpls.unregister(this);
    }

    @Nullable
    public Object tryResumeReceive(E e, @Nullable Object obj) {
        if (this.select.trySelect(obj) != null) {
            return e != null ? e : AbstractChannelKt.NULL_VALUE;
        } else {
            return null;
        }
    }

    public void completeResumeReceive(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "token");
        if (obj == AbstractChannelKt.NULL_VALUE) {
            obj = null;
        }
        CoroutinesKt.startCoroutine(this.block, obj, this.select.getCompletion());
    }

    public void resumeReceiveClosed(@NotNull Closed<?> closed) {
        Intrinsics.checkParameterIsNotNull(closed, "closed");
        if (!this.select.trySelect(null)) {
            return;
        }
        if (closed.closeCause == null && this.nullOnClose) {
            CoroutinesKt.startCoroutine(this.block, null, this.select.getCompletion());
        } else {
            this.select.resumeSelectWithException(closed.getReceiveException(), 0);
        }
    }

    public final void removeOnSelectCompletion() {
        this.select.disposeOnSelect(this);
    }

    public void dispose() {
        if (remove()) {
            this.this$0.onCancelledReceive();
        }
    }

    @NotNull
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ReceiveSelect[");
        stringBuilder.append(this.select);
        stringBuilder.append(",nullOnClose=");
        stringBuilder.append(this.nullOnClose);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
