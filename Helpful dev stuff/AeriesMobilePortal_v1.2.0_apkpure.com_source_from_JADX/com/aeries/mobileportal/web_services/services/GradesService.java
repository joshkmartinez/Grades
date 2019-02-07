package com.aeries.mobileportal.web_services.services;

import com.aeries.mobileportal.models.Gradebook;
import com.aeries.mobileportal.models.SchoolClassSummary;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\tH'¢\u0006\u0002\u0010\nJM\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\b\u001a\u00020\tH'¢\u0006\u0002\u0010\u0010J;\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00040\u00032\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\tH'¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/aeries/mobileportal/web_services/services/GradesService;", "", "getClassSummary", "Lio/reactivex/Observable;", "", "Lcom/aeries/mobileportal/models/SchoolClassSummary;", "studentId", "", "token", "", "(Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "getGradebook", "Lcom/aeries/mobileportal/models/Gradebook;", "schoolCode", "gradebookNumber", "termCode", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "getGradebooks", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: GradesService.kt */
public interface GradesService {
    @NotNull
    @GET("student/{studentId}/classsummary/")
    Observable<List<SchoolClassSummary>> getClassSummary(@Nullable @Path("studentId") Integer num, @NotNull @Header("Authorization") String str);

    @NotNull
    @GET("{schoolCode}/student/{studentId}/gradebooks/{gradebookNumber}/{termCode}")
    Observable<Gradebook> getGradebook(@Nullable @Path("schoolCode") Integer num, @Nullable @Path("studentId") Integer num2, @Nullable @Path("gradebookNumber") Integer num3, @Nullable @Path("termCode") String str, @NotNull @Header("Authorization") String str2);

    @NotNull
    @GET("{schoolCode}/student/{studentId}/gradebooks/")
    Observable<List<Gradebook>> getGradebooks(@Nullable @Path("schoolCode") Integer num, @Nullable @Path("studentId") Integer num2, @NotNull @Header("Authorization") String str);
}
