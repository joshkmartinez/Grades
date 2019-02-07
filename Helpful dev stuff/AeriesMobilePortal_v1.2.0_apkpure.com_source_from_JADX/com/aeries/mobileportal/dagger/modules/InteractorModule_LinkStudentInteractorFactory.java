package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.link_student.LinkStudentInteractor;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.LinkStudentService;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_LinkStudentInteractorFactory implements Factory<LinkStudentInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AnalyticsService> analyticsServiceProvider;
    private final Provider<ApplicationService> applicationServiceProvider;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final Provider<GoogleSignInClient> googleSignInClientProvider;
    private final Provider<LinkStudentService> linkStudentServiceProvider;
    private final InteractorModule module;
    private final Provider<SchoolRepo> schoolRepoProvider;
    private final Provider<StudentRepo> studentRepoProvider;
    private final Provider<TokenProvider> tokenProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public InteractorModule_LinkStudentInteractorFactory(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<UserRepository> provider2, Provider<TokenProvider> provider3, Provider<ConfigurationRepository> provider4, Provider<StudentRepo> provider5, Provider<SchoolRepo> provider6, Provider<GoogleSignInClient> provider7, Provider<LinkStudentService> provider8, Provider<ApplicationService> provider9) {
        this.module = interactorModule;
        this.analyticsServiceProvider = provider;
        this.userRepositoryProvider = provider2;
        this.tokenProvider = provider3;
        this.configurationRepositoryProvider = provider4;
        this.studentRepoProvider = provider5;
        this.schoolRepoProvider = provider6;
        this.googleSignInClientProvider = provider7;
        this.linkStudentServiceProvider = provider8;
        this.applicationServiceProvider = provider9;
    }

    public LinkStudentInteractor get() {
        return (LinkStudentInteractor) Preconditions.checkNotNull(this.module.linkStudentInteractor((AnalyticsService) this.analyticsServiceProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (TokenProvider) this.tokenProvider.get(), (ConfigurationRepository) this.configurationRepositoryProvider.get(), (StudentRepo) this.studentRepoProvider.get(), (SchoolRepo) this.schoolRepoProvider.get(), (GoogleSignInClient) this.googleSignInClientProvider.get(), (LinkStudentService) this.linkStudentServiceProvider.get(), (ApplicationService) this.applicationServiceProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<LinkStudentInteractor> create(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<UserRepository> provider2, Provider<TokenProvider> provider3, Provider<ConfigurationRepository> provider4, Provider<StudentRepo> provider5, Provider<SchoolRepo> provider6, Provider<GoogleSignInClient> provider7, Provider<LinkStudentService> provider8, Provider<ApplicationService> provider9) {
        return new InteractorModule_LinkStudentInteractorFactory(interactorModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }
}
