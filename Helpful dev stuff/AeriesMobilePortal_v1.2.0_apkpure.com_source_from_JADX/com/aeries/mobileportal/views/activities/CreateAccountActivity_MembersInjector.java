package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.create_account.CreateAccountPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class CreateAccountActivity_MembersInjector implements MembersInjector<CreateAccountActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<CreateAccountPresenter> presenterProvider;

    public CreateAccountActivity_MembersInjector(Provider<CreateAccountPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<CreateAccountActivity> create(Provider<CreateAccountPresenter> provider) {
        return new CreateAccountActivity_MembersInjector(provider);
    }

    public void injectMembers(CreateAccountActivity createAccountActivity) {
        if (createAccountActivity != null) {
            createAccountActivity.presenter = (CreateAccountPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
