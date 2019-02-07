package io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.aeries.mobileportal.models.CalculateScoreRequest;
import com.aeries.mobileportal.models.MockGradebook;
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

public class CalculateScoreRequestRealmProxy extends CalculateScoreRequest implements RealmObjectProxy, CalculateScoreRequestRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private CalculateScoreRequestColumnInfo columnInfo;
    private ProxyState<CalculateScoreRequest> proxyState;

    static final class CalculateScoreRequestColumnInfo extends ColumnInfo {
        long gradebookIndex;
        long schoolNumberIndex;
        long studentIdIndex;

        CalculateScoreRequestColumnInfo(SharedRealm sharedRealm, Table table) {
            super(3);
            this.schoolNumberIndex = addColumnDetails(table, "schoolNumber", RealmFieldType.STRING);
            this.studentIdIndex = addColumnDetails(table, "studentId", RealmFieldType.STRING);
            this.gradebookIndex = addColumnDetails(table, "gradebook", RealmFieldType.OBJECT);
        }

        CalculateScoreRequestColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        protected final ColumnInfo copy(boolean z) {
            return new CalculateScoreRequestColumnInfo((ColumnInfo) this, z);
        }

        protected final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            CalculateScoreRequestColumnInfo calculateScoreRequestColumnInfo = (CalculateScoreRequestColumnInfo) columnInfo;
            CalculateScoreRequestColumnInfo calculateScoreRequestColumnInfo2 = (CalculateScoreRequestColumnInfo) columnInfo2;
            calculateScoreRequestColumnInfo2.schoolNumberIndex = calculateScoreRequestColumnInfo.schoolNumberIndex;
            calculateScoreRequestColumnInfo2.studentIdIndex = calculateScoreRequestColumnInfo.studentIdIndex;
            calculateScoreRequestColumnInfo2.gradebookIndex = calculateScoreRequestColumnInfo.gradebookIndex;
        }
    }

    public static String getTableName() {
        return "class_CalculateScoreRequest";
    }

    static {
        List arrayList = new ArrayList();
        arrayList.add("schoolNumber");
        arrayList.add("studentId");
        arrayList.add("gradebook");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    CalculateScoreRequestRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (CalculateScoreRequestColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$schoolNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.schoolNumberIndex);
    }

    public void realmSet$schoolNumber(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.schoolNumberIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.schoolNumberIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.schoolNumberIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.schoolNumberIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$studentId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.studentIdIndex);
    }

    public void realmSet$studentId(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.studentIdIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.studentIdIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.studentIdIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.studentIdIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public MockGradebook realmGet$gradebook() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNullLink(this.columnInfo.gradebookIndex)) {
            return null;
        }
        return (MockGradebook) this.proxyState.getRealm$realm().get(MockGradebook.class, this.proxyState.getRow$realm().getLink(this.columnInfo.gradebookIndex), false, Collections.emptyList());
    }

    public void realmSet$gradebook(MockGradebook mockGradebook) {
        RealmObjectProxy realmObjectProxy;
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (mockGradebook == null) {
                this.proxyState.getRow$realm().nullifyLink(this.columnInfo.gradebookIndex);
            } else if (RealmObject.isManaged(mockGradebook) && RealmObject.isValid(mockGradebook)) {
                realmObjectProxy = (RealmObjectProxy) mockGradebook;
                if (realmObjectProxy.realmGet$proxyState().getRealm$realm() == this.proxyState.getRealm$realm()) {
                    this.proxyState.getRow$realm().setLink(this.columnInfo.gradebookIndex, realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex());
                    return;
                }
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            } else {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm() && !this.proxyState.getExcludeFields$realm().contains("gradebook")) {
            if (!(mockGradebook == null || RealmObject.isManaged(mockGradebook))) {
                mockGradebook = (MockGradebook) ((Realm) this.proxyState.getRealm$realm()).copyToRealm((RealmModel) mockGradebook);
            }
            Row row$realm = this.proxyState.getRow$realm();
            if (mockGradebook == null) {
                row$realm.nullifyLink(this.columnInfo.gradebookIndex);
            } else if (RealmObject.isValid(mockGradebook)) {
                realmObjectProxy = (RealmObjectProxy) mockGradebook;
                if (realmObjectProxy.realmGet$proxyState().getRealm$realm() == this.proxyState.getRealm$realm()) {
                    row$realm.getTable().setLink(this.columnInfo.gradebookIndex, row$realm.getIndex(), realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex(), true);
                    return;
                }
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            } else {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        Builder builder = new Builder("CalculateScoreRequest");
        Builder builder2 = builder;
        builder2.addProperty("schoolNumber", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("studentId", RealmFieldType.STRING, false, false, false);
        builder.addLinkedProperty("gradebook", RealmFieldType.OBJECT, "MockGradebook");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static CalculateScoreRequestColumnInfo validateTable(SharedRealm sharedRealm, boolean z) {
        if (sharedRealm.hasTable("class_CalculateScoreRequest")) {
            Table table = sharedRealm.getTable("class_CalculateScoreRequest");
            long columnCount = table.getColumnCount();
            if (columnCount != 3) {
                StringBuilder stringBuilder;
                if (columnCount < 3) {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is less than expected - expected 3 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                } else if (z) {
                    RealmLog.debug("Field count is more than expected - expected 3 but was %1$d", Long.valueOf(columnCount));
                } else {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is more than expected - expected 3 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                }
            }
            z = new HashMap();
            for (long j = 0; j < columnCount; j++) {
                z.put(table.getColumnName(j), table.getColumnType(j));
            }
            CalculateScoreRequestColumnInfo calculateScoreRequestColumnInfo = new CalculateScoreRequestColumnInfo(sharedRealm, table);
            if (table.hasPrimaryKey()) {
                sharedRealm = sharedRealm.getPath();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Primary Key defined for field ");
                stringBuilder2.append(table.getColumnName(table.getPrimaryKey()));
                stringBuilder2.append(" was removed.");
                throw new RealmMigrationNeededException(sharedRealm, stringBuilder2.toString());
            } else if (!z.containsKey("schoolNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'schoolNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("schoolNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'schoolNumber' in existing Realm file.");
            } else if (!table.isColumnNullable(calculateScoreRequestColumnInfo.schoolNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'schoolNumber' is required. Either set @Required to field 'schoolNumber' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("studentId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'studentId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("studentId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'studentId' in existing Realm file.");
            } else if (!table.isColumnNullable(calculateScoreRequestColumnInfo.studentIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'studentId' is required. Either set @Required to field 'studentId' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("gradebook")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'gradebook' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("gradebook") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'MockGradebook' for field 'gradebook'");
            } else if (sharedRealm.hasTable("class_MockGradebook")) {
                z = sharedRealm.getTable("class_MockGradebook");
                if (table.getLinkTarget(calculateScoreRequestColumnInfo.gradebookIndex).hasSameSchema(z)) {
                    return calculateScoreRequestColumnInfo;
                }
                sharedRealm = sharedRealm.getPath();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Invalid RealmObject for field 'gradebook': '");
                stringBuilder3.append(table.getLinkTarget(calculateScoreRequestColumnInfo.gradebookIndex).getName());
                stringBuilder3.append("' expected - was '");
                stringBuilder3.append(z.getName());
                stringBuilder3.append("'");
                throw new RealmMigrationNeededException(sharedRealm, stringBuilder3.toString());
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_MockGradebook' for field 'gradebook'");
            }
        }
        throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'CalculateScoreRequest' class is missing from the schema for this Realm.");
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static CalculateScoreRequest createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        List arrayList = new ArrayList(1);
        if (jSONObject.has("gradebook")) {
            arrayList.add("gradebook");
        }
        CalculateScoreRequest calculateScoreRequest = (CalculateScoreRequest) realm.createObjectInternal(CalculateScoreRequest.class, true, arrayList);
        if (jSONObject.has("schoolNumber")) {
            if (jSONObject.isNull("schoolNumber")) {
                calculateScoreRequest.realmSet$schoolNumber(null);
            } else {
                calculateScoreRequest.realmSet$schoolNumber(jSONObject.getString("schoolNumber"));
            }
        }
        if (jSONObject.has("studentId")) {
            if (jSONObject.isNull("studentId")) {
                calculateScoreRequest.realmSet$studentId(null);
            } else {
                calculateScoreRequest.realmSet$studentId(jSONObject.getString("studentId"));
            }
        }
        if (jSONObject.has("gradebook")) {
            if (jSONObject.isNull("gradebook")) {
                calculateScoreRequest.realmSet$gradebook(null);
            } else {
                calculateScoreRequest.realmSet$gradebook(MockGradebookRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject.getJSONObject("gradebook"), z));
            }
        }
        return calculateScoreRequest;
    }

    @TargetApi(11)
    public static CalculateScoreRequest createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RealmModel calculateScoreRequest = new CalculateScoreRequest();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("schoolNumber")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((CalculateScoreRequestRealmProxyInterface) calculateScoreRequest).realmSet$schoolNumber(null);
                } else {
                    ((CalculateScoreRequestRealmProxyInterface) calculateScoreRequest).realmSet$schoolNumber(jsonReader.nextString());
                }
            } else if (nextName.equals("studentId")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((CalculateScoreRequestRealmProxyInterface) calculateScoreRequest).realmSet$studentId(null);
                } else {
                    ((CalculateScoreRequestRealmProxyInterface) calculateScoreRequest).realmSet$studentId(jsonReader.nextString());
                }
            } else if (!nextName.equals("gradebook")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.skipValue();
                ((CalculateScoreRequestRealmProxyInterface) calculateScoreRequest).realmSet$gradebook(null);
            } else {
                ((CalculateScoreRequestRealmProxyInterface) calculateScoreRequest).realmSet$gradebook(MockGradebookRealmProxy.createUsingJsonStream(realm, jsonReader));
            }
        }
        jsonReader.endObject();
        return (CalculateScoreRequest) realm.copyToRealm(calculateScoreRequest);
    }

    public static CalculateScoreRequest copyOrUpdate(Realm realm, CalculateScoreRequest calculateScoreRequest, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy;
        boolean z2 = calculateScoreRequest instanceof RealmObjectProxy;
        if (z2) {
            RealmObjectProxy realmObjectProxy2 = (RealmObjectProxy) calculateScoreRequest;
            if (realmObjectProxy2.realmGet$proxyState().getRealm$realm() != null) {
                if (realmObjectProxy2.realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                }
            }
        }
        if (z2) {
            realmObjectProxy = (RealmObjectProxy) calculateScoreRequest;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return calculateScoreRequest;
            }
        }
        RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectProxy = (RealmObjectProxy) map.get(calculateScoreRequest);
        if (realmObjectProxy != null) {
            return (CalculateScoreRequest) realmObjectProxy;
        }
        return copy(realm, calculateScoreRequest, z, map);
    }

    public static CalculateScoreRequest copy(Realm realm, CalculateScoreRequest calculateScoreRequest, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = (RealmObjectProxy) map.get(calculateScoreRequest);
        if (realmObjectProxy != null) {
            return (CalculateScoreRequest) realmObjectProxy;
        }
        CalculateScoreRequest calculateScoreRequest2 = (CalculateScoreRequest) realm.createObjectInternal(CalculateScoreRequest.class, false, Collections.emptyList());
        map.put(calculateScoreRequest, (RealmObjectProxy) calculateScoreRequest2);
        CalculateScoreRequestRealmProxyInterface calculateScoreRequestRealmProxyInterface = calculateScoreRequest;
        CalculateScoreRequestRealmProxyInterface calculateScoreRequestRealmProxyInterface2 = calculateScoreRequest2;
        calculateScoreRequestRealmProxyInterface2.realmSet$schoolNumber(calculateScoreRequestRealmProxyInterface.realmGet$schoolNumber());
        calculateScoreRequestRealmProxyInterface2.realmSet$studentId(calculateScoreRequestRealmProxyInterface.realmGet$studentId());
        calculateScoreRequest = calculateScoreRequestRealmProxyInterface.realmGet$gradebook();
        if (calculateScoreRequest == null) {
            calculateScoreRequestRealmProxyInterface2.realmSet$gradebook(null);
        } else {
            MockGradebook mockGradebook = (MockGradebook) map.get(calculateScoreRequest);
            if (mockGradebook != null) {
                calculateScoreRequestRealmProxyInterface2.realmSet$gradebook(mockGradebook);
            } else {
                calculateScoreRequestRealmProxyInterface2.realmSet$gradebook(MockGradebookRealmProxy.copyOrUpdate(realm, calculateScoreRequest, z, map));
            }
        }
        return calculateScoreRequest2;
    }

    public static long insert(Realm realm, CalculateScoreRequest calculateScoreRequest, Map<RealmModel, Long> map) {
        long j;
        Realm realm2 = realm;
        CalculateScoreRequest calculateScoreRequest2 = calculateScoreRequest;
        Map map2 = map;
        if (calculateScoreRequest2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) calculateScoreRequest2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(CalculateScoreRequest.class);
        long nativePtr = table.getNativePtr();
        CalculateScoreRequestColumnInfo calculateScoreRequestColumnInfo = (CalculateScoreRequestColumnInfo) realm2.schema.getColumnInfo(CalculateScoreRequest.class);
        long createRow = OsObject.createRow(table);
        map2.put(calculateScoreRequest2, Long.valueOf(createRow));
        CalculateScoreRequestRealmProxyInterface calculateScoreRequestRealmProxyInterface = calculateScoreRequest2;
        String realmGet$schoolNumber = calculateScoreRequestRealmProxyInterface.realmGet$schoolNumber();
        if (realmGet$schoolNumber != null) {
            j = createRow;
            Table.nativeSetString(nativePtr, calculateScoreRequestColumnInfo.schoolNumberIndex, createRow, realmGet$schoolNumber, false);
        } else {
            j = createRow;
        }
        String realmGet$studentId = calculateScoreRequestRealmProxyInterface.realmGet$studentId();
        if (realmGet$studentId != null) {
            Table.nativeSetString(nativePtr, calculateScoreRequestColumnInfo.studentIdIndex, j, realmGet$studentId, false);
        }
        MockGradebook realmGet$gradebook = calculateScoreRequestRealmProxyInterface.realmGet$gradebook();
        if (realmGet$gradebook != null) {
            Long l = (Long) map2.get(realmGet$gradebook);
            if (l == null) {
                l = Long.valueOf(MockGradebookRealmProxy.insert(realm2, realmGet$gradebook, map2));
            }
            Table.nativeSetLink(nativePtr, calculateScoreRequestColumnInfo.gradebookIndex, j, l.longValue(), false);
        }
        return j;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map map2 = map;
        Table table = realm2.getTable(CalculateScoreRequest.class);
        long nativePtr = table.getNativePtr();
        CalculateScoreRequestColumnInfo calculateScoreRequestColumnInfo = (CalculateScoreRequestColumnInfo) realm2.schema.getColumnInfo(CalculateScoreRequest.class);
        while (it.hasNext()) {
            CalculateScoreRequest calculateScoreRequest = (CalculateScoreRequest) it.next();
            if (!map2.containsKey(calculateScoreRequest)) {
                Table table2;
                CalculateScoreRequestRealmProxyInterface calculateScoreRequestRealmProxyInterface;
                if (calculateScoreRequest instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) calculateScoreRequest;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(calculateScoreRequest, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(calculateScoreRequest, Long.valueOf(createRow));
                CalculateScoreRequestRealmProxyInterface calculateScoreRequestRealmProxyInterface2 = calculateScoreRequest;
                String realmGet$schoolNumber = calculateScoreRequestRealmProxyInterface2.realmGet$schoolNumber();
                if (realmGet$schoolNumber != null) {
                    table2 = table;
                    calculateScoreRequestRealmProxyInterface = calculateScoreRequestRealmProxyInterface2;
                    Table.nativeSetString(nativePtr, calculateScoreRequestColumnInfo.schoolNumberIndex, createRow, realmGet$schoolNumber, false);
                } else {
                    table2 = table;
                    calculateScoreRequestRealmProxyInterface = calculateScoreRequestRealmProxyInterface2;
                }
                realmGet$schoolNumber = calculateScoreRequestRealmProxyInterface.realmGet$studentId();
                if (realmGet$schoolNumber != null) {
                    Table.nativeSetString(nativePtr, calculateScoreRequestColumnInfo.studentIdIndex, createRow, realmGet$schoolNumber, false);
                }
                MockGradebook realmGet$gradebook = calculateScoreRequestRealmProxyInterface.realmGet$gradebook();
                if (realmGet$gradebook != null) {
                    Long l = (Long) map2.get(realmGet$gradebook);
                    if (l == null) {
                        l = Long.valueOf(MockGradebookRealmProxy.insert(realm2, realmGet$gradebook, map2));
                    }
                    table2.setLink(calculateScoreRequestColumnInfo.gradebookIndex, createRow, l.longValue(), false);
                }
                table = table2;
            }
        }
    }

    public static long insertOrUpdate(Realm realm, CalculateScoreRequest calculateScoreRequest, Map<RealmModel, Long> map) {
        long j;
        Realm realm2 = realm;
        CalculateScoreRequest calculateScoreRequest2 = calculateScoreRequest;
        Map map2 = map;
        if (calculateScoreRequest2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) calculateScoreRequest2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(CalculateScoreRequest.class);
        long nativePtr = table.getNativePtr();
        CalculateScoreRequestColumnInfo calculateScoreRequestColumnInfo = (CalculateScoreRequestColumnInfo) realm2.schema.getColumnInfo(CalculateScoreRequest.class);
        long createRow = OsObject.createRow(table);
        map2.put(calculateScoreRequest2, Long.valueOf(createRow));
        CalculateScoreRequestRealmProxyInterface calculateScoreRequestRealmProxyInterface = calculateScoreRequest2;
        String realmGet$schoolNumber = calculateScoreRequestRealmProxyInterface.realmGet$schoolNumber();
        if (realmGet$schoolNumber != null) {
            j = createRow;
            Table.nativeSetString(nativePtr, calculateScoreRequestColumnInfo.schoolNumberIndex, createRow, realmGet$schoolNumber, false);
        } else {
            j = createRow;
            Table.nativeSetNull(nativePtr, calculateScoreRequestColumnInfo.schoolNumberIndex, j, false);
        }
        String realmGet$studentId = calculateScoreRequestRealmProxyInterface.realmGet$studentId();
        if (realmGet$studentId != null) {
            Table.nativeSetString(nativePtr, calculateScoreRequestColumnInfo.studentIdIndex, j, realmGet$studentId, false);
        } else {
            Table.nativeSetNull(nativePtr, calculateScoreRequestColumnInfo.studentIdIndex, j, false);
        }
        MockGradebook realmGet$gradebook = calculateScoreRequestRealmProxyInterface.realmGet$gradebook();
        if (realmGet$gradebook != null) {
            Long l = (Long) map2.get(realmGet$gradebook);
            if (l == null) {
                l = Long.valueOf(MockGradebookRealmProxy.insertOrUpdate(realm2, realmGet$gradebook, map2));
            }
            Table.nativeSetLink(nativePtr, calculateScoreRequestColumnInfo.gradebookIndex, j, l.longValue(), false);
        } else {
            Table.nativeNullifyLink(nativePtr, calculateScoreRequestColumnInfo.gradebookIndex, j);
        }
        return j;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map map2 = map;
        Table table = realm2.getTable(CalculateScoreRequest.class);
        long nativePtr = table.getNativePtr();
        CalculateScoreRequestColumnInfo calculateScoreRequestColumnInfo = (CalculateScoreRequestColumnInfo) realm2.schema.getColumnInfo(CalculateScoreRequest.class);
        while (it.hasNext()) {
            CalculateScoreRequest calculateScoreRequest = (CalculateScoreRequest) it.next();
            if (!map2.containsKey(calculateScoreRequest)) {
                long j;
                if (calculateScoreRequest instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) calculateScoreRequest;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(calculateScoreRequest, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(calculateScoreRequest, Long.valueOf(createRow));
                CalculateScoreRequestRealmProxyInterface calculateScoreRequestRealmProxyInterface = calculateScoreRequest;
                String realmGet$schoolNumber = calculateScoreRequestRealmProxyInterface.realmGet$schoolNumber();
                if (realmGet$schoolNumber != null) {
                    j = createRow;
                    Table.nativeSetString(nativePtr, calculateScoreRequestColumnInfo.schoolNumberIndex, createRow, realmGet$schoolNumber, false);
                } else {
                    j = createRow;
                    Table.nativeSetNull(nativePtr, calculateScoreRequestColumnInfo.schoolNumberIndex, j, false);
                }
                realmGet$schoolNumber = calculateScoreRequestRealmProxyInterface.realmGet$studentId();
                if (realmGet$schoolNumber != null) {
                    Table.nativeSetString(nativePtr, calculateScoreRequestColumnInfo.studentIdIndex, j, realmGet$schoolNumber, false);
                } else {
                    Table.nativeSetNull(nativePtr, calculateScoreRequestColumnInfo.studentIdIndex, j, false);
                }
                MockGradebook realmGet$gradebook = calculateScoreRequestRealmProxyInterface.realmGet$gradebook();
                if (realmGet$gradebook != null) {
                    Long l = (Long) map2.get(realmGet$gradebook);
                    if (l == null) {
                        l = Long.valueOf(MockGradebookRealmProxy.insertOrUpdate(realm2, realmGet$gradebook, map2));
                    }
                    Table.nativeSetLink(nativePtr, calculateScoreRequestColumnInfo.gradebookIndex, j, l.longValue(), false);
                } else {
                    Table.nativeNullifyLink(nativePtr, calculateScoreRequestColumnInfo.gradebookIndex, j);
                }
            }
        }
    }

    public static CalculateScoreRequest createDetachedCopy(CalculateScoreRequest calculateScoreRequest, int i, int i2, Map<RealmModel, CacheData<RealmModel>> map) {
        if (i <= i2) {
            if (calculateScoreRequest != null) {
                CalculateScoreRequest calculateScoreRequest2;
                CacheData cacheData = (CacheData) map.get(calculateScoreRequest);
                if (cacheData == null) {
                    calculateScoreRequest2 = new CalculateScoreRequest();
                    map.put(calculateScoreRequest, new CacheData(i, calculateScoreRequest2));
                } else if (i >= cacheData.minDepth) {
                    return cacheData.object;
                } else {
                    CalculateScoreRequest calculateScoreRequest3 = (CalculateScoreRequest) cacheData.object;
                    cacheData.minDepth = i;
                    calculateScoreRequest2 = calculateScoreRequest3;
                }
                CalculateScoreRequestRealmProxyInterface calculateScoreRequestRealmProxyInterface = calculateScoreRequest2;
                CalculateScoreRequestRealmProxyInterface calculateScoreRequestRealmProxyInterface2 = calculateScoreRequest;
                calculateScoreRequestRealmProxyInterface.realmSet$schoolNumber(calculateScoreRequestRealmProxyInterface2.realmGet$schoolNumber());
                calculateScoreRequestRealmProxyInterface.realmSet$studentId(calculateScoreRequestRealmProxyInterface2.realmGet$studentId());
                calculateScoreRequestRealmProxyInterface.realmSet$gradebook(MockGradebookRealmProxy.createDetachedCopy(calculateScoreRequestRealmProxyInterface2.realmGet$gradebook(), i + 1, i2, map));
                return calculateScoreRequest2;
            }
        }
        return null;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("CalculateScoreRequest = proxy[");
        stringBuilder.append("{schoolNumber:");
        stringBuilder.append(realmGet$schoolNumber() != null ? realmGet$schoolNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{studentId:");
        stringBuilder.append(realmGet$studentId() != null ? realmGet$studentId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{gradebook:");
        stringBuilder.append(realmGet$gradebook() != null ? "MockGradebook" : "null");
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
        r7 = (io.realm.CalculateScoreRequestRealmProxy) r7;
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
        throw new UnsupportedOperationException("Method not decompiled: io.realm.CalculateScoreRequestRealmProxy.equals(java.lang.Object):boolean");
    }
}
