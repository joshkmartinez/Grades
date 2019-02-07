package io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.aeries.mobileportal.models.MockAssignment;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
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

public class MockAssignmentRealmProxy extends MockAssignment implements RealmObjectProxy, MockAssignmentRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private MockAssignmentColumnInfo columnInfo;
    private ProxyState<MockAssignment> proxyState;

    static final class MockAssignmentColumnInfo extends ColumnInfo {
        long assignmentNumberIndex;
        long categoryIndex;
        long markIndex;
        long maxScoreIndex;
        long scoreIndex;

        MockAssignmentColumnInfo(SharedRealm sharedRealm, Table table) {
            super(5);
            this.categoryIndex = addColumnDetails(table, "category", RealmFieldType.STRING);
            this.assignmentNumberIndex = addColumnDetails(table, "assignmentNumber", RealmFieldType.STRING);
            this.markIndex = addColumnDetails(table, "mark", RealmFieldType.STRING);
            this.scoreIndex = addColumnDetails(table, Param.SCORE, RealmFieldType.STRING);
            this.maxScoreIndex = addColumnDetails(table, "maxScore", RealmFieldType.STRING);
        }

        MockAssignmentColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        protected final ColumnInfo copy(boolean z) {
            return new MockAssignmentColumnInfo((ColumnInfo) this, z);
        }

        protected final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            MockAssignmentColumnInfo mockAssignmentColumnInfo = (MockAssignmentColumnInfo) columnInfo;
            MockAssignmentColumnInfo mockAssignmentColumnInfo2 = (MockAssignmentColumnInfo) columnInfo2;
            mockAssignmentColumnInfo2.categoryIndex = mockAssignmentColumnInfo.categoryIndex;
            mockAssignmentColumnInfo2.assignmentNumberIndex = mockAssignmentColumnInfo.assignmentNumberIndex;
            mockAssignmentColumnInfo2.markIndex = mockAssignmentColumnInfo.markIndex;
            mockAssignmentColumnInfo2.scoreIndex = mockAssignmentColumnInfo.scoreIndex;
            mockAssignmentColumnInfo2.maxScoreIndex = mockAssignmentColumnInfo.maxScoreIndex;
        }
    }

    public static String getTableName() {
        return "class_MockAssignment";
    }

    static {
        List arrayList = new ArrayList();
        arrayList.add("category");
        arrayList.add("assignmentNumber");
        arrayList.add("mark");
        arrayList.add(Param.SCORE);
        arrayList.add("maxScore");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    MockAssignmentRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (MockAssignmentColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$category() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.categoryIndex);
    }

    public void realmSet$category(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.categoryIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.categoryIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.categoryIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.categoryIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$assignmentNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.assignmentNumberIndex);
    }

    public void realmSet$assignmentNumber(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.assignmentNumberIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.assignmentNumberIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.assignmentNumberIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.assignmentNumberIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$mark() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.markIndex);
    }

    public void realmSet$mark(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.markIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.markIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.markIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.markIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$score() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.scoreIndex);
    }

    public void realmSet$score(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.scoreIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.scoreIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.scoreIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.scoreIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$maxScore() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.maxScoreIndex);
    }

    public void realmSet$maxScore(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.maxScoreIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.maxScoreIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.maxScoreIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.maxScoreIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        Builder builder = new Builder("MockAssignment");
        Builder builder2 = builder;
        builder2.addProperty("category", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("assignmentNumber", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("mark", RealmFieldType.STRING, false, false, false);
        builder2.addProperty(Param.SCORE, RealmFieldType.STRING, false, false, false);
        builder2.addProperty("maxScore", RealmFieldType.STRING, false, false, false);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static MockAssignmentColumnInfo validateTable(SharedRealm sharedRealm, boolean z) {
        if (sharedRealm.hasTable("class_MockAssignment")) {
            Table table = sharedRealm.getTable("class_MockAssignment");
            long columnCount = table.getColumnCount();
            if (columnCount != 5) {
                StringBuilder stringBuilder;
                if (columnCount < 5) {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is less than expected - expected 5 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                } else if (z) {
                    RealmLog.debug("Field count is more than expected - expected 5 but was %1$d", Long.valueOf(columnCount));
                } else {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is more than expected - expected 5 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                }
            }
            z = new HashMap();
            for (long j = 0; j < columnCount; j++) {
                z.put(table.getColumnName(j), table.getColumnType(j));
            }
            MockAssignmentColumnInfo mockAssignmentColumnInfo = new MockAssignmentColumnInfo(sharedRealm, table);
            if (table.hasPrimaryKey()) {
                sharedRealm = sharedRealm.getPath();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Primary Key defined for field ");
                stringBuilder2.append(table.getColumnName(table.getPrimaryKey()));
                stringBuilder2.append(" was removed.");
                throw new RealmMigrationNeededException(sharedRealm, stringBuilder2.toString());
            } else if (!z.containsKey("category")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'category' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("category") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'category' in existing Realm file.");
            } else if (!table.isColumnNullable(mockAssignmentColumnInfo.categoryIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'category' is required. Either set @Required to field 'category' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("assignmentNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'assignmentNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("assignmentNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'assignmentNumber' in existing Realm file.");
            } else if (!table.isColumnNullable(mockAssignmentColumnInfo.assignmentNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'assignmentNumber' is required. Either set @Required to field 'assignmentNumber' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("mark")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mark' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("mark") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'mark' in existing Realm file.");
            } else if (!table.isColumnNullable(mockAssignmentColumnInfo.markIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mark' is required. Either set @Required to field 'mark' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey(Param.SCORE)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'score' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get(Param.SCORE) != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'score' in existing Realm file.");
            } else if (!table.isColumnNullable(mockAssignmentColumnInfo.scoreIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'score' is required. Either set @Required to field 'score' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("maxScore")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'maxScore' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("maxScore") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'maxScore' in existing Realm file.");
            } else if (table.isColumnNullable(mockAssignmentColumnInfo.maxScoreIndex)) {
                return mockAssignmentColumnInfo;
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'maxScore' is required. Either set @Required to field 'maxScore' or migrate using RealmObjectSchema.setNullable().");
            }
        }
        throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'MockAssignment' class is missing from the schema for this Realm.");
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static MockAssignment createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        MockAssignment mockAssignment = (MockAssignment) realm.createObjectInternal(MockAssignment.class, true, Collections.emptyList());
        if (jSONObject.has("category")) {
            if (jSONObject.isNull("category")) {
                mockAssignment.realmSet$category(null);
            } else {
                mockAssignment.realmSet$category(jSONObject.getString("category"));
            }
        }
        if (jSONObject.has("assignmentNumber")) {
            if (jSONObject.isNull("assignmentNumber")) {
                mockAssignment.realmSet$assignmentNumber(null);
            } else {
                mockAssignment.realmSet$assignmentNumber(jSONObject.getString("assignmentNumber"));
            }
        }
        if (jSONObject.has("mark")) {
            if (jSONObject.isNull("mark")) {
                mockAssignment.realmSet$mark(null);
            } else {
                mockAssignment.realmSet$mark(jSONObject.getString("mark"));
            }
        }
        if (jSONObject.has(Param.SCORE)) {
            if (jSONObject.isNull(Param.SCORE)) {
                mockAssignment.realmSet$score(null);
            } else {
                mockAssignment.realmSet$score(jSONObject.getString(Param.SCORE));
            }
        }
        if (jSONObject.has("maxScore")) {
            if (jSONObject.isNull("maxScore")) {
                mockAssignment.realmSet$maxScore(null);
            } else {
                mockAssignment.realmSet$maxScore(jSONObject.getString("maxScore"));
            }
        }
        return mockAssignment;
    }

    @TargetApi(11)
    public static MockAssignment createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RealmModel mockAssignment = new MockAssignment();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("category")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((MockAssignmentRealmProxyInterface) mockAssignment).realmSet$category(null);
                } else {
                    ((MockAssignmentRealmProxyInterface) mockAssignment).realmSet$category(jsonReader.nextString());
                }
            } else if (nextName.equals("assignmentNumber")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((MockAssignmentRealmProxyInterface) mockAssignment).realmSet$assignmentNumber(null);
                } else {
                    ((MockAssignmentRealmProxyInterface) mockAssignment).realmSet$assignmentNumber(jsonReader.nextString());
                }
            } else if (nextName.equals("mark")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((MockAssignmentRealmProxyInterface) mockAssignment).realmSet$mark(null);
                } else {
                    ((MockAssignmentRealmProxyInterface) mockAssignment).realmSet$mark(jsonReader.nextString());
                }
            } else if (nextName.equals(Param.SCORE)) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((MockAssignmentRealmProxyInterface) mockAssignment).realmSet$score(null);
                } else {
                    ((MockAssignmentRealmProxyInterface) mockAssignment).realmSet$score(jsonReader.nextString());
                }
            } else if (!nextName.equals("maxScore")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.skipValue();
                ((MockAssignmentRealmProxyInterface) mockAssignment).realmSet$maxScore(null);
            } else {
                ((MockAssignmentRealmProxyInterface) mockAssignment).realmSet$maxScore(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return (MockAssignment) realm.copyToRealm(mockAssignment);
    }

    public static MockAssignment copyOrUpdate(Realm realm, MockAssignment mockAssignment, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy;
        boolean z2 = mockAssignment instanceof RealmObjectProxy;
        if (z2) {
            RealmObjectProxy realmObjectProxy2 = (RealmObjectProxy) mockAssignment;
            if (realmObjectProxy2.realmGet$proxyState().getRealm$realm() != null) {
                if (realmObjectProxy2.realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                }
            }
        }
        if (z2) {
            realmObjectProxy = (RealmObjectProxy) mockAssignment;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return mockAssignment;
            }
        }
        RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectProxy = (RealmObjectProxy) map.get(mockAssignment);
        if (realmObjectProxy != null) {
            return (MockAssignment) realmObjectProxy;
        }
        return copy(realm, mockAssignment, z, map);
    }

    public static MockAssignment copy(Realm realm, MockAssignment mockAssignment, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = (RealmObjectProxy) map.get(mockAssignment);
        if (realmObjectProxy != null) {
            return (MockAssignment) realmObjectProxy;
        }
        MockAssignment mockAssignment2 = (MockAssignment) realm.createObjectInternal(MockAssignment.class, false, Collections.emptyList());
        map.put(mockAssignment, (RealmObjectProxy) mockAssignment2);
        MockAssignmentRealmProxyInterface mockAssignmentRealmProxyInterface = mockAssignment;
        MockAssignmentRealmProxyInterface mockAssignmentRealmProxyInterface2 = mockAssignment2;
        mockAssignmentRealmProxyInterface2.realmSet$category(mockAssignmentRealmProxyInterface.realmGet$category());
        mockAssignmentRealmProxyInterface2.realmSet$assignmentNumber(mockAssignmentRealmProxyInterface.realmGet$assignmentNumber());
        mockAssignmentRealmProxyInterface2.realmSet$mark(mockAssignmentRealmProxyInterface.realmGet$mark());
        mockAssignmentRealmProxyInterface2.realmSet$score(mockAssignmentRealmProxyInterface.realmGet$score());
        mockAssignmentRealmProxyInterface2.realmSet$maxScore(mockAssignmentRealmProxyInterface.realmGet$maxScore());
        return mockAssignment2;
    }

    public static long insert(Realm realm, MockAssignment mockAssignment, Map<RealmModel, Long> map) {
        if (mockAssignment instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) mockAssignment;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm.getTable(MockAssignment.class);
        long nativePtr = table.getNativePtr();
        MockAssignmentColumnInfo mockAssignmentColumnInfo = (MockAssignmentColumnInfo) realm.schema.getColumnInfo(MockAssignment.class);
        long createRow = OsObject.createRow(table);
        map.put(mockAssignment, Long.valueOf(createRow));
        MockAssignmentRealmProxyInterface mockAssignmentRealmProxyInterface = mockAssignment;
        String realmGet$category = mockAssignmentRealmProxyInterface.realmGet$category();
        if (realmGet$category != null) {
            Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.categoryIndex, createRow, realmGet$category, false);
        }
        realmGet$category = mockAssignmentRealmProxyInterface.realmGet$assignmentNumber();
        if (realmGet$category != null) {
            Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.assignmentNumberIndex, createRow, realmGet$category, false);
        }
        realmGet$category = mockAssignmentRealmProxyInterface.realmGet$mark();
        if (realmGet$category != null) {
            Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.markIndex, createRow, realmGet$category, false);
        }
        realmGet$category = mockAssignmentRealmProxyInterface.realmGet$score();
        if (realmGet$category != null) {
            Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.scoreIndex, createRow, realmGet$category, false);
        }
        realmGet$category = mockAssignmentRealmProxyInterface.realmGet$maxScore();
        if (realmGet$category != null) {
            Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.maxScoreIndex, createRow, realmGet$category, false);
        }
        return createRow;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Table table = realm2.getTable(MockAssignment.class);
        long nativePtr = table.getNativePtr();
        MockAssignmentColumnInfo mockAssignmentColumnInfo = (MockAssignmentColumnInfo) realm2.schema.getColumnInfo(MockAssignment.class);
        while (it.hasNext()) {
            MockAssignment mockAssignment = (MockAssignment) it.next();
            if (!map2.containsKey(mockAssignment)) {
                MockAssignmentRealmProxyInterface mockAssignmentRealmProxyInterface;
                if (mockAssignment instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) mockAssignment;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(mockAssignment, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(mockAssignment, Long.valueOf(createRow));
                MockAssignmentRealmProxyInterface mockAssignmentRealmProxyInterface2 = mockAssignment;
                String realmGet$category = mockAssignmentRealmProxyInterface2.realmGet$category();
                if (realmGet$category != null) {
                    mockAssignmentRealmProxyInterface = mockAssignmentRealmProxyInterface2;
                    Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.categoryIndex, createRow, realmGet$category, false);
                } else {
                    mockAssignmentRealmProxyInterface = mockAssignmentRealmProxyInterface2;
                }
                realmGet$category = mockAssignmentRealmProxyInterface.realmGet$assignmentNumber();
                if (realmGet$category != null) {
                    Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.assignmentNumberIndex, createRow, realmGet$category, false);
                }
                realmGet$category = mockAssignmentRealmProxyInterface.realmGet$mark();
                if (realmGet$category != null) {
                    Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.markIndex, createRow, realmGet$category, false);
                }
                realmGet$category = mockAssignmentRealmProxyInterface.realmGet$score();
                if (realmGet$category != null) {
                    Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.scoreIndex, createRow, realmGet$category, false);
                }
                realmGet$category = mockAssignmentRealmProxyInterface.realmGet$maxScore();
                if (realmGet$category != null) {
                    Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.maxScoreIndex, createRow, realmGet$category, false);
                }
                realm2 = realm;
            }
        }
    }

    public static long insertOrUpdate(Realm realm, MockAssignment mockAssignment, Map<RealmModel, Long> map) {
        if (mockAssignment instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) mockAssignment;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm.getTable(MockAssignment.class);
        long nativePtr = table.getNativePtr();
        MockAssignmentColumnInfo mockAssignmentColumnInfo = (MockAssignmentColumnInfo) realm.schema.getColumnInfo(MockAssignment.class);
        long createRow = OsObject.createRow(table);
        map.put(mockAssignment, Long.valueOf(createRow));
        MockAssignmentRealmProxyInterface mockAssignmentRealmProxyInterface = mockAssignment;
        String realmGet$category = mockAssignmentRealmProxyInterface.realmGet$category();
        if (realmGet$category != null) {
            Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.categoryIndex, createRow, realmGet$category, false);
        } else {
            Table.nativeSetNull(nativePtr, mockAssignmentColumnInfo.categoryIndex, createRow, false);
        }
        realmGet$category = mockAssignmentRealmProxyInterface.realmGet$assignmentNumber();
        if (realmGet$category != null) {
            Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.assignmentNumberIndex, createRow, realmGet$category, false);
        } else {
            Table.nativeSetNull(nativePtr, mockAssignmentColumnInfo.assignmentNumberIndex, createRow, false);
        }
        realmGet$category = mockAssignmentRealmProxyInterface.realmGet$mark();
        if (realmGet$category != null) {
            Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.markIndex, createRow, realmGet$category, false);
        } else {
            Table.nativeSetNull(nativePtr, mockAssignmentColumnInfo.markIndex, createRow, false);
        }
        realmGet$category = mockAssignmentRealmProxyInterface.realmGet$score();
        if (realmGet$category != null) {
            Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.scoreIndex, createRow, realmGet$category, false);
        } else {
            Table.nativeSetNull(nativePtr, mockAssignmentColumnInfo.scoreIndex, createRow, false);
        }
        realmGet$category = mockAssignmentRealmProxyInterface.realmGet$maxScore();
        if (realmGet$category != null) {
            Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.maxScoreIndex, createRow, realmGet$category, false);
        } else {
            Table.nativeSetNull(nativePtr, mockAssignmentColumnInfo.maxScoreIndex, createRow, false);
        }
        return createRow;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Table table = realm2.getTable(MockAssignment.class);
        long nativePtr = table.getNativePtr();
        MockAssignmentColumnInfo mockAssignmentColumnInfo = (MockAssignmentColumnInfo) realm2.schema.getColumnInfo(MockAssignment.class);
        while (it.hasNext()) {
            MockAssignment mockAssignment = (MockAssignment) it.next();
            if (!map2.containsKey(mockAssignment)) {
                MockAssignmentRealmProxyInterface mockAssignmentRealmProxyInterface;
                if (mockAssignment instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) mockAssignment;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(mockAssignment, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(mockAssignment, Long.valueOf(createRow));
                MockAssignmentRealmProxyInterface mockAssignmentRealmProxyInterface2 = mockAssignment;
                String realmGet$category = mockAssignmentRealmProxyInterface2.realmGet$category();
                if (realmGet$category != null) {
                    mockAssignmentRealmProxyInterface = mockAssignmentRealmProxyInterface2;
                    Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.categoryIndex, createRow, realmGet$category, false);
                } else {
                    mockAssignmentRealmProxyInterface = mockAssignmentRealmProxyInterface2;
                    Table.nativeSetNull(nativePtr, mockAssignmentColumnInfo.categoryIndex, createRow, false);
                }
                realmGet$category = mockAssignmentRealmProxyInterface.realmGet$assignmentNumber();
                if (realmGet$category != null) {
                    Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.assignmentNumberIndex, createRow, realmGet$category, false);
                } else {
                    Table.nativeSetNull(nativePtr, mockAssignmentColumnInfo.assignmentNumberIndex, createRow, false);
                }
                realmGet$category = mockAssignmentRealmProxyInterface.realmGet$mark();
                if (realmGet$category != null) {
                    Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.markIndex, createRow, realmGet$category, false);
                } else {
                    Table.nativeSetNull(nativePtr, mockAssignmentColumnInfo.markIndex, createRow, false);
                }
                realmGet$category = mockAssignmentRealmProxyInterface.realmGet$score();
                if (realmGet$category != null) {
                    Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.scoreIndex, createRow, realmGet$category, false);
                } else {
                    Table.nativeSetNull(nativePtr, mockAssignmentColumnInfo.scoreIndex, createRow, false);
                }
                realmGet$category = mockAssignmentRealmProxyInterface.realmGet$maxScore();
                if (realmGet$category != null) {
                    Table.nativeSetString(nativePtr, mockAssignmentColumnInfo.maxScoreIndex, createRow, realmGet$category, false);
                } else {
                    Table.nativeSetNull(nativePtr, mockAssignmentColumnInfo.maxScoreIndex, createRow, false);
                }
                realm2 = realm;
            }
        }
    }

    public static MockAssignment createDetachedCopy(MockAssignment mockAssignment, int i, int i2, Map<RealmModel, CacheData<RealmModel>> map) {
        if (i <= i2) {
            if (mockAssignment != null) {
                CacheData cacheData = (CacheData) map.get(mockAssignment);
                if (cacheData == null) {
                    i2 = new MockAssignment();
                    map.put(mockAssignment, new CacheData(i, i2));
                } else if (i >= cacheData.minDepth) {
                    return cacheData.object;
                } else {
                    MockAssignment mockAssignment2 = (MockAssignment) cacheData.object;
                    cacheData.minDepth = i;
                    i2 = mockAssignment2;
                }
                MockAssignmentRealmProxyInterface mockAssignmentRealmProxyInterface = (MockAssignmentRealmProxyInterface) i2;
                MockAssignmentRealmProxyInterface mockAssignmentRealmProxyInterface2 = mockAssignment;
                mockAssignmentRealmProxyInterface.realmSet$category(mockAssignmentRealmProxyInterface2.realmGet$category());
                mockAssignmentRealmProxyInterface.realmSet$assignmentNumber(mockAssignmentRealmProxyInterface2.realmGet$assignmentNumber());
                mockAssignmentRealmProxyInterface.realmSet$mark(mockAssignmentRealmProxyInterface2.realmGet$mark());
                mockAssignmentRealmProxyInterface.realmSet$score(mockAssignmentRealmProxyInterface2.realmGet$score());
                mockAssignmentRealmProxyInterface.realmSet$maxScore(mockAssignmentRealmProxyInterface2.realmGet$maxScore());
                return i2;
            }
        }
        return null;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MockAssignment = proxy[");
        stringBuilder.append("{category:");
        stringBuilder.append(realmGet$category() != null ? realmGet$category() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{assignmentNumber:");
        stringBuilder.append(realmGet$assignmentNumber() != null ? realmGet$assignmentNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mark:");
        stringBuilder.append(realmGet$mark() != null ? realmGet$mark() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{score:");
        stringBuilder.append(realmGet$score() != null ? realmGet$score() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{maxScore:");
        stringBuilder.append(realmGet$maxScore() != null ? realmGet$maxScore() : "null");
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
        r7 = (io.realm.MockAssignmentRealmProxy) r7;
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
        throw new UnsupportedOperationException("Method not decompiled: io.realm.MockAssignmentRealmProxy.equals(java.lang.Object):boolean");
    }
}
