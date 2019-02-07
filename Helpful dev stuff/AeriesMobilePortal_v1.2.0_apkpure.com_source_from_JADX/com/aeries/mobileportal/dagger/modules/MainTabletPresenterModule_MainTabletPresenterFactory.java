package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.tablet.MainTabletInteractor;
import com.aeries.mobileportal.presenters.tablet.MainTabletPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class MainTabletPresenterModule_MainTabletPresenterFactory implements Factory<MainTabletPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<MainTabletInteractor> mainTabletInteractorProvider;
    private final MainTabletPresenterModule module;

    public MainTabletPresenterModule_MainTabletPresenterFactory(MainTabletPresenterModule mainTabletPresenterModule, Provider<MainTabletInteractor> provider) {
        this.module = mainTabletPresenterModule;
        this.mainTabletInteractorProvider = provider;
    }

    public MainTabletPresenter get() {
        return (MainTabletPresenter) Preconditions.checkNotNull(this.module.mainTabletPresenter((MainTabletInteractor) this.mainTabletInteractorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<MainTabletPresenter> create(MainTabletPresenterModule mainTabletPresenterModule, Provider<MainTabletInteractor> provider) {
        return new MainTabletPresenterModule_MainTabletPresenterFactory(mainTabletPresenterModule, provider);
    }
}
