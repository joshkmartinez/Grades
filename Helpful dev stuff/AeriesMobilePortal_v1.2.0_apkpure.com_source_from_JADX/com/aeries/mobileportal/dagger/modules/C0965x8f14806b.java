package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.supplemental_attendance.SupplementalAttendanceViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class C0965x8f14806b implements Factory<SupplementalAttendanceViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SupplementalAttendancePresenterModule module;

    public C0965x8f14806b(SupplementalAttendancePresenterModule supplementalAttendancePresenterModule) {
        this.module = supplementalAttendancePresenterModule;
    }

    public SupplementalAttendanceViewModel get() {
        return (SupplementalAttendanceViewModel) Preconditions.checkNotNull(this.module.supplementalAttendanceViewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SupplementalAttendanceViewModel> create(SupplementalAttendancePresenterModule supplementalAttendancePresenterModule) {
        return new C0965x8f14806b(supplementalAttendancePresenterModule);
    }
}
