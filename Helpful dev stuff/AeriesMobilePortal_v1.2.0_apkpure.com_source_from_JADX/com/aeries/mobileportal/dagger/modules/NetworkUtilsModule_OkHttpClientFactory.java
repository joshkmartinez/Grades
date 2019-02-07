package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.PSPTokenAuthenticator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public final class NetworkUtilsModule_OkHttpClientFactory implements Factory<OkHttpClient> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<CookieJar> cookieJarProvider;
    private final Provider<HttpLoggingInterceptor> loggingInterceptorProvider;
    private final NetworkUtilsModule module;
    private final Provider<PSPTokenAuthenticator> pspTokenAuthenticatorProvider;

    public NetworkUtilsModule_OkHttpClientFactory(NetworkUtilsModule networkUtilsModule, Provider<HttpLoggingInterceptor> provider, Provider<PSPTokenAuthenticator> provider2, Provider<CookieJar> provider3) {
        this.module = networkUtilsModule;
        this.loggingInterceptorProvider = provider;
        this.pspTokenAuthenticatorProvider = provider2;
        this.cookieJarProvider = provider3;
    }

    public OkHttpClient get() {
        return (OkHttpClient) Preconditions.checkNotNull(this.module.okHttpClient((HttpLoggingInterceptor) this.loggingInterceptorProvider.get(), (PSPTokenAuthenticator) this.pspTokenAuthenticatorProvider.get(), (CookieJar) this.cookieJarProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<OkHttpClient> create(NetworkUtilsModule networkUtilsModule, Provider<HttpLoggingInterceptor> provider, Provider<PSPTokenAuthenticator> provider2, Provider<CookieJar> provider3) {
        return new NetworkUtilsModule_OkHttpClientFactory(networkUtilsModule, provider, provider2, provider3);
    }
}
