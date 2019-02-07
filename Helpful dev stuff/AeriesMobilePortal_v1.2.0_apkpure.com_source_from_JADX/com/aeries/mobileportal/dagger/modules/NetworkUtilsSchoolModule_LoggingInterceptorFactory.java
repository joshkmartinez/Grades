package com.aeries.mobileportal.dagger.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.logging.HttpLoggingInterceptor;

public final class NetworkUtilsSchoolModule_LoggingInterceptorFactory implements Factory<HttpLoggingInterceptor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkUtilsSchoolModule module;

    public NetworkUtilsSchoolModule_LoggingInterceptorFactory(NetworkUtilsSchoolModule networkUtilsSchoolModule) {
        this.module = networkUtilsSchoolModule;
    }

    public HttpLoggingInterceptor get() {
        return (HttpLoggingInterceptor) Preconditions.checkNotNull(this.module.loggingInterceptor(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<HttpLoggingInterceptor> create(NetworkUtilsSchoolModule networkUtilsSchoolModule) {
        return new NetworkUtilsSchoolModule_LoggingInterceptorFactory(networkUtilsSchoolModule);
    }
}
