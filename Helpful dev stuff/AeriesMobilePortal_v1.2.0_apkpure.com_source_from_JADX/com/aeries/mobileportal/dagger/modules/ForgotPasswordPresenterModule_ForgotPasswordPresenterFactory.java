package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.forgot_password.ForgotPasswordInteractor;
import com.aeries.mobileportal.presenters.forgot_password.ForgotPasswordPresenter;
import com.aeries.mobileportal.views.viewmodels.forgot_password.ForgotPasswordViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ForgotPasswordPresenterModule_ForgotPasswordPresenterFactory implements Factory<ForgotPasswordPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ForgotPasswordInteractor> forgotPasswordInteractorProvider;
    private final Provider<ForgotPasswordViewModel> forgotPasswordViewModelProvider;
    private final ForgotPasswordPresenterModule module;

    public ForgotPasswordPresenterModule_ForgotPasswordPresenterFactory(ForgotPasswordPresenterModule forgotPasswordPresenterModule, Provider<ForgotPasswordViewModel> provider, Provider<ForgotPasswordInteractor> provider2) {
        this.module = forgotPasswordPresenterModule;
        this.forgotPasswordViewModelProvider = provider;
        this.forgotPasswordInteractorProvider = provider2;
    }

    public ForgotPasswordPresenter get() {
        return (ForgotPasswordPresenter) Preconditions.checkNotNull(this.module.forgotPasswordPresenter((ForgotPasswordViewModel) this.forgotPasswordViewModelProvider.get(), (ForgotPasswordInteractor) this.forgotPasswordInteractorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ForgotPasswordPresenter> create(ForgotPasswordPresenterModule forgotPasswordPresenterModule, Provider<ForgotPasswordViewModel> provider, Provider<ForgotPasswordInteractor> provider2) {
        return new ForgotPasswordPresenterModule_ForgotPasswordPresenterFactory(forgotPasswordPresenterModule, provider, provider2);
    }
}
