package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.SettingsAdapter;
import com.aeries.mobileportal.presenters.AccountSettingsPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AccountSettingsFragment_MembersInjector implements MembersInjector<AccountSettingsFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<SettingsAdapter> adapterProvider;
    private final Provider<AccountSettingsPresenter> presenterProvider;

    public AccountSettingsFragment_MembersInjector(Provider<SettingsAdapter> provider, Provider<AccountSettingsPresenter> provider2) {
        this.adapterProvider = provider;
        this.presenterProvider = provider2;
    }

    public static MembersInjector<AccountSettingsFragment> create(Provider<SettingsAdapter> provider, Provider<AccountSettingsPresenter> provider2) {
        return new AccountSettingsFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(AccountSettingsFragment accountSettingsFragment) {
        if (accountSettingsFragment != null) {
            accountSettingsFragment.adapter = (SettingsAdapter) this.adapterProvider.get();
            accountSettingsFragment.presenter = (AccountSettingsPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
