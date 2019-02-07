package com.aeries.mobileportal.dagger.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Converter;

public final class NetworkUtilsModule_ConverterFactoryFactory implements Factory<Converter.Factory> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkUtilsModule module;

    public NetworkUtilsModule_ConverterFactoryFactory(NetworkUtilsModule networkUtilsModule) {
        this.module = networkUtilsModule;
    }

    public Converter.Factory get() {
        return (Converter.Factory) Preconditions.checkNotNull(this.module.converterFactory(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<Converter.Factory> create(NetworkUtilsModule networkUtilsModule) {
        return new NetworkUtilsModule_ConverterFactoryFactory(networkUtilsModule);
    }
}
