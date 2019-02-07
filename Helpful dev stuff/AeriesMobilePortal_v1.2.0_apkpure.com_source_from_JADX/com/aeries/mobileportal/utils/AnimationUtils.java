package com.aeries.mobileportal.utils;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/utils/AnimationUtils;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AnimationUtils.kt */
public final class AnimationUtils {
    public static final Companion Companion = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J&\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ&\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000f"}, d2 = {"Lcom/aeries/mobileportal/utils/AnimationUtils$Companion;", "", "()V", "fadeIn", "", "view", "Landroid/view/View;", "fadeOut", "translateToPoint", "x", "", "y", "listener", "Landroid/view/animation/Animation$AnimationListener;", "translateToStart", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AnimationUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void translateToStart(@NotNull View view, float f, float f2) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            TranslateAnimation translateAnimation = new TranslateAnimation(0, f, 0, 0.0f, 0, f2, 0, 0.0f);
            translateAnimation.setDuration(4.2E-43f);
            view.startAnimation(translateAnimation);
        }

        public final void translateToStart(@NotNull View view, float f, float f2, @NotNull AnimationListener animationListener) {
            View view2 = view;
            AnimationListener animationListener2 = animationListener;
            Intrinsics.checkParameterIsNotNull(view2, "view");
            Intrinsics.checkParameterIsNotNull(animationListener2, CastExtraArgs.LISTENER);
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            TranslateAnimation translateAnimation = new TranslateAnimation(0, f - ((float) iArr[0]), 0, 0.0f, 0, f2 - ((float) iArr[1]), 0, 0.0f);
            translateAnimation.setDuration(300);
            translateAnimation.setAnimationListener(animationListener2);
            view2.startAnimation(translateAnimation);
        }

        public final void fadeOut(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300);
            alphaAnimation.setFillAfter(true);
            view.startAnimation(alphaAnimation);
        }

        public final void fadeIn(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300);
            alphaAnimation.setFillAfter(true);
            view.startAnimation(alphaAnimation);
        }

        public final void translateToPoint(@NotNull View view, float f, float f2, @NotNull AnimationListener animationListener) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(animationListener, CastExtraArgs.LISTENER);
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, f - ((float) iArr[0]), 0.0f, f2 - ((float) iArr[1]));
            translateAnimation.setDuration(4.2E-43f);
            translateAnimation.setAnimationListener(animationListener);
            translateAnimation.setFillAfter(true);
            view.startAnimation(translateAnimation);
        }
    }
}
