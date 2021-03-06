package kotlinx.coroutines.experimental.channels;

import kotlin.Metadata;
import kotlinx.coroutines.experimental.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ActorJob;", "E", "Lkotlinx/coroutines/experimental/Job;", "Lkotlinx/coroutines/experimental/channels/SendChannel;", "channel", "getChannel", "()Lkotlinx/coroutines/experimental/channels/SendChannel;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: Actor.kt */
public interface ActorJob<E> extends Job, SendChannel<E> {
    @NotNull
    SendChannel<E> getChannel();
}
