package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0013H\u0016R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/aeries/mobileportal/models/AccountTakenRequest;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "emailaddress", "", "AccountType", "(Ljava/lang/String;Ljava/lang/String;)V", "getAccountType", "()Ljava/lang/String;", "setAccountType", "(Ljava/lang/String;)V", "getEmailaddress", "setEmailaddress", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AccountTakenRequest.kt */
public final class AccountTakenRequest implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("AccountType")
    @NotNull
    @Expose
    private String AccountType;
    @SerializedName("emailaddress")
    @NotNull
    @Expose
    private String emailaddress;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/AccountTakenRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/AccountTakenRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/AccountTakenRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AccountTakenRequest.kt */
    public static final class CREATOR implements Creator<AccountTakenRequest> {
        private CREATOR() {
        }

        @NotNull
        public AccountTakenRequest createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new AccountTakenRequest(parcel);
        }

        @NotNull
        public AccountTakenRequest[] newArray(int i) {
            return new AccountTakenRequest[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ AccountTakenRequest copy$default(AccountTakenRequest accountTakenRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = accountTakenRequest.emailaddress;
        }
        if ((i & 2) != 0) {
            str2 = accountTakenRequest.AccountType;
        }
        return accountTakenRequest.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.emailaddress;
    }

    @NotNull
    public final String component2() {
        return this.AccountType;
    }

    @NotNull
    public final AccountTakenRequest copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "emailaddress");
        Intrinsics.checkParameterIsNotNull(str2, "AccountType");
        return new AccountTakenRequest(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof AccountTakenRequest) {
                AccountTakenRequest accountTakenRequest = (AccountTakenRequest) obj;
                if (Intrinsics.areEqual(this.emailaddress, accountTakenRequest.emailaddress) && Intrinsics.areEqual(this.AccountType, accountTakenRequest.AccountType)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.emailaddress;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.AccountType;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AccountTakenRequest(emailaddress=");
        stringBuilder.append(this.emailaddress);
        stringBuilder.append(", AccountType=");
        stringBuilder.append(this.AccountType);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public AccountTakenRequest(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "emailaddress");
        Intrinsics.checkParameterIsNotNull(str2, "AccountType");
        this.emailaddress = str;
        this.AccountType = str2;
    }

    @NotNull
    public final String getEmailaddress() {
        return this.emailaddress;
    }

    public final void setEmailaddress(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.emailaddress = str;
    }

    @NotNull
    public final String getAccountType() {
        return this.AccountType;
    }

    public final void setAccountType(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.AccountType = str;
    }

    public AccountTakenRequest(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        parcel = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(parcel, "parcel.readString()");
        this(readString, parcel);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.emailaddress);
        parcel.writeString(this.AccountType);
    }
}
