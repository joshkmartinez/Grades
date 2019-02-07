package com.aeries.mobileportal.web_services;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/experimental/CoroutineScope;", "invoke", "(Lkotlinx/coroutines/experimental/CoroutineScope;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "org/jetbrains/anko/coroutines/experimental/BgKt$bg$1"}, k = 3, mv = {1, 1, 10})
/* compiled from: bg.kt */
public final class TokenProvider$performAuthCall$2$doResume$$inlined$bg$1 extends CoroutineImpl implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    private CoroutineScope p$;
    final /* synthetic */ TokenProvider$performAuthCall$2 this$0;

    public TokenProvider$performAuthCall$2$doResume$$inlined$bg$1(Continuation continuation, TokenProvider$performAuthCall$2 tokenProvider$performAuthCall$2) {
        this.this$0 = tokenProvider$performAuthCall$2;
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super String> continuation) {
        Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
        Continuation tokenProvider$performAuthCall$2$doResume$$inlined$bg$1 = new TokenProvider$performAuthCall$2$doResume$$inlined$bg$1(continuation, this.this$0);
        tokenProvider$performAuthCall$2$doResume$$inlined$bg$1.p$ = coroutineScope;
        return tokenProvider$performAuthCall$2$doResume$$inlined$bg$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super String> continuation) {
        Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
        return ((TokenProvider$performAuthCall$2$doResume$$inlined$bg$1) create(coroutineScope, (Continuation) continuation)).doResume(Unit.INSTANCE, null);
    }

    @Nullable
    public final Object doResume(@Nullable Object obj, @Nullable Throwable th) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != null) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else if (th == null) {
            obj = this.p$;
            obj = this.this$0.$tokenBundle;
            Intrinsics.checkExpressionValueIsNotNull(obj, "tokenBundle");
            return ((Bundle) obj.getResult()).get("authtoken").toString();
        } else {
            throw th;
        }
    }
}
