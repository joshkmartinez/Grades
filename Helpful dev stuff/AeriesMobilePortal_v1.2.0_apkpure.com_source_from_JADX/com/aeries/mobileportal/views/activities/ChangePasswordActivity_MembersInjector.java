package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.change_password.ChangePasswordPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ChangePasswordActivity_MembersInjector implements MembersInjector<ChangePasswordActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ChangePasswordPresenter> presenterProvider;

    public ChangePasswordActivity_MembersInjector(Provider<ChangePasswordPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<ChangePasswordActivity> create(Provider<ChangePasswordPresenter> provider) {
        return new ChangePasswordActivity_MembersInjector(provider);
    }

    public void injectMembers(ChangePasswordActivity changePasswordActivity) {
        if (changePasswordActivity != null) {
            changePasswordActivity.presenter = (ChangePasswordPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
