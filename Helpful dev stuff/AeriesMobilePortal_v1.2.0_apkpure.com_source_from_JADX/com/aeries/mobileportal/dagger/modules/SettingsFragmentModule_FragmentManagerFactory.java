package com.aeries.mobileportal.dagger.modules;

import android.support.v4.app.FragmentManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SettingsFragmentModule_FragmentManagerFactory implements Factory<FragmentManager> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SettingsFragmentModule module;

    public SettingsFragmentModule_FragmentManagerFactory(SettingsFragmentModule settingsFragmentModule) {
        this.module = settingsFragmentModule;
    }

    public FragmentManager get() {
        return (FragmentManager) Preconditions.checkNotNull(this.module.fragmentManager(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<FragmentManager> create(SettingsFragmentModule settingsFragmentModule) {
        return new SettingsFragmentModule_FragmentManagerFactory(settingsFragmentModule);
    }
}
