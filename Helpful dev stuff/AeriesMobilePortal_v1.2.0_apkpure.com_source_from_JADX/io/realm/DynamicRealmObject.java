package io.realm;

import io.realm.internal.CheckedRow;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.UncheckedRow;
import io.realm.internal.android.JsonUtils;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class DynamicRealmObject extends RealmObject implements RealmObjectProxy {
    static final String MSG_LINK_QUERY_NOT_SUPPORTED = "Queries across relationships are not supported";
    private final ProxyState<DynamicRealmObject> proxyState = new ProxyState(this);

    public void realm$injectObjectContext() {
    }

    public DynamicRealmObject(RealmModel realmModel) {
        if (realmModel == null) {
            throw new IllegalArgumentException("A non-null object must be provided.");
        } else if (realmModel instanceof DynamicRealmObject) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The object is already a DynamicRealmObject: ");
            stringBuilder.append(realmModel);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (!RealmObject.isManaged(realmModel)) {
            throw new IllegalArgumentException("An object managed by Realm must be provided. This is an unmanaged object.");
        } else if (RealmObject.isValid(realmModel)) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) realmModel;
            Row row$realm = realmObjectProxy.realmGet$proxyState().getRow$realm();
            this.proxyState.setRealm$realm(realmObjectProxy.realmGet$proxyState().getRealm$realm());
            this.proxyState.setRow$realm(((UncheckedRow) row$realm).convertToChecked());
            this.proxyState.setConstructionFinished();
        } else {
            throw new IllegalArgumentException("A valid object managed by Realm must be provided. This object was deleted.");
        }
    }

    DynamicRealmObject(BaseRealm baseRealm, Row row) {
        this.proxyState.setRealm$realm(baseRealm);
        this.proxyState.setRow$realm(row);
        this.proxyState.setConstructionFinished();
    }

    public <E> E get(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        RealmFieldType columnType = this.proxyState.getRow$realm().getColumnType(columnIndex);
        switch (columnType) {
            case BOOLEAN:
                return Boolean.valueOf(this.proxyState.getRow$realm().getBoolean(columnIndex));
            case INTEGER:
                return Long.valueOf(this.proxyState.getRow$realm().getLong(columnIndex));
            case FLOAT:
                return Float.valueOf(this.proxyState.getRow$realm().getFloat(columnIndex));
            case DOUBLE:
                return Double.valueOf(this.proxyState.getRow$realm().getDouble(columnIndex));
            case STRING:
                return this.proxyState.getRow$realm().getString(columnIndex);
            case BINARY:
                return this.proxyState.getRow$realm().getBinaryByteArray(columnIndex);
            case DATE:
                return this.proxyState.getRow$realm().getDate(columnIndex);
            case OBJECT:
                return getObject(str);
            case LIST:
                return getList(str);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Field type not supported: ");
                stringBuilder.append(columnType);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public boolean getBoolean(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        try {
            return this.proxyState.getRow$realm().getBoolean(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(str, columnIndex, RealmFieldType.BOOLEAN);
            throw e;
        }
    }

    public int getInt(String str) {
        return (int) getLong(str);
    }

    public short getShort(String str) {
        return (short) ((int) getLong(str));
    }

    public long getLong(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        try {
            return this.proxyState.getRow$realm().getLong(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(str, columnIndex, RealmFieldType.INTEGER);
            throw e;
        }
    }

    public byte getByte(String str) {
        return (byte) ((int) getLong(str));
    }

    public float getFloat(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        try {
            return this.proxyState.getRow$realm().getFloat(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(str, columnIndex, RealmFieldType.FLOAT);
            throw e;
        }
    }

    public double getDouble(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        try {
            return this.proxyState.getRow$realm().getDouble(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(str, columnIndex, RealmFieldType.DOUBLE);
            throw e;
        }
    }

    public byte[] getBlob(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        try {
            return this.proxyState.getRow$realm().getBinaryByteArray(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(str, columnIndex, RealmFieldType.BINARY);
            throw e;
        }
    }

    public String getString(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        try {
            return this.proxyState.getRow$realm().getString(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(str, columnIndex, RealmFieldType.STRING);
            throw e;
        }
    }

    public Date getDate(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        checkFieldType(str, columnIndex, RealmFieldType.DATE);
        if (this.proxyState.getRow$realm().isNull(columnIndex) != null) {
            return null;
        }
        return this.proxyState.getRow$realm().getDate(columnIndex);
    }

    public DynamicRealmObject getObject(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        checkFieldType(str, columnIndex, RealmFieldType.OBJECT);
        if (this.proxyState.getRow$realm().isNullLink(columnIndex) != null) {
            return null;
        }
        return new DynamicRealmObject(this.proxyState.getRealm$realm(), this.proxyState.getRow$realm().getTable().getLinkTarget(columnIndex).getCheckedRow(this.proxyState.getRow$realm().getLink(columnIndex)));
    }

    public RealmList<DynamicRealmObject> getList(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        try {
            LinkView linkList = this.proxyState.getRow$realm().getLinkList(columnIndex);
            return new RealmList(linkList.getTargetTable().getClassName(), linkList, this.proxyState.getRealm$realm());
        } catch (IllegalArgumentException e) {
            checkFieldType(str, columnIndex, RealmFieldType.LIST);
            throw e;
        }
    }

    public boolean isNull(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        switch (this.proxyState.getRow$realm().getColumnType(columnIndex)) {
            case BOOLEAN:
            case INTEGER:
            case FLOAT:
            case DOUBLE:
            case STRING:
            case BINARY:
            case DATE:
                return this.proxyState.getRow$realm().isNull(columnIndex);
            case OBJECT:
                return this.proxyState.getRow$realm().isNullLink(columnIndex);
            default:
                return null;
        }
    }

    public boolean hasField(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        if (str != null) {
            if (!str.isEmpty()) {
                return this.proxyState.getRow$realm().hasColumn(str);
            }
        }
        return null;
    }

    public String[] getFieldNames() {
        this.proxyState.getRealm$realm().checkIfValid();
        String[] strArr = new String[((int) this.proxyState.getRow$realm().getColumnCount())];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = this.proxyState.getRow$realm().getColumnName((long) i);
        }
        return strArr;
    }

    public void set(String str, Object obj) {
        this.proxyState.getRealm$realm().checkIfValid();
        boolean z = obj instanceof String;
        String str2 = z ? (String) obj : null;
        RealmFieldType columnType = this.proxyState.getRow$realm().getColumnType(this.proxyState.getRow$realm().getColumnIndex(str));
        if (z && columnType != RealmFieldType.STRING) {
            int i = C09821.$SwitchMap$io$realm$RealmFieldType[columnType.ordinal()];
            if (i != 7) {
                switch (i) {
                    case 1:
                        obj = Boolean.valueOf(Boolean.parseBoolean(str2));
                        break;
                    case 2:
                        obj = Long.valueOf(Long.parseLong(str2));
                        break;
                    case 3:
                        obj = Float.valueOf(Float.parseFloat(str2));
                        break;
                    case 4:
                        obj = Double.valueOf(Double.parseDouble(str2));
                        break;
                    default:
                        throw new IllegalArgumentException(String.format(Locale.US, "Field %s is not a String field, and the provide value could not be automatically converted: %s. Use a typedsetter instead", new Object[]{str, obj}));
                }
            }
            obj = JsonUtils.stringToDate(str2);
        }
        if (obj == null) {
            setNull(str);
        } else {
            setValue(str, obj);
        }
    }

    private void setValue(String str, Object obj) {
        Class cls = obj.getClass();
        if (cls == Boolean.class) {
            setBoolean(str, ((Boolean) obj).booleanValue());
        } else if (cls == Short.class) {
            setShort(str, ((Short) obj).shortValue());
        } else if (cls == Integer.class) {
            setInt(str, ((Integer) obj).intValue());
        } else if (cls == Long.class) {
            setLong(str, ((Long) obj).longValue());
        } else if (cls == Byte.class) {
            setByte(str, ((Byte) obj).byteValue());
        } else if (cls == Float.class) {
            setFloat(str, ((Float) obj).floatValue());
        } else if (cls == Double.class) {
            setDouble(str, ((Double) obj).doubleValue());
        } else if (cls == String.class) {
            setString(str, (String) obj);
        } else if (obj instanceof Date) {
            setDate(str, (Date) obj);
        } else if (obj instanceof byte[]) {
            setBlob(str, (byte[]) obj);
        } else if (cls == DynamicRealmObject.class) {
            setObject(str, (DynamicRealmObject) obj);
        } else if (cls == RealmList.class) {
            setList(str, (RealmList) obj);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Value is of an type not supported: ");
            stringBuilder.append(obj.getClass());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public void setBoolean(String str, boolean z) {
        this.proxyState.getRealm$realm().checkIfValid();
        this.proxyState.getRow$realm().setBoolean(this.proxyState.getRow$realm().getColumnIndex(str), z);
    }

    public void setShort(String str, short s) {
        this.proxyState.getRealm$realm().checkIfValid();
        checkIsPrimaryKey(str);
        this.proxyState.getRow$realm().setLong(this.proxyState.getRow$realm().getColumnIndex(str), (long) s);
    }

    public void setInt(String str, int i) {
        this.proxyState.getRealm$realm().checkIfValid();
        checkIsPrimaryKey(str);
        this.proxyState.getRow$realm().setLong(this.proxyState.getRow$realm().getColumnIndex(str), (long) i);
    }

    public void setLong(String str, long j) {
        this.proxyState.getRealm$realm().checkIfValid();
        checkIsPrimaryKey(str);
        this.proxyState.getRow$realm().setLong(this.proxyState.getRow$realm().getColumnIndex(str), j);
    }

    public void setByte(String str, byte b) {
        this.proxyState.getRealm$realm().checkIfValid();
        checkIsPrimaryKey(str);
        this.proxyState.getRow$realm().setLong(this.proxyState.getRow$realm().getColumnIndex(str), (long) b);
    }

    public void setFloat(String str, float f) {
        this.proxyState.getRealm$realm().checkIfValid();
        this.proxyState.getRow$realm().setFloat(this.proxyState.getRow$realm().getColumnIndex(str), f);
    }

    public void setDouble(String str, double d) {
        this.proxyState.getRealm$realm().checkIfValid();
        this.proxyState.getRow$realm().setDouble(this.proxyState.getRow$realm().getColumnIndex(str), d);
    }

    public void setString(String str, String str2) {
        this.proxyState.getRealm$realm().checkIfValid();
        checkIsPrimaryKey(str);
        this.proxyState.getRow$realm().setString(this.proxyState.getRow$realm().getColumnIndex(str), str2);
    }

    public void setBlob(String str, byte[] bArr) {
        this.proxyState.getRealm$realm().checkIfValid();
        this.proxyState.getRow$realm().setBinaryByteArray(this.proxyState.getRow$realm().getColumnIndex(str), bArr);
    }

    public void setDate(String str, Date date) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        if (date == null) {
            this.proxyState.getRow$realm().setNull(columnIndex);
        } else {
            this.proxyState.getRow$realm().setDate(columnIndex, date);
        }
    }

    public void setObject(String str, DynamicRealmObject dynamicRealmObject) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        if (dynamicRealmObject == null) {
            this.proxyState.getRow$realm().nullifyLink(columnIndex);
        } else if (dynamicRealmObject.proxyState.getRealm$realm() == null || dynamicRealmObject.proxyState.getRow$realm() == null) {
            throw new IllegalArgumentException("Cannot link to objects that are not part of the Realm.");
        } else if (this.proxyState.getRealm$realm() == dynamicRealmObject.proxyState.getRealm$realm()) {
            if (this.proxyState.getRow$realm().getTable().getLinkTarget(columnIndex).hasSameSchema(dynamicRealmObject.proxyState.getRow$realm().getTable())) {
                this.proxyState.getRow$realm().setLink(columnIndex, dynamicRealmObject.proxyState.getRow$realm().getIndex());
                return;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Type of object is wrong. Was %s, expected %s", new Object[]{r2.getName(), str.getName()}));
        } else {
            throw new IllegalArgumentException("Cannot add an object from another Realm instance.");
        }
    }

    public void setList(String str, RealmList<DynamicRealmObject> realmList) {
        this.proxyState.getRealm$realm().checkIfValid();
        if (realmList != null) {
            int i;
            str = this.proxyState.getRow$realm().getLinkList(this.proxyState.getRow$realm().getColumnIndex(str));
            Table targetTable = str.getTargetTable();
            String className = targetTable.getClassName();
            int i2 = 0;
            if (realmList.className == null && realmList.clazz == null) {
                i = 0;
            } else {
                Object obj;
                if (realmList.className != null) {
                    obj = realmList.className;
                } else {
                    obj = this.proxyState.getRealm$realm().getSchema().getTable(realmList.clazz).getClassName();
                }
                if (className.equals(obj)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException(String.format(Locale.US, "The elements in the list are not the proper type. Was %s expected %s.", new Object[]{obj, className}));
                }
            }
            int size = realmList.size();
            long[] jArr = new long[size];
            int i3 = 0;
            while (i3 < size) {
                RealmObjectProxy realmObjectProxy = (RealmObjectProxy) realmList.get(i3);
                if (realmObjectProxy.realmGet$proxyState().getRealm$realm() == this.proxyState.getRealm$realm()) {
                    if (i == 0) {
                        if (!targetTable.hasSameSchema(realmObjectProxy.realmGet$proxyState().getRow$realm().getTable())) {
                            throw new IllegalArgumentException(String.format(Locale.US, "Element at index %d is not the proper type. Was '%s' expected '%s'.", new Object[]{Integer.valueOf(i3), realmObjectProxy.realmGet$proxyState().getRow$realm().getTable().getClassName(), className}));
                        }
                    }
                    jArr[i3] = realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
                    i3++;
                } else {
                    throw new IllegalArgumentException("Each element in 'list' must belong to the same Realm instance.");
                }
            }
            str.clear();
            while (i2 < size) {
                str.add(jArr[i2]);
                i2++;
            }
            return;
        }
        throw new IllegalArgumentException("Null values not allowed for lists");
    }

    public void setNull(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str);
        if (this.proxyState.getRow$realm().getColumnType(columnIndex) == RealmFieldType.OBJECT) {
            this.proxyState.getRow$realm().nullifyLink(columnIndex);
            return;
        }
        checkIsPrimaryKey(str);
        this.proxyState.getRow$realm().setNull(columnIndex);
    }

    public String getType() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getTable().getClassName();
    }

    public RealmFieldType getFieldType(String str) {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getColumnType(this.proxyState.getRow$realm().getColumnIndex(str));
    }

    private void checkFieldType(String str, long j, RealmFieldType realmFieldType) {
        j = this.proxyState.getRow$realm().getColumnType(j);
        if (j != realmFieldType) {
            String str2;
            String str3 = "";
            if (realmFieldType == RealmFieldType.INTEGER || realmFieldType == RealmFieldType.OBJECT) {
                str3 = "n";
            }
            if (j != RealmFieldType.INTEGER) {
                if (j != RealmFieldType.OBJECT) {
                    str2 = "";
                    throw new IllegalArgumentException(String.format(Locale.US, "'%s' is not a%s '%s', but a%s '%s'.", new Object[]{str, str3, realmFieldType, str2, j}));
                }
            }
            str2 = "n";
            throw new IllegalArgumentException(String.format(Locale.US, "'%s' is not a%s '%s', but a%s '%s'.", new Object[]{str, str3, realmFieldType, str2, j}));
        }
    }

    public int hashCode() {
        this.proxyState.getRealm$realm().checkIfValid();
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
        r0 = r6.proxyState;
        r0 = r0.getRealm$realm();
        r0.checkIfValid();
        r0 = 1;
        if (r6 != r7) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r1 = 0;
        if (r7 == 0) goto L_0x0080;
    L_0x0010:
        r2 = r6.getClass();
        r3 = r7.getClass();
        if (r2 == r3) goto L_0x001b;
    L_0x001a:
        goto L_0x0080;
    L_0x001b:
        r7 = (io.realm.DynamicRealmObject) r7;
        r2 = r6.proxyState;
        r2 = r2.getRealm$realm();
        r2 = r2.getPath();
        r3 = r7.proxyState;
        r3 = r3.getRealm$realm();
        r3 = r3.getPath();
        if (r2 == 0) goto L_0x003a;
    L_0x0033:
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x003d;
    L_0x0039:
        goto L_0x003c;
    L_0x003a:
        if (r3 == 0) goto L_0x003d;
    L_0x003c:
        return r1;
    L_0x003d:
        r2 = r6.proxyState;
        r2 = r2.getRow$realm();
        r2 = r2.getTable();
        r2 = r2.getName();
        r3 = r7.proxyState;
        r3 = r3.getRow$realm();
        r3 = r3.getTable();
        r3 = r3.getName();
        if (r2 == 0) goto L_0x0062;
    L_0x005b:
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0065;
    L_0x0061:
        goto L_0x0064;
    L_0x0062:
        if (r3 == 0) goto L_0x0065;
    L_0x0064:
        return r1;
    L_0x0065:
        r2 = r6.proxyState;
        r2 = r2.getRow$realm();
        r2 = r2.getIndex();
        r7 = r7.proxyState;
        r7 = r7.getRow$realm();
        r4 = r7.getIndex();
        r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r7 != 0) goto L_0x007e;
    L_0x007d:
        goto L_0x007f;
    L_0x007e:
        r0 = r1;
    L_0x007f:
        return r0;
    L_0x0080:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.DynamicRealmObject.equals(java.lang.Object):boolean");
    }

    public String toString() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (!this.proxyState.getRow$realm().isAttached()) {
            return "Invalid object";
        }
        String className = this.proxyState.getRow$realm().getTable().getClassName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(className);
        stringBuilder.append(" = dynamic[");
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.toString());
        for (String str : getFieldNames()) {
            String str2;
            long columnIndex = this.proxyState.getRow$realm().getColumnIndex(str2);
            RealmFieldType columnType = this.proxyState.getRow$realm().getColumnType(columnIndex);
            stringBuilder2.append("{");
            stringBuilder2.append(str2);
            stringBuilder2.append(":");
            switch (columnType) {
                case BOOLEAN:
                    stringBuilder2.append(this.proxyState.getRow$realm().isNull(columnIndex) ? "null" : Boolean.valueOf(this.proxyState.getRow$realm().getBoolean(columnIndex)));
                    break;
                case INTEGER:
                    stringBuilder2.append(this.proxyState.getRow$realm().isNull(columnIndex) ? "null" : Long.valueOf(this.proxyState.getRow$realm().getLong(columnIndex)));
                    break;
                case FLOAT:
                    stringBuilder2.append(this.proxyState.getRow$realm().isNull(columnIndex) ? "null" : Float.valueOf(this.proxyState.getRow$realm().getFloat(columnIndex)));
                    break;
                case DOUBLE:
                    stringBuilder2.append(this.proxyState.getRow$realm().isNull(columnIndex) ? "null" : Double.valueOf(this.proxyState.getRow$realm().getDouble(columnIndex)));
                    break;
                case STRING:
                    stringBuilder2.append(this.proxyState.getRow$realm().getString(columnIndex));
                    break;
                case BINARY:
                    stringBuilder2.append(Arrays.toString(this.proxyState.getRow$realm().getBinaryByteArray(columnIndex)));
                    break;
                case DATE:
                    stringBuilder2.append(this.proxyState.getRow$realm().isNull(columnIndex) ? "null" : this.proxyState.getRow$realm().getDate(columnIndex));
                    break;
                case OBJECT:
                    String str3;
                    if (this.proxyState.getRow$realm().isNullLink(columnIndex)) {
                        str3 = "null";
                    } else {
                        str3 = this.proxyState.getRow$realm().getTable().getLinkTarget(columnIndex).getClassName();
                    }
                    stringBuilder2.append(str3);
                    break;
                case LIST:
                    str2 = this.proxyState.getRow$realm().getTable().getLinkTarget(columnIndex).getClassName();
                    stringBuilder2.append(String.format(Locale.US, "RealmList<%s>[%s]", new Object[]{str2, Long.valueOf(this.proxyState.getRow$realm().getLinkList(columnIndex).size())}));
                    break;
                default:
                    stringBuilder2.append("?");
                    break;
            }
            stringBuilder2.append("},");
        }
        stringBuilder2.replace(stringBuilder2.length() - 1, stringBuilder2.length(), "");
        stringBuilder2.append("]");
        return stringBuilder2.toString();
    }

    public RealmResults<DynamicRealmObject> linkingObjects(String str, String str2) {
        DynamicRealm dynamicRealm = (DynamicRealm) this.proxyState.getRealm$realm();
        dynamicRealm.checkIfValid();
        this.proxyState.getRow$realm().checkIfAttached();
        RealmObjectSchema realmObjectSchema = dynamicRealm.getSchema().get(str);
        if (realmObjectSchema == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Class not found: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (str2 == null) {
            throw new IllegalArgumentException("Non-null 'srcFieldName' required.");
        } else if (str2.contains(".") == null) {
            str = realmObjectSchema.getFieldType(str2);
            if (str != RealmFieldType.OBJECT) {
                if (str != RealmFieldType.LIST) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Unexpected field type: %1$s. Field type should be either %2$s.%3$s or %2$s.%4$s.", new Object[]{str.name(), RealmFieldType.class.getSimpleName(), RealmFieldType.OBJECT.name(), RealmFieldType.LIST.name()}));
                }
            }
            return RealmResults.createDynamicBacklinkResults(dynamicRealm, (CheckedRow) this.proxyState.getRow$realm(), realmObjectSchema.getTable(), str2);
        } else {
            throw new IllegalArgumentException(MSG_LINK_QUERY_NOT_SUPPORTED);
        }
    }

    public ProxyState realmGet$proxyState() {
        return this.proxyState;
    }

    private void checkIsPrimaryKey(String str) {
        RealmObjectSchema schemaForClass = this.proxyState.getRealm$realm().getSchema().getSchemaForClass(getType());
        if (!schemaForClass.hasPrimaryKey()) {
            return;
        }
        if (schemaForClass.getPrimaryKey().equals(str)) {
            throw new IllegalArgumentException(String.format(Locale.US, "Primary key field '%s' cannot be changed after object was created.", new Object[]{str}));
        }
    }
}
