package org.jetbrains.anko.sdk25.coroutines;

import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
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

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "view", "Landroid/widget/TimePicker;", "kotlin.jvm.PlatformType", "hourOfDay", "", "minute", "onTimeChanged"}, k = 3, mv = {1, 1, 5})
/* compiled from: ListenersWithCoroutines.kt */
final class Sdk25CoroutinesListenersWithCoroutinesKt$onTimeChanged$1 implements OnTimeChangedListener {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function5 $handler;

    Sdk25CoroutinesListenersWithCoroutinesKt$onTimeChanged$1(CoroutineContext coroutineContext, Function5 function5) {
        this.$context = coroutineContext;
        this.$handler = function5;
    }

    public final void onTimeChanged(TimePicker timePicker, int i, int i2) {
        final Sdk25CoroutinesListenersWithCoroutinesKt$onTimeChanged$1 sdk25CoroutinesListenersWithCoroutinesKt$onTimeChanged$1 = this;
        final TimePicker timePicker2 = timePicker;
        final int i3 = i;
        final int i4 = i2;
        BuildersKt.launch$default(this.$context, null, new Function2<CoroutineScope, Continuation<? super Unit>, Object>(null) {
            private CoroutineScope p$;

            @NotNull
            public final Continuation<Unit> create(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
                Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
                Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
                Continuation c11491 = /* anonymous class already generated */;
                c11491.p$ = coroutineScope;
                return c11491;
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
                Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
                Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
                return ((C11491) create(coroutineScope, (Continuation) continuation)).doResume(Unit.INSTANCE, null);
            }

            @Nullable
            public final Object doResume(@Nullable Object obj, @Nullable Throwable th) {
                Throwable coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        if (th == null) {
                            CoroutineScope coroutineScope = this.p$;
                            Function5 function5 = sdk25CoroutinesListenersWithCoroutinesKt$onTimeChanged$1.$handler;
                            TimePicker timePicker = timePicker2;
                            Integer valueOf = Integer.valueOf(i3);
                            Integer valueOf2 = Integer.valueOf(i4);
                            this.label = 1;
                            if (function5.invoke(coroutineScope, timePicker, valueOf, valueOf2, this) == coroutine_suspended) {
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