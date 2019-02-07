package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.MockAssignmentRealmProxyInterface;
import io.realm.RealmObject;
import io.realm.internal.RealmObjectProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001aH\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001e\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001e\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001e\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/aeries/mobileportal/models/MockAssignment;", "Lio/realm/RealmObject;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "assignmentNumber", "", "getAssignmentNumber", "()Ljava/lang/String;", "setAssignmentNumber", "(Ljava/lang/String;)V", "category", "getCategory", "setCategory", "mark", "getMark", "setMark", "maxScore", "getMaxScore", "setMaxScore", "score", "getScore", "setScore", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: MockAssignment.kt */
public class MockAssignment extends RealmObject implements Parcelable, MockAssignmentRealmProxyInterface {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("AssignmentNumber")
    @NotNull
    @Expose
    private String assignmentNumber;
    @SerializedName("Category")
    @NotNull
    @Expose
    private String category;
    @SerializedName("Mark")
    @NotNull
    @Expose
    private String mark;
    @SerializedName("MaxScore")
    @NotNull
    @Expose
    private String maxScore;
    @SerializedName("Score")
    @NotNull
    @Expose
    private String score;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/MockAssignment$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/MockAssignment;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/MockAssignment;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: MockAssignment.kt */
    public static final class CREATOR implements Creator<MockAssignment> {
        private CREATOR() {
        }

        @NotNull
        public MockAssignment createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new MockAssignment(parcel);
        }

        @NotNull
        public MockAssignment[] newArray(int i) {
            return new MockAssignment[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public String realmGet$assignmentNumber() {
        return this.assignmentNumber;
    }

    public String realmGet$category() {
        return this.category;
    }

    public String realmGet$mark() {
        return this.mark;
    }

    public String realmGet$maxScore() {
        return this.maxScore;
    }

    public String realmGet$score() {
        return this.score;
    }

    public void realmSet$assignmentNumber(String str) {
        this.assignmentNumber = str;
    }

    public void realmSet$category(String str) {
        this.category = str;
    }

    public void realmSet$mark(String str) {
        this.mark = str;
    }

    public void realmSet$maxScore(String str) {
        this.maxScore = str;
    }

    public void realmSet$score(String str) {
        this.score = str;
    }

    public MockAssignment() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$category("");
        realmSet$assignmentNumber("");
        realmSet$mark("");
        realmSet$score("");
        realmSet$maxScore("");
    }

    @NotNull
    public final String getCategory() {
        return realmGet$category();
    }

    public final void setCategory(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$category(str);
    }

    @NotNull
    public final String getAssignmentNumber() {
        return realmGet$assignmentNumber();
    }

    public final void setAssignmentNumber(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$assignmentNumber(str);
    }

    @NotNull
    public final String getMark() {
        return realmGet$mark();
    }

    public final void setMark(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$mark(str);
    }

    @NotNull
    public final String getScore() {
        return realmGet$score();
    }

    public final void setScore(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$score(str);
    }

    @NotNull
    public final String getMaxScore() {
        return realmGet$maxScore();
    }

    public final void setMaxScore(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$maxScore(str);
    }

    public MockAssignment(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this();
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        realmSet$category(readString);
        readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        realmSet$assignmentNumber(readString);
        readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        realmSet$mark(readString);
        readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        realmSet$score(readString);
        parcel = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(parcel, "parcel.readString()");
        realmSet$maxScore(parcel);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(realmGet$category());
        parcel.writeString(realmGet$assignmentNumber());
        parcel.writeString(realmGet$mark());
        parcel.writeString(realmGet$score());
        parcel.writeString(realmGet$maxScore());
    }
}
