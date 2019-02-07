package com.aeries.mobileportal.views.viewmodels.supplemental_attendance;

import com.aeries.mobileportal.models.SupplementalAttendance;
import com.aeries.mobileportal.views.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/supplemental_attendance/SupplementalAttendanceViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "showCourseList", "", "attendance", "Lcom/aeries/mobileportal/models/SupplementalAttendance;", "showDoneScreen", "supplementalAttendance", "showError", "error", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SupplementalAttendanceViewModel.kt */
public interface SupplementalAttendanceViewModel extends BaseViewModel {
    void showCourseList(@NotNull SupplementalAttendance supplementalAttendance);

    void showDoneScreen(@NotNull SupplementalAttendance supplementalAttendance);

    void showError(@NotNull String str);
}
