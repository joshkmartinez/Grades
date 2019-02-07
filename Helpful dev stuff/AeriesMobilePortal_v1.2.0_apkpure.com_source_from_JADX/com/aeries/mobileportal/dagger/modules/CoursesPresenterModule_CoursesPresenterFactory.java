package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.grades.CoursesInteractor;
import com.aeries.mobileportal.presenters.grades.CoursesPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CoursesPresenterModule_CoursesPresenterFactory implements Factory<CoursesPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<CoursesInteractor> interactorProvider;
    private final CoursesPresenterModule module;

    public CoursesPresenterModule_CoursesPresenterFactory(CoursesPresenterModule coursesPresenterModule, Provider<CoursesInteractor> provider) {
        this.module = coursesPresenterModule;
        this.interactorProvider = provider;
    }

    public CoursesPresenter get() {
        return (CoursesPresenter) Preconditions.checkNotNull(this.module.coursesPresenter((CoursesInteractor) this.interactorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<CoursesPresenter> create(CoursesPresenterModule coursesPresenterModule, Provider<CoursesInteractor> provider) {
        return new CoursesPresenterModule_CoursesPresenterFactory(coursesPresenterModule, provider);
    }
}
