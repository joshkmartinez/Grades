package com.aeries.mobileportal.web_services.services;

import com.aeries.mobileportal.models.ReportCard;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Streaming;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001Jc\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\nH'¢\u0006\u0002\u0010\u000fJ/\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00112\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u000e\u001a\u00020\nH'¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/aeries/mobileportal/web_services/services/ReportCardService;", "", "downloadReport", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "schoolCode", "", "studentId", "year", "termCode", "", "type", "english", "", "token", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lretrofit2/Call;", "getReports", "Lio/reactivex/Observable;", "", "Lcom/aeries/mobileportal/models/ReportCard;", "(Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ReportCardService.kt */
public interface ReportCardService {
    @Streaming
    @NotNull
    @GET("reportcardhistory/schoolcode/{sc}/student/{id}/year/{yr}/term/{tm}/type/{ty}/english/{en}/download/")
    Call<ResponseBody> downloadReport(@Nullable @Path("sc") Integer num, @Nullable @Path("id") Integer num2, @Nullable @Path("yr") Integer num3, @Nullable @Path("tm") String str, @Nullable @Path("ty") String str2, @Path("en") boolean z, @NotNull @Header("Authorization") String str3);

    @NotNull
    @GET("reportcardhistory/{id}")
    Observable<List<ReportCard>> getReports(@Nullable @Path("id") Integer num, @NotNull @Header("Authorization") String str);
}
