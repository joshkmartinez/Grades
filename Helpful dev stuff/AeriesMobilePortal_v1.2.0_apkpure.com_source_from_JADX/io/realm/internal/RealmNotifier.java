package io.realm.internal;

import io.realm.RealmChangeListener;
import io.realm.internal.ObserverPairList.Callback;
import io.realm.internal.ObserverPairList.ObserverPair;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

@Keep
public abstract class RealmNotifier implements Closeable {
    private final Callback<RealmObserverPair> onChangeCallBack = new C10451();
    private ObserverPairList<RealmObserverPair> realmObserverPairs = new ObserverPairList();
    private SharedRealm sharedRealm;
    private List<Runnable> transactionCallbacks = new ArrayList();

    class C10451 implements Callback<RealmObserverPair> {
        C10451() {
        }

        public void onCalled(RealmObserverPair realmObserverPair, Object obj) {
            if (RealmNotifier.this.sharedRealm != null && !RealmNotifier.this.sharedRealm.isClosed()) {
                realmObserverPair.onChange(obj);
            }
        }
    }

    private static class RealmObserverPair<T> extends ObserverPair<T, RealmChangeListener<T>> {
        public RealmObserverPair(T t, RealmChangeListener<T> realmChangeListener) {
            super(t, realmChangeListener);
        }

        private void onChange(T t) {
            if (t != null) {
                ((RealmChangeListener) this.listener).onChange(t);
            }
        }
    }

    public abstract boolean post(Runnable runnable);

    protected RealmNotifier(SharedRealm sharedRealm) {
        this.sharedRealm = sharedRealm;
    }

    void didChange() {
        this.realmObserverPairs.foreach(this.onChangeCallBack);
        if (!this.transactionCallbacks.isEmpty()) {
            List<Runnable> list = this.transactionCallbacks;
            this.transactionCallbacks = new ArrayList();
            for (Runnable run : list) {
                run.run();
            }
        }
    }

    void beforeNotify() {
        this.sharedRealm.invalidateIterators();
    }

    public void close() {
        removeAllChangeListeners();
    }

    public <T> void addChangeListener(T t, RealmChangeListener<T> realmChangeListener) {
        this.realmObserverPairs.add(new RealmObserverPair(t, realmChangeListener));
    }

    public <E> void removeChangeListener(E e, RealmChangeListener<E> realmChangeListener) {
        this.realmObserverPairs.remove(e, realmChangeListener);
    }

    public <E> void removeChangeListeners(E e) {
        this.realmObserverPairs.removeByObserver(e);
    }

    private void removeAllChangeListeners() {
        this.realmObserverPairs.clear();
    }

    public void addTransactionCallback(Runnable runnable) {
        this.transactionCallbacks.add(runnable);
    }

    public int getListenersListSize() {
        return this.realmObserverPairs.size();
    }
}
