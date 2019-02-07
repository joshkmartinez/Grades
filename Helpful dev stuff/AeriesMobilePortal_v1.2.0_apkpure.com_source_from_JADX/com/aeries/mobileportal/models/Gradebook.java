package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.GradebookRealmProxyInterface;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.internal.RealmObjectProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u00107\u001a\u00020\u001cH\u0016J\u0018\u00108\u001a\u0002092\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u001cH\u0016R&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010+\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R \u0010.\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R \u00101\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R \u00104\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0015\"\u0004\b6\u0010\u0017¨\u0006<"}, d2 = {"Lcom/aeries/mobileportal/models/Gradebook;", "Lio/realm/RealmObject;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "assignments", "Lio/realm/RealmList;", "Lcom/aeries/mobileportal/models/Assignment;", "getAssignments", "()Lio/realm/RealmList;", "setAssignments", "(Lio/realm/RealmList;)V", "categories", "Lcom/aeries/mobileportal/models/AssignmentCategory;", "getCategories", "setCategories", "endDate", "", "getEndDate", "()Ljava/lang/String;", "setEndDate", "(Ljava/lang/String;)V", "gradebookName", "getGradebookName", "setGradebookName", "gradebookNumber", "", "getGradebookNumber", "()Ljava/lang/Integer;", "setGradebookNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "period", "getPeriod", "setPeriod", "showWhatIf", "", "getShowWhatIf", "()Z", "setShowWhatIf", "(Z)V", "startDate", "getStartDate", "setStartDate", "status", "getStatus", "setStatus", "termCode", "getTermCode", "setTermCode", "termDescription", "getTermDescription", "setTermDescription", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: Gradebook.kt */
public class Gradebook extends RealmObject implements Parcelable, GradebookRealmProxyInterface {
    public static final CREATOR CREATOR = new CREATOR();
    @Nullable
    @SerializedName("Assignments")
    @Expose
    private RealmList<Assignment> assignments;
    @Nullable
    @SerializedName("Categories")
    @Expose
    private RealmList<AssignmentCategory> categories;
    @SerializedName("EndDate")
    @NotNull
    @Expose
    private String endDate;
    @SerializedName("GradebookName")
    @Nullable
    @Expose
    private String gradebookName;
    @SerializedName("GradebookNumber")
    @Nullable
    @Expose
    private Integer gradebookNumber;
    @SerializedName("Period")
    @Nullable
    @Expose
    private Integer period;
    @SerializedName("ShowWhatIf")
    @Expose
    private boolean showWhatIf;
    @SerializedName("StartDate")
    @Nullable
    @Expose
    private String startDate;
    @SerializedName("Status")
    @Nullable
    @Expose
    private String status;
    @SerializedName("TermCode")
    @Nullable
    @Expose
    private String termCode;
    @SerializedName("TermDescription")
    @Nullable
    @Expose
    private String termDescription;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/Gradebook$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/Gradebook;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/Gradebook;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Gradebook.kt */
    public static final class CREATOR implements Creator<Gradebook> {
        private CREATOR() {
        }

        @NotNull
        public Gradebook createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new Gradebook(parcel);
        }

        @NotNull
        public Gradebook[] newArray(int i) {
            return new Gradebook[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public RealmList realmGet$assignments() {
        return this.assignments;
    }

    public RealmList realmGet$categories() {
        return this.categories;
    }

    public String realmGet$endDate() {
        return this.endDate;
    }

    public String realmGet$gradebookName() {
        return this.gradebookName;
    }

    public Integer realmGet$gradebookNumber() {
        return this.gradebookNumber;
    }

    public Integer realmGet$period() {
        return this.period;
    }

    public boolean realmGet$showWhatIf() {
        return this.showWhatIf;
    }

    public String realmGet$startDate() {
        return this.startDate;
    }

    public String realmGet$status() {
        return this.status;
    }

    public String realmGet$termCode() {
        return this.termCode;
    }

    public String realmGet$termDescription() {
        return this.termDescription;
    }

    public void realmSet$assignments(RealmList realmList) {
        this.assignments = realmList;
    }

    public void realmSet$categories(RealmList realmList) {
        this.categories = realmList;
    }

    public void realmSet$endDate(String str) {
        this.endDate = str;
    }

    public void realmSet$gradebookName(String str) {
        this.gradebookName = str;
    }

    public void realmSet$gradebookNumber(Integer num) {
        this.gradebookNumber = num;
    }

    public void realmSet$period(Integer num) {
        this.period = num;
    }

    public void realmSet$showWhatIf(boolean z) {
        this.showWhatIf = z;
    }

    public void realmSet$startDate(String str) {
        this.startDate = str;
    }

    public void realmSet$status(String str) {
        this.status = str;
    }

    public void realmSet$termCode(String str) {
        this.termCode = str;
    }

    public void realmSet$termDescription(String str) {
        this.termDescription = str;
    }

    public Gradebook() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$gradebookNumber(Integer.valueOf(0));
        realmSet$gradebookName("");
        realmSet$termCode("");
        realmSet$termDescription("");
        realmSet$status("");
        realmSet$period(Integer.valueOf(0));
        realmSet$startDate("");
        realmSet$endDate("");
        realmSet$categories(new RealmList());
        realmSet$assignments(new RealmList());
    }

    @Nullable
    public final Integer getGradebookNumber() {
        return realmGet$gradebookNumber();
    }

    public final void setGradebookNumber(@Nullable Integer num) {
        realmSet$gradebookNumber(num);
    }

    @Nullable
    public final String getGradebookName() {
        return realmGet$gradebookName();
    }

    public final void setGradebookName(@Nullable String str) {
        realmSet$gradebookName(str);
    }

    @Nullable
    public final String getTermCode() {
        return realmGet$termCode();
    }

    public final void setTermCode(@Nullable String str) {
        realmSet$termCode(str);
    }

    @Nullable
    public final String getTermDescription() {
        return realmGet$termDescription();
    }

    public final void setTermDescription(@Nullable String str) {
        realmSet$termDescription(str);
    }

    @Nullable
    public final String getStatus() {
        return realmGet$status();
    }

    public final void setStatus(@Nullable String str) {
        realmSet$status(str);
    }

    @Nullable
    public final Integer getPeriod() {
        return realmGet$period();
    }

    public final void setPeriod(@Nullable Integer num) {
        realmSet$period(num);
    }

    @Nullable
    public final String getStartDate() {
        return realmGet$startDate();
    }

    public final void setStartDate(@Nullable String str) {
        realmSet$startDate(str);
    }

    @NotNull
    public final String getEndDate() {
        return realmGet$endDate();
    }

    public final void setEndDate(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$endDate(str);
    }

    public final boolean getShowWhatIf() {
        return realmGet$showWhatIf();
    }

    public final void setShowWhatIf(boolean z) {
        realmSet$showWhatIf(z);
    }

    @Nullable
    public final RealmList<AssignmentCategory> getCategories() {
        return realmGet$categories();
    }

    public final void setCategories(@Nullable RealmList<AssignmentCategory> realmList) {
        realmSet$categories(realmList);
    }

    @Nullable
    public final RealmList<Assignment> getAssignments() {
        return realmGet$assignments();
    }

    public final void setAssignments(@Nullable RealmList<Assignment> realmList) {
        realmSet$assignments(realmList);
    }

    public Gradebook(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this();
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        Object readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        realmSet$gradebookNumber((Integer) readValue);
        realmSet$gradebookName(parcel.readString());
        realmSet$termCode(parcel.readString());
        realmSet$termDescription(parcel.readString());
        realmSet$status(parcel.readString());
        readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        realmSet$period((Integer) readValue);
        realmSet$startDate(parcel.readString());
        parcel = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(parcel, "parcel.readString()");
        realmSet$endDate(parcel);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeValue(realmGet$gradebookNumber());
        parcel.writeString(realmGet$gradebookName());
        parcel.writeString(realmGet$termCode());
        parcel.writeString(realmGet$termDescription());
        parcel.writeString(realmGet$status());
        parcel.writeValue(realmGet$period());
        parcel.writeString(realmGet$startDate());
        parcel.writeString(realmGet$endDate());
    }
}
