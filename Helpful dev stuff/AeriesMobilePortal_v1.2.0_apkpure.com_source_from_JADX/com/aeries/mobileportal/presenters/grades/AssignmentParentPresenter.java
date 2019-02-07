package com.aeries.mobileportal.presenters.grades;

import com.aeries.mobileportal.interactors.grades.AssignmentParentCallback;
import com.aeries.mobileportal.interactors.grades.AssignmentParentInteractor;
import com.aeries.mobileportal.models.ClassSummary;
import com.aeries.mobileportal.models.Gradebook;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.grades.AssignmentParentViewModel;
import io.realm.RealmList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/aeries/mobileportal/presenters/grades/AssignmentParentPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentParentViewModel;", "Lcom/aeries/mobileportal/interactors/grades/AssignmentParentCallback;", "model", "interactor", "Lcom/aeries/mobileportal/interactors/grades/AssignmentParentInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentParentViewModel;Lcom/aeries/mobileportal/interactors/grades/AssignmentParentInteractor;)V", "getInteractor", "()Lcom/aeries/mobileportal/interactors/grades/AssignmentParentInteractor;", "getModel", "()Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentParentViewModel;", "cancelNetworkCalls", "", "getGradebook", "classSummary", "Lcom/aeries/mobileportal/models/ClassSummary;", "onCreate", "onGradebookError", "e", "", "onGradebookReceived", "gradebook", "Lcom/aeries/mobileportal/models/Gradebook;", "sendAnalytics", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentParentPresenter.kt */
public final class AssignmentParentPresenter extends BasePresenter<AssignmentParentViewModel> implements AssignmentParentCallback {
    @NotNull
    private final AssignmentParentInteractor interactor;
    @NotNull
    private final AssignmentParentViewModel model;

    public void onCreate() {
    }

    @NotNull
    public final AssignmentParentInteractor getInteractor() {
        return this.interactor;
    }

    @NotNull
    public final AssignmentParentViewModel getModel() {
        return this.model;
    }

    public AssignmentParentPresenter(@NotNull AssignmentParentViewModel assignmentParentViewModel, @NotNull AssignmentParentInteractor assignmentParentInteractor) {
        Intrinsics.checkParameterIsNotNull(assignmentParentViewModel, "model");
        Intrinsics.checkParameterIsNotNull(assignmentParentInteractor, "interactor");
        super(assignmentParentViewModel, assignmentParentInteractor);
        this.model = assignmentParentViewModel;
        this.interactor = assignmentParentInteractor;
    }

    public final void sendAnalytics() {
        this.interactor.sendAssignmentsAnalytics();
    }

    public final void getGradebook(@Nullable ClassSummary classSummary) {
        this.interactor.getGradebook(classSummary, this);
    }

    public void onGradebookReceived(@NotNull Gradebook gradebook) {
        Intrinsics.checkParameterIsNotNull(gradebook, "gradebook");
        RealmList categories = gradebook.getCategories();
        if ((categories == null || (categories.isEmpty() ^ 1) != 1) && !this.model.getShowCategories()) {
            this.model.showAssignments(gradebook);
        } else {
            this.model.showCategories(gradebook);
        }
    }

    public void onGradebookError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.model.showError(th);
    }

    public final void cancelNetworkCalls() {
        this.interactor.cancelRequests();
    }
}
