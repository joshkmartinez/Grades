package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.attendance.AttendancePresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AttendanceActivity_MembersInjector implements MembersInjector<AttendanceActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AttendancePresenter> presenterProvider;

    public AttendanceActivity_MembersInjector(Provider<AttendancePresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<AttendanceActivity> create(Provider<AttendancePresenter> provider) {
        return new AttendanceActivity_MembersInjector(provider);
    }

    public void injectMembers(AttendanceActivity attendanceActivity) {
        if (attendanceActivity != null) {
            attendanceActivity.presenter = (AttendancePresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
