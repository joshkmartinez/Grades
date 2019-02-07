package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.change_password.ChangePasswordInteractor;
import com.aeries.mobileportal.presenters.change_password.ChangePasswordPresenter;
import com.aeries.mobileportal.views.viewmodels.change_password.ChangePasswordViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ChangePasswordPresenterModule_ChangePasswordPresenterFactory implements Factory<ChangePasswordPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ChangePasswordInteractor> changePasswordInteractorProvider;
    private final Provider<ChangePasswordViewModel> changePasswordViewModelProvider;
    private final ChangePasswordPresenterModule module;

    public ChangePasswordPresenterModule_ChangePasswordPresenterFactory(ChangePasswordPresenterModule changePasswordPresenterModule, Provider<ChangePasswordViewModel> provider, Provider<ChangePasswordInteractor> provider2) {
        this.module = changePasswordPresenterModule;
        this.changePasswordViewModelProvider = provider;
        this.changePasswordInteractorProvider = provider2;
    }

    public ChangePasswordPresenter get() {
        return (ChangePasswordPresenter) Preconditions.checkNotNull(this.module.changePasswordPresenter((ChangePasswordViewModel) this.changePasswordViewModelProvider.get(), (ChangePasswordInteractor) this.changePasswordInteractorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ChangePasswordPresenter> create(ChangePasswordPresenterModule changePasswordPresenterModule, Provider<ChangePasswordViewModel> provider, Provider<ChangePasswordInteractor> provider2) {
        return new ChangePasswordPresenterModule_ChangePasswordPresenterFactory(changePasswordPresenterModule, provider, provider2);
    }
}
