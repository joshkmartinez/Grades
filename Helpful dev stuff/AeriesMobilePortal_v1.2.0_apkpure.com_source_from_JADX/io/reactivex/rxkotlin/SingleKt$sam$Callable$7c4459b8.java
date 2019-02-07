package io.reactivex.rxkotlin;

import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 1}, k = 3, mv = {1, 1, 6})
/* compiled from: single.kt */
final class SingleKt$sam$Callable$7c4459b8 implements Callable {
    private final /* synthetic */ Function0 function;

    SingleKt$sam$Callable$7c4459b8(Function0 function0) {
        this.function = function0;
    }

    public final /* synthetic */ V call() {
        return this.function.invoke();
    }
}
