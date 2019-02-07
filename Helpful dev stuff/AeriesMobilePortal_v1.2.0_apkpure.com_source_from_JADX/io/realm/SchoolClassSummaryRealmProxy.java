package io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.aeries.mobileportal.models.ClassSummary;
import com.aeries.mobileportal.models.SchoolClassSummary;
import io.realm.BaseRealm.RealmObjectContext;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
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

public class SchoolClassSummaryRealmProxy extends SchoolClassSummary implements RealmObjectProxy, SchoolClassSummaryRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RealmList<ClassSummary> classSummariesRealmList;
    private SchoolClassSummaryColumnInfo columnInfo;
    private ProxyState<SchoolClassSummary> proxyState;

    static final class SchoolClassSummaryColumnInfo extends ColumnInfo {
        long classSummariesIndex;
        long hideScoresIndex;
        long schoolCodeIndex;
        long schoolNameIndex;
        long showPeriodIndex;
        long studentIDIndex;

        SchoolClassSummaryColumnInfo(SharedRealm sharedRealm, Table table) {
            super(6);
            this.schoolCodeIndex = addColumnDetails(table, "schoolCode", RealmFieldType.INTEGER);
            this.schoolNameIndex = addColumnDetails(table, "schoolName", RealmFieldType.STRING);
            this.studentIDIndex = addColumnDetails(table, "studentID", RealmFieldType.INTEGER);
            this.showPeriodIndex = addColumnDetails(table, "showPeriod", RealmFieldType.BOOLEAN);
            this.hideScoresIndex = addColumnDetails(table, "hideScores", RealmFieldType.BOOLEAN);
            this.classSummariesIndex = addColumnDetails(table, "classSummaries", RealmFieldType.LIST);
        }

        SchoolClassSummaryColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        protected final ColumnInfo copy(boolean z) {
            return new SchoolClassSummaryColumnInfo((ColumnInfo) this, z);
        }

        protected final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            SchoolClassSummaryColumnInfo schoolClassSummaryColumnInfo = (SchoolClassSummaryColumnInfo) columnInfo;
            SchoolClassSummaryColumnInfo schoolClassSummaryColumnInfo2 = (SchoolClassSummaryColumnInfo) columnInfo2;
            schoolClassSummaryColumnInfo2.schoolCodeIndex = schoolClassSummaryColumnInfo.schoolCodeIndex;
            schoolClassSummaryColumnInfo2.schoolNameIndex = schoolClassSummaryColumnInfo.schoolNameIndex;
            schoolClassSummaryColumnInfo2.studentIDIndex = schoolClassSummaryColumnInfo.studentIDIndex;
            schoolClassSummaryColumnInfo2.showPeriodIndex = schoolClassSummaryColumnInfo.showPeriodIndex;
            schoolClassSummaryColumnInfo2.hideScoresIndex = schoolClassSummaryColumnInfo.hideScoresIndex;
            schoolClassSummaryColumnInfo2.classSummariesIndex = schoolClassSummaryColumnInfo.classSummariesIndex;
        }
    }

    public static String getTableName() {
        return "class_SchoolClassSummary";
    }

    static {
        List arrayList = new ArrayList();
        arrayList.add("schoolCode");
        arrayList.add("schoolName");
        arrayList.add("studentID");
        arrayList.add("showPeriod");
        arrayList.add("hideScores");
        arrayList.add("classSummaries");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    SchoolClassSummaryRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (SchoolClassSummaryColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public Integer realmGet$schoolCode() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.schoolCodeIndex)) {
            return null;
        }
        return Integer.valueOf((int) this.proxyState.getRow$realm().getLong(this.columnInfo.schoolCodeIndex));
    }

    public void realmSet$schoolCode(Integer num) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (num == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.schoolCodeIndex);
            } else {
                r0.proxyState.getRow$realm().setLong(r0.columnInfo.schoolCodeIndex, (long) num.intValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (num == null) {
                row$realm.getTable().setNull(r0.columnInfo.schoolCodeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setLong(r0.columnInfo.schoolCodeIndex, row$realm.getIndex(), (long) num.intValue(), true);
            }
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

    public Integer realmGet$studentID() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.studentIDIndex)) {
            return null;
        }
        return Integer.valueOf((int) this.proxyState.getRow$realm().getLong(this.columnInfo.studentIDIndex));
    }

    public void realmSet$studentID(Integer num) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (num == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.studentIDIndex);
            } else {
                r0.proxyState.getRow$realm().setLong(r0.columnInfo.studentIDIndex, (long) num.intValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (num == null) {
                row$realm.getTable().setNull(r0.columnInfo.studentIDIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setLong(r0.columnInfo.studentIDIndex, row$realm.getIndex(), (long) num.intValue(), true);
            }
        }
    }

    public boolean realmGet$showPeriod() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.showPeriodIndex);
    }

    public void realmSet$showPeriod(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.showPeriodIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.showPeriodIndex, row$realm.getIndex(), z, true);
        }
    }

    public boolean realmGet$hideScores() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.hideScoresIndex);
    }

    public void realmSet$hideScores(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.hideScoresIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.hideScoresIndex, row$realm.getIndex(), z, true);
        }
    }

    public RealmList<ClassSummary> realmGet$classSummaries() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.classSummariesRealmList != null) {
            return this.classSummariesRealmList;
        }
        this.classSummariesRealmList = new RealmList(ClassSummary.class, this.proxyState.getRow$realm().getLinkList(this.columnInfo.classSummariesIndex), this.proxyState.getRealm$realm());
        return this.classSummariesRealmList;
    }

    public void realmSet$classSummaries(RealmList<ClassSummary> realmList) {
        if (this.proxyState.isUnderConstruction()) {
            if (!this.proxyState.getAcceptDefaultValue$realm() || this.proxyState.getExcludeFields$realm().contains("classSummaries")) {
                return;
            }
            if (!(realmList == null || realmList.isManaged())) {
                Realm realm = (Realm) this.proxyState.getRealm$realm();
                RealmList<ClassSummary> realmList2 = new RealmList();
                realmList = realmList.iterator();
                while (realmList.hasNext()) {
                    RealmModel realmModel = (ClassSummary) realmList.next();
                    if (realmModel != null) {
                        if (!RealmObject.isManaged(realmModel)) {
                            realmList2.add(realm.copyToRealm(realmModel));
                        }
                    }
                    realmList2.add(realmModel);
                }
                realmList = realmList2;
            }
        }
        this.proxyState.getRealm$realm().checkIfValid();
        LinkView linkList = this.proxyState.getRow$realm().getLinkList(this.columnInfo.classSummariesIndex);
        linkList.clear();
        if (realmList != null) {
            realmList = realmList.iterator();
            while (realmList.hasNext()) {
                RealmModel realmModel2 = (RealmModel) realmList.next();
                if (RealmObject.isManaged(realmModel2) && RealmObject.isValid(realmModel2)) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) realmModel2;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() == this.proxyState.getRealm$realm()) {
                        linkList.add(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex());
                    } else {
                        throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
                    }
                }
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        Builder builder = new Builder("SchoolClassSummary");
        Builder builder2 = builder;
        builder2.addProperty("schoolCode", RealmFieldType.INTEGER, false, false, false);
        builder2.addProperty("schoolName", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("studentID", RealmFieldType.INTEGER, false, false, false);
        builder2.addProperty("showPeriod", RealmFieldType.BOOLEAN, false, false, true);
        builder2.addProperty("hideScores", RealmFieldType.BOOLEAN, false, false, true);
        builder.addLinkedProperty("classSummaries", RealmFieldType.LIST, "ClassSummary");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static SchoolClassSummaryColumnInfo validateTable(SharedRealm sharedRealm, boolean z) {
        if (sharedRealm.hasTable("class_SchoolClassSummary")) {
            Table table = sharedRealm.getTable("class_SchoolClassSummary");
            long columnCount = table.getColumnCount();
            if (columnCount != 6) {
                StringBuilder stringBuilder;
                if (columnCount < 6) {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is less than expected - expected 6 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                } else if (z) {
                    RealmLog.debug("Field count is more than expected - expected 6 but was %1$d", Long.valueOf(columnCount));
                } else {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is more than expected - expected 6 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                }
            }
            z = new HashMap();
            for (long j = 0; j < columnCount; j++) {
                z.put(table.getColumnName(j), table.getColumnType(j));
            }
            SchoolClassSummaryColumnInfo schoolClassSummaryColumnInfo = new SchoolClassSummaryColumnInfo(sharedRealm, table);
            if (table.hasPrimaryKey()) {
                sharedRealm = sharedRealm.getPath();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Primary Key defined for field ");
                stringBuilder2.append(table.getColumnName(table.getPrimaryKey()));
                stringBuilder2.append(" was removed.");
                throw new RealmMigrationNeededException(sharedRealm, stringBuilder2.toString());
            } else if (!z.containsKey("schoolCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'schoolCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("schoolCode") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'schoolCode' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolClassSummaryColumnInfo.schoolCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'schoolCode' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'schoolCode' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("schoolName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'schoolName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("schoolName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'schoolName' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolClassSummaryColumnInfo.schoolNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'schoolName' is required. Either set @Required to field 'schoolName' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("studentID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'studentID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("studentID") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'studentID' in existing Realm file.");
            } else if (!table.isColumnNullable(schoolClassSummaryColumnInfo.studentIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'studentID' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'studentID' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("showPeriod")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'showPeriod' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("showPeriod") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'showPeriod' in existing Realm file.");
            } else if (table.isColumnNullable(schoolClassSummaryColumnInfo.showPeriodIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'showPeriod' does support null values in the existing Realm file. Use corresponding boxed type for field 'showPeriod' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("hideScores")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'hideScores' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("hideScores") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'hideScores' in existing Realm file.");
            } else if (table.isColumnNullable(schoolClassSummaryColumnInfo.hideScoresIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'hideScores' does support null values in the existing Realm file. Use corresponding boxed type for field 'hideScores' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("classSummaries")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'classSummaries'");
            } else if (z.get("classSummaries") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'ClassSummary' for field 'classSummaries'");
            } else if (sharedRealm.hasTable("class_ClassSummary")) {
                z = sharedRealm.getTable("class_ClassSummary");
                if (table.getLinkTarget(schoolClassSummaryColumnInfo.classSummariesIndex).hasSameSchema(z)) {
                    return schoolClassSummaryColumnInfo;
                }
                sharedRealm = sharedRealm.getPath();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Invalid RealmList type for field 'classSummaries': '");
                stringBuilder3.append(table.getLinkTarget(schoolClassSummaryColumnInfo.classSummariesIndex).getName());
                stringBuilder3.append("' expected - was '");
                stringBuilder3.append(z.getName());
                stringBuilder3.append("'");
                throw new RealmMigrationNeededException(sharedRealm, stringBuilder3.toString());
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_ClassSummary' for field 'classSummaries'");
            }
        }
        throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'SchoolClassSummary' class is missing from the schema for this Realm.");
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static SchoolClassSummary createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        List arrayList = new ArrayList(1);
        if (jSONObject.has("classSummaries")) {
            arrayList.add("classSummaries");
        }
        SchoolClassSummary schoolClassSummary = (SchoolClassSummary) realm.createObjectInternal(SchoolClassSummary.class, true, arrayList);
        if (jSONObject.has("schoolCode")) {
            if (jSONObject.isNull("schoolCode")) {
                schoolClassSummary.realmSet$schoolCode(null);
            } else {
                schoolClassSummary.realmSet$schoolCode(Integer.valueOf(jSONObject.getInt("schoolCode")));
            }
        }
        if (jSONObject.has("schoolName")) {
            if (jSONObject.isNull("schoolName")) {
                schoolClassSummary.realmSet$schoolName(null);
            } else {
                schoolClassSummary.realmSet$schoolName(jSONObject.getString("schoolName"));
            }
        }
        if (jSONObject.has("studentID")) {
            if (jSONObject.isNull("studentID")) {
                schoolClassSummary.realmSet$studentID(null);
            } else {
                schoolClassSummary.realmSet$studentID(Integer.valueOf(jSONObject.getInt("studentID")));
            }
        }
        if (jSONObject.has("showPeriod")) {
            if (jSONObject.isNull("showPeriod")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'showPeriod' to null.");
            }
            schoolClassSummary.realmSet$showPeriod(jSONObject.getBoolean("showPeriod"));
        }
        if (jSONObject.has("hideScores")) {
            if (jSONObject.isNull("hideScores")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'hideScores' to null.");
            }
            schoolClassSummary.realmSet$hideScores(jSONObject.getBoolean("hideScores"));
        }
        if (jSONObject.has("classSummaries")) {
            if (jSONObject.isNull("classSummaries")) {
                schoolClassSummary.realmSet$classSummaries(null);
            } else {
                SchoolClassSummaryRealmProxyInterface schoolClassSummaryRealmProxyInterface = schoolClassSummary;
                schoolClassSummaryRealmProxyInterface.realmGet$classSummaries().clear();
                jSONObject = jSONObject.getJSONArray("classSummaries");
                for (int i = 0; i < jSONObject.length(); i++) {
                    schoolClassSummaryRealmProxyInterface.realmGet$classSummaries().add(ClassSummaryRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject.getJSONObject(i), z));
                }
            }
        }
        return schoolClassSummary;
    }

    @TargetApi(11)
    public static SchoolClassSummary createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RealmModel schoolClassSummary = new SchoolClassSummary();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("schoolCode")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolClassSummaryRealmProxyInterface) schoolClassSummary).realmSet$schoolCode(null);
                } else {
                    ((SchoolClassSummaryRealmProxyInterface) schoolClassSummary).realmSet$schoolCode(Integer.valueOf(jsonReader.nextInt()));
                }
            } else if (nextName.equals("schoolName")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolClassSummaryRealmProxyInterface) schoolClassSummary).realmSet$schoolName(null);
                } else {
                    ((SchoolClassSummaryRealmProxyInterface) schoolClassSummary).realmSet$schoolName(jsonReader.nextString());
                }
            } else if (nextName.equals("studentID")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((SchoolClassSummaryRealmProxyInterface) schoolClassSummary).realmSet$studentID(null);
                } else {
                    ((SchoolClassSummaryRealmProxyInterface) schoolClassSummary).realmSet$studentID(Integer.valueOf(jsonReader.nextInt()));
                }
            } else if (nextName.equals("showPeriod")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    ((SchoolClassSummaryRealmProxyInterface) schoolClassSummary).realmSet$showPeriod(jsonReader.nextBoolean());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'showPeriod' to null.");
                }
            } else if (nextName.equals("hideScores")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    ((SchoolClassSummaryRealmProxyInterface) schoolClassSummary).realmSet$hideScores(jsonReader.nextBoolean());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'hideScores' to null.");
                }
            } else if (!nextName.equals("classSummaries")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.skipValue();
                ((SchoolClassSummaryRealmProxyInterface) schoolClassSummary).realmSet$classSummaries(null);
            } else {
                SchoolClassSummaryRealmProxyInterface schoolClassSummaryRealmProxyInterface = (SchoolClassSummaryRealmProxyInterface) schoolClassSummary;
                schoolClassSummaryRealmProxyInterface.realmSet$classSummaries(new RealmList());
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    schoolClassSummaryRealmProxyInterface.realmGet$classSummaries().add(ClassSummaryRealmProxy.createUsingJsonStream(realm, jsonReader));
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
        return (SchoolClassSummary) realm.copyToRealm(schoolClassSummary);
    }

    public static SchoolClassSummary copyOrUpdate(Realm realm, SchoolClassSummary schoolClassSummary, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy;
        boolean z2 = schoolClassSummary instanceof RealmObjectProxy;
        if (z2) {
            RealmObjectProxy realmObjectProxy2 = (RealmObjectProxy) schoolClassSummary;
            if (realmObjectProxy2.realmGet$proxyState().getRealm$realm() != null) {
                if (realmObjectProxy2.realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                }
            }
        }
        if (z2) {
            realmObjectProxy = (RealmObjectProxy) schoolClassSummary;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return schoolClassSummary;
            }
        }
        RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectProxy = (RealmObjectProxy) map.get(schoolClassSummary);
        if (realmObjectProxy != null) {
            return (SchoolClassSummary) realmObjectProxy;
        }
        return copy(realm, schoolClassSummary, z, map);
    }

    public static SchoolClassSummary copy(Realm realm, SchoolClassSummary schoolClassSummary, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = (RealmObjectProxy) map.get(schoolClassSummary);
        if (realmObjectProxy != null) {
            return (SchoolClassSummary) realmObjectProxy;
        }
        int i = 0;
        SchoolClassSummary schoolClassSummary2 = (SchoolClassSummary) realm.createObjectInternal(SchoolClassSummary.class, false, Collections.emptyList());
        map.put(schoolClassSummary, (RealmObjectProxy) schoolClassSummary2);
        SchoolClassSummaryRealmProxyInterface schoolClassSummaryRealmProxyInterface = schoolClassSummary;
        SchoolClassSummaryRealmProxyInterface schoolClassSummaryRealmProxyInterface2 = schoolClassSummary2;
        schoolClassSummaryRealmProxyInterface2.realmSet$schoolCode(schoolClassSummaryRealmProxyInterface.realmGet$schoolCode());
        schoolClassSummaryRealmProxyInterface2.realmSet$schoolName(schoolClassSummaryRealmProxyInterface.realmGet$schoolName());
        schoolClassSummaryRealmProxyInterface2.realmSet$studentID(schoolClassSummaryRealmProxyInterface.realmGet$studentID());
        schoolClassSummaryRealmProxyInterface2.realmSet$showPeriod(schoolClassSummaryRealmProxyInterface.realmGet$showPeriod());
        schoolClassSummaryRealmProxyInterface2.realmSet$hideScores(schoolClassSummaryRealmProxyInterface.realmGet$hideScores());
        schoolClassSummary = schoolClassSummaryRealmProxyInterface.realmGet$classSummaries();
        if (schoolClassSummary != null) {
            RealmList realmGet$classSummaries = schoolClassSummaryRealmProxyInterface2.realmGet$classSummaries();
            while (i < schoolClassSummary.size()) {
                ClassSummary classSummary = (ClassSummary) schoolClassSummary.get(i);
                RealmModel realmModel = (ClassSummary) map.get(classSummary);
                if (realmModel != null) {
                    realmGet$classSummaries.add(realmModel);
                } else {
                    realmGet$classSummaries.add(ClassSummaryRealmProxy.copyOrUpdate(realm, classSummary, z, map));
                }
                i++;
            }
        }
        return schoolClassSummary2;
    }

    public static long insert(Realm realm, SchoolClassSummary schoolClassSummary, Map<RealmModel, Long> map) {
        long j;
        Realm realm2 = realm;
        SchoolClassSummary schoolClassSummary2 = schoolClassSummary;
        Map map2 = map;
        if (schoolClassSummary2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) schoolClassSummary2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(SchoolClassSummary.class);
        long nativePtr = table.getNativePtr();
        SchoolClassSummaryColumnInfo schoolClassSummaryColumnInfo = (SchoolClassSummaryColumnInfo) realm2.schema.getColumnInfo(SchoolClassSummary.class);
        long createRow = OsObject.createRow(table);
        map2.put(schoolClassSummary2, Long.valueOf(createRow));
        SchoolClassSummaryRealmProxyInterface schoolClassSummaryRealmProxyInterface = schoolClassSummary2;
        Number realmGet$schoolCode = schoolClassSummaryRealmProxyInterface.realmGet$schoolCode();
        if (realmGet$schoolCode != null) {
            j = createRow;
            Table.nativeSetLong(nativePtr, schoolClassSummaryColumnInfo.schoolCodeIndex, createRow, realmGet$schoolCode.longValue(), false);
        } else {
            j = createRow;
        }
        String realmGet$schoolName = schoolClassSummaryRealmProxyInterface.realmGet$schoolName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolClassSummaryColumnInfo.schoolNameIndex, j, realmGet$schoolName, false);
        }
        realmGet$schoolCode = schoolClassSummaryRealmProxyInterface.realmGet$studentID();
        if (realmGet$schoolCode != null) {
            Table.nativeSetLong(nativePtr, schoolClassSummaryColumnInfo.studentIDIndex, j, realmGet$schoolCode.longValue(), false);
        }
        long j2 = nativePtr;
        long j3 = j;
        Table.nativeSetBoolean(j2, schoolClassSummaryColumnInfo.showPeriodIndex, j3, schoolClassSummaryRealmProxyInterface.realmGet$showPeriod(), false);
        Table.nativeSetBoolean(j2, schoolClassSummaryColumnInfo.hideScoresIndex, j3, schoolClassSummaryRealmProxyInterface.realmGet$hideScores(), false);
        RealmList realmGet$classSummaries = schoolClassSummaryRealmProxyInterface.realmGet$classSummaries();
        if (realmGet$classSummaries != null) {
            long nativeGetLinkView = Table.nativeGetLinkView(nativePtr, schoolClassSummaryColumnInfo.classSummariesIndex, j);
            Iterator it = realmGet$classSummaries.iterator();
            while (it.hasNext()) {
                ClassSummary classSummary = (ClassSummary) it.next();
                Long l = (Long) map2.get(classSummary);
                if (l == null) {
                    l = Long.valueOf(ClassSummaryRealmProxy.insert(realm2, classSummary, map2));
                }
                LinkView.nativeAdd(nativeGetLinkView, l.longValue());
            }
        }
        return j;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map map2 = map;
        Table table = realm2.getTable(SchoolClassSummary.class);
        long nativePtr = table.getNativePtr();
        SchoolClassSummaryColumnInfo schoolClassSummaryColumnInfo = (SchoolClassSummaryColumnInfo) realm2.schema.getColumnInfo(SchoolClassSummary.class);
        while (it.hasNext()) {
            SchoolClassSummary schoolClassSummary = (SchoolClassSummary) it.next();
            if (!map2.containsKey(schoolClassSummary)) {
                long j;
                if (schoolClassSummary instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) schoolClassSummary;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(schoolClassSummary, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(schoolClassSummary, Long.valueOf(createRow));
                SchoolClassSummaryRealmProxyInterface schoolClassSummaryRealmProxyInterface = schoolClassSummary;
                Number realmGet$schoolCode = schoolClassSummaryRealmProxyInterface.realmGet$schoolCode();
                if (realmGet$schoolCode != null) {
                    j = createRow;
                    Table.nativeSetLong(nativePtr, schoolClassSummaryColumnInfo.schoolCodeIndex, createRow, realmGet$schoolCode.longValue(), false);
                } else {
                    j = createRow;
                }
                String realmGet$schoolName = schoolClassSummaryRealmProxyInterface.realmGet$schoolName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolClassSummaryColumnInfo.schoolNameIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolCode = schoolClassSummaryRealmProxyInterface.realmGet$studentID();
                if (realmGet$schoolCode != null) {
                    Table.nativeSetLong(nativePtr, schoolClassSummaryColumnInfo.studentIDIndex, j, realmGet$schoolCode.longValue(), false);
                }
                long j2 = nativePtr;
                long j3 = j;
                Table.nativeSetBoolean(j2, schoolClassSummaryColumnInfo.showPeriodIndex, j3, schoolClassSummaryRealmProxyInterface.realmGet$showPeriod(), false);
                Table.nativeSetBoolean(j2, schoolClassSummaryColumnInfo.hideScoresIndex, j3, schoolClassSummaryRealmProxyInterface.realmGet$hideScores(), false);
                RealmList realmGet$classSummaries = schoolClassSummaryRealmProxyInterface.realmGet$classSummaries();
                if (realmGet$classSummaries != null) {
                    j2 = Table.nativeGetLinkView(nativePtr, schoolClassSummaryColumnInfo.classSummariesIndex, j);
                    Iterator it2 = realmGet$classSummaries.iterator();
                    while (it2.hasNext()) {
                        ClassSummary classSummary = (ClassSummary) it2.next();
                        Long l = (Long) map2.get(classSummary);
                        if (l == null) {
                            l = Long.valueOf(ClassSummaryRealmProxy.insert(realm2, classSummary, map2));
                        }
                        LinkView.nativeAdd(j2, l.longValue());
                    }
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, SchoolClassSummary schoolClassSummary, Map<RealmModel, Long> map) {
        long j;
        Realm realm2 = realm;
        SchoolClassSummary schoolClassSummary2 = schoolClassSummary;
        Map map2 = map;
        if (schoolClassSummary2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) schoolClassSummary2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(SchoolClassSummary.class);
        long nativePtr = table.getNativePtr();
        SchoolClassSummaryColumnInfo schoolClassSummaryColumnInfo = (SchoolClassSummaryColumnInfo) realm2.schema.getColumnInfo(SchoolClassSummary.class);
        long createRow = OsObject.createRow(table);
        map2.put(schoolClassSummary2, Long.valueOf(createRow));
        SchoolClassSummaryRealmProxyInterface schoolClassSummaryRealmProxyInterface = schoolClassSummary2;
        Number realmGet$schoolCode = schoolClassSummaryRealmProxyInterface.realmGet$schoolCode();
        if (realmGet$schoolCode != null) {
            j = createRow;
            Table.nativeSetLong(nativePtr, schoolClassSummaryColumnInfo.schoolCodeIndex, createRow, realmGet$schoolCode.longValue(), false);
        } else {
            j = createRow;
            Table.nativeSetNull(nativePtr, schoolClassSummaryColumnInfo.schoolCodeIndex, j, false);
        }
        String realmGet$schoolName = schoolClassSummaryRealmProxyInterface.realmGet$schoolName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, schoolClassSummaryColumnInfo.schoolNameIndex, j, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, schoolClassSummaryColumnInfo.schoolNameIndex, j, false);
        }
        realmGet$schoolCode = schoolClassSummaryRealmProxyInterface.realmGet$studentID();
        if (realmGet$schoolCode != null) {
            Table.nativeSetLong(nativePtr, schoolClassSummaryColumnInfo.studentIDIndex, j, realmGet$schoolCode.longValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, schoolClassSummaryColumnInfo.studentIDIndex, j, false);
        }
        long j2 = nativePtr;
        long j3 = j;
        Table.nativeSetBoolean(j2, schoolClassSummaryColumnInfo.showPeriodIndex, j3, schoolClassSummaryRealmProxyInterface.realmGet$showPeriod(), false);
        Table.nativeSetBoolean(j2, schoolClassSummaryColumnInfo.hideScoresIndex, j3, schoolClassSummaryRealmProxyInterface.realmGet$hideScores(), false);
        long nativeGetLinkView = Table.nativeGetLinkView(j2, schoolClassSummaryColumnInfo.classSummariesIndex, j3);
        LinkView.nativeClear(nativeGetLinkView);
        RealmList realmGet$classSummaries = schoolClassSummaryRealmProxyInterface.realmGet$classSummaries();
        if (realmGet$classSummaries != null) {
            Iterator it = realmGet$classSummaries.iterator();
            while (it.hasNext()) {
                ClassSummary classSummary = (ClassSummary) it.next();
                Long l = (Long) map2.get(classSummary);
                if (l == null) {
                    l = Long.valueOf(ClassSummaryRealmProxy.insertOrUpdate(realm2, classSummary, map2));
                }
                LinkView.nativeAdd(nativeGetLinkView, l.longValue());
            }
        }
        return j;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map map2 = map;
        Table table = realm2.getTable(SchoolClassSummary.class);
        long nativePtr = table.getNativePtr();
        SchoolClassSummaryColumnInfo schoolClassSummaryColumnInfo = (SchoolClassSummaryColumnInfo) realm2.schema.getColumnInfo(SchoolClassSummary.class);
        while (it.hasNext()) {
            SchoolClassSummary schoolClassSummary = (SchoolClassSummary) it.next();
            if (!map2.containsKey(schoolClassSummary)) {
                long j;
                if (schoolClassSummary instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) schoolClassSummary;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(schoolClassSummary, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(schoolClassSummary, Long.valueOf(createRow));
                SchoolClassSummaryRealmProxyInterface schoolClassSummaryRealmProxyInterface = schoolClassSummary;
                Number realmGet$schoolCode = schoolClassSummaryRealmProxyInterface.realmGet$schoolCode();
                if (realmGet$schoolCode != null) {
                    j = createRow;
                    Table.nativeSetLong(nativePtr, schoolClassSummaryColumnInfo.schoolCodeIndex, createRow, realmGet$schoolCode.longValue(), false);
                } else {
                    j = createRow;
                    Table.nativeSetNull(nativePtr, schoolClassSummaryColumnInfo.schoolCodeIndex, j, false);
                }
                String realmGet$schoolName = schoolClassSummaryRealmProxyInterface.realmGet$schoolName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, schoolClassSummaryColumnInfo.schoolNameIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolClassSummaryColumnInfo.schoolNameIndex, j, false);
                }
                realmGet$schoolCode = schoolClassSummaryRealmProxyInterface.realmGet$studentID();
                if (realmGet$schoolCode != null) {
                    Table.nativeSetLong(nativePtr, schoolClassSummaryColumnInfo.studentIDIndex, j, realmGet$schoolCode.longValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, schoolClassSummaryColumnInfo.studentIDIndex, j, false);
                }
                long j2 = nativePtr;
                long j3 = j;
                Table.nativeSetBoolean(j2, schoolClassSummaryColumnInfo.showPeriodIndex, j3, schoolClassSummaryRealmProxyInterface.realmGet$showPeriod(), false);
                Table.nativeSetBoolean(j2, schoolClassSummaryColumnInfo.hideScoresIndex, j3, schoolClassSummaryRealmProxyInterface.realmGet$hideScores(), false);
                j2 = Table.nativeGetLinkView(j2, schoolClassSummaryColumnInfo.classSummariesIndex, j3);
                LinkView.nativeClear(j2);
                RealmList realmGet$classSummaries = schoolClassSummaryRealmProxyInterface.realmGet$classSummaries();
                if (realmGet$classSummaries != null) {
                    Iterator it2 = realmGet$classSummaries.iterator();
                    while (it2.hasNext()) {
                        ClassSummary classSummary = (ClassSummary) it2.next();
                        Long l = (Long) map2.get(classSummary);
                        if (l == null) {
                            l = Long.valueOf(ClassSummaryRealmProxy.insertOrUpdate(realm2, classSummary, map2));
                        }
                        LinkView.nativeAdd(j2, l.longValue());
                    }
                }
            }
        }
    }

    public static SchoolClassSummary createDetachedCopy(SchoolClassSummary schoolClassSummary, int i, int i2, Map<RealmModel, CacheData<RealmModel>> map) {
        if (i <= i2) {
            if (schoolClassSummary != null) {
                SchoolClassSummary schoolClassSummary2;
                CacheData cacheData = (CacheData) map.get(schoolClassSummary);
                if (cacheData == null) {
                    schoolClassSummary2 = new SchoolClassSummary();
                    map.put(schoolClassSummary, new CacheData(i, schoolClassSummary2));
                } else if (i >= cacheData.minDepth) {
                    return cacheData.object;
                } else {
                    SchoolClassSummary schoolClassSummary3 = (SchoolClassSummary) cacheData.object;
                    cacheData.minDepth = i;
                    schoolClassSummary2 = schoolClassSummary3;
                }
                SchoolClassSummaryRealmProxyInterface schoolClassSummaryRealmProxyInterface = schoolClassSummary2;
                SchoolClassSummaryRealmProxyInterface schoolClassSummaryRealmProxyInterface2 = schoolClassSummary;
                schoolClassSummaryRealmProxyInterface.realmSet$schoolCode(schoolClassSummaryRealmProxyInterface2.realmGet$schoolCode());
                schoolClassSummaryRealmProxyInterface.realmSet$schoolName(schoolClassSummaryRealmProxyInterface2.realmGet$schoolName());
                schoolClassSummaryRealmProxyInterface.realmSet$studentID(schoolClassSummaryRealmProxyInterface2.realmGet$studentID());
                schoolClassSummaryRealmProxyInterface.realmSet$showPeriod(schoolClassSummaryRealmProxyInterface2.realmGet$showPeriod());
                schoolClassSummaryRealmProxyInterface.realmSet$hideScores(schoolClassSummaryRealmProxyInterface2.realmGet$hideScores());
                if (i == i2) {
                    schoolClassSummaryRealmProxyInterface.realmSet$classSummaries(null);
                } else {
                    schoolClassSummary = schoolClassSummaryRealmProxyInterface2.realmGet$classSummaries();
                    RealmList realmList = new RealmList();
                    schoolClassSummaryRealmProxyInterface.realmSet$classSummaries(realmList);
                    i++;
                    int size = schoolClassSummary.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        realmList.add(ClassSummaryRealmProxy.createDetachedCopy((ClassSummary) schoolClassSummary.get(i3), i, i2, map));
                    }
                }
                return schoolClassSummary2;
            }
        }
        return null;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("SchoolClassSummary = proxy[");
        stringBuilder.append("{schoolCode:");
        stringBuilder.append(realmGet$schoolCode() != null ? realmGet$schoolCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{schoolName:");
        stringBuilder.append(realmGet$schoolName() != null ? realmGet$schoolName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{studentID:");
        stringBuilder.append(realmGet$studentID() != null ? realmGet$studentID() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{showPeriod:");
        stringBuilder.append(realmGet$showPeriod());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{hideScores:");
        stringBuilder.append(realmGet$hideScores());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{classSummaries:");
        stringBuilder.append("RealmList<ClassSummary>[");
        stringBuilder.append(realmGet$classSummaries().size());
        stringBuilder.append("]");
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
        r7 = (io.realm.SchoolClassSummaryRealmProxy) r7;
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
        throw new UnsupportedOperationException("Method not decompiled: io.realm.SchoolClassSummaryRealmProxy.equals(java.lang.Object):boolean");
    }
}
