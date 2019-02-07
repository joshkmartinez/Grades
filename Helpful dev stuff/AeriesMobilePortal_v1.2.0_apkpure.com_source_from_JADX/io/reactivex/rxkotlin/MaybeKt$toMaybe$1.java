package io.reactivex.rxkotlin;

import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032*\u0010\u0004\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u0002 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "", "s", "Lio/reactivex/MaybeEmitter;", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 1, 6})
/* compiled from: maybe.kt */
final class MaybeKt$toMaybe$1<T> implements MaybeOnSubscribe<T> {
    final /* synthetic */ Object receiver$0;

    MaybeKt$toMaybe$1(Object obj) {
        this.receiver$0 = obj;
    }

    public final void subscribe(MaybeEmitter<T> maybeEmitter) {
        if (this.receiver$0 != null) {
            maybeEmitter.onSuccess(this.receiver$0);
        }
        maybeEmitter.onComplete();
    }
}
