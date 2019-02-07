package com.aeries.mobileportal.dagger.modules;

import android.accounts.AccountManager;
import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AuthModule_AccManagerFactory implements Factory<AccountManager> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<Context> contextProvider;
    private final AuthModule module;

    public AuthModule_AccManagerFactory(AuthModule authModule, Provider<Context> provider) {
        this.module = authModule;
        this.contextProvider = provider;
    }

    public AccountManager get() {
        return (AccountManager) Preconditions.checkNotNull(this.module.accManager((Context) this.contextProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AccountManager> create(AuthModule authModule, Provider<Context> provider) {
        return new AuthModule_AccManagerFactory(authModule, provider);
    }
}
