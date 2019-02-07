package io.realm.internal;

import io.realm.RealmModel;
import io.realm.internal.util.Pair;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class ColumnIndices {
    private final Map<Class<? extends RealmModel>, ColumnInfo> classes;
    private final Map<String, ColumnInfo> classesByName;
    private final Map<Pair<Class<? extends RealmModel>, String>, ColumnInfo> classesToColumnInfo;
    private final boolean mutable;
    private long schemaVersion;

    public ColumnIndices(long j, Map<Pair<Class<? extends RealmModel>, String>, ColumnInfo> map) {
        this(j, new HashMap(map), true);
        for (Entry entry : map.entrySet()) {
            ColumnInfo columnInfo = (ColumnInfo) entry.getValue();
            if (this.mutable == columnInfo.isMutable()) {
                Pair pair = (Pair) entry.getKey();
                this.classes.put(pair.first, columnInfo);
                this.classesByName.put(pair.second, columnInfo);
            } else {
                throw new IllegalArgumentException("ColumnInfo mutability does not match ColumnIndices");
            }
        }
    }

    public ColumnIndices(ColumnIndices columnIndices, boolean z) {
        this(columnIndices.schemaVersion, new HashMap(columnIndices.classesToColumnInfo.size()), z);
        for (Entry entry : columnIndices.classesToColumnInfo.entrySet()) {
            ColumnInfo copy = ((ColumnInfo) entry.getValue()).copy(z);
            Pair pair = (Pair) entry.getKey();
            this.classes.put(pair.first, copy);
            this.classesByName.put(pair.second, copy);
            this.classesToColumnInfo.put(pair, copy);
        }
    }

    private ColumnIndices(long j, Map<Pair<Class<? extends RealmModel>, String>, ColumnInfo> map, boolean z) {
        this.schemaVersion = j;
        this.classesToColumnInfo = map;
        this.mutable = z;
        this.classes = new HashMap(map.size());
        this.classesByName = new HashMap(map.size());
    }

    public long getSchemaVersion() {
        return this.schemaVersion;
    }

    public ColumnInfo getColumnInfo(Class<? extends RealmModel> cls) {
        return (ColumnInfo) this.classes.get(cls);
    }

    public ColumnInfo getColumnInfo(String str) {
        return (ColumnInfo) this.classesByName.get(str);
    }

    @Deprecated
    public long getColumnIndex(Class<? extends RealmModel> cls, String str) {
        cls = getColumnInfo((Class) cls);
        if (cls == null) {
            return -1;
        }
        return cls.getColumnIndex(str);
    }

    public void copyFrom(ColumnIndices columnIndices) {
        if (this.mutable) {
            for (Entry entry : this.classesByName.entrySet()) {
                ColumnInfo columnInfo = (ColumnInfo) columnIndices.classesByName.get(entry.getKey());
                if (columnInfo != null) {
                    ((ColumnInfo) entry.getValue()).copyFrom(columnInfo);
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to copy ColumnIndices cache for class: ");
                    stringBuilder.append((String) entry.getKey());
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
            this.schemaVersion = columnIndices.schemaVersion;
            return;
        }
        throw new UnsupportedOperationException("Attempt to modify immutable cache");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ColumnIndices[");
        stringBuilder.append(this.schemaVersion);
        stringBuilder.append(",");
        stringBuilder.append(this.mutable);
        stringBuilder.append(",");
        if (this.classes != null) {
            Object obj = null;
            for (Entry entry : this.classesByName.entrySet()) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append("->");
                stringBuilder.append(entry.getValue());
                obj = 1;
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
