package com.aeries.mobileportal.dagger.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public final class NetworkUtilsSchoolModule_OkHttpClientFactory implements Factory<OkHttpClient> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<HttpLoggingInterceptor> loggingInterceptorProvider;
    private final NetworkUtilsSchoolModule module;

    public NetworkUtilsSchoolModule_OkHttpClientFactory(NetworkUtilsSchoolModule networkUtilsSchoolModule, Provider<HttpLoggingInterceptor> provider) {
        this.module = networkUtilsSchoolModule;
        this.loggingInterceptorProvider = provider;
    }

    public OkHttpClient get() {
        return (OkHttpClient) Preconditions.checkNotNull(this.module.okHttpClient((HttpLoggingInterceptor) this.loggingInterceptorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<OkHttpClient> create(NetworkUtilsSchoolModule networkUtilsSchoolModule, Provider<HttpLoggingInterceptor> provider) {
        return new NetworkUtilsSchoolModule_OkHttpClientFactory(networkUtilsSchoolModule, provider);
    }
}
