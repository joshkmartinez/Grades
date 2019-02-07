package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapSingle<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final boolean delayErrors;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final int maxConcurrency;

    static final class FlatMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 8600231336733376951L;
        final AtomicInteger active = new AtomicInteger(1);
        final Subscriber<? super R> actual;
        volatile boolean cancelled;
        final boolean delayErrors;
        final AtomicThrowable errors = new AtomicThrowable();
        final Function<? super T, ? extends SingleSource<? extends R>> mapper;
        final int maxConcurrency;
        final AtomicReference<SpscLinkedArrayQueue<R>> queue = new AtomicReference();
        final AtomicLong requested = new AtomicLong();
        Subscription f241s;
        final CompositeDisposable set = new CompositeDisposable();

        final class InnerObserver extends AtomicReference<Disposable> implements SingleObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            InnerObserver() {
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(R r) {
                FlatMapSingleSubscriber.this.innerSuccess(this, r);
            }

            public void onError(Throwable th) {
                FlatMapSingleSubscriber.this.innerError(this, th);
            }

            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }
        }

        FlatMapSingleSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z, int i) {
            this.actual = subscriber;
            this.mapper = function;
            this.delayErrors = z;
            this.maxConcurrency = i;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f241s, subscription)) {
                this.f241s = subscription;
                this.actual.onSubscribe(this);
                if (this.maxConcurrency == Integer.MAX_VALUE) {
                    subscription.request(LongCompanionObject.MAX_VALUE);
                } else {
                    subscription.request((long) this.maxConcurrency);
                }
            }
        }

        public void onNext(T t) {
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null SingleSource");
                this.active.getAndIncrement();
                Object innerObserver = new InnerObserver();
                if (!this.cancelled && this.set.add(innerObserver)) {
                    singleSource.subscribe(innerObserver);
                }
            } catch (T t2) {
                Exceptions.throwIfFatal(t2);
                this.f241s.cancel();
                onError(t2);
            }
        }

        public void onError(Throwable th) {
            this.active.decrementAndGet();
            if (this.errors.addThrowable(th)) {
                if (this.delayErrors == null) {
                    this.set.dispose();
                }
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        public void cancel() {
            this.cancelled = true;
            this.f241s.cancel();
            this.set.dispose();
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        void innerSuccess(InnerObserver innerObserver, R r) {
            this.set.delete(innerObserver);
            if (get() == null) {
                innerObserver = true;
                if (compareAndSet(0, 1)) {
                    if (this.active.decrementAndGet() != 0) {
                        innerObserver = null;
                    }
                    if (this.requested.get() != 0) {
                        this.actual.onNext(r);
                        SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.queue.get();
                        if (innerObserver == null || (spscLinkedArrayQueue != null && spscLinkedArrayQueue.isEmpty() == null)) {
                            BackpressureHelper.produced(this.requested, 1);
                            if (this.maxConcurrency != Integer.MAX_VALUE) {
                                this.f241s.request(1);
                            }
                        } else {
                            innerObserver = this.errors.terminate();
                            if (innerObserver != null) {
                                this.actual.onError(innerObserver);
                            } else {
                                this.actual.onComplete();
                            }
                            return;
                        }
                    }
                    innerObserver = getOrCreateQueue();
                    synchronized (innerObserver) {
                        innerObserver.offer(r);
                    }
                    if (decrementAndGet() == null) {
                        return;
                    }
                    drainLoop();
                }
            }
            innerObserver = getOrCreateQueue();
            synchronized (innerObserver) {
                innerObserver.offer(r);
            }
            this.active.decrementAndGet();
            if (getAndIncrement() != null) {
                return;
            }
            drainLoop();
        }

        SpscLinkedArrayQueue<R> getOrCreateQueue() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
            do {
                spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.queue.get();
                if (spscLinkedArrayQueue != null) {
                    return spscLinkedArrayQueue;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue(Flowable.bufferSize());
            } while (!this.queue.compareAndSet(null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        void innerError(InnerObserver innerObserver, Throwable th) {
            this.set.delete(innerObserver);
            if (this.errors.addThrowable(th) != null) {
                if (this.delayErrors == null) {
                    this.f241s.cancel();
                    this.set.dispose();
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.f241s.request(1);
                }
                this.active.decrementAndGet();
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void clear() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.queue.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void drainLoop() {
            /*
            r15 = this;
            r0 = r15.actual;
            r1 = r15.active;
            r2 = r15.queue;
            r3 = 1;
            r4 = r3;
        L_0x0008:
            r5 = r15.requested;
            r5 = r5.get();
            r7 = 0;
            r9 = r7;
        L_0x0011:
            r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
            r12 = 0;
            if (r11 == 0) goto L_0x0075;
        L_0x0016:
            r11 = r15.cancelled;
            if (r11 == 0) goto L_0x001e;
        L_0x001a:
            r15.clear();
            return;
        L_0x001e:
            r11 = r15.delayErrors;
            if (r11 != 0) goto L_0x0039;
        L_0x0022:
            r11 = r15.errors;
            r11 = r11.get();
            r11 = (java.lang.Throwable) r11;
            if (r11 == 0) goto L_0x0039;
        L_0x002c:
            r1 = r15.errors;
            r1 = r1.terminate();
            r15.clear();
            r0.onError(r1);
            return;
        L_0x0039:
            r11 = r1.get();
            if (r11 != 0) goto L_0x0041;
        L_0x003f:
            r11 = r3;
            goto L_0x0042;
        L_0x0041:
            r11 = r12;
        L_0x0042:
            r13 = r2.get();
            r13 = (io.reactivex.internal.queue.SpscLinkedArrayQueue) r13;
            if (r13 == 0) goto L_0x004f;
        L_0x004a:
            r13 = r13.poll();
            goto L_0x0050;
        L_0x004f:
            r13 = 0;
        L_0x0050:
            if (r13 != 0) goto L_0x0054;
        L_0x0052:
            r14 = r3;
            goto L_0x0055;
        L_0x0054:
            r14 = r12;
        L_0x0055:
            if (r11 == 0) goto L_0x0069;
        L_0x0057:
            if (r14 == 0) goto L_0x0069;
        L_0x0059:
            r1 = r15.errors;
            r1 = r1.terminate();
            if (r1 == 0) goto L_0x0065;
        L_0x0061:
            r0.onError(r1);
            goto L_0x0068;
        L_0x0065:
            r0.onComplete();
        L_0x0068:
            return;
        L_0x0069:
            if (r14 == 0) goto L_0x006c;
        L_0x006b:
            goto L_0x0075;
        L_0x006c:
            r0.onNext(r13);
            r11 = 1;
            r13 = r9 + r11;
            r9 = r13;
            goto L_0x0011;
        L_0x0075:
            r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
            if (r11 != 0) goto L_0x00c8;
        L_0x0079:
            r5 = r15.cancelled;
            if (r5 == 0) goto L_0x0081;
        L_0x007d:
            r15.clear();
            return;
        L_0x0081:
            r5 = r15.delayErrors;
            if (r5 != 0) goto L_0x009c;
        L_0x0085:
            r5 = r15.errors;
            r5 = r5.get();
            r5 = (java.lang.Throwable) r5;
            if (r5 == 0) goto L_0x009c;
        L_0x008f:
            r1 = r15.errors;
            r1 = r1.terminate();
            r15.clear();
            r0.onError(r1);
            return;
        L_0x009c:
            r5 = r1.get();
            if (r5 != 0) goto L_0x00a4;
        L_0x00a2:
            r5 = r3;
            goto L_0x00a5;
        L_0x00a4:
            r5 = r12;
        L_0x00a5:
            r6 = r2.get();
            r6 = (io.reactivex.internal.queue.SpscLinkedArrayQueue) r6;
            if (r6 == 0) goto L_0x00b3;
        L_0x00ad:
            r6 = r6.isEmpty();
            if (r6 == 0) goto L_0x00b4;
        L_0x00b3:
            r12 = r3;
        L_0x00b4:
            if (r5 == 0) goto L_0x00c8;
        L_0x00b6:
            if (r12 == 0) goto L_0x00c8;
        L_0x00b8:
            r1 = r15.errors;
            r1 = r1.terminate();
            if (r1 == 0) goto L_0x00c4;
        L_0x00c0:
            r0.onError(r1);
            goto L_0x00c7;
        L_0x00c4:
            r0.onComplete();
        L_0x00c7:
            return;
        L_0x00c8:
            r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));
            if (r5 == 0) goto L_0x00dd;
        L_0x00cc:
            r5 = r15.requested;
            io.reactivex.internal.util.BackpressureHelper.produced(r5, r9);
            r5 = r15.maxConcurrency;
            r6 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
            if (r5 == r6) goto L_0x00dd;
        L_0x00d8:
            r5 = r15.f241s;
            r5.request(r9);
        L_0x00dd:
            r4 = -r4;
            r4 = r15.addAndGet(r4);
            if (r4 != 0) goto L_0x0008;
        L_0x00e4:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMapSingle.FlatMapSingleSubscriber.drainLoop():void");
        }
    }

    public FlowableFlatMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z, int i) {
        super(flowable);
        this.mapper = function;
        this.delayErrors = z;
        this.maxConcurrency = i;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe(new FlatMapSingleSubscriber(subscriber, this.mapper, this.delayErrors, this.maxConcurrency));
    }
}
