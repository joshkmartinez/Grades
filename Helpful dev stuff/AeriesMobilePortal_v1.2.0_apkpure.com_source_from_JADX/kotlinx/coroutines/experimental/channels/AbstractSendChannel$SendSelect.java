package kotlinx.coroutines.experimental.channels;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutinesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.DisposableHandle;
import kotlinx.coroutines.experimental.DisposableHandle.DefaultImpls;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.experimental.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u00022\u00020\u00032\u00020\u0004B>\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00060\nø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0006\u0010\u0014\u001a\u00020\u0011J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0016R+\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n8\u0006X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$SendSelect;", "R", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/channels/Send;", "Lkotlinx/coroutines/experimental/DisposableHandle;", "pollResult", "", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/experimental/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "token", "dispose", "disposeOnSelect", "toString", "", "tryResumeSend", "idempotent", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: AbstractChannel.kt */
final class AbstractSendChannel$SendSelect<R> extends LockFreeLinkedListNode implements Send, DisposableHandle {
    @NotNull
    @JvmField
    public final Function1<Continuation<? super R>, Object> block;
    @Nullable
    private final Object pollResult;
    @NotNull
    @JvmField
    public final SelectInstance<R> select;

    @Deprecated(message = "Replace with `dispose`", replaceWith = @ReplaceWith(expression = "dispose()", imports = {}))
    public void unregister() {
        DefaultImpls.unregister(this);
    }

    @Nullable
    public Object getPollResult() {
        return this.pollResult;
    }

    public AbstractSendChannel$SendSelect(@Nullable Object obj, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        this.pollResult = obj;
        this.select = selectInstance;
        this.block = function1;
    }

    @Nullable
    public Object tryResumeSend(@Nullable Object obj) {
        return this.select.trySelect(obj) != null ? AbstractChannelKt.SELECT_STARTED : null;
    }

    public void completeResumeSend(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "token");
        if ((obj == AbstractChannelKt.SELECT_STARTED ? true : null) != null) {
            CoroutinesKt.startCoroutine(this.block, this.select.getCompletion());
            return;
        }
        throw ((Throwable) new IllegalStateException("Check failed.".toString()));
    }

    public final void disposeOnSelect() {
        this.select.disposeOnSelect(this);
    }

    public void dispose() {
        remove();
    }

    @NotNull
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SendSelect(");
        stringBuilder.append(getPollResult());
        stringBuilder.append(")[");
        stringBuilder.append(this.select);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
