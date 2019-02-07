package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.AttendanceAdapter.AttendanceListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AttendanceListFragmentModule_AttendanceListenerFactory implements Factory<AttendanceListener> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AttendanceListFragmentModule module;

    public AttendanceListFragmentModule_AttendanceListenerFactory(AttendanceListFragmentModule attendanceListFragmentModule) {
        this.module = attendanceListFragmentModule;
    }

    public AttendanceListener get() {
        return (AttendanceListener) Preconditions.checkNotNull(this.module.attendanceListener(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AttendanceListener> create(AttendanceListFragmentModule attendanceListFragmentModule) {
        return new AttendanceListFragmentModule_AttendanceListenerFactory(attendanceListFragmentModule);
    }
}
