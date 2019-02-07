package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.AssignmentCategoryRealmProxyInterface;
import io.realm.RealmObject;
import io.realm.internal.RealmObjectProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\"\u001a\u00020\u0011H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0011H\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001e\u0010\u001f\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015¨\u0006'"}, d2 = {"Lcom/aeries/mobileportal/models/AssignmentCategory;", "Lio/realm/RealmObject;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "mark", "", "getMark", "()Ljava/lang/String;", "setMark", "(Ljava/lang/String;)V", "name", "getName", "setName", "numberOfAssignment", "", "getNumberOfAssignment", "()I", "setNumberOfAssignment", "(I)V", "percent", "", "getPercent", "()D", "setPercent", "(D)V", "totalMaxScore", "getTotalMaxScore", "setTotalMaxScore", "totalScore", "getTotalScore", "setTotalScore", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentCategory.kt */
public class AssignmentCategory extends RealmObject implements Parcelable, AssignmentCategoryRealmProxyInterface {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("Mark")
    @Nullable
    @Expose
    private String mark;
    @SerializedName("Name")
    @Nullable
    @Expose
    private String name;
    @SerializedName("NumberOfAssignment")
    @Expose
    private int numberOfAssignment;
    @SerializedName("Percent")
    @Expose
    private double percent;
    @SerializedName("TotalMaxScore")
    @Expose
    private int totalMaxScore;
    @SerializedName("TotalScore")
    @Expose
    private int totalScore;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/AssignmentCategory$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/AssignmentCategory;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/AssignmentCategory;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentCategory.kt */
    public static final class CREATOR implements Creator<AssignmentCategory> {
        private CREATOR() {
        }

        @NotNull
        public AssignmentCategory createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new AssignmentCategory(parcel);
        }

        @NotNull
        public AssignmentCategory[] newArray(int i) {
            return new AssignmentCategory[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public String realmGet$mark() {
        return this.mark;
    }

    public String realmGet$name() {
        return this.name;
    }

    public int realmGet$numberOfAssignment() {
        return this.numberOfAssignment;
    }

    public double realmGet$percent() {
        return this.percent;
    }

    public int realmGet$totalMaxScore() {
        return this.totalMaxScore;
    }

    public int realmGet$totalScore() {
        return this.totalScore;
    }

    public void realmSet$mark(String str) {
        this.mark = str;
    }

    public void realmSet$name(String str) {
        this.name = str;
    }

    public void realmSet$numberOfAssignment(int i) {
        this.numberOfAssignment = i;
    }

    public void realmSet$percent(double d) {
        this.percent = d;
    }

    public void realmSet$totalMaxScore(int i) {
        this.totalMaxScore = i;
    }

    public void realmSet$totalScore(int i) {
        this.totalScore = i;
    }

    public AssignmentCategory() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    @Nullable
    public final String getName() {
        return realmGet$name();
    }

    public final void setName(@Nullable String str) {
        realmSet$name(str);
    }

    public final int getNumberOfAssignment() {
        return realmGet$numberOfAssignment();
    }

    public final void setNumberOfAssignment(int i) {
        realmSet$numberOfAssignment(i);
    }

    @Nullable
    public final String getMark() {
        return realmGet$mark();
    }

    public final void setMark(@Nullable String str) {
        realmSet$mark(str);
    }

    public final int getTotalScore() {
        return realmGet$totalScore();
    }

    public final void setTotalScore(int i) {
        realmSet$totalScore(i);
    }

    public final int getTotalMaxScore() {
        return realmGet$totalMaxScore();
    }

    public final void setTotalMaxScore(int i) {
        realmSet$totalMaxScore(i);
    }

    public final double getPercent() {
        return realmGet$percent();
    }

    public final void setPercent(double d) {
        realmSet$percent(d);
    }

    public AssignmentCategory(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this();
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$name(parcel.readString());
        realmSet$numberOfAssignment(parcel.readInt());
        realmSet$mark(parcel.readString());
        realmSet$totalScore(parcel.readInt());
        realmSet$totalMaxScore(parcel.readInt());
        realmSet$percent(parcel.readDouble());
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(realmGet$name());
        parcel.writeInt(realmGet$numberOfAssignment());
        parcel.writeString(realmGet$mark());
        parcel.writeInt(realmGet$totalScore());
        parcel.writeInt(realmGet$totalMaxScore());
        parcel.writeDouble(realmGet$percent());
    }
}
