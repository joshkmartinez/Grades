package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.aeries.mobileportal.interactors.grades.AssignmentCategoryInteractor;
import com.aeries.mobileportal.presenters.grades.AssignmentCategoryPresenter;
import com.aeries.mobileportal.views.viewmodels.grades.AssignmentCategoryViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/AssignmentCategoryPresenterModule;", "", "assignmentCategoryViewModel", "Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentCategoryViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentCategoryViewModel;)V", "getAssignmentCategoryViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentCategoryViewModel;", "assignmentCategoryPresenter", "Lcom/aeries/mobileportal/presenters/grades/AssignmentCategoryPresenter;", "interactor", "Lcom/aeries/mobileportal/interactors/grades/AssignmentCategoryInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: AssignmentCategoryPresenterModule.kt */
public final class AssignmentCategoryPresenterModule {
    @NotNull
    private final AssignmentCategoryViewModel assignmentCategoryViewModel;

    public AssignmentCategoryPresenterModule(@NotNull AssignmentCategoryViewModel assignmentCategoryViewModel) {
        Intrinsics.checkParameterIsNotNull(assignmentCategoryViewModel, "assignmentCategoryViewModel");
        this.assignmentCategoryViewModel = assignmentCategoryViewModel;
    }

    @NotNull
    public final AssignmentCategoryViewModel getAssignmentCategoryViewModel() {
        return this.assignmentCategoryViewModel;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final AssignmentCategoryPresenter assignmentCategoryPresenter(@NotNull AssignmentCategoryInteractor assignmentCategoryInteractor) {
        Intrinsics.checkParameterIsNotNull(assignmentCategoryInteractor, "interactor");
        return new AssignmentCategoryPresenter(this.assignmentCategoryViewModel, assignmentCategoryInteractor);
    }
}
