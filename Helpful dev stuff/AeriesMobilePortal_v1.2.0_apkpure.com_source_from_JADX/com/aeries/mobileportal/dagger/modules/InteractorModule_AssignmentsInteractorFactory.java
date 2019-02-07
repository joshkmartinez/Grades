package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.grades.AssignmentsInteractor;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.GradesService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_AssignmentsInteractorFactory implements Factory<AssignmentsInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<GradesService> gradesServiceProvider;
    private final InteractorModule module;
    private final Provider<TokenProvider> tokenProvider;

    public InteractorModule_AssignmentsInteractorFactory(InteractorModule interactorModule, Provider<GradesService> provider, Provider<TokenProvider> provider2) {
        this.module = interactorModule;
        this.gradesServiceProvider = provider;
        this.tokenProvider = provider2;
    }

    public AssignmentsInteractor get() {
        return (AssignmentsInteractor) Preconditions.checkNotNull(this.module.assignmentsInteractor((GradesService) this.gradesServiceProvider.get(), (TokenProvider) this.tokenProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AssignmentsInteractor> create(InteractorModule interactorModule, Provider<GradesService> provider, Provider<TokenProvider> provider2) {
        return new InteractorModule_AssignmentsInteractorFactory(interactorModule, provider, provider2);
    }
}
