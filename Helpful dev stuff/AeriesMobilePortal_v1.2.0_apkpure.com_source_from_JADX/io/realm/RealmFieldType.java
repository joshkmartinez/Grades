package io.realm;

import io.realm.internal.Keep;
import java.nio.ByteBuffer;
import java.util.Date;

@Keep
public enum RealmFieldType {
    INTEGER(0),
    BOOLEAN(1),
    STRING(2),
    BINARY(4),
    UNSUPPORTED_TABLE(5),
    UNSUPPORTED_MIXED(6),
    UNSUPPORTED_DATE(7),
    DATE(8),
    FLOAT(9),
    DOUBLE(10),
    OBJECT(12),
    LIST(13),
    LINKING_OBJECTS(14);
    
    private static final RealmFieldType[] typeList = null;
    private final int nativeValue;

    static {
        typeList = new RealmFieldType[15];
        RealmFieldType[] values = values();
        int i;
        while (i < values.length) {
            typeList[values[i].nativeValue] = values[i];
            i++;
        }
    }

    private RealmFieldType(int i) {
        this.nativeValue = i;
    }

    public int getNativeValue() {
        return this.nativeValue;
    }

    public boolean isValid(Object obj) {
        boolean z = true;
        switch (this.nativeValue) {
            case 0:
                if (!((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short))) {
                    if ((obj instanceof Byte) == null) {
                        z = false;
                    }
                }
                return z;
            case 1:
                return obj instanceof Boolean;
            case 2:
                return obj instanceof String;
            case 4:
                if (!(obj instanceof byte[])) {
                    if ((obj instanceof ByteBuffer) == null) {
                        z = false;
                    }
                }
                return z;
            case 5:
                if (obj != null) {
                    if ((obj instanceof Object[][]) == null) {
                        z = false;
                    }
                }
                return z;
            case 7:
                return obj instanceof Date;
            case 8:
                return obj instanceof Date;
            case 9:
                return obj instanceof Float;
            case 10:
                return obj instanceof Double;
            case 12:
                return false;
            case 13:
                return false;
            case 14:
                return false;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported Realm type:  ");
                stringBuilder.append(this);
                throw new RuntimeException(stringBuilder.toString());
        }
    }

    public static RealmFieldType fromNativeValue(int i) {
        if (i >= 0 && i < typeList.length) {
            RealmFieldType realmFieldType = typeList[i];
            if (realmFieldType != null) {
                return realmFieldType;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid native Realm type: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
