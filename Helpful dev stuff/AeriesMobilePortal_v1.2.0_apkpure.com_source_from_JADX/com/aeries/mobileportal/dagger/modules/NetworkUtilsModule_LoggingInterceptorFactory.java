package com.aeries.mobileportal.dagger.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.logging.HttpLoggingInterceptor;

public final class NetworkUtilsModule_LoggingInterceptorFactory implements Factory<HttpLoggingInterceptor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkUtilsModule module;

    public NetworkUtilsModule_LoggingInterceptorFactory(NetworkUtilsModule networkUtilsModule) {
        this.module = networkUtilsModule;
    }

    public HttpLoggingInterceptor get() {
        return (HttpLoggingInterceptor) Preconditions.checkNotNull(this.module.loggingInterceptor(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<HttpLoggingInterceptor> create(NetworkUtilsModule networkUtilsModule) {
        return new NetworkUtilsModule_LoggingInterceptorFactory(networkUtilsModule);
    }
}
