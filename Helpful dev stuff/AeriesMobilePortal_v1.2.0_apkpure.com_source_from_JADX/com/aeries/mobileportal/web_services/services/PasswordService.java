package com.aeries.mobileportal.web_services.services;

import com.aeries.mobileportal.models.ChangePasswordRequest;
import com.aeries.mobileportal.models.ChangePasswordResponse;
import com.aeries.mobileportal.models.ForgotPasswordRequest;
import com.aeries.mobileportal.models.ForgotPasswordResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH'J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\rH'¨\u0006\u000e"}, d2 = {"Lcom/aeries/mobileportal/web_services/services/PasswordService;", "", "changePassword", "Lio/reactivex/Observable;", "Lcom/aeries/mobileportal/models/ChangePasswordResponse;", "changePasswordRequest", "Lcom/aeries/mobileportal/models/ChangePasswordRequest;", "changePasswordNoVerification", "token", "", "forgotPassword", "Lcom/aeries/mobileportal/models/ForgotPasswordResponse;", "forgotPasswordRequest", "Lcom/aeries/mobileportal/models/ForgotPasswordRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: PasswordService.kt */
public interface PasswordService {
    @NotNull
    @POST("changepassword")
    Observable<ChangePasswordResponse> changePassword(@NotNull @Body ChangePasswordRequest changePasswordRequest);

    @NotNull
    @POST("changepassword")
    Observable<ChangePasswordResponse> changePasswordNoVerification(@NotNull @Body ChangePasswordRequest changePasswordRequest, @NotNull @Header("Authorization") String str);

    @NotNull
    @POST("forgotpassword")
    Observable<ForgotPasswordResponse> forgotPassword(@NotNull @Body ForgotPasswordRequest forgotPasswordRequest);
}
