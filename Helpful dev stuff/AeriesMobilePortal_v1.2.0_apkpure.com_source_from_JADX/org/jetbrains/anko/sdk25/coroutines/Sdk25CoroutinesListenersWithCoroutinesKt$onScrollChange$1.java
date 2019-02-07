package org.jetbrains.anko.sdk25.coroutines;

import android.view.View;
import android.view.View.OnScrollChangeListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.BuildersKt;
import kotlinx.coroutines.experimental.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "scrollX", "", "scrollY", "oldScrollX", "oldScrollY", "onScrollChange"}, k = 3, mv = {1, 1, 5})
/* compiled from: ListenersWithCoroutines.kt */
final class Sdk25CoroutinesListenersWithCoroutinesKt$onScrollChange$1 implements OnScrollChangeListener {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function7 $handler;

    Sdk25CoroutinesListenersWithCoroutinesKt$onScrollChange$1(CoroutineContext coroutineContext, Function7 function7) {
        this.$context = coroutineContext;
        this.$handler = function7;
    }

    public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
        final Sdk25CoroutinesListenersWithCoroutinesKt$onScrollChange$1 sdk25CoroutinesListenersWithCoroutinesKt$onScrollChange$1 = this;
        final View view2 = view;
        final int i5 = i;
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        BuildersKt.launch$default(this.$context, null, new Function2<CoroutineScope, Continuation<? super Unit>, Object>(null) {
            private CoroutineScope p$;

            @NotNull
            public final Continuation<Unit> create(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
                Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
                Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
                Continuation c11451 = /* anonymous class already generated */;
                c11451.p$ = coroutineScope;
                return c11451;
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
                Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
                Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
                return ((C11451) create(coroutineScope, (Continuation) continuation)).doResume(Unit.INSTANCE, null);
            }

            @Nullable
            public final Object doResume(@Nullable Object obj, @Nullable Throwable th) {
                Throwable coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        if (th == null) {
                            CoroutineScope coroutineScope = this.p$;
                            Function7 function7 = sdk25CoroutinesListenersWithCoroutinesKt$onScrollChange$1.$handler;
                            View view = view2;
                            Integer valueOf = Integer.valueOf(i5);
                            Integer valueOf2 = Integer.valueOf(i6);
                            Integer valueOf3 = Integer.valueOf(i7);
                            Integer valueOf4 = Integer.valueOf(i8);
                            this.label = 1;
                            if (function7.invoke(coroutineScope, view, valueOf, valueOf2, valueOf3, valueOf4, this) == coroutine_suspended) {
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
