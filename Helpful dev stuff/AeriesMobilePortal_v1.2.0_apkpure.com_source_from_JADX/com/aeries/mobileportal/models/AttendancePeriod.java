package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0006H\u0016R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/aeries/mobileportal/models/AttendancePeriod;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "period", "", "code", "", "description", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getDescription", "getPeriod", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AttendancePeriod.kt */
public final class AttendancePeriod implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("Code")
    @NotNull
    @Expose
    private final String code;
    @SerializedName("Description")
    @NotNull
    @Expose
    private final String description;
    @SerializedName("Period")
    @Expose
    private final int period;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/AttendancePeriod$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/AttendancePeriod;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/AttendancePeriod;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AttendancePeriod.kt */
    public static final class CREATOR implements Creator<AttendancePeriod> {
        private CREATOR() {
        }

        @NotNull
        public AttendancePeriod createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new AttendancePeriod(parcel);
        }

        @NotNull
        public AttendancePeriod[] newArray(int i) {
            return new AttendancePeriod[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ AttendancePeriod copy$default(AttendancePeriod attendancePeriod, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = attendancePeriod.period;
        }
        if ((i2 & 2) != 0) {
            str = attendancePeriod.code;
        }
        if ((i2 & 4) != 0) {
            str2 = attendancePeriod.description;
        }
        return attendancePeriod.copy(i, str, str2);
    }

    public final int component1() {
        return this.period;
    }

    @NotNull
    public final String component2() {
        return this.code;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final AttendancePeriod copy(int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "code");
        Intrinsics.checkParameterIsNotNull(str2, "description");
        return new AttendancePeriod(i, str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof AttendancePeriod) {
                AttendancePeriod attendancePeriod = (AttendancePeriod) obj;
                if ((this.period == attendancePeriod.period) && Intrinsics.areEqual(this.code, attendancePeriod.code) && Intrinsics.areEqual(this.description, attendancePeriod.description)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.period * 31;
        String str = this.code;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.description;
        if (str != null) {
            i2 = str.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AttendancePeriod(period=");
        stringBuilder.append(this.period);
        stringBuilder.append(", code=");
        stringBuilder.append(this.code);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public AttendancePeriod(int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "code");
        Intrinsics.checkParameterIsNotNull(str2, "description");
        this.period = i;
        this.code = str;
        this.description = str2;
    }

    public final int getPeriod() {
        return this.period;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public AttendancePeriod(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        int readInt = parcel.readInt();
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        parcel = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(parcel, "parcel.readString()");
        this(readInt, readString, parcel);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeInt(this.period);
        parcel.writeString(this.code);
        parcel.writeString(this.description);
    }
}
