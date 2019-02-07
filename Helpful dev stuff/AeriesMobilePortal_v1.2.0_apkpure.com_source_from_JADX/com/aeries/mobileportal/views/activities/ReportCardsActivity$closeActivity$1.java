package com.aeries.mobileportal.views.activities;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, d2 = {"com/aeries/mobileportal/views/activities/ReportCardsActivity$closeActivity$1", "Landroid/view/animation/Animation$AnimationListener;", "(Lcom/aeries/mobileportal/views/activities/ReportCardsActivity;)V", "onAnimationEnd", "", "p0", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ReportCardsActivity.kt */
public final class ReportCardsActivity$closeActivity$1 implements AnimationListener {
    final /* synthetic */ ReportCardsActivity this$0;

    public void onAnimationRepeat(@Nullable Animation animation) {
    }

    public void onAnimationStart(@Nullable Animation animation) {
    }

    ReportCardsActivity$closeActivity$1(ReportCardsActivity reportCardsActivity) {
        this.this$0 = reportCardsActivity;
    }

    public void onAnimationEnd(@Nullable Animation animation) {
        this.this$0.finish();
        this.this$0.overridePendingTransition(17432576, 17432577);
    }
}
