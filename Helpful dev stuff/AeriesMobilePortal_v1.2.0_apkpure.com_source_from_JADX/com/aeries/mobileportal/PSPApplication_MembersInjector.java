package com.aeries.mobileportal;

import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class PSPApplication_MembersInjector implements MembersInjector<PSPApplication> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    public PSPApplication_MembersInjector(Provider<TokenRepository> provider) {
        this.tokenRepositoryProvider = provider;
    }

    public static MembersInjector<PSPApplication> create(Provider<TokenRepository> provider) {
        return new PSPApplication_MembersInjector(provider);
    }

    public void injectMembers(PSPApplication pSPApplication) {
        if (pSPApplication != null) {
            pSPApplication.tokenRepository = (TokenRepository) this.tokenRepositoryProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
