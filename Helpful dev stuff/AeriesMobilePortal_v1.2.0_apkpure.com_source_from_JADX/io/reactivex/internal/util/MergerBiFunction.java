package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.Comparator;
import java.util.List;

public final class MergerBiFunction<T> implements BiFunction<List<T>, List<T>, List<T>> {
    final Comparator<? super T> comparator;

    public MergerBiFunction(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public java.util.List<T> apply(java.util.List<T> r6, java.util.List<T> r7) throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r0 = r6.size();
        r1 = r7.size();
        r0 = r0 + r1;
        if (r0 != 0) goto L_0x0011;
    L_0x000b:
        r6 = new java.util.ArrayList;
        r6.<init>();
        return r6;
    L_0x0011:
        r1 = new java.util.ArrayList;
        r1.<init>(r0);
        r6 = r6.iterator();
        r7 = r7.iterator();
        r0 = r6.hasNext();
        r2 = 0;
        if (r0 == 0) goto L_0x002a;
    L_0x0025:
        r0 = r6.next();
        goto L_0x002b;
    L_0x002a:
        r0 = r2;
    L_0x002b:
        r3 = r7.hasNext();
        if (r3 == 0) goto L_0x0036;
    L_0x0031:
        r3 = r7.next();
        goto L_0x0037;
    L_0x0036:
        r3 = r2;
    L_0x0037:
        if (r0 == 0) goto L_0x0061;
    L_0x0039:
        if (r3 == 0) goto L_0x0061;
    L_0x003b:
        r4 = r5.comparator;
        r4 = r4.compare(r0, r3);
        if (r4 >= 0) goto L_0x0053;
    L_0x0043:
        r1.add(r0);
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x0051;
    L_0x004c:
        r0 = r6.next();
        goto L_0x0037;
    L_0x0051:
        r0 = r2;
        goto L_0x0037;
    L_0x0053:
        r1.add(r3);
        r3 = r7.hasNext();
        if (r3 == 0) goto L_0x0036;
    L_0x005c:
        r3 = r7.next();
        goto L_0x0037;
    L_0x0061:
        if (r0 == 0) goto L_0x0074;
    L_0x0063:
        r1.add(r0);
    L_0x0066:
        r7 = r6.hasNext();
        if (r7 == 0) goto L_0x0087;
    L_0x006c:
        r7 = r6.next();
        r1.add(r7);
        goto L_0x0066;
    L_0x0074:
        if (r3 == 0) goto L_0x0087;
    L_0x0076:
        r1.add(r3);
    L_0x0079:
        r6 = r7.hasNext();
        if (r6 == 0) goto L_0x0087;
    L_0x007f:
        r6 = r7.next();
        r1.add(r6);
        goto L_0x0079;
    L_0x0087:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.MergerBiFunction.apply(java.util.List, java.util.List):java.util.List<T>");
    }
}
