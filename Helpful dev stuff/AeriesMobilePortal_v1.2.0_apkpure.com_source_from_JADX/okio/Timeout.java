package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class Timeout {
    public static final Timeout NONE = new C10891();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    class C10891 extends Timeout {
        public Timeout deadlineNanoTime(long j) {
            return this;
        }

        public void throwIfReached() throws IOException {
        }

        public Timeout timeout(long j, TimeUnit timeUnit) {
            return this;
        }

        C10891() {
        }
    }

    public Timeout timeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("timeout < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (timeUnit != null) {
            this.timeoutNanos = timeUnit.toNanos(j);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public Timeout deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }

    public final Timeout deadline(long j, TimeUnit timeUnit) {
        if (j <= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("duration <= 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (timeUnit != null) {
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j));
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (!this.hasDeadline) {
        } else {
            if (this.deadlineNanoTime - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
        }
    }

    public final void waitUntilNotified(java.lang.Object r12) throws java.io.InterruptedIOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = r11.hasDeadline();	 Catch:{ InterruptedException -> 0x0056 }
        r1 = r11.timeoutNanos();	 Catch:{ InterruptedException -> 0x0056 }
        r3 = 0;	 Catch:{ InterruptedException -> 0x0056 }
        if (r0 != 0) goto L_0x0014;	 Catch:{ InterruptedException -> 0x0056 }
    L_0x000c:
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ InterruptedException -> 0x0056 }
        if (r5 != 0) goto L_0x0014;	 Catch:{ InterruptedException -> 0x0056 }
    L_0x0010:
        r12.wait();	 Catch:{ InterruptedException -> 0x0056 }
        return;	 Catch:{ InterruptedException -> 0x0056 }
    L_0x0014:
        r5 = java.lang.System.nanoTime();	 Catch:{ InterruptedException -> 0x0056 }
        if (r0 == 0) goto L_0x0029;	 Catch:{ InterruptedException -> 0x0056 }
    L_0x001a:
        r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ InterruptedException -> 0x0056 }
        if (r7 == 0) goto L_0x0029;	 Catch:{ InterruptedException -> 0x0056 }
    L_0x001e:
        r7 = r11.deadlineNanoTime();	 Catch:{ InterruptedException -> 0x0056 }
        r9 = r7 - r5;	 Catch:{ InterruptedException -> 0x0056 }
        r1 = java.lang.Math.min(r1, r9);	 Catch:{ InterruptedException -> 0x0056 }
        goto L_0x0032;	 Catch:{ InterruptedException -> 0x0056 }
    L_0x0029:
        if (r0 == 0) goto L_0x0032;	 Catch:{ InterruptedException -> 0x0056 }
    L_0x002b:
        r0 = r11.deadlineNanoTime();	 Catch:{ InterruptedException -> 0x0056 }
        r7 = r0 - r5;	 Catch:{ InterruptedException -> 0x0056 }
        r1 = r7;	 Catch:{ InterruptedException -> 0x0056 }
    L_0x0032:
        r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ InterruptedException -> 0x0056 }
        if (r0 <= 0) goto L_0x0049;	 Catch:{ InterruptedException -> 0x0056 }
    L_0x0036:
        r3 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;	 Catch:{ InterruptedException -> 0x0056 }
        r7 = r1 / r3;	 Catch:{ InterruptedException -> 0x0056 }
        r3 = r3 * r7;	 Catch:{ InterruptedException -> 0x0056 }
        r9 = r1 - r3;	 Catch:{ InterruptedException -> 0x0056 }
        r0 = (int) r9;	 Catch:{ InterruptedException -> 0x0056 }
        r12.wait(r7, r0);	 Catch:{ InterruptedException -> 0x0056 }
        r3 = java.lang.System.nanoTime();	 Catch:{ InterruptedException -> 0x0056 }
        r7 = r3 - r5;	 Catch:{ InterruptedException -> 0x0056 }
        r3 = r7;	 Catch:{ InterruptedException -> 0x0056 }
    L_0x0049:
        r12 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));	 Catch:{ InterruptedException -> 0x0056 }
        if (r12 >= 0) goto L_0x004e;	 Catch:{ InterruptedException -> 0x0056 }
    L_0x004d:
        return;	 Catch:{ InterruptedException -> 0x0056 }
    L_0x004e:
        r12 = new java.io.InterruptedIOException;	 Catch:{ InterruptedException -> 0x0056 }
        r0 = "timeout";	 Catch:{ InterruptedException -> 0x0056 }
        r12.<init>(r0);	 Catch:{ InterruptedException -> 0x0056 }
        throw r12;	 Catch:{ InterruptedException -> 0x0056 }
    L_0x0056:
        r12 = new java.io.InterruptedIOException;
        r0 = "interrupted";
        r12.<init>(r0);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Timeout.waitUntilNotified(java.lang.Object):void");
    }
}
