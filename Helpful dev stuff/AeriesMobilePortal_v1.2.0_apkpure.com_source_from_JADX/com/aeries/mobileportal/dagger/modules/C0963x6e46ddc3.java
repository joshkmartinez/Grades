package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.grades.AssignmentCategoryInteractor;
import com.aeries.mobileportal.presenters.grades.AssignmentCategoryPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class C0963x6e46ddc3 implements Factory<AssignmentCategoryPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AssignmentCategoryInteractor> interactorProvider;
    private final AssignmentCategoryPresenterModule module;

    public C0963x6e46ddc3(AssignmentCategoryPresenterModule assignmentCategoryPresenterModule, Provider<AssignmentCategoryInteractor> provider) {
        this.module = assignmentCategoryPresenterModule;
        this.interactorProvider = provider;
    }

    public AssignmentCategoryPresenter get() {
        return (AssignmentCategoryPresenter) Preconditions.checkNotNull(this.module.assignmentCategoryPresenter((AssignmentCategoryInteractor) this.interactorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AssignmentCategoryPresenter> create(AssignmentCategoryPresenterModule assignmentCategoryPresenterModule, Provider<AssignmentCategoryInteractor> provider) {
        return new C0963x6e46ddc3(assignmentCategoryPresenterModule, provider);
    }
}
