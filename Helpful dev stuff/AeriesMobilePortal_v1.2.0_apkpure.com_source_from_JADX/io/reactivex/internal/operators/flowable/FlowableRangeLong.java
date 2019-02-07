package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;

public final class FlowableRangeLong extends Flowable<Long> {
    final long end;
    final long start;

    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final long end;
        long index;

        abstract void fastPath();

        public final int requestFusion(int i) {
            return i & 1;
        }

        abstract void slowPath(long j);

        BaseRangeSubscription(long j, long j2) {
            this.index = j;
            this.end = j2;
        }

        @Nullable
        public final Long poll() {
            long j = this.index;
            if (j == this.end) {
                return null;
            }
            this.index = j + 1;
            return Long.valueOf(j);
        }

        public final boolean isEmpty() {
            return this.index == this.end;
        }

        public final void clear() {
            this.index = this.end;
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

    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super Long> actual;

        RangeConditionalSubscription(ConditionalSubscriber<? super Long> conditionalSubscriber, long j, long j2) {
            super(j, j2);
            this.actual = conditionalSubscriber;
        }

        void fastPath() {
            long j = this.end;
            ConditionalSubscriber conditionalSubscriber = this.actual;
            long j2 = this.index;
            while (j2 != j) {
                if (!this.cancelled) {
                    conditionalSubscriber.tryOnNext(Long.valueOf(j2));
                    j2++;
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                conditionalSubscriber.onComplete();
            }
        }

        void slowPath(long j) {
            long j2 = this.end;
            long j3 = this.index;
            ConditionalSubscriber conditionalSubscriber = this.actual;
            long j4 = j;
            long j5 = j3;
            loop0:
            do {
                j3 = 0;
                while (true) {
                    if (j3 == j4 || j5 == j2) {
                        if (j5 == j2) {
                            break loop0;
                        }
                        j4 = get();
                        if (j3 == j4) {
                            r0.index = j5;
                            j4 = addAndGet(-j3);
                        }
                    } else if (!r0.cancelled) {
                        if (conditionalSubscriber.tryOnNext(Long.valueOf(j5))) {
                            j3++;
                        }
                        j5++;
                    } else {
                        return;
                    }
                }
                if (!r0.cancelled) {
                    conditionalSubscriber.onComplete();
                }
                return;
            } while (j4 != 0);
        }
    }

    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super Long> actual;

        RangeSubscription(Subscriber<? super Long> subscriber, long j, long j2) {
            super(j, j2);
            this.actual = subscriber;
        }

        void fastPath() {
            long j = this.end;
            Subscriber subscriber = this.actual;
            long j2 = this.index;
            while (j2 != j) {
                if (!this.cancelled) {
                    subscriber.onNext(Long.valueOf(j2));
                    j2++;
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                subscriber.onComplete();
            }
        }

        void slowPath(long j) {
            long j2 = this.end;
            long j3 = this.index;
            Subscriber subscriber = this.actual;
            long j4 = j3;
            j3 = j;
            loop0:
            do {
                j = 0;
                while (true) {
                    if (j == j3 || j4 == j2) {
                        if (j4 == j2) {
                            break loop0;
                        }
                        j3 = get();
                        if (j == j3) {
                            this.index = j4;
                            j3 = addAndGet(-j);
                        }
                    } else if (!this.cancelled) {
                        subscriber.onNext(Long.valueOf(j4));
                        j4++;
                        j++;
                    } else {
                        return;
                    }
                }
                if (this.cancelled == null) {
                    subscriber.onComplete();
                }
                return;
            } while (j3 != 0);
        }
    }

    public FlowableRangeLong(long j, long j2) {
        this.start = j;
        this.end = j + j2;
    }

    public void subscribeActual(Subscriber<? super Long> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) subscriber, this.start, this.end));
            return;
        }
        subscriber.onSubscribe(new RangeSubscription(subscriber, this.start, this.end));
    }
}
