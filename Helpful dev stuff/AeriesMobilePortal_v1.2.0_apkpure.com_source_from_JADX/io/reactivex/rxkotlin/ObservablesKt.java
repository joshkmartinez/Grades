package io.reactivex.rxkotlin;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ao\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072 \b\u0004\u0010\t\u001a\u001a\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00020\nH\b\u001a\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\u000b\"\u0004\b\u0004\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00072&\b\u0004\u0010\t\u001a \u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00020\rH\b\u001a£\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\u000b\"\u0004\b\u0004\u0010\u000e\"\u0004\b\u0005\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00072,\b\u0004\u0010\t\u001a&\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u00020\u0010H\b\u001aU\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00072\u001a\b\u0004\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00020\u0013H\b\u001aU\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00072\u001a\b\u0004\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00020\u0013H\b¨\u0006\u0016"}, d2 = {"withLatestFrom", "Lio/reactivex/Observable;", "R", "T", "T1", "T2", "o1", "Lio/reactivex/ObservableSource;", "o2", "combiner", "Lkotlin/Function3;", "T3", "o3", "Lkotlin/Function4;", "T4", "o4", "Lkotlin/Function5;", "U", "other", "Lkotlin/Function2;", "zipWith", "zipper", "rxkotlin_main"}, k = 2, mv = {1, 1, 6})
/* compiled from: Observables.kt */
public final class ObservablesKt {
    @NotNull
    public static final <T, U, R> Observable<R> withLatestFrom(@NotNull Observable<T> observable, @NotNull ObservableSource<U> observableSource, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(observableSource, "other");
        Intrinsics.checkParameterIsNotNull(function2, "combiner");
        observable = observable.withLatestFrom(observableSource, new ObservablesKt$withLatestFrom$1(function2));
        Intrinsics.checkExpressionValueIsNotNull(observable, "withLatestFrom(other, Bi…combiner.invoke(t, u)  })");
        return observable;
    }

    @NotNull
    public static final <T, T1, T2, R> Observable<R> withLatestFrom(@NotNull Observable<T> observable, @NotNull ObservableSource<T1> observableSource, @NotNull ObservableSource<T2> observableSource2, @NotNull Function3<? super T, ? super T1, ? super T2, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(observableSource, "o1");
        Intrinsics.checkParameterIsNotNull(observableSource2, "o2");
        Intrinsics.checkParameterIsNotNull(function3, "combiner");
        observable = observable.withLatestFrom(observableSource, observableSource2, new ObservablesKt$withLatestFrom$2(function3));
        Intrinsics.checkExpressionValueIsNotNull(observable, "withLatestFrom(o1, o2, F…iner.invoke(t, t1, t2) })");
        return observable;
    }

    @NotNull
    public static final <T, T1, T2, T3, R> Observable<R> withLatestFrom(@NotNull Observable<T> observable, @NotNull ObservableSource<T1> observableSource, @NotNull ObservableSource<T2> observableSource2, @NotNull ObservableSource<T3> observableSource3, @NotNull Function4<? super T, ? super T1, ? super T2, ? super T3, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(observableSource, "o1");
        Intrinsics.checkParameterIsNotNull(observableSource2, "o2");
        Intrinsics.checkParameterIsNotNull(observableSource3, "o3");
        Intrinsics.checkParameterIsNotNull(function4, "combiner");
        observable = observable.withLatestFrom(observableSource, observableSource2, observableSource3, new ObservablesKt$withLatestFrom$3(function4));
        Intrinsics.checkExpressionValueIsNotNull(observable, "withLatestFrom(o1, o2, o….invoke(t, t1, t2, t3) })");
        return observable;
    }

    @NotNull
    public static final <T, T1, T2, T3, T4, R> Observable<R> withLatestFrom(@NotNull Observable<T> observable, @NotNull ObservableSource<T1> observableSource, @NotNull ObservableSource<T2> observableSource2, @NotNull ObservableSource<T3> observableSource3, @NotNull ObservableSource<T4> observableSource4, @NotNull Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(observableSource, "o1");
        Intrinsics.checkParameterIsNotNull(observableSource2, "o2");
        Intrinsics.checkParameterIsNotNull(observableSource3, "o3");
        Intrinsics.checkParameterIsNotNull(observableSource4, "o4");
        Intrinsics.checkParameterIsNotNull(function5, "combiner");
        observable = observable.withLatestFrom(observableSource, observableSource2, observableSource3, observableSource4, new ObservablesKt$withLatestFrom$4(function5));
        Intrinsics.checkExpressionValueIsNotNull(observable, "withLatestFrom(o1, o2, o…oke(t, t1, t2, t3, t4) })");
        return observable;
    }

    @NotNull
    public static final <T, U, R> Observable<R> zipWith(@NotNull Observable<T> observable, @NotNull ObservableSource<U> observableSource, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        Intrinsics.checkParameterIsNotNull(observableSource, "other");
        Intrinsics.checkParameterIsNotNull(function2, "zipper");
        observable = observable.zipWith(observableSource, new ObservablesKt$zipWith$1(function2));
        Intrinsics.checkExpressionValueIsNotNull(observable, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        return observable;
    }
}
