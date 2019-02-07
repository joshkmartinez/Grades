package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

public final class HalfSerializer {
    private HalfSerializer() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> void onNext(Subscriber<? super T> subscriber, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            subscriber.onNext(t);
            if (atomicInteger.decrementAndGet() != null) {
                t = atomicThrowable.terminate();
                if (t != null) {
                    subscriber.onError(t);
                } else {
                    subscriber.onComplete();
                }
            }
        }
    }

    public static void onError(Subscriber<?> subscriber, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.addThrowable(th)) {
            RxJavaPlugins.onError(th);
        } else if (atomicInteger.getAndIncrement() == null) {
            subscriber.onError(atomicThrowable.terminate());
        }
    }

    public static void onComplete(Subscriber<?> subscriber, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == null) {
            atomicInteger = atomicThrowable.terminate();
            if (atomicInteger != null) {
                subscriber.onError(atomicInteger);
            } else {
                subscriber.onComplete();
            }
        }
    }

    public static <T> void onNext(Observer<? super T> observer, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            observer.onNext(t);
            if (atomicInteger.decrementAndGet() != null) {
                t = atomicThrowable.terminate();
                if (t != null) {
                    observer.onError(t);
                } else {
                    observer.onComplete();
                }
            }
        }
    }

    public static void onError(Observer<?> observer, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.addThrowable(th)) {
            RxJavaPlugins.onError(th);
        } else if (atomicInteger.getAndIncrement() == null) {
            observer.onError(atomicThrowable.terminate());
        }
    }

    public static void onComplete(Observer<?> observer, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == null) {
            atomicInteger = atomicThrowable.terminate();
            if (atomicInteger != null) {
                observer.onError(atomicInteger);
            } else {
                observer.onComplete();
            }
        }
    }
}
