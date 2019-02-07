package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.demographics.DemographicsPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class DemographicsActivity_MembersInjector implements MembersInjector<DemographicsActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<DemographicsPresenter> presenterProvider;

    public DemographicsActivity_MembersInjector(Provider<DemographicsPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<DemographicsActivity> create(Provider<DemographicsPresenter> provider) {
        return new DemographicsActivity_MembersInjector(provider);
    }

    public void injectMembers(DemographicsActivity demographicsActivity) {
        if (demographicsActivity != null) {
            demographicsActivity.presenter = (DemographicsPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
