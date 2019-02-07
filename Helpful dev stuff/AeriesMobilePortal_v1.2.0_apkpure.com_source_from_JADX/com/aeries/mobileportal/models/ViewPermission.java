package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;
import io.realm.ViewPermissionRealmProxyInterface;
import io.realm.internal.RealmObjectProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000eH\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006!"}, d2 = {"Lcom/aeries/mobileportal/models/ViewPermission;", "Lio/realm/RealmObject;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "canViewDetails", "", "getCanViewDetails", "()Z", "setCanViewDetails", "(Z)V", "position", "", "getPosition", "()I", "setPosition", "(I)V", "viewCode", "", "getViewCode", "()Ljava/lang/String;", "setViewCode", "(Ljava/lang/String;)V", "viewDescription", "getViewDescription", "setViewDescription", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ViewPermission.kt */
public class ViewPermission extends RealmObject implements Parcelable, ViewPermissionRealmProxyInterface {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("CanViewDetails")
    @Expose
    private boolean canViewDetails;
    private int position;
    @SerializedName("ViewCode")
    @Nullable
    @Expose
    private String viewCode;
    @SerializedName("ViewDescription")
    @Nullable
    @Expose
    private String viewDescription;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/ViewPermission$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/ViewPermission;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/ViewPermission;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ViewPermission.kt */
    public static final class CREATOR implements Creator<ViewPermission> {
        private CREATOR() {
        }

        @NotNull
        public ViewPermission createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new ViewPermission(parcel);
        }

        @NotNull
        public ViewPermission[] newArray(int i) {
            return new ViewPermission[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean realmGet$canViewDetails() {
        return this.canViewDetails;
    }

    public int realmGet$position() {
        return this.position;
    }

    public String realmGet$viewCode() {
        return this.viewCode;
    }

    public String realmGet$viewDescription() {
        return this.viewDescription;
    }

    public void realmSet$canViewDetails(boolean z) {
        this.canViewDetails = z;
    }

    public void realmSet$position(int i) {
        this.position = i;
    }

    public void realmSet$viewCode(String str) {
        this.viewCode = str;
    }

    public void realmSet$viewDescription(String str) {
        this.viewDescription = str;
    }

    public ViewPermission() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$viewCode("");
        realmSet$viewDescription("");
    }

    @Nullable
    public final String getViewCode() {
        return realmGet$viewCode();
    }

    public final void setViewCode(@Nullable String str) {
        realmSet$viewCode(str);
    }

    public final boolean getCanViewDetails() {
        return realmGet$canViewDetails();
    }

    public final void setCanViewDetails(boolean z) {
        realmSet$canViewDetails(z);
    }

    @Nullable
    public final String getViewDescription() {
        return realmGet$viewDescription();
    }

    public final void setViewDescription(@Nullable String str) {
        realmSet$viewDescription(str);
    }

    public final int getPosition() {
        return realmGet$position();
    }

    public final void setPosition(int i) {
        realmSet$position(i);
    }

    public ViewPermission(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this();
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$viewCode(parcel.readString());
        boolean z = false;
        if (parcel.readByte() != ((byte) null)) {
            z = true;
        }
        realmSet$canViewDetails(z);
        realmSet$viewDescription(parcel.readString());
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(realmGet$viewCode());
        parcel.writeByte(realmGet$canViewDetails());
        parcel.writeString(realmGet$viewDescription());
    }
}
