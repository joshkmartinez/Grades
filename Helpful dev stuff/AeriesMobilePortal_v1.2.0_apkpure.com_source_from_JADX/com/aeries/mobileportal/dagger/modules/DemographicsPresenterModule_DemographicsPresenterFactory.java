package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.demographics.DemographicsInteractor;
import com.aeries.mobileportal.presenters.demographics.DemographicsPresenter;
import com.aeries.mobileportal.views.viewmodels.demographics.DemographicsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DemographicsPresenterModule_DemographicsPresenterFactory implements Factory<DemographicsPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<DemographicsInteractor> interactorProvider;
    private final DemographicsPresenterModule module;
    private final Provider<DemographicsViewModel> viewModelProvider;

    public DemographicsPresenterModule_DemographicsPresenterFactory(DemographicsPresenterModule demographicsPresenterModule, Provider<DemographicsViewModel> provider, Provider<DemographicsInteractor> provider2) {
        this.module = demographicsPresenterModule;
        this.viewModelProvider = provider;
        this.interactorProvider = provider2;
    }

    public DemographicsPresenter get() {
        return (DemographicsPresenter) Preconditions.checkNotNull(this.module.demographicsPresenter((DemographicsViewModel) this.viewModelProvider.get(), (DemographicsInteractor) this.interactorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<DemographicsPresenter> create(DemographicsPresenterModule demographicsPresenterModule, Provider<DemographicsViewModel> provider, Provider<DemographicsInteractor> provider2) {
        return new DemographicsPresenterModule_DemographicsPresenterFactory(demographicsPresenterModule, provider, provider2);
    }
}
