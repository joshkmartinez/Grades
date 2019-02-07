package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.StudentRealmProxyInterface;
import io.realm.internal.RealmObjectProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000eH\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/aeries/mobileportal/models/Student;", "Lio/realm/RealmObject;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "demographics", "Lcom/aeries/mobileportal/models/Demographics;", "getDemographics", "()Lcom/aeries/mobileportal/models/Demographics;", "setDemographics", "(Lcom/aeries/mobileportal/models/Demographics;)V", "studentID", "", "getStudentID", "()I", "setStudentID", "(I)V", "views", "Lio/realm/RealmList;", "Lcom/aeries/mobileportal/models/ViewPermission;", "getViews", "()Lio/realm/RealmList;", "setViews", "(Lio/realm/RealmList;)V", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: Student.kt */
public class Student extends RealmObject implements Parcelable, StudentRealmProxyInterface {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("Demographics")
    @NotNull
    @Expose
    private Demographics demographics;
    private int studentID;
    @SerializedName("Views")
    @NotNull
    @Expose
    private RealmList<ViewPermission> views;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/Student$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/Student;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/Student;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Student.kt */
    public static final class CREATOR implements Creator<Student> {
        private CREATOR() {
        }

        @NotNull
        public Student createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new Student(parcel);
        }

        @NotNull
        public Student[] newArray(int i) {
            return new Student[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public Demographics realmGet$demographics() {
        return this.demographics;
    }

    public int realmGet$studentID() {
        return this.studentID;
    }

    public RealmList realmGet$views() {
        return this.views;
    }

    public void realmSet$demographics(Demographics demographics) {
        this.demographics = demographics;
    }

    public void realmSet$studentID(int i) {
        this.studentID = i;
    }

    public void realmSet$views(RealmList realmList) {
        this.views = realmList;
    }

    public Student() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$demographics(new Demographics());
        realmSet$views(new RealmList());
    }

    @NotNull
    public Demographics getDemographics() {
        return realmGet$demographics();
    }

    public void setDemographics(@NotNull Demographics demographics) {
        Intrinsics.checkParameterIsNotNull(demographics, "<set-?>");
        realmSet$demographics(demographics);
    }

    @NotNull
    public RealmList<ViewPermission> getViews() {
        return realmGet$views();
    }

    public void setViews(@NotNull RealmList<ViewPermission> realmList) {
        Intrinsics.checkParameterIsNotNull(realmList, "<set-?>");
        realmSet$views(realmList);
    }

    public int getStudentID() {
        return realmGet$studentID();
    }

    public void setStudentID(int i) {
        realmSet$studentID(i);
    }

    public Student(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this();
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        Parcelable readParcelable = parcel.readParcelable(Demographics.class.getClassLoader());
        Intrinsics.checkExpressionValueIsNotNull(readParcelable, "parcel.readParcelable(De…::class.java.classLoader)");
        setDemographics((Demographics) readParcelable);
        setStudentID(parcel.readInt());
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeParcelable(getDemographics(), i);
        parcel.writeInt(getStudentID());
    }
}
