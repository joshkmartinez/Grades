package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B=\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003JP\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0006H\u0016J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020\bHÖ\u0001J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0006H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006*"}, d2 = {"Lcom/aeries/mobileportal/models/SupplementalAttendance;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "studentID", "", "status", "", "message", "attendanceStatus", "sessions", "", "Lcom/aeries/mobileportal/models/SupplementalAttendanceSession;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAttendanceStatus", "()Ljava/lang/String;", "getMessage", "getSessions", "()Ljava/util/List;", "getStatus", "getStudentID", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/aeries/mobileportal/models/SupplementalAttendance;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SupplementalAttendance.kt */
public final class SupplementalAttendance implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("AttendanceStatus")
    @Nullable
    @Expose
    private final String attendanceStatus;
    @SerializedName("Message")
    @Nullable
    @Expose
    private final String message;
    @Nullable
    @SerializedName("SupplementalAttendanceSession")
    @Expose
    private final List<SupplementalAttendanceSession> sessions;
    @SerializedName("Status")
    @Nullable
    @Expose
    private final String status;
    @SerializedName("StudentID")
    @Nullable
    @Expose
    private final Integer studentID;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/SupplementalAttendance$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/SupplementalAttendance;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/SupplementalAttendance;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SupplementalAttendance.kt */
    public static final class CREATOR implements Creator<SupplementalAttendance> {
        private CREATOR() {
        }

        @NotNull
        public SupplementalAttendance createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new SupplementalAttendance(parcel);
        }

        @NotNull
        public SupplementalAttendance[] newArray(int i) {
            return new SupplementalAttendance[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ SupplementalAttendance copy$default(SupplementalAttendance supplementalAttendance, Integer num, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = supplementalAttendance.studentID;
        }
        if ((i & 2) != 0) {
            str = supplementalAttendance.status;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = supplementalAttendance.message;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = supplementalAttendance.attendanceStatus;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            list = supplementalAttendance.sessions;
        }
        return supplementalAttendance.copy(num, str4, str5, str6, list);
    }

    @Nullable
    public final Integer component1() {
        return this.studentID;
    }

    @Nullable
    public final String component2() {
        return this.status;
    }

    @Nullable
    public final String component3() {
        return this.message;
    }

    @Nullable
    public final String component4() {
        return this.attendanceStatus;
    }

    @Nullable
    public final List<SupplementalAttendanceSession> component5() {
        return this.sessions;
    }

    @NotNull
    public final SupplementalAttendance copy(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable List<SupplementalAttendanceSession> list) {
        return new SupplementalAttendance(num, str, str2, str3, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SupplementalAttendance) {
                SupplementalAttendance supplementalAttendance = (SupplementalAttendance) obj;
                if (Intrinsics.areEqual(this.studentID, supplementalAttendance.studentID) && Intrinsics.areEqual(this.status, supplementalAttendance.status) && Intrinsics.areEqual(this.message, supplementalAttendance.message) && Intrinsics.areEqual(this.attendanceStatus, supplementalAttendance.attendanceStatus) && Intrinsics.areEqual(this.sessions, supplementalAttendance.sessions)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.studentID;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.status;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.message;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.attendanceStatus;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List list = this.sessions;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SupplementalAttendance(studentID=");
        stringBuilder.append(this.studentID);
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", message=");
        stringBuilder.append(this.message);
        stringBuilder.append(", attendanceStatus=");
        stringBuilder.append(this.attendanceStatus);
        stringBuilder.append(", sessions=");
        stringBuilder.append(this.sessions);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public SupplementalAttendance(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable List<SupplementalAttendanceSession> list) {
        this.studentID = num;
        this.status = str;
        this.message = str2;
        this.attendanceStatus = str3;
        this.sessions = list;
    }

    @Nullable
    public final Integer getStudentID() {
        return this.studentID;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getAttendanceStatus() {
        return this.attendanceStatus;
    }

    @Nullable
    public final List<SupplementalAttendanceSession> getSessions() {
        return this.sessions;
    }

    public SupplementalAttendance(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Object readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        this((Integer) readValue, parcel.readString(), parcel.readString(), parcel.readString(), parcel.createTypedArrayList(SupplementalAttendanceSession.CREATOR));
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeValue(this.studentID);
        parcel.writeString(this.status);
        parcel.writeString(this.message);
        parcel.writeString(this.attendanceStatus);
        parcel.writeTypedList(this.sessions);
    }
}
