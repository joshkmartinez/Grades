package com.aeries.mobileportal.adapters;

import android.view.View;
import android.view.View.OnClickListener;
import com.aeries.mobileportal.adapters.DemographicsAdapter.DemographicDetailHolder;
import com.aeries.mobileportal.enums.DemographicsDetails;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
/* compiled from: DemographicsAdapter.kt */
final class DemographicsAdapter$DemographicDetailHolder$bindData$1 implements OnClickListener {
    final /* synthetic */ DemographicsDetails $detail;
    final /* synthetic */ DemographicDetailHolder this$0;

    DemographicsAdapter$DemographicDetailHolder$bindData$1(DemographicDetailHolder demographicDetailHolder, DemographicsDetails demographicsDetails) {
        this.this$0 = demographicDetailHolder;
        this.$detail = demographicsDetails;
    }

    public final void onClick(View view) {
        view = this.$detail.getOnClickInfo(this.this$0.this$0.getDemographics());
        if (this.$detail == DemographicsDetails.primaryPhone) {
            this.this$0.this$0.getListener().onPhoneSelected(view);
        } else if (this.$detail == DemographicsDetails.teacherEmail) {
            this.this$0.this$0.getListener().onEmailSelected(view);
        } else if (view != null) {
            this.this$0.this$0.getListener().onAddressSelected(view);
        }
    }
}
