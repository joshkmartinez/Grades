package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.SettingsAdapter.SettingsListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SettingsAdapterModule_SettingsListenerFactory implements Factory<SettingsListener> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SettingsAdapterModule module;

    public SettingsAdapterModule_SettingsListenerFactory(SettingsAdapterModule settingsAdapterModule) {
        this.module = settingsAdapterModule;
    }

    public SettingsListener get() {
        return (SettingsListener) Preconditions.checkNotNull(this.module.settingsListener(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SettingsListener> create(SettingsAdapterModule settingsAdapterModule) {
        return new SettingsAdapterModule_SettingsListenerFactory(settingsAdapterModule);
    }
}
