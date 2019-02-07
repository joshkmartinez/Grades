package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit.Builder;

public final class NetworkModule_ServiceContainerFactory implements Factory<ServicesProvider> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkModule module;
    private final Provider<NetworkRepo> networkRepositoryProvider;
    private final Provider<Builder> retrofitBuilderProvider;

    public NetworkModule_ServiceContainerFactory(NetworkModule networkModule, Provider<Builder> provider, Provider<NetworkRepo> provider2) {
        this.module = networkModule;
        this.retrofitBuilderProvider = provider;
        this.networkRepositoryProvider = provider2;
    }

    public ServicesProvider get() {
        return (ServicesProvider) Preconditions.checkNotNull(this.module.serviceContainer((Builder) this.retrofitBuilderProvider.get(), (NetworkRepo) this.networkRepositoryProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ServicesProvider> create(NetworkModule networkModule, Provider<Builder> provider, Provider<NetworkRepo> provider2) {
        return new NetworkModule_ServiceContainerFactory(networkModule, provider, provider2);
    }
}
