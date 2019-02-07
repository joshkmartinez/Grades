package com.aeries.mobileportal.interactors.supplementan_attendance;

import com.aeries.mobileportal.models.Session;
import com.aeries.mobileportal.models.SupplementalAttendanceStatus;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0012\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0018"}, d2 = {"Lcom/aeries/mobileportal/interactors/supplementan_attendance/ClassCheckInCallback;", "", "onCheckInError", "", "message", "", "onCheckInFailure", "supplementalAttendanceStatus", "Lcom/aeries/mobileportal/models/SupplementalAttendanceStatus;", "onCheckInSuccessNoSessions", "onCheckInSuccessWithSessions", "onCheckOutError", "onCheckOutFailure", "onCheckOutSuccess", "onCheckedIn", "onNotCheckedIn", "onScanCheckInSuccess", "onSessionsError", "onSessionsRetrieved", "sessions", "", "Lcom/aeries/mobileportal/models/Session;", "onStatusError", "onStatusFail", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ClassCheckInCallback.kt */
public interface ClassCheckInCallback {
    void onCheckInError(@NotNull String str);

    void onCheckInFailure(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus);

    void onCheckInSuccessNoSessions(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus);

    void onCheckInSuccessWithSessions(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus);

    void onCheckOutError(@NotNull String str);

    void onCheckOutFailure(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus);

    void onCheckOutSuccess(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus);

    void onCheckedIn(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus);

    void onNotCheckedIn(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus);

    void onScanCheckInSuccess(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus);

    void onSessionsError(@NotNull String str);

    void onSessionsRetrieved(@NotNull List<Session> list);

    void onStatusError(@NotNull String str);

    void onStatusFail(@NotNull String str);
}
