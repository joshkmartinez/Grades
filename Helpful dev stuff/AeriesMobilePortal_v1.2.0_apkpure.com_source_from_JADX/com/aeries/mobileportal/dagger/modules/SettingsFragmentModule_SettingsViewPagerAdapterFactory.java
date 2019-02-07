package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import com.aeries.mobileportal.adapters.SettingsViewPagerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SettingsFragmentModule_SettingsViewPagerAdapterFactory implements Factory<SettingsViewPagerAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<Context> contextProvider;
    private final Provider<FragmentManager> fragmentManagerProvider;
    private final SettingsFragmentModule module;

    public SettingsFragmentModule_SettingsViewPagerAdapterFactory(SettingsFragmentModule settingsFragmentModule, Provider<Context> provider, Provider<FragmentManager> provider2) {
        this.module = settingsFragmentModule;
        this.contextProvider = provider;
        this.fragmentManagerProvider = provider2;
    }

    public SettingsViewPagerAdapter get() {
        return (SettingsViewPagerAdapter) Preconditions.checkNotNull(this.module.settingsViewPagerAdapter((Context) this.contextProvider.get(), (FragmentManager) this.fragmentManagerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SettingsViewPagerAdapter> create(SettingsFragmentModule settingsFragmentModule, Provider<Context> provider, Provider<FragmentManager> provider2) {
        return new SettingsFragmentModule_SettingsViewPagerAdapterFactory(settingsFragmentModule, provider, provider2);
    }
}
