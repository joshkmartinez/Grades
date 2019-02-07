package com.aeries.mobileportal.services;

import com.aeries.mobileportal.PSPAuthenticator;
import com.aeries.mobileportal.presenters.AuthServicePresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class PSPAuthenticatorService_MembersInjector implements MembersInjector<PSPAuthenticatorService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<PSPAuthenticator> authenticatorProvider;
    private final Provider<AuthServicePresenter> presenterProvider;

    public PSPAuthenticatorService_MembersInjector(Provider<PSPAuthenticator> provider, Provider<AuthServicePresenter> provider2) {
        this.authenticatorProvider = provider;
        this.presenterProvider = provider2;
    }

    public static MembersInjector<PSPAuthenticatorService> create(Provider<PSPAuthenticator> provider, Provider<AuthServicePresenter> provider2) {
        return new PSPAuthenticatorService_MembersInjector(provider, provider2);
    }

    public void injectMembers(PSPAuthenticatorService pSPAuthenticatorService) {
        if (pSPAuthenticatorService != null) {
            pSPAuthenticatorService.authenticator = (PSPAuthenticator) this.authenticatorProvider.get();
            pSPAuthenticatorService.presenter = (AuthServicePresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
