package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.SchoolSearchFragmentInteractor;
import com.aeries.mobileportal.presenters.SchoolSearchFragmentPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SchoolSearchFragmentModule_SchoolSearchFragmentPresenterFactory implements Factory<SchoolSearchFragmentPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<SchoolSearchFragmentInteractor> interactorProvider;
    private final SchoolSearchFragmentModule module;

    public SchoolSearchFragmentModule_SchoolSearchFragmentPresenterFactory(SchoolSearchFragmentModule schoolSearchFragmentModule, Provider<SchoolSearchFragmentInteractor> provider) {
        this.module = schoolSearchFragmentModule;
        this.interactorProvider = provider;
    }

    public SchoolSearchFragmentPresenter get() {
        return (SchoolSearchFragmentPresenter) Preconditions.checkNotNull(this.module.schoolSearchFragmentPresenter((SchoolSearchFragmentInteractor) this.interactorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SchoolSearchFragmentPresenter> create(SchoolSearchFragmentModule schoolSearchFragmentModule, Provider<SchoolSearchFragmentInteractor> provider) {
        return new SchoolSearchFragmentModule_SchoolSearchFragmentPresenterFactory(schoolSearchFragmentModule, provider);
    }
}
