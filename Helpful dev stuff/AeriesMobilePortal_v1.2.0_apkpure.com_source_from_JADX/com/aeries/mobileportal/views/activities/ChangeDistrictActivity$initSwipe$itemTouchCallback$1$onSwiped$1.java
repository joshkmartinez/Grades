package com.aeries.mobileportal.views.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.aeries.mobileportal.models.School;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 1, 10})
/* compiled from: ChangeDistrictActivity.kt */
final class ChangeDistrictActivity$initSwipe$itemTouchCallback$1$onSwiped$1 implements OnClickListener {
    final /* synthetic */ Integer $position;
    final /* synthetic */ ChangeDistrictActivity$initSwipe$itemTouchCallback$1 this$0;

    ChangeDistrictActivity$initSwipe$itemTouchCallback$1$onSwiped$1(ChangeDistrictActivity$initSwipe$itemTouchCallback$1 changeDistrictActivity$initSwipe$itemTouchCallback$1, Integer num) {
        this.this$0 = changeDistrictActivity$initSwipe$itemTouchCallback$1;
        this.$position = num;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.$position != null) {
            this.this$0.this$0.getPresenter().deleteDistrict((School) this.this$0.this$0.getAdapter().getSchools().get(this.$position.intValue()));
        }
    }
}
