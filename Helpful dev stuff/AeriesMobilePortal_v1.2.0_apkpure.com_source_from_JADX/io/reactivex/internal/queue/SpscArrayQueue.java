package io.reactivex.internal.queue;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements SimplePlainQueue<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex = new AtomicLong();
    final int lookAheadStep;
    final int mask = (length() - 1);
    final AtomicLong producerIndex = new AtomicLong();
    long producerLookAhead;

    int calcElementOffset(long j, int i) {
        return ((int) j) & i;
    }

    public SpscArrayQueue(int i) {
        super(Pow2.roundToPowerOfTwo(i));
        this.lookAheadStep = Math.min(i / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    public boolean offer(E e) {
        if (e != null) {
            int i = this.mask;
            long j = this.producerIndex.get();
            int calcElementOffset = calcElementOffset(j, i);
            if (j >= this.producerLookAhead) {
                long j2 = j + ((long) this.lookAheadStep);
                if (lvElement(calcElementOffset(j2, i)) == null) {
                    this.producerLookAhead = j2;
                } else if (lvElement(calcElementOffset) != null) {
                    return null;
                }
            }
            soElement(calcElementOffset, e);
            soProducerIndex(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public boolean offer(E e, E e2) {
        return (offer(e) == null || offer(e2) == null) ? null : true;
    }

    @Nullable
    public E poll() {
        long j = this.consumerIndex.get();
        int calcElementOffset = calcElementOffset(j);
        E lvElement = lvElement(calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soConsumerIndex(j + 1);
        soElement(calcElementOffset, null);
        return lvElement;
    }

    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    public void clear() {
        while (true) {
            if (poll() == null) {
                if (isEmpty()) {
                    return;
                }
            }
        }
    }

    int calcElementOffset(long j) {
        return ((int) j) & this.mask;
    }

    void soElement(int i, E e) {
        lazySet(i, e);
    }

    E lvElement(int i) {
        return get(i);
    }
}
