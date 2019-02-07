package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.AttendanceService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NetworkModule_AttendanceServiceFactory implements Factory<AttendanceService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkModule module;
    private final Provider<ServicesProvider> servicesProvider;

    public NetworkModule_AttendanceServiceFactory(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        this.module = networkModule;
        this.servicesProvider = provider;
    }

    public AttendanceService get() {
        return (AttendanceService) Preconditions.checkNotNull(this.module.attendanceService((ServicesProvider) this.servicesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AttendanceService> create(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        return new NetworkModule_AttendanceServiceFactory(networkModule, provider);
    }
}
