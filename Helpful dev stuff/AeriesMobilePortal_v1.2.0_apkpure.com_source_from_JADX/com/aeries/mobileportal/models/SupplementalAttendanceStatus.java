package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BA\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u001d\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eHÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eHÆ\u0001J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\t\u0010$\u001a\u00020\bHÖ\u0001J\u0018\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0006H\u0016R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\n\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R*\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2 = {"Lcom/aeries/mobileportal/models/SupplementalAttendanceStatus;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "studentId", "", "status", "", "message", "messageType", "sessions", "Ljava/util/ArrayList;", "Lcom/aeries/mobileportal/models/Session;", "Lkotlin/collections/ArrayList;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getMessage", "()Ljava/lang/String;", "getMessageType", "getSessions", "()Ljava/util/ArrayList;", "getStatus", "getStudentId", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SupplementalAttendanceStatus.kt */
public final class SupplementalAttendanceStatus implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("Message")
    @NotNull
    @Expose
    private final String message;
    @SerializedName("MessageType")
    @NotNull
    @Expose
    private final String messageType;
    @Nullable
    @SerializedName("SupplementalAttendanceSession")
    @Expose
    private final ArrayList<Session> sessions;
    @SerializedName("Status")
    @NotNull
    @Expose
    private final String status;
    @SerializedName("StudentID")
    @Expose
    private final int studentId;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/SupplementalAttendanceStatus$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/SupplementalAttendanceStatus;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/SupplementalAttendanceStatus;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SupplementalAttendanceStatus.kt */
    public static final class CREATOR implements Creator<SupplementalAttendanceStatus> {
        private CREATOR() {
        }

        @NotNull
        public SupplementalAttendanceStatus createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new SupplementalAttendanceStatus(parcel);
        }

        @NotNull
        public SupplementalAttendanceStatus[] newArray(int i) {
            return new SupplementalAttendanceStatus[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ SupplementalAttendanceStatus copy$default(SupplementalAttendanceStatus supplementalAttendanceStatus, int i, String str, String str2, String str3, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = supplementalAttendanceStatus.studentId;
        }
        if ((i2 & 2) != 0) {
            str = supplementalAttendanceStatus.status;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = supplementalAttendanceStatus.message;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = supplementalAttendanceStatus.messageType;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            arrayList = supplementalAttendanceStatus.sessions;
        }
        return supplementalAttendanceStatus.copy(i, str4, str5, str6, arrayList);
    }

    public final int component1() {
        return this.studentId;
    }

    @NotNull
    public final String component2() {
        return this.status;
    }

    @NotNull
    public final String component3() {
        return this.message;
    }

    @NotNull
    public final String component4() {
        return this.messageType;
    }

    @Nullable
    public final ArrayList<Session> component5() {
        return this.sessions;
    }

    @NotNull
    public final SupplementalAttendanceStatus copy(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable ArrayList<Session> arrayList) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        Intrinsics.checkParameterIsNotNull(str2, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Intrinsics.checkParameterIsNotNull(str3, "messageType");
        return new SupplementalAttendanceStatus(i, str, str2, str3, arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SupplementalAttendanceStatus) {
                SupplementalAttendanceStatus supplementalAttendanceStatus = (SupplementalAttendanceStatus) obj;
                if ((this.studentId == supplementalAttendanceStatus.studentId) && Intrinsics.areEqual(this.status, supplementalAttendanceStatus.status) && Intrinsics.areEqual(this.message, supplementalAttendanceStatus.message) && Intrinsics.areEqual(this.messageType, supplementalAttendanceStatus.messageType) && Intrinsics.areEqual(this.sessions, supplementalAttendanceStatus.sessions)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.studentId * 31;
        String str = this.status;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.message;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.messageType;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        ArrayList arrayList = this.sessions;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SupplementalAttendanceStatus(studentId=");
        stringBuilder.append(this.studentId);
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", message=");
        stringBuilder.append(this.message);
        stringBuilder.append(", messageType=");
        stringBuilder.append(this.messageType);
        stringBuilder.append(", sessions=");
        stringBuilder.append(this.sessions);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public SupplementalAttendanceStatus(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable ArrayList<Session> arrayList) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        Intrinsics.checkParameterIsNotNull(str2, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Intrinsics.checkParameterIsNotNull(str3, "messageType");
        this.studentId = i;
        this.status = str;
        this.message = str2;
        this.messageType = str3;
        this.sessions = arrayList;
    }

    public final int getStudentId() {
        return this.studentId;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final String getMessageType() {
        return this.messageType;
    }

    @Nullable
    public final ArrayList<Session> getSessions() {
        return this.sessions;
    }

    public SupplementalAttendanceStatus(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        int readInt = parcel.readInt();
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        String readString2 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString2, "parcel.readString()");
        String readString3 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString3, "parcel.readString()");
        this(readInt, readString, readString2, readString3, parcel.createTypedArrayList(Session.CREATOR));
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeInt(this.studentId);
        parcel.writeString(this.status);
        parcel.writeString(this.message);
        parcel.writeString(this.messageType);
        parcel.writeTypedList((List) this.sessions);
    }
}
