package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.ContactsService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NetworkModule_ContactsServiceFactory implements Factory<ContactsService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkModule module;
    private final Provider<ServicesProvider> servicesProvider;

    public NetworkModule_ContactsServiceFactory(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        this.module = networkModule;
        this.servicesProvider = provider;
    }

    public ContactsService get() {
        return (ContactsService) Preconditions.checkNotNull(this.module.contactsService((ServicesProvider) this.servicesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ContactsService> create(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        return new NetworkModule_ContactsServiceFactory(networkModule, provider);
    }
}
