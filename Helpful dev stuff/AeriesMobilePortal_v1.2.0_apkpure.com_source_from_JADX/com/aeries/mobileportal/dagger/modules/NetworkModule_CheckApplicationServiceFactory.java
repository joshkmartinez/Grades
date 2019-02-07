package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.ApplicationService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NetworkModule_CheckApplicationServiceFactory implements Factory<ApplicationService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkModule module;
    private final Provider<ServicesProvider> servicesProvider;

    public NetworkModule_CheckApplicationServiceFactory(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        this.module = networkModule;
        this.servicesProvider = provider;
    }

    public ApplicationService get() {
        return (ApplicationService) Preconditions.checkNotNull(this.module.checkApplicationService((ServicesProvider) this.servicesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ApplicationService> create(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        return new NetworkModule_CheckApplicationServiceFactory(networkModule, provider);
    }
}
