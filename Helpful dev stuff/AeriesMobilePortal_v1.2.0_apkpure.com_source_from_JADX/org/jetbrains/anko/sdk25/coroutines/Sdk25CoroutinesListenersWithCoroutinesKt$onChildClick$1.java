package org.jetbrains.anko.sdk25.coroutines;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
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

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\n¢\u0006\u0002\b\f"}, d2 = {"<anonymous>", "", "parent", "Landroid/widget/ExpandableListView;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "groupPosition", "", "childPosition", "id", "", "onChildClick"}, k = 3, mv = {1, 1, 5})
/* compiled from: ListenersWithCoroutines.kt */
final class Sdk25CoroutinesListenersWithCoroutinesKt$onChildClick$1 implements OnChildClickListener {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function7 $handler;
    final /* synthetic */ boolean $returnValue;

    Sdk25CoroutinesListenersWithCoroutinesKt$onChildClick$1(CoroutineContext coroutineContext, Function7 function7, boolean z) {
        this.$context = coroutineContext;
        this.$handler = function7;
        this.$returnValue = z;
    }

    public final boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        final Sdk25CoroutinesListenersWithCoroutinesKt$onChildClick$1 sdk25CoroutinesListenersWithCoroutinesKt$onChildClick$1 = this;
        final ExpandableListView expandableListView2 = expandableListView;
        final View view2 = view;
        final int i3 = i;
        final int i4 = i2;
        final long j2 = j;
        BuildersKt.launch$default(this.$context, null, new Function2<CoroutineScope, Continuation<? super Unit>, Object>(null) {
            private CoroutineScope p$;

            @NotNull
            public final Continuation<Unit> create(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
                Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
                Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
                Continuation c11151 = /* anonymous class already generated */;
                c11151.p$ = coroutineScope;
                return c11151;
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
                Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
                Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
                return ((C11151) create(coroutineScope, (Continuation) continuation)).doResume(Unit.INSTANCE, null);
            }

            @Nullable
            public final Object doResume(@Nullable Object obj, @Nullable Throwable th) {
                Throwable coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        if (th == null) {
                            CoroutineScope coroutineScope = this.p$;
                            Function7 function7 = sdk25CoroutinesListenersWithCoroutinesKt$onChildClick$1.$handler;
                            ExpandableListView expandableListView = expandableListView2;
                            View view = view2;
                            Integer valueOf = Integer.valueOf(i3);
                            Integer valueOf2 = Integer.valueOf(i4);
                            Long valueOf3 = Long.valueOf(j2);
                            this.label = 1;
                            if (function7.invoke(coroutineScope, expandableListView, view, valueOf, valueOf2, valueOf3, this) == coroutine_suspended) {
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
