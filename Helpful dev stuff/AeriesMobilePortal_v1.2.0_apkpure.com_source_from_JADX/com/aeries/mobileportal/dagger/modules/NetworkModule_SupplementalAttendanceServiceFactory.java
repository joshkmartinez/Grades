package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.SupplementalAttendanceService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NetworkModule_SupplementalAttendanceServiceFactory implements Factory<SupplementalAttendanceService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkModule module;
    private final Provider<ServicesProvider> servicesProvider;

    public NetworkModule_SupplementalAttendanceServiceFactory(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        this.module = networkModule;
        this.servicesProvider = provider;
    }

    public SupplementalAttendanceService get() {
        return (SupplementalAttendanceService) Preconditions.checkNotNull(this.module.supplementalAttendanceService((ServicesProvider) this.servicesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SupplementalAttendanceService> create(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        return new NetworkModule_SupplementalAttendanceServiceFactory(networkModule, provider);
    }
}
