package com.aeries.mobileportal.web_services.services;

import com.aeries.mobileportal.models.GenericServiceResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H'¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/web_services/services/FeedbackService;", "", "getFeedbackFlag", "Lio/reactivex/Observable;", "", "url", "", "sendFeedback", "Lcom/aeries/mobileportal/models/GenericServiceResponse;", "email", "comment", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: FeedbackService.kt */
public interface FeedbackService {
    @NotNull
    @GET
    Observable<Integer> getFeedbackFlag(@NotNull @Url String str);

    @FormUrlEncoded
    @NotNull
    @POST
    Observable<GenericServiceResponse> sendFeedback(@NotNull @Url String str, @NotNull @Field("email") String str2, @NotNull @Field("comment") String str3);
}
