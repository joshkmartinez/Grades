package com.aeries.mobileportal.presenters.grades;

import com.aeries.mobileportal.interactors.grades.CoursesCallback;
import com.aeries.mobileportal.interactors.grades.CoursesInteractor;
import com.aeries.mobileportal.models.SchoolClassSummary;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.grades.CoursesViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0006\u0010\u0017\u001a\u00020\rJ\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/aeries/mobileportal/presenters/grades/CoursesPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/grades/CoursesViewModel;", "Lcom/aeries/mobileportal/interactors/grades/CoursesCallback;", "viewModel", "interactor", "Lcom/aeries/mobileportal/interactors/grades/CoursesInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/grades/CoursesViewModel;Lcom/aeries/mobileportal/interactors/grades/CoursesInteractor;)V", "getInteractor", "()Lcom/aeries/mobileportal/interactors/grades/CoursesInteractor;", "getViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/grades/CoursesViewModel;", "cancelNetworkRequests", "", "getCourses", "onClassSummariesError", "e", "", "onClassSummariesReceived", "classSummaries", "", "Lcom/aeries/mobileportal/models/SchoolClassSummary;", "onCreate", "sendAnalytics", "showError", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CoursesPresenter.kt */
public final class CoursesPresenter extends BasePresenter<CoursesViewModel> implements CoursesCallback {
    @NotNull
    private final CoursesInteractor interactor;
    @NotNull
    private final CoursesViewModel viewModel;

    public void onCreate() {
    }

    public void showError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
    }

    @NotNull
    public final CoursesInteractor getInteractor() {
        return this.interactor;
    }

    @NotNull
    public final CoursesViewModel getViewModel() {
        return this.viewModel;
    }

    public CoursesPresenter(@NotNull CoursesViewModel coursesViewModel, @NotNull CoursesInteractor coursesInteractor) {
        Intrinsics.checkParameterIsNotNull(coursesViewModel, "viewModel");
        Intrinsics.checkParameterIsNotNull(coursesInteractor, "interactor");
        super(coursesViewModel, coursesInteractor);
        this.viewModel = coursesViewModel;
        this.interactor = coursesInteractor;
    }

    public final void getCourses() {
        this.interactor.getCurrentStudentClasses(this);
    }

    public final void sendAnalytics() {
        this.interactor.sendScreenAnalytics();
    }

    public void onClassSummariesReceived(@NotNull List<SchoolClassSummary> list) {
        Intrinsics.checkParameterIsNotNull(list, "classSummaries");
        this.viewModel.showCourses(list);
    }

    public void onClassSummariesError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.viewModel.showErrorAndFinish(th.getMessage());
    }

    public final void cancelNetworkRequests() {
        this.interactor.cancelRequests();
    }
}
