package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
public final class zzii extends zzhh {
    private final zziw zzaox;
    private zzey zzaoy;
    private volatile Boolean zzaoz;
    private final zzem zzapa;
    private final zzjm zzapb;
    private final List<Runnable> zzapc = new ArrayList();
    private final zzem zzapd;

    protected zzii(zzgl com_google_android_gms_internal_measurement_zzgl) {
        super(com_google_android_gms_internal_measurement_zzgl);
        this.zzapb = new zzjm(com_google_android_gms_internal_measurement_zzgl.zzbt());
        this.zzaox = new zziw(this);
        this.zzapa = new zzij(this, com_google_android_gms_internal_measurement_zzgl);
        this.zzapd = new zzio(this, com_google_android_gms_internal_measurement_zzgl);
    }

    @WorkerThread
    private final void onServiceDisconnected(ComponentName componentName) {
        zzab();
        if (this.zzaoy != null) {
            this.zzaoy = null;
            zzge().zzit().zzg("Disconnected from device MeasurementService", componentName);
            zzab();
            zzdf();
        }
    }

    @WorkerThread
    private final void zzcu() {
        zzab();
        this.zzapb.start();
        this.zzapa.zzh(((Long) zzew.zzaho.get()).longValue());
    }

    @WorkerThread
    private final void zzcv() {
        zzab();
        if (isConnected()) {
            zzge().zzit().log("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    @WorkerThread
    private final void zzf(Runnable runnable) throws IllegalStateException {
        zzab();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.zzapc.size()) >= 1000) {
            zzge().zzim().log("Discarding data. Max runnable queue size reached");
        } else {
            this.zzapc.add(runnable);
            this.zzapd.zzh(60000);
            zzdf();
        }
    }

    @Nullable
    @WorkerThread
    private final zzdz zzk(boolean z) {
        return zzfv().zzbi(z ? zzge().zziv() : null);
    }

    @WorkerThread
    private final void zzkg() {
        zzab();
        zzge().zzit().zzg("Processing queued up service tasks", Integer.valueOf(this.zzapc.size()));
        for (Runnable run : this.zzapc) {
            try {
                run.run();
            } catch (Exception e) {
                zzge().zzim().zzg("Task exception while flushing queue", e);
            }
        }
        this.zzapc.clear();
        this.zzapd.cancel();
    }

    @android.support.annotation.WorkerThread
    public final void disconnect() {
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
        r3.zzab();
        r3.zzch();
        r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance();	 Catch:{ IllegalStateException -> 0x0013, IllegalStateException -> 0x0013 }
        r1 = r3.getContext();	 Catch:{ IllegalStateException -> 0x0013, IllegalStateException -> 0x0013 }
        r2 = r3.zzaox;	 Catch:{ IllegalStateException -> 0x0013, IllegalStateException -> 0x0013 }
        r0.unbindService(r1, r2);	 Catch:{ IllegalStateException -> 0x0013, IllegalStateException -> 0x0013 }
    L_0x0013:
        r0 = 0;
        r3.zzaoy = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzii.disconnect():void");
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public final boolean isConnected() {
        zzab();
        zzch();
        return this.zzaoy != null;
    }

    @WorkerThread
    protected final void resetAnalyticsData() {
        zzab();
        zzch();
        zzdz zzk = zzk(false);
        zzfz().resetAnalyticsData();
        zzf(new zzik(this, zzk));
    }

    @WorkerThread
    @VisibleForTesting
    protected final void zza(zzey com_google_android_gms_internal_measurement_zzey) {
        zzab();
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzey);
        this.zzaoy = com_google_android_gms_internal_measurement_zzey;
        zzcu();
        zzkg();
    }

    @WorkerThread
    @VisibleForTesting
    final void zza(zzey com_google_android_gms_internal_measurement_zzey, AbstractSafeParcelable abstractSafeParcelable, zzdz com_google_android_gms_internal_measurement_zzdz) {
        zzfi zzim;
        String str;
        zzab();
        zzch();
        int i = 0;
        int i2 = 100;
        while (i < 1001 && r3 == 100) {
            int size;
            List arrayList = new ArrayList();
            Object zzp = zzfz().zzp(100);
            if (zzp != null) {
                arrayList.addAll(zzp);
                size = zzp.size();
            } else {
                size = 0;
            }
            if (abstractSafeParcelable != null && size < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            int size2 = arrayList2.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj = arrayList2.get(i3);
                i3++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzeu) {
                    try {
                        com_google_android_gms_internal_measurement_zzey.zza((zzeu) abstractSafeParcelable2, com_google_android_gms_internal_measurement_zzdz);
                    } catch (RemoteException e) {
                        obj = e;
                        zzim = zzge().zzim();
                        str = "Failed to send event to the service";
                        zzim.zzg(str, obj);
                    }
                } else if (abstractSafeParcelable2 instanceof zzjx) {
                    try {
                        com_google_android_gms_internal_measurement_zzey.zza((zzjx) abstractSafeParcelable2, com_google_android_gms_internal_measurement_zzdz);
                    } catch (RemoteException e2) {
                        obj = e2;
                        zzim = zzge().zzim();
                        str = "Failed to send attribute to the service";
                        zzim.zzg(str, obj);
                    }
                } else if (abstractSafeParcelable2 instanceof zzed) {
                    try {
                        com_google_android_gms_internal_measurement_zzey.zza((zzed) abstractSafeParcelable2, com_google_android_gms_internal_measurement_zzdz);
                    } catch (RemoteException e3) {
                        obj = e3;
                        zzim = zzge().zzim();
                        str = "Failed to send conditional property to the service";
                        zzim.zzg(str, obj);
                    }
                } else {
                    zzge().zzim().log("Discarding data. Unrecognized parcel type.");
                }
            }
            i++;
            i2 = size;
        }
    }

    @WorkerThread
    public final void zza(AtomicReference<String> atomicReference) {
        zzab();
        zzch();
        zzf(new zzil(this, atomicReference, zzk(false)));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzed>> atomicReference, String str, String str2, String str3) {
        zzab();
        zzch();
        zzf(new zzis(this, atomicReference, str, str2, str3, zzk(false)));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzjx>> atomicReference, String str, String str2, String str3, boolean z) {
        zzab();
        zzch();
        zzf(new zzit(this, atomicReference, str, str2, str3, z, zzk(false)));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzjx>> atomicReference, boolean z) {
        zzab();
        zzch();
        zzf(new zziv(this, atomicReference, zzk(false), z));
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    @WorkerThread
    protected final void zzb(zzeu com_google_android_gms_internal_measurement_zzeu, String str) {
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzeu);
        zzab();
        zzch();
        zzf(new zziq(this, true, zzfz().zza(com_google_android_gms_internal_measurement_zzeu), com_google_android_gms_internal_measurement_zzeu, zzk(true), str));
    }

    @WorkerThread
    protected final void zzb(zzie com_google_android_gms_internal_measurement_zzie) {
        zzab();
        zzch();
        zzf(new zzin(this, com_google_android_gms_internal_measurement_zzie));
    }

    @WorkerThread
    protected final void zzb(zzjx com_google_android_gms_internal_measurement_zzjx) {
        zzab();
        zzch();
        zzf(new zziu(this, zzfz().zza(com_google_android_gms_internal_measurement_zzjx), com_google_android_gms_internal_measurement_zzjx, zzk(true)));
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    @WorkerThread
    protected final void zzd(zzed com_google_android_gms_internal_measurement_zzed) {
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzed);
        zzab();
        zzch();
        zzf(new zzir(this, true, zzfz().zzc(com_google_android_gms_internal_measurement_zzed), new zzed(com_google_android_gms_internal_measurement_zzed), zzk(true), com_google_android_gms_internal_measurement_zzed));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.WorkerThread
    final void zzdf() {
        /*
        r6 = this;
        r6.zzab();
        r6.zzch();
        r0 = r6.isConnected();
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r6.zzaoz;
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x00fa;
    L_0x0013:
        r6.zzab();
        r6.zzch();
        r0 = r6.zzgf();
        r0 = r0.zzjb();
        if (r0 == 0) goto L_0x002c;
    L_0x0023:
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x002c;
    L_0x0029:
        r3 = r2;
        goto L_0x00f4;
    L_0x002c:
        r0 = r6.zzfv();
        r0 = r0.zzik();
        if (r0 != r2) goto L_0x003a;
    L_0x0036:
        r0 = r2;
    L_0x0037:
        r3 = r0;
        goto L_0x00eb;
    L_0x003a:
        r0 = r6.zzge();
        r0 = r0.zzit();
        r3 = "Checking service availability";
        r0.log(r3);
        r0 = r6.zzgb();
        r3 = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance();
        r0 = r0.getContext();
        r4 = 12451; // 0x30a3 float:1.7448E-41 double:6.1516E-320;
        r0 = r3.isGooglePlayServicesAvailable(r0, r4);
        r3 = 9;
        if (r0 == r3) goto L_0x00e0;
    L_0x005d:
        r3 = 18;
        if (r0 == r3) goto L_0x00d5;
    L_0x0061:
        switch(r0) {
            case 0: goto L_0x00c6;
            case 1: goto L_0x00b6;
            case 2: goto L_0x0085;
            case 3: goto L_0x0077;
            default: goto L_0x0064;
        };
    L_0x0064:
        r3 = r6.zzge();
        r3 = r3.zzip();
        r4 = "Unexpected service status";
        r0 = java.lang.Integer.valueOf(r0);
        r3.zzg(r4, r0);
    L_0x0075:
        r0 = r1;
        goto L_0x0037;
    L_0x0077:
        r0 = r6.zzge();
        r0 = r0.zzip();
        r3 = "Service disabled";
    L_0x0081:
        r0.log(r3);
        goto L_0x0075;
    L_0x0085:
        r0 = r6.zzge();
        r0 = r0.zzis();
        r3 = "Service container out of date";
        r0.log(r3);
        r0 = r6.zzgb();
        r0 = r0.zzld();
        r3 = 12600; // 0x3138 float:1.7656E-41 double:6.225E-320;
        if (r0 >= r3) goto L_0x009f;
    L_0x009e:
        goto L_0x00c3;
    L_0x009f:
        r0 = r6.zzgf();
        r0 = r0.zzjb();
        if (r0 == 0) goto L_0x00b2;
    L_0x00a9:
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x00b0;
    L_0x00af:
        goto L_0x00b2;
    L_0x00b0:
        r0 = r1;
        goto L_0x00b3;
    L_0x00b2:
        r0 = r2;
    L_0x00b3:
        r3 = r0;
        r0 = r1;
        goto L_0x00eb;
    L_0x00b6:
        r0 = r6.zzge();
        r0 = r0.zzit();
        r3 = "Service missing";
        r0.log(r3);
    L_0x00c3:
        r3 = r1;
        r0 = r2;
        goto L_0x00eb;
    L_0x00c6:
        r0 = r6.zzge();
        r0 = r0.zzit();
        r3 = "Service available";
    L_0x00d0:
        r0.log(r3);
        goto L_0x0036;
    L_0x00d5:
        r0 = r6.zzge();
        r0 = r0.zzip();
        r3 = "Service updating";
        goto L_0x00d0;
    L_0x00e0:
        r0 = r6.zzge();
        r0 = r0.zzip();
        r3 = "Service invalid";
        goto L_0x0081;
    L_0x00eb:
        if (r0 == 0) goto L_0x00f4;
    L_0x00ed:
        r0 = r6.zzgf();
        r0.zzf(r3);
    L_0x00f4:
        r0 = java.lang.Boolean.valueOf(r3);
        r6.zzaoz = r0;
    L_0x00fa:
        r0 = r6.zzaoz;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0108;
    L_0x0102:
        r0 = r6.zzaox;
        r0.zzkh();
        return;
    L_0x0108:
        r0 = r6.getContext();
        r0 = r0.getPackageManager();
        r3 = new android.content.Intent;
        r3.<init>();
        r4 = r6.getContext();
        r5 = "com.google.android.gms.measurement.AppMeasurementService";
        r3 = r3.setClassName(r4, r5);
        r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r0 = r0.queryIntentServices(r3, r4);
        if (r0 == 0) goto L_0x012e;
    L_0x0127:
        r0 = r0.size();
        if (r0 <= 0) goto L_0x012e;
    L_0x012d:
        r1 = r2;
    L_0x012e:
        if (r1 == 0) goto L_0x014b;
    L_0x0130:
        r0 = new android.content.Intent;
        r1 = "com.google.android.gms.measurement.START";
        r0.<init>(r1);
        r1 = new android.content.ComponentName;
        r2 = r6.getContext();
        r3 = "com.google.android.gms.measurement.AppMeasurementService";
        r1.<init>(r2, r3);
        r0.setComponent(r1);
        r1 = r6.zzaox;
        r1.zzc(r0);
        return;
    L_0x014b:
        r0 = r6.zzge();
        r0 = r0.zzim();
        r1 = "Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest";
        r0.log(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzii.zzdf():void");
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        super.zzfr();
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        super.zzfs();
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

    @WorkerThread
    protected final void zzkb() {
        zzab();
        zzch();
        zzf(new zzim(this, zzk(true)));
    }

    @WorkerThread
    protected final void zzke() {
        zzab();
        zzch();
        zzf(new zzip(this, zzk(true)));
    }

    final Boolean zzkf() {
        return this.zzaoz;
    }
}
