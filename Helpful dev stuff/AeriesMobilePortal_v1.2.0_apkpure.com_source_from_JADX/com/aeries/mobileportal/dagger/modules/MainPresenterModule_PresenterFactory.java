package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.main.MainInteractor;
import com.aeries.mobileportal.presenters.MainPresenter;
import com.aeries.mobileportal.views.viewmodels.main.MainViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class MainPresenterModule_PresenterFactory implements Factory<MainPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<MainInteractor> interactorProvider;
    private final MainPresenterModule module;
    private final Provider<MainViewModel> viewModelProvider;

    public MainPresenterModule_PresenterFactory(MainPresenterModule mainPresenterModule, Provider<MainViewModel> provider, Provider<MainInteractor> provider2) {
        this.module = mainPresenterModule;
        this.viewModelProvider = provider;
        this.interactorProvider = provider2;
    }

    public MainPresenter get() {
        return (MainPresenter) Preconditions.checkNotNull(this.module.presenter((MainViewModel) this.viewModelProvider.get(), (MainInteractor) this.interactorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<MainPresenter> create(MainPresenterModule mainPresenterModule, Provider<MainViewModel> provider, Provider<MainInteractor> provider2) {
        return new MainPresenterModule_PresenterFactory(mainPresenterModule, provider, provider2);
    }
}
