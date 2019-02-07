package com.aeries.mobileportal.adapters;

import android.view.View;
import android.view.View.OnClickListener;
import com.aeries.mobileportal.adapters.AttendanceAdapter.PeriodAdapter.PeriodHolder;
import com.aeries.mobileportal.models.AttendanceDetail;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
/* compiled from: AttendanceAdapter.kt */
final class AttendanceAdapter$PeriodAdapter$PeriodHolder$bindView$1 implements OnClickListener {
    final /* synthetic */ AttendanceDetail $attendance;
    final /* synthetic */ PeriodHolder this$0;

    AttendanceAdapter$PeriodAdapter$PeriodHolder$bindView$1(PeriodHolder periodHolder, AttendanceDetail attendanceDetail) {
        this.this$0 = periodHolder;
        this.$attendance = attendanceDetail;
    }

    public final void onClick(View view) {
        this.this$0.this$0.this$0.getListener().onAttendanceSelected(this.$attendance);
    }
}
