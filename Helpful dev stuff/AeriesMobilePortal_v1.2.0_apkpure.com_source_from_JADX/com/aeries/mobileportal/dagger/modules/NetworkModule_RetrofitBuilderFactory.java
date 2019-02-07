package com.aeries.mobileportal.dagger.modules;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit.Builder;

public final class NetworkModule_RetrofitBuilderFactory implements Factory<Builder> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<Gson> gsonProvider;
    private final NetworkModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public NetworkModule_RetrofitBuilderFactory(NetworkModule networkModule, Provider<Gson> provider, Provider<OkHttpClient> provider2) {
        this.module = networkModule;
        this.gsonProvider = provider;
        this.okHttpClientProvider = provider2;
    }

    public Builder get() {
        return (Builder) Preconditions.checkNotNull(this.module.retrofitBuilder((Gson) this.gsonProvider.get(), (OkHttpClient) this.okHttpClientProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<Builder> create(NetworkModule networkModule, Provider<Gson> provider, Provider<OkHttpClient> provider2) {
        return new NetworkModule_RetrofitBuilderFactory(networkModule, provider, provider2);
    }
}
