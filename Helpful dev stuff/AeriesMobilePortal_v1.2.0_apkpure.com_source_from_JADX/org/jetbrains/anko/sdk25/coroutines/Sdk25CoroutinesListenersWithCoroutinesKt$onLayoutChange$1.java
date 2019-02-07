package org.jetbrains.anko.sdk25.coroutines;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.BuildersKt;
import kotlinx.coroutines.experimental.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\n¢\u0006\u0002\b\u000e"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"}, k = 3, mv = {1, 1, 5})
/* compiled from: ListenersWithCoroutines.kt */
final class Sdk25CoroutinesListenersWithCoroutinesKt$onLayoutChange$1 implements OnLayoutChangeListener {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function11 $handler;

    Sdk25CoroutinesListenersWithCoroutinesKt$onLayoutChange$1(CoroutineContext coroutineContext, Function11 function11) {
        this.$context = coroutineContext;
        this.$handler = function11;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        final Sdk25CoroutinesListenersWithCoroutinesKt$onLayoutChange$1 sdk25CoroutinesListenersWithCoroutinesKt$onLayoutChange$1 = this;
        final View view2 = view;
        final int i9 = i;
        final int i10 = i2;
        final int i11 = i3;
        final int i12 = i4;
        final int i13 = i5;
        final int i14 = i6;
        final int i15 = i7;
        final int i16 = i8;
        BuildersKt.launch$default(this.$context, null, new Function2<CoroutineScope, Continuation<? super Unit>, Object>(null) {
            private CoroutineScope p$;

            @NotNull
            public final Continuation<Unit> create(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
                Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
                Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
                Continuation c11371 = /* anonymous class already generated */;
                c11371.p$ = coroutineScope;
                return c11371;
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
                Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
                Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
                return ((C11371) create(coroutineScope, (Continuation) continuation)).doResume(Unit.INSTANCE, null);
            }

            @Nullable
            public final Object doResume(@Nullable Object obj, @Nullable Throwable th) {
                Throwable coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        if (th == null) {
                            CoroutineScope coroutineScope = this.p$;
                            Function11 function11 = sdk25CoroutinesListenersWithCoroutinesKt$onLayoutChange$1.$handler;
                            View view = view2;
                            Integer valueOf = Integer.valueOf(i9);
                            Integer valueOf2 = Integer.valueOf(i10);
                            Integer valueOf3 = Integer.valueOf(i11);
                            Integer valueOf4 = Integer.valueOf(i12);
                            Integer valueOf5 = Integer.valueOf(i13);
                            Integer valueOf6 = Integer.valueOf(i14);
                            Integer valueOf7 = Integer.valueOf(i15);
                            Integer valueOf8 = Integer.valueOf(i16);
                            this.label = 1;
                            if (function11.invoke(coroutineScope, view, valueOf, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6, valueOf7, valueOf8, this) == coroutine_suspended) {
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
