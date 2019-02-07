package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.adapters.DistrictsAdapter;
import com.aeries.mobileportal.presenters.change_district.ChangeDistrictPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ChangeDistrictActivity_MembersInjector implements MembersInjector<ChangeDistrictActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<DistrictsAdapter> adapterProvider;
    private final Provider<ChangeDistrictPresenter> presenterProvider;

    public ChangeDistrictActivity_MembersInjector(Provider<ChangeDistrictPresenter> provider, Provider<DistrictsAdapter> provider2) {
        this.presenterProvider = provider;
        this.adapterProvider = provider2;
    }

    public static MembersInjector<ChangeDistrictActivity> create(Provider<ChangeDistrictPresenter> provider, Provider<DistrictsAdapter> provider2) {
        return new ChangeDistrictActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(ChangeDistrictActivity changeDistrictActivity) {
        if (changeDistrictActivity != null) {
            changeDistrictActivity.presenter = (ChangeDistrictPresenter) this.presenterProvider.get();
            changeDistrictActivity.adapter = (DistrictsAdapter) this.adapterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
