package com.aeries.mobileportal.dagger.modules;

import android.content.SharedPreferences;
import com.aeries.mobileportal.repos.sharedpreferences.RestrictionRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SharedPreferencesModule_RestrictionRepositoryFactory implements Factory<RestrictionRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SharedPreferencesModule module;
    private final Provider<SharedPreferences> restrictionPreferencesProvider;

    public SharedPreferencesModule_RestrictionRepositoryFactory(SharedPreferencesModule sharedPreferencesModule, Provider<SharedPreferences> provider) {
        this.module = sharedPreferencesModule;
        this.restrictionPreferencesProvider = provider;
    }

    public RestrictionRepository get() {
        return (RestrictionRepository) Preconditions.checkNotNull(this.module.restrictionRepository((SharedPreferences) this.restrictionPreferencesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<RestrictionRepository> create(SharedPreferencesModule sharedPreferencesModule, Provider<SharedPreferences> provider) {
        return new SharedPreferencesModule_RestrictionRepositoryFactory(sharedPreferencesModule, provider);
    }
}
