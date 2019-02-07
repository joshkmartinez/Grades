package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SharedPreferencesModule_TokenPreferencesFactory implements Factory<SharedPreferences> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<Context> contextProvider;
    private final SharedPreferencesModule module;

    public SharedPreferencesModule_TokenPreferencesFactory(SharedPreferencesModule sharedPreferencesModule, Provider<Context> provider) {
        this.module = sharedPreferencesModule;
        this.contextProvider = provider;
    }

    public SharedPreferences get() {
        return (SharedPreferences) Preconditions.checkNotNull(this.module.tokenPreferences((Context) this.contextProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SharedPreferences> create(SharedPreferencesModule sharedPreferencesModule, Provider<Context> provider) {
        return new SharedPreferencesModule_TokenPreferencesFactory(sharedPreferencesModule, provider);
    }
}
