package org.jetbrains.anko.sdk25.coroutines;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/experimental/CoroutineScope;", "invoke", "(Lkotlinx/coroutines/experimental/CoroutineScope;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 5})
/* compiled from: ListenersWithCoroutines.kt */
final class __ViewGroup_OnHierarchyChangeListener$onChildViewAdded$1 extends CoroutineImpl implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $child;
    final /* synthetic */ Function4 $handler;
    final /* synthetic */ View $parent;
    private CoroutineScope p$;

    __ViewGroup_OnHierarchyChangeListener$onChildViewAdded$1(Function4 function4, View view, View view2, Continuation continuation) {
        this.$handler = function4;
        this.$parent = view;
        this.$child = view2;
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
        Continuation org_jetbrains_anko_sdk25_coroutines___ViewGroup_OnHierarchyChangeListener_onChildViewAdded_1 = new __ViewGroup_OnHierarchyChangeListener$onChildViewAdded$1(this.$handler, this.$parent, this.$child, continuation);
        org_jetbrains_anko_sdk25_coroutines___ViewGroup_OnHierarchyChangeListener_onChildViewAdded_1.p$ = coroutineScope;
        return org_jetbrains_anko_sdk25_coroutines___ViewGroup_OnHierarchyChangeListener_onChildViewAdded_1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "$continuation");
        return ((__ViewGroup_OnHierarchyChangeListener$onChildViewAdded$1) create(coroutineScope, (Continuation) continuation)).doResume(Unit.INSTANCE, null);
    }

    @Nullable
    public final Object doResume(@Nullable Object obj, @Nullable Throwable th) {
        Throwable coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                if (th == null) {
                    th = this.p$;
                    Function4 function4 = this.$handler;
                    View view = this.$parent;
                    View view2 = this.$child;
                    this.label = 1;
                    if (function4.invoke(th, view, view2, this) == coroutine_suspended) {
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
}