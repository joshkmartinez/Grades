package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.settings.SettingsInteractor;
import com.aeries.mobileportal.repos.adapters.NotificationsRepo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_SettingsInteractorFactory implements Factory<SettingsInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final InteractorModule module;
    private final Provider<NotificationsRepo> notificationsRepoProvider;

    public InteractorModule_SettingsInteractorFactory(InteractorModule interactorModule, Provider<NotificationsRepo> provider) {
        this.module = interactorModule;
        this.notificationsRepoProvider = provider;
    }

    public SettingsInteractor get() {
        return (SettingsInteractor) Preconditions.checkNotNull(this.module.settingsInteractor((NotificationsRepo) this.notificationsRepoProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SettingsInteractor> create(InteractorModule interactorModule, Provider<NotificationsRepo> provider) {
        return new InteractorModule_SettingsInteractorFactory(interactorModule, provider);
    }
}
