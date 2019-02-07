package com.aeries.mobileportal.web_services.services;

import com.aeries.mobileportal.models.AccountSettings;
import com.aeries.mobileportal.models.GenericServiceResponse;
import com.aeries.mobileportal.models.ServerInfo;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H'J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u0006H'¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "", "checkAppSettings", "Lio/reactivex/Observable;", "Lcom/aeries/mobileportal/models/AccountSettings;", "url", "", "checkIfAppActive", "Lcom/aeries/mobileportal/models/GenericServiceResponse;", "getServerInfo", "Lcom/aeries/mobileportal/models/ServerInfo;", "token", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ApplicationService.kt */
public interface ApplicationService {
    @NotNull
    @GET
    Observable<AccountSettings> checkAppSettings(@NotNull @Url String str);

    @NotNull
    @GET
    Observable<GenericServiceResponse> checkIfAppActive(@NotNull @Url String str);

    @NotNull
    @GET("serverinfo")
    Observable<ServerInfo> getServerInfo();

    @NotNull
    @GET("serverinfo")
    Observable<ServerInfo> getServerInfo(@NotNull @Header("Authorization") String str);
}
