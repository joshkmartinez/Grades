package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.CalculateScoreRequestRealmProxyInterface;
import io.realm.RealmObject;
import io.realm.internal.RealmObjectProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0017H\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/aeries/mobileportal/models/CalculateScoreRequest;", "Lio/realm/RealmObject;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "gradebook", "Lcom/aeries/mobileportal/models/MockGradebook;", "getGradebook", "()Lcom/aeries/mobileportal/models/MockGradebook;", "setGradebook", "(Lcom/aeries/mobileportal/models/MockGradebook;)V", "schoolNumber", "", "getSchoolNumber", "()Ljava/lang/String;", "setSchoolNumber", "(Ljava/lang/String;)V", "studentId", "getStudentId", "setStudentId", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CalculateScoreRequest.kt */
public class CalculateScoreRequest extends RealmObject implements Parcelable, CalculateScoreRequestRealmProxyInterface {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("gn")
    @Nullable
    @Expose
    private MockGradebook gradebook;
    @SerializedName("sc")
    @NotNull
    @Expose
    private String schoolNumber;
    @SerializedName("id")
    @NotNull
    @Expose
    private String studentId;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/CalculateScoreRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/CalculateScoreRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/CalculateScoreRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: CalculateScoreRequest.kt */
    public static final class CREATOR implements Creator<CalculateScoreRequest> {
        private CREATOR() {
        }

        @NotNull
        public CalculateScoreRequest createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new CalculateScoreRequest(parcel);
        }

        @NotNull
        public CalculateScoreRequest[] newArray(int i) {
            return new CalculateScoreRequest[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public MockGradebook realmGet$gradebook() {
        return this.gradebook;
    }

    public String realmGet$schoolNumber() {
        return this.schoolNumber;
    }

    public String realmGet$studentId() {
        return this.studentId;
    }

    public void realmSet$gradebook(MockGradebook mockGradebook) {
        this.gradebook = mockGradebook;
    }

    public void realmSet$schoolNumber(String str) {
        this.schoolNumber = str;
    }

    public void realmSet$studentId(String str) {
        this.studentId = str;
    }

    public CalculateScoreRequest() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$schoolNumber("");
        realmSet$studentId("");
    }

    @NotNull
    public final String getSchoolNumber() {
        return realmGet$schoolNumber();
    }

    public final void setSchoolNumber(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$schoolNumber(str);
    }

    @NotNull
    public final String getStudentId() {
        return realmGet$studentId();
    }

    public final void setStudentId(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$studentId(str);
    }

    @Nullable
    public final MockGradebook getGradebook() {
        return realmGet$gradebook();
    }

    public final void setGradebook(@Nullable MockGradebook mockGradebook) {
        realmSet$gradebook(mockGradebook);
    }

    public CalculateScoreRequest(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this();
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        realmSet$schoolNumber(readString);
        readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        realmSet$studentId(readString);
        realmSet$gradebook((MockGradebook) parcel.readParcelable(MockGradebook.class.getClassLoader()));
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(realmGet$schoolNumber());
        parcel.writeString(realmGet$studentId());
        parcel.writeParcelable(realmGet$gradebook(), i);
    }
}
