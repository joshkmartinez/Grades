package io.reactivex.rxkotlin;

import io.reactivex.functions.Function5;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0004\n\u0002\b\u000f\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u00012\u000e\u0010\u0007\u001a\n \b*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\t\u001a\n \b*\u0004\u0018\u0001H\u0003H\u00032\u000e\u0010\n\u001a\n \b*\u0004\u0018\u0001H\u0004H\u00042\u000e\u0010\u000b\u001a\n \b*\u0004\u0018\u0001H\u0005H\u00052\u000e\u0010\f\u001a\n \b*\u0004\u0018\u0001H\u0006H\u0006H\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"<anonymous>", "R", "T", "T1", "T2", "T3", "T4", "t", "kotlin.jvm.PlatformType", "t1", "t2", "t3", "t4", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 6})
/* compiled from: Flowables.kt */
public final class FlowablesKt$withLatestFrom$4<T1, T2, T3, T4, T5, R> implements Function5<T, T1, T2, T3, T4, R> {
    final /* synthetic */ kotlin.jvm.functions.Function5 $combiner;

    public FlowablesKt$withLatestFrom$4(kotlin.jvm.functions.Function5 function5) {
        this.$combiner = function5;
    }

    public final R apply(T t, T1 t1, T2 t2, T3 t3, T4 t4) {
        return this.$combiner.invoke(t, t1, t2, t3, t4);
    }
}
