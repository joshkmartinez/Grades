package io.realm;

import android.annotation.SuppressLint;
import io.realm.internal.CheckedRow;
import io.realm.internal.Row;
import io.realm.internal.SortDescriptor;
import io.realm.internal.Table;
import io.realm.internal.UncheckedRow;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;
import rx.Observable;

public class RealmResults<E extends RealmModel> extends OrderedRealmCollectionImpl<E> {
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

    public /* bridge */ /* synthetic */ OrderedRealmCollectionSnapshot createSnapshot() {
        return super.createSnapshot();
    }

    public /* bridge */ /* synthetic */ boolean deleteAllFromRealm() {
        return super.deleteAllFromRealm();
    }

    public /* bridge */ /* synthetic */ boolean deleteFirstFromRealm() {
        return super.deleteFirstFromRealm();
    }

    public /* bridge */ /* synthetic */ void deleteFromRealm(int i) {
        super.deleteFromRealm(i);
    }

    public /* bridge */ /* synthetic */ boolean deleteLastFromRealm() {
        return super.deleteLastFromRealm();
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

    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    public /* bridge */ /* synthetic */ RealmResults sort(String str) {
        return super.sort(str);
    }

    public /* bridge */ /* synthetic */ Number sum(String str) {
        return super.sum(str);
    }

    @SuppressLint({"unused"})
    static <T extends RealmModel> RealmResults<T> createBacklinkResults(BaseRealm baseRealm, Row row, Class<T> cls, String str) {
        return new RealmResults(baseRealm, io.realm.internal.Collection.createBacklinksCollection(baseRealm.sharedRealm, (UncheckedRow) row, baseRealm.getSchema().getTable((Class) cls), str), (Class) cls);
    }

    static RealmResults<DynamicRealmObject> createDynamicBacklinkResults(DynamicRealm dynamicRealm, CheckedRow checkedRow, Table table, String str) {
        return new RealmResults((BaseRealm) dynamicRealm, io.realm.internal.Collection.createBacklinksCollection(dynamicRealm.sharedRealm, checkedRow, table, str), Table.getClassNameForTable(table.getName()));
    }

    RealmResults(BaseRealm baseRealm, io.realm.internal.Collection collection, Class<E> cls) {
        super(baseRealm, collection, (Class) cls);
    }

    RealmResults(BaseRealm baseRealm, io.realm.internal.Collection collection, String str) {
        super(baseRealm, collection, str);
    }

    public RealmQuery<E> where() {
        this.realm.checkIfValid();
        return RealmQuery.createQueryFromResult(this);
    }

    public RealmResults<E> sort(String str, Sort sort, String str2, Sort sort2) {
        return sort(new String[]{str, str2}, new Sort[]{sort, sort2});
    }

    public boolean isLoaded() {
        this.realm.checkIfValid();
        return this.collection.isLoaded();
    }

    public boolean load() {
        this.realm.checkIfValid();
        this.collection.load();
        return true;
    }

    public void addChangeListener(RealmChangeListener<RealmResults<E>> realmChangeListener) {
        checkForAddRemoveListener(realmChangeListener, true);
        this.collection.addListener((Object) this, (RealmChangeListener) realmChangeListener);
    }

    public void addChangeListener(OrderedRealmCollectionChangeListener<RealmResults<E>> orderedRealmCollectionChangeListener) {
        checkForAddRemoveListener(orderedRealmCollectionChangeListener, true);
        this.collection.addListener((Object) this, (OrderedRealmCollectionChangeListener) orderedRealmCollectionChangeListener);
    }

    private void checkForAddRemoveListener(Object obj, boolean z) {
        if (z) {
            if (obj == null) {
                throw new IllegalArgumentException("Listener should not be null");
            }
        }
        this.realm.checkIfValid();
        this.realm.sharedRealm.capabilities.checkCanDeliverNotification("Listeners cannot be used on current thread.");
    }

    public void removeAllChangeListeners() {
        checkForAddRemoveListener(null, false);
        this.collection.removeAllListeners();
    }

    @Deprecated
    public void removeChangeListeners() {
        removeAllChangeListeners();
    }

    public void removeChangeListener(RealmChangeListener<RealmResults<E>> realmChangeListener) {
        checkForAddRemoveListener(realmChangeListener, true);
        this.collection.removeListener((Object) this, (RealmChangeListener) realmChangeListener);
    }

    public void removeChangeListener(OrderedRealmCollectionChangeListener<RealmResults<E>> orderedRealmCollectionChangeListener) {
        checkForAddRemoveListener(orderedRealmCollectionChangeListener, true);
        this.collection.removeListener((Object) this, (OrderedRealmCollectionChangeListener) orderedRealmCollectionChangeListener);
    }

    public Observable<RealmResults<E>> asObservable() {
        if (this.realm instanceof Realm) {
            return this.realm.configuration.getRxFactory().from((Realm) this.realm, this);
        }
        if (this.realm instanceof DynamicRealm) {
            return this.realm.configuration.getRxFactory().from((DynamicRealm) this.realm, this);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.realm.getClass());
        stringBuilder.append(" does not support RxJava.");
        throw new UnsupportedOperationException(stringBuilder.toString());
    }

    @Deprecated
    public RealmResults<E> distinct(String str) {
        return createLoadedResults(this.collection.distinct(SortDescriptor.getInstanceForDistinct(new SchemaConnector(this.realm.getSchema()), this.collection.getTable(), str)));
    }

    @Deprecated
    public RealmResults<E> distinctAsync(String str) {
        return where().distinctAsync(str);
    }

    @Deprecated
    public RealmResults<E> distinct(String str, String... strArr) {
        return where().distinct(str, strArr);
    }
}
