package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.experimental.internal.LockFreeLinkedListNode;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\"\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/experimental/EventLoopImpl$QueuedTask;", "Lkotlinx/coroutines/experimental/internal/LockFreeLinkedListNode;", "Lkotlin/Function0;", "", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 6})
/* compiled from: EventLoop.kt */
abstract class EventLoopImpl$QueuedTask extends LockFreeLinkedListNode implements Function0<Unit> {
}
