package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import com.aeries.mobileportal.interactors.notifications.NotificationsInteractor;
import com.aeries.mobileportal.repos.adapters.NotificationsRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.NotificationService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_NotificationsInteractorFactory implements Factory<NotificationsInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ApplicationService> applicationServiceProvider;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final Provider<Context> contextProvider;
    private final InteractorModule module;
    private final Provider<NotificationService> notificationServiceProvider;
    private final Provider<NotificationsRepo> notificationsRepoProvider;
    private final Provider<SchoolRepo> schoolRepoProvider;
    private final Provider<TokenProvider> tokenProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public InteractorModule_NotificationsInteractorFactory(InteractorModule interactorModule, Provider<ConfigurationRepository> provider, Provider<UserRepository> provider2, Provider<SchoolRepo> provider3, Provider<NotificationService> provider4, Provider<NotificationsRepo> provider5, Provider<ApplicationService> provider6, Provider<TokenProvider> provider7, Provider<Context> provider8) {
        this.module = interactorModule;
        this.configurationRepositoryProvider = provider;
        this.userRepositoryProvider = provider2;
        this.schoolRepoProvider = provider3;
        this.notificationServiceProvider = provider4;
        this.notificationsRepoProvider = provider5;
        this.applicationServiceProvider = provider6;
        this.tokenProvider = provider7;
        this.contextProvider = provider8;
    }

    public NotificationsInteractor get() {
        return (NotificationsInteractor) Preconditions.checkNotNull(this.module.notificationsInteractor((ConfigurationRepository) this.configurationRepositoryProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (SchoolRepo) this.schoolRepoProvider.get(), (NotificationService) this.notificationServiceProvider.get(), (NotificationsRepo) this.notificationsRepoProvider.get(), (ApplicationService) this.applicationServiceProvider.get(), (TokenProvider) this.tokenProvider.get(), (Context) this.contextProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<NotificationsInteractor> create(InteractorModule interactorModule, Provider<ConfigurationRepository> provider, Provider<UserRepository> provider2, Provider<SchoolRepo> provider3, Provider<NotificationService> provider4, Provider<NotificationsRepo> provider5, Provider<ApplicationService> provider6, Provider<TokenProvider> provider7, Provider<Context> provider8) {
        return new InteractorModule_NotificationsInteractorFactory(interactorModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }
}
