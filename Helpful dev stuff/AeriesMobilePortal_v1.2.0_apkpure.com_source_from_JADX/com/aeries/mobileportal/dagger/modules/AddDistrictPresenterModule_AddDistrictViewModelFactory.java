package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.add_district.AddDistrictViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AddDistrictPresenterModule_AddDistrictViewModelFactory implements Factory<AddDistrictViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AddDistrictPresenterModule module;

    public AddDistrictPresenterModule_AddDistrictViewModelFactory(AddDistrictPresenterModule addDistrictPresenterModule) {
        this.module = addDistrictPresenterModule;
    }

    public AddDistrictViewModel get() {
        return (AddDistrictViewModel) Preconditions.checkNotNull(this.module.addDistrictViewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AddDistrictViewModel> create(AddDistrictPresenterModule addDistrictPresenterModule) {
        return new AddDistrictPresenterModule_AddDistrictViewModelFactory(addDistrictPresenterModule);
    }
}
