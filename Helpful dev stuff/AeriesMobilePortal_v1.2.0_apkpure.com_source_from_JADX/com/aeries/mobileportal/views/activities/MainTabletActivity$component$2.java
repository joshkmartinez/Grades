package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.components.DaggerMainTabletActivityComponent;
import com.aeries.mobileportal.dagger.components.MainTabletActivityComponent;
import com.aeries.mobileportal.dagger.modules.MainTabletPresenterModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/MainTabletActivityComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: MainTabletActivity.kt */
final class MainTabletActivity$component$2 extends Lambda implements Function0<MainTabletActivityComponent> {
    final /* synthetic */ MainTabletActivity this$0;

    MainTabletActivity$component$2(MainTabletActivity mainTabletActivity) {
        this.this$0 = mainTabletActivity;
        super(0);
    }

    public final MainTabletActivityComponent invoke() {
        return DaggerMainTabletActivityComponent.builder().mainTabletPresenterModule(new MainTabletPresenterModule(this.this$0)).pSPComponent(PSPApplication.Companion.get((Activity) this.this$0)).build();
    }
}
