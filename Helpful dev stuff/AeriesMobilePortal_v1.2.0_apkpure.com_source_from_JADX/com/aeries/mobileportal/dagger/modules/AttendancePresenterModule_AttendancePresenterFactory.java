package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.attendance.AttendanceInteractor;
import com.aeries.mobileportal.presenters.attendance.AttendancePresenter;
import com.aeries.mobileportal.views.viewmodels.attendance.AttendanceViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AttendancePresenterModule_AttendancePresenterFactory implements Factory<AttendancePresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AttendanceInteractor> attendanceInteractorProvider;
    private final Provider<AttendanceViewModel> attendanceViewModelProvider;
    private final AttendancePresenterModule module;

    public AttendancePresenterModule_AttendancePresenterFactory(AttendancePresenterModule attendancePresenterModule, Provider<AttendanceViewModel> provider, Provider<AttendanceInteractor> provider2) {
        this.module = attendancePresenterModule;
        this.attendanceViewModelProvider = provider;
        this.attendanceInteractorProvider = provider2;
    }

    public AttendancePresenter get() {
        return (AttendancePresenter) Preconditions.checkNotNull(this.module.attendancePresenter((AttendanceViewModel) this.attendanceViewModelProvider.get(), (AttendanceInteractor) this.attendanceInteractorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AttendancePresenter> create(AttendancePresenterModule attendancePresenterModule, Provider<AttendanceViewModel> provider, Provider<AttendanceInteractor> provider2) {
        return new AttendancePresenterModule_AttendancePresenterFactory(attendancePresenterModule, provider, provider2);
    }
}
