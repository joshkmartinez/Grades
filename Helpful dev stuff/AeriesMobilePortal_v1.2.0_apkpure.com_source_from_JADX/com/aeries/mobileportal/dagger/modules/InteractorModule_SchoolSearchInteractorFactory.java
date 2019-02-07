package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.school.select.SchoolSearchInteractor;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationStartupService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_SchoolSearchInteractorFactory implements Factory<SchoolSearchInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AnalyticsService> analyticsServiceProvider;
    private final Provider<ApplicationStartupService> applicationServiceProvider;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final InteractorModule module;
    private final Provider<NetworkRepo> networkRepositoryProvider;
    private final Provider<SchoolRepo> schoolRepoProvider;

    public InteractorModule_SchoolSearchInteractorFactory(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<ApplicationStartupService> provider2, Provider<SchoolRepo> provider3, Provider<NetworkRepo> provider4, Provider<ConfigurationRepository> provider5) {
        this.module = interactorModule;
        this.analyticsServiceProvider = provider;
        this.applicationServiceProvider = provider2;
        this.schoolRepoProvider = provider3;
        this.networkRepositoryProvider = provider4;
        this.configurationRepositoryProvider = provider5;
    }

    public SchoolSearchInteractor get() {
        return (SchoolSearchInteractor) Preconditions.checkNotNull(this.module.schoolSearchInteractor((AnalyticsService) this.analyticsServiceProvider.get(), (ApplicationStartupService) this.applicationServiceProvider.get(), (SchoolRepo) this.schoolRepoProvider.get(), (NetworkRepo) this.networkRepositoryProvider.get(), (ConfigurationRepository) this.configurationRepositoryProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SchoolSearchInteractor> create(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<ApplicationStartupService> provider2, Provider<SchoolRepo> provider3, Provider<NetworkRepo> provider4, Provider<ConfigurationRepository> provider5) {
        return new InteractorModule_SchoolSearchInteractorFactory(interactorModule, provider, provider2, provider3, provider4, provider5);
    }
}
