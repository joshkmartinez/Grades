package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.login.LoginPresenter;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class LoginActivity_MembersInjector implements MembersInjector<LoginActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<GoogleSignInClient> googleSignInClientProvider;
    private final Provider<LoginPresenter> loginPresenterProvider;

    public LoginActivity_MembersInjector(Provider<LoginPresenter> provider, Provider<GoogleSignInClient> provider2) {
        this.loginPresenterProvider = provider;
        this.googleSignInClientProvider = provider2;
    }

    public static MembersInjector<LoginActivity> create(Provider<LoginPresenter> provider, Provider<GoogleSignInClient> provider2) {
        return new LoginActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(LoginActivity loginActivity) {
        if (loginActivity != null) {
            loginActivity.loginPresenter = (LoginPresenter) this.loginPresenterProvider.get();
            loginActivity.googleSignInClient = (GoogleSignInClient) this.googleSignInClientProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
