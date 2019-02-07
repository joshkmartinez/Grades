package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.CreateAccountService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NetworkModule_CreateAccountServiceFactory implements Factory<CreateAccountService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkModule module;
    private final Provider<ServicesProvider> servicesProvider;

    public NetworkModule_CreateAccountServiceFactory(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        this.module = networkModule;
        this.servicesProvider = provider;
    }

    public CreateAccountService get() {
        return (CreateAccountService) Preconditions.checkNotNull(this.module.createAccountService((ServicesProvider) this.servicesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<CreateAccountService> create(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        return new NetworkModule_CreateAccountServiceFactory(networkModule, provider);
    }
}
