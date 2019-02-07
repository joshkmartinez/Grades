package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.AttendanceAdapter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AttendanceListFragment_MembersInjector implements MembersInjector<AttendanceListFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AttendanceAdapter> adapterProvider;

    public AttendanceListFragment_MembersInjector(Provider<AttendanceAdapter> provider) {
        this.adapterProvider = provider;
    }

    public static MembersInjector<AttendanceListFragment> create(Provider<AttendanceAdapter> provider) {
        return new AttendanceListFragment_MembersInjector(provider);
    }

    public void injectMembers(AttendanceListFragment attendanceListFragment) {
        if (attendanceListFragment != null) {
            attendanceListFragment.adapter = (AttendanceAdapter) this.adapterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
