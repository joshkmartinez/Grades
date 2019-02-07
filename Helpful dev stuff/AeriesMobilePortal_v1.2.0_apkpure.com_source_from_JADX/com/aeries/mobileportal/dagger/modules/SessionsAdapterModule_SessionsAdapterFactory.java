package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.SessionsAdapter;
import com.aeries.mobileportal.adapters.SessionsAdapter.SessionsAdapterListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SessionsAdapterModule_SessionsAdapterFactory implements Factory<SessionsAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SessionsAdapterModule module;
    private final Provider<SessionsAdapterListener> sessionsAdapterListenerProvider;

    public SessionsAdapterModule_SessionsAdapterFactory(SessionsAdapterModule sessionsAdapterModule, Provider<SessionsAdapterListener> provider) {
        this.module = sessionsAdapterModule;
        this.sessionsAdapterListenerProvider = provider;
    }

    public SessionsAdapter get() {
        return (SessionsAdapter) Preconditions.checkNotNull(this.module.sessionsAdapter((SessionsAdapterListener) this.sessionsAdapterListenerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SessionsAdapter> create(SessionsAdapterModule sessionsAdapterModule, Provider<SessionsAdapterListener> provider) {
        return new SessionsAdapterModule_SessionsAdapterFactory(sessionsAdapterModule, provider);
    }
}
