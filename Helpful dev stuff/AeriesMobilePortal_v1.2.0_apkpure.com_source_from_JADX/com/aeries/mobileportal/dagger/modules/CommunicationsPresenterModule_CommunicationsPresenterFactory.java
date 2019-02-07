package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.communications.CommunicationsInteractor;
import com.aeries.mobileportal.presenters.communications.CommunicationsPresenter;
import com.aeries.mobileportal.views.viewmodels.communications.CommunicationsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CommunicationsPresenterModule_CommunicationsPresenterFactory implements Factory<CommunicationsPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<CommunicationsInteractor> interactorProvider;
    private final CommunicationsPresenterModule module;
    private final Provider<CommunicationsViewModel> viewModelProvider;

    public CommunicationsPresenterModule_CommunicationsPresenterFactory(CommunicationsPresenterModule communicationsPresenterModule, Provider<CommunicationsViewModel> provider, Provider<CommunicationsInteractor> provider2) {
        this.module = communicationsPresenterModule;
        this.viewModelProvider = provider;
        this.interactorProvider = provider2;
    }

    public CommunicationsPresenter get() {
        return (CommunicationsPresenter) Preconditions.checkNotNull(this.module.communicationsPresenter((CommunicationsViewModel) this.viewModelProvider.get(), (CommunicationsInteractor) this.interactorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<CommunicationsPresenter> create(CommunicationsPresenterModule communicationsPresenterModule, Provider<CommunicationsViewModel> provider, Provider<CommunicationsInteractor> provider2) {
        return new CommunicationsPresenterModule_CommunicationsPresenterFactory(communicationsPresenterModule, provider, provider2);
    }
}
