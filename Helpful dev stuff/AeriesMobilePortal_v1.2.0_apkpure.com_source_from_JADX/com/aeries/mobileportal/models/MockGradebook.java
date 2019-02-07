package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.MockGradebookRealmProxyInterface;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.internal.RealmObjectProxy;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0018H\u0016R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/aeries/mobileportal/models/MockGradebook;", "Lio/realm/RealmObject;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "assignments", "Lio/realm/RealmList;", "Lcom/aeries/mobileportal/models/MockAssignment;", "getAssignments", "()Lio/realm/RealmList;", "setAssignments", "(Lio/realm/RealmList;)V", "gradebookNumber", "", "getGradebookNumber", "()Ljava/lang/String;", "setGradebookNumber", "(Ljava/lang/String;)V", "termCode", "getTermCode", "setTermCode", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: MockGradebook.kt */
public class MockGradebook extends RealmObject implements Parcelable, MockGradebookRealmProxyInterface {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("Assignments")
    @NotNull
    @Expose
    private RealmList<MockAssignment> assignments;
    @SerializedName("GradebookNumber")
    @NotNull
    @Expose
    private String gradebookNumber;
    @SerializedName("TermCode")
    @NotNull
    @Expose
    private String termCode;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/MockGradebook$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/MockGradebook;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/MockGradebook;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: MockGradebook.kt */
    public static final class CREATOR implements Creator<MockGradebook> {
        private CREATOR() {
        }

        @NotNull
        public MockGradebook createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new MockGradebook(parcel);
        }

        @NotNull
        public MockGradebook[] newArray(int i) {
            return new MockGradebook[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public RealmList realmGet$assignments() {
        return this.assignments;
    }

    public String realmGet$gradebookNumber() {
        return this.gradebookNumber;
    }

    public String realmGet$termCode() {
        return this.termCode;
    }

    public void realmSet$assignments(RealmList realmList) {
        this.assignments = realmList;
    }

    public void realmSet$gradebookNumber(String str) {
        this.gradebookNumber = str;
    }

    public void realmSet$termCode(String str) {
        this.termCode = str;
    }

    public MockGradebook() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$gradebookNumber("");
        realmSet$termCode("");
        realmSet$assignments(new RealmList());
    }

    @NotNull
    public final String getGradebookNumber() {
        return realmGet$gradebookNumber();
    }

    public final void setGradebookNumber(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$gradebookNumber(str);
    }

    @NotNull
    public final String getTermCode() {
        return realmGet$termCode();
    }

    public final void setTermCode(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$termCode(str);
    }

    @NotNull
    public final RealmList<MockAssignment> getAssignments() {
        return realmGet$assignments();
    }

    public final void setAssignments(@NotNull RealmList<MockAssignment> realmList) {
        Intrinsics.checkParameterIsNotNull(realmList, "<set-?>");
        realmSet$assignments(realmList);
    }

    public MockGradebook(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this();
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        realmSet$gradebookNumber(readString);
        readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        realmSet$termCode(readString);
        parcel = parcel.createTypedArrayList(MockAssignment.CREATOR);
        RealmList realmList = new RealmList();
        realmList.addAll((Collection) parcel);
        realmSet$assignments(realmList);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(realmGet$gradebookNumber());
        parcel.writeString(realmGet$termCode());
        parcel.writeTypedList(realmGet$assignments());
    }
}
