package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.change_district.ChangeDistrictViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ChangeDistrictPresenterModule_ChangeDistrictViewModelFactory implements Factory<ChangeDistrictViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ChangeDistrictPresenterModule module;

    public ChangeDistrictPresenterModule_ChangeDistrictViewModelFactory(ChangeDistrictPresenterModule changeDistrictPresenterModule) {
        this.module = changeDistrictPresenterModule;
    }

    public ChangeDistrictViewModel get() {
        return (ChangeDistrictViewModel) Preconditions.checkNotNull(this.module.changeDistrictViewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ChangeDistrictViewModel> create(ChangeDistrictPresenterModule changeDistrictPresenterModule) {
        return new ChangeDistrictPresenterModule_ChangeDistrictViewModelFactory(changeDistrictPresenterModule);
    }
}
