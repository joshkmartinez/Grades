package io.reactivex.rxkotlin;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JY\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\u001a\b\u0004\u0010\n\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00050\u000bH\b¨\u0006\f"}, d2 = {"Lio/reactivex/rxkotlin/Maybes;", "", "()V", "zip", "Lio/reactivex/MaybeSource;", "R", "T", "U", "s1", "s2", "zipper", "Lkotlin/Function2;", "rxkotlin_main"}, k = 1, mv = {1, 1, 6})
/* compiled from: Maybes.kt */
public final class Maybes {
    public static final Maybes INSTANCE = null;

    static {
        Maybes maybes = new Maybes();
    }

    private Maybes() {
        INSTANCE = this;
    }

    @NotNull
    public final <T, U, R> MaybeSource<R> zip(@NotNull MaybeSource<T> maybeSource, @NotNull MaybeSource<U> maybeSource2, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(maybeSource, "s1");
        Intrinsics.checkParameterIsNotNull(maybeSource2, "s2");
        Intrinsics.checkParameterIsNotNull(function2, "zipper");
        maybeSource = Maybe.zip(maybeSource, maybeSource2, new Maybes$zip$1(function2));
        Intrinsics.checkExpressionValueIsNotNull(maybeSource, "Maybe.zip(s1,s2, BiFunct…-> zipper.invoke(t, u) })");
        return maybeSource;
    }
}
