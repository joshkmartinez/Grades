package org.jetbrains.anko.sdk25.coroutines;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.BuildersKt;
import kotlinx.coroutines.experimental.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKey"}, k = 3, mv = {1, 1, 5})
/* compiled from: ListenersWithCoroutines.kt */
final class Sdk25CoroutinesListenersWithCoroutinesKt$onKey$1 implements OnKeyListener {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function5 $handler;
    final /* synthetic */ boolean $returnValue;

    Sdk25CoroutinesListenersWithCoroutinesKt$onKey$1(CoroutineContext coroutineContext, Function5 function5, boolean z) {
        this.$context = coroutineContext;
        this.$handler = function5;
        this.$returnValue = z;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        final Sdk25CoroutinesListenersWithCoroutinesKt$onKey$1 sdk25CoroutinesListenersWithCoroutinesKt$onKey$1 = this;
        final View view2 = view;
        final int i2 = i;
        final KeyEvent keyEvent2 = keyEvent;
        BuildersKt.launch$default(this.$context, null, new Function2<CoroutineScope, Continuation<? super Unit>, Object>(null) {
            private CoroutineScope p$;

            @NotNull
            public final Continuation<Unit> create(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
                Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
                Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
                Continuation c11361 = /* anonymous class already generated */;
                c11361.p$ = coroutineScope;
                return c11361;
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
                Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
                Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
                return ((C11361) create(coroutineScope, (Continuation) continuation)).doResume(Unit.INSTANCE, null);
            }

            @Nullable
            public final Object doResume(@Nullable Object obj, @Nullable Throwable th) {
                Throwable coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        if (th == null) {
                            CoroutineScope coroutineScope = this.p$;
                            Function5 function5 = sdk25CoroutinesListenersWithCoroutinesKt$onKey$1.$handler;
                            View view = view2;
                            Intrinsics.checkExpressionValueIsNotNull(view, "v");
                            Integer valueOf = Integer.valueOf(i2);
                            KeyEvent keyEvent = keyEvent2;
                            this.label = 1;
                            if (function5.invoke(coroutineScope, view, valueOf, keyEvent, this) == coroutine_suspended) {
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
        return this.$returnValue;
    }
}