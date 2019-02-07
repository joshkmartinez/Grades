package com.aeries.mobileportal.dagger.modules;

import android.accounts.AccountManager;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AuthModule_TokenProviderFactory implements Factory<TokenProvider> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AccountManager> accountManagerProvider;
    private final AuthModule module;
    private final Provider<TokenRepository> tokenRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public AuthModule_TokenProviderFactory(AuthModule authModule, Provider<AccountManager> provider, Provider<UserRepository> provider2, Provider<TokenRepository> provider3) {
        this.module = authModule;
        this.accountManagerProvider = provider;
        this.userRepositoryProvider = provider2;
        this.tokenRepositoryProvider = provider3;
    }

    public TokenProvider get() {
        return (TokenProvider) Preconditions.checkNotNull(this.module.tokenProvider((AccountManager) this.accountManagerProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (TokenRepository) this.tokenRepositoryProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<TokenProvider> create(AuthModule authModule, Provider<AccountManager> provider, Provider<UserRepository> provider2, Provider<TokenRepository> provider3) {
        return new AuthModule_TokenProviderFactory(authModule, provider, provider2, provider3);
    }
}
