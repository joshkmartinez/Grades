package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0006H\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/aeries/mobileportal/models/UpdateStudentContactRequest;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "studentID", "", "sequenceNumber", "(II)V", "getSequenceNumber", "()I", "getStudentID", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: UpdateStudentContactRequest.kt */
public final class UpdateStudentContactRequest implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("SequenceNumber")
    @Expose
    private final int sequenceNumber;
    @SerializedName("StudentID")
    @Expose
    private final int studentID;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/UpdateStudentContactRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/UpdateStudentContactRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/UpdateStudentContactRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: UpdateStudentContactRequest.kt */
    public static final class CREATOR implements Creator<UpdateStudentContactRequest> {
        private CREATOR() {
        }

        @NotNull
        public UpdateStudentContactRequest createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new UpdateStudentContactRequest(parcel);
        }

        @NotNull
        public UpdateStudentContactRequest[] newArray(int i) {
            return new UpdateStudentContactRequest[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ UpdateStudentContactRequest copy$default(UpdateStudentContactRequest updateStudentContactRequest, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = updateStudentContactRequest.studentID;
        }
        if ((i3 & 2) != 0) {
            i2 = updateStudentContactRequest.sequenceNumber;
        }
        return updateStudentContactRequest.copy(i, i2);
    }

    public final int component1() {
        return this.studentID;
    }

    public final int component2() {
        return this.sequenceNumber;
    }

    @NotNull
    public final UpdateStudentContactRequest copy(int i, int i2) {
        return new UpdateStudentContactRequest(i, i2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof UpdateStudentContactRequest) {
                UpdateStudentContactRequest updateStudentContactRequest = (UpdateStudentContactRequest) obj;
                if (this.studentID == updateStudentContactRequest.studentID) {
                    if (this.sequenceNumber == updateStudentContactRequest.sequenceNumber) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.studentID * 31) + this.sequenceNumber;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UpdateStudentContactRequest(studentID=");
        stringBuilder.append(this.studentID);
        stringBuilder.append(", sequenceNumber=");
        stringBuilder.append(this.sequenceNumber);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public UpdateStudentContactRequest(int i, int i2) {
        this.studentID = i;
        this.sequenceNumber = i2;
    }

    public final int getStudentID() {
        return this.studentID;
    }

    public final int getSequenceNumber() {
        return this.sequenceNumber;
    }

    public UpdateStudentContactRequest(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this(parcel.readInt(), parcel.readInt());
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeInt(this.studentID);
        parcel.writeInt(this.sequenceNumber);
    }
}
