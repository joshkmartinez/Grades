package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.add_district.AddDistrictPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AddDistrictActivity_MembersInjector implements MembersInjector<AddDistrictActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AddDistrictPresenter> presenterProvider;

    public AddDistrictActivity_MembersInjector(Provider<AddDistrictPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<AddDistrictActivity> create(Provider<AddDistrictPresenter> provider) {
        return new AddDistrictActivity_MembersInjector(provider);
    }

    public void injectMembers(AddDistrictActivity addDistrictActivity) {
        if (addDistrictActivity != null) {
            addDistrictActivity.presenter = (AddDistrictPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
