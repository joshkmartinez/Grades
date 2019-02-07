package kotlinx.coroutines.experimental.channels;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.internal.Symbol;
import kotlinx.coroutines.experimental.intrinsics.UndispatchedKt;
import kotlinx.coroutines.experimental.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 4*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u00043456B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J=\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u00162\u0014\u0010\u0018\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0017\u0018\u00010\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0002¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J\u0016\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0003J\u0015\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0017\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010!\u001a\u00028\u0000H\u0003¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0017JJ\u0010(\u001a\u00020\u001f\"\u0004\b\u0001\u0010)2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H)0+2\u0006\u0010!\u001a\u00028\u00002\u001c\u0010,\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H)0.\u0012\u0006\u0012\u0004\u0018\u00010\u000b0-H\u0016ø\u0001\u0000¢\u0006\u0002\u0010/J=\u00100\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0017\u0018\u00010\u00162\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0003¢\u0006\u0002\u0010\u001aJ\u0019\u00101\u001a\u00020\u001f2\u0006\u0010!\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u00102R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0018\u0010\n\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0005R\u0012\u0010\r\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00028\u00008FX\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00018\u00008FX\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0011\u0002\u0004\n\u0002\b\t¨\u00067"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel;", "E", "Lkotlinx/coroutines/experimental/channels/BroadcastChannel;", "value", "(Ljava/lang/Object;)V", "()V", "isClosedForSend", "", "()Z", "isFull", "state", "", "state$annotations", "updating", "", "value$annotations", "getValue", "()Ljava/lang/Object;", "valueOrNull", "valueOrNull$annotations", "getValueOrNull", "addSubscriber", "", "Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Subscriber;", "list", "subscriber", "([Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Subscriber;Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Subscriber;)[Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Subscriber;", "close", "cause", "", "closeSubscriber", "", "offer", "element", "(Ljava/lang/Object;)Z", "offerInternal", "Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Closed;", "(Ljava/lang/Object;)Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Closed;", "open", "Lkotlinx/coroutines/experimental/channels/SubscriptionReceiveChannel;", "registerSelectSend", "R", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "(Lkotlinx/coroutines/experimental/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "removeSubscriber", "send", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "Closed", "Companion", "State", "Subscriber", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: ConflatedBroadcastChannel.kt */
public final class ConflatedBroadcastChannel<E> implements BroadcastChannel<E> {
    @NotNull
    @JvmField
    public static final Closed CLOSED = new Closed(null);
    public static final Companion Companion = new Companion();
    @NotNull
    @JvmField
    public static final State<Object> INITIAL_STATE = new State(UNDEFINED, null);
    @NotNull
    @JvmField
    public static final AtomicReferenceFieldUpdater<ConflatedBroadcastChannel<?>, Object> STATE;
    @NotNull
    @JvmField
    public static final Symbol UNDEFINED = new Symbol("UNDEFINED");
    @NotNull
    @JvmField
    public static final AtomicIntegerFieldUpdater<ConflatedBroadcastChannel<?>> UPDATING;
    private volatile Object state;
    private volatile int updating;

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Closed;", "", "closeCause", "", "(Ljava/lang/Throwable;)V", "sendException", "getSendException", "()Ljava/lang/Throwable;", "valueException", "getValueException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: ConflatedBroadcastChannel.kt */
    private static final class Closed {
        @Nullable
        @JvmField
        public final Throwable closeCause;

        public Closed(@Nullable Throwable th) {
            this.closeCause = th;
        }

        @NotNull
        public final Throwable getSendException() {
            Throwable th = this.closeCause;
            return th != null ? th : new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        }

        @NotNull
        public final Throwable getValueException() {
            Throwable th = this.closeCause;
            return th != null ? th : new IllegalStateException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00010\b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\r8\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Companion;", "", "()V", "CLOSED", "Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Closed;", "INITIAL_STATE", "Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$State;", "STATE", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel;", "UNDEFINED", "Lkotlinx/coroutines/experimental/internal/Symbol;", "UPDATING", "Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: ConflatedBroadcastChannel.kt */
    private static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R \u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$State;", "E", "", "value", "subscribers", "", "Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Subscriber;", "(Ljava/lang/Object;[Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Subscriber;)V", "[Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Subscriber;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: ConflatedBroadcastChannel.kt */
    private static final class State<E> {
        @Nullable
        @JvmField
        public final Subscriber<E>[] subscribers;
        @Nullable
        @JvmField
        public final Object value;

        public State(@Nullable Object obj, @Nullable Subscriber<E>[] subscriberArr) {
            this.value = obj;
            this.subscribers = subscriberArr;
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/experimental/channels/ConflatedChannel;", "Lkotlinx/coroutines/experimental/channels/SubscriptionReceiveChannel;", "broadcastChannel", "Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel;", "(Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel;)V", "close", "", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
    /* compiled from: ConflatedBroadcastChannel.kt */
    private static final class Subscriber<E> extends ConflatedChannel<E> implements SubscriptionReceiveChannel<E> {
        private final ConflatedBroadcastChannel<E> broadcastChannel;

        public Subscriber(@NotNull ConflatedBroadcastChannel<E> conflatedBroadcastChannel) {
            Intrinsics.checkParameterIsNotNull(conflatedBroadcastChannel, "broadcastChannel");
            this.broadcastChannel = conflatedBroadcastChannel;
        }

        public void close() {
            if (close(null)) {
                this.broadcastChannel.closeSubscriber(this);
            }
        }

        @NotNull
        public Object offerInternal(E e) {
            return super.offerInternal(e);
        }
    }

    private static /* synthetic */ void state$annotations() {
    }

    public static /* synthetic */ void value$annotations() {
    }

    public static /* synthetic */ void valueOrNull$annotations() {
    }

    public boolean isFull() {
        return false;
    }

    public ConflatedBroadcastChannel() {
        this.state = INITIAL_STATE;
    }

    public ConflatedBroadcastChannel(E e) {
        this();
        this.state = new State(e, null);
    }

    static {
        AtomicReferenceFieldUpdater newUpdater = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "state");
        Intrinsics.checkExpressionValueIsNotNull(newUpdater, "AtomicReferenceFieldUpda…Any::class.java, \"state\")");
        STATE = newUpdater;
        AtomicIntegerFieldUpdater newUpdater2 = AtomicIntegerFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, "updating");
        Intrinsics.checkExpressionValueIsNotNull(newUpdater2, "AtomicIntegerFieldUpdate…::class.java, \"updating\")");
        UPDATING = newUpdater2;
    }

    public final E getValue() {
        Object obj = this.state;
        if (obj instanceof Closed) {
            throw ((Closed) obj).getValueException();
        } else if (obj instanceof State) {
            State state = (State) obj;
            if (state.value != UNDEFINED) {
                return state.value;
            }
            throw new IllegalStateException("No value");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid state ");
            stringBuilder.append(obj);
            throw new IllegalStateException(stringBuilder.toString().toString());
        }
    }

    @Nullable
    public final E getValueOrNull() {
        Object obj = this.state;
        if (obj instanceof Closed) {
            return null;
        }
        if (obj instanceof State) {
            State state = (State) obj;
            if (state.value == UNDEFINED) {
                return null;
            }
            return state.value;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid state ");
        stringBuilder.append(obj);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    public boolean isClosedForSend() {
        return this.state instanceof Closed;
    }

    @NotNull
    public SubscriptionReceiveChannel<E> open() {
        Subscriber subscriber = new Subscriber(this);
        Object obj;
        Object obj2;
        State state;
        do {
            obj = this.state;
            if (obj instanceof Closed) {
                subscriber.close(((Closed) obj).closeCause);
                return subscriber;
            } else if (obj instanceof State) {
                state = (State) obj;
                if (state.value != UNDEFINED) {
                    subscriber.offerInternal(state.value);
                }
                obj2 = state.value;
                if (obj != null) {
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.channels.ConflatedBroadcastChannel.State<E>");
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid state ");
                stringBuilder.append(obj);
                throw new IllegalStateException(stringBuilder.toString().toString());
            }
        } while (!STATE.compareAndSet(this, obj, new State(obj2, addSubscriber(state.subscribers, subscriber))));
        return subscriber;
    }

    private final void closeSubscriber(Subscriber<E> subscriber) {
        Object obj;
        Object obj2;
        Subscriber[] subscriberArr;
        do {
            obj = this.state;
            if (!(obj instanceof Closed)) {
                if (obj instanceof State) {
                    State state = (State) obj;
                    obj2 = state.value;
                    if (obj != null) {
                        subscriberArr = state.subscribers;
                        if (subscriberArr == null) {
                            Intrinsics.throwNpe();
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.channels.ConflatedBroadcastChannel.State<E>");
                    }
                }
                subscriber = new StringBuilder();
                subscriber.append("Invalid state ");
                subscriber.append(obj);
                throw new IllegalStateException(subscriber.toString().toString());
            }
            return;
        } while (!STATE.compareAndSet(this, obj, new State(obj2, removeSubscriber(subscriberArr, subscriber))));
    }

    private final Subscriber<E>[] removeSubscriber(Subscriber<E>[] subscriberArr, Subscriber<E> subscriber) {
        Object[] objArr = (Object[]) subscriberArr;
        int length = objArr.length;
        subscriber = ArraysKt___ArraysKt.indexOf(objArr, (Object) subscriber);
        if ((subscriber >= null ? 1 : 0) == 0) {
            throw ((Throwable) new IllegalStateException("Check failed.".toString()));
        } else if (length == 1) {
            return null;
        } else {
            Object obj = new Subscriber[(length - 1)];
            System.arraycopy(subscriberArr, 0, obj, 0, subscriber);
            System.arraycopy(subscriberArr, subscriber + 1, obj, subscriber, (length - subscriber) - 1);
            return obj;
        }
    }

    public boolean close(@Nullable Throwable th) {
        Object obj;
        do {
            obj = this.state;
            int i = 0;
            if (obj instanceof Closed) {
                return false;
            }
            if (!(obj instanceof State)) {
                th = new StringBuilder();
                th.append("Invalid state ");
                th.append(obj);
                throw new IllegalStateException(th.toString().toString());
            }
        } while (!STATE.compareAndSet(this, obj, th == null ? CLOSED : new Closed(th)));
        if (obj != null) {
            Subscriber[] subscriberArr = ((State) obj).subscribers;
            if (subscriberArr != null) {
                Object[] objArr = (Object[]) subscriberArr;
                while (i < objArr.length) {
                    ((Subscriber) objArr[i]).close(th);
                    i++;
                }
            }
            return true;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.channels.ConflatedBroadcastChannel.State<E>");
    }

    @Nullable
    public Object send(E e, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
        e = offerInternal(e);
        if (e == null) {
            return Unit.INSTANCE;
        }
        throw e.getSendException();
    }

    public boolean offer(E e) {
        e = offerInternal(e);
        if (e == null) {
            return true;
        }
        throw e.getSendException();
    }

    private final Closed offerInternal(E e) {
        if (!UPDATING.compareAndSet(this, 0, 1)) {
            return null;
        }
        Object obj;
        do {
            obj = this.state;
            if (obj instanceof Closed) {
                Closed closed = (Closed) obj;
                this.updating = 0;
                return closed;
            }
            try {
                if (!(obj instanceof State)) {
                    e = new StringBuilder();
                    e.append("Invalid state ");
                    e.append(obj);
                    throw new IllegalStateException(e.toString().toString());
                } else if (obj != null) {
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.channels.ConflatedBroadcastChannel.State<E>");
                }
            } catch (Throwable th) {
                this.updating = 0;
            }
        } while (!STATE.compareAndSet(this, obj, new State(e, ((State) obj).subscribers)));
        Subscriber[] subscriberArr = ((State) obj).subscribers;
        if (subscriberArr != null) {
            Object[] objArr = (Object[]) subscriberArr;
            for (Object obj2 : objArr) {
                ((Subscriber) obj2).offerInternal(e);
            }
        }
        this.updating = 0;
        return null;
    }

    public <R> void registerSelectSend(@NotNull SelectInstance<? super R> selectInstance, E e, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        if (selectInstance.trySelect(null)) {
            e = offerInternal(e);
            if (e != null) {
                selectInstance.resumeSelectWithException(e.getSendException(), 2);
            } else {
                UndispatchedKt.startCoroutineUndispatched(function1, selectInstance.getCompletion());
            }
        }
    }

    private final Subscriber<E>[] addSubscriber(Subscriber<E>[] subscriberArr, Subscriber<E> subscriber) {
        if (subscriberArr != null) {
            return (Subscriber[]) ArraysKt___ArraysKt.plus((Object[]) subscriberArr, (Object) subscriber);
        }
        return new Subscriber[]{subscriber};
    }
}
