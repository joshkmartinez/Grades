package com.aeries.mobileportal.web_services;

import android.accounts.AccountManagerFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CoroutineScope;
import kotlinx.coroutines.experimental.Deferred;
import kotlinx.coroutines.experimental.DeferredKt;
import org.jetbrains.anko.coroutines.experimental.BgKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/experimental/CoroutineScope;", "invoke", "(Lkotlinx/coroutines/experimental/CoroutineScope;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 10})
/* compiled from: TokenProvider.kt */
final class TokenProvider$performAuthCall$2 extends CoroutineImpl implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $call;
    final /* synthetic */ AccountManagerFuture $tokenBundle;
    Object L$0;
    Object L$1;
    private CoroutineScope p$;

    TokenProvider$performAuthCall$2(AccountManagerFuture accountManagerFuture, Function1 function1, Continuation continuation) {
        this.$tokenBundle = accountManagerFuture;
        this.$call = function1;
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        Continuation tokenProvider$performAuthCall$2 = new TokenProvider$performAuthCall$2(this.$tokenBundle, this.$call, continuation);
        tokenProvider$performAuthCall$2.p$ = coroutineScope;
        return tokenProvider$performAuthCall$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return ((TokenProvider$performAuthCall$2) create(coroutineScope, (Continuation) continuation)).doResume(Unit.INSTANCE, null);
    }

    @Nullable
    public final Object doResume(@Nullable Object obj, @Nullable Throwable th) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                if (th == null) {
                    obj = this.p$;
                    obj = DeferredKt.async$default(BgKt.getPOOL(), null, (Function2) new TokenProvider$performAuthCall$2$doResume$$inlined$bg$1(null, this), 2, null);
                    th = this.$call;
                    this.L$0 = obj;
                    this.L$1 = th;
                    this.label = 1;
                    obj = obj.await(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                throw th;
                break;
            case 1:
                Function1 function1 = (Function1) this.L$1;
                Deferred deferred = (Deferred) this.L$0;
                if (th == null) {
                    th = function1;
                    break;
                }
                throw th;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        th.invoke(obj);
        return Unit.INSTANCE;
    }
}
