package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.school.select.SchoolSearchInteractor;
import com.aeries.mobileportal.presenters.school.select.SchoolSearchPresenter;
import com.aeries.mobileportal.views.viewmodels.school_select.SchoolSearchViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SchoolSearchPresenterModule_SchoolSearchPresenterFactory implements Factory<SchoolSearchPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SchoolSearchPresenterModule module;
    private final Provider<SchoolSearchInteractor> schoolSearchInteractorProvider;
    private final Provider<SchoolSearchViewModel> schoolSearchViewModelProvider;

    public SchoolSearchPresenterModule_SchoolSearchPresenterFactory(SchoolSearchPresenterModule schoolSearchPresenterModule, Provider<SchoolSearchViewModel> provider, Provider<SchoolSearchInteractor> provider2) {
        this.module = schoolSearchPresenterModule;
        this.schoolSearchViewModelProvider = provider;
        this.schoolSearchInteractorProvider = provider2;
    }

    public SchoolSearchPresenter get() {
        return (SchoolSearchPresenter) Preconditions.checkNotNull(this.module.schoolSearchPresenter((SchoolSearchViewModel) this.schoolSearchViewModelProvider.get(), (SchoolSearchInteractor) this.schoolSearchInteractorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SchoolSearchPresenter> create(SchoolSearchPresenterModule schoolSearchPresenterModule, Provider<SchoolSearchViewModel> provider, Provider<SchoolSearchInteractor> provider2) {
        return new SchoolSearchPresenterModule_SchoolSearchPresenterFactory(schoolSearchPresenterModule, provider, provider2);
    }
}
