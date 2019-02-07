package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.grades.GradesInteractor;
import com.aeries.mobileportal.presenters.grades.GradesPresenter;
import com.aeries.mobileportal.views.viewmodels.grades.GradesViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class GradesPresenterModule_GradesPresenterFactory implements Factory<GradesPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<GradesInteractor> gradesInteractorProvider;
    private final Provider<GradesViewModel> gradesViewModelProvider;
    private final GradesPresenterModule module;

    public GradesPresenterModule_GradesPresenterFactory(GradesPresenterModule gradesPresenterModule, Provider<GradesViewModel> provider, Provider<GradesInteractor> provider2) {
        this.module = gradesPresenterModule;
        this.gradesViewModelProvider = provider;
        this.gradesInteractorProvider = provider2;
    }

    public GradesPresenter get() {
        return (GradesPresenter) Preconditions.checkNotNull(this.module.gradesPresenter((GradesViewModel) this.gradesViewModelProvider.get(), (GradesInteractor) this.gradesInteractorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<GradesPresenter> create(GradesPresenterModule gradesPresenterModule, Provider<GradesViewModel> provider, Provider<GradesInteractor> provider2) {
        return new GradesPresenterModule_GradesPresenterFactory(gradesPresenterModule, provider, provider2);
    }
}
