package com.aeries.mobileportal.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010¨\u0006!"}, d2 = {"Lcom/aeries/mobileportal/models/CheckInOutRequest;", "", "studentID", "", "schoolCode", "room", "", "sessionID", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getRoom", "()Ljava/lang/String;", "setRoom", "(Ljava/lang/String;)V", "getSchoolCode", "()Ljava/lang/Integer;", "setSchoolCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSessionID", "setSessionID", "getStudentID", "setStudentID", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/aeries/mobileportal/models/CheckInOutRequest;", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CheckInOutRequest.kt */
public final class CheckInOutRequest {
    @SerializedName("Room")
    @Nullable
    @Expose
    private String room;
    @SerializedName("SchoolCode")
    @Nullable
    @Expose
    private Integer schoolCode;
    @SerializedName("SessionID")
    @Nullable
    @Expose
    private Integer sessionID;
    @SerializedName("StudentID")
    @Nullable
    @Expose
    private Integer studentID;

    @NotNull
    public static /* bridge */ /* synthetic */ CheckInOutRequest copy$default(CheckInOutRequest checkInOutRequest, Integer num, Integer num2, String str, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = checkInOutRequest.studentID;
        }
        if ((i & 2) != 0) {
            num2 = checkInOutRequest.schoolCode;
        }
        if ((i & 4) != 0) {
            str = checkInOutRequest.room;
        }
        if ((i & 8) != 0) {
            num3 = checkInOutRequest.sessionID;
        }
        return checkInOutRequest.copy(num, num2, str, num3);
    }

    @Nullable
    public final Integer component1() {
        return this.studentID;
    }

    @Nullable
    public final Integer component2() {
        return this.schoolCode;
    }

    @Nullable
    public final String component3() {
        return this.room;
    }

    @Nullable
    public final Integer component4() {
        return this.sessionID;
    }

    @NotNull
    public final CheckInOutRequest copy(@Nullable Integer num, @Nullable Integer num2, @Nullable String str, @Nullable Integer num3) {
        return new CheckInOutRequest(num, num2, str, num3);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CheckInOutRequest) {
                CheckInOutRequest checkInOutRequest = (CheckInOutRequest) obj;
                if (Intrinsics.areEqual(this.studentID, checkInOutRequest.studentID) && Intrinsics.areEqual(this.schoolCode, checkInOutRequest.schoolCode) && Intrinsics.areEqual(this.room, checkInOutRequest.room) && Intrinsics.areEqual(this.sessionID, checkInOutRequest.sessionID)) {
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
        Integer num2 = this.schoolCode;
        hashCode = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str = this.room;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        num2 = this.sessionID;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CheckInOutRequest(studentID=");
        stringBuilder.append(this.studentID);
        stringBuilder.append(", schoolCode=");
        stringBuilder.append(this.schoolCode);
        stringBuilder.append(", room=");
        stringBuilder.append(this.room);
        stringBuilder.append(", sessionID=");
        stringBuilder.append(this.sessionID);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public CheckInOutRequest(@Nullable Integer num, @Nullable Integer num2, @Nullable String str, @Nullable Integer num3) {
        this.studentID = num;
        this.schoolCode = num2;
        this.room = str;
        this.sessionID = num3;
    }

    @Nullable
    public final Integer getStudentID() {
        return this.studentID;
    }

    public final void setStudentID(@Nullable Integer num) {
        this.studentID = num;
    }

    @Nullable
    public final Integer getSchoolCode() {
        return this.schoolCode;
    }

    public final void setSchoolCode(@Nullable Integer num) {
        this.schoolCode = num;
    }

    @Nullable
    public final String getRoom() {
        return this.room;
    }

    public final void setRoom(@Nullable String str) {
        this.room = str;
    }

    @Nullable
    public final Integer getSessionID() {
        return this.sessionID;
    }

    public final void setSessionID(@Nullable Integer num) {
        this.sessionID = num;
    }
}
