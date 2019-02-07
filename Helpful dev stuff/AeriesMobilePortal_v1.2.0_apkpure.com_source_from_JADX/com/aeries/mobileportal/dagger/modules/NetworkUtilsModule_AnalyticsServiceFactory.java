package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.AnalyticsService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class NetworkUtilsModule_AnalyticsServiceFactory implements Factory<AnalyticsService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkUtilsModule module;
    private final Provider<Retrofit> retrofitProvider;

    public NetworkUtilsModule_AnalyticsServiceFactory(NetworkUtilsModule networkUtilsModule, Provider<Retrofit> provider) {
        this.module = networkUtilsModule;
        this.retrofitProvider = provider;
    }

    public AnalyticsService get() {
        return (AnalyticsService) Preconditions.checkNotNull(this.module.analyticsService((Retrofit) this.retrofitProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AnalyticsService> create(NetworkUtilsModule networkUtilsModule, Provider<Retrofit> provider) {
        return new NetworkUtilsModule_AnalyticsServiceFactory(networkUtilsModule, provider);
    }
}
