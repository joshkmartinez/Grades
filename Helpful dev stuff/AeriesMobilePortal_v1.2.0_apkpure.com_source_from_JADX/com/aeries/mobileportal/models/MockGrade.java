package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/aeries/mobileportal/models/MockGrade;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mark", "", "percent", "", "(Ljava/lang/String;D)V", "getMark", "()Ljava/lang/String;", "getPercent", "()D", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: MockGrade.kt */
public final class MockGrade implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("Mark")
    @NotNull
    @Expose
    private final String mark;
    @SerializedName("Percent")
    @Expose
    private final double percent;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/MockGrade$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/MockGrade;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/MockGrade;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: MockGrade.kt */
    public static final class CREATOR implements Creator<MockGrade> {
        private CREATOR() {
        }

        @NotNull
        public MockGrade createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new MockGrade(parcel);
        }

        @NotNull
        public MockGrade[] newArray(int i) {
            return new MockGrade[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ MockGrade copy$default(MockGrade mockGrade, String str, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mockGrade.mark;
        }
        if ((i & 2) != 0) {
            d = mockGrade.percent;
        }
        return mockGrade.copy(str, d);
    }

    @NotNull
    public final String component1() {
        return this.mark;
    }

    public final double component2() {
        return this.percent;
    }

    @NotNull
    public final MockGrade copy(@NotNull String str, double d) {
        Intrinsics.checkParameterIsNotNull(str, "mark");
        return new MockGrade(str, d);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MockGrade) {
                MockGrade mockGrade = (MockGrade) obj;
                if (Intrinsics.areEqual(this.mark, mockGrade.mark) && Double.compare(this.percent, mockGrade.percent) == 0) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.mark;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.percent);
        return hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MockGrade(mark=");
        stringBuilder.append(this.mark);
        stringBuilder.append(", percent=");
        stringBuilder.append(this.percent);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public MockGrade(@NotNull String str, double d) {
        Intrinsics.checkParameterIsNotNull(str, "mark");
        this.mark = str;
        this.percent = d;
    }

    @NotNull
    public final String getMark() {
        return this.mark;
    }

    public final double getPercent() {
        return this.percent;
    }

    public MockGrade(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        this(readString, parcel.readDouble());
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.mark);
        parcel.writeDouble(this.percent);
    }
}
