package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zziw implements ServiceConnection, BaseConnectionCallbacks, BaseOnConnectionFailedListener {
    final /* synthetic */ zzii zzape;
    private volatile boolean zzapk;
    private volatile zzff zzapl;

    protected zziw(zzii com_google_android_gms_internal_measurement_zzii) {
        this.zzape = com_google_android_gms_internal_measurement_zzii;
    }

    @android.support.annotation.MainThread
    public final void onConnected(@android.support.annotation.Nullable android.os.Bundle r4) {
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
        r3 = this;
        r4 = "MeasurementServiceConnection.onConnected";
        com.google.android.gms.common.internal.Preconditions.checkMainThread(r4);
        monitor-enter(r3);
        r4 = 0;
        r0 = r3.zzapl;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r0 = r0.getService();	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r0 = (com.google.android.gms.internal.measurement.zzey) r0;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r3.zzapl = r4;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r1 = r3.zzape;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r1 = r1.zzgd();	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r2 = new com.google.android.gms.internal.measurement.zziz;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r2.<init>(r3, r0);	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r1.zzc(r2);	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        goto L_0x0027;
    L_0x0020:
        r4 = move-exception;
        goto L_0x0029;
    L_0x0022:
        r3.zzapl = r4;	 Catch:{ all -> 0x0020 }
        r4 = 0;	 Catch:{ all -> 0x0020 }
        r3.zzapk = r4;	 Catch:{ all -> 0x0020 }
    L_0x0027:
        monitor-exit(r3);	 Catch:{ all -> 0x0020 }
        return;	 Catch:{ all -> 0x0020 }
    L_0x0029:
        monitor-exit(r3);	 Catch:{ all -> 0x0020 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zziw.onConnected(android.os.Bundle):void");
    }

    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzfg zzjo = this.zzape.zzacw.zzjo();
        if (zzjo != null) {
            zzjo.zzip().zzg("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzapk = false;
            this.zzapl = null;
        }
        this.zzape.zzgd().zzc(new zzjb(this));
    }

    @MainThread
    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zzape.zzge().zzis().log("Service connection suspended");
        this.zzape.zzgd().zzc(new zzja(this));
    }

    @android.support.annotation.MainThread
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
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
        r3 = this;
        r4 = "MeasurementServiceConnection.onServiceConnected";
        com.google.android.gms.common.internal.Preconditions.checkMainThread(r4);
        monitor-enter(r3);
        r4 = 0;
        if (r5 != 0) goto L_0x001f;
    L_0x0009:
        r3.zzapk = r4;	 Catch:{ all -> 0x001c }
        r4 = r3.zzape;	 Catch:{ all -> 0x001c }
        r4 = r4.zzge();	 Catch:{ all -> 0x001c }
        r4 = r4.zzim();	 Catch:{ all -> 0x001c }
        r5 = "Service connected with null binder";	 Catch:{ all -> 0x001c }
        r4.log(r5);	 Catch:{ all -> 0x001c }
        monitor-exit(r3);	 Catch:{ all -> 0x001c }
        return;
    L_0x001c:
        r4 = move-exception;
        goto L_0x009a;
    L_0x001f:
        r0 = 0;
        r1 = r5.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0063 }
        r2 = "com.google.android.gms.measurement.internal.IMeasurementService";	 Catch:{ RemoteException -> 0x0063 }
        r2 = r2.equals(r1);	 Catch:{ RemoteException -> 0x0063 }
        if (r2 == 0) goto L_0x0053;	 Catch:{ RemoteException -> 0x0063 }
    L_0x002c:
        if (r5 != 0) goto L_0x002f;	 Catch:{ RemoteException -> 0x0063 }
    L_0x002e:
        goto L_0x0043;	 Catch:{ RemoteException -> 0x0063 }
    L_0x002f:
        r1 = "com.google.android.gms.measurement.internal.IMeasurementService";	 Catch:{ RemoteException -> 0x0063 }
        r1 = r5.queryLocalInterface(r1);	 Catch:{ RemoteException -> 0x0063 }
        r2 = r1 instanceof com.google.android.gms.internal.measurement.zzey;	 Catch:{ RemoteException -> 0x0063 }
        if (r2 == 0) goto L_0x003d;	 Catch:{ RemoteException -> 0x0063 }
    L_0x0039:
        r1 = (com.google.android.gms.internal.measurement.zzey) r1;	 Catch:{ RemoteException -> 0x0063 }
    L_0x003b:
        r0 = r1;	 Catch:{ RemoteException -> 0x0063 }
        goto L_0x0043;	 Catch:{ RemoteException -> 0x0063 }
    L_0x003d:
        r1 = new com.google.android.gms.internal.measurement.zzfa;	 Catch:{ RemoteException -> 0x0063 }
        r1.<init>(r5);	 Catch:{ RemoteException -> 0x0063 }
        goto L_0x003b;	 Catch:{ RemoteException -> 0x0063 }
    L_0x0043:
        r5 = r3.zzape;	 Catch:{ RemoteException -> 0x0063 }
        r5 = r5.zzge();	 Catch:{ RemoteException -> 0x0063 }
        r5 = r5.zzit();	 Catch:{ RemoteException -> 0x0063 }
        r1 = "Bound to IMeasurementService interface";	 Catch:{ RemoteException -> 0x0063 }
        r5.log(r1);	 Catch:{ RemoteException -> 0x0063 }
        goto L_0x0072;	 Catch:{ RemoteException -> 0x0063 }
    L_0x0053:
        r5 = r3.zzape;	 Catch:{ RemoteException -> 0x0063 }
        r5 = r5.zzge();	 Catch:{ RemoteException -> 0x0063 }
        r5 = r5.zzim();	 Catch:{ RemoteException -> 0x0063 }
        r2 = "Got binder with a wrong descriptor";	 Catch:{ RemoteException -> 0x0063 }
        r5.zzg(r2, r1);	 Catch:{ RemoteException -> 0x0063 }
        goto L_0x0072;
    L_0x0063:
        r5 = r3.zzape;	 Catch:{ all -> 0x001c }
        r5 = r5.zzge();	 Catch:{ all -> 0x001c }
        r5 = r5.zzim();	 Catch:{ all -> 0x001c }
        r1 = "Service connect failed to get IMeasurementService";	 Catch:{ all -> 0x001c }
        r5.log(r1);	 Catch:{ all -> 0x001c }
    L_0x0072:
        if (r0 != 0) goto L_0x008a;	 Catch:{ all -> 0x001c }
    L_0x0074:
        r3.zzapk = r4;	 Catch:{ all -> 0x001c }
        r4 = com.google.android.gms.common.stats.ConnectionTracker.getInstance();	 Catch:{ IllegalArgumentException -> 0x0098 }
        r5 = r3.zzape;	 Catch:{ IllegalArgumentException -> 0x0098 }
        r5 = r5.getContext();	 Catch:{ IllegalArgumentException -> 0x0098 }
        r0 = r3.zzape;	 Catch:{ IllegalArgumentException -> 0x0098 }
        r0 = r0.zzaox;	 Catch:{ IllegalArgumentException -> 0x0098 }
        r4.unbindService(r5, r0);	 Catch:{ IllegalArgumentException -> 0x0098 }
        goto L_0x0098;
    L_0x008a:
        r4 = r3.zzape;	 Catch:{ all -> 0x001c }
        r4 = r4.zzgd();	 Catch:{ all -> 0x001c }
        r5 = new com.google.android.gms.internal.measurement.zzix;	 Catch:{ all -> 0x001c }
        r5.<init>(r3, r0);	 Catch:{ all -> 0x001c }
        r4.zzc(r5);	 Catch:{ all -> 0x001c }
    L_0x0098:
        monitor-exit(r3);	 Catch:{ all -> 0x001c }
        return;	 Catch:{ all -> 0x001c }
    L_0x009a:
        monitor-exit(r3);	 Catch:{ all -> 0x001c }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zziw.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zzape.zzge().zzis().log("Service disconnected");
        this.zzape.zzgd().zzc(new zziy(this, componentName));
    }

    @WorkerThread
    public final void zzc(Intent intent) {
        this.zzape.zzab();
        Context context = this.zzape.getContext();
        ConnectionTracker instance = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzapk) {
                this.zzape.zzge().zzit().log("Connection attempt already in progress");
                return;
            }
            this.zzape.zzge().zzit().log("Using local app measurement service");
            this.zzapk = true;
            instance.bindService(context, intent, this.zzape.zzaox, GmsClientSupervisor.DEFAULT_BIND_FLAGS);
        }
    }

    @WorkerThread
    public final void zzkh() {
        this.zzape.zzab();
        Context context = this.zzape.getContext();
        synchronized (this) {
            if (this.zzapk) {
                this.zzape.zzge().zzit().log("Connection attempt already in progress");
            } else if (this.zzapl != null) {
                this.zzape.zzge().zzit().log("Already awaiting connection attempt");
            } else {
                this.zzapl = new zzff(context, Looper.getMainLooper(), this, this);
                this.zzape.zzge().zzit().log("Connecting to remote service");
                this.zzapk = true;
                this.zzapl.checkAvailabilityAndConnect();
            }
        }
    }
}
