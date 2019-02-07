package com.aeries.mobileportal.presenters.attendance;

import com.aeries.mobileportal.interactors.attendance.AttendanceCallback;
import com.aeries.mobileportal.interactors.attendance.AttendanceInteractor;
import com.aeries.mobileportal.models.AttendanceDetail;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.attendance.AttendanceViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0006\u0010\u0016\u001a\u00020\rR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/aeries/mobileportal/presenters/attendance/AttendancePresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/attendance/AttendanceViewModel;", "Lcom/aeries/mobileportal/interactors/attendance/AttendanceCallback;", "attendanceViewModel", "interactor", "Lcom/aeries/mobileportal/interactors/attendance/AttendanceInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/attendance/AttendanceViewModel;Lcom/aeries/mobileportal/interactors/attendance/AttendanceInteractor;)V", "getAttendanceViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/attendance/AttendanceViewModel;", "getInteractor", "()Lcom/aeries/mobileportal/interactors/attendance/AttendanceInteractor;", "getYearlyAttendances", "", "onAttendanceError", "e", "", "onAttendanceReceived", "attendance", "", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "onCreate", "sendDetailsAnalytics", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AttendancePresenter.kt */
public final class AttendancePresenter extends BasePresenter<AttendanceViewModel> implements AttendanceCallback {
    @NotNull
    private final AttendanceViewModel attendanceViewModel;
    @NotNull
    private final AttendanceInteractor interactor;

    public AttendancePresenter(@NotNull AttendanceViewModel attendanceViewModel, @NotNull AttendanceInteractor attendanceInteractor) {
        Intrinsics.checkParameterIsNotNull(attendanceViewModel, "attendanceViewModel");
        Intrinsics.checkParameterIsNotNull(attendanceInteractor, "interactor");
        super(attendanceViewModel, attendanceInteractor);
        this.attendanceViewModel = attendanceViewModel;
        this.interactor = attendanceInteractor;
    }

    @NotNull
    public final AttendanceViewModel getAttendanceViewModel() {
        return this.attendanceViewModel;
    }

    @NotNull
    public final AttendanceInteractor getInteractor() {
        return this.interactor;
    }

    public final void getYearlyAttendances() {
        this.interactor.getCurrentStudentYearlyAttendance(this);
    }

    public final void sendDetailsAnalytics() {
        this.interactor.sendDetailsAnalytics();
    }

    public void onAttendanceError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.attendanceViewModel.onAttendanceError(th);
    }

    public void onAttendanceReceived(@NotNull List<AttendanceDetail> list) {
        Intrinsics.checkParameterIsNotNull(list, "attendance");
        this.attendanceViewModel.onAttendanceRetrieved(list);
    }

    public void onCreate() {
        this.interactor.sendAnalytics();
    }
}
