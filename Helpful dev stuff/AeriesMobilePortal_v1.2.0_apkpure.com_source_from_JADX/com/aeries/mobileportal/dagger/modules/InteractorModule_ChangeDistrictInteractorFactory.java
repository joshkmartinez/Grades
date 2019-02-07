package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.change_district.ChangeDistrictInteractor;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_ChangeDistrictInteractorFactory implements Factory<ChangeDistrictInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ApplicationService> applicationServiceProvider;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final InteractorModule module;
    private final Provider<NetworkRepo> networkRepositoryProvider;
    private final Provider<SchoolRepo> schoolRepoProvider;
    private final Provider<StudentRepo> studentRepoProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public InteractorModule_ChangeDistrictInteractorFactory(InteractorModule interactorModule, Provider<NetworkRepo> provider, Provider<UserRepository> provider2, Provider<TokenRepository> provider3, Provider<ConfigurationRepository> provider4, Provider<SchoolRepo> provider5, Provider<StudentRepo> provider6, Provider<ApplicationService> provider7) {
        this.module = interactorModule;
        this.networkRepositoryProvider = provider;
        this.userRepositoryProvider = provider2;
        this.tokenRepositoryProvider = provider3;
        this.configurationRepositoryProvider = provider4;
        this.schoolRepoProvider = provider5;
        this.studentRepoProvider = provider6;
        this.applicationServiceProvider = provider7;
    }

    public ChangeDistrictInteractor get() {
        return (ChangeDistrictInteractor) Preconditions.checkNotNull(this.module.changeDistrictInteractor((NetworkRepo) this.networkRepositoryProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (TokenRepository) this.tokenRepositoryProvider.get(), (ConfigurationRepository) this.configurationRepositoryProvider.get(), (SchoolRepo) this.schoolRepoProvider.get(), (StudentRepo) this.studentRepoProvider.get(), (ApplicationService) this.applicationServiceProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ChangeDistrictInteractor> create(InteractorModule interactorModule, Provider<NetworkRepo> provider, Provider<UserRepository> provider2, Provider<TokenRepository> provider3, Provider<ConfigurationRepository> provider4, Provider<SchoolRepo> provider5, Provider<StudentRepo> provider6, Provider<ApplicationService> provider7) {
        return new InteractorModule_ChangeDistrictInteractorFactory(interactorModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
