package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.grades.GradesViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class GradesPresenterModule_GradesViewModelFactory implements Factory<GradesViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final GradesPresenterModule module;

    public GradesPresenterModule_GradesViewModelFactory(GradesPresenterModule gradesPresenterModule) {
        this.module = gradesPresenterModule;
    }

    public GradesViewModel get() {
        return (GradesViewModel) Preconditions.checkNotNull(this.module.gradesViewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<GradesViewModel> create(GradesPresenterModule gradesPresenterModule) {
        return new GradesPresenterModule_GradesViewModelFactory(gradesPresenterModule);
    }
}
