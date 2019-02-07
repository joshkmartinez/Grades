package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.add_district.AddDistrictInteractor;
import com.aeries.mobileportal.presenters.add_district.AddDistrictPresenter;
import com.aeries.mobileportal.views.viewmodels.add_district.AddDistrictViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AddDistrictPresenterModule_AddDistrictPresenterFactory implements Factory<AddDistrictPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AddDistrictInteractor> interactorProvider;
    private final AddDistrictPresenterModule module;
    private final Provider<AddDistrictViewModel> viewModelProvider;

    public AddDistrictPresenterModule_AddDistrictPresenterFactory(AddDistrictPresenterModule addDistrictPresenterModule, Provider<AddDistrictViewModel> provider, Provider<AddDistrictInteractor> provider2) {
        this.module = addDistrictPresenterModule;
        this.viewModelProvider = provider;
        this.interactorProvider = provider2;
    }

    public AddDistrictPresenter get() {
        return (AddDistrictPresenter) Preconditions.checkNotNull(this.module.addDistrictPresenter((AddDistrictViewModel) this.viewModelProvider.get(), (AddDistrictInteractor) this.interactorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AddDistrictPresenter> create(AddDistrictPresenterModule addDistrictPresenterModule, Provider<AddDistrictViewModel> provider, Provider<AddDistrictInteractor> provider2) {
        return new AddDistrictPresenterModule_AddDistrictPresenterFactory(addDistrictPresenterModule, provider, provider2);
    }
}
