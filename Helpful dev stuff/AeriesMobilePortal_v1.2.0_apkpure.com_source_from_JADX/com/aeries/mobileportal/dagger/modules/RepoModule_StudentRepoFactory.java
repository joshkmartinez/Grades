package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.repos.adapters.StudentRepo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class RepoModule_StudentRepoFactory implements Factory<StudentRepo> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final RepoModule module;

    public RepoModule_StudentRepoFactory(RepoModule repoModule) {
        this.module = repoModule;
    }

    public StudentRepo get() {
        return (StudentRepo) Preconditions.checkNotNull(this.module.studentRepo(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<StudentRepo> create(RepoModule repoModule) {
        return new RepoModule_StudentRepoFactory(repoModule);
    }
}
