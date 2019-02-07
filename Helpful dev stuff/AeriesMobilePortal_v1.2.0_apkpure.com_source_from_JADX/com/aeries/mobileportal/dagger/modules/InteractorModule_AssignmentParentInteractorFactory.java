package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.grades.AssignmentParentInteractor;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.GradesService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_AssignmentParentInteractorFactory implements Factory<AssignmentParentInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AnalyticsService> analyticsServiceProvider;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final Provider<GradesService> gradesServiceProvider;
    private final InteractorModule module;
    private final Provider<SchoolRepo> schoolRepoProvider;
    private final Provider<StudentRepo> studentRepoProvider;
    private final Provider<TokenProvider> tokenProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public InteractorModule_AssignmentParentInteractorFactory(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<GradesService> provider2, Provider<SchoolRepo> provider3, Provider<StudentRepo> provider4, Provider<ConfigurationRepository> provider5, Provider<UserRepository> provider6, Provider<TokenProvider> provider7) {
        this.module = interactorModule;
        this.analyticsServiceProvider = provider;
        this.gradesServiceProvider = provider2;
        this.schoolRepoProvider = provider3;
        this.studentRepoProvider = provider4;
        this.configurationRepositoryProvider = provider5;
        this.userRepositoryProvider = provider6;
        this.tokenProvider = provider7;
    }

    public AssignmentParentInteractor get() {
        return (AssignmentParentInteractor) Preconditions.checkNotNull(this.module.assignmentParentInteractor((AnalyticsService) this.analyticsServiceProvider.get(), (GradesService) this.gradesServiceProvider.get(), (SchoolRepo) this.schoolRepoProvider.get(), (StudentRepo) this.studentRepoProvider.get(), (ConfigurationRepository) this.configurationRepositoryProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (TokenProvider) this.tokenProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AssignmentParentInteractor> create(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<GradesService> provider2, Provider<SchoolRepo> provider3, Provider<StudentRepo> provider4, Provider<ConfigurationRepository> provider5, Provider<UserRepository> provider6, Provider<TokenProvider> provider7) {
        return new InteractorModule_AssignmentParentInteractorFactory(interactorModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
