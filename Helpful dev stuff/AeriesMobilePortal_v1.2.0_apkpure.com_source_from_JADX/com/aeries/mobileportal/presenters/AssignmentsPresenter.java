package com.aeries.mobileportal.presenters;

import com.aeries.mobileportal.interactors.grades.AssignmentsCallback;
import com.aeries.mobileportal.interactors.grades.AssignmentsInteractor;
import com.aeries.mobileportal.models.Gradebook;
import com.aeries.mobileportal.views.viewmodels.grades.AssignmentsViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/aeries/mobileportal/presenters/AssignmentsPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentsViewModel;", "Lcom/aeries/mobileportal/interactors/grades/AssignmentsCallback;", "assignmentsViewModel", "assignmentsInteractor", "Lcom/aeries/mobileportal/interactors/grades/AssignmentsInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentsViewModel;Lcom/aeries/mobileportal/interactors/grades/AssignmentsInteractor;)V", "getAssignmentsInteractor", "()Lcom/aeries/mobileportal/interactors/grades/AssignmentsInteractor;", "getAssignmentsViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentsViewModel;", "cancelNetworkCalls", "", "onCreate", "onGradebookError", "e", "", "onGradebookReceived", "gradebook", "Lcom/aeries/mobileportal/models/Gradebook;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentsPresenter.kt */
public final class AssignmentsPresenter extends BasePresenter<AssignmentsViewModel> implements AssignmentsCallback {
    @NotNull
    private final AssignmentsInteractor assignmentsInteractor;
    @NotNull
    private final AssignmentsViewModel assignmentsViewModel;

    public void onCreate() {
    }

    @NotNull
    public final AssignmentsInteractor getAssignmentsInteractor() {
        return this.assignmentsInteractor;
    }

    @NotNull
    public final AssignmentsViewModel getAssignmentsViewModel() {
        return this.assignmentsViewModel;
    }

    public AssignmentsPresenter(@NotNull AssignmentsViewModel assignmentsViewModel, @NotNull AssignmentsInteractor assignmentsInteractor) {
        Intrinsics.checkParameterIsNotNull(assignmentsViewModel, "assignmentsViewModel");
        Intrinsics.checkParameterIsNotNull(assignmentsInteractor, "assignmentsInteractor");
        super(assignmentsViewModel, assignmentsInteractor);
        this.assignmentsViewModel = assignmentsViewModel;
        this.assignmentsInteractor = assignmentsInteractor;
    }

    public void onGradebookReceived(@NotNull Gradebook gradebook) {
        Intrinsics.checkParameterIsNotNull(gradebook, "gradebook");
        this.assignmentsViewModel.showAssignments(gradebook.getAssignments());
    }

    public void onGradebookError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.assignmentsViewModel.showError(th);
    }

    public final void cancelNetworkCalls() {
        this.assignmentsInteractor.cancelRequests();
    }
}
