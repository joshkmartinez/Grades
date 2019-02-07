package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.DistrictsAdapter.DistrictsListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class DistrictsAdapterModule_DistrictsListenerFactory implements Factory<DistrictsListener> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final DistrictsAdapterModule module;

    public DistrictsAdapterModule_DistrictsListenerFactory(DistrictsAdapterModule districtsAdapterModule) {
        this.module = districtsAdapterModule;
    }

    public DistrictsListener get() {
        return (DistrictsListener) Preconditions.checkNotNull(this.module.districtsListener(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<DistrictsListener> create(DistrictsAdapterModule districtsAdapterModule) {
        return new DistrictsAdapterModule_DistrictsListenerFactory(districtsAdapterModule);
    }
}
