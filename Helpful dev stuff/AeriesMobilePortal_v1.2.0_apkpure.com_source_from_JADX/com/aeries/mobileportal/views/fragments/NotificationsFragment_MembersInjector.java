package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.NotificationsAdapter;
import com.aeries.mobileportal.presenters.NotificationsPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class NotificationsFragment_MembersInjector implements MembersInjector<NotificationsFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<NotificationsAdapter> adapterProvider;
    private final Provider<NotificationsPresenter> presenterProvider;

    public NotificationsFragment_MembersInjector(Provider<NotificationsAdapter> provider, Provider<NotificationsPresenter> provider2) {
        this.adapterProvider = provider;
        this.presenterProvider = provider2;
    }

    public static MembersInjector<NotificationsFragment> create(Provider<NotificationsAdapter> provider, Provider<NotificationsPresenter> provider2) {
        return new NotificationsFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(NotificationsFragment notificationsFragment) {
        if (notificationsFragment != null) {
            notificationsFragment.adapter = (NotificationsAdapter) this.adapterProvider.get();
            notificationsFragment.presenter = (NotificationsPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
