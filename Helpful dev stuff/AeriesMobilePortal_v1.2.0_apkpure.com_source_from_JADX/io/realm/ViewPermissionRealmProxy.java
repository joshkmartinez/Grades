package io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.aeries.mobileportal.models.ViewPermission;
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

public class ViewPermissionRealmProxy extends ViewPermission implements RealmObjectProxy, ViewPermissionRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private ViewPermissionColumnInfo columnInfo;
    private ProxyState<ViewPermission> proxyState;

    static final class ViewPermissionColumnInfo extends ColumnInfo {
        long canViewDetailsIndex;
        long positionIndex;
        long viewCodeIndex;
        long viewDescriptionIndex;

        ViewPermissionColumnInfo(SharedRealm sharedRealm, Table table) {
            super(4);
            this.viewCodeIndex = addColumnDetails(table, "viewCode", RealmFieldType.STRING);
            this.canViewDetailsIndex = addColumnDetails(table, "canViewDetails", RealmFieldType.BOOLEAN);
            this.viewDescriptionIndex = addColumnDetails(table, "viewDescription", RealmFieldType.STRING);
            this.positionIndex = addColumnDetails(table, "position", RealmFieldType.INTEGER);
        }

        ViewPermissionColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        protected final ColumnInfo copy(boolean z) {
            return new ViewPermissionColumnInfo((ColumnInfo) this, z);
        }

        protected final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            ViewPermissionColumnInfo viewPermissionColumnInfo = (ViewPermissionColumnInfo) columnInfo;
            ViewPermissionColumnInfo viewPermissionColumnInfo2 = (ViewPermissionColumnInfo) columnInfo2;
            viewPermissionColumnInfo2.viewCodeIndex = viewPermissionColumnInfo.viewCodeIndex;
            viewPermissionColumnInfo2.canViewDetailsIndex = viewPermissionColumnInfo.canViewDetailsIndex;
            viewPermissionColumnInfo2.viewDescriptionIndex = viewPermissionColumnInfo.viewDescriptionIndex;
            viewPermissionColumnInfo2.positionIndex = viewPermissionColumnInfo.positionIndex;
        }
    }

    public static String getTableName() {
        return "class_ViewPermission";
    }

    static {
        List arrayList = new ArrayList();
        arrayList.add("viewCode");
        arrayList.add("canViewDetails");
        arrayList.add("viewDescription");
        arrayList.add("position");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    ViewPermissionRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (ViewPermissionColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$viewCode() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.viewCodeIndex);
    }

    public void realmSet$viewCode(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.viewCodeIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.viewCodeIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.viewCodeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.viewCodeIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public boolean realmGet$canViewDetails() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.canViewDetailsIndex);
    }

    public void realmSet$canViewDetails(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.canViewDetailsIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.canViewDetailsIndex, row$realm.getIndex(), z, true);
        }
    }

    public String realmGet$viewDescription() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.viewDescriptionIndex);
    }

    public void realmSet$viewDescription(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.viewDescriptionIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.viewDescriptionIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.viewDescriptionIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.viewDescriptionIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public int realmGet$position() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.positionIndex);
    }

    public void realmSet$position(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.positionIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.positionIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        Builder builder = new Builder("ViewPermission");
        Builder builder2 = builder;
        builder2.addProperty("viewCode", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("canViewDetails", RealmFieldType.BOOLEAN, false, false, true);
        builder2.addProperty("viewDescription", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("position", RealmFieldType.INTEGER, false, false, true);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ViewPermissionColumnInfo validateTable(SharedRealm sharedRealm, boolean z) {
        if (sharedRealm.hasTable("class_ViewPermission")) {
            Table table = sharedRealm.getTable("class_ViewPermission");
            long columnCount = table.getColumnCount();
            if (columnCount != 4) {
                StringBuilder stringBuilder;
                if (columnCount < 4) {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is less than expected - expected 4 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                } else if (z) {
                    RealmLog.debug("Field count is more than expected - expected 4 but was %1$d", Long.valueOf(columnCount));
                } else {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is more than expected - expected 4 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                }
            }
            z = new HashMap();
            for (long j = 0; j < columnCount; j++) {
                z.put(table.getColumnName(j), table.getColumnType(j));
            }
            ViewPermissionColumnInfo viewPermissionColumnInfo = new ViewPermissionColumnInfo(sharedRealm, table);
            if (table.hasPrimaryKey()) {
                sharedRealm = sharedRealm.getPath();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Primary Key defined for field ");
                stringBuilder2.append(table.getColumnName(table.getPrimaryKey()));
                stringBuilder2.append(" was removed.");
                throw new RealmMigrationNeededException(sharedRealm, stringBuilder2.toString());
            } else if (!z.containsKey("viewCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'viewCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("viewCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'viewCode' in existing Realm file.");
            } else if (!table.isColumnNullable(viewPermissionColumnInfo.viewCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'viewCode' is required. Either set @Required to field 'viewCode' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("canViewDetails")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'canViewDetails' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("canViewDetails") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'canViewDetails' in existing Realm file.");
            } else if (table.isColumnNullable(viewPermissionColumnInfo.canViewDetailsIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'canViewDetails' does support null values in the existing Realm file. Use corresponding boxed type for field 'canViewDetails' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("viewDescription")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'viewDescription' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("viewDescription") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'viewDescription' in existing Realm file.");
            } else if (!table.isColumnNullable(viewPermissionColumnInfo.viewDescriptionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'viewDescription' is required. Either set @Required to field 'viewDescription' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("position")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'position' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("position") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'position' in existing Realm file.");
            } else if (!table.isColumnNullable(viewPermissionColumnInfo.positionIndex)) {
                return viewPermissionColumnInfo;
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'position' does support null values in the existing Realm file. Use corresponding boxed type for field 'position' or migrate using RealmObjectSchema.setNullable().");
            }
        }
        throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'ViewPermission' class is missing from the schema for this Realm.");
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static ViewPermission createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        ViewPermission viewPermission = (ViewPermission) realm.createObjectInternal(ViewPermission.class, true, Collections.emptyList());
        if (jSONObject.has("viewCode")) {
            if (jSONObject.isNull("viewCode")) {
                viewPermission.realmSet$viewCode(null);
            } else {
                viewPermission.realmSet$viewCode(jSONObject.getString("viewCode"));
            }
        }
        if (jSONObject.has("canViewDetails")) {
            if (jSONObject.isNull("canViewDetails")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'canViewDetails' to null.");
            }
            viewPermission.realmSet$canViewDetails(jSONObject.getBoolean("canViewDetails"));
        }
        if (jSONObject.has("viewDescription")) {
            if (jSONObject.isNull("viewDescription")) {
                viewPermission.realmSet$viewDescription(null);
            } else {
                viewPermission.realmSet$viewDescription(jSONObject.getString("viewDescription"));
            }
        }
        if (jSONObject.has("position")) {
            if (jSONObject.isNull("position")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'position' to null.");
            }
            viewPermission.realmSet$position(jSONObject.getInt("position"));
        }
        return viewPermission;
    }

    @TargetApi(11)
    public static ViewPermission createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RealmModel viewPermission = new ViewPermission();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("viewCode")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ViewPermissionRealmProxyInterface) viewPermission).realmSet$viewCode(null);
                } else {
                    ((ViewPermissionRealmProxyInterface) viewPermission).realmSet$viewCode(jsonReader.nextString());
                }
            } else if (nextName.equals("canViewDetails")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    ((ViewPermissionRealmProxyInterface) viewPermission).realmSet$canViewDetails(jsonReader.nextBoolean());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'canViewDetails' to null.");
                }
            } else if (nextName.equals("viewDescription")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ViewPermissionRealmProxyInterface) viewPermission).realmSet$viewDescription(null);
                } else {
                    ((ViewPermissionRealmProxyInterface) viewPermission).realmSet$viewDescription(jsonReader.nextString());
                }
            } else if (!nextName.equals("position")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                ((ViewPermissionRealmProxyInterface) viewPermission).realmSet$position(jsonReader.nextInt());
            } else {
                jsonReader.skipValue();
                throw new IllegalArgumentException("Trying to set non-nullable field 'position' to null.");
            }
        }
        jsonReader.endObject();
        return (ViewPermission) realm.copyToRealm(viewPermission);
    }

    public static ViewPermission copyOrUpdate(Realm realm, ViewPermission viewPermission, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy;
        boolean z2 = viewPermission instanceof RealmObjectProxy;
        if (z2) {
            RealmObjectProxy realmObjectProxy2 = (RealmObjectProxy) viewPermission;
            if (realmObjectProxy2.realmGet$proxyState().getRealm$realm() != null) {
                if (realmObjectProxy2.realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                }
            }
        }
        if (z2) {
            realmObjectProxy = (RealmObjectProxy) viewPermission;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return viewPermission;
            }
        }
        RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectProxy = (RealmObjectProxy) map.get(viewPermission);
        if (realmObjectProxy != null) {
            return (ViewPermission) realmObjectProxy;
        }
        return copy(realm, viewPermission, z, map);
    }

    public static ViewPermission copy(Realm realm, ViewPermission viewPermission, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = (RealmObjectProxy) map.get(viewPermission);
        if (realmObjectProxy != null) {
            return (ViewPermission) realmObjectProxy;
        }
        ViewPermission viewPermission2 = (ViewPermission) realm.createObjectInternal(ViewPermission.class, false, Collections.emptyList());
        map.put(viewPermission, (RealmObjectProxy) viewPermission2);
        ViewPermissionRealmProxyInterface viewPermissionRealmProxyInterface = viewPermission;
        ViewPermissionRealmProxyInterface viewPermissionRealmProxyInterface2 = viewPermission2;
        viewPermissionRealmProxyInterface2.realmSet$viewCode(viewPermissionRealmProxyInterface.realmGet$viewCode());
        viewPermissionRealmProxyInterface2.realmSet$canViewDetails(viewPermissionRealmProxyInterface.realmGet$canViewDetails());
        viewPermissionRealmProxyInterface2.realmSet$viewDescription(viewPermissionRealmProxyInterface.realmGet$viewDescription());
        viewPermissionRealmProxyInterface2.realmSet$position(viewPermissionRealmProxyInterface.realmGet$position());
        return viewPermission2;
    }

    public static long insert(Realm realm, ViewPermission viewPermission, Map<RealmModel, Long> map) {
        if (viewPermission instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) viewPermission;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm.getTable(ViewPermission.class);
        long nativePtr = table.getNativePtr();
        ViewPermissionColumnInfo viewPermissionColumnInfo = (ViewPermissionColumnInfo) realm.schema.getColumnInfo(ViewPermission.class);
        long createRow = OsObject.createRow(table);
        map.put(viewPermission, Long.valueOf(createRow));
        ViewPermissionRealmProxyInterface viewPermissionRealmProxyInterface = viewPermission;
        String realmGet$viewCode = viewPermissionRealmProxyInterface.realmGet$viewCode();
        if (realmGet$viewCode != null) {
            Table.nativeSetString(nativePtr, viewPermissionColumnInfo.viewCodeIndex, createRow, realmGet$viewCode, false);
        }
        Table.nativeSetBoolean(nativePtr, viewPermissionColumnInfo.canViewDetailsIndex, createRow, viewPermissionRealmProxyInterface.realmGet$canViewDetails(), false);
        realmGet$viewCode = viewPermissionRealmProxyInterface.realmGet$viewDescription();
        if (realmGet$viewCode != null) {
            Table.nativeSetString(nativePtr, viewPermissionColumnInfo.viewDescriptionIndex, createRow, realmGet$viewCode, false);
        }
        Table.nativeSetLong(nativePtr, viewPermissionColumnInfo.positionIndex, createRow, (long) viewPermissionRealmProxyInterface.realmGet$position(), null);
        return createRow;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Table table = realm2.getTable(ViewPermission.class);
        long nativePtr = table.getNativePtr();
        ViewPermissionColumnInfo viewPermissionColumnInfo = (ViewPermissionColumnInfo) realm2.schema.getColumnInfo(ViewPermission.class);
        while (it.hasNext()) {
            ViewPermission viewPermission = (ViewPermission) it.next();
            if (!map2.containsKey(viewPermission)) {
                long j;
                if (viewPermission instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) viewPermission;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(viewPermission, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(viewPermission, Long.valueOf(createRow));
                ViewPermissionRealmProxyInterface viewPermissionRealmProxyInterface = viewPermission;
                String realmGet$viewCode = viewPermissionRealmProxyInterface.realmGet$viewCode();
                if (realmGet$viewCode != null) {
                    j = createRow;
                    Table.nativeSetString(nativePtr, viewPermissionColumnInfo.viewCodeIndex, createRow, realmGet$viewCode, false);
                } else {
                    j = createRow;
                }
                Table.nativeSetBoolean(nativePtr, viewPermissionColumnInfo.canViewDetailsIndex, j, viewPermissionRealmProxyInterface.realmGet$canViewDetails(), false);
                realmGet$viewCode = viewPermissionRealmProxyInterface.realmGet$viewDescription();
                if (realmGet$viewCode != null) {
                    Table.nativeSetString(nativePtr, viewPermissionColumnInfo.viewDescriptionIndex, j, realmGet$viewCode, false);
                }
                Table.nativeSetLong(nativePtr, viewPermissionColumnInfo.positionIndex, j, (long) viewPermissionRealmProxyInterface.realmGet$position(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, ViewPermission viewPermission, Map<RealmModel, Long> map) {
        if (viewPermission instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) viewPermission;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm.getTable(ViewPermission.class);
        long nativePtr = table.getNativePtr();
        ViewPermissionColumnInfo viewPermissionColumnInfo = (ViewPermissionColumnInfo) realm.schema.getColumnInfo(ViewPermission.class);
        long createRow = OsObject.createRow(table);
        map.put(viewPermission, Long.valueOf(createRow));
        ViewPermissionRealmProxyInterface viewPermissionRealmProxyInterface = viewPermission;
        String realmGet$viewCode = viewPermissionRealmProxyInterface.realmGet$viewCode();
        if (realmGet$viewCode != null) {
            Table.nativeSetString(nativePtr, viewPermissionColumnInfo.viewCodeIndex, createRow, realmGet$viewCode, false);
        } else {
            Table.nativeSetNull(nativePtr, viewPermissionColumnInfo.viewCodeIndex, createRow, false);
        }
        Table.nativeSetBoolean(nativePtr, viewPermissionColumnInfo.canViewDetailsIndex, createRow, viewPermissionRealmProxyInterface.realmGet$canViewDetails(), false);
        realmGet$viewCode = viewPermissionRealmProxyInterface.realmGet$viewDescription();
        if (realmGet$viewCode != null) {
            Table.nativeSetString(nativePtr, viewPermissionColumnInfo.viewDescriptionIndex, createRow, realmGet$viewCode, false);
        } else {
            Table.nativeSetNull(nativePtr, viewPermissionColumnInfo.viewDescriptionIndex, createRow, false);
        }
        Table.nativeSetLong(nativePtr, viewPermissionColumnInfo.positionIndex, createRow, (long) viewPermissionRealmProxyInterface.realmGet$position(), null);
        return createRow;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Table table = realm2.getTable(ViewPermission.class);
        long nativePtr = table.getNativePtr();
        ViewPermissionColumnInfo viewPermissionColumnInfo = (ViewPermissionColumnInfo) realm2.schema.getColumnInfo(ViewPermission.class);
        while (it.hasNext()) {
            ViewPermission viewPermission = (ViewPermission) it.next();
            if (!map2.containsKey(viewPermission)) {
                long j;
                if (viewPermission instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) viewPermission;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(viewPermission, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(viewPermission, Long.valueOf(createRow));
                ViewPermissionRealmProxyInterface viewPermissionRealmProxyInterface = viewPermission;
                String realmGet$viewCode = viewPermissionRealmProxyInterface.realmGet$viewCode();
                if (realmGet$viewCode != null) {
                    j = createRow;
                    Table.nativeSetString(nativePtr, viewPermissionColumnInfo.viewCodeIndex, createRow, realmGet$viewCode, false);
                } else {
                    j = createRow;
                    Table.nativeSetNull(nativePtr, viewPermissionColumnInfo.viewCodeIndex, j, false);
                }
                Table.nativeSetBoolean(nativePtr, viewPermissionColumnInfo.canViewDetailsIndex, j, viewPermissionRealmProxyInterface.realmGet$canViewDetails(), false);
                realmGet$viewCode = viewPermissionRealmProxyInterface.realmGet$viewDescription();
                if (realmGet$viewCode != null) {
                    Table.nativeSetString(nativePtr, viewPermissionColumnInfo.viewDescriptionIndex, j, realmGet$viewCode, false);
                } else {
                    Table.nativeSetNull(nativePtr, viewPermissionColumnInfo.viewDescriptionIndex, j, false);
                }
                Table.nativeSetLong(nativePtr, viewPermissionColumnInfo.positionIndex, j, (long) viewPermissionRealmProxyInterface.realmGet$position(), false);
            }
        }
    }

    public static ViewPermission createDetachedCopy(ViewPermission viewPermission, int i, int i2, Map<RealmModel, CacheData<RealmModel>> map) {
        if (i <= i2) {
            if (viewPermission != null) {
                CacheData cacheData = (CacheData) map.get(viewPermission);
                if (cacheData == null) {
                    i2 = new ViewPermission();
                    map.put(viewPermission, new CacheData(i, i2));
                } else if (i >= cacheData.minDepth) {
                    return cacheData.object;
                } else {
                    ViewPermission viewPermission2 = (ViewPermission) cacheData.object;
                    cacheData.minDepth = i;
                    i2 = viewPermission2;
                }
                ViewPermissionRealmProxyInterface viewPermissionRealmProxyInterface = (ViewPermissionRealmProxyInterface) i2;
                ViewPermissionRealmProxyInterface viewPermissionRealmProxyInterface2 = viewPermission;
                viewPermissionRealmProxyInterface.realmSet$viewCode(viewPermissionRealmProxyInterface2.realmGet$viewCode());
                viewPermissionRealmProxyInterface.realmSet$canViewDetails(viewPermissionRealmProxyInterface2.realmGet$canViewDetails());
                viewPermissionRealmProxyInterface.realmSet$viewDescription(viewPermissionRealmProxyInterface2.realmGet$viewDescription());
                viewPermissionRealmProxyInterface.realmSet$position(viewPermissionRealmProxyInterface2.realmGet$position());
                return i2;
            }
        }
        return null;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ViewPermission = proxy[");
        stringBuilder.append("{viewCode:");
        stringBuilder.append(realmGet$viewCode() != null ? realmGet$viewCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{canViewDetails:");
        stringBuilder.append(realmGet$canViewDetails());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{viewDescription:");
        stringBuilder.append(realmGet$viewDescription() != null ? realmGet$viewDescription() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{position:");
        stringBuilder.append(realmGet$position());
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
        r7 = (io.realm.ViewPermissionRealmProxy) r7;
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
        throw new UnsupportedOperationException("Method not decompiled: io.realm.ViewPermissionRealmProxy.equals(java.lang.Object):boolean");
    }
}
