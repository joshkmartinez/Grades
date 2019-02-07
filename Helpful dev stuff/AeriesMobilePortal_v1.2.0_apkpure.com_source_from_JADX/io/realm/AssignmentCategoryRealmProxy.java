package io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.aeries.mobileportal.models.AssignmentCategory;
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

public class AssignmentCategoryRealmProxy extends AssignmentCategory implements RealmObjectProxy, AssignmentCategoryRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private AssignmentCategoryColumnInfo columnInfo;
    private ProxyState<AssignmentCategory> proxyState;

    static final class AssignmentCategoryColumnInfo extends ColumnInfo {
        long markIndex;
        long nameIndex;
        long numberOfAssignmentIndex;
        long percentIndex;
        long totalMaxScoreIndex;
        long totalScoreIndex;

        AssignmentCategoryColumnInfo(SharedRealm sharedRealm, Table table) {
            super(6);
            this.nameIndex = addColumnDetails(table, "name", RealmFieldType.STRING);
            this.numberOfAssignmentIndex = addColumnDetails(table, "numberOfAssignment", RealmFieldType.INTEGER);
            this.markIndex = addColumnDetails(table, "mark", RealmFieldType.STRING);
            this.totalScoreIndex = addColumnDetails(table, "totalScore", RealmFieldType.INTEGER);
            this.totalMaxScoreIndex = addColumnDetails(table, "totalMaxScore", RealmFieldType.INTEGER);
            this.percentIndex = addColumnDetails(table, "percent", RealmFieldType.DOUBLE);
        }

        AssignmentCategoryColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        protected final ColumnInfo copy(boolean z) {
            return new AssignmentCategoryColumnInfo((ColumnInfo) this, z);
        }

        protected final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            AssignmentCategoryColumnInfo assignmentCategoryColumnInfo = (AssignmentCategoryColumnInfo) columnInfo;
            AssignmentCategoryColumnInfo assignmentCategoryColumnInfo2 = (AssignmentCategoryColumnInfo) columnInfo2;
            assignmentCategoryColumnInfo2.nameIndex = assignmentCategoryColumnInfo.nameIndex;
            assignmentCategoryColumnInfo2.numberOfAssignmentIndex = assignmentCategoryColumnInfo.numberOfAssignmentIndex;
            assignmentCategoryColumnInfo2.markIndex = assignmentCategoryColumnInfo.markIndex;
            assignmentCategoryColumnInfo2.totalScoreIndex = assignmentCategoryColumnInfo.totalScoreIndex;
            assignmentCategoryColumnInfo2.totalMaxScoreIndex = assignmentCategoryColumnInfo.totalMaxScoreIndex;
            assignmentCategoryColumnInfo2.percentIndex = assignmentCategoryColumnInfo.percentIndex;
        }
    }

    public static String getTableName() {
        return "class_AssignmentCategory";
    }

    static {
        List arrayList = new ArrayList();
        arrayList.add("name");
        arrayList.add("numberOfAssignment");
        arrayList.add("mark");
        arrayList.add("totalScore");
        arrayList.add("totalMaxScore");
        arrayList.add("percent");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    AssignmentCategoryRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (AssignmentCategoryColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
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

    public int realmGet$numberOfAssignment() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.numberOfAssignmentIndex);
    }

    public void realmSet$numberOfAssignment(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.numberOfAssignmentIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.numberOfAssignmentIndex, row$realm.getIndex(), (long) i, true);
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

    public int realmGet$totalScore() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.totalScoreIndex);
    }

    public void realmSet$totalScore(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.totalScoreIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.totalScoreIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    public int realmGet$totalMaxScore() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.totalMaxScoreIndex);
    }

    public void realmSet$totalMaxScore(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.totalMaxScoreIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.totalMaxScoreIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    public double realmGet$percent() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getDouble(this.columnInfo.percentIndex);
    }

    public void realmSet$percent(double d) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setDouble(this.columnInfo.percentIndex, d);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setDouble(this.columnInfo.percentIndex, row$realm.getIndex(), d, true);
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        Builder builder = new Builder("AssignmentCategory");
        Builder builder2 = builder;
        builder2.addProperty("name", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("numberOfAssignment", RealmFieldType.INTEGER, false, false, true);
        builder2.addProperty("mark", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("totalScore", RealmFieldType.INTEGER, false, false, true);
        builder2.addProperty("totalMaxScore", RealmFieldType.INTEGER, false, false, true);
        builder2.addProperty("percent", RealmFieldType.DOUBLE, false, false, true);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static AssignmentCategoryColumnInfo validateTable(SharedRealm sharedRealm, boolean z) {
        if (sharedRealm.hasTable("class_AssignmentCategory")) {
            Table table = sharedRealm.getTable("class_AssignmentCategory");
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
            AssignmentCategoryColumnInfo assignmentCategoryColumnInfo = new AssignmentCategoryColumnInfo(sharedRealm, table);
            if (table.hasPrimaryKey()) {
                sharedRealm = sharedRealm.getPath();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Primary Key defined for field ");
                stringBuilder2.append(table.getColumnName(table.getPrimaryKey()));
                stringBuilder2.append(" was removed.");
                throw new RealmMigrationNeededException(sharedRealm, stringBuilder2.toString());
            } else if (!z.containsKey("name")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentCategoryColumnInfo.nameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("numberOfAssignment")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'numberOfAssignment' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("numberOfAssignment") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'numberOfAssignment' in existing Realm file.");
            } else if (table.isColumnNullable(assignmentCategoryColumnInfo.numberOfAssignmentIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'numberOfAssignment' does support null values in the existing Realm file. Use corresponding boxed type for field 'numberOfAssignment' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("mark")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mark' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("mark") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'mark' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentCategoryColumnInfo.markIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mark' is required. Either set @Required to field 'mark' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("totalScore")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalScore' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("totalScore") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalScore' in existing Realm file.");
            } else if (table.isColumnNullable(assignmentCategoryColumnInfo.totalScoreIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalScore' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalScore' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("totalMaxScore")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalMaxScore' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("totalMaxScore") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalMaxScore' in existing Realm file.");
            } else if (table.isColumnNullable(assignmentCategoryColumnInfo.totalMaxScoreIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalMaxScore' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalMaxScore' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("percent")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'percent' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("percent") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'percent' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentCategoryColumnInfo.percentIndex)) {
                return assignmentCategoryColumnInfo;
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'percent' does support null values in the existing Realm file. Use corresponding boxed type for field 'percent' or migrate using RealmObjectSchema.setNullable().");
            }
        }
        throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'AssignmentCategory' class is missing from the schema for this Realm.");
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static AssignmentCategory createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        AssignmentCategory assignmentCategory = (AssignmentCategory) realm.createObjectInternal(AssignmentCategory.class, true, Collections.emptyList());
        if (jSONObject.has("name")) {
            if (jSONObject.isNull("name")) {
                assignmentCategory.realmSet$name(null);
            } else {
                assignmentCategory.realmSet$name(jSONObject.getString("name"));
            }
        }
        if (jSONObject.has("numberOfAssignment")) {
            if (jSONObject.isNull("numberOfAssignment")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'numberOfAssignment' to null.");
            }
            assignmentCategory.realmSet$numberOfAssignment(jSONObject.getInt("numberOfAssignment"));
        }
        if (jSONObject.has("mark")) {
            if (jSONObject.isNull("mark")) {
                assignmentCategory.realmSet$mark(null);
            } else {
                assignmentCategory.realmSet$mark(jSONObject.getString("mark"));
            }
        }
        if (jSONObject.has("totalScore")) {
            if (jSONObject.isNull("totalScore")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalScore' to null.");
            }
            assignmentCategory.realmSet$totalScore(jSONObject.getInt("totalScore"));
        }
        if (jSONObject.has("totalMaxScore")) {
            if (jSONObject.isNull("totalMaxScore")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalMaxScore' to null.");
            }
            assignmentCategory.realmSet$totalMaxScore(jSONObject.getInt("totalMaxScore"));
        }
        if (jSONObject.has("percent")) {
            if (jSONObject.isNull("percent")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'percent' to null.");
            }
            assignmentCategory.realmSet$percent(jSONObject.getDouble("percent"));
        }
        return assignmentCategory;
    }

    @TargetApi(11)
    public static AssignmentCategory createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RealmModel assignmentCategory = new AssignmentCategory();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("name")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentCategoryRealmProxyInterface) assignmentCategory).realmSet$name(null);
                } else {
                    ((AssignmentCategoryRealmProxyInterface) assignmentCategory).realmSet$name(jsonReader.nextString());
                }
            } else if (nextName.equals("numberOfAssignment")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    ((AssignmentCategoryRealmProxyInterface) assignmentCategory).realmSet$numberOfAssignment(jsonReader.nextInt());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'numberOfAssignment' to null.");
                }
            } else if (nextName.equals("mark")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentCategoryRealmProxyInterface) assignmentCategory).realmSet$mark(null);
                } else {
                    ((AssignmentCategoryRealmProxyInterface) assignmentCategory).realmSet$mark(jsonReader.nextString());
                }
            } else if (nextName.equals("totalScore")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    ((AssignmentCategoryRealmProxyInterface) assignmentCategory).realmSet$totalScore(jsonReader.nextInt());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalScore' to null.");
                }
            } else if (nextName.equals("totalMaxScore")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    ((AssignmentCategoryRealmProxyInterface) assignmentCategory).realmSet$totalMaxScore(jsonReader.nextInt());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalMaxScore' to null.");
                }
            } else if (!nextName.equals("percent")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                ((AssignmentCategoryRealmProxyInterface) assignmentCategory).realmSet$percent(jsonReader.nextDouble());
            } else {
                jsonReader.skipValue();
                throw new IllegalArgumentException("Trying to set non-nullable field 'percent' to null.");
            }
        }
        jsonReader.endObject();
        return (AssignmentCategory) realm.copyToRealm(assignmentCategory);
    }

    public static AssignmentCategory copyOrUpdate(Realm realm, AssignmentCategory assignmentCategory, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy;
        boolean z2 = assignmentCategory instanceof RealmObjectProxy;
        if (z2) {
            RealmObjectProxy realmObjectProxy2 = (RealmObjectProxy) assignmentCategory;
            if (realmObjectProxy2.realmGet$proxyState().getRealm$realm() != null) {
                if (realmObjectProxy2.realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                }
            }
        }
        if (z2) {
            realmObjectProxy = (RealmObjectProxy) assignmentCategory;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return assignmentCategory;
            }
        }
        RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectProxy = (RealmObjectProxy) map.get(assignmentCategory);
        if (realmObjectProxy != null) {
            return (AssignmentCategory) realmObjectProxy;
        }
        return copy(realm, assignmentCategory, z, map);
    }

    public static AssignmentCategory copy(Realm realm, AssignmentCategory assignmentCategory, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = (RealmObjectProxy) map.get(assignmentCategory);
        if (realmObjectProxy != null) {
            return (AssignmentCategory) realmObjectProxy;
        }
        AssignmentCategory assignmentCategory2 = (AssignmentCategory) realm.createObjectInternal(AssignmentCategory.class, false, Collections.emptyList());
        map.put(assignmentCategory, (RealmObjectProxy) assignmentCategory2);
        AssignmentCategoryRealmProxyInterface assignmentCategoryRealmProxyInterface = assignmentCategory;
        AssignmentCategoryRealmProxyInterface assignmentCategoryRealmProxyInterface2 = assignmentCategory2;
        assignmentCategoryRealmProxyInterface2.realmSet$name(assignmentCategoryRealmProxyInterface.realmGet$name());
        assignmentCategoryRealmProxyInterface2.realmSet$numberOfAssignment(assignmentCategoryRealmProxyInterface.realmGet$numberOfAssignment());
        assignmentCategoryRealmProxyInterface2.realmSet$mark(assignmentCategoryRealmProxyInterface.realmGet$mark());
        assignmentCategoryRealmProxyInterface2.realmSet$totalScore(assignmentCategoryRealmProxyInterface.realmGet$totalScore());
        assignmentCategoryRealmProxyInterface2.realmSet$totalMaxScore(assignmentCategoryRealmProxyInterface.realmGet$totalMaxScore());
        assignmentCategoryRealmProxyInterface2.realmSet$percent(assignmentCategoryRealmProxyInterface.realmGet$percent());
        return assignmentCategory2;
    }

    public static long insert(Realm realm, AssignmentCategory assignmentCategory, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        AssignmentCategory assignmentCategory2 = assignmentCategory;
        if (assignmentCategory2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) assignmentCategory2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(AssignmentCategory.class);
        long nativePtr = table.getNativePtr();
        AssignmentCategoryColumnInfo assignmentCategoryColumnInfo = (AssignmentCategoryColumnInfo) realm2.schema.getColumnInfo(AssignmentCategory.class);
        long createRow = OsObject.createRow(table);
        map.put(assignmentCategory2, Long.valueOf(createRow));
        AssignmentCategoryRealmProxyInterface assignmentCategoryRealmProxyInterface = assignmentCategory2;
        String realmGet$name = assignmentCategoryRealmProxyInterface.realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(nativePtr, assignmentCategoryColumnInfo.nameIndex, createRow, realmGet$name, false);
        }
        Table.nativeSetLong(nativePtr, assignmentCategoryColumnInfo.numberOfAssignmentIndex, createRow, (long) assignmentCategoryRealmProxyInterface.realmGet$numberOfAssignment(), false);
        realmGet$name = assignmentCategoryRealmProxyInterface.realmGet$mark();
        if (realmGet$name != null) {
            Table.nativeSetString(nativePtr, assignmentCategoryColumnInfo.markIndex, createRow, realmGet$name, false);
        }
        long j = nativePtr;
        long j2 = createRow;
        Table.nativeSetLong(j, assignmentCategoryColumnInfo.totalScoreIndex, j2, (long) assignmentCategoryRealmProxyInterface.realmGet$totalScore(), false);
        Table.nativeSetLong(j, assignmentCategoryColumnInfo.totalMaxScoreIndex, j2, (long) assignmentCategoryRealmProxyInterface.realmGet$totalMaxScore(), false);
        Table.nativeSetDouble(j, assignmentCategoryColumnInfo.percentIndex, j2, assignmentCategoryRealmProxyInterface.realmGet$percent(), false);
        return createRow;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Table table = realm2.getTable(AssignmentCategory.class);
        long nativePtr = table.getNativePtr();
        AssignmentCategoryColumnInfo assignmentCategoryColumnInfo = (AssignmentCategoryColumnInfo) realm2.schema.getColumnInfo(AssignmentCategory.class);
        while (it.hasNext()) {
            AssignmentCategory assignmentCategory = (AssignmentCategory) it.next();
            if (!map2.containsKey(assignmentCategory)) {
                long j;
                if (assignmentCategory instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) assignmentCategory;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(assignmentCategory, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(assignmentCategory, Long.valueOf(createRow));
                AssignmentCategoryRealmProxyInterface assignmentCategoryRealmProxyInterface = assignmentCategory;
                String realmGet$name = assignmentCategoryRealmProxyInterface.realmGet$name();
                if (realmGet$name != null) {
                    j = createRow;
                    Table.nativeSetString(nativePtr, assignmentCategoryColumnInfo.nameIndex, createRow, realmGet$name, false);
                } else {
                    j = createRow;
                }
                Table.nativeSetLong(nativePtr, assignmentCategoryColumnInfo.numberOfAssignmentIndex, j, (long) assignmentCategoryRealmProxyInterface.realmGet$numberOfAssignment(), false);
                realmGet$name = assignmentCategoryRealmProxyInterface.realmGet$mark();
                if (realmGet$name != null) {
                    Table.nativeSetString(nativePtr, assignmentCategoryColumnInfo.markIndex, j, realmGet$name, false);
                }
                long j2 = j;
                Table.nativeSetLong(nativePtr, assignmentCategoryColumnInfo.totalScoreIndex, j2, (long) assignmentCategoryRealmProxyInterface.realmGet$totalScore(), false);
                long j3 = nativePtr;
                Table.nativeSetLong(j3, assignmentCategoryColumnInfo.totalMaxScoreIndex, j2, (long) assignmentCategoryRealmProxyInterface.realmGet$totalMaxScore(), false);
                Table.nativeSetDouble(j3, assignmentCategoryColumnInfo.percentIndex, j2, assignmentCategoryRealmProxyInterface.realmGet$percent(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, AssignmentCategory assignmentCategory, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        AssignmentCategory assignmentCategory2 = assignmentCategory;
        if (assignmentCategory2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) assignmentCategory2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(AssignmentCategory.class);
        long nativePtr = table.getNativePtr();
        AssignmentCategoryColumnInfo assignmentCategoryColumnInfo = (AssignmentCategoryColumnInfo) realm2.schema.getColumnInfo(AssignmentCategory.class);
        long createRow = OsObject.createRow(table);
        map.put(assignmentCategory2, Long.valueOf(createRow));
        AssignmentCategoryRealmProxyInterface assignmentCategoryRealmProxyInterface = assignmentCategory2;
        String realmGet$name = assignmentCategoryRealmProxyInterface.realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(nativePtr, assignmentCategoryColumnInfo.nameIndex, createRow, realmGet$name, false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentCategoryColumnInfo.nameIndex, createRow, false);
        }
        Table.nativeSetLong(nativePtr, assignmentCategoryColumnInfo.numberOfAssignmentIndex, createRow, (long) assignmentCategoryRealmProxyInterface.realmGet$numberOfAssignment(), false);
        realmGet$name = assignmentCategoryRealmProxyInterface.realmGet$mark();
        if (realmGet$name != null) {
            Table.nativeSetString(nativePtr, assignmentCategoryColumnInfo.markIndex, createRow, realmGet$name, false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentCategoryColumnInfo.markIndex, createRow, false);
        }
        long j = nativePtr;
        long j2 = createRow;
        Table.nativeSetLong(j, assignmentCategoryColumnInfo.totalScoreIndex, j2, (long) assignmentCategoryRealmProxyInterface.realmGet$totalScore(), false);
        Table.nativeSetLong(j, assignmentCategoryColumnInfo.totalMaxScoreIndex, j2, (long) assignmentCategoryRealmProxyInterface.realmGet$totalMaxScore(), false);
        Table.nativeSetDouble(j, assignmentCategoryColumnInfo.percentIndex, j2, assignmentCategoryRealmProxyInterface.realmGet$percent(), false);
        return createRow;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Table table = realm2.getTable(AssignmentCategory.class);
        long nativePtr = table.getNativePtr();
        AssignmentCategoryColumnInfo assignmentCategoryColumnInfo = (AssignmentCategoryColumnInfo) realm2.schema.getColumnInfo(AssignmentCategory.class);
        while (it.hasNext()) {
            AssignmentCategory assignmentCategory = (AssignmentCategory) it.next();
            if (!map2.containsKey(assignmentCategory)) {
                long j;
                if (assignmentCategory instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) assignmentCategory;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(assignmentCategory, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(assignmentCategory, Long.valueOf(createRow));
                AssignmentCategoryRealmProxyInterface assignmentCategoryRealmProxyInterface = assignmentCategory;
                String realmGet$name = assignmentCategoryRealmProxyInterface.realmGet$name();
                if (realmGet$name != null) {
                    j = createRow;
                    Table.nativeSetString(nativePtr, assignmentCategoryColumnInfo.nameIndex, createRow, realmGet$name, false);
                } else {
                    j = createRow;
                    Table.nativeSetNull(nativePtr, assignmentCategoryColumnInfo.nameIndex, j, false);
                }
                Table.nativeSetLong(nativePtr, assignmentCategoryColumnInfo.numberOfAssignmentIndex, j, (long) assignmentCategoryRealmProxyInterface.realmGet$numberOfAssignment(), false);
                realmGet$name = assignmentCategoryRealmProxyInterface.realmGet$mark();
                if (realmGet$name != null) {
                    Table.nativeSetString(nativePtr, assignmentCategoryColumnInfo.markIndex, j, realmGet$name, false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentCategoryColumnInfo.markIndex, j, false);
                }
                long j2 = j;
                Table.nativeSetLong(nativePtr, assignmentCategoryColumnInfo.totalScoreIndex, j2, (long) assignmentCategoryRealmProxyInterface.realmGet$totalScore(), false);
                long j3 = nativePtr;
                Table.nativeSetLong(j3, assignmentCategoryColumnInfo.totalMaxScoreIndex, j2, (long) assignmentCategoryRealmProxyInterface.realmGet$totalMaxScore(), false);
                Table.nativeSetDouble(j3, assignmentCategoryColumnInfo.percentIndex, j2, assignmentCategoryRealmProxyInterface.realmGet$percent(), false);
            }
        }
    }

    public static AssignmentCategory createDetachedCopy(AssignmentCategory assignmentCategory, int i, int i2, Map<RealmModel, CacheData<RealmModel>> map) {
        if (i <= i2) {
            if (assignmentCategory != null) {
                CacheData cacheData = (CacheData) map.get(assignmentCategory);
                if (cacheData == null) {
                    i2 = new AssignmentCategory();
                    map.put(assignmentCategory, new CacheData(i, i2));
                } else if (i >= cacheData.minDepth) {
                    return cacheData.object;
                } else {
                    AssignmentCategory assignmentCategory2 = (AssignmentCategory) cacheData.object;
                    cacheData.minDepth = i;
                    i2 = assignmentCategory2;
                }
                AssignmentCategoryRealmProxyInterface assignmentCategoryRealmProxyInterface = (AssignmentCategoryRealmProxyInterface) i2;
                AssignmentCategoryRealmProxyInterface assignmentCategoryRealmProxyInterface2 = assignmentCategory;
                assignmentCategoryRealmProxyInterface.realmSet$name(assignmentCategoryRealmProxyInterface2.realmGet$name());
                assignmentCategoryRealmProxyInterface.realmSet$numberOfAssignment(assignmentCategoryRealmProxyInterface2.realmGet$numberOfAssignment());
                assignmentCategoryRealmProxyInterface.realmSet$mark(assignmentCategoryRealmProxyInterface2.realmGet$mark());
                assignmentCategoryRealmProxyInterface.realmSet$totalScore(assignmentCategoryRealmProxyInterface2.realmGet$totalScore());
                assignmentCategoryRealmProxyInterface.realmSet$totalMaxScore(assignmentCategoryRealmProxyInterface2.realmGet$totalMaxScore());
                assignmentCategoryRealmProxyInterface.realmSet$percent(assignmentCategoryRealmProxyInterface2.realmGet$percent());
                return i2;
            }
        }
        return null;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("AssignmentCategory = proxy[");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numberOfAssignment:");
        stringBuilder.append(realmGet$numberOfAssignment());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mark:");
        stringBuilder.append(realmGet$mark() != null ? realmGet$mark() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalScore:");
        stringBuilder.append(realmGet$totalScore());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalMaxScore:");
        stringBuilder.append(realmGet$totalMaxScore());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{percent:");
        stringBuilder.append(realmGet$percent());
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
        r7 = (io.realm.AssignmentCategoryRealmProxy) r7;
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
        throw new UnsupportedOperationException("Method not decompiled: io.realm.AssignmentCategoryRealmProxy.equals(java.lang.Object):boolean");
    }
}
