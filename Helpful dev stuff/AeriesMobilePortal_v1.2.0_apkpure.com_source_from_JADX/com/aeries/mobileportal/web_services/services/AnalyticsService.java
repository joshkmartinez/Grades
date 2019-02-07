package com.aeries.mobileportal.web_services.services;

import android.content.res.Resources;
import android.os.Build.VERSION;
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.BuildConfig;
import io.reactivex.Observable;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001JÂ\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\u00052\b\b\u0003\u0010\n\u001a\u00020\b2\b\b\u0003\u0010\u000b\u001a\u00020\u00052\b\b\u0003\u0010\f\u001a\u00020\u00052\b\b\u0003\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u00052\b\b\u0003\u0010\u0010\u001a\u00020\b2\b\b\u0003\u0010\u0011\u001a\u00020\b2\b\b\u0003\u0010\u0012\u001a\u00020\b2\b\b\u0003\u0010\u0013\u001a\u00020\b2\b\b\u0003\u0010\u0014\u001a\u00020\b2\b\b\u0003\u0010\u0015\u001a\u00020\b2\b\b\u0003\u0010\u0016\u001a\u00020\b2\b\b\u0003\u0010\u0017\u001a\u00020\u0005H'¨\u0006\u0018"}, d2 = {"Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "", "postAnalytics", "Lio/reactivex/Observable;", "OS", "", "appVersion", "linkedStudentsNumber", "", "language", "linkedDistrictsNumber", "selectedSchool", "selectedDistrict", "userType", "currentScreen", "androidURL", "idSite", "random6DigNumber", "currentHour", "currentMin", "currentSec", "rec", "apiVersion", "screenResolution", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AnalyticsService.kt */
public interface AnalyticsService {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
    /* compiled from: AnalyticsService.kt */
    public static final class DefaultImpls {
        @NotNull
        @POST("piwik.php")
        public static /* bridge */ /* synthetic */ Observable postAnalytics$default(AnalyticsService analyticsService, String str, String str2, int i, String str3, int i2, String str4, String str5, String str6, String str7, String str8, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str9, int i10, Object obj) {
            int i11 = i10;
            if (obj == null) {
                String stringBuilder;
                String str10;
                if ((i11 & 1) != 0) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Android ");
                    stringBuilder2.append(String.valueOf(VERSION.SDK_INT));
                    stringBuilder = stringBuilder2.toString();
                } else {
                    stringBuilder = str;
                }
                String str11 = (i11 & 2) != 0 ? BuildConfig.VERSION_NAME : str2;
                int i12 = (i11 & 4) != 0 ? 0 : i;
                if ((i11 & 8) != 0) {
                    Resources system = Resources.getSystem();
                    Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
                    Locale locale = system.getConfiguration().locale;
                    Intrinsics.checkExpressionValueIsNotNull(locale, "Resources.getSystem().configuration.locale");
                    String displayLanguage = locale.getDisplayLanguage();
                    Intrinsics.checkExpressionValueIsNotNull(displayLanguage, "Resources.getSystem().co…on.locale.displayLanguage");
                    str10 = displayLanguage;
                } else {
                    str10 = str3;
                }
                return analyticsService.postAnalytics(stringBuilder, str11, i12, str10, (i11 & 16) != 0 ? 0 : i2, (i11 & 32) != 0 ? "" : str4, (i11 & 64) != 0 ? "" : str5, (i11 & 128) != 0 ? "" : str6, str7, str8, (i11 & 1024) != 0 ? 3 : i3, (i11 & 2048) != 0 ? new Random().nextInt(999998) + 1 : i4, (i11 & 4096) != 0 ? Calendar.getInstance().get(10) : i5, (i11 & 8192) != 0 ? Calendar.getInstance().get(12) : i6, (i11 & 16384) != 0 ? Calendar.getInstance().get(13) : i7, (32768 & i11) != 0 ? 1 : i8, (65536 & i11) != 0 ? 1 : i9, (i11 & 131072) != 0 ? AppConstants.Companion.getScreenRes() : str9);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postAnalytics");
        }
    }

    @NotNull
    @POST("piwik.php")
    Observable<Object> postAnalytics(@NotNull @Query("dimension1") String str, @NotNull @Query("dimension2") String str2, @Query("dimension3") int i, @NotNull @Query("dimension4") String str3, @Query("dimension5") int i2, @NotNull @Query("dimension6") String str4, @NotNull @Query("dimension7") String str5, @NotNull @Query("dimension9") String str6, @NotNull @Query("action_name") String str7, @NotNull @Query("url") String str8, @Query("idsite") int i3, @Query("rand") int i4, @Query("h") int i5, @Query("m") int i6, @Query("s") int i7, @Query("rec") int i8, @Query("apiv") int i9, @NotNull @Query("res") String str9);
}
