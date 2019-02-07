package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.school_select.SchoolSearchViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SchoolSearchPresenterModule_SchoolSearchViewModelFactory implements Factory<SchoolSearchViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SchoolSearchPresenterModule module;

    public SchoolSearchPresenterModule_SchoolSearchViewModelFactory(SchoolSearchPresenterModule schoolSearchPresenterModule) {
        this.module = schoolSearchPresenterModule;
    }

    public SchoolSearchViewModel get() {
        return (SchoolSearchViewModel) Preconditions.checkNotNull(this.module.schoolSearchViewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SchoolSearchViewModel> create(SchoolSearchPresenterModule schoolSearchPresenterModule) {
        return new SchoolSearchPresenterModule_SchoolSearchViewModelFactory(schoolSearchPresenterModule);
    }
}
