package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0003J%\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/aeries/mobileportal/models/ChangePasswordResponse;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "status", "", "errorList", "", "(Ljava/lang/String;Ljava/util/List;)V", "getErrorList", "()Ljava/util/List;", "getStatus", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ChangePasswordResponse.kt */
public final class ChangePasswordResponse implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @Nullable
    @SerializedName("errors")
    @Expose
    private final List<String> errorList;
    @SerializedName("status")
    @NotNull
    @Expose
    private final String status;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/ChangePasswordResponse$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/ChangePasswordResponse;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/ChangePasswordResponse;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ChangePasswordResponse.kt */
    public static final class CREATOR implements Creator<ChangePasswordResponse> {
        private CREATOR() {
        }

        @NotNull
        public ChangePasswordResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new ChangePasswordResponse(parcel);
        }

        @NotNull
        public ChangePasswordResponse[] newArray(int i) {
            return new ChangePasswordResponse[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ ChangePasswordResponse copy$default(ChangePasswordResponse changePasswordResponse, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = changePasswordResponse.status;
        }
        if ((i & 2) != 0) {
            list = changePasswordResponse.errorList;
        }
        return changePasswordResponse.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.status;
    }

    @Nullable
    public final List<String> component2() {
        return this.errorList;
    }

    @NotNull
    public final ChangePasswordResponse copy(@NotNull String str, @Nullable List<String> list) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        return new ChangePasswordResponse(str, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ChangePasswordResponse) {
                ChangePasswordResponse changePasswordResponse = (ChangePasswordResponse) obj;
                if (Intrinsics.areEqual(this.status, changePasswordResponse.status) && Intrinsics.areEqual(this.errorList, changePasswordResponse.errorList)) {
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
        List list = this.errorList;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChangePasswordResponse(status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", errorList=");
        stringBuilder.append(this.errorList);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ChangePasswordResponse(@NotNull String str, @Nullable List<String> list) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        this.status = str;
        this.errorList = list;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final List<String> getErrorList() {
        return this.errorList;
    }

    public ChangePasswordResponse(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        this(readString, parcel.createStringArrayList());
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.status);
        parcel.writeStringList(this.errorList);
    }
}
