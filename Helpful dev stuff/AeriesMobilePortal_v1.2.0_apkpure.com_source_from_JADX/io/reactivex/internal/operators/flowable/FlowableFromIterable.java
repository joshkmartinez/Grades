package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;

public final class FlowableFromIterable<T> extends Flowable<T> {
    final Iterable<? extends T> source;

    static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        Iterator<? extends T> it;
        boolean once;

        abstract void fastPath();

        public final int requestFusion(int i) {
            return i & 1;
        }

        abstract void slowPath(long j);

        BaseRangeSubscription(Iterator<? extends T> it) {
            this.it = it;
        }

        @Nullable
        public final T poll() {
            if (this.it == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!this.it.hasNext()) {
                return null;
            }
            return ObjectHelper.requireNonNull(this.it.next(), "Iterator.next() returned a null value");
        }

        public final boolean isEmpty() {
            if (this.it != null) {
                if (this.it.hasNext()) {
                    return false;
                }
            }
            return true;
        }

        public final void clear() {
            this.it = null;
        }

        public final void request(long j) {
            if (!SubscriptionHelper.validate(j) || BackpressureHelper.add(this, j) != 0) {
                return;
            }
            if (j == LongCompanionObject.MAX_VALUE) {
                fastPath();
            } else {
                slowPath(j);
            }
        }

        public final void cancel() {
            this.cancelled = true;
        }
    }

    static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final ConditionalSubscriber<? super T> actual;

        IteratorConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, Iterator<? extends T> it) {
            super(it);
            this.actual = conditionalSubscriber;
        }

        void fastPath() {
            Iterator it = this.it;
            ConditionalSubscriber conditionalSubscriber = this.actual;
            while (!this.cancelled) {
                try {
                    Object next = it.next();
                    if (!this.cancelled) {
                        if (next == null) {
                            conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        conditionalSubscriber.tryOnNext(next);
                        if (!this.cancelled) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.cancelled) {
                                        conditionalSubscriber.onComplete();
                                    }
                                    return;
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                conditionalSubscriber.onError(th);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    conditionalSubscriber.onError(th2);
                    return;
                }
            }
        }

        void slowPath(long j) {
            Iterator it = this.it;
            ConditionalSubscriber conditionalSubscriber = this.actual;
            long j2 = j;
            loop0:
            do {
                j = 0;
                while (true) {
                    if (j == j2) {
                        j2 = get();
                        if (j == j2) {
                            j2 = addAndGet(-j);
                        }
                    } else if (!this.cancelled) {
                        try {
                            Object next = it.next();
                            if (!this.cancelled) {
                                if (next == null) {
                                    conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                boolean tryOnNext = conditionalSubscriber.tryOnNext(next);
                                if (!this.cancelled) {
                                    try {
                                        if (!it.hasNext()) {
                                            break loop0;
                                        } else if (tryOnNext) {
                                            j++;
                                        }
                                    } catch (long j3) {
                                        Exceptions.throwIfFatal(j3);
                                        conditionalSubscriber.onError(j3);
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (long j32) {
                            Exceptions.throwIfFatal(j32);
                            conditionalSubscriber.onError(j32);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (this.cancelled == null) {
                    conditionalSubscriber.onComplete();
                }
                return;
            } while (j2 != 0);
        }
    }

    static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final Subscriber<? super T> actual;

        IteratorSubscription(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            super(it);
            this.actual = subscriber;
        }

        void fastPath() {
            Iterator it = this.it;
            Subscriber subscriber = this.actual;
            while (!this.cancelled) {
                try {
                    Object next = it.next();
                    if (!this.cancelled) {
                        if (next == null) {
                            subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        subscriber.onNext(next);
                        if (!this.cancelled) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.cancelled) {
                                        subscriber.onComplete();
                                    }
                                    return;
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                subscriber.onError(th);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    subscriber.onError(th2);
                    return;
                }
            }
        }

        void slowPath(long j) {
            Iterator it = this.it;
            Subscriber subscriber = this.actual;
            long j2 = j;
            loop0:
            do {
                j = 0;
                while (true) {
                    if (j == j2) {
                        j2 = get();
                        if (j == j2) {
                            j2 = addAndGet(-j);
                        }
                    } else if (!this.cancelled) {
                        try {
                            Object next = it.next();
                            if (!this.cancelled) {
                                if (next == null) {
                                    subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                subscriber.onNext(next);
                                if (!this.cancelled) {
                                    try {
                                        if (!it.hasNext()) {
                                            break loop0;
                                        }
                                        j++;
                                    } catch (long j3) {
                                        Exceptions.throwIfFatal(j3);
                                        subscriber.onError(j3);
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (long j32) {
                            Exceptions.throwIfFatal(j32);
                            subscriber.onError(j32);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (this.cancelled == null) {
                    subscriber.onComplete();
                }
                return;
            } while (j2 != 0);
        }
    }

    public FlowableFromIterable(Iterable<? extends T> iterable) {
        this.source = iterable;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            subscribe(subscriber, this.source.iterator());
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    public static <T> void subscribe(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
        try {
            if (it.hasNext()) {
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriber.onSubscribe(new IteratorConditionalSubscription((ConditionalSubscriber) subscriber, it));
                } else {
                    subscriber.onSubscribe(new IteratorSubscription(subscriber, it));
                }
                return;
            }
            EmptySubscription.complete(subscriber);
        } catch (Iterator<? extends T> it2) {
            Exceptions.throwIfFatal(it2);
            EmptySubscription.error(it2, subscriber);
        }
    }
}
