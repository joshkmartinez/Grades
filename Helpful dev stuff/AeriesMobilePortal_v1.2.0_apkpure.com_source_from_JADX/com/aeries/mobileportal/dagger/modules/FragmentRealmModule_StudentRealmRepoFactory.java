package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.repos.realm.StudentRealmRepo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class FragmentRealmModule_StudentRealmRepoFactory implements Factory<StudentRealmRepo> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final FragmentRealmModule module;

    public FragmentRealmModule_StudentRealmRepoFactory(FragmentRealmModule fragmentRealmModule) {
        this.module = fragmentRealmModule;
    }

    public StudentRealmRepo get() {
        return (StudentRealmRepo) Preconditions.checkNotNull(this.module.studentRealmRepo(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<StudentRealmRepo> create(FragmentRealmModule fragmentRealmModule) {
        return new FragmentRealmModule_StudentRealmRepoFactory(fragmentRealmModule);
    }
}
