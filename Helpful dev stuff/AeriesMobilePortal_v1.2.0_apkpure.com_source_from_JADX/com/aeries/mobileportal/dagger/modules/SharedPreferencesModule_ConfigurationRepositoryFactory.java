package com.aeries.mobileportal.dagger.modules;

import android.content.SharedPreferences;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SharedPreferencesModule_ConfigurationRepositoryFactory implements Factory<ConfigurationRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SharedPreferencesModule module;
    private final Provider<SharedPreferences> userPreferencesProvider;

    public SharedPreferencesModule_ConfigurationRepositoryFactory(SharedPreferencesModule sharedPreferencesModule, Provider<SharedPreferences> provider) {
        this.module = sharedPreferencesModule;
        this.userPreferencesProvider = provider;
    }

    public ConfigurationRepository get() {
        return (ConfigurationRepository) Preconditions.checkNotNull(this.module.configurationRepository((SharedPreferences) this.userPreferencesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ConfigurationRepository> create(SharedPreferencesModule sharedPreferencesModule, Provider<SharedPreferences> provider) {
        return new SharedPreferencesModule_ConfigurationRepositoryFactory(sharedPreferencesModule, provider);
    }
}
