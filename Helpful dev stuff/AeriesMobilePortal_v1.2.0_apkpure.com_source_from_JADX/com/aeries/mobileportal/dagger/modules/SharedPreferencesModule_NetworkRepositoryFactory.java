package com.aeries.mobileportal.dagger.modules;

import android.content.SharedPreferences;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SharedPreferencesModule_NetworkRepositoryFactory implements Factory<NetworkRepo> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SharedPreferencesModule module;
    private final Provider<SharedPreferences> userPreferencesProvider;

    public SharedPreferencesModule_NetworkRepositoryFactory(SharedPreferencesModule sharedPreferencesModule, Provider<SharedPreferences> provider) {
        this.module = sharedPreferencesModule;
        this.userPreferencesProvider = provider;
    }

    public NetworkRepo get() {
        return (NetworkRepo) Preconditions.checkNotNull(this.module.networkRepository((SharedPreferences) this.userPreferencesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<NetworkRepo> create(SharedPreferencesModule sharedPreferencesModule, Provider<SharedPreferences> provider) {
        return new SharedPreferencesModule_NetworkRepositoryFactory(sharedPreferencesModule, provider);
    }
}
