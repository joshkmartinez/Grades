package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;

public final class FlowableFromArray<T> extends Flowable<T> {
    final T[] array;

    static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        final T[] array;
        volatile boolean cancelled;
        int index;

        abstract void fastPath();

        public final int requestFusion(int i) {
            return i & 1;
        }

        abstract void slowPath(long j);

        BaseArraySubscription(T[] tArr) {
            this.array = tArr;
        }

        @Nullable
        public final T poll() {
            int i = this.index;
            Object[] objArr = this.array;
            if (i == objArr.length) {
                return null;
            }
            this.index = i + 1;
            return ObjectHelper.requireNonNull(objArr[i], "array element is null");
        }

        public final boolean isEmpty() {
            return this.index == this.array.length;
        }

        public final void clear() {
            this.index = this.array.length;
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

    static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super T> actual;

        ArrayConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, T[] tArr) {
            super(tArr);
            this.actual = conditionalSubscriber;
        }

        void fastPath() {
            Object[] objArr = this.array;
            int length = objArr.length;
            ConditionalSubscriber conditionalSubscriber = this.actual;
            int i = this.index;
            while (i != length) {
                if (!this.cancelled) {
                    Object obj = objArr[i];
                    if (obj == null) {
                        conditionalSubscriber.onError(new NullPointerException("array element is null"));
                        return;
                    } else {
                        conditionalSubscriber.tryOnNext(obj);
                        i++;
                    }
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                conditionalSubscriber.onComplete();
            }
        }

        void slowPath(long j) {
            Object[] objArr = this.array;
            int length = objArr.length;
            int i = this.index;
            ConditionalSubscriber conditionalSubscriber = this.actual;
            long j2 = j;
            loop0:
            do {
                j = 0;
                while (true) {
                    if (j == j2 || i == length) {
                        if (i == length) {
                            break loop0;
                        }
                        j2 = get();
                        if (j == j2) {
                            this.index = i;
                            j2 = addAndGet(-j);
                        }
                    } else if (!this.cancelled) {
                        Object obj = objArr[i];
                        if (obj == null) {
                            conditionalSubscriber.onError(new NullPointerException("array element is null"));
                            return;
                        }
                        if (conditionalSubscriber.tryOnNext(obj)) {
                            j++;
                        }
                        i++;
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

    static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super T> actual;

        ArraySubscription(Subscriber<? super T> subscriber, T[] tArr) {
            super(tArr);
            this.actual = subscriber;
        }

        void fastPath() {
            Object[] objArr = this.array;
            int length = objArr.length;
            Subscriber subscriber = this.actual;
            int i = this.index;
            while (i != length) {
                if (!this.cancelled) {
                    Object obj = objArr[i];
                    if (obj == null) {
                        subscriber.onError(new NullPointerException("array element is null"));
                        return;
                    } else {
                        subscriber.onNext(obj);
                        i++;
                    }
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                subscriber.onComplete();
            }
        }

        void slowPath(long j) {
            Object[] objArr = this.array;
            int length = objArr.length;
            int i = this.index;
            Subscriber subscriber = this.actual;
            long j2 = j;
            loop0:
            do {
                j = 0;
                while (true) {
                    if (j == j2 || i == length) {
                        if (i == length) {
                            break loop0;
                        }
                        j2 = get();
                        if (j == j2) {
                            this.index = i;
                            j2 = addAndGet(-j);
                        }
                    } else if (!this.cancelled) {
                        Object obj = objArr[i];
                        if (obj == null) {
                            subscriber.onError(new NullPointerException("array element is null"));
                            return;
                        }
                        subscriber.onNext(obj);
                        i++;
                        j++;
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

    public FlowableFromArray(T[] tArr) {
        this.array = tArr;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new ArrayConditionalSubscription((ConditionalSubscriber) subscriber, this.array));
        } else {
            subscriber.onSubscribe(new ArraySubscription(subscriber, this.array));
        }
    }
}
