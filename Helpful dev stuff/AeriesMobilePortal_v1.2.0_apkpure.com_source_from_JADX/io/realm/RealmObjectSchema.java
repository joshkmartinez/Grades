package io.realm;

import io.realm.internal.ColumnInfo;
import io.realm.internal.Table;
import io.realm.internal.fields.FieldDescriptor;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class RealmObjectSchema {
    private static final Map<Class<?>, FieldMetaData> SUPPORTED_LINKED_FIELDS;
    private static final Map<Class<?>, FieldMetaData> SUPPORTED_SIMPLE_FIELDS;
    private final ColumnInfo columnInfo;
    private final BaseRealm realm;
    private final RealmSchema schema;
    private final Table table;

    private static final class FieldMetaData {
        final boolean defaultNullable;
        final RealmFieldType realmType;

        FieldMetaData(RealmFieldType realmFieldType, boolean z) {
            this.realmType = realmFieldType;
            this.defaultNullable = z;
        }
    }

    public interface Function {
        void apply(DynamicRealmObject dynamicRealmObject);
    }

    private static final class DynamicColumnIndices extends ColumnInfo {
        private final Table table;

        DynamicColumnIndices(Table table) {
            super(null, false);
            this.table = table;
        }

        public long getColumnIndex(String str) {
            return this.table.getColumnIndex(str);
        }

        public RealmFieldType getColumnType(String str) {
            throw new UnsupportedOperationException("DynamicColumnIndices do not support 'getColumnType'");
        }

        public String getLinkedTable(String str) {
            throw new UnsupportedOperationException("DynamicColumnIndices do not support 'getLinkedTable'");
        }

        public void copyFrom(ColumnInfo columnInfo) {
            throw new UnsupportedOperationException("DynamicColumnIndices cannot be copied");
        }

        protected ColumnInfo copy(boolean z) {
            throw new UnsupportedOperationException("DynamicColumnIndices cannot be copied");
        }

        protected void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            throw new UnsupportedOperationException("DynamicColumnIndices cannot copy");
        }
    }

    @Deprecated
    public void close() {
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put(String.class, new FieldMetaData(RealmFieldType.STRING, true));
        hashMap.put(Short.TYPE, new FieldMetaData(RealmFieldType.INTEGER, false));
        hashMap.put(Short.class, new FieldMetaData(RealmFieldType.INTEGER, true));
        hashMap.put(Integer.TYPE, new FieldMetaData(RealmFieldType.INTEGER, false));
        hashMap.put(Integer.class, new FieldMetaData(RealmFieldType.INTEGER, true));
        hashMap.put(Long.TYPE, new FieldMetaData(RealmFieldType.INTEGER, false));
        hashMap.put(Long.class, new FieldMetaData(RealmFieldType.INTEGER, true));
        hashMap.put(Float.TYPE, new FieldMetaData(RealmFieldType.FLOAT, false));
        hashMap.put(Float.class, new FieldMetaData(RealmFieldType.FLOAT, true));
        hashMap.put(Double.TYPE, new FieldMetaData(RealmFieldType.DOUBLE, false));
        hashMap.put(Double.class, new FieldMetaData(RealmFieldType.DOUBLE, true));
        hashMap.put(Boolean.TYPE, new FieldMetaData(RealmFieldType.BOOLEAN, false));
        hashMap.put(Boolean.class, new FieldMetaData(RealmFieldType.BOOLEAN, true));
        hashMap.put(Byte.TYPE, new FieldMetaData(RealmFieldType.INTEGER, false));
        hashMap.put(Byte.class, new FieldMetaData(RealmFieldType.INTEGER, true));
        hashMap.put(byte[].class, new FieldMetaData(RealmFieldType.BINARY, true));
        hashMap.put(Date.class, new FieldMetaData(RealmFieldType.DATE, true));
        SUPPORTED_SIMPLE_FIELDS = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put(RealmObject.class, new FieldMetaData(RealmFieldType.OBJECT, false));
        hashMap.put(RealmList.class, new FieldMetaData(RealmFieldType.LIST, false));
        SUPPORTED_LINKED_FIELDS = Collections.unmodifiableMap(hashMap);
    }

    RealmObjectSchema(BaseRealm baseRealm, RealmSchema realmSchema, Table table) {
        this(baseRealm, realmSchema, table, new DynamicColumnIndices(table));
    }

    RealmObjectSchema(BaseRealm baseRealm, RealmSchema realmSchema, Table table, ColumnInfo columnInfo) {
        this.schema = realmSchema;
        this.realm = baseRealm;
        this.table = table;
        this.columnInfo = columnInfo;
    }

    public String getClassName() {
        return this.table.getClassName();
    }

    public RealmObjectSchema setClassName(String str) {
        this.realm.checkNotInSync();
        checkEmpty(str);
        String tableNameForClass = Table.getTableNameForClass(str);
        StringBuilder stringBuilder;
        if (tableNameForClass.length() > 56) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Class name is too long. Limit is 56 characters: '");
            stringBuilder.append(str);
            stringBuilder.append("' (");
            stringBuilder.append(Integer.toString(str.length()));
            stringBuilder.append(")");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.realm.sharedRealm.hasTable(tableNameForClass)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Class already exists: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            String str2 = null;
            if (this.table.hasPrimaryKey() != null) {
                str = this.table.getName();
                String primaryKey = getPrimaryKey();
                this.table.setPrimaryKey(null);
                str2 = primaryKey;
            } else {
                str = null;
            }
            this.realm.sharedRealm.renameTable(this.table.getName(), tableNameForClass);
            if (!(str2 == null || str2.isEmpty())) {
                try {
                    this.table.setPrimaryKey(str2);
                } catch (Exception e) {
                    this.realm.sharedRealm.renameTable(this.table.getName(), str);
                    throw e;
                }
            }
            return this;
        }
    }

    public RealmObjectSchema addField(String str, Class<?> cls, FieldAttribute... fieldAttributeArr) {
        FieldMetaData fieldMetaData = (FieldMetaData) SUPPORTED_SIMPLE_FIELDS.get(cls);
        if (fieldMetaData != null) {
            checkNewFieldName(str);
            cls = fieldMetaData.defaultNullable;
            if (containsAttribute(fieldAttributeArr, FieldAttribute.REQUIRED)) {
                cls = null;
            }
            long addColumn = this.table.addColumn(fieldMetaData.realmType, str, cls);
            try {
                addModifiers(str, fieldAttributeArr);
                return this;
            } catch (String str2) {
                this.table.removeColumn(addColumn);
                throw str2;
            }
        } else if (SUPPORTED_LINKED_FIELDS.containsKey(cls) != null) {
            fieldAttributeArr = new StringBuilder();
            fieldAttributeArr.append("Use addRealmObjectField() instead to add fields that link to other RealmObjects: ");
            fieldAttributeArr.append(str2);
            throw new IllegalArgumentException(fieldAttributeArr.toString());
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "Realm doesn't support this field type: %s(%s)", new Object[]{str2, cls}));
        }
    }

    public RealmObjectSchema addRealmObjectField(String str, RealmObjectSchema realmObjectSchema) {
        checkLegalName(str);
        checkFieldNameIsAvailable(str);
        this.table.addColumnLink(RealmFieldType.OBJECT, str, this.realm.sharedRealm.getTable(Table.getTableNameForClass(realmObjectSchema.getClassName())));
        return this;
    }

    public RealmObjectSchema addRealmListField(String str, RealmObjectSchema realmObjectSchema) {
        checkLegalName(str);
        checkFieldNameIsAvailable(str);
        this.table.addColumnLink(RealmFieldType.LIST, str, this.realm.sharedRealm.getTable(Table.getTableNameForClass(realmObjectSchema.getClassName())));
        return this;
    }

    public RealmObjectSchema removeField(String str) {
        this.realm.checkNotInSync();
        checkLegalName(str);
        if (hasField(str)) {
            long columnIndex = getColumnIndex(str);
            if (this.table.getPrimaryKey() == columnIndex) {
                this.table.setPrimaryKey(null);
            }
            this.table.removeColumn(columnIndex);
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" does not exist.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public RealmObjectSchema renameField(String str, String str2) {
        this.realm.checkNotInSync();
        checkLegalName(str);
        checkFieldExists(str);
        checkLegalName(str2);
        checkFieldNameIsAvailable(str2);
        this.table.renameColumn(getColumnIndex(str), str2);
        return this;
    }

    public boolean hasField(String str) {
        return this.table.getColumnIndex(str) != -1 ? true : null;
    }

    public RealmObjectSchema addIndex(String str) {
        checkLegalName(str);
        checkFieldExists(str);
        long columnIndex = getColumnIndex(str);
        if (this.table.hasSearchIndex(columnIndex)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" already has an index.");
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.table.addSearchIndex(columnIndex);
        return this;
    }

    public boolean hasIndex(String str) {
        checkLegalName(str);
        checkFieldExists(str);
        return this.table.hasSearchIndex(this.table.getColumnIndex(str));
    }

    public RealmObjectSchema removeIndex(String str) {
        this.realm.checkNotInSync();
        checkLegalName(str);
        checkFieldExists(str);
        long columnIndex = getColumnIndex(str);
        if (this.table.hasSearchIndex(columnIndex)) {
            this.table.removeSearchIndex(columnIndex);
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Field is not indexed: ");
        stringBuilder.append(str);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public RealmObjectSchema addPrimaryKey(String str) {
        checkLegalName(str);
        checkFieldExists(str);
        if (this.table.hasPrimaryKey()) {
            throw new IllegalStateException("A primary key is already defined");
        }
        this.table.setPrimaryKey(str);
        long columnIndex = getColumnIndex(str);
        if (this.table.hasSearchIndex(columnIndex) == null) {
            this.table.addSearchIndex(columnIndex);
        }
        return this;
    }

    public RealmObjectSchema removePrimaryKey() {
        this.realm.checkNotInSync();
        if (this.table.hasPrimaryKey()) {
            long primaryKey = this.table.getPrimaryKey();
            if (this.table.hasSearchIndex(primaryKey)) {
                this.table.removeSearchIndex(primaryKey);
            }
            this.table.setPrimaryKey("");
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClassName());
        stringBuilder.append(" doesn't have a primary key.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public RealmObjectSchema setRequired(String str, boolean z) {
        long columnIndex = this.table.getColumnIndex(str);
        boolean isRequired = isRequired(str);
        RealmFieldType columnType = this.table.getColumnType(columnIndex);
        StringBuilder stringBuilder;
        if (columnType == RealmFieldType.OBJECT) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot modify the required state for RealmObject references: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (columnType != RealmFieldType.LIST) {
            if (z) {
                if (isRequired) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field is already required: ");
                    stringBuilder.append(str);
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
            if (!z) {
                if (!isRequired) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field is already nullable: ");
                    stringBuilder.append(str);
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
            if (z) {
                this.table.convertColumnToNotNullable(columnIndex);
            } else {
                this.table.convertColumnToNullable(columnIndex);
            }
            return this;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot modify the required state for RealmList references: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public RealmObjectSchema setNullable(String str, boolean z) {
        setRequired(str, z ^ 1);
        return this;
    }

    public boolean isRequired(String str) {
        return this.table.isColumnNullable(getColumnIndex(str)) ^ 1;
    }

    public boolean isNullable(String str) {
        return this.table.isColumnNullable(getColumnIndex(str));
    }

    public boolean isPrimaryKey(String str) {
        return getColumnIndex(str) == this.table.getPrimaryKey() ? true : null;
    }

    public boolean hasPrimaryKey() {
        return this.table.hasPrimaryKey();
    }

    public String getPrimaryKey() {
        if (this.table.hasPrimaryKey()) {
            return this.table.getColumnName(this.table.getPrimaryKey());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClassName());
        stringBuilder.append(" doesn't have a primary key.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public Set<String> getFieldNames() {
        int columnCount = (int) this.table.getColumnCount();
        Set<String> linkedHashSet = new LinkedHashSet(columnCount);
        for (int i = 0; i < columnCount; i++) {
            linkedHashSet.add(this.table.getColumnName((long) i));
        }
        return linkedHashSet;
    }

    public RealmObjectSchema transform(Function function) {
        if (function != null) {
            long size = this.table.size();
            for (long j = 0; j < size; j++) {
                function.apply(new DynamicRealmObject(this.realm, this.table.getCheckedRow(j)));
            }
        }
        return this;
    }

    public RealmFieldType getFieldType(String str) {
        return this.table.getColumnType(getColumnIndex(str));
    }

    protected final FieldDescriptor getColumnIndices(String str, RealmFieldType... realmFieldTypeArr) {
        return FieldDescriptor.createStandardFieldDescriptor(getSchemaConnector(), getTable(), str, realmFieldTypeArr);
    }

    RealmObjectSchema add(String str, RealmFieldType realmFieldType, boolean z, boolean z2, boolean z3) {
        long addColumn = this.table.addColumn(realmFieldType, str, z3 ^ 1);
        if (z2) {
            this.table.addSearchIndex(addColumn);
        }
        if (z) {
            this.table.setPrimaryKey(str);
        }
        return this;
    }

    RealmObjectSchema add(String str, RealmFieldType realmFieldType, RealmObjectSchema realmObjectSchema) {
        this.table.addColumnLink(realmFieldType, str, this.realm.getSharedRealm().getTable(Table.getTableNameForClass(realmObjectSchema.getClassName())));
        return this;
    }

    long getAndCheckFieldIndex(String str) {
        long columnIndex = this.columnInfo.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Field does not exist: ");
        stringBuilder.append(str);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    Table getTable() {
        return this.table;
    }

    private SchemaConnector getSchemaConnector() {
        return new SchemaConnector(this.schema);
    }

    long getFieldIndex(String str) {
        return this.columnInfo.getColumnIndex(str);
    }

    private void addModifiers(String str, FieldAttribute[] fieldAttributeArr) {
        if (fieldAttributeArr != null) {
            try {
                if (fieldAttributeArr.length > 0) {
                    if (containsAttribute(fieldAttributeArr, FieldAttribute.INDEXED)) {
                        addIndex(str);
                    }
                    if (containsAttribute(fieldAttributeArr, FieldAttribute.PRIMARY_KEY) != null) {
                        addPrimaryKey(str);
                    }
                }
            } catch (FieldAttribute[] fieldAttributeArr2) {
                long columnIndex = getColumnIndex(str);
                if (null != null) {
                    this.table.removeSearchIndex(columnIndex);
                }
                throw ((RuntimeException) fieldAttributeArr2);
            }
        }
    }

    private boolean containsAttribute(FieldAttribute[] fieldAttributeArr, FieldAttribute fieldAttribute) {
        if (fieldAttributeArr != null) {
            if (fieldAttributeArr.length != 0) {
                for (FieldAttribute fieldAttribute2 : fieldAttributeArr) {
                    if (fieldAttribute2 == fieldAttribute) {
                        return 1;
                    }
                }
                return false;
            }
        }
        return false;
    }

    private void checkNewFieldName(String str) {
        checkLegalName(str);
        checkFieldNameIsAvailable(str);
    }

    private void checkLegalName(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Field name can not be null or empty");
        } else if (str.contains(".") != null) {
            throw new IllegalArgumentException("Field name can not contain '.'");
        }
    }

    private void checkFieldNameIsAvailable(String str) {
        if (this.table.getColumnIndex(str) != -1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field already exists in '");
            stringBuilder.append(getClassName());
            stringBuilder.append("': ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private void checkFieldExists(String str) {
        if (this.table.getColumnIndex(str) == -1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field name doesn't exist on object '");
            stringBuilder.append(getClassName());
            stringBuilder.append("': ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private long getColumnIndex(String str) {
        long columnIndex = this.table.getColumnIndex(str);
        if (columnIndex != -1) {
            return columnIndex;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "Field name '%s' does not exist on schema for '%s'", new Object[]{str, getClassName()}));
    }

    private void checkEmpty(String str) {
        if (str == null || str.isEmpty() != null) {
            throw new IllegalArgumentException("Null or empty class names are not allowed");
        }
    }
}
