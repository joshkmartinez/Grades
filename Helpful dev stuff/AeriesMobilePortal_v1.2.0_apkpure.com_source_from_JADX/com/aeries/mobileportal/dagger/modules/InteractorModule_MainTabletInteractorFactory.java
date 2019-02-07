package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.tablet.MainTabletInteractor;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.GradesService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_MainTabletInteractorFactory implements Factory<MainTabletInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ApplicationService> applicationServiceProvider;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final Provider<GradesService> gradesServiceProvider;
    private final InteractorModule module;
    private final Provider<SchoolRepo> schoolRepoProvider;
    private final Provider<StudentRepo> studentRepoProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public InteractorModule_MainTabletInteractorFactory(InteractorModule interactorModule, Provider<StudentRepo> provider, Provider<SchoolRepo> provider2, Provider<UserRepository> provider3, Provider<ConfigurationRepository> provider4, Provider<TokenRepository> provider5, Provider<ApplicationService> provider6, Provider<GradesService> provider7) {
        this.module = interactorModule;
        this.studentRepoProvider = provider;
        this.schoolRepoProvider = provider2;
        this.userRepositoryProvider = provider3;
        this.configurationRepositoryProvider = provider4;
        this.tokenRepositoryProvider = provider5;
        this.applicationServiceProvider = provider6;
        this.gradesServiceProvider = provider7;
    }

    public MainTabletInteractor get() {
        return (MainTabletInteractor) Preconditions.checkNotNull(this.module.mainTabletInteractor((StudentRepo) this.studentRepoProvider.get(), (SchoolRepo) this.schoolRepoProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (ConfigurationRepository) this.configurationRepositoryProvider.get(), (TokenRepository) this.tokenRepositoryProvider.get(), (ApplicationService) this.applicationServiceProvider.get(), (GradesService) this.gradesServiceProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<MainTabletInteractor> create(InteractorModule interactorModule, Provider<StudentRepo> provider, Provider<SchoolRepo> provider2, Provider<UserRepository> provider3, Provider<ConfigurationRepository> provider4, Provider<TokenRepository> provider5, Provider<ApplicationService> provider6, Provider<GradesService> provider7) {
        return new InteractorModule_MainTabletInteractorFactory(interactorModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
