package com.aeries.mobileportal.adapters;

import android.view.View;
import android.view.View.OnClickListener;
import com.aeries.mobileportal.adapters.DistrictsAdapter.DistrictHolder;
import com.aeries.mobileportal.models.School;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
/* compiled from: DistrictsAdapter.kt */
final class DistrictsAdapter$DistrictHolder$bindData$1 implements OnClickListener {
    final /* synthetic */ School $school;
    final /* synthetic */ DistrictHolder this$0;

    DistrictsAdapter$DistrictHolder$bindData$1(DistrictHolder districtHolder, School school) {
        this.this$0 = districtHolder;
        this.$school = school;
    }

    public final void onClick(View view) {
        CharSequence aeriesAppParentURL = this.$school.getAeriesAppParentURL();
        if (aeriesAppParentURL != null) {
            if (aeriesAppParentURL.length() != null) {
                view = null;
                if (view == null) {
                    this.this$0.this$0.getListener().onDistrictURLEmpty();
                } else {
                    this.this$0.this$0.getListener().onDistrictSelected(this.$school);
                }
            }
        }
        view = true;
        if (view == null) {
            this.this$0.this$0.getListener().onDistrictSelected(this.$school);
        } else {
            this.this$0.this$0.getListener().onDistrictURLEmpty();
        }
    }
}
