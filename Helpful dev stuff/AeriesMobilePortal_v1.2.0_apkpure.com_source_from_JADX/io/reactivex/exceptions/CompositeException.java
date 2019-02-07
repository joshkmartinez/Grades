package io.reactivex.exceptions;

import io.reactivex.annotations.NonNull;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    static final class CompositeExceptionCausalChain extends RuntimeException {
        static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
        private static final long serialVersionUID = 3875212506787802066L;

        public String getMessage() {
            return MESSAGE;
        }

        CompositeExceptionCausalChain() {
        }
    }

    static abstract class PrintStreamOrWriter {
        abstract void println(Object obj);

        PrintStreamOrWriter() {
        }
    }

    static final class WrappedPrintStream extends PrintStreamOrWriter {
        private final PrintStream printStream;

        WrappedPrintStream(PrintStream printStream) {
            this.printStream = printStream;
        }

        void println(Object obj) {
            this.printStream.println(obj);
        }
    }

    static final class WrappedPrintWriter extends PrintStreamOrWriter {
        private final PrintWriter printWriter;

        WrappedPrintWriter(PrintWriter printWriter) {
            this.printWriter = printWriter;
        }

        void println(Object obj) {
            this.printWriter.println(obj);
        }
    }

    public CompositeException(@NonNull Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    public CompositeException(@NonNull Iterable<? extends Throwable> iterable) {
        Collection linkedHashSet = new LinkedHashSet();
        List arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (linkedHashSet.isEmpty() == null) {
            arrayList.addAll(linkedHashSet);
            this.exceptions = Collections.unmodifiableList(arrayList);
            iterable = new StringBuilder();
            iterable.append(this.exceptions.size());
            iterable.append(" exceptions occurred. ");
            this.message = iterable.toString();
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    @NonNull
    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @NonNull
    public String getMessage() {
        return this.message;
    }

    @io.reactivex.annotations.NonNull
    public synchronized java.lang.Throwable getCause() {
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
        r8 = this;
        monitor-enter(r8);
        r0 = r8.cause;	 Catch:{ all -> 0x0060 }
        if (r0 != 0) goto L_0x005c;	 Catch:{ all -> 0x0060 }
    L_0x0005:
        r0 = new io.reactivex.exceptions.CompositeException$CompositeExceptionCausalChain;	 Catch:{ all -> 0x0060 }
        r0.<init>();	 Catch:{ all -> 0x0060 }
        r1 = new java.util.HashSet;	 Catch:{ all -> 0x0060 }
        r1.<init>();	 Catch:{ all -> 0x0060 }
        r2 = r8.exceptions;	 Catch:{ all -> 0x0060 }
        r2 = r2.iterator();	 Catch:{ all -> 0x0060 }
        r3 = r0;	 Catch:{ all -> 0x0060 }
    L_0x0016:
        r4 = r2.hasNext();	 Catch:{ all -> 0x0060 }
        if (r4 == 0) goto L_0x005a;	 Catch:{ all -> 0x0060 }
    L_0x001c:
        r4 = r2.next();	 Catch:{ all -> 0x0060 }
        r4 = (java.lang.Throwable) r4;	 Catch:{ all -> 0x0060 }
        r5 = r1.contains(r4);	 Catch:{ all -> 0x0060 }
        if (r5 == 0) goto L_0x0029;	 Catch:{ all -> 0x0060 }
    L_0x0028:
        goto L_0x0016;	 Catch:{ all -> 0x0060 }
    L_0x0029:
        r1.add(r4);	 Catch:{ all -> 0x0060 }
        r5 = r8.getListOfCauses(r4);	 Catch:{ all -> 0x0060 }
        r5 = r5.iterator();	 Catch:{ all -> 0x0060 }
    L_0x0034:
        r6 = r5.hasNext();	 Catch:{ all -> 0x0060 }
        if (r6 == 0) goto L_0x0052;	 Catch:{ all -> 0x0060 }
    L_0x003a:
        r6 = r5.next();	 Catch:{ all -> 0x0060 }
        r6 = (java.lang.Throwable) r6;	 Catch:{ all -> 0x0060 }
        r7 = r1.contains(r6);	 Catch:{ all -> 0x0060 }
        if (r7 == 0) goto L_0x004e;	 Catch:{ all -> 0x0060 }
    L_0x0046:
        r4 = new java.lang.RuntimeException;	 Catch:{ all -> 0x0060 }
        r6 = "Duplicate found in causal chain so cropping to prevent loop ...";	 Catch:{ all -> 0x0060 }
        r4.<init>(r6);	 Catch:{ all -> 0x0060 }
        goto L_0x0034;	 Catch:{ all -> 0x0060 }
    L_0x004e:
        r1.add(r6);	 Catch:{ all -> 0x0060 }
        goto L_0x0034;
    L_0x0052:
        r3.initCause(r4);	 Catch:{ Throwable -> 0x0055 }
    L_0x0055:
        r3 = r8.getRootCause(r3);	 Catch:{ all -> 0x0060 }
        goto L_0x0016;	 Catch:{ all -> 0x0060 }
    L_0x005a:
        r8.cause = r0;	 Catch:{ all -> 0x0060 }
    L_0x005c:
        r0 = r8.cause;	 Catch:{ all -> 0x0060 }
        monitor-exit(r8);
        return r0;
    L_0x0060:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.exceptions.CompositeException.getCause():java.lang.Throwable");
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        printStackTrace(new WrappedPrintStream(printStream));
    }

    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace(new WrappedPrintWriter(printWriter));
    }

    private void printStackTrace(PrintStreamOrWriter printStreamOrWriter) {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(this);
        stringBuilder.append('\n');
        for (Object obj : getStackTrace()) {
            stringBuilder.append("\tat ");
            stringBuilder.append(obj);
            stringBuilder.append('\n');
        }
        int i = 1;
        for (Throwable th : this.exceptions) {
            stringBuilder.append("  ComposedException ");
            stringBuilder.append(i);
            stringBuilder.append(" :\n");
            appendStackTrace(stringBuilder, th, "\t");
            i++;
        }
        printStreamOrWriter.println(stringBuilder.toString());
    }

    private void appendStackTrace(StringBuilder stringBuilder, Throwable th, String str) {
        stringBuilder.append(str);
        stringBuilder.append(th);
        stringBuilder.append('\n');
        for (Object obj : th.getStackTrace()) {
            stringBuilder.append("\t\tat ");
            stringBuilder.append(obj);
            stringBuilder.append('\n');
        }
        if (th.getCause() != null) {
            stringBuilder.append("\tCaused by: ");
            appendStackTrace(stringBuilder, th.getCause(), "");
        }
    }

    private List<Throwable> getListOfCauses(Throwable th) {
        List<Throwable> arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause != null) {
            if (cause != th) {
                while (true) {
                    arrayList.add(cause);
                    th = cause.getCause();
                    if (th == null) {
                        break;
                    } else if (th == cause) {
                        break;
                    } else {
                        cause = th;
                    }
                }
                return arrayList;
            }
        }
        return arrayList;
    }

    public int size() {
        return this.exceptions.size();
    }

    private Throwable getRootCause(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            if (this.cause != cause) {
                while (true) {
                    th = cause.getCause();
                    if (th == null) {
                        break;
                    } else if (th == cause) {
                        break;
                    } else {
                        cause = th;
                    }
                }
                return cause;
            }
        }
        return th;
    }
}
