package io.reactivex.rxkotlin;

import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0004\n\u0002\b\t\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00012\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0003H\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "R", "T", "U", "t", "kotlin.jvm.PlatformType", "u", "apply", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 6})
/* compiled from: Singles.kt */
public final class Singles$zip$1<T1, T2, R> implements BiFunction<T, U, R> {
    final /* synthetic */ Function2 $zipper;

    public Singles$zip$1(Function2 function2) {
        this.$zipper = function2;
    }

    public final R apply(T t, U u) {
        return this.$zipper.invoke(t, u);
    }
}
