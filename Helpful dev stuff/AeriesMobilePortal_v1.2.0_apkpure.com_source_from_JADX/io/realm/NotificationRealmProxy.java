package io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.aeries.mobileportal.models.Notification;
import io.realm.BaseRealm.RealmObjectContext;
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

public class NotificationRealmProxy extends Notification implements RealmObjectProxy, NotificationRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private NotificationColumnInfo columnInfo;
    private ProxyState<Notification> proxyState;

    static final class NotificationColumnInfo extends ColumnInfo {
        long dateCreatedIndex;
        long dateReadIndex;
        long nameIndex;
        long notificationIDIndex;
        long notificationMessageIndex;
        long schoolCodeIndex;
        long schoolNameIndex;
        long ssoUrlIndex;
        long statusIndex;
        long userIDIndex;
        long userTypeIndex;

        NotificationColumnInfo(SharedRealm sharedRealm, Table table) {
            super(11);
            this.notificationIDIndex = addColumnDetails(table, "notificationID", RealmFieldType.STRING);
            this.notificationMessageIndex = addColumnDetails(table, "notificationMessage", RealmFieldType.STRING);
            this.userIDIndex = addColumnDetails(table, "userID", RealmFieldType.INTEGER);
            this.nameIndex = addColumnDetails(table, "name", RealmFieldType.STRING);
            this.schoolCodeIndex = addColumnDetails(table, "schoolCode", RealmFieldType.INTEGER);
            this.schoolNameIndex = addColumnDetails(table, "schoolName", RealmFieldType.STRING);
            this.userTypeIndex = addColumnDetails(table, "userType", RealmFieldType.STRING);
            this.statusIndex = addColumnDetails(table, "status", RealmFieldType.STRING);
            this.ssoUrlIndex = addColumnDetails(table, "ssoUrl", RealmFieldType.STRING);
            this.dateReadIndex = addColumnDetails(table, "dateRead", RealmFieldType.STRING);
            this.dateCreatedIndex = addColumnDetails(table, "dateCreated", RealmFieldType.STRING);
        }

        NotificationColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        protected final ColumnInfo copy(boolean z) {
            return new NotificationColumnInfo((ColumnInfo) this, z);
        }

        protected final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            NotificationColumnInfo notificationColumnInfo = (NotificationColumnInfo) columnInfo;
            NotificationColumnInfo notificationColumnInfo2 = (NotificationColumnInfo) columnInfo2;
            notificationColumnInfo2.notificationIDIndex = notificationColumnInfo.notificationIDIndex;
            notificationColumnInfo2.notificationMessageIndex = notificationColumnInfo.notificationMessageIndex;
            notificationColumnInfo2.userIDIndex = notificationColumnInfo.userIDIndex;
            notificationColumnInfo2.nameIndex = notificationColumnInfo.nameIndex;
            notificationColumnInfo2.schoolCodeIndex = notificationColumnInfo.schoolCodeIndex;
            notificationColumnInfo2.schoolNameIndex = notificationColumnInfo.schoolNameIndex;
            notificationColumnInfo2.userTypeIndex = notificationColumnInfo.userTypeIndex;
            notificationColumnInfo2.statusIndex = notificationColumnInfo.statusIndex;
            notificationColumnInfo2.ssoUrlIndex = notificationColumnInfo.ssoUrlIndex;
            notificationColumnInfo2.dateReadIndex = notificationColumnInfo.dateReadIndex;
            notificationColumnInfo2.dateCreatedIndex = notificationColumnInfo.dateCreatedIndex;
        }
    }

    public static String getTableName() {
        return "class_Notification";
    }

    static {
        List arrayList = new ArrayList();
        arrayList.add("notificationID");
        arrayList.add("notificationMessage");
        arrayList.add("userID");
        arrayList.add("name");
        arrayList.add("schoolCode");
        arrayList.add("schoolName");
        arrayList.add("userType");
        arrayList.add("status");
        arrayList.add("ssoUrl");
        arrayList.add("dateRead");
        arrayList.add("dateCreated");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    NotificationRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (NotificationColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$notificationID() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.notificationIDIndex);
    }

    public void realmSet$notificationID(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.notificationIDIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.notificationIDIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.notificationIDIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.notificationIDIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$notificationMessage() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.notificationMessageIndex);
    }

    public void realmSet$notificationMessage(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.notificationMessageIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.notificationMessageIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.notificationMessageIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.notificationMessageIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public int realmGet$userID() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.userIDIndex);
    }

    public void realmSet$userID(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.userIDIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.userIDIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    public String realmGet$name() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.nameIndex);
    }

    public void realmSet$name(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.nameIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.nameIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.nameIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.nameIndex, row$realm.getIndex(), str, true);
            }
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

    public String realmGet$userType() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.userTypeIndex);
    }

    public void realmSet$userType(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.userTypeIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.userTypeIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.userTypeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.userTypeIndex, row$realm.getIndex(), str, true);
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

    public String realmGet$ssoUrl() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.ssoUrlIndex);
    }

    public void realmSet$ssoUrl(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.ssoUrlIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.ssoUrlIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.ssoUrlIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.ssoUrlIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$dateRead() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.dateReadIndex);
    }

    public void realmSet$dateRead(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.dateReadIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.dateReadIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.dateReadIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.dateReadIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$dateCreated() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.dateCreatedIndex);
    }

    public void realmSet$dateCreated(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.dateCreatedIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.dateCreatedIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.dateCreatedIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.dateCreatedIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        Builder builder = new Builder("Notification");
        Builder builder2 = builder;
        builder2.addProperty("notificationID", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("notificationMessage", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("userID", RealmFieldType.INTEGER, false, false, true);
        builder2.addProperty("name", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("schoolCode", RealmFieldType.INTEGER, false, false, true);
        builder2.addProperty("schoolName", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("userType", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("status", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("ssoUrl", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("dateRead", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("dateCreated", RealmFieldType.STRING, false, false, false);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static NotificationColumnInfo validateTable(SharedRealm sharedRealm, boolean z) {
        if (sharedRealm.hasTable("class_Notification")) {
            Table table = sharedRealm.getTable("class_Notification");
            long columnCount = table.getColumnCount();
            if (columnCount != 11) {
                StringBuilder stringBuilder;
                if (columnCount < 11) {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is less than expected - expected 11 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                } else if (z) {
                    RealmLog.debug("Field count is more than expected - expected 11 but was %1$d", Long.valueOf(columnCount));
                } else {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is more than expected - expected 11 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                }
            }
            z = new HashMap();
            for (long j = 0; j < columnCount; j++) {
                z.put(table.getColumnName(j), table.getColumnType(j));
            }
            NotificationColumnInfo notificationColumnInfo = new NotificationColumnInfo(sharedRealm, table);
            if (table.hasPrimaryKey()) {
                sharedRealm = sharedRealm.getPath();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Primary Key defined for field ");
                stringBuilder2.append(table.getColumnName(table.getPrimaryKey()));
                stringBuilder2.append(" was removed.");
                throw new RealmMigrationNeededException(sharedRealm, stringBuilder2.toString());
            } else if (!z.containsKey("notificationID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'notificationID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("notificationID") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'notificationID' in existing Realm file.");
            } else if (!table.isColumnNullable(notificationColumnInfo.notificationIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'notificationID' is required. Either set @Required to field 'notificationID' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("notificationMessage")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'notificationMessage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("notificationMessage") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'notificationMessage' in existing Realm file.");
            } else if (!table.isColumnNullable(notificationColumnInfo.notificationMessageIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'notificationMessage' is required. Either set @Required to field 'notificationMessage' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("userID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'userID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("userID") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'userID' in existing Realm file.");
            } else if (table.isColumnNullable(notificationColumnInfo.userIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'userID' does support null values in the existing Realm file. Use corresponding boxed type for field 'userID' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("name")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            } else if (!table.isColumnNullable(notificationColumnInfo.nameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("schoolCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'schoolCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("schoolCode") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'schoolCode' in existing Realm file.");
            } else if (table.isColumnNullable(notificationColumnInfo.schoolCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'schoolCode' does support null values in the existing Realm file. Use corresponding boxed type for field 'schoolCode' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("schoolName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'schoolName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("schoolName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'schoolName' in existing Realm file.");
            } else if (!table.isColumnNullable(notificationColumnInfo.schoolNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'schoolName' is required. Either set @Required to field 'schoolName' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("userType")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'userType' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("userType") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'userType' in existing Realm file.");
            } else if (!table.isColumnNullable(notificationColumnInfo.userTypeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'userType' is required. Either set @Required to field 'userType' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("status")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'status' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("status") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'status' in existing Realm file.");
            } else if (!table.isColumnNullable(notificationColumnInfo.statusIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'status' is required. Either set @Required to field 'status' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("ssoUrl")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'ssoUrl' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("ssoUrl") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'ssoUrl' in existing Realm file.");
            } else if (!table.isColumnNullable(notificationColumnInfo.ssoUrlIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'ssoUrl' is required. Either set @Required to field 'ssoUrl' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("dateRead")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'dateRead' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("dateRead") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'dateRead' in existing Realm file.");
            } else if (!table.isColumnNullable(notificationColumnInfo.dateReadIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'dateRead' is required. Either set @Required to field 'dateRead' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("dateCreated")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'dateCreated' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("dateCreated") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'dateCreated' in existing Realm file.");
            } else if (table.isColumnNullable(notificationColumnInfo.dateCreatedIndex)) {
                return notificationColumnInfo;
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'dateCreated' is required. Either set @Required to field 'dateCreated' or migrate using RealmObjectSchema.setNullable().");
            }
        }
        throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Notification' class is missing from the schema for this Realm.");
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Notification createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        Notification notification = (Notification) realm.createObjectInternal(Notification.class, true, Collections.emptyList());
        if (jSONObject.has("notificationID")) {
            if (jSONObject.isNull("notificationID")) {
                notification.realmSet$notificationID(null);
            } else {
                notification.realmSet$notificationID(jSONObject.getString("notificationID"));
            }
        }
        if (jSONObject.has("notificationMessage")) {
            if (jSONObject.isNull("notificationMessage")) {
                notification.realmSet$notificationMessage(null);
            } else {
                notification.realmSet$notificationMessage(jSONObject.getString("notificationMessage"));
            }
        }
        if (jSONObject.has("userID")) {
            if (jSONObject.isNull("userID")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'userID' to null.");
            }
            notification.realmSet$userID(jSONObject.getInt("userID"));
        }
        if (jSONObject.has("name")) {
            if (jSONObject.isNull("name")) {
                notification.realmSet$name(null);
            } else {
                notification.realmSet$name(jSONObject.getString("name"));
            }
        }
        if (jSONObject.has("schoolCode")) {
            if (jSONObject.isNull("schoolCode")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'schoolCode' to null.");
            }
            notification.realmSet$schoolCode(jSONObject.getInt("schoolCode"));
        }
        if (jSONObject.has("schoolName")) {
            if (jSONObject.isNull("schoolName")) {
                notification.realmSet$schoolName(null);
            } else {
                notification.realmSet$schoolName(jSONObject.getString("schoolName"));
            }
        }
        if (jSONObject.has("userType")) {
            if (jSONObject.isNull("userType")) {
                notification.realmSet$userType(null);
            } else {
                notification.realmSet$userType(jSONObject.getString("userType"));
            }
        }
        if (jSONObject.has("status")) {
            if (jSONObject.isNull("status")) {
                notification.realmSet$status(null);
            } else {
                notification.realmSet$status(jSONObject.getString("status"));
            }
        }
        if (jSONObject.has("ssoUrl")) {
            if (jSONObject.isNull("ssoUrl")) {
                notification.realmSet$ssoUrl(null);
            } else {
                notification.realmSet$ssoUrl(jSONObject.getString("ssoUrl"));
            }
        }
        if (jSONObject.has("dateRead")) {
            if (jSONObject.isNull("dateRead")) {
                notification.realmSet$dateRead(null);
            } else {
                notification.realmSet$dateRead(jSONObject.getString("dateRead"));
            }
        }
        if (jSONObject.has("dateCreated")) {
            if (jSONObject.isNull("dateCreated")) {
                notification.realmSet$dateCreated(null);
            } else {
                notification.realmSet$dateCreated(jSONObject.getString("dateCreated"));
            }
        }
        return notification;
    }

    @TargetApi(11)
    public static Notification createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RealmModel notification = new Notification();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("notificationID")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((NotificationRealmProxyInterface) notification).realmSet$notificationID(null);
                } else {
                    ((NotificationRealmProxyInterface) notification).realmSet$notificationID(jsonReader.nextString());
                }
            } else if (nextName.equals("notificationMessage")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((NotificationRealmProxyInterface) notification).realmSet$notificationMessage(null);
                } else {
                    ((NotificationRealmProxyInterface) notification).realmSet$notificationMessage(jsonReader.nextString());
                }
            } else if (nextName.equals("userID")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    ((NotificationRealmProxyInterface) notification).realmSet$userID(jsonReader.nextInt());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'userID' to null.");
                }
            } else if (nextName.equals("name")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((NotificationRealmProxyInterface) notification).realmSet$name(null);
                } else {
                    ((NotificationRealmProxyInterface) notification).realmSet$name(jsonReader.nextString());
                }
            } else if (nextName.equals("schoolCode")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    ((NotificationRealmProxyInterface) notification).realmSet$schoolCode(jsonReader.nextInt());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'schoolCode' to null.");
                }
            } else if (nextName.equals("schoolName")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((NotificationRealmProxyInterface) notification).realmSet$schoolName(null);
                } else {
                    ((NotificationRealmProxyInterface) notification).realmSet$schoolName(jsonReader.nextString());
                }
            } else if (nextName.equals("userType")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((NotificationRealmProxyInterface) notification).realmSet$userType(null);
                } else {
                    ((NotificationRealmProxyInterface) notification).realmSet$userType(jsonReader.nextString());
                }
            } else if (nextName.equals("status")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((NotificationRealmProxyInterface) notification).realmSet$status(null);
                } else {
                    ((NotificationRealmProxyInterface) notification).realmSet$status(jsonReader.nextString());
                }
            } else if (nextName.equals("ssoUrl")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((NotificationRealmProxyInterface) notification).realmSet$ssoUrl(null);
                } else {
                    ((NotificationRealmProxyInterface) notification).realmSet$ssoUrl(jsonReader.nextString());
                }
            } else if (nextName.equals("dateRead")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((NotificationRealmProxyInterface) notification).realmSet$dateRead(null);
                } else {
                    ((NotificationRealmProxyInterface) notification).realmSet$dateRead(jsonReader.nextString());
                }
            } else if (!nextName.equals("dateCreated")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.skipValue();
                ((NotificationRealmProxyInterface) notification).realmSet$dateCreated(null);
            } else {
                ((NotificationRealmProxyInterface) notification).realmSet$dateCreated(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return (Notification) realm.copyToRealm(notification);
    }

    public static Notification copyOrUpdate(Realm realm, Notification notification, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy;
        boolean z2 = notification instanceof RealmObjectProxy;
        if (z2) {
            RealmObjectProxy realmObjectProxy2 = (RealmObjectProxy) notification;
            if (realmObjectProxy2.realmGet$proxyState().getRealm$realm() != null) {
                if (realmObjectProxy2.realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                }
            }
        }
        if (z2) {
            realmObjectProxy = (RealmObjectProxy) notification;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return notification;
            }
        }
        RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectProxy = (RealmObjectProxy) map.get(notification);
        if (realmObjectProxy != null) {
            return (Notification) realmObjectProxy;
        }
        return copy(realm, notification, z, map);
    }

    public static Notification copy(Realm realm, Notification notification, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = (RealmObjectProxy) map.get(notification);
        if (realmObjectProxy != null) {
            return (Notification) realmObjectProxy;
        }
        Notification notification2 = (Notification) realm.createObjectInternal(Notification.class, false, Collections.emptyList());
        map.put(notification, (RealmObjectProxy) notification2);
        NotificationRealmProxyInterface notificationRealmProxyInterface = notification;
        NotificationRealmProxyInterface notificationRealmProxyInterface2 = notification2;
        notificationRealmProxyInterface2.realmSet$notificationID(notificationRealmProxyInterface.realmGet$notificationID());
        notificationRealmProxyInterface2.realmSet$notificationMessage(notificationRealmProxyInterface.realmGet$notificationMessage());
        notificationRealmProxyInterface2.realmSet$userID(notificationRealmProxyInterface.realmGet$userID());
        notificationRealmProxyInterface2.realmSet$name(notificationRealmProxyInterface.realmGet$name());
        notificationRealmProxyInterface2.realmSet$schoolCode(notificationRealmProxyInterface.realmGet$schoolCode());
        notificationRealmProxyInterface2.realmSet$schoolName(notificationRealmProxyInterface.realmGet$schoolName());
        notificationRealmProxyInterface2.realmSet$userType(notificationRealmProxyInterface.realmGet$userType());
        notificationRealmProxyInterface2.realmSet$status(notificationRealmProxyInterface.realmGet$status());
        notificationRealmProxyInterface2.realmSet$ssoUrl(notificationRealmProxyInterface.realmGet$ssoUrl());
        notificationRealmProxyInterface2.realmSet$dateRead(notificationRealmProxyInterface.realmGet$dateRead());
        notificationRealmProxyInterface2.realmSet$dateCreated(notificationRealmProxyInterface.realmGet$dateCreated());
        return notification2;
    }

    public static long insert(Realm realm, Notification notification, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Notification notification2 = notification;
        if (notification2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) notification2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(Notification.class);
        long nativePtr = table.getNativePtr();
        NotificationColumnInfo notificationColumnInfo = (NotificationColumnInfo) realm2.schema.getColumnInfo(Notification.class);
        long createRow = OsObject.createRow(table);
        map.put(notification2, Long.valueOf(createRow));
        NotificationRealmProxyInterface notificationRealmProxyInterface = notification2;
        String realmGet$notificationID = notificationRealmProxyInterface.realmGet$notificationID();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.notificationIDIndex, createRow, realmGet$notificationID, false);
        }
        realmGet$notificationID = notificationRealmProxyInterface.realmGet$notificationMessage();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.notificationMessageIndex, createRow, realmGet$notificationID, false);
        }
        Table.nativeSetLong(nativePtr, notificationColumnInfo.userIDIndex, createRow, (long) notificationRealmProxyInterface.realmGet$userID(), false);
        realmGet$notificationID = notificationRealmProxyInterface.realmGet$name();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.nameIndex, createRow, realmGet$notificationID, false);
        }
        Table.nativeSetLong(nativePtr, notificationColumnInfo.schoolCodeIndex, createRow, (long) notificationRealmProxyInterface.realmGet$schoolCode(), false);
        realmGet$notificationID = notificationRealmProxyInterface.realmGet$schoolName();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.schoolNameIndex, createRow, realmGet$notificationID, false);
        }
        realmGet$notificationID = notificationRealmProxyInterface.realmGet$userType();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.userTypeIndex, createRow, realmGet$notificationID, false);
        }
        realmGet$notificationID = notificationRealmProxyInterface.realmGet$status();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.statusIndex, createRow, realmGet$notificationID, false);
        }
        realmGet$notificationID = notificationRealmProxyInterface.realmGet$ssoUrl();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.ssoUrlIndex, createRow, realmGet$notificationID, false);
        }
        realmGet$notificationID = notificationRealmProxyInterface.realmGet$dateRead();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.dateReadIndex, createRow, realmGet$notificationID, false);
        }
        realmGet$notificationID = notificationRealmProxyInterface.realmGet$dateCreated();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.dateCreatedIndex, createRow, realmGet$notificationID, false);
        }
        return createRow;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Table table = realm2.getTable(Notification.class);
        long nativePtr = table.getNativePtr();
        NotificationColumnInfo notificationColumnInfo = (NotificationColumnInfo) realm2.schema.getColumnInfo(Notification.class);
        while (it.hasNext()) {
            Notification notification = (Notification) it.next();
            if (!map2.containsKey(notification)) {
                long j;
                if (notification instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) notification;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(notification, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(notification, Long.valueOf(createRow));
                NotificationRealmProxyInterface notificationRealmProxyInterface = notification;
                String realmGet$notificationID = notificationRealmProxyInterface.realmGet$notificationID();
                if (realmGet$notificationID != null) {
                    j = createRow;
                    Table.nativeSetString(nativePtr, notificationColumnInfo.notificationIDIndex, createRow, realmGet$notificationID, false);
                } else {
                    j = createRow;
                }
                realmGet$notificationID = notificationRealmProxyInterface.realmGet$notificationMessage();
                if (realmGet$notificationID != null) {
                    Table.nativeSetString(nativePtr, notificationColumnInfo.notificationMessageIndex, j, realmGet$notificationID, false);
                }
                Table.nativeSetLong(nativePtr, notificationColumnInfo.userIDIndex, j, (long) notificationRealmProxyInterface.realmGet$userID(), false);
                realmGet$notificationID = notificationRealmProxyInterface.realmGet$name();
                if (realmGet$notificationID != null) {
                    Table.nativeSetString(nativePtr, notificationColumnInfo.nameIndex, j, realmGet$notificationID, false);
                }
                Table.nativeSetLong(nativePtr, notificationColumnInfo.schoolCodeIndex, j, (long) notificationRealmProxyInterface.realmGet$schoolCode(), false);
                realmGet$notificationID = notificationRealmProxyInterface.realmGet$schoolName();
                if (realmGet$notificationID != null) {
                    Table.nativeSetString(nativePtr, notificationColumnInfo.schoolNameIndex, j, realmGet$notificationID, false);
                }
                realmGet$notificationID = notificationRealmProxyInterface.realmGet$userType();
                if (realmGet$notificationID != null) {
                    Table.nativeSetString(nativePtr, notificationColumnInfo.userTypeIndex, j, realmGet$notificationID, false);
                }
                realmGet$notificationID = notificationRealmProxyInterface.realmGet$status();
                if (realmGet$notificationID != null) {
                    Table.nativeSetString(nativePtr, notificationColumnInfo.statusIndex, j, realmGet$notificationID, false);
                }
                realmGet$notificationID = notificationRealmProxyInterface.realmGet$ssoUrl();
                if (realmGet$notificationID != null) {
                    Table.nativeSetString(nativePtr, notificationColumnInfo.ssoUrlIndex, j, realmGet$notificationID, false);
                }
                realmGet$notificationID = notificationRealmProxyInterface.realmGet$dateRead();
                if (realmGet$notificationID != null) {
                    Table.nativeSetString(nativePtr, notificationColumnInfo.dateReadIndex, j, realmGet$notificationID, false);
                }
                realmGet$notificationID = notificationRealmProxyInterface.realmGet$dateCreated();
                if (realmGet$notificationID != null) {
                    Table.nativeSetString(nativePtr, notificationColumnInfo.dateCreatedIndex, j, realmGet$notificationID, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, Notification notification, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Notification notification2 = notification;
        if (notification2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) notification2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(Notification.class);
        long nativePtr = table.getNativePtr();
        NotificationColumnInfo notificationColumnInfo = (NotificationColumnInfo) realm2.schema.getColumnInfo(Notification.class);
        long createRow = OsObject.createRow(table);
        map.put(notification2, Long.valueOf(createRow));
        NotificationRealmProxyInterface notificationRealmProxyInterface = notification2;
        String realmGet$notificationID = notificationRealmProxyInterface.realmGet$notificationID();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.notificationIDIndex, createRow, realmGet$notificationID, false);
        } else {
            Table.nativeSetNull(nativePtr, notificationColumnInfo.notificationIDIndex, createRow, false);
        }
        realmGet$notificationID = notificationRealmProxyInterface.realmGet$notificationMessage();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.notificationMessageIndex, createRow, realmGet$notificationID, false);
        } else {
            Table.nativeSetNull(nativePtr, notificationColumnInfo.notificationMessageIndex, createRow, false);
        }
        Table.nativeSetLong(nativePtr, notificationColumnInfo.userIDIndex, createRow, (long) notificationRealmProxyInterface.realmGet$userID(), false);
        realmGet$notificationID = notificationRealmProxyInterface.realmGet$name();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.nameIndex, createRow, realmGet$notificationID, false);
        } else {
            Table.nativeSetNull(nativePtr, notificationColumnInfo.nameIndex, createRow, false);
        }
        Table.nativeSetLong(nativePtr, notificationColumnInfo.schoolCodeIndex, createRow, (long) notificationRealmProxyInterface.realmGet$schoolCode(), false);
        realmGet$notificationID = notificationRealmProxyInterface.realmGet$schoolName();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.schoolNameIndex, createRow, realmGet$notificationID, false);
        } else {
            Table.nativeSetNull(nativePtr, notificationColumnInfo.schoolNameIndex, createRow, false);
        }
        realmGet$notificationID = notificationRealmProxyInterface.realmGet$userType();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.userTypeIndex, createRow, realmGet$notificationID, false);
        } else {
            Table.nativeSetNull(nativePtr, notificationColumnInfo.userTypeIndex, createRow, false);
        }
        realmGet$notificationID = notificationRealmProxyInterface.realmGet$status();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.statusIndex, createRow, realmGet$notificationID, false);
        } else {
            Table.nativeSetNull(nativePtr, notificationColumnInfo.statusIndex, createRow, false);
        }
        realmGet$notificationID = notificationRealmProxyInterface.realmGet$ssoUrl();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.ssoUrlIndex, createRow, realmGet$notificationID, false);
        } else {
            Table.nativeSetNull(nativePtr, notificationColumnInfo.ssoUrlIndex, createRow, false);
        }
        realmGet$notificationID = notificationRealmProxyInterface.realmGet$dateRead();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.dateReadIndex, createRow, realmGet$notificationID, false);
        } else {
            Table.nativeSetNull(nativePtr, notificationColumnInfo.dateReadIndex, createRow, false);
        }
        realmGet$notificationID = notificationRealmProxyInterface.realmGet$dateCreated();
        if (realmGet$notificationID != null) {
            Table.nativeSetString(nativePtr, notificationColumnInfo.dateCreatedIndex, createRow, realmGet$notificationID, false);
        } else {
            Table.nativeSetNull(nativePtr, notificationColumnInfo.dateCreatedIndex, createRow, false);
        }
        return createRow;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Table table = realm2.getTable(Notification.class);
        long nativePtr = table.getNativePtr();
        NotificationColumnInfo notificationColumnInfo = (NotificationColumnInfo) realm2.schema.getColumnInfo(Notification.class);
        while (it.hasNext()) {
            Notification notification = (Notification) it.next();
            if (!map2.containsKey(notification)) {
                long j;
                if (notification instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) notification;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(notification, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(notification, Long.valueOf(createRow));
                NotificationRealmProxyInterface notificationRealmProxyInterface = notification;
                String realmGet$notificationID = notificationRealmProxyInterface.realmGet$notificationID();
                if (realmGet$notificationID != null) {
                    j = createRow;
                    Table.nativeSetString(nativePtr, notificationColumnInfo.notificationIDIndex, createRow, realmGet$notificationID, false);
                } else {
                    j = createRow;
                    Table.nativeSetNull(nativePtr, notificationColumnInfo.notificationIDIndex, j, false);
                }
                realmGet$notificationID = notificationRealmProxyInterface.realmGet$notificationMessage();
                if (realmGet$notificationID != null) {
                    Table.nativeSetString(nativePtr, notificationColumnInfo.notificationMessageIndex, j, realmGet$notificationID, false);
                } else {
                    Table.nativeSetNull(nativePtr, notificationColumnInfo.notificationMessageIndex, j, false);
                }
                Table.nativeSetLong(nativePtr, notificationColumnInfo.userIDIndex, j, (long) notificationRealmProxyInterface.realmGet$userID(), false);
                realmGet$notificationID = notificationRealmProxyInterface.realmGet$name();
                if (realmGet$notificationID != null) {
                    Table.nativeSetString(nativePtr, notificationColumnInfo.nameIndex, j, realmGet$notificationID, false);
                } else {
                    Table.nativeSetNull(nativePtr, notificationColumnInfo.nameIndex, j, false);
                }
                Table.nativeSetLong(nativePtr, notificationColumnInfo.schoolCodeIndex, j, (long) notificationRealmProxyInterface.realmGet$schoolCode(), false);
                realmGet$notificationID = notificationRealmProxyInterface.realmGet$schoolName();
                if (realmGet$notificationID != null) {
                    Table.nativeSetString(nativePtr, notificationColumnInfo.schoolNameIndex, j, realmGet$notificationID, false);
                } else {
                    Table.nativeSetNull(nativePtr, notificationColumnInfo.schoolNameIndex, j, false);
                }
                realmGet$notificationID = notificationRealmProxyInterface.realmGet$userType();
                if (realmGet$notificationID != null) {
                    Table.nativeSetString(nativePtr, notificationColumnInfo.userTypeIndex, j, realmGet$notificationID, false);
                } else {
                    Table.nativeSetNull(nativePtr, notificationColumnInfo.userTypeIndex, j, false);
                }
                realmGet$notificationID = notificationRealmProxyInterface.realmGet$status();
                if (realmGet$notificationID != null) {
                    Table.nativeSetString(nativePtr, notificationColumnInfo.statusIndex, j, realmGet$notificationID, false);
                } else {
                    Table.nativeSetNull(nativePtr, notificationColumnInfo.statusIndex, j, false);
                }
                realmGet$notificationID = notificationRealmProxyInterface.realmGet$ssoUrl();
                if (realmGet$notificationID != null) {
                    Table.nativeSetString(nativePtr, notificationColumnInfo.ssoUrlIndex, j, realmGet$notificationID, false);
                } else {
                    Table.nativeSetNull(nativePtr, notificationColumnInfo.ssoUrlIndex, j, false);
                }
                realmGet$notificationID = notificationRealmProxyInterface.realmGet$dateRead();
                if (realmGet$notificationID != null) {
                    Table.nativeSetString(nativePtr, notificationColumnInfo.dateReadIndex, j, realmGet$notificationID, false);
                } else {
                    Table.nativeSetNull(nativePtr, notificationColumnInfo.dateReadIndex, j, false);
                }
                realmGet$notificationID = notificationRealmProxyInterface.realmGet$dateCreated();
                if (realmGet$notificationID != null) {
                    Table.nativeSetString(nativePtr, notificationColumnInfo.dateCreatedIndex, j, realmGet$notificationID, false);
                } else {
                    Table.nativeSetNull(nativePtr, notificationColumnInfo.dateCreatedIndex, j, false);
                }
            }
        }
    }

    public static Notification createDetachedCopy(Notification notification, int i, int i2, Map<RealmModel, CacheData<RealmModel>> map) {
        if (i <= i2) {
            if (notification != null) {
                CacheData cacheData = (CacheData) map.get(notification);
                if (cacheData == null) {
                    i2 = new Notification();
                    map.put(notification, new CacheData(i, i2));
                } else if (i >= cacheData.minDepth) {
                    return cacheData.object;
                } else {
                    Notification notification2 = (Notification) cacheData.object;
                    cacheData.minDepth = i;
                    i2 = notification2;
                }
                NotificationRealmProxyInterface notificationRealmProxyInterface = (NotificationRealmProxyInterface) i2;
                NotificationRealmProxyInterface notificationRealmProxyInterface2 = notification;
                notificationRealmProxyInterface.realmSet$notificationID(notificationRealmProxyInterface2.realmGet$notificationID());
                notificationRealmProxyInterface.realmSet$notificationMessage(notificationRealmProxyInterface2.realmGet$notificationMessage());
                notificationRealmProxyInterface.realmSet$userID(notificationRealmProxyInterface2.realmGet$userID());
                notificationRealmProxyInterface.realmSet$name(notificationRealmProxyInterface2.realmGet$name());
                notificationRealmProxyInterface.realmSet$schoolCode(notificationRealmProxyInterface2.realmGet$schoolCode());
                notificationRealmProxyInterface.realmSet$schoolName(notificationRealmProxyInterface2.realmGet$schoolName());
                notificationRealmProxyInterface.realmSet$userType(notificationRealmProxyInterface2.realmGet$userType());
                notificationRealmProxyInterface.realmSet$status(notificationRealmProxyInterface2.realmGet$status());
                notificationRealmProxyInterface.realmSet$ssoUrl(notificationRealmProxyInterface2.realmGet$ssoUrl());
                notificationRealmProxyInterface.realmSet$dateRead(notificationRealmProxyInterface2.realmGet$dateRead());
                notificationRealmProxyInterface.realmSet$dateCreated(notificationRealmProxyInterface2.realmGet$dateCreated());
                return i2;
            }
        }
        return null;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Notification = proxy[");
        stringBuilder.append("{notificationID:");
        stringBuilder.append(realmGet$notificationID() != null ? realmGet$notificationID() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{notificationMessage:");
        stringBuilder.append(realmGet$notificationMessage() != null ? realmGet$notificationMessage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userID:");
        stringBuilder.append(realmGet$userID());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{schoolCode:");
        stringBuilder.append(realmGet$schoolCode());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{schoolName:");
        stringBuilder.append(realmGet$schoolName() != null ? realmGet$schoolName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userType:");
        stringBuilder.append(realmGet$userType() != null ? realmGet$userType() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status() != null ? realmGet$status() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ssoUrl:");
        stringBuilder.append(realmGet$ssoUrl() != null ? realmGet$ssoUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{dateRead:");
        stringBuilder.append(realmGet$dateRead() != null ? realmGet$dateRead() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{dateCreated:");
        stringBuilder.append(realmGet$dateCreated() != null ? realmGet$dateCreated() : "null");
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
        r7 = (io.realm.NotificationRealmProxy) r7;
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
        throw new UnsupportedOperationException("Method not decompiled: io.realm.NotificationRealmProxy.equals(java.lang.Object):boolean");
    }
}
