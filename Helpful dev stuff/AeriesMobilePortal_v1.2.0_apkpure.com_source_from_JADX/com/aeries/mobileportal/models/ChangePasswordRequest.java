package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B5\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\fHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0013\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001eHÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u001eH\u0016R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006("}, d2 = {"Lcom/aeries/mobileportal/models/ChangePasswordRequest;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "emailAddress", "", "verificationCode", "oldPassword", "password", "confirmedPassword", "requireCodeValidation", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getConfirmedPassword", "()Ljava/lang/String;", "getEmailAddress", "getOldPassword", "getPassword", "getRequireCodeValidation", "()Z", "getVerificationCode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ChangePasswordRequest.kt */
public final class ChangePasswordRequest implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("ConfirmPassword")
    @NotNull
    @Expose
    private final String confirmedPassword;
    @SerializedName("EmailAddress")
    @NotNull
    @Expose
    private final String emailAddress;
    @SerializedName("OldPassword")
    @NotNull
    @Expose
    private final String oldPassword;
    @SerializedName("Password")
    @NotNull
    @Expose
    private final String password;
    @SerializedName("RequireCodeValidation")
    @Expose
    private final boolean requireCodeValidation;
    @SerializedName("VerificationCode")
    @NotNull
    @Expose
    private final String verificationCode;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/ChangePasswordRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/ChangePasswordRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/ChangePasswordRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ChangePasswordRequest.kt */
    public static final class CREATOR implements Creator<ChangePasswordRequest> {
        private CREATOR() {
        }

        @NotNull
        public ChangePasswordRequest createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new ChangePasswordRequest(parcel);
        }

        @NotNull
        public ChangePasswordRequest[] newArray(int i) {
            return new ChangePasswordRequest[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ ChangePasswordRequest copy$default(ChangePasswordRequest changePasswordRequest, String str, String str2, String str3, String str4, String str5, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = changePasswordRequest.emailAddress;
        }
        if ((i & 2) != 0) {
            str2 = changePasswordRequest.verificationCode;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = changePasswordRequest.oldPassword;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = changePasswordRequest.password;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = changePasswordRequest.confirmedPassword;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            z = changePasswordRequest.requireCodeValidation;
        }
        return changePasswordRequest.copy(str, str6, str7, str8, str9, z);
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
    public final String component3() {
        return this.oldPassword;
    }

    @NotNull
    public final String component4() {
        return this.password;
    }

    @NotNull
    public final String component5() {
        return this.confirmedPassword;
    }

    public final boolean component6() {
        return this.requireCodeValidation;
    }

    @NotNull
    public final ChangePasswordRequest copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "emailAddress");
        Intrinsics.checkParameterIsNotNull(str2, "verificationCode");
        Intrinsics.checkParameterIsNotNull(str3, "oldPassword");
        Intrinsics.checkParameterIsNotNull(str4, "password");
        Intrinsics.checkParameterIsNotNull(str5, "confirmedPassword");
        return new ChangePasswordRequest(str, str2, str3, str4, str5, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ChangePasswordRequest) {
                ChangePasswordRequest changePasswordRequest = (ChangePasswordRequest) obj;
                if (Intrinsics.areEqual(this.emailAddress, changePasswordRequest.emailAddress) && Intrinsics.areEqual(this.verificationCode, changePasswordRequest.verificationCode) && Intrinsics.areEqual(this.oldPassword, changePasswordRequest.oldPassword) && Intrinsics.areEqual(this.password, changePasswordRequest.password) && Intrinsics.areEqual(this.confirmedPassword, changePasswordRequest.confirmedPassword)) {
                    if (this.requireCodeValidation == changePasswordRequest.requireCodeValidation) {
                    }
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
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.oldPassword;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.password;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.confirmedPassword;
        if (str2 != null) {
            i = str2.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.requireCodeValidation;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChangePasswordRequest(emailAddress=");
        stringBuilder.append(this.emailAddress);
        stringBuilder.append(", verificationCode=");
        stringBuilder.append(this.verificationCode);
        stringBuilder.append(", oldPassword=");
        stringBuilder.append(this.oldPassword);
        stringBuilder.append(", password=");
        stringBuilder.append(this.password);
        stringBuilder.append(", confirmedPassword=");
        stringBuilder.append(this.confirmedPassword);
        stringBuilder.append(", requireCodeValidation=");
        stringBuilder.append(this.requireCodeValidation);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ChangePasswordRequest(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "emailAddress");
        Intrinsics.checkParameterIsNotNull(str2, "verificationCode");
        Intrinsics.checkParameterIsNotNull(str3, "oldPassword");
        Intrinsics.checkParameterIsNotNull(str4, "password");
        Intrinsics.checkParameterIsNotNull(str5, "confirmedPassword");
        this.emailAddress = str;
        this.verificationCode = str2;
        this.oldPassword = str3;
        this.password = str4;
        this.confirmedPassword = str5;
        this.requireCodeValidation = z;
    }

    @NotNull
    public final String getEmailAddress() {
        return this.emailAddress;
    }

    @NotNull
    public final String getVerificationCode() {
        return this.verificationCode;
    }

    @NotNull
    public final String getOldPassword() {
        return this.oldPassword;
    }

    @NotNull
    public final String getPassword() {
        return this.password;
    }

    @NotNull
    public final String getConfirmedPassword() {
        return this.confirmedPassword;
    }

    public final boolean getRequireCodeValidation() {
        return this.requireCodeValidation;
    }

    public ChangePasswordRequest(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        String readString2 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString2, "parcel.readString()");
        String readString3 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString3, "parcel.readString()");
        String readString4 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString4, "parcel.readString()");
        String readString5 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString5, "parcel.readString()");
        this(readString, readString2, readString3, readString4, readString5, parcel.readByte() != ((byte) null));
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.emailAddress);
        parcel.writeString(this.verificationCode);
        parcel.writeString(this.password);
        parcel.writeString(this.oldPassword);
        parcel.writeString(this.confirmedPassword);
        parcel.writeByte(this.requireCodeValidation);
    }
}
