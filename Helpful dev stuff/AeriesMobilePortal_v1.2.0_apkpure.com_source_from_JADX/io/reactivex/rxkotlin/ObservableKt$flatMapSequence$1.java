package io.reactivex.rxkotlin;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0002*\u00020\u00042\u000e\u0010\u0005\u001a\n \u0006*\u0004\u0018\u0001H\u0003H\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "R", "T", "", "it", "kotlin.jvm.PlatformType", "apply", "(Ljava/lang/Object;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 1, 6})
/* compiled from: observable.kt */
public final class ObservableKt$flatMapSequence$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ Function1 $body;

    public ObservableKt$flatMapSequence$1(Function1 function1) {
        this.$body = function1;
    }

    @NotNull
    public final Observable<R> apply(T t) {
        Function1 function1 = this.$body;
        Intrinsics.checkExpressionValueIsNotNull(t, "it");
        return ObservableKt.toObservable((Sequence) function1.invoke(t));
    }
}
