package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.components.AddDistrictActivityComponent;
import com.aeries.mobileportal.dagger.components.DaggerAddDistrictActivityComponent;
import com.aeries.mobileportal.dagger.modules.AddDistrictPresenterModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/AddDistrictActivityComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: AddDistrictActivity.kt */
final class AddDistrictActivity$component$2 extends Lambda implements Function0<AddDistrictActivityComponent> {
    final /* synthetic */ AddDistrictActivity this$0;

    AddDistrictActivity$component$2(AddDistrictActivity addDistrictActivity) {
        this.this$0 = addDistrictActivity;
        super(0);
    }

    public final AddDistrictActivityComponent invoke() {
        return DaggerAddDistrictActivityComponent.builder().addDistrictPresenterModule(new AddDistrictPresenterModule(this.this$0)).pSPComponent(PSPApplication.Companion.get((Activity) this.this$0)).build();
    }
}
