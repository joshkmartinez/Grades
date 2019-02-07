package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.supplemental_attendance.ClassCheckInViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ClassCheckInPresenterModule_ClassCheckInViewModelFactory implements Factory<ClassCheckInViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ClassCheckInPresenterModule module;

    public ClassCheckInPresenterModule_ClassCheckInViewModelFactory(ClassCheckInPresenterModule classCheckInPresenterModule) {
        this.module = classCheckInPresenterModule;
    }

    public ClassCheckInViewModel get() {
        return (ClassCheckInViewModel) Preconditions.checkNotNull(this.module.classCheckInViewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ClassCheckInViewModel> create(ClassCheckInPresenterModule classCheckInPresenterModule) {
        return new ClassCheckInPresenterModule_ClassCheckInViewModelFactory(classCheckInPresenterModule);
    }
}
