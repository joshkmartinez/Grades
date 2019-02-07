package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import com.aeries.mobileportal.interactors.main.MainInteractor;
import com.aeries.mobileportal.repos.adapters.NotificationsRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.RestrictionRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.RestrictionService;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_MainInteractorFactory implements Factory<MainInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AnalyticsService> analyticsServiceProvider;
    private final Provider<ApplicationService> applicationServiceProvider;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final Provider<Context> contextProvider;
    private final Provider<GoogleSignInClient> googleSignInClientProvider;
    private final InteractorModule module;
    private final Provider<NotificationsRepo> notificationsRepoProvider;
    private final Provider<RestrictionRepository> restrictionRepositoryProvider;
    private final Provider<RestrictionService> restrictionServiceProvider;
    private final Provider<SchoolRepo> schoolRepoProvider;
    private final Provider<StudentRepo> studentRepoProvider;
    private final Provider<TokenProvider> tokenProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public InteractorModule_MainInteractorFactory(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<ApplicationService> provider2, Provider<StudentRepo> provider3, Provider<SchoolRepo> provider4, Provider<NotificationsRepo> provider5, Provider<ConfigurationRepository> provider6, Provider<UserRepository> provider7, Provider<RestrictionRepository> provider8, Provider<RestrictionService> provider9, Provider<TokenProvider> provider10, Provider<GoogleSignInClient> provider11, Provider<Context> provider12) {
        this.module = interactorModule;
        this.analyticsServiceProvider = provider;
        this.applicationServiceProvider = provider2;
        this.studentRepoProvider = provider3;
        this.schoolRepoProvider = provider4;
        this.notificationsRepoProvider = provider5;
        this.configurationRepositoryProvider = provider6;
        this.userRepositoryProvider = provider7;
        this.restrictionRepositoryProvider = provider8;
        this.restrictionServiceProvider = provider9;
        this.tokenProvider = provider10;
        this.googleSignInClientProvider = provider11;
        this.contextProvider = provider12;
    }

    public MainInteractor get() {
        return (MainInteractor) Preconditions.checkNotNull(this.module.mainInteractor((AnalyticsService) this.analyticsServiceProvider.get(), (ApplicationService) this.applicationServiceProvider.get(), (StudentRepo) this.studentRepoProvider.get(), (SchoolRepo) this.schoolRepoProvider.get(), (NotificationsRepo) this.notificationsRepoProvider.get(), (ConfigurationRepository) this.configurationRepositoryProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (RestrictionRepository) this.restrictionRepositoryProvider.get(), (RestrictionService) this.restrictionServiceProvider.get(), (TokenProvider) this.tokenProvider.get(), (GoogleSignInClient) this.googleSignInClientProvider.get(), (Context) this.contextProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<MainInteractor> create(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<ApplicationService> provider2, Provider<StudentRepo> provider3, Provider<SchoolRepo> provider4, Provider<NotificationsRepo> provider5, Provider<ConfigurationRepository> provider6, Provider<UserRepository> provider7, Provider<RestrictionRepository> provider8, Provider<RestrictionService> provider9, Provider<TokenProvider> provider10, Provider<GoogleSignInClient> provider11, Provider<Context> provider12) {
        return new InteractorModule_MainInteractorFactory(interactorModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }
}
