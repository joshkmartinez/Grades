package io.realm;

import io.realm.internal.Collection;
import io.realm.internal.Collection.Aggregate;
import io.realm.internal.Collection.Iterator;
import io.realm.internal.Collection.ListIterator;
import io.realm.internal.InvalidRow;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.SortDescriptor;
import io.realm.internal.Table;
import io.realm.internal.UncheckedRow;
import java.util.AbstractList;
import java.util.Date;
import java.util.Locale;

abstract class OrderedRealmCollectionImpl<E extends RealmModel> extends AbstractList<E> implements OrderedRealmCollection<E> {
    private static final String NOT_SUPPORTED_MESSAGE = "This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.";
    final String className;
    final Class<E> classSpec;
    final Collection collection;
    final BaseRealm realm;

    private class RealmCollectionIterator extends Iterator<E> {
        RealmCollectionIterator() {
            super(OrderedRealmCollectionImpl.this.collection);
        }

        protected E convertRowToObject(UncheckedRow uncheckedRow) {
            return OrderedRealmCollectionImpl.this.realm.get(OrderedRealmCollectionImpl.this.classSpec, OrderedRealmCollectionImpl.this.className, uncheckedRow);
        }
    }

    private class RealmCollectionListIterator extends ListIterator<E> {
        RealmCollectionListIterator(int i) {
            super(OrderedRealmCollectionImpl.this.collection, i);
        }

        protected E convertRowToObject(UncheckedRow uncheckedRow) {
            return OrderedRealmCollectionImpl.this.realm.get(OrderedRealmCollectionImpl.this.classSpec, OrderedRealmCollectionImpl.this.className, uncheckedRow);
        }
    }

    public boolean isManaged() {
        return true;
    }

    OrderedRealmCollectionImpl(BaseRealm baseRealm, Collection collection, Class<E> cls) {
        this(baseRealm, collection, cls, null);
    }

    OrderedRealmCollectionImpl(BaseRealm baseRealm, Collection collection, String str) {
        this(baseRealm, collection, null, str);
    }

    private OrderedRealmCollectionImpl(BaseRealm baseRealm, Collection collection, Class<E> cls, String str) {
        this.realm = baseRealm;
        this.collection = collection;
        this.classSpec = cls;
        this.className = str;
    }

    Table getTable() {
        return this.collection.getTable();
    }

    Collection getCollection() {
        return this.collection;
    }

    public boolean isValid() {
        return this.collection.isValid();
    }

    public boolean contains(Object obj) {
        if (!isLoaded() || ((obj instanceof RealmObjectProxy) && ((RealmObjectProxy) obj).realmGet$proxyState().getRow$realm() == InvalidRow.INSTANCE)) {
            return false;
        }
        java.util.Iterator it = iterator();
        while (it.hasNext()) {
            if (((RealmModel) it.next()).equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public E get(int i) {
        this.realm.checkIfValid();
        return this.realm.get(this.classSpec, this.className, this.collection.getUncheckedRow(i));
    }

    public E first() {
        return firstImpl(true, null);
    }

    public E first(E e) {
        return firstImpl(false, e);
    }

    private E firstImpl(boolean z, E e) {
        UncheckedRow firstUncheckedRow = this.collection.firstUncheckedRow();
        if (firstUncheckedRow != null) {
            return this.realm.get(this.classSpec, this.className, firstUncheckedRow);
        }
        if (!z) {
            return e;
        }
        throw new IndexOutOfBoundsException("No results were found.");
    }

    public E last() {
        return lastImpl(true, null);
    }

    public E last(E e) {
        return lastImpl(false, e);
    }

    private E lastImpl(boolean z, E e) {
        UncheckedRow lastUncheckedRow = this.collection.lastUncheckedRow();
        if (lastUncheckedRow != null) {
            return this.realm.get(this.classSpec, this.className, lastUncheckedRow);
        }
        if (!z) {
            return e;
        }
        throw new IndexOutOfBoundsException("No results were found.");
    }

    public void deleteFromRealm(int i) {
        this.realm.checkIfValidAndInTransaction();
        this.collection.delete((long) i);
    }

    public boolean deleteAllFromRealm() {
        this.realm.checkIfValid();
        if (size() <= 0) {
            return false;
        }
        this.collection.clear();
        return true;
    }

    public java.util.Iterator<E> iterator() {
        return new RealmCollectionIterator();
    }

    public java.util.ListIterator<E> listIterator() {
        return new RealmCollectionListIterator(0);
    }

    public java.util.ListIterator<E> listIterator(int i) {
        return new RealmCollectionListIterator(i);
    }

    private long getColumnIndexForSort(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Non-empty field name required.");
        } else if (str.contains(".")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Aggregates on child object fields are not supported: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            long columnIndex = this.collection.getTable().getColumnIndex(str);
            if (columnIndex >= 0) {
                return columnIndex;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Field '%s' does not exist.", new Object[]{str}));
        }
    }

    public RealmResults<E> sort(String str) {
        return createLoadedResults(this.collection.sort(SortDescriptor.getInstanceForSort(getSchemaConnector(), this.collection.getTable(), str, Sort.ASCENDING)));
    }

    public RealmResults<E> sort(String str, Sort sort) {
        return createLoadedResults(this.collection.sort(SortDescriptor.getInstanceForSort(getSchemaConnector(), this.collection.getTable(), str, sort)));
    }

    public RealmResults<E> sort(String[] strArr, Sort[] sortArr) {
        return createLoadedResults(this.collection.sort(SortDescriptor.getInstanceForSort(getSchemaConnector(), this.collection.getTable(), strArr, sortArr)));
    }

    public RealmResults<E> sort(String str, Sort sort, String str2, Sort sort2) {
        return sort(new String[]{str, str2}, new Sort[]{sort, sort2});
    }

    public int size() {
        if (!isLoaded()) {
            return 0;
        }
        long size = this.collection.size();
        return size > 2147483647L ? Integer.MAX_VALUE : (int) size;
    }

    public Number min(String str) {
        this.realm.checkIfValid();
        return this.collection.aggregateNumber(Aggregate.MINIMUM, getColumnIndexForSort(str));
    }

    public Date minDate(String str) {
        this.realm.checkIfValid();
        return this.collection.aggregateDate(Aggregate.MINIMUM, getColumnIndexForSort(str));
    }

    public Number max(String str) {
        this.realm.checkIfValid();
        return this.collection.aggregateNumber(Aggregate.MAXIMUM, getColumnIndexForSort(str));
    }

    public Date maxDate(String str) {
        this.realm.checkIfValid();
        return this.collection.aggregateDate(Aggregate.MAXIMUM, getColumnIndexForSort(str));
    }

    public Number sum(String str) {
        this.realm.checkIfValid();
        return this.collection.aggregateNumber(Aggregate.SUM, getColumnIndexForSort(str));
    }

    public double average(String str) {
        this.realm.checkIfValid();
        return this.collection.aggregateNumber(Aggregate.AVERAGE, getColumnIndexForSort(str)).doubleValue();
    }

    @Deprecated
    public E remove(int i) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean removeAll(java.util.Collection<?> collection) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public E set(int i, E e) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean retainAll(java.util.Collection<?> collection) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    public boolean deleteLastFromRealm() {
        this.realm.checkIfValidAndInTransaction();
        return this.collection.deleteLast();
    }

    public boolean deleteFirstFromRealm() {
        this.realm.checkIfValidAndInTransaction();
        return this.collection.deleteFirst();
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean add(E e) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public void add(int i, E e) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean addAll(int i, java.util.Collection<? extends E> collection) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean addAll(java.util.Collection<? extends E> collection) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    public OrderedRealmCollectionSnapshot<E> createSnapshot() {
        if (this.className != null) {
            return new OrderedRealmCollectionSnapshot(this.realm, this.collection, this.className);
        }
        return new OrderedRealmCollectionSnapshot(this.realm, this.collection, this.classSpec);
    }

    RealmResults<E> createLoadedResults(Collection collection) {
        RealmResults<E> realmResults;
        if (this.className != null) {
            realmResults = new RealmResults(this.realm, collection, this.className);
        } else {
            realmResults = new RealmResults(this.realm, collection, this.classSpec);
        }
        realmResults.load();
        return realmResults;
    }

    private SchemaConnector getSchemaConnector() {
        return new SchemaConnector(this.realm.getSchema());
    }
}
