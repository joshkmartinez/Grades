package com.aeries.mobileportal.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.RealmModel;
import io.realm.SchoolRealmProxyInterface;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import io.realm.internal.RealmObjectProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\b\n\u0002\bJ\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010|\u001a\u000203H\u0016J\u0018\u0010}\u001a\u00020~2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001a\u000203H\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR\"\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R \u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\fR\"\u0010\u001d\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R \u0010 \u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR \u0010#\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\n\"\u0004\b%\u0010\fR \u0010&\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\n\"\u0004\b(\u0010\fR \u0010)\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\n\"\u0004\b+\u0010\fR \u0010,\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\n\"\u0004\b.\u0010\fR \u0010/\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\n\"\u0004\b1\u0010\fR\"\u00102\u001a\u0004\u0018\u0001038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b9\u0010\u0010\"\u0004\b:\u0010\u0012R \u0010;\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\n\"\u0004\b=\u0010\fR \u0010>\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\n\"\u0004\b@\u0010\fR\"\u0010A\u001a\u0004\u0018\u0001038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\bB\u00105\"\u0004\bC\u00107R \u0010D\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\n\"\u0004\bF\u0010\fR \u0010G\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\n\"\u0004\bI\u0010\fR \u0010J\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\n\"\u0004\bL\u0010\fR \u0010M\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\n\"\u0004\bO\u0010\fR \u0010P\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\n\"\u0004\bR\u0010\fR \u0010S\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\n\"\u0004\bU\u0010\fR \u0010V\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\n\"\u0004\bX\u0010\fR \u0010Y\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\n\"\u0004\b[\u0010\fR \u0010\\\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\n\"\u0004\b^\u0010\fR \u0010_\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\n\"\u0004\ba\u0010\fR\"\u0010b\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\bc\u0010\u0010\"\u0004\bd\u0010\u0012R \u0010e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\n\"\u0004\bg\u0010\fR \u0010h\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\n\"\u0004\bj\u0010\fR\u001a\u0010k\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR \u0010p\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\n\"\u0004\br\u0010\fR \u0010s\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\n\"\u0004\bu\u0010\fR \u0010v\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\n\"\u0004\bx\u0010\fR \u0010y\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\n\"\u0004\b{\u0010\f¨\u0006\u0001"}, d2 = {"Lcom/aeries/mobileportal/models/School;", "Landroid/os/Parcelable;", "Lio/realm/RealmModel;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "CDS", "", "getCDS", "()Ljava/lang/String;", "setCDS", "(Ljava/lang/String;)V", "aeriesAppParent", "", "getAeriesAppParent", "()Ljava/lang/Boolean;", "setAeriesAppParent", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "aeriesAppParentURL", "getAeriesAppParentURL", "setAeriesAppParentURL", "aeriesAppStaff", "getAeriesAppStaff", "setAeriesAppStaff", "aeriesAppStaffURL", "getAeriesAppStaffURL", "setAeriesAppStaffURL", "aeriesAppTeacher", "getAeriesAppTeacher", "setAeriesAppTeacher", "aeriesAppTeacherURL", "getAeriesAppTeacherURL", "setAeriesAppTeacherURL", "city", "getCity", "setCity", "closeDate", "getCloseDate", "setCloseDate", "county", "getCounty", "setCounty", "districtName", "getDistrictName", "setDistrictName", "fax", "getFax", "setFax", "highGrade", "", "getHighGrade", "()Ljava/lang/Integer;", "setHighGrade", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isCharter", "setCharter", "latitude", "getLatitude", "setLatitude", "longitude", "getLongitude", "setLongitude", "lowGrade", "getLowGrade", "setLowGrade", "mailingAddress", "getMailingAddress", "setMailingAddress", "mailingCity", "getMailingCity", "setMailingCity", "mailingState", "getMailingState", "setMailingState", "mailingZipCode", "getMailingZipCode", "setMailingZipCode", "openDate", "getOpenDate", "setOpenDate", "publicAdminEmail", "getPublicAdminEmail", "setPublicAdminEmail", "publicAdminFirstName", "getPublicAdminFirstName", "setPublicAdminFirstName", "publicAdminLastName", "getPublicAdminLastName", "setPublicAdminLastName", "publicPhone", "getPublicPhone", "setPublicPhone", "publicWebsite", "getPublicWebsite", "setPublicWebsite", "recordsTransfer", "getRecordsTransfer", "setRecordsTransfer", "recordsTransferURL", "getRecordsTransferURL", "setRecordsTransferURL", "schoolName", "getSchoolName", "setSchoolName", "selected", "getSelected", "()Z", "setSelected", "(Z)V", "state", "getState", "setState", "status", "getStatus", "setStatus", "streetAddress", "getStreetAddress", "setStreetAddress", "zipCode", "getZipCode", "setZipCode", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k = 1, mv = {1, 1, 10})
@RealmClass
/* compiled from: School.kt */
public class School implements Parcelable, RealmModel, SchoolRealmProxyInterface {
    public static final CREATOR CREATOR = new CREATOR();
    @PrimaryKey
    @Nullable
    @SerializedName("CDS")
    @Expose
    private String CDS;
    @SerializedName("AeriesAppParent")
    @Nullable
    @Expose
    private Boolean aeriesAppParent;
    @SerializedName("AeriesAppParentURL")
    @Nullable
    @Expose
    private String aeriesAppParentURL;
    @SerializedName("AeriesAppStaff")
    @Nullable
    @Expose
    private Boolean aeriesAppStaff;
    @SerializedName("AeriesAppStaffURL")
    @Nullable
    @Expose
    private String aeriesAppStaffURL;
    @SerializedName("AeriesAppTeacher")
    @Nullable
    @Expose
    private Boolean aeriesAppTeacher;
    @SerializedName("AeriesAppTeacherURL")
    @Nullable
    @Expose
    private String aeriesAppTeacherURL;
    @SerializedName("City")
    @Nullable
    @Expose
    private String city;
    @SerializedName("CloseDate")
    @Nullable
    @Expose
    private String closeDate;
    @SerializedName("County")
    @Nullable
    @Expose
    private String county;
    @SerializedName("DistrictName")
    @Nullable
    @Expose
    private String districtName;
    @SerializedName("Fax")
    @Nullable
    @Expose
    private String fax;
    @SerializedName("HighGrade")
    @Nullable
    @Expose
    private Integer highGrade;
    @SerializedName("isCharter")
    @Nullable
    @Expose
    private Boolean isCharter;
    @SerializedName("Latitude")
    @Nullable
    @Expose
    private String latitude;
    @SerializedName("Longitude")
    @Nullable
    @Expose
    private String longitude;
    @SerializedName("LowGrade")
    @Nullable
    @Expose
    private Integer lowGrade;
    @SerializedName("MailingAddress")
    @Nullable
    @Expose
    private String mailingAddress;
    @SerializedName("MailingCity")
    @Nullable
    @Expose
    private String mailingCity;
    @SerializedName("MailingState")
    @Nullable
    @Expose
    private String mailingState;
    @SerializedName("MailingZipCode")
    @Nullable
    @Expose
    private String mailingZipCode;
    @SerializedName("OpenDate")
    @Nullable
    @Expose
    private String openDate;
    @SerializedName("PublicAdminEmail")
    @Nullable
    @Expose
    private String publicAdminEmail;
    @SerializedName("PublicAdminFirstName")
    @Nullable
    @Expose
    private String publicAdminFirstName;
    @SerializedName("PublicAdminLastName")
    @Nullable
    @Expose
    private String publicAdminLastName;
    @SerializedName("PublicPhone")
    @Nullable
    @Expose
    private String publicPhone;
    @SerializedName("PublicWebsite")
    @Nullable
    @Expose
    private String publicWebsite;
    @SerializedName("RecordsTransfer")
    @Nullable
    @Expose
    private Boolean recordsTransfer;
    @SerializedName("RecordsTransferURL")
    @Nullable
    @Expose
    private String recordsTransferURL;
    @SerializedName("SchoolName")
    @Nullable
    @Expose
    private String schoolName;
    private boolean selected;
    @SerializedName("State")
    @Nullable
    @Expose
    private String state;
    @SerializedName("Status")
    @Nullable
    @Expose
    private String status;
    @SerializedName("StreetAddress")
    @Nullable
    @Expose
    private String streetAddress;
    @SerializedName("ZipCode")
    @Nullable
    @Expose
    private String zipCode;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/models/School$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/aeries/mobileportal/models/School;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/aeries/mobileportal/models/School;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: School.kt */
    public static final class CREATOR implements Creator<School> {
        private CREATOR() {
        }

        @NotNull
        public School createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new School(parcel);
        }

        @NotNull
        public School[] newArray(int i) {
            return new School[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public String realmGet$CDS() {
        return this.CDS;
    }

    public Boolean realmGet$aeriesAppParent() {
        return this.aeriesAppParent;
    }

    public String realmGet$aeriesAppParentURL() {
        return this.aeriesAppParentURL;
    }

    public Boolean realmGet$aeriesAppStaff() {
        return this.aeriesAppStaff;
    }

    public String realmGet$aeriesAppStaffURL() {
        return this.aeriesAppStaffURL;
    }

    public Boolean realmGet$aeriesAppTeacher() {
        return this.aeriesAppTeacher;
    }

    public String realmGet$aeriesAppTeacherURL() {
        return this.aeriesAppTeacherURL;
    }

    public String realmGet$city() {
        return this.city;
    }

    public String realmGet$closeDate() {
        return this.closeDate;
    }

    public String realmGet$county() {
        return this.county;
    }

    public String realmGet$districtName() {
        return this.districtName;
    }

    public String realmGet$fax() {
        return this.fax;
    }

    public Integer realmGet$highGrade() {
        return this.highGrade;
    }

    public Boolean realmGet$isCharter() {
        return this.isCharter;
    }

    public String realmGet$latitude() {
        return this.latitude;
    }

    public String realmGet$longitude() {
        return this.longitude;
    }

    public Integer realmGet$lowGrade() {
        return this.lowGrade;
    }

    public String realmGet$mailingAddress() {
        return this.mailingAddress;
    }

    public String realmGet$mailingCity() {
        return this.mailingCity;
    }

    public String realmGet$mailingState() {
        return this.mailingState;
    }

    public String realmGet$mailingZipCode() {
        return this.mailingZipCode;
    }

    public String realmGet$openDate() {
        return this.openDate;
    }

    public String realmGet$publicAdminEmail() {
        return this.publicAdminEmail;
    }

    public String realmGet$publicAdminFirstName() {
        return this.publicAdminFirstName;
    }

    public String realmGet$publicAdminLastName() {
        return this.publicAdminLastName;
    }

    public String realmGet$publicPhone() {
        return this.publicPhone;
    }

    public String realmGet$publicWebsite() {
        return this.publicWebsite;
    }

    public Boolean realmGet$recordsTransfer() {
        return this.recordsTransfer;
    }

    public String realmGet$recordsTransferURL() {
        return this.recordsTransferURL;
    }

    public String realmGet$schoolName() {
        return this.schoolName;
    }

    public boolean realmGet$selected() {
        return this.selected;
    }

    public String realmGet$state() {
        return this.state;
    }

    public String realmGet$status() {
        return this.status;
    }

    public String realmGet$streetAddress() {
        return this.streetAddress;
    }

    public String realmGet$zipCode() {
        return this.zipCode;
    }

    public void realmSet$CDS(String str) {
        this.CDS = str;
    }

    public void realmSet$aeriesAppParent(Boolean bool) {
        this.aeriesAppParent = bool;
    }

    public void realmSet$aeriesAppParentURL(String str) {
        this.aeriesAppParentURL = str;
    }

    public void realmSet$aeriesAppStaff(Boolean bool) {
        this.aeriesAppStaff = bool;
    }

    public void realmSet$aeriesAppStaffURL(String str) {
        this.aeriesAppStaffURL = str;
    }

    public void realmSet$aeriesAppTeacher(Boolean bool) {
        this.aeriesAppTeacher = bool;
    }

    public void realmSet$aeriesAppTeacherURL(String str) {
        this.aeriesAppTeacherURL = str;
    }

    public void realmSet$city(String str) {
        this.city = str;
    }

    public void realmSet$closeDate(String str) {
        this.closeDate = str;
    }

    public void realmSet$county(String str) {
        this.county = str;
    }

    public void realmSet$districtName(String str) {
        this.districtName = str;
    }

    public void realmSet$fax(String str) {
        this.fax = str;
    }

    public void realmSet$highGrade(Integer num) {
        this.highGrade = num;
    }

    public void realmSet$isCharter(Boolean bool) {
        this.isCharter = bool;
    }

    public void realmSet$latitude(String str) {
        this.latitude = str;
    }

    public void realmSet$longitude(String str) {
        this.longitude = str;
    }

    public void realmSet$lowGrade(Integer num) {
        this.lowGrade = num;
    }

    public void realmSet$mailingAddress(String str) {
        this.mailingAddress = str;
    }

    public void realmSet$mailingCity(String str) {
        this.mailingCity = str;
    }

    public void realmSet$mailingState(String str) {
        this.mailingState = str;
    }

    public void realmSet$mailingZipCode(String str) {
        this.mailingZipCode = str;
    }

    public void realmSet$openDate(String str) {
        this.openDate = str;
    }

    public void realmSet$publicAdminEmail(String str) {
        this.publicAdminEmail = str;
    }

    public void realmSet$publicAdminFirstName(String str) {
        this.publicAdminFirstName = str;
    }

    public void realmSet$publicAdminLastName(String str) {
        this.publicAdminLastName = str;
    }

    public void realmSet$publicPhone(String str) {
        this.publicPhone = str;
    }

    public void realmSet$publicWebsite(String str) {
        this.publicWebsite = str;
    }

    public void realmSet$recordsTransfer(Boolean bool) {
        this.recordsTransfer = bool;
    }

    public void realmSet$recordsTransferURL(String str) {
        this.recordsTransferURL = str;
    }

    public void realmSet$schoolName(String str) {
        this.schoolName = str;
    }

    public void realmSet$selected(boolean z) {
        this.selected = z;
    }

    public void realmSet$state(String str) {
        this.state = str;
    }

    public void realmSet$status(String str) {
        this.status = str;
    }

    public void realmSet$streetAddress(String str) {
        this.streetAddress = str;
    }

    public void realmSet$zipCode(String str) {
        this.zipCode = str;
    }

    public School() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$CDS("");
        realmSet$schoolName("");
        realmSet$districtName("");
        realmSet$status("");
        realmSet$county("");
        realmSet$streetAddress("");
        realmSet$city("");
        realmSet$state("");
        realmSet$zipCode("");
        realmSet$mailingAddress("");
        realmSet$mailingCity("");
        realmSet$mailingState("");
        realmSet$mailingZipCode("");
        realmSet$aeriesAppParentURL("");
        realmSet$aeriesAppStaffURL("");
        realmSet$aeriesAppTeacherURL("");
        realmSet$aeriesAppParent(Boolean.valueOf(false));
        realmSet$aeriesAppStaff(Boolean.valueOf(false));
        realmSet$aeriesAppTeacher(Boolean.valueOf(false));
        realmSet$recordsTransferURL("");
        realmSet$recordsTransfer(Boolean.valueOf(false));
        realmSet$fax("");
        realmSet$publicPhone("");
        realmSet$publicWebsite("");
        realmSet$openDate("");
        realmSet$closeDate("");
        realmSet$isCharter(Boolean.valueOf(false));
        realmSet$latitude("");
        realmSet$longitude("");
        realmSet$publicAdminFirstName("");
        realmSet$publicAdminLastName("");
        realmSet$publicAdminEmail("");
        realmSet$highGrade(Integer.valueOf(0));
        realmSet$lowGrade(Integer.valueOf(0));
    }

    @Nullable
    public final String getCDS() {
        return realmGet$CDS();
    }

    public final void setCDS(@Nullable String str) {
        realmSet$CDS(str);
    }

    @Nullable
    public final String getSchoolName() {
        return realmGet$schoolName();
    }

    public final void setSchoolName(@Nullable String str) {
        realmSet$schoolName(str);
    }

    @Nullable
    public final String getDistrictName() {
        return realmGet$districtName();
    }

    public final void setDistrictName(@Nullable String str) {
        realmSet$districtName(str);
    }

    @Nullable
    public final String getStatus() {
        return realmGet$status();
    }

    public final void setStatus(@Nullable String str) {
        realmSet$status(str);
    }

    @Nullable
    public final String getCounty() {
        return realmGet$county();
    }

    public final void setCounty(@Nullable String str) {
        realmSet$county(str);
    }

    @Nullable
    public final String getStreetAddress() {
        return realmGet$streetAddress();
    }

    public final void setStreetAddress(@Nullable String str) {
        realmSet$streetAddress(str);
    }

    @Nullable
    public final String getCity() {
        return realmGet$city();
    }

    public final void setCity(@Nullable String str) {
        realmSet$city(str);
    }

    @Nullable
    public final String getState() {
        return realmGet$state();
    }

    public final void setState(@Nullable String str) {
        realmSet$state(str);
    }

    @Nullable
    public final String getZipCode() {
        return realmGet$zipCode();
    }

    public final void setZipCode(@Nullable String str) {
        realmSet$zipCode(str);
    }

    @Nullable
    public final String getMailingAddress() {
        return realmGet$mailingAddress();
    }

    public final void setMailingAddress(@Nullable String str) {
        realmSet$mailingAddress(str);
    }

    @Nullable
    public final String getMailingCity() {
        return realmGet$mailingCity();
    }

    public final void setMailingCity(@Nullable String str) {
        realmSet$mailingCity(str);
    }

    @Nullable
    public final String getMailingState() {
        return realmGet$mailingState();
    }

    public final void setMailingState(@Nullable String str) {
        realmSet$mailingState(str);
    }

    @Nullable
    public final String getMailingZipCode() {
        return realmGet$mailingZipCode();
    }

    public final void setMailingZipCode(@Nullable String str) {
        realmSet$mailingZipCode(str);
    }

    @Nullable
    public final String getAeriesAppParentURL() {
        return realmGet$aeriesAppParentURL();
    }

    public final void setAeriesAppParentURL(@Nullable String str) {
        realmSet$aeriesAppParentURL(str);
    }

    @Nullable
    public final String getAeriesAppStaffURL() {
        return realmGet$aeriesAppStaffURL();
    }

    public final void setAeriesAppStaffURL(@Nullable String str) {
        realmSet$aeriesAppStaffURL(str);
    }

    @Nullable
    public final String getAeriesAppTeacherURL() {
        return realmGet$aeriesAppTeacherURL();
    }

    public final void setAeriesAppTeacherURL(@Nullable String str) {
        realmSet$aeriesAppTeacherURL(str);
    }

    @Nullable
    public final Boolean getAeriesAppParent() {
        return realmGet$aeriesAppParent();
    }

    public final void setAeriesAppParent(@Nullable Boolean bool) {
        realmSet$aeriesAppParent(bool);
    }

    @Nullable
    public final Boolean getAeriesAppStaff() {
        return realmGet$aeriesAppStaff();
    }

    public final void setAeriesAppStaff(@Nullable Boolean bool) {
        realmSet$aeriesAppStaff(bool);
    }

    @Nullable
    public final Boolean getAeriesAppTeacher() {
        return realmGet$aeriesAppTeacher();
    }

    public final void setAeriesAppTeacher(@Nullable Boolean bool) {
        realmSet$aeriesAppTeacher(bool);
    }

    @Nullable
    public final String getRecordsTransferURL() {
        return realmGet$recordsTransferURL();
    }

    public final void setRecordsTransferURL(@Nullable String str) {
        realmSet$recordsTransferURL(str);
    }

    @Nullable
    public final Boolean getRecordsTransfer() {
        return realmGet$recordsTransfer();
    }

    public final void setRecordsTransfer(@Nullable Boolean bool) {
        realmSet$recordsTransfer(bool);
    }

    @Nullable
    public final String getFax() {
        return realmGet$fax();
    }

    public final void setFax(@Nullable String str) {
        realmSet$fax(str);
    }

    @Nullable
    public final String getPublicPhone() {
        return realmGet$publicPhone();
    }

    public final void setPublicPhone(@Nullable String str) {
        realmSet$publicPhone(str);
    }

    @Nullable
    public final String getPublicWebsite() {
        return realmGet$publicWebsite();
    }

    public final void setPublicWebsite(@Nullable String str) {
        realmSet$publicWebsite(str);
    }

    @Nullable
    public final String getOpenDate() {
        return realmGet$openDate();
    }

    public final void setOpenDate(@Nullable String str) {
        realmSet$openDate(str);
    }

    @Nullable
    public final String getCloseDate() {
        return realmGet$closeDate();
    }

    public final void setCloseDate(@Nullable String str) {
        realmSet$closeDate(str);
    }

    @Nullable
    public final Boolean isCharter() {
        return realmGet$isCharter();
    }

    public final void setCharter(@Nullable Boolean bool) {
        realmSet$isCharter(bool);
    }

    @Nullable
    public final String getLatitude() {
        return realmGet$latitude();
    }

    public final void setLatitude(@Nullable String str) {
        realmSet$latitude(str);
    }

    @Nullable
    public final String getLongitude() {
        return realmGet$longitude();
    }

    public final void setLongitude(@Nullable String str) {
        realmSet$longitude(str);
    }

    @Nullable
    public final String getPublicAdminFirstName() {
        return realmGet$publicAdminFirstName();
    }

    public final void setPublicAdminFirstName(@Nullable String str) {
        realmSet$publicAdminFirstName(str);
    }

    @Nullable
    public final String getPublicAdminLastName() {
        return realmGet$publicAdminLastName();
    }

    public final void setPublicAdminLastName(@Nullable String str) {
        realmSet$publicAdminLastName(str);
    }

    @Nullable
    public final String getPublicAdminEmail() {
        return realmGet$publicAdminEmail();
    }

    public final void setPublicAdminEmail(@Nullable String str) {
        realmSet$publicAdminEmail(str);
    }

    @Nullable
    public final Integer getHighGrade() {
        return realmGet$highGrade();
    }

    public final void setHighGrade(@Nullable Integer num) {
        realmSet$highGrade(num);
    }

    @Nullable
    public final Integer getLowGrade() {
        return realmGet$lowGrade();
    }

    public final void setLowGrade(@Nullable Integer num) {
        realmSet$lowGrade(num);
    }

    public final boolean getSelected() {
        return realmGet$selected();
    }

    public final void setSelected(boolean z) {
        realmSet$selected(z);
    }

    public School(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this();
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$CDS(parcel.readString());
        realmSet$schoolName(parcel.readString());
        realmSet$districtName(parcel.readString());
        realmSet$status(parcel.readString());
        realmSet$county(parcel.readString());
        realmSet$streetAddress(parcel.readString());
        realmSet$city(parcel.readString());
        realmSet$state(parcel.readString());
        realmSet$zipCode(parcel.readString());
        realmSet$mailingAddress(parcel.readString());
        realmSet$mailingCity(parcel.readString());
        realmSet$mailingState(parcel.readString());
        realmSet$mailingZipCode(parcel.readString());
        realmSet$aeriesAppParentURL(parcel.readString());
        realmSet$aeriesAppStaffURL(parcel.readString());
        realmSet$aeriesAppTeacherURL(parcel.readString());
        Object readValue = parcel.readValue(Boolean.TYPE.getClassLoader());
        if (!(readValue instanceof Boolean)) {
            readValue = null;
        }
        realmSet$aeriesAppParent((Boolean) readValue);
        readValue = parcel.readValue(Boolean.TYPE.getClassLoader());
        if (!(readValue instanceof Boolean)) {
            readValue = null;
        }
        realmSet$aeriesAppStaff((Boolean) readValue);
        readValue = parcel.readValue(Boolean.TYPE.getClassLoader());
        if (!(readValue instanceof Boolean)) {
            readValue = null;
        }
        realmSet$aeriesAppTeacher((Boolean) readValue);
        realmSet$recordsTransferURL(parcel.readString());
        readValue = parcel.readValue(Boolean.TYPE.getClassLoader());
        if (!(readValue instanceof Boolean)) {
            readValue = null;
        }
        realmSet$recordsTransfer((Boolean) readValue);
        realmSet$fax(parcel.readString());
        realmSet$publicPhone(parcel.readString());
        realmSet$publicWebsite(parcel.readString());
        realmSet$openDate(parcel.readString());
        realmSet$closeDate(parcel.readString());
        readValue = parcel.readValue(Boolean.TYPE.getClassLoader());
        if (!(readValue instanceof Boolean)) {
            readValue = null;
        }
        realmSet$isCharter((Boolean) readValue);
        realmSet$latitude(parcel.readString());
        realmSet$longitude(parcel.readString());
        realmSet$publicAdminFirstName(parcel.readString());
        realmSet$publicAdminLastName(parcel.readString());
        realmSet$publicAdminEmail(parcel.readString());
        readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(readValue instanceof Integer)) {
            readValue = null;
        }
        realmSet$highGrade((Integer) readValue);
        parcel = parcel.readValue(Integer.TYPE.getClassLoader());
        if (!(parcel instanceof Integer)) {
            parcel = null;
        }
        realmSet$lowGrade((Integer) parcel);
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(realmGet$CDS());
        parcel.writeString(realmGet$schoolName());
        parcel.writeString(realmGet$districtName());
        parcel.writeString(realmGet$status());
        parcel.writeString(realmGet$county());
        parcel.writeString(realmGet$streetAddress());
        parcel.writeString(realmGet$city());
        parcel.writeString(realmGet$state());
        parcel.writeString(realmGet$zipCode());
        parcel.writeString(realmGet$mailingAddress());
        parcel.writeString(realmGet$mailingCity());
        parcel.writeString(realmGet$mailingState());
        parcel.writeString(realmGet$mailingZipCode());
        parcel.writeString(realmGet$aeriesAppParentURL());
        parcel.writeString(realmGet$aeriesAppStaffURL());
        parcel.writeString(realmGet$aeriesAppTeacherURL());
        parcel.writeValue(realmGet$aeriesAppParent());
        parcel.writeValue(realmGet$aeriesAppStaff());
        parcel.writeValue(realmGet$aeriesAppTeacher());
        parcel.writeString(realmGet$recordsTransferURL());
        parcel.writeValue(realmGet$recordsTransfer());
        parcel.writeString(realmGet$fax());
        parcel.writeString(realmGet$publicPhone());
        parcel.writeString(realmGet$publicWebsite());
        parcel.writeString(realmGet$openDate());
        parcel.writeString(realmGet$closeDate());
        parcel.writeValue(realmGet$isCharter());
        parcel.writeString(realmGet$latitude());
        parcel.writeString(realmGet$longitude());
        parcel.writeString(realmGet$publicAdminFirstName());
        parcel.writeString(realmGet$publicAdminLastName());
        parcel.writeString(realmGet$publicAdminEmail());
        parcel.writeValue(realmGet$highGrade());
        parcel.writeValue(realmGet$lowGrade());
    }
}
