package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.dagger.components.AttendanceDetailFragmentComponent;
import com.aeries.mobileportal.dagger.components.DaggerAttendanceDetailFragmentComponent;
import com.aeries.mobileportal.dagger.components.DaggerAttendanceDetailFragmentComponent.Builder;
import com.aeries.mobileportal.dagger.modules.AttendanceDetailFragmentModule;
import com.aeries.mobileportal.models.AttendanceDetail;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/AttendanceDetailFragmentComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: AttendanceDetailFragment.kt */
final class AttendanceDetailFragment$component$2 extends Lambda implements Function0<AttendanceDetailFragmentComponent> {
    final /* synthetic */ AttendanceDetailFragment this$0;

    AttendanceDetailFragment$component$2(AttendanceDetailFragment attendanceDetailFragment) {
        this.this$0 = attendanceDetailFragment;
        super(0);
    }

    public final AttendanceDetailFragmentComponent invoke() {
        List attendancePeriods;
        Builder builder = DaggerAttendanceDetailFragmentComponent.builder();
        AttendanceDetail access$getMDetail$p = this.this$0.mDetail;
        if (access$getMDetail$p != null) {
            attendancePeriods = access$getMDetail$p.getAttendancePeriods();
            if (attendancePeriods != null) {
                return builder.attendanceDetailFragmentModule(new AttendanceDetailFragmentModule(attendancePeriods)).build();
            }
        }
        attendancePeriods = new ArrayList();
        return builder.attendanceDetailFragmentModule(new AttendanceDetailFragmentModule(attendancePeriods)).build();
    }
}
