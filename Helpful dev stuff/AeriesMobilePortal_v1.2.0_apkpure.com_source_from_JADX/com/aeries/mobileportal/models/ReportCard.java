package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 @2\u00020\u0001:\u0001@B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Bu\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\t¢\u0006\u0002\u0010\u0016J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u0013HÆ\u0003J\t\u0010,\u001a\u00020\u0013HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\tHÆ\u0003J\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\tHÆ\u0001J\b\u00107\u001a\u00020\u0006H\u0016J\u0013\u00108\u001a\u00020\u00132\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0006HÖ\u0001J\t\u0010<\u001a\u00020\tHÖ\u0001J\u0018\u0010=\u001a\u00020>2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0006H\u0016R\u0016\u0010\u000e\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0014\u001a\u00020\u00138\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u000f\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\u0015\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0016\u0010\u0012\u001a\u00020\u00138\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0016\u0010\r\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0016\u0010\u0010\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0016\u0010\f\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!¨\u0006A"}, d2 = {"Lcom/aeries/mobileportal/models/ReportCard;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "studentId", "", "schoolCode", "schoolName", "", "year", "grade", "type", "reportTitle", "correspondenceLanguage", "correspondenceReportTitle", "termCode", "termDescription", "englishReport", "", "correspondenceReport", "createdDate", "(IILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "getCorrespondenceLanguage", "()Ljava/lang/String;", "getCorrespondenceReport", "()Z", "getCorrespondenceReportTitle", "getCreatedDate", "getEnglishReport", "getGrade", "getReportTitle", "getSchoolCode", "()I", "getSchoolName", "getStudentId", "getTermCode", "getTermDescription", "getType", "getYear", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ReportCard.kt */
public final class ReportCard implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("CorrespondenceLanguage")
    @NotNull
    @Expose
    private final String correspondenceLanguage;
    @SerializedName("CorrespondenceReport")
    @Expose
    private final boolean correspondenceReport;
    @SerializedName("CorrespondenceReportTitle")
    @NotNull
    @Expose
    private final String correspondenceReportTitle;
    @SerializedName("CreatedDate")
    @NotNull
    @Expose
    private final String createdDate;
    @SerializedName("EnglishReport")
    @Expose
    private final boolean englishReport;
    @SerializedName("Grade")
    @NotNull
    @Expose
    private final String grade;
    @SerializedName("ReportTitle")
    @NotNull
    @Expose
    private final String reportTitle;
    @SerializedName("SchoolCode")
    @Expose
    private final int schoolCode;
    @SerializedName("SchoolName")
    @NotNull
    @Expose
    private final String schoolName;
    @SerializedName("StudentID")
    @Expose
    private final int studentId;
    @SerializedName("TermCode")
    @NotNull
    @Expose
    private final String termCode;
    @SerializedName("TermDescription")
    @NotNull
    @Expose
    private final String termDescription;
    @SerializedName("Type")
    @NotNull
    @Expose
    private final String type;
    @SerializedName("Year")
    @Expose
    private final int year;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/ReportCard$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/ReportCard;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/ReportCard;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ReportCard.kt */
    public static final class CREATOR implements Creator<ReportCard> {
        private CREATOR() {
        }

        @NotNull
        public ReportCard createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new ReportCard(parcel);
        }

        @NotNull
        public ReportCard[] newArray(int i) {
            return new ReportCard[i];
        }
    }

    @NotNull
    public static /* bridge */ /* synthetic */ ReportCard copy$default(ReportCard reportCard, int i, int i2, String str, int i3, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, String str9, int i4, Object obj) {
        ReportCard reportCard2 = reportCard;
        int i5 = i4;
        return reportCard.copy((i5 & 1) != 0 ? reportCard2.studentId : i, (i5 & 2) != 0 ? reportCard2.schoolCode : i2, (i5 & 4) != 0 ? reportCard2.schoolName : str, (i5 & 8) != 0 ? reportCard2.year : i3, (i5 & 16) != 0 ? reportCard2.grade : str2, (i5 & 32) != 0 ? reportCard2.type : str3, (i5 & 64) != 0 ? reportCard2.reportTitle : str4, (i5 & 128) != 0 ? reportCard2.correspondenceLanguage : str5, (i5 & 256) != 0 ? reportCard2.correspondenceReportTitle : str6, (i5 & 512) != 0 ? reportCard2.termCode : str7, (i5 & 1024) != 0 ? reportCard2.termDescription : str8, (i5 & 2048) != 0 ? reportCard2.englishReport : z, (i5 & 4096) != 0 ? reportCard2.correspondenceReport : z2, (i5 & 8192) != 0 ? reportCard2.createdDate : str9);
    }

    public final int component1() {
        return this.studentId;
    }

    @NotNull
    public final String component10() {
        return this.termCode;
    }

    @NotNull
    public final String component11() {
        return this.termDescription;
    }

    public final boolean component12() {
        return this.englishReport;
    }

    public final boolean component13() {
        return this.correspondenceReport;
    }

    @NotNull
    public final String component14() {
        return this.createdDate;
    }

    public final int component2() {
        return this.schoolCode;
    }

    @NotNull
    public final String component3() {
        return this.schoolName;
    }

    public final int component4() {
        return this.year;
    }

    @NotNull
    public final String component5() {
        return this.grade;
    }

    @NotNull
    public final String component6() {
        return this.type;
    }

    @NotNull
    public final String component7() {
        return this.reportTitle;
    }

    @NotNull
    public final String component8() {
        return this.correspondenceLanguage;
    }

    @NotNull
    public final String component9() {
        return this.correspondenceReportTitle;
    }

    @NotNull
    public final ReportCard copy(int i, int i2, @NotNull String str, int i3, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, boolean z, boolean z2, @NotNull String str9) {
        String str10 = str;
        Intrinsics.checkParameterIsNotNull(str10, "schoolName");
        String str11 = str2;
        Intrinsics.checkParameterIsNotNull(str11, "grade");
        String str12 = str3;
        Intrinsics.checkParameterIsNotNull(str12, Param.TYPE);
        String str13 = str4;
        Intrinsics.checkParameterIsNotNull(str13, "reportTitle");
        String str14 = str5;
        Intrinsics.checkParameterIsNotNull(str14, "correspondenceLanguage");
        String str15 = str6;
        Intrinsics.checkParameterIsNotNull(str15, "correspondenceReportTitle");
        String str16 = str7;
        Intrinsics.checkParameterIsNotNull(str16, "termCode");
        String str17 = str8;
        Intrinsics.checkParameterIsNotNull(str17, "termDescription");
        String str18 = str9;
        Intrinsics.checkParameterIsNotNull(str18, "createdDate");
        return new ReportCard(i, i2, str10, i3, str11, str12, str13, str14, str15, str16, str17, z, z2, str18);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ReportCard) {
                ReportCard reportCard = (ReportCard) obj;
                if (this.studentId == reportCard.studentId) {
                    if ((this.schoolCode == reportCard.schoolCode) && Intrinsics.areEqual(this.schoolName, reportCard.schoolName)) {
                        if ((this.year == reportCard.year) && Intrinsics.areEqual(this.grade, reportCard.grade) && Intrinsics.areEqual(this.type, reportCard.type) && Intrinsics.areEqual(this.reportTitle, reportCard.reportTitle) && Intrinsics.areEqual(this.correspondenceLanguage, reportCard.correspondenceLanguage) && Intrinsics.areEqual(this.correspondenceReportTitle, reportCard.correspondenceReportTitle) && Intrinsics.areEqual(this.termCode, reportCard.termCode) && Intrinsics.areEqual(this.termDescription, reportCard.termDescription)) {
                            if (this.englishReport == reportCard.englishReport) {
                                if ((this.correspondenceReport == reportCard.correspondenceReport) && Intrinsics.areEqual(this.createdDate, reportCard.createdDate)) {
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = ((this.studentId * 31) + this.schoolCode) * 31;
        String str = this.schoolName;
        int i2 = 0;
        i = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.year) * 31;
        str = this.grade;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.type;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.reportTitle;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.correspondenceLanguage;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.correspondenceReportTitle;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.termCode;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.termDescription;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        int i3 = this.englishReport;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.correspondenceReport;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        str = this.createdDate;
        if (str != null) {
            i2 = str.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ReportCard(studentId=");
        stringBuilder.append(this.studentId);
        stringBuilder.append(", schoolCode=");
        stringBuilder.append(this.schoolCode);
        stringBuilder.append(", schoolName=");
        stringBuilder.append(this.schoolName);
        stringBuilder.append(", year=");
        stringBuilder.append(this.year);
        stringBuilder.append(", grade=");
        stringBuilder.append(this.grade);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", reportTitle=");
        stringBuilder.append(this.reportTitle);
        stringBuilder.append(", correspondenceLanguage=");
        stringBuilder.append(this.correspondenceLanguage);
        stringBuilder.append(", correspondenceReportTitle=");
        stringBuilder.append(this.correspondenceReportTitle);
        stringBuilder.append(", termCode=");
        stringBuilder.append(this.termCode);
        stringBuilder.append(", termDescription=");
        stringBuilder.append(this.termDescription);
        stringBuilder.append(", englishReport=");
        stringBuilder.append(this.englishReport);
        stringBuilder.append(", correspondenceReport=");
        stringBuilder.append(this.correspondenceReport);
        stringBuilder.append(", createdDate=");
        stringBuilder.append(this.createdDate);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ReportCard(int i, int i2, @NotNull String str, int i3, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, boolean z, boolean z2, @NotNull String str9) {
        Intrinsics.checkParameterIsNotNull(str, "schoolName");
        Intrinsics.checkParameterIsNotNull(str2, "grade");
        Intrinsics.checkParameterIsNotNull(str3, Param.TYPE);
        Intrinsics.checkParameterIsNotNull(str4, "reportTitle");
        Intrinsics.checkParameterIsNotNull(str5, "correspondenceLanguage");
        Intrinsics.checkParameterIsNotNull(str6, "correspondenceReportTitle");
        Intrinsics.checkParameterIsNotNull(str7, "termCode");
        Intrinsics.checkParameterIsNotNull(str8, "termDescription");
        Intrinsics.checkParameterIsNotNull(str9, "createdDate");
        this.studentId = i;
        this.schoolCode = i2;
        this.schoolName = str;
        this.year = i3;
        this.grade = str2;
        this.type = str3;
        this.reportTitle = str4;
        this.correspondenceLanguage = str5;
        this.correspondenceReportTitle = str6;
        this.termCode = str7;
        this.termDescription = str8;
        this.englishReport = z;
        this.correspondenceReport = z2;
        this.createdDate = str9;
    }

    public final int getStudentId() {
        return this.studentId;
    }

    public final int getSchoolCode() {
        return this.schoolCode;
    }

    @NotNull
    public final String getSchoolName() {
        return this.schoolName;
    }

    public final int getYear() {
        return this.year;
    }

    @NotNull
    public final String getGrade() {
        return this.grade;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getReportTitle() {
        return this.reportTitle;
    }

    @NotNull
    public final String getCorrespondenceLanguage() {
        return this.correspondenceLanguage;
    }

    @NotNull
    public final String getCorrespondenceReportTitle() {
        return this.correspondenceReportTitle;
    }

    @NotNull
    public final String getTermCode() {
        return this.termCode;
    }

    @NotNull
    public final String getTermDescription() {
        return this.termDescription;
    }

    public final boolean getEnglishReport() {
        return this.englishReport;
    }

    public final boolean getCorrespondenceReport() {
        return this.correspondenceReport;
    }

    @NotNull
    public final String getCreatedDate() {
        return this.createdDate;
    }

    public ReportCard(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        int readInt3 = parcel.readInt();
        String readString2 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString2, "parcel.readString()");
        String readString3 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString3, "parcel.readString()");
        String readString4 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString4, "parcel.readString()");
        String readString5 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString5, "parcel.readString()");
        String readString6 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString6, "parcel.readString()");
        String readString7 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString7, "parcel.readString()");
        String readString8 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString8, "parcel.readString()");
        byte b = (byte) null;
        boolean z = parcel.readByte() != b;
        boolean z2 = parcel.readByte() != b;
        String readString9 = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString9, "parcel.readString()");
        this(readInt, readInt2, readString, readInt3, readString2, readString3, readString4, readString5, readString6, readString7, readString8, z, z2, readString9);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeInt(this.studentId);
        parcel.writeInt(this.schoolCode);
        parcel.writeString(this.schoolName);
        parcel.writeInt(this.year);
        parcel.writeString(this.grade);
        parcel.writeString(this.type);
        parcel.writeString(this.reportTitle);
        parcel.writeString(this.correspondenceLanguage);
        parcel.writeString(this.correspondenceReportTitle);
        parcel.writeString(this.termCode);
        parcel.writeString(this.termDescription);
        parcel.writeByte(this.englishReport);
        parcel.writeByte(this.correspondenceReport);
        parcel.writeString(this.createdDate);
    }
}
