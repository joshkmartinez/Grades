package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.supplementan_attendance.ClassCheckInInteractor;
import com.aeries.mobileportal.presenters.supplemental_attendance.ClassCheckInPresenter;
import com.aeries.mobileportal.views.viewmodels.supplemental_attendance.ClassCheckInViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ClassCheckInPresenterModule_ClassCheckInPresenterFactory implements Factory<ClassCheckInPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ClassCheckInInteractor> classCheckInInteractorProvider;
    private final Provider<ClassCheckInViewModel> classCheckInViewModelProvider;
    private final ClassCheckInPresenterModule module;

    public ClassCheckInPresenterModule_ClassCheckInPresenterFactory(ClassCheckInPresenterModule classCheckInPresenterModule, Provider<ClassCheckInViewModel> provider, Provider<ClassCheckInInteractor> provider2) {
        this.module = classCheckInPresenterModule;
        this.classCheckInViewModelProvider = provider;
        this.classCheckInInteractorProvider = provider2;
    }

    public ClassCheckInPresenter get() {
        return (ClassCheckInPresenter) Preconditions.checkNotNull(this.module.classCheckInPresenter((ClassCheckInViewModel) this.classCheckInViewModelProvider.get(), (ClassCheckInInteractor) this.classCheckInInteractorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ClassCheckInPresenter> create(ClassCheckInPresenterModule classCheckInPresenterModule, Provider<ClassCheckInViewModel> provider, Provider<ClassCheckInInteractor> provider2) {
        return new ClassCheckInPresenterModule_ClassCheckInPresenterFactory(classCheckInPresenterModule, provider, provider2);
    }
}
