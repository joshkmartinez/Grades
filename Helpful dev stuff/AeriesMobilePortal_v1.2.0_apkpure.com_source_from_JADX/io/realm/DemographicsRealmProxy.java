package io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.aeries.mobileportal.models.Demographics;
import com.aeries.mobileportal.models.GenericAddress;
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

public class DemographicsRealmProxy extends Demographics implements RealmObjectProxy, DemographicsRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private DemographicsColumnInfo columnInfo;
    private ProxyState<Demographics> proxyState;

    static final class DemographicsColumnInfo extends ColumnInfo {
        long ageIndex;
        long birthDateIndex;
        long contact1PhoneNumberIndex;
        long contact1TitleIndex;
        long contact2PhoneNumberIndex;
        long contact2TitleIndex;
        long correspondenceLanguageCodeIndex;
        long correspondenceLanguageDescriptionIndex;
        long counselorEmailAddressIndex;
        long counselorNameIndex;
        long counselorNumberIndex;
        long displayTextIndex;
        long emailAddressIndex;
        long ethnicityCodeIndex;
        long ethnicityDescriptionIndex;
        long firstNameIndex;
        long genderIndex;
        long gradeIndex;
        long languageFluencyCodeIndex;
        long languageFluencyDescriptionIndex;
        long lastNameIndex;
        long mailingAddressIndex;
        long middleNameIndex;
        long mobilePhoneIndex;
        long parentGuardianEmailAddressIndex;
        long parentGuardianNameIndex;
        long primaryPhoneNumberIndex;
        long raceCodeIndex;
        long raceDescriptionIndex;
        long residenceAddressIndex;
        long schoolCodeIndex;
        long schoolNameIndex;
        long studentIdIndex;

        DemographicsColumnInfo(SharedRealm sharedRealm, Table table) {
            super(33);
            this.schoolCodeIndex = addColumnDetails(table, "schoolCode", RealmFieldType.INTEGER);
            this.schoolNameIndex = addColumnDetails(table, "schoolName", RealmFieldType.STRING);
            this.studentIdIndex = addColumnDetails(table, "studentId", RealmFieldType.INTEGER);
            this.firstNameIndex = addColumnDetails(table, "firstName", RealmFieldType.STRING);
            this.middleNameIndex = addColumnDetails(table, "middleName", RealmFieldType.STRING);
            this.lastNameIndex = addColumnDetails(table, "lastName", RealmFieldType.STRING);
            this.gradeIndex = addColumnDetails(table, "grade", RealmFieldType.STRING);
            this.genderIndex = addColumnDetails(table, "gender", RealmFieldType.STRING);
            this.birthDateIndex = addColumnDetails(table, "birthDate", RealmFieldType.STRING);
            this.ageIndex = addColumnDetails(table, "age", RealmFieldType.INTEGER);
            this.mobilePhoneIndex = addColumnDetails(table, "mobilePhone", RealmFieldType.STRING);
            this.emailAddressIndex = addColumnDetails(table, "emailAddress", RealmFieldType.STRING);
            this.mailingAddressIndex = addColumnDetails(table, "mailingAddress", RealmFieldType.OBJECT);
            this.residenceAddressIndex = addColumnDetails(table, "residenceAddress", RealmFieldType.OBJECT);
            this.correspondenceLanguageCodeIndex = addColumnDetails(table, "correspondenceLanguageCode", RealmFieldType.STRING);
            this.correspondenceLanguageDescriptionIndex = addColumnDetails(table, "correspondenceLanguageDescription", RealmFieldType.STRING);
            this.languageFluencyCodeIndex = addColumnDetails(table, "languageFluencyCode", RealmFieldType.STRING);
            this.languageFluencyDescriptionIndex = addColumnDetails(table, "languageFluencyDescription", RealmFieldType.STRING);
            this.ethnicityCodeIndex = addColumnDetails(table, "ethnicityCode", RealmFieldType.STRING);
            this.ethnicityDescriptionIndex = addColumnDetails(table, "ethnicityDescription", RealmFieldType.STRING);
            this.raceCodeIndex = addColumnDetails(table, "raceCode", RealmFieldType.STRING);
            this.raceDescriptionIndex = addColumnDetails(table, "raceDescription", RealmFieldType.STRING);
            this.primaryPhoneNumberIndex = addColumnDetails(table, "primaryPhoneNumber", RealmFieldType.STRING);
            this.parentGuardianNameIndex = addColumnDetails(table, "parentGuardianName", RealmFieldType.STRING);
            this.contact1PhoneNumberIndex = addColumnDetails(table, "contact1PhoneNumber", RealmFieldType.STRING);
            this.contact1TitleIndex = addColumnDetails(table, "contact1Title", RealmFieldType.STRING);
            this.contact2PhoneNumberIndex = addColumnDetails(table, "contact2PhoneNumber", RealmFieldType.STRING);
            this.contact2TitleIndex = addColumnDetails(table, "contact2Title", RealmFieldType.STRING);
            this.counselorNumberIndex = addColumnDetails(table, "counselorNumber", RealmFieldType.INTEGER);
            this.counselorNameIndex = addColumnDetails(table, "counselorName", RealmFieldType.STRING);
            this.displayTextIndex = addColumnDetails(table, "displayText", RealmFieldType.STRING);
            this.counselorEmailAddressIndex = addColumnDetails(table, "counselorEmailAddress", RealmFieldType.STRING);
            this.parentGuardianEmailAddressIndex = addColumnDetails(table, "parentGuardianEmailAddress", RealmFieldType.STRING);
        }

        DemographicsColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        protected final ColumnInfo copy(boolean z) {
            return new DemographicsColumnInfo((ColumnInfo) this, z);
        }

        protected final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            DemographicsColumnInfo demographicsColumnInfo = (DemographicsColumnInfo) columnInfo;
            DemographicsColumnInfo demographicsColumnInfo2 = (DemographicsColumnInfo) columnInfo2;
            demographicsColumnInfo2.schoolCodeIndex = demographicsColumnInfo.schoolCodeIndex;
            demographicsColumnInfo2.schoolNameIndex = demographicsColumnInfo.schoolNameIndex;
            demographicsColumnInfo2.studentIdIndex = demographicsColumnInfo.studentIdIndex;
            demographicsColumnInfo2.firstNameIndex = demographicsColumnInfo.firstNameIndex;
            demographicsColumnInfo2.middleNameIndex = demographicsColumnInfo.middleNameIndex;
            demographicsColumnInfo2.lastNameIndex = demographicsColumnInfo.lastNameIndex;
            demographicsColumnInfo2.gradeIndex = demographicsColumnInfo.gradeIndex;
            demographicsColumnInfo2.genderIndex = demographicsColumnInfo.genderIndex;
            demographicsColumnInfo2.birthDateIndex = demographicsColumnInfo.birthDateIndex;
            demographicsColumnInfo2.ageIndex = demographicsColumnInfo.ageIndex;
            demographicsColumnInfo2.mobilePhoneIndex = demographicsColumnInfo.mobilePhoneIndex;
            demographicsColumnInfo2.emailAddressIndex = demographicsColumnInfo.emailAddressIndex;
            demographicsColumnInfo2.mailingAddressIndex = demographicsColumnInfo.mailingAddressIndex;
            demographicsColumnInfo2.residenceAddressIndex = demographicsColumnInfo.residenceAddressIndex;
            demographicsColumnInfo2.correspondenceLanguageCodeIndex = demographicsColumnInfo.correspondenceLanguageCodeIndex;
            demographicsColumnInfo2.correspondenceLanguageDescriptionIndex = demographicsColumnInfo.correspondenceLanguageDescriptionIndex;
            demographicsColumnInfo2.languageFluencyCodeIndex = demographicsColumnInfo.languageFluencyCodeIndex;
            demographicsColumnInfo2.languageFluencyDescriptionIndex = demographicsColumnInfo.languageFluencyDescriptionIndex;
            demographicsColumnInfo2.ethnicityCodeIndex = demographicsColumnInfo.ethnicityCodeIndex;
            demographicsColumnInfo2.ethnicityDescriptionIndex = demographicsColumnInfo.ethnicityDescriptionIndex;
            demographicsColumnInfo2.raceCodeIndex = demographicsColumnInfo.raceCodeIndex;
            demographicsColumnInfo2.raceDescriptionIndex = demographicsColumnInfo.raceDescriptionIndex;
            demographicsColumnInfo2.primaryPhoneNumberIndex = demographicsColumnInfo.primaryPhoneNumberIndex;
            demographicsColumnInfo2.parentGuardianNameIndex = demographicsColumnInfo.parentGuardianNameIndex;
            demographicsColumnInfo2.contact1PhoneNumberIndex = demographicsColumnInfo.contact1PhoneNumberIndex;
            demographicsColumnInfo2.contact1TitleIndex = demographicsColumnInfo.contact1TitleIndex;
            demographicsColumnInfo2.contact2PhoneNumberIndex = demographicsColumnInfo.contact2PhoneNumberIndex;
            demographicsColumnInfo2.contact2TitleIndex = demographicsColumnInfo.contact2TitleIndex;
            demographicsColumnInfo2.counselorNumberIndex = demographicsColumnInfo.counselorNumberIndex;
            demographicsColumnInfo2.counselorNameIndex = demographicsColumnInfo.counselorNameIndex;
            demographicsColumnInfo2.displayTextIndex = demographicsColumnInfo.displayTextIndex;
            demographicsColumnInfo2.counselorEmailAddressIndex = demographicsColumnInfo.counselorEmailAddressIndex;
            demographicsColumnInfo2.parentGuardianEmailAddressIndex = demographicsColumnInfo.parentGuardianEmailAddressIndex;
        }
    }

    public static String getTableName() {
        return "class_Demographics";
    }

    static {
        List arrayList = new ArrayList();
        arrayList.add("schoolCode");
        arrayList.add("schoolName");
        arrayList.add("studentId");
        arrayList.add("firstName");
        arrayList.add("middleName");
        arrayList.add("lastName");
        arrayList.add("grade");
        arrayList.add("gender");
        arrayList.add("birthDate");
        arrayList.add("age");
        arrayList.add("mobilePhone");
        arrayList.add("emailAddress");
        arrayList.add("mailingAddress");
        arrayList.add("residenceAddress");
        arrayList.add("correspondenceLanguageCode");
        arrayList.add("correspondenceLanguageDescription");
        arrayList.add("languageFluencyCode");
        arrayList.add("languageFluencyDescription");
        arrayList.add("ethnicityCode");
        arrayList.add("ethnicityDescription");
        arrayList.add("raceCode");
        arrayList.add("raceDescription");
        arrayList.add("primaryPhoneNumber");
        arrayList.add("parentGuardianName");
        arrayList.add("contact1PhoneNumber");
        arrayList.add("contact1Title");
        arrayList.add("contact2PhoneNumber");
        arrayList.add("contact2Title");
        arrayList.add("counselorNumber");
        arrayList.add("counselorName");
        arrayList.add("displayText");
        arrayList.add("counselorEmailAddress");
        arrayList.add("parentGuardianEmailAddress");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    DemographicsRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (DemographicsColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public int realmGet$schoolCode() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.schoolCodeIndex);
    }

    public void realmSet$schoolCode(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.schoolCodeIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.schoolCodeIndex, row$realm.getIndex(), (long) i, true);
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

    public int realmGet$studentId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.studentIdIndex);
    }

    public void realmSet$studentId(int i) {
        if (this.proxyState.isUnderConstruction() == 0) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'studentId' cannot be changed after object was created.");
        }
    }

    public String realmGet$firstName() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.firstNameIndex);
    }

    public void realmSet$firstName(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.firstNameIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.firstNameIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.firstNameIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.firstNameIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$middleName() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.middleNameIndex);
    }

    public void realmSet$middleName(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.middleNameIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.middleNameIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.middleNameIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.middleNameIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$lastName() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.lastNameIndex);
    }

    public void realmSet$lastName(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.lastNameIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.lastNameIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.lastNameIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.lastNameIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$grade() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.gradeIndex);
    }

    public void realmSet$grade(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.gradeIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.gradeIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.gradeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.gradeIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$gender() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.genderIndex);
    }

    public void realmSet$gender(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.genderIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.genderIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.genderIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.genderIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$birthDate() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.birthDateIndex);
    }

    public void realmSet$birthDate(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.birthDateIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.birthDateIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.birthDateIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.birthDateIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public Integer realmGet$age() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.ageIndex)) {
            return null;
        }
        return Integer.valueOf((int) this.proxyState.getRow$realm().getLong(this.columnInfo.ageIndex));
    }

    public void realmSet$age(Integer num) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (num == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.ageIndex);
            } else {
                r0.proxyState.getRow$realm().setLong(r0.columnInfo.ageIndex, (long) num.intValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (num == null) {
                row$realm.getTable().setNull(r0.columnInfo.ageIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setLong(r0.columnInfo.ageIndex, row$realm.getIndex(), (long) num.intValue(), true);
            }
        }
    }

    public String realmGet$mobilePhone() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.mobilePhoneIndex);
    }

    public void realmSet$mobilePhone(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.mobilePhoneIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.mobilePhoneIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.mobilePhoneIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.mobilePhoneIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$emailAddress() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.emailAddressIndex);
    }

    public void realmSet$emailAddress(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.emailAddressIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.emailAddressIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.emailAddressIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.emailAddressIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public GenericAddress realmGet$mailingAddress() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNullLink(this.columnInfo.mailingAddressIndex)) {
            return null;
        }
        return (GenericAddress) this.proxyState.getRealm$realm().get(GenericAddress.class, this.proxyState.getRow$realm().getLink(this.columnInfo.mailingAddressIndex), false, Collections.emptyList());
    }

    public void realmSet$mailingAddress(GenericAddress genericAddress) {
        RealmObjectProxy realmObjectProxy;
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (genericAddress == null) {
                this.proxyState.getRow$realm().nullifyLink(this.columnInfo.mailingAddressIndex);
            } else if (RealmObject.isManaged(genericAddress) && RealmObject.isValid(genericAddress)) {
                realmObjectProxy = (RealmObjectProxy) genericAddress;
                if (realmObjectProxy.realmGet$proxyState().getRealm$realm() == this.proxyState.getRealm$realm()) {
                    this.proxyState.getRow$realm().setLink(this.columnInfo.mailingAddressIndex, realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex());
                    return;
                }
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            } else {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm() && !this.proxyState.getExcludeFields$realm().contains("mailingAddress")) {
            if (!(genericAddress == null || RealmObject.isManaged(genericAddress))) {
                genericAddress = (GenericAddress) ((Realm) this.proxyState.getRealm$realm()).copyToRealm((RealmModel) genericAddress);
            }
            Row row$realm = this.proxyState.getRow$realm();
            if (genericAddress == null) {
                row$realm.nullifyLink(this.columnInfo.mailingAddressIndex);
            } else if (RealmObject.isValid(genericAddress)) {
                realmObjectProxy = (RealmObjectProxy) genericAddress;
                if (realmObjectProxy.realmGet$proxyState().getRealm$realm() == this.proxyState.getRealm$realm()) {
                    row$realm.getTable().setLink(this.columnInfo.mailingAddressIndex, row$realm.getIndex(), realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex(), true);
                    return;
                }
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            } else {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
        }
    }

    public GenericAddress realmGet$residenceAddress() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNullLink(this.columnInfo.residenceAddressIndex)) {
            return null;
        }
        return (GenericAddress) this.proxyState.getRealm$realm().get(GenericAddress.class, this.proxyState.getRow$realm().getLink(this.columnInfo.residenceAddressIndex), false, Collections.emptyList());
    }

    public void realmSet$residenceAddress(GenericAddress genericAddress) {
        RealmObjectProxy realmObjectProxy;
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (genericAddress == null) {
                this.proxyState.getRow$realm().nullifyLink(this.columnInfo.residenceAddressIndex);
            } else if (RealmObject.isManaged(genericAddress) && RealmObject.isValid(genericAddress)) {
                realmObjectProxy = (RealmObjectProxy) genericAddress;
                if (realmObjectProxy.realmGet$proxyState().getRealm$realm() == this.proxyState.getRealm$realm()) {
                    this.proxyState.getRow$realm().setLink(this.columnInfo.residenceAddressIndex, realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex());
                    return;
                }
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            } else {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm() && !this.proxyState.getExcludeFields$realm().contains("residenceAddress")) {
            if (!(genericAddress == null || RealmObject.isManaged(genericAddress))) {
                genericAddress = (GenericAddress) ((Realm) this.proxyState.getRealm$realm()).copyToRealm((RealmModel) genericAddress);
            }
            Row row$realm = this.proxyState.getRow$realm();
            if (genericAddress == null) {
                row$realm.nullifyLink(this.columnInfo.residenceAddressIndex);
            } else if (RealmObject.isValid(genericAddress)) {
                realmObjectProxy = (RealmObjectProxy) genericAddress;
                if (realmObjectProxy.realmGet$proxyState().getRealm$realm() == this.proxyState.getRealm$realm()) {
                    row$realm.getTable().setLink(this.columnInfo.residenceAddressIndex, row$realm.getIndex(), realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex(), true);
                    return;
                }
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            } else {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
        }
    }

    public String realmGet$correspondenceLanguageCode() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.correspondenceLanguageCodeIndex);
    }

    public void realmSet$correspondenceLanguageCode(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.correspondenceLanguageCodeIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.correspondenceLanguageCodeIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.correspondenceLanguageCodeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.correspondenceLanguageCodeIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$correspondenceLanguageDescription() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.correspondenceLanguageDescriptionIndex);
    }

    public void realmSet$correspondenceLanguageDescription(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.correspondenceLanguageDescriptionIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.correspondenceLanguageDescriptionIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.correspondenceLanguageDescriptionIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.correspondenceLanguageDescriptionIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$languageFluencyCode() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.languageFluencyCodeIndex);
    }

    public void realmSet$languageFluencyCode(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.languageFluencyCodeIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.languageFluencyCodeIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.languageFluencyCodeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.languageFluencyCodeIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$languageFluencyDescription() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.languageFluencyDescriptionIndex);
    }

    public void realmSet$languageFluencyDescription(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.languageFluencyDescriptionIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.languageFluencyDescriptionIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.languageFluencyDescriptionIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.languageFluencyDescriptionIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$ethnicityCode() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.ethnicityCodeIndex);
    }

    public void realmSet$ethnicityCode(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.ethnicityCodeIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.ethnicityCodeIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.ethnicityCodeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.ethnicityCodeIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$ethnicityDescription() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.ethnicityDescriptionIndex);
    }

    public void realmSet$ethnicityDescription(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.ethnicityDescriptionIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.ethnicityDescriptionIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.ethnicityDescriptionIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.ethnicityDescriptionIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$raceCode() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.raceCodeIndex);
    }

    public void realmSet$raceCode(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.raceCodeIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.raceCodeIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.raceCodeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.raceCodeIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$raceDescription() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.raceDescriptionIndex);
    }

    public void realmSet$raceDescription(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.raceDescriptionIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.raceDescriptionIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.raceDescriptionIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.raceDescriptionIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$primaryPhoneNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.primaryPhoneNumberIndex);
    }

    public void realmSet$primaryPhoneNumber(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.primaryPhoneNumberIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.primaryPhoneNumberIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.primaryPhoneNumberIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.primaryPhoneNumberIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$parentGuardianName() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.parentGuardianNameIndex);
    }

    public void realmSet$parentGuardianName(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.parentGuardianNameIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.parentGuardianNameIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.parentGuardianNameIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.parentGuardianNameIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$contact1PhoneNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.contact1PhoneNumberIndex);
    }

    public void realmSet$contact1PhoneNumber(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.contact1PhoneNumberIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.contact1PhoneNumberIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.contact1PhoneNumberIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.contact1PhoneNumberIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$contact1Title() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.contact1TitleIndex);
    }

    public void realmSet$contact1Title(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.contact1TitleIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.contact1TitleIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.contact1TitleIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.contact1TitleIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$contact2PhoneNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.contact2PhoneNumberIndex);
    }

    public void realmSet$contact2PhoneNumber(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.contact2PhoneNumberIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.contact2PhoneNumberIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.contact2PhoneNumberIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.contact2PhoneNumberIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$contact2Title() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.contact2TitleIndex);
    }

    public void realmSet$contact2Title(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.contact2TitleIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.contact2TitleIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.contact2TitleIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.contact2TitleIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public Integer realmGet$counselorNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.counselorNumberIndex)) {
            return null;
        }
        return Integer.valueOf((int) this.proxyState.getRow$realm().getLong(this.columnInfo.counselorNumberIndex));
    }

    public void realmSet$counselorNumber(Integer num) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (num == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.counselorNumberIndex);
            } else {
                r0.proxyState.getRow$realm().setLong(r0.columnInfo.counselorNumberIndex, (long) num.intValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (num == null) {
                row$realm.getTable().setNull(r0.columnInfo.counselorNumberIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setLong(r0.columnInfo.counselorNumberIndex, row$realm.getIndex(), (long) num.intValue(), true);
            }
        }
    }

    public String realmGet$counselorName() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.counselorNameIndex);
    }

    public void realmSet$counselorName(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.counselorNameIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.counselorNameIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.counselorNameIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.counselorNameIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$displayText() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.displayTextIndex);
    }

    public void realmSet$displayText(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.displayTextIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.displayTextIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.displayTextIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.displayTextIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$counselorEmailAddress() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.counselorEmailAddressIndex);
    }

    public void realmSet$counselorEmailAddress(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.counselorEmailAddressIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.counselorEmailAddressIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.counselorEmailAddressIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.counselorEmailAddressIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$parentGuardianEmailAddress() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.parentGuardianEmailAddressIndex);
    }

    public void realmSet$parentGuardianEmailAddress(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.parentGuardianEmailAddressIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.parentGuardianEmailAddressIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.parentGuardianEmailAddressIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.parentGuardianEmailAddressIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        Builder builder = new Builder("Demographics");
        Builder builder2 = builder;
        builder2.addProperty("schoolCode", RealmFieldType.INTEGER, false, false, true);
        builder2.addProperty("schoolName", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("studentId", RealmFieldType.INTEGER, true, true, true);
        builder2.addProperty("firstName", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("middleName", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("lastName", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("grade", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("gender", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("birthDate", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("age", RealmFieldType.INTEGER, false, false, false);
        builder2.addProperty("mobilePhone", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("emailAddress", RealmFieldType.STRING, false, false, false);
        builder.addLinkedProperty("mailingAddress", RealmFieldType.OBJECT, "GenericAddress");
        builder.addLinkedProperty("residenceAddress", RealmFieldType.OBJECT, "GenericAddress");
        builder2 = builder;
        builder2.addProperty("correspondenceLanguageCode", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("correspondenceLanguageDescription", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("languageFluencyCode", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("languageFluencyDescription", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("ethnicityCode", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("ethnicityDescription", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("raceCode", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("raceDescription", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("primaryPhoneNumber", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("parentGuardianName", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("contact1PhoneNumber", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("contact1Title", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("contact2PhoneNumber", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("contact2Title", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("counselorNumber", RealmFieldType.INTEGER, false, false, false);
        builder2.addProperty("counselorName", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("displayText", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("counselorEmailAddress", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("parentGuardianEmailAddress", RealmFieldType.STRING, false, false, false);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static DemographicsColumnInfo validateTable(SharedRealm sharedRealm, boolean z) {
        if (sharedRealm.hasTable("class_Demographics")) {
            Table table = sharedRealm.getTable("class_Demographics");
            long columnCount = table.getColumnCount();
            if (columnCount != 33) {
                StringBuilder stringBuilder;
                if (columnCount < 33) {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is less than expected - expected 33 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                } else if (z) {
                    RealmLog.debug("Field count is more than expected - expected 33 but was %1$d", Long.valueOf(columnCount));
                } else {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is more than expected - expected 33 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                }
            }
            z = new HashMap();
            for (long j = 0; j < columnCount; j++) {
                z.put(table.getColumnName(j), table.getColumnType(j));
            }
            DemographicsColumnInfo demographicsColumnInfo = new DemographicsColumnInfo(sharedRealm, table);
            if (!table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'studentId' in existing Realm file. @PrimaryKey was added.");
            } else if (table.getPrimaryKey() != demographicsColumnInfo.studentIdIndex) {
                sharedRealm = sharedRealm.getPath();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Primary Key annotation definition was changed, from field ");
                stringBuilder2.append(table.getColumnName(table.getPrimaryKey()));
                stringBuilder2.append(" to field studentId");
                throw new RealmMigrationNeededException(sharedRealm, stringBuilder2.toString());
            } else if (!z.containsKey("schoolCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'schoolCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("schoolCode") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'schoolCode' in existing Realm file.");
            } else if (table.isColumnNullable(demographicsColumnInfo.schoolCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'schoolCode' does support null values in the existing Realm file. Use corresponding boxed type for field 'schoolCode' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("schoolName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'schoolName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("schoolName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'schoolName' in existing Realm file.");
            } else if (!table.isColumnNullable(demographicsColumnInfo.schoolNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'schoolName' is required. Either set @Required to field 'schoolName' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("studentId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'studentId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("studentId") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'studentId' in existing Realm file.");
            } else if (table.isColumnNullable(demographicsColumnInfo.studentIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'studentId' does support null values in the existing Realm file. Use corresponding boxed type for field 'studentId' or migrate using RealmObjectSchema.setNullable().");
            } else if (!table.hasSearchIndex(table.getColumnIndex("studentId"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'studentId' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            } else if (!z.containsKey("firstName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'firstName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("firstName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'firstName' in existing Realm file.");
            } else if (!table.isColumnNullable(demographicsColumnInfo.firstNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'firstName' is required. Either set @Required to field 'firstName' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("middleName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'middleName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("middleName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'middleName' in existing Realm file.");
            } else if (!table.isColumnNullable(demographicsColumnInfo.middleNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'middleName' is required. Either set @Required to field 'middleName' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("lastName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'lastName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("lastName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'lastName' in existing Realm file.");
            } else if (!table.isColumnNullable(demographicsColumnInfo.lastNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'lastName' is required. Either set @Required to field 'lastName' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("grade")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'grade' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("grade") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'grade' in existing Realm file.");
            } else if (!table.isColumnNullable(demographicsColumnInfo.gradeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'grade' is required. Either set @Required to field 'grade' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("gender")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'gender' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("gender") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'gender' in existing Realm file.");
            } else if (!table.isColumnNullable(demographicsColumnInfo.genderIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'gender' is required. Either set @Required to field 'gender' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("birthDate")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'birthDate' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("birthDate") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'birthDate' in existing Realm file.");
            } else if (!table.isColumnNullable(demographicsColumnInfo.birthDateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'birthDate' is required. Either set @Required to field 'birthDate' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("age")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'age' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("age") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'age' in existing Realm file.");
            } else if (!table.isColumnNullable(demographicsColumnInfo.ageIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'age' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'age' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("mobilePhone")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mobilePhone' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("mobilePhone") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'mobilePhone' in existing Realm file.");
            } else if (!table.isColumnNullable(demographicsColumnInfo.mobilePhoneIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mobilePhone' is required. Either set @Required to field 'mobilePhone' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("emailAddress")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'emailAddress' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("emailAddress") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'emailAddress' in existing Realm file.");
            } else if (!table.isColumnNullable(demographicsColumnInfo.emailAddressIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'emailAddress' is required. Either set @Required to field 'emailAddress' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("mailingAddress")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mailingAddress' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("mailingAddress") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'GenericAddress' for field 'mailingAddress'");
            } else if (sharedRealm.hasTable("class_GenericAddress")) {
                Table table2 = sharedRealm.getTable("class_GenericAddress");
                StringBuilder stringBuilder3;
                if (!table.getLinkTarget(demographicsColumnInfo.mailingAddressIndex).hasSameSchema(table2)) {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Invalid RealmObject for field 'mailingAddress': '");
                    stringBuilder3.append(table.getLinkTarget(demographicsColumnInfo.mailingAddressIndex).getName());
                    stringBuilder3.append("' expected - was '");
                    stringBuilder3.append(table2.getName());
                    stringBuilder3.append("'");
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder3.toString());
                } else if (!z.containsKey("residenceAddress")) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'residenceAddress' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                } else if (z.get("residenceAddress") != RealmFieldType.OBJECT) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'GenericAddress' for field 'residenceAddress'");
                } else if (sharedRealm.hasTable("class_GenericAddress")) {
                    table2 = sharedRealm.getTable("class_GenericAddress");
                    if (!table.getLinkTarget(demographicsColumnInfo.residenceAddressIndex).hasSameSchema(table2)) {
                        sharedRealm = sharedRealm.getPath();
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("Invalid RealmObject for field 'residenceAddress': '");
                        stringBuilder3.append(table.getLinkTarget(demographicsColumnInfo.residenceAddressIndex).getName());
                        stringBuilder3.append("' expected - was '");
                        stringBuilder3.append(table2.getName());
                        stringBuilder3.append("'");
                        throw new RealmMigrationNeededException(sharedRealm, stringBuilder3.toString());
                    } else if (!z.containsKey("correspondenceLanguageCode")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'correspondenceLanguageCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("correspondenceLanguageCode") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'correspondenceLanguageCode' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.correspondenceLanguageCodeIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'correspondenceLanguageCode' is required. Either set @Required to field 'correspondenceLanguageCode' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("correspondenceLanguageDescription")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'correspondenceLanguageDescription' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("correspondenceLanguageDescription") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'correspondenceLanguageDescription' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.correspondenceLanguageDescriptionIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'correspondenceLanguageDescription' is required. Either set @Required to field 'correspondenceLanguageDescription' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("languageFluencyCode")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'languageFluencyCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("languageFluencyCode") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'languageFluencyCode' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.languageFluencyCodeIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'languageFluencyCode' is required. Either set @Required to field 'languageFluencyCode' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("languageFluencyDescription")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'languageFluencyDescription' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("languageFluencyDescription") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'languageFluencyDescription' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.languageFluencyDescriptionIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'languageFluencyDescription' is required. Either set @Required to field 'languageFluencyDescription' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("ethnicityCode")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'ethnicityCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("ethnicityCode") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'ethnicityCode' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.ethnicityCodeIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'ethnicityCode' is required. Either set @Required to field 'ethnicityCode' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("ethnicityDescription")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'ethnicityDescription' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("ethnicityDescription") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'ethnicityDescription' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.ethnicityDescriptionIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'ethnicityDescription' is required. Either set @Required to field 'ethnicityDescription' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("raceCode")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'raceCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("raceCode") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'raceCode' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.raceCodeIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'raceCode' is required. Either set @Required to field 'raceCode' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("raceDescription")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'raceDescription' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("raceDescription") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'raceDescription' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.raceDescriptionIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'raceDescription' is required. Either set @Required to field 'raceDescription' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("primaryPhoneNumber")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'primaryPhoneNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("primaryPhoneNumber") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'primaryPhoneNumber' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.primaryPhoneNumberIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'primaryPhoneNumber' is required. Either set @Required to field 'primaryPhoneNumber' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("parentGuardianName")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'parentGuardianName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("parentGuardianName") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'parentGuardianName' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.parentGuardianNameIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'parentGuardianName' is required. Either set @Required to field 'parentGuardianName' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("contact1PhoneNumber")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'contact1PhoneNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("contact1PhoneNumber") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'contact1PhoneNumber' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.contact1PhoneNumberIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'contact1PhoneNumber' is required. Either set @Required to field 'contact1PhoneNumber' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("contact1Title")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'contact1Title' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("contact1Title") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'contact1Title' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.contact1TitleIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'contact1Title' is required. Either set @Required to field 'contact1Title' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("contact2PhoneNumber")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'contact2PhoneNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("contact2PhoneNumber") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'contact2PhoneNumber' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.contact2PhoneNumberIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'contact2PhoneNumber' is required. Either set @Required to field 'contact2PhoneNumber' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("contact2Title")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'contact2Title' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("contact2Title") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'contact2Title' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.contact2TitleIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'contact2Title' is required. Either set @Required to field 'contact2Title' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("counselorNumber")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'counselorNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("counselorNumber") != RealmFieldType.INTEGER) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'counselorNumber' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.counselorNumberIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'counselorNumber' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'counselorNumber' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("counselorName")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'counselorName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("counselorName") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'counselorName' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.counselorNameIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'counselorName' is required. Either set @Required to field 'counselorName' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("displayText")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'displayText' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("displayText") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'displayText' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.displayTextIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'displayText' is required. Either set @Required to field 'displayText' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("counselorEmailAddress")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'counselorEmailAddress' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("counselorEmailAddress") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'counselorEmailAddress' in existing Realm file.");
                    } else if (!table.isColumnNullable(demographicsColumnInfo.counselorEmailAddressIndex)) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'counselorEmailAddress' is required. Either set @Required to field 'counselorEmailAddress' or migrate using RealmObjectSchema.setNullable().");
                    } else if (!z.containsKey("parentGuardianEmailAddress")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'parentGuardianEmailAddress' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("parentGuardianEmailAddress") != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'parentGuardianEmailAddress' in existing Realm file.");
                    } else if (table.isColumnNullable(demographicsColumnInfo.parentGuardianEmailAddressIndex)) {
                        return demographicsColumnInfo;
                    } else {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'parentGuardianEmailAddress' is required. Either set @Required to field 'parentGuardianEmailAddress' or migrate using RealmObjectSchema.setNullable().");
                    }
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_GenericAddress' for field 'residenceAddress'");
                }
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_GenericAddress' for field 'mailingAddress'");
            }
        }
        throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Demographics' class is missing from the schema for this Realm.");
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Demographics createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        Demographics table;
        List arrayList = new ArrayList(2);
        if (z) {
            table = realm.getTable(Demographics.class);
            long findFirstLong = !jSONObject.isNull("studentId") ? table.findFirstLong(table.getPrimaryKey(), jSONObject.getLong("studentId")) : -1;
            if (findFirstLong != -1) {
                RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
                try {
                    realmObjectContext.set(realm, table.getUncheckedRow(findFirstLong), realm.schema.getColumnInfo(Demographics.class), false, Collections.emptyList());
                    table = new DemographicsRealmProxy();
                    if (table == null) {
                        if (jSONObject.has("mailingAddress")) {
                            arrayList.add("mailingAddress");
                        }
                        if (jSONObject.has("residenceAddress")) {
                            arrayList.add("residenceAddress");
                        }
                        if (jSONObject.has("studentId")) {
                            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'studentId'.");
                        } else if (jSONObject.isNull("studentId")) {
                            table = (DemographicsRealmProxy) realm.createObjectInternal(Demographics.class, Integer.valueOf(jSONObject.getInt("studentId")), true, arrayList);
                        } else {
                            table = (DemographicsRealmProxy) realm.createObjectInternal(Demographics.class, null, true, arrayList);
                        }
                    }
                    if (jSONObject.has("schoolCode")) {
                        if (jSONObject.isNull("schoolCode")) {
                            table.realmSet$schoolCode(jSONObject.getInt("schoolCode"));
                        } else {
                            throw new IllegalArgumentException("Trying to set non-nullable field 'schoolCode' to null.");
                        }
                    }
                    if (jSONObject.has("schoolName")) {
                        if (jSONObject.isNull("schoolName")) {
                            table.realmSet$schoolName(jSONObject.getString("schoolName"));
                        } else {
                            table.realmSet$schoolName(null);
                        }
                    }
                    if (jSONObject.has("firstName")) {
                        if (jSONObject.isNull("firstName")) {
                            table.realmSet$firstName(jSONObject.getString("firstName"));
                        } else {
                            table.realmSet$firstName(null);
                        }
                    }
                    if (jSONObject.has("middleName")) {
                        if (jSONObject.isNull("middleName")) {
                            table.realmSet$middleName(jSONObject.getString("middleName"));
                        } else {
                            table.realmSet$middleName(null);
                        }
                    }
                    if (jSONObject.has("lastName")) {
                        if (jSONObject.isNull("lastName")) {
                            table.realmSet$lastName(jSONObject.getString("lastName"));
                        } else {
                            table.realmSet$lastName(null);
                        }
                    }
                    if (jSONObject.has("grade")) {
                        if (jSONObject.isNull("grade")) {
                            table.realmSet$grade(jSONObject.getString("grade"));
                        } else {
                            table.realmSet$grade(null);
                        }
                    }
                    if (jSONObject.has("gender")) {
                        if (jSONObject.isNull("gender")) {
                            table.realmSet$gender(jSONObject.getString("gender"));
                        } else {
                            table.realmSet$gender(null);
                        }
                    }
                    if (jSONObject.has("birthDate")) {
                        if (jSONObject.isNull("birthDate")) {
                            table.realmSet$birthDate(jSONObject.getString("birthDate"));
                        } else {
                            table.realmSet$birthDate(null);
                        }
                    }
                    if (jSONObject.has("age")) {
                        if (jSONObject.isNull("age")) {
                            table.realmSet$age(Integer.valueOf(jSONObject.getInt("age")));
                        } else {
                            table.realmSet$age(null);
                        }
                    }
                    if (jSONObject.has("mobilePhone")) {
                        if (jSONObject.isNull("mobilePhone")) {
                            table.realmSet$mobilePhone(jSONObject.getString("mobilePhone"));
                        } else {
                            table.realmSet$mobilePhone(null);
                        }
                    }
                    if (jSONObject.has("emailAddress")) {
                        if (jSONObject.isNull("emailAddress")) {
                            table.realmSet$emailAddress(jSONObject.getString("emailAddress"));
                        } else {
                            table.realmSet$emailAddress(null);
                        }
                    }
                    if (jSONObject.has("mailingAddress")) {
                        if (jSONObject.isNull("mailingAddress")) {
                            table.realmSet$mailingAddress(GenericAddressRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject.getJSONObject("mailingAddress"), z));
                        } else {
                            table.realmSet$mailingAddress(null);
                        }
                    }
                    if (jSONObject.has("residenceAddress")) {
                        if (jSONObject.isNull("residenceAddress")) {
                            table.realmSet$residenceAddress(GenericAddressRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject.getJSONObject("residenceAddress"), z));
                        } else {
                            table.realmSet$residenceAddress(null);
                        }
                    }
                    if (jSONObject.has("correspondenceLanguageCode") != null) {
                        if (jSONObject.isNull("correspondenceLanguageCode") == null) {
                            table.realmSet$correspondenceLanguageCode(null);
                        } else {
                            table.realmSet$correspondenceLanguageCode(jSONObject.getString("correspondenceLanguageCode"));
                        }
                    }
                    if (jSONObject.has("correspondenceLanguageDescription") != null) {
                        if (jSONObject.isNull("correspondenceLanguageDescription") == null) {
                            table.realmSet$correspondenceLanguageDescription(null);
                        } else {
                            table.realmSet$correspondenceLanguageDescription(jSONObject.getString("correspondenceLanguageDescription"));
                        }
                    }
                    if (jSONObject.has("languageFluencyCode") != null) {
                        if (jSONObject.isNull("languageFluencyCode") == null) {
                            table.realmSet$languageFluencyCode(null);
                        } else {
                            table.realmSet$languageFluencyCode(jSONObject.getString("languageFluencyCode"));
                        }
                    }
                    if (jSONObject.has("languageFluencyDescription") != null) {
                        if (jSONObject.isNull("languageFluencyDescription") == null) {
                            table.realmSet$languageFluencyDescription(null);
                        } else {
                            table.realmSet$languageFluencyDescription(jSONObject.getString("languageFluencyDescription"));
                        }
                    }
                    if (jSONObject.has("ethnicityCode") != null) {
                        if (jSONObject.isNull("ethnicityCode") == null) {
                            table.realmSet$ethnicityCode(null);
                        } else {
                            table.realmSet$ethnicityCode(jSONObject.getString("ethnicityCode"));
                        }
                    }
                    if (jSONObject.has("ethnicityDescription") != null) {
                        if (jSONObject.isNull("ethnicityDescription") == null) {
                            table.realmSet$ethnicityDescription(null);
                        } else {
                            table.realmSet$ethnicityDescription(jSONObject.getString("ethnicityDescription"));
                        }
                    }
                    if (jSONObject.has("raceCode") != null) {
                        if (jSONObject.isNull("raceCode") == null) {
                            table.realmSet$raceCode(null);
                        } else {
                            table.realmSet$raceCode(jSONObject.getString("raceCode"));
                        }
                    }
                    if (jSONObject.has("raceDescription") != null) {
                        if (jSONObject.isNull("raceDescription") == null) {
                            table.realmSet$raceDescription(null);
                        } else {
                            table.realmSet$raceDescription(jSONObject.getString("raceDescription"));
                        }
                    }
                    if (jSONObject.has("primaryPhoneNumber") != null) {
                        if (jSONObject.isNull("primaryPhoneNumber") == null) {
                            table.realmSet$primaryPhoneNumber(null);
                        } else {
                            table.realmSet$primaryPhoneNumber(jSONObject.getString("primaryPhoneNumber"));
                        }
                    }
                    if (jSONObject.has("parentGuardianName") != null) {
                        if (jSONObject.isNull("parentGuardianName") == null) {
                            table.realmSet$parentGuardianName(null);
                        } else {
                            table.realmSet$parentGuardianName(jSONObject.getString("parentGuardianName"));
                        }
                    }
                    if (jSONObject.has("contact1PhoneNumber") != null) {
                        if (jSONObject.isNull("contact1PhoneNumber") == null) {
                            table.realmSet$contact1PhoneNumber(null);
                        } else {
                            table.realmSet$contact1PhoneNumber(jSONObject.getString("contact1PhoneNumber"));
                        }
                    }
                    if (jSONObject.has("contact1Title") != null) {
                        if (jSONObject.isNull("contact1Title") == null) {
                            table.realmSet$contact1Title(null);
                        } else {
                            table.realmSet$contact1Title(jSONObject.getString("contact1Title"));
                        }
                    }
                    if (jSONObject.has("contact2PhoneNumber") != null) {
                        if (jSONObject.isNull("contact2PhoneNumber") == null) {
                            table.realmSet$contact2PhoneNumber(null);
                        } else {
                            table.realmSet$contact2PhoneNumber(jSONObject.getString("contact2PhoneNumber"));
                        }
                    }
                    if (jSONObject.has("contact2Title") != null) {
                        if (jSONObject.isNull("contact2Title") == null) {
                            table.realmSet$contact2Title(null);
                        } else {
                            table.realmSet$contact2Title(jSONObject.getString("contact2Title"));
                        }
                    }
                    if (jSONObject.has("counselorNumber") != null) {
                        if (jSONObject.isNull("counselorNumber") == null) {
                            table.realmSet$counselorNumber(null);
                        } else {
                            table.realmSet$counselorNumber(Integer.valueOf(jSONObject.getInt("counselorNumber")));
                        }
                    }
                    if (jSONObject.has("counselorName") != null) {
                        if (jSONObject.isNull("counselorName") == null) {
                            table.realmSet$counselorName(null);
                        } else {
                            table.realmSet$counselorName(jSONObject.getString("counselorName"));
                        }
                    }
                    if (jSONObject.has("displayText") != null) {
                        if (jSONObject.isNull("displayText") == null) {
                            table.realmSet$displayText(null);
                        } else {
                            table.realmSet$displayText(jSONObject.getString("displayText"));
                        }
                    }
                    if (jSONObject.has("counselorEmailAddress") != null) {
                        if (jSONObject.isNull("counselorEmailAddress") == null) {
                            table.realmSet$counselorEmailAddress(null);
                        } else {
                            table.realmSet$counselorEmailAddress(jSONObject.getString("counselorEmailAddress"));
                        }
                    }
                    if (jSONObject.has("parentGuardianEmailAddress") != null) {
                        if (jSONObject.isNull("parentGuardianEmailAddress") == null) {
                            table.realmSet$parentGuardianEmailAddress(null);
                        } else {
                            table.realmSet$parentGuardianEmailAddress(jSONObject.getString("parentGuardianEmailAddress"));
                        }
                    }
                    return table;
                } finally {
                    realmObjectContext.clear();
                }
            }
        }
        table = null;
        if (table == null) {
            if (jSONObject.has("mailingAddress")) {
                arrayList.add("mailingAddress");
            }
            if (jSONObject.has("residenceAddress")) {
                arrayList.add("residenceAddress");
            }
            if (jSONObject.has("studentId")) {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'studentId'.");
            } else if (jSONObject.isNull("studentId")) {
                table = (DemographicsRealmProxy) realm.createObjectInternal(Demographics.class, Integer.valueOf(jSONObject.getInt("studentId")), true, arrayList);
            } else {
                table = (DemographicsRealmProxy) realm.createObjectInternal(Demographics.class, null, true, arrayList);
            }
        }
        if (jSONObject.has("schoolCode")) {
            if (jSONObject.isNull("schoolCode")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'schoolCode' to null.");
            }
            table.realmSet$schoolCode(jSONObject.getInt("schoolCode"));
        }
        if (jSONObject.has("schoolName")) {
            if (jSONObject.isNull("schoolName")) {
                table.realmSet$schoolName(jSONObject.getString("schoolName"));
            } else {
                table.realmSet$schoolName(null);
            }
        }
        if (jSONObject.has("firstName")) {
            if (jSONObject.isNull("firstName")) {
                table.realmSet$firstName(jSONObject.getString("firstName"));
            } else {
                table.realmSet$firstName(null);
            }
        }
        if (jSONObject.has("middleName")) {
            if (jSONObject.isNull("middleName")) {
                table.realmSet$middleName(jSONObject.getString("middleName"));
            } else {
                table.realmSet$middleName(null);
            }
        }
        if (jSONObject.has("lastName")) {
            if (jSONObject.isNull("lastName")) {
                table.realmSet$lastName(jSONObject.getString("lastName"));
            } else {
                table.realmSet$lastName(null);
            }
        }
        if (jSONObject.has("grade")) {
            if (jSONObject.isNull("grade")) {
                table.realmSet$grade(jSONObject.getString("grade"));
            } else {
                table.realmSet$grade(null);
            }
        }
        if (jSONObject.has("gender")) {
            if (jSONObject.isNull("gender")) {
                table.realmSet$gender(jSONObject.getString("gender"));
            } else {
                table.realmSet$gender(null);
            }
        }
        if (jSONObject.has("birthDate")) {
            if (jSONObject.isNull("birthDate")) {
                table.realmSet$birthDate(jSONObject.getString("birthDate"));
            } else {
                table.realmSet$birthDate(null);
            }
        }
        if (jSONObject.has("age")) {
            if (jSONObject.isNull("age")) {
                table.realmSet$age(Integer.valueOf(jSONObject.getInt("age")));
            } else {
                table.realmSet$age(null);
            }
        }
        if (jSONObject.has("mobilePhone")) {
            if (jSONObject.isNull("mobilePhone")) {
                table.realmSet$mobilePhone(jSONObject.getString("mobilePhone"));
            } else {
                table.realmSet$mobilePhone(null);
            }
        }
        if (jSONObject.has("emailAddress")) {
            if (jSONObject.isNull("emailAddress")) {
                table.realmSet$emailAddress(jSONObject.getString("emailAddress"));
            } else {
                table.realmSet$emailAddress(null);
            }
        }
        if (jSONObject.has("mailingAddress")) {
            if (jSONObject.isNull("mailingAddress")) {
                table.realmSet$mailingAddress(GenericAddressRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject.getJSONObject("mailingAddress"), z));
            } else {
                table.realmSet$mailingAddress(null);
            }
        }
        if (jSONObject.has("residenceAddress")) {
            if (jSONObject.isNull("residenceAddress")) {
                table.realmSet$residenceAddress(GenericAddressRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject.getJSONObject("residenceAddress"), z));
            } else {
                table.realmSet$residenceAddress(null);
            }
        }
        if (jSONObject.has("correspondenceLanguageCode") != null) {
            if (jSONObject.isNull("correspondenceLanguageCode") == null) {
                table.realmSet$correspondenceLanguageCode(jSONObject.getString("correspondenceLanguageCode"));
            } else {
                table.realmSet$correspondenceLanguageCode(null);
            }
        }
        if (jSONObject.has("correspondenceLanguageDescription") != null) {
            if (jSONObject.isNull("correspondenceLanguageDescription") == null) {
                table.realmSet$correspondenceLanguageDescription(jSONObject.getString("correspondenceLanguageDescription"));
            } else {
                table.realmSet$correspondenceLanguageDescription(null);
            }
        }
        if (jSONObject.has("languageFluencyCode") != null) {
            if (jSONObject.isNull("languageFluencyCode") == null) {
                table.realmSet$languageFluencyCode(jSONObject.getString("languageFluencyCode"));
            } else {
                table.realmSet$languageFluencyCode(null);
            }
        }
        if (jSONObject.has("languageFluencyDescription") != null) {
            if (jSONObject.isNull("languageFluencyDescription") == null) {
                table.realmSet$languageFluencyDescription(jSONObject.getString("languageFluencyDescription"));
            } else {
                table.realmSet$languageFluencyDescription(null);
            }
        }
        if (jSONObject.has("ethnicityCode") != null) {
            if (jSONObject.isNull("ethnicityCode") == null) {
                table.realmSet$ethnicityCode(jSONObject.getString("ethnicityCode"));
            } else {
                table.realmSet$ethnicityCode(null);
            }
        }
        if (jSONObject.has("ethnicityDescription") != null) {
            if (jSONObject.isNull("ethnicityDescription") == null) {
                table.realmSet$ethnicityDescription(jSONObject.getString("ethnicityDescription"));
            } else {
                table.realmSet$ethnicityDescription(null);
            }
        }
        if (jSONObject.has("raceCode") != null) {
            if (jSONObject.isNull("raceCode") == null) {
                table.realmSet$raceCode(jSONObject.getString("raceCode"));
            } else {
                table.realmSet$raceCode(null);
            }
        }
        if (jSONObject.has("raceDescription") != null) {
            if (jSONObject.isNull("raceDescription") == null) {
                table.realmSet$raceDescription(jSONObject.getString("raceDescription"));
            } else {
                table.realmSet$raceDescription(null);
            }
        }
        if (jSONObject.has("primaryPhoneNumber") != null) {
            if (jSONObject.isNull("primaryPhoneNumber") == null) {
                table.realmSet$primaryPhoneNumber(jSONObject.getString("primaryPhoneNumber"));
            } else {
                table.realmSet$primaryPhoneNumber(null);
            }
        }
        if (jSONObject.has("parentGuardianName") != null) {
            if (jSONObject.isNull("parentGuardianName") == null) {
                table.realmSet$parentGuardianName(jSONObject.getString("parentGuardianName"));
            } else {
                table.realmSet$parentGuardianName(null);
            }
        }
        if (jSONObject.has("contact1PhoneNumber") != null) {
            if (jSONObject.isNull("contact1PhoneNumber") == null) {
                table.realmSet$contact1PhoneNumber(jSONObject.getString("contact1PhoneNumber"));
            } else {
                table.realmSet$contact1PhoneNumber(null);
            }
        }
        if (jSONObject.has("contact1Title") != null) {
            if (jSONObject.isNull("contact1Title") == null) {
                table.realmSet$contact1Title(jSONObject.getString("contact1Title"));
            } else {
                table.realmSet$contact1Title(null);
            }
        }
        if (jSONObject.has("contact2PhoneNumber") != null) {
            if (jSONObject.isNull("contact2PhoneNumber") == null) {
                table.realmSet$contact2PhoneNumber(jSONObject.getString("contact2PhoneNumber"));
            } else {
                table.realmSet$contact2PhoneNumber(null);
            }
        }
        if (jSONObject.has("contact2Title") != null) {
            if (jSONObject.isNull("contact2Title") == null) {
                table.realmSet$contact2Title(jSONObject.getString("contact2Title"));
            } else {
                table.realmSet$contact2Title(null);
            }
        }
        if (jSONObject.has("counselorNumber") != null) {
            if (jSONObject.isNull("counselorNumber") == null) {
                table.realmSet$counselorNumber(Integer.valueOf(jSONObject.getInt("counselorNumber")));
            } else {
                table.realmSet$counselorNumber(null);
            }
        }
        if (jSONObject.has("counselorName") != null) {
            if (jSONObject.isNull("counselorName") == null) {
                table.realmSet$counselorName(jSONObject.getString("counselorName"));
            } else {
                table.realmSet$counselorName(null);
            }
        }
        if (jSONObject.has("displayText") != null) {
            if (jSONObject.isNull("displayText") == null) {
                table.realmSet$displayText(jSONObject.getString("displayText"));
            } else {
                table.realmSet$displayText(null);
            }
        }
        if (jSONObject.has("counselorEmailAddress") != null) {
            if (jSONObject.isNull("counselorEmailAddress") == null) {
                table.realmSet$counselorEmailAddress(jSONObject.getString("counselorEmailAddress"));
            } else {
                table.realmSet$counselorEmailAddress(null);
            }
        }
        if (jSONObject.has("parentGuardianEmailAddress") != null) {
            if (jSONObject.isNull("parentGuardianEmailAddress") == null) {
                table.realmSet$parentGuardianEmailAddress(jSONObject.getString("parentGuardianEmailAddress"));
            } else {
                table.realmSet$parentGuardianEmailAddress(null);
            }
        }
        return table;
    }

    @TargetApi(11)
    public static Demographics createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RealmModel demographics = new Demographics();
        jsonReader.beginObject();
        Object obj = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("schoolCode")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$schoolCode(jsonReader.nextInt());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'schoolCode' to null.");
                }
            } else if (nextName.equals("schoolName")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$schoolName(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$schoolName(jsonReader.nextString());
                }
            } else if (nextName.equals("studentId")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$studentId(jsonReader.nextInt());
                    obj = 1;
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'studentId' to null.");
                }
            } else if (nextName.equals("firstName")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$firstName(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$firstName(jsonReader.nextString());
                }
            } else if (nextName.equals("middleName")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$middleName(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$middleName(jsonReader.nextString());
                }
            } else if (nextName.equals("lastName")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$lastName(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$lastName(jsonReader.nextString());
                }
            } else if (nextName.equals("grade")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$grade(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$grade(jsonReader.nextString());
                }
            } else if (nextName.equals("gender")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$gender(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$gender(jsonReader.nextString());
                }
            } else if (nextName.equals("birthDate")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$birthDate(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$birthDate(jsonReader.nextString());
                }
            } else if (nextName.equals("age")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$age(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$age(Integer.valueOf(jsonReader.nextInt()));
                }
            } else if (nextName.equals("mobilePhone")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$mobilePhone(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$mobilePhone(jsonReader.nextString());
                }
            } else if (nextName.equals("emailAddress")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$emailAddress(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$emailAddress(jsonReader.nextString());
                }
            } else if (nextName.equals("mailingAddress")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$mailingAddress(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$mailingAddress(GenericAddressRealmProxy.createUsingJsonStream(realm, jsonReader));
                }
            } else if (nextName.equals("residenceAddress")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$residenceAddress(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$residenceAddress(GenericAddressRealmProxy.createUsingJsonStream(realm, jsonReader));
                }
            } else if (nextName.equals("correspondenceLanguageCode")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$correspondenceLanguageCode(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$correspondenceLanguageCode(jsonReader.nextString());
                }
            } else if (nextName.equals("correspondenceLanguageDescription")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$correspondenceLanguageDescription(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$correspondenceLanguageDescription(jsonReader.nextString());
                }
            } else if (nextName.equals("languageFluencyCode")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$languageFluencyCode(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$languageFluencyCode(jsonReader.nextString());
                }
            } else if (nextName.equals("languageFluencyDescription")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$languageFluencyDescription(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$languageFluencyDescription(jsonReader.nextString());
                }
            } else if (nextName.equals("ethnicityCode")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$ethnicityCode(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$ethnicityCode(jsonReader.nextString());
                }
            } else if (nextName.equals("ethnicityDescription")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$ethnicityDescription(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$ethnicityDescription(jsonReader.nextString());
                }
            } else if (nextName.equals("raceCode")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$raceCode(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$raceCode(jsonReader.nextString());
                }
            } else if (nextName.equals("raceDescription")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$raceDescription(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$raceDescription(jsonReader.nextString());
                }
            } else if (nextName.equals("primaryPhoneNumber")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$primaryPhoneNumber(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$primaryPhoneNumber(jsonReader.nextString());
                }
            } else if (nextName.equals("parentGuardianName")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$parentGuardianName(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$parentGuardianName(jsonReader.nextString());
                }
            } else if (nextName.equals("contact1PhoneNumber")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$contact1PhoneNumber(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$contact1PhoneNumber(jsonReader.nextString());
                }
            } else if (nextName.equals("contact1Title")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$contact1Title(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$contact1Title(jsonReader.nextString());
                }
            } else if (nextName.equals("contact2PhoneNumber")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$contact2PhoneNumber(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$contact2PhoneNumber(jsonReader.nextString());
                }
            } else if (nextName.equals("contact2Title")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$contact2Title(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$contact2Title(jsonReader.nextString());
                }
            } else if (nextName.equals("counselorNumber")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$counselorNumber(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$counselorNumber(Integer.valueOf(jsonReader.nextInt()));
                }
            } else if (nextName.equals("counselorName")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$counselorName(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$counselorName(jsonReader.nextString());
                }
            } else if (nextName.equals("displayText")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$displayText(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$displayText(jsonReader.nextString());
                }
            } else if (nextName.equals("counselorEmailAddress")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((DemographicsRealmProxyInterface) demographics).realmSet$counselorEmailAddress(null);
                } else {
                    ((DemographicsRealmProxyInterface) demographics).realmSet$counselorEmailAddress(jsonReader.nextString());
                }
            } else if (!nextName.equals("parentGuardianEmailAddress")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.skipValue();
                ((DemographicsRealmProxyInterface) demographics).realmSet$parentGuardianEmailAddress(null);
            } else {
                ((DemographicsRealmProxyInterface) demographics).realmSet$parentGuardianEmailAddress(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        if (obj != null) {
            return (Demographics) realm.copyToRealm(demographics);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'studentId'.");
    }

    public static Demographics copyOrUpdate(Realm realm, Demographics demographics, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy;
        boolean z2 = demographics instanceof RealmObjectProxy;
        if (z2) {
            realmObjectProxy = (RealmObjectProxy) demographics;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null) {
                if (realmObjectProxy.realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                }
            }
        }
        if (z2) {
            RealmObjectProxy realmObjectProxy2 = (RealmObjectProxy) demographics;
            if (realmObjectProxy2.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy2.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return demographics;
            }
        }
        RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectProxy = (RealmObjectProxy) map.get(demographics);
        if (realmObjectProxy != null) {
            return (Demographics) realmObjectProxy;
        }
        Demographics demographics2 = null;
        if (z) {
            Table table = realm.getTable(Demographics.class);
            long findFirstLong = table.findFirstLong(table.getPrimaryKey(), (long) demographics.realmGet$studentId());
            if (findFirstLong != -1) {
                try {
                    realmObjectContext.set(realm, table.getUncheckedRow(findFirstLong), realm.schema.getColumnInfo(Demographics.class), false, Collections.emptyList());
                    demographics2 = new DemographicsRealmProxy();
                    map.put(demographics, (RealmObjectProxy) demographics2);
                } finally {
                    realmObjectContext.clear();
                }
            } else {
                z2 = false;
                if (z2) {
                    return copy(realm, demographics, z, map);
                }
                return update(realm, demographics2, demographics, map);
            }
        }
        z2 = z;
        if (z2) {
            return copy(realm, demographics, z, map);
        }
        return update(realm, demographics2, demographics, map);
    }

    public static Demographics copy(Realm realm, Demographics demographics, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = (RealmObjectProxy) map.get(demographics);
        if (realmObjectProxy != null) {
            return (Demographics) realmObjectProxy;
        }
        DemographicsRealmProxyInterface demographicsRealmProxyInterface = demographics;
        Demographics demographics2 = (Demographics) realm.createObjectInternal(Demographics.class, Integer.valueOf(demographicsRealmProxyInterface.realmGet$studentId()), false, Collections.emptyList());
        map.put(demographics, (RealmObjectProxy) demographics2);
        DemographicsRealmProxyInterface demographicsRealmProxyInterface2 = demographics2;
        demographicsRealmProxyInterface2.realmSet$schoolCode(demographicsRealmProxyInterface.realmGet$schoolCode());
        demographicsRealmProxyInterface2.realmSet$schoolName(demographicsRealmProxyInterface.realmGet$schoolName());
        demographicsRealmProxyInterface2.realmSet$firstName(demographicsRealmProxyInterface.realmGet$firstName());
        demographicsRealmProxyInterface2.realmSet$middleName(demographicsRealmProxyInterface.realmGet$middleName());
        demographicsRealmProxyInterface2.realmSet$lastName(demographicsRealmProxyInterface.realmGet$lastName());
        demographicsRealmProxyInterface2.realmSet$grade(demographicsRealmProxyInterface.realmGet$grade());
        demographicsRealmProxyInterface2.realmSet$gender(demographicsRealmProxyInterface.realmGet$gender());
        demographicsRealmProxyInterface2.realmSet$birthDate(demographicsRealmProxyInterface.realmGet$birthDate());
        demographicsRealmProxyInterface2.realmSet$age(demographicsRealmProxyInterface.realmGet$age());
        demographicsRealmProxyInterface2.realmSet$mobilePhone(demographicsRealmProxyInterface.realmGet$mobilePhone());
        demographicsRealmProxyInterface2.realmSet$emailAddress(demographicsRealmProxyInterface.realmGet$emailAddress());
        GenericAddress realmGet$mailingAddress = demographicsRealmProxyInterface.realmGet$mailingAddress();
        if (realmGet$mailingAddress == null) {
            demographicsRealmProxyInterface2.realmSet$mailingAddress(null);
        } else {
            GenericAddress genericAddress = (GenericAddress) map.get(realmGet$mailingAddress);
            if (genericAddress != null) {
                demographicsRealmProxyInterface2.realmSet$mailingAddress(genericAddress);
            } else {
                demographicsRealmProxyInterface2.realmSet$mailingAddress(GenericAddressRealmProxy.copyOrUpdate(realm, realmGet$mailingAddress, z, map));
            }
        }
        realmGet$mailingAddress = demographicsRealmProxyInterface.realmGet$residenceAddress();
        if (realmGet$mailingAddress == null) {
            demographicsRealmProxyInterface2.realmSet$residenceAddress(null);
        } else {
            GenericAddress genericAddress2 = (GenericAddress) map.get(realmGet$mailingAddress);
            if (genericAddress2 != null) {
                demographicsRealmProxyInterface2.realmSet$residenceAddress(genericAddress2);
            } else {
                demographicsRealmProxyInterface2.realmSet$residenceAddress(GenericAddressRealmProxy.copyOrUpdate(realm, realmGet$mailingAddress, z, map));
            }
        }
        demographicsRealmProxyInterface2.realmSet$correspondenceLanguageCode(demographicsRealmProxyInterface.realmGet$correspondenceLanguageCode());
        demographicsRealmProxyInterface2.realmSet$correspondenceLanguageDescription(demographicsRealmProxyInterface.realmGet$correspondenceLanguageDescription());
        demographicsRealmProxyInterface2.realmSet$languageFluencyCode(demographicsRealmProxyInterface.realmGet$languageFluencyCode());
        demographicsRealmProxyInterface2.realmSet$languageFluencyDescription(demographicsRealmProxyInterface.realmGet$languageFluencyDescription());
        demographicsRealmProxyInterface2.realmSet$ethnicityCode(demographicsRealmProxyInterface.realmGet$ethnicityCode());
        demographicsRealmProxyInterface2.realmSet$ethnicityDescription(demographicsRealmProxyInterface.realmGet$ethnicityDescription());
        demographicsRealmProxyInterface2.realmSet$raceCode(demographicsRealmProxyInterface.realmGet$raceCode());
        demographicsRealmProxyInterface2.realmSet$raceDescription(demographicsRealmProxyInterface.realmGet$raceDescription());
        demographicsRealmProxyInterface2.realmSet$primaryPhoneNumber(demographicsRealmProxyInterface.realmGet$primaryPhoneNumber());
        demographicsRealmProxyInterface2.realmSet$parentGuardianName(demographicsRealmProxyInterface.realmGet$parentGuardianName());
        demographicsRealmProxyInterface2.realmSet$contact1PhoneNumber(demographicsRealmProxyInterface.realmGet$contact1PhoneNumber());
        demographicsRealmProxyInterface2.realmSet$contact1Title(demographicsRealmProxyInterface.realmGet$contact1Title());
        demographicsRealmProxyInterface2.realmSet$contact2PhoneNumber(demographicsRealmProxyInterface.realmGet$contact2PhoneNumber());
        demographicsRealmProxyInterface2.realmSet$contact2Title(demographicsRealmProxyInterface.realmGet$contact2Title());
        demographicsRealmProxyInterface2.realmSet$counselorNumber(demographicsRealmProxyInterface.realmGet$counselorNumber());
        demographicsRealmProxyInterface2.realmSet$counselorName(demographicsRealmProxyInterface.realmGet$counselorName());
        demographicsRealmProxyInterface2.realmSet$displayText(demographicsRealmProxyInterface.realmGet$displayText());
        demographicsRealmProxyInterface2.realmSet$counselorEmailAddress(demographicsRealmProxyInterface.realmGet$counselorEmailAddress());
        demographicsRealmProxyInterface2.realmSet$parentGuardianEmailAddress(demographicsRealmProxyInterface.realmGet$parentGuardianEmailAddress());
        return demographics2;
    }

    public static long insert(Realm realm, Demographics demographics, Map<RealmModel, Long> map) {
        long nativeFindFirstInt;
        long createRowWithPrimaryKey;
        Long l;
        Realm realm2 = realm;
        Demographics demographics2 = demographics;
        Map map2 = map;
        if (demographics2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) demographics2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(Demographics.class);
        long nativePtr = table.getNativePtr();
        DemographicsColumnInfo demographicsColumnInfo = (DemographicsColumnInfo) realm2.schema.getColumnInfo(Demographics.class);
        long primaryKey = table.getPrimaryKey();
        DemographicsRealmProxyInterface demographicsRealmProxyInterface = demographics2;
        Integer valueOf = Integer.valueOf(demographicsRealmProxyInterface.realmGet$studentId());
        if (valueOf != null) {
            nativeFindFirstInt = Table.nativeFindFirstInt(nativePtr, primaryKey, (long) demographicsRealmProxyInterface.realmGet$studentId());
        } else {
            nativeFindFirstInt = -1;
        }
        if (nativeFindFirstInt == -1) {
            createRowWithPrimaryKey = OsObject.createRowWithPrimaryKey(table, Integer.valueOf(demographicsRealmProxyInterface.realmGet$studentId()));
        } else {
            Table.throwDuplicatePrimaryKeyException(valueOf);
            createRowWithPrimaryKey = nativeFindFirstInt;
        }
        map2.put(demographics2, Long.valueOf(createRowWithPrimaryKey));
        long j = createRowWithPrimaryKey;
        DemographicsRealmProxyInterface demographicsRealmProxyInterface2 = demographicsRealmProxyInterface;
        Table.nativeSetLong(nativePtr, demographicsColumnInfo.schoolCodeIndex, createRowWithPrimaryKey, (long) demographicsRealmProxyInterface.realmGet$schoolCode(), false);
        String realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$schoolName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.schoolNameIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$firstName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.firstNameIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$middleName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.middleNameIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$lastName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.lastNameIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$grade();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.gradeIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$gender();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.genderIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$birthDate();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.birthDateIndex, j, realmGet$schoolName, false);
        }
        Number realmGet$age = demographicsRealmProxyInterface2.realmGet$age();
        if (realmGet$age != null) {
            Table.nativeSetLong(nativePtr, demographicsColumnInfo.ageIndex, j, realmGet$age.longValue(), false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$mobilePhone();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.mobilePhoneIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$emailAddress();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.emailAddressIndex, j, realmGet$schoolName, false);
        }
        GenericAddress realmGet$mailingAddress = demographicsRealmProxyInterface2.realmGet$mailingAddress();
        if (realmGet$mailingAddress != null) {
            l = (Long) map2.get(realmGet$mailingAddress);
            if (l == null) {
                l = Long.valueOf(GenericAddressRealmProxy.insert(realm2, realmGet$mailingAddress, map2));
            }
            Table.nativeSetLink(nativePtr, demographicsColumnInfo.mailingAddressIndex, j, l.longValue(), false);
        }
        realmGet$mailingAddress = demographicsRealmProxyInterface2.realmGet$residenceAddress();
        if (realmGet$mailingAddress != null) {
            l = (Long) map2.get(realmGet$mailingAddress);
            if (l == null) {
                l = Long.valueOf(GenericAddressRealmProxy.insert(realm2, realmGet$mailingAddress, map2));
            }
            Table.nativeSetLink(nativePtr, demographicsColumnInfo.residenceAddressIndex, j, l.longValue(), false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$correspondenceLanguageCode();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.correspondenceLanguageCodeIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$correspondenceLanguageDescription();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.correspondenceLanguageDescriptionIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$languageFluencyCode();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.languageFluencyCodeIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$languageFluencyDescription();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.languageFluencyDescriptionIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$ethnicityCode();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.ethnicityCodeIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$ethnicityDescription();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.ethnicityDescriptionIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$raceCode();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.raceCodeIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$raceDescription();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.raceDescriptionIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$primaryPhoneNumber();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.primaryPhoneNumberIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$parentGuardianName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.parentGuardianNameIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$contact1PhoneNumber();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.contact1PhoneNumberIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$contact1Title();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.contact1TitleIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$contact2PhoneNumber();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.contact2PhoneNumberIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$contact2Title();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.contact2TitleIndex, j, realmGet$schoolName, false);
        }
        Number realmGet$counselorNumber = demographicsRealmProxyInterface2.realmGet$counselorNumber();
        if (realmGet$counselorNumber != null) {
            Table.nativeSetLong(nativePtr, demographicsColumnInfo.counselorNumberIndex, j, realmGet$counselorNumber.longValue(), false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$counselorName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.counselorNameIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$displayText();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.displayTextIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$counselorEmailAddress();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.counselorEmailAddressIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$parentGuardianEmailAddress();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.parentGuardianEmailAddressIndex, j, realmGet$schoolName, false);
        }
        return j;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map map2 = map;
        Table table = realm2.getTable(Demographics.class);
        long nativePtr = table.getNativePtr();
        DemographicsColumnInfo demographicsColumnInfo = (DemographicsColumnInfo) realm2.schema.getColumnInfo(Demographics.class);
        long primaryKey = table.getPrimaryKey();
        while (it.hasNext()) {
            Demographics demographics = (Demographics) it.next();
            if (!map2.containsKey(demographics)) {
                long nativeFindFirstInt;
                Long l;
                if (demographics instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) demographics;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(demographics, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                DemographicsRealmProxyInterface demographicsRealmProxyInterface = demographics;
                Integer valueOf = Integer.valueOf(demographicsRealmProxyInterface.realmGet$studentId());
                if (valueOf != null) {
                    nativeFindFirstInt = Table.nativeFindFirstInt(nativePtr, primaryKey, (long) demographicsRealmProxyInterface.realmGet$studentId());
                } else {
                    nativeFindFirstInt = -1;
                }
                if (nativeFindFirstInt == -1) {
                    nativeFindFirstInt = OsObject.createRowWithPrimaryKey(table, Integer.valueOf(demographicsRealmProxyInterface.realmGet$studentId()));
                } else {
                    Table.throwDuplicatePrimaryKeyException(valueOf);
                }
                long j = nativeFindFirstInt;
                map2.put(demographics, Long.valueOf(j));
                long j2 = j;
                long j3 = primaryKey;
                DemographicsRealmProxyInterface demographicsRealmProxyInterface2 = demographicsRealmProxyInterface;
                Table.nativeSetLong(nativePtr, demographicsColumnInfo.schoolCodeIndex, j, (long) demographicsRealmProxyInterface.realmGet$schoolCode(), false);
                String realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$schoolName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.schoolNameIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$firstName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.firstNameIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$middleName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.middleNameIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$lastName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.lastNameIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$grade();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.gradeIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$gender();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.genderIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$birthDate();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.birthDateIndex, j2, realmGet$schoolName, false);
                }
                Number realmGet$age = demographicsRealmProxyInterface2.realmGet$age();
                if (realmGet$age != null) {
                    Table.nativeSetLong(nativePtr, demographicsColumnInfo.ageIndex, j2, realmGet$age.longValue(), false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$mobilePhone();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.mobilePhoneIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$emailAddress();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.emailAddressIndex, j2, realmGet$schoolName, false);
                }
                GenericAddress realmGet$mailingAddress = demographicsRealmProxyInterface2.realmGet$mailingAddress();
                if (realmGet$mailingAddress != null) {
                    l = (Long) map2.get(realmGet$mailingAddress);
                    if (l == null) {
                        l = Long.valueOf(GenericAddressRealmProxy.insert(realm2, realmGet$mailingAddress, map2));
                    }
                    table.setLink(demographicsColumnInfo.mailingAddressIndex, j2, l.longValue(), false);
                }
                realmGet$mailingAddress = demographicsRealmProxyInterface2.realmGet$residenceAddress();
                if (realmGet$mailingAddress != null) {
                    l = (Long) map2.get(realmGet$mailingAddress);
                    if (l == null) {
                        l = Long.valueOf(GenericAddressRealmProxy.insert(realm2, realmGet$mailingAddress, map2));
                    }
                    table.setLink(demographicsColumnInfo.residenceAddressIndex, j2, l.longValue(), false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$correspondenceLanguageCode();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.correspondenceLanguageCodeIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$correspondenceLanguageDescription();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.correspondenceLanguageDescriptionIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$languageFluencyCode();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.languageFluencyCodeIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$languageFluencyDescription();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.languageFluencyDescriptionIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$ethnicityCode();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.ethnicityCodeIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$ethnicityDescription();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.ethnicityDescriptionIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$raceCode();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.raceCodeIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$raceDescription();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.raceDescriptionIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$primaryPhoneNumber();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.primaryPhoneNumberIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$parentGuardianName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.parentGuardianNameIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$contact1PhoneNumber();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.contact1PhoneNumberIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$contact1Title();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.contact1TitleIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$contact2PhoneNumber();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.contact2PhoneNumberIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$contact2Title();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.contact2TitleIndex, j2, realmGet$schoolName, false);
                }
                realmGet$age = demographicsRealmProxyInterface2.realmGet$counselorNumber();
                if (realmGet$age != null) {
                    Table.nativeSetLong(nativePtr, demographicsColumnInfo.counselorNumberIndex, j2, realmGet$age.longValue(), false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$counselorName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.counselorNameIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$displayText();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.displayTextIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$counselorEmailAddress();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.counselorEmailAddressIndex, j2, realmGet$schoolName, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$parentGuardianEmailAddress();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.parentGuardianEmailAddressIndex, j2, realmGet$schoolName, false);
                }
                primaryKey = j3;
            }
        }
    }

    public static long insertOrUpdate(Realm realm, Demographics demographics, Map<RealmModel, Long> map) {
        Long l;
        Realm realm2 = realm;
        Demographics demographics2 = demographics;
        Map map2 = map;
        if (demographics2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) demographics2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(Demographics.class);
        long nativePtr = table.getNativePtr();
        DemographicsColumnInfo demographicsColumnInfo = (DemographicsColumnInfo) realm2.schema.getColumnInfo(Demographics.class);
        DemographicsRealmProxyInterface demographicsRealmProxyInterface = demographics2;
        long nativeFindFirstInt = Integer.valueOf(demographicsRealmProxyInterface.realmGet$studentId()) != null ? Table.nativeFindFirstInt(nativePtr, table.getPrimaryKey(), (long) demographicsRealmProxyInterface.realmGet$studentId()) : -1;
        long createRowWithPrimaryKey = nativeFindFirstInt == -1 ? OsObject.createRowWithPrimaryKey(table, Integer.valueOf(demographicsRealmProxyInterface.realmGet$studentId())) : nativeFindFirstInt;
        map2.put(demographics2, Long.valueOf(createRowWithPrimaryKey));
        long j = createRowWithPrimaryKey;
        DemographicsRealmProxyInterface demographicsRealmProxyInterface2 = demographicsRealmProxyInterface;
        Table.nativeSetLong(nativePtr, demographicsColumnInfo.schoolCodeIndex, createRowWithPrimaryKey, (long) demographicsRealmProxyInterface.realmGet$schoolCode(), false);
        String realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$schoolName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.schoolNameIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.schoolNameIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$firstName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.firstNameIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.firstNameIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$middleName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.middleNameIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.middleNameIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$lastName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.lastNameIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.lastNameIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$grade();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.gradeIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.gradeIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$gender();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.genderIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.genderIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$birthDate();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.birthDateIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.birthDateIndex, j, false);
        }
        Number realmGet$age = demographicsRealmProxyInterface2.realmGet$age();
        if (realmGet$age != null) {
            Table.nativeSetLong(nativePtr, demographicsColumnInfo.ageIndex, j, realmGet$age.longValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.ageIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$mobilePhone();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.mobilePhoneIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.mobilePhoneIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$emailAddress();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.emailAddressIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.emailAddressIndex, j, false);
        }
        GenericAddress realmGet$mailingAddress = demographicsRealmProxyInterface2.realmGet$mailingAddress();
        if (realmGet$mailingAddress != null) {
            l = (Long) map2.get(realmGet$mailingAddress);
            if (l == null) {
                l = Long.valueOf(GenericAddressRealmProxy.insertOrUpdate(realm2, realmGet$mailingAddress, map2));
            }
            Table.nativeSetLink(nativePtr, demographicsColumnInfo.mailingAddressIndex, j, l.longValue(), false);
        } else {
            Table.nativeNullifyLink(nativePtr, demographicsColumnInfo.mailingAddressIndex, j);
        }
        realmGet$mailingAddress = demographicsRealmProxyInterface2.realmGet$residenceAddress();
        if (realmGet$mailingAddress != null) {
            l = (Long) map2.get(realmGet$mailingAddress);
            if (l == null) {
                l = Long.valueOf(GenericAddressRealmProxy.insertOrUpdate(realm2, realmGet$mailingAddress, map2));
            }
            Table.nativeSetLink(nativePtr, demographicsColumnInfo.residenceAddressIndex, j, l.longValue(), false);
        } else {
            Table.nativeNullifyLink(nativePtr, demographicsColumnInfo.residenceAddressIndex, j);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$correspondenceLanguageCode();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.correspondenceLanguageCodeIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.correspondenceLanguageCodeIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$correspondenceLanguageDescription();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.correspondenceLanguageDescriptionIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.correspondenceLanguageDescriptionIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$languageFluencyCode();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.languageFluencyCodeIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.languageFluencyCodeIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$languageFluencyDescription();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.languageFluencyDescriptionIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.languageFluencyDescriptionIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$ethnicityCode();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.ethnicityCodeIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.ethnicityCodeIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$ethnicityDescription();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.ethnicityDescriptionIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.ethnicityDescriptionIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$raceCode();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.raceCodeIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.raceCodeIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$raceDescription();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.raceDescriptionIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.raceDescriptionIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$primaryPhoneNumber();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.primaryPhoneNumberIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.primaryPhoneNumberIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$parentGuardianName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.parentGuardianNameIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.parentGuardianNameIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$contact1PhoneNumber();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.contact1PhoneNumberIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.contact1PhoneNumberIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$contact1Title();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.contact1TitleIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.contact1TitleIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$contact2PhoneNumber();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.contact2PhoneNumberIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.contact2PhoneNumberIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$contact2Title();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.contact2TitleIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.contact2TitleIndex, j, false);
        }
        Number realmGet$counselorNumber = demographicsRealmProxyInterface2.realmGet$counselorNumber();
        if (realmGet$counselorNumber != null) {
            Table.nativeSetLong(nativePtr, demographicsColumnInfo.counselorNumberIndex, j, realmGet$counselorNumber.longValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.counselorNumberIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$counselorName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.counselorNameIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.counselorNameIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$displayText();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.displayTextIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.displayTextIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$counselorEmailAddress();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.counselorEmailAddressIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.counselorEmailAddressIndex, j, false);
        }
        realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$parentGuardianEmailAddress();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, demographicsColumnInfo.parentGuardianEmailAddressIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, demographicsColumnInfo.parentGuardianEmailAddressIndex, j, false);
        }
        return j;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map map2 = map;
        Table table = realm2.getTable(Demographics.class);
        long nativePtr = table.getNativePtr();
        DemographicsColumnInfo demographicsColumnInfo = (DemographicsColumnInfo) realm2.schema.getColumnInfo(Demographics.class);
        long primaryKey = table.getPrimaryKey();
        while (it.hasNext()) {
            Demographics demographics = (Demographics) it.next();
            if (!map2.containsKey(demographics)) {
                long nativeFindFirstInt;
                Long l;
                if (demographics instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) demographics;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(demographics, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                DemographicsRealmProxyInterface demographicsRealmProxyInterface = demographics;
                if (Integer.valueOf(demographicsRealmProxyInterface.realmGet$studentId()) != null) {
                    nativeFindFirstInt = Table.nativeFindFirstInt(nativePtr, primaryKey, (long) demographicsRealmProxyInterface.realmGet$studentId());
                } else {
                    nativeFindFirstInt = -1;
                }
                if (nativeFindFirstInt == -1) {
                    nativeFindFirstInt = OsObject.createRowWithPrimaryKey(table, Integer.valueOf(demographicsRealmProxyInterface.realmGet$studentId()));
                }
                long j = nativeFindFirstInt;
                map2.put(demographics, Long.valueOf(j));
                long j2 = j;
                Table table2 = table;
                DemographicsRealmProxyInterface demographicsRealmProxyInterface2 = demographicsRealmProxyInterface;
                Table.nativeSetLong(nativePtr, demographicsColumnInfo.schoolCodeIndex, j, (long) demographicsRealmProxyInterface.realmGet$schoolCode(), false);
                String realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$schoolName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.schoolNameIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.schoolNameIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$firstName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.firstNameIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.firstNameIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$middleName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.middleNameIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.middleNameIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$lastName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.lastNameIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.lastNameIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$grade();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.gradeIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.gradeIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$gender();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.genderIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.genderIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$birthDate();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.birthDateIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.birthDateIndex, j2, false);
                }
                Number realmGet$age = demographicsRealmProxyInterface2.realmGet$age();
                if (realmGet$age != null) {
                    Table.nativeSetLong(nativePtr, demographicsColumnInfo.ageIndex, j2, realmGet$age.longValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.ageIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$mobilePhone();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.mobilePhoneIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.mobilePhoneIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$emailAddress();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.emailAddressIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.emailAddressIndex, j2, false);
                }
                GenericAddress realmGet$mailingAddress = demographicsRealmProxyInterface2.realmGet$mailingAddress();
                if (realmGet$mailingAddress != null) {
                    l = (Long) map2.get(realmGet$mailingAddress);
                    if (l == null) {
                        l = Long.valueOf(GenericAddressRealmProxy.insertOrUpdate(realm2, realmGet$mailingAddress, map2));
                    }
                    Table.nativeSetLink(nativePtr, demographicsColumnInfo.mailingAddressIndex, j2, l.longValue(), false);
                } else {
                    Table.nativeNullifyLink(nativePtr, demographicsColumnInfo.mailingAddressIndex, j2);
                }
                realmGet$mailingAddress = demographicsRealmProxyInterface2.realmGet$residenceAddress();
                if (realmGet$mailingAddress != null) {
                    l = (Long) map2.get(realmGet$mailingAddress);
                    if (l == null) {
                        l = Long.valueOf(GenericAddressRealmProxy.insertOrUpdate(realm2, realmGet$mailingAddress, map2));
                    }
                    Table.nativeSetLink(nativePtr, demographicsColumnInfo.residenceAddressIndex, j2, l.longValue(), false);
                } else {
                    Table.nativeNullifyLink(nativePtr, demographicsColumnInfo.residenceAddressIndex, j2);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$correspondenceLanguageCode();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.correspondenceLanguageCodeIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.correspondenceLanguageCodeIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$correspondenceLanguageDescription();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.correspondenceLanguageDescriptionIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.correspondenceLanguageDescriptionIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$languageFluencyCode();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.languageFluencyCodeIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.languageFluencyCodeIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$languageFluencyDescription();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.languageFluencyDescriptionIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.languageFluencyDescriptionIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$ethnicityCode();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.ethnicityCodeIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.ethnicityCodeIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$ethnicityDescription();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.ethnicityDescriptionIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.ethnicityDescriptionIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$raceCode();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.raceCodeIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.raceCodeIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$raceDescription();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.raceDescriptionIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.raceDescriptionIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$primaryPhoneNumber();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.primaryPhoneNumberIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.primaryPhoneNumberIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$parentGuardianName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.parentGuardianNameIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.parentGuardianNameIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$contact1PhoneNumber();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.contact1PhoneNumberIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.contact1PhoneNumberIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$contact1Title();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.contact1TitleIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.contact1TitleIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$contact2PhoneNumber();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.contact2PhoneNumberIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.contact2PhoneNumberIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$contact2Title();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.contact2TitleIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.contact2TitleIndex, j2, false);
                }
                realmGet$age = demographicsRealmProxyInterface2.realmGet$counselorNumber();
                if (realmGet$age != null) {
                    Table.nativeSetLong(nativePtr, demographicsColumnInfo.counselorNumberIndex, j2, realmGet$age.longValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.counselorNumberIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$counselorName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.counselorNameIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.counselorNameIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$displayText();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.displayTextIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.displayTextIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$counselorEmailAddress();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.counselorEmailAddressIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.counselorEmailAddressIndex, j2, false);
                }
                realmGet$schoolName = demographicsRealmProxyInterface2.realmGet$parentGuardianEmailAddress();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, demographicsColumnInfo.parentGuardianEmailAddressIndex, j2, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, demographicsColumnInfo.parentGuardianEmailAddressIndex, j2, false);
                }
                table = table2;
            }
        }
    }

    public static Demographics createDetachedCopy(Demographics demographics, int i, int i2, Map<RealmModel, CacheData<RealmModel>> map) {
        if (i <= i2) {
            if (demographics != null) {
                Demographics demographics2;
                CacheData cacheData = (CacheData) map.get(demographics);
                if (cacheData == null) {
                    demographics2 = new Demographics();
                    map.put(demographics, new CacheData(i, demographics2));
                } else if (i >= cacheData.minDepth) {
                    return cacheData.object;
                } else {
                    Demographics demographics3 = (Demographics) cacheData.object;
                    cacheData.minDepth = i;
                    demographics2 = demographics3;
                }
                DemographicsRealmProxyInterface demographicsRealmProxyInterface = demographics2;
                DemographicsRealmProxyInterface demographicsRealmProxyInterface2 = demographics;
                demographicsRealmProxyInterface.realmSet$schoolCode(demographicsRealmProxyInterface2.realmGet$schoolCode());
                demographicsRealmProxyInterface.realmSet$schoolName(demographicsRealmProxyInterface2.realmGet$schoolName());
                demographicsRealmProxyInterface.realmSet$studentId(demographicsRealmProxyInterface2.realmGet$studentId());
                demographicsRealmProxyInterface.realmSet$firstName(demographicsRealmProxyInterface2.realmGet$firstName());
                demographicsRealmProxyInterface.realmSet$middleName(demographicsRealmProxyInterface2.realmGet$middleName());
                demographicsRealmProxyInterface.realmSet$lastName(demographicsRealmProxyInterface2.realmGet$lastName());
                demographicsRealmProxyInterface.realmSet$grade(demographicsRealmProxyInterface2.realmGet$grade());
                demographicsRealmProxyInterface.realmSet$gender(demographicsRealmProxyInterface2.realmGet$gender());
                demographicsRealmProxyInterface.realmSet$birthDate(demographicsRealmProxyInterface2.realmGet$birthDate());
                demographicsRealmProxyInterface.realmSet$age(demographicsRealmProxyInterface2.realmGet$age());
                demographicsRealmProxyInterface.realmSet$mobilePhone(demographicsRealmProxyInterface2.realmGet$mobilePhone());
                demographicsRealmProxyInterface.realmSet$emailAddress(demographicsRealmProxyInterface2.realmGet$emailAddress());
                i++;
                demographicsRealmProxyInterface.realmSet$mailingAddress(GenericAddressRealmProxy.createDetachedCopy(demographicsRealmProxyInterface2.realmGet$mailingAddress(), i, i2, map));
                demographicsRealmProxyInterface.realmSet$residenceAddress(GenericAddressRealmProxy.createDetachedCopy(demographicsRealmProxyInterface2.realmGet$residenceAddress(), i, i2, map));
                demographicsRealmProxyInterface.realmSet$correspondenceLanguageCode(demographicsRealmProxyInterface2.realmGet$correspondenceLanguageCode());
                demographicsRealmProxyInterface.realmSet$correspondenceLanguageDescription(demographicsRealmProxyInterface2.realmGet$correspondenceLanguageDescription());
                demographicsRealmProxyInterface.realmSet$languageFluencyCode(demographicsRealmProxyInterface2.realmGet$languageFluencyCode());
                demographicsRealmProxyInterface.realmSet$languageFluencyDescription(demographicsRealmProxyInterface2.realmGet$languageFluencyDescription());
                demographicsRealmProxyInterface.realmSet$ethnicityCode(demographicsRealmProxyInterface2.realmGet$ethnicityCode());
                demographicsRealmProxyInterface.realmSet$ethnicityDescription(demographicsRealmProxyInterface2.realmGet$ethnicityDescription());
                demographicsRealmProxyInterface.realmSet$raceCode(demographicsRealmProxyInterface2.realmGet$raceCode());
                demographicsRealmProxyInterface.realmSet$raceDescription(demographicsRealmProxyInterface2.realmGet$raceDescription());
                demographicsRealmProxyInterface.realmSet$primaryPhoneNumber(demographicsRealmProxyInterface2.realmGet$primaryPhoneNumber());
                demographicsRealmProxyInterface.realmSet$parentGuardianName(demographicsRealmProxyInterface2.realmGet$parentGuardianName());
                demographicsRealmProxyInterface.realmSet$contact1PhoneNumber(demographicsRealmProxyInterface2.realmGet$contact1PhoneNumber());
                demographicsRealmProxyInterface.realmSet$contact1Title(demographicsRealmProxyInterface2.realmGet$contact1Title());
                demographicsRealmProxyInterface.realmSet$contact2PhoneNumber(demographicsRealmProxyInterface2.realmGet$contact2PhoneNumber());
                demographicsRealmProxyInterface.realmSet$contact2Title(demographicsRealmProxyInterface2.realmGet$contact2Title());
                demographicsRealmProxyInterface.realmSet$counselorNumber(demographicsRealmProxyInterface2.realmGet$counselorNumber());
                demographicsRealmProxyInterface.realmSet$counselorName(demographicsRealmProxyInterface2.realmGet$counselorName());
                demographicsRealmProxyInterface.realmSet$displayText(demographicsRealmProxyInterface2.realmGet$displayText());
                demographicsRealmProxyInterface.realmSet$counselorEmailAddress(demographicsRealmProxyInterface2.realmGet$counselorEmailAddress());
                demographicsRealmProxyInterface.realmSet$parentGuardianEmailAddress(demographicsRealmProxyInterface2.realmGet$parentGuardianEmailAddress());
                return demographics2;
            }
        }
        return null;
    }

    static Demographics update(Realm realm, Demographics demographics, Demographics demographics2, Map<RealmModel, RealmObjectProxy> map) {
        DemographicsRealmProxyInterface demographicsRealmProxyInterface = demographics;
        DemographicsRealmProxyInterface demographicsRealmProxyInterface2 = demographics2;
        demographicsRealmProxyInterface.realmSet$schoolCode(demographicsRealmProxyInterface2.realmGet$schoolCode());
        demographicsRealmProxyInterface.realmSet$schoolName(demographicsRealmProxyInterface2.realmGet$schoolName());
        demographicsRealmProxyInterface.realmSet$firstName(demographicsRealmProxyInterface2.realmGet$firstName());
        demographicsRealmProxyInterface.realmSet$middleName(demographicsRealmProxyInterface2.realmGet$middleName());
        demographicsRealmProxyInterface.realmSet$lastName(demographicsRealmProxyInterface2.realmGet$lastName());
        demographicsRealmProxyInterface.realmSet$grade(demographicsRealmProxyInterface2.realmGet$grade());
        demographicsRealmProxyInterface.realmSet$gender(demographicsRealmProxyInterface2.realmGet$gender());
        demographicsRealmProxyInterface.realmSet$birthDate(demographicsRealmProxyInterface2.realmGet$birthDate());
        demographicsRealmProxyInterface.realmSet$age(demographicsRealmProxyInterface2.realmGet$age());
        demographicsRealmProxyInterface.realmSet$mobilePhone(demographicsRealmProxyInterface2.realmGet$mobilePhone());
        demographicsRealmProxyInterface.realmSet$emailAddress(demographicsRealmProxyInterface2.realmGet$emailAddress());
        GenericAddress realmGet$mailingAddress = demographicsRealmProxyInterface2.realmGet$mailingAddress();
        if (realmGet$mailingAddress == null) {
            demographicsRealmProxyInterface.realmSet$mailingAddress(null);
        } else {
            GenericAddress genericAddress = (GenericAddress) map.get(realmGet$mailingAddress);
            if (genericAddress != null) {
                demographicsRealmProxyInterface.realmSet$mailingAddress(genericAddress);
            } else {
                demographicsRealmProxyInterface.realmSet$mailingAddress(GenericAddressRealmProxy.copyOrUpdate(realm, realmGet$mailingAddress, true, map));
            }
        }
        realmGet$mailingAddress = demographicsRealmProxyInterface2.realmGet$residenceAddress();
        if (realmGet$mailingAddress == null) {
            demographicsRealmProxyInterface.realmSet$residenceAddress(null);
        } else {
            GenericAddress genericAddress2 = (GenericAddress) map.get(realmGet$mailingAddress);
            if (genericAddress2 != null) {
                demographicsRealmProxyInterface.realmSet$residenceAddress(genericAddress2);
            } else {
                demographicsRealmProxyInterface.realmSet$residenceAddress(GenericAddressRealmProxy.copyOrUpdate(realm, realmGet$mailingAddress, true, map));
            }
        }
        demographicsRealmProxyInterface.realmSet$correspondenceLanguageCode(demographicsRealmProxyInterface2.realmGet$correspondenceLanguageCode());
        demographicsRealmProxyInterface.realmSet$correspondenceLanguageDescription(demographicsRealmProxyInterface2.realmGet$correspondenceLanguageDescription());
        demographicsRealmProxyInterface.realmSet$languageFluencyCode(demographicsRealmProxyInterface2.realmGet$languageFluencyCode());
        demographicsRealmProxyInterface.realmSet$languageFluencyDescription(demographicsRealmProxyInterface2.realmGet$languageFluencyDescription());
        demographicsRealmProxyInterface.realmSet$ethnicityCode(demographicsRealmProxyInterface2.realmGet$ethnicityCode());
        demographicsRealmProxyInterface.realmSet$ethnicityDescription(demographicsRealmProxyInterface2.realmGet$ethnicityDescription());
        demographicsRealmProxyInterface.realmSet$raceCode(demographicsRealmProxyInterface2.realmGet$raceCode());
        demographicsRealmProxyInterface.realmSet$raceDescription(demographicsRealmProxyInterface2.realmGet$raceDescription());
        demographicsRealmProxyInterface.realmSet$primaryPhoneNumber(demographicsRealmProxyInterface2.realmGet$primaryPhoneNumber());
        demographicsRealmProxyInterface.realmSet$parentGuardianName(demographicsRealmProxyInterface2.realmGet$parentGuardianName());
        demographicsRealmProxyInterface.realmSet$contact1PhoneNumber(demographicsRealmProxyInterface2.realmGet$contact1PhoneNumber());
        demographicsRealmProxyInterface.realmSet$contact1Title(demographicsRealmProxyInterface2.realmGet$contact1Title());
        demographicsRealmProxyInterface.realmSet$contact2PhoneNumber(demographicsRealmProxyInterface2.realmGet$contact2PhoneNumber());
        demographicsRealmProxyInterface.realmSet$contact2Title(demographicsRealmProxyInterface2.realmGet$contact2Title());
        demographicsRealmProxyInterface.realmSet$counselorNumber(demographicsRealmProxyInterface2.realmGet$counselorNumber());
        demographicsRealmProxyInterface.realmSet$counselorName(demographicsRealmProxyInterface2.realmGet$counselorName());
        demographicsRealmProxyInterface.realmSet$displayText(demographicsRealmProxyInterface2.realmGet$displayText());
        demographicsRealmProxyInterface.realmSet$counselorEmailAddress(demographicsRealmProxyInterface2.realmGet$counselorEmailAddress());
        demographicsRealmProxyInterface.realmSet$parentGuardianEmailAddress(demographicsRealmProxyInterface2.realmGet$parentGuardianEmailAddress());
        return demographics;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Demographics = proxy[");
        stringBuilder.append("{schoolCode:");
        stringBuilder.append(realmGet$schoolCode());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{schoolName:");
        stringBuilder.append(realmGet$schoolName() != null ? realmGet$schoolName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{studentId:");
        stringBuilder.append(realmGet$studentId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{firstName:");
        stringBuilder.append(realmGet$firstName() != null ? realmGet$firstName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{middleName:");
        stringBuilder.append(realmGet$middleName() != null ? realmGet$middleName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lastName:");
        stringBuilder.append(realmGet$lastName() != null ? realmGet$lastName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{grade:");
        stringBuilder.append(realmGet$grade() != null ? realmGet$grade() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{gender:");
        stringBuilder.append(realmGet$gender() != null ? realmGet$gender() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{birthDate:");
        stringBuilder.append(realmGet$birthDate() != null ? realmGet$birthDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{age:");
        stringBuilder.append(realmGet$age() != null ? realmGet$age() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mobilePhone:");
        stringBuilder.append(realmGet$mobilePhone() != null ? realmGet$mobilePhone() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{emailAddress:");
        stringBuilder.append(realmGet$emailAddress() != null ? realmGet$emailAddress() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mailingAddress:");
        stringBuilder.append(realmGet$mailingAddress() != null ? "GenericAddress" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{residenceAddress:");
        stringBuilder.append(realmGet$residenceAddress() != null ? "GenericAddress" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{correspondenceLanguageCode:");
        stringBuilder.append(realmGet$correspondenceLanguageCode() != null ? realmGet$correspondenceLanguageCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{correspondenceLanguageDescription:");
        stringBuilder.append(realmGet$correspondenceLanguageDescription() != null ? realmGet$correspondenceLanguageDescription() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{languageFluencyCode:");
        stringBuilder.append(realmGet$languageFluencyCode() != null ? realmGet$languageFluencyCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{languageFluencyDescription:");
        stringBuilder.append(realmGet$languageFluencyDescription() != null ? realmGet$languageFluencyDescription() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ethnicityCode:");
        stringBuilder.append(realmGet$ethnicityCode() != null ? realmGet$ethnicityCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ethnicityDescription:");
        stringBuilder.append(realmGet$ethnicityDescription() != null ? realmGet$ethnicityDescription() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{raceCode:");
        stringBuilder.append(realmGet$raceCode() != null ? realmGet$raceCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{raceDescription:");
        stringBuilder.append(realmGet$raceDescription() != null ? realmGet$raceDescription() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{primaryPhoneNumber:");
        stringBuilder.append(realmGet$primaryPhoneNumber() != null ? realmGet$primaryPhoneNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{parentGuardianName:");
        stringBuilder.append(realmGet$parentGuardianName() != null ? realmGet$parentGuardianName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{contact1PhoneNumber:");
        stringBuilder.append(realmGet$contact1PhoneNumber() != null ? realmGet$contact1PhoneNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{contact1Title:");
        stringBuilder.append(realmGet$contact1Title() != null ? realmGet$contact1Title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{contact2PhoneNumber:");
        stringBuilder.append(realmGet$contact2PhoneNumber() != null ? realmGet$contact2PhoneNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{contact2Title:");
        stringBuilder.append(realmGet$contact2Title() != null ? realmGet$contact2Title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{counselorNumber:");
        stringBuilder.append(realmGet$counselorNumber() != null ? realmGet$counselorNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{counselorName:");
        stringBuilder.append(realmGet$counselorName() != null ? realmGet$counselorName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{displayText:");
        stringBuilder.append(realmGet$displayText() != null ? realmGet$displayText() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{counselorEmailAddress:");
        stringBuilder.append(realmGet$counselorEmailAddress() != null ? realmGet$counselorEmailAddress() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{parentGuardianEmailAddress:");
        stringBuilder.append(realmGet$parentGuardianEmailAddress() != null ? realmGet$parentGuardianEmailAddress() : "null");
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
        r7 = (io.realm.DemographicsRealmProxy) r7;
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
        throw new UnsupportedOperationException("Method not decompiled: io.realm.DemographicsRealmProxy.equals(java.lang.Object):boolean");
    }
}
