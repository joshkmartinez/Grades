package com.aeries.mobileportal.presenters.grades;

import com.aeries.mobileportal.interactors.grades.AssignmentCategoryCallback;
import com.aeries.mobileportal.interactors.grades.AssignmentCategoryInteractor;
import com.aeries.mobileportal.models.ClassSummary;
import com.aeries.mobileportal.models.Gradebook;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.grades.AssignmentCategoryViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/aeries/mobileportal/presenters/grades/AssignmentCategoryPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentCategoryViewModel;", "Lcom/aeries/mobileportal/interactors/grades/AssignmentCategoryCallback;", "assignmentCategoryViewModel", "interactor", "Lcom/aeries/mobileportal/interactors/grades/AssignmentCategoryInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentCategoryViewModel;Lcom/aeries/mobileportal/interactors/grades/AssignmentCategoryInteractor;)V", "getAssignmentCategoryViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentCategoryViewModel;", "getInteractor", "()Lcom/aeries/mobileportal/interactors/grades/AssignmentCategoryInteractor;", "getCourses", "", "course", "Lcom/aeries/mobileportal/models/ClassSummary;", "onCreate", "onGradebookError", "e", "", "onGradebookReceived", "gradebook", "Lcom/aeries/mobileportal/models/Gradebook;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentCategoryPresenter.kt */
public final class AssignmentCategoryPresenter extends BasePresenter<AssignmentCategoryViewModel> implements AssignmentCategoryCallback {
    @NotNull
    private final AssignmentCategoryViewModel assignmentCategoryViewModel;
    @NotNull
    private final AssignmentCategoryInteractor interactor;

    public void onCreate() {
    }

    @NotNull
    public final AssignmentCategoryViewModel getAssignmentCategoryViewModel() {
        return this.assignmentCategoryViewModel;
    }

    @NotNull
    public final AssignmentCategoryInteractor getInteractor() {
        return this.interactor;
    }

    public AssignmentCategoryPresenter(@NotNull AssignmentCategoryViewModel assignmentCategoryViewModel, @NotNull AssignmentCategoryInteractor assignmentCategoryInteractor) {
        Intrinsics.checkParameterIsNotNull(assignmentCategoryViewModel, "assignmentCategoryViewModel");
        Intrinsics.checkParameterIsNotNull(assignmentCategoryInteractor, "interactor");
        super(assignmentCategoryViewModel, assignmentCategoryInteractor);
        this.assignmentCategoryViewModel = assignmentCategoryViewModel;
        this.interactor = assignmentCategoryInteractor;
    }

    public final void getCourses(@NotNull ClassSummary classSummary) {
        Intrinsics.checkParameterIsNotNull(classSummary, "course");
        this.interactor.getGradebook(classSummary, this);
    }

    public void onGradebookReceived(@NotNull Gradebook gradebook) {
        Intrinsics.checkParameterIsNotNull(gradebook, "gradebook");
        this.assignmentCategoryViewModel.showCategories(gradebook);
    }

    public void onGradebookError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.assignmentCategoryViewModel.showError(th);
    }
}
