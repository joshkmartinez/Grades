package io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.aeries.mobileportal.models.GenericAddress;
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

public class GenericAddressRealmProxy extends GenericAddress implements RealmObjectProxy, GenericAddressRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private GenericAddressColumnInfo columnInfo;
    private ProxyState<GenericAddress> proxyState;

    static final class GenericAddressColumnInfo extends ColumnInfo {
        long addressIndex;
        long cityIndex;
        long stateIndex;
        long typeCodeIndex;
        long typeDescriptionIndex;
        long zipCodeIndex;
        long zipExtIndex;

        GenericAddressColumnInfo(SharedRealm sharedRealm, Table table) {
            super(7);
            this.addressIndex = addColumnDetails(table, "address", RealmFieldType.STRING);
            this.cityIndex = addColumnDetails(table, "city", RealmFieldType.STRING);
            this.stateIndex = addColumnDetails(table, "state", RealmFieldType.STRING);
            this.zipCodeIndex = addColumnDetails(table, "zipCode", RealmFieldType.STRING);
            this.zipExtIndex = addColumnDetails(table, "zipExt", RealmFieldType.STRING);
            this.typeCodeIndex = addColumnDetails(table, "typeCode", RealmFieldType.STRING);
            this.typeDescriptionIndex = addColumnDetails(table, "typeDescription", RealmFieldType.STRING);
        }

        GenericAddressColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        protected final ColumnInfo copy(boolean z) {
            return new GenericAddressColumnInfo((ColumnInfo) this, z);
        }

        protected final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            GenericAddressColumnInfo genericAddressColumnInfo = (GenericAddressColumnInfo) columnInfo;
            GenericAddressColumnInfo genericAddressColumnInfo2 = (GenericAddressColumnInfo) columnInfo2;
            genericAddressColumnInfo2.addressIndex = genericAddressColumnInfo.addressIndex;
            genericAddressColumnInfo2.cityIndex = genericAddressColumnInfo.cityIndex;
            genericAddressColumnInfo2.stateIndex = genericAddressColumnInfo.stateIndex;
            genericAddressColumnInfo2.zipCodeIndex = genericAddressColumnInfo.zipCodeIndex;
            genericAddressColumnInfo2.zipExtIndex = genericAddressColumnInfo.zipExtIndex;
            genericAddressColumnInfo2.typeCodeIndex = genericAddressColumnInfo.typeCodeIndex;
            genericAddressColumnInfo2.typeDescriptionIndex = genericAddressColumnInfo.typeDescriptionIndex;
        }
    }

    public static String getTableName() {
        return "class_GenericAddress";
    }

    static {
        List arrayList = new ArrayList();
        arrayList.add("address");
        arrayList.add("city");
        arrayList.add("state");
        arrayList.add("zipCode");
        arrayList.add("zipExt");
        arrayList.add("typeCode");
        arrayList.add("typeDescription");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    GenericAddressRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (GenericAddressColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public String realmGet$address() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.addressIndex);
    }

    public void realmSet$address(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.addressIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.addressIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.addressIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.addressIndex, row$realm.getIndex(), str, true);
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

    public String realmGet$zipExt() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.zipExtIndex);
    }

    public void realmSet$zipExt(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.zipExtIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.zipExtIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.zipExtIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.zipExtIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$typeCode() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.typeCodeIndex);
    }

    public void realmSet$typeCode(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.typeCodeIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.typeCodeIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.typeCodeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.typeCodeIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$typeDescription() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.typeDescriptionIndex);
    }

    public void realmSet$typeDescription(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.typeDescriptionIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.typeDescriptionIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.typeDescriptionIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.typeDescriptionIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        Builder builder = new Builder("GenericAddress");
        Builder builder2 = builder;
        builder2.addProperty("address", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("city", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("state", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("zipCode", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("zipExt", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("typeCode", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("typeDescription", RealmFieldType.STRING, false, false, false);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static GenericAddressColumnInfo validateTable(SharedRealm sharedRealm, boolean z) {
        if (sharedRealm.hasTable("class_GenericAddress")) {
            Table table = sharedRealm.getTable("class_GenericAddress");
            long columnCount = table.getColumnCount();
            if (columnCount != 7) {
                StringBuilder stringBuilder;
                if (columnCount < 7) {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is less than expected - expected 7 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                } else if (z) {
                    RealmLog.debug("Field count is more than expected - expected 7 but was %1$d", Long.valueOf(columnCount));
                } else {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is more than expected - expected 7 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                }
            }
            z = new HashMap();
            for (long j = 0; j < columnCount; j++) {
                z.put(table.getColumnName(j), table.getColumnType(j));
            }
            GenericAddressColumnInfo genericAddressColumnInfo = new GenericAddressColumnInfo(sharedRealm, table);
            if (table.hasPrimaryKey()) {
                sharedRealm = sharedRealm.getPath();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Primary Key defined for field ");
                stringBuilder2.append(table.getColumnName(table.getPrimaryKey()));
                stringBuilder2.append(" was removed.");
                throw new RealmMigrationNeededException(sharedRealm, stringBuilder2.toString());
            } else if (!z.containsKey("address")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'address' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("address") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'address' in existing Realm file.");
            } else if (!table.isColumnNullable(genericAddressColumnInfo.addressIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'address' is required. Either set @Required to field 'address' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("city")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'city' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("city") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'city' in existing Realm file.");
            } else if (!table.isColumnNullable(genericAddressColumnInfo.cityIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'city' is required. Either set @Required to field 'city' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("state")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'state' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("state") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'state' in existing Realm file.");
            } else if (!table.isColumnNullable(genericAddressColumnInfo.stateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'state' is required. Either set @Required to field 'state' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("zipCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'zipCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("zipCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'zipCode' in existing Realm file.");
            } else if (!table.isColumnNullable(genericAddressColumnInfo.zipCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'zipCode' is required. Either set @Required to field 'zipCode' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("zipExt")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'zipExt' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("zipExt") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'zipExt' in existing Realm file.");
            } else if (!table.isColumnNullable(genericAddressColumnInfo.zipExtIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'zipExt' is required. Either set @Required to field 'zipExt' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("typeCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'typeCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("typeCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'typeCode' in existing Realm file.");
            } else if (!table.isColumnNullable(genericAddressColumnInfo.typeCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'typeCode' is required. Either set @Required to field 'typeCode' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("typeDescription")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'typeDescription' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("typeDescription") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'typeDescription' in existing Realm file.");
            } else if (table.isColumnNullable(genericAddressColumnInfo.typeDescriptionIndex)) {
                return genericAddressColumnInfo;
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'typeDescription' is required. Either set @Required to field 'typeDescription' or migrate using RealmObjectSchema.setNullable().");
            }
        }
        throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'GenericAddress' class is missing from the schema for this Realm.");
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static GenericAddress createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        GenericAddress genericAddress = (GenericAddress) realm.createObjectInternal(GenericAddress.class, true, Collections.emptyList());
        if (jSONObject.has("address")) {
            if (jSONObject.isNull("address")) {
                genericAddress.realmSet$address(null);
            } else {
                genericAddress.realmSet$address(jSONObject.getString("address"));
            }
        }
        if (jSONObject.has("city")) {
            if (jSONObject.isNull("city")) {
                genericAddress.realmSet$city(null);
            } else {
                genericAddress.realmSet$city(jSONObject.getString("city"));
            }
        }
        if (jSONObject.has("state")) {
            if (jSONObject.isNull("state")) {
                genericAddress.realmSet$state(null);
            } else {
                genericAddress.realmSet$state(jSONObject.getString("state"));
            }
        }
        if (jSONObject.has("zipCode")) {
            if (jSONObject.isNull("zipCode")) {
                genericAddress.realmSet$zipCode(null);
            } else {
                genericAddress.realmSet$zipCode(jSONObject.getString("zipCode"));
            }
        }
        if (jSONObject.has("zipExt")) {
            if (jSONObject.isNull("zipExt")) {
                genericAddress.realmSet$zipExt(null);
            } else {
                genericAddress.realmSet$zipExt(jSONObject.getString("zipExt"));
            }
        }
        if (jSONObject.has("typeCode")) {
            if (jSONObject.isNull("typeCode")) {
                genericAddress.realmSet$typeCode(null);
            } else {
                genericAddress.realmSet$typeCode(jSONObject.getString("typeCode"));
            }
        }
        if (jSONObject.has("typeDescription")) {
            if (jSONObject.isNull("typeDescription")) {
                genericAddress.realmSet$typeDescription(null);
            } else {
                genericAddress.realmSet$typeDescription(jSONObject.getString("typeDescription"));
            }
        }
        return genericAddress;
    }

    @TargetApi(11)
    public static GenericAddress createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RealmModel genericAddress = new GenericAddress();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("address")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((GenericAddressRealmProxyInterface) genericAddress).realmSet$address(null);
                } else {
                    ((GenericAddressRealmProxyInterface) genericAddress).realmSet$address(jsonReader.nextString());
                }
            } else if (nextName.equals("city")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((GenericAddressRealmProxyInterface) genericAddress).realmSet$city(null);
                } else {
                    ((GenericAddressRealmProxyInterface) genericAddress).realmSet$city(jsonReader.nextString());
                }
            } else if (nextName.equals("state")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((GenericAddressRealmProxyInterface) genericAddress).realmSet$state(null);
                } else {
                    ((GenericAddressRealmProxyInterface) genericAddress).realmSet$state(jsonReader.nextString());
                }
            } else if (nextName.equals("zipCode")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((GenericAddressRealmProxyInterface) genericAddress).realmSet$zipCode(null);
                } else {
                    ((GenericAddressRealmProxyInterface) genericAddress).realmSet$zipCode(jsonReader.nextString());
                }
            } else if (nextName.equals("zipExt")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((GenericAddressRealmProxyInterface) genericAddress).realmSet$zipExt(null);
                } else {
                    ((GenericAddressRealmProxyInterface) genericAddress).realmSet$zipExt(jsonReader.nextString());
                }
            } else if (nextName.equals("typeCode")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((GenericAddressRealmProxyInterface) genericAddress).realmSet$typeCode(null);
                } else {
                    ((GenericAddressRealmProxyInterface) genericAddress).realmSet$typeCode(jsonReader.nextString());
                }
            } else if (!nextName.equals("typeDescription")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.skipValue();
                ((GenericAddressRealmProxyInterface) genericAddress).realmSet$typeDescription(null);
            } else {
                ((GenericAddressRealmProxyInterface) genericAddress).realmSet$typeDescription(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return (GenericAddress) realm.copyToRealm(genericAddress);
    }

    public static GenericAddress copyOrUpdate(Realm realm, GenericAddress genericAddress, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy;
        boolean z2 = genericAddress instanceof RealmObjectProxy;
        if (z2) {
            RealmObjectProxy realmObjectProxy2 = (RealmObjectProxy) genericAddress;
            if (realmObjectProxy2.realmGet$proxyState().getRealm$realm() != null) {
                if (realmObjectProxy2.realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                }
            }
        }
        if (z2) {
            realmObjectProxy = (RealmObjectProxy) genericAddress;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return genericAddress;
            }
        }
        RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectProxy = (RealmObjectProxy) map.get(genericAddress);
        if (realmObjectProxy != null) {
            return (GenericAddress) realmObjectProxy;
        }
        return copy(realm, genericAddress, z, map);
    }

    public static GenericAddress copy(Realm realm, GenericAddress genericAddress, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = (RealmObjectProxy) map.get(genericAddress);
        if (realmObjectProxy != null) {
            return (GenericAddress) realmObjectProxy;
        }
        GenericAddress genericAddress2 = (GenericAddress) realm.createObjectInternal(GenericAddress.class, false, Collections.emptyList());
        map.put(genericAddress, (RealmObjectProxy) genericAddress2);
        GenericAddressRealmProxyInterface genericAddressRealmProxyInterface = genericAddress;
        GenericAddressRealmProxyInterface genericAddressRealmProxyInterface2 = genericAddress2;
        genericAddressRealmProxyInterface2.realmSet$address(genericAddressRealmProxyInterface.realmGet$address());
        genericAddressRealmProxyInterface2.realmSet$city(genericAddressRealmProxyInterface.realmGet$city());
        genericAddressRealmProxyInterface2.realmSet$state(genericAddressRealmProxyInterface.realmGet$state());
        genericAddressRealmProxyInterface2.realmSet$zipCode(genericAddressRealmProxyInterface.realmGet$zipCode());
        genericAddressRealmProxyInterface2.realmSet$zipExt(genericAddressRealmProxyInterface.realmGet$zipExt());
        genericAddressRealmProxyInterface2.realmSet$typeCode(genericAddressRealmProxyInterface.realmGet$typeCode());
        genericAddressRealmProxyInterface2.realmSet$typeDescription(genericAddressRealmProxyInterface.realmGet$typeDescription());
        return genericAddress2;
    }

    public static long insert(Realm realm, GenericAddress genericAddress, Map<RealmModel, Long> map) {
        if (genericAddress instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) genericAddress;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm.getTable(GenericAddress.class);
        long nativePtr = table.getNativePtr();
        GenericAddressColumnInfo genericAddressColumnInfo = (GenericAddressColumnInfo) realm.schema.getColumnInfo(GenericAddress.class);
        long createRow = OsObject.createRow(table);
        map.put(genericAddress, Long.valueOf(createRow));
        GenericAddressRealmProxyInterface genericAddressRealmProxyInterface = genericAddress;
        String realmGet$address = genericAddressRealmProxyInterface.realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(nativePtr, genericAddressColumnInfo.addressIndex, createRow, realmGet$address, false);
        }
        realmGet$address = genericAddressRealmProxyInterface.realmGet$city();
        if (realmGet$address != null) {
            Table.nativeSetString(nativePtr, genericAddressColumnInfo.cityIndex, createRow, realmGet$address, false);
        }
        realmGet$address = genericAddressRealmProxyInterface.realmGet$state();
        if (realmGet$address != null) {
            Table.nativeSetString(nativePtr, genericAddressColumnInfo.stateIndex, createRow, realmGet$address, false);
        }
        realmGet$address = genericAddressRealmProxyInterface.realmGet$zipCode();
        if (realmGet$address != null) {
            Table.nativeSetString(nativePtr, genericAddressColumnInfo.zipCodeIndex, createRow, realmGet$address, false);
        }
        realmGet$address = genericAddressRealmProxyInterface.realmGet$zipExt();
        if (realmGet$address != null) {
            Table.nativeSetString(nativePtr, genericAddressColumnInfo.zipExtIndex, createRow, realmGet$address, false);
        }
        realmGet$address = genericAddressRealmProxyInterface.realmGet$typeCode();
        if (realmGet$address != null) {
            Table.nativeSetString(nativePtr, genericAddressColumnInfo.typeCodeIndex, createRow, realmGet$address, false);
        }
        realmGet$address = genericAddressRealmProxyInterface.realmGet$typeDescription();
        if (realmGet$address != null) {
            Table.nativeSetString(nativePtr, genericAddressColumnInfo.typeDescriptionIndex, createRow, realmGet$address, false);
        }
        return createRow;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Table table = realm2.getTable(GenericAddress.class);
        long nativePtr = table.getNativePtr();
        GenericAddressColumnInfo genericAddressColumnInfo = (GenericAddressColumnInfo) realm2.schema.getColumnInfo(GenericAddress.class);
        while (it.hasNext()) {
            GenericAddress genericAddress = (GenericAddress) it.next();
            if (!map2.containsKey(genericAddress)) {
                GenericAddressRealmProxyInterface genericAddressRealmProxyInterface;
                if (genericAddress instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) genericAddress;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(genericAddress, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(genericAddress, Long.valueOf(createRow));
                GenericAddressRealmProxyInterface genericAddressRealmProxyInterface2 = genericAddress;
                String realmGet$address = genericAddressRealmProxyInterface2.realmGet$address();
                if (realmGet$address != null) {
                    genericAddressRealmProxyInterface = genericAddressRealmProxyInterface2;
                    Table.nativeSetString(nativePtr, genericAddressColumnInfo.addressIndex, createRow, realmGet$address, false);
                } else {
                    genericAddressRealmProxyInterface = genericAddressRealmProxyInterface2;
                }
                realmGet$address = genericAddressRealmProxyInterface.realmGet$city();
                if (realmGet$address != null) {
                    Table.nativeSetString(nativePtr, genericAddressColumnInfo.cityIndex, createRow, realmGet$address, false);
                }
                realmGet$address = genericAddressRealmProxyInterface.realmGet$state();
                if (realmGet$address != null) {
                    Table.nativeSetString(nativePtr, genericAddressColumnInfo.stateIndex, createRow, realmGet$address, false);
                }
                realmGet$address = genericAddressRealmProxyInterface.realmGet$zipCode();
                if (realmGet$address != null) {
                    Table.nativeSetString(nativePtr, genericAddressColumnInfo.zipCodeIndex, createRow, realmGet$address, false);
                }
                realmGet$address = genericAddressRealmProxyInterface.realmGet$zipExt();
                if (realmGet$address != null) {
                    Table.nativeSetString(nativePtr, genericAddressColumnInfo.zipExtIndex, createRow, realmGet$address, false);
                }
                realmGet$address = genericAddressRealmProxyInterface.realmGet$typeCode();
                if (realmGet$address != null) {
                    Table.nativeSetString(nativePtr, genericAddressColumnInfo.typeCodeIndex, createRow, realmGet$address, false);
                }
                realmGet$address = genericAddressRealmProxyInterface.realmGet$typeDescription();
                if (realmGet$address != null) {
                    Table.nativeSetString(nativePtr, genericAddressColumnInfo.typeDescriptionIndex, createRow, realmGet$address, false);
                }
                realm2 = realm;
            }
        }
    }

    public static long insertOrUpdate(Realm realm, GenericAddress genericAddress, Map<RealmModel, Long> map) {
        if (genericAddress instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) genericAddress;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm.getTable(GenericAddress.class);
        long nativePtr = table.getNativePtr();
        GenericAddressColumnInfo genericAddressColumnInfo = (GenericAddressColumnInfo) realm.schema.getColumnInfo(GenericAddress.class);
        long createRow = OsObject.createRow(table);
        map.put(genericAddress, Long.valueOf(createRow));
        GenericAddressRealmProxyInterface genericAddressRealmProxyInterface = genericAddress;
        String realmGet$address = genericAddressRealmProxyInterface.realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(nativePtr, genericAddressColumnInfo.addressIndex, createRow, realmGet$address, false);
        } else {
            Table.nativeSetNull(nativePtr, genericAddressColumnInfo.addressIndex, createRow, false);
        }
        realmGet$address = genericAddressRealmProxyInterface.realmGet$city();
        if (realmGet$address != null) {
            Table.nativeSetString(nativePtr, genericAddressColumnInfo.cityIndex, createRow, realmGet$address, false);
        } else {
            Table.nativeSetNull(nativePtr, genericAddressColumnInfo.cityIndex, createRow, false);
        }
        realmGet$address = genericAddressRealmProxyInterface.realmGet$state();
        if (realmGet$address != null) {
            Table.nativeSetString(nativePtr, genericAddressColumnInfo.stateIndex, createRow, realmGet$address, false);
        } else {
            Table.nativeSetNull(nativePtr, genericAddressColumnInfo.stateIndex, createRow, false);
        }
        realmGet$address = genericAddressRealmProxyInterface.realmGet$zipCode();
        if (realmGet$address != null) {
            Table.nativeSetString(nativePtr, genericAddressColumnInfo.zipCodeIndex, createRow, realmGet$address, false);
        } else {
            Table.nativeSetNull(nativePtr, genericAddressColumnInfo.zipCodeIndex, createRow, false);
        }
        realmGet$address = genericAddressRealmProxyInterface.realmGet$zipExt();
        if (realmGet$address != null) {
            Table.nativeSetString(nativePtr, genericAddressColumnInfo.zipExtIndex, createRow, realmGet$address, false);
        } else {
            Table.nativeSetNull(nativePtr, genericAddressColumnInfo.zipExtIndex, createRow, false);
        }
        realmGet$address = genericAddressRealmProxyInterface.realmGet$typeCode();
        if (realmGet$address != null) {
            Table.nativeSetString(nativePtr, genericAddressColumnInfo.typeCodeIndex, createRow, realmGet$address, false);
        } else {
            Table.nativeSetNull(nativePtr, genericAddressColumnInfo.typeCodeIndex, createRow, false);
        }
        realmGet$address = genericAddressRealmProxyInterface.realmGet$typeDescription();
        if (realmGet$address != null) {
            Table.nativeSetString(nativePtr, genericAddressColumnInfo.typeDescriptionIndex, createRow, realmGet$address, false);
        } else {
            Table.nativeSetNull(nativePtr, genericAddressColumnInfo.typeDescriptionIndex, createRow, false);
        }
        return createRow;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Table table = realm2.getTable(GenericAddress.class);
        long nativePtr = table.getNativePtr();
        GenericAddressColumnInfo genericAddressColumnInfo = (GenericAddressColumnInfo) realm2.schema.getColumnInfo(GenericAddress.class);
        while (it.hasNext()) {
            GenericAddress genericAddress = (GenericAddress) it.next();
            if (!map2.containsKey(genericAddress)) {
                GenericAddressRealmProxyInterface genericAddressRealmProxyInterface;
                if (genericAddress instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) genericAddress;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(genericAddress, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(genericAddress, Long.valueOf(createRow));
                GenericAddressRealmProxyInterface genericAddressRealmProxyInterface2 = genericAddress;
                String realmGet$address = genericAddressRealmProxyInterface2.realmGet$address();
                if (realmGet$address != null) {
                    genericAddressRealmProxyInterface = genericAddressRealmProxyInterface2;
                    Table.nativeSetString(nativePtr, genericAddressColumnInfo.addressIndex, createRow, realmGet$address, false);
                } else {
                    genericAddressRealmProxyInterface = genericAddressRealmProxyInterface2;
                    Table.nativeSetNull(nativePtr, genericAddressColumnInfo.addressIndex, createRow, false);
                }
                realmGet$address = genericAddressRealmProxyInterface.realmGet$city();
                if (realmGet$address != null) {
                    Table.nativeSetString(nativePtr, genericAddressColumnInfo.cityIndex, createRow, realmGet$address, false);
                } else {
                    Table.nativeSetNull(nativePtr, genericAddressColumnInfo.cityIndex, createRow, false);
                }
                realmGet$address = genericAddressRealmProxyInterface.realmGet$state();
                if (realmGet$address != null) {
                    Table.nativeSetString(nativePtr, genericAddressColumnInfo.stateIndex, createRow, realmGet$address, false);
                } else {
                    Table.nativeSetNull(nativePtr, genericAddressColumnInfo.stateIndex, createRow, false);
                }
                realmGet$address = genericAddressRealmProxyInterface.realmGet$zipCode();
                if (realmGet$address != null) {
                    Table.nativeSetString(nativePtr, genericAddressColumnInfo.zipCodeIndex, createRow, realmGet$address, false);
                } else {
                    Table.nativeSetNull(nativePtr, genericAddressColumnInfo.zipCodeIndex, createRow, false);
                }
                realmGet$address = genericAddressRealmProxyInterface.realmGet$zipExt();
                if (realmGet$address != null) {
                    Table.nativeSetString(nativePtr, genericAddressColumnInfo.zipExtIndex, createRow, realmGet$address, false);
                } else {
                    Table.nativeSetNull(nativePtr, genericAddressColumnInfo.zipExtIndex, createRow, false);
                }
                realmGet$address = genericAddressRealmProxyInterface.realmGet$typeCode();
                if (realmGet$address != null) {
                    Table.nativeSetString(nativePtr, genericAddressColumnInfo.typeCodeIndex, createRow, realmGet$address, false);
                } else {
                    Table.nativeSetNull(nativePtr, genericAddressColumnInfo.typeCodeIndex, createRow, false);
                }
                realmGet$address = genericAddressRealmProxyInterface.realmGet$typeDescription();
                if (realmGet$address != null) {
                    Table.nativeSetString(nativePtr, genericAddressColumnInfo.typeDescriptionIndex, createRow, realmGet$address, false);
                } else {
                    Table.nativeSetNull(nativePtr, genericAddressColumnInfo.typeDescriptionIndex, createRow, false);
                }
                realm2 = realm;
            }
        }
    }

    public static GenericAddress createDetachedCopy(GenericAddress genericAddress, int i, int i2, Map<RealmModel, CacheData<RealmModel>> map) {
        if (i <= i2) {
            if (genericAddress != null) {
                CacheData cacheData = (CacheData) map.get(genericAddress);
                if (cacheData == null) {
                    i2 = new GenericAddress();
                    map.put(genericAddress, new CacheData(i, i2));
                } else if (i >= cacheData.minDepth) {
                    return cacheData.object;
                } else {
                    GenericAddress genericAddress2 = (GenericAddress) cacheData.object;
                    cacheData.minDepth = i;
                    i2 = genericAddress2;
                }
                GenericAddressRealmProxyInterface genericAddressRealmProxyInterface = (GenericAddressRealmProxyInterface) i2;
                GenericAddressRealmProxyInterface genericAddressRealmProxyInterface2 = genericAddress;
                genericAddressRealmProxyInterface.realmSet$address(genericAddressRealmProxyInterface2.realmGet$address());
                genericAddressRealmProxyInterface.realmSet$city(genericAddressRealmProxyInterface2.realmGet$city());
                genericAddressRealmProxyInterface.realmSet$state(genericAddressRealmProxyInterface2.realmGet$state());
                genericAddressRealmProxyInterface.realmSet$zipCode(genericAddressRealmProxyInterface2.realmGet$zipCode());
                genericAddressRealmProxyInterface.realmSet$zipExt(genericAddressRealmProxyInterface2.realmGet$zipExt());
                genericAddressRealmProxyInterface.realmSet$typeCode(genericAddressRealmProxyInterface2.realmGet$typeCode());
                genericAddressRealmProxyInterface.realmSet$typeDescription(genericAddressRealmProxyInterface2.realmGet$typeDescription());
                return i2;
            }
        }
        return null;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("GenericAddress = proxy[");
        stringBuilder.append("{address:");
        stringBuilder.append(realmGet$address() != null ? realmGet$address() : "null");
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
        stringBuilder.append("{zipExt:");
        stringBuilder.append(realmGet$zipExt() != null ? realmGet$zipExt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{typeCode:");
        stringBuilder.append(realmGet$typeCode() != null ? realmGet$typeCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{typeDescription:");
        stringBuilder.append(realmGet$typeDescription() != null ? realmGet$typeDescription() : "null");
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
        r7 = (io.realm.GenericAddressRealmProxy) r7;
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
        throw new UnsupportedOperationException("Method not decompiled: io.realm.GenericAddressRealmProxy.equals(java.lang.Object):boolean");
    }
}
