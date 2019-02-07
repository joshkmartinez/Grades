package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCombineLatest<T, R> extends Observable<R> {
    final int bufferSize;
    final Function<? super Object[], ? extends R> combiner;
    final boolean delayError;
    final ObservableSource<? extends T>[] sources;
    final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;

    static final class CombinerObserver<T, R> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        final int index;
        final LatestCoordinator<T, R> parent;

        CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i) {
            this.parent = latestCoordinator;
            this.index = i;
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onNext(T t) {
            this.parent.innerNext(this.index, t);
        }

        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }
    }

    static final class LatestCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        final Observer<? super R> actual;
        volatile boolean cancelled;
        final Function<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final AtomicThrowable errors = new AtomicThrowable();
        Object[] latest;
        final CombinerObserver<T, R>[] observers;
        final SpscLinkedArrayQueue<Object[]> queue;

        LatestCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.actual = observer;
            this.combiner = function;
            this.delayError = z;
            this.latest = new Object[i];
            observer = new CombinerObserver[i];
            for (function = null; function < i; function++) {
                observer[function] = new CombinerObserver(this, function);
            }
            this.observers = observer;
            this.queue = new SpscLinkedArrayQueue(i2);
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr) {
            CombinerObserver[] combinerObserverArr = this.observers;
            int length = combinerObserverArr.length;
            this.actual.onSubscribe(this);
            for (int i = 0; i < length && !this.done; i++) {
                if (this.cancelled) {
                    break;
                }
                observableSourceArr[i].subscribe(combinerObserverArr[i]);
            }
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelSources();
                if (getAndIncrement() == 0) {
                    clear(this.queue);
                }
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        void cancelSources() {
            for (CombinerObserver dispose : this.observers) {
                dispose.dispose();
            }
        }

        void clear(SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            synchronized (this) {
                this.latest = null;
            }
            spscLinkedArrayQueue.clear();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
                Observer observer = this.actual;
                boolean z = this.delayError;
                int i = 1;
                while (!this.cancelled) {
                    if (z || this.errors.get() == null) {
                        boolean z2 = this.done;
                        Object[] objArr = (Object[]) spscLinkedArrayQueue.poll();
                        Object obj = objArr == null ? 1 : null;
                        if (z2 && obj != null) {
                            clear(spscLinkedArrayQueue);
                            Throwable terminate = this.errors.terminate();
                            if (terminate == null) {
                                observer.onComplete();
                            } else {
                                observer.onError(terminate);
                            }
                            return;
                        } else if (obj != null) {
                            i = addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        } else {
                            try {
                                observer.onNext(ObjectHelper.requireNonNull(this.combiner.apply(objArr), "The combiner returned a null value"));
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.errors.addThrowable(th);
                                cancelSources();
                                clear(spscLinkedArrayQueue);
                                observer.onError(this.errors.terminate());
                                return;
                            }
                        }
                    }
                    cancelSources();
                    clear(spscLinkedArrayQueue);
                    observer.onError(this.errors.terminate());
                    return;
                }
                clear(spscLinkedArrayQueue);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void innerNext(int r4, T r5) {
            /*
            r3 = this;
            monitor-enter(r3);
            r0 = r3.latest;	 Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0007;
        L_0x0005:
            monitor-exit(r3);	 Catch:{ all -> 0x0029 }
            return;
        L_0x0007:
            r1 = r0[r4];	 Catch:{ all -> 0x0029 }
            r2 = r3.active;	 Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0011;
        L_0x000d:
            r2 = r2 + 1;
            r3.active = r2;	 Catch:{ all -> 0x0029 }
        L_0x0011:
            r0[r4] = r5;	 Catch:{ all -> 0x0029 }
            r4 = r0.length;	 Catch:{ all -> 0x0029 }
            if (r2 != r4) goto L_0x0021;
        L_0x0016:
            r4 = r3.queue;	 Catch:{ all -> 0x0029 }
            r5 = r0.clone();	 Catch:{ all -> 0x0029 }
            r4.offer(r5);	 Catch:{ all -> 0x0029 }
            r4 = 1;
            goto L_0x0022;
        L_0x0021:
            r4 = 0;
        L_0x0022:
            monitor-exit(r3);	 Catch:{ all -> 0x0029 }
            if (r4 == 0) goto L_0x0028;
        L_0x0025:
            r3.drain();
        L_0x0028:
            return;
        L_0x0029:
            r4 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0029 }
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.innerNext(int, java.lang.Object):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void innerError(int r3, java.lang.Throwable r4) {
            /*
            r2 = this;
            r0 = r2.errors;
            r0 = r0.addThrowable(r4);
            if (r0 == 0) goto L_0x0036;
        L_0x0008:
            r4 = r2.delayError;
            r0 = 1;
            if (r4 == 0) goto L_0x002c;
        L_0x000d:
            monitor-enter(r2);
            r4 = r2.latest;	 Catch:{ all -> 0x0029 }
            if (r4 != 0) goto L_0x0014;
        L_0x0012:
            monitor-exit(r2);	 Catch:{ all -> 0x0029 }
            return;
        L_0x0014:
            r3 = r4[r3];	 Catch:{ all -> 0x0029 }
            if (r3 != 0) goto L_0x001a;
        L_0x0018:
            r3 = r0;
            goto L_0x001b;
        L_0x001a:
            r3 = 0;
        L_0x001b:
            if (r3 != 0) goto L_0x0025;
        L_0x001d:
            r1 = r2.complete;	 Catch:{ all -> 0x0029 }
            r1 = r1 + r0;
            r2.complete = r1;	 Catch:{ all -> 0x0029 }
            r4 = r4.length;	 Catch:{ all -> 0x0029 }
            if (r1 != r4) goto L_0x0027;
        L_0x0025:
            r2.done = r0;	 Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r2);	 Catch:{ all -> 0x0029 }
            goto L_0x002d;
        L_0x0029:
            r3 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0029 }
            throw r3;
        L_0x002c:
            r3 = r0;
        L_0x002d:
            if (r3 == 0) goto L_0x0032;
        L_0x002f:
            r2.cancelSources();
        L_0x0032:
            r2.drain();
            goto L_0x0039;
        L_0x0036:
            io.reactivex.plugins.RxJavaPlugins.onError(r4);
        L_0x0039:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.innerError(int, java.lang.Throwable):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void innerComplete(int r4) {
            /*
            r3 = this;
            monitor-enter(r3);
            r0 = r3.latest;	 Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0007;
        L_0x0005:
            monitor-exit(r3);	 Catch:{ all -> 0x0025 }
            return;
        L_0x0007:
            r4 = r0[r4];	 Catch:{ all -> 0x0025 }
            r1 = 1;
            if (r4 != 0) goto L_0x000e;
        L_0x000c:
            r4 = r1;
            goto L_0x000f;
        L_0x000e:
            r4 = 0;
        L_0x000f:
            if (r4 != 0) goto L_0x0019;
        L_0x0011:
            r2 = r3.complete;	 Catch:{ all -> 0x0025 }
            r2 = r2 + r1;
            r3.complete = r2;	 Catch:{ all -> 0x0025 }
            r0 = r0.length;	 Catch:{ all -> 0x0025 }
            if (r2 != r0) goto L_0x001b;
        L_0x0019:
            r3.done = r1;	 Catch:{ all -> 0x0025 }
        L_0x001b:
            monitor-exit(r3);	 Catch:{ all -> 0x0025 }
            if (r4 == 0) goto L_0x0021;
        L_0x001e:
            r3.cancelSources();
        L_0x0021:
            r3.drain();
            return;
        L_0x0025:
            r4 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0025 }
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.innerComplete(int):void");
        }
    }

    public ObservableCombineLatest(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.sources = observableSourceArr;
        this.sourcesIterable = iterable;
        this.combiner = function;
        this.bufferSize = i;
        this.delayError = z;
    }

    public void subscribeActual(Observer<? super R> observer) {
        int i;
        ObservableSource[] observableSourceArr = this.sources;
        if (observableSourceArr == null) {
            Object obj = new Observable[8];
            Object obj2 = obj;
            int i2 = 0;
            for (ObservableSource observableSource : this.sourcesIterable) {
                if (i2 == obj2.length) {
                    Object obj3 = new ObservableSource[((i2 >> 2) + i2)];
                    System.arraycopy(obj2, 0, obj3, 0, i2);
                    obj2 = obj3;
                }
                i = i2 + 1;
                obj2[i2] = observableSource;
                i2 = i;
            }
            i = i2;
            observableSourceArr = obj2;
        } else {
            i = observableSourceArr.length;
        }
        if (i == 0) {
            EmptyDisposable.complete((Observer) observer);
            return;
        }
        new LatestCoordinator(observer, this.combiner, i, this.bufferSize, this.delayError).subscribe(observableSourceArr);
    }
}
