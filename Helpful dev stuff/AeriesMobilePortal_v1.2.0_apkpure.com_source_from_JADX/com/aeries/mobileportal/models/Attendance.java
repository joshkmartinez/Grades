package com.aeries.mobileportal.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\"\u0010 \u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015¨\u0006#"}, d2 = {"Lcom/aeries/mobileportal/models/Attendance;", "", "()V", "attendanceDetails", "", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "getAttendanceDetails", "()Ljava/util/List;", "setAttendanceDetails", "(Ljava/util/List;)V", "redFlag", "Lcom/aeries/mobileportal/models/StudentRedFlag;", "getRedFlag", "()Lcom/aeries/mobileportal/models/StudentRedFlag;", "setRedFlag", "(Lcom/aeries/mobileportal/models/StudentRedFlag;)V", "schoolCode", "", "getSchoolCode", "()Ljava/lang/Integer;", "setSchoolCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "schoolName", "", "getSchoolName", "()Ljava/lang/String;", "setSchoolName", "(Ljava/lang/String;)V", "studentAttendanceType", "getStudentAttendanceType", "setStudentAttendanceType", "studentID", "getStudentID", "setStudentID", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: Attendance.kt */
public final class Attendance {
    @Nullable
    @SerializedName("AttendanceDetails")
    @Expose
    private List<AttendanceDetail> attendanceDetails = CollectionsKt.emptyList();
    @SerializedName("StudentRedFlag")
    @Nullable
    @Expose
    private StudentRedFlag redFlag = new StudentRedFlag();
    @SerializedName("SchoolCode")
    @Nullable
    @Expose
    private Integer schoolCode = Integer.valueOf(0);
    @SerializedName("SchoolName")
    @Nullable
    @Expose
    private String schoolName = "";
    @SerializedName("StudentAttendanceType")
    @Nullable
    @Expose
    private Integer studentAttendanceType = Integer.valueOf(0);
    @SerializedName("StudentID")
    @Nullable
    @Expose
    private Integer studentID = Integer.valueOf(0);

    @Nullable
    public final Integer getSchoolCode() {
        return this.schoolCode;
    }

    public final void setSchoolCode(@Nullable Integer num) {
        this.schoolCode = num;
    }

    @Nullable
    public final String getSchoolName() {
        return this.schoolName;
    }

    public final void setSchoolName(@Nullable String str) {
        this.schoolName = str;
    }

    @Nullable
    public final Integer getStudentID() {
        return this.studentID;
    }

    public final void setStudentID(@Nullable Integer num) {
        this.studentID = num;
    }

    @Nullable
    public final Integer getStudentAttendanceType() {
        return this.studentAttendanceType;
    }

    public final void setStudentAttendanceType(@Nullable Integer num) {
        this.studentAttendanceType = num;
    }

    @Nullable
    public final StudentRedFlag getRedFlag() {
        return this.redFlag;
    }

    public final void setRedFlag(@Nullable StudentRedFlag studentRedFlag) {
        this.redFlag = studentRedFlag;
    }

    @Nullable
    public final List<AttendanceDetail> getAttendanceDetails() {
        return this.attendanceDetails;
    }

    public final void setAttendanceDetails(@Nullable List<AttendanceDetail> list) {
        this.attendanceDetails = list;
    }
}
