package com.aeries.mobileportal.dagger.modules;

import android.accounts.AccountManager;
import android.content.Context;
import com.aeries.mobileportal.interactors.login.LoginInteractor;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.LoginService;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.GoogleApiClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_LoginInteractorFactory implements Factory<LoginInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AccountManager> accountManagerProvider;
    private final Provider<AnalyticsService> analyticsServiceProvider;
    private final Provider<ApplicationService> applicationServiceProvider;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final Provider<Context> contextProvider;
    private final Provider<GoogleApiClient> googleApiClientProvider;
    private final Provider<GoogleSignInClient> googleSignInClientProvider;
    private final Provider<LoginService> loginServiceProvider;
    private final InteractorModule module;
    private final Provider<NetworkRepo> networkRepositoryProvider;
    private final Provider<SchoolRepo> schoolRepoProvider;
    private final Provider<ServicesProvider> servicesProvider;
    private final Provider<StudentRepo> studentRepoProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public InteractorModule_LoginInteractorFactory(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<LoginService> provider2, Provider<ApplicationService> provider3, Provider<UserRepository> provider4, Provider<TokenRepository> provider5, Provider<ConfigurationRepository> provider6, Provider<NetworkRepo> provider7, Provider<ServicesProvider> provider8, Provider<StudentRepo> provider9, Provider<SchoolRepo> provider10, Provider<AccountManager> provider11, Provider<Context> provider12, Provider<GoogleSignInClient> provider13, Provider<GoogleApiClient> provider14) {
        this.module = interactorModule;
        this.analyticsServiceProvider = provider;
        this.loginServiceProvider = provider2;
        this.applicationServiceProvider = provider3;
        this.userRepositoryProvider = provider4;
        this.tokenRepositoryProvider = provider5;
        this.configurationRepositoryProvider = provider6;
        this.networkRepositoryProvider = provider7;
        this.servicesProvider = provider8;
        this.studentRepoProvider = provider9;
        this.schoolRepoProvider = provider10;
        this.accountManagerProvider = provider11;
        this.contextProvider = provider12;
        this.googleSignInClientProvider = provider13;
        this.googleApiClientProvider = provider14;
    }

    public LoginInteractor get() {
        return (LoginInteractor) Preconditions.checkNotNull(this.module.loginInteractor((AnalyticsService) this.analyticsServiceProvider.get(), (LoginService) this.loginServiceProvider.get(), (ApplicationService) this.applicationServiceProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (TokenRepository) this.tokenRepositoryProvider.get(), (ConfigurationRepository) this.configurationRepositoryProvider.get(), (NetworkRepo) this.networkRepositoryProvider.get(), (ServicesProvider) this.servicesProvider.get(), (StudentRepo) this.studentRepoProvider.get(), (SchoolRepo) this.schoolRepoProvider.get(), (AccountManager) this.accountManagerProvider.get(), (Context) this.contextProvider.get(), (GoogleSignInClient) this.googleSignInClientProvider.get(), (GoogleApiClient) this.googleApiClientProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<LoginInteractor> create(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<LoginService> provider2, Provider<ApplicationService> provider3, Provider<UserRepository> provider4, Provider<TokenRepository> provider5, Provider<ConfigurationRepository> provider6, Provider<NetworkRepo> provider7, Provider<ServicesProvider> provider8, Provider<StudentRepo> provider9, Provider<SchoolRepo> provider10, Provider<AccountManager> provider11, Provider<Context> provider12, Provider<GoogleSignInClient> provider13, Provider<GoogleApiClient> provider14) {
        return new InteractorModule_LoginInteractorFactory(interactorModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14);
    }
}
