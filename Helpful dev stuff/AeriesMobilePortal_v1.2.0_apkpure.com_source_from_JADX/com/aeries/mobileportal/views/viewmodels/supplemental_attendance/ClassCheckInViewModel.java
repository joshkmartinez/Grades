package com.aeries.mobileportal.views.viewmodels.supplemental_attendance;

import com.aeries.mobileportal.models.Session;
import com.aeries.mobileportal.models.SupplementalAttendanceStatus;
import com.aeries.mobileportal.views.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/supplemental_attendance/ClassCheckInViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "showCheckInFragment", "", "supplementalAttendanceStatus", "Lcom/aeries/mobileportal/models/SupplementalAttendanceStatus;", "showCheckInToAnotherRoomFragment", "showCheckOutFragment", "showError", "message", "", "showScanCheckOutFragment", "showSessionsFragment", "updateSessions", "sessions", "", "Lcom/aeries/mobileportal/models/Session;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ClassCheckInViewModel.kt */
public interface ClassCheckInViewModel extends BaseViewModel {
    void showCheckInFragment(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus);

    void showCheckInToAnotherRoomFragment(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus);

    void showCheckOutFragment(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus);

    void showError(@NotNull String str);

    void showScanCheckOutFragment(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus);

    void showSessionsFragment(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus);

    void updateSessions(@NotNull List<Session> list);
}
