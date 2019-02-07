package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.SchoolSearchService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class SchoolSearchNetworkModule_SchoolSearchServiceFactory implements Factory<SchoolSearchService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SchoolSearchNetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public SchoolSearchNetworkModule_SchoolSearchServiceFactory(SchoolSearchNetworkModule schoolSearchNetworkModule, Provider<Retrofit> provider) {
        this.module = schoolSearchNetworkModule;
        this.retrofitProvider = provider;
    }

    public SchoolSearchService get() {
        return (SchoolSearchService) Preconditions.checkNotNull(this.module.schoolSearchService((Retrofit) this.retrofitProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SchoolSearchService> create(SchoolSearchNetworkModule schoolSearchNetworkModule, Provider<Retrofit> provider) {
        return new SchoolSearchNetworkModule_SchoolSearchServiceFactory(schoolSearchNetworkModule, provider);
    }
}
