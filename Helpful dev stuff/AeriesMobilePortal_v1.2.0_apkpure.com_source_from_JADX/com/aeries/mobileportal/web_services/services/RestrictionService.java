package com.aeries.mobileportal.web_services.services;

import com.aeries.mobileportal.models.Restricted;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/web_services/services/RestrictionService;", "", "getRestricted", "Lio/reactivex/Observable;", "Lcom/aeries/mobileportal/models/Restricted;", "schoolCode", "", "studentID", "token", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: RestrictionService.kt */
public interface RestrictionService {
    @NotNull
    @GET("{schoolCode}/student/{studentID}/restricted")
    Observable<Restricted> getRestricted(@Path("schoolCode") int i, @Path("studentID") int i2, @NotNull @Header("Authorization") String str);
}
