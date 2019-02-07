package com.aeries.mobileportal.dagger.modules;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class SchoolSearchNetworkModule_SchoolSearchRetrofitFactory implements Factory<Retrofit> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<Gson> gsonProvider;
    private final SchoolSearchNetworkModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public SchoolSearchNetworkModule_SchoolSearchRetrofitFactory(SchoolSearchNetworkModule schoolSearchNetworkModule, Provider<Gson> provider, Provider<OkHttpClient> provider2) {
        this.module = schoolSearchNetworkModule;
        this.gsonProvider = provider;
        this.okHttpClientProvider = provider2;
    }

    public Retrofit get() {
        return (Retrofit) Preconditions.checkNotNull(this.module.schoolSearchRetrofit((Gson) this.gsonProvider.get(), (OkHttpClient) this.okHttpClientProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<Retrofit> create(SchoolSearchNetworkModule schoolSearchNetworkModule, Provider<Gson> provider, Provider<OkHttpClient> provider2) {
        return new SchoolSearchNetworkModule_SchoolSearchRetrofitFactory(schoolSearchNetworkModule, provider, provider2);
    }
}
