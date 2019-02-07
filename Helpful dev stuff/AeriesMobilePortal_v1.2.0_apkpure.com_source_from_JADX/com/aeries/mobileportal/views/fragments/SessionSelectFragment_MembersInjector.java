package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.SessionsAdapter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SessionSelectFragment_MembersInjector implements MembersInjector<SessionSelectFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<SessionsAdapter> adapterProvider;

    public SessionSelectFragment_MembersInjector(Provider<SessionsAdapter> provider) {
        this.adapterProvider = provider;
    }

    public static MembersInjector<SessionSelectFragment> create(Provider<SessionsAdapter> provider) {
        return new SessionSelectFragment_MembersInjector(provider);
    }

    public void injectMembers(SessionSelectFragment sessionSelectFragment) {
        if (sessionSelectFragment != null) {
            sessionSelectFragment.adapter = (SessionsAdapter) this.adapterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
