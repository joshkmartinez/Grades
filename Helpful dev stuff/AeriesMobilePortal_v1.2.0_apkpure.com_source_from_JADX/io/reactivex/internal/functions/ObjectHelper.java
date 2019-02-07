package io.reactivex.internal.functions;

import io.reactivex.functions.BiPredicate;

public final class ObjectHelper {
    static final BiPredicate<Object, Object> EQUALS = new BiObjectPredicate();

    static final class BiObjectPredicate implements BiPredicate<Object, Object> {
        BiObjectPredicate() {
        }

        public boolean test(Object obj, Object obj2) {
            return ObjectHelper.equals(obj, obj2);
        }
    }

    public static int compare(int i, int i2) {
        return i < i2 ? -1 : i > i2 ? 1 : 0;
    }

    public static int compare(long j, long j2) {
        return j < j2 ? -1 : j > j2 ? 1 : 0;
    }

    private ObjectHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> T requireNonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    public static int hashCode(Object obj) {
        return obj != null ? obj.hashCode() : null;
    }

    public static <T> BiPredicate<T, T> equalsPredicate() {
        return EQUALS;
    }

    public static int verifyPositive(int i, String str) {
        if (i > 0) {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" > 0 required but it was ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static long verifyPositive(long j, String str) {
        if (j > 0) {
            return j;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" > 0 required but it was ");
        stringBuilder.append(j);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
