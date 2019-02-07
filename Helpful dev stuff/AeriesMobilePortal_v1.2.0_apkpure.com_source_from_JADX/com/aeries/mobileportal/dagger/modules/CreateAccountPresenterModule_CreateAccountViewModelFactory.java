package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.create_account.CreateAccountViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class CreateAccountPresenterModule_CreateAccountViewModelFactory implements Factory<CreateAccountViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final CreateAccountPresenterModule module;

    public CreateAccountPresenterModule_CreateAccountViewModelFactory(CreateAccountPresenterModule createAccountPresenterModule) {
        this.module = createAccountPresenterModule;
    }

    public CreateAccountViewModel get() {
        return (CreateAccountViewModel) Preconditions.checkNotNull(this.module.createAccountViewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<CreateAccountViewModel> create(CreateAccountPresenterModule createAccountPresenterModule) {
        return new CreateAccountPresenterModule_CreateAccountViewModelFactory(createAccountPresenterModule);
    }
}
