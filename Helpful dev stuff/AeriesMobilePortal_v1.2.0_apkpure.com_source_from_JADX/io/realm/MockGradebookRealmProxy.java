package io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.aeries.mobileportal.models.MockAssignment;
import com.aeries.mobileportal.models.MockGradebook;
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

public class MockGradebookRealmProxy extends MockGradebook implements RealmObjectProxy, MockGradebookRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RealmList<MockAssignment> assignmentsRealmList;
    private MockGradebookColumnInfo columnInfo;
    private ProxyState<MockGradebook> proxyState;

    static final class MockGradebookColumnInfo extends ColumnInfo {
        long assignmentsIndex;
        long gradebookNumberIndex;
        long termCodeIndex;

        MockGradebookColumnInfo(SharedRealm sharedRealm, Table table) {
            super(3);
            this.gradebookNumberIndex = addColumnDetails(table, "gradebookNumber", RealmFieldType.STRING);
            this.termCodeIndex = addColumnDetails(table, "termCode", RealmFieldType.STRING);
            this.assignmentsIndex = addColumnDetails(table, "assignments", RealmFieldType.LIST);
        }

        MockGradebookColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        protected final ColumnInfo copy(boolean z) {
            return new MockGradebookColumnInfo((ColumnInfo) this, z);
        }

        protected final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            MockGradebookColumnInfo mockGradebookColumnInfo = (MockGradebookColumnInfo) columnInfo;
            MockGradebookColumnInfo mockGradebookColumnInfo2 = (MockGradebookColumnInfo) columnInfo2;
            mockGradebookColumnInfo2.gradebookNumberIndex = mockGradebookColumnInfo.gradebookNumberIndex;
            mockGradebookColumnInfo2.termCodeIndex = mockGradebookColumnInfo.termCodeIndex;
            mockGradebookColumnInfo2.assignmentsIndex = mockGradebookColumnInfo.assignmentsIndex;
        }
    }

    public static String getTableName() {
        return "class_MockGradebook";
    }

    static {
        List arrayList = new ArrayList();
        arrayList.add("gradebookNumber");
        arrayList.add("termCode");
        arrayList.add("assignments");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    MockGradebookRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (MockGradebookColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$gradebookNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.gradebookNumberIndex);
    }

    public void realmSet$gradebookNumber(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.gradebookNumberIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.gradebookNumberIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.gradebookNumberIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.gradebookNumberIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$termCode() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.termCodeIndex);
    }

    public void realmSet$termCode(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.termCodeIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.termCodeIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.termCodeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.termCodeIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public RealmList<MockAssignment> realmGet$assignments() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.assignmentsRealmList != null) {
            return this.assignmentsRealmList;
        }
        this.assignmentsRealmList = new RealmList(MockAssignment.class, this.proxyState.getRow$realm().getLinkList(this.columnInfo.assignmentsIndex), this.proxyState.getRealm$realm());
        return this.assignmentsRealmList;
    }

    public void realmSet$assignments(RealmList<MockAssignment> realmList) {
        if (this.proxyState.isUnderConstruction()) {
            if (!this.proxyState.getAcceptDefaultValue$realm() || this.proxyState.getExcludeFields$realm().contains("assignments")) {
                return;
            }
            if (!(realmList == null || realmList.isManaged())) {
                Realm realm = (Realm) this.proxyState.getRealm$realm();
                RealmList<MockAssignment> realmList2 = new RealmList();
                realmList = realmList.iterator();
                while (realmList.hasNext()) {
                    RealmModel realmModel = (MockAssignment) realmList.next();
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
        LinkView linkList = this.proxyState.getRow$realm().getLinkList(this.columnInfo.assignmentsIndex);
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
        Builder builder = new Builder("MockGradebook");
        Builder builder2 = builder;
        builder2.addProperty("gradebookNumber", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("termCode", RealmFieldType.STRING, false, false, false);
        builder.addLinkedProperty("assignments", RealmFieldType.LIST, "MockAssignment");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static MockGradebookColumnInfo validateTable(SharedRealm sharedRealm, boolean z) {
        if (sharedRealm.hasTable("class_MockGradebook")) {
            Table table = sharedRealm.getTable("class_MockGradebook");
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
            MockGradebookColumnInfo mockGradebookColumnInfo = new MockGradebookColumnInfo(sharedRealm, table);
            if (table.hasPrimaryKey()) {
                sharedRealm = sharedRealm.getPath();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Primary Key defined for field ");
                stringBuilder2.append(table.getColumnName(table.getPrimaryKey()));
                stringBuilder2.append(" was removed.");
                throw new RealmMigrationNeededException(sharedRealm, stringBuilder2.toString());
            } else if (!z.containsKey("gradebookNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'gradebookNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("gradebookNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'gradebookNumber' in existing Realm file.");
            } else if (!table.isColumnNullable(mockGradebookColumnInfo.gradebookNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'gradebookNumber' is required. Either set @Required to field 'gradebookNumber' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("termCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'termCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("termCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'termCode' in existing Realm file.");
            } else if (!table.isColumnNullable(mockGradebookColumnInfo.termCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'termCode' is required. Either set @Required to field 'termCode' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("assignments")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'assignments'");
            } else if (z.get("assignments") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'MockAssignment' for field 'assignments'");
            } else if (sharedRealm.hasTable("class_MockAssignment")) {
                z = sharedRealm.getTable("class_MockAssignment");
                if (table.getLinkTarget(mockGradebookColumnInfo.assignmentsIndex).hasSameSchema(z)) {
                    return mockGradebookColumnInfo;
                }
                sharedRealm = sharedRealm.getPath();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Invalid RealmList type for field 'assignments': '");
                stringBuilder3.append(table.getLinkTarget(mockGradebookColumnInfo.assignmentsIndex).getName());
                stringBuilder3.append("' expected - was '");
                stringBuilder3.append(z.getName());
                stringBuilder3.append("'");
                throw new RealmMigrationNeededException(sharedRealm, stringBuilder3.toString());
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_MockAssignment' for field 'assignments'");
            }
        }
        throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'MockGradebook' class is missing from the schema for this Realm.");
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static MockGradebook createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        List arrayList = new ArrayList(1);
        if (jSONObject.has("assignments")) {
            arrayList.add("assignments");
        }
        MockGradebook mockGradebook = (MockGradebook) realm.createObjectInternal(MockGradebook.class, true, arrayList);
        if (jSONObject.has("gradebookNumber")) {
            if (jSONObject.isNull("gradebookNumber")) {
                mockGradebook.realmSet$gradebookNumber(null);
            } else {
                mockGradebook.realmSet$gradebookNumber(jSONObject.getString("gradebookNumber"));
            }
        }
        if (jSONObject.has("termCode")) {
            if (jSONObject.isNull("termCode")) {
                mockGradebook.realmSet$termCode(null);
            } else {
                mockGradebook.realmSet$termCode(jSONObject.getString("termCode"));
            }
        }
        if (jSONObject.has("assignments")) {
            if (jSONObject.isNull("assignments")) {
                mockGradebook.realmSet$assignments(null);
            } else {
                MockGradebookRealmProxyInterface mockGradebookRealmProxyInterface = mockGradebook;
                mockGradebookRealmProxyInterface.realmGet$assignments().clear();
                jSONObject = jSONObject.getJSONArray("assignments");
                for (int i = 0; i < jSONObject.length(); i++) {
                    mockGradebookRealmProxyInterface.realmGet$assignments().add(MockAssignmentRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject.getJSONObject(i), z));
                }
            }
        }
        return mockGradebook;
    }

    @TargetApi(11)
    public static MockGradebook createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RealmModel mockGradebook = new MockGradebook();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("gradebookNumber")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((MockGradebookRealmProxyInterface) mockGradebook).realmSet$gradebookNumber(null);
                } else {
                    ((MockGradebookRealmProxyInterface) mockGradebook).realmSet$gradebookNumber(jsonReader.nextString());
                }
            } else if (nextName.equals("termCode")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((MockGradebookRealmProxyInterface) mockGradebook).realmSet$termCode(null);
                } else {
                    ((MockGradebookRealmProxyInterface) mockGradebook).realmSet$termCode(jsonReader.nextString());
                }
            } else if (!nextName.equals("assignments")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.skipValue();
                ((MockGradebookRealmProxyInterface) mockGradebook).realmSet$assignments(null);
            } else {
                MockGradebookRealmProxyInterface mockGradebookRealmProxyInterface = (MockGradebookRealmProxyInterface) mockGradebook;
                mockGradebookRealmProxyInterface.realmSet$assignments(new RealmList());
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    mockGradebookRealmProxyInterface.realmGet$assignments().add(MockAssignmentRealmProxy.createUsingJsonStream(realm, jsonReader));
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
        return (MockGradebook) realm.copyToRealm(mockGradebook);
    }

    public static MockGradebook copyOrUpdate(Realm realm, MockGradebook mockGradebook, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy;
        boolean z2 = mockGradebook instanceof RealmObjectProxy;
        if (z2) {
            RealmObjectProxy realmObjectProxy2 = (RealmObjectProxy) mockGradebook;
            if (realmObjectProxy2.realmGet$proxyState().getRealm$realm() != null) {
                if (realmObjectProxy2.realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                }
            }
        }
        if (z2) {
            realmObjectProxy = (RealmObjectProxy) mockGradebook;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return mockGradebook;
            }
        }
        RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectProxy = (RealmObjectProxy) map.get(mockGradebook);
        if (realmObjectProxy != null) {
            return (MockGradebook) realmObjectProxy;
        }
        return copy(realm, mockGradebook, z, map);
    }

    public static MockGradebook copy(Realm realm, MockGradebook mockGradebook, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = (RealmObjectProxy) map.get(mockGradebook);
        if (realmObjectProxy != null) {
            return (MockGradebook) realmObjectProxy;
        }
        int i = 0;
        MockGradebook mockGradebook2 = (MockGradebook) realm.createObjectInternal(MockGradebook.class, false, Collections.emptyList());
        map.put(mockGradebook, (RealmObjectProxy) mockGradebook2);
        MockGradebookRealmProxyInterface mockGradebookRealmProxyInterface = mockGradebook;
        MockGradebookRealmProxyInterface mockGradebookRealmProxyInterface2 = mockGradebook2;
        mockGradebookRealmProxyInterface2.realmSet$gradebookNumber(mockGradebookRealmProxyInterface.realmGet$gradebookNumber());
        mockGradebookRealmProxyInterface2.realmSet$termCode(mockGradebookRealmProxyInterface.realmGet$termCode());
        mockGradebook = mockGradebookRealmProxyInterface.realmGet$assignments();
        if (mockGradebook != null) {
            RealmList realmGet$assignments = mockGradebookRealmProxyInterface2.realmGet$assignments();
            while (i < mockGradebook.size()) {
                MockAssignment mockAssignment = (MockAssignment) mockGradebook.get(i);
                RealmModel realmModel = (MockAssignment) map.get(mockAssignment);
                if (realmModel != null) {
                    realmGet$assignments.add(realmModel);
                } else {
                    realmGet$assignments.add(MockAssignmentRealmProxy.copyOrUpdate(realm, mockAssignment, z, map));
                }
                i++;
            }
        }
        return mockGradebook2;
    }

    public static long insert(Realm realm, MockGradebook mockGradebook, Map<RealmModel, Long> map) {
        long j;
        Realm realm2 = realm;
        MockGradebook mockGradebook2 = mockGradebook;
        Map map2 = map;
        if (mockGradebook2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) mockGradebook2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(MockGradebook.class);
        long nativePtr = table.getNativePtr();
        MockGradebookColumnInfo mockGradebookColumnInfo = (MockGradebookColumnInfo) realm2.schema.getColumnInfo(MockGradebook.class);
        long createRow = OsObject.createRow(table);
        map2.put(mockGradebook2, Long.valueOf(createRow));
        MockGradebookRealmProxyInterface mockGradebookRealmProxyInterface = mockGradebook2;
        String realmGet$gradebookNumber = mockGradebookRealmProxyInterface.realmGet$gradebookNumber();
        if (realmGet$gradebookNumber != null) {
            j = createRow;
            Table.nativeSetString(nativePtr, mockGradebookColumnInfo.gradebookNumberIndex, createRow, realmGet$gradebookNumber, false);
        } else {
            j = createRow;
        }
        String realmGet$termCode = mockGradebookRealmProxyInterface.realmGet$termCode();
        if (realmGet$termCode != null) {
            Table.nativeSetString(nativePtr, mockGradebookColumnInfo.termCodeIndex, j, realmGet$termCode, false);
        }
        RealmList realmGet$assignments = mockGradebookRealmProxyInterface.realmGet$assignments();
        if (realmGet$assignments != null) {
            long nativeGetLinkView = Table.nativeGetLinkView(nativePtr, mockGradebookColumnInfo.assignmentsIndex, j);
            Iterator it = realmGet$assignments.iterator();
            while (it.hasNext()) {
                MockAssignment mockAssignment = (MockAssignment) it.next();
                Long l = (Long) map2.get(mockAssignment);
                if (l == null) {
                    l = Long.valueOf(MockAssignmentRealmProxy.insert(realm2, mockAssignment, map2));
                }
                LinkView.nativeAdd(nativeGetLinkView, l.longValue());
            }
        }
        return j;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map map2 = map;
        Table table = realm2.getTable(MockGradebook.class);
        long nativePtr = table.getNativePtr();
        MockGradebookColumnInfo mockGradebookColumnInfo = (MockGradebookColumnInfo) realm2.schema.getColumnInfo(MockGradebook.class);
        while (it.hasNext()) {
            MockGradebook mockGradebook = (MockGradebook) it.next();
            if (!map2.containsKey(mockGradebook)) {
                Table table2;
                MockGradebookRealmProxyInterface mockGradebookRealmProxyInterface;
                if (mockGradebook instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) mockGradebook;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(mockGradebook, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(mockGradebook, Long.valueOf(createRow));
                MockGradebookRealmProxyInterface mockGradebookRealmProxyInterface2 = mockGradebook;
                String realmGet$gradebookNumber = mockGradebookRealmProxyInterface2.realmGet$gradebookNumber();
                if (realmGet$gradebookNumber != null) {
                    table2 = table;
                    mockGradebookRealmProxyInterface = mockGradebookRealmProxyInterface2;
                    Table.nativeSetString(nativePtr, mockGradebookColumnInfo.gradebookNumberIndex, createRow, realmGet$gradebookNumber, false);
                } else {
                    table2 = table;
                    mockGradebookRealmProxyInterface = mockGradebookRealmProxyInterface2;
                }
                realmGet$gradebookNumber = mockGradebookRealmProxyInterface.realmGet$termCode();
                if (realmGet$gradebookNumber != null) {
                    Table.nativeSetString(nativePtr, mockGradebookColumnInfo.termCodeIndex, createRow, realmGet$gradebookNumber, false);
                }
                RealmList realmGet$assignments = mockGradebookRealmProxyInterface.realmGet$assignments();
                if (realmGet$assignments != null) {
                    long nativeGetLinkView = Table.nativeGetLinkView(nativePtr, mockGradebookColumnInfo.assignmentsIndex, createRow);
                    Iterator it2 = realmGet$assignments.iterator();
                    while (it2.hasNext()) {
                        MockAssignment mockAssignment = (MockAssignment) it2.next();
                        Long l = (Long) map2.get(mockAssignment);
                        if (l == null) {
                            l = Long.valueOf(MockAssignmentRealmProxy.insert(realm2, mockAssignment, map2));
                        }
                        LinkView.nativeAdd(nativeGetLinkView, l.longValue());
                    }
                }
                table = table2;
            }
        }
    }

    public static long insertOrUpdate(Realm realm, MockGradebook mockGradebook, Map<RealmModel, Long> map) {
        long j;
        Realm realm2 = realm;
        MockGradebook mockGradebook2 = mockGradebook;
        Map map2 = map;
        if (mockGradebook2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) mockGradebook2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(MockGradebook.class);
        long nativePtr = table.getNativePtr();
        MockGradebookColumnInfo mockGradebookColumnInfo = (MockGradebookColumnInfo) realm2.schema.getColumnInfo(MockGradebook.class);
        long createRow = OsObject.createRow(table);
        map2.put(mockGradebook2, Long.valueOf(createRow));
        MockGradebookRealmProxyInterface mockGradebookRealmProxyInterface = mockGradebook2;
        String realmGet$gradebookNumber = mockGradebookRealmProxyInterface.realmGet$gradebookNumber();
        if (realmGet$gradebookNumber != null) {
            j = createRow;
            Table.nativeSetString(nativePtr, mockGradebookColumnInfo.gradebookNumberIndex, createRow, realmGet$gradebookNumber, false);
        } else {
            j = createRow;
            Table.nativeSetNull(nativePtr, mockGradebookColumnInfo.gradebookNumberIndex, j, false);
        }
        String realmGet$termCode = mockGradebookRealmProxyInterface.realmGet$termCode();
        if (realmGet$termCode != null) {
            Table.nativeSetString(nativePtr, mockGradebookColumnInfo.termCodeIndex, j, realmGet$termCode, false);
        } else {
            Table.nativeSetNull(nativePtr, mockGradebookColumnInfo.termCodeIndex, j, false);
        }
        long nativeGetLinkView = Table.nativeGetLinkView(nativePtr, mockGradebookColumnInfo.assignmentsIndex, j);
        LinkView.nativeClear(nativeGetLinkView);
        RealmList realmGet$assignments = mockGradebookRealmProxyInterface.realmGet$assignments();
        if (realmGet$assignments != null) {
            Iterator it = realmGet$assignments.iterator();
            while (it.hasNext()) {
                MockAssignment mockAssignment = (MockAssignment) it.next();
                Long l = (Long) map2.get(mockAssignment);
                if (l == null) {
                    l = Long.valueOf(MockAssignmentRealmProxy.insertOrUpdate(realm2, mockAssignment, map2));
                }
                LinkView.nativeAdd(nativeGetLinkView, l.longValue());
            }
        }
        return j;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map map2 = map;
        Table table = realm2.getTable(MockGradebook.class);
        long nativePtr = table.getNativePtr();
        MockGradebookColumnInfo mockGradebookColumnInfo = (MockGradebookColumnInfo) realm2.schema.getColumnInfo(MockGradebook.class);
        while (it.hasNext()) {
            MockGradebook mockGradebook = (MockGradebook) it.next();
            if (!map2.containsKey(mockGradebook)) {
                Table table2;
                MockGradebookRealmProxyInterface mockGradebookRealmProxyInterface;
                if (mockGradebook instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) mockGradebook;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(mockGradebook, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(mockGradebook, Long.valueOf(createRow));
                MockGradebookRealmProxyInterface mockGradebookRealmProxyInterface2 = mockGradebook;
                String realmGet$gradebookNumber = mockGradebookRealmProxyInterface2.realmGet$gradebookNumber();
                if (realmGet$gradebookNumber != null) {
                    table2 = table;
                    mockGradebookRealmProxyInterface = mockGradebookRealmProxyInterface2;
                    Table.nativeSetString(nativePtr, mockGradebookColumnInfo.gradebookNumberIndex, createRow, realmGet$gradebookNumber, false);
                } else {
                    table2 = table;
                    mockGradebookRealmProxyInterface = mockGradebookRealmProxyInterface2;
                    Table.nativeSetNull(nativePtr, mockGradebookColumnInfo.gradebookNumberIndex, createRow, false);
                }
                realmGet$gradebookNumber = mockGradebookRealmProxyInterface.realmGet$termCode();
                if (realmGet$gradebookNumber != null) {
                    Table.nativeSetString(nativePtr, mockGradebookColumnInfo.termCodeIndex, createRow, realmGet$gradebookNumber, false);
                } else {
                    Table.nativeSetNull(nativePtr, mockGradebookColumnInfo.termCodeIndex, createRow, false);
                }
                long nativeGetLinkView = Table.nativeGetLinkView(nativePtr, mockGradebookColumnInfo.assignmentsIndex, createRow);
                LinkView.nativeClear(nativeGetLinkView);
                RealmList realmGet$assignments = mockGradebookRealmProxyInterface.realmGet$assignments();
                if (realmGet$assignments != null) {
                    Iterator it2 = realmGet$assignments.iterator();
                    while (it2.hasNext()) {
                        MockAssignment mockAssignment = (MockAssignment) it2.next();
                        Long l = (Long) map2.get(mockAssignment);
                        if (l == null) {
                            l = Long.valueOf(MockAssignmentRealmProxy.insertOrUpdate(realm2, mockAssignment, map2));
                        }
                        LinkView.nativeAdd(nativeGetLinkView, l.longValue());
                    }
                }
                table = table2;
            }
        }
    }

    public static MockGradebook createDetachedCopy(MockGradebook mockGradebook, int i, int i2, Map<RealmModel, CacheData<RealmModel>> map) {
        if (i <= i2) {
            if (mockGradebook != null) {
                MockGradebook mockGradebook2;
                CacheData cacheData = (CacheData) map.get(mockGradebook);
                if (cacheData == null) {
                    mockGradebook2 = new MockGradebook();
                    map.put(mockGradebook, new CacheData(i, mockGradebook2));
                } else if (i >= cacheData.minDepth) {
                    return cacheData.object;
                } else {
                    MockGradebook mockGradebook3 = (MockGradebook) cacheData.object;
                    cacheData.minDepth = i;
                    mockGradebook2 = mockGradebook3;
                }
                MockGradebookRealmProxyInterface mockGradebookRealmProxyInterface = mockGradebook2;
                MockGradebookRealmProxyInterface mockGradebookRealmProxyInterface2 = mockGradebook;
                mockGradebookRealmProxyInterface.realmSet$gradebookNumber(mockGradebookRealmProxyInterface2.realmGet$gradebookNumber());
                mockGradebookRealmProxyInterface.realmSet$termCode(mockGradebookRealmProxyInterface2.realmGet$termCode());
                if (i == i2) {
                    mockGradebookRealmProxyInterface.realmSet$assignments(null);
                } else {
                    mockGradebook = mockGradebookRealmProxyInterface2.realmGet$assignments();
                    RealmList realmList = new RealmList();
                    mockGradebookRealmProxyInterface.realmSet$assignments(realmList);
                    i++;
                    int size = mockGradebook.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        realmList.add(MockAssignmentRealmProxy.createDetachedCopy((MockAssignment) mockGradebook.get(i3), i, i2, map));
                    }
                }
                return mockGradebook2;
            }
        }
        return null;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MockGradebook = proxy[");
        stringBuilder.append("{gradebookNumber:");
        stringBuilder.append(realmGet$gradebookNumber() != null ? realmGet$gradebookNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{termCode:");
        stringBuilder.append(realmGet$termCode() != null ? realmGet$termCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{assignments:");
        stringBuilder.append("RealmList<MockAssignment>[");
        stringBuilder.append(realmGet$assignments().size());
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
        r7 = (io.realm.MockGradebookRealmProxy) r7;
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
        throw new UnsupportedOperationException("Method not decompiled: io.realm.MockGradebookRealmProxy.equals(java.lang.Object):boolean");
    }
}
