package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.StudentDetailsAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class MainFragmentModule_StudentDetailsAdapterFactory implements Factory<StudentDetailsAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final MainFragmentModule module;

    public MainFragmentModule_StudentDetailsAdapterFactory(MainFragmentModule mainFragmentModule) {
        this.module = mainFragmentModule;
    }

    public StudentDetailsAdapter get() {
        return (StudentDetailsAdapter) Preconditions.checkNotNull(this.module.studentDetailsAdapter(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<StudentDetailsAdapter> create(MainFragmentModule mainFragmentModule) {
        return new MainFragmentModule_StudentDetailsAdapterFactory(mainFragmentModule);
    }
}
