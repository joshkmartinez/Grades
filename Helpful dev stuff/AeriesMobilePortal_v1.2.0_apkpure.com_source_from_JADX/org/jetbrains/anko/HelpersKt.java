package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\b\u001a\u001f\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\f0\nH\b\u001a\u001f\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\f0\nH\b\u001a¶\u0001\u0010\u000f\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u0010*\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\b¢\u0006\u0002\u0010#\u001a¶\u0001\u0010\u000f\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u0010*\u00020$2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\b¢\u0006\u0002\u0010%\u001a¶\u0001\u0010\u000f\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u0010*\u00020&2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\b¢\u0006\u0002\u0010'\u001aº\u0001\u0010\u000f\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u0010*\u0006\u0012\u0002\b\u00030(2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\b¢\u0006\u0002\u0010)\u001a\u0012\u0010*\u001a\u00020\u0001*\u00020\u00012\u0006\u0010+\u001a\u00020\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003¨\u0006,"}, d2 = {"gray", "", "getGray", "(I)I", "opaque", "getOpaque", "attempt", "Lorg/jetbrains/anko/AttemptResult;", "T", "f", "Lkotlin/Function0;", "doFromSdk", "", "version", "doIfSdk", "configuration", "", "Landroid/app/Activity;", "screenSize", "Lorg/jetbrains/anko/ScreenSize;", "density", "Lkotlin/ranges/ClosedRange;", "language", "", "orientation", "Lorg/jetbrains/anko/Orientation;", "long", "", "fromSdk", "sdk", "uiMode", "Lorg/jetbrains/anko/UiMode;", "nightMode", "rightToLeft", "smallestWidth", "(Landroid/app/Activity;Lorg/jetbrains/anko/ScreenSize;Lkotlin/ranges/ClosedRange;Ljava/lang/String;Lorg/jetbrains/anko/Orientation;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lorg/jetbrains/anko/UiMode;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Landroid/app/Fragment;", "(Landroid/app/Fragment;Lorg/jetbrains/anko/ScreenSize;Lkotlin/ranges/ClosedRange;Ljava/lang/String;Lorg/jetbrains/anko/Orientation;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lorg/jetbrains/anko/UiMode;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Landroid/content/Context;", "(Landroid/content/Context;Lorg/jetbrains/anko/ScreenSize;Lkotlin/ranges/ClosedRange;Ljava/lang/String;Lorg/jetbrains/anko/Orientation;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lorg/jetbrains/anko/UiMode;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lorg/jetbrains/anko/AnkoContext;", "(Lorg/jetbrains/anko/AnkoContext;Lorg/jetbrains/anko/ScreenSize;Lkotlin/ranges/ClosedRange;Ljava/lang/String;Lorg/jetbrains/anko/Orientation;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lorg/jetbrains/anko/UiMode;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withAlpha", "alpha", "commons_release"}, k = 2, mv = {1, 1, 5})
/* compiled from: Helpers.kt */
public final class HelpersKt {
    public static final int getGray(int i) {
        return (i << 16) | ((i << 8) | i);
    }

    public static final int getOpaque(int i) {
        return i | ((int) 4278190080L);
    }

    public static final int withAlpha(int i, int i2) {
        Object obj = (i2 < 0 || i2 > 255) ? null : 1;
        if (obj != null) {
            return (i & ViewCompat.MEASURED_SIZE_MASK) | (i2 << 24);
        }
        throw ((Throwable) new IllegalArgumentException("Failed requirement.".toString()));
    }

    @Nullable
    public static final <T> T configuration(@NotNull Context context, @Nullable ScreenSize screenSize, @Nullable ClosedRange<Integer> closedRange, @Nullable String str, @Nullable Orientation orientation, @Nullable Boolean bool, @Nullable Integer num, @Nullable Integer num2, @Nullable UiMode uiMode, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Integer num3, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        return AnkoInternals.testConfiguration(context, screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3) != null ? function0.invoke() : null;
    }

    @Nullable
    public static final <T> T configuration(@NotNull Activity activity, @Nullable ScreenSize screenSize, @Nullable ClosedRange<Integer> closedRange, @Nullable String str, @Nullable Orientation orientation, @Nullable Boolean bool, @Nullable Integer num, @Nullable Integer num2, @Nullable UiMode uiMode, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Integer num3, @NotNull Function0<? extends T> function0) {
        Activity activity2 = activity;
        Intrinsics.checkParameterIsNotNull(activity2, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        return AnkoInternals.testConfiguration((Context) activity2, screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3) ? function0.invoke() : null;
    }

    @Nullable
    public static final <T> T configuration(@NotNull AnkoContext<?> ankoContext, @Nullable ScreenSize screenSize, @Nullable ClosedRange<Integer> closedRange, @Nullable String str, @Nullable Orientation orientation, @Nullable Boolean bool, @Nullable Integer num, @Nullable Integer num2, @Nullable UiMode uiMode, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Integer num3, @NotNull Function0<? extends T> function0) {
        AnkoContext<?> ankoContext2 = ankoContext;
        Intrinsics.checkParameterIsNotNull(ankoContext2, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        return AnkoInternals.testConfiguration(ankoContext2.getCtx(), screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3) ? function0.invoke() : null;
    }

    @Nullable
    public static final <T> T configuration(@NotNull Fragment fragment, @Nullable ScreenSize screenSize, @Nullable ClosedRange<Integer> closedRange, @Nullable String str, @Nullable Orientation orientation, @Nullable Boolean bool, @Nullable Integer num, @Nullable Integer num2, @Nullable UiMode uiMode, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Integer num3, @NotNull Function0<? extends T> function0) {
        Fragment fragment2 = fragment;
        Intrinsics.checkParameterIsNotNull(fragment2, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        Activity activity = fragment2.getActivity();
        if (activity == null || !AnkoInternals.testConfiguration(activity, screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3)) {
            return null;
        }
        return function0.invoke();
    }

    public static final void doFromSdk(int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (VERSION.SDK_INT >= i) {
            function0.invoke();
        }
    }

    public static final void doIfSdk(int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (VERSION.SDK_INT == i) {
            function0.invoke();
        }
    }

    @NotNull
    public static final <T> AttemptResult<T> attempt(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "f");
        Throwable th = (Throwable) null;
        try {
            function0 = function0.invoke();
        } catch (Throwable th2) {
            th = th2;
            function0 = null;
        }
        return new AttemptResult(function0, th);
    }
}
