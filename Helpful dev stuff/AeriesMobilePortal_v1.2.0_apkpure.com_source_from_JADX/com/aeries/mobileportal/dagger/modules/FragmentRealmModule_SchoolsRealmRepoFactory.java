package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.repos.realm.SchoolRealmRepo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class FragmentRealmModule_SchoolsRealmRepoFactory implements Factory<SchoolRealmRepo> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final FragmentRealmModule module;

    public FragmentRealmModule_SchoolsRealmRepoFactory(FragmentRealmModule fragmentRealmModule) {
        this.module = fragmentRealmModule;
    }

    public SchoolRealmRepo get() {
        return (SchoolRealmRepo) Preconditions.checkNotNull(this.module.schoolsRealmRepo(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SchoolRealmRepo> create(FragmentRealmModule fragmentRealmModule) {
        return new FragmentRealmModule_SchoolsRealmRepoFactory(fragmentRealmModule);
    }
}
