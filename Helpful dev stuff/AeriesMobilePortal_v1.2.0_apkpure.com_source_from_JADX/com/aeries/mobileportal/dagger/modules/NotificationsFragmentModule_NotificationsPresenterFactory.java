package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.notifications.NotificationsInteractor;
import com.aeries.mobileportal.presenters.NotificationsPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NotificationsFragmentModule_NotificationsPresenterFactory implements Factory<NotificationsPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<NotificationsInteractor> interactorProvider;
    private final NotificationsFragmentModule module;

    public NotificationsFragmentModule_NotificationsPresenterFactory(NotificationsFragmentModule notificationsFragmentModule, Provider<NotificationsInteractor> provider) {
        this.module = notificationsFragmentModule;
        this.interactorProvider = provider;
    }

    public NotificationsPresenter get() {
        return (NotificationsPresenter) Preconditions.checkNotNull(this.module.notificationsPresenter((NotificationsInteractor) this.interactorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<NotificationsPresenter> create(NotificationsFragmentModule notificationsFragmentModule, Provider<NotificationsInteractor> provider) {
        return new NotificationsFragmentModule_NotificationsPresenterFactory(notificationsFragmentModule, provider);
    }
}
