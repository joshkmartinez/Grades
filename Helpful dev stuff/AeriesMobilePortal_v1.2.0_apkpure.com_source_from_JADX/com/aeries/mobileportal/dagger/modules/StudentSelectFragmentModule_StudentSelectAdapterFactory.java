package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.StudentSelectAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class StudentSelectFragmentModule_StudentSelectAdapterFactory implements Factory<StudentSelectAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final StudentSelectFragmentModule module;

    public StudentSelectFragmentModule_StudentSelectAdapterFactory(StudentSelectFragmentModule studentSelectFragmentModule) {
        this.module = studentSelectFragmentModule;
    }

    public StudentSelectAdapter get() {
        return (StudentSelectAdapter) Preconditions.checkNotNull(this.module.studentSelectAdapter(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<StudentSelectAdapter> create(StudentSelectFragmentModule studentSelectFragmentModule) {
        return new StudentSelectFragmentModule_StudentSelectAdapterFactory(studentSelectFragmentModule);
    }
}
