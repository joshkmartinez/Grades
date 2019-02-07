package com.aeries.mobileportal.presenters.supplemental_attendance;

import com.aeries.mobileportal.interactors.supplementan_attendance.SupplementalAttendanceCallback;
import com.aeries.mobileportal.interactors.supplementan_attendance.SupplementalAttendanceInteractor;
import com.aeries.mobileportal.models.SupplementalAttendance;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.supplemental_attendance.SupplementalAttendanceViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/aeries/mobileportal/presenters/supplemental_attendance/SupplementalAttendancePresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/supplemental_attendance/SupplementalAttendanceViewModel;", "Lcom/aeries/mobileportal/interactors/supplementan_attendance/SupplementalAttendanceCallback;", "supplementalAttendanceViewModel", "interactor", "Lcom/aeries/mobileportal/interactors/supplementan_attendance/SupplementalAttendanceInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/supplemental_attendance/SupplementalAttendanceViewModel;Lcom/aeries/mobileportal/interactors/supplementan_attendance/SupplementalAttendanceInteractor;)V", "getInteractor", "()Lcom/aeries/mobileportal/interactors/supplementan_attendance/SupplementalAttendanceInteractor;", "onCheckIn", "", "supplementalAttendance", "Lcom/aeries/mobileportal/models/SupplementalAttendance;", "onCheckInError", "throwable", "", "onCheckInFail", "onCreate", "onSupplementalAttendanceError", "e", "onSupplementalAttendanceFail", "onSupplementalAttendanceSuccessChoseCourse", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SupplementalAttendancePresenter.kt */
public final class SupplementalAttendancePresenter extends BasePresenter<SupplementalAttendanceViewModel> implements SupplementalAttendanceCallback {
    @NotNull
    private final SupplementalAttendanceInteractor interactor;
    private final SupplementalAttendanceViewModel supplementalAttendanceViewModel;

    public void onCreate() {
    }

    public SupplementalAttendancePresenter(@NotNull SupplementalAttendanceViewModel supplementalAttendanceViewModel, @NotNull SupplementalAttendanceInteractor supplementalAttendanceInteractor) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceViewModel, "supplementalAttendanceViewModel");
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceInteractor, "interactor");
        super(supplementalAttendanceViewModel, supplementalAttendanceInteractor);
        this.supplementalAttendanceViewModel = supplementalAttendanceViewModel;
        this.interactor = supplementalAttendanceInteractor;
    }

    @NotNull
    public final SupplementalAttendanceInteractor getInteractor() {
        return this.interactor;
    }

    public void onSupplementalAttendanceSuccessChoseCourse(@NotNull SupplementalAttendance supplementalAttendance) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendance, "supplementalAttendance");
        this.supplementalAttendanceViewModel.showCourseList(supplementalAttendance);
    }

    public void onSupplementalAttendanceFail(@NotNull SupplementalAttendance supplementalAttendance) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendance, "supplementalAttendance");
        SupplementalAttendanceViewModel supplementalAttendanceViewModel = this.supplementalAttendanceViewModel;
        supplementalAttendance = supplementalAttendance.getMessage();
        if (supplementalAttendance == null) {
            supplementalAttendance = "";
        }
        supplementalAttendanceViewModel.showError(supplementalAttendance);
    }

    public void onSupplementalAttendanceError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        SupplementalAttendanceViewModel supplementalAttendanceViewModel = this.supplementalAttendanceViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "Error";
        }
        supplementalAttendanceViewModel.showError(th);
    }

    public void onCheckIn(@NotNull SupplementalAttendance supplementalAttendance) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendance, "supplementalAttendance");
        this.supplementalAttendanceViewModel.showDoneScreen(supplementalAttendance);
    }

    public void onCheckInFail(@NotNull SupplementalAttendance supplementalAttendance) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendance, "supplementalAttendance");
        SupplementalAttendanceViewModel supplementalAttendanceViewModel = this.supplementalAttendanceViewModel;
        supplementalAttendance = supplementalAttendance.getMessage();
        if (supplementalAttendance == null) {
            supplementalAttendance = "Error";
        }
        supplementalAttendanceViewModel.showError(supplementalAttendance);
    }

    public void onCheckInError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        SupplementalAttendanceViewModel supplementalAttendanceViewModel = this.supplementalAttendanceViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "Error";
        }
        supplementalAttendanceViewModel.showError(th);
    }
}
