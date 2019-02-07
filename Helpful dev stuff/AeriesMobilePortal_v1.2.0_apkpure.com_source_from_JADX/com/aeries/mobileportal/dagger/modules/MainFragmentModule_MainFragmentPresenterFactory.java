package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.MainFragmentInteractor;
import com.aeries.mobileportal.presenters.MainFragmentPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class MainFragmentModule_MainFragmentPresenterFactory implements Factory<MainFragmentPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<MainFragmentInteractor> interactorProvider;
    private final MainFragmentModule module;

    public MainFragmentModule_MainFragmentPresenterFactory(MainFragmentModule mainFragmentModule, Provider<MainFragmentInteractor> provider) {
        this.module = mainFragmentModule;
        this.interactorProvider = provider;
    }

    public MainFragmentPresenter get() {
        return (MainFragmentPresenter) Preconditions.checkNotNull(this.module.mainFragmentPresenter((MainFragmentInteractor) this.interactorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<MainFragmentPresenter> create(MainFragmentModule mainFragmentModule, Provider<MainFragmentInteractor> provider) {
        return new MainFragmentModule_MainFragmentPresenterFactory(mainFragmentModule, provider);
    }
}
