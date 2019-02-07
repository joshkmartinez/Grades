package com.aeries.mobileportal.models;

import com.aeries.mobileportal.utils.EncryptionHelper;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u001d\u001a\u00020\u0003H J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J[\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003H J\t\u0010-\u001a\u00020\u0003H J\t\u0010.\u001a\u00020\u0003H J\t\u0010/\u001a\u00020\u0003H J\t\u00100\u001a\u00020\u0003HÖ\u0001J\u0006\u00101\u001a\u000202R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\r¨\u00063"}, d2 = {"Lcom/aeries/mobileportal/models/AddStudentRequest;", "", "studentID", "", "studentHomePhone", "verificationCode", "accountType", "clientId", "secretKey", "dateTimeStamp", "platform", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountType", "()Ljava/lang/String;", "getClientId", "setClientId", "(Ljava/lang/String;)V", "getDateTimeStamp", "setDateTimeStamp", "eHelper", "Lcom/aeries/mobileportal/utils/EncryptionHelper;", "getEHelper", "()Lcom/aeries/mobileportal/utils/EncryptionHelper;", "getPlatform", "getSecretKey", "setSecretKey", "getStudentHomePhone", "getStudentID", "getVerificationCode", "clientID", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "oldClientID", "oldSecretKey", "privateXML", "rawSecretKey", "toString", "useOldKeys", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AddStudentRequest.kt */
public final class AddStudentRequest {
    @SerializedName("AccountType")
    @NotNull
    @Expose
    private final String accountType;
    @SerializedName("ClientId")
    @NotNull
    @Expose
    private String clientId;
    @SerializedName("DateTimeStamp")
    @Nullable
    @Expose
    private String dateTimeStamp;
    @NotNull
    private final EncryptionHelper eHelper;
    @SerializedName("Platform")
    @NotNull
    @Expose
    private final String platform;
    @SerializedName("SecretKey")
    @NotNull
    @Expose
    private String secretKey;
    @SerializedName("StudentHomePhone")
    @NotNull
    @Expose
    private final String studentHomePhone;
    @SerializedName("StudentID")
    @NotNull
    @Expose
    private final String studentID;
    @SerializedName("VerificationCode")
    @NotNull
    @Expose
    private final String verificationCode;

    @NotNull
    public static /* bridge */ /* synthetic */ AddStudentRequest copy$default(AddStudentRequest addStudentRequest, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        AddStudentRequest addStudentRequest2 = addStudentRequest;
        int i2 = i;
        return addStudentRequest.copy((i2 & 1) != 0 ? addStudentRequest2.studentID : str, (i2 & 2) != 0 ? addStudentRequest2.studentHomePhone : str2, (i2 & 4) != 0 ? addStudentRequest2.verificationCode : str3, (i2 & 8) != 0 ? addStudentRequest2.accountType : str4, (i2 & 16) != 0 ? addStudentRequest2.clientId : str5, (i2 & 32) != 0 ? addStudentRequest2.secretKey : str6, (i2 & 64) != 0 ? addStudentRequest2.dateTimeStamp : str7, (i2 & 128) != 0 ? addStudentRequest2.platform : str8);
    }

    @NotNull
    public final native String clientID();

    @NotNull
    public final String component1() {
        return this.studentID;
    }

    @NotNull
    public final String component2() {
        return this.studentHomePhone;
    }

    @NotNull
    public final String component3() {
        return this.verificationCode;
    }

    @NotNull
    public final String component4() {
        return this.accountType;
    }

    @NotNull
    public final String component5() {
        return this.clientId;
    }

    @NotNull
    public final String component6() {
        return this.secretKey;
    }

    @Nullable
    public final String component7() {
        return this.dateTimeStamp;
    }

    @NotNull
    public final String component8() {
        return this.platform;
    }

    @NotNull
    public final AddStudentRequest copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @Nullable String str7, @NotNull String str8) {
        String str9 = str;
        Intrinsics.checkParameterIsNotNull(str9, "studentID");
        String str10 = str2;
        Intrinsics.checkParameterIsNotNull(str10, "studentHomePhone");
        String str11 = str3;
        Intrinsics.checkParameterIsNotNull(str11, "verificationCode");
        String str12 = str4;
        Intrinsics.checkParameterIsNotNull(str12, "accountType");
        String str13 = str5;
        Intrinsics.checkParameterIsNotNull(str13, "clientId");
        String str14 = str6;
        Intrinsics.checkParameterIsNotNull(str14, "secretKey");
        String str15 = str8;
        Intrinsics.checkParameterIsNotNull(str15, "platform");
        return new AddStudentRequest(str9, str10, str11, str12, str13, str14, str7, str15);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof AddStudentRequest) {
                AddStudentRequest addStudentRequest = (AddStudentRequest) obj;
                if (Intrinsics.areEqual(this.studentID, addStudentRequest.studentID) && Intrinsics.areEqual(this.studentHomePhone, addStudentRequest.studentHomePhone) && Intrinsics.areEqual(this.verificationCode, addStudentRequest.verificationCode) && Intrinsics.areEqual(this.accountType, addStudentRequest.accountType) && Intrinsics.areEqual(this.clientId, addStudentRequest.clientId) && Intrinsics.areEqual(this.secretKey, addStudentRequest.secretKey) && Intrinsics.areEqual(this.dateTimeStamp, addStudentRequest.dateTimeStamp) && Intrinsics.areEqual(this.platform, addStudentRequest.platform)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.studentID;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.studentHomePhone;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.verificationCode;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.accountType;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.clientId;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.secretKey;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.dateTimeStamp;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.platform;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public final native String oldClientID();

    @NotNull
    public final native String oldSecretKey();

    @NotNull
    public final native String privateXML();

    @NotNull
    public final native String rawSecretKey();

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AddStudentRequest(studentID=");
        stringBuilder.append(this.studentID);
        stringBuilder.append(", studentHomePhone=");
        stringBuilder.append(this.studentHomePhone);
        stringBuilder.append(", verificationCode=");
        stringBuilder.append(this.verificationCode);
        stringBuilder.append(", accountType=");
        stringBuilder.append(this.accountType);
        stringBuilder.append(", clientId=");
        stringBuilder.append(this.clientId);
        stringBuilder.append(", secretKey=");
        stringBuilder.append(this.secretKey);
        stringBuilder.append(", dateTimeStamp=");
        stringBuilder.append(this.dateTimeStamp);
        stringBuilder.append(", platform=");
        stringBuilder.append(this.platform);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public AddStudentRequest(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @Nullable String str7, @NotNull String str8) {
        Intrinsics.checkParameterIsNotNull(str, "studentID");
        Intrinsics.checkParameterIsNotNull(str2, "studentHomePhone");
        Intrinsics.checkParameterIsNotNull(str3, "verificationCode");
        Intrinsics.checkParameterIsNotNull(str4, "accountType");
        Intrinsics.checkParameterIsNotNull(str5, "clientId");
        Intrinsics.checkParameterIsNotNull(str6, "secretKey");
        Intrinsics.checkParameterIsNotNull(str8, "platform");
        this.studentID = str;
        this.studentHomePhone = str2;
        this.verificationCode = str3;
        this.accountType = str4;
        this.clientId = str5;
        this.secretKey = str6;
        this.dateTimeStamp = str7;
        this.platform = str8;
        System.loadLibrary("keys");
        this.eHelper = new EncryptionHelper();
        this.clientId = clientID();
        this.secretKey = this.eHelper.rsaEncrypt(rawSecretKey(), PrivateRSAKey.Companion.getKeyFromXml(privateXML()));
        this.dateTimeStamp = this.eHelper.getCurrentDateTime();
    }

    @NotNull
    public final String getStudentID() {
        return this.studentID;
    }

    @NotNull
    public final String getStudentHomePhone() {
        return this.studentHomePhone;
    }

    @NotNull
    public final String getVerificationCode() {
        return this.verificationCode;
    }

    @NotNull
    public final String getAccountType() {
        return this.accountType;
    }

    @NotNull
    public final String getClientId() {
        return this.clientId;
    }

    public final void setClientId(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.clientId = str;
    }

    @NotNull
    public final String getSecretKey() {
        return this.secretKey;
    }

    public final void setSecretKey(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.secretKey = str;
    }

    public /* synthetic */ AddStudentRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        int i2 = i;
        this(str, str2, str3, str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? "" : str6, (i2 & 64) != 0 ? (String) null : str7, (i2 & 128) != 0 ? AbstractSpiCall.ANDROID_CLIENT_TYPE : str8);
    }

    @Nullable
    public final String getDateTimeStamp() {
        return this.dateTimeStamp;
    }

    public final void setDateTimeStamp(@Nullable String str) {
        this.dateTimeStamp = str;
    }

    @NotNull
    public final String getPlatform() {
        return this.platform;
    }

    @NotNull
    public final EncryptionHelper getEHelper() {
        return this.eHelper;
    }

    public final void useOldKeys() {
        this.secretKey = oldSecretKey();
        this.clientId = oldClientID();
        this.dateTimeStamp = (String) null;
    }
}
