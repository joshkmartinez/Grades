package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.forgot_password.ForgotPasswordInteractor;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.PasswordService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_ForgotPasswordInteractorFactory implements Factory<ForgotPasswordInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AnalyticsService> analyticsServiceProvider;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final InteractorModule module;
    private final Provider<PasswordService> passwordServiceProvider;
    private final Provider<SchoolRepo> schoolRepoProvider;

    public InteractorModule_ForgotPasswordInteractorFactory(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<PasswordService> provider2, Provider<SchoolRepo> provider3, Provider<ConfigurationRepository> provider4) {
        this.module = interactorModule;
        this.analyticsServiceProvider = provider;
        this.passwordServiceProvider = provider2;
        this.schoolRepoProvider = provider3;
        this.configurationRepositoryProvider = provider4;
    }

    public ForgotPasswordInteractor get() {
        return (ForgotPasswordInteractor) Preconditions.checkNotNull(this.module.forgotPasswordInteractor((AnalyticsService) this.analyticsServiceProvider.get(), (PasswordService) this.passwordServiceProvider.get(), (SchoolRepo) this.schoolRepoProvider.get(), (ConfigurationRepository) this.configurationRepositoryProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ForgotPasswordInteractor> create(InteractorModule interactorModule, Provider<AnalyticsService> provider, Provider<PasswordService> provider2, Provider<SchoolRepo> provider3, Provider<ConfigurationRepository> provider4) {
        return new InteractorModule_ForgotPasswordInteractorFactory(interactorModule, provider, provider2, provider3, provider4);
    }
}
