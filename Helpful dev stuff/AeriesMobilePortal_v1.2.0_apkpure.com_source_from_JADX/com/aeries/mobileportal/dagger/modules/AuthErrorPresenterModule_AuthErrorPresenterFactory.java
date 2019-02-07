package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.auth_error.AuthErrorInteractor;
import com.aeries.mobileportal.presenters.auth_error.AuthErrorPresenter;
import com.aeries.mobileportal.views.viewmodels.auth_error.AuthErrorViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AuthErrorPresenterModule_AuthErrorPresenterFactory implements Factory<AuthErrorPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AuthErrorInteractor> authErrorInteractorProvider;
    private final Provider<AuthErrorViewModel> authErrorViewModelProvider;
    private final AuthErrorPresenterModule module;

    public AuthErrorPresenterModule_AuthErrorPresenterFactory(AuthErrorPresenterModule authErrorPresenterModule, Provider<AuthErrorViewModel> provider, Provider<AuthErrorInteractor> provider2) {
        this.module = authErrorPresenterModule;
        this.authErrorViewModelProvider = provider;
        this.authErrorInteractorProvider = provider2;
    }

    public AuthErrorPresenter get() {
        return (AuthErrorPresenter) Preconditions.checkNotNull(this.module.authErrorPresenter((AuthErrorViewModel) this.authErrorViewModelProvider.get(), (AuthErrorInteractor) this.authErrorInteractorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AuthErrorPresenter> create(AuthErrorPresenterModule authErrorPresenterModule, Provider<AuthErrorViewModel> provider, Provider<AuthErrorInteractor> provider2) {
        return new AuthErrorPresenterModule_AuthErrorPresenterFactory(authErrorPresenterModule, provider, provider2);
    }
}
