package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\rH\u0016R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/aeries/mobileportal/models/ForgotPasswordRequest;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "emailAddress", "", "(Ljava/lang/String;)V", "getEmailAddress", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ForgotPasswordRequest.kt */
public final class ForgotPasswordRequest implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("emailaddress")
    @NotNull
    @Expose
    private final String emailAddress;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/ForgotPasswordRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/ForgotPasswordRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/ForgotPasswordRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ForgotPasswordRequest.kt */
    public static final class CREATOR implements Creator<ForgotPasswordRequest> {
        private CREATOR() {
        }

        @NotNull
        public ForgotPasswordRequest createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new ForgotPasswordRequest(parcel);
        }

        @NotNull
        public ForgotPasswordRequest[] newArray(int i) {
            return new ForgotPasswordRequest[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ ForgotPasswordRequest copy$default(ForgotPasswordRequest forgotPasswordRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = forgotPasswordRequest.emailAddress;
        }
        return forgotPasswordRequest.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.emailAddress;
    }

    @NotNull
    public final ForgotPasswordRequest copy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "emailAddress");
        return new ForgotPasswordRequest(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ForgotPasswordRequest) {
                if (Intrinsics.areEqual(this.emailAddress, ((ForgotPasswordRequest) obj).emailAddress)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.emailAddress;
        return str != null ? str.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ForgotPasswordRequest(emailAddress=");
        stringBuilder.append(this.emailAddress);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ForgotPasswordRequest(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "emailAddress");
        this.emailAddress = str;
    }

    @NotNull
    public final String getEmailAddress() {
        return this.emailAddress;
    }

    public ForgotPasswordRequest(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        this(readString);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.emailAddress);
    }
}
