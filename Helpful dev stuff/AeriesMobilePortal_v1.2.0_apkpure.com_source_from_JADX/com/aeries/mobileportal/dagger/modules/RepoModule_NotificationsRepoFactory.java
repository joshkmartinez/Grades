package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.repos.adapters.NotificationsRepo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class RepoModule_NotificationsRepoFactory implements Factory<NotificationsRepo> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final RepoModule module;

    public RepoModule_NotificationsRepoFactory(RepoModule repoModule) {
        this.module = repoModule;
    }

    public NotificationsRepo get() {
        return (NotificationsRepo) Preconditions.checkNotNull(this.module.notificationsRepo(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<NotificationsRepo> create(RepoModule repoModule) {
        return new RepoModule_NotificationsRepoFactory(repoModule);
    }
}
