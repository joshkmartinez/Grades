package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.DistrictsAdapter;
import com.aeries.mobileportal.adapters.DistrictsAdapter.DistrictsListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DistrictsAdapterModule_DistrictsAdapterFactory implements Factory<DistrictsAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<DistrictsListener> listenerProvider;
    private final DistrictsAdapterModule module;

    public DistrictsAdapterModule_DistrictsAdapterFactory(DistrictsAdapterModule districtsAdapterModule, Provider<DistrictsListener> provider) {
        this.module = districtsAdapterModule;
        this.listenerProvider = provider;
    }

    public DistrictsAdapter get() {
        return (DistrictsAdapter) Preconditions.checkNotNull(this.module.districtsAdapter((DistrictsListener) this.listenerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<DistrictsAdapter> create(DistrictsAdapterModule districtsAdapterModule, Provider<DistrictsListener> provider) {
        return new DistrictsAdapterModule_DistrictsAdapterFactory(districtsAdapterModule, provider);
    }
}
