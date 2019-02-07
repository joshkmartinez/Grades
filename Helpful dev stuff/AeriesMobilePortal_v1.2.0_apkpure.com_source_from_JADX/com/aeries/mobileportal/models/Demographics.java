package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.DemographicsRealmProxyInterface;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.internal.RealmObjectProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b>\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 z2\u00020\u00012\u00020\u0002:\u0001zB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010v\u001a\u00020\bH\u0016J\u0018\u0010w\u001a\u00020x2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010y\u001a\u00020\bH\u0016R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R \u0010\u0017\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R \u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R \u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R \u0010 \u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R \u0010#\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R \u0010&\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R \u0010)\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013R\"\u0010,\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b-\u0010\n\"\u0004\b.\u0010\fR \u0010/\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0011\"\u0004\b1\u0010\u0013R \u00102\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013R \u00105\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u0010\u0013R \u00108\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0011\"\u0004\b:\u0010\u0013R \u0010;\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0011\"\u0004\b=\u0010\u0013R \u0010>\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0011\"\u0004\b@\u0010\u0013R \u0010A\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0011\"\u0004\bC\u0010\u0013R \u0010D\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0011\"\u0004\bF\u0010\u0013R \u0010G\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0011\"\u0004\bI\u0010\u0013R \u0010J\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0011\"\u0004\bL\u0010\u0013R \u0010M\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR \u0010S\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0011\"\u0004\bU\u0010\u0013R \u0010V\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0011\"\u0004\bX\u0010\u0013R \u0010Y\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0011\"\u0004\b[\u0010\u0013R \u0010\\\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0011\"\u0004\b^\u0010\u0013R \u0010_\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0011\"\u0004\ba\u0010\u0013R \u0010b\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0011\"\u0004\bd\u0010\u0013R \u0010e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u0011\"\u0004\bg\u0010\u0013R \u0010h\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010P\"\u0004\bj\u0010RR\u001e\u0010k\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u001e\u0010p\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0011\"\u0004\br\u0010\u0013R\u001e\u0010s\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010m\"\u0004\bu\u0010o¨\u0006{"}, d2 = {"Lcom/aeries/mobileportal/models/Demographics;", "Lio/realm/RealmObject;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "age", "", "getAge", "()Ljava/lang/Integer;", "setAge", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "birthDate", "", "getBirthDate", "()Ljava/lang/String;", "setBirthDate", "(Ljava/lang/String;)V", "contact1PhoneNumber", "getContact1PhoneNumber", "setContact1PhoneNumber", "contact1Title", "getContact1Title", "setContact1Title", "contact2PhoneNumber", "getContact2PhoneNumber", "setContact2PhoneNumber", "contact2Title", "getContact2Title", "setContact2Title", "correspondenceLanguageCode", "getCorrespondenceLanguageCode", "setCorrespondenceLanguageCode", "correspondenceLanguageDescription", "getCorrespondenceLanguageDescription", "setCorrespondenceLanguageDescription", "counselorEmailAddress", "getCounselorEmailAddress", "setCounselorEmailAddress", "counselorName", "getCounselorName", "setCounselorName", "counselorNumber", "getCounselorNumber", "setCounselorNumber", "displayText", "getDisplayText", "setDisplayText", "emailAddress", "getEmailAddress", "setEmailAddress", "ethnicityCode", "getEthnicityCode", "setEthnicityCode", "ethnicityDescription", "getEthnicityDescription", "setEthnicityDescription", "firstName", "getFirstName", "setFirstName", "gender", "getGender", "setGender", "grade", "getGrade", "setGrade", "languageFluencyCode", "getLanguageFluencyCode", "setLanguageFluencyCode", "languageFluencyDescription", "getLanguageFluencyDescription", "setLanguageFluencyDescription", "lastName", "getLastName", "setLastName", "mailingAddress", "Lcom/aeries/mobileportal/models/GenericAddress;", "getMailingAddress", "()Lcom/aeries/mobileportal/models/GenericAddress;", "setMailingAddress", "(Lcom/aeries/mobileportal/models/GenericAddress;)V", "middleName", "getMiddleName", "setMiddleName", "mobilePhone", "getMobilePhone", "setMobilePhone", "parentGuardianEmailAddress", "getParentGuardianEmailAddress", "setParentGuardianEmailAddress", "parentGuardianName", "getParentGuardianName", "setParentGuardianName", "primaryPhoneNumber", "getPrimaryPhoneNumber", "setPrimaryPhoneNumber", "raceCode", "getRaceCode", "setRaceCode", "raceDescription", "getRaceDescription", "setRaceDescription", "residenceAddress", "getResidenceAddress", "setResidenceAddress", "schoolCode", "getSchoolCode", "()I", "setSchoolCode", "(I)V", "schoolName", "getSchoolName", "setSchoolName", "studentId", "getStudentId", "setStudentId", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: Demographics.kt */
public class Demographics extends RealmObject implements Parcelable, DemographicsRealmProxyInterface {
    public static final CREATOR CREATOR = new CREATOR();
    @SerializedName("Age")
    @Nullable
    @Expose
    private Integer age;
    @SerializedName("Birthdate")
    @Nullable
    @Expose
    private String birthDate;
    @SerializedName("Contact1PhoneNumber")
    @Nullable
    @Expose
    private String contact1PhoneNumber;
    @SerializedName("Contact1Title")
    @Nullable
    @Expose
    private String contact1Title;
    @SerializedName("Contact2PhoneNumber")
    @Nullable
    @Expose
    private String contact2PhoneNumber;
    @SerializedName("Contact2Title")
    @Nullable
    @Expose
    private String contact2Title;
    @SerializedName("CorrespondenceLanguageCode")
    @Nullable
    @Expose
    private String correspondenceLanguageCode;
    @SerializedName("CorrespondenceLanguageDescription")
    @Nullable
    @Expose
    private String correspondenceLanguageDescription;
    @SerializedName("CounselorEmailAddress")
    @Nullable
    @Expose
    private String counselorEmailAddress;
    @SerializedName("CounselorName")
    @Nullable
    @Expose
    private String counselorName;
    @SerializedName("CounselorNumber")
    @Nullable
    @Expose
    private Integer counselorNumber;
    @SerializedName("DisplayText")
    @Nullable
    @Expose
    private String displayText;
    @SerializedName("EmailAddress")
    @Nullable
    @Expose
    private String emailAddress;
    @SerializedName("EthnicityCode")
    @Nullable
    @Expose
    private String ethnicityCode;
    @SerializedName("EthnicityDescription")
    @Nullable
    @Expose
    private String ethnicityDescription;
    @SerializedName("FirstName")
    @Nullable
    @Expose
    private String firstName;
    @SerializedName("Gender")
    @Nullable
    @Expose
    private String gender;
    @SerializedName("Grade")
    @Nullable
    @Expose
    private String grade;
    @SerializedName("LanguageFluencyCode")
    @Nullable
    @Expose
    private String languageFluencyCode;
    @SerializedName("LanguageFluencyDescription")
    @Nullable
    @Expose
    private String languageFluencyDescription;
    @SerializedName("LastName")
    @Nullable
    @Expose
    private String lastName;
    @SerializedName("MailingAddress")
    @Nullable
    @Expose
    private GenericAddress mailingAddress;
    @SerializedName("MiddleName")
    @Nullable
    @Expose
    private String middleName;
    @SerializedName("MobilePhone")
    @Nullable
    @Expose
    private String mobilePhone;
    @SerializedName("ParentGuardianEmailAddress")
    @Nullable
    @Expose
    private String parentGuardianEmailAddress;
    @SerializedName("ParentGuardianName")
    @Nullable
    @Expose
    private String parentGuardianName;
    @SerializedName("PrimaryPhoneNumber")
    @Nullable
    @Expose
    private String primaryPhoneNumber;
    @SerializedName("RaceCode")
    @Nullable
    @Expose
    private String raceCode;
    @SerializedName("RaceDescription")
    @Nullable
    @Expose
    private String raceDescription;
    @SerializedName("ResidenceAddress")
    @Nullable
    @Expose
    private GenericAddress residenceAddress;
    @SerializedName("SchoolCode")
    @Expose
    private int schoolCode;
    @SerializedName("SchoolName")
    @NotNull
    @Expose
    private String schoolName;
    @SerializedName("StudentID")
    @PrimaryKey
    @Expose
    private int studentId;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/Demographics$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/Demographics;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/Demographics;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: Demographics.kt */
    public static final class CREATOR implements Creator<Demographics> {
        private CREATOR() {
        }

        @NotNull
        public Demographics createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new Demographics(parcel);
        }

        @NotNull
        public Demographics[] newArray(int i) {
            return new Demographics[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public Integer realmGet$age() {
        return this.age;
    }

    public String realmGet$birthDate() {
        return this.birthDate;
    }

    public String realmGet$contact1PhoneNumber() {
        return this.contact1PhoneNumber;
    }

    public String realmGet$contact1Title() {
        return this.contact1Title;
    }

    public String realmGet$contact2PhoneNumber() {
        return this.contact2PhoneNumber;
    }

    public String realmGet$contact2Title() {
        return this.contact2Title;
    }

    public String realmGet$correspondenceLanguageCode() {
        return this.correspondenceLanguageCode;
    }

    public String realmGet$correspondenceLanguageDescription() {
        return this.correspondenceLanguageDescription;
    }

    public String realmGet$counselorEmailAddress() {
        return this.counselorEmailAddress;
    }

    public String realmGet$counselorName() {
        return this.counselorName;
    }

    public Integer realmGet$counselorNumber() {
        return this.counselorNumber;
    }

    public String realmGet$displayText() {
        return this.displayText;
    }

    public String realmGet$emailAddress() {
        return this.emailAddress;
    }

    public String realmGet$ethnicityCode() {
        return this.ethnicityCode;
    }

    public String realmGet$ethnicityDescription() {
        return this.ethnicityDescription;
    }

    public String realmGet$firstName() {
        return this.firstName;
    }

    public String realmGet$gender() {
        return this.gender;
    }

    public String realmGet$grade() {
        return this.grade;
    }

    public String realmGet$languageFluencyCode() {
        return this.languageFluencyCode;
    }

    public String realmGet$languageFluencyDescription() {
        return this.languageFluencyDescription;
    }

    public String realmGet$lastName() {
        return this.lastName;
    }

    public GenericAddress realmGet$mailingAddress() {
        return this.mailingAddress;
    }

    public String realmGet$middleName() {
        return this.middleName;
    }

    public String realmGet$mobilePhone() {
        return this.mobilePhone;
    }

    public String realmGet$parentGuardianEmailAddress() {
        return this.parentGuardianEmailAddress;
    }

    public String realmGet$parentGuardianName() {
        return this.parentGuardianName;
    }

    public String realmGet$primaryPhoneNumber() {
        return this.primaryPhoneNumber;
    }

    public String realmGet$raceCode() {
        return this.raceCode;
    }

    public String realmGet$raceDescription() {
        return this.raceDescription;
    }

    public GenericAddress realmGet$residenceAddress() {
        return this.residenceAddress;
    }

    public int realmGet$schoolCode() {
        return this.schoolCode;
    }

    public String realmGet$schoolName() {
        return this.schoolName;
    }

    public int realmGet$studentId() {
        return this.studentId;
    }

    public void realmSet$age(Integer num) {
        this.age = num;
    }

    public void realmSet$birthDate(String str) {
        this.birthDate = str;
    }

    public void realmSet$contact1PhoneNumber(String str) {
        this.contact1PhoneNumber = str;
    }

    public void realmSet$contact1Title(String str) {
        this.contact1Title = str;
    }

    public void realmSet$contact2PhoneNumber(String str) {
        this.contact2PhoneNumber = str;
    }

    public void realmSet$contact2Title(String str) {
        this.contact2Title = str;
    }

    public void realmSet$correspondenceLanguageCode(String str) {
        this.correspondenceLanguageCode = str;
    }

    public void realmSet$correspondenceLanguageDescription(String str) {
        this.correspondenceLanguageDescription = str;
    }

    public void realmSet$counselorEmailAddress(String str) {
        this.counselorEmailAddress = str;
    }

    public void realmSet$counselorName(String str) {
        this.counselorName = str;
    }

    public void realmSet$counselorNumber(Integer num) {
        this.counselorNumber = num;
    }

    public void realmSet$displayText(String str) {
        this.displayText = str;
    }

    public void realmSet$emailAddress(String str) {
        this.emailAddress = str;
    }

    public void realmSet$ethnicityCode(String str) {
        this.ethnicityCode = str;
    }

    public void realmSet$ethnicityDescription(String str) {
        this.ethnicityDescription = str;
    }

    public void realmSet$firstName(String str) {
        this.firstName = str;
    }

    public void realmSet$gender(String str) {
        this.gender = str;
    }

    public void realmSet$grade(String str) {
        this.grade = str;
    }

    public void realmSet$languageFluencyCode(String str) {
        this.languageFluencyCode = str;
    }

    public void realmSet$languageFluencyDescription(String str) {
        this.languageFluencyDescription = str;
    }

    public void realmSet$lastName(String str) {
        this.lastName = str;
    }

    public void realmSet$mailingAddress(GenericAddress genericAddress) {
        this.mailingAddress = genericAddress;
    }

    public void realmSet$middleName(String str) {
        this.middleName = str;
    }

    public void realmSet$mobilePhone(String str) {
        this.mobilePhone = str;
    }

    public void realmSet$parentGuardianEmailAddress(String str) {
        this.parentGuardianEmailAddress = str;
    }

    public void realmSet$parentGuardianName(String str) {
        this.parentGuardianName = str;
    }

    public void realmSet$primaryPhoneNumber(String str) {
        this.primaryPhoneNumber = str;
    }

    public void realmSet$raceCode(String str) {
        this.raceCode = str;
    }

    public void realmSet$raceDescription(String str) {
        this.raceDescription = str;
    }

    public void realmSet$residenceAddress(GenericAddress genericAddress) {
        this.residenceAddress = genericAddress;
    }

    public void realmSet$schoolCode(int i) {
        this.schoolCode = i;
    }

    public void realmSet$schoolName(String str) {
        this.schoolName = str;
    }

    public void realmSet$studentId(int i) {
        this.studentId = i;
    }

    public Demographics() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$schoolName("");
        realmSet$firstName("");
        realmSet$middleName("");
        realmSet$lastName("");
        realmSet$grade("");
        realmSet$gender("");
        realmSet$birthDate("");
        realmSet$age(Integer.valueOf(0));
        realmSet$mobilePhone("");
        realmSet$emailAddress("");
        realmSet$mailingAddress(new GenericAddress());
        realmSet$residenceAddress(new GenericAddress());
        realmSet$correspondenceLanguageCode("");
        realmSet$correspondenceLanguageDescription("");
        realmSet$languageFluencyCode("");
        realmSet$languageFluencyDescription("");
        realmSet$ethnicityCode("");
        realmSet$ethnicityDescription("");
        realmSet$raceCode("");
        realmSet$raceDescription("");
        realmSet$primaryPhoneNumber("");
        realmSet$parentGuardianName("");
        realmSet$contact1PhoneNumber("");
        realmSet$contact1Title("");
        realmSet$contact2PhoneNumber("");
        realmSet$contact2Title("");
        realmSet$counselorNumber(Integer.valueOf(0));
        realmSet$counselorName("");
        realmSet$displayText("");
        realmSet$counselorEmailAddress("");
        realmSet$parentGuardianEmailAddress("");
    }

    public final int getSchoolCode() {
        return realmGet$schoolCode();
    }

    public final void setSchoolCode(int i) {
        realmSet$schoolCode(i);
    }

    @NotNull
    public final String getSchoolName() {
        return realmGet$schoolName();
    }

    public final void setSchoolName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$schoolName(str);
    }

    public final int getStudentId() {
        return realmGet$studentId();
    }

    public final void setStudentId(int i) {
        realmSet$studentId(i);
    }

    @Nullable
    public final String getFirstName() {
        return realmGet$firstName();
    }

    public final void setFirstName(@Nullable String str) {
        realmSet$firstName(str);
    }

    @Nullable
    public final String getMiddleName() {
        return realmGet$middleName();
    }

    public final void setMiddleName(@Nullable String str) {
        realmSet$middleName(str);
    }

    @Nullable
    public final String getLastName() {
        return realmGet$lastName();
    }

    public final void setLastName(@Nullable String str) {
        realmSet$lastName(str);
    }

    @Nullable
    public final String getGrade() {
        return realmGet$grade();
    }

    public final void setGrade(@Nullable String str) {
        realmSet$grade(str);
    }

    @Nullable
    public final String getGender() {
        return realmGet$gender();
    }

    public final void setGender(@Nullable String str) {
        realmSet$gender(str);
    }

    @Nullable
    public final String getBirthDate() {
        return realmGet$birthDate();
    }

    public final void setBirthDate(@Nullable String str) {
        realmSet$birthDate(str);
    }

    @Nullable
    public final Integer getAge() {
        return realmGet$age();
    }

    public final void setAge(@Nullable Integer num) {
        realmSet$age(num);
    }

    @Nullable
    public final String getMobilePhone() {
        return realmGet$mobilePhone();
    }

    public final void setMobilePhone(@Nullable String str) {
        realmSet$mobilePhone(str);
    }

    @Nullable
    public final String getEmailAddress() {
        return realmGet$emailAddress();
    }

    public final void setEmailAddress(@Nullable String str) {
        realmSet$emailAddress(str);
    }

    @Nullable
    public final GenericAddress getMailingAddress() {
        return realmGet$mailingAddress();
    }

    public final void setMailingAddress(@Nullable GenericAddress genericAddress) {
        realmSet$mailingAddress(genericAddress);
    }

    @Nullable
    public final GenericAddress getResidenceAddress() {
        return realmGet$residenceAddress();
    }

    public final void setResidenceAddress(@Nullable GenericAddress genericAddress) {
        realmSet$residenceAddress(genericAddress);
    }

    @Nullable
    public final String getCorrespondenceLanguageCode() {
        return realmGet$correspondenceLanguageCode();
    }

    public final void setCorrespondenceLanguageCode(@Nullable String str) {
        realmSet$correspondenceLanguageCode(str);
    }

    @Nullable
    public final String getCorrespondenceLanguageDescription() {
        return realmGet$correspondenceLanguageDescription();
    }

    public final void setCorrespondenceLanguageDescription(@Nullable String str) {
        realmSet$correspondenceLanguageDescription(str);
    }

    @Nullable
    public final String getLanguageFluencyCode() {
        return realmGet$languageFluencyCode();
    }

    public final void setLanguageFluencyCode(@Nullable String str) {
        realmSet$languageFluencyCode(str);
    }

    @Nullable
    public final String getLanguageFluencyDescription() {
        return realmGet$languageFluencyDescription();
    }

    public final void setLanguageFluencyDescription(@Nullable String str) {
        realmSet$languageFluencyDescription(str);
    }

    @Nullable
    public final String getEthnicityCode() {
        return realmGet$ethnicityCode();
    }

    public final void setEthnicityCode(@Nullable String str) {
        realmSet$ethnicityCode(str);
    }

    @Nullable
    public final String getEthnicityDescription() {
        return realmGet$ethnicityDescription();
    }

    public final void setEthnicityDescription(@Nullable String str) {
        realmSet$ethnicityDescription(str);
    }

    @Nullable
    public final String getRaceCode() {
        return realmGet$raceCode();
    }

    public final void setRaceCode(@Nullable String str) {
        realmSet$raceCode(str);
    }

    @Nullable
    public final String getRaceDescription() {
        return realmGet$raceDescription();
    }

    public final void setRaceDescription(@Nullable String str) {
        realmSet$raceDescription(str);
    }

    @Nullable
    public final String getPrimaryPhoneNumber() {
        return realmGet$primaryPhoneNumber();
    }

    public final void setPrimaryPhoneNumber(@Nullable String str) {
        realmSet$primaryPhoneNumber(str);
    }

    @Nullable
    public final String getParentGuardianName() {
        return realmGet$parentGuardianName();
    }

    public final void setParentGuardianName(@Nullable String str) {
        realmSet$parentGuardianName(str);
    }

    @Nullable
    public final String getContact1PhoneNumber() {
        return realmGet$contact1PhoneNumber();
    }

    public final void setContact1PhoneNumber(@Nullable String str) {
        realmSet$contact1PhoneNumber(str);
    }

    @Nullable
    public final String getContact1Title() {
        return realmGet$contact1Title();
    }

    public final void setContact1Title(@Nullable String str) {
        realmSet$contact1Title(str);
    }

    @Nullable
    public final String getContact2PhoneNumber() {
        return realmGet$contact2PhoneNumber();
    }

    public final void setContact2PhoneNumber(@Nullable String str) {
        realmSet$contact2PhoneNumber(str);
    }

    @Nullable
    public final String getContact2Title() {
        return realmGet$contact2Title();
    }

    public final void setContact2Title(@Nullable String str) {
        realmSet$contact2Title(str);
    }

    @Nullable
    public final Integer getCounselorNumber() {
        return realmGet$counselorNumber();
    }

    public final void setCounselorNumber(@Nullable Integer num) {
        realmSet$counselorNumber(num);
    }

    @Nullable
    public final String getCounselorName() {
        return realmGet$counselorName();
    }

    public final void setCounselorName(@Nullable String str) {
        realmSet$counselorName(str);
    }

    @Nullable
    public final String getDisplayText() {
        return realmGet$displayText();
    }

    public final void setDisplayText(@Nullable String str) {
        realmSet$displayText(str);
    }

    @Nullable
    public final String getCounselorEmailAddress() {
        return realmGet$counselorEmailAddress();
    }

    public final void setCounselorEmailAddress(@Nullable String str) {
        realmSet$counselorEmailAddress(str);
    }

    @Nullable
    public final String getParentGuardianEmailAddress() {
        return realmGet$parentGuardianEmailAddress();
    }

    public final void setParentGuardianEmailAddress(@Nullable String str) {
        realmSet$parentGuardianEmailAddress(str);
    }

    public Demographics(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this();
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$schoolCode(parcel.readInt());
        String readString = parcel.readString();
        Intrinsics.checkExpressionValueIsNotNull(readString, "parcel.readString()");
        realmSet$schoolName(readString);
        realmSet$studentId(parcel.readInt());
        realmSet$firstName(parcel.readString());
        realmSet$middleName(parcel.readString());
        realmSet$lastName(parcel.readString());
        realmSet$grade(parcel.readString());
        realmSet$gender(parcel.readString());
        realmSet$birthDate(parcel.readString());
        Object readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        realmSet$age((Integer) readValue);
        realmSet$mobilePhone(parcel.readString());
        realmSet$emailAddress(parcel.readString());
        realmSet$correspondenceLanguageCode(parcel.readString());
        realmSet$correspondenceLanguageDescription(parcel.readString());
        realmSet$languageFluencyCode(parcel.readString());
        realmSet$languageFluencyDescription(parcel.readString());
        realmSet$ethnicityCode(parcel.readString());
        realmSet$ethnicityDescription(parcel.readString());
        realmSet$raceCode(parcel.readString());
        realmSet$raceDescription(parcel.readString());
        realmSet$primaryPhoneNumber(parcel.readString());
        realmSet$parentGuardianName(parcel.readString());
        realmSet$contact1PhoneNumber(parcel.readString());
        realmSet$contact1Title(parcel.readString());
        realmSet$contact2PhoneNumber(parcel.readString());
        realmSet$contact2Title(parcel.readString());
        readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        realmSet$counselorNumber((Integer) readValue);
        realmSet$counselorName(parcel.readString());
        realmSet$displayText(parcel.readString());
        realmSet$counselorEmailAddress(parcel.readString());
        realmSet$parentGuardianEmailAddress(parcel.readString());
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeInt(realmGet$schoolCode());
        parcel.writeString(realmGet$schoolName());
        parcel.writeInt(realmGet$studentId());
        parcel.writeString(realmGet$firstName());
        parcel.writeString(realmGet$middleName());
        parcel.writeString(realmGet$lastName());
        parcel.writeString(realmGet$grade());
        parcel.writeString(realmGet$gender());
        parcel.writeString(realmGet$birthDate());
        parcel.writeValue(realmGet$age());
        parcel.writeString(realmGet$mobilePhone());
        parcel.writeString(realmGet$emailAddress());
        parcel.writeString(realmGet$correspondenceLanguageCode());
        parcel.writeString(realmGet$correspondenceLanguageDescription());
        parcel.writeString(realmGet$languageFluencyCode());
        parcel.writeString(realmGet$languageFluencyDescription());
        parcel.writeString(realmGet$ethnicityCode());
        parcel.writeString(realmGet$ethnicityDescription());
        parcel.writeString(realmGet$raceCode());
        parcel.writeString(realmGet$raceDescription());
        parcel.writeString(realmGet$primaryPhoneNumber());
        parcel.writeString(realmGet$parentGuardianName());
        parcel.writeString(realmGet$contact1PhoneNumber());
        parcel.writeString(realmGet$contact1Title());
        parcel.writeString(realmGet$contact2PhoneNumber());
        parcel.writeString(realmGet$contact2Title());
        parcel.writeValue(realmGet$counselorNumber());
        parcel.writeString(realmGet$counselorName());
        parcel.writeString(realmGet$displayText());
        parcel.writeString(realmGet$counselorEmailAddress());
        parcel.writeString(realmGet$parentGuardianEmailAddress());
    }
}
