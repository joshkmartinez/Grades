package io.reactivex.rxkotlin;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "T", "kotlin.jvm.PlatformType", "", "it", "apply"}, k = 3, mv = {1, 1, 6})
/* compiled from: observable.kt */
final class ObservableKt$switchLatest$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    public static final ObservableKt$switchLatest$1 INSTANCE = new ObservableKt$switchLatest$1();

    ObservableKt$switchLatest$1() {
    }

    public final Observable<T> apply(Observable<T> observable) {
        return observable;
    }
}
