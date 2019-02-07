package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.AttendanceAdapter;
import com.aeries.mobileportal.adapters.AttendanceAdapter.AttendanceListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AttendanceListFragmentModule_AttendanceAdapterFactory implements Factory<AttendanceAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AttendanceListener> attendanceListenerProvider;
    private final AttendanceListFragmentModule module;

    public AttendanceListFragmentModule_AttendanceAdapterFactory(AttendanceListFragmentModule attendanceListFragmentModule, Provider<AttendanceListener> provider) {
        this.module = attendanceListFragmentModule;
        this.attendanceListenerProvider = provider;
    }

    public AttendanceAdapter get() {
        return (AttendanceAdapter) Preconditions.checkNotNull(this.module.attendanceAdapter((AttendanceListener) this.attendanceListenerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AttendanceAdapter> create(AttendanceListFragmentModule attendanceListFragmentModule, Provider<AttendanceListener> provider) {
        return new AttendanceListFragmentModule_AttendanceAdapterFactory(attendanceListFragmentModule, provider);
    }
}
