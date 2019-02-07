package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenManager;
import com.aeries.mobileportal.web_services.TokenProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NetworkUtilsModule_TokenManagerFactory implements Factory<TokenManager> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<Context> contextProvider;
    private final NetworkUtilsModule module;
    private final Provider<TokenProvider> tokenProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public NetworkUtilsModule_TokenManagerFactory(NetworkUtilsModule networkUtilsModule, Provider<UserRepository> provider, Provider<TokenProvider> provider2, Provider<Context> provider3) {
        this.module = networkUtilsModule;
        this.userRepositoryProvider = provider;
        this.tokenProvider = provider2;
        this.contextProvider = provider3;
    }

    public TokenManager get() {
        return (TokenManager) Preconditions.checkNotNull(this.module.tokenManager((UserRepository) this.userRepositoryProvider.get(), (TokenProvider) this.tokenProvider.get(), (Context) this.contextProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<TokenManager> create(NetworkUtilsModule networkUtilsModule, Provider<UserRepository> provider, Provider<TokenProvider> provider2, Provider<Context> provider3) {
        return new NetworkUtilsModule_TokenManagerFactory(networkUtilsModule, provider, provider2, provider3);
    }
}
