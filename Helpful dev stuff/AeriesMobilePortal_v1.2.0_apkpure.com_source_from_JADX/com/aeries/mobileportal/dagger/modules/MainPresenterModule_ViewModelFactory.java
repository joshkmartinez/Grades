package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.main.MainViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class MainPresenterModule_ViewModelFactory implements Factory<MainViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final MainPresenterModule module;

    public MainPresenterModule_ViewModelFactory(MainPresenterModule mainPresenterModule) {
        this.module = mainPresenterModule;
    }

    public MainViewModel get() {
        return (MainViewModel) Preconditions.checkNotNull(this.module.viewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<MainViewModel> create(MainPresenterModule mainPresenterModule) {
        return new MainPresenterModule_ViewModelFactory(mainPresenterModule);
    }
}
