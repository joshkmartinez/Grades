package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.forgot_password.ForgotPasswordPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ForgotPasswordActivity_MembersInjector implements MembersInjector<ForgotPasswordActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ForgotPasswordPresenter> presenterProvider;

    public ForgotPasswordActivity_MembersInjector(Provider<ForgotPasswordPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<ForgotPasswordActivity> create(Provider<ForgotPasswordPresenter> provider) {
        return new ForgotPasswordActivity_MembersInjector(provider);
    }

    public void injectMembers(ForgotPasswordActivity forgotPasswordActivity) {
        if (forgotPasswordActivity != null) {
            forgotPasswordActivity.presenter = (ForgotPasswordPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
