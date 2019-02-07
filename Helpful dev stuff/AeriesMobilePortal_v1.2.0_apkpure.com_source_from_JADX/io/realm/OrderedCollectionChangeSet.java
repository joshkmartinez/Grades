package io.realm;

public interface OrderedCollectionChangeSet {

    public static class Range {
        public final int length;
        public final int startIndex;

        public Range(int i, int i2) {
            this.startIndex = i;
            this.length = i2;
        }
    }

    Range[] getChangeRanges();

    int[] getChanges();

    Range[] getDeletionRanges();

    int[] getDeletions();

    Range[] getInsertionRanges();

    int[] getInsertions();
}
