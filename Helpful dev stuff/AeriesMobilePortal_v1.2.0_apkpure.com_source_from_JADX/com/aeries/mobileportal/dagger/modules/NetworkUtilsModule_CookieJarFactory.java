package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.CookieJar;

public final class NetworkUtilsModule_CookieJarFactory implements Factory<CookieJar> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<Context> contextProvider;
    private final NetworkUtilsModule module;

    public NetworkUtilsModule_CookieJarFactory(NetworkUtilsModule networkUtilsModule, Provider<Context> provider) {
        this.module = networkUtilsModule;
        this.contextProvider = provider;
    }

    public CookieJar get() {
        return (CookieJar) Preconditions.checkNotNull(this.module.cookieJar((Context) this.contextProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<CookieJar> create(NetworkUtilsModule networkUtilsModule, Provider<Context> provider) {
        return new NetworkUtilsModule_CookieJarFactory(networkUtilsModule, provider);
    }
}
