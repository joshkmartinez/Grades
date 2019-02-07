package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.RestrictionService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NetworkModule_RestrictionServiceFactory implements Factory<RestrictionService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkModule module;
    private final Provider<ServicesProvider> servicesProvider;

    public NetworkModule_RestrictionServiceFactory(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        this.module = networkModule;
        this.servicesProvider = provider;
    }

    public RestrictionService get() {
        return (RestrictionService) Preconditions.checkNotNull(this.module.restrictionService((ServicesProvider) this.servicesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<RestrictionService> create(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        return new NetworkModule_RestrictionServiceFactory(networkModule, provider);
    }
}
