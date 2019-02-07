package com.aeries.mobileportal.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/aeries/mobileportal/models/CheckOutRequest;", "", "studentID", "", "schoolCode", "sessionID", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getSchoolCode", "()Ljava/lang/Integer;", "setSchoolCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSessionID", "setSessionID", "getStudentID", "setStudentID", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/aeries/mobileportal/models/CheckOutRequest;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CheckOutRequest.kt */
public final class CheckOutRequest {
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
    public static /* bridge */ /* synthetic */ CheckOutRequest copy$default(CheckOutRequest checkOutRequest, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = checkOutRequest.studentID;
        }
        if ((i & 2) != 0) {
            num2 = checkOutRequest.schoolCode;
        }
        if ((i & 4) != 0) {
            num3 = checkOutRequest.sessionID;
        }
        return checkOutRequest.copy(num, num2, num3);
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
    public final Integer component3() {
        return this.sessionID;
    }

    @NotNull
    public final CheckOutRequest copy(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        return new CheckOutRequest(num, num2, num3);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CheckOutRequest) {
                CheckOutRequest checkOutRequest = (CheckOutRequest) obj;
                if (Intrinsics.areEqual(this.studentID, checkOutRequest.studentID) && Intrinsics.areEqual(this.schoolCode, checkOutRequest.schoolCode) && Intrinsics.areEqual(this.sessionID, checkOutRequest.sessionID)) {
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
        num2 = this.sessionID;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CheckOutRequest(studentID=");
        stringBuilder.append(this.studentID);
        stringBuilder.append(", schoolCode=");
        stringBuilder.append(this.schoolCode);
        stringBuilder.append(", sessionID=");
        stringBuilder.append(this.sessionID);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public CheckOutRequest(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        this.studentID = num;
        this.schoolCode = num2;
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
    public final Integer getSessionID() {
        return this.sessionID;
    }

    public final void setSessionID(@Nullable Integer num) {
        this.sessionID = num;
    }
}
