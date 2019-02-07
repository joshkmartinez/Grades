package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.supplemental_attendance.SupplementalAttendancePresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SupplementalAttendanceActivity_MembersInjector implements MembersInjector<SupplementalAttendanceActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<SupplementalAttendancePresenter> presenterProvider;

    public SupplementalAttendanceActivity_MembersInjector(Provider<SupplementalAttendancePresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<SupplementalAttendanceActivity> create(Provider<SupplementalAttendancePresenter> provider) {
        return new SupplementalAttendanceActivity_MembersInjector(provider);
    }

    public void injectMembers(SupplementalAttendanceActivity supplementalAttendanceActivity) {
        if (supplementalAttendanceActivity != null) {
            supplementalAttendanceActivity.presenter = (SupplementalAttendancePresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
