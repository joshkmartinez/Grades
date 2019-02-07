package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.forgot_password.ForgotPasswordViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ForgotPasswordPresenterModule_ForgotPasswordViewModelFactory implements Factory<ForgotPasswordViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ForgotPasswordPresenterModule module;

    public ForgotPasswordPresenterModule_ForgotPasswordViewModelFactory(ForgotPasswordPresenterModule forgotPasswordPresenterModule) {
        this.module = forgotPasswordPresenterModule;
    }

    public ForgotPasswordViewModel get() {
        return (ForgotPasswordViewModel) Preconditions.checkNotNull(this.module.forgotPasswordViewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ForgotPasswordViewModel> create(ForgotPasswordPresenterModule forgotPasswordPresenterModule) {
        return new ForgotPasswordPresenterModule_ForgotPasswordViewModelFactory(forgotPasswordPresenterModule);
    }
}
