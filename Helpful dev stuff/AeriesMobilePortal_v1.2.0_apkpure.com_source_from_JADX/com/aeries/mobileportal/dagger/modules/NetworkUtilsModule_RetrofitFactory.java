package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class NetworkUtilsModule_RetrofitFactory implements Factory<Retrofit> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<Converter.Factory> converterFactoryProvider;
    private final Provider<Gson> gsonProvider;
    private final NetworkUtilsModule module;
    private final Provider<NetworkRepo> networkRepositoryProvider;

    public NetworkUtilsModule_RetrofitFactory(NetworkUtilsModule networkUtilsModule, Provider<Gson> provider, Provider<NetworkRepo> provider2, Provider<Converter.Factory> provider3) {
        this.module = networkUtilsModule;
        this.gsonProvider = provider;
        this.networkRepositoryProvider = provider2;
        this.converterFactoryProvider = provider3;
    }

    public Retrofit get() {
        return (Retrofit) Preconditions.checkNotNull(this.module.retrofit((Gson) this.gsonProvider.get(), (NetworkRepo) this.networkRepositoryProvider.get(), (Converter.Factory) this.converterFactoryProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<Retrofit> create(NetworkUtilsModule networkUtilsModule, Provider<Gson> provider, Provider<NetworkRepo> provider2, Provider<Converter.Factory> provider3) {
        return new NetworkUtilsModule_RetrofitFactory(networkUtilsModule, provider, provider2, provider3);
    }
}
