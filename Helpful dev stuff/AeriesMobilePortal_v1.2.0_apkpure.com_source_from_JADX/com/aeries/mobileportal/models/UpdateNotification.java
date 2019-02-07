package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u0016R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/aeries/mobileportal/models/UpdateNotification;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "notificationId", "", "(Ljava/lang/String;)V", "getNotificationId", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: UpdateNotification.kt */
public final class UpdateNotification implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("nid")
    @NotNull
    @Expose
    private final String notificationId;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/UpdateNotification$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/UpdateNotification;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/UpdateNotification;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: UpdateNotification.kt */
    public static final class CREATOR implements Creator<UpdateNotification> {
        private CREATOR() {
        }

        @NotNull
        public UpdateNotification createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new UpdateNotification(parcel);
        }

        @NotNull
        public UpdateNotification[] newArray(int i) {
            return new UpdateNotification[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public UpdateNotification(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "notificationId");
        this.notificationId = str;
    }

    @NotNull
    public final String getNotificationId() {
        return this.notificationId;
    }

    public UpdateNotification(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        this(readString);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.notificationId);
    }
}
