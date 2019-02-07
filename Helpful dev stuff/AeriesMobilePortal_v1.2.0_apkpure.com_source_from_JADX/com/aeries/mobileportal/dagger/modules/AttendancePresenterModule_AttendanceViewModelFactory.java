package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.attendance.AttendanceViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AttendancePresenterModule_AttendanceViewModelFactory implements Factory<AttendanceViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AttendancePresenterModule module;

    public AttendancePresenterModule_AttendanceViewModelFactory(AttendancePresenterModule attendancePresenterModule) {
        this.module = attendancePresenterModule;
    }

    public AttendanceViewModel get() {
        return (AttendanceViewModel) Preconditions.checkNotNull(this.module.attendanceViewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AttendanceViewModel> create(AttendancePresenterModule attendancePresenterModule) {
        return new AttendancePresenterModule_AttendanceViewModelFactory(attendancePresenterModule);
    }
}
