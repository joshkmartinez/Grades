package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.login.LoginInteractor;
import com.aeries.mobileportal.presenters.AuthServicePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PSPAuthenticatorModule_AuthServicePresenterFactory implements Factory<AuthServicePresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<LoginInteractor> interactorProvider;
    private final PSPAuthenticatorModule module;

    public PSPAuthenticatorModule_AuthServicePresenterFactory(PSPAuthenticatorModule pSPAuthenticatorModule, Provider<LoginInteractor> provider) {
        this.module = pSPAuthenticatorModule;
        this.interactorProvider = provider;
    }

    public AuthServicePresenter get() {
        return (AuthServicePresenter) Preconditions.checkNotNull(this.module.authServicePresenter((LoginInteractor) this.interactorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AuthServicePresenter> create(PSPAuthenticatorModule pSPAuthenticatorModule, Provider<LoginInteractor> provider) {
        return new PSPAuthenticatorModule_AuthServicePresenterFactory(pSPAuthenticatorModule, provider);
    }
}
