package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class QueueDrainHelper {
    static final long COMPLETED_MASK = Long.MIN_VALUE;
    static final long REQUESTED_MASK = Long.MAX_VALUE;

    private QueueDrainHelper() {
        throw new IllegalStateException("No instances!");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T, U> void drainMaxLoop(io.reactivex.internal.fuseable.SimplePlainQueue<T> r10, org.reactivestreams.Subscriber<? super U> r11, boolean r12, io.reactivex.disposables.Disposable r13, io.reactivex.internal.util.QueueDrain<T, U> r14) {
        /*
        r0 = 1;
        r1 = r0;
    L_0x0002:
        r2 = r14.done();
        r8 = r10.poll();
        if (r8 != 0) goto L_0x000e;
    L_0x000c:
        r9 = r0;
        goto L_0x0010;
    L_0x000e:
        r3 = 0;
        r9 = r3;
    L_0x0010:
        r3 = r9;
        r4 = r11;
        r5 = r12;
        r6 = r10;
        r7 = r14;
        r2 = checkTerminated(r2, r3, r4, r5, r6, r7);
        if (r2 == 0) goto L_0x0021;
    L_0x001b:
        if (r13 == 0) goto L_0x0020;
    L_0x001d:
        r13.dispose();
    L_0x0020:
        return;
    L_0x0021:
        if (r9 == 0) goto L_0x002b;
    L_0x0023:
        r1 = -r1;
        r1 = r14.leave(r1);
        if (r1 != 0) goto L_0x0002;
    L_0x002a:
        return;
    L_0x002b:
        r2 = r14.requested();
        r4 = 0;
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r6 == 0) goto L_0x004a;
    L_0x0035:
        r4 = r14.accept(r11, r8);
        if (r4 == 0) goto L_0x0002;
    L_0x003b:
        r4 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r6 == 0) goto L_0x0002;
    L_0x0044:
        r2 = 1;
        r14.produced(r2);
        goto L_0x0002;
    L_0x004a:
        r10.clear();
        if (r13 == 0) goto L_0x0052;
    L_0x004f:
        r13.dispose();
    L_0x0052:
        r10 = new io.reactivex.exceptions.MissingBackpressureException;
        r12 = "Could not emit value due to lack of requests.";
        r10.<init>(r12);
        r11.onError(r10);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(io.reactivex.internal.fuseable.SimplePlainQueue, org.reactivestreams.Subscriber, boolean, io.reactivex.disposables.Disposable, io.reactivex.internal.util.QueueDrain):void");
    }

    public static <T, U> boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, boolean z3, SimpleQueue<?> simpleQueue, QueueDrain<T, U> queueDrain) {
        if (queueDrain.cancelled()) {
            simpleQueue.clear();
            return true;
        }
        if (z) {
            if (!z3) {
                z = queueDrain.error();
                if (z) {
                    simpleQueue.clear();
                    subscriber.onError(z);
                    return true;
                } else if (z2) {
                    subscriber.onComplete();
                    return true;
                }
            } else if (z2) {
                z = queueDrain.error();
                if (z) {
                    subscriber.onError(z);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }
        return false;
    }

    public static <T, U> void drainLoop(SimplePlainQueue<T> simplePlainQueue, Observer<? super U> observer, boolean z, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        int i = 1;
        while (!checkTerminated(observableQueueDrain.done(), simplePlainQueue.isEmpty(), observer, z, simplePlainQueue, disposable, observableQueueDrain)) {
            while (true) {
                boolean done = observableQueueDrain.done();
                Object poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                if (!checkTerminated(done, z2, observer, z, simplePlainQueue, disposable, observableQueueDrain)) {
                    if (z2) {
                        i = observableQueueDrain.leave(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                    observableQueueDrain.accept(observer, poll);
                } else {
                    return;
                }
            }
        }
    }

    public static <T, U> boolean checkTerminated(boolean z, boolean z2, Observer<?> observer, boolean z3, SimpleQueue<?> simpleQueue, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        if (observableQueueDrain.cancelled()) {
            simpleQueue.clear();
            disposable.dispose();
            return true;
        }
        if (z) {
            if (!z3) {
                z = observableQueueDrain.error();
                if (z) {
                    simpleQueue.clear();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    observer.onError(z);
                    return true;
                } else if (z2) {
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    observer.onComplete();
                    return true;
                }
            } else if (z2) {
                if (disposable != null) {
                    disposable.dispose();
                }
                z = observableQueueDrain.error();
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

    public static <T> SimpleQueue<T> createQueue(int i) {
        if (i < 0) {
            return new SpscLinkedArrayQueue(-i);
        }
        return new SpscArrayQueue(i);
    }

    public static void request(Subscription subscription, int i) {
        subscription.request(i < 0 ? Long.MAX_VALUE : (long) i);
    }

    public static <T> boolean postCompleteRequest(long j, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j2 = j;
        long j3;
        do {
            j3 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j3, (j3 & Long.MIN_VALUE) | BackpressureHelper.addCap(j3 & Long.MAX_VALUE, j2)));
        if (j3 != Long.MIN_VALUE) {
            return false;
        }
        postCompleteDrain(j2 | Long.MIN_VALUE, subscriber, queue, atomicLong, booleanSupplier);
        return true;
    }

    static boolean isCancelled(BooleanSupplier booleanSupplier) {
        try {
            return booleanSupplier.getAsBoolean();
        } catch (BooleanSupplier booleanSupplier2) {
            Exceptions.throwIfFatal(booleanSupplier2);
            return true;
        }
    }

    static <T> boolean postCompleteDrain(long j, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j2 = j & Long.MIN_VALUE;
        while (true) {
            if (j2 != j) {
                if (isCancelled(booleanSupplier)) {
                    return true;
                }
                Object poll = queue.poll();
                if (poll == null) {
                    subscriber.onComplete();
                    return true;
                }
                subscriber.onNext(poll);
                j2++;
            } else if (isCancelled(booleanSupplier) != null) {
                return true;
            } else {
                if (queue.isEmpty() != null) {
                    subscriber.onComplete();
                    return true;
                }
                j = atomicLong.get();
                if (j == j2) {
                    j2 = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                    if ((j2 & Long.MAX_VALUE) == 0) {
                        return 0;
                    }
                    j = j2;
                    j2 &= Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T> void postComplete(Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        if (queue.isEmpty()) {
            subscriber.onComplete();
        } else if (!postCompleteDrain(atomicLong.get(), subscriber, queue, atomicLong, booleanSupplier)) {
            long j;
            long j2;
            do {
                j = atomicLong.get();
                if ((j & Long.MIN_VALUE) == 0) {
                    j2 = j | Long.MIN_VALUE;
                } else {
                    return;
                }
            } while (!atomicLong.compareAndSet(j, j2));
            if (j != 0) {
                postCompleteDrain(j2, subscriber, queue, atomicLong, booleanSupplier);
            }
        }
    }
}
