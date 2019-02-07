package com.aeries.mobileportal.dagger.modules;

import android.accounts.AccountManager;
import com.aeries.mobileportal.interactors.change_password.ChangePasswordInteractor;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.PasswordService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_ChangePasswordInteractorFactory implements Factory<ChangePasswordInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AccountManager> accountManagerProvider;
    private final Provider<AnalyticsService> analyticsServiceProvider;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final InteractorModule module;
    private final Provider<PasswordService> passwordServiceProvider;
    private final Provider<SchoolRepo> schoolRepoProvider;
    private final Provider<StudentRepo> studentRepoProvider;
    private final Provider<TokenProvider> tokenProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public InteractorModule_ChangePasswordInteractorFactory(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<UserRepository> provider2, Provider<ConfigurationRepository> provider3, Provider<TokenProvider> provider4, Provider<SchoolRepo> provider5, Provider<StudentRepo> provider6, Provider<PasswordService> provider7, Provider<AccountManager> provider8) {
        this.module = interactorModule;
        this.analyticsServiceProvider = provider;
        this.userRepositoryProvider = provider2;
        this.configurationRepositoryProvider = provider3;
        this.tokenProvider = provider4;
        this.schoolRepoProvider = provider5;
        this.studentRepoProvider = provider6;
        this.passwordServiceProvider = provider7;
        this.accountManagerProvider = provider8;
    }

    public ChangePasswordInteractor get() {
        return (ChangePasswordInteractor) Preconditions.checkNotNull(this.module.changePasswordInteractor((AnalyticsService) this.analyticsServiceProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (ConfigurationRepository) this.configurationRepositoryProvider.get(), (TokenProvider) this.tokenProvider.get(), (SchoolRepo) this.schoolRepoProvider.get(), (StudentRepo) this.studentRepoProvider.get(), (PasswordService) this.passwordServiceProvider.get(), (AccountManager) this.accountManagerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ChangePasswordInteractor> create(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<UserRepository> provider2, Provider<ConfigurationRepository> provider3, Provider<TokenProvider> provider4, Provider<SchoolRepo> provider5, Provider<StudentRepo> provider6, Provider<PasswordService> provider7, Provider<AccountManager> provider8) {
        return new InteractorModule_ChangePasswordInteractorFactory(interactorModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }
}
