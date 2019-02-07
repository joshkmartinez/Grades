package com.aeries.mobileportal;

import android.util.DisplayMetrics;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/AppConstants;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AppConstants.kt */
public final class AppConstants {
    @NotNull
    private static final Set<String> ABOUT_SETTINGS = SetsKt.setOf(new String[]{"AppVersion", "PortalVersion"});
    @NotNull
    private static final String ANALYTICS_URL = "https://stats.aeries.com/statistics/";
    @NotNull
    private static final List<Integer> ASSIGNMENT_DETAIL_TITLES = CollectionsKt.listOf(new Integer[]{Integer.valueOf(C0316R.string.category), Integer.valueOf(C0316R.string.description), Integer.valueOf(C0316R.string.score), Integer.valueOf(C0316R.string.gradebook), Integer.valueOf(C0316R.string.date_assigned), Integer.valueOf(C0316R.string.due_date), Integer.valueOf(C0316R.string.date_completed), Integer.valueOf(C0316R.string.grading_completed), Integer.valueOf(C0316R.string.comment), Integer.valueOf(C0316R.string.assignment_description)});
    public static final Companion Companion = new Companion();
    @NotNull
    private static final List<String> DEMOGRAPHICS_DETAILS = CollectionsKt.listOf(new String[]{"<header>Profile", "fullName", "primaryPhone", "schoolName", "permId", "sex", "grade", "birthDate", "teacher", "teacherEmail", "<header>Demographics", "residenceAddress", "mailingAddress"});
    @NotNull
    private static final Set<String> DISTRICT_SETTINGS = SetsKt.setOf(new String[]{"SwitchDistrict", "AddDistrict"});
    @NotNull
    private static final Set<String> DISTRICT_SETTINGS_ONE_DISTRICT = SetsKt.setOf("AddDistrict");
    @NotNull
    private static final String FAKE_URL = "http://android.mobileportal.aeries.com/screen/";
    @NotNull
    private static final Set<String> PARENT_SETTINGS = SetsKt.setOf(new String[]{"ChangePassword", "Logout", "LinkStudent"});
    @NotNull
    private static final Set<String> PARENT_SETTINGS_NO_CHANGE_PASSWORD = SetsKt.setOf(new String[]{"LinkStudent", "Logout"});
    private static final int PERMISSIONS_REQUEST_CAMERA = 1001;
    @NotNull
    private static final Set<String> STUDENT_SETTINGS = SetsKt.setOf(new String[]{"ChangePassword", "Logout"});
    @NotNull
    private static final Set<String> STUDENT_SETTINGS_NO_CHANGE_PASSWORD = SetsKt.setOf("Logout");
    @NotNull
    private static final String URL_EXTENSION = "/mobileapi/v1/";
    @NotNull
    public static String screenResulution;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010)\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\nR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0014\u0010\u001c\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0007R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0007R\u0014\u0010#\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\nR\u001a\u0010%\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010(¨\u0006."}, d2 = {"Lcom/aeries/mobileportal/AppConstants$Companion;", "", "()V", "ABOUT_SETTINGS", "", "", "getABOUT_SETTINGS", "()Ljava/util/Set;", "ANALYTICS_URL", "getANALYTICS_URL", "()Ljava/lang/String;", "ASSIGNMENT_DETAIL_TITLES", "", "", "getASSIGNMENT_DETAIL_TITLES", "()Ljava/util/List;", "DEMOGRAPHICS_DETAILS", "getDEMOGRAPHICS_DETAILS", "DISTRICT_SETTINGS", "getDISTRICT_SETTINGS", "DISTRICT_SETTINGS_ONE_DISTRICT", "getDISTRICT_SETTINGS_ONE_DISTRICT", "FAKE_URL", "getFAKE_URL", "PARENT_SETTINGS", "getPARENT_SETTINGS", "PARENT_SETTINGS_NO_CHANGE_PASSWORD", "getPARENT_SETTINGS_NO_CHANGE_PASSWORD", "PERMISSIONS_REQUEST_CAMERA", "getPERMISSIONS_REQUEST_CAMERA", "()I", "STUDENT_SETTINGS", "getSTUDENT_SETTINGS", "STUDENT_SETTINGS_NO_CHANGE_PASSWORD", "getSTUDENT_SETTINGS_NO_CHANGE_PASSWORD", "URL_EXTENSION", "getURL_EXTENSION", "screenResulution", "getScreenResulution", "setScreenResulution", "(Ljava/lang/String;)V", "getScreenRes", "setScreenRes", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AppConstants.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getURL_EXTENSION() {
            return AppConstants.URL_EXTENSION;
        }

        @NotNull
        public final String getScreenResulution() {
            return AppConstants.access$getScreenResulution$cp();
        }

        public final void setScreenResulution(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            AppConstants.screenResulution = str;
        }

        @NotNull
        public final List<Integer> getASSIGNMENT_DETAIL_TITLES() {
            return AppConstants.ASSIGNMENT_DETAIL_TITLES;
        }

        @NotNull
        public final List<String> getDEMOGRAPHICS_DETAILS() {
            return AppConstants.DEMOGRAPHICS_DETAILS;
        }

        public final int getPERMISSIONS_REQUEST_CAMERA() {
            return AppConstants.PERMISSIONS_REQUEST_CAMERA;
        }

        @NotNull
        public final Set<String> getSTUDENT_SETTINGS() {
            return AppConstants.STUDENT_SETTINGS;
        }

        @NotNull
        public final Set<String> getPARENT_SETTINGS() {
            return AppConstants.PARENT_SETTINGS;
        }

        @NotNull
        public final Set<String> getSTUDENT_SETTINGS_NO_CHANGE_PASSWORD() {
            return AppConstants.STUDENT_SETTINGS_NO_CHANGE_PASSWORD;
        }

        @NotNull
        public final Set<String> getPARENT_SETTINGS_NO_CHANGE_PASSWORD() {
            return AppConstants.PARENT_SETTINGS_NO_CHANGE_PASSWORD;
        }

        @NotNull
        public final Set<String> getDISTRICT_SETTINGS() {
            return AppConstants.DISTRICT_SETTINGS;
        }

        @NotNull
        public final Set<String> getDISTRICT_SETTINGS_ONE_DISTRICT() {
            return AppConstants.DISTRICT_SETTINGS_ONE_DISTRICT;
        }

        @NotNull
        public final Set<String> getABOUT_SETTINGS() {
            return AppConstants.ABOUT_SETTINGS;
        }

        @NotNull
        public final String getANALYTICS_URL() {
            return AppConstants.ANALYTICS_URL;
        }

        @NotNull
        public final String getFAKE_URL() {
            return AppConstants.FAKE_URL;
        }

        public final void setScreenRes(@NotNull DisplayMetrics displayMetrics) {
            Intrinsics.checkParameterIsNotNull(displayMetrics, "displayMetrics");
            Companion companion = this;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(displayMetrics.widthPixels));
            stringBuilder.append("X");
            stringBuilder.append(String.valueOf(displayMetrics.heightPixels));
            setScreenResulution(stringBuilder.toString());
        }

        @NotNull
        public final String getScreenRes() {
            return getScreenResulution();
        }
    }

    @NotNull
    public static final /* synthetic */ String access$getScreenResulution$cp() {
        String str = screenResulution;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenResulution");
        }
        return str;
    }
}
