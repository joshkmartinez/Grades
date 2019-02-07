package io.reactivex.rxkotlin;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function3;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 1}, k = 3, mv = {1, 1, 6})
/* compiled from: observable.kt */
final class ObservableKt$sam$Function3$5d5171b5 implements Function3 {
    private final /* synthetic */ kotlin.jvm.functions.Function3 function;

    ObservableKt$sam$Function3$5d5171b5(kotlin.jvm.functions.Function3 function3) {
        this.function = function3;
    }

    @NonNull
    public final /* synthetic */ R apply(@NonNull T1 t1, @NonNull T2 t2, @NonNull T3 t3) {
        return this.function.invoke(t1, t2, t3);
    }
}
