package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CancellableContinuation;
import kotlinx.coroutines.experimental.CancellableContinuationImpl;
import kotlinx.coroutines.experimental.CancellableContinuationKt;
import kotlinx.coroutines.experimental.JobKt;
import kotlinx.coroutines.experimental.internal.AtomicDesc;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode$AddLastDesc;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode$CondAddOp;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode$RemoveFirstDesc;
import kotlinx.coroutines.experimental.intrinsics.UndispatchedKt;
import kotlinx.coroutines.experimental.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0006<=>?@AB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J!\u0010\u0019\u001a\u000e\u0012\u0002\b\u00030\u001aj\u0006\u0012\u0002\b\u0003`\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u001dJ!\u0010\u001e\u001a\u000e\u0012\u0002\b\u00030\u001aj\u0006\u0012\u0002\b\u0003`\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u001dJ\u001b\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0006\u0010\u001c\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$H\u0002J\u0013\u0010%\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010&J\u0015\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010)J!\u0010*\u001a\u00020(2\u0006\u0010\u001c\u001a\u00028\u00002\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,H\u0014¢\u0006\u0002\u0010-JJ\u0010.\u001a\u00020\u0015\"\u0004\b\u0001\u0010/2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H/0,2\u0006\u0010\u001c\u001a\u00028\u00002\u001c\u00100\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H/02\u0012\u0006\u0012\u0004\u0018\u00010(01H\u0016ø\u0001\u0000¢\u0006\u0002\u00103J\u0019\u0010#\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u00104J\u0015\u00105\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010&J\u0015\u00106\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010&J\u0019\u00107\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u00104J\u0010\u00108\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000109H\u0004J\n\u0010:\u001a\u0004\u0018\u00010;H\u0004R\u001a\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00058DX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00058DX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u000bX¤\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0012\u0010\r\u001a\u00020\u000bX¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0002\u0004\n\u0002\b\t¨\u0006B"}, d2 = {"Lkotlinx/coroutines/experimental/channels/AbstractSendChannel;", "E", "Lkotlinx/coroutines/experimental/channels/SendChannel;", "()V", "closedForReceive", "Lkotlinx/coroutines/experimental/channels/Closed;", "getClosedForReceive", "()Lkotlinx/coroutines/experimental/channels/Closed;", "closedForSend", "getClosedForSend", "isBufferAlwaysFull", "", "()Z", "isBufferFull", "isClosedForSend", "isFull", "queue", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;", "getQueue", "()Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;", "afterClose", "", "cause", "", "close", "describeSendBuffered", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/experimental/internal/AddLastDesc;", "element", "(Ljava/lang/Object;)Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AddLastDesc;", "describeSendConflated", "describeTryOffer", "Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$TryOfferDesc;", "(Ljava/lang/Object;)Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$TryOfferDesc;", "enqueueSend", "send", "Lkotlinx/coroutines/experimental/channels/SendElement;", "offer", "(Ljava/lang/Object;)Z", "offerInternal", "", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/experimental/selects/SelectInstance;)Ljava/lang/Object;", "registerSelectSend", "R", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "(Lkotlinx/coroutines/experimental/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "sendBuffered", "sendConflated", "sendSuspend", "takeFirstReceiveOrPeekClosed", "Lkotlinx/coroutines/experimental/channels/ReceiveOrClosed;", "takeFirstSendOrPeekClosed", "Lkotlinx/coroutines/experimental/channels/Send;", "SendBuffered", "SendBufferedDesc", "SendConflatedDesc", "SendSelect", "TryEnqueueSendDesc", "TryOfferDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: AbstractChannel.kt */
public abstract class AbstractSendChannel<E> implements SendChannel<E> {
    @NotNull
    private final LockFreeLinkedListHead queue = new LockFreeLinkedListHead();

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016R\u0012\u0010\u0004\u001a\u00028\u00018\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$SendBuffered;", "E", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/experimental/channels/Send;", "element", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "pollResult", "", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "token", "tryResumeSend", "idempotent", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: AbstractChannel.kt */
    private static final class SendBuffered<E> extends LockFreeLinkedListNode implements Send {
        @JvmField
        public final E element;

        public SendBuffered(E e) {
            this.element = e;
        }

        @Nullable
        public Object getPollResult() {
            return this.element;
        }

        @Nullable
        public Object tryResumeSend(@Nullable Object obj) {
            return AbstractChannelKt.SEND_RESUMED;
        }

        public void completeResumeSend(@NotNull Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "token");
            if ((obj == AbstractChannelKt.SEND_RESUMED ? true : null) == null) {
                throw ((Throwable) new IllegalStateException("Check failed.".toString()));
            }
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0001¢\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0014¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$SendBufferedDesc;", "E", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$SendBuffered;", "Lkotlinx/coroutines/experimental/internal/AddLastDesc;", "queue", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;", "element", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "failure", "", "affected", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: AbstractChannel.kt */
    private static class SendBufferedDesc<E> extends LockFreeLinkedListNode$AddLastDesc<SendBuffered<? extends E>> {
        public SendBufferedDesc(@NotNull LockFreeLinkedListHead lockFreeLinkedListHead, E e) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListHead, "queue");
            super(lockFreeLinkedListHead, new SendBuffered(e));
        }

        @Nullable
        protected Object failure(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            return (lockFreeLinkedListNode instanceof ReceiveOrClosed) != null ? AbstractChannelKt.OFFER_FAILED : null;
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004`\u0005B<\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\b\u0012\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0014J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014\u0002\u0004\n\u0002\b\t¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$TryEnqueueSendDesc;", "E", "R", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$SendSelect;", "Lkotlinx/coroutines/experimental/internal/AddLastDesc;", "element", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "", "(Lkotlinx/coroutines/experimental/channels/AbstractSendChannel;Ljava/lang/Object;Lkotlinx/coroutines/experimental/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "failure", "affected", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "next", "finishOnSuccess", "", "onPrepare", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: AbstractChannel.kt */
    private final class TryEnqueueSendDesc<E, R> extends LockFreeLinkedListNode$AddLastDesc<SendSelect<R>> {
        final /* synthetic */ AbstractSendChannel this$0;

        public TryEnqueueSendDesc(AbstractSendChannel abstractSendChannel, @NotNull E e, @NotNull SelectInstance<? super R> selectInstance, Function1<? super Continuation<? super R>, ? extends Object> function1) {
            Intrinsics.checkParameterIsNotNull(selectInstance, "select");
            Intrinsics.checkParameterIsNotNull(function1, "block");
            this.this$0 = abstractSendChannel;
            super(abstractSendChannel.getQueue(), new SendSelect(e, selectInstance, function1));
        }

        @Nullable
        protected Object failure(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            if ((lockFreeLinkedListNode instanceof ReceiveOrClosed) == null) {
                return null;
            }
            if ((lockFreeLinkedListNode instanceof Closed) == null) {
                lockFreeLinkedListNode = null;
            }
            lockFreeLinkedListNode = (Closed) lockFreeLinkedListNode;
            if (lockFreeLinkedListNode == null) {
                lockFreeLinkedListNode = AbstractChannelKt.ENQUEUE_FAILED;
            }
            return lockFreeLinkedListNode;
        }

        @Nullable
        protected Object onPrepare(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            if (this.this$0.isBufferFull()) {
                return super.onPrepare(lockFreeLinkedListNode, lockFreeLinkedListNode2);
            }
            return AbstractChannelKt.ENQUEUE_FAILED;
        }

        protected void finishOnSuccess(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            super.finishOnSuccess(lockFreeLinkedListNode, lockFreeLinkedListNode2);
            ((SendSelect) this.node).disposeOnSelect();
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014J\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0014R\u0012\u0010\u0005\u001a\u00028\u00018\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$TryOfferDesc;", "E", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/experimental/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/experimental/internal/RemoveFirstDesc;", "element", "queue", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;", "(Ljava/lang/Object;Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;)V", "Ljava/lang/Object;", "resumeToken", "", "failure", "affected", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "next", "validatePrepared", "", "node", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: AbstractChannel.kt */
    protected static final class TryOfferDesc<E> extends LockFreeLinkedListNode$RemoveFirstDesc<ReceiveOrClosed<? super E>> {
        @JvmField
        public final E element;
        @Nullable
        @JvmField
        public Object resumeToken;

        public TryOfferDesc(E e, @NotNull LockFreeLinkedListHead lockFreeLinkedListHead) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListHead, "queue");
            super(lockFreeLinkedListHead);
            this.element = e;
        }

        @Nullable
        protected Object failure(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            if ((lockFreeLinkedListNode instanceof ReceiveOrClosed) == null) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            return (lockFreeLinkedListNode instanceof Closed) != null ? lockFreeLinkedListNode : null;
        }

        protected boolean validatePrepared(@NotNull ReceiveOrClosed<? super E> receiveOrClosed) {
            Intrinsics.checkParameterIsNotNull(receiveOrClosed, "node");
            receiveOrClosed = receiveOrClosed.tryResumeReceive(this.element, this);
            if (receiveOrClosed == null) {
                return null;
            }
            this.resumeToken = receiveOrClosed;
            return true;
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0014¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$SendConflatedDesc;", "E", "Lkotlinx/coroutines/experimental/channels/AbstractSendChannel$SendBufferedDesc;", "queue", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;", "element", "(Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "finishOnSuccess", "", "affected", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: AbstractChannel.kt */
    private static final class SendConflatedDesc<E> extends SendBufferedDesc<E> {
        public SendConflatedDesc(@NotNull LockFreeLinkedListHead lockFreeLinkedListHead, E e) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListHead, "queue");
            super(lockFreeLinkedListHead, e);
        }

        protected void finishOnSuccess(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            super.finishOnSuccess(lockFreeLinkedListNode, lockFreeLinkedListNode2);
            if ((lockFreeLinkedListNode instanceof SendBuffered) != null) {
                lockFreeLinkedListNode.remove();
            }
        }
    }

    protected void afterClose(@Nullable Throwable th) {
    }

    protected abstract boolean isBufferAlwaysFull();

    protected abstract boolean isBufferFull();

    @NotNull
    protected final LockFreeLinkedListHead getQueue() {
        return this.queue;
    }

    @NotNull
    protected Object offerInternal(E e) {
        Object tryResumeReceive;
        ReceiveOrClosed takeFirstReceiveOrPeekClosed;
        do {
            takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
            if (takeFirstReceiveOrPeekClosed == null) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(e, null);
        } while (tryResumeReceive == null);
        takeFirstReceiveOrPeekClosed.completeResumeReceive(tryResumeReceive);
        return takeFirstReceiveOrPeekClosed.getOfferResult();
    }

    @NotNull
    protected Object offerSelectInternal(E e, @NotNull SelectInstance<?> selectInstance) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        e = describeTryOffer(e);
        selectInstance = selectInstance.performAtomicTrySelect((AtomicDesc) e);
        if (selectInstance != null) {
            return selectInstance;
        }
        ReceiveOrClosed receiveOrClosed = (ReceiveOrClosed) e.getResult();
        e = e.resumeToken;
        if (e == null) {
            Intrinsics.throwNpe();
        }
        receiveOrClosed.completeResumeReceive(e);
        return receiveOrClosed.getOfferResult();
    }

    @Nullable
    protected final Closed<?> getClosedForSend() {
        Object prev = this.queue.getPrev();
        if (!(prev instanceof Closed)) {
            prev = null;
        }
        return (Closed) prev;
    }

    @Nullable
    protected final Closed<?> getClosedForReceive() {
        Object next = this.queue.getNext();
        if (!(next instanceof Closed)) {
            next = null;
        }
        return (Closed) next;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @org.jetbrains.annotations.Nullable
    protected final kotlinx.coroutines.experimental.channels.Send takeFirstSendOrPeekClosed() {
        /*
        r4 = this;
        r0 = r4.queue;
    L_0x0002:
        r1 = r0.getNext();
        if (r1 == 0) goto L_0x002c;
    L_0x0008:
        r1 = (kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode) r1;
        r2 = r0;
        r2 = (kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode) r2;
        r3 = 0;
        if (r1 != r2) goto L_0x0011;
    L_0x0010:
        goto L_0x0025;
    L_0x0011:
        r2 = r1 instanceof kotlinx.coroutines.experimental.channels.Send;
        if (r2 != 0) goto L_0x0016;
    L_0x0015:
        goto L_0x0025;
    L_0x0016:
        r2 = r1;
        r2 = (kotlinx.coroutines.experimental.channels.Send) r2;
        r2 = r2 instanceof kotlinx.coroutines.experimental.channels.Closed;
        if (r2 == 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0024;
    L_0x001e:
        r2 = r1.remove();
        if (r2 == 0) goto L_0x0028;
    L_0x0024:
        r3 = r1;
    L_0x0025:
        r3 = (kotlinx.coroutines.experimental.channels.Send) r3;
        return r3;
    L_0x0028:
        r1.helpDelete();
        goto L_0x0002;
    L_0x002c:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.experimental.channels.AbstractSendChannel.takeFirstSendOrPeekClosed():kotlinx.coroutines.experimental.channels.Send");
    }

    protected final boolean sendBuffered(E e) {
        LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
        LockFreeLinkedListNode sendBuffered = new SendBuffered(e);
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        do {
            e = lockFreeLinkedListNode.getPrev();
            if (e != null) {
                lockFreeLinkedListNode2 = (LockFreeLinkedListNode) e;
                if (!(!(lockFreeLinkedListNode2 instanceof ReceiveOrClosed))) {
                    return false;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        } while (lockFreeLinkedListNode2.addNext(sendBuffered, lockFreeLinkedListNode) == null);
        return true;
    }

    protected final boolean sendConflated(E e) {
        SendBuffered sendBuffered = new SendBuffered(e);
        e = this.queue;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            Object prev = e.getPrev();
            if (prev != null) {
                lockFreeLinkedListNode = (LockFreeLinkedListNode) prev;
                if (!(!(lockFreeLinkedListNode instanceof ReceiveOrClosed))) {
                    e = null;
                    break;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        } while (!lockFreeLinkedListNode.addNext(sendBuffered, e));
        e = 1;
        if (e == null) {
            return false;
        }
        e = sendBuffered.getPrev();
        if (e instanceof SendBuffered) {
            ((SendBuffered) e).remove();
        }
        return true;
    }

    @NotNull
    protected final LockFreeLinkedListNode$AddLastDesc<?> describeSendBuffered(E e) {
        return new SendBufferedDesc(this.queue, e);
    }

    @NotNull
    protected final LockFreeLinkedListNode$AddLastDesc<?> describeSendConflated(E e) {
        return new SendConflatedDesc(this.queue, e);
    }

    public final boolean isClosedForSend() {
        return getClosedForSend() != null;
    }

    public final boolean isFull() {
        return !(this.queue.getNext() instanceof ReceiveOrClosed) && isBufferFull();
    }

    @Nullable
    public final Object send(E e, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
        if (offer(e)) {
            return Unit.INSTANCE;
        }
        return sendSuspend(e, continuation);
    }

    public final boolean offer(E e) {
        e = offerInternal(e);
        if (e == AbstractChannelKt.OFFER_SUCCESS) {
            return true;
        }
        if (e == AbstractChannelKt.OFFER_FAILED) {
            return null;
        }
        if (e instanceof Closed) {
            throw ((Closed) e).getSendException();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("offerInternal returned ");
        stringBuilder.append(e);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    private final boolean enqueueSend(SendElement sendElement) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        if (isBufferAlwaysFull()) {
            lockFreeLinkedListNode = this.queue;
            LockFreeLinkedListNode lockFreeLinkedListNode2;
            do {
                Object prev = lockFreeLinkedListNode.getPrev();
                if (prev != null) {
                    lockFreeLinkedListNode2 = (LockFreeLinkedListNode) prev;
                    if (!(lockFreeLinkedListNode2 instanceof ReceiveOrClosed)) {
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
                }
            } while (!lockFreeLinkedListNode2.addNext(sendElement, lockFreeLinkedListNode));
            return true;
        }
        lockFreeLinkedListNode = this.queue;
        LockFreeLinkedListNode lockFreeLinkedListNode3 = sendElement;
        LockFreeLinkedListNode$CondAddOp abstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1 = new AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1(lockFreeLinkedListNode3, lockFreeLinkedListNode3, this);
        while (true) {
            Object prev2 = lockFreeLinkedListNode.getPrev();
            if (prev2 != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode4 = (LockFreeLinkedListNode) prev2;
                if (!(lockFreeLinkedListNode4 instanceof ReceiveOrClosed)) {
                    switch (lockFreeLinkedListNode4.tryCondAddNext(lockFreeLinkedListNode3, lockFreeLinkedListNode, abstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1)) {
                        case 1:
                            return true;
                        case 2:
                            break;
                        default:
                    }
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
            }
        }
        return false;
    }

    public boolean close(@Nullable Throwable th) {
        Closed closed = new Closed(th);
        while (true) {
            ReceiveOrClosed takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
            boolean z = false;
            if (takeFirstReceiveOrPeekClosed == null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
                LockFreeLinkedListNode lockFreeLinkedListNode2;
                do {
                    Object prev = lockFreeLinkedListNode.getPrev();
                    if (prev != null) {
                        lockFreeLinkedListNode2 = (LockFreeLinkedListNode) prev;
                        if (!(!(lockFreeLinkedListNode2 instanceof ReceiveOrClosed))) {
                            break;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */");
                    }
                } while (!lockFreeLinkedListNode2.addNext(closed, lockFreeLinkedListNode));
                z = true;
                if (z) {
                    afterClose(th);
                    return true;
                }
            } else if (takeFirstReceiveOrPeekClosed instanceof Closed) {
                return false;
            } else {
                ((Receive) takeFirstReceiveOrPeekClosed).resumeReceiveClosed(closed);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @org.jetbrains.annotations.Nullable
    protected final kotlinx.coroutines.experimental.channels.ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        /*
        r4 = this;
        r0 = r4.queue;
    L_0x0002:
        r1 = r0.getNext();
        if (r1 == 0) goto L_0x002c;
    L_0x0008:
        r1 = (kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode) r1;
        r2 = r0;
        r2 = (kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode) r2;
        r3 = 0;
        if (r1 != r2) goto L_0x0011;
    L_0x0010:
        goto L_0x0025;
    L_0x0011:
        r2 = r1 instanceof kotlinx.coroutines.experimental.channels.ReceiveOrClosed;
        if (r2 != 0) goto L_0x0016;
    L_0x0015:
        goto L_0x0025;
    L_0x0016:
        r2 = r1;
        r2 = (kotlinx.coroutines.experimental.channels.ReceiveOrClosed) r2;
        r2 = r2 instanceof kotlinx.coroutines.experimental.channels.Closed;
        if (r2 == 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0024;
    L_0x001e:
        r2 = r1.remove();
        if (r2 == 0) goto L_0x0028;
    L_0x0024:
        r3 = r1;
    L_0x0025:
        r3 = (kotlinx.coroutines.experimental.channels.ReceiveOrClosed) r3;
        return r3;
    L_0x0028:
        r1.helpDelete();
        goto L_0x0002;
    L_0x002c:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type kotlinx.coroutines.experimental.internal.Node /* = kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode */";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.experimental.channels.AbstractSendChannel.takeFirstReceiveOrPeekClosed():kotlinx.coroutines.experimental.channels.ReceiveOrClosed<E>");
    }

    @NotNull
    protected final TryOfferDesc<E> describeTryOffer(E e) {
        return new TryOfferDesc(e, this.queue);
    }

    public <R> void registerSelectSend(@NotNull SelectInstance<? super R> selectInstance, E e, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        while (!selectInstance.isSelected()) {
            if (isFull()) {
                Object performAtomicIfNotSelected = selectInstance.performAtomicIfNotSelected(new TryEnqueueSendDesc(this, e, selectInstance, function1));
                if (performAtomicIfNotSelected != null && performAtomicIfNotSelected != JobKt.getALREADY_SELECTED()) {
                    if (performAtomicIfNotSelected != AbstractChannelKt.ENQUEUE_FAILED) {
                        if ((performAtomicIfNotSelected instanceof Closed) != null) {
                            throw ((Closed) performAtomicIfNotSelected).getSendException();
                        }
                        selectInstance = new StringBuilder();
                        selectInstance.append("performAtomicIfNotSelected(TryEnqueueSendDesc) returned ");
                        selectInstance.append(performAtomicIfNotSelected);
                        throw ((Throwable) new IllegalStateException(selectInstance.toString().toString()));
                    }
                } else {
                    return;
                }
            }
            E offerSelectInternal = offerSelectInternal(e, selectInstance);
            if (offerSelectInternal != JobKt.getALREADY_SELECTED()) {
                if (offerSelectInternal != AbstractChannelKt.OFFER_FAILED) {
                    if (offerSelectInternal == AbstractChannelKt.OFFER_SUCCESS) {
                        UndispatchedKt.startCoroutineUndispatched(function1, selectInstance.getCompletion());
                        return;
                    } else if ((offerSelectInternal instanceof Closed) != null) {
                        throw ((Closed) offerSelectInternal).getSendException();
                    } else {
                        selectInstance = new StringBuilder();
                        selectInstance.append("offerSelectInternal returned ");
                        selectInstance.append(offerSelectInternal);
                        throw ((Throwable) new IllegalStateException(selectInstance.toString().toString()));
                    }
                }
            } else {
                return;
            }
        }
    }

    private final Object sendSuspend(E e, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(CoroutineIntrinsics.normalizeContinuation(continuation), true);
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        SendElement sendElement = new SendElement(e, cancellableContinuation);
        while (!enqueueSend(sendElement)) {
            Object offerInternal = offerInternal(e);
            if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
                cancellableContinuation.resume(Unit.INSTANCE);
                break;
            } else if (offerInternal != AbstractChannelKt.OFFER_FAILED) {
                if ((offerInternal instanceof Closed) != null) {
                    cancellableContinuation.resumeWithException(((Closed) offerInternal).getSendException());
                } else {
                    e = new StringBuilder();
                    e.append("offerInternal returned ");
                    e.append(offerInternal);
                    throw ((Throwable) new IllegalStateException(e.toString().toString()));
                }
            }
        }
        cancellableContinuation.initCancellability();
        CancellableContinuationKt.removeOnCancel(cancellableContinuation, sendElement);
        return cancellableContinuationImpl.getResult();
    }
}
