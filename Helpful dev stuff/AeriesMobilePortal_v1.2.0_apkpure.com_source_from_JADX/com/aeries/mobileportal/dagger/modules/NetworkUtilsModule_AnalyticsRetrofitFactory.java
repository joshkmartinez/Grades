package com.aeries.mobileportal.dagger.modules;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class NetworkUtilsModule_AnalyticsRetrofitFactory implements Factory<Retrofit> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<Converter.Factory> converterFactoryProvider;
    private final Provider<Gson> gsonProvider;
    private final NetworkUtilsModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public NetworkUtilsModule_AnalyticsRetrofitFactory(NetworkUtilsModule networkUtilsModule, Provider<Gson> provider, Provider<Converter.Factory> provider2, Provider<OkHttpClient> provider3) {
        this.module = networkUtilsModule;
        this.gsonProvider = provider;
        this.converterFactoryProvider = provider2;
        this.okHttpClientProvider = provider3;
    }

    public Retrofit get() {
        return (Retrofit) Preconditions.checkNotNull(this.module.analyticsRetrofit((Gson) this.gsonProvider.get(), (Converter.Factory) this.converterFactoryProvider.get(), (OkHttpClient) this.okHttpClientProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<Retrofit> create(NetworkUtilsModule networkUtilsModule, Provider<Gson> provider, Provider<Converter.Factory> provider2, Provider<OkHttpClient> provider3) {
        return new NetworkUtilsModule_AnalyticsRetrofitFactory(networkUtilsModule, provider, provider2, provider3);
    }
}
