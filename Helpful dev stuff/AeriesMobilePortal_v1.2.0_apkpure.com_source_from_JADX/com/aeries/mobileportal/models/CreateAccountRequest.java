package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B5\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u001cH\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006'"}, d2 = {"Lcom/aeries/mobileportal/models/CreateAccountRequest;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "emailaddress", "", "accountType", "password", "confirmPassword", "lastName", "firstName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountType", "()Ljava/lang/String;", "getConfirmPassword", "getEmailaddress", "getFirstName", "getLastName", "getPassword", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CreateAccountRequest.kt */
public final class CreateAccountRequest implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("AccountType")
    @NotNull
    @Expose
    private final String accountType;
    @SerializedName("ConfirmPassword")
    @NotNull
    @Expose
    private final String confirmPassword;
    @SerializedName("emailaddress")
    @NotNull
    @Expose
    private final String emailaddress;
    @SerializedName("FirstName")
    @NotNull
    @Expose
    private final String firstName;
    @SerializedName("Lastname")
    @NotNull
    @Expose
    private final String lastName;
    @SerializedName("Password")
    @NotNull
    @Expose
    private final String password;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/CreateAccountRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/CreateAccountRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/CreateAccountRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: CreateAccountRequest.kt */
    public static final class CREATOR implements Creator<CreateAccountRequest> {
        private CREATOR() {
        }

        @NotNull
        public CreateAccountRequest createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new CreateAccountRequest(parcel);
        }

        @NotNull
        public CreateAccountRequest[] newArray(int i) {
            return new CreateAccountRequest[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ CreateAccountRequest copy$default(CreateAccountRequest createAccountRequest, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createAccountRequest.emailaddress;
        }
        if ((i & 2) != 0) {
            str2 = createAccountRequest.accountType;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = createAccountRequest.password;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = createAccountRequest.confirmPassword;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = createAccountRequest.lastName;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = createAccountRequest.firstName;
        }
        return createAccountRequest.copy(str, str7, str8, str9, str10, str6);
    }

    @NotNull
    public final String component1() {
        return this.emailaddress;
    }

    @NotNull
    public final String component2() {
        return this.accountType;
    }

    @NotNull
    public final String component3() {
        return this.password;
    }

    @NotNull
    public final String component4() {
        return this.confirmPassword;
    }

    @NotNull
    public final String component5() {
        return this.lastName;
    }

    @NotNull
    public final String component6() {
        return this.firstName;
    }

    @NotNull
    public final CreateAccountRequest copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkParameterIsNotNull(str, "emailaddress");
        Intrinsics.checkParameterIsNotNull(str2, "accountType");
        Intrinsics.checkParameterIsNotNull(str3, "password");
        Intrinsics.checkParameterIsNotNull(str4, "confirmPassword");
        Intrinsics.checkParameterIsNotNull(str5, "lastName");
        Intrinsics.checkParameterIsNotNull(str6, "firstName");
        return new CreateAccountRequest(str, str2, str3, str4, str5, str6);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CreateAccountRequest) {
                CreateAccountRequest createAccountRequest = (CreateAccountRequest) obj;
                if (Intrinsics.areEqual(this.emailaddress, createAccountRequest.emailaddress) && Intrinsics.areEqual(this.accountType, createAccountRequest.accountType) && Intrinsics.areEqual(this.password, createAccountRequest.password) && Intrinsics.areEqual(this.confirmPassword, createAccountRequest.confirmPassword) && Intrinsics.areEqual(this.lastName, createAccountRequest.lastName) && Intrinsics.areEqual(this.firstName, createAccountRequest.firstName)) {
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
        String str2 = this.accountType;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.password;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.confirmPassword;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.lastName;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.firstName;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CreateAccountRequest(emailaddress=");
        stringBuilder.append(this.emailaddress);
        stringBuilder.append(", accountType=");
        stringBuilder.append(this.accountType);
        stringBuilder.append(", password=");
        stringBuilder.append(this.password);
        stringBuilder.append(", confirmPassword=");
        stringBuilder.append(this.confirmPassword);
        stringBuilder.append(", lastName=");
        stringBuilder.append(this.lastName);
        stringBuilder.append(", firstName=");
        stringBuilder.append(this.firstName);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public CreateAccountRequest(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkParameterIsNotNull(str, "emailaddress");
        Intrinsics.checkParameterIsNotNull(str2, "accountType");
        Intrinsics.checkParameterIsNotNull(str3, "password");
        Intrinsics.checkParameterIsNotNull(str4, "confirmPassword");
        Intrinsics.checkParameterIsNotNull(str5, "lastName");
        Intrinsics.checkParameterIsNotNull(str6, "firstName");
        this.emailaddress = str;
        this.accountType = str2;
        this.password = str3;
        this.confirmPassword = str4;
        this.lastName = str5;
        this.firstName = str6;
    }

    @NotNull
    public final String getEmailaddress() {
        return this.emailaddress;
    }

    @NotNull
    public final String getAccountType() {
        return this.accountType;
    }

    @NotNull
    public final String getPassword() {
        return this.password;
    }

    @NotNull
    public final String getConfirmPassword() {
        return this.confirmPassword;
    }

    @NotNull
    public final String getLastName() {
        return this.lastName;
    }

    @NotNull
    public final String getFirstName() {
        return this.firstName;
    }

    public CreateAccountRequest(@NotNull Parcel parcel) {
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
        String readString6 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString6, "parcel.readString()");
        this(readString, readString2, readString3, readString4, readString5, readString6);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.emailaddress);
        parcel.writeString(this.accountType);
        parcel.writeString(this.password);
        parcel.writeString(this.confirmPassword);
        parcel.writeString(this.lastName);
        parcel.writeString(this.firstName);
    }
}
