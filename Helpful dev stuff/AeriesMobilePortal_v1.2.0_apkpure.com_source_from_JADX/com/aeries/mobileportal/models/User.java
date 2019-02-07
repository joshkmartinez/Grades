package com.aeries.mobileportal.models;

import com.aeries.mobileportal.utils.EncryptionHelper;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\b\u0018\u00002\u00020\u0001By\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\b\u001a\u00020\u0003H J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00104\u001a\u00020\u000eHÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J}\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010>\u001a\u00020\u000e2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\u0003H J\t\u0010C\u001a\u00020\u0003H J\t\u0010D\u001a\u00020\u0003H J\t\u0010E\u001a\u00020\u0003H J\t\u0010F\u001a\u00020\u0003HÖ\u0001J\u0006\u0010G\u001a\u00020HR\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0011\"\u0004\b-\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0011\"\u0004\b/\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0011\"\u0004\b1\u0010\u0013¨\u0006I"}, d2 = {"Lcom/aeries/mobileportal/models/User;", "", "username", "", "password", "googleAccount", "googleToken", "userType", "clientID", "secretKey", "appType", "platform", "dateTimeStamp", "keepSession", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAppType", "()Ljava/lang/String;", "setAppType", "(Ljava/lang/String;)V", "getClientID", "setClientID", "getDateTimeStamp", "setDateTimeStamp", "ehelper", "Lcom/aeries/mobileportal/utils/EncryptionHelper;", "getGoogleAccount", "setGoogleAccount", "getGoogleToken", "setGoogleToken", "getKeepSession", "()Z", "setKeepSession", "(Z)V", "getPassword", "setPassword", "getPlatform", "setPlatform", "school", "Lcom/aeries/mobileportal/models/School;", "getSchool", "()Lcom/aeries/mobileportal/models/School;", "setSchool", "(Lcom/aeries/mobileportal/models/School;)V", "getSecretKey", "setSecretKey", "getUserType", "setUserType", "getUsername", "setUsername", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "oldClientID", "oldSecretKey", "privateXML", "rawSecretKey", "toString", "useOldKeys", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: User.kt */
public final class User {
    @SerializedName("AppType")
    @NotNull
    @Expose
    private String appType;
    @SerializedName("ClientId")
    @NotNull
    @Expose
    private String clientID;
    @SerializedName("DateTimeStamp")
    @Nullable
    @Expose
    private String dateTimeStamp;
    private final EncryptionHelper ehelper;
    @SerializedName("googleAccount")
    @Nullable
    @Expose
    private String googleAccount;
    @SerializedName("GoogleToken")
    @Nullable
    @Expose
    private String googleToken;
    private boolean keepSession;
    @SerializedName("Password")
    @NotNull
    @Expose
    private String password;
    @SerializedName("Platform")
    @NotNull
    @Expose
    private String platform;
    @NotNull
    private School school;
    @SerializedName("SecretKey")
    @NotNull
    @Expose
    private String secretKey;
    @SerializedName("UserType")
    @NotNull
    @Expose
    private String userType;
    @SerializedName("UserName")
    @NotNull
    @Expose
    private String username;

    public User() {
        this(null, null, null, null, null, null, null, null, null, null, false, 2047, null);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ User copy$default(User user, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, int i, Object obj) {
        User user2 = user;
        int i2 = i;
        return user.copy((i2 & 1) != 0 ? user2.username : str, (i2 & 2) != 0 ? user2.password : str2, (i2 & 4) != 0 ? user2.googleAccount : str3, (i2 & 8) != 0 ? user2.googleToken : str4, (i2 & 16) != 0 ? user2.userType : str5, (i2 & 32) != 0 ? user2.clientID : str6, (i2 & 64) != 0 ? user2.secretKey : str7, (i2 & 128) != 0 ? user2.appType : str8, (i2 & 256) != 0 ? user2.platform : str9, (i2 & 512) != 0 ? user2.dateTimeStamp : str10, (i2 & 1024) != 0 ? user2.keepSession : z);
    }

    @NotNull
    public final native String clientID();

    @NotNull
    public final String component1() {
        return this.username;
    }

    @Nullable
    public final String component10() {
        return this.dateTimeStamp;
    }

    public final boolean component11() {
        return this.keepSession;
    }

    @NotNull
    public final String component2() {
        return this.password;
    }

    @Nullable
    public final String component3() {
        return this.googleAccount;
    }

    @Nullable
    public final String component4() {
        return this.googleToken;
    }

    @NotNull
    public final String component5() {
        return this.userType;
    }

    @NotNull
    public final String component6() {
        return this.clientID;
    }

    @NotNull
    public final String component7() {
        return this.secretKey;
    }

    @NotNull
    public final String component8() {
        return this.appType;
    }

    @NotNull
    public final String component9() {
        return this.platform;
    }

    @NotNull
    public final User copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @Nullable String str10, boolean z) {
        String str11 = str;
        Intrinsics.checkParameterIsNotNull(str11, "username");
        String str12 = str2;
        Intrinsics.checkParameterIsNotNull(str12, "password");
        String str13 = str5;
        Intrinsics.checkParameterIsNotNull(str13, "userType");
        String str14 = str6;
        Intrinsics.checkParameterIsNotNull(str14, "clientID");
        String str15 = str7;
        Intrinsics.checkParameterIsNotNull(str15, "secretKey");
        String str16 = str8;
        Intrinsics.checkParameterIsNotNull(str16, "appType");
        String str17 = str9;
        Intrinsics.checkParameterIsNotNull(str17, "platform");
        return new User(str11, str12, str3, str4, str13, str14, str15, str16, str17, str10, z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof User) {
                User user = (User) obj;
                if (Intrinsics.areEqual(this.username, user.username) && Intrinsics.areEqual(this.password, user.password) && Intrinsics.areEqual(this.googleAccount, user.googleAccount) && Intrinsics.areEqual(this.googleToken, user.googleToken) && Intrinsics.areEqual(this.userType, user.userType) && Intrinsics.areEqual(this.clientID, user.clientID) && Intrinsics.areEqual(this.secretKey, user.secretKey) && Intrinsics.areEqual(this.appType, user.appType) && Intrinsics.areEqual(this.platform, user.platform) && Intrinsics.areEqual(this.dateTimeStamp, user.dateTimeStamp)) {
                    if (this.keepSession == user.keepSession) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.username;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.password;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.googleAccount;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.googleToken;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.userType;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.clientID;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.secretKey;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.appType;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.platform;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.dateTimeStamp;
        if (str2 != null) {
            i = str2.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.keepSession;
        if (i != 0) {
            i = 1;
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
        stringBuilder.append("User(username=");
        stringBuilder.append(this.username);
        stringBuilder.append(", password=");
        stringBuilder.append(this.password);
        stringBuilder.append(", googleAccount=");
        stringBuilder.append(this.googleAccount);
        stringBuilder.append(", googleToken=");
        stringBuilder.append(this.googleToken);
        stringBuilder.append(", userType=");
        stringBuilder.append(this.userType);
        stringBuilder.append(", clientID=");
        stringBuilder.append(this.clientID);
        stringBuilder.append(", secretKey=");
        stringBuilder.append(this.secretKey);
        stringBuilder.append(", appType=");
        stringBuilder.append(this.appType);
        stringBuilder.append(", platform=");
        stringBuilder.append(this.platform);
        stringBuilder.append(", dateTimeStamp=");
        stringBuilder.append(this.dateTimeStamp);
        stringBuilder.append(", keepSession=");
        stringBuilder.append(this.keepSession);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public User(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @Nullable String str10, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "password");
        Intrinsics.checkParameterIsNotNull(str5, "userType");
        Intrinsics.checkParameterIsNotNull(str6, "clientID");
        Intrinsics.checkParameterIsNotNull(str7, "secretKey");
        Intrinsics.checkParameterIsNotNull(str8, "appType");
        Intrinsics.checkParameterIsNotNull(str9, "platform");
        this.username = str;
        this.password = str2;
        this.googleAccount = str3;
        this.googleToken = str4;
        this.userType = str5;
        this.clientID = str6;
        this.secretKey = str7;
        this.appType = str8;
        this.platform = str9;
        this.dateTimeStamp = str10;
        this.keepSession = z;
        this.school = new School();
        System.loadLibrary("keys");
        this.clientID = clientID();
        this.ehelper = new EncryptionHelper();
        this.secretKey = this.ehelper.rsaEncrypt(rawSecretKey(), PrivateRSAKey.Companion.getKeyFromXml(privateXML()));
        this.dateTimeStamp = this.ehelper.getCurrentDateTime();
    }

    @NotNull
    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.username = str;
    }

    @NotNull
    public final String getPassword() {
        return this.password;
    }

    public final void setPassword(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.password = str;
    }

    public /* synthetic */ User(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        int i2 = i;
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? (String) null : str3, (i2 & 8) != 0 ? (String) null : str4, (i2 & 16) != 0 ? "Student" : str5, (i2 & 32) != 0 ? "" : str6, (i2 & 64) != 0 ? "" : str7, (i2 & 128) != 0 ? "PSP" : str8, (i2 & 256) != 0 ? AbstractSpiCall.ANDROID_CLIENT_TYPE : str9, (i2 & 512) != 0 ? (String) null : str10, (i2 & 1024) != 0 ? true : z);
    }

    @Nullable
    public final String getGoogleAccount() {
        return this.googleAccount;
    }

    public final void setGoogleAccount(@Nullable String str) {
        this.googleAccount = str;
    }

    @Nullable
    public final String getGoogleToken() {
        return this.googleToken;
    }

    public final void setGoogleToken(@Nullable String str) {
        this.googleToken = str;
    }

    @NotNull
    public final String getUserType() {
        return this.userType;
    }

    public final void setUserType(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.userType = str;
    }

    @NotNull
    public final String getClientID() {
        return this.clientID;
    }

    public final void setClientID(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.clientID = str;
    }

    @NotNull
    public final String getSecretKey() {
        return this.secretKey;
    }

    public final void setSecretKey(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.secretKey = str;
    }

    @NotNull
    public final String getAppType() {
        return this.appType;
    }

    public final void setAppType(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.appType = str;
    }

    @NotNull
    public final String getPlatform() {
        return this.platform;
    }

    public final void setPlatform(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.platform = str;
    }

    @Nullable
    public final String getDateTimeStamp() {
        return this.dateTimeStamp;
    }

    public final void setDateTimeStamp(@Nullable String str) {
        this.dateTimeStamp = str;
    }

    public final boolean getKeepSession() {
        return this.keepSession;
    }

    public final void setKeepSession(boolean z) {
        this.keepSession = z;
    }

    @NotNull
    public final School getSchool() {
        return this.school;
    }

    public final void setSchool(@NotNull School school) {
        Intrinsics.checkParameterIsNotNull(school, "<set-?>");
        this.school = school;
    }

    public final void useOldKeys() {
        this.secretKey = oldSecretKey();
        this.clientID = oldClientID();
        this.dateTimeStamp = (String) null;
    }
}
