package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class zzgg extends zzhh {
    private static final AtomicLong zzalx = new AtomicLong(Long.MIN_VALUE);
    private ExecutorService zzaln;
    private zzgk zzalo;
    private zzgk zzalp;
    private final PriorityBlockingQueue<zzgj<?>> zzalq = new PriorityBlockingQueue();
    private final BlockingQueue<zzgj<?>> zzalr = new LinkedBlockingQueue();
    private final UncaughtExceptionHandler zzals = new zzgi(this, "Thread death: Uncaught exception on worker thread");
    private final UncaughtExceptionHandler zzalt = new zzgi(this, "Thread death: Uncaught exception on network thread");
    private final Object zzalu = new Object();
    private final Semaphore zzalv = new Semaphore(2);
    private volatile boolean zzalw;

    zzgg(zzgl com_google_android_gms_internal_measurement_zzgl) {
        super(com_google_android_gms_internal_measurement_zzgl);
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private final void zza(zzgj<?> com_google_android_gms_internal_measurement_zzgj_) {
        synchronized (this.zzalu) {
            this.zzalq.add(com_google_android_gms_internal_measurement_zzgj_);
            if (this.zzalo == null) {
                this.zzalo = new zzgk(this, "Measurement Worker", this.zzalq);
                this.zzalo.setUncaughtExceptionHandler(this.zzals);
                this.zzalo.start();
            } else {
                this.zzalo.zzjn();
            }
        }
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    final <T> T zza(java.util.concurrent.atomic.AtomicReference<T> r1, long r2, java.lang.String r4, java.lang.Runnable r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = this;
        monitor-enter(r1);
        r2 = r0.zzgd();	 Catch:{ all -> 0x005c }
        r2.zzc(r5);	 Catch:{ all -> 0x005c }
        r2 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r1.wait(r2);	 Catch:{ InterruptedException -> 0x0037 }
        monitor-exit(r1);	 Catch:{ all -> 0x005c }
        r1 = r1.get();
        if (r1 != 0) goto L_0x0036;
    L_0x0014:
        r2 = r0.zzge();
        r2 = r2.zzip();
        r3 = "Timed out waiting for ";
        r4 = java.lang.String.valueOf(r4);
        r5 = r4.length();
        if (r5 == 0) goto L_0x002d;
    L_0x0028:
        r3 = r3.concat(r4);
        goto L_0x0033;
    L_0x002d:
        r4 = new java.lang.String;
        r4.<init>(r3);
        r3 = r4;
    L_0x0033:
        r2.log(r3);
    L_0x0036:
        return r1;
    L_0x0037:
        r2 = r0.zzge();	 Catch:{ all -> 0x005c }
        r2 = r2.zzip();	 Catch:{ all -> 0x005c }
        r3 = "Interrupted waiting for ";	 Catch:{ all -> 0x005c }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ all -> 0x005c }
        r5 = r4.length();	 Catch:{ all -> 0x005c }
        if (r5 == 0) goto L_0x0050;	 Catch:{ all -> 0x005c }
    L_0x004b:
        r3 = r3.concat(r4);	 Catch:{ all -> 0x005c }
        goto L_0x0056;	 Catch:{ all -> 0x005c }
    L_0x0050:
        r4 = new java.lang.String;	 Catch:{ all -> 0x005c }
        r4.<init>(r3);	 Catch:{ all -> 0x005c }
        r3 = r4;	 Catch:{ all -> 0x005c }
    L_0x0056:
        r2.log(r3);	 Catch:{ all -> 0x005c }
        r2 = 0;	 Catch:{ all -> 0x005c }
        monitor-exit(r1);	 Catch:{ all -> 0x005c }
        return r2;	 Catch:{ all -> 0x005c }
    L_0x005c:
        r2 = move-exception;	 Catch:{ all -> 0x005c }
        monitor-exit(r1);	 Catch:{ all -> 0x005c }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgg.zza(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):T");
    }

    public final void zzab() {
        if (Thread.currentThread() != this.zzalo) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final <V> Future<V> zzb(Callable<V> callable) throws IllegalStateException {
        zzch();
        Preconditions.checkNotNull(callable);
        zzgj com_google_android_gms_internal_measurement_zzgj = new zzgj(this, (Callable) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzalo) {
            if (!this.zzalq.isEmpty()) {
                zzge().zzip().log("Callable skipped the worker queue.");
            }
            com_google_android_gms_internal_measurement_zzgj.run();
        } else {
            zza(com_google_android_gms_internal_measurement_zzgj);
        }
        return com_google_android_gms_internal_measurement_zzgj;
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    public final <V> Future<V> zzc(Callable<V> callable) throws IllegalStateException {
        zzch();
        Preconditions.checkNotNull(callable);
        zzgj com_google_android_gms_internal_measurement_zzgj = new zzgj(this, (Callable) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzalo) {
            com_google_android_gms_internal_measurement_zzgj.run();
        } else {
            zza(com_google_android_gms_internal_measurement_zzgj);
        }
        return com_google_android_gms_internal_measurement_zzgj;
    }

    public final void zzc(Runnable runnable) throws IllegalStateException {
        zzch();
        Preconditions.checkNotNull(runnable);
        zza(new zzgj(this, runnable, false, "Task exception on worker thread"));
    }

    public final void zzd(Runnable runnable) throws IllegalStateException {
        zzch();
        Preconditions.checkNotNull(runnable);
        zzgj com_google_android_gms_internal_measurement_zzgj = new zzgj(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzalu) {
            this.zzalr.add(com_google_android_gms_internal_measurement_zzgj);
            if (this.zzalp == null) {
                this.zzalp = new zzgk(this, "Measurement Network", this.zzalr);
                this.zzalp.setUncaughtExceptionHandler(this.zzalt);
                this.zzalp.start();
            } else {
                this.zzalp.zzjn();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        super.zzfr();
    }

    public final void zzfs() {
        if (Thread.currentThread() != this.zzalp) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        return super.zzft();
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        return super.zzfu();
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        return super.zzfv();
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        return super.zzfw();
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        return super.zzfx();
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        return super.zzfy();
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        return super.zzfz();
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        return super.zzga();
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        return super.zzgb();
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        return super.zzgc();
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        return super.zzgd();
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        return super.zzge();
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        return super.zzgf();
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        return super.zzgg();
    }

    protected final boolean zzhf() {
        return false;
    }

    public final boolean zzjk() {
        return Thread.currentThread() == this.zzalo;
    }

    final ExecutorService zzjl() {
        ExecutorService executorService;
        synchronized (this.zzalu) {
            if (this.zzaln == null) {
                this.zzaln = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
            }
            executorService = this.zzaln;
        }
        return executorService;
    }
}
