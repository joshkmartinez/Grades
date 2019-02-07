package io.reactivex.rxkotlin;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aU\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\u001a\b\u0004\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\bH\b¨\u0006\t"}, d2 = {"zipWith", "Lio/reactivex/Single;", "R", "T", "U", "other", "Lio/reactivex/SingleSource;", "zipper", "Lkotlin/Function2;", "rxkotlin_main"}, k = 2, mv = {1, 1, 6})
/* compiled from: Singles.kt */
public final class SinglesKt {
    @NotNull
    public static final <T, U, R> Single<R> zipWith(@NotNull Single<T> single, @NotNull SingleSource<U> singleSource, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(single, "$receiver");
        Intrinsics.checkParameterIsNotNull(singleSource, "other");
        Intrinsics.checkParameterIsNotNull(function2, "zipper");
        single = single.zipWith(singleSource, new SinglesKt$zipWith$1(function2));
        Intrinsics.checkExpressionValueIsNotNull(single, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        return single;
    }
}
