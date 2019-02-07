package io.realm;

import io.realm.internal.UncheckedRow;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Locale;

public class OrderedRealmCollectionSnapshot<E extends RealmModel> extends OrderedRealmCollectionImpl<E> {
    private int size = -1;

    public boolean isLoaded() {
        return true;
    }

    public boolean load() {
        return true;
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void add(int i, RealmModel realmModel) {
        super.add(i, realmModel);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean add(RealmModel realmModel) {
        return super.add(realmModel);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean addAll(int i, Collection collection) {
        return super.addAll(i, collection);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return super.addAll(collection);
    }

    public /* bridge */ /* synthetic */ double average(String str) {
        return super.average(str);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    public /* bridge */ /* synthetic */ RealmModel first() {
        return super.first();
    }

    public /* bridge */ /* synthetic */ RealmModel first(RealmModel realmModel) {
        return super.first(realmModel);
    }

    public /* bridge */ /* synthetic */ RealmModel get(int i) {
        return super.get(i);
    }

    public /* bridge */ /* synthetic */ boolean isManaged() {
        return super.isManaged();
    }

    public /* bridge */ /* synthetic */ boolean isValid() {
        return super.isValid();
    }

    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public /* bridge */ /* synthetic */ RealmModel last() {
        return super.last();
    }

    public /* bridge */ /* synthetic */ RealmModel last(RealmModel realmModel) {
        return super.last(realmModel);
    }

    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return super.listIterator();
    }

    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return super.listIterator(i);
    }

    public /* bridge */ /* synthetic */ Number max(String str) {
        return super.max(str);
    }

    public /* bridge */ /* synthetic */ Date maxDate(String str) {
        return super.maxDate(str);
    }

    public /* bridge */ /* synthetic */ Number min(String str) {
        return super.min(str);
    }

    public /* bridge */ /* synthetic */ Date minDate(String str) {
        return super.minDate(str);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ RealmModel set(int i, RealmModel realmModel) {
        return super.set(i, realmModel);
    }

    public /* bridge */ /* synthetic */ Number sum(String str) {
        return super.sum(str);
    }

    OrderedRealmCollectionSnapshot(BaseRealm baseRealm, io.realm.internal.Collection collection, Class<E> cls) {
        super(baseRealm, collection.createSnapshot(), (Class) cls);
    }

    OrderedRealmCollectionSnapshot(BaseRealm baseRealm, io.realm.internal.Collection collection, String str) {
        super(baseRealm, collection.createSnapshot(), str);
    }

    public int size() {
        if (this.size == -1) {
            this.size = super.size();
        }
        return this.size;
    }

    public RealmResults<E> sort(String str) {
        throw getUnsupportedException("sort");
    }

    public RealmResults<E> sort(String str, Sort sort) {
        throw getUnsupportedException("sort");
    }

    public RealmResults<E> sort(String str, Sort sort, String str2, Sort sort2) {
        throw getUnsupportedException("sort");
    }

    public RealmResults<E> sort(String[] strArr, Sort[] sortArr) {
        throw getUnsupportedException("sort");
    }

    @Deprecated
    public RealmQuery<E> where() {
        throw getUnsupportedException("where");
    }

    private UnsupportedOperationException getUnsupportedException(String str) {
        return new UnsupportedOperationException(String.format(Locale.US, "'%s()' is not supported by OrderedRealmCollectionSnapshot. Call '%s()' on the original 'RealmCollection' instead.", new Object[]{str, str}));
    }

    public OrderedRealmCollectionSnapshot<E> createSnapshot() {
        this.realm.checkIfValid();
        return this;
    }

    public void deleteFromRealm(int i) {
        this.realm.checkIfValidAndInTransaction();
        if (this.collection.getUncheckedRow(i).isAttached()) {
            this.collection.delete((long) i);
        }
    }

    public boolean deleteFirstFromRealm() {
        this.realm.checkIfValidAndInTransaction();
        UncheckedRow firstUncheckedRow = this.collection.firstUncheckedRow();
        return firstUncheckedRow != null && firstUncheckedRow.isAttached() && this.collection.deleteFirst();
    }

    public boolean deleteLastFromRealm() {
        this.realm.checkIfValidAndInTransaction();
        UncheckedRow lastUncheckedRow = this.collection.lastUncheckedRow();
        return lastUncheckedRow != null && lastUncheckedRow.isAttached() && this.collection.deleteLast();
    }

    public boolean deleteAllFromRealm() {
        return super.deleteAllFromRealm();
    }
}
