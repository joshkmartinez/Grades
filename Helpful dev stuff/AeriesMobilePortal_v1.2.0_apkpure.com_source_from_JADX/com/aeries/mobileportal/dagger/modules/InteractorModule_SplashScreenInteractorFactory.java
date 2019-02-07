package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.splashscreen.SplashScreenInteractor;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_SplashScreenInteractorFactory implements Factory<SplashScreenInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AnalyticsService> analyticsServiceProvider;
    private final InteractorModule module;

    public InteractorModule_SplashScreenInteractorFactory(InteractorModule interactorModule, Provider<AnalyticsService> provider) {
        this.module = interactorModule;
        this.analyticsServiceProvider = provider;
    }

    public SplashScreenInteractor get() {
        return (SplashScreenInteractor) Preconditions.checkNotNull(this.module.splashScreenInteractor((AnalyticsService) this.analyticsServiceProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SplashScreenInteractor> create(InteractorModule interactorModule, Provider<AnalyticsService> provider) {
        return new InteractorModule_SplashScreenInteractorFactory(interactorModule, provider);
    }
}
