package com.aeries.mobileportal.dagger.modules;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class NetworkUtilsSchoolModule_GsonFactory implements Factory<Gson> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkUtilsSchoolModule module;

    public NetworkUtilsSchoolModule_GsonFactory(NetworkUtilsSchoolModule networkUtilsSchoolModule) {
        this.module = networkUtilsSchoolModule;
    }

    public Gson get() {
        return (Gson) Preconditions.checkNotNull(this.module.gson(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<Gson> create(NetworkUtilsSchoolModule networkUtilsSchoolModule) {
        return new NetworkUtilsSchoolModule_GsonFactory(networkUtilsSchoolModule);
    }
}
