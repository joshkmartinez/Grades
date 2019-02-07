package com.aeries.mobileportal.web_services.services;

import com.aeries.mobileportal.models.AuthenticationData;
import com.aeries.mobileportal.models.FeedbackFlag;
import com.aeries.mobileportal.models.User;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\fH'¨\u0006\r"}, d2 = {"Lcom/aeries/mobileportal/web_services/services/LoginService;", "", "getAccessToken", "Lio/reactivex/Observable;", "Lcom/aeries/mobileportal/models/AuthenticationData;", "user", "Lcom/aeries/mobileportal/models/User;", "getAccessTokenCall", "Lretrofit2/Call;", "isFeedbackEnabled", "Lcom/aeries/mobileportal/models/FeedbackFlag;", "url", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: LoginService.kt */
public interface LoginService {
    @NotNull
    @POST("authentication")
    Observable<AuthenticationData> getAccessToken(@NotNull @Body User user);

    @NotNull
    @POST("authentication")
    Call<AuthenticationData> getAccessTokenCall(@NotNull @Body User user);

    @NotNull
    @GET
    Observable<FeedbackFlag> isFeedbackEnabled(@NotNull @Url String str);
}
