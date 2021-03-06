package io.realm.internal;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.RealmChangeListener;
import io.realm.internal.ObserverPairList.ObserverPair;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.NoSuchElementException;

@Keep
public class Collection implements NativeObject {
    public static final byte AGGREGATE_FUNCTION_AVERAGE = (byte) 3;
    public static final byte AGGREGATE_FUNCTION_MAXIMUM = (byte) 2;
    public static final byte AGGREGATE_FUNCTION_MINIMUM = (byte) 1;
    public static final byte AGGREGATE_FUNCTION_SUM = (byte) 4;
    private static final String CLOSED_REALM_MESSAGE = "This Realm instance has already been closed, making it unusable.";
    public static final byte MODE_EMPTY = (byte) 0;
    public static final byte MODE_LINKVIEW = (byte) 3;
    public static final byte MODE_QUERY = (byte) 2;
    public static final byte MODE_TABLE = (byte) 1;
    public static final byte MODE_TABLEVIEW = (byte) 4;
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private final NativeContext context;
    private boolean isSnapshot;
    private boolean loaded;
    private final long nativePtr;
    private final ObserverPairList<CollectionObserverPair> observerPairs;
    private final SharedRealm sharedRealm;
    private final Table table;

    public enum Aggregate {
        MINIMUM((byte) 1),
        MAXIMUM((byte) 2),
        AVERAGE((byte) 3),
        SUM((byte) 4);
        
        private final byte value;

        private Aggregate(byte b) {
            this.value = b;
        }

        public byte getValue() {
            return this.value;
        }
    }

    public static abstract class Iterator<T> implements java.util.Iterator<T> {
        Collection iteratorCollection;
        protected int pos = -1;

        protected abstract T convertRowToObject(UncheckedRow uncheckedRow);

        public Iterator(Collection collection) {
            if (collection.sharedRealm.isClosed()) {
                throw new IllegalStateException(Collection.CLOSED_REALM_MESSAGE);
            }
            this.iteratorCollection = collection;
            if (!collection.isSnapshot) {
                if (collection.sharedRealm.isInTransaction() != null) {
                    detach();
                } else {
                    this.iteratorCollection.sharedRealm.addIterator(this);
                }
            }
        }

        public boolean hasNext() {
            checkValid();
            return ((long) (this.pos + 1)) < this.iteratorCollection.size();
        }

        public T next() {
            checkValid();
            this.pos++;
            if (((long) this.pos) < this.iteratorCollection.size()) {
                return get(this.pos);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot access index ");
            stringBuilder.append(this.pos);
            stringBuilder.append(" when size is ");
            stringBuilder.append(this.iteratorCollection.size());
            stringBuilder.append(". Remember to check hasNext() before using next().");
            throw new NoSuchElementException(stringBuilder.toString());
        }

        @Deprecated
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported by RealmResults iterators.");
        }

        void detach() {
            this.iteratorCollection = this.iteratorCollection.createSnapshot();
        }

        void invalidate() {
            this.iteratorCollection = null;
        }

        void checkValid() {
            if (this.iteratorCollection == null) {
                throw new ConcurrentModificationException("No outside changes to a Realm is allowed while iterating a living Realm collection.");
            }
        }

        T get(int i) {
            return convertRowToObject(this.iteratorCollection.getUncheckedRow(i));
        }
    }

    public enum Mode {
        EMPTY,
        TABLE,
        QUERY,
        LINKVIEW,
        TABLEVIEW;

        static Mode getByValue(byte b) {
            switch (b) {
                case (byte) 0:
                    return EMPTY;
                case (byte) 1:
                    return TABLE;
                case (byte) 2:
                    return QUERY;
                case (byte) 3:
                    return LINKVIEW;
                case (byte) 4:
                    return TABLEVIEW;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid value: ");
                    stringBuilder.append(b);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    private static class Callback implements io.realm.internal.ObserverPairList.Callback<CollectionObserverPair> {
        private final OrderedCollectionChangeSet changeSet;

        Callback(OrderedCollectionChangeSet orderedCollectionChangeSet) {
            this.changeSet = orderedCollectionChangeSet;
        }

        public void onCalled(CollectionObserverPair collectionObserverPair, Object obj) {
            collectionObserverPair.onChange(obj, this.changeSet);
        }
    }

    private static class CollectionObserverPair<T> extends ObserverPair<T, Object> {
        public CollectionObserverPair(T t, Object obj) {
            super(t, obj);
        }

        public void onChange(T t, OrderedCollectionChangeSet orderedCollectionChangeSet) {
            if (this.listener instanceof OrderedRealmCollectionChangeListener) {
                ((OrderedRealmCollectionChangeListener) this.listener).onChange(t, orderedCollectionChangeSet);
            } else if ((this.listener instanceof RealmChangeListener) != null) {
                ((RealmChangeListener) this.listener).onChange(t);
            } else {
                orderedCollectionChangeSet = new StringBuilder();
                orderedCollectionChangeSet.append("Unsupported listener type: ");
                orderedCollectionChangeSet.append(this.listener);
                throw new RuntimeException(orderedCollectionChangeSet.toString());
            }
        }
    }

    public static abstract class ListIterator<T> extends Iterator<T> implements java.util.ListIterator<T> {
        public ListIterator(Collection collection, int i) {
            super(collection);
            if (i < 0 || ((long) i) > this.iteratorCollection.size()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Starting location must be a valid index: [0, ");
                stringBuilder.append(this.iteratorCollection.size() - 1);
                stringBuilder.append("]. Yours was ");
                stringBuilder.append(i);
                throw new IndexOutOfBoundsException(stringBuilder.toString());
            }
            this.pos = i - 1;
        }

        @Deprecated
        public void add(T t) {
            throw new UnsupportedOperationException("Adding an element is not supported. Use Realm.createObject() instead.");
        }

        public boolean hasPrevious() {
            checkValid();
            return this.pos >= 0;
        }

        public int nextIndex() {
            checkValid();
            return this.pos + 1;
        }

        public T previous() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r3.checkValid();
            r0 = r3.pos;	 Catch:{ IndexOutOfBoundsException -> 0x0010 }
            r0 = r3.get(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0010 }
            r1 = r3.pos;	 Catch:{ IndexOutOfBoundsException -> 0x0010 }
            r1 = r1 + -1;	 Catch:{ IndexOutOfBoundsException -> 0x0010 }
            r3.pos = r1;	 Catch:{ IndexOutOfBoundsException -> 0x0010 }
            return r0;
        L_0x0010:
            r0 = new java.util.NoSuchElementException;
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "Cannot access index less than zero. This was ";
            r1.append(r2);
            r2 = r3.pos;
            r1.append(r2);
            r2 = ". Remember to check hasPrevious() before using previous().";
            r1.append(r2);
            r1 = r1.toString();
            r0.<init>(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.realm.internal.Collection.ListIterator.previous():T");
        }

        public int previousIndex() {
            checkValid();
            return this.pos;
        }

        @Deprecated
        public void set(T t) {
            throw new UnsupportedOperationException("Replacing and element is not supported.");
        }
    }

    private static class RealmChangeListenerWrapper<T> implements OrderedRealmCollectionChangeListener<T> {
        private final RealmChangeListener<T> listener;

        RealmChangeListenerWrapper(RealmChangeListener<T> realmChangeListener) {
            this.listener = realmChangeListener;
        }

        public void onChange(T t, OrderedCollectionChangeSet orderedCollectionChangeSet) {
            this.listener.onChange(t);
        }

        public boolean equals(Object obj) {
            return ((obj instanceof RealmChangeListenerWrapper) && this.listener == ((RealmChangeListenerWrapper) obj).listener) ? true : null;
        }

        public int hashCode() {
            return this.listener.hashCode();
        }
    }

    private static native Object nativeAggregate(long j, long j2, byte b);

    private static native void nativeClear(long j);

    private static native boolean nativeContains(long j, long j2);

    private static native long nativeCreateResults(long j, long j2, SortDescriptor sortDescriptor, SortDescriptor sortDescriptor2);

    private static native long nativeCreateResultsFromBacklinks(long j, long j2, long j3, long j4);

    private static native long nativeCreateResultsFromLinkView(long j, long j2, SortDescriptor sortDescriptor);

    private static native long nativeCreateSnapshot(long j);

    private static native void nativeDelete(long j, long j2);

    private static native boolean nativeDeleteFirst(long j);

    private static native boolean nativeDeleteLast(long j);

    private static native long nativeDistinct(long j, SortDescriptor sortDescriptor);

    private static native long nativeFirstRow(long j);

    private static native long nativeGetFinalizerPtr();

    private static native byte nativeGetMode(long j);

    private static native long nativeGetRow(long j, int i);

    private static native long nativeIndexOf(long j, long j2);

    private static native long nativeIndexOfBySourceRowIndex(long j, long j2);

    private static native boolean nativeIsValid(long j);

    private static native long nativeLastRow(long j);

    private static native long nativeSize(long j);

    private static native long nativeSort(long j, SortDescriptor sortDescriptor);

    private native void nativeStartListening(long j);

    private native void nativeStopListening(long j);

    private static native long nativeWhere(long j);

    public static Collection createBacklinksCollection(SharedRealm sharedRealm, UncheckedRow uncheckedRow, Table table, String str) {
        return new Collection(sharedRealm, table, nativeCreateResultsFromBacklinks(sharedRealm.getNativePtr(), uncheckedRow.getNativePtr(), table.getNativePtr(), table.getColumnIndex(str)), true);
    }

    public Collection(SharedRealm sharedRealm, TableQuery tableQuery, SortDescriptor sortDescriptor, SortDescriptor sortDescriptor2) {
        this.isSnapshot = false;
        this.observerPairs = new ObserverPairList();
        tableQuery.validateQuery();
        this.nativePtr = nativeCreateResults(sharedRealm.getNativePtr(), tableQuery.getNativePtr(), sortDescriptor, sortDescriptor2);
        this.sharedRealm = sharedRealm;
        this.context = sharedRealm.context;
        this.table = tableQuery.getTable();
        this.context.addReference(this);
        this.loaded = false;
    }

    public Collection(SharedRealm sharedRealm, TableQuery tableQuery, SortDescriptor sortDescriptor) {
        this(sharedRealm, tableQuery, sortDescriptor, null);
    }

    public Collection(SharedRealm sharedRealm, TableQuery tableQuery) {
        this(sharedRealm, tableQuery, null, null);
    }

    public Collection(SharedRealm sharedRealm, LinkView linkView, SortDescriptor sortDescriptor) {
        this.isSnapshot = false;
        this.observerPairs = new ObserverPairList();
        this.nativePtr = nativeCreateResultsFromLinkView(sharedRealm.getNativePtr(), linkView.getNativePtr(), sortDescriptor);
        this.sharedRealm = sharedRealm;
        this.context = sharedRealm.context;
        this.table = linkView.getTargetTable();
        this.context.addReference(this);
        this.loaded = true;
    }

    private Collection(SharedRealm sharedRealm, Table table, long j) {
        this(sharedRealm, table, j, false);
    }

    private Collection(SharedRealm sharedRealm, Table table, long j, boolean z) {
        this.isSnapshot = false;
        this.observerPairs = new ObserverPairList();
        this.sharedRealm = sharedRealm;
        this.context = sharedRealm.context;
        this.table = table;
        this.nativePtr = j;
        this.context.addReference(this);
        this.loaded = z;
    }

    public Collection createSnapshot() {
        if (this.isSnapshot) {
            return this;
        }
        Collection collection = new Collection(this.sharedRealm, this.table, nativeCreateSnapshot(this.nativePtr));
        collection.isSnapshot = true;
        return collection;
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public UncheckedRow getUncheckedRow(int i) {
        return this.table.getUncheckedRowByPointer(nativeGetRow(this.nativePtr, i));
    }

    public UncheckedRow firstUncheckedRow() {
        long nativeFirstRow = nativeFirstRow(this.nativePtr);
        return nativeFirstRow != 0 ? this.table.getUncheckedRowByPointer(nativeFirstRow) : null;
    }

    public UncheckedRow lastUncheckedRow() {
        long nativeLastRow = nativeLastRow(this.nativePtr);
        return nativeLastRow != 0 ? this.table.getUncheckedRowByPointer(nativeLastRow) : null;
    }

    public Table getTable() {
        return this.table;
    }

    public TableQuery where() {
        return new TableQuery(this.context, this.table, nativeWhere(this.nativePtr));
    }

    public Number aggregateNumber(Aggregate aggregate, long j) {
        return (Number) nativeAggregate(this.nativePtr, j, aggregate.getValue());
    }

    public Date aggregateDate(Aggregate aggregate, long j) {
        return (Date) nativeAggregate(this.nativePtr, j, aggregate.getValue());
    }

    public long size() {
        return nativeSize(this.nativePtr);
    }

    public void clear() {
        nativeClear(this.nativePtr);
    }

    public Collection sort(SortDescriptor sortDescriptor) {
        return new Collection(this.sharedRealm, this.table, nativeSort(this.nativePtr, sortDescriptor));
    }

    public Collection distinct(SortDescriptor sortDescriptor) {
        return new Collection(this.sharedRealm, this.table, nativeDistinct(this.nativePtr, sortDescriptor));
    }

    public boolean contains(UncheckedRow uncheckedRow) {
        return nativeContains(this.nativePtr, uncheckedRow.getNativePtr());
    }

    public int indexOf(UncheckedRow uncheckedRow) {
        long nativeIndexOf = nativeIndexOf(this.nativePtr, uncheckedRow.getNativePtr());
        return nativeIndexOf > 2147483647L ? Integer.MAX_VALUE : (int) nativeIndexOf;
    }

    public int indexOf(long j) {
        j = nativeIndexOfBySourceRowIndex(this.nativePtr, j);
        return j > 2147483647L ? 2147483647L : (int) j;
    }

    public void delete(long j) {
        nativeDelete(this.nativePtr, j);
    }

    public boolean deleteFirst() {
        return nativeDeleteFirst(this.nativePtr);
    }

    public boolean deleteLast() {
        return nativeDeleteLast(this.nativePtr);
    }

    public <T> void addListener(T t, OrderedRealmCollectionChangeListener<T> orderedRealmCollectionChangeListener) {
        if (this.observerPairs.isEmpty()) {
            nativeStartListening(this.nativePtr);
        }
        this.observerPairs.add(new CollectionObserverPair(t, orderedRealmCollectionChangeListener));
    }

    public <T> void addListener(T t, RealmChangeListener<T> realmChangeListener) {
        addListener((Object) t, new RealmChangeListenerWrapper(realmChangeListener));
    }

    public <T> void removeListener(T t, OrderedRealmCollectionChangeListener<T> orderedRealmCollectionChangeListener) {
        this.observerPairs.remove(t, orderedRealmCollectionChangeListener);
        if (this.observerPairs.isEmpty() != null) {
            nativeStopListening(this.nativePtr);
        }
    }

    public <T> void removeListener(T t, RealmChangeListener<T> realmChangeListener) {
        removeListener((Object) t, new RealmChangeListenerWrapper(realmChangeListener));
    }

    public void removeAllListeners() {
        this.observerPairs.clear();
        nativeStopListening(this.nativePtr);
    }

    public boolean isValid() {
        return nativeIsValid(this.nativePtr);
    }

    private void notifyChangeListeners(long j) {
        if (j != 0 || !isLoaded()) {
            OrderedCollectionChangeSet collectionChangeSet;
            boolean z = this.loaded;
            this.loaded = true;
            ObserverPairList observerPairList = this.observerPairs;
            if (j != 0) {
                if (z) {
                    collectionChangeSet = new CollectionChangeSet(j);
                    observerPairList.foreach(new Callback(collectionChangeSet));
                }
            }
            collectionChangeSet = null;
            observerPairList.foreach(new Callback(collectionChangeSet));
        }
    }

    public Mode getMode() {
        return Mode.getByValue(nativeGetMode(this.nativePtr));
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public void load() {
        if (!this.loaded) {
            notifyChangeListeners(0);
        }
    }
}
