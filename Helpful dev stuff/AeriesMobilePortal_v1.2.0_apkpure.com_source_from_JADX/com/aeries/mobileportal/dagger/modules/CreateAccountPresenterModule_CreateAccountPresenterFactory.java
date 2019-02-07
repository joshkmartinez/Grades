package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.create_account.CreateAccountInteractor;
import com.aeries.mobileportal.presenters.create_account.CreateAccountPresenter;
import com.aeries.mobileportal.views.viewmodels.create_account.CreateAccountViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CreateAccountPresenterModule_CreateAccountPresenterFactory implements Factory<CreateAccountPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<CreateAccountInteractor> createAccountInteractorProvider;
    private final Provider<CreateAccountViewModel> createAccountViewModelProvider;
    private final CreateAccountPresenterModule module;

    public CreateAccountPresenterModule_CreateAccountPresenterFactory(CreateAccountPresenterModule createAccountPresenterModule, Provider<CreateAccountViewModel> provider, Provider<CreateAccountInteractor> provider2) {
        this.module = createAccountPresenterModule;
        this.createAccountViewModelProvider = provider;
        this.createAccountInteractorProvider = provider2;
    }

    public CreateAccountPresenter get() {
        return (CreateAccountPresenter) Preconditions.checkNotNull(this.module.createAccountPresenter((CreateAccountViewModel) this.createAccountViewModelProvider.get(), (CreateAccountInteractor) this.createAccountInteractorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<CreateAccountPresenter> create(CreateAccountPresenterModule createAccountPresenterModule, Provider<CreateAccountViewModel> provider, Provider<CreateAccountInteractor> provider2) {
        return new CreateAccountPresenterModule_CreateAccountPresenterFactory(createAccountPresenterModule, provider, provider2);
    }
}
