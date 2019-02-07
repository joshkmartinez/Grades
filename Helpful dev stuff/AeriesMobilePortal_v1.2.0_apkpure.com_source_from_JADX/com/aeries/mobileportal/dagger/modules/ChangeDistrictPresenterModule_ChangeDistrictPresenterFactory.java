package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.change_district.ChangeDistrictInteractor;
import com.aeries.mobileportal.presenters.change_district.ChangeDistrictPresenter;
import com.aeries.mobileportal.views.viewmodels.change_district.ChangeDistrictViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ChangeDistrictPresenterModule_ChangeDistrictPresenterFactory implements Factory<ChangeDistrictPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ChangeDistrictInteractor> changeDistrictInteractorProvider;
    private final Provider<ChangeDistrictViewModel> changeDistrictViewModelProvider;
    private final ChangeDistrictPresenterModule module;

    public ChangeDistrictPresenterModule_ChangeDistrictPresenterFactory(ChangeDistrictPresenterModule changeDistrictPresenterModule, Provider<ChangeDistrictViewModel> provider, Provider<ChangeDistrictInteractor> provider2) {
        this.module = changeDistrictPresenterModule;
        this.changeDistrictViewModelProvider = provider;
        this.changeDistrictInteractorProvider = provider2;
    }

    public ChangeDistrictPresenter get() {
        return (ChangeDistrictPresenter) Preconditions.checkNotNull(this.module.changeDistrictPresenter((ChangeDistrictViewModel) this.changeDistrictViewModelProvider.get(), (ChangeDistrictInteractor) this.changeDistrictInteractorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ChangeDistrictPresenter> create(ChangeDistrictPresenterModule changeDistrictPresenterModule, Provider<ChangeDistrictViewModel> provider, Provider<ChangeDistrictInteractor> provider2) {
        return new ChangeDistrictPresenterModule_ChangeDistrictPresenterFactory(changeDistrictPresenterModule, provider, provider2);
    }
}
