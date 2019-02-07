package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.aeries.mobileportal.interactors.grades.AssignmentParentInteractor;
import com.aeries.mobileportal.presenters.grades.AssignmentParentPresenter;
import com.aeries.mobileportal.views.viewmodels.grades.AssignmentParentViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/AssignmentParentFragmentModule;", "", "viewModel", "Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentParentViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentParentViewModel;)V", "getViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentParentViewModel;", "presenter", "Lcom/aeries/mobileportal/presenters/grades/AssignmentParentPresenter;", "interactor", "Lcom/aeries/mobileportal/interactors/grades/AssignmentParentInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: AssignmentParentFragmentModule.kt */
public final class AssignmentParentFragmentModule {
    @NotNull
    private final AssignmentParentViewModel viewModel;

    public AssignmentParentFragmentModule(@NotNull AssignmentParentViewModel assignmentParentViewModel) {
        Intrinsics.checkParameterIsNotNull(assignmentParentViewModel, "viewModel");
        this.viewModel = assignmentParentViewModel;
    }

    @NotNull
    public final AssignmentParentViewModel getViewModel() {
        return this.viewModel;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final AssignmentParentPresenter presenter(@NotNull AssignmentParentInteractor assignmentParentInteractor) {
        Intrinsics.checkParameterIsNotNull(assignmentParentInteractor, "interactor");
        return new AssignmentParentPresenter(this.viewModel, assignmentParentInteractor);
    }
}
