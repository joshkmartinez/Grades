package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.login.LoginViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class LoginPresenterModule_LoginViewModelFactory implements Factory<LoginViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final LoginPresenterModule module;

    public LoginPresenterModule_LoginViewModelFactory(LoginPresenterModule loginPresenterModule) {
        this.module = loginPresenterModule;
    }

    public LoginViewModel get() {
        return (LoginViewModel) Preconditions.checkNotNull(this.module.loginViewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<LoginViewModel> create(LoginPresenterModule loginPresenterModule) {
        return new LoginPresenterModule_LoginViewModelFactory(loginPresenterModule);
    }
}
