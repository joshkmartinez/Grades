package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.SettingsViewPagerAdapter;
import com.aeries.mobileportal.presenters.settings.SettingsPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SettingsFragment_MembersInjector implements MembersInjector<SettingsFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<SettingsViewPagerAdapter> adapterProvider;
    private final Provider<SettingsPresenter> presenterProvider;

    public SettingsFragment_MembersInjector(Provider<SettingsViewPagerAdapter> provider, Provider<SettingsPresenter> provider2) {
        this.adapterProvider = provider;
        this.presenterProvider = provider2;
    }

    public static MembersInjector<SettingsFragment> create(Provider<SettingsViewPagerAdapter> provider, Provider<SettingsPresenter> provider2) {
        return new SettingsFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(SettingsFragment settingsFragment) {
        if (settingsFragment != null) {
            settingsFragment.adapter = (SettingsViewPagerAdapter) this.adapterProvider.get();
            settingsFragment.presenter = (SettingsPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
