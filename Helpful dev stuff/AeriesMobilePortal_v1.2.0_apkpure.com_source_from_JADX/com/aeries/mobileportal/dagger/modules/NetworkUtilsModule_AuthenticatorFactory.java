package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.PSPTokenAuthenticator;
import com.aeries.mobileportal.web_services.TokenManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NetworkUtilsModule_AuthenticatorFactory implements Factory<PSPTokenAuthenticator> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkUtilsModule module;
    private final Provider<TokenManager> tokenManagerProvider;

    public NetworkUtilsModule_AuthenticatorFactory(NetworkUtilsModule networkUtilsModule, Provider<TokenManager> provider) {
        this.module = networkUtilsModule;
        this.tokenManagerProvider = provider;
    }

    public PSPTokenAuthenticator get() {
        return (PSPTokenAuthenticator) Preconditions.checkNotNull(this.module.authenticator((TokenManager) this.tokenManagerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<PSPTokenAuthenticator> create(NetworkUtilsModule networkUtilsModule, Provider<TokenManager> provider) {
        return new NetworkUtilsModule_AuthenticatorFactory(networkUtilsModule, provider);
    }
}
