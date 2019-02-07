package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.settings.SettingsInteractor;
import com.aeries.mobileportal.presenters.settings.SettingsPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SettingsFragmentModule_SettingsPresenterFactory implements Factory<SettingsPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<SettingsInteractor> interactorProvider;
    private final SettingsFragmentModule module;

    public SettingsFragmentModule_SettingsPresenterFactory(SettingsFragmentModule settingsFragmentModule, Provider<SettingsInteractor> provider) {
        this.module = settingsFragmentModule;
        this.interactorProvider = provider;
    }

    public SettingsPresenter get() {
        return (SettingsPresenter) Preconditions.checkNotNull(this.module.settingsPresenter((SettingsInteractor) this.interactorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SettingsPresenter> create(SettingsFragmentModule settingsFragmentModule, Provider<SettingsInteractor> provider) {
        return new SettingsFragmentModule_SettingsPresenterFactory(settingsFragmentModule, provider);
    }
}
