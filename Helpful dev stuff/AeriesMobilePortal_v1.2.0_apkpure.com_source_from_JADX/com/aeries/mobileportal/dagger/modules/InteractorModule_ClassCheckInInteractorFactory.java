package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.supplementan_attendance.ClassCheckInInteractor;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.SupplementalAttendanceService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_ClassCheckInInteractorFactory implements Factory<ClassCheckInInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AnalyticsService> analyticsServiceProvider;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final InteractorModule module;
    private final Provider<SchoolRepo> schoolRepoProvider;
    private final Provider<StudentRepo> studentRepoProvider;
    private final Provider<SupplementalAttendanceService> supplementalAttendanceServiceProvider;
    private final Provider<TokenProvider> tokenProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public InteractorModule_ClassCheckInInteractorFactory(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<SupplementalAttendanceService> provider2, Provider<UserRepository> provider3, Provider<ConfigurationRepository> provider4, Provider<StudentRepo> provider5, Provider<SchoolRepo> provider6, Provider<TokenProvider> provider7) {
        this.module = interactorModule;
        this.analyticsServiceProvider = provider;
        this.supplementalAttendanceServiceProvider = provider2;
        this.userRepositoryProvider = provider3;
        this.configurationRepositoryProvider = provider4;
        this.studentRepoProvider = provider5;
        this.schoolRepoProvider = provider6;
        this.tokenProvider = provider7;
    }

    public ClassCheckInInteractor get() {
        return (ClassCheckInInteractor) Preconditions.checkNotNull(this.module.classCheckInInteractor((AnalyticsService) this.analyticsServiceProvider.get(), (SupplementalAttendanceService) this.supplementalAttendanceServiceProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (ConfigurationRepository) this.configurationRepositoryProvider.get(), (StudentRepo) this.studentRepoProvider.get(), (SchoolRepo) this.schoolRepoProvider.get(), (TokenProvider) this.tokenProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ClassCheckInInteractor> create(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<SupplementalAttendanceService> provider2, Provider<UserRepository> provider3, Provider<ConfigurationRepository> provider4, Provider<StudentRepo> provider5, Provider<SchoolRepo> provider6, Provider<TokenProvider> provider7) {
        return new InteractorModule_ClassCheckInInteractorFactory(interactorModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
