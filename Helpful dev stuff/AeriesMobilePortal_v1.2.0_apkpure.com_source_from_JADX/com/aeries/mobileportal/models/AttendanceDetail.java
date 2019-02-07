package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010#\u001a\u00020\u001aH\u0016J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u001aH\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR \u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\t\"\u0004\b\"\u0010\u000b¨\u0006("}, d2 = {"Lcom/aeries/mobileportal/models/AttendanceDetail;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "allDayCode", "", "getAllDayCode", "()Ljava/lang/String;", "setAllDayCode", "(Ljava/lang/String;)V", "allDayDescription", "getAllDayDescription", "setAllDayDescription", "attendanceDate", "getAttendanceDate", "setAttendanceDate", "attendancePeriods", "", "Lcom/aeries/mobileportal/models/AttendancePeriod;", "getAttendancePeriods", "()Ljava/util/List;", "setAttendancePeriods", "(Ljava/util/List;)V", "schoolCode", "", "getSchoolCode", "()Ljava/lang/Integer;", "setSchoolCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "schoolName", "getSchoolName", "setSchoolName", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AttendanceDetail.kt */
public final class AttendanceDetail implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("AllDayCode")
    @Nullable
    @Expose
    private String allDayCode;
    @SerializedName("AllDayDescription")
    @Nullable
    @Expose
    private String allDayDescription;
    @SerializedName("AttendanceDate")
    @Nullable
    @Expose
    private String attendanceDate;
    @Nullable
    @SerializedName("AttendancePeriod")
    @Expose
    private List<AttendancePeriod> attendancePeriods;
    @Nullable
    private Integer schoolCode;
    @Nullable
    private String schoolName;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/AttendanceDetail$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/AttendanceDetail;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AttendanceDetail.kt */
    public static final class CREATOR implements Creator<AttendanceDetail> {
        private CREATOR() {
        }

        @NotNull
        public AttendanceDetail createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new AttendanceDetail(parcel);
        }

        @NotNull
        public AttendanceDetail[] newArray(int i) {
            return new AttendanceDetail[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public AttendanceDetail() {
        this.attendanceDate = "";
        this.allDayCode = "";
        this.allDayDescription = "";
        this.attendancePeriods = CollectionsKt.emptyList();
    }

    @Nullable
    public final String getAttendanceDate() {
        return this.attendanceDate;
    }

    public final void setAttendanceDate(@Nullable String str) {
        this.attendanceDate = str;
    }

    @Nullable
    public final String getAllDayCode() {
        return this.allDayCode;
    }

    public final void setAllDayCode(@Nullable String str) {
        this.allDayCode = str;
    }

    @Nullable
    public final String getAllDayDescription() {
        return this.allDayDescription;
    }

    public final void setAllDayDescription(@Nullable String str) {
        this.allDayDescription = str;
    }

    @Nullable
    public final List<AttendancePeriod> getAttendancePeriods() {
        return this.attendancePeriods;
    }

    public final void setAttendancePeriods(@Nullable List<AttendancePeriod> list) {
        this.attendancePeriods = list;
    }

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

    public AttendanceDetail(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this();
        this.attendanceDate = parcel.readString();
        this.allDayCode = parcel.readString();
        this.allDayDescription = parcel.readString();
        this.attendancePeriods = parcel.createTypedArrayList(AttendancePeriod.CREATOR);
        Object readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        this.schoolCode = (Integer) readValue;
        this.schoolName = parcel.readString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.attendanceDate);
        parcel.writeString(this.allDayCode);
        parcel.writeString(this.allDayDescription);
        parcel.writeTypedList(this.attendancePeriods);
        parcel.writeValue(this.schoolCode);
        parcel.writeString(this.schoolName);
    }
}
