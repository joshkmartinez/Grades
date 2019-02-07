package io.realm;

import io.realm.internal.Collection;
import io.realm.internal.InvalidRow;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import rx.Observable;

public class RealmList<E extends RealmModel> extends AbstractList<E> implements OrderedRealmCollection<E> {
    private static final String NULL_OBJECTS_NOT_ALLOWED_MESSAGE = "RealmList does not accept null values";
    private static final String ONLY_IN_MANAGED_MODE_MESSAGE = "This method is only available in managed mode";
    public static final String REMOVE_OUTSIDE_TRANSACTION_ERROR = "Objects can only be removed from inside a write transaction";
    protected String className;
    protected Class<E> clazz;
    private final Collection collection;
    protected BaseRealm realm;
    private List<E> unmanagedList;
    final LinkView view;

    private class RealmItr implements Iterator<E> {
        int cursor;
        int expectedModCount;
        int lastRet;

        private RealmItr() {
            this.cursor = null;
            this.lastRet = -1;
            this.expectedModCount = RealmList.this.modCount;
        }

        public boolean hasNext() {
            RealmList.this.realm.checkIfValid();
            checkConcurrentModification();
            return this.cursor != RealmList.this.size();
        }

        public E next() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = io.realm.RealmList.this;
            r0 = r0.realm;
            r0.checkIfValid();
            r4.checkConcurrentModification();
            r0 = r4.cursor;
            r1 = io.realm.RealmList.this;	 Catch:{ IndexOutOfBoundsException -> 0x0019 }
            r1 = r1.get(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0019 }
            r4.lastRet = r0;	 Catch:{ IndexOutOfBoundsException -> 0x0019 }
            r2 = r0 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x0019 }
            r4.cursor = r2;	 Catch:{ IndexOutOfBoundsException -> 0x0019 }
            return r1;
        L_0x0019:
            r4.checkConcurrentModification();
            r1 = new java.util.NoSuchElementException;
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "Cannot access index ";
            r2.append(r3);
            r2.append(r0);
            r0 = " when size is ";
            r2.append(r0);
            r0 = io.realm.RealmList.this;
            r0 = r0.size();
            r2.append(r0);
            r0 = ". Remember to check hasNext() before using next().";
            r2.append(r0);
            r0 = r2.toString();
            r1.<init>(r0);
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.realm.RealmList.RealmItr.next():E");
        }

        public void remove() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = io.realm.RealmList.this;
            r0 = r0.realm;
            r0.checkIfValid();
            r0 = r2.lastRet;
            if (r0 < 0) goto L_0x0033;
        L_0x000b:
            r2.checkConcurrentModification();
            r0 = io.realm.RealmList.this;	 Catch:{ IndexOutOfBoundsException -> 0x002d }
            r1 = r2.lastRet;	 Catch:{ IndexOutOfBoundsException -> 0x002d }
            r0.remove(r1);	 Catch:{ IndexOutOfBoundsException -> 0x002d }
            r0 = r2.lastRet;	 Catch:{ IndexOutOfBoundsException -> 0x002d }
            r1 = r2.cursor;	 Catch:{ IndexOutOfBoundsException -> 0x002d }
            if (r0 >= r1) goto L_0x0021;	 Catch:{ IndexOutOfBoundsException -> 0x002d }
        L_0x001b:
            r0 = r2.cursor;	 Catch:{ IndexOutOfBoundsException -> 0x002d }
            r0 = r0 + -1;	 Catch:{ IndexOutOfBoundsException -> 0x002d }
            r2.cursor = r0;	 Catch:{ IndexOutOfBoundsException -> 0x002d }
        L_0x0021:
            r0 = -1;	 Catch:{ IndexOutOfBoundsException -> 0x002d }
            r2.lastRet = r0;	 Catch:{ IndexOutOfBoundsException -> 0x002d }
            r0 = io.realm.RealmList.this;	 Catch:{ IndexOutOfBoundsException -> 0x002d }
            r0 = r0.modCount;	 Catch:{ IndexOutOfBoundsException -> 0x002d }
            r2.expectedModCount = r0;	 Catch:{ IndexOutOfBoundsException -> 0x002d }
            return;
        L_0x002d:
            r0 = new java.util.ConcurrentModificationException;
            r0.<init>();
            throw r0;
        L_0x0033:
            r0 = new java.lang.IllegalStateException;
            r1 = "Cannot call remove() twice. Must call next() in between.";
            r0.<init>(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.realm.RealmList.RealmItr.remove():void");
        }

        final void checkConcurrentModification() {
            if (RealmList.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private class RealmListItr extends RealmItr implements ListIterator<E> {
        RealmListItr(int i) {
            super();
            if (i < 0 || i > RealmList.this.size()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Starting location must be a valid index: [0, ");
                stringBuilder.append(RealmList.this.size() - 1);
                stringBuilder.append("]. Index was ");
                stringBuilder.append(i);
                throw new IndexOutOfBoundsException(stringBuilder.toString());
            }
            this.cursor = i;
        }

        public boolean hasPrevious() {
            return this.cursor != 0;
        }

        public E previous() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r4.checkConcurrentModification();
            r0 = r4.cursor;
            r0 = r0 + -1;
            r1 = io.realm.RealmList.this;	 Catch:{ IndexOutOfBoundsException -> 0x0012 }
            r1 = r1.get(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0012 }
            r4.cursor = r0;	 Catch:{ IndexOutOfBoundsException -> 0x0012 }
            r4.lastRet = r0;	 Catch:{ IndexOutOfBoundsException -> 0x0012 }
            return r1;
        L_0x0012:
            r4.checkConcurrentModification();
            r1 = new java.util.NoSuchElementException;
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "Cannot access index less than zero. This was ";
            r2.append(r3);
            r2.append(r0);
            r0 = ". Remember to check hasPrevious() before using previous().";
            r2.append(r0);
            r0 = r2.toString();
            r1.<init>(r0);
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.realm.RealmList.RealmListItr.previous():E");
        }

        public int nextIndex() {
            return this.cursor;
        }

        public int previousIndex() {
            return this.cursor - 1;
        }

        public void set(E r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = io.realm.RealmList.this;
            r0 = r0.realm;
            r0.checkIfValid();
            r0 = r2.lastRet;
            if (r0 < 0) goto L_0x0024;
        L_0x000b:
            r2.checkConcurrentModification();
            r0 = io.realm.RealmList.this;	 Catch:{ IndexOutOfBoundsException -> 0x001e }
            r1 = r2.lastRet;	 Catch:{ IndexOutOfBoundsException -> 0x001e }
            r0.set(r1, r3);	 Catch:{ IndexOutOfBoundsException -> 0x001e }
            r3 = io.realm.RealmList.this;	 Catch:{ IndexOutOfBoundsException -> 0x001e }
            r3 = r3.modCount;	 Catch:{ IndexOutOfBoundsException -> 0x001e }
            r2.expectedModCount = r3;	 Catch:{ IndexOutOfBoundsException -> 0x001e }
            return;
        L_0x001e:
            r3 = new java.util.ConcurrentModificationException;
            r3.<init>();
            throw r3;
        L_0x0024:
            r3 = new java.lang.IllegalStateException;
            r3.<init>();
            throw r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.realm.RealmList.RealmListItr.set(io.realm.RealmModel):void");
        }

        public void add(E r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = io.realm.RealmList.this;
            r0 = r0.realm;
            r0.checkIfValid();
            r2.checkConcurrentModification();
            r0 = r2.cursor;	 Catch:{ IndexOutOfBoundsException -> 0x0021 }
            r1 = io.realm.RealmList.this;	 Catch:{ IndexOutOfBoundsException -> 0x0021 }
            r1.add(r0, r3);	 Catch:{ IndexOutOfBoundsException -> 0x0021 }
            r3 = -1;	 Catch:{ IndexOutOfBoundsException -> 0x0021 }
            r2.lastRet = r3;	 Catch:{ IndexOutOfBoundsException -> 0x0021 }
            r0 = r0 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x0021 }
            r2.cursor = r0;	 Catch:{ IndexOutOfBoundsException -> 0x0021 }
            r3 = io.realm.RealmList.this;	 Catch:{ IndexOutOfBoundsException -> 0x0021 }
            r3 = r3.modCount;	 Catch:{ IndexOutOfBoundsException -> 0x0021 }
            r2.expectedModCount = r3;	 Catch:{ IndexOutOfBoundsException -> 0x0021 }
            return;
        L_0x0021:
            r3 = new java.util.ConcurrentModificationException;
            r3.<init>();
            throw r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.realm.RealmList.RealmListItr.add(io.realm.RealmModel):void");
        }
    }

    public boolean isLoaded() {
        return true;
    }

    public boolean load() {
        return true;
    }

    public RealmList() {
        this.collection = null;
        this.view = null;
        this.unmanagedList = new ArrayList();
    }

    public RealmList(E... eArr) {
        if (eArr != null) {
            this.collection = null;
            this.view = null;
            this.unmanagedList = new ArrayList(eArr.length);
            Collections.addAll(this.unmanagedList, eArr);
            return;
        }
        throw new IllegalArgumentException("The objects argument cannot be null");
    }

    RealmList(Class<E> cls, LinkView linkView, BaseRealm baseRealm) {
        this.collection = new Collection(baseRealm.sharedRealm, linkView, null);
        this.clazz = cls;
        this.view = linkView;
        this.realm = baseRealm;
    }

    RealmList(String str, LinkView linkView, BaseRealm baseRealm) {
        this.collection = new Collection(baseRealm.sharedRealm, linkView, null);
        this.view = linkView;
        this.realm = baseRealm;
        this.className = str;
    }

    public boolean isValid() {
        if (this.realm == null) {
            return true;
        }
        if (this.realm.isClosed()) {
            return false;
        }
        return isAttached();
    }

    public boolean isManaged() {
        return this.realm != null;
    }

    private boolean isAttached() {
        return this.view != null && this.view.isAttached();
    }

    public void add(int i, E e) {
        checkValidObject(e);
        if (isManaged()) {
            checkValidView();
            if (i < 0 || i > size()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid index ");
                stringBuilder.append(i);
                stringBuilder.append(", size is ");
                stringBuilder.append(size());
                throw new IndexOutOfBoundsException(stringBuilder.toString());
            }
            this.view.insert((long) i, ((RealmObjectProxy) copyToRealmIfNeeded(e)).realmGet$proxyState().getRow$realm().getIndex());
        } else {
            this.unmanagedList.add(i, e);
        }
        this.modCount++;
    }

    public boolean add(E e) {
        checkValidObject(e);
        if (isManaged()) {
            checkValidView();
            this.view.add(((RealmObjectProxy) copyToRealmIfNeeded(e)).realmGet$proxyState().getRow$realm().getIndex());
        } else {
            this.unmanagedList.add(e);
        }
        this.modCount += 1;
        return true;
    }

    public E set(int i, E e) {
        checkValidObject(e);
        if (!isManaged()) {
            return (RealmModel) this.unmanagedList.set(i, e);
        }
        checkValidView();
        RealmObjectProxy realmObjectProxy = (RealmObjectProxy) copyToRealmIfNeeded(e);
        E e2 = get(i);
        this.view.set((long) i, realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex());
        return e2;
    }

    private E copyToRealmIfNeeded(E e) {
        if (e instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) e;
            if (realmObjectProxy instanceof DynamicRealmObject) {
                String className = this.view.getTargetTable().getClassName();
                if (realmObjectProxy.realmGet$proxyState().getRealm$realm() == this.realm) {
                    if (className.equals(((DynamicRealmObject) e).getType())) {
                        return e;
                    }
                    throw new IllegalArgumentException(String.format(Locale.US, "The object has a different type from list's. Type of the list is '%s', type of object is '%s'.", new Object[]{className, r0}));
                } else if (this.realm.threadId == realmObjectProxy.realmGet$proxyState().getRealm$realm().threadId) {
                    throw new IllegalArgumentException("Cannot copy DynamicRealmObject between Realm instances.");
                } else {
                    throw new IllegalStateException("Cannot copy an object to a Realm instance created in another thread.");
                }
            } else if (realmObjectProxy.realmGet$proxyState().getRow$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(this.realm.getPath())) {
                if (this.realm == realmObjectProxy.realmGet$proxyState().getRealm$realm()) {
                    return e;
                }
                throw new IllegalArgumentException("Cannot copy an object from another Realm instance.");
            }
        }
        Realm realm = (Realm) this.realm;
        if (realm.getTable(e.getClass()).hasPrimaryKey()) {
            return realm.copyToRealmOrUpdate((RealmModel) e);
        }
        return realm.copyToRealm((RealmModel) e);
    }

    public void move(int i, int i2) {
        if (isManaged()) {
            checkValidView();
            this.view.move((long) i, (long) i2);
            return;
        }
        checkIndex(i);
        checkIndex(i2);
        RealmModel realmModel = (RealmModel) this.unmanagedList.remove(i);
        if (i2 > i) {
            this.unmanagedList.add(i2 - 1, realmModel);
        } else {
            this.unmanagedList.add(i2, realmModel);
        }
    }

    public void clear() {
        if (isManaged()) {
            checkValidView();
            this.view.clear();
        } else {
            this.unmanagedList.clear();
        }
        this.modCount++;
    }

    public E remove(int i) {
        E e;
        if (isManaged()) {
            checkValidView();
            e = get(i);
            this.view.remove((long) i);
        } else {
            e = (RealmModel) this.unmanagedList.remove(i);
        }
        this.modCount++;
        return e;
    }

    public boolean remove(Object obj) {
        if (isManaged()) {
            if (!this.realm.isInTransaction()) {
                throw new IllegalStateException(REMOVE_OUTSIDE_TRANSACTION_ERROR);
            }
        }
        return super.remove(obj);
    }

    public boolean removeAll(java.util.Collection<?> collection) {
        if (isManaged()) {
            if (!this.realm.isInTransaction()) {
                throw new IllegalStateException(REMOVE_OUTSIDE_TRANSACTION_ERROR);
            }
        }
        return super.removeAll(collection);
    }

    public boolean deleteFirstFromRealm() {
        if (!isManaged()) {
            throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
        } else if (size() <= 0) {
            return false;
        } else {
            deleteFromRealm(0);
            this.modCount++;
            return true;
        }
    }

    public boolean deleteLastFromRealm() {
        if (!isManaged()) {
            throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
        } else if (size() <= 0) {
            return false;
        } else {
            deleteFromRealm(size() - 1);
            this.modCount++;
            return true;
        }
    }

    public E get(int i) {
        if (!isManaged()) {
            return (RealmModel) this.unmanagedList.get(i);
        }
        checkValidView();
        return this.realm.get(this.clazz, this.className, this.view.getTargetRowIndex((long) i));
    }

    public E first() {
        return firstImpl(true, null);
    }

    public E first(E e) {
        return firstImpl(false, e);
    }

    private E firstImpl(boolean z, E e) {
        if (isManaged()) {
            checkValidView();
            if (!this.view.isEmpty()) {
                return get(0);
            }
        } else if (!(this.unmanagedList == null || this.unmanagedList.isEmpty())) {
            return (RealmModel) this.unmanagedList.get(0);
        }
        if (!z) {
            return e;
        }
        throw new IndexOutOfBoundsException("The list is empty.");
    }

    public E last() {
        return lastImpl(true, null);
    }

    public E last(E e) {
        return lastImpl(false, e);
    }

    private E lastImpl(boolean z, E e) {
        if (isManaged()) {
            checkValidView();
            if (!this.view.isEmpty()) {
                return get(((int) this.view.size()) - 1);
            }
        } else if (!(this.unmanagedList == null || this.unmanagedList.isEmpty())) {
            return (RealmModel) this.unmanagedList.get(this.unmanagedList.size() - 1);
        }
        if (!z) {
            return e;
        }
        throw new IndexOutOfBoundsException("The list is empty.");
    }

    public RealmResults<E> sort(String str) {
        return sort(str, Sort.ASCENDING);
    }

    public RealmResults<E> sort(String str, Sort sort) {
        if (isManaged()) {
            return where().findAllSorted(str, sort);
        }
        throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
    }

    public RealmResults<E> sort(String str, Sort sort, String str2, Sort sort2) {
        return sort(new String[]{str, str2}, new Sort[]{sort, sort2});
    }

    public RealmResults<E> sort(String[] strArr, Sort[] sortArr) {
        if (isManaged()) {
            return where().findAllSorted(strArr, sortArr);
        }
        throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
    }

    public void deleteFromRealm(int i) {
        if (isManaged()) {
            checkValidView();
            this.view.removeTargetRow(i);
            this.modCount++;
            return;
        }
        throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
    }

    public int size() {
        if (!isManaged()) {
            return this.unmanagedList.size();
        }
        checkValidView();
        long size = this.view.size();
        return size < 2147483647L ? (int) size : Integer.MAX_VALUE;
    }

    public RealmQuery<E> where() {
        if (isManaged()) {
            checkValidView();
            return RealmQuery.createQueryFromList(this);
        }
        throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
    }

    public Number min(String str) {
        if (isManaged()) {
            return where().min(str);
        }
        throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
    }

    public Number max(String str) {
        if (isManaged()) {
            return where().max(str);
        }
        throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
    }

    public Number sum(String str) {
        if (isManaged()) {
            return where().sum(str);
        }
        throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
    }

    public double average(String str) {
        if (isManaged()) {
            return where().average(str);
        }
        throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
    }

    public Date maxDate(String str) {
        if (isManaged()) {
            return where().maximumDate(str);
        }
        throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
    }

    public Date minDate(String str) {
        if (isManaged()) {
            return where().minimumDate(str);
        }
        throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
    }

    public boolean deleteAllFromRealm() {
        if (isManaged()) {
            checkValidView();
            if (size() <= 0) {
                return false;
            }
            this.view.removeAllTargetRows();
            this.modCount++;
            return true;
        }
        throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
    }

    public boolean contains(Object obj) {
        if (!isManaged()) {
            return this.unmanagedList.contains(obj);
        }
        this.realm.checkIfValid();
        if ((obj instanceof RealmObjectProxy) && ((RealmObjectProxy) obj).realmGet$proxyState().getRow$realm() == InvalidRow.INSTANCE) {
            return false;
        }
        Iterator it = iterator();
        while (it.hasNext()) {
            if (((RealmModel) it.next()).equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public Iterator<E> iterator() {
        if (isManaged()) {
            return new RealmItr();
        }
        return super.iterator();
    }

    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public ListIterator<E> listIterator(int i) {
        if (isManaged()) {
            return new RealmListItr(i);
        }
        return super.listIterator(i);
    }

    private void checkValidObject(E e) {
        if (e == null) {
            throw new IllegalArgumentException(NULL_OBJECTS_NOT_ALLOWED_MESSAGE);
        }
    }

    private void checkIndex(int i) {
        int size = size();
        if (i < 0 || i >= size) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid index ");
            stringBuilder.append(i);
            stringBuilder.append(", size is ");
            stringBuilder.append(size);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
    }

    private void checkValidView() {
        this.realm.checkIfValid();
        if (this.view == null || !this.view.isAttached()) {
            throw new IllegalStateException("Realm instance has been closed or this object or its parent has been deleted.");
        }
    }

    public OrderedRealmCollectionSnapshot<E> createSnapshot() {
        if (isManaged()) {
            checkValidView();
            if (this.className != null) {
                return new OrderedRealmCollectionSnapshot(this.realm, new Collection(this.realm.sharedRealm, this.view, null), this.className);
            }
            return new OrderedRealmCollectionSnapshot(this.realm, new Collection(this.realm.sharedRealm, this.view, null), this.clazz);
        }
        throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((isManaged() ? this.clazz : getClass()).getSimpleName());
        stringBuilder.append("@[");
        if (!isManaged() || isAttached()) {
            for (int i = 0; i < size(); i++) {
                if (isManaged()) {
                    stringBuilder.append(((RealmObjectProxy) get(i)).realmGet$proxyState().getRow$realm().getIndex());
                } else {
                    stringBuilder.append(System.identityHashCode(get(i)));
                }
                if (i < size() - 1) {
                    stringBuilder.append(',');
                }
            }
        } else {
            stringBuilder.append("invalid");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public Observable<RealmList<E>> asObservable() {
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

    private void checkForAddRemoveListener(Object obj, boolean z) {
        if (z) {
            if (obj == null) {
                throw new IllegalArgumentException("Listener should not be null");
            }
        }
        this.realm.checkIfValid();
        this.realm.sharedRealm.capabilities.checkCanDeliverNotification("Listeners cannot be used on current thread.");
    }

    public void addChangeListener(OrderedRealmCollectionChangeListener<RealmList<E>> orderedRealmCollectionChangeListener) {
        checkForAddRemoveListener(orderedRealmCollectionChangeListener, true);
        this.collection.addListener((Object) this, (OrderedRealmCollectionChangeListener) orderedRealmCollectionChangeListener);
    }

    public void removeChangeListener(OrderedRealmCollectionChangeListener<RealmList<E>> orderedRealmCollectionChangeListener) {
        checkForAddRemoveListener(orderedRealmCollectionChangeListener, true);
        this.collection.removeListener((Object) this, (OrderedRealmCollectionChangeListener) orderedRealmCollectionChangeListener);
    }

    public void addChangeListener(RealmChangeListener<RealmList<E>> realmChangeListener) {
        checkForAddRemoveListener(realmChangeListener, true);
        this.collection.addListener((Object) this, (RealmChangeListener) realmChangeListener);
    }

    public void removeChangeListener(RealmChangeListener<RealmList<E>> realmChangeListener) {
        checkForAddRemoveListener(realmChangeListener, true);
        this.collection.removeListener((Object) this, (RealmChangeListener) realmChangeListener);
    }

    public void removeAllChangeListeners() {
        checkForAddRemoveListener(null, false);
        this.collection.removeAllListeners();
    }
}
