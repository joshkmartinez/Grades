package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.AssignmentRealmProxyInterface;
import io.realm.RealmObject;
import io.realm.internal.RealmObjectProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001WB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010S\u001a\u00020\u000eH\u0016J\u0018\u0010T\u001a\u00020U2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u000eH\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR \u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\fR \u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\fR \u0010\u001d\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\fR \u0010 \u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR \u0010#\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\n\"\u0004\b%\u0010\fR\u001c\u0010&\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\n\"\u0004\b(\u0010\fR\u001e\u0010)\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010+\"\u0004\b/\u0010-R\"\u00100\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b5\u00101\"\u0004\b6\u00103R \u00107\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\n\"\u0004\b9\u0010\fR\"\u0010:\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010@\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010@\u001a\u0004\bB\u0010=\"\u0004\bC\u0010?R\"\u0010D\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010@\u001a\u0004\bE\u0010=\"\u0004\bF\u0010?R\"\u0010G\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010@\u001a\u0004\bH\u0010=\"\u0004\bI\u0010?R\u001e\u0010J\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010+\"\u0004\bL\u0010-R\"\u0010M\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010@\u001a\u0004\bN\u0010=\"\u0004\bO\u0010?R \u0010P\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\n\"\u0004\bR\u0010\f¨\u0006X"}, d2 = {"Lcom/aeries/mobileportal/models/Assignment;", "Lio/realm/RealmObject;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "assignmentDescription", "", "getAssignmentDescription", "()Ljava/lang/String;", "setAssignmentDescription", "(Ljava/lang/String;)V", "assignmentNumber", "", "getAssignmentNumber", "()Ljava/lang/Integer;", "setAssignmentNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "category", "getCategory", "setCategory", "comment", "getComment", "setComment", "dateAssigned", "getDateAssigned", "setDateAssigned", "dateCompleted", "getDateCompleted", "setDateCompleted", "dateDue", "getDateDue", "setDateDue", "description", "getDescription", "setDescription", "gradebookName", "getGradebookName", "setGradebookName", "isExtraCredit", "", "()Z", "setExtraCredit", "(Z)V", "isGraded", "setGraded", "isScoreValueACheckMark", "()Ljava/lang/Boolean;", "setScoreValueACheckMark", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isScoreVisibleToParents", "setScoreVisibleToParents", "mark", "getMark", "setMark", "maxScore", "", "getMaxScore", "()Ljava/lang/Double;", "setMaxScore", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "numberCorrect", "getNumberCorrect", "setNumberCorrect", "numberPossible", "getNumberPossible", "setNumberPossible", "percent", "getPercent", "setPercent", "rubricAssignMent", "getRubricAssignMent", "setRubricAssignMent", "score", "getScore", "setScore", "type", "getType", "setType", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: Assignment.kt */
public class Assignment extends RealmObject implements Parcelable, AssignmentRealmProxyInterface {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("AssignmentDescription")
    @Nullable
    @Expose
    private String assignmentDescription;
    @SerializedName("AssignmentNumber")
    @Nullable
    @Expose
    private Integer assignmentNumber;
    @SerializedName("Category")
    @Nullable
    @Expose
    private String category;
    @SerializedName("Comment")
    @Nullable
    @Expose
    private String comment;
    @SerializedName("DateAssigned")
    @Nullable
    @Expose
    private String dateAssigned;
    @SerializedName("DateCompleted")
    @Nullable
    @Expose
    private String dateCompleted;
    @SerializedName("DateDue")
    @Nullable
    @Expose
    private String dateDue;
    @SerializedName("Description")
    @Nullable
    @Expose
    private String description;
    @Nullable
    private String gradebookName;
    @SerializedName("IsExtraCredit")
    @Expose
    private boolean isExtraCredit;
    @SerializedName("IsGraded")
    @Expose
    private boolean isGraded;
    @SerializedName("IsScoreValueACheckMark")
    @Nullable
    @Expose
    private Boolean isScoreValueACheckMark;
    @SerializedName("IsScoreVisibleToParents")
    @Nullable
    @Expose
    private Boolean isScoreVisibleToParents;
    @SerializedName("Mark")
    @Nullable
    @Expose
    private String mark;
    @SerializedName("MaxScore")
    @Nullable
    @Expose
    private Double maxScore;
    @SerializedName("NumberCorrect")
    @Nullable
    @Expose
    private Double numberCorrect;
    @SerializedName("NumberPossible")
    @Nullable
    @Expose
    private Double numberPossible;
    @SerializedName("Percent")
    @Nullable
    @Expose
    private Double percent;
    @SerializedName("RubricAssignMent")
    @Expose
    private boolean rubricAssignMent;
    @SerializedName("Score")
    @Nullable
    @Expose
    private Double score;
    @SerializedName("Type")
    @Nullable
    @Expose
    private String type;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/Assignment$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/Assignment;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/Assignment;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Assignment.kt */
    public static final class CREATOR implements Creator<Assignment> {
        private CREATOR() {
        }

        @NotNull
        public Assignment createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new Assignment(parcel);
        }

        @NotNull
        public Assignment[] newArray(int i) {
            return new Assignment[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public String realmGet$assignmentDescription() {
        return this.assignmentDescription;
    }

    public Integer realmGet$assignmentNumber() {
        return this.assignmentNumber;
    }

    public String realmGet$category() {
        return this.category;
    }

    public String realmGet$comment() {
        return this.comment;
    }

    public String realmGet$dateAssigned() {
        return this.dateAssigned;
    }

    public String realmGet$dateCompleted() {
        return this.dateCompleted;
    }

    public String realmGet$dateDue() {
        return this.dateDue;
    }

    public String realmGet$description() {
        return this.description;
    }

    public String realmGet$gradebookName() {
        return this.gradebookName;
    }

    public boolean realmGet$isExtraCredit() {
        return this.isExtraCredit;
    }

    public boolean realmGet$isGraded() {
        return this.isGraded;
    }

    public Boolean realmGet$isScoreValueACheckMark() {
        return this.isScoreValueACheckMark;
    }

    public Boolean realmGet$isScoreVisibleToParents() {
        return this.isScoreVisibleToParents;
    }

    public String realmGet$mark() {
        return this.mark;
    }

    public Double realmGet$maxScore() {
        return this.maxScore;
    }

    public Double realmGet$numberCorrect() {
        return this.numberCorrect;
    }

    public Double realmGet$numberPossible() {
        return this.numberPossible;
    }

    public Double realmGet$percent() {
        return this.percent;
    }

    public boolean realmGet$rubricAssignMent() {
        return this.rubricAssignMent;
    }

    public Double realmGet$score() {
        return this.score;
    }

    public String realmGet$type() {
        return this.type;
    }

    public void realmSet$assignmentDescription(String str) {
        this.assignmentDescription = str;
    }

    public void realmSet$assignmentNumber(Integer num) {
        this.assignmentNumber = num;
    }

    public void realmSet$category(String str) {
        this.category = str;
    }

    public void realmSet$comment(String str) {
        this.comment = str;
    }

    public void realmSet$dateAssigned(String str) {
        this.dateAssigned = str;
    }

    public void realmSet$dateCompleted(String str) {
        this.dateCompleted = str;
    }

    public void realmSet$dateDue(String str) {
        this.dateDue = str;
    }

    public void realmSet$description(String str) {
        this.description = str;
    }

    public void realmSet$gradebookName(String str) {
        this.gradebookName = str;
    }

    public void realmSet$isExtraCredit(boolean z) {
        this.isExtraCredit = z;
    }

    public void realmSet$isGraded(boolean z) {
        this.isGraded = z;
    }

    public void realmSet$isScoreValueACheckMark(Boolean bool) {
        this.isScoreValueACheckMark = bool;
    }

    public void realmSet$isScoreVisibleToParents(Boolean bool) {
        this.isScoreVisibleToParents = bool;
    }

    public void realmSet$mark(String str) {
        this.mark = str;
    }

    public void realmSet$maxScore(Double d) {
        this.maxScore = d;
    }

    public void realmSet$numberCorrect(Double d) {
        this.numberCorrect = d;
    }

    public void realmSet$numberPossible(Double d) {
        this.numberPossible = d;
    }

    public void realmSet$percent(Double d) {
        this.percent = d;
    }

    public void realmSet$rubricAssignMent(boolean z) {
        this.rubricAssignMent = z;
    }

    public void realmSet$score(Double d) {
        this.score = d;
    }

    public void realmSet$type(String str) {
        this.type = str;
    }

    public Assignment() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$assignmentNumber(Integer.valueOf(0));
        realmSet$description("");
        realmSet$type("");
        realmSet$category("");
        realmSet$isScoreVisibleToParents(Boolean.valueOf(false));
        realmSet$isScoreValueACheckMark(Boolean.valueOf(false));
        realmSet$numberCorrect(Double.valueOf(0.0d));
        realmSet$numberPossible(Double.valueOf(0.0d));
        realmSet$mark("");
        realmSet$score(Double.valueOf(0.0d));
        realmSet$maxScore(Double.valueOf(0.0d));
        realmSet$percent(Double.valueOf(0.0d));
        realmSet$dateAssigned("");
        realmSet$dateDue("");
        realmSet$dateCompleted("");
        realmSet$comment("");
        realmSet$assignmentDescription("");
        realmSet$gradebookName("");
    }

    @Nullable
    public final Integer getAssignmentNumber() {
        return realmGet$assignmentNumber();
    }

    public final void setAssignmentNumber(@Nullable Integer num) {
        realmSet$assignmentNumber(num);
    }

    @Nullable
    public final String getDescription() {
        return realmGet$description();
    }

    public final void setDescription(@Nullable String str) {
        realmSet$description(str);
    }

    @Nullable
    public final String getType() {
        return realmGet$type();
    }

    public final void setType(@Nullable String str) {
        realmSet$type(str);
    }

    @Nullable
    public final String getCategory() {
        return realmGet$category();
    }

    public final void setCategory(@Nullable String str) {
        realmSet$category(str);
    }

    public final boolean isGraded() {
        return realmGet$isGraded();
    }

    public final void setGraded(boolean z) {
        realmSet$isGraded(z);
    }

    public final boolean isExtraCredit() {
        return realmGet$isExtraCredit();
    }

    public final void setExtraCredit(boolean z) {
        realmSet$isExtraCredit(z);
    }

    @Nullable
    public final Boolean isScoreVisibleToParents() {
        return realmGet$isScoreVisibleToParents();
    }

    public final void setScoreVisibleToParents(@Nullable Boolean bool) {
        realmSet$isScoreVisibleToParents(bool);
    }

    @Nullable
    public final Boolean isScoreValueACheckMark() {
        return realmGet$isScoreValueACheckMark();
    }

    public final void setScoreValueACheckMark(@Nullable Boolean bool) {
        realmSet$isScoreValueACheckMark(bool);
    }

    @Nullable
    public final Double getNumberCorrect() {
        return realmGet$numberCorrect();
    }

    public final void setNumberCorrect(@Nullable Double d) {
        realmSet$numberCorrect(d);
    }

    @Nullable
    public final Double getNumberPossible() {
        return realmGet$numberPossible();
    }

    public final void setNumberPossible(@Nullable Double d) {
        realmSet$numberPossible(d);
    }

    @Nullable
    public final String getMark() {
        return realmGet$mark();
    }

    public final void setMark(@Nullable String str) {
        realmSet$mark(str);
    }

    @Nullable
    public final Double getScore() {
        return realmGet$score();
    }

    public final void setScore(@Nullable Double d) {
        realmSet$score(d);
    }

    @Nullable
    public final Double getMaxScore() {
        return realmGet$maxScore();
    }

    public final void setMaxScore(@Nullable Double d) {
        realmSet$maxScore(d);
    }

    @Nullable
    public final Double getPercent() {
        return realmGet$percent();
    }

    public final void setPercent(@Nullable Double d) {
        realmSet$percent(d);
    }

    @Nullable
    public final String getDateAssigned() {
        return realmGet$dateAssigned();
    }

    public final void setDateAssigned(@Nullable String str) {
        realmSet$dateAssigned(str);
    }

    @Nullable
    public final String getDateDue() {
        return realmGet$dateDue();
    }

    public final void setDateDue(@Nullable String str) {
        realmSet$dateDue(str);
    }

    @Nullable
    public final String getDateCompleted() {
        return realmGet$dateCompleted();
    }

    public final void setDateCompleted(@Nullable String str) {
        realmSet$dateCompleted(str);
    }

    public final boolean getRubricAssignMent() {
        return realmGet$rubricAssignMent();
    }

    public final void setRubricAssignMent(boolean z) {
        realmSet$rubricAssignMent(z);
    }

    @Nullable
    public final String getComment() {
        return realmGet$comment();
    }

    public final void setComment(@Nullable String str) {
        realmSet$comment(str);
    }

    @Nullable
    public final String getAssignmentDescription() {
        return realmGet$assignmentDescription();
    }

    public final void setAssignmentDescription(@Nullable String str) {
        realmSet$assignmentDescription(str);
    }

    @Nullable
    public final String getGradebookName() {
        return realmGet$gradebookName();
    }

    public final void setGradebookName(@Nullable String str) {
        realmSet$gradebookName(str);
    }

    public Assignment(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this();
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        Object readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        realmSet$assignmentNumber((Integer) readValue);
        realmSet$description(parcel.readString());
        realmSet$type(parcel.readString());
        realmSet$category(parcel.readString());
        boolean z = false;
        byte b = (byte) null;
        realmSet$isGraded(parcel.readByte() != b);
        realmSet$isExtraCredit(parcel.readByte() != b);
        readValue = parcel.readValue(Boolean.TYPE.getClassLoader());
        if (!(readValue instanceof Boolean)) {
            readValue = null;
        }
        realmSet$isScoreVisibleToParents((Boolean) readValue);
        readValue = parcel.readValue(Boolean.TYPE.getClassLoader());
        if (!(readValue instanceof Boolean)) {
            readValue = null;
        }
        realmSet$isScoreValueACheckMark((Boolean) readValue);
        readValue = parcel.readValue(Double.TYPE.getClassLoader());
        if (!(readValue instanceof Double)) {
            readValue = null;
        }
        realmSet$numberCorrect((Double) readValue);
        readValue = parcel.readValue(Double.TYPE.getClassLoader());
        if (!(readValue instanceof Double)) {
            readValue = null;
        }
        realmSet$numberPossible((Double) readValue);
        realmSet$mark(parcel.readString());
        readValue = parcel.readValue(Double.TYPE.getClassLoader());
        if (!(readValue instanceof Double)) {
            readValue = null;
        }
        realmSet$score((Double) readValue);
        readValue = parcel.readValue(Double.TYPE.getClassLoader());
        if (!(readValue instanceof Double)) {
            readValue = null;
        }
        realmSet$maxScore((Double) readValue);
        readValue = parcel.readValue(Double.TYPE.getClassLoader());
        if (!(readValue instanceof Double)) {
            readValue = null;
        }
        realmSet$percent((Double) readValue);
        realmSet$dateAssigned(parcel.readString());
        realmSet$dateDue(parcel.readString());
        realmSet$dateCompleted(parcel.readString());
        if (parcel.readByte() != b) {
            z = true;
        }
        realmSet$rubricAssignMent(z);
        realmSet$comment(parcel.readString());
        realmSet$assignmentDescription(parcel.readString());
        realmSet$gradebookName(parcel.readString());
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeValue(realmGet$assignmentNumber());
        parcel.writeString(realmGet$description());
        parcel.writeString(realmGet$type());
        parcel.writeString(realmGet$category());
        parcel.writeByte(realmGet$isGraded());
        parcel.writeByte(realmGet$isExtraCredit());
        parcel.writeValue(realmGet$isScoreVisibleToParents());
        parcel.writeValue(realmGet$isScoreValueACheckMark());
        parcel.writeValue(realmGet$numberCorrect());
        parcel.writeValue(realmGet$numberPossible());
        parcel.writeString(realmGet$mark());
        parcel.writeValue(realmGet$score());
        parcel.writeValue(realmGet$maxScore());
        parcel.writeValue(realmGet$percent());
        parcel.writeString(realmGet$dateAssigned());
        parcel.writeString(realmGet$dateDue());
        parcel.writeString(realmGet$dateCompleted());
        parcel.writeByte(realmGet$rubricAssignMent());
        parcel.writeString(realmGet$comment());
        parcel.writeString(realmGet$assignmentDescription());
        parcel.writeString(realmGet$gradebookName());
    }
}
