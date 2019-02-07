package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.auth_error.AuthErrorPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AuthErrorActivity_MembersInjector implements MembersInjector<AuthErrorActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AuthErrorPresenter> presenterProvider;

    public AuthErrorActivity_MembersInjector(Provider<AuthErrorPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<AuthErrorActivity> create(Provider<AuthErrorPresenter> provider) {
        return new AuthErrorActivity_MembersInjector(provider);
    }

    public void injectMembers(AuthErrorActivity authErrorActivity) {
        if (authErrorActivity != null) {
            authErrorActivity.presenter = (AuthErrorPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
