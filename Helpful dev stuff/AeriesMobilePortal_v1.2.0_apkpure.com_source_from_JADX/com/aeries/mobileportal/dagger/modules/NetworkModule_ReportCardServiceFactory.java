package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.ReportCardService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NetworkModule_ReportCardServiceFactory implements Factory<ReportCardService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkModule module;
    private final Provider<ServicesProvider> servicesProvider;

    public NetworkModule_ReportCardServiceFactory(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        this.module = networkModule;
        this.servicesProvider = provider;
    }

    public ReportCardService get() {
        return (ReportCardService) Preconditions.checkNotNull(this.module.reportCardService((ServicesProvider) this.servicesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ReportCardService> create(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        return new NetworkModule_ReportCardServiceFactory(networkModule, provider);
    }
}
