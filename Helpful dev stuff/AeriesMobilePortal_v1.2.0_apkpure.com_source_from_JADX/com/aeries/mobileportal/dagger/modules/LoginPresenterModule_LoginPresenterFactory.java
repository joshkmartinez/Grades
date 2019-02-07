package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.login.LoginInteractor;
import com.aeries.mobileportal.presenters.login.LoginPresenter;
import com.aeries.mobileportal.views.viewmodels.login.LoginViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class LoginPresenterModule_LoginPresenterFactory implements Factory<LoginPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<LoginInteractor> loginInteractorProvider;
    private final Provider<LoginViewModel> loginViewModelProvider;
    private final LoginPresenterModule module;

    public LoginPresenterModule_LoginPresenterFactory(LoginPresenterModule loginPresenterModule, Provider<LoginViewModel> provider, Provider<LoginInteractor> provider2) {
        this.module = loginPresenterModule;
        this.loginViewModelProvider = provider;
        this.loginInteractorProvider = provider2;
    }

    public LoginPresenter get() {
        return (LoginPresenter) Preconditions.checkNotNull(this.module.loginPresenter((LoginViewModel) this.loginViewModelProvider.get(), (LoginInteractor) this.loginInteractorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<LoginPresenter> create(LoginPresenterModule loginPresenterModule, Provider<LoginViewModel> provider, Provider<LoginInteractor> provider2) {
        return new LoginPresenterModule_LoginPresenterFactory(loginPresenterModule, provider, provider2);
    }
}
