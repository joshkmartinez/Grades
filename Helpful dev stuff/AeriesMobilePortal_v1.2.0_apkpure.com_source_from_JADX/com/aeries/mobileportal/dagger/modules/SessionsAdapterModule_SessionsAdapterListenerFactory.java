package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.SessionsAdapter.SessionsAdapterListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SessionsAdapterModule_SessionsAdapterListenerFactory implements Factory<SessionsAdapterListener> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SessionsAdapterModule module;

    public SessionsAdapterModule_SessionsAdapterListenerFactory(SessionsAdapterModule sessionsAdapterModule) {
        this.module = sessionsAdapterModule;
    }

    public SessionsAdapterListener get() {
        return (SessionsAdapterListener) Preconditions.checkNotNull(this.module.sessionsAdapterListener(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SessionsAdapterListener> create(SessionsAdapterModule sessionsAdapterModule) {
        return new SessionsAdapterModule_SessionsAdapterListenerFactory(sessionsAdapterModule);
    }
}
