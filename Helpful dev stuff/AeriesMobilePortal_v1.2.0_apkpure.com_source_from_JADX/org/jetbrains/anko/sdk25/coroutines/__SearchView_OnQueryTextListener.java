package org.jetbrains.anko.sdk25.coroutines;

import android.widget.SearchView.OnQueryTextListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.BuildersKt;
import kotlinx.coroutines.experimental.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JI\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\n2/\u0010\u0014\u001a+\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0016JI\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\n2/\u0010\u0014\u001a+\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0016R>\u0010\u0005\u001a-\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0006¢\u0006\u0002\b\fX\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R>\u0010\u000f\u001a-\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0006¢\u0006\u0002\b\fX\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006\u0019"}, d2 = {"Lorg/jetbrains/anko/sdk25/coroutines/__SearchView_OnQueryTextListener;", "Landroid/widget/SearchView$OnQueryTextListener;", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "(Lkotlin/coroutines/experimental/CoroutineContext;)V", "_onQueryTextChange", "Lkotlin/Function3;", "Lkotlinx/coroutines/experimental/CoroutineScope;", "", "Lkotlin/coroutines/experimental/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "_onQueryTextChange_returnValue", "_onQueryTextSubmit", "_onQueryTextSubmit_returnValue", "onQueryTextChange", "", "returnValue", "listener", "(ZLkotlin/jvm/functions/Function3;)V", "newText", "onQueryTextSubmit", "query", "anko-sdk25-coroutines_release"}, k = 1, mv = {1, 1, 5})
/* compiled from: ListenersWithCoroutines.kt */
public final class __SearchView_OnQueryTextListener implements OnQueryTextListener {
    private Function3<? super CoroutineScope, ? super String, ? super Continuation<? super Boolean>, ? extends Object> _onQueryTextChange;
    private boolean _onQueryTextChange_returnValue;
    private Function3<? super CoroutineScope, ? super String, ? super Continuation<? super Boolean>, ? extends Object> _onQueryTextSubmit;
    private boolean _onQueryTextSubmit_returnValue;
    private final CoroutineContext context;

    public __SearchView_OnQueryTextListener(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        this.context = coroutineContext;
    }

    public boolean onQueryTextSubmit(@Nullable String str) {
        boolean z = this._onQueryTextSubmit_returnValue;
        Function3 function3 = this._onQueryTextSubmit;
        if (function3 == null) {
            return z;
        }
        BuildersKt.launch$default(this.context, null, new __SearchView_OnQueryTextListener$onQueryTextSubmit$1(function3, str, null), 2, null);
        return z;
    }

    public static /* bridge */ /* synthetic */ void onQueryTextSubmit$default(__SearchView_OnQueryTextListener org_jetbrains_anko_sdk25_coroutines___SearchView_OnQueryTextListener, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        org_jetbrains_anko_sdk25_coroutines___SearchView_OnQueryTextListener.onQueryTextSubmit(z, function3);
    }

    public final void onQueryTextSubmit(boolean z, @NotNull Function3<? super CoroutineScope, ? super String, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, CastExtraArgs.LISTENER);
        this._onQueryTextSubmit = function3;
        this._onQueryTextSubmit_returnValue = z;
    }

    public boolean onQueryTextChange(@Nullable String str) {
        boolean z = this._onQueryTextChange_returnValue;
        Function3 function3 = this._onQueryTextChange;
        if (function3 == null) {
            return z;
        }
        BuildersKt.launch$default(this.context, null, new __SearchView_OnQueryTextListener$onQueryTextChange$1(function3, str, null), 2, null);
        return z;
    }

    public static /* bridge */ /* synthetic */ void onQueryTextChange$default(__SearchView_OnQueryTextListener org_jetbrains_anko_sdk25_coroutines___SearchView_OnQueryTextListener, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        org_jetbrains_anko_sdk25_coroutines___SearchView_OnQueryTextListener.onQueryTextChange(z, function3);
    }

    public final void onQueryTextChange(boolean z, @NotNull Function3<? super CoroutineScope, ? super String, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, CastExtraArgs.LISTENER);
        this._onQueryTextChange = function3;
        this._onQueryTextChange_returnValue = z;
    }
}
