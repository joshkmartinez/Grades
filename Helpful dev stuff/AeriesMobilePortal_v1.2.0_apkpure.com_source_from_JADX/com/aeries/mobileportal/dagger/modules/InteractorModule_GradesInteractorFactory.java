package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.grades.GradesInteractor;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.GradesService;
import com.aeries.mobileportal.web_services.services.WhatIfService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_GradesInteractorFactory implements Factory<GradesInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AnalyticsService> analyticsServiceProvider;
    private final Provider<ApplicationService> applicationServiceProvider;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final Provider<GradesService> gradesServiceProvider;
    private final InteractorModule module;
    private final Provider<SchoolRepo> schoolRepoProvider;
    private final Provider<StudentRepo> studentRepoProvider;
    private final Provider<TokenProvider> tokenProvider;
    private final Provider<UserRepository> userRepositoryProvider;
    private final Provider<WhatIfService> whatIfServiceProvider;

    public InteractorModule_GradesInteractorFactory(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<GradesService> provider2, Provider<ApplicationService> provider3, Provider<WhatIfService> provider4, Provider<UserRepository> provider5, Provider<ConfigurationRepository> provider6, Provider<StudentRepo> provider7, Provider<SchoolRepo> provider8, Provider<TokenProvider> provider9) {
        this.module = interactorModule;
        this.analyticsServiceProvider = provider;
        this.gradesServiceProvider = provider2;
        this.applicationServiceProvider = provider3;
        this.whatIfServiceProvider = provider4;
        this.userRepositoryProvider = provider5;
        this.configurationRepositoryProvider = provider6;
        this.studentRepoProvider = provider7;
        this.schoolRepoProvider = provider8;
        this.tokenProvider = provider9;
    }

    public GradesInteractor get() {
        return (GradesInteractor) Preconditions.checkNotNull(this.module.gradesInteractor((AnalyticsService) this.analyticsServiceProvider.get(), (GradesService) this.gradesServiceProvider.get(), (ApplicationService) this.applicationServiceProvider.get(), (WhatIfService) this.whatIfServiceProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (ConfigurationRepository) this.configurationRepositoryProvider.get(), (StudentRepo) this.studentRepoProvider.get(), (SchoolRepo) this.schoolRepoProvider.get(), (TokenProvider) this.tokenProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<GradesInteractor> create(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<GradesService> provider2, Provider<ApplicationService> provider3, Provider<WhatIfService> provider4, Provider<UserRepository> provider5, Provider<ConfigurationRepository> provider6, Provider<StudentRepo> provider7, Provider<SchoolRepo> provider8, Provider<TokenProvider> provider9) {
        return new InteractorModule_GradesInteractorFactory(interactorModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }
}
