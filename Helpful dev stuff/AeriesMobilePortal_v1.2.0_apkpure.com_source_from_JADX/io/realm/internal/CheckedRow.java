package io.realm.internal;

import io.realm.RealmFieldType;

public class CheckedRow extends UncheckedRow {
    private UncheckedRow originalRow;

    protected native boolean nativeGetBoolean(long j, long j2);

    protected native byte[] nativeGetByteArray(long j, long j2);

    protected native long nativeGetColumnCount(long j);

    protected native long nativeGetColumnIndex(long j, String str);

    protected native String nativeGetColumnName(long j, long j2);

    protected native int nativeGetColumnType(long j, long j2);

    protected native double nativeGetDouble(long j, long j2);

    protected native float nativeGetFloat(long j, long j2);

    protected native long nativeGetLink(long j, long j2);

    protected native long nativeGetLinkView(long j, long j2);

    protected native long nativeGetLong(long j, long j2);

    protected native String nativeGetString(long j, long j2);

    protected native long nativeGetTimestamp(long j, long j2);

    protected native boolean nativeIsNullLink(long j, long j2);

    protected native void nativeNullifyLink(long j, long j2);

    protected native void nativeSetBoolean(long j, long j2, boolean z);

    protected native void nativeSetByteArray(long j, long j2, byte[] bArr);

    protected native void nativeSetDouble(long j, long j2, double d);

    protected native void nativeSetFloat(long j, long j2, float f);

    protected native void nativeSetLink(long j, long j2, long j3);

    protected native void nativeSetLong(long j, long j2, long j3);

    protected native void nativeSetString(long j, long j2, String str);

    protected native void nativeSetTimestamp(long j, long j2, long j3);

    private CheckedRow(NativeContext nativeContext, Table table, long j) {
        super(nativeContext, table, j);
    }

    private CheckedRow(UncheckedRow uncheckedRow) {
        super(uncheckedRow);
        this.originalRow = uncheckedRow;
    }

    public static CheckedRow get(NativeContext nativeContext, Table table, long j) {
        return new CheckedRow(nativeContext, table, table.nativeGetRowPtr(table.getNativePtr(), j));
    }

    public static CheckedRow get(NativeContext nativeContext, LinkView linkView, long j) {
        return new CheckedRow(nativeContext, linkView.getTargetTable(), linkView.nativeGetRow(linkView.getNativePtr(), j));
    }

    public static CheckedRow getFromRow(UncheckedRow uncheckedRow) {
        return new CheckedRow(uncheckedRow);
    }

    public boolean isNullLink(long j) {
        RealmFieldType columnType = getColumnType(j);
        if (columnType != RealmFieldType.OBJECT) {
            if (columnType != RealmFieldType.LIST) {
                return 0;
            }
        }
        return super.isNullLink(j);
    }

    public boolean isNull(long j) {
        return super.isNull(j);
    }

    public void setNull(long j) {
        if (getColumnType(j) == RealmFieldType.BINARY) {
            super.setBinaryByteArray(j, null);
        } else {
            super.setNull(j);
        }
    }
}
