package io.realm.internal;

import java.lang.ref.ReferenceQueue;

class FinalizerRunnable implements Runnable {
    private final ReferenceQueue<NativeObject> referenceQueue;

    FinalizerRunnable(ReferenceQueue<NativeObject> referenceQueue) {
        this.referenceQueue = referenceQueue;
    }

    public void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
    L_0x0000:
        r0 = r2.referenceQueue;	 Catch:{ InterruptedException -> 0x000c }
        r0 = r0.remove();	 Catch:{ InterruptedException -> 0x000c }
        r0 = (io.realm.internal.NativeObjectReference) r0;	 Catch:{ InterruptedException -> 0x000c }
        r0.cleanup();	 Catch:{ InterruptedException -> 0x000c }
        goto L_0x0000;
    L_0x000c:
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
        r0 = "The FinalizerRunnable thread has been interrupted. Native resources cannot be freed anymore";
        r1 = 0;
        r1 = new java.lang.Object[r1];
        io.realm.log.RealmLog.fatal(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.internal.FinalizerRunnable.run():void");
    }
}
