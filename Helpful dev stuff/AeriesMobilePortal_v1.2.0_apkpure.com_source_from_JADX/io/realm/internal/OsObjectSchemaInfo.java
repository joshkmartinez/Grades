package io.realm.internal;

import io.realm.RealmFieldType;
import java.util.ArrayList;
import java.util.List;

public class OsObjectSchemaInfo implements NativeObject {
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private long nativePtr;

    public static class Builder {
        private String className;
        private List<Property> propertyList = new ArrayList();

        public Builder(String str) {
            this.className = str;
        }

        public Builder addProperty(String str, RealmFieldType realmFieldType, boolean z, boolean z2, boolean z3) {
            this.propertyList.add(new Property(str, realmFieldType, z, z2, z3));
            return this;
        }

        public Builder addLinkedProperty(String str, RealmFieldType realmFieldType, String str2) {
            this.propertyList.add(new Property(str, realmFieldType, str2));
            return this;
        }

        public OsObjectSchemaInfo build() {
            OsObjectSchemaInfo osObjectSchemaInfo = new OsObjectSchemaInfo(this.className);
            for (Property nativePtr : this.propertyList) {
                OsObjectSchemaInfo.nativeAddProperty(osObjectSchemaInfo.nativePtr, nativePtr.getNativePtr());
            }
            return osObjectSchemaInfo;
        }
    }

    private static native void nativeAddProperty(long j, long j2);

    private static native long nativeCreateRealmObjectSchema(String str);

    private static native String nativeGetClassName(long j);

    private static native long nativeGetFinalizerPtr();

    private OsObjectSchemaInfo(String str) {
        this(nativeCreateRealmObjectSchema(str));
    }

    private OsObjectSchemaInfo(long j) {
        this.nativePtr = j;
        NativeContext.dummyContext.addReference(this);
    }

    public String getClassName() {
        return nativeGetClassName(this.nativePtr);
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }
}
