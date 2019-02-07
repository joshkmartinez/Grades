package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.NotificationService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NetworkModule_NotificationServiceFactory implements Factory<NotificationService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkModule module;
    private final Provider<ServicesProvider> servicesProvider;

    public NetworkModule_NotificationServiceFactory(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        this.module = networkModule;
        this.servicesProvider = provider;
    }

    public NotificationService get() {
        return (NotificationService) Preconditions.checkNotNull(this.module.notificationService((ServicesProvider) this.servicesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<NotificationService> create(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        return new NetworkModule_NotificationServiceFactory(networkModule, provider);
    }
}
