package io.realm.internal;

import io.realm.ObjectChangeSet;
import io.realm.RealmFieldType;
import io.realm.RealmModel;
import io.realm.RealmObjectChangeListener;
import io.realm.exceptions.RealmException;
import io.realm.internal.ObserverPairList.ObserverPair;

@KeepMember
public class OsObject implements NativeObject {
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private final long nativePtr;
    private ObserverPairList<ObjectObserverPair> observerPairs = new ObserverPairList();

    private static class Callback implements io.realm.internal.ObserverPairList.Callback<ObjectObserverPair> {
        private final String[] changedFields;

        Callback(String[] strArr) {
            this.changedFields = strArr;
        }

        private ObjectChangeSet createChangeSet() {
            boolean z = this.changedFields == null;
            return new OsObjectChangeSet(z ? new String[0] : this.changedFields, z);
        }

        public void onCalled(ObjectObserverPair objectObserverPair, Object obj) {
            objectObserverPair.onChange((RealmModel) obj, createChangeSet());
        }
    }

    public static class ObjectObserverPair<T extends RealmModel> extends ObserverPair<T, RealmObjectChangeListener<T>> {
        public ObjectObserverPair(T t, RealmObjectChangeListener<T> realmObjectChangeListener) {
            super(t, realmObjectChangeListener);
        }

        public void onChange(T t, ObjectChangeSet objectChangeSet) {
            ((RealmObjectChangeListener) this.listener).onChange(t, objectChangeSet);
        }
    }

    private static class OsObjectChangeSet implements ObjectChangeSet {
        final String[] changedFields;
        final boolean deleted;

        OsObjectChangeSet(String[] strArr, boolean z) {
            this.changedFields = strArr;
            this.deleted = z;
        }

        public boolean isDeleted() {
            return this.deleted;
        }

        public String[] getChangedFields() {
            return this.changedFields;
        }

        public boolean isFieldChanged(String str) {
            for (String equals : this.changedFields) {
                if (equals.equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static native long nativeCreate(long j, long j2);

    private static native long nativeCreateNewObject(long j, long j2);

    private static native long nativeCreateNewObjectWithLongPrimaryKey(long j, long j2, long j3, long j4, boolean z);

    private static native long nativeCreateNewObjectWithStringPrimaryKey(long j, long j2, long j3, String str);

    private static native long nativeCreateRow(long j, long j2);

    private static native long nativeCreateRowWithLongPrimaryKey(long j, long j2, long j3, long j4, boolean z);

    private static native long nativeCreateRowWithStringPrimaryKey(long j, long j2, long j3, String str);

    private static native long nativeGetFinalizerPtr();

    private native void nativeStartListening(long j);

    private native void nativeStopListening(long j);

    public OsObject(SharedRealm sharedRealm, UncheckedRow uncheckedRow) {
        this.nativePtr = nativeCreate(sharedRealm.getNativePtr(), uncheckedRow.getNativePtr());
        sharedRealm.context.addReference(this);
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public <T extends RealmModel> void addListener(T t, RealmObjectChangeListener<T> realmObjectChangeListener) {
        if (this.observerPairs.isEmpty()) {
            nativeStartListening(this.nativePtr);
        }
        this.observerPairs.add(new ObjectObserverPair(t, realmObjectChangeListener));
    }

    public <T extends RealmModel> void removeListener(T t) {
        this.observerPairs.removeByObserver(t);
        if (this.observerPairs.isEmpty() != null) {
            nativeStopListening(this.nativePtr);
        }
    }

    public <T extends RealmModel> void removeListener(T t, RealmObjectChangeListener<T> realmObjectChangeListener) {
        this.observerPairs.remove(t, realmObjectChangeListener);
        if (this.observerPairs.isEmpty() != null) {
            nativeStopListening(this.nativePtr);
        }
    }

    public void setObserverPairs(ObserverPairList<ObjectObserverPair> observerPairList) {
        if (this.observerPairs.isEmpty()) {
            this.observerPairs = observerPairList;
            if (observerPairList.isEmpty() == null) {
                nativeStartListening(this.nativePtr);
                return;
            }
            return;
        }
        throw new IllegalStateException("'observerPairs' is not empty. Listeners have been added before.");
    }

    public static UncheckedRow create(Table table) {
        SharedRealm sharedRealm = table.getSharedRealm();
        return new UncheckedRow(sharedRealm.context, table, nativeCreateNewObject(sharedRealm.getNativePtr(), table.getNativePtr()));
    }

    public static long createRow(Table table) {
        return nativeCreateRow(table.getSharedRealm().getNativePtr(), table.getNativePtr());
    }

    private static long getAndVerifyPrimaryKeyColumnIndex(Table table) {
        long primaryKey = table.getPrimaryKey();
        if (primaryKey != -2) {
            return primaryKey;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(table.getName());
        stringBuilder.append(" has no primary key defined.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public static UncheckedRow createWithPrimaryKey(Table table, Object obj) {
        long andVerifyPrimaryKeyColumnIndex = getAndVerifyPrimaryKeyColumnIndex(table);
        RealmFieldType columnType = table.getColumnType(andVerifyPrimaryKeyColumnIndex);
        SharedRealm sharedRealm = table.getSharedRealm();
        if (columnType == RealmFieldType.STRING) {
            if (obj != null) {
                if (!(obj instanceof String)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Primary key value is not a String: ");
                    stringBuilder.append(obj);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            return new UncheckedRow(sharedRealm.context, table, nativeCreateNewObjectWithStringPrimaryKey(sharedRealm.getNativePtr(), table.getNativePtr(), andVerifyPrimaryKeyColumnIndex, (String) obj));
        } else if (columnType == RealmFieldType.INTEGER) {
            long j;
            if (obj == null) {
                j = 0;
            } else {
                j = Long.parseLong(obj.toString());
            }
            return new UncheckedRow(sharedRealm.context, table, nativeCreateNewObjectWithLongPrimaryKey(sharedRealm.getNativePtr(), table.getNativePtr(), andVerifyPrimaryKeyColumnIndex, j, obj == null ? true : null));
        } else {
            obj = new StringBuilder();
            obj.append("Cannot check for duplicate rows for unsupported primary key type: ");
            obj.append(columnType);
            throw new RealmException(obj.toString());
        }
    }

    public static long createRowWithPrimaryKey(Table table, Object obj) {
        long andVerifyPrimaryKeyColumnIndex = getAndVerifyPrimaryKeyColumnIndex(table);
        RealmFieldType columnType = table.getColumnType(andVerifyPrimaryKeyColumnIndex);
        SharedRealm sharedRealm = table.getSharedRealm();
        if (columnType == RealmFieldType.STRING) {
            if (obj != null) {
                if (!(obj instanceof String)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Primary key value is not a String: ");
                    stringBuilder.append(obj);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            return nativeCreateRowWithStringPrimaryKey(sharedRealm.getNativePtr(), table.getNativePtr(), andVerifyPrimaryKeyColumnIndex, (String) obj);
        } else if (columnType == RealmFieldType.INTEGER) {
            long j;
            if (obj == null) {
                j = 0;
            } else {
                j = Long.parseLong(obj.toString());
            }
            return nativeCreateRowWithLongPrimaryKey(sharedRealm.getNativePtr(), table.getNativePtr(), andVerifyPrimaryKeyColumnIndex, j, obj == null ? true : null);
        } else {
            obj = new StringBuilder();
            obj.append("Cannot check for duplicate rows for unsupported primary key type: ");
            obj.append(columnType);
            throw new RealmException(obj.toString());
        }
    }

    @KeepMember
    private void notifyChangeListeners(String[] strArr) {
        this.observerPairs.foreach(new Callback(strArr));
    }
}
