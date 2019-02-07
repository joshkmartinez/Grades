package io.reactivex.rxkotlin;

import io.reactivex.functions.Function3;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0004\n\u0002\b\u000b\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00012\u000e\u0010\u0005\u001a\n \u0006*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u0001H\u0003H\u00032\u000e\u0010\b\u001a\n \u0006*\u0004\u0018\u0001H\u0004H\u0004H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "R", "T", "T1", "T2", "t", "kotlin.jvm.PlatformType", "t1", "t2", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 6})
/* compiled from: Flowables.kt */
public final class FlowablesKt$withLatestFrom$2<T1, T2, T3, R> implements Function3<T, T1, T2, R> {
    final /* synthetic */ kotlin.jvm.functions.Function3 $combiner;

    public FlowablesKt$withLatestFrom$2(kotlin.jvm.functions.Function3 function3) {
        this.$combiner = function3;
    }

    public final R apply(T t, T1 t1, T2 t2) {
        return this.$combiner.invoke(t, t1, t2);
    }
}
