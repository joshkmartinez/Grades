package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.supplementan_attendance.SupplementalAttendanceInteractor;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.web_services.services.SupplementalAttendanceService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_SupplementalAttendanceInteractorFactory implements Factory<SupplementalAttendanceInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final InteractorModule module;
    private final Provider<SupplementalAttendanceService> supplementalAttendanceServiceProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    public InteractorModule_SupplementalAttendanceInteractorFactory(InteractorModule interactorModule, Provider<TokenRepository> provider, Provider<ConfigurationRepository> provider2, Provider<SupplementalAttendanceService> provider3) {
        this.module = interactorModule;
        this.tokenRepositoryProvider = provider;
        this.configurationRepositoryProvider = provider2;
        this.supplementalAttendanceServiceProvider = provider3;
    }

    public SupplementalAttendanceInteractor get() {
        return (SupplementalAttendanceInteractor) Preconditions.checkNotNull(this.module.supplementalAttendanceInteractor((TokenRepository) this.tokenRepositoryProvider.get(), (ConfigurationRepository) this.configurationRepositoryProvider.get(), (SupplementalAttendanceService) this.supplementalAttendanceServiceProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SupplementalAttendanceInteractor> create(InteractorModule interactorModule, Provider<TokenRepository> provider, Provider<ConfigurationRepository> provider2, Provider<SupplementalAttendanceService> provider3) {
        return new InteractorModule_SupplementalAttendanceInteractorFactory(interactorModule, provider, provider2, provider3);
    }
}
