package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0013H\u0016R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/aeries/mobileportal/models/GenericServiceResponse;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "status", "", "error", "authorizationCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthorizationCode", "()Ljava/lang/String;", "getError", "getStatus", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: GenericServiceResponse.kt */
public final class GenericServiceResponse implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("authorizationCode")
    @NotNull
    @Expose
    private final String authorizationCode;
    @SerializedName("error")
    @NotNull
    @Expose
    private final String error;
    @SerializedName("status")
    @NotNull
    @Expose
    private final String status;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/GenericServiceResponse$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/GenericServiceResponse;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/GenericServiceResponse;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: GenericServiceResponse.kt */
    public static final class CREATOR implements Creator<GenericServiceResponse> {
        private CREATOR() {
        }

        @NotNull
        public GenericServiceResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new GenericServiceResponse(parcel);
        }

        @NotNull
        public GenericServiceResponse[] newArray(int i) {
            return new GenericServiceResponse[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ GenericServiceResponse copy$default(GenericServiceResponse genericServiceResponse, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = genericServiceResponse.status;
        }
        if ((i & 2) != 0) {
            str2 = genericServiceResponse.error;
        }
        if ((i & 4) != 0) {
            str3 = genericServiceResponse.authorizationCode;
        }
        return genericServiceResponse.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.status;
    }

    @NotNull
    public final String component2() {
        return this.error;
    }

    @NotNull
    public final String component3() {
        return this.authorizationCode;
    }

    @NotNull
    public final GenericServiceResponse copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        Intrinsics.checkParameterIsNotNull(str2, "error");
        Intrinsics.checkParameterIsNotNull(str3, "authorizationCode");
        return new GenericServiceResponse(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof GenericServiceResponse) {
                GenericServiceResponse genericServiceResponse = (GenericServiceResponse) obj;
                if (Intrinsics.areEqual(this.status, genericServiceResponse.status) && Intrinsics.areEqual(this.error, genericServiceResponse.error) && Intrinsics.areEqual(this.authorizationCode, genericServiceResponse.authorizationCode)) {
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
        String str2 = this.error;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.authorizationCode;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GenericServiceResponse(status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", error=");
        stringBuilder.append(this.error);
        stringBuilder.append(", authorizationCode=");
        stringBuilder.append(this.authorizationCode);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public GenericServiceResponse(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        Intrinsics.checkParameterIsNotNull(str2, "error");
        Intrinsics.checkParameterIsNotNull(str3, "authorizationCode");
        this.status = str;
        this.error = str2;
        this.authorizationCode = str3;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final String getError() {
        return this.error;
    }

    @NotNull
    public final String getAuthorizationCode() {
        return this.authorizationCode;
    }

    public GenericServiceResponse(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        String readString2 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString2, "parcel.readString()");
        parcel = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(parcel, "parcel.readString()");
        this(readString, readString2, parcel);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.status);
        parcel.writeString(this.error);
        parcel.writeString(this.authorizationCode);
    }
}
