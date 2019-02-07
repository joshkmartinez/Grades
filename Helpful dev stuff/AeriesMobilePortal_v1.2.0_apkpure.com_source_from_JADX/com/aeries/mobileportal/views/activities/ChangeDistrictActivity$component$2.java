package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.components.ChangeDistrictActivityComponent;
import com.aeries.mobileportal.dagger.components.DaggerChangeDistrictActivityComponent;
import com.aeries.mobileportal.dagger.modules.ChangeDistrictPresenterModule;
import com.aeries.mobileportal.dagger.modules.DistrictsAdapterModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/ChangeDistrictActivityComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: ChangeDistrictActivity.kt */
final class ChangeDistrictActivity$component$2 extends Lambda implements Function0<ChangeDistrictActivityComponent> {
    final /* synthetic */ ChangeDistrictActivity this$0;

    ChangeDistrictActivity$component$2(ChangeDistrictActivity changeDistrictActivity) {
        this.this$0 = changeDistrictActivity;
        super(0);
    }

    public final ChangeDistrictActivityComponent invoke() {
        return DaggerChangeDistrictActivityComponent.builder().pSPComponent(PSPApplication.Companion.get((Activity) this.this$0)).changeDistrictPresenterModule(new ChangeDistrictPresenterModule(this.this$0)).districtsAdapterModule(new DistrictsAdapterModule(this.this$0)).build();
    }
}
