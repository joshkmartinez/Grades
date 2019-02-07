package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.grades.CoursesInteractor;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.GradesService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_CoursesInteractorFactory implements Factory<CoursesInteractor> {
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

    public InteractorModule_CoursesInteractorFactory(InteractorModule interactorModule, Provider<SchoolRepo> provider, Provider<StudentRepo> provider2, Provider<UserRepository> provider3, Provider<ConfigurationRepository> provider4, Provider<TokenProvider> provider5, Provider<ApplicationService> provider6, Provider<AnalyticsService> provider7, Provider<GradesService> provider8) {
        this.module = interactorModule;
        this.schoolRepoProvider = provider;
        this.studentRepoProvider = provider2;
        this.userRepositoryProvider = provider3;
        this.configurationRepositoryProvider = provider4;
        this.tokenProvider = provider5;
        this.applicationServiceProvider = provider6;
        this.analyticsServiceProvider = provider7;
        this.gradesServiceProvider = provider8;
    }

    public CoursesInteractor get() {
        return (CoursesInteractor) Preconditions.checkNotNull(this.module.coursesInteractor((SchoolRepo) this.schoolRepoProvider.get(), (StudentRepo) this.studentRepoProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (ConfigurationRepository) this.configurationRepositoryProvider.get(), (TokenProvider) this.tokenProvider.get(), (ApplicationService) this.applicationServiceProvider.get(), (AnalyticsService) this.analyticsServiceProvider.get(), (GradesService) this.gradesServiceProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<CoursesInteractor> create(InteractorModule interactorModule, Provider<SchoolRepo> provider, Provider<StudentRepo> provider2, Provider<UserRepository> provider3, Provider<ConfigurationRepository> provider4, Provider<TokenProvider> provider5, Provider<ApplicationService> provider6, Provider<AnalyticsService> provider7, Provider<GradesService> provider8) {
        return new InteractorModule_CoursesInteractorFactory(interactorModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }
}
