package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.login.LoginPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AuthenticationActivity_MembersInjector implements MembersInjector<AuthenticationActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<LoginPresenter> presenterProvider;

    public AuthenticationActivity_MembersInjector(Provider<LoginPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<AuthenticationActivity> create(Provider<LoginPresenter> provider) {
        return new AuthenticationActivity_MembersInjector(provider);
    }

    public void injectMembers(AuthenticationActivity authenticationActivity) {
        if (authenticationActivity != null) {
            authenticationActivity.presenter = (LoginPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
