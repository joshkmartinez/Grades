package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.DemographicsAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class DemographicsAdapterModule_DemographicsAdapterFactory implements Factory<DemographicsAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final DemographicsAdapterModule module;

    public DemographicsAdapterModule_DemographicsAdapterFactory(DemographicsAdapterModule demographicsAdapterModule) {
        this.module = demographicsAdapterModule;
    }

    public DemographicsAdapter get() {
        return (DemographicsAdapter) Preconditions.checkNotNull(this.module.demographicsAdapter(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<DemographicsAdapter> create(DemographicsAdapterModule demographicsAdapterModule) {
        return new DemographicsAdapterModule_DemographicsAdapterFactory(demographicsAdapterModule);
    }
}
