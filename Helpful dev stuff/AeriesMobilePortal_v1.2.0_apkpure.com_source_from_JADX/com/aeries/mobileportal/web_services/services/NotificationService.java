package com.aeries.mobileportal.web_services.services;

import com.aeries.mobileportal.models.GenericServiceResponse;
import com.aeries.mobileportal.models.Notification;
import com.aeries.mobileportal.models.UpdateNotification;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\tH'J\u001e\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00032\b\b\u0001\u0010\n\u001a\u00020\tH'J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0001\u0010\n\u001a\u00020\tH'¨\u0006\u0011"}, d2 = {"Lcom/aeries/mobileportal/web_services/services/NotificationService;", "", "getAuthorizationCode", "Lio/reactivex/Observable;", "Lcom/aeries/mobileportal/models/GenericServiceResponse;", "schoolCode", "", "studentId", "userType", "", "token", "getNotifications", "", "Lcom/aeries/mobileportal/models/Notification;", "updateNotification", "notification", "Lcom/aeries/mobileportal/models/UpdateNotification;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: NotificationService.kt */
public interface NotificationService {
    @NotNull
    @GET("{schoolCode}/student/{studentId}/userType/{userType}/authorizationcode/")
    Observable<GenericServiceResponse> getAuthorizationCode(@Path("schoolCode") int i, @Path("studentId") int i2, @NotNull @Path("userType") String str, @NotNull @Header("Authorization") String str2);

    @NotNull
    @GET("notifications/")
    Observable<List<Notification>> getNotifications(@NotNull @Header("Authorization") String str);

    @NotNull
    @POST("updatenotification/")
    Observable<GenericServiceResponse> updateNotification(@Body @Nullable UpdateNotification updateNotification, @NotNull @Header("Authorization") String str);
}
