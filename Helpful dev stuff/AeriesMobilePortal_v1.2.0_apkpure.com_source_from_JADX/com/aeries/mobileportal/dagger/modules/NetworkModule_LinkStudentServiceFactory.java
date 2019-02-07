package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.LinkStudentService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NetworkModule_LinkStudentServiceFactory implements Factory<LinkStudentService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkModule module;
    private final Provider<ServicesProvider> servicesProvider;

    public NetworkModule_LinkStudentServiceFactory(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        this.module = networkModule;
        this.servicesProvider = provider;
    }

    public LinkStudentService get() {
        return (LinkStudentService) Preconditions.checkNotNull(this.module.linkStudentService((ServicesProvider) this.servicesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<LinkStudentService> create(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        return new NetworkModule_LinkStudentServiceFactory(networkModule, provider);
    }
}
