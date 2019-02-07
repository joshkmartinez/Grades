package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.SignalKitService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NetworkModule_SignalKitServiceFactory implements Factory<SignalKitService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkModule module;
    private final Provider<ServicesProvider> servicesProvider;

    public NetworkModule_SignalKitServiceFactory(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        this.module = networkModule;
        this.servicesProvider = provider;
    }

    public SignalKitService get() {
        return (SignalKitService) Preconditions.checkNotNull(this.module.signalKitService((ServicesProvider) this.servicesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SignalKitService> create(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        return new NetworkModule_SignalKitServiceFactory(networkModule, provider);
    }
}
