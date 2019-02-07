package com.aeries.mobileportal.dagger.modules;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class NetworkUtilsModule_GsonFactory implements Factory<Gson> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkUtilsModule module;

    public NetworkUtilsModule_GsonFactory(NetworkUtilsModule networkUtilsModule) {
        this.module = networkUtilsModule;
    }

    public Gson get() {
        return (Gson) Preconditions.checkNotNull(this.module.gson(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<Gson> create(NetworkUtilsModule networkUtilsModule) {
        return new NetworkUtilsModule_GsonFactory(networkUtilsModule);
    }
}
