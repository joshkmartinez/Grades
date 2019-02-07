package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.components.DaggerFeedbackActivityComponent;
import com.aeries.mobileportal.dagger.components.FeedbackActivityComponent;
import com.aeries.mobileportal.dagger.modules.FeedbackPresenterModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/FeedbackActivityComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: FeedbackActivity.kt */
final class FeedbackActivity$component$2 extends Lambda implements Function0<FeedbackActivityComponent> {
    final /* synthetic */ FeedbackActivity this$0;

    FeedbackActivity$component$2(FeedbackActivity feedbackActivity) {
        this.this$0 = feedbackActivity;
        super(0);
    }

    public final FeedbackActivityComponent invoke() {
        return DaggerFeedbackActivityComponent.builder().feedbackPresenterModule(new FeedbackPresenterModule(this.this$0)).pSPComponent(PSPApplication.Companion.get((Activity) this.this$0)).build();
    }
}
