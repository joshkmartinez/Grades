package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.components.DaggerSplashScreenActivityComponent;
import com.aeries.mobileportal.dagger.components.SplashScreenActivityComponent;
import com.aeries.mobileportal.dagger.modules.SplashScreenPresenterModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/SplashScreenActivityComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: SplashScreenActivity.kt */
final class SplashScreenActivity$component$2 extends Lambda implements Function0<SplashScreenActivityComponent> {
    final /* synthetic */ SplashScreenActivity this$0;

    SplashScreenActivity$component$2(SplashScreenActivity splashScreenActivity) {
        this.this$0 = splashScreenActivity;
        super(0);
    }

    public final SplashScreenActivityComponent invoke() {
        return DaggerSplashScreenActivityComponent.builder().splashScreenPresenterModule(new SplashScreenPresenterModule(this.this$0)).pSPComponent(PSPApplication.Companion.get((Activity) this.this$0)).build();
    }
}
