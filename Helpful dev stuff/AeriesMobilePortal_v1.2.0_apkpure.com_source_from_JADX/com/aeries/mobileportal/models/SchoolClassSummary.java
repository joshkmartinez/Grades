package com.aeries.mobileportal.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.SchoolClassSummaryRealmProxyInterface;
import io.realm.internal.RealmObjectProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\"\u0010 \u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015¨\u0006#"}, d2 = {"Lcom/aeries/mobileportal/models/SchoolClassSummary;", "Lio/realm/RealmObject;", "()V", "classSummaries", "Lio/realm/RealmList;", "Lcom/aeries/mobileportal/models/ClassSummary;", "getClassSummaries", "()Lio/realm/RealmList;", "setClassSummaries", "(Lio/realm/RealmList;)V", "hideScores", "", "getHideScores", "()Z", "setHideScores", "(Z)V", "schoolCode", "", "getSchoolCode", "()Ljava/lang/Integer;", "setSchoolCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "schoolName", "", "getSchoolName", "()Ljava/lang/String;", "setSchoolName", "(Ljava/lang/String;)V", "showPeriod", "getShowPeriod", "setShowPeriod", "studentID", "getStudentID", "setStudentID", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolClassSummary.kt */
public class SchoolClassSummary extends RealmObject implements SchoolClassSummaryRealmProxyInterface {
    @SerializedName("ClassSummary")
    @NotNull
    @Expose
    private RealmList<ClassSummary> classSummaries;
    @SerializedName("HideScores")
    @Expose
    private boolean hideScores;
    @SerializedName("SchoolCode")
    @Nullable
    @Expose
    private Integer schoolCode;
    @SerializedName("SchoolName")
    @Nullable
    @Expose
    private String schoolName;
    @SerializedName("ShowPeriod")
    @Expose
    private boolean showPeriod;
    @SerializedName("StudentID")
    @Nullable
    @Expose
    private Integer studentID;

    public RealmList realmGet$classSummaries() {
        return this.classSummaries;
    }

    public boolean realmGet$hideScores() {
        return this.hideScores;
    }

    public Integer realmGet$schoolCode() {
        return this.schoolCode;
    }

    public String realmGet$schoolName() {
        return this.schoolName;
    }

    public boolean realmGet$showPeriod() {
        return this.showPeriod;
    }

    public Integer realmGet$studentID() {
        return this.studentID;
    }

    public void realmSet$classSummaries(RealmList realmList) {
        this.classSummaries = realmList;
    }

    public void realmSet$hideScores(boolean z) {
        this.hideScores = z;
    }

    public void realmSet$schoolCode(Integer num) {
        this.schoolCode = num;
    }

    public void realmSet$schoolName(String str) {
        this.schoolName = str;
    }

    public void realmSet$showPeriod(boolean z) {
        this.showPeriod = z;
    }

    public void realmSet$studentID(Integer num) {
        this.studentID = num;
    }

    public SchoolClassSummary() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$schoolCode(Integer.valueOf(0));
        realmSet$schoolName("");
        realmSet$studentID(Integer.valueOf(0));
        realmSet$showPeriod(true);
        realmSet$classSummaries(new RealmList());
    }

    @Nullable
    public final Integer getSchoolCode() {
        return realmGet$schoolCode();
    }

    public final void setSchoolCode(@Nullable Integer num) {
        realmSet$schoolCode(num);
    }

    @Nullable
    public final String getSchoolName() {
        return realmGet$schoolName();
    }

    public final void setSchoolName(@Nullable String str) {
        realmSet$schoolName(str);
    }

    @Nullable
    public final Integer getStudentID() {
        return realmGet$studentID();
    }

    public final void setStudentID(@Nullable Integer num) {
        realmSet$studentID(num);
    }

    public final boolean getShowPeriod() {
        return realmGet$showPeriod();
    }

    public final void setShowPeriod(boolean z) {
        realmSet$showPeriod(z);
    }

    public final boolean getHideScores() {
        return realmGet$hideScores();
    }

    public final void setHideScores(boolean z) {
        realmSet$hideScores(z);
    }

    @NotNull
    public final RealmList<ClassSummary> getClassSummaries() {
        return realmGet$classSummaries();
    }

    public final void setClassSummaries(@NotNull RealmList<ClassSummary> realmList) {
        Intrinsics.checkParameterIsNotNull(realmList, "<set-?>");
        realmSet$classSummaries(realmList);
    }
}
