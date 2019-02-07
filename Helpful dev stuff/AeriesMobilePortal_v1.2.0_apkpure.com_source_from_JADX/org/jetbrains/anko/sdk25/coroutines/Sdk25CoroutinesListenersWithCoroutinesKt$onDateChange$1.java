package org.jetbrains.anko.sdk25.coroutines;

import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.BuildersKt;
import kotlinx.coroutines.experimental.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "view", "Landroid/widget/CalendarView;", "kotlin.jvm.PlatformType", "year", "", "month", "dayOfMonth", "onSelectedDayChange"}, k = 3, mv = {1, 1, 5})
/* compiled from: ListenersWithCoroutines.kt */
final class Sdk25CoroutinesListenersWithCoroutinesKt$onDateChange$1 implements OnDateChangeListener {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function6 $handler;

    Sdk25CoroutinesListenersWithCoroutinesKt$onDateChange$1(CoroutineContext coroutineContext, Function6 function6) {
        this.$context = coroutineContext;
        this.$handler = function6;
    }

    public final void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3) {
        final Sdk25CoroutinesListenersWithCoroutinesKt$onDateChange$1 sdk25CoroutinesListenersWithCoroutinesKt$onDateChange$1 = this;
        final CalendarView calendarView2 = calendarView;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        BuildersKt.launch$default(this.$context, null, new Function2<CoroutineScope, Continuation<? super Unit>, Object>(null) {
            private CoroutineScope p$;

            @NotNull
            public final Continuation<Unit> create(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
                Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
                Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
                Continuation c11211 = /* anonymous class already generated */;
                c11211.p$ = coroutineScope;
                return c11211;
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
                Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
                Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
                return ((C11211) create(coroutineScope, (Continuation) continuation)).doResume(Unit.INSTANCE, null);
            }

            @Nullable
            public final Object doResume(@Nullable Object obj, @Nullable Throwable th) {
                Throwable coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        if (th == null) {
                            CoroutineScope coroutineScope = this.p$;
                            Function6 function6 = sdk25CoroutinesListenersWithCoroutinesKt$onDateChange$1.$handler;
                            CalendarView calendarView = calendarView2;
                            Integer valueOf = Integer.valueOf(i4);
                            Integer valueOf2 = Integer.valueOf(i5);
                            Integer valueOf3 = Integer.valueOf(i6);
                            this.label = 1;
                            if (function6.invoke(coroutineScope, calendarView, valueOf, valueOf2, valueOf3, this) == coroutine_suspended) {
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
