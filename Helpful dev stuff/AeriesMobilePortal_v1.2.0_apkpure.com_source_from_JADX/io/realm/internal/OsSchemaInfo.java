package io.realm.internal;

import java.util.Collection;

public class OsSchemaInfo implements NativeObject {
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private long nativePtr;

    private static native long nativeCreateFromList(long[] jArr);

    private static native long nativeGetFinalizerPtr();

    public OsSchemaInfo(Collection<OsObjectSchemaInfo> collection) {
        long[] jArr = new long[collection.size()];
        int i = 0;
        for (OsObjectSchemaInfo nativePtr : collection) {
            jArr[i] = nativePtr.getNativePtr();
            i++;
        }
        this.nativePtr = nativeCreateFromList(jArr);
        NativeContext.dummyContext.addReference(this);
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }
}
