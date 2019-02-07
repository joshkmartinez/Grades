package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.NotificationRealmProxyInterface;
import io.realm.RealmModel;
import io.realm.annotations.RealmClass;
import io.realm.internal.RealmObjectProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010.\u001a\u00020\u001aH\u0016J\u0018\u0010/\u001a\u0002002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u001aH\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001e\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001e\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001e\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001e\u0010\"\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR\u001e\u0010%\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010\fR\u001e\u0010(\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001e\u0010+\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\n\"\u0004\b-\u0010\f¨\u00063"}, d2 = {"Lcom/aeries/mobileportal/models/Notification;", "Lio/realm/RealmModel;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "dateCreated", "", "getDateCreated", "()Ljava/lang/String;", "setDateCreated", "(Ljava/lang/String;)V", "dateRead", "getDateRead", "setDateRead", "name", "getName", "setName", "notificationID", "getNotificationID", "setNotificationID", "notificationMessage", "getNotificationMessage", "setNotificationMessage", "schoolCode", "", "getSchoolCode", "()I", "setSchoolCode", "(I)V", "schoolName", "getSchoolName", "setSchoolName", "ssoUrl", "getSsoUrl", "setSsoUrl", "status", "getStatus", "setStatus", "userID", "getUserID", "setUserID", "userType", "getUserType", "setUserType", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
@RealmClass
/* compiled from: Notification.kt */
public class Notification implements RealmModel, Parcelable, NotificationRealmProxyInterface {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("DateCreated")
    @NotNull
    @Expose
    private String dateCreated;
    @SerializedName("DateRead")
    @Nullable
    @Expose
    private String dateRead;
    @SerializedName("DisplayName")
    @NotNull
    @Expose
    private String name;
    @SerializedName("NotificationID")
    @NotNull
    @Expose
    private String notificationID;
    @SerializedName("NotificationMessage")
    @NotNull
    @Expose
    private String notificationMessage;
    @SerializedName("SchoolCode")
    @Expose
    private int schoolCode;
    @SerializedName("SchoolName")
    @NotNull
    @Expose
    private String schoolName;
    @SerializedName("SSOURL")
    @NotNull
    @Expose
    private String ssoUrl;
    @SerializedName("Status")
    @NotNull
    @Expose
    private String status;
    @SerializedName("UserID")
    @Expose
    private int userID;
    @SerializedName("UserType")
    @NotNull
    @Expose
    private String userType;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/Notification$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/Notification;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/Notification;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Notification.kt */
    public static final class CREATOR implements Creator<Notification> {
        private CREATOR() {
        }

        @NotNull
        public Notification createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new Notification(parcel);
        }

        @NotNull
        public Notification[] newArray(int i) {
            return new Notification[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public String realmGet$dateCreated() {
        return this.dateCreated;
    }

    public String realmGet$dateRead() {
        return this.dateRead;
    }

    public String realmGet$name() {
        return this.name;
    }

    public String realmGet$notificationID() {
        return this.notificationID;
    }

    public String realmGet$notificationMessage() {
        return this.notificationMessage;
    }

    public int realmGet$schoolCode() {
        return this.schoolCode;
    }

    public String realmGet$schoolName() {
        return this.schoolName;
    }

    public String realmGet$ssoUrl() {
        return this.ssoUrl;
    }

    public String realmGet$status() {
        return this.status;
    }

    public int realmGet$userID() {
        return this.userID;
    }

    public String realmGet$userType() {
        return this.userType;
    }

    public void realmSet$dateCreated(String str) {
        this.dateCreated = str;
    }

    public void realmSet$dateRead(String str) {
        this.dateRead = str;
    }

    public void realmSet$name(String str) {
        this.name = str;
    }

    public void realmSet$notificationID(String str) {
        this.notificationID = str;
    }

    public void realmSet$notificationMessage(String str) {
        this.notificationMessage = str;
    }

    public void realmSet$schoolCode(int i) {
        this.schoolCode = i;
    }

    public void realmSet$schoolName(String str) {
        this.schoolName = str;
    }

    public void realmSet$ssoUrl(String str) {
        this.ssoUrl = str;
    }

    public void realmSet$status(String str) {
        this.status = str;
    }

    public void realmSet$userID(int i) {
        this.userID = i;
    }

    public void realmSet$userType(String str) {
        this.userType = str;
    }

    public Notification() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$notificationID("");
        realmSet$notificationMessage("");
        realmSet$name("");
        realmSet$schoolName("");
        realmSet$userType("");
        realmSet$status("");
        realmSet$ssoUrl("");
        realmSet$dateCreated("");
    }

    @NotNull
    public final String getNotificationID() {
        return realmGet$notificationID();
    }

    public final void setNotificationID(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$notificationID(str);
    }

    @NotNull
    public final String getNotificationMessage() {
        return realmGet$notificationMessage();
    }

    public final void setNotificationMessage(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$notificationMessage(str);
    }

    public final int getUserID() {
        return realmGet$userID();
    }

    public final void setUserID(int i) {
        realmSet$userID(i);
    }

    @NotNull
    public final String getName() {
        return realmGet$name();
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$name(str);
    }

    public final int getSchoolCode() {
        return realmGet$schoolCode();
    }

    public final void setSchoolCode(int i) {
        realmSet$schoolCode(i);
    }

    @NotNull
    public final String getSchoolName() {
        return realmGet$schoolName();
    }

    public final void setSchoolName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$schoolName(str);
    }

    @NotNull
    public final String getUserType() {
        return realmGet$userType();
    }

    public final void setUserType(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$userType(str);
    }

    @NotNull
    public final String getStatus() {
        return realmGet$status();
    }

    public final void setStatus(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$status(str);
    }

    @NotNull
    public final String getSsoUrl() {
        return realmGet$ssoUrl();
    }

    public final void setSsoUrl(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$ssoUrl(str);
    }

    @Nullable
    public final String getDateRead() {
        return realmGet$dateRead();
    }

    public final void setDateRead(@Nullable String str) {
        realmSet$dateRead(str);
    }

    @NotNull
    public final String getDateCreated() {
        return realmGet$dateCreated();
    }

    public final void setDateCreated(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$dateCreated(str);
    }

    public Notification(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this();
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        realmSet$notificationID(readString);
        readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        realmSet$notificationMessage(readString);
        realmSet$userID(parcel.readInt());
        readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        realmSet$name(readString);
        realmSet$schoolCode(parcel.readInt());
        readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        realmSet$schoolName(readString);
        readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        realmSet$userType(readString);
        readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        realmSet$status(readString);
        readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        realmSet$ssoUrl(readString);
        realmSet$dateRead(parcel.readString());
        parcel = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(parcel, "parcel.readString()");
        realmSet$dateCreated(parcel);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(realmGet$notificationID());
        parcel.writeString(realmGet$notificationMessage());
        parcel.writeInt(realmGet$userID());
        parcel.writeString(realmGet$name());
        parcel.writeInt(realmGet$schoolCode());
        parcel.writeString(realmGet$schoolName());
        parcel.writeString(realmGet$userType());
        parcel.writeString(realmGet$status());
        parcel.writeString(realmGet$ssoUrl());
        parcel.writeString(realmGet$dateRead());
        parcel.writeString(realmGet$dateCreated());
    }
}
