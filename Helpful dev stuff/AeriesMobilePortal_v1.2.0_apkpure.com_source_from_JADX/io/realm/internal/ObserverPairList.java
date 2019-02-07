package io.realm.internal;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObserverPairList<T extends ObserverPair> {
    private boolean cleared = false;
    private List<T> pairs = new CopyOnWriteArrayList();

    public interface Callback<T extends ObserverPair> {
        void onCalled(T t, Object obj);
    }

    public static abstract class ObserverPair<T, S> {
        protected final S listener;
        final WeakReference<T> observerRef;
        boolean removed = false;

        ObserverPair(T t, S s) {
            this.listener = s;
            this.observerRef = new WeakReference(t);
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ObserverPair)) {
                return false;
            }
            ObserverPair observerPair = (ObserverPair) obj;
            if (!this.listener.equals(observerPair.listener) || this.observerRef.get() != observerPair.observerRef.get()) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            Object obj = this.observerRef.get();
            int i = 0;
            int hashCode = 31 * (527 + (obj != null ? obj.hashCode() : 0));
            if (this.listener != null) {
                i = this.listener.hashCode();
            }
            return hashCode + i;
        }
    }

    public void foreach(Callback<T> callback) {
        for (ObserverPair observerPair : this.pairs) {
            if (!this.cleared) {
                Object obj = observerPair.observerRef.get();
                if (obj == null) {
                    this.pairs.remove(observerPair);
                } else if (!observerPair.removed) {
                    callback.onCalled(observerPair, obj);
                }
            } else {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return this.pairs.isEmpty();
    }

    public void clear() {
        this.cleared = true;
        this.pairs.clear();
    }

    public void add(T t) {
        if (!this.pairs.contains(t)) {
            this.pairs.add(t);
            t.removed = false;
        }
        if (this.cleared != null) {
            this.cleared = false;
        }
    }

    public <S, U> void remove(S s, U u) {
        for (ObserverPair observerPair : this.pairs) {
            if (s == observerPair.observerRef.get() && u.equals(observerPair.listener)) {
                observerPair.removed = true;
                this.pairs.remove(observerPair);
                return;
            }
        }
    }

    void removeByObserver(Object obj) {
        for (ObserverPair observerPair : this.pairs) {
            Object obj2 = observerPair.observerRef.get();
            if (obj2 == null || obj2 == obj) {
                observerPair.removed = true;
                this.pairs.remove(observerPair);
            }
        }
    }

    public int size() {
        return this.pairs.size();
    }
}
