package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;

public final class SerializedObserver<T> implements Observer<T>, Disposable {
    static final int QUEUE_LINK_SIZE = 4;
    final Observer<? super T> actual;
    final boolean delayError;
    volatile boolean done;
    boolean emitting;
    AppendOnlyLinkedArrayList<Object> queue;
    Disposable f214s;

    public SerializedObserver(@NonNull Observer<? super T> observer) {
        this(observer, false);
    }

    public SerializedObserver(@NonNull Observer<? super T> observer, boolean z) {
        this.actual = observer;
        this.delayError = z;
    }

    public void onSubscribe(@NonNull Disposable disposable) {
        if (DisposableHelper.validate(this.f214s, disposable)) {
            this.f214s = disposable;
            this.actual.onSubscribe(this);
        }
    }

    public void dispose() {
        this.f214s.dispose();
    }

    public boolean isDisposed() {
        return this.f214s.isDisposed();
    }

    public void onNext(@NonNull T t) {
        if (!this.done) {
            if (t == null) {
                this.f214s.dispose();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (this.done) {
                } else if (this.emitting) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.queue;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                        this.queue = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                } else {
                    this.emitting = true;
                    this.actual.onNext(t);
                    emitLoop();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(@io.reactivex.annotations.NonNull java.lang.Throwable r3) {
        /*
        r2 = this;
        r0 = r2.done;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        io.reactivex.plugins.RxJavaPlugins.onError(r3);
        return;
    L_0x0008:
        monitor-enter(r2);
        r0 = r2.done;	 Catch:{ all -> 0x0044 }
        r1 = 1;
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0037;
    L_0x000f:
        r0 = r2.emitting;	 Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x0032;
    L_0x0013:
        r2.done = r1;	 Catch:{ all -> 0x0044 }
        r0 = r2.queue;	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0021;
    L_0x0019:
        r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList;	 Catch:{ all -> 0x0044 }
        r1 = 4;
        r0.<init>(r1);	 Catch:{ all -> 0x0044 }
        r2.queue = r0;	 Catch:{ all -> 0x0044 }
    L_0x0021:
        r3 = io.reactivex.internal.util.NotificationLite.error(r3);	 Catch:{ all -> 0x0044 }
        r1 = r2.delayError;	 Catch:{ all -> 0x0044 }
        if (r1 == 0) goto L_0x002d;
    L_0x0029:
        r0.add(r3);	 Catch:{ all -> 0x0044 }
        goto L_0x0030;
    L_0x002d:
        r0.setFirst(r3);	 Catch:{ all -> 0x0044 }
    L_0x0030:
        monitor-exit(r2);	 Catch:{ all -> 0x0044 }
        return;
    L_0x0032:
        r2.done = r1;	 Catch:{ all -> 0x0044 }
        r2.emitting = r1;	 Catch:{ all -> 0x0044 }
        r1 = 0;
    L_0x0037:
        monitor-exit(r2);	 Catch:{ all -> 0x0044 }
        if (r1 == 0) goto L_0x003e;
    L_0x003a:
        io.reactivex.plugins.RxJavaPlugins.onError(r3);
        return;
    L_0x003e:
        r0 = r2.actual;
        r0.onError(r3);
        return;
    L_0x0044:
        r3 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0044 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.observers.SerializedObserver.onError(java.lang.Throwable):void");
    }

    public void onComplete() {
        if (!this.done) {
            synchronized (this) {
                if (this.done) {
                } else if (this.emitting) {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.queue;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                        this.queue = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.add(NotificationLite.complete());
                } else {
                    this.done = true;
                    this.emitting = true;
                    this.actual.onComplete();
                }
            }
        }
    }

    void emitLoop() {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    this.emitting = false;
                    return;
                }
                this.queue = null;
            }
        } while (!appendOnlyLinkedArrayList.accept(this.actual));
    }
}
