package com.aeries.mobileportal.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import com.aeries.mobileportal.adapters.AttendanceAdapter.AttendanceHolderPeriod;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"com/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceHolderPeriod$bindView$layoutManager$1", "Landroid/support/v7/widget/LinearLayoutManager;", "(Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceHolderPeriod;Landroid/content/Context;IZ)V", "canScrollHorizontally", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AttendanceAdapter.kt */
public final class C0961x4826acde extends LinearLayoutManager {
    final /* synthetic */ AttendanceHolderPeriod this$0;

    public boolean canScrollHorizontally() {
        return false;
    }

    C0961x4826acde(AttendanceHolderPeriod attendanceHolderPeriod, Context context, int i, boolean z) {
        this.this$0 = attendanceHolderPeriod;
        super(context, i, z);
    }
}
