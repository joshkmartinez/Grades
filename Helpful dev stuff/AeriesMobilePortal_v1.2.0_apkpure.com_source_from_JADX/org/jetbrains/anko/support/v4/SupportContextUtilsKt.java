package org.jetbrains.anko.support.v4;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0016\u0010\t\u001a\u00020\n*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"act", "Landroid/app/Activity;", "Landroid/support/v4/app/Fragment;", "getAct", "(Landroid/support/v4/app/Fragment;)Landroid/app/Activity;", "ctx", "Landroid/content/Context;", "getCtx", "(Landroid/support/v4/app/Fragment;)Landroid/content/Context;", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "getDefaultSharedPreferences", "(Landroid/support/v4/app/Fragment;)Landroid/content/SharedPreferences;", "supportV4_release"}, k = 2, mv = {1, 1, 5})
/* compiled from: SupportContextUtils.kt */
public final class SupportContextUtilsKt {
    @NotNull
    public static final SharedPreferences getDefaultSharedPreferences(@NotNull Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        fragment = PreferenceManager.getDefaultSharedPreferences(fragment.getActivity());
        Intrinsics.checkExpressionValueIsNotNull(fragment, "PreferenceManager.getDef…aredPreferences(activity)");
        return fragment;
    }

    @NotNull
    public static final Activity getAct(@NotNull Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        fragment = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragment, "activity");
        return (Activity) fragment;
    }

    @NotNull
    public static final Context getCtx(@NotNull Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        fragment = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragment, "activity");
        return (Context) fragment;
    }
}
