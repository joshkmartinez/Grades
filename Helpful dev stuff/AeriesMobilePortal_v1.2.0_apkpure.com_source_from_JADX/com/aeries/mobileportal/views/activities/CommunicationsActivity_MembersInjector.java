package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.communications.CommunicationsPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class CommunicationsActivity_MembersInjector implements MembersInjector<CommunicationsActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<CommunicationsPresenter> presenterProvider;

    public CommunicationsActivity_MembersInjector(Provider<CommunicationsPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<CommunicationsActivity> create(Provider<CommunicationsPresenter> provider) {
        return new CommunicationsActivity_MembersInjector(provider);
    }

    public void injectMembers(CommunicationsActivity communicationsActivity) {
        if (communicationsActivity != null) {
            communicationsActivity.presenter = (CommunicationsPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
