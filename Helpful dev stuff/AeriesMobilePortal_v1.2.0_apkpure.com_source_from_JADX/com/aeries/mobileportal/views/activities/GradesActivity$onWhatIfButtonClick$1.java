package com.aeries.mobileportal.views.activities;

import android.content.Intent;
import android.support.transition.Transition;
import android.support.transition.Transition.TransitionListener;
import android.support.v4.content.LocalBroadcastManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"com/aeries/mobileportal/views/activities/GradesActivity$onWhatIfButtonClick$1", "Landroid/support/transition/Transition$TransitionListener;", "(Lcom/aeries/mobileportal/views/activities/GradesActivity;)V", "onTransitionCancel", "", "transition", "Landroid/support/transition/Transition;", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: GradesActivity.kt */
public final class GradesActivity$onWhatIfButtonClick$1 implements TransitionListener {
    final /* synthetic */ GradesActivity this$0;

    public void onTransitionCancel(@NotNull Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, "transition");
    }

    public void onTransitionPause(@NotNull Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, "transition");
    }

    public void onTransitionResume(@NotNull Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, "transition");
    }

    GradesActivity$onWhatIfButtonClick$1(GradesActivity gradesActivity) {
        this.this$0 = gradesActivity;
    }

    public void onTransitionEnd(@NotNull Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, "transition");
        transition = new Intent(GradesActivity.Companion.getWHAT_IF_ACTION());
        transition.putExtra(GradesActivity.Companion.getWHAT_IF_ENABLED(), this.this$0.editModeEnabled);
        LocalBroadcastManager.getInstance(this.this$0).sendBroadcast(transition);
    }

    public void onTransitionStart(@NotNull Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, "transition");
        this.this$0.setLoading(false);
    }
}
