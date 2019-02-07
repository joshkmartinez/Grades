package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.SchoolListAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SchoolSearchFragmentModule_SchoolListAdapterFactory implements Factory<SchoolListAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SchoolSearchFragmentModule module;

    public SchoolSearchFragmentModule_SchoolListAdapterFactory(SchoolSearchFragmentModule schoolSearchFragmentModule) {
        this.module = schoolSearchFragmentModule;
    }

    public SchoolListAdapter get() {
        return (SchoolListAdapter) Preconditions.checkNotNull(this.module.schoolListAdapter(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SchoolListAdapter> create(SchoolSearchFragmentModule schoolSearchFragmentModule) {
        return new SchoolSearchFragmentModule_SchoolListAdapterFactory(schoolSearchFragmentModule);
    }
}
