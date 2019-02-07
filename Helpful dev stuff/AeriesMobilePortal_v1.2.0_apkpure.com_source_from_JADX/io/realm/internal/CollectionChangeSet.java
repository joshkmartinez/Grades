package io.realm.internal;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedCollectionChangeSet.Range;

public class CollectionChangeSet implements OrderedCollectionChangeSet, NativeObject {
    public static final int MAX_ARRAY_LENGTH = 2147483639;
    public static final int TYPE_DELETION = 0;
    public static final int TYPE_INSERTION = 1;
    public static final int TYPE_MODIFICATION = 2;
    private static long finalizerPtr = nativeGetFinalizerPtr();
    private final long nativePtr;

    private static native long nativeGetFinalizerPtr();

    private static native int[] nativeGetIndices(long j, int i);

    private static native int[] nativeGetRanges(long j, int i);

    public CollectionChangeSet(long j) {
        this.nativePtr = j;
        NativeContext.dummyContext.addReference(this);
    }

    public int[] getDeletions() {
        return nativeGetIndices(this.nativePtr, 0);
    }

    public int[] getInsertions() {
        return nativeGetIndices(this.nativePtr, 1);
    }

    public int[] getChanges() {
        return nativeGetIndices(this.nativePtr, 2);
    }

    public Range[] getDeletionRanges() {
        return longArrayToRangeArray(nativeGetRanges(this.nativePtr, 0));
    }

    public Range[] getInsertionRanges() {
        return longArrayToRangeArray(nativeGetRanges(this.nativePtr, 1));
    }

    public Range[] getChangeRanges() {
        return longArrayToRangeArray(nativeGetRanges(this.nativePtr, 2));
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public long getNativeFinalizerPtr() {
        return finalizerPtr;
    }

    private Range[] longArrayToRangeArray(int[] iArr) {
        int i = 0;
        if (iArr == null) {
            return new Range[0];
        }
        Range[] rangeArr = new Range[(iArr.length / 2)];
        while (i < rangeArr.length) {
            int i2 = i * 2;
            rangeArr[i] = new Range(iArr[i2], iArr[i2 + 1]);
            i++;
        }
        return rangeArr;
    }
}
