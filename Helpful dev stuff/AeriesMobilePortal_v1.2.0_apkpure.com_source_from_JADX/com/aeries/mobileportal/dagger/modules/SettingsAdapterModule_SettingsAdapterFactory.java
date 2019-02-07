package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.SettingsAdapter;
import com.aeries.mobileportal.adapters.SettingsAdapter.SettingsListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SettingsAdapterModule_SettingsAdapterFactory implements Factory<SettingsAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<SettingsListener> listenerProvider;
    private final SettingsAdapterModule module;

    public SettingsAdapterModule_SettingsAdapterFactory(SettingsAdapterModule settingsAdapterModule, Provider<SettingsListener> provider) {
        this.module = settingsAdapterModule;
        this.listenerProvider = provider;
    }

    public SettingsAdapter get() {
        return (SettingsAdapter) Preconditions.checkNotNull(this.module.settingsAdapter((SettingsListener) this.listenerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SettingsAdapter> create(SettingsAdapterModule settingsAdapterModule, Provider<SettingsListener> provider) {
        return new SettingsAdapterModule_SettingsAdapterFactory(settingsAdapterModule, provider);
    }
}
