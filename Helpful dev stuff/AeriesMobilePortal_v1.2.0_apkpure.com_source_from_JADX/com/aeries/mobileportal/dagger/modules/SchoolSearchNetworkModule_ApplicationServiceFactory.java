package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.ApplicationStartupService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class SchoolSearchNetworkModule_ApplicationServiceFactory implements Factory<ApplicationStartupService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SchoolSearchNetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public SchoolSearchNetworkModule_ApplicationServiceFactory(SchoolSearchNetworkModule schoolSearchNetworkModule, Provider<Retrofit> provider) {
        this.module = schoolSearchNetworkModule;
        this.retrofitProvider = provider;
    }

    public ApplicationStartupService get() {
        return (ApplicationStartupService) Preconditions.checkNotNull(this.module.applicationService((Retrofit) this.retrofitProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ApplicationStartupService> create(SchoolSearchNetworkModule schoolSearchNetworkModule, Provider<Retrofit> provider) {
        return new SchoolSearchNetworkModule_ApplicationServiceFactory(schoolSearchNetworkModule, provider);
    }
}
