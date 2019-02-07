package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.NotificationsAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class NotificationsFragmentModule_NotificationsAdapterFactory implements Factory<NotificationsAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NotificationsFragmentModule module;

    public NotificationsFragmentModule_NotificationsAdapterFactory(NotificationsFragmentModule notificationsFragmentModule) {
        this.module = notificationsFragmentModule;
    }

    public NotificationsAdapter get() {
        return (NotificationsAdapter) Preconditions.checkNotNull(this.module.notificationsAdapter(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<NotificationsAdapter> create(NotificationsFragmentModule notificationsFragmentModule) {
        return new NotificationsFragmentModule_NotificationsAdapterFactory(notificationsFragmentModule);
    }
}
