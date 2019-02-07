package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.PeriodsAdapter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AttendanceDetailFragment_MembersInjector implements MembersInjector<AttendanceDetailFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<PeriodsAdapter> adapterProvider;

    public AttendanceDetailFragment_MembersInjector(Provider<PeriodsAdapter> provider) {
        this.adapterProvider = provider;
    }

    public static MembersInjector<AttendanceDetailFragment> create(Provider<PeriodsAdapter> provider) {
        return new AttendanceDetailFragment_MembersInjector(provider);
    }

    public void injectMembers(AttendanceDetailFragment attendanceDetailFragment) {
        if (attendanceDetailFragment != null) {
            attendanceDetailFragment.adapter = (PeriodsAdapter) this.adapterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
