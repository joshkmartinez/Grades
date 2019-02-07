package io.realm;

import io.realm.internal.ColumnIndices;
import io.realm.internal.ColumnInfo;
import io.realm.internal.Table;
import io.realm.internal.Util;
import io.realm.internal.util.Pair;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class RealmSchema {
    static final String EMPTY_STRING_MSG = "Null or empty class names are not allowed";
    private final Map<Class<? extends RealmModel>, RealmObjectSchema> classToSchema = new HashMap();
    private final Map<Class<? extends RealmModel>, Table> classToTable = new HashMap();
    private ColumnIndices columnIndices;
    private final Map<String, RealmObjectSchema> dynamicClassToSchema = new HashMap();
    private final Map<String, Table> dynamicClassToTable = new HashMap();
    private final BaseRealm realm;

    @Deprecated
    public void close() {
    }

    RealmSchema(BaseRealm baseRealm) {
        this.realm = baseRealm;
    }

    public RealmObjectSchema get(String str) {
        checkEmpty(str, EMPTY_STRING_MSG);
        str = Table.getTableNameForClass(str);
        if (!this.realm.getSharedRealm().hasTable(str)) {
            return null;
        }
        return new RealmObjectSchema(this.realm, this, this.realm.getSharedRealm().getTable(str));
    }

    public Set<RealmObjectSchema> getAll() {
        int size = (int) this.realm.getSharedRealm().size();
        Set<RealmObjectSchema> linkedHashSet = new LinkedHashSet(size);
        for (int i = 0; i < size; i++) {
            String tableName = this.realm.getSharedRealm().getTableName(i);
            if (Table.isModelTable(tableName)) {
                linkedHashSet.add(new RealmObjectSchema(this.realm, this, this.realm.getSharedRealm().getTable(tableName)));
            }
        }
        return linkedHashSet;
    }

    public RealmObjectSchema create(String str) {
        checkEmpty(str, EMPTY_STRING_MSG);
        String tableNameForClass = Table.getTableNameForClass(str);
        if (tableNameForClass.length() <= 56) {
            return new RealmObjectSchema(this.realm, this, this.realm.getSharedRealm().createTable(tableNameForClass));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Class name is too long. Limit is 56 characters: ");
        stringBuilder.append(str.length());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void remove(String str) {
        this.realm.checkNotInSync();
        checkEmpty(str, EMPTY_STRING_MSG);
        String tableNameForClass = Table.getTableNameForClass(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot remove class because it is not in this Realm: ");
        stringBuilder.append(str);
        checkHasTable(str, stringBuilder.toString());
        str = getTable(str);
        if (str.hasPrimaryKey()) {
            str.setPrimaryKey(null);
        }
        this.realm.getSharedRealm().removeTable(tableNameForClass);
    }

    public RealmObjectSchema rename(String str, String str2) {
        this.realm.checkNotInSync();
        checkEmpty(str, "Class names cannot be empty or null");
        checkEmpty(str2, "Class names cannot be empty or null");
        String tableNameForClass = Table.getTableNameForClass(str);
        String tableNameForClass2 = Table.getTableNameForClass(str2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot rename class because it doesn't exist in this Realm: ");
        stringBuilder.append(str);
        checkHasTable(str, stringBuilder.toString());
        if (this.realm.getSharedRealm().hasTable(tableNameForClass2)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(" cannot be renamed because the new class already exists: ");
            stringBuilder2.append(str2);
            throw new IllegalArgumentException(stringBuilder2.toString());
        }
        str = getTable(str);
        if (str.hasPrimaryKey() != null) {
            str2 = str.getColumnName(str.getPrimaryKey());
            str.setPrimaryKey(null);
        } else {
            str2 = null;
        }
        this.realm.getSharedRealm().renameTable(tableNameForClass, tableNameForClass2);
        str = this.realm.getSharedRealm().getTable(tableNameForClass2);
        if (str2 != null) {
            str.setPrimaryKey(str2);
        }
        return new RealmObjectSchema(this.realm, this, str);
    }

    public boolean contains(String str) {
        return this.realm.getSharedRealm().hasTable(Table.getTableNameForClass(str));
    }

    private void checkEmpty(String str, String str2) {
        if (str == null || str.isEmpty() != null) {
            throw new IllegalArgumentException(str2);
        }
    }

    private void checkHasTable(String str, String str2) {
        if (this.realm.getSharedRealm().hasTable(Table.getTableNameForClass(str)) == null) {
            throw new IllegalArgumentException(str2);
        }
    }

    Table getTable(String str) {
        str = Table.getTableNameForClass(str);
        Table table = (Table) this.dynamicClassToTable.get(str);
        if (table != null) {
            return table;
        }
        table = this.realm.getSharedRealm().getTable(str);
        this.dynamicClassToTable.put(str, table);
        return table;
    }

    Table getTable(Class<? extends RealmModel> cls) {
        Table table = (Table) this.classToTable.get(cls);
        if (table != null) {
            return table;
        }
        Class originalModelClass = Util.getOriginalModelClass(cls);
        if (isProxyClass(originalModelClass, cls)) {
            table = (Table) this.classToTable.get(originalModelClass);
        }
        if (table == null) {
            table = this.realm.getSharedRealm().getTable(this.realm.getConfiguration().getSchemaMediator().getTableName(originalModelClass));
            this.classToTable.put(originalModelClass, table);
        }
        if (isProxyClass(originalModelClass, cls)) {
            this.classToTable.put(cls, table);
        }
        return table;
    }

    RealmObjectSchema getSchemaForClass(Class<? extends RealmModel> cls) {
        RealmObjectSchema realmObjectSchema = (RealmObjectSchema) this.classToSchema.get(cls);
        if (realmObjectSchema != null) {
            return realmObjectSchema;
        }
        Class originalModelClass = Util.getOriginalModelClass(cls);
        if (isProxyClass(originalModelClass, cls)) {
            realmObjectSchema = (RealmObjectSchema) this.classToSchema.get(originalModelClass);
        }
        if (realmObjectSchema == null) {
            RealmObjectSchema realmObjectSchema2 = new RealmObjectSchema(this.realm, this, getTable((Class) cls), getColumnInfo(originalModelClass));
            this.classToSchema.put(originalModelClass, realmObjectSchema2);
            realmObjectSchema = realmObjectSchema2;
        }
        if (isProxyClass(originalModelClass, cls)) {
            this.classToSchema.put(cls, realmObjectSchema);
        }
        return realmObjectSchema;
    }

    RealmObjectSchema getSchemaForClass(String str) {
        String tableNameForClass = Table.getTableNameForClass(str);
        RealmObjectSchema realmObjectSchema = (RealmObjectSchema) this.dynamicClassToSchema.get(tableNameForClass);
        if (realmObjectSchema != null) {
            return realmObjectSchema;
        }
        if (this.realm.getSharedRealm().hasTable(tableNameForClass)) {
            realmObjectSchema = new RealmObjectSchema(this.realm, this, this.realm.getSharedRealm().getTable(tableNameForClass));
            this.dynamicClassToSchema.put(tableNameForClass, realmObjectSchema);
            return realmObjectSchema;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The class ");
        stringBuilder.append(str);
        stringBuilder.append(" doesn't exist in this Realm.");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    final void setInitialColumnIndices(ColumnIndices columnIndices) {
        if (this.columnIndices == null) {
            this.columnIndices = new ColumnIndices(columnIndices, true);
            return;
        }
        throw new IllegalStateException("An instance of ColumnIndices is already set.");
    }

    final void setInitialColumnIndices(long j, Map<Pair<Class<? extends RealmModel>, String>, ColumnInfo> map) {
        if (this.columnIndices == null) {
            this.columnIndices = new ColumnIndices(j, (Map) map);
            return;
        }
        throw new IllegalStateException("An instance of ColumnIndices is already set.");
    }

    void updateColumnIndices(ColumnIndices columnIndices) {
        this.columnIndices.copyFrom(columnIndices);
    }

    final boolean isProxyClass(Class<? extends RealmModel> cls, Class<? extends RealmModel> cls2) {
        return cls.equals(cls2);
    }

    final ColumnIndices getImmutableColumnIndicies() {
        checkIndices();
        return new ColumnIndices(this.columnIndices, false);
    }

    final boolean haveColumnInfo() {
        return this.columnIndices != null;
    }

    final long getSchemaVersion() {
        checkIndices();
        return this.columnIndices.getSchemaVersion();
    }

    final ColumnInfo getColumnInfo(Class<? extends RealmModel> cls) {
        checkIndices();
        return this.columnIndices.getColumnInfo((Class) cls);
    }

    protected final ColumnInfo getColumnInfo(String str) {
        checkIndices();
        return this.columnIndices.getColumnInfo(str);
    }

    private void checkIndices() {
        if (!haveColumnInfo()) {
            throw new IllegalStateException("Attempt to use column index before set.");
        }
    }
}
