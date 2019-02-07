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

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J.\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0017H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006!"}, d2 = {"Lcom/aeries/mobileportal/models/AccountTakenResponse;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "status", "", "requirePassword", "", "error", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getRequirePassword", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStatus", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/aeries/mobileportal/models/AccountTakenResponse;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AccountTakenResponse.kt */
public final class AccountTakenResponse implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("error")
    @NotNull
    @Expose
    private final String error;
    @SerializedName("requirePassword")
    @Nullable
    @Expose
    private final Boolean requirePassword;
    @SerializedName("status")
    @NotNull
    @Expose
    private final String status;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/AccountTakenResponse$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/AccountTakenResponse;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/AccountTakenResponse;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AccountTakenResponse.kt */
    public static final class CREATOR implements Creator<AccountTakenResponse> {
        private CREATOR() {
        }

        @NotNull
        public AccountTakenResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new AccountTakenResponse(parcel);
        }

        @NotNull
        public AccountTakenResponse[] newArray(int i) {
            return new AccountTakenResponse[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ AccountTakenResponse copy$default(AccountTakenResponse accountTakenResponse, String str, Boolean bool, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = accountTakenResponse.status;
        }
        if ((i & 2) != 0) {
            bool = accountTakenResponse.requirePassword;
        }
        if ((i & 4) != 0) {
            str2 = accountTakenResponse.error;
        }
        return accountTakenResponse.copy(str, bool, str2);
    }

    @NotNull
    public final String component1() {
        return this.status;
    }

    @Nullable
    public final Boolean component2() {
        return this.requirePassword;
    }

    @NotNull
    public final String component3() {
        return this.error;
    }

    @NotNull
    public final AccountTakenResponse copy(@NotNull String str, @Nullable Boolean bool, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        Intrinsics.checkParameterIsNotNull(str2, "error");
        return new AccountTakenResponse(str, bool, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof AccountTakenResponse) {
                AccountTakenResponse accountTakenResponse = (AccountTakenResponse) obj;
                if (Intrinsics.areEqual(this.status, accountTakenResponse.status) && Intrinsics.areEqual(this.requirePassword, accountTakenResponse.requirePassword) && Intrinsics.areEqual(this.error, accountTakenResponse.error)) {
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
        Boolean bool = this.requirePassword;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        String str2 = this.error;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AccountTakenResponse(status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", requirePassword=");
        stringBuilder.append(this.requirePassword);
        stringBuilder.append(", error=");
        stringBuilder.append(this.error);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public AccountTakenResponse(@NotNull String str, @Nullable Boolean bool, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        Intrinsics.checkParameterIsNotNull(str2, "error");
        this.status = str;
        this.requirePassword = bool;
        this.error = str2;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final Boolean getRequirePassword() {
        return this.requirePassword;
    }

    @NotNull
    public final String getError() {
        return this.error;
    }

    public AccountTakenResponse(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        Object readValue = parcel.readValue(Boolean.TYPE.getClassLoader());
        if (!(readValue instanceof Boolean)) {
            readValue = null;
        }
        Boolean bool = (Boolean) readValue;
        parcel = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(parcel, "parcel.readString()");
        this(readString, bool, parcel);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.status);
        parcel.writeValue(this.requirePassword);
        parcel.writeString(this.error);
    }
}
