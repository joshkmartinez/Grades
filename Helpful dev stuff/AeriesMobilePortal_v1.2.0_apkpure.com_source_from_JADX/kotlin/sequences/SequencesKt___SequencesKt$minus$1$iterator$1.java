package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.BooleanRef;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Z"}, k = 3, mv = {1, 1, 10})
/* compiled from: _Sequences.kt */
final class SequencesKt___SequencesKt$minus$1$iterator$1 extends Lambda implements Function1<T, Boolean> {
    final /* synthetic */ BooleanRef $removed;
    final /* synthetic */ SequencesKt___SequencesKt$minus$1 this$0;

    SequencesKt___SequencesKt$minus$1$iterator$1(SequencesKt___SequencesKt$minus$1 sequencesKt___SequencesKt$minus$1, BooleanRef booleanRef) {
        this.this$0 = sequencesKt___SequencesKt$minus$1;
        this.$removed = booleanRef;
        super(1);
    }

    public final boolean invoke(T t) {
        if (this.$removed.element || Intrinsics.areEqual(t, this.this$0.$element) == null) {
            return true;
        }
        this.$removed.element = true;
        return false;
    }
}
