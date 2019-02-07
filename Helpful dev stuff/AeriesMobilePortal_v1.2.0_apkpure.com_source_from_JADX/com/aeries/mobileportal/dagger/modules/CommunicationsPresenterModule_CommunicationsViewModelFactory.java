package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.communications.CommunicationsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class CommunicationsPresenterModule_CommunicationsViewModelFactory implements Factory<CommunicationsViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final CommunicationsPresenterModule module;

    public CommunicationsPresenterModule_CommunicationsViewModelFactory(CommunicationsPresenterModule communicationsPresenterModule) {
        this.module = communicationsPresenterModule;
    }

    public CommunicationsViewModel get() {
        return (CommunicationsViewModel) Preconditions.checkNotNull(this.module.communicationsViewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<CommunicationsViewModel> create(CommunicationsPresenterModule communicationsPresenterModule) {
        return new CommunicationsPresenterModule_CommunicationsViewModelFactory(communicationsPresenterModule);
    }
}
