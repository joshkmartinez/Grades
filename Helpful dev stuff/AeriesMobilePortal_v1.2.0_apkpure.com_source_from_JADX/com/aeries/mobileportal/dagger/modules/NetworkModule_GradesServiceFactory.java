package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.GradesService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NetworkModule_GradesServiceFactory implements Factory<GradesService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkModule module;
    private final Provider<ServicesProvider> servicesProvider;

    public NetworkModule_GradesServiceFactory(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        this.module = networkModule;
        this.servicesProvider = provider;
    }

    public GradesService get() {
        return (GradesService) Preconditions.checkNotNull(this.module.gradesService((ServicesProvider) this.servicesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<GradesService> create(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        return new NetworkModule_GradesServiceFactory(networkModule, provider);
    }
}
