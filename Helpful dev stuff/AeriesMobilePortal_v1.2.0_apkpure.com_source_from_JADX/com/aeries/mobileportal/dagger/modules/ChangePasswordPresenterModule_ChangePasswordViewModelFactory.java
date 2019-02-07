package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.change_password.ChangePasswordViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ChangePasswordPresenterModule_ChangePasswordViewModelFactory implements Factory<ChangePasswordViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ChangePasswordPresenterModule module;

    public ChangePasswordPresenterModule_ChangePasswordViewModelFactory(ChangePasswordPresenterModule changePasswordPresenterModule) {
        this.module = changePasswordPresenterModule;
    }

    public ChangePasswordViewModel get() {
        return (ChangePasswordViewModel) Preconditions.checkNotNull(this.module.changePasswordViewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ChangePasswordViewModel> create(ChangePasswordPresenterModule changePasswordPresenterModule) {
        return new ChangePasswordPresenterModule_ChangePasswordViewModelFactory(changePasswordPresenterModule);
    }
}
