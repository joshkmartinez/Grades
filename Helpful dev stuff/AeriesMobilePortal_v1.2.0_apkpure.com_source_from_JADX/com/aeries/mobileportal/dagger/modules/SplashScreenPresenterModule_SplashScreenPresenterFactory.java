package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.splashscreen.SplashScreenInteractor;
import com.aeries.mobileportal.presenters.splashscreen.SplashScreenPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SplashScreenPresenterModule_SplashScreenPresenterFactory implements Factory<SplashScreenPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SplashScreenPresenterModule module;
    private final Provider<SplashScreenInteractor> splashScreenInteractorProvider;

    public SplashScreenPresenterModule_SplashScreenPresenterFactory(SplashScreenPresenterModule splashScreenPresenterModule, Provider<SplashScreenInteractor> provider) {
        this.module = splashScreenPresenterModule;
        this.splashScreenInteractorProvider = provider;
    }

    public SplashScreenPresenter get() {
        return (SplashScreenPresenter) Preconditions.checkNotNull(this.module.splashScreenPresenter((SplashScreenInteractor) this.splashScreenInteractorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SplashScreenPresenter> create(SplashScreenPresenterModule splashScreenPresenterModule, Provider<SplashScreenInteractor> provider) {
        return new SplashScreenPresenterModule_SplashScreenPresenterFactory(splashScreenPresenterModule, provider);
    }
}
