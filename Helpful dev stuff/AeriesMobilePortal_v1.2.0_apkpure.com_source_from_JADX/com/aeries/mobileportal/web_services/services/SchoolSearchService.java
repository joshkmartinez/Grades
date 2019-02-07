package com.aeries.mobileportal.web_services.services;

import com.aeries.mobileportal.models.School;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'J*\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\nH'¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/web_services/services/SchoolSearchService;", "", "searchSchool", "Lio/reactivex/Observable;", "", "Lcom/aeries/mobileportal/models/School;", "query", "", "searchSchoolByLocation", "lat", "", "lon", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolSearchService.kt */
public interface SchoolSearchService {
    @NotNull
    @GET("https://ping.aeries.com/api/v1/schoolsearch/ca/AeriesAppParent/{searchValue}")
    Observable<List<School>> searchSchool(@Nullable @Path("searchValue") String str);

    @NotNull
    @GET("https://ping.aeries.com/api/v1/nearbyschools/ca/AeriesAppParent/{latitude}/{longitude}/10")
    Observable<List<School>> searchSchoolByLocation(@Path("latitude") double d, @Path("longitude") double d2);
}
