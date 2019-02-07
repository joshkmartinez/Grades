package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.supplementan_attendance.SupplementalAttendanceInteractor;
import com.aeries.mobileportal.presenters.supplemental_attendance.SupplementalAttendancePresenter;
import com.aeries.mobileportal.views.viewmodels.supplemental_attendance.SupplementalAttendanceViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class C0964x8bf4dcc7 implements Factory<SupplementalAttendancePresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SupplementalAttendancePresenterModule module;
    private final Provider<SupplementalAttendanceInteractor> supplementalAttendanceInteractorProvider;
    private final Provider<SupplementalAttendanceViewModel> supplementalAttendanceViewModelProvider;

    public C0964x8bf4dcc7(SupplementalAttendancePresenterModule supplementalAttendancePresenterModule, Provider<SupplementalAttendanceViewModel> provider, Provider<SupplementalAttendanceInteractor> provider2) {
        this.module = supplementalAttendancePresenterModule;
        this.supplementalAttendanceViewModelProvider = provider;
        this.supplementalAttendanceInteractorProvider = provider2;
    }

    public SupplementalAttendancePresenter get() {
        return (SupplementalAttendancePresenter) Preconditions.checkNotNull(this.module.supplementalAttendancePresenter((SupplementalAttendanceViewModel) this.supplementalAttendanceViewModelProvider.get(), (SupplementalAttendanceInteractor) this.supplementalAttendanceInteractorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SupplementalAttendancePresenter> create(SupplementalAttendancePresenterModule supplementalAttendancePresenterModule, Provider<SupplementalAttendanceViewModel> provider, Provider<SupplementalAttendanceInteractor> provider2) {
        return new C0964x8bf4dcc7(supplementalAttendancePresenterModule, provider, provider2);
    }
}
