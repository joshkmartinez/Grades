package io.reactivex.observers;

import io.reactivex.Notification;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.VolatileSizeArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {
    protected boolean checkSubscriptionOnce;
    protected long completions;
    protected final CountDownLatch done = new CountDownLatch(1);
    protected final List<Throwable> errors = new VolatileSizeArrayList();
    protected int establishedFusionMode;
    protected int initialFusionMode;
    protected Thread lastThread;
    protected CharSequence tag;
    protected boolean timeout;
    protected final List<T> values = new VolatileSizeArrayList();

    public enum TestWaitStrategy implements Runnable {
        SPIN {
            public void run() {
            }
        },
        YIELD {
            public void run() {
                Thread.yield();
            }
        },
        SLEEP_1MS {
            public void run() {
                TestWaitStrategy.sleep(1);
            }
        },
        SLEEP_10MS {
            public void run() {
                TestWaitStrategy.sleep(10);
            }
        },
        SLEEP_100MS {
            public void run() {
                TestWaitStrategy.sleep(100);
            }
        },
        SLEEP_1000MS {
            public void run() {
                TestWaitStrategy.sleep(1000);
            }
        };

        public abstract void run();

        static void sleep(int i) {
            try {
                Thread.sleep((long) i);
            } catch (int i2) {
                throw new RuntimeException(i2);
            }
        }
    }

    public abstract U assertNotSubscribed();

    public abstract U assertSubscribed();

    public final Thread lastThread() {
        return this.lastThread;
    }

    public final List<T> values() {
        return this.values;
    }

    public final List<Throwable> errors() {
        return this.errors;
    }

    public final long completions() {
        return this.completions;
    }

    public final boolean isTerminated() {
        return this.done.getCount() == 0;
    }

    public final int valueCount() {
        return this.values.size();
    }

    public final int errorCount() {
        return this.errors.size();
    }

    protected final AssertionError fail(String str) {
        StringBuilder stringBuilder = new StringBuilder(64 + str.length());
        stringBuilder.append(str);
        stringBuilder.append(" (");
        stringBuilder.append("latch = ");
        stringBuilder.append(this.done.getCount());
        stringBuilder.append(", ");
        stringBuilder.append("values = ");
        stringBuilder.append(this.values.size());
        stringBuilder.append(", ");
        stringBuilder.append("errors = ");
        stringBuilder.append(this.errors.size());
        stringBuilder.append(", ");
        stringBuilder.append("completions = ");
        stringBuilder.append(this.completions);
        if (this.timeout != null) {
            stringBuilder.append(", timeout!");
        }
        if (isDisposed() != null) {
            stringBuilder.append(", disposed!");
        }
        str = this.tag;
        if (str != null) {
            stringBuilder.append(", tag = ");
            stringBuilder.append(str);
        }
        stringBuilder.append(')');
        str = new AssertionError(stringBuilder.toString());
        if (!this.errors.isEmpty()) {
            if (this.errors.size() == 1) {
                str.initCause((Throwable) this.errors.get(0));
            } else {
                str.initCause(new CompositeException(this.errors));
            }
        }
        return str;
    }

    public final U await() throws InterruptedException {
        if (this.done.getCount() == 0) {
            return this;
        }
        this.done.await();
        return this;
    }

    public final boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
        if (this.done.getCount() != 0) {
            if (this.done.await(j, timeUnit) == null) {
                j = null;
                this.timeout = j ^ 1;
                return j;
            }
        }
        j = 1;
        this.timeout = j ^ 1;
        return j;
    }

    public final U assertComplete() {
        long j = this.completions;
        if (j == 0) {
            throw fail("Not completed");
        } else if (j <= 1) {
            return this;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Multiple completions: ");
            stringBuilder.append(j);
            throw fail(stringBuilder.toString());
        }
    }

    public final U assertNotComplete() {
        long j = this.completions;
        if (j == 1) {
            throw fail("Completed!");
        } else if (j <= 1) {
            return this;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Multiple completions: ");
            stringBuilder.append(j);
            throw fail(stringBuilder.toString());
        }
    }

    public final U assertNoErrors() {
        if (this.errors.size() == 0) {
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error(s) present: ");
        stringBuilder.append(this.errors);
        throw fail(stringBuilder.toString());
    }

    public final U assertError(Throwable th) {
        return assertError(Functions.equalsWith(th));
    }

    public final U assertError(Class<? extends Throwable> cls) {
        return assertError(Functions.isInstanceOf(cls));
    }

    public final U assertError(Predicate<Throwable> predicate) {
        int size = this.errors.size();
        if (size != 0) {
            Object obj = null;
            for (Throwable test : this.errors) {
                try {
                    if (predicate.test(test)) {
                        obj = 1;
                        break;
                    }
                } catch (Predicate<Throwable> predicate2) {
                    throw ExceptionHelper.wrapOrThrow(predicate2);
                }
            }
            if (obj == null) {
                throw fail("Error not present");
            } else if (size == 1) {
                return this;
            } else {
                throw fail("Error present but other errors as well");
            }
        }
        throw fail("No errors");
    }

    public final U assertValue(T t) {
        if (this.values.size() == 1) {
            Object obj = this.values.get(0);
            if (ObjectHelper.equals(t, obj)) {
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected: ");
            stringBuilder.append(valueAndClass(t));
            stringBuilder.append(", Actual: ");
            stringBuilder.append(valueAndClass(obj));
            throw fail(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Expected: ");
        stringBuilder2.append(valueAndClass(t));
        stringBuilder2.append(", Actual: ");
        stringBuilder2.append(this.values);
        throw fail(stringBuilder2.toString());
    }

    public final U assertNever(T t) {
        int size = this.values.size();
        for (int i = 0; i < size; i++) {
            if (ObjectHelper.equals(this.values.get(i), t)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Value at position ");
                stringBuilder.append(i);
                stringBuilder.append(" is equal to ");
                stringBuilder.append(valueAndClass(t));
                stringBuilder.append("; Expected them to be different");
                throw fail(stringBuilder.toString());
            }
        }
        return this;
    }

    public final U assertValue(Predicate<T> predicate) {
        assertValueAt(0, (Predicate) predicate);
        if (this.values.size() <= 1) {
            return this;
        }
        throw fail("Value present but other values as well");
    }

    public final U assertNever(Predicate<? super T> predicate) {
        int size = this.values.size();
        int i = 0;
        while (i < size) {
            try {
                if (predicate.test(this.values.get(i))) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Value at position ");
                    stringBuilder.append(i);
                    stringBuilder.append(" matches predicate ");
                    stringBuilder.append(predicate.toString());
                    stringBuilder.append(", which was not expected.");
                    throw fail(stringBuilder.toString());
                }
                i++;
            } catch (Predicate<? super T> predicate2) {
                throw ExceptionHelper.wrapOrThrow(predicate2);
            }
        }
        return this;
    }

    @Experimental
    public final U assertValueAt(int i, T t) {
        int size = this.values.size();
        if (size == 0) {
            throw fail("No values");
        } else if (i < size) {
            i = this.values.get(i);
            if (ObjectHelper.equals(t, i)) {
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected: ");
            stringBuilder.append(valueAndClass(t));
            stringBuilder.append(", Actual: ");
            stringBuilder.append(valueAndClass(i));
            throw fail(stringBuilder.toString());
        } else {
            t = new StringBuilder();
            t.append("Invalid index: ");
            t.append(i);
            throw fail(t.toString());
        }
    }

    public final U assertValueAt(int i, Predicate<T> predicate) {
        if (this.values.size() == 0) {
            throw fail("No values");
        } else if (i < this.values.size()) {
            try {
                if (predicate.test(this.values.get(i)) != 0) {
                    return this;
                }
                throw fail("Value not present");
            } catch (int i2) {
                throw ExceptionHelper.wrapOrThrow(i2);
            }
        } else {
            predicate = new StringBuilder();
            predicate.append("Invalid index: ");
            predicate.append(i2);
            throw fail(predicate.toString());
        }
    }

    public static String valueAndClass(Object obj) {
        if (obj == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(obj);
        stringBuilder.append(" (class: ");
        stringBuilder.append(obj.getClass().getSimpleName());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final U assertValueCount(int i) {
        int size = this.values.size();
        if (size == i) {
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Value counts differ; Expected: ");
        stringBuilder.append(i);
        stringBuilder.append(", Actual: ");
        stringBuilder.append(size);
        throw fail(stringBuilder.toString());
    }

    public final U assertNoValues() {
        return assertValueCount(0);
    }

    public final U assertValues(T... tArr) {
        int size = this.values.size();
        if (size == tArr.length) {
            int i = 0;
            while (i < size) {
                Object obj = this.values.get(i);
                Object obj2 = tArr[i];
                if (ObjectHelper.equals(obj2, obj)) {
                    i++;
                } else {
                    tArr = new StringBuilder();
                    tArr.append("Values at position ");
                    tArr.append(i);
                    tArr.append(" differ; Expected: ");
                    tArr.append(valueAndClass(obj2));
                    tArr.append(", Actual: ");
                    tArr.append(valueAndClass(obj));
                    throw fail(tArr.toString());
                }
            }
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Value count differs; Expected: ");
        stringBuilder.append(tArr.length);
        stringBuilder.append(" ");
        stringBuilder.append(Arrays.toString(tArr));
        stringBuilder.append(", Actual: ");
        stringBuilder.append(size);
        stringBuilder.append(" ");
        stringBuilder.append(this.values);
        throw fail(stringBuilder.toString());
    }

    @Experimental
    public final U assertValuesOnly(T... tArr) {
        return assertSubscribed().assertValues(tArr).assertNoErrors().assertNotComplete();
    }

    public final U assertValueSet(Collection<? extends T> collection) {
        if (collection.isEmpty()) {
            assertNoValues();
            return this;
        }
        for (Object next : this.values) {
            if (!collection.contains(next)) {
                collection = new StringBuilder();
                collection.append("Value not in the expected collection: ");
                collection.append(valueAndClass(next));
                throw fail(collection.toString());
            }
        }
        return this;
    }

    public final U assertValueSequence(Iterable<? extends T> iterable) {
        Iterator it = this.values.iterator();
        iterable = iterable.iterator();
        int i = 0;
        while (true) {
            boolean hasNext = iterable.hasNext();
            boolean hasNext2 = it.hasNext();
            if (!hasNext2) {
                break;
            } else if (!hasNext) {
                break;
            } else {
                Object next = iterable.next();
                Object next2 = it.next();
                if (ObjectHelper.equals(next, next2)) {
                    i++;
                } else {
                    iterable = new StringBuilder();
                    iterable.append("Values at position ");
                    iterable.append(i);
                    iterable.append(" differ; Expected: ");
                    iterable.append(valueAndClass(next));
                    iterable.append(", Actual: ");
                    iterable.append(valueAndClass(next2));
                    throw fail(iterable.toString());
                }
            }
        }
        if (hasNext2) {
            iterable = new StringBuilder();
            iterable.append("More values received than expected (");
            iterable.append(i);
            iterable.append(")");
            throw fail(iterable.toString());
        } else if (!hasNext) {
            return this;
        } else {
            iterable = new StringBuilder();
            iterable.append("Fewer values received than expected (");
            iterable.append(i);
            iterable.append(")");
            throw fail(iterable.toString());
        }
    }

    public final U assertTerminated() {
        if (this.done.getCount() == 0) {
            long j = this.completions;
            StringBuilder stringBuilder;
            if (j <= 1) {
                int size = this.errors.size();
                if (size <= 1) {
                    if (j != 0) {
                        if (size != 0) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Terminated with multiple completions and errors: ");
                            stringBuilder.append(j);
                            throw fail(stringBuilder.toString());
                        }
                    }
                    return this;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Terminated with multiple errors: ");
                stringBuilder2.append(size);
                throw fail(stringBuilder2.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Terminated with multiple completions: ");
            stringBuilder.append(j);
            throw fail(stringBuilder.toString());
        }
        throw fail("Subscriber still running!");
    }

    public final U assertNotTerminated() {
        if (this.done.getCount() != 0) {
            return this;
        }
        throw fail("Subscriber terminated!");
    }

    public final boolean awaitTerminalEvent() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = this;
        r1.await();	 Catch:{ InterruptedException -> 0x0005 }
        r0 = 1;
        return r0;
    L_0x0005:
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.observers.BaseTestConsumer.awaitTerminalEvent():boolean");
    }

    public final boolean awaitTerminalEvent(long r1, java.util.concurrent.TimeUnit r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = this;
        r1 = r0.await(r1, r3);	 Catch:{ InterruptedException -> 0x0005 }
        return r1;
    L_0x0005:
        r1 = java.lang.Thread.currentThread();
        r1.interrupt();
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.observers.BaseTestConsumer.awaitTerminalEvent(long, java.util.concurrent.TimeUnit):boolean");
    }

    public final U assertErrorMessage(String str) {
        int size = this.errors.size();
        if (size == 0) {
            throw fail("No errors");
        } else if (size == 1) {
            String message = ((Throwable) this.errors.get(0)).getMessage();
            if (ObjectHelper.equals(str, message)) {
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error message differs; Expected: ");
            stringBuilder.append(str);
            stringBuilder.append(", Actual: ");
            stringBuilder.append(message);
            throw fail(stringBuilder.toString());
        } else {
            throw fail("Multiple errors");
        }
    }

    public final List<List<Object>> getEvents() {
        List<List<Object>> arrayList = new ArrayList();
        arrayList.add(values());
        arrayList.add(errors());
        List arrayList2 = new ArrayList();
        for (long j = 0; j < this.completions; j++) {
            arrayList2.add(Notification.createOnComplete());
        }
        arrayList.add(arrayList2);
        return arrayList;
    }

    public final U assertResult(T... tArr) {
        return assertSubscribed().assertValues(tArr).assertNoErrors().assertComplete();
    }

    public final U assertFailure(Class<? extends Throwable> cls, T... tArr) {
        return assertSubscribed().assertValues(tArr).assertError((Class) cls).assertNotComplete();
    }

    public final U assertFailure(Predicate<Throwable> predicate, T... tArr) {
        return assertSubscribed().assertValues(tArr).assertError((Predicate) predicate).assertNotComplete();
    }

    public final U assertFailureAndMessage(Class<? extends Throwable> cls, String str, T... tArr) {
        return assertSubscribed().assertValues(tArr).assertError((Class) cls).assertErrorMessage(str).assertNotComplete();
    }

    public final U awaitDone(long j, TimeUnit timeUnit) {
        try {
            if (this.done.await(j, timeUnit) == null) {
                this.timeout = 1;
                dispose();
            }
            return this;
        } catch (long j2) {
            dispose();
            throw ExceptionHelper.wrapOrThrow(j2);
        }
    }

    public final U assertEmpty() {
        return assertSubscribed().assertNoValues().assertNoErrors().assertNotComplete();
    }

    public final U withTag(CharSequence charSequence) {
        this.tag = charSequence;
        return this;
    }

    public final U awaitCount(int i) {
        return awaitCount(i, TestWaitStrategy.SLEEP_10MS, 5000);
    }

    public final U awaitCount(int i, Runnable runnable) {
        return awaitCount(i, runnable, 5000);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final U awaitCount(int r9, java.lang.Runnable r10, long r11) {
        /*
        r8 = this;
        r0 = java.lang.System.currentTimeMillis();
    L_0x0004:
        r2 = 0;
        r4 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x0018;
    L_0x000a:
        r4 = java.lang.System.currentTimeMillis();
        r6 = r4 - r0;
        r4 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1));
        if (r4 < 0) goto L_0x0018;
    L_0x0014:
        r9 = 1;
        r8.timeout = r9;
        goto L_0x002b;
    L_0x0018:
        r4 = r8.done;
        r4 = r4.getCount();
        r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r6 != 0) goto L_0x0023;
    L_0x0022:
        goto L_0x002b;
    L_0x0023:
        r2 = r8.values;
        r2 = r2.size();
        if (r2 < r9) goto L_0x002c;
    L_0x002b:
        return r8;
    L_0x002c:
        r10.run();
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.observers.BaseTestConsumer.awaitCount(int, java.lang.Runnable, long):U");
    }

    public final boolean isTimeout() {
        return this.timeout;
    }

    public final U clearTimeout() {
        this.timeout = false;
        return this;
    }

    public final U assertTimeout() {
        if (this.timeout) {
            return this;
        }
        throw fail("No timeout?!");
    }

    public final U assertNoTimeout() {
        if (!this.timeout) {
            return this;
        }
        throw fail("Timeout?!");
    }
}
