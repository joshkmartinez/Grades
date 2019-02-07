package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzfc extends zzhh {
    private final zzfd zzaig = new zzfd(this, getContext(), "google_app_measurement_local.db");
    private boolean zzaih;

    zzfc(zzgl com_google_android_gms_internal_measurement_zzgl) {
        super(com_google_android_gms_internal_measurement_zzgl);
    }

    @WorkerThread
    @VisibleForTesting
    private final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        if (this.zzaih) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzaig.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzaih = true;
        return null;
    }

    @android.support.annotation.WorkerThread
    private final boolean zza(int r19, byte[] r20) {
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
        r18 = this;
        r1 = r18;
        r18.zzab();
        r0 = r1.zzaih;
        r2 = 0;
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return r2;
    L_0x000b:
        r3 = new android.content.ContentValues;
        r3.<init>();
        r0 = "type";
        r4 = java.lang.Integer.valueOf(r19);
        r3.put(r0, r4);
        r0 = "entry";
        r4 = r20;
        r3.put(r0, r4);
        r4 = 5;
        r5 = r2;
        r6 = r4;
    L_0x0023:
        if (r5 >= r4) goto L_0x0148;
    L_0x0025:
        r7 = 0;
        r8 = 1;
        r9 = r18.getWritableDatabase();	 Catch:{ SQLiteFullException -> 0x011a, SQLiteDatabaseLockedException -> 0x0107, SQLiteException -> 0x00da, all -> 0x00d4 }
        if (r9 != 0) goto L_0x0040;
    L_0x002d:
        r1.zzaih = r8;	 Catch:{ SQLiteFullException -> 0x003d, SQLiteDatabaseLockedException -> 0x003a, SQLiteException -> 0x0035 }
        if (r9 == 0) goto L_0x0034;
    L_0x0031:
        r9.close();
    L_0x0034:
        return r2;
    L_0x0035:
        r0 = move-exception;
        r12 = r7;
    L_0x0037:
        r7 = r9;
        goto L_0x00dd;
    L_0x003a:
        r2 = r7;
        goto L_0x00cf;
    L_0x003d:
        r0 = move-exception;
        goto L_0x011d;
    L_0x0040:
        r9.beginTransaction();	 Catch:{ SQLiteFullException -> 0x00d1, SQLiteDatabaseLockedException -> 0x003a, SQLiteException -> 0x00ca, all -> 0x00c5 }
        r10 = 0;	 Catch:{ SQLiteFullException -> 0x00d1, SQLiteDatabaseLockedException -> 0x003a, SQLiteException -> 0x00ca, all -> 0x00c5 }
        r0 = "select count(1) from messages";	 Catch:{ SQLiteFullException -> 0x00d1, SQLiteDatabaseLockedException -> 0x003a, SQLiteException -> 0x00ca, all -> 0x00c5 }
        r12 = r9.rawQuery(r0, r7);	 Catch:{ SQLiteFullException -> 0x00d1, SQLiteDatabaseLockedException -> 0x003a, SQLiteException -> 0x00ca, all -> 0x00c5 }
        if (r12 == 0) goto L_0x0061;
    L_0x004d:
        r0 = r12.moveToFirst();	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        if (r0 == 0) goto L_0x0061;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
    L_0x0053:
        r10 = r12.getLong(r2);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        goto L_0x0061;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
    L_0x0058:
        r0 = move-exception;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        goto L_0x013d;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
    L_0x005b:
        r0 = move-exception;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        goto L_0x0037;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
    L_0x005d:
        r0 = move-exception;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r7 = r12;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        goto L_0x011d;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
    L_0x0061:
        r13 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r0 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1));	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        if (r0 < 0) goto L_0x00ab;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
    L_0x0068:
        r0 = r18.zzge();	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r0 = r0.zzim();	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r15 = "Data loss, local db full";	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r0.log(r15);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r15 = r13 - r10;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r10 = 1;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r13 = r15 + r10;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r0 = "messages";	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r10 = "rowid in (select rowid from messages order by rowid asc limit ?)";	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r11 = new java.lang.String[r8];	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r15 = java.lang.Long.toString(r13);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r11[r2] = r15;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r0 = r9.delete(r0, r10, r11);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r10 = (long) r0;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r0 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1));	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        if (r0 == 0) goto L_0x00ab;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
    L_0x0090:
        r0 = r18.zzge();	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r0 = r0.zzim();	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r15 = "Different delete count than expected in local db. expected, received, difference";	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r4 = java.lang.Long.valueOf(r13);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r2 = java.lang.Long.valueOf(r10);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r7 = r13 - r10;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r0.zzd(r15, r4, r2, r7);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
    L_0x00ab:
        r0 = "messages";	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r2 = 0;	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r9.insertOrThrow(r0, r2, r3);	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r9.setTransactionSuccessful();	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        r9.endTransaction();	 Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c3, SQLiteException -> 0x005b, all -> 0x0058 }
        if (r12 == 0) goto L_0x00bc;
    L_0x00b9:
        r12.close();
    L_0x00bc:
        if (r9 == 0) goto L_0x00c1;
    L_0x00be:
        r9.close();
    L_0x00c1:
        r2 = 1;
        return r2;
    L_0x00c3:
        r7 = r12;
        goto L_0x0109;
    L_0x00c5:
        r0 = move-exception;
        r2 = r7;
        r12 = r2;
        goto L_0x013d;
    L_0x00ca:
        r0 = move-exception;
        r2 = r7;
        r12 = r2;
        goto L_0x0037;
    L_0x00cf:
        r7 = r2;
        goto L_0x0109;
    L_0x00d1:
        r0 = move-exception;
        r2 = r7;
        goto L_0x011d;
    L_0x00d4:
        r0 = move-exception;
        r2 = r7;
        r9 = r2;
        r12 = r9;
        goto L_0x013d;
    L_0x00da:
        r0 = move-exception;
        r2 = r7;
        r12 = r7;
    L_0x00dd:
        if (r7 == 0) goto L_0x00ec;
    L_0x00df:
        r2 = r7.inTransaction();	 Catch:{ all -> 0x00e9 }
        if (r2 == 0) goto L_0x00ec;	 Catch:{ all -> 0x00e9 }
    L_0x00e5:
        r7.endTransaction();	 Catch:{ all -> 0x00e9 }
        goto L_0x00ec;	 Catch:{ all -> 0x00e9 }
    L_0x00e9:
        r0 = move-exception;	 Catch:{ all -> 0x00e9 }
        r9 = r7;	 Catch:{ all -> 0x00e9 }
        goto L_0x013d;	 Catch:{ all -> 0x00e9 }
    L_0x00ec:
        r2 = r18.zzge();	 Catch:{ all -> 0x00e9 }
        r2 = r2.zzim();	 Catch:{ all -> 0x00e9 }
        r4 = "Error writing entry to local database";	 Catch:{ all -> 0x00e9 }
        r2.zzg(r4, r0);	 Catch:{ all -> 0x00e9 }
        r2 = 1;	 Catch:{ all -> 0x00e9 }
        r1.zzaih = r2;	 Catch:{ all -> 0x00e9 }
        if (r12 == 0) goto L_0x0101;
    L_0x00fe:
        r12.close();
    L_0x0101:
        if (r7 == 0) goto L_0x0135;
    L_0x0103:
        r7.close();
        goto L_0x0135;
    L_0x0107:
        r2 = r7;
        r9 = r7;
    L_0x0109:
        r10 = (long) r6;
        android.os.SystemClock.sleep(r10);	 Catch:{ all -> 0x013b }
        r6 = r6 + 20;
        if (r7 == 0) goto L_0x0114;
    L_0x0111:
        r7.close();
    L_0x0114:
        if (r9 == 0) goto L_0x0135;
    L_0x0116:
        r9.close();
        goto L_0x0135;
    L_0x011a:
        r0 = move-exception;
        r2 = r7;
        r9 = r7;
    L_0x011d:
        r2 = r18.zzge();	 Catch:{ all -> 0x013b }
        r2 = r2.zzim();	 Catch:{ all -> 0x013b }
        r4 = "Error writing entry to local database";	 Catch:{ all -> 0x013b }
        r2.zzg(r4, r0);	 Catch:{ all -> 0x013b }
        r2 = 1;	 Catch:{ all -> 0x013b }
        r1.zzaih = r2;	 Catch:{ all -> 0x013b }
        if (r7 == 0) goto L_0x0132;
    L_0x012f:
        r7.close();
    L_0x0132:
        if (r9 == 0) goto L_0x0135;
    L_0x0134:
        goto L_0x0116;
    L_0x0135:
        r5 = r5 + 1;
        r2 = 0;
        r4 = 5;
        goto L_0x0023;
    L_0x013b:
        r0 = move-exception;
        r12 = r7;
    L_0x013d:
        if (r12 == 0) goto L_0x0142;
    L_0x013f:
        r12.close();
    L_0x0142:
        if (r9 == 0) goto L_0x0147;
    L_0x0144:
        r9.close();
    L_0x0147:
        throw r0;
    L_0x0148:
        r0 = r18.zzge();
        r0 = r0.zzip();
        r2 = "Failed to write entry to local database";
        r0.log(r2);
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfc.zza(int, byte[]):boolean");
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public final void resetAnalyticsData() {
        zzab();
        try {
            int delete = 0 + getWritableDatabase().delete("messages", null, null);
            if (delete > 0) {
                zzge().zzit().zzg("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzge().zzim().zzg("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zza(zzeu com_google_android_gms_internal_measurement_zzeu) {
        Parcel obtain = Parcel.obtain();
        com_google_android_gms_internal_measurement_zzeu.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzge().zzip().log("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzjx com_google_android_gms_internal_measurement_zzjx) {
        Parcel obtain = Parcel.obtain();
        com_google_android_gms_internal_measurement_zzjx.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzge().zzip().log("User property too long for local database. Sending directly to service");
        return false;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    public final boolean zzc(zzed com_google_android_gms_internal_measurement_zzed) {
        zzgb();
        byte[] zza = zzka.zza((Parcelable) com_google_android_gms_internal_measurement_zzed);
        if (zza.length <= 131072) {
            return zza(2, zza);
        }
        zzge().zzip().log("Conditional user property too long for local database. Sending directly to service");
        return false;
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

    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zzp(int r20) {
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
        r19 = this;
        r1 = r19;
        r19.zzab();
        r0 = r1.zzaih;
        r2 = 0;
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return r2;
    L_0x000b:
        r3 = new java.util.ArrayList;
        r3.<init>();
        r0 = r19.getContext();
        r4 = "google_app_measurement_local.db";
        r0 = r0.getDatabasePath(r4);
        r0 = r0.exists();
        if (r0 != 0) goto L_0x0021;
    L_0x0020:
        return r3;
    L_0x0021:
        r4 = 5;
        r5 = 0;
        r7 = r4;
        r6 = r5;
    L_0x0025:
        if (r6 >= r4) goto L_0x01de;
    L_0x0027:
        r8 = 1;
        r15 = r19.getWritableDatabase();	 Catch:{ SQLiteFullException -> 0x01b3, SQLiteDatabaseLockedException -> 0x01a0, SQLiteException -> 0x017b, all -> 0x0177 }
        if (r15 != 0) goto L_0x0048;
    L_0x002e:
        r1.zzaih = r8;	 Catch:{ SQLiteFullException -> 0x0043, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x003b, all -> 0x0036 }
        if (r15 == 0) goto L_0x0035;
    L_0x0032:
        r15.close();
    L_0x0035:
        return r2;
    L_0x0036:
        r0 = move-exception;
        r9 = r2;
        r4 = r15;
        goto L_0x01d3;
    L_0x003b:
        r0 = move-exception;
        r9 = r2;
        r4 = r15;
        goto L_0x017e;
    L_0x0040:
        r4 = r15;
        goto L_0x0171;
    L_0x0043:
        r0 = move-exception;
        r9 = r2;
        r4 = r15;
        goto L_0x01b6;
    L_0x0048:
        r15.beginTransaction();	 Catch:{ SQLiteFullException -> 0x0173, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x016d, all -> 0x0168 }
        r10 = "messages";	 Catch:{ SQLiteFullException -> 0x0173, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x016d, all -> 0x0168 }
        r0 = "rowid";	 Catch:{ SQLiteFullException -> 0x0173, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x016d, all -> 0x0168 }
        r9 = "type";	 Catch:{ SQLiteFullException -> 0x0173, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x016d, all -> 0x0168 }
        r11 = "entry";	 Catch:{ SQLiteFullException -> 0x0173, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x016d, all -> 0x0168 }
        r11 = new java.lang.String[]{r0, r9, r11};	 Catch:{ SQLiteFullException -> 0x0173, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x016d, all -> 0x0168 }
        r12 = 0;	 Catch:{ SQLiteFullException -> 0x0173, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x016d, all -> 0x0168 }
        r13 = 0;	 Catch:{ SQLiteFullException -> 0x0173, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x016d, all -> 0x0168 }
        r14 = 0;	 Catch:{ SQLiteFullException -> 0x0173, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x016d, all -> 0x0168 }
        r0 = 0;	 Catch:{ SQLiteFullException -> 0x0173, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x016d, all -> 0x0168 }
        r16 = "rowid asc";	 Catch:{ SQLiteFullException -> 0x0173, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x016d, all -> 0x0168 }
        r9 = 100;	 Catch:{ SQLiteFullException -> 0x0173, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x016d, all -> 0x0168 }
        r17 = java.lang.Integer.toString(r9);	 Catch:{ SQLiteFullException -> 0x0173, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x016d, all -> 0x0168 }
        r9 = r15;
        r4 = r15;
        r15 = r0;
        r9 = r9.query(r10, r11, r12, r13, r14, r15, r16, r17);	 Catch:{ SQLiteFullException -> 0x0166, SQLiteDatabaseLockedException -> 0x0171, SQLiteException -> 0x0164, all -> 0x0162 }
        r10 = -1;
    L_0x006c:
        r0 = r9.moveToNext();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        if (r0 == 0) goto L_0x0129;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x0072:
        r10 = r9.getLong(r5);	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r0 = r9.getInt(r8);	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r12 = 2;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r13 = r9.getBlob(r12);	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        if (r0 != 0) goto L_0x00b4;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x0081:
        r12 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r0 = r13.length;	 Catch:{ ParseException -> 0x009f }
        r12.unmarshall(r13, r5, r0);	 Catch:{ ParseException -> 0x009f }
        r12.setDataPosition(r5);	 Catch:{ ParseException -> 0x009f }
        r0 = com.google.android.gms.internal.measurement.zzeu.CREATOR;	 Catch:{ ParseException -> 0x009f }
        r0 = r0.createFromParcel(r12);	 Catch:{ ParseException -> 0x009f }
        r0 = (com.google.android.gms.internal.measurement.zzeu) r0;	 Catch:{ ParseException -> 0x009f }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        if (r0 == 0) goto L_0x006c;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x0099:
        r3.add(r0);	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        goto L_0x006c;
    L_0x009d:
        r0 = move-exception;
        goto L_0x00b0;
    L_0x009f:
        r0 = r19.zzge();	 Catch:{ all -> 0x009d }
        r0 = r0.zzim();	 Catch:{ all -> 0x009d }
        r13 = "Failed to load event from local database";	 Catch:{ all -> 0x009d }
        r0.log(r13);	 Catch:{ all -> 0x009d }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        goto L_0x006c;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x00b0:
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        throw r0;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x00b4:
        if (r0 != r8) goto L_0x00e7;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x00b6:
        r12 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r0 = r13.length;	 Catch:{ ParseException -> 0x00cf }
        r12.unmarshall(r13, r5, r0);	 Catch:{ ParseException -> 0x00cf }
        r12.setDataPosition(r5);	 Catch:{ ParseException -> 0x00cf }
        r0 = com.google.android.gms.internal.measurement.zzjx.CREATOR;	 Catch:{ ParseException -> 0x00cf }
        r0 = r0.createFromParcel(r12);	 Catch:{ ParseException -> 0x00cf }
        r0 = (com.google.android.gms.internal.measurement.zzjx) r0;	 Catch:{ ParseException -> 0x00cf }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        goto L_0x00e0;
    L_0x00cd:
        r0 = move-exception;
        goto L_0x00e3;
    L_0x00cf:
        r0 = r19.zzge();	 Catch:{ all -> 0x00cd }
        r0 = r0.zzim();	 Catch:{ all -> 0x00cd }
        r13 = "Failed to load user property from local database";	 Catch:{ all -> 0x00cd }
        r0.log(r13);	 Catch:{ all -> 0x00cd }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r0 = r2;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x00e0:
        if (r0 == 0) goto L_0x006c;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x00e2:
        goto L_0x0099;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x00e3:
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        throw r0;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x00e7:
        if (r0 != r12) goto L_0x011a;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x00e9:
        r12 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r0 = r13.length;	 Catch:{ ParseException -> 0x0102 }
        r12.unmarshall(r13, r5, r0);	 Catch:{ ParseException -> 0x0102 }
        r12.setDataPosition(r5);	 Catch:{ ParseException -> 0x0102 }
        r0 = com.google.android.gms.internal.measurement.zzed.CREATOR;	 Catch:{ ParseException -> 0x0102 }
        r0 = r0.createFromParcel(r12);	 Catch:{ ParseException -> 0x0102 }
        r0 = (com.google.android.gms.internal.measurement.zzed) r0;	 Catch:{ ParseException -> 0x0102 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        goto L_0x0113;
    L_0x0100:
        r0 = move-exception;
        goto L_0x0116;
    L_0x0102:
        r0 = r19.zzge();	 Catch:{ all -> 0x0100 }
        r0 = r0.zzim();	 Catch:{ all -> 0x0100 }
        r13 = "Failed to load user property from local database";	 Catch:{ all -> 0x0100 }
        r0.log(r13);	 Catch:{ all -> 0x0100 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r0 = r2;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x0113:
        if (r0 == 0) goto L_0x006c;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x0115:
        goto L_0x0099;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x0116:
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        throw r0;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x011a:
        r0 = r19.zzge();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r0 = r0.zzim();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r12 = "Unknown record type in local database";	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r0.log(r12);	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        goto L_0x006c;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x0129:
        r0 = "messages";	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r12 = "rowid <= ?";	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r13 = new java.lang.String[r8];	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r10 = java.lang.Long.toString(r10);	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r13[r5] = r10;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r0 = r4.delete(r0, r12, r13);	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r10 = r3.size();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        if (r0 >= r10) goto L_0x014c;	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x013f:
        r0 = r19.zzge();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r0 = r0.zzim();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r10 = "Fewer entries removed from local database than expected";	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r0.log(r10);	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
    L_0x014c:
        r4.setTransactionSuccessful();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        r4.endTransaction();	 Catch:{ SQLiteFullException -> 0x015f, SQLiteDatabaseLockedException -> 0x01a2, SQLiteException -> 0x015d }
        if (r9 == 0) goto L_0x0157;
    L_0x0154:
        r9.close();
    L_0x0157:
        if (r4 == 0) goto L_0x015c;
    L_0x0159:
        r4.close();
    L_0x015c:
        return r3;
    L_0x015d:
        r0 = move-exception;
        goto L_0x017e;
    L_0x015f:
        r0 = move-exception;
        goto L_0x01b6;
    L_0x0162:
        r0 = move-exception;
        goto L_0x016a;
    L_0x0164:
        r0 = move-exception;
        goto L_0x016f;
    L_0x0166:
        r0 = move-exception;
        goto L_0x0175;
    L_0x0168:
        r0 = move-exception;
        r4 = r15;
    L_0x016a:
        r9 = r2;
        goto L_0x01d3;
    L_0x016d:
        r0 = move-exception;
        r4 = r15;
    L_0x016f:
        r9 = r2;
        goto L_0x017e;
    L_0x0171:
        r9 = r2;
        goto L_0x01a2;
    L_0x0173:
        r0 = move-exception;
        r4 = r15;
    L_0x0175:
        r9 = r2;
        goto L_0x01b6;
    L_0x0177:
        r0 = move-exception;
        r4 = r2;
        r9 = r4;
        goto L_0x01d3;
    L_0x017b:
        r0 = move-exception;
        r4 = r2;
        r9 = r4;
    L_0x017e:
        if (r4 == 0) goto L_0x0189;
    L_0x0180:
        r10 = r4.inTransaction();	 Catch:{ all -> 0x01d2 }
        if (r10 == 0) goto L_0x0189;	 Catch:{ all -> 0x01d2 }
    L_0x0186:
        r4.endTransaction();	 Catch:{ all -> 0x01d2 }
    L_0x0189:
        r10 = r19.zzge();	 Catch:{ all -> 0x01d2 }
        r10 = r10.zzim();	 Catch:{ all -> 0x01d2 }
        r11 = "Error reading entries from local database";	 Catch:{ all -> 0x01d2 }
        r10.zzg(r11, r0);	 Catch:{ all -> 0x01d2 }
        r1.zzaih = r8;	 Catch:{ all -> 0x01d2 }
        if (r9 == 0) goto L_0x019d;
    L_0x019a:
        r9.close();
    L_0x019d:
        if (r4 == 0) goto L_0x01cd;
    L_0x019f:
        goto L_0x01af;
    L_0x01a0:
        r4 = r2;
        r9 = r4;
    L_0x01a2:
        r10 = (long) r7;
        android.os.SystemClock.sleep(r10);	 Catch:{ all -> 0x01d2 }
        r7 = r7 + 20;
        if (r9 == 0) goto L_0x01ad;
    L_0x01aa:
        r9.close();
    L_0x01ad:
        if (r4 == 0) goto L_0x01cd;
    L_0x01af:
        r4.close();
        goto L_0x01cd;
    L_0x01b3:
        r0 = move-exception;
        r4 = r2;
        r9 = r4;
    L_0x01b6:
        r10 = r19.zzge();	 Catch:{ all -> 0x01d2 }
        r10 = r10.zzim();	 Catch:{ all -> 0x01d2 }
        r11 = "Error reading entries from local database";	 Catch:{ all -> 0x01d2 }
        r10.zzg(r11, r0);	 Catch:{ all -> 0x01d2 }
        r1.zzaih = r8;	 Catch:{ all -> 0x01d2 }
        if (r9 == 0) goto L_0x01ca;
    L_0x01c7:
        r9.close();
    L_0x01ca:
        if (r4 == 0) goto L_0x01cd;
    L_0x01cc:
        goto L_0x01af;
    L_0x01cd:
        r6 = r6 + 1;
        r4 = 5;
        goto L_0x0025;
    L_0x01d2:
        r0 = move-exception;
    L_0x01d3:
        if (r9 == 0) goto L_0x01d8;
    L_0x01d5:
        r9.close();
    L_0x01d8:
        if (r4 == 0) goto L_0x01dd;
    L_0x01da:
        r4.close();
    L_0x01dd:
        throw r0;
    L_0x01de:
        r0 = r19.zzge();
        r0 = r0.zzip();
        r3 = "Failed to read events from database in reasonable time";
        r0.log(r3);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfc.zzp(int):java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>");
    }
}
