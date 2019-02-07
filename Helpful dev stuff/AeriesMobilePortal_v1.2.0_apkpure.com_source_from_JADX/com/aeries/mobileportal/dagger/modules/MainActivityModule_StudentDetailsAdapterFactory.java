package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.StudentDetailsAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class MainActivityModule_StudentDetailsAdapterFactory implements Factory<StudentDetailsAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final MainActivityModule module;

    public MainActivityModule_StudentDetailsAdapterFactory(MainActivityModule mainActivityModule) {
        this.module = mainActivityModule;
    }

    public StudentDetailsAdapter get() {
        return (StudentDetailsAdapter) Preconditions.checkNotNull(this.module.studentDetailsAdapter(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<StudentDetailsAdapter> create(MainActivityModule mainActivityModule) {
        return new MainActivityModule_StudentDetailsAdapterFactory(mainActivityModule);
    }
}
