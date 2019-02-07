package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.attendance.AttendanceInteractor;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.AttendanceService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_AttendanceInteractorFactory implements Factory<AttendanceInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AnalyticsService> analyticsServiceProvider;
    private final Provider<AttendanceService> attendanceServiceProvider;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final InteractorModule module;
    private final Provider<SchoolRepo> schoolRepoProvider;
    private final Provider<StudentRepo> studentRepoProvider;
    private final Provider<TokenProvider> tokenProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public InteractorModule_AttendanceInteractorFactory(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<AttendanceService> provider2, Provider<TokenProvider> provider3, Provider<UserRepository> provider4, Provider<ConfigurationRepository> provider5, Provider<StudentRepo> provider6, Provider<SchoolRepo> provider7) {
        this.module = interactorModule;
        this.analyticsServiceProvider = provider;
        this.attendanceServiceProvider = provider2;
        this.tokenProvider = provider3;
        this.userRepositoryProvider = provider4;
        this.configurationRepositoryProvider = provider5;
        this.studentRepoProvider = provider6;
        this.schoolRepoProvider = provider7;
    }

    public AttendanceInteractor get() {
        return (AttendanceInteractor) Preconditions.checkNotNull(this.module.attendanceInteractor((AnalyticsService) this.analyticsServiceProvider.get(), (AttendanceService) this.attendanceServiceProvider.get(), (TokenProvider) this.tokenProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (ConfigurationRepository) this.configurationRepositoryProvider.get(), (StudentRepo) this.studentRepoProvider.get(), (SchoolRepo) this.schoolRepoProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AttendanceInteractor> create(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<AttendanceService> provider2, Provider<TokenProvider> provider3, Provider<UserRepository> provider4, Provider<ConfigurationRepository> provider5, Provider<StudentRepo> provider6, Provider<SchoolRepo> provider7) {
        return new InteractorModule_AttendanceInteractorFactory(interactorModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
