package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.grades.AssignmentParentInteractor;
import com.aeries.mobileportal.presenters.grades.AssignmentParentPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AssignmentParentFragmentModule_PresenterFactory implements Factory<AssignmentParentPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AssignmentParentInteractor> interactorProvider;
    private final AssignmentParentFragmentModule module;

    public AssignmentParentFragmentModule_PresenterFactory(AssignmentParentFragmentModule assignmentParentFragmentModule, Provider<AssignmentParentInteractor> provider) {
        this.module = assignmentParentFragmentModule;
        this.interactorProvider = provider;
    }

    public AssignmentParentPresenter get() {
        return (AssignmentParentPresenter) Preconditions.checkNotNull(this.module.presenter((AssignmentParentInteractor) this.interactorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AssignmentParentPresenter> create(AssignmentParentFragmentModule assignmentParentFragmentModule, Provider<AssignmentParentInteractor> provider) {
        return new AssignmentParentFragmentModule_PresenterFactory(assignmentParentFragmentModule, provider);
    }
}
