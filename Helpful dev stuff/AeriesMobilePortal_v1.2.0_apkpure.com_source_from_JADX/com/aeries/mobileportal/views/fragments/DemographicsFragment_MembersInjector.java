package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.DemographicsAdapter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class DemographicsFragment_MembersInjector implements MembersInjector<DemographicsFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<DemographicsAdapter> adapterProvider;

    public DemographicsFragment_MembersInjector(Provider<DemographicsAdapter> provider) {
        this.adapterProvider = provider;
    }

    public static MembersInjector<DemographicsFragment> create(Provider<DemographicsAdapter> provider) {
        return new DemographicsFragment_MembersInjector(provider);
    }

    public void injectMembers(DemographicsFragment demographicsFragment) {
        if (demographicsFragment != null) {
            demographicsFragment.adapter = (DemographicsAdapter) this.adapterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
