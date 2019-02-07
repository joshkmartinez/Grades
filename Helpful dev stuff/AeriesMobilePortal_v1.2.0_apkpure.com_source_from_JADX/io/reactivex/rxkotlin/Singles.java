package io.reactivex.rxkotlin;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JY\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\t2\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00050\fH\b¨\u0006\r"}, d2 = {"Lio/reactivex/rxkotlin/Singles;", "", "()V", "zip", "Lio/reactivex/Single;", "R", "T", "U", "s1", "Lio/reactivex/SingleSource;", "s2", "zipper", "Lkotlin/Function2;", "rxkotlin_main"}, k = 1, mv = {1, 1, 6})
/* compiled from: Singles.kt */
public final class Singles {
    public static final Singles INSTANCE = null;

    static {
        Singles singles = new Singles();
    }

    private Singles() {
        INSTANCE = this;
    }

    @NotNull
    public final <T, U, R> Single<R> zip(@NotNull SingleSource<T> singleSource, @NotNull SingleSource<U> singleSource2, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(singleSource, "s1");
        Intrinsics.checkParameterIsNotNull(singleSource2, "s2");
        Intrinsics.checkParameterIsNotNull(function2, "zipper");
        singleSource = Single.zip(singleSource, singleSource2, new Singles$zip$1(function2));
        Intrinsics.checkExpressionValueIsNotNull(singleSource, "Single.zip(s1,s2, BiFunc…-> zipper.invoke(t, u) })");
        return singleSource;
    }
}
