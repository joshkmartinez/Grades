package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.AccountSettingsInteractor;
import com.aeries.mobileportal.presenters.AccountSettingsPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SettingsAdapterModule_SettingsPresenterFactory implements Factory<AccountSettingsPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AccountSettingsInteractor> interactorProvider;
    private final SettingsAdapterModule module;

    public SettingsAdapterModule_SettingsPresenterFactory(SettingsAdapterModule settingsAdapterModule, Provider<AccountSettingsInteractor> provider) {
        this.module = settingsAdapterModule;
        this.interactorProvider = provider;
    }

    public AccountSettingsPresenter get() {
        return (AccountSettingsPresenter) Preconditions.checkNotNull(this.module.settingsPresenter((AccountSettingsInteractor) this.interactorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AccountSettingsPresenter> create(SettingsAdapterModule settingsAdapterModule, Provider<AccountSettingsInteractor> provider) {
        return new SettingsAdapterModule_SettingsPresenterFactory(settingsAdapterModule, provider);
    }
}
