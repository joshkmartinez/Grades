package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.ClassSummaryRealmProxyInterface;
import io.realm.RealmObject;
import io.realm.internal.RealmObjectProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b(\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0001[B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010W\u001a\u00020 H\u0016J\u0018\u0010X\u001a\u00020Y2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020 H\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR \u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR\"\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010&\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0019\"\u0004\b(\u0010\u001bR \u0010)\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\n\"\u0004\b+\u0010\fR\"\u0010,\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$R\"\u0010/\u001a\u0004\u0018\u0001008\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b7\u0010\"\"\u0004\b8\u0010$R \u00109\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\n\"\u0004\b;\u0010\fR\u001e\u0010<\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b=\u0010\"\"\u0004\b>\u0010$R\u001a\u0010?\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\n\"\u0004\bA\u0010\fR\"\u0010B\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\bC\u0010\"\"\u0004\bD\u0010$R\u001a\u0010E\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0019\"\u0004\bG\u0010\u001bR\u001e\u0010H\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\bI\u0010\"\"\u0004\bJ\u0010$R \u0010K\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\n\"\u0004\bM\u0010\fR\"\u0010N\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\bO\u0010\"\"\u0004\bP\u0010$R \u0010Q\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\n\"\u0004\bS\u0010\fR \u0010T\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\n\"\u0004\bV\u0010\f¨\u0006\\"}, d2 = {"Lcom/aeries/mobileportal/models/ClassSummary;", "Lio/realm/RealmObject;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "average", "", "getAverage", "()Ljava/lang/String;", "setAverage", "(Ljava/lang/String;)V", "courseNumber", "getCourseNumber", "setCourseNumber", "courseTitle", "getCourseTitle", "setCourseTitle", "currentMark", "getCurrentMark", "setCurrentMark", "doingRubric", "", "getDoingRubric", "()Z", "setDoingRubric", "(Z)V", "gradeBookName", "getGradeBookName", "setGradeBookName", "gradeBookNumber", "", "getGradeBookNumber", "()Ljava/lang/Integer;", "setGradeBookNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "hideScores", "getHideScores", "setHideScores", "lastUpdated", "getLastUpdated", "setLastUpdated", "missingAssignment", "getMissingAssignment", "setMissingAssignment", "percent", "", "getPercent", "()Ljava/lang/Double;", "setPercent", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "period", "getPeriod", "setPeriod", "roomNumber", "getRoomNumber", "setRoomNumber", "schoolCode", "getSchoolCode", "setSchoolCode", "schoolName", "getSchoolName", "setSchoolName", "sectionNumber", "getSectionNumber", "setSectionNumber", "showPeriod", "getShowPeriod", "setShowPeriod", "studentID", "getStudentID", "setStudentID", "teacherName", "getTeacherName", "setTeacherName", "teacherNumber", "getTeacherNumber", "setTeacherNumber", "term", "getTerm", "setTerm", "termCode", "getTermCode", "setTermCode", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ClassSummary.kt */
public class ClassSummary extends RealmObject implements Parcelable, ClassSummaryRealmProxyInterface {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("Average")
    @Nullable
    @Expose
    private String average;
    @SerializedName("CourseNumber")
    @Nullable
    @Expose
    private String courseNumber;
    @SerializedName("CourseTitle")
    @Nullable
    @Expose
    private String courseTitle;
    @SerializedName("CurrentMark")
    @Nullable
    @Expose
    private String currentMark;
    @SerializedName("DoingRubric")
    @Expose
    private boolean doingRubric;
    @SerializedName("GradeBookName")
    @Nullable
    @Expose
    private String gradeBookName;
    @SerializedName("GradeBookNumber")
    @Nullable
    @Expose
    private Integer gradeBookNumber;
    private boolean hideScores;
    @SerializedName("LastUpdated")
    @Nullable
    @Expose
    private String lastUpdated;
    @SerializedName("MissingAssignment")
    @Nullable
    @Expose
    private Integer missingAssignment;
    @SerializedName("Percent")
    @Nullable
    @Expose
    private Double percent;
    @SerializedName("Period")
    @Nullable
    @Expose
    private Integer period;
    @SerializedName("RoomNumber")
    @Nullable
    @Expose
    private String roomNumber;
    @Nullable
    private Integer schoolCode;
    @NotNull
    private String schoolName;
    @SerializedName("SectionNumber")
    @Nullable
    @Expose
    private Integer sectionNumber;
    private boolean showPeriod;
    @Nullable
    private Integer studentID;
    @SerializedName("TeacherName")
    @Nullable
    @Expose
    private String teacherName;
    @SerializedName("TeacherNumber")
    @Nullable
    @Expose
    private Integer teacherNumber;
    @SerializedName("Term")
    @Nullable
    @Expose
    private String term;
    @SerializedName("TermCode")
    @Nullable
    @Expose
    private String termCode;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/ClassSummary$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/ClassSummary;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/ClassSummary;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ClassSummary.kt */
    public static final class CREATOR implements Creator<ClassSummary> {
        private CREATOR() {
        }

        @NotNull
        public ClassSummary createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new ClassSummary(parcel);
        }

        @NotNull
        public ClassSummary[] newArray(int i) {
            return new ClassSummary[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public String realmGet$average() {
        return this.average;
    }

    public String realmGet$courseNumber() {
        return this.courseNumber;
    }

    public String realmGet$courseTitle() {
        return this.courseTitle;
    }

    public String realmGet$currentMark() {
        return this.currentMark;
    }

    public boolean realmGet$doingRubric() {
        return this.doingRubric;
    }

    public String realmGet$gradeBookName() {
        return this.gradeBookName;
    }

    public Integer realmGet$gradeBookNumber() {
        return this.gradeBookNumber;
    }

    public boolean realmGet$hideScores() {
        return this.hideScores;
    }

    public String realmGet$lastUpdated() {
        return this.lastUpdated;
    }

    public Integer realmGet$missingAssignment() {
        return this.missingAssignment;
    }

    public Double realmGet$percent() {
        return this.percent;
    }

    public Integer realmGet$period() {
        return this.period;
    }

    public String realmGet$roomNumber() {
        return this.roomNumber;
    }

    public Integer realmGet$schoolCode() {
        return this.schoolCode;
    }

    public String realmGet$schoolName() {
        return this.schoolName;
    }

    public Integer realmGet$sectionNumber() {
        return this.sectionNumber;
    }

    public boolean realmGet$showPeriod() {
        return this.showPeriod;
    }

    public Integer realmGet$studentID() {
        return this.studentID;
    }

    public String realmGet$teacherName() {
        return this.teacherName;
    }

    public Integer realmGet$teacherNumber() {
        return this.teacherNumber;
    }

    public String realmGet$term() {
        return this.term;
    }

    public String realmGet$termCode() {
        return this.termCode;
    }

    public void realmSet$average(String str) {
        this.average = str;
    }

    public void realmSet$courseNumber(String str) {
        this.courseNumber = str;
    }

    public void realmSet$courseTitle(String str) {
        this.courseTitle = str;
    }

    public void realmSet$currentMark(String str) {
        this.currentMark = str;
    }

    public void realmSet$doingRubric(boolean z) {
        this.doingRubric = z;
    }

    public void realmSet$gradeBookName(String str) {
        this.gradeBookName = str;
    }

    public void realmSet$gradeBookNumber(Integer num) {
        this.gradeBookNumber = num;
    }

    public void realmSet$hideScores(boolean z) {
        this.hideScores = z;
    }

    public void realmSet$lastUpdated(String str) {
        this.lastUpdated = str;
    }

    public void realmSet$missingAssignment(Integer num) {
        this.missingAssignment = num;
    }

    public void realmSet$percent(Double d) {
        this.percent = d;
    }

    public void realmSet$period(Integer num) {
        this.period = num;
    }

    public void realmSet$roomNumber(String str) {
        this.roomNumber = str;
    }

    public void realmSet$schoolCode(Integer num) {
        this.schoolCode = num;
    }

    public void realmSet$schoolName(String str) {
        this.schoolName = str;
    }

    public void realmSet$sectionNumber(Integer num) {
        this.sectionNumber = num;
    }

    public void realmSet$showPeriod(boolean z) {
        this.showPeriod = z;
    }

    public void realmSet$studentID(Integer num) {
        this.studentID = num;
    }

    public void realmSet$teacherName(String str) {
        this.teacherName = str;
    }

    public void realmSet$teacherNumber(Integer num) {
        this.teacherNumber = num;
    }

    public void realmSet$term(String str) {
        this.term = str;
    }

    public void realmSet$termCode(String str) {
        this.termCode = str;
    }

    public ClassSummary() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$period(Integer.valueOf(0));
        realmSet$schoolCode(Integer.valueOf(0));
        realmSet$studentID(Integer.valueOf(0));
        realmSet$schoolName("");
        realmSet$sectionNumber(Integer.valueOf(0));
        realmSet$gradeBookName("");
        realmSet$courseNumber("");
        realmSet$courseTitle("");
        realmSet$teacherNumber(Integer.valueOf(0));
        realmSet$teacherName("");
        realmSet$roomNumber("");
        realmSet$currentMark("");
        realmSet$percent(Double.valueOf(0.0d));
        realmSet$average("");
        realmSet$missingAssignment(Integer.valueOf(0));
        realmSet$term("");
        realmSet$termCode("");
    }

    @Nullable
    public final Integer getPeriod() {
        return realmGet$period();
    }

    public final void setPeriod(@Nullable Integer num) {
        realmSet$period(num);
    }

    @Nullable
    public final Integer getSchoolCode() {
        return realmGet$schoolCode();
    }

    public final void setSchoolCode(@Nullable Integer num) {
        realmSet$schoolCode(num);
    }

    @Nullable
    public final Integer getStudentID() {
        return realmGet$studentID();
    }

    public final void setStudentID(@Nullable Integer num) {
        realmSet$studentID(num);
    }

    public final boolean getShowPeriod() {
        return realmGet$showPeriod();
    }

    public final void setShowPeriod(boolean z) {
        realmSet$showPeriod(z);
    }

    public final boolean getHideScores() {
        return realmGet$hideScores();
    }

    public final void setHideScores(boolean z) {
        realmSet$hideScores(z);
    }

    @NotNull
    public final String getSchoolName() {
        return realmGet$schoolName();
    }

    public final void setSchoolName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$schoolName(str);
    }

    @Nullable
    public final Integer getSectionNumber() {
        return realmGet$sectionNumber();
    }

    public final void setSectionNumber(@Nullable Integer num) {
        realmSet$sectionNumber(num);
    }

    @Nullable
    public final Integer getGradeBookNumber() {
        return realmGet$gradeBookNumber();
    }

    public final void setGradeBookNumber(@Nullable Integer num) {
        realmSet$gradeBookNumber(num);
    }

    @Nullable
    public final String getGradeBookName() {
        return realmGet$gradeBookName();
    }

    public final void setGradeBookName(@Nullable String str) {
        realmSet$gradeBookName(str);
    }

    public final boolean getDoingRubric() {
        return realmGet$doingRubric();
    }

    public final void setDoingRubric(boolean z) {
        realmSet$doingRubric(z);
    }

    @Nullable
    public final String getCourseNumber() {
        return realmGet$courseNumber();
    }

    public final void setCourseNumber(@Nullable String str) {
        realmSet$courseNumber(str);
    }

    @Nullable
    public final String getCourseTitle() {
        return realmGet$courseTitle();
    }

    public final void setCourseTitle(@Nullable String str) {
        realmSet$courseTitle(str);
    }

    @Nullable
    public final Integer getTeacherNumber() {
        return realmGet$teacherNumber();
    }

    public final void setTeacherNumber(@Nullable Integer num) {
        realmSet$teacherNumber(num);
    }

    @Nullable
    public final String getTeacherName() {
        return realmGet$teacherName();
    }

    public final void setTeacherName(@Nullable String str) {
        realmSet$teacherName(str);
    }

    @Nullable
    public final String getRoomNumber() {
        return realmGet$roomNumber();
    }

    public final void setRoomNumber(@Nullable String str) {
        realmSet$roomNumber(str);
    }

    @Nullable
    public final String getCurrentMark() {
        return realmGet$currentMark();
    }

    public final void setCurrentMark(@Nullable String str) {
        realmSet$currentMark(str);
    }

    @Nullable
    public final Double getPercent() {
        return realmGet$percent();
    }

    public final void setPercent(@Nullable Double d) {
        realmSet$percent(d);
    }

    @Nullable
    public final String getAverage() {
        return realmGet$average();
    }

    public final void setAverage(@Nullable String str) {
        realmSet$average(str);
    }

    @Nullable
    public final Integer getMissingAssignment() {
        return realmGet$missingAssignment();
    }

    public final void setMissingAssignment(@Nullable Integer num) {
        realmSet$missingAssignment(num);
    }

    @Nullable
    public final String getTerm() {
        return realmGet$term();
    }

    public final void setTerm(@Nullable String str) {
        realmSet$term(str);
    }

    @Nullable
    public final String getTermCode() {
        return realmGet$termCode();
    }

    public final void setTermCode(@Nullable String str) {
        realmSet$termCode(str);
    }

    @Nullable
    public final String getLastUpdated() {
        return realmGet$lastUpdated();
    }

    public final void setLastUpdated(@Nullable String str) {
        realmSet$lastUpdated(str);
    }

    public ClassSummary(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this();
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        Object readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        realmSet$period((Integer) readValue);
        readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        realmSet$schoolCode((Integer) readValue);
        readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        realmSet$studentID((Integer) readValue);
        readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        realmSet$sectionNumber((Integer) readValue);
        readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        realmSet$gradeBookNumber((Integer) readValue);
        realmSet$gradeBookName(parcel.readString());
        boolean z = false;
        if (parcel.readByte() != ((byte) null)) {
            z = true;
        }
        realmSet$doingRubric(z);
        realmSet$courseNumber(parcel.readString());
        realmSet$courseTitle(parcel.readString());
        readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        realmSet$teacherNumber((Integer) readValue);
        realmSet$teacherName(parcel.readString());
        realmSet$roomNumber(parcel.readString());
        realmSet$currentMark(parcel.readString());
        readValue = parcel.readValue(Double.TYPE.getClassLoader());
        if (!(readValue instanceof Double)) {
            readValue = null;
        }
        realmSet$percent((Double) readValue);
        realmSet$average(parcel.readString());
        readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        realmSet$missingAssignment((Integer) readValue);
        realmSet$term(parcel.readString());
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeValue(realmGet$period());
        parcel.writeValue(realmGet$schoolCode());
        parcel.writeValue(realmGet$studentID());
        parcel.writeValue(realmGet$sectionNumber());
        parcel.writeValue(realmGet$gradeBookNumber());
        parcel.writeString(realmGet$gradeBookName());
        parcel.writeByte(realmGet$doingRubric());
        parcel.writeString(realmGet$courseNumber());
        parcel.writeString(realmGet$courseTitle());
        parcel.writeValue(realmGet$teacherNumber());
        parcel.writeString(realmGet$teacherName());
        parcel.writeString(realmGet$roomNumber());
        parcel.writeString(realmGet$currentMark());
        parcel.writeValue(realmGet$percent());
        parcel.writeString(realmGet$average());
        parcel.writeValue(realmGet$missingAssignment());
        parcel.writeString(realmGet$term());
    }
}
