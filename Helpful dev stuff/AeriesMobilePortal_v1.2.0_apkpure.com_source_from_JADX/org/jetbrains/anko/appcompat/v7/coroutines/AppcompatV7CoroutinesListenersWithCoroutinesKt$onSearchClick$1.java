package org.jetbrains.anko.appcompat.v7.coroutines;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.BuildersKt;
import kotlinx.coroutines.experimental.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 5})
/* compiled from: ListenersWithCoroutines.kt */
final class AppcompatV7CoroutinesListenersWithCoroutinesKt$onSearchClick$1 implements OnClickListener {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function3 $handler;

    AppcompatV7CoroutinesListenersWithCoroutinesKt$onSearchClick$1(CoroutineContext coroutineContext, Function3 function3) {
        this.$context = coroutineContext;
        this.$handler = function3;
    }

    public final void onClick(final View view) {
        BuildersKt.launch$default(this.$context, null, new Function2<CoroutineScope, Continuation<? super Unit>, Object>(null) {
            private CoroutineScope p$;

            @NotNull
            public final Continuation<Unit> create(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
                Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
                Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
                Continuation c11111 = /* anonymous class already generated */;
                c11111.p$ = coroutineScope;
                return c11111;
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
                Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
                Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
                return ((C11111) create(coroutineScope, (Continuation) continuation)).doResume(Unit.INSTANCE, null);
            }

            @Nullable
            public final Object doResume(@Nullable Object obj, @Nullable Throwable th) {
                Throwable coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        if (th == null) {
                            th = this.p$;
                            Function3 function3 = this.$handler;
                            View view = view;
                            this.label = 1;
                            if (function3.invoke(th, view, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        throw th;
                        break;
                    case 1:
                        if (th == null) {
                            break;
                        }
                        throw th;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
    }
}
