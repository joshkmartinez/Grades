package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.WhatIfService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NetworkModule_WhatIfServiceFactory implements Factory<WhatIfService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkModule module;
    private final Provider<ServicesProvider> servicesProvider;

    public NetworkModule_WhatIfServiceFactory(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        this.module = networkModule;
        this.servicesProvider = provider;
    }

    public WhatIfService get() {
        return (WhatIfService) Preconditions.checkNotNull(this.module.whatIfService((ServicesProvider) this.servicesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<WhatIfService> create(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        return new NetworkModule_WhatIfServiceFactory(networkModule, provider);
    }
}
