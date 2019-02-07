package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {
    final int bufferSize;
    final boolean delayError;
    final Function<? super T, ? extends K> keySelector;
    final Function<? super T, ? extends V> valueSelector;

    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final Observer<? super GroupedObservable<K, V>> actual;
        final int bufferSize;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final boolean delayError;
        final Map<Object, GroupedUnicast<K, V>> groups;
        final Function<? super T, ? extends K> keySelector;
        Disposable f133s;
        final Function<? super T, ? extends V> valueSelector;

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z) {
            this.actual = observer;
            this.keySelector = function;
            this.valueSelector = function2;
            this.bufferSize = i;
            this.delayError = z;
            this.groups = new ConcurrentHashMap();
            lazySet(1);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f133s, disposable)) {
                this.f133s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            try {
                Object obj;
                Object apply = this.keySelector.apply(t);
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = NULL_KEY;
                }
                GroupedUnicast groupedUnicast = (GroupedUnicast) this.groups.get(obj);
                if (groupedUnicast == null) {
                    if (!this.cancelled.get()) {
                        groupedUnicast = GroupedUnicast.createWith(apply, this.bufferSize, this, this.delayError);
                        this.groups.put(obj, groupedUnicast);
                        getAndIncrement();
                        this.actual.onNext(groupedUnicast);
                    } else {
                        return;
                    }
                }
                try {
                    groupedUnicast.onNext(ObjectHelper.requireNonNull(this.valueSelector.apply(t), "The value supplied is null"));
                } catch (T t2) {
                    Exceptions.throwIfFatal(t2);
                    this.f133s.dispose();
                    onError(t2);
                }
            } catch (T t22) {
                Exceptions.throwIfFatal(t22);
                this.f133s.dispose();
                onError(t22);
            }
        }

        public void onError(Throwable th) {
            List<GroupedUnicast> arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            for (GroupedUnicast onError : arrayList) {
                onError.onError(th);
            }
            this.actual.onError(th);
        }

        public void onComplete() {
            List<GroupedUnicast> arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            for (GroupedUnicast onComplete : arrayList) {
                onComplete.onComplete();
            }
            this.actual.onComplete();
        }

        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.f133s.dispose();
            }
        }

        public boolean isDisposed() {
            return this.cancelled.get();
        }

        public void cancel(K k) {
            if (k == null) {
                k = NULL_KEY;
            }
            this.groups.remove(k);
            if (decrementAndGet() == null) {
                this.f133s.dispose();
            }
        }
    }

    static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final AtomicReference<Observer<? super T>> actual = new AtomicReference();
        final AtomicBoolean cancelled = new AtomicBoolean();
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final AtomicBoolean once = new AtomicBoolean();
        final GroupByObserver<?, K, T> parent;
        final SpscLinkedArrayQueue<T> queue;

        State(int i, GroupByObserver<?, K, T> groupByObserver, K k, boolean z) {
            this.queue = new SpscLinkedArrayQueue(i);
            this.parent = groupByObserver;
            this.key = k;
            this.delayError = z;
        }

        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet(null);
                this.parent.cancel(this.key);
            }
        }

        public boolean isDisposed() {
            return this.cancelled.get();
        }

        public void subscribe(Observer<? super T> observer) {
            if (this.once.compareAndSet(false, true)) {
                observer.onSubscribe(this);
                this.actual.lazySet(observer);
                if (this.cancelled.get() != null) {
                    this.actual.lazySet(null);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), (Observer) observer);
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
                boolean z = this.delayError;
                Observer observer = (Observer) this.actual.get();
                int i = 1;
                while (true) {
                    if (observer != null) {
                        while (true) {
                            boolean z2 = this.done;
                            Object poll = spscLinkedArrayQueue.poll();
                            boolean z3 = poll == null;
                            if (!checkTerminated(z2, z3, observer, z)) {
                                if (z3) {
                                    break;
                                }
                                observer.onNext(poll);
                            } else {
                                return;
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i != 0) {
                        if (observer == null) {
                            observer = (Observer) this.actual.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        boolean checkTerminated(boolean z, boolean z2, Observer<? super T> observer, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                this.actual.lazySet(null);
                return true;
            }
            if (z) {
                if (!z3) {
                    z = this.error;
                    if (z) {
                        this.queue.clear();
                        this.actual.lazySet(null);
                        observer.onError(z);
                        return true;
                    } else if (z2) {
                        this.actual.lazySet(null);
                        observer.onComplete();
                        return true;
                    }
                } else if (z2) {
                    z = this.error;
                    this.actual.lazySet(null);
                    if (z) {
                        observer.onError(z);
                    } else {
                        observer.onComplete();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        final State<T, K> state;

        public static <T, K> GroupedUnicast<K, T> createWith(K k, int i, GroupByObserver<?, K, T> groupByObserver, boolean z) {
            return new GroupedUnicast(k, new State(i, groupByObserver, k, z));
        }

        protected GroupedUnicast(K k, State<T, K> state) {
            super(k);
            this.state = state;
        }

        protected void subscribeActual(Observer<? super T> observer) {
            this.state.subscribe(observer);
        }

        public void onNext(T t) {
            this.state.onNext(t);
        }

        public void onError(Throwable th) {
            this.state.onError(th);
        }

        public void onComplete() {
            this.state.onComplete();
        }
    }

    public ObservableGroupBy(ObservableSource<T> observableSource, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z) {
        super(observableSource);
        this.keySelector = function;
        this.valueSelector = function2;
        this.bufferSize = i;
        this.delayError = z;
    }

    public void subscribeActual(Observer<? super GroupedObservable<K, V>> observer) {
        this.source.subscribe(new GroupByObserver(observer, this.keySelector, this.valueSelector, this.bufferSize, this.delayError));
    }
}
