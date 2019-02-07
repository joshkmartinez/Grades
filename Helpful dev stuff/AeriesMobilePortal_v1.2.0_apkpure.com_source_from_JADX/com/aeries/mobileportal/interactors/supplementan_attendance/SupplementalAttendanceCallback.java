package com.aeries.mobileportal.interactors.supplementan_attendance;

import com.aeries.mobileportal.models.SupplementalAttendance;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/aeries/mobileportal/interactors/supplementan_attendance/SupplementalAttendanceCallback;", "", "onCheckIn", "", "supplementalAttendance", "Lcom/aeries/mobileportal/models/SupplementalAttendance;", "onCheckInError", "throwable", "", "onCheckInFail", "onSupplementalAttendanceError", "e", "onSupplementalAttendanceFail", "onSupplementalAttendanceSuccessChoseCourse", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SupplementalAttendanceCallback.kt */
public interface SupplementalAttendanceCallback {
    void onCheckIn(@NotNull SupplementalAttendance supplementalAttendance);

    void onCheckInError(@NotNull Throwable th);

    void onCheckInFail(@NotNull SupplementalAttendance supplementalAttendance);

    void onSupplementalAttendanceError(@NotNull Throwable th);

    void onSupplementalAttendanceFail(@NotNull SupplementalAttendance supplementalAttendance);

    void onSupplementalAttendanceSuccessChoseCourse(@NotNull SupplementalAttendance supplementalAttendance);
}
