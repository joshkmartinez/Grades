package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.components.AttendanceActivityComponent;
import com.aeries.mobileportal.dagger.components.DaggerAttendanceActivityComponent;
import com.aeries.mobileportal.dagger.modules.AttendancePresenterModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/AttendanceActivityComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: AttendanceActivity.kt */
final class AttendanceActivity$component$2 extends Lambda implements Function0<AttendanceActivityComponent> {
    final /* synthetic */ AttendanceActivity this$0;

    AttendanceActivity$component$2(AttendanceActivity attendanceActivity) {
        this.this$0 = attendanceActivity;
        super(0);
    }

    public final AttendanceActivityComponent invoke() {
        return DaggerAttendanceActivityComponent.builder().attendancePresenterModule(new AttendancePresenterModule(this.this$0)).pSPComponent(PSPApplication.Companion.get((Activity) this.this$0)).build();
    }
}
