package io.realm.internal.async;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class RealmThreadPoolExecutor extends ThreadPoolExecutor {
    private static final int CORE_POOL_SIZE = calculateCorePoolSize();
    private static final int QUEUE_SIZE = 100;
    private static final String SYS_CPU_DIR = "/sys/devices/system/cpu/";
    private boolean isPaused;
    private ReentrantLock pauseLock = new ReentrantLock();
    private Condition unpaused = this.pauseLock.newCondition();

    class C09971 implements FileFilter {
        final /* synthetic */ Pattern val$filePattern;

        C09971(Pattern pattern) {
            this.val$filePattern = pattern;
        }

        public boolean accept(File file) {
            return this.val$filePattern.matcher(file.getName()).matches();
        }
    }

    public static RealmThreadPoolExecutor newDefaultExecutor() {
        return new RealmThreadPoolExecutor(CORE_POOL_SIZE, CORE_POOL_SIZE);
    }

    public static RealmThreadPoolExecutor newSingleThreadExecutor() {
        return new RealmThreadPoolExecutor(1, 1);
    }

    @SuppressFBWarnings({"DMI_HARDCODED_ABSOLUTE_FILENAME"})
    private static int calculateCorePoolSize() {
        int countFilesInDir = countFilesInDir(SYS_CPU_DIR, "cpu[0-9]+");
        if (countFilesInDir <= 0) {
            countFilesInDir = Runtime.getRuntime().availableProcessors();
        }
        return countFilesInDir <= 0 ? 1 : 1 + (countFilesInDir * 2);
    }

    private static int countFilesInDir(java.lang.String r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = java.util.regex.Pattern.compile(r3);
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ SecurityException -> 0x0019 }
        r1.<init>(r2);	 Catch:{ SecurityException -> 0x0019 }
        r2 = new io.realm.internal.async.RealmThreadPoolExecutor$1;	 Catch:{ SecurityException -> 0x0019 }
        r2.<init>(r3);	 Catch:{ SecurityException -> 0x0019 }
        r2 = r1.listFiles(r2);	 Catch:{ SecurityException -> 0x0019 }
        if (r2 != 0) goto L_0x0017;	 Catch:{ SecurityException -> 0x0019 }
    L_0x0015:
        r2 = r0;	 Catch:{ SecurityException -> 0x0019 }
        goto L_0x0018;	 Catch:{ SecurityException -> 0x0019 }
    L_0x0017:
        r2 = r2.length;	 Catch:{ SecurityException -> 0x0019 }
    L_0x0018:
        return r2;
    L_0x0019:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.internal.async.RealmThreadPoolExecutor.countFilesInDir(java.lang.String, java.lang.String):int");
    }

    private RealmThreadPoolExecutor(int i, int i2) {
        super(i, i2, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(100));
    }

    public Future<?> submitTransaction(Runnable runnable) {
        return super.submit(new BgPriorityRunnable(runnable));
    }

    protected void beforeExecute(java.lang.Thread r1, java.lang.Runnable r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        super.beforeExecute(r1, r2);
        r2 = r0.pauseLock;
        r2.lock();
    L_0x0008:
        r2 = r0.isPaused;	 Catch:{ InterruptedException -> 0x001a }
        if (r2 == 0) goto L_0x0012;	 Catch:{ InterruptedException -> 0x001a }
    L_0x000c:
        r2 = r0.unpaused;	 Catch:{ InterruptedException -> 0x001a }
        r2.await();	 Catch:{ InterruptedException -> 0x001a }
        goto L_0x0008;
    L_0x0012:
        r1 = r0.pauseLock;
        r1.unlock();
        goto L_0x001e;
    L_0x0018:
        r1 = move-exception;
        goto L_0x001f;
    L_0x001a:
        r1.interrupt();	 Catch:{ all -> 0x0018 }
        goto L_0x0012;
    L_0x001e:
        return;
    L_0x001f:
        r2 = r0.pauseLock;
        r2.unlock();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.internal.async.RealmThreadPoolExecutor.beforeExecute(java.lang.Thread, java.lang.Runnable):void");
    }

    public void pause() {
        this.pauseLock.lock();
        try {
            this.isPaused = true;
        } finally {
            this.pauseLock.unlock();
        }
    }

    public void resume() {
        this.pauseLock.lock();
        try {
            this.isPaused = false;
            this.unpaused.signalAll();
        } finally {
            this.pauseLock.unlock();
        }
    }
}
