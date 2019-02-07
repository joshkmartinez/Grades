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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BC\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003JU\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0001J\b\u0010#\u001a\u00020\u0006H\u0016J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\t\u0010)\u001a\u00020\tHÖ\u0001J\u0018\u0010*\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0006H\u0016R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\f\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014¨\u0006."}, d2 = {"Lcom/aeries/mobileportal/models/SupplementalAttendanceSession;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "schoolCode", "", "sessionID", "sessionName", "", "startTime", "endTime", "room", "details", "", "Lcom/aeries/mobileportal/models/SupplementalAttendanceDetail;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getDetails", "()Ljava/util/List;", "getEndTime", "()Ljava/lang/String;", "getRoom", "getSchoolCode", "()I", "getSessionID", "getSessionName", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SupplementalAttendanceSession.kt */
public final class SupplementalAttendanceSession implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("SupplementalAttendanceDetails")
    @NotNull
    @Expose
    private final List<SupplementalAttendanceDetail> details;
    @SerializedName("EndTime")
    @NotNull
    @Expose
    private final String endTime;
    @SerializedName("Room")
    @NotNull
    @Expose
    private final String room;
    @SerializedName("SchoolCode")
    @Expose
    private final int schoolCode;
    @SerializedName("SessionID")
    @Expose
    private final int sessionID;
    @SerializedName("SessionName")
    @NotNull
    @Expose
    private final String sessionName;
    @SerializedName("StartTime")
    @NotNull
    @Expose
    private final String startTime;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/SupplementalAttendanceSession$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/SupplementalAttendanceSession;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/SupplementalAttendanceSession;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SupplementalAttendanceSession.kt */
    public static final class CREATOR implements Creator<SupplementalAttendanceSession> {
        private CREATOR() {
        }

        @NotNull
        public SupplementalAttendanceSession createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new SupplementalAttendanceSession(parcel);
        }

        @NotNull
        public SupplementalAttendanceSession[] newArray(int i) {
            return new SupplementalAttendanceSession[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ SupplementalAttendanceSession copy$default(SupplementalAttendanceSession supplementalAttendanceSession, int i, int i2, String str, String str2, String str3, String str4, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = supplementalAttendanceSession.schoolCode;
        }
        if ((i3 & 2) != 0) {
            i2 = supplementalAttendanceSession.sessionID;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = supplementalAttendanceSession.sessionName;
        }
        String str5 = str;
        if ((i3 & 8) != 0) {
            str2 = supplementalAttendanceSession.startTime;
        }
        String str6 = str2;
        if ((i3 & 16) != 0) {
            str3 = supplementalAttendanceSession.endTime;
        }
        String str7 = str3;
        if ((i3 & 32) != 0) {
            str4 = supplementalAttendanceSession.room;
        }
        String str8 = str4;
        if ((i3 & 64) != 0) {
            list = supplementalAttendanceSession.details;
        }
        return supplementalAttendanceSession.copy(i, i4, str5, str6, str7, str8, list);
    }

    public final int component1() {
        return this.schoolCode;
    }

    public final int component2() {
        return this.sessionID;
    }

    @NotNull
    public final String component3() {
        return this.sessionName;
    }

    @NotNull
    public final String component4() {
        return this.startTime;
    }

    @NotNull
    public final String component5() {
        return this.endTime;
    }

    @NotNull
    public final String component6() {
        return this.room;
    }

    @NotNull
    public final List<SupplementalAttendanceDetail> component7() {
        return this.details;
    }

    @NotNull
    public final SupplementalAttendanceSession copy(int i, int i2, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull List<SupplementalAttendanceDetail> list) {
        String str5 = str;
        Intrinsics.checkParameterIsNotNull(str5, "sessionName");
        String str6 = str2;
        Intrinsics.checkParameterIsNotNull(str6, "startTime");
        String str7 = str3;
        Intrinsics.checkParameterIsNotNull(str7, "endTime");
        String str8 = str4;
        Intrinsics.checkParameterIsNotNull(str8, "room");
        List<SupplementalAttendanceDetail> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "details");
        return new SupplementalAttendanceSession(i, i2, str5, str6, str7, str8, list2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SupplementalAttendanceSession) {
                SupplementalAttendanceSession supplementalAttendanceSession = (SupplementalAttendanceSession) obj;
                if (this.schoolCode == supplementalAttendanceSession.schoolCode) {
                    if ((this.sessionID == supplementalAttendanceSession.sessionID) && Intrinsics.areEqual(this.sessionName, supplementalAttendanceSession.sessionName) && Intrinsics.areEqual(this.startTime, supplementalAttendanceSession.startTime) && Intrinsics.areEqual(this.endTime, supplementalAttendanceSession.endTime) && Intrinsics.areEqual(this.room, supplementalAttendanceSession.room) && Intrinsics.areEqual(this.details, supplementalAttendanceSession.details)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = ((this.schoolCode * 31) + this.sessionID) * 31;
        String str = this.sessionName;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.startTime;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.endTime;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.room;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        List list = this.details;
        if (list != null) {
            i2 = list.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SupplementalAttendanceSession(schoolCode=");
        stringBuilder.append(this.schoolCode);
        stringBuilder.append(", sessionID=");
        stringBuilder.append(this.sessionID);
        stringBuilder.append(", sessionName=");
        stringBuilder.append(this.sessionName);
        stringBuilder.append(", startTime=");
        stringBuilder.append(this.startTime);
        stringBuilder.append(", endTime=");
        stringBuilder.append(this.endTime);
        stringBuilder.append(", room=");
        stringBuilder.append(this.room);
        stringBuilder.append(", details=");
        stringBuilder.append(this.details);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public SupplementalAttendanceSession(int i, int i2, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull List<SupplementalAttendanceDetail> list) {
        Intrinsics.checkParameterIsNotNull(str, "sessionName");
        Intrinsics.checkParameterIsNotNull(str2, "startTime");
        Intrinsics.checkParameterIsNotNull(str3, "endTime");
        Intrinsics.checkParameterIsNotNull(str4, "room");
        Intrinsics.checkParameterIsNotNull(list, "details");
        this.schoolCode = i;
        this.sessionID = i2;
        this.sessionName = str;
        this.startTime = str2;
        this.endTime = str3;
        this.room = str4;
        this.details = list;
    }

    public final int getSchoolCode() {
        return this.schoolCode;
    }

    public final int getSessionID() {
        return this.sessionID;
    }

    @NotNull
    public final String getSessionName() {
        return this.sessionName;
    }

    @NotNull
    public final String getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final String getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getRoom() {
        return this.room;
    }

    @NotNull
    public final List<SupplementalAttendanceDetail> getDetails() {
        return this.details;
    }

    public SupplementalAttendanceSession(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        String readString2 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString2, "parcel.readString()");
        String readString3 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString3, "parcel.readString()");
        String readString4 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString4, "parcel.readString()");
        parcel = parcel.createTypedArrayList(SupplementalAttendanceDetail.CREATOR);
        Intrinsics.checkExpressionValueIsNotNull(parcel, "parcel.createTypedArrayL…lementalAttendanceDetail)");
        this(readInt, readInt2, readString, readString2, readString3, readString4, (List) parcel);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeInt(this.schoolCode);
        parcel.writeInt(this.sessionID);
        parcel.writeString(this.sessionName);
        parcel.writeString(this.startTime);
        parcel.writeString(this.endTime);
        parcel.writeString(this.room);
        parcel.writeTypedList(this.details);
    }
}
