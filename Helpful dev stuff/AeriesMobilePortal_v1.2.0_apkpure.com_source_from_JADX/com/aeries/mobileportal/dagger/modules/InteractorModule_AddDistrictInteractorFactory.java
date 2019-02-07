package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.add_district.AddDistrictInteractor;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_AddDistrictInteractorFactory implements Factory<AddDistrictInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AnalyticsService> analyticsServiceProvider;
    private final Provider<ApplicationService> applicationServiceProvider;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final InteractorModule module;
    private final Provider<NetworkRepo> networkRepositoryProvider;
    private final Provider<SchoolRepo> schoolRepoProvider;
    private final Provider<ServicesProvider> servicesProvider;
    private final Provider<StudentRepo> studentRepoProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public InteractorModule_AddDistrictInteractorFactory(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<NetworkRepo> provider2, Provider<UserRepository> provider3, Provider<ConfigurationRepository> provider4, Provider<TokenRepository> provider5, Provider<SchoolRepo> provider6, Provider<StudentRepo> provider7, Provider<ApplicationService> provider8, Provider<ServicesProvider> provider9) {
        this.module = interactorModule;
        this.analyticsServiceProvider = provider;
        this.networkRepositoryProvider = provider2;
        this.userRepositoryProvider = provider3;
        this.configurationRepositoryProvider = provider4;
        this.tokenRepositoryProvider = provider5;
        this.schoolRepoProvider = provider6;
        this.studentRepoProvider = provider7;
        this.applicationServiceProvider = provider8;
        this.servicesProvider = provider9;
    }

    public AddDistrictInteractor get() {
        return (AddDistrictInteractor) Preconditions.checkNotNull(this.module.addDistrictInteractor((AnalyticsService) this.analyticsServiceProvider.get(), (NetworkRepo) this.networkRepositoryProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (ConfigurationRepository) this.configurationRepositoryProvider.get(), (TokenRepository) this.tokenRepositoryProvider.get(), (SchoolRepo) this.schoolRepoProvider.get(), (StudentRepo) this.studentRepoProvider.get(), (ApplicationService) this.applicationServiceProvider.get(), (ServicesProvider) this.servicesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AddDistrictInteractor> create(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<NetworkRepo> provider2, Provider<UserRepository> provider3, Provider<ConfigurationRepository> provider4, Provider<TokenRepository> provider5, Provider<SchoolRepo> provider6, Provider<StudentRepo> provider7, Provider<ApplicationService> provider8, Provider<ServicesProvider> provider9) {
        return new InteractorModule_AddDistrictInteractorFactory(interactorModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }
}
