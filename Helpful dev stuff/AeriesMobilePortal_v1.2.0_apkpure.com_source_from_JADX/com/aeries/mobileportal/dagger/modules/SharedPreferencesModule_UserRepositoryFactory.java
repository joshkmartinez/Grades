package com.aeries.mobileportal.dagger.modules;

import android.content.SharedPreferences;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SharedPreferencesModule_UserRepositoryFactory implements Factory<UserRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SharedPreferencesModule module;
    private final Provider<SharedPreferences> userPreferencesProvider;

    public SharedPreferencesModule_UserRepositoryFactory(SharedPreferencesModule sharedPreferencesModule, Provider<SharedPreferences> provider) {
        this.module = sharedPreferencesModule;
        this.userPreferencesProvider = provider;
    }

    public UserRepository get() {
        return (UserRepository) Preconditions.checkNotNull(this.module.userRepository((SharedPreferences) this.userPreferencesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<UserRepository> create(SharedPreferencesModule sharedPreferencesModule, Provider<SharedPreferences> provider) {
        return new SharedPreferencesModule_UserRepositoryFactory(sharedPreferencesModule, provider);
    }
}
