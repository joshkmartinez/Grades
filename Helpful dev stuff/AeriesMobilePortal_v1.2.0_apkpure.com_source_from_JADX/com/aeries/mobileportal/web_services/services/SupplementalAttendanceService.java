package com.aeries.mobileportal.web_services.services;

import com.aeries.mobileportal.models.CheckInOutRequest;
import com.aeries.mobileportal.models.Session;
import com.aeries.mobileportal.models.SupplementalAttendanceStatus;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J2\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0007\u001a\u00020\bH'J,\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006\u0012"}, d2 = {"Lcom/aeries/mobileportal/web_services/services/SupplementalAttendanceService;", "", "checkIn", "Lio/reactivex/Observable;", "Lcom/aeries/mobileportal/models/SupplementalAttendanceStatus;", "checkInOutRequest", "Lcom/aeries/mobileportal/models/CheckInOutRequest;", "token", "", "checkOut", "checkOutOutRequest", "sessions", "", "Lcom/aeries/mobileportal/models/Session;", "schoolCode", "", "studentId", "status", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SupplementalAttendanceService.kt */
public interface SupplementalAttendanceService {
    @NotNull
    @POST("supplementalattendance/checkin")
    Observable<SupplementalAttendanceStatus> checkIn(@NotNull @Body CheckInOutRequest checkInOutRequest, @NotNull @Header("Authorization") String str);

    @NotNull
    @POST("supplementalattendance/checkout")
    Observable<SupplementalAttendanceStatus> checkOut(@NotNull @Body CheckInOutRequest checkInOutRequest, @NotNull @Header("Authorization") String str);

    @NotNull
    @GET("{schoolCode}/student/{studentId}/supplementalattendancesessions")
    Observable<List<Session>> sessions(@Path("schoolCode") int i, @Path("studentId") int i2, @NotNull @Header("Authorization") String str);

    @NotNull
    @GET("{schoolCode}/student/{studentId}/supplementalattendancestatus")
    Observable<SupplementalAttendanceStatus> status(@Path("schoolCode") int i, @Path("studentId") int i2, @NotNull @Header("Authorization") String str);
}
