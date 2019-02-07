package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.AccountSettingsInteractor;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_AccountSettingsInteractorFactory implements Factory<AccountSettingsInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final InteractorModule module;
    private final Provider<SchoolRepo> schoolRepoProvider;

    public InteractorModule_AccountSettingsInteractorFactory(InteractorModule interactorModule, Provider<ConfigurationRepository> provider, Provider<SchoolRepo> provider2) {
        this.module = interactorModule;
        this.configurationRepositoryProvider = provider;
        this.schoolRepoProvider = provider2;
    }

    public AccountSettingsInteractor get() {
        return (AccountSettingsInteractor) Preconditions.checkNotNull(this.module.accountSettingsInteractor((ConfigurationRepository) this.configurationRepositoryProvider.get(), (SchoolRepo) this.schoolRepoProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AccountSettingsInteractor> create(InteractorModule interactorModule, Provider<ConfigurationRepository> provider, Provider<SchoolRepo> provider2) {
        return new InteractorModule_AccountSettingsInteractorFactory(interactorModule, provider, provider2);
    }
}
