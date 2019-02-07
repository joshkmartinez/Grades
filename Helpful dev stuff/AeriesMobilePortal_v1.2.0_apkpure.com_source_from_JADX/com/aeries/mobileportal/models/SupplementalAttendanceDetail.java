package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\b\u0010\u001a\u001a\u00020\nH\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\nHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\nH\u0016R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006%"}, d2 = {"Lcom/aeries/mobileportal/models/SupplementalAttendanceDetail;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "attendanceDate", "", "startTime", "endTime", "minutes", "", "sequenceNumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getAttendanceDate", "()Ljava/lang/String;", "getEndTime", "getMinutes", "()I", "getSequenceNumber", "getStartTime", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SupplementalAttendanceDetail.kt */
public final class SupplementalAttendanceDetail implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("AttendanceDate")
    @NotNull
    @Expose
    private final String attendanceDate;
    @SerializedName("EndTime")
    @NotNull
    @Expose
    private final String endTime;
    @SerializedName("Minutes")
    @Expose
    private final int minutes;
    @SerializedName("SequenceNumber")
    @Expose
    private final int sequenceNumber;
    @SerializedName("StartTime")
    @NotNull
    @Expose
    private final String startTime;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/SupplementalAttendanceDetail$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/SupplementalAttendanceDetail;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/SupplementalAttendanceDetail;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SupplementalAttendanceDetail.kt */
    public static final class CREATOR implements Creator<SupplementalAttendanceDetail> {
        private CREATOR() {
        }

        @NotNull
        public SupplementalAttendanceDetail createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new SupplementalAttendanceDetail(parcel);
        }

        @NotNull
        public SupplementalAttendanceDetail[] newArray(int i) {
            return new SupplementalAttendanceDetail[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ SupplementalAttendanceDetail copy$default(SupplementalAttendanceDetail supplementalAttendanceDetail, String str, String str2, String str3, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = supplementalAttendanceDetail.attendanceDate;
        }
        if ((i3 & 2) != 0) {
            str2 = supplementalAttendanceDetail.startTime;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            str3 = supplementalAttendanceDetail.endTime;
        }
        String str5 = str3;
        if ((i3 & 8) != 0) {
            i = supplementalAttendanceDetail.minutes;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = supplementalAttendanceDetail.sequenceNumber;
        }
        return supplementalAttendanceDetail.copy(str, str4, str5, i4, i2);
    }

    @NotNull
    public final String component1() {
        return this.attendanceDate;
    }

    @NotNull
    public final String component2() {
        return this.startTime;
    }

    @NotNull
    public final String component3() {
        return this.endTime;
    }

    public final int component4() {
        return this.minutes;
    }

    public final int component5() {
        return this.sequenceNumber;
    }

    @NotNull
    public final SupplementalAttendanceDetail copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "attendanceDate");
        Intrinsics.checkParameterIsNotNull(str2, "startTime");
        Intrinsics.checkParameterIsNotNull(str3, "endTime");
        return new SupplementalAttendanceDetail(str, str2, str3, i, i2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SupplementalAttendanceDetail) {
                SupplementalAttendanceDetail supplementalAttendanceDetail = (SupplementalAttendanceDetail) obj;
                if (Intrinsics.areEqual(this.attendanceDate, supplementalAttendanceDetail.attendanceDate) && Intrinsics.areEqual(this.startTime, supplementalAttendanceDetail.startTime) && Intrinsics.areEqual(this.endTime, supplementalAttendanceDetail.endTime)) {
                    if (this.minutes == supplementalAttendanceDetail.minutes) {
                        if (this.sequenceNumber == supplementalAttendanceDetail.sequenceNumber) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.attendanceDate;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.startTime;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.endTime;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((hashCode + i) * 31) + this.minutes) * 31) + this.sequenceNumber;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SupplementalAttendanceDetail(attendanceDate=");
        stringBuilder.append(this.attendanceDate);
        stringBuilder.append(", startTime=");
        stringBuilder.append(this.startTime);
        stringBuilder.append(", endTime=");
        stringBuilder.append(this.endTime);
        stringBuilder.append(", minutes=");
        stringBuilder.append(this.minutes);
        stringBuilder.append(", sequenceNumber=");
        stringBuilder.append(this.sequenceNumber);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public SupplementalAttendanceDetail(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "attendanceDate");
        Intrinsics.checkParameterIsNotNull(str2, "startTime");
        Intrinsics.checkParameterIsNotNull(str3, "endTime");
        this.attendanceDate = str;
        this.startTime = str2;
        this.endTime = str3;
        this.minutes = i;
        this.sequenceNumber = i2;
    }

    @NotNull
    public final String getAttendanceDate() {
        return this.attendanceDate;
    }

    @NotNull
    public final String getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final String getEndTime() {
        return this.endTime;
    }

    public final int getMinutes() {
        return this.minutes;
    }

    public final int getSequenceNumber() {
        return this.sequenceNumber;
    }

    public SupplementalAttendanceDetail(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        String readString2 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString2, "parcel.readString()");
        String readString3 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString3, "parcel.readString()");
        this(readString, readString2, readString3, parcel.readInt(), parcel.readInt());
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.attendanceDate);
        parcel.writeString(this.startTime);
        parcel.writeString(this.endTime);
        parcel.writeInt(this.minutes);
        parcel.writeInt(this.sequenceNumber);
    }
}
