package org.jetbrains.anko.support.v4;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.support.media.ExifInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.IntentsKt;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001\u001a&\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004\u001a\u0019\u0010\t\u001a\u00020\n\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\f*\u00020\u0002H\b\u001a\u0012\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004\u001a\u001c\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u001aJ\u0010\u0010\u001a\u00020\u0011\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\u0012*\u00020\u00022*\u0010\u0013\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u00150\u0014\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u0015H\b¢\u0006\u0002\u0010\u0016\u001aR\u0010\u0017\u001a\u00020\u0011\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\u0012*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192*\u0010\u0013\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u00150\u0014\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u0015H\b¢\u0006\u0002\u0010\u001a\u001aJ\u0010\u001b\u001a\u00020\u0011\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\u001c*\u00020\u00022*\u0010\u0013\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u00150\u0014\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u0015H\b¢\u0006\u0002\u0010\u0016\u001aJ\u0010\u001d\u001a\u00020\u0011\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\u001c*\u00020\u00022*\u0010\u0013\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u00150\u0014\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u0015H\b¢\u0006\u0002\u0010\u0016¨\u0006\u001e"}, d2 = {"browse", "", "Landroid/support/v4/app/Fragment;", "url", "", "newTask", "email", "subject", "text", "intentFor", "Landroid/content/Intent;", "T", "", "makeCall", "number", "share", "startActivity", "", "Landroid/app/Activity;", "params", "", "Lkotlin/Pair;", "(Landroid/support/v4/app/Fragment;[Lkotlin/Pair;)V", "startActivityForResult", "requestCode", "", "(Landroid/support/v4/app/Fragment;I[Lkotlin/Pair;)V", "startService", "Landroid/app/Service;", "stopService", "supportV4_release"}, k = 2, mv = {1, 1, 5})
/* compiled from: SupportIntents.kt */
public final class SupportIntentsKt {
    public static final boolean browse(@NotNull Fragment fragment, @NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "url");
        return IntentsKt.browse((Context) fragment.getActivity(), str, z);
    }

    public static /* bridge */ /* synthetic */ boolean browse$default(Fragment fragment, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return browse(fragment, str, z);
    }

    public static final boolean share(@NotNull Fragment fragment, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        return IntentsKt.share((Context) fragment.getActivity(), str, str2);
    }

    public static /* bridge */ /* synthetic */ boolean share$default(Fragment fragment, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return share(fragment, str, str2);
    }

    public static /* bridge */ /* synthetic */ boolean email$default(Fragment fragment, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != null) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        return email(fragment, str, str2, str3);
    }

    public static final boolean email(@NotNull Fragment fragment, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "email");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        Intrinsics.checkParameterIsNotNull(str3, "text");
        return IntentsKt.email((Context) fragment.getActivity(), str, str2, str3);
    }

    public static final boolean makeCall(@NotNull Fragment fragment, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "number");
        return IntentsKt.makeCall((Context) fragment.getActivity(), str);
    }

    private static final <T extends Activity> void startActivity(@NotNull Fragment fragment, Pair<String, ? extends Object>... pairArr) {
        fragment = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragment, "activity");
        Context context = (Context) fragment;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        AnkoInternals.internalStartActivity(context, Activity.class, pairArr);
    }

    private static final <T extends Service> void startService(@NotNull Fragment fragment, Pair<String, ? extends Object>... pairArr) {
        fragment = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragment, "activity");
        Context context = (Context) fragment;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        AnkoInternals.internalStartService(context, Service.class, pairArr);
    }

    private static final <T extends Service> void stopService(@NotNull Fragment fragment, Pair<String, ? extends Object>... pairArr) {
        fragment = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragment, "activity");
        Context context = (Context) fragment;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        AnkoInternals.internalStopService(context, Service.class, pairArr);
    }

    private static final <T> Intent intentFor(@NotNull Fragment fragment) {
        Context activity = fragment.getActivity();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new Intent(activity, Object.class);
    }

    private static final <T extends Activity> void startActivityForResult(@NotNull Fragment fragment, int i, Pair<String, ? extends Object>... pairArr) {
        FragmentActivity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        Context context = activity;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        fragment.startActivityForResult(AnkoInternals.createIntent(context, Activity.class, pairArr), i);
    }
}
