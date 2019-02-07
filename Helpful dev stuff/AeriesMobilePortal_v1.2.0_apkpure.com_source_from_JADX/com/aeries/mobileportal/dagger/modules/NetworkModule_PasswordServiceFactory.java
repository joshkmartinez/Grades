package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.PasswordService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NetworkModule_PasswordServiceFactory implements Factory<PasswordService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkModule module;
    private final Provider<ServicesProvider> servicesProvider;

    public NetworkModule_PasswordServiceFactory(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        this.module = networkModule;
        this.servicesProvider = provider;
    }

    public PasswordService get() {
        return (PasswordService) Preconditions.checkNotNull(this.module.passwordService((ServicesProvider) this.servicesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<PasswordService> create(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        return new NetworkModule_PasswordServiceFactory(networkModule, provider);
    }
}
