package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.LoginService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NetworkModule_LogInServiceFactory implements Factory<LoginService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkModule module;
    private final Provider<ServicesProvider> servicesProvider;

    public NetworkModule_LogInServiceFactory(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        this.module = networkModule;
        this.servicesProvider = provider;
    }

    public LoginService get() {
        return (LoginService) Preconditions.checkNotNull(this.module.logInService((ServicesProvider) this.servicesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<LoginService> create(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        return new NetworkModule_LogInServiceFactory(networkModule, provider);
    }
}
