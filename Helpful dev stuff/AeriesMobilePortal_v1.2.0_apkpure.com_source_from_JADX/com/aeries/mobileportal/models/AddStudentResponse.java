package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B9\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÆ\u0003J\t\u0010\u0019\u001a\u00020\rHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u001cH\u0016R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R*\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006'"}, d2 = {"Lcom/aeries/mobileportal/models/AddStudentResponse;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "status", "", "error", "contacts", "Ljava/util/ArrayList;", "Lcom/aeries/mobileportal/models/LinkContact;", "Lkotlin/collections/ArrayList;", "authenticationData", "Lcom/aeries/mobileportal/models/AuthenticationData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/aeries/mobileportal/models/AuthenticationData;)V", "getAuthenticationData", "()Lcom/aeries/mobileportal/models/AuthenticationData;", "getContacts", "()Ljava/util/ArrayList;", "getError", "()Ljava/lang/String;", "getStatus", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AddStudentResponse.kt */
public final class AddStudentResponse implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("authenticationData")
    @NotNull
    @Expose
    private final AuthenticationData authenticationData;
    @Nullable
    @SerializedName("contacts")
    @Expose
    private final ArrayList<LinkContact> contacts;
    @SerializedName("error")
    @NotNull
    @Expose
    private final String error;
    @SerializedName("status")
    @NotNull
    @Expose
    private final String status;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/AddStudentResponse$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/AddStudentResponse;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/AddStudentResponse;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AddStudentResponse.kt */
    public static final class CREATOR implements Creator<AddStudentResponse> {
        private CREATOR() {
        }

        @NotNull
        public AddStudentResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new AddStudentResponse(parcel);
        }

        @NotNull
        public AddStudentResponse[] newArray(int i) {
            return new AddStudentResponse[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ AddStudentResponse copy$default(AddStudentResponse addStudentResponse, String str, String str2, ArrayList arrayList, AuthenticationData authenticationData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = addStudentResponse.status;
        }
        if ((i & 2) != 0) {
            str2 = addStudentResponse.error;
        }
        if ((i & 4) != 0) {
            arrayList = addStudentResponse.contacts;
        }
        if ((i & 8) != 0) {
            authenticationData = addStudentResponse.authenticationData;
        }
        return addStudentResponse.copy(str, str2, arrayList, authenticationData);
    }

    @NotNull
    public final String component1() {
        return this.status;
    }

    @NotNull
    public final String component2() {
        return this.error;
    }

    @Nullable
    public final ArrayList<LinkContact> component3() {
        return this.contacts;
    }

    @NotNull
    public final AuthenticationData component4() {
        return this.authenticationData;
    }

    @NotNull
    public final AddStudentResponse copy(@NotNull String str, @NotNull String str2, @Nullable ArrayList<LinkContact> arrayList, @NotNull AuthenticationData authenticationData) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        Intrinsics.checkParameterIsNotNull(str2, "error");
        Intrinsics.checkParameterIsNotNull(authenticationData, "authenticationData");
        return new AddStudentResponse(str, str2, arrayList, authenticationData);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof AddStudentResponse) {
                AddStudentResponse addStudentResponse = (AddStudentResponse) obj;
                if (Intrinsics.areEqual(this.status, addStudentResponse.status) && Intrinsics.areEqual(this.error, addStudentResponse.error) && Intrinsics.areEqual(this.contacts, addStudentResponse.contacts) && Intrinsics.areEqual(this.authenticationData, addStudentResponse.authenticationData)) {
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
        String str2 = this.error;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ArrayList arrayList = this.contacts;
        hashCode = (hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        AuthenticationData authenticationData = this.authenticationData;
        if (authenticationData != null) {
            i = authenticationData.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AddStudentResponse(status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", error=");
        stringBuilder.append(this.error);
        stringBuilder.append(", contacts=");
        stringBuilder.append(this.contacts);
        stringBuilder.append(", authenticationData=");
        stringBuilder.append(this.authenticationData);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public AddStudentResponse(@NotNull String str, @NotNull String str2, @Nullable ArrayList<LinkContact> arrayList, @NotNull AuthenticationData authenticationData) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        Intrinsics.checkParameterIsNotNull(str2, "error");
        Intrinsics.checkParameterIsNotNull(authenticationData, "authenticationData");
        this.status = str;
        this.error = str2;
        this.contacts = arrayList;
        this.authenticationData = authenticationData;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final String getError() {
        return this.error;
    }

    @Nullable
    public final ArrayList<LinkContact> getContacts() {
        return this.contacts;
    }

    @NotNull
    public final AuthenticationData getAuthenticationData() {
        return this.authenticationData;
    }

    public AddStudentResponse(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        String readString2 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString2, "parcel.readString()");
        ArrayList createTypedArrayList = parcel.createTypedArrayList(LinkContact.CREATOR);
        parcel = parcel.readParcelable(AuthenticationData.class.getClassLoader());
        Intrinsics.checkExpressionValueIsNotNull(parcel, "parcel.readParcelable(Au…::class.java.classLoader)");
        this(readString, readString2, createTypedArrayList, (AuthenticationData) parcel);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.status);
        parcel.writeString(this.error);
        parcel.writeTypedList(this.contacts);
        parcel.writeParcelable(this.authenticationData, i);
    }
}
