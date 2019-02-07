package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.StudentSelectInteractor;
import com.aeries.mobileportal.presenters.StudentSelectPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class StudentSelectFragmentModule_StudentSelectPresenterFactory implements Factory<StudentSelectPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<StudentSelectInteractor> interactorProvider;
    private final StudentSelectFragmentModule module;

    public StudentSelectFragmentModule_StudentSelectPresenterFactory(StudentSelectFragmentModule studentSelectFragmentModule, Provider<StudentSelectInteractor> provider) {
        this.module = studentSelectFragmentModule;
        this.interactorProvider = provider;
    }

    public StudentSelectPresenter get() {
        return (StudentSelectPresenter) Preconditions.checkNotNull(this.module.studentSelectPresenter((StudentSelectInteractor) this.interactorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<StudentSelectPresenter> create(StudentSelectFragmentModule studentSelectFragmentModule, Provider<StudentSelectInteractor> provider) {
        return new StudentSelectFragmentModule_StudentSelectPresenterFactory(studentSelectFragmentModule, provider);
    }
}
