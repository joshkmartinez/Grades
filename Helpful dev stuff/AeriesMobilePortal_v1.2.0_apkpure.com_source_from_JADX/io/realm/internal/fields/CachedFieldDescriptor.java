package io.realm.internal.fields;

import io.realm.RealmFieldType;
import io.realm.internal.ColumnInfo;
import io.realm.internal.fields.FieldDescriptor.SchemaProxy;
import java.util.List;
import java.util.Locale;
import java.util.Set;

class CachedFieldDescriptor extends FieldDescriptor {
    private final String className;
    private final SchemaProxy schema;

    CachedFieldDescriptor(SchemaProxy schemaProxy, String str, String str2, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        super(str2, set, set2);
        this.className = str;
        this.schema = schemaProxy;
    }

    protected void compileFieldDescription(List<String> list) {
        int size = list.size();
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        String str = null;
        String str2 = str;
        String str3 = this.className;
        int i = 0;
        while (i < size) {
            str = (String) list.get(i);
            if (str == null || str.length() <= 0) {
                throw new IllegalArgumentException("Invalid query: Field descriptor contains an empty field.  A field description may not begin with or contain adjacent periods ('.').");
            }
            ColumnInfo columnInfo = this.schema.getColumnInfo(str3);
            if (columnInfo != null) {
                long columnIndex = columnInfo.getColumnIndex(str);
                long j = 0;
                if (columnIndex >= 0) {
                    RealmFieldType columnType = columnInfo.getColumnType(str);
                    if (i < size - 1) {
                        verifyInternalColumnType(str3, str, columnType);
                    }
                    str3 = columnInfo.getLinkedTable(str);
                    jArr[i] = columnIndex;
                    if (columnType == RealmFieldType.LINKING_OBJECTS) {
                        j = this.schema.getNativeTablePtr(str3);
                    }
                    jArr2[i] = j;
                    i++;
                    Object obj = columnType;
                } else {
                    throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' not found in table '%s'.", new Object[]{str, str3}));
                }
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: table '%s' not found in this schema.", new Object[]{str3}));
        }
        setCompilationResults(this.className, str, str2, jArr, jArr2);
    }
}
