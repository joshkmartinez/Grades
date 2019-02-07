package com.aeries.mobileportal.web_services.services;

import com.aeries.mobileportal.models.SignalKit;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Header;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/aeries/mobileportal/web_services/services/SignalKitService;", "", "getSignalKitURL", "Lio/reactivex/Observable;", "Lcom/aeries/mobileportal/models/SignalKit;", "token", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SignalKitService.kt */
public interface SignalKitService {
    @NotNull
    @GET("signalkit/")
    Observable<SignalKit> getSignalKitURL(@NotNull @Header("Authorization") String str);
}
