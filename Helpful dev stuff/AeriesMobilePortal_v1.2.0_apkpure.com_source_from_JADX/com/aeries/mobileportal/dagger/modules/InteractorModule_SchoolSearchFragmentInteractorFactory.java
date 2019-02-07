package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.SchoolSearchFragmentInteractor;
import com.aeries.mobileportal.web_services.services.SchoolSearchService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_SchoolSearchFragmentInteractorFactory implements Factory<SchoolSearchFragmentInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final InteractorModule module;
    private final Provider<SchoolSearchService> schoolSearchServiceProvider;

    public InteractorModule_SchoolSearchFragmentInteractorFactory(InteractorModule interactorModule, Provider<SchoolSearchService> provider) {
        this.module = interactorModule;
        this.schoolSearchServiceProvider = provider;
    }

    public SchoolSearchFragmentInteractor get() {
        return (SchoolSearchFragmentInteractor) Preconditions.checkNotNull(this.module.schoolSearchFragmentInteractor((SchoolSearchService) this.schoolSearchServiceProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SchoolSearchFragmentInteractor> create(InteractorModule interactorModule, Provider<SchoolSearchService> provider) {
        return new InteractorModule_SchoolSearchFragmentInteractorFactory(interactorModule, provider);
    }
}
