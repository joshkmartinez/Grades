package io.reactivex.rxkotlin;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Maybe;", "T", "kotlin.jvm.PlatformType", "", "it", "apply"}, k = 3, mv = {1, 1, 6})
/* compiled from: maybe.kt */
final class MaybeKt$mergeAllMaybes$1<T, R> implements Function<T, MaybeSource<? extends R>> {
    public static final MaybeKt$mergeAllMaybes$1 INSTANCE = new MaybeKt$mergeAllMaybes$1();

    MaybeKt$mergeAllMaybes$1() {
    }

    public final Maybe<T> apply(Maybe<T> maybe) {
        return maybe;
    }
}
