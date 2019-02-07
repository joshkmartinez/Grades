package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.auth_error.AuthErrorViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AuthErrorPresenterModule_AuthErrorViewModelFactory implements Factory<AuthErrorViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AuthErrorPresenterModule module;

    public AuthErrorPresenterModule_AuthErrorViewModelFactory(AuthErrorPresenterModule authErrorPresenterModule) {
        this.module = authErrorPresenterModule;
    }

    public AuthErrorViewModel get() {
        return (AuthErrorViewModel) Preconditions.checkNotNull(this.module.authErrorViewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AuthErrorViewModel> create(AuthErrorPresenterModule authErrorPresenterModule) {
        return new AuthErrorPresenterModule_AuthErrorViewModelFactory(authErrorPresenterModule);
    }
}
