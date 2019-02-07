package io.reactivex.rxkotlin;

import io.reactivex.Flowable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;

@Metadata(bv = {1, 0, 1}, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ao\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072 \b\u0004\u0010\t\u001a\u001a\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00020\nH\b\u001a\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\u000b\"\u0004\b\u0004\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00072&\b\u0004\u0010\t\u001a \u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00020\rH\b\u001a£\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\u000b\"\u0004\b\u0004\u0010\u000e\"\u0004\b\u0005\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00072,\b\u0004\u0010\t\u001a&\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u00020\u0010H\b\u001aU\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00072\u001a\b\u0004\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00020\u0013H\b\u001aU\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00072\u001a\b\u0004\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00020\u0013H\b¨\u0006\u0016"}, d2 = {"withLatestFrom", "Lio/reactivex/Flowable;", "R", "T", "T1", "T2", "o1", "Lorg/reactivestreams/Publisher;", "o2", "combiner", "Lkotlin/Function3;", "T3", "o3", "Lkotlin/Function4;", "T4", "o4", "Lkotlin/Function5;", "U", "other", "Lkotlin/Function2;", "zipWith", "zipper", "rxkotlin_main"}, k = 2, mv = {1, 1, 6})
/* compiled from: Flowables.kt */
public final class FlowablesKt {
    @NotNull
    public static final <T, U, R> Flowable<R> withLatestFrom(@NotNull Flowable<T> flowable, @NotNull Publisher<U> publisher, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(publisher, "other");
        Intrinsics.checkParameterIsNotNull(function2, "combiner");
        flowable = flowable.withLatestFrom(publisher, new FlowablesKt$withLatestFrom$1(function2));
        Intrinsics.checkExpressionValueIsNotNull(flowable, "withLatestFrom(other, Bi…combiner.invoke(t, u)  })");
        return flowable;
    }

    @NotNull
    public static final <T, T1, T2, R> Flowable<R> withLatestFrom(@NotNull Flowable<T> flowable, @NotNull Publisher<T1> publisher, @NotNull Publisher<T2> publisher2, @NotNull Function3<? super T, ? super T1, ? super T2, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(publisher, "o1");
        Intrinsics.checkParameterIsNotNull(publisher2, "o2");
        Intrinsics.checkParameterIsNotNull(function3, "combiner");
        flowable = flowable.withLatestFrom(publisher, publisher2, new FlowablesKt$withLatestFrom$2(function3));
        Intrinsics.checkExpressionValueIsNotNull(flowable, "withLatestFrom(o1, o2, F…iner.invoke(t, t1, t2) })");
        return flowable;
    }

    @NotNull
    public static final <T, T1, T2, T3, R> Flowable<R> withLatestFrom(@NotNull Flowable<T> flowable, @NotNull Publisher<T1> publisher, @NotNull Publisher<T2> publisher2, @NotNull Publisher<T3> publisher3, @NotNull Function4<? super T, ? super T1, ? super T2, ? super T3, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(publisher, "o1");
        Intrinsics.checkParameterIsNotNull(publisher2, "o2");
        Intrinsics.checkParameterIsNotNull(publisher3, "o3");
        Intrinsics.checkParameterIsNotNull(function4, "combiner");
        flowable = flowable.withLatestFrom(publisher, publisher2, publisher3, new FlowablesKt$withLatestFrom$3(function4));
        Intrinsics.checkExpressionValueIsNotNull(flowable, "withLatestFrom(o1, o2, o….invoke(t, t1, t2, t3) })");
        return flowable;
    }

    @NotNull
    public static final <T, T1, T2, T3, T4, R> Flowable<R> withLatestFrom(@NotNull Flowable<T> flowable, @NotNull Publisher<T1> publisher, @NotNull Publisher<T2> publisher2, @NotNull Publisher<T3> publisher3, @NotNull Publisher<T4> publisher4, @NotNull Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(publisher, "o1");
        Intrinsics.checkParameterIsNotNull(publisher2, "o2");
        Intrinsics.checkParameterIsNotNull(publisher3, "o3");
        Intrinsics.checkParameterIsNotNull(publisher4, "o4");
        Intrinsics.checkParameterIsNotNull(function5, "combiner");
        flowable = flowable.withLatestFrom(publisher, publisher2, publisher3, publisher4, new FlowablesKt$withLatestFrom$4(function5));
        Intrinsics.checkExpressionValueIsNotNull(flowable, "withLatestFrom(o1, o2, o…oke(t, t1, t2, t3, t4) })");
        return flowable;
    }

    @NotNull
    public static final <T, U, R> Flowable<R> zipWith(@NotNull Flowable<T> flowable, @NotNull Publisher<U> publisher, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        Intrinsics.checkParameterIsNotNull(publisher, "other");
        Intrinsics.checkParameterIsNotNull(function2, "zipper");
        flowable = flowable.zipWith(publisher, new FlowablesKt$zipWith$1(function2));
        Intrinsics.checkExpressionValueIsNotNull(flowable, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        return flowable;
    }
}
