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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 62\u00020\u0001:\u00016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005B[\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0002\u0010\u0013J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003Jr\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u000eH\u0016J\u0013\u0010.\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u000eHÖ\u0001J\t\u00102\u001a\u00020\tHÖ\u0001J\u0018\u00103\u001a\u0002042\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u000eH\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015¨\u00067"}, d2 = {"Lcom/aeries/mobileportal/models/AuthenticationData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "success", "", "error", "", "accessToken", "refreshToken", "userType", "defaultStudentId", "", "signalKit", "students", "", "Lcom/aeries/mobileportal/models/Student;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;)V", "getAccessToken", "()Ljava/lang/String;", "getDefaultStudentId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getError", "getRefreshToken", "getSignalKit", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStudents", "()Ljava/util/List;", "getSuccess", "()Z", "getUserType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;)Lcom/aeries/mobileportal/models/AuthenticationData;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AuthenticationData.kt */
public final class AuthenticationData implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("AccessToken")
    @Nullable
    @Expose
    private final String accessToken;
    @SerializedName("DefaultStudentID")
    @Nullable
    @Expose
    private final Integer defaultStudentId;
    @SerializedName("error")
    @Nullable
    @Expose
    private final String error;
    @SerializedName("RefreshToken")
    @Nullable
    @Expose
    private final String refreshToken;
    @SerializedName("SignalKit")
    @Nullable
    @Expose
    private final Boolean signalKit;
    @Nullable
    @SerializedName("Students")
    @Expose
    private final List<Student> students;
    @SerializedName("success")
    @Expose
    private final boolean success;
    @SerializedName("UserType")
    @Nullable
    @Expose
    private final String userType;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/AuthenticationData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/AuthenticationData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/AuthenticationData;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AuthenticationData.kt */
    public static final class CREATOR implements Creator<AuthenticationData> {
        private CREATOR() {
        }

        @NotNull
        public AuthenticationData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new AuthenticationData(parcel);
        }

        @NotNull
        public AuthenticationData[] newArray(int i) {
            return new AuthenticationData[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ AuthenticationData copy$default(AuthenticationData authenticationData, boolean z, String str, String str2, String str3, String str4, Integer num, Boolean bool, List list, int i, Object obj) {
        AuthenticationData authenticationData2 = authenticationData;
        int i2 = i;
        return authenticationData.copy((i2 & 1) != 0 ? authenticationData2.success : z, (i2 & 2) != 0 ? authenticationData2.error : str, (i2 & 4) != 0 ? authenticationData2.accessToken : str2, (i2 & 8) != 0 ? authenticationData2.refreshToken : str3, (i2 & 16) != 0 ? authenticationData2.userType : str4, (i2 & 32) != 0 ? authenticationData2.defaultStudentId : num, (i2 & 64) != 0 ? authenticationData2.signalKit : bool, (i2 & 128) != 0 ? authenticationData2.students : list);
    }

    public final boolean component1() {
        return this.success;
    }

    @Nullable
    public final String component2() {
        return this.error;
    }

    @Nullable
    public final String component3() {
        return this.accessToken;
    }

    @Nullable
    public final String component4() {
        return this.refreshToken;
    }

    @Nullable
    public final String component5() {
        return this.userType;
    }

    @Nullable
    public final Integer component6() {
        return this.defaultStudentId;
    }

    @Nullable
    public final Boolean component7() {
        return this.signalKit;
    }

    @Nullable
    public final List<Student> component8() {
        return this.students;
    }

    @NotNull
    public final AuthenticationData copy(boolean z, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable Boolean bool, @Nullable List<? extends Student> list) {
        return new AuthenticationData(z, str, str2, str3, str4, num, bool, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof AuthenticationData) {
                AuthenticationData authenticationData = (AuthenticationData) obj;
                if ((this.success == authenticationData.success) && Intrinsics.areEqual(this.error, authenticationData.error) && Intrinsics.areEqual(this.accessToken, authenticationData.accessToken) && Intrinsics.areEqual(this.refreshToken, authenticationData.refreshToken) && Intrinsics.areEqual(this.userType, authenticationData.userType) && Intrinsics.areEqual(this.defaultStudentId, authenticationData.defaultStudentId) && Intrinsics.areEqual(this.signalKit, authenticationData.signalKit) && Intrinsics.areEqual(this.students, authenticationData.students)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.success;
        if (i != 0) {
            i = 1;
        }
        i *= 31;
        String str = this.error;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.accessToken;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.refreshToken;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.userType;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.defaultStudentId;
        i = (i + (num != null ? num.hashCode() : 0)) * 31;
        Boolean bool = this.signalKit;
        i = (i + (bool != null ? bool.hashCode() : 0)) * 31;
        List list = this.students;
        if (list != null) {
            i2 = list.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AuthenticationData(success=");
        stringBuilder.append(this.success);
        stringBuilder.append(", error=");
        stringBuilder.append(this.error);
        stringBuilder.append(", accessToken=");
        stringBuilder.append(this.accessToken);
        stringBuilder.append(", refreshToken=");
        stringBuilder.append(this.refreshToken);
        stringBuilder.append(", userType=");
        stringBuilder.append(this.userType);
        stringBuilder.append(", defaultStudentId=");
        stringBuilder.append(this.defaultStudentId);
        stringBuilder.append(", signalKit=");
        stringBuilder.append(this.signalKit);
        stringBuilder.append(", students=");
        stringBuilder.append(this.students);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public AuthenticationData(boolean z, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable Boolean bool, @Nullable List<? extends Student> list) {
        this.success = z;
        this.error = str;
        this.accessToken = str2;
        this.refreshToken = str3;
        this.userType = str4;
        this.defaultStudentId = num;
        this.signalKit = bool;
        this.students = list;
    }

    public /* synthetic */ AuthenticationData(boolean z, String str, String str2, String str3, String str4, Integer num, Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, str, str2, str3, str4, num, bool, list);
    }

    public final boolean getSuccess() {
        return this.success;
    }

    @Nullable
    public final String getError() {
        return this.error;
    }

    @Nullable
    public final String getAccessToken() {
        return this.accessToken;
    }

    @Nullable
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @Nullable
    public final String getUserType() {
        return this.userType;
    }

    @Nullable
    public final Integer getDefaultStudentId() {
        return this.defaultStudentId;
    }

    @Nullable
    public final Boolean getSignalKit() {
        return this.signalKit;
    }

    @Nullable
    public final List<Student> getStudents() {
        return this.students;
    }

    public AuthenticationData(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        boolean z = false;
        if (parcel.readByte() != ((byte) null)) {
            z = true;
        }
        boolean z2 = z;
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        Object readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        Integer num = (Integer) readValue;
        readValue = parcel.readValue(Boolean.TYPE.getClassLoader());
        if (!(readValue instanceof Boolean)) {
            readValue = null;
        }
        this(z2, readString, readString2, readString3, readString4, num, (Boolean) readValue, parcel.createTypedArrayList(Student.CREATOR));
    }

    public AuthenticationData() {
        this(true, null, null, null, null, null, null, null);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeByte(this.success);
        parcel.writeString(this.error);
        parcel.writeString(this.accessToken);
        parcel.writeString(this.refreshToken);
        parcel.writeString(this.userType);
        parcel.writeValue(this.defaultStudentId);
        parcel.writeValue(this.signalKit);
        parcel.writeTypedList(this.students);
    }
}
