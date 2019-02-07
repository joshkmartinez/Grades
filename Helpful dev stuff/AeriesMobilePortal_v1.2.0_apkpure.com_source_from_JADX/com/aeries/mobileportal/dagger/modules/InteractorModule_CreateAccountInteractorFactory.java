package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.create_account.CreateAccountInteractor;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.CreateAccountService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_CreateAccountInteractorFactory implements Factory<CreateAccountInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AnalyticsService> analyticsServiceProvider;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final Provider<CreateAccountService> createAccountServiceProvider;
    private final InteractorModule module;
    private final Provider<SchoolRepo> schoolRepoProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public InteractorModule_CreateAccountInteractorFactory(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<CreateAccountService> provider2, Provider<ConfigurationRepository> provider3, Provider<SchoolRepo> provider4, Provider<UserRepository> provider5) {
        this.module = interactorModule;
        this.analyticsServiceProvider = provider;
        this.createAccountServiceProvider = provider2;
        this.configurationRepositoryProvider = provider3;
        this.schoolRepoProvider = provider4;
        this.userRepositoryProvider = provider5;
    }

    public CreateAccountInteractor get() {
        return (CreateAccountInteractor) Preconditions.checkNotNull(this.module.createAccountInteractor((AnalyticsService) this.analyticsServiceProvider.get(), (CreateAccountService) this.createAccountServiceProvider.get(), (ConfigurationRepository) this.configurationRepositoryProvider.get(), (SchoolRepo) this.schoolRepoProvider.get(), (UserRepository) this.userRepositoryProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<CreateAccountInteractor> create(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<CreateAccountService> provider2, Provider<ConfigurationRepository> provider3, Provider<SchoolRepo> provider4, Provider<UserRepository> provider5) {
        return new InteractorModule_CreateAccountInteractorFactory(interactorModule, provider, provider2, provider3, provider4, provider5);
    }
}
