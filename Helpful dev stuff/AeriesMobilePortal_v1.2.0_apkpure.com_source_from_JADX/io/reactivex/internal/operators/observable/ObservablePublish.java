package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublish<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T> {
    final AtomicReference<PublishObserver<T>> current;
    final ObservableSource<T> onSubscribe;
    final ObservableSource<T> source;

    static final class InnerDisposable<T> extends AtomicReference<Object> implements Disposable {
        private static final long serialVersionUID = -1100270633763673112L;
        final Observer<? super T> child;

        InnerDisposable(Observer<? super T> observer) {
            this.child = observer;
        }

        public boolean isDisposed() {
            return get() == this;
        }

        public void dispose() {
            InnerDisposable andSet = getAndSet(this);
            if (andSet != null && andSet != this) {
                ((PublishObserver) andSet).remove(this);
            }
        }

        void setParent(PublishObserver<T> publishObserver) {
            if (!compareAndSet(null, publishObserver)) {
                publishObserver.remove(this);
            }
        }
    }

    static final class PublishObserver<T> implements Observer<T>, Disposable {
        static final InnerDisposable[] EMPTY = new InnerDisposable[0];
        static final InnerDisposable[] TERMINATED = new InnerDisposable[0];
        final AtomicReference<PublishObserver<T>> current;
        final AtomicReference<InnerDisposable<T>[]> observers = new AtomicReference(EMPTY);
        final AtomicReference<Disposable> f143s = new AtomicReference();
        final AtomicBoolean shouldConnect;

        PublishObserver(AtomicReference<PublishObserver<T>> atomicReference) {
            this.current = atomicReference;
            this.shouldConnect = new AtomicBoolean();
        }

        public void dispose() {
            if (this.observers.get() != TERMINATED && ((InnerDisposable[]) this.observers.getAndSet(TERMINATED)) != TERMINATED) {
                this.current.compareAndSet(this, null);
                DisposableHelper.dispose(this.f143s);
            }
        }

        public boolean isDisposed() {
            return this.observers.get() == TERMINATED;
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f143s, disposable);
        }

        public void onNext(T t) {
            for (InnerDisposable innerDisposable : (InnerDisposable[]) this.observers.get()) {
                innerDisposable.child.onNext(t);
            }
        }

        public void onError(Throwable th) {
            this.current.compareAndSet(this, null);
            InnerDisposable[] innerDisposableArr = (InnerDisposable[]) this.observers.getAndSet(TERMINATED);
            if (innerDisposableArr.length != 0) {
                for (InnerDisposable innerDisposable : innerDisposableArr) {
                    innerDisposable.child.onError(th);
                }
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onComplete() {
            this.current.compareAndSet(this, null);
            for (InnerDisposable innerDisposable : (InnerDisposable[]) this.observers.getAndSet(TERMINATED)) {
                innerDisposable.child.onComplete();
            }
        }

        boolean add(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            Object obj;
            do {
                innerDisposableArr = (InnerDisposable[]) this.observers.get();
                if (innerDisposableArr == TERMINATED) {
                    return false;
                }
                int length = innerDisposableArr.length;
                obj = new InnerDisposable[(length + 1)];
                System.arraycopy(innerDisposableArr, 0, obj, 0, length);
                obj[length] = innerDisposable;
            } while (!this.observers.compareAndSet(innerDisposableArr, obj));
            return true;
        }

        void remove(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            Object obj;
            do {
                innerDisposableArr = (InnerDisposable[]) this.observers.get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i = -1;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (innerDisposableArr[i2].equals(innerDisposable)) {
                            i = i2;
                            break;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            obj = EMPTY;
                        } else {
                            Object obj2 = new InnerDisposable[(length - 1)];
                            System.arraycopy(innerDisposableArr, 0, obj2, 0, i);
                            System.arraycopy(innerDisposableArr, i + 1, obj2, i, (length - i) - 1);
                            obj = obj2;
                        }
                    } else {
                        return;
                    }
                }
                return;
            } while (!this.observers.compareAndSet(innerDisposableArr, obj));
        }
    }

    static final class PublishSource<T> implements ObservableSource<T> {
        private final AtomicReference<PublishObserver<T>> curr;

        PublishSource(AtomicReference<PublishObserver<T>> atomicReference) {
            this.curr = atomicReference;
        }

        public void subscribe(Observer<? super T> observer) {
            InnerDisposable innerDisposable = new InnerDisposable(observer);
            observer.onSubscribe(innerDisposable);
            while (true) {
                observer = (PublishObserver) this.curr.get();
                if (observer == null || observer.isDisposed()) {
                    PublishObserver publishObserver = new PublishObserver(this.curr);
                    if (this.curr.compareAndSet(observer, publishObserver) != null) {
                        observer = publishObserver;
                    }
                }
                if (observer.add(innerDisposable)) {
                    innerDisposable.setParent(observer);
                    return;
                }
            }
        }
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly(new ObservablePublish(new PublishSource(atomicReference), observableSource, atomicReference));
    }

    private ObservablePublish(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<PublishObserver<T>> atomicReference) {
        this.onSubscribe = observableSource;
        this.source = observableSource2;
        this.current = atomicReference;
    }

    public ObservableSource<T> source() {
        return this.source;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.onSubscribe.subscribe(observer);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> r5) {
        /*
        r4 = this;
    L_0x0000:
        r0 = r4.current;
        r0 = r0.get();
        r0 = (io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver) r0;
        if (r0 == 0) goto L_0x0010;
    L_0x000a:
        r1 = r0.isDisposed();
        if (r1 == 0) goto L_0x0021;
    L_0x0010:
        r1 = new io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver;
        r2 = r4.current;
        r1.<init>(r2);
        r2 = r4.current;
        r0 = r2.compareAndSet(r0, r1);
        if (r0 != 0) goto L_0x0020;
    L_0x001f:
        goto L_0x0000;
    L_0x0020:
        r0 = r1;
    L_0x0021:
        r1 = r0.shouldConnect;
        r1 = r1.get();
        r2 = 1;
        r3 = 0;
        if (r1 != 0) goto L_0x0034;
    L_0x002b:
        r1 = r0.shouldConnect;
        r1 = r1.compareAndSet(r3, r2);
        if (r1 == 0) goto L_0x0034;
    L_0x0033:
        goto L_0x0035;
    L_0x0034:
        r2 = r3;
    L_0x0035:
        r5.accept(r0);	 Catch:{ Throwable -> 0x0040 }
        if (r2 == 0) goto L_0x003f;
    L_0x003a:
        r5 = r4.source;
        r5.subscribe(r0);
    L_0x003f:
        return;
    L_0x0040:
        r5 = move-exception;
        io.reactivex.exceptions.Exceptions.throwIfFatal(r5);
        r5 = io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(r5);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservablePublish.connect(io.reactivex.functions.Consumer):void");
    }
}
