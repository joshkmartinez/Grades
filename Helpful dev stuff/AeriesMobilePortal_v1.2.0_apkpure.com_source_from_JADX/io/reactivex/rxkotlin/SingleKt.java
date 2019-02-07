package io.reactivex.rxkotlin;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\u0001H\b\u001aD\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u0006\u0018\u00010\u00050\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0005\u001aD\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u0006\u0018\u00010\b0\b\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\b\u001a \u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\n\u001a\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u0002H\u0006¢\u0006\u0002\u0010\u000b\u001a \u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\f\u001a \u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\r¨\u0006\u000e"}, d2 = {"cast", "Lio/reactivex/Single;", "R", "", "mergeAllSingles", "Lio/reactivex/Flowable;", "T", "kotlin.jvm.PlatformType", "Lio/reactivex/Observable;", "toSingle", "Lkotlin/Function0;", "(Ljava/lang/Object;)Lio/reactivex/Single;", "Ljava/util/concurrent/Callable;", "Ljava/util/concurrent/Future;", "rxkotlin_main"}, k = 2, mv = {1, 1, 6})
/* compiled from: single.kt */
public final class SingleKt {
    @NotNull
    public static final <T> Single<T> toSingle(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        t = Single.just(t);
        Intrinsics.checkExpressionValueIsNotNull(t, "Single.just(this)");
        return t;
    }

    @NotNull
    public static final <T> Single<T> toSingle(@NotNull Future<T> future) {
        Intrinsics.checkParameterIsNotNull(future, "$receiver");
        future = Single.fromFuture(future);
        Intrinsics.checkExpressionValueIsNotNull(future, "Single.fromFuture(this)");
        return future;
    }

    @NotNull
    public static final <T> Single<T> toSingle(@NotNull Callable<T> callable) {
        Intrinsics.checkParameterIsNotNull(callable, "$receiver");
        callable = Single.fromCallable(callable);
        Intrinsics.checkExpressionValueIsNotNull(callable, "Single.fromCallable(this)");
        return callable;
    }

    @NotNull
    public static final <T> Single<T> toSingle(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "$receiver");
        function0 = Single.fromCallable(new SingleKt$sam$Callable$7c4459b8(function0));
        Intrinsics.checkExpressionValueIsNotNull(function0, "Single.fromCallable(this)");
        return function0;
    }

    private static final <R> Single<R> cast(@NotNull Single<Object> single) {
        Intrinsics.reifiedOperationMarker(4, "R");
        single = single.cast(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(single, "cast(R::class.java)");
        return single;
    }

    public static final <T> Observable<T> mergeAllSingles(@NotNull Observable<Single<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        return observable.flatMapSingle(SingleKt$mergeAllSingles$1.INSTANCE);
    }

    public static final <T> Flowable<T> mergeAllSingles(@NotNull Flowable<Single<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        return flowable.flatMapSingle(SingleKt$mergeAllSingles$2.INSTANCE);
    }
}
