package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.PeriodsAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AttendanceDetailFragmentModule_PeriodsAdapterFactory implements Factory<PeriodsAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AttendanceDetailFragmentModule module;

    public AttendanceDetailFragmentModule_PeriodsAdapterFactory(AttendanceDetailFragmentModule attendanceDetailFragmentModule) {
        this.module = attendanceDetailFragmentModule;
    }

    public PeriodsAdapter get() {
        return (PeriodsAdapter) Preconditions.checkNotNull(this.module.periodsAdapter(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<PeriodsAdapter> create(AttendanceDetailFragmentModule attendanceDetailFragmentModule) {
        return new AttendanceDetailFragmentModule_PeriodsAdapterFactory(attendanceDetailFragmentModule);
    }
}
