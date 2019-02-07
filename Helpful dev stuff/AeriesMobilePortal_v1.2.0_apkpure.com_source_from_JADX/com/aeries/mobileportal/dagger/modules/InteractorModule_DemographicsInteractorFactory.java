package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.demographics.DemographicsInteractor;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_DemographicsInteractorFactory implements Factory<DemographicsInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AnalyticsService> analyticsServiceProvider;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final InteractorModule module;
    private final Provider<NetworkRepo> networkRepositoryProvider;
    private final Provider<SchoolRepo> schoolRepoProvider;
    private final Provider<StudentRepo> studentRepoProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public InteractorModule_DemographicsInteractorFactory(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<UserRepository> provider2, Provider<ConfigurationRepository> provider3, Provider<NetworkRepo> provider4, Provider<StudentRepo> provider5, Provider<SchoolRepo> provider6) {
        this.module = interactorModule;
        this.analyticsServiceProvider = provider;
        this.userRepositoryProvider = provider2;
        this.configurationRepositoryProvider = provider3;
        this.networkRepositoryProvider = provider4;
        this.studentRepoProvider = provider5;
        this.schoolRepoProvider = provider6;
    }

    public DemographicsInteractor get() {
        return (DemographicsInteractor) Preconditions.checkNotNull(this.module.demographicsInteractor((AnalyticsService) this.analyticsServiceProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (ConfigurationRepository) this.configurationRepositoryProvider.get(), (NetworkRepo) this.networkRepositoryProvider.get(), (StudentRepo) this.studentRepoProvider.get(), (SchoolRepo) this.schoolRepoProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<DemographicsInteractor> create(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<UserRepository> provider2, Provider<ConfigurationRepository> provider3, Provider<NetworkRepo> provider4, Provider<StudentRepo> provider5, Provider<SchoolRepo> provider6) {
        return new InteractorModule_DemographicsInteractorFactory(interactorModule, provider, provider2, provider3, provider4, provider5, provider6);
    }
}
