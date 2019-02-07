package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.grades.AssignmentsInteractor;
import com.aeries.mobileportal.presenters.AssignmentsPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AssignmentsPresenterModule_AssignmentPresenterFactory implements Factory<AssignmentsPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AssignmentsInteractor> assignmentsInteractorProvider;
    private final AssignmentsPresenterModule module;

    public AssignmentsPresenterModule_AssignmentPresenterFactory(AssignmentsPresenterModule assignmentsPresenterModule, Provider<AssignmentsInteractor> provider) {
        this.module = assignmentsPresenterModule;
        this.assignmentsInteractorProvider = provider;
    }

    public AssignmentsPresenter get() {
        return (AssignmentsPresenter) Preconditions.checkNotNull(this.module.assignmentPresenter((AssignmentsInteractor) this.assignmentsInteractorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AssignmentsPresenter> create(AssignmentsPresenterModule assignmentsPresenterModule, Provider<AssignmentsInteractor> provider) {
        return new AssignmentsPresenterModule_AssignmentPresenterFactory(assignmentsPresenterModule, provider);
    }
}
