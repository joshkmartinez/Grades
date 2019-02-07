package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.demographics.DemographicsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class DemographicsPresenterModule_DemographicsViewModelFactory implements Factory<DemographicsViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final DemographicsPresenterModule module;

    public DemographicsPresenterModule_DemographicsViewModelFactory(DemographicsPresenterModule demographicsPresenterModule) {
        this.module = demographicsPresenterModule;
    }

    public DemographicsViewModel get() {
        return (DemographicsViewModel) Preconditions.checkNotNull(this.module.demographicsViewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<DemographicsViewModel> create(DemographicsPresenterModule demographicsPresenterModule) {
        return new DemographicsPresenterModule_DemographicsViewModelFactory(demographicsPresenterModule);
    }
}
