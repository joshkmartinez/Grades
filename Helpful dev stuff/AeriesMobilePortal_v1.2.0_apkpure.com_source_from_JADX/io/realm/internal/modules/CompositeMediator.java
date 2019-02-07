package io.realm.internal.modules;

import android.util.JsonReader;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmObjectProxy.CacheData;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Util;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class CompositeMediator extends RealmProxyMediator {
    private final Map<Class<? extends RealmModel>, RealmProxyMediator> mediators;

    public CompositeMediator(RealmProxyMediator... realmProxyMediatorArr) {
        Map hashMap = new HashMap();
        if (realmProxyMediatorArr != null) {
            for (RealmProxyMediator realmProxyMediator : realmProxyMediatorArr) {
                for (Class put : realmProxyMediator.getModelClasses()) {
                    hashMap.put(put, realmProxyMediator);
                }
            }
        }
        this.mediators = Collections.unmodifiableMap(hashMap);
    }

    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> hashMap = new HashMap();
        for (RealmProxyMediator expectedObjectSchemaInfoMap : this.mediators.values()) {
            hashMap.putAll(expectedObjectSchemaInfoMap.getExpectedObjectSchemaInfoMap());
        }
        return hashMap;
    }

    public ColumnInfo validateTable(Class<? extends RealmModel> cls, SharedRealm sharedRealm, boolean z) {
        return getMediator(cls).validateTable(cls, sharedRealm, z);
    }

    public List<String> getFieldNames(Class<? extends RealmModel> cls) {
        return getMediator(cls).getFieldNames(cls);
    }

    public String getTableName(Class<? extends RealmModel> cls) {
        return getMediator(cls).getTableName(cls);
    }

    public <E extends RealmModel> E newInstance(Class<E> cls, Object obj, Row row, ColumnInfo columnInfo, boolean z, List<String> list) {
        return getMediator(cls).newInstance(cls, obj, row, columnInfo, z, list);
    }

    public Set<Class<? extends RealmModel>> getModelClasses() {
        return this.mediators.keySet();
    }

    public <E extends RealmModel> E copyOrUpdate(Realm realm, E e, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        return getMediator(Util.getOriginalModelClass(e.getClass())).copyOrUpdate(realm, e, z, map);
    }

    public void insert(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map) {
        getMediator(Util.getOriginalModelClass(realmModel.getClass())).insert(realm, realmModel, map);
    }

    public void insert(Realm realm, Collection<? extends RealmModel> collection) {
        getMediator(Util.getOriginalModelClass(Util.getOriginalModelClass(((RealmModel) collection.iterator().next()).getClass()))).insert(realm, collection);
    }

    public void insertOrUpdate(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map) {
        getMediator(Util.getOriginalModelClass(realmModel.getClass())).insertOrUpdate(realm, realmModel, map);
    }

    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> collection) {
        getMediator(Util.getOriginalModelClass(Util.getOriginalModelClass(((RealmModel) collection.iterator().next()).getClass()))).insertOrUpdate(realm, collection);
    }

    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> cls, Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        return getMediator(cls).createOrUpdateUsingJsonObject(cls, realm, jSONObject, z);
    }

    public <E extends RealmModel> E createUsingJsonStream(Class<E> cls, Realm realm, JsonReader jsonReader) throws IOException {
        return getMediator(cls).createUsingJsonStream(cls, realm, jsonReader);
    }

    public <E extends RealmModel> E createDetachedCopy(E e, int i, Map<RealmModel, CacheData<RealmModel>> map) {
        return getMediator(Util.getOriginalModelClass(e.getClass())).createDetachedCopy(e, i, map);
    }

    public boolean transformerApplied() {
        for (Entry value : this.mediators.entrySet()) {
            if (!((RealmProxyMediator) value.getValue()).transformerApplied()) {
                return false;
            }
        }
        return true;
    }

    private RealmProxyMediator getMediator(Class<? extends RealmModel> cls) {
        RealmProxyMediator realmProxyMediator = (RealmProxyMediator) this.mediators.get(cls);
        if (realmProxyMediator != null) {
            return realmProxyMediator;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cls.getSimpleName());
        stringBuilder.append(" is not part of the schema for this Realm");
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
