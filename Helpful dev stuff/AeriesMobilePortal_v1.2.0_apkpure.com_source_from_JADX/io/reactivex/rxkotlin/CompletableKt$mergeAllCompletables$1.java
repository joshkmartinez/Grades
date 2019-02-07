package io.reactivex.rxkotlin;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "kotlin.jvm.PlatformType", "it", "apply"}, k = 3, mv = {1, 1, 6})
/* compiled from: completable.kt */
final class CompletableKt$mergeAllCompletables$1<T, R> implements Function<Completable, CompletableSource> {
    public static final CompletableKt$mergeAllCompletables$1 INSTANCE = new CompletableKt$mergeAllCompletables$1();

    CompletableKt$mergeAllCompletables$1() {
    }

    public final Completable apply(Completable completable) {
        return completable;
    }
}
