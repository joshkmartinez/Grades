package io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.aeries.mobileportal.models.School;
import io.realm.BaseRealm.RealmObjectContext;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsObjectSchemaInfo.Builder;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmObjectProxy.CacheData;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SchoolRealmProxy extends School implements RealmObjectProxy, SchoolRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private SchoolColumnInfo columnInfo;
    private ProxyState<School> proxyState;

    static final class SchoolColumnInfo extends ColumnInfo {
        long CDSIndex;
        long aeriesAppParentIndex;
        long aeriesAppParentURLIndex;
        long aeriesAppStaffIndex;
        long aeriesAppStaffURLIndex;
        long aeriesAppTeacherIndex;
        long aeriesAppTeacherURLIndex;
        long cityIndex;
        long closeDateIndex;
        long countyIndex;
        long districtNameIndex;
        long faxIndex;
        long highGradeIndex;
        long isCharterIndex;
        long latitudeIndex;
        long longitudeIndex;
        long lowGradeIndex;
        long mailingAddressIndex;
        long mailingCityIndex;
        long mailingStateIndex;
        long mailingZipCodeIndex;
        long openDateIndex;
        long publicAdminEmailIndex;
        long publicAdminFirstNameIndex;
        long publicAdminLastNameIndex;
        long publicPhoneIndex;
        long publicWebsiteIndex;
        long recordsTransferIndex;
        long recordsTransferURLIndex;
        long schoolNameIndex;
        long selectedIndex;
        long stateIndex;
        long statusIndex;
        long streetAddressIndex;
        long zipCodeIndex;

        SchoolColumnInfo(SharedRealm sharedRealm, Table table) {
            super(35);
            this.CDSIndex = addColumnDetails(table, "CDS", RealmFieldType.STRING);
            this.schoolNameIndex = addColumnDetails(table, "schoolName", RealmFieldType.STRING);
            this.districtNameIndex = addColumnDetails(table, "districtName", RealmFieldType.STRING);
            this.statusIndex = addColumnDetails(table, "status", RealmFieldType.STRING);
            this.countyIndex = addColumnDetails(table, "county", RealmFieldType.STRING);
            this.streetAddressIndex = addColumnDetails(table, "streetAddress", RealmFieldType.STRING);
            this.cityIndex = addColumnDetails(table, "city", RealmFieldType.STRING);
            this.stateIndex = addColumnDetails(table, "state", RealmFieldType.STRING);
            this.zipCodeIndex = addColumnDetails(table, "zipCode", RealmFieldType.STRING);
            this.mailingAddressIndex = addColumnDetails(table, "mailingAddress", RealmFieldType.STRING);
            this.mailingCityIndex = addColumnDetails(table, "mailingCity", RealmFieldType.STRING);
            this.mailingStateIndex = addColumnDetails(table, "mailingState", RealmFieldType.STRING);
            this.mailingZipCodeIndex = addColumnDetails(table, "mailingZipCode", RealmFieldType.STRING);
            this.aeriesAppParentURLIndex = addColumnDetails(table, "aeriesAppParentURL", RealmFieldType.STRING);
            this.aeriesAppStaffURLIndex = addColumnDetails(table, "aeriesAppStaffURL", RealmFieldType.STRING);
            this.aeriesAppTeacherURLIndex = addColumnDetails(table, "aeriesAppTeacherURL", RealmFieldType.STRING);
            this.aeriesAppParentIndex = addColumnDetails(table, "aeriesAppParent", RealmFieldType.BOOLEAN);
            this.aeriesAppStaffIndex = addColumnDetails(table, "aeriesAppStaff", RealmFieldType.BOOLEAN);
            this.aeriesAppTeacherIndex = addColumnDetails(table, "aeriesAppTeacher", RealmFieldType.BOOLEAN);
            this.recordsTransferURLIndex = addColumnDetails(table, "recordsTransferURL", RealmFieldType.STRING);
            this.recordsTransferIndex = addColumnDetails(table, "recordsTransfer", RealmFieldType.BOOLEAN);
            this.faxIndex = addColumnDetails(table, "fax", RealmFieldType.STRING);
            this.publicPhoneIndex = addColumnDetails(table, "publicPhone", RealmFieldType.STRING);
            this.publicWebsiteIndex = addColumnDetails(table, "publicWebsite", RealmFieldType.STRING);
            this.openDateIndex = addColumnDetails(table, "openDate", RealmFieldType.STRING);
            this.closeDateIndex = addColumnDetails(table, "closeDate", RealmFieldType.STRING);
            this.isCharterIndex = addColumnDetails(table, "isCharter", RealmFieldType.BOOLEAN);
            this.latitudeIndex = addColumnDetails(table, "latitude", RealmFieldType.STRING);
            this.longitudeIndex = addColumnDetails(table, "longitude", RealmFieldType.STRING);
            this.publicAdminFirstNameIndex = addColumnDetails(table, "publicAdminFirstName", RealmFieldType.STRING);
            this.publicAdminLastNameIndex = addColumnDetails(table, "publicAdminLastName", RealmFieldType.STRING);
            this.publicAdminEmailIndex = addColumnDetails(table, "publicAdminEmail", RealmFieldType.STRING);
            this.highGradeIndex = addColumnDetails(table, "highGrade", RealmFieldType.INTEGER);
            this.lowGradeIndex = addColumnDetails(table, "lowGrade", RealmFieldType.INTEGER);
            this.selectedIndex = addColumnDetails(table, "selected", RealmFieldType.BOOLEAN);
        }

        SchoolColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        protected final ColumnInfo copy(boolean z) {
            return new SchoolColumnInfo((ColumnInfo) this, z);
        }

        protected final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            SchoolColumnInfo schoolColumnInfo = (SchoolColumnInfo) columnInfo;
            SchoolColumnInfo schoolColumnInfo2 = (SchoolColumnInfo) columnInfo2;
            schoolColumnInfo2.CDSIndex = schoolColumnInfo.CDSIndex;
            schoolColumnInfo2.schoolNameIndex = schoolColumnInfo.schoolNameIndex;
            schoolColumnInfo2.districtNameIndex = schoolColumnInfo.districtNameIndex;
            schoolColumnInfo2.statusIndex = schoolColumnInfo.statusIndex;
            schoolColumnInfo2.countyIndex = schoolColumnInfo.countyIndex;
            schoolColumnInfo2.streetAddressIndex = schoolColumnInfo.streetAddressIndex;
            schoolColumnInfo2.cityIndex = schoolColumnInfo.cityIndex;
            schoolColumnInfo2.stateIndex = schoolColumnInfo.stateIndex;
            schoolColumnInfo2.zipCodeIndex = schoolColumnInfo.zipCodeIndex;
            schoolColumnInfo2.mailingAddressIndex = schoolColumnInfo.mailingAddressIndex;
            schoolColumnInfo2.mailingCityIndex = schoolColumnInfo.mailingCityIndex;
            schoolColumnInfo2.mailingStateIndex = schoolColumnInfo.mailingStateIndex;
            schoolColumnInfo2.mailingZipCodeIndex = schoolColumnInfo.mailingZipCodeIndex;
            schoolColumnInfo2.aeriesAppParentURLIndex = schoolColumnInfo.aeriesAppParentURLIndex;
            schoolColumnInfo2.aeriesAppStaffURLIndex = schoolColumnInfo.aeriesAppStaffURLIndex;
            schoolColumnInfo2.aeriesAppTeacherURLIndex = schoolColumnInfo.aeriesAppTeacherURLIndex;
            schoolColumnInfo2.aeriesAppParentIndex = schoolColumnInfo.aeriesAppParentIndex;
            schoolColumnInfo2.aeriesAppStaffIndex = schoolColumnInfo.aeriesAppStaffIndex;
            schoolColumnInfo2.aeriesAppTeacherIndex = schoolColumnInfo.aeriesAppTeacherIndex;
            schoolColumnInfo2.recordsTransferURLIndex = schoolColumnInfo.recordsTransferURLIndex;
            schoolColumnInfo2.recordsTransferIndex = schoolColumnInfo.recordsTransferIndex;
            schoolColumnInfo2.faxIndex = schoolColumnInfo.faxIndex;
            schoolColumnInfo2.publicPhoneIndex = schoolColumnInfo.publicPhoneIndex;
            schoolColumnInfo2.publicWebsiteIndex = schoolColumnInfo.publicWebsiteIndex;
            schoolColumnInfo2.openDateIndex = schoolColumnInfo.openDateIndex;
            schoolColumnInfo2.closeDateIndex = schoolColumnInfo.closeDateIndex;
            schoolColumnInfo2.isCharterIndex = schoolColumnInfo.isCharterIndex;
            schoolColumnInfo2.latitudeIndex = schoolColumnInfo.latitudeIndex;
            schoolColumnInfo2.longitudeIndex = schoolColumnInfo.longitudeIndex;
            schoolColumnInfo2.publicAdminFirstNameIndex = schoolColumnInfo.publicAdminFirstNameIndex;
            schoolColumnInfo2.publicAdminLastNameIndex = schoolColumnInfo.publicAdminLastNameIndex;
            schoolColumnInfo2.publicAdminEmailIndex = schoolColumnInfo.publicAdminEmailIndex;
            schoolColumnInfo2.highGradeIndex = schoolColumnInfo.highGradeIndex;
            schoolColumnInfo2.lowGradeIndex = schoolColumnInfo.lowGradeIndex;
            schoolColumnInfo2.selectedIndex = schoolColumnInfo.selectedIndex;
        }
    }

    public static String getTableName() {
        return "class_School";
    }

    static {
        List arrayList = new ArrayList();
        arrayList.add("CDS");
        arrayList.add("schoolName");
        arrayList.add("districtName");
        arrayList.add("status");
        arrayList.add("county");
        arrayList.add("streetAddress");
        arrayList.add("city");
        arrayList.add("state");
        arrayList.add("zipCode");
        arrayList.add("mailingAddress");
        arrayList.add("mailingCity");
        arrayList.add("mailingState");
        arrayList.add("mailingZipCode");
        arrayList.add("aeriesAppParentURL");
        arrayList.add("aeriesAppStaffURL");
        arrayList.add("aeriesAppTeacherURL");
        arrayList.add("aeriesAppParent");
        arrayList.add("aeriesAppStaff");
        arrayList.add("aeriesAppTeacher");
        arrayList.add("recordsTransferURL");
        arrayList.add("recordsTransfer");
        arrayList.add("fax");
        arrayList.add("publicPhone");
        arrayList.add("publicWebsite");
        arrayList.add("openDate");
        arrayList.add("closeDate");
        arrayList.add("isCharter");
        arrayList.add("latitude");
        arrayList.add("longitude");
        arrayList.add("publicAdminFirstName");
        arrayList.add("publicAdminLastName");
        arrayList.add("publicAdminEmail");
        arrayList.add("highGrade");
        arrayList.add("lowGrade");
        arrayList.add("selected");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    SchoolRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (SchoolColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$CDS() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.CDSIndex);
    }

    public void realmSet$CDS(String str) {
        if (this.proxyState.isUnderConstruction() == null) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'CDS' cannot be changed after object was created.");
        }
    }

    public String realmGet$schoolName() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.schoolNameIndex);
    }

    public void realmSet$schoolName(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.schoolNameIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.schoolNameIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.schoolNameIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.schoolNameIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$districtName() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.districtNameIndex);
    }

    public void realmSet$districtName(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.districtNameIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.districtNameIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.districtNameIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.districtNameIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$status() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.statusIndex);
    }

    public void realmSet$status(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.statusIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.statusIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.statusIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.statusIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$county() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.countyIndex);
    }

    public void realmSet$county(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.countyIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.countyIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.countyIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.countyIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$streetAddress() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.streetAddressIndex);
    }

    public void realmSet$streetAddress(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.streetAddressIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.streetAddressIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.streetAddressIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.streetAddressIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$city() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.cityIndex);
    }

    public void realmSet$city(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.cityIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.cityIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.cityIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.cityIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$state() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.stateIndex);
    }

    public void realmSet$state(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.stateIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.stateIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.stateIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.stateIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$zipCode() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.zipCodeIndex);
    }

    public void realmSet$zipCode(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.zipCodeIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.zipCodeIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.zipCodeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.zipCodeIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$mailingAddress() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.mailingAddressIndex);
    }

    public void realmSet$mailingAddress(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.mailingAddressIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.mailingAddressIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.mailingAddressIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.mailingAddressIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$mailingCity() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.mailingCityIndex);
    }

    public void realmSet$mailingCity(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.mailingCityIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.mailingCityIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.mailingCityIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.mailingCityIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$mailingState() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.mailingStateIndex);
    }

    public void realmSet$mailingState(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.mailingStateIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.mailingStateIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.mailingStateIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.mailingStateIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$mailingZipCode() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.mailingZipCodeIndex);
    }

    public void realmSet$mailingZipCode(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.mailingZipCodeIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.mailingZipCodeIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.mailingZipCodeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.mailingZipCodeIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$aeriesAppParentURL() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.aeriesAppParentURLIndex);
    }

    public void realmSet$aeriesAppParentURL(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.aeriesAppParentURLIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.aeriesAppParentURLIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.aeriesAppParentURLIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.aeriesAppParentURLIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$aeriesAppStaffURL() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.aeriesAppStaffURLIndex);
    }

    public void realmSet$aeriesAppStaffURL(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.aeriesAppStaffURLIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.aeriesAppStaffURLIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.aeriesAppStaffURLIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.aeriesAppStaffURLIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$aeriesAppTeacherURL() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.aeriesAppTeacherURLIndex);
    }

    public void realmSet$aeriesAppTeacherURL(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.aeriesAppTeacherURLIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.aeriesAppTeacherURLIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.aeriesAppTeacherURLIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.aeriesAppTeacherURLIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public Boolean realmGet$aeriesAppParent() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.aeriesAppParentIndex)) {
            return null;
        }
        return Boolean.valueOf(this.proxyState.getRow$realm().getBoolean(this.columnInfo.aeriesAppParentIndex));
    }

    public void realmSet$aeriesAppParent(Boolean bool) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (bool == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.aeriesAppParentIndex);
            } else {
                this.proxyState.getRow$realm().setBoolean(this.columnInfo.aeriesAppParentIndex, bool.booleanValue());
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (bool == null) {
                row$realm.getTable().setNull(this.columnInfo.aeriesAppParentIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setBoolean(this.columnInfo.aeriesAppParentIndex, row$realm.getIndex(), bool.booleanValue(), true);
            }
        }
    }

    public Boolean realmGet$aeriesAppStaff() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.aeriesAppStaffIndex)) {
            return null;
        }
        return Boolean.valueOf(this.proxyState.getRow$realm().getBoolean(this.columnInfo.aeriesAppStaffIndex));
    }

    public void realmSet$aeriesAppStaff(Boolean bool) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (bool == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.aeriesAppStaffIndex);
            } else {
                this.proxyState.getRow$realm().setBoolean(this.columnInfo.aeriesAppStaffIndex, bool.booleanValue());
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (bool == null) {
                row$realm.getTable().setNull(this.columnInfo.aeriesAppStaffIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setBoolean(this.columnInfo.aeriesAppStaffIndex, row$realm.getIndex(), bool.booleanValue(), true);
            }
        }
    }

    public Boolean realmGet$aeriesAppTeacher() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.aeriesAppTeacherIndex)) {
            return null;
        }
        return Boolean.valueOf(this.proxyState.getRow$realm().getBoolean(this.columnInfo.aeriesAppTeacherIndex));
    }

    public void realmSet$aeriesAppTeacher(Boolean bool) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (bool == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.aeriesAppTeacherIndex);
            } else {
                this.proxyState.getRow$realm().setBoolean(this.columnInfo.aeriesAppTeacherIndex, bool.booleanValue());
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (bool == null) {
                row$realm.getTable().setNull(this.columnInfo.aeriesAppTeacherIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setBoolean(this.columnInfo.aeriesAppTeacherIndex, row$realm.getIndex(), bool.booleanValue(), true);
            }
        }
    }

    public String realmGet$recordsTransferURL() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.recordsTransferURLIndex);
    }

    public void realmSet$recordsTransferURL(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.recordsTransferURLIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.recordsTransferURLIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.recordsTransferURLIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.recordsTransferURLIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public Boolean realmGet$recordsTransfer() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.recordsTransferIndex)) {
            return null;
        }
        return Boolean.valueOf(this.proxyState.getRow$realm().getBoolean(this.columnInfo.recordsTransferIndex));
    }

    public void realmSet$recordsTransfer(Boolean bool) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (bool == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.recordsTransferIndex);
            } else {
                this.proxyState.getRow$realm().setBoolean(this.columnInfo.recordsTransferIndex, bool.booleanValue());
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (bool == null) {
                row$realm.getTable().setNull(this.columnInfo.recordsTransferIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setBoolean(this.columnInfo.recordsTransferIndex, row$realm.getIndex(), bool.booleanValue(), true);
            }
        }
    }

    public String realmGet$fax() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.faxIndex);
    }

    public void realmSet$fax(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.faxIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.faxIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.faxIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.faxIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$publicPhone() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.publicPhoneIndex);
    }

    public void realmSet$publicPhone(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.publicPhoneIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.publicPhoneIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.publicPhoneIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.publicPhoneIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$publicWebsite() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.publicWebsiteIndex);
    }

    public void realmSet$publicWebsite(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.publicWebsiteIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.publicWebsiteIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.publicWebsiteIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.publicWebsiteIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$openDate() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.openDateIndex);
    }

    public void realmSet$openDate(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.openDateIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.openDateIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.openDateIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.openDateIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$closeDate() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.closeDateIndex);
    }

    public void realmSet$closeDate(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.closeDateIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.closeDateIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.closeDateIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.closeDateIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public Boolean realmGet$isCharter() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.isCharterIndex)) {
            return null;
        }
        return Boolean.valueOf(this.proxyState.getRow$realm().getBoolean(this.columnInfo.isCharterIndex));
    }

    public void realmSet$isCharter(Boolean bool) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (bool == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.isCharterIndex);
            } else {
                this.proxyState.getRow$realm().setBoolean(this.columnInfo.isCharterIndex, bool.booleanValue());
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (bool == null) {
                row$realm.getTable().setNull(this.columnInfo.isCharterIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setBoolean(this.columnInfo.isCharterIndex, row$realm.getIndex(), bool.booleanValue(), true);
            }
        }
    }

    public String realmGet$latitude() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.latitudeIndex);
    }

    public void realmSet$latitude(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.latitudeIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.latitudeIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.latitudeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.latitudeIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$longitude() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.longitudeIndex);
    }

    public void realmSet$longitude(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.longitudeIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.longitudeIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.longitudeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.longitudeIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$publicAdminFirstName() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.publicAdminFirstNameIndex);
    }

    public void realmSet$publicAdminFirstName(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.publicAdminFirstNameIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.publicAdminFirstNameIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.publicAdminFirstNameIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.publicAdminFirstNameIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$publicAdminLastName() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.publicAdminLastNameIndex);
    }

    public void realmSet$publicAdminLastName(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.publicAdminLastNameIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.publicAdminLastNameIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.publicAdminLastNameIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.publicAdminLastNameIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$publicAdminEmail() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.publicAdminEmailIndex);
    }

    public void realmSet$publicAdminEmail(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.publicAdminEmailIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.publicAdminEmailIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.publicAdminEmailIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.publicAdminEmailIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public Integer realmGet$highGrade() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.highGradeIndex)) {
            return null;
        }
        return Integer.valueOf((int) this.proxyState.getRow$realm().getLong(this.columnInfo.highGradeIndex));
    }

    public void realmSet$highGrade(Integer num) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (num == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.highGradeIndex);
            } else {
                r0.proxyState.getRow$realm().setLong(r0.columnInfo.highGradeIndex, (long) num.intValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (num == null) {
                row$realm.getTable().setNull(r0.columnInfo.highGradeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setLong(r0.columnInfo.highGradeIndex, row$realm.getIndex(), (long) num.intValue(), true);
            }
        }
    }

    public Integer realmGet$lowGrade() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.lowGradeIndex)) {
            return null;
        }
        return Integer.valueOf((int) this.proxyState.getRow$realm().getLong(this.columnInfo.lowGradeIndex));
    }

    public void realmSet$lowGrade(Integer num) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (num == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.lowGradeIndex);
            } else {
                r0.proxyState.getRow$realm().setLong(r0.columnInfo.lowGradeIndex, (long) num.intValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (num == null) {
                row$realm.getTable().setNull(r0.columnInfo.lowGradeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setLong(r0.columnInfo.lowGradeIndex, row$realm.getIndex(), (long) num.intValue(), true);
            }
        }
    }

    public boolean realmGet$selected() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.selectedIndex);
    }

    public void realmSet$selected(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.selectedIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.selectedIndex, row$realm.getIndex(), z, true);
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        Builder builder = new Builder("School");
        Builder builder2 = builder;
        builder2.addProperty("CDS", RealmFieldType.STRING, true, true, false);
        builder2.addProperty("schoolName", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("districtName", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("status", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("county", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("streetAddress", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("city", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("state", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("zipCode", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("mailingAddress", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("mailingCity", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("mailingState", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("mailingZipCode", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("aeriesAppParentURL", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("aeriesAppStaffURL", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("aeriesAppTeacherURL", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("aeriesAppParent", RealmFieldType.BOOLEAN, false, false, false);
        builder2.addProperty("aeriesAppStaff", RealmFieldType.BOOLEAN, false, false, false);
        builder2.addProperty("aeriesAppTeacher", RealmFieldType.BOOLEAN, false, false, false);
        builder2.addProperty("recordsTransferURL", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("recordsTransfer", RealmFieldType.BOOLEAN, false, false, false);
        builder2.addProperty("fax", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("publicPhone", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("publicWebsite", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("openDate", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("closeDate", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("isCharter", RealmFieldType.BOOLEAN, false, false, false);
        builder2.addProperty("latitude", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("longitude", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("publicAdminFirstName", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("publicAdminLastName", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("publicAdminEmail", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("highGrade", RealmFieldType.INTEGER, false, false, false);
        builder2.addProperty("lowGrade", RealmFieldType.INTEGER, false, false, false);
        builder2.addProperty("selected", RealmFieldType.BOOLEAN, false, false, true);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static SchoolColumnInfo validateTable(SharedRealm sharedRealm, boolean z) {
        if (sharedRealm.hasTable("class_School")) {
            Table table = sharedRealm.getTable("class_School");
            long columnCount = table.getColumnCount();
            if (columnCount != 35) {
                StringBuilder stringBuilder;
                if (columnCount < 35) {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is less than expected - expected 35 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                } else if (z) {
                    RealmLog.debug("Field count is more than expected - expected 35 but was %1$d", Long.valueOf(columnCount));
                } else {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is more than expected - expected 35 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                }
            }
            z = new HashMap();
            for (long j = 0; j < columnCount; j++) {
                z.put(table.getColumnName(j), table.getColumnType(j));
            }
            SchoolColumnInfo schoolColumnInfo = new SchoolColumnInfo(sharedRealm, table);
            if (!table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'CDS' in existing Realm file. @PrimaryKey was added.");
            } else if (table.getPrimaryKey() != schoolColumnInfo.CDSIndex) {
                sharedRealm = sharedRealm.getPath();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Primary Key annotation definition was changed, from field ");
                stringBuilder2.append(table.getColumnName(table.getPrimaryKey()));
                stringBuilder2.append(" to field CDS");
                throw new RealmMigrationNeededException(sharedRealm, stringBuilder2.toString());
            } else if (!z.containsKey("CDS")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'CDS' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("CDS") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'CDS' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.CDSIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "@PrimaryKey field 'CDS' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            } else if (!table.hasSearchIndex(table.getColumnIndex("CDS"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'CDS' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            } else if (!z.containsKey("schoolName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'schoolName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("schoolName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'schoolName' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.schoolNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'schoolName' is required. Either set @Required to field 'schoolName' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("districtName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'districtName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("districtName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'districtName' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.districtNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'districtName' is required. Either set @Required to field 'districtName' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("status")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'status' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("status") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'status' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.statusIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'status' is required. Either set @Required to field 'status' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("county")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'county' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("county") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'county' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.countyIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'county' is required. Either set @Required to field 'county' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("streetAddress")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'streetAddress' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("streetAddress") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'streetAddress' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.streetAddressIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'streetAddress' is required. Either set @Required to field 'streetAddress' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("city")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'city' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("city") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'city' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.cityIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'city' is required. Either set @Required to field 'city' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("state")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'state' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("state") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'state' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.stateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'state' is required. Either set @Required to field 'state' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("zipCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'zipCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("zipCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'zipCode' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.zipCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'zipCode' is required. Either set @Required to field 'zipCode' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("mailingAddress")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mailingAddress' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("mailingAddress") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'mailingAddress' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.mailingAddressIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mailingAddress' is required. Either set @Required to field 'mailingAddress' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("mailingCity")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mailingCity' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("mailingCity") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'mailingCity' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.mailingCityIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mailingCity' is required. Either set @Required to field 'mailingCity' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("mailingState")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mailingState' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("mailingState") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'mailingState' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.mailingStateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mailingState' is required. Either set @Required to field 'mailingState' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("mailingZipCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mailingZipCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("mailingZipCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'mailingZipCode' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.mailingZipCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mailingZipCode' is required. Either set @Required to field 'mailingZipCode' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("aeriesAppParentURL")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'aeriesAppParentURL' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("aeriesAppParentURL") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'aeriesAppParentURL' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.aeriesAppParentURLIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'aeriesAppParentURL' is required. Either set @Required to field 'aeriesAppParentURL' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("aeriesAppStaffURL")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'aeriesAppStaffURL' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("aeriesAppStaffURL") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'aeriesAppStaffURL' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.aeriesAppStaffURLIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'aeriesAppStaffURL' is required. Either set @Required to field 'aeriesAppStaffURL' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("aeriesAppTeacherURL")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'aeriesAppTeacherURL' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("aeriesAppTeacherURL") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'aeriesAppTeacherURL' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.aeriesAppTeacherURLIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'aeriesAppTeacherURL' is required. Either set @Required to field 'aeriesAppTeacherURL' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("aeriesAppParent")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'aeriesAppParent' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("aeriesAppParent") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'aeriesAppParent' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.aeriesAppParentIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'aeriesAppParent' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'aeriesAppParent' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("aeriesAppStaff")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'aeriesAppStaff' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("aeriesAppStaff") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'aeriesAppStaff' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.aeriesAppStaffIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'aeriesAppStaff' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'aeriesAppStaff' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("aeriesAppTeacher")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'aeriesAppTeacher' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("aeriesAppTeacher") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'aeriesAppTeacher' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.aeriesAppTeacherIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'aeriesAppTeacher' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'aeriesAppTeacher' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("recordsTransferURL")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'recordsTransferURL' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("recordsTransferURL") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'recordsTransferURL' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.recordsTransferURLIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'recordsTransferURL' is required. Either set @Required to field 'recordsTransferURL' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("recordsTransfer")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'recordsTransfer' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("recordsTransfer") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'recordsTransfer' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.recordsTransferIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'recordsTransfer' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'recordsTransfer' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("fax")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'fax' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("fax") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'fax' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.faxIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'fax' is required. Either set @Required to field 'fax' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("publicPhone")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'publicPhone' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("publicPhone") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'publicPhone' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.publicPhoneIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'publicPhone' is required. Either set @Required to field 'publicPhone' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("publicWebsite")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'publicWebsite' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("publicWebsite") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'publicWebsite' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.publicWebsiteIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'publicWebsite' is required. Either set @Required to field 'publicWebsite' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("openDate")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'openDate' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("openDate") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'openDate' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.openDateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'openDate' is required. Either set @Required to field 'openDate' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("closeDate")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'closeDate' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("closeDate") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'closeDate' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.closeDateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'closeDate' is required. Either set @Required to field 'closeDate' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("isCharter")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isCharter' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("isCharter") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'isCharter' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.isCharterIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isCharter' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'isCharter' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("latitude")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'latitude' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("latitude") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'latitude' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.latitudeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'latitude' is required. Either set @Required to field 'latitude' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("longitude")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'longitude' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("longitude") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'longitude' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.longitudeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'longitude' is required. Either set @Required to field 'longitude' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("publicAdminFirstName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'publicAdminFirstName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("publicAdminFirstName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'publicAdminFirstName' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.publicAdminFirstNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'publicAdminFirstName' is required. Either set @Required to field 'publicAdminFirstName' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("publicAdminLastName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'publicAdminLastName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("publicAdminLastName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'publicAdminLastName' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.publicAdminLastNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'publicAdminLastName' is required. Either set @Required to field 'publicAdminLastName' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("publicAdminEmail")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'publicAdminEmail' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("publicAdminEmail") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'publicAdminEmail' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.publicAdminEmailIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'publicAdminEmail' is required. Either set @Required to field 'publicAdminEmail' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("highGrade")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'highGrade' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("highGrade") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'highGrade' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.highGradeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'highGrade' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'highGrade' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("lowGrade")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'lowGrade' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("lowGrade") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'lowGrade' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.lowGradeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'lowGrade' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'lowGrade' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("selected")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'selected' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("selected") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'selected' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolColumnInfo.selectedIndex)) {
                return schoolColumnInfo;
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'selected' does support null values in the existing Realm file. Use corresponding boxed type for field 'selected' or migrate using RealmObjectSchema.setNullable().");
            }
        }
        throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'School' class is missing from the schema for this Realm.");
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static School createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        List emptyList = Collections.emptyList();
        if (z) {
            z = realm.getTable(School.class);
            long primaryKey = z.getPrimaryKey();
            if (jSONObject.isNull("CDS")) {
                primaryKey = z.findFirstNull(primaryKey);
            } else {
                primaryKey = z.findFirstString(primaryKey, jSONObject.getString("CDS"));
            }
            if (primaryKey != -1) {
                RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
                try {
                    realmObjectContext.set(realm, z.getUncheckedRow(primaryKey), realm.schema.getColumnInfo(School.class), false, Collections.emptyList());
                    z = new SchoolRealmProxy();
                    if (!z) {
                        if (jSONObject.has("CDS")) {
                            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'CDS'.");
                        } else if (jSONObject.isNull("CDS")) {
                            z = (SchoolRealmProxy) realm.createObjectInternal(School.class, jSONObject.getString("CDS"), true, emptyList);
                        } else {
                            z = (SchoolRealmProxy) realm.createObjectInternal(School.class, null, true, emptyList);
                        }
                    }
                    if (jSONObject.has("schoolName") != null) {
                        if (jSONObject.isNull("schoolName") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$schoolName(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$schoolName(jSONObject.getString("schoolName"));
                        }
                    }
                    if (jSONObject.has("districtName") != null) {
                        if (jSONObject.isNull("districtName") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$districtName(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$districtName(jSONObject.getString("districtName"));
                        }
                    }
                    if (jSONObject.has("status") != null) {
                        if (jSONObject.isNull("status") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$status(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$status(jSONObject.getString("status"));
                        }
                    }
                    if (jSONObject.has("county") != null) {
                        if (jSONObject.isNull("county") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$county(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$county(jSONObject.getString("county"));
                        }
                    }
                    if (jSONObject.has("streetAddress") != null) {
                        if (jSONObject.isNull("streetAddress") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$streetAddress(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$streetAddress(jSONObject.getString("streetAddress"));
                        }
                    }
                    if (jSONObject.has("city") != null) {
                        if (jSONObject.isNull("city") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$city(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$city(jSONObject.getString("city"));
                        }
                    }
                    if (jSONObject.has("state") != null) {
                        if (jSONObject.isNull("state") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$state(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$state(jSONObject.getString("state"));
                        }
                    }
                    if (jSONObject.has("zipCode") != null) {
                        if (jSONObject.isNull("zipCode") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$zipCode(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$zipCode(jSONObject.getString("zipCode"));
                        }
                    }
                    if (jSONObject.has("mailingAddress") != null) {
                        if (jSONObject.isNull("mailingAddress") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$mailingAddress(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$mailingAddress(jSONObject.getString("mailingAddress"));
                        }
                    }
                    if (jSONObject.has("mailingCity") != null) {
                        if (jSONObject.isNull("mailingCity") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$mailingCity(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$mailingCity(jSONObject.getString("mailingCity"));
                        }
                    }
                    if (jSONObject.has("mailingState") != null) {
                        if (jSONObject.isNull("mailingState") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$mailingState(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$mailingState(jSONObject.getString("mailingState"));
                        }
                    }
                    if (jSONObject.has("mailingZipCode") != null) {
                        if (jSONObject.isNull("mailingZipCode") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$mailingZipCode(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$mailingZipCode(jSONObject.getString("mailingZipCode"));
                        }
                    }
                    if (jSONObject.has("aeriesAppParentURL") != null) {
                        if (jSONObject.isNull("aeriesAppParentURL") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$aeriesAppParentURL(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$aeriesAppParentURL(jSONObject.getString("aeriesAppParentURL"));
                        }
                    }
                    if (jSONObject.has("aeriesAppStaffURL") != null) {
                        if (jSONObject.isNull("aeriesAppStaffURL") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$aeriesAppStaffURL(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$aeriesAppStaffURL(jSONObject.getString("aeriesAppStaffURL"));
                        }
                    }
                    if (jSONObject.has("aeriesAppTeacherURL") != null) {
                        if (jSONObject.isNull("aeriesAppTeacherURL") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$aeriesAppTeacherURL(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$aeriesAppTeacherURL(jSONObject.getString("aeriesAppTeacherURL"));
                        }
                    }
                    if (jSONObject.has("aeriesAppParent") != null) {
                        if (jSONObject.isNull("aeriesAppParent") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$aeriesAppParent(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$aeriesAppParent(Boolean.valueOf(jSONObject.getBoolean("aeriesAppParent")));
                        }
                    }
                    if (jSONObject.has("aeriesAppStaff") != null) {
                        if (jSONObject.isNull("aeriesAppStaff") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$aeriesAppStaff(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$aeriesAppStaff(Boolean.valueOf(jSONObject.getBoolean("aeriesAppStaff")));
                        }
                    }
                    if (jSONObject.has("aeriesAppTeacher") != null) {
                        if (jSONObject.isNull("aeriesAppTeacher") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$aeriesAppTeacher(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$aeriesAppTeacher(Boolean.valueOf(jSONObject.getBoolean("aeriesAppTeacher")));
                        }
                    }
                    if (jSONObject.has("recordsTransferURL") != null) {
                        if (jSONObject.isNull("recordsTransferURL") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$recordsTransferURL(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$recordsTransferURL(jSONObject.getString("recordsTransferURL"));
                        }
                    }
                    if (jSONObject.has("recordsTransfer") != null) {
                        if (jSONObject.isNull("recordsTransfer") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$recordsTransfer(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$recordsTransfer(Boolean.valueOf(jSONObject.getBoolean("recordsTransfer")));
                        }
                    }
                    if (jSONObject.has("fax") != null) {
                        if (jSONObject.isNull("fax") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$fax(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$fax(jSONObject.getString("fax"));
                        }
                    }
                    if (jSONObject.has("publicPhone") != null) {
                        if (jSONObject.isNull("publicPhone") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$publicPhone(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$publicPhone(jSONObject.getString("publicPhone"));
                        }
                    }
                    if (jSONObject.has("publicWebsite") != null) {
                        if (jSONObject.isNull("publicWebsite") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$publicWebsite(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$publicWebsite(jSONObject.getString("publicWebsite"));
                        }
                    }
                    if (jSONObject.has("openDate") != null) {
                        if (jSONObject.isNull("openDate") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$openDate(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$openDate(jSONObject.getString("openDate"));
                        }
                    }
                    if (jSONObject.has("closeDate") != null) {
                        if (jSONObject.isNull("closeDate") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$closeDate(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$closeDate(jSONObject.getString("closeDate"));
                        }
                    }
                    if (jSONObject.has("isCharter") != null) {
                        if (jSONObject.isNull("isCharter") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$isCharter(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$isCharter(Boolean.valueOf(jSONObject.getBoolean("isCharter")));
                        }
                    }
                    if (jSONObject.has("latitude") != null) {
                        if (jSONObject.isNull("latitude") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$latitude(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$latitude(jSONObject.getString("latitude"));
                        }
                    }
                    if (jSONObject.has("longitude") != null) {
                        if (jSONObject.isNull("longitude") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$longitude(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$longitude(jSONObject.getString("longitude"));
                        }
                    }
                    if (jSONObject.has("publicAdminFirstName") != null) {
                        if (jSONObject.isNull("publicAdminFirstName") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$publicAdminFirstName(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$publicAdminFirstName(jSONObject.getString("publicAdminFirstName"));
                        }
                    }
                    if (jSONObject.has("publicAdminLastName") != null) {
                        if (jSONObject.isNull("publicAdminLastName") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$publicAdminLastName(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$publicAdminLastName(jSONObject.getString("publicAdminLastName"));
                        }
                    }
                    if (jSONObject.has("publicAdminEmail") != null) {
                        if (jSONObject.isNull("publicAdminEmail") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$publicAdminEmail(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$publicAdminEmail(jSONObject.getString("publicAdminEmail"));
                        }
                    }
                    if (jSONObject.has("highGrade") != null) {
                        if (jSONObject.isNull("highGrade") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$highGrade(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$highGrade(Integer.valueOf(jSONObject.getInt("highGrade")));
                        }
                    }
                    if (jSONObject.has("lowGrade") != null) {
                        if (jSONObject.isNull("lowGrade") == null) {
                            ((SchoolRealmProxyInterface) z).realmSet$lowGrade(null);
                        } else {
                            ((SchoolRealmProxyInterface) z).realmSet$lowGrade(Integer.valueOf(jSONObject.getInt("lowGrade")));
                        }
                    }
                    if (jSONObject.has("selected") != null) {
                        if (jSONObject.isNull("selected") != null) {
                            ((SchoolRealmProxyInterface) z).realmSet$selected(jSONObject.getBoolean("selected"));
                        } else {
                            throw new IllegalArgumentException("Trying to set non-nullable field 'selected' to null.");
                        }
                    }
                    return z;
                } finally {
                    realmObjectContext.clear();
                }
            }
        }
        z = false;
        if (z) {
            if (jSONObject.has("CDS")) {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'CDS'.");
            } else if (jSONObject.isNull("CDS")) {
                z = (SchoolRealmProxy) realm.createObjectInternal(School.class, jSONObject.getString("CDS"), true, emptyList);
            } else {
                z = (SchoolRealmProxy) realm.createObjectInternal(School.class, null, true, emptyList);
            }
        }
        if (jSONObject.has("schoolName") != null) {
            if (jSONObject.isNull("schoolName") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$schoolName(jSONObject.getString("schoolName"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$schoolName(null);
            }
        }
        if (jSONObject.has("districtName") != null) {
            if (jSONObject.isNull("districtName") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$districtName(jSONObject.getString("districtName"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$districtName(null);
            }
        }
        if (jSONObject.has("status") != null) {
            if (jSONObject.isNull("status") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$status(jSONObject.getString("status"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$status(null);
            }
        }
        if (jSONObject.has("county") != null) {
            if (jSONObject.isNull("county") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$county(jSONObject.getString("county"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$county(null);
            }
        }
        if (jSONObject.has("streetAddress") != null) {
            if (jSONObject.isNull("streetAddress") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$streetAddress(jSONObject.getString("streetAddress"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$streetAddress(null);
            }
        }
        if (jSONObject.has("city") != null) {
            if (jSONObject.isNull("city") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$city(jSONObject.getString("city"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$city(null);
            }
        }
        if (jSONObject.has("state") != null) {
            if (jSONObject.isNull("state") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$state(jSONObject.getString("state"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$state(null);
            }
        }
        if (jSONObject.has("zipCode") != null) {
            if (jSONObject.isNull("zipCode") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$zipCode(jSONObject.getString("zipCode"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$zipCode(null);
            }
        }
        if (jSONObject.has("mailingAddress") != null) {
            if (jSONObject.isNull("mailingAddress") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$mailingAddress(jSONObject.getString("mailingAddress"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$mailingAddress(null);
            }
        }
        if (jSONObject.has("mailingCity") != null) {
            if (jSONObject.isNull("mailingCity") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$mailingCity(jSONObject.getString("mailingCity"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$mailingCity(null);
            }
        }
        if (jSONObject.has("mailingState") != null) {
            if (jSONObject.isNull("mailingState") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$mailingState(jSONObject.getString("mailingState"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$mailingState(null);
            }
        }
        if (jSONObject.has("mailingZipCode") != null) {
            if (jSONObject.isNull("mailingZipCode") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$mailingZipCode(jSONObject.getString("mailingZipCode"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$mailingZipCode(null);
            }
        }
        if (jSONObject.has("aeriesAppParentURL") != null) {
            if (jSONObject.isNull("aeriesAppParentURL") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$aeriesAppParentURL(jSONObject.getString("aeriesAppParentURL"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$aeriesAppParentURL(null);
            }
        }
        if (jSONObject.has("aeriesAppStaffURL") != null) {
            if (jSONObject.isNull("aeriesAppStaffURL") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$aeriesAppStaffURL(jSONObject.getString("aeriesAppStaffURL"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$aeriesAppStaffURL(null);
            }
        }
        if (jSONObject.has("aeriesAppTeacherURL") != null) {
            if (jSONObject.isNull("aeriesAppTeacherURL") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$aeriesAppTeacherURL(jSONObject.getString("aeriesAppTeacherURL"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$aeriesAppTeacherURL(null);
            }
        }
        if (jSONObject.has("aeriesAppParent") != null) {
            if (jSONObject.isNull("aeriesAppParent") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$aeriesAppParent(Boolean.valueOf(jSONObject.getBoolean("aeriesAppParent")));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$aeriesAppParent(null);
            }
        }
        if (jSONObject.has("aeriesAppStaff") != null) {
            if (jSONObject.isNull("aeriesAppStaff") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$aeriesAppStaff(Boolean.valueOf(jSONObject.getBoolean("aeriesAppStaff")));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$aeriesAppStaff(null);
            }
        }
        if (jSONObject.has("aeriesAppTeacher") != null) {
            if (jSONObject.isNull("aeriesAppTeacher") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$aeriesAppTeacher(Boolean.valueOf(jSONObject.getBoolean("aeriesAppTeacher")));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$aeriesAppTeacher(null);
            }
        }
        if (jSONObject.has("recordsTransferURL") != null) {
            if (jSONObject.isNull("recordsTransferURL") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$recordsTransferURL(jSONObject.getString("recordsTransferURL"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$recordsTransferURL(null);
            }
        }
        if (jSONObject.has("recordsTransfer") != null) {
            if (jSONObject.isNull("recordsTransfer") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$recordsTransfer(Boolean.valueOf(jSONObject.getBoolean("recordsTransfer")));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$recordsTransfer(null);
            }
        }
        if (jSONObject.has("fax") != null) {
            if (jSONObject.isNull("fax") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$fax(jSONObject.getString("fax"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$fax(null);
            }
        }
        if (jSONObject.has("publicPhone") != null) {
            if (jSONObject.isNull("publicPhone") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$publicPhone(jSONObject.getString("publicPhone"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$publicPhone(null);
            }
        }
        if (jSONObject.has("publicWebsite") != null) {
            if (jSONObject.isNull("publicWebsite") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$publicWebsite(jSONObject.getString("publicWebsite"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$publicWebsite(null);
            }
        }
        if (jSONObject.has("openDate") != null) {
            if (jSONObject.isNull("openDate") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$openDate(jSONObject.getString("openDate"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$openDate(null);
            }
        }
        if (jSONObject.has("closeDate") != null) {
            if (jSONObject.isNull("closeDate") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$closeDate(jSONObject.getString("closeDate"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$closeDate(null);
            }
        }
        if (jSONObject.has("isCharter") != null) {
            if (jSONObject.isNull("isCharter") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$isCharter(Boolean.valueOf(jSONObject.getBoolean("isCharter")));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$isCharter(null);
            }
        }
        if (jSONObject.has("latitude") != null) {
            if (jSONObject.isNull("latitude") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$latitude(jSONObject.getString("latitude"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$latitude(null);
            }
        }
        if (jSONObject.has("longitude") != null) {
            if (jSONObject.isNull("longitude") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$longitude(jSONObject.getString("longitude"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$longitude(null);
            }
        }
        if (jSONObject.has("publicAdminFirstName") != null) {
            if (jSONObject.isNull("publicAdminFirstName") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$publicAdminFirstName(jSONObject.getString("publicAdminFirstName"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$publicAdminFirstName(null);
            }
        }
        if (jSONObject.has("publicAdminLastName") != null) {
            if (jSONObject.isNull("publicAdminLastName") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$publicAdminLastName(jSONObject.getString("publicAdminLastName"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$publicAdminLastName(null);
            }
        }
        if (jSONObject.has("publicAdminEmail") != null) {
            if (jSONObject.isNull("publicAdminEmail") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$publicAdminEmail(jSONObject.getString("publicAdminEmail"));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$publicAdminEmail(null);
            }
        }
        if (jSONObject.has("highGrade") != null) {
            if (jSONObject.isNull("highGrade") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$highGrade(Integer.valueOf(jSONObject.getInt("highGrade")));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$highGrade(null);
            }
        }
        if (jSONObject.has("lowGrade") != null) {
            if (jSONObject.isNull("lowGrade") == null) {
                ((SchoolRealmProxyInterface) z).realmSet$lowGrade(Integer.valueOf(jSONObject.getInt("lowGrade")));
            } else {
                ((SchoolRealmProxyInterface) z).realmSet$lowGrade(null);
            }
        }
        if (jSONObject.has("selected") != null) {
            if (jSONObject.isNull("selected") != null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'selected' to null.");
            }
            ((SchoolRealmProxyInterface) z).realmSet$selected(jSONObject.getBoolean("selected"));
        }
        return z;
    }

    @TargetApi(11)
    public static School createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RealmModel school = new School();
        jsonReader.beginObject();
        Object obj = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("CDS")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$CDS(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$CDS(jsonReader.nextString());
                }
                obj = 1;
            } else if (nextName.equals("schoolName")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$schoolName(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$schoolName(jsonReader.nextString());
                }
            } else if (nextName.equals("districtName")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$districtName(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$districtName(jsonReader.nextString());
                }
            } else if (nextName.equals("status")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$status(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$status(jsonReader.nextString());
                }
            } else if (nextName.equals("county")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$county(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$county(jsonReader.nextString());
                }
            } else if (nextName.equals("streetAddress")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$streetAddress(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$streetAddress(jsonReader.nextString());
                }
            } else if (nextName.equals("city")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$city(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$city(jsonReader.nextString());
                }
            } else if (nextName.equals("state")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$state(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$state(jsonReader.nextString());
                }
            } else if (nextName.equals("zipCode")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$zipCode(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$zipCode(jsonReader.nextString());
                }
            } else if (nextName.equals("mailingAddress")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$mailingAddress(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$mailingAddress(jsonReader.nextString());
                }
            } else if (nextName.equals("mailingCity")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$mailingCity(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$mailingCity(jsonReader.nextString());
                }
            } else if (nextName.equals("mailingState")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$mailingState(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$mailingState(jsonReader.nextString());
                }
            } else if (nextName.equals("mailingZipCode")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$mailingZipCode(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$mailingZipCode(jsonReader.nextString());
                }
            } else if (nextName.equals("aeriesAppParentURL")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$aeriesAppParentURL(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$aeriesAppParentURL(jsonReader.nextString());
                }
            } else if (nextName.equals("aeriesAppStaffURL")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$aeriesAppStaffURL(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$aeriesAppStaffURL(jsonReader.nextString());
                }
            } else if (nextName.equals("aeriesAppTeacherURL")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$aeriesAppTeacherURL(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$aeriesAppTeacherURL(jsonReader.nextString());
                }
            } else if (nextName.equals("aeriesAppParent")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$aeriesAppParent(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$aeriesAppParent(Boolean.valueOf(jsonReader.nextBoolean()));
                }
            } else if (nextName.equals("aeriesAppStaff")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$aeriesAppStaff(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$aeriesAppStaff(Boolean.valueOf(jsonReader.nextBoolean()));
                }
            } else if (nextName.equals("aeriesAppTeacher")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$aeriesAppTeacher(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$aeriesAppTeacher(Boolean.valueOf(jsonReader.nextBoolean()));
                }
            } else if (nextName.equals("recordsTransferURL")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$recordsTransferURL(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$recordsTransferURL(jsonReader.nextString());
                }
            } else if (nextName.equals("recordsTransfer")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$recordsTransfer(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$recordsTransfer(Boolean.valueOf(jsonReader.nextBoolean()));
                }
            } else if (nextName.equals("fax")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$fax(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$fax(jsonReader.nextString());
                }
            } else if (nextName.equals("publicPhone")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$publicPhone(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$publicPhone(jsonReader.nextString());
                }
            } else if (nextName.equals("publicWebsite")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$publicWebsite(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$publicWebsite(jsonReader.nextString());
                }
            } else if (nextName.equals("openDate")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$openDate(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$openDate(jsonReader.nextString());
                }
            } else if (nextName.equals("closeDate")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$closeDate(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$closeDate(jsonReader.nextString());
                }
            } else if (nextName.equals("isCharter")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$isCharter(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$isCharter(Boolean.valueOf(jsonReader.nextBoolean()));
                }
            } else if (nextName.equals("latitude")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$latitude(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$latitude(jsonReader.nextString());
                }
            } else if (nextName.equals("longitude")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$longitude(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$longitude(jsonReader.nextString());
                }
            } else if (nextName.equals("publicAdminFirstName")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$publicAdminFirstName(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$publicAdminFirstName(jsonReader.nextString());
                }
            } else if (nextName.equals("publicAdminLastName")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$publicAdminLastName(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$publicAdminLastName(jsonReader.nextString());
                }
            } else if (nextName.equals("publicAdminEmail")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$publicAdminEmail(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$publicAdminEmail(jsonReader.nextString());
                }
            } else if (nextName.equals("highGrade")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$highGrade(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$highGrade(Integer.valueOf(jsonReader.nextInt()));
                }
            } else if (nextName.equals("lowGrade")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolRealmProxyInterface) school).realmSet$lowGrade(null);
                } else {
                    ((SchoolRealmProxyInterface) school).realmSet$lowGrade(Integer.valueOf(jsonReader.nextInt()));
                }
            } else if (!nextName.equals("selected")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                ((SchoolRealmProxyInterface) school).realmSet$selected(jsonReader.nextBoolean());
            } else {
                jsonReader.skipValue();
                throw new IllegalArgumentException("Trying to set non-nullable field 'selected' to null.");
            }
        }
        jsonReader.endObject();
        if (obj != null) {
            return (School) realm.copyToRealm(school);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'CDS'.");
    }

    public static School copyOrUpdate(Realm realm, School school, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy;
        boolean z2 = school instanceof RealmObjectProxy;
        if (z2) {
            realmObjectProxy = (RealmObjectProxy) school;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null) {
                if (realmObjectProxy.realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                }
            }
        }
        if (z2) {
            RealmObjectProxy realmObjectProxy2 = (RealmObjectProxy) school;
            if (realmObjectProxy2.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy2.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return school;
            }
        }
        RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectProxy = (RealmObjectProxy) map.get(school);
        if (realmObjectProxy != null) {
            return (School) realmObjectProxy;
        }
        School school2 = null;
        if (z) {
            Table table = realm.getTable(School.class);
            long primaryKey = table.getPrimaryKey();
            String realmGet$CDS = school.realmGet$CDS();
            if (realmGet$CDS == null) {
                primaryKey = table.findFirstNull(primaryKey);
            } else {
                primaryKey = table.findFirstString(primaryKey, realmGet$CDS);
            }
            if (primaryKey != -1) {
                try {
                    realmObjectContext.set(realm, table.getUncheckedRow(primaryKey), realm.schema.getColumnInfo(School.class), false, Collections.emptyList());
                    school2 = new SchoolRealmProxy();
                    map.put(school, (RealmObjectProxy) school2);
                } finally {
                    realmObjectContext.clear();
                }
            } else {
                z2 = false;
                if (z2) {
                    return copy(realm, school, z, map);
                }
                return update(realm, school2, school, map);
            }
        }
        z2 = z;
        if (z2) {
            return copy(realm, school, z, map);
        }
        return update(realm, school2, school, map);
    }

    public static School copy(Realm realm, School school, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = (RealmObjectProxy) map.get(school);
        if (realmObjectProxy != null) {
            return (School) realmObjectProxy;
        }
        SchoolRealmProxyInterface schoolRealmProxyInterface = school;
        School school2 = (School) realm.createObjectInternal(School.class, schoolRealmProxyInterface.realmGet$CDS(), false, Collections.emptyList());
        map.put(school, (RealmObjectProxy) school2);
        SchoolRealmProxyInterface schoolRealmProxyInterface2 = school2;
        schoolRealmProxyInterface2.realmSet$schoolName(schoolRealmProxyInterface.realmGet$schoolName());
        schoolRealmProxyInterface2.realmSet$districtName(schoolRealmProxyInterface.realmGet$districtName());
        schoolRealmProxyInterface2.realmSet$status(schoolRealmProxyInterface.realmGet$status());
        schoolRealmProxyInterface2.realmSet$county(schoolRealmProxyInterface.realmGet$county());
        schoolRealmProxyInterface2.realmSet$streetAddress(schoolRealmProxyInterface.realmGet$streetAddress());
        schoolRealmProxyInterface2.realmSet$city(schoolRealmProxyInterface.realmGet$city());
        schoolRealmProxyInterface2.realmSet$state(schoolRealmProxyInterface.realmGet$state());
        schoolRealmProxyInterface2.realmSet$zipCode(schoolRealmProxyInterface.realmGet$zipCode());
        schoolRealmProxyInterface2.realmSet$mailingAddress(schoolRealmProxyInterface.realmGet$mailingAddress());
        schoolRealmProxyInterface2.realmSet$mailingCity(schoolRealmProxyInterface.realmGet$mailingCity());
        schoolRealmProxyInterface2.realmSet$mailingState(schoolRealmProxyInterface.realmGet$mailingState());
        schoolRealmProxyInterface2.realmSet$mailingZipCode(schoolRealmProxyInterface.realmGet$mailingZipCode());
        schoolRealmProxyInterface2.realmSet$aeriesAppParentURL(schoolRealmProxyInterface.realmGet$aeriesAppParentURL());
        schoolRealmProxyInterface2.realmSet$aeriesAppStaffURL(schoolRealmProxyInterface.realmGet$aeriesAppStaffURL());
        schoolRealmProxyInterface2.realmSet$aeriesAppTeacherURL(schoolRealmProxyInterface.realmGet$aeriesAppTeacherURL());
        schoolRealmProxyInterface2.realmSet$aeriesAppParent(schoolRealmProxyInterface.realmGet$aeriesAppParent());
        schoolRealmProxyInterface2.realmSet$aeriesAppStaff(schoolRealmProxyInterface.realmGet$aeriesAppStaff());
        schoolRealmProxyInterface2.realmSet$aeriesAppTeacher(schoolRealmProxyInterface.realmGet$aeriesAppTeacher());
        schoolRealmProxyInterface2.realmSet$recordsTransferURL(schoolRealmProxyInterface.realmGet$recordsTransferURL());
        schoolRealmProxyInterface2.realmSet$recordsTransfer(schoolRealmProxyInterface.realmGet$recordsTransfer());
        schoolRealmProxyInterface2.realmSet$fax(schoolRealmProxyInterface.realmGet$fax());
        schoolRealmProxyInterface2.realmSet$publicPhone(schoolRealmProxyInterface.realmGet$publicPhone());
        schoolRealmProxyInterface2.realmSet$publicWebsite(schoolRealmProxyInterface.realmGet$publicWebsite());
        schoolRealmProxyInterface2.realmSet$openDate(schoolRealmProxyInterface.realmGet$openDate());
        schoolRealmProxyInterface2.realmSet$closeDate(schoolRealmProxyInterface.realmGet$closeDate());
        schoolRealmProxyInterface2.realmSet$isCharter(schoolRealmProxyInterface.realmGet$isCharter());
        schoolRealmProxyInterface2.realmSet$latitude(schoolRealmProxyInterface.realmGet$latitude());
        schoolRealmProxyInterface2.realmSet$longitude(schoolRealmProxyInterface.realmGet$longitude());
        schoolRealmProxyInterface2.realmSet$publicAdminFirstName(schoolRealmProxyInterface.realmGet$publicAdminFirstName());
        schoolRealmProxyInterface2.realmSet$publicAdminLastName(schoolRealmProxyInterface.realmGet$publicAdminLastName());
        schoolRealmProxyInterface2.realmSet$publicAdminEmail(schoolRealmProxyInterface.realmGet$publicAdminEmail());
        schoolRealmProxyInterface2.realmSet$highGrade(schoolRealmProxyInterface.realmGet$highGrade());
        schoolRealmProxyInterface2.realmSet$lowGrade(schoolRealmProxyInterface.realmGet$lowGrade());
        schoolRealmProxyInterface2.realmSet$selected(schoolRealmProxyInterface.realmGet$selected());
        return school2;
    }

    public static long insert(Realm realm, School school, Map<RealmModel, Long> map) {
        long createRowWithPrimaryKey;
        long j;
        Realm realm2 = realm;
        School school2 = school;
        if (school2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) school2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(School.class);
        long nativePtr = table.getNativePtr();
        SchoolColumnInfo schoolColumnInfo = (SchoolColumnInfo) realm2.schema.getColumnInfo(School.class);
        long primaryKey = table.getPrimaryKey();
        SchoolRealmProxyInterface schoolRealmProxyInterface = school2;
        String realmGet$CDS = schoolRealmProxyInterface.realmGet$CDS();
        if (realmGet$CDS == null) {
            primaryKey = Table.nativeFindFirstNull(nativePtr, primaryKey);
        } else {
            primaryKey = Table.nativeFindFirstString(nativePtr, primaryKey, realmGet$CDS);
        }
        if (primaryKey == -1) {
            createRowWithPrimaryKey = OsObject.createRowWithPrimaryKey(table, realmGet$CDS);
        } else {
            Table.throwDuplicatePrimaryKeyException(realmGet$CDS);
            createRowWithPrimaryKey = primaryKey;
        }
        map.put(school2, Long.valueOf(createRowWithPrimaryKey));
        String realmGet$schoolName = schoolRealmProxyInterface.realmGet$schoolName();
        if (realmGet$schoolName != null) {
            j = createRowWithPrimaryKey;
            Table.nativeSetString(nativePtr, schoolColumnInfo.schoolNameIndex, createRowWithPrimaryKey, realmGet$schoolName, false);
        } else {
            j = createRowWithPrimaryKey;
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$districtName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.districtNameIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$status();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.statusIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$county();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.countyIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$streetAddress();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.streetAddressIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$city();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.cityIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$state();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.stateIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$zipCode();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.zipCodeIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$mailingAddress();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.mailingAddressIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$mailingCity();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.mailingCityIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$mailingState();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.mailingStateIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$mailingZipCode();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.mailingZipCodeIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$aeriesAppParentURL();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.aeriesAppParentURLIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$aeriesAppStaffURL();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.aeriesAppStaffURLIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$aeriesAppTeacherURL();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.aeriesAppTeacherURLIndex, j, realmGet$schoolName, false);
        }
        Boolean realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$aeriesAppParent();
        if (realmGet$aeriesAppParent != null) {
            Table.nativeSetBoolean(nativePtr, schoolColumnInfo.aeriesAppParentIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
        }
        realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$aeriesAppStaff();
        if (realmGet$aeriesAppParent != null) {
            Table.nativeSetBoolean(nativePtr, schoolColumnInfo.aeriesAppStaffIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
        }
        realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$aeriesAppTeacher();
        if (realmGet$aeriesAppParent != null) {
            Table.nativeSetBoolean(nativePtr, schoolColumnInfo.aeriesAppTeacherIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$recordsTransferURL();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.recordsTransferURLIndex, j, realmGet$schoolName, false);
        }
        realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$recordsTransfer();
        if (realmGet$aeriesAppParent != null) {
            Table.nativeSetBoolean(nativePtr, schoolColumnInfo.recordsTransferIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$fax();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.faxIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicPhone();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.publicPhoneIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicWebsite();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.publicWebsiteIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$openDate();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.openDateIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$closeDate();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.closeDateIndex, j, realmGet$schoolName, false);
        }
        realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$isCharter();
        if (realmGet$aeriesAppParent != null) {
            Table.nativeSetBoolean(nativePtr, schoolColumnInfo.isCharterIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$latitude();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.latitudeIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$longitude();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.longitudeIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicAdminFirstName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.publicAdminFirstNameIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicAdminLastName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.publicAdminLastNameIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicAdminEmail();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.publicAdminEmailIndex, j, realmGet$schoolName, false);
        }
        Number realmGet$highGrade = schoolRealmProxyInterface.realmGet$highGrade();
        if (realmGet$highGrade != null) {
            Table.nativeSetLong(nativePtr, schoolColumnInfo.highGradeIndex, j, realmGet$highGrade.longValue(), false);
        }
        realmGet$highGrade = schoolRealmProxyInterface.realmGet$lowGrade();
        if (realmGet$highGrade != null) {
            Table.nativeSetLong(nativePtr, schoolColumnInfo.lowGradeIndex, j, realmGet$highGrade.longValue(), false);
        }
        Table.nativeSetBoolean(nativePtr, schoolColumnInfo.selectedIndex, j, schoolRealmProxyInterface.realmGet$selected(), false);
        return j;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Table table = realm2.getTable(School.class);
        long nativePtr = table.getNativePtr();
        SchoolColumnInfo schoolColumnInfo = (SchoolColumnInfo) realm2.schema.getColumnInfo(School.class);
        long primaryKey = table.getPrimaryKey();
        while (it.hasNext()) {
            School school = (School) it.next();
            if (!map2.containsKey(school)) {
                long nativeFindFirstNull;
                long createRowWithPrimaryKey;
                long j;
                long j2;
                if (school instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) school;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(school, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                SchoolRealmProxyInterface schoolRealmProxyInterface = school;
                String realmGet$CDS = schoolRealmProxyInterface.realmGet$CDS();
                if (realmGet$CDS == null) {
                    nativeFindFirstNull = Table.nativeFindFirstNull(nativePtr, primaryKey);
                } else {
                    nativeFindFirstNull = Table.nativeFindFirstString(nativePtr, primaryKey, realmGet$CDS);
                }
                if (nativeFindFirstNull == -1) {
                    createRowWithPrimaryKey = OsObject.createRowWithPrimaryKey(table, realmGet$CDS);
                } else {
                    Table.throwDuplicatePrimaryKeyException(realmGet$CDS);
                    createRowWithPrimaryKey = nativeFindFirstNull;
                }
                map2.put(school, Long.valueOf(createRowWithPrimaryKey));
                String realmGet$schoolName = schoolRealmProxyInterface.realmGet$schoolName();
                if (realmGet$schoolName != null) {
                    j = createRowWithPrimaryKey;
                    j2 = primaryKey;
                    Table.nativeSetString(nativePtr, schoolColumnInfo.schoolNameIndex, createRowWithPrimaryKey, realmGet$schoolName, false);
                } else {
                    j = createRowWithPrimaryKey;
                    j2 = primaryKey;
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$districtName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.districtNameIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$status();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.statusIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$county();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.countyIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$streetAddress();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.streetAddressIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$city();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.cityIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$state();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.stateIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$zipCode();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.zipCodeIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$mailingAddress();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.mailingAddressIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$mailingCity();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.mailingCityIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$mailingState();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.mailingStateIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$mailingZipCode();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.mailingZipCodeIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$aeriesAppParentURL();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.aeriesAppParentURLIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$aeriesAppStaffURL();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.aeriesAppStaffURLIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$aeriesAppTeacherURL();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.aeriesAppTeacherURLIndex, j, realmGet$schoolName, false);
                }
                Boolean realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$aeriesAppParent();
                if (realmGet$aeriesAppParent != null) {
                    Table.nativeSetBoolean(nativePtr, schoolColumnInfo.aeriesAppParentIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
                }
                realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$aeriesAppStaff();
                if (realmGet$aeriesAppParent != null) {
                    Table.nativeSetBoolean(nativePtr, schoolColumnInfo.aeriesAppStaffIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
                }
                realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$aeriesAppTeacher();
                if (realmGet$aeriesAppParent != null) {
                    Table.nativeSetBoolean(nativePtr, schoolColumnInfo.aeriesAppTeacherIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$recordsTransferURL();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.recordsTransferURLIndex, j, realmGet$schoolName, false);
                }
                realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$recordsTransfer();
                if (realmGet$aeriesAppParent != null) {
                    Table.nativeSetBoolean(nativePtr, schoolColumnInfo.recordsTransferIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$fax();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.faxIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicPhone();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.publicPhoneIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicWebsite();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.publicWebsiteIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$openDate();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.openDateIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$closeDate();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.closeDateIndex, j, realmGet$schoolName, false);
                }
                realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$isCharter();
                if (realmGet$aeriesAppParent != null) {
                    Table.nativeSetBoolean(nativePtr, schoolColumnInfo.isCharterIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$latitude();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.latitudeIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$longitude();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.longitudeIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicAdminFirstName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.publicAdminFirstNameIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicAdminLastName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.publicAdminLastNameIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicAdminEmail();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.publicAdminEmailIndex, j, realmGet$schoolName, false);
                }
                Number realmGet$highGrade = schoolRealmProxyInterface.realmGet$highGrade();
                if (realmGet$highGrade != null) {
                    Table.nativeSetLong(nativePtr, schoolColumnInfo.highGradeIndex, j, realmGet$highGrade.longValue(), false);
                }
                realmGet$highGrade = schoolRealmProxyInterface.realmGet$lowGrade();
                if (realmGet$highGrade != null) {
                    Table.nativeSetLong(nativePtr, schoolColumnInfo.lowGradeIndex, j, realmGet$highGrade.longValue(), false);
                }
                Table.nativeSetBoolean(nativePtr, schoolColumnInfo.selectedIndex, j, schoolRealmProxyInterface.realmGet$selected(), false);
                primaryKey = j2;
            }
        }
    }

    public static long insertOrUpdate(Realm realm, School school, Map<RealmModel, Long> map) {
        long j;
        Realm realm2 = realm;
        School school2 = school;
        if (school2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) school2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(School.class);
        long nativePtr = table.getNativePtr();
        SchoolColumnInfo schoolColumnInfo = (SchoolColumnInfo) realm2.schema.getColumnInfo(School.class);
        long primaryKey = table.getPrimaryKey();
        SchoolRealmProxyInterface schoolRealmProxyInterface = school2;
        String realmGet$CDS = schoolRealmProxyInterface.realmGet$CDS();
        if (realmGet$CDS == null) {
            primaryKey = Table.nativeFindFirstNull(nativePtr, primaryKey);
        } else {
            primaryKey = Table.nativeFindFirstString(nativePtr, primaryKey, realmGet$CDS);
        }
        long createRowWithPrimaryKey = primaryKey == -1 ? OsObject.createRowWithPrimaryKey(table, realmGet$CDS) : primaryKey;
        map.put(school2, Long.valueOf(createRowWithPrimaryKey));
        String realmGet$schoolName = schoolRealmProxyInterface.realmGet$schoolName();
        if (realmGet$schoolName != null) {
            j = createRowWithPrimaryKey;
            Table.nativeSetString(nativePtr, schoolColumnInfo.schoolNameIndex, createRowWithPrimaryKey, realmGet$schoolName, false);
        } else {
            j = createRowWithPrimaryKey;
            Table.nativeSetNull(nativePtr, schoolColumnInfo.schoolNameIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$districtName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.districtNameIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.districtNameIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$status();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.statusIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.statusIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$county();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.countyIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.countyIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$streetAddress();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.streetAddressIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.streetAddressIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$city();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.cityIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.cityIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$state();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.stateIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.stateIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$zipCode();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.zipCodeIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.zipCodeIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$mailingAddress();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.mailingAddressIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.mailingAddressIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$mailingCity();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.mailingCityIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.mailingCityIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$mailingState();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.mailingStateIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.mailingStateIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$mailingZipCode();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.mailingZipCodeIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.mailingZipCodeIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$aeriesAppParentURL();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.aeriesAppParentURLIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.aeriesAppParentURLIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$aeriesAppStaffURL();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.aeriesAppStaffURLIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.aeriesAppStaffURLIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$aeriesAppTeacherURL();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.aeriesAppTeacherURLIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.aeriesAppTeacherURLIndex, j, false);
        }
        Boolean realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$aeriesAppParent();
        if (realmGet$aeriesAppParent != null) {
            Table.nativeSetBoolean(nativePtr, schoolColumnInfo.aeriesAppParentIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.aeriesAppParentIndex, j, false);
        }
        realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$aeriesAppStaff();
        if (realmGet$aeriesAppParent != null) {
            Table.nativeSetBoolean(nativePtr, schoolColumnInfo.aeriesAppStaffIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.aeriesAppStaffIndex, j, false);
        }
        realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$aeriesAppTeacher();
        if (realmGet$aeriesAppParent != null) {
            Table.nativeSetBoolean(nativePtr, schoolColumnInfo.aeriesAppTeacherIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.aeriesAppTeacherIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$recordsTransferURL();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.recordsTransferURLIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.recordsTransferURLIndex, j, false);
        }
        realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$recordsTransfer();
        if (realmGet$aeriesAppParent != null) {
            Table.nativeSetBoolean(nativePtr, schoolColumnInfo.recordsTransferIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.recordsTransferIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$fax();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.faxIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.faxIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicPhone();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.publicPhoneIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.publicPhoneIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicWebsite();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.publicWebsiteIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.publicWebsiteIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$openDate();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.openDateIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.openDateIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$closeDate();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.closeDateIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.closeDateIndex, j, false);
        }
        realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$isCharter();
        if (realmGet$aeriesAppParent != null) {
            Table.nativeSetBoolean(nativePtr, schoolColumnInfo.isCharterIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.isCharterIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$latitude();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.latitudeIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.latitudeIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$longitude();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.longitudeIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.longitudeIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicAdminFirstName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.publicAdminFirstNameIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.publicAdminFirstNameIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicAdminLastName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.publicAdminLastNameIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.publicAdminLastNameIndex, j, false);
        }
        realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicAdminEmail();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolColumnInfo.publicAdminEmailIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.publicAdminEmailIndex, j, false);
        }
        Number realmGet$highGrade = schoolRealmProxyInterface.realmGet$highGrade();
        if (realmGet$highGrade != null) {
            Table.nativeSetLong(nativePtr, schoolColumnInfo.highGradeIndex, j, realmGet$highGrade.longValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.highGradeIndex, j, false);
        }
        realmGet$highGrade = schoolRealmProxyInterface.realmGet$lowGrade();
        if (realmGet$highGrade != null) {
            Table.nativeSetLong(nativePtr, schoolColumnInfo.lowGradeIndex, j, realmGet$highGrade.longValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, schoolColumnInfo.lowGradeIndex, j, false);
        }
        Table.nativeSetBoolean(nativePtr, schoolColumnInfo.selectedIndex, j, schoolRealmProxyInterface.realmGet$selected(), false);
        return j;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Table table = realm2.getTable(School.class);
        long nativePtr = table.getNativePtr();
        SchoolColumnInfo schoolColumnInfo = (SchoolColumnInfo) realm2.schema.getColumnInfo(School.class);
        long primaryKey = table.getPrimaryKey();
        while (it.hasNext()) {
            School school = (School) it.next();
            if (!map2.containsKey(school)) {
                long nativeFindFirstNull;
                long j;
                long j2;
                if (school instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) school;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(school, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                SchoolRealmProxyInterface schoolRealmProxyInterface = school;
                String realmGet$CDS = schoolRealmProxyInterface.realmGet$CDS();
                if (realmGet$CDS == null) {
                    nativeFindFirstNull = Table.nativeFindFirstNull(nativePtr, primaryKey);
                } else {
                    nativeFindFirstNull = Table.nativeFindFirstString(nativePtr, primaryKey, realmGet$CDS);
                }
                long createRowWithPrimaryKey = nativeFindFirstNull == -1 ? OsObject.createRowWithPrimaryKey(table, realmGet$CDS) : nativeFindFirstNull;
                map2.put(school, Long.valueOf(createRowWithPrimaryKey));
                String realmGet$schoolName = schoolRealmProxyInterface.realmGet$schoolName();
                if (realmGet$schoolName != null) {
                    j = createRowWithPrimaryKey;
                    j2 = primaryKey;
                    Table.nativeSetString(nativePtr, schoolColumnInfo.schoolNameIndex, createRowWithPrimaryKey, realmGet$schoolName, false);
                } else {
                    j = createRowWithPrimaryKey;
                    j2 = primaryKey;
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.schoolNameIndex, createRowWithPrimaryKey, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$districtName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.districtNameIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.districtNameIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$status();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.statusIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.statusIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$county();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.countyIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.countyIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$streetAddress();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.streetAddressIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.streetAddressIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$city();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.cityIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.cityIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$state();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.stateIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.stateIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$zipCode();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.zipCodeIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.zipCodeIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$mailingAddress();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.mailingAddressIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.mailingAddressIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$mailingCity();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.mailingCityIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.mailingCityIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$mailingState();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.mailingStateIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.mailingStateIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$mailingZipCode();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.mailingZipCodeIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.mailingZipCodeIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$aeriesAppParentURL();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.aeriesAppParentURLIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.aeriesAppParentURLIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$aeriesAppStaffURL();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.aeriesAppStaffURLIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.aeriesAppStaffURLIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$aeriesAppTeacherURL();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.aeriesAppTeacherURLIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.aeriesAppTeacherURLIndex, j, false);
                }
                Boolean realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$aeriesAppParent();
                if (realmGet$aeriesAppParent != null) {
                    Table.nativeSetBoolean(nativePtr, schoolColumnInfo.aeriesAppParentIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.aeriesAppParentIndex, j, false);
                }
                realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$aeriesAppStaff();
                if (realmGet$aeriesAppParent != null) {
                    Table.nativeSetBoolean(nativePtr, schoolColumnInfo.aeriesAppStaffIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.aeriesAppStaffIndex, j, false);
                }
                realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$aeriesAppTeacher();
                if (realmGet$aeriesAppParent != null) {
                    Table.nativeSetBoolean(nativePtr, schoolColumnInfo.aeriesAppTeacherIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.aeriesAppTeacherIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$recordsTransferURL();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.recordsTransferURLIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.recordsTransferURLIndex, j, false);
                }
                realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$recordsTransfer();
                if (realmGet$aeriesAppParent != null) {
                    Table.nativeSetBoolean(nativePtr, schoolColumnInfo.recordsTransferIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.recordsTransferIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$fax();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.faxIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.faxIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicPhone();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.publicPhoneIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.publicPhoneIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicWebsite();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.publicWebsiteIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.publicWebsiteIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$openDate();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.openDateIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.openDateIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$closeDate();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.closeDateIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.closeDateIndex, j, false);
                }
                realmGet$aeriesAppParent = schoolRealmProxyInterface.realmGet$isCharter();
                if (realmGet$aeriesAppParent != null) {
                    Table.nativeSetBoolean(nativePtr, schoolColumnInfo.isCharterIndex, j, realmGet$aeriesAppParent.booleanValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.isCharterIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$latitude();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.latitudeIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.latitudeIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$longitude();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.longitudeIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.longitudeIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicAdminFirstName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.publicAdminFirstNameIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.publicAdminFirstNameIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicAdminLastName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.publicAdminLastNameIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.publicAdminLastNameIndex, j, false);
                }
                realmGet$schoolName = schoolRealmProxyInterface.realmGet$publicAdminEmail();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolColumnInfo.publicAdminEmailIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.publicAdminEmailIndex, j, false);
                }
                Number realmGet$highGrade = schoolRealmProxyInterface.realmGet$highGrade();
                if (realmGet$highGrade != null) {
                    Table.nativeSetLong(nativePtr, schoolColumnInfo.highGradeIndex, j, realmGet$highGrade.longValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.highGradeIndex, j, false);
                }
                realmGet$highGrade = schoolRealmProxyInterface.realmGet$lowGrade();
                if (realmGet$highGrade != null) {
                    Table.nativeSetLong(nativePtr, schoolColumnInfo.lowGradeIndex, j, realmGet$highGrade.longValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolColumnInfo.lowGradeIndex, j, false);
                }
                Table.nativeSetBoolean(nativePtr, schoolColumnInfo.selectedIndex, j, schoolRealmProxyInterface.realmGet$selected(), false);
                primaryKey = j2;
            }
        }
    }

    public static School createDetachedCopy(School school, int i, int i2, Map<RealmModel, CacheData<RealmModel>> map) {
        if (i <= i2) {
            if (school != null) {
                CacheData cacheData = (CacheData) map.get(school);
                if (cacheData == null) {
                    i2 = new School();
                    map.put(school, new CacheData(i, i2));
                } else if (i >= cacheData.minDepth) {
                    return cacheData.object;
                } else {
                    School school2 = (School) cacheData.object;
                    cacheData.minDepth = i;
                    i2 = school2;
                }
                SchoolRealmProxyInterface schoolRealmProxyInterface = (SchoolRealmProxyInterface) i2;
                SchoolRealmProxyInterface schoolRealmProxyInterface2 = school;
                schoolRealmProxyInterface.realmSet$CDS(schoolRealmProxyInterface2.realmGet$CDS());
                schoolRealmProxyInterface.realmSet$schoolName(schoolRealmProxyInterface2.realmGet$schoolName());
                schoolRealmProxyInterface.realmSet$districtName(schoolRealmProxyInterface2.realmGet$districtName());
                schoolRealmProxyInterface.realmSet$status(schoolRealmProxyInterface2.realmGet$status());
                schoolRealmProxyInterface.realmSet$county(schoolRealmProxyInterface2.realmGet$county());
                schoolRealmProxyInterface.realmSet$streetAddress(schoolRealmProxyInterface2.realmGet$streetAddress());
                schoolRealmProxyInterface.realmSet$city(schoolRealmProxyInterface2.realmGet$city());
                schoolRealmProxyInterface.realmSet$state(schoolRealmProxyInterface2.realmGet$state());
                schoolRealmProxyInterface.realmSet$zipCode(schoolRealmProxyInterface2.realmGet$zipCode());
                schoolRealmProxyInterface.realmSet$mailingAddress(schoolRealmProxyInterface2.realmGet$mailingAddress());
                schoolRealmProxyInterface.realmSet$mailingCity(schoolRealmProxyInterface2.realmGet$mailingCity());
                schoolRealmProxyInterface.realmSet$mailingState(schoolRealmProxyInterface2.realmGet$mailingState());
                schoolRealmProxyInterface.realmSet$mailingZipCode(schoolRealmProxyInterface2.realmGet$mailingZipCode());
                schoolRealmProxyInterface.realmSet$aeriesAppParentURL(schoolRealmProxyInterface2.realmGet$aeriesAppParentURL());
                schoolRealmProxyInterface.realmSet$aeriesAppStaffURL(schoolRealmProxyInterface2.realmGet$aeriesAppStaffURL());
                schoolRealmProxyInterface.realmSet$aeriesAppTeacherURL(schoolRealmProxyInterface2.realmGet$aeriesAppTeacherURL());
                schoolRealmProxyInterface.realmSet$aeriesAppParent(schoolRealmProxyInterface2.realmGet$aeriesAppParent());
                schoolRealmProxyInterface.realmSet$aeriesAppStaff(schoolRealmProxyInterface2.realmGet$aeriesAppStaff());
                schoolRealmProxyInterface.realmSet$aeriesAppTeacher(schoolRealmProxyInterface2.realmGet$aeriesAppTeacher());
                schoolRealmProxyInterface.realmSet$recordsTransferURL(schoolRealmProxyInterface2.realmGet$recordsTransferURL());
                schoolRealmProxyInterface.realmSet$recordsTransfer(schoolRealmProxyInterface2.realmGet$recordsTransfer());
                schoolRealmProxyInterface.realmSet$fax(schoolRealmProxyInterface2.realmGet$fax());
                schoolRealmProxyInterface.realmSet$publicPhone(schoolRealmProxyInterface2.realmGet$publicPhone());
                schoolRealmProxyInterface.realmSet$publicWebsite(schoolRealmProxyInterface2.realmGet$publicWebsite());
                schoolRealmProxyInterface.realmSet$openDate(schoolRealmProxyInterface2.realmGet$openDate());
                schoolRealmProxyInterface.realmSet$closeDate(schoolRealmProxyInterface2.realmGet$closeDate());
                schoolRealmProxyInterface.realmSet$isCharter(schoolRealmProxyInterface2.realmGet$isCharter());
                schoolRealmProxyInterface.realmSet$latitude(schoolRealmProxyInterface2.realmGet$latitude());
                schoolRealmProxyInterface.realmSet$longitude(schoolRealmProxyInterface2.realmGet$longitude());
                schoolRealmProxyInterface.realmSet$publicAdminFirstName(schoolRealmProxyInterface2.realmGet$publicAdminFirstName());
                schoolRealmProxyInterface.realmSet$publicAdminLastName(schoolRealmProxyInterface2.realmGet$publicAdminLastName());
                schoolRealmProxyInterface.realmSet$publicAdminEmail(schoolRealmProxyInterface2.realmGet$publicAdminEmail());
                schoolRealmProxyInterface.realmSet$highGrade(schoolRealmProxyInterface2.realmGet$highGrade());
                schoolRealmProxyInterface.realmSet$lowGrade(schoolRealmProxyInterface2.realmGet$lowGrade());
                schoolRealmProxyInterface.realmSet$selected(schoolRealmProxyInterface2.realmGet$selected());
                return i2;
            }
        }
        return null;
    }

    static School update(Realm realm, School school, School school2, Map<RealmModel, RealmObjectProxy> map) {
        SchoolRealmProxyInterface schoolRealmProxyInterface = school;
        SchoolRealmProxyInterface schoolRealmProxyInterface2 = school2;
        schoolRealmProxyInterface.realmSet$schoolName(schoolRealmProxyInterface2.realmGet$schoolName());
        schoolRealmProxyInterface.realmSet$districtName(schoolRealmProxyInterface2.realmGet$districtName());
        schoolRealmProxyInterface.realmSet$status(schoolRealmProxyInterface2.realmGet$status());
        schoolRealmProxyInterface.realmSet$county(schoolRealmProxyInterface2.realmGet$county());
        schoolRealmProxyInterface.realmSet$streetAddress(schoolRealmProxyInterface2.realmGet$streetAddress());
        schoolRealmProxyInterface.realmSet$city(schoolRealmProxyInterface2.realmGet$city());
        schoolRealmProxyInterface.realmSet$state(schoolRealmProxyInterface2.realmGet$state());
        schoolRealmProxyInterface.realmSet$zipCode(schoolRealmProxyInterface2.realmGet$zipCode());
        schoolRealmProxyInterface.realmSet$mailingAddress(schoolRealmProxyInterface2.realmGet$mailingAddress());
        schoolRealmProxyInterface.realmSet$mailingCity(schoolRealmProxyInterface2.realmGet$mailingCity());
        schoolRealmProxyInterface.realmSet$mailingState(schoolRealmProxyInterface2.realmGet$mailingState());
        schoolRealmProxyInterface.realmSet$mailingZipCode(schoolRealmProxyInterface2.realmGet$mailingZipCode());
        schoolRealmProxyInterface.realmSet$aeriesAppParentURL(schoolRealmProxyInterface2.realmGet$aeriesAppParentURL());
        schoolRealmProxyInterface.realmSet$aeriesAppStaffURL(schoolRealmProxyInterface2.realmGet$aeriesAppStaffURL());
        schoolRealmProxyInterface.realmSet$aeriesAppTeacherURL(schoolRealmProxyInterface2.realmGet$aeriesAppTeacherURL());
        schoolRealmProxyInterface.realmSet$aeriesAppParent(schoolRealmProxyInterface2.realmGet$aeriesAppParent());
        schoolRealmProxyInterface.realmSet$aeriesAppStaff(schoolRealmProxyInterface2.realmGet$aeriesAppStaff());
        schoolRealmProxyInterface.realmSet$aeriesAppTeacher(schoolRealmProxyInterface2.realmGet$aeriesAppTeacher());
        schoolRealmProxyInterface.realmSet$recordsTransferURL(schoolRealmProxyInterface2.realmGet$recordsTransferURL());
        schoolRealmProxyInterface.realmSet$recordsTransfer(schoolRealmProxyInterface2.realmGet$recordsTransfer());
        schoolRealmProxyInterface.realmSet$fax(schoolRealmProxyInterface2.realmGet$fax());
        schoolRealmProxyInterface.realmSet$publicPhone(schoolRealmProxyInterface2.realmGet$publicPhone());
        schoolRealmProxyInterface.realmSet$publicWebsite(schoolRealmProxyInterface2.realmGet$publicWebsite());
        schoolRealmProxyInterface.realmSet$openDate(schoolRealmProxyInterface2.realmGet$openDate());
        schoolRealmProxyInterface.realmSet$closeDate(schoolRealmProxyInterface2.realmGet$closeDate());
        schoolRealmProxyInterface.realmSet$isCharter(schoolRealmProxyInterface2.realmGet$isCharter());
        schoolRealmProxyInterface.realmSet$latitude(schoolRealmProxyInterface2.realmGet$latitude());
        schoolRealmProxyInterface.realmSet$longitude(schoolRealmProxyInterface2.realmGet$longitude());
        schoolRealmProxyInterface.realmSet$publicAdminFirstName(schoolRealmProxyInterface2.realmGet$publicAdminFirstName());
        schoolRealmProxyInterface.realmSet$publicAdminLastName(schoolRealmProxyInterface2.realmGet$publicAdminLastName());
        schoolRealmProxyInterface.realmSet$publicAdminEmail(schoolRealmProxyInterface2.realmGet$publicAdminEmail());
        schoolRealmProxyInterface.realmSet$highGrade(schoolRealmProxyInterface2.realmGet$highGrade());
        schoolRealmProxyInterface.realmSet$lowGrade(schoolRealmProxyInterface2.realmGet$lowGrade());
        schoolRealmProxyInterface.realmSet$selected(schoolRealmProxyInterface2.realmGet$selected());
        return school;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("School = proxy[");
        stringBuilder.append("{CDS:");
        stringBuilder.append(realmGet$CDS() != null ? realmGet$CDS() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{schoolName:");
        stringBuilder.append(realmGet$schoolName() != null ? realmGet$schoolName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{districtName:");
        stringBuilder.append(realmGet$districtName() != null ? realmGet$districtName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status() != null ? realmGet$status() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{county:");
        stringBuilder.append(realmGet$county() != null ? realmGet$county() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{streetAddress:");
        stringBuilder.append(realmGet$streetAddress() != null ? realmGet$streetAddress() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{city:");
        stringBuilder.append(realmGet$city() != null ? realmGet$city() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{state:");
        stringBuilder.append(realmGet$state() != null ? realmGet$state() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{zipCode:");
        stringBuilder.append(realmGet$zipCode() != null ? realmGet$zipCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mailingAddress:");
        stringBuilder.append(realmGet$mailingAddress() != null ? realmGet$mailingAddress() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mailingCity:");
        stringBuilder.append(realmGet$mailingCity() != null ? realmGet$mailingCity() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mailingState:");
        stringBuilder.append(realmGet$mailingState() != null ? realmGet$mailingState() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mailingZipCode:");
        stringBuilder.append(realmGet$mailingZipCode() != null ? realmGet$mailingZipCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{aeriesAppParentURL:");
        stringBuilder.append(realmGet$aeriesAppParentURL() != null ? realmGet$aeriesAppParentURL() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{aeriesAppStaffURL:");
        stringBuilder.append(realmGet$aeriesAppStaffURL() != null ? realmGet$aeriesAppStaffURL() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{aeriesAppTeacherURL:");
        stringBuilder.append(realmGet$aeriesAppTeacherURL() != null ? realmGet$aeriesAppTeacherURL() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{aeriesAppParent:");
        stringBuilder.append(realmGet$aeriesAppParent() != null ? realmGet$aeriesAppParent() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{aeriesAppStaff:");
        stringBuilder.append(realmGet$aeriesAppStaff() != null ? realmGet$aeriesAppStaff() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{aeriesAppTeacher:");
        stringBuilder.append(realmGet$aeriesAppTeacher() != null ? realmGet$aeriesAppTeacher() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{recordsTransferURL:");
        stringBuilder.append(realmGet$recordsTransferURL() != null ? realmGet$recordsTransferURL() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{recordsTransfer:");
        stringBuilder.append(realmGet$recordsTransfer() != null ? realmGet$recordsTransfer() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fax:");
        stringBuilder.append(realmGet$fax() != null ? realmGet$fax() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{publicPhone:");
        stringBuilder.append(realmGet$publicPhone() != null ? realmGet$publicPhone() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{publicWebsite:");
        stringBuilder.append(realmGet$publicWebsite() != null ? realmGet$publicWebsite() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{openDate:");
        stringBuilder.append(realmGet$openDate() != null ? realmGet$openDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{closeDate:");
        stringBuilder.append(realmGet$closeDate() != null ? realmGet$closeDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isCharter:");
        stringBuilder.append(realmGet$isCharter() != null ? realmGet$isCharter() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{latitude:");
        stringBuilder.append(realmGet$latitude() != null ? realmGet$latitude() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{longitude:");
        stringBuilder.append(realmGet$longitude() != null ? realmGet$longitude() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{publicAdminFirstName:");
        stringBuilder.append(realmGet$publicAdminFirstName() != null ? realmGet$publicAdminFirstName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{publicAdminLastName:");
        stringBuilder.append(realmGet$publicAdminLastName() != null ? realmGet$publicAdminLastName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{publicAdminEmail:");
        stringBuilder.append(realmGet$publicAdminEmail() != null ? realmGet$publicAdminEmail() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{highGrade:");
        stringBuilder.append(realmGet$highGrade() != null ? realmGet$highGrade() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lowGrade:");
        stringBuilder.append(realmGet$lowGrade() != null ? realmGet$lowGrade() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{selected:");
        stringBuilder.append(realmGet$selected());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public int hashCode() {
        String path = this.proxyState.getRealm$realm().getPath();
        String name = this.proxyState.getRow$realm().getTable().getName();
        long index = this.proxyState.getRow$realm().getIndex();
        int i = 0;
        int hashCode = (527 + (path != null ? path.hashCode() : 0)) * 31;
        if (name != null) {
            i = name.hashCode();
        }
        return (31 * (hashCode + i)) + ((int) (index ^ (index >>> 32)));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
        r6 = this;
        r0 = 1;
        if (r6 != r7) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        if (r7 == 0) goto L_0x0076;
    L_0x0007:
        r2 = r6.getClass();
        r3 = r7.getClass();
        if (r2 == r3) goto L_0x0012;
    L_0x0011:
        goto L_0x0076;
    L_0x0012:
        r7 = (io.realm.SchoolRealmProxy) r7;
        r2 = r6.proxyState;
        r2 = r2.getRealm$realm();
        r2 = r2.getPath();
        r3 = r7.proxyState;
        r3 = r3.getRealm$realm();
        r3 = r3.getPath();
        if (r2 == 0) goto L_0x0031;
    L_0x002a:
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0034;
    L_0x0030:
        goto L_0x0033;
    L_0x0031:
        if (r3 == 0) goto L_0x0034;
    L_0x0033:
        return r1;
    L_0x0034:
        r2 = r6.proxyState;
        r2 = r2.getRow$realm();
        r2 = r2.getTable();
        r2 = r2.getName();
        r3 = r7.proxyState;
        r3 = r3.getRow$realm();
        r3 = r3.getTable();
        r3 = r3.getName();
        if (r2 == 0) goto L_0x0059;
    L_0x0052:
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x005c;
    L_0x0058:
        goto L_0x005b;
    L_0x0059:
        if (r3 == 0) goto L_0x005c;
    L_0x005b:
        return r1;
    L_0x005c:
        r2 = r6.proxyState;
        r2 = r2.getRow$realm();
        r2 = r2.getIndex();
        r7 = r7.proxyState;
        r7 = r7.getRow$realm();
        r4 = r7.getIndex();
        r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r7 == 0) goto L_0x0075;
    L_0x0074:
        return r1;
    L_0x0075:
        return r0;
    L_0x0076:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.SchoolRealmProxy.equals(java.lang.Object):boolean");
    }
}
