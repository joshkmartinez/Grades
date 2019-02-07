package com.aeries.mobileportal.views.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/aeries/mobileportal/views/activities/AuthenticationActivity$showProgress$2", "Landroid/animation/AnimatorListenerAdapter;", "(Lcom/aeries/mobileportal/views/activities/AuthenticationActivity;Z)V", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AuthenticationActivity.kt */
public final class AuthenticationActivity$showProgress$2 extends AnimatorListenerAdapter {
    final /* synthetic */ boolean $show;
    final /* synthetic */ AuthenticationActivity this$0;

    AuthenticationActivity$showProgress$2(AuthenticationActivity authenticationActivity, boolean z) {
        this.this$0 = authenticationActivity;
        this.$show = z;
    }

    public void onAnimationEnd(@NotNull Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animation");
        this.this$0.getLoginProgress().setVisibility(this.$show ? 0 : 8);
    }
}
