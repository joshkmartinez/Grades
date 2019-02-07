package com.aeries.mobileportal.views.viewmodels.attendance;

import com.aeries.mobileportal.models.AttendanceDetail;
import com.aeries.mobileportal.views.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/views/viewmodels/attendance/AttendanceViewModel;", "Lcom/aeries/mobileportal/views/BaseViewModel;", "onAttendanceError", "", "e", "", "onAttendanceRetrieved", "attendances", "", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AttendanceViewModel.kt */
public interface AttendanceViewModel extends BaseViewModel {
    void onAttendanceError(@NotNull Throwable th);

    void onAttendanceRetrieved(@NotNull List<AttendanceDetail> list);
}
