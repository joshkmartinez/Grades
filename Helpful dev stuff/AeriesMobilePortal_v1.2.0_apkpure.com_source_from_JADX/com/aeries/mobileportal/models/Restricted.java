package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\tHÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0015H\u0016R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/aeries/mobileportal/models/Restricted;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "status", "", "message", "forceLogout", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getForceLogout", "()Z", "getMessage", "()Ljava/lang/String;", "getStatus", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: Restricted.kt */
public final class Restricted implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("forceLogout")
    @Expose
    private final boolean forceLogout;
    @SerializedName("message")
    @Nullable
    @Expose
    private final String message;
    @SerializedName("status")
    @NotNull
    @Expose
    private final String status;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/Restricted$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/Restricted;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/Restricted;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Restricted.kt */
    public static final class CREATOR implements Creator<Restricted> {
        private CREATOR() {
        }

        @NotNull
        public Restricted createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new Restricted(parcel);
        }

        @NotNull
        public Restricted[] newArray(int i) {
            return new Restricted[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Restricted copy$default(Restricted restricted, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = restricted.status;
        }
        if ((i & 2) != 0) {
            str2 = restricted.message;
        }
        if ((i & 4) != 0) {
            z = restricted.forceLogout;
        }
        return restricted.copy(str, str2, z);
    }

    @NotNull
    public final String component1() {
        return this.status;
    }

    @Nullable
    public final String component2() {
        return this.message;
    }

    public final boolean component3() {
        return this.forceLogout;
    }

    @NotNull
    public final Restricted copy(@NotNull String str, @Nullable String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        return new Restricted(str, str2, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Restricted) {
                Restricted restricted = (Restricted) obj;
                if (Intrinsics.areEqual(this.status, restricted.status) && Intrinsics.areEqual(this.message, restricted.message)) {
                    if (this.forceLogout == restricted.forceLogout) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.status;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        if (str2 != null) {
            i = str2.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.forceLogout;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Restricted(status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", message=");
        stringBuilder.append(this.message);
        stringBuilder.append(", forceLogout=");
        stringBuilder.append(this.forceLogout);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Restricted(@NotNull String str, @Nullable String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        this.status = str;
        this.message = str2;
        this.forceLogout = z;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    public final boolean getForceLogout() {
        return this.forceLogout;
    }

    public Restricted(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        String readString2 = parcel.readString();
        boolean z = false;
        if (parcel.readByte() != ((byte) null)) {
            z = true;
        }
        this(readString, readString2, z);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.status);
        parcel.writeString(this.message);
        parcel.writeByte(this.forceLogout);
    }
}
