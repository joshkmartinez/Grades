package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.DemographicsAdapter.DemographicsListener;
import com.aeries.mobileportal.dagger.components.DaggerDemographicsFragmentComponent;
import com.aeries.mobileportal.dagger.components.DaggerDemographicsFragmentComponent.Builder;
import com.aeries.mobileportal.dagger.components.DemographicsFragmentComponent;
import com.aeries.mobileportal.dagger.modules.DemographicsAdapterModule;
import com.aeries.mobileportal.models.Demographics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/DemographicsFragmentComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: DemographicsFragment.kt */
final class DemographicsFragment$component$2 extends Lambda implements Function0<DemographicsFragmentComponent> {
    final /* synthetic */ DemographicsFragment this$0;

    DemographicsFragment$component$2(DemographicsFragment demographicsFragment) {
        this.this$0 = demographicsFragment;
        super(0);
    }

    public final DemographicsFragmentComponent invoke() {
        Builder builder = DaggerDemographicsFragmentComponent.builder();
        DemographicsListener demographicsListener = this.this$0;
        Demographics access$getMDemographics$p = this.this$0.mDemographics;
        if (access$getMDemographics$p == null) {
            Intrinsics.throwNpe();
        }
        return builder.demographicsAdapterModule(new DemographicsAdapterModule(demographicsListener, access$getMDemographics$p)).build();
    }
}
