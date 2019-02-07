package io.realm.internal.fields;

import io.realm.RealmFieldType;
import io.realm.internal.Table;
import java.util.List;
import java.util.Locale;
import java.util.Set;

class DynamicFieldDescriptor extends FieldDescriptor {
    private final Table table;

    DynamicFieldDescriptor(Table table, String str, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        super(str, set, set2);
        this.table = table;
    }

    protected void compileFieldDescription(List<String> list) {
        int size = list.size();
        long[] jArr = new long[size];
        String str = null;
        Table table = this.table;
        int i = 0;
        String str2 = null;
        RealmFieldType realmFieldType = str2;
        while (i < size) {
            str2 = (String) list.get(i);
            if (str2 == null || str2.length() <= 0) {
                throw new IllegalArgumentException("Invalid query: Field descriptor contains an empty field.  A field description may not begin with or contain adjacent periods ('.').");
            }
            str = table.getClassName();
            long columnIndex = table.getColumnIndex(str2);
            if (columnIndex >= 0) {
                realmFieldType = table.getColumnType(columnIndex);
                if (i < size - 1) {
                    verifyInternalColumnType(str, str2, realmFieldType);
                    table = table.getLinkTarget(columnIndex);
                }
                jArr[i] = columnIndex;
                i++;
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' not found in table '%s'.", new Object[]{str2, str}));
            }
        }
        setCompilationResults(str, str2, realmFieldType, jArr, new long[size]);
    }
}
