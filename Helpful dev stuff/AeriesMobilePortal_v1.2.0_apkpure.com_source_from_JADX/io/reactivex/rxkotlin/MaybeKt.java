package io.reactivex.rxkotlin;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\u0001H\b\u001aD\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u0006\u0018\u00010\u00050\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0005\u001aD\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u0001H\u0006H\u0006\u0018\u00010\b0\b\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\b\u001a%\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\u0001H\b\u001a \u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u000b\u001a!\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u0004\u0018\u0001H\u0006¢\u0006\u0002\u0010\f\u001a \u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\r\u001a \u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u000e¨\u0006\u000f"}, d2 = {"cast", "Lio/reactivex/Maybe;", "R", "", "mergeAllMaybes", "Lio/reactivex/Flowable;", "T", "kotlin.jvm.PlatformType", "Lio/reactivex/Observable;", "ofType", "toMaybe", "Lkotlin/Function0;", "(Ljava/lang/Object;)Lio/reactivex/Maybe;", "Ljava/util/concurrent/Callable;", "Ljava/util/concurrent/Future;", "rxkotlin_main"}, k = 2, mv = {1, 1, 6})
/* compiled from: maybe.kt */
public final class MaybeKt {
    @NotNull
    public static final <T> Maybe<T> toMaybe(@Nullable T t) {
        t = Maybe.create(new MaybeKt$toMaybe$1(t));
        Intrinsics.checkExpressionValueIsNotNull(t, "Maybe.create { s -> if (…s(this); s.onComplete() }");
        return t;
    }

    @NotNull
    public static final <T> Maybe<T> toMaybe(@NotNull Future<T> future) {
        Intrinsics.checkParameterIsNotNull(future, "$receiver");
        future = Maybe.fromFuture(future);
        Intrinsics.checkExpressionValueIsNotNull(future, "Maybe.fromFuture(this)");
        return future;
    }

    @NotNull
    public static final <T> Maybe<T> toMaybe(@NotNull Callable<T> callable) {
        Intrinsics.checkParameterIsNotNull(callable, "$receiver");
        callable = Maybe.fromCallable(callable);
        Intrinsics.checkExpressionValueIsNotNull(callable, "Maybe.fromCallable(this)");
        return callable;
    }

    @NotNull
    public static final <T> Maybe<T> toMaybe(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "$receiver");
        function0 = Maybe.fromCallable(new MaybeKt$sam$Callable$477278a8(function0));
        Intrinsics.checkExpressionValueIsNotNull(function0, "Maybe.fromCallable(this)");
        return function0;
    }

    private static final <R> Maybe<R> cast(@NotNull Maybe<Object> maybe) {
        Intrinsics.reifiedOperationMarker(4, "R");
        maybe = maybe.cast(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(maybe, "cast(R::class.java)");
        return maybe;
    }

    private static final <R> Maybe<R> ofType(@NotNull Maybe<Object> maybe) {
        Intrinsics.reifiedOperationMarker(4, "R");
        maybe = maybe.ofType(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(maybe, "ofType(R::class.java)");
        return maybe;
    }

    public static final <T> Observable<T> mergeAllMaybes(@NotNull Observable<Maybe<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$receiver");
        return observable.flatMapMaybe(MaybeKt$mergeAllMaybes$1.INSTANCE);
    }

    public static final <T> Flowable<T> mergeAllMaybes(@NotNull Flowable<Maybe<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$receiver");
        return flowable.flatMapMaybe(MaybeKt$mergeAllMaybes$2.INSTANCE);
    }
}
