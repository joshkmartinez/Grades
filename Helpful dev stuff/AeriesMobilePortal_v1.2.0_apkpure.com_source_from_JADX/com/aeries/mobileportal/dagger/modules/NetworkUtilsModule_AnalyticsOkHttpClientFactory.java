package com.aeries.mobileportal.dagger.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public final class NetworkUtilsModule_AnalyticsOkHttpClientFactory implements Factory<OkHttpClient> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<CookieJar> cookieJarProvider;
    private final Provider<HttpLoggingInterceptor> loggingInterceptorProvider;
    private final NetworkUtilsModule module;

    public NetworkUtilsModule_AnalyticsOkHttpClientFactory(NetworkUtilsModule networkUtilsModule, Provider<HttpLoggingInterceptor> provider, Provider<CookieJar> provider2) {
        this.module = networkUtilsModule;
        this.loggingInterceptorProvider = provider;
        this.cookieJarProvider = provider2;
    }

    public OkHttpClient get() {
        return (OkHttpClient) Preconditions.checkNotNull(this.module.analyticsOkHttpClient((HttpLoggingInterceptor) this.loggingInterceptorProvider.get(), (CookieJar) this.cookieJarProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<OkHttpClient> create(NetworkUtilsModule networkUtilsModule, Provider<HttpLoggingInterceptor> provider, Provider<CookieJar> provider2) {
        return new NetworkUtilsModule_AnalyticsOkHttpClientFactory(networkUtilsModule, provider, provider2);
    }
}
