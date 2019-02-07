package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class RepoModule_SchoolRepoFactory implements Factory<SchoolRepo> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final RepoModule module;

    public RepoModule_SchoolRepoFactory(RepoModule repoModule) {
        this.module = repoModule;
    }

    public SchoolRepo get() {
        return (SchoolRepo) Preconditions.checkNotNull(this.module.schoolRepo(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SchoolRepo> create(RepoModule repoModule) {
        return new RepoModule_SchoolRepoFactory(repoModule);
    }
}
