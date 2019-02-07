package io.reactivex.rxkotlin;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 1}, k = 3, mv = {1, 1, 6})
/* compiled from: observable.kt */
final class ObservableKt$sam$BiFunction$76a140ed implements BiFunction {
    private final /* synthetic */ Function2 function;

    ObservableKt$sam$BiFunction$76a140ed(Function2 function2) {
        this.function = function2;
    }

    @NonNull
    public final /* synthetic */ R apply(@NonNull T1 t1, @NonNull T2 t2) {
        return this.function.invoke(t1, t2);
    }
}
