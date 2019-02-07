package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0010H\u0016R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/aeries/mobileportal/models/ConfirmAccountRequest;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "emailAddress", "", "verificationCode", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmailAddress", "()Ljava/lang/String;", "getVerificationCode", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ConfirmAccountRequest.kt */
public final class ConfirmAccountRequest implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("emailaddress")
    @NotNull
    @Expose
    private final String emailAddress;
    @SerializedName("verificationcode")
    @NotNull
    @Expose
    private final String verificationCode;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/ConfirmAccountRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/ConfirmAccountRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/ConfirmAccountRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ConfirmAccountRequest.kt */
    public static final class CREATOR implements Creator<ConfirmAccountRequest> {
        private CREATOR() {
        }

        @NotNull
        public ConfirmAccountRequest createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new ConfirmAccountRequest(parcel);
        }

        @NotNull
        public ConfirmAccountRequest[] newArray(int i) {
            return new ConfirmAccountRequest[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ ConfirmAccountRequest copy$default(ConfirmAccountRequest confirmAccountRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = confirmAccountRequest.emailAddress;
        }
        if ((i & 2) != 0) {
            str2 = confirmAccountRequest.verificationCode;
        }
        return confirmAccountRequest.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.emailAddress;
    }

    @NotNull
    public final String component2() {
        return this.verificationCode;
    }

    @NotNull
    public final ConfirmAccountRequest copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "emailAddress");
        Intrinsics.checkParameterIsNotNull(str2, "verificationCode");
        return new ConfirmAccountRequest(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ConfirmAccountRequest) {
                ConfirmAccountRequest confirmAccountRequest = (ConfirmAccountRequest) obj;
                if (Intrinsics.areEqual(this.emailAddress, confirmAccountRequest.emailAddress) && Intrinsics.areEqual(this.verificationCode, confirmAccountRequest.verificationCode)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.emailAddress;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.verificationCode;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConfirmAccountRequest(emailAddress=");
        stringBuilder.append(this.emailAddress);
        stringBuilder.append(", verificationCode=");
        stringBuilder.append(this.verificationCode);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ConfirmAccountRequest(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "emailAddress");
        Intrinsics.checkParameterIsNotNull(str2, "verificationCode");
        this.emailAddress = str;
        this.verificationCode = str2;
    }

    @NotNull
    public final String getEmailAddress() {
        return this.emailAddress;
    }

    @NotNull
    public final String getVerificationCode() {
        return this.verificationCode;
    }

    public ConfirmAccountRequest(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        parcel = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(parcel, "parcel.readString()");
        this(readString, parcel);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.emailAddress);
        parcel.writeString(this.verificationCode);
    }
}
