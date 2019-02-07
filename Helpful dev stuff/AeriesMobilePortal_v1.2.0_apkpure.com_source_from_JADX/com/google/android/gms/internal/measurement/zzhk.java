package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;
import com.google.android.gms.measurement.AppMeasurement.EventInterceptor;
import com.google.android.gms.measurement.AppMeasurement.OnEventListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzhk extends zzhh {
    @VisibleForTesting
    protected zzid zzanp;
    private EventInterceptor zzanq;
    private final Set<OnEventListener> zzanr = new CopyOnWriteArraySet();
    private boolean zzans;
    private final AtomicReference<String> zzant = new AtomicReference();
    @VisibleForTesting
    protected boolean zzanu = true;

    protected zzhk(zzgl com_google_android_gms_internal_measurement_zzgl) {
        super(com_google_android_gms_internal_measurement_zzgl);
    }

    private final void zza(ConditionalUserProperty conditionalUserProperty) {
        long currentTimeMillis = zzbt().currentTimeMillis();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (zzgb().zzcf(str) != 0) {
            zzge().zzim().zzg("Invalid conditional user property name", zzga().zzbl(str));
        } else if (zzgb().zzi(str, obj) != 0) {
            zzge().zzim().zze("Invalid conditional user property value", zzga().zzbl(str), obj);
        } else {
            Object zzj = zzgb().zzj(str, obj);
            if (zzj == null) {
                zzge().zzim().zze("Unable to normalize conditional user property value", zzga().zzbl(str), obj);
                return;
            }
            conditionalUserProperty.mValue = zzj;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j <= 15552000000L && j >= 1)) {
                j = conditionalUserProperty.mTimeToLive;
                if (j <= 15552000000L) {
                    if (j >= 1) {
                        zzgd().zzc(new zzhr(this, conditionalUserProperty));
                        return;
                    }
                }
                zzge().zzim().zze("Invalid conditional user property time to live", zzga().zzbl(str), Long.valueOf(j));
                return;
            }
            zzge().zzim().zze("Invalid conditional user property timeout", zzga().zzbl(str), Long.valueOf(j));
        }
    }

    private final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2;
        Bundle bundle3 = bundle;
        if (bundle3 == null) {
            bundle2 = new Bundle();
        } else {
            Bundle bundle4 = new Bundle(bundle3);
            for (String str4 : bundle4.keySet()) {
                Object obj = bundle4.get(str4);
                if (obj instanceof Bundle) {
                    bundle4.putBundle(str4, new Bundle((Bundle) obj));
                } else {
                    int i = 0;
                    if (obj instanceof Parcelable[]) {
                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                        while (i < parcelableArr.length) {
                            if (parcelableArr[i] instanceof Bundle) {
                                parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                            }
                            i++;
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) obj;
                        while (i < arrayList.size()) {
                            Object obj2 = arrayList.get(i);
                            if (obj2 instanceof Bundle) {
                                arrayList.set(i, new Bundle((Bundle) obj2));
                            }
                            i++;
                        }
                    }
                }
            }
            bundle2 = bundle4;
        }
        zzgd().zzc(new zzic(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzgd().zzc(new zzhm(this, str, str2, obj, j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zza(str, str2, zzbt().currentTimeMillis(), bundle, true, z2, z3, null);
    }

    @WorkerThread
    private final void zza(String str, String str2, Object obj, long j) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        if (!this.zzacw.isEnabled()) {
            zzge().zzis().log("User property not set since app measurement is disabled");
        } else if (this.zzacw.zzjv()) {
            zzge().zzis().zze("Setting user property (FE)", zzga().zzbj(str2), obj);
            zzfx().zzb(new zzjx(str2, j, obj, str));
        }
    }

    private final void zza(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzbt().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        zzgd().zzc(new zzhs(this, conditionalUserProperty));
    }

    @VisibleForTesting
    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        zzfi zzim;
        if (zzgd().zzjk()) {
            zzim = zzge().zzim();
            str2 = "Cannot get user properties from analytics worker thread";
        } else {
            zzgd();
            if (zzgg.isMainThread()) {
                zzim = zzge().zzim();
                str2 = "Cannot get user properties from main thread";
            } else {
                AtomicReference atomicReference = new AtomicReference();
                synchronized (atomicReference) {
                    this.zzacw.zzgd().zzc(new zzhu(this, atomicReference, str, str2, str3, z));
                    try {
                        atomicReference.wait(5000);
                    } catch (InterruptedException e) {
                        zzge().zzip().zzg("Interrupted waiting for get user properties", e);
                    }
                }
                List<zzjx> list = (List) atomicReference.get();
                if (list == null) {
                    zzim = zzge().zzip();
                    str2 = "Timed out waiting for get user properties";
                } else {
                    Map<String, Object> arrayMap = new ArrayMap(list.size());
                    for (zzjx com_google_android_gms_internal_measurement_zzjx : list) {
                        arrayMap.put(com_google_android_gms_internal_measurement_zzjx.name, com_google_android_gms_internal_measurement_zzjx.getValue());
                    }
                    return arrayMap;
                }
            }
        }
        zzim.log(str2);
        return Collections.emptyMap();
    }

    @android.support.annotation.WorkerThread
    private final void zzb(com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty r22) {
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
        r21 = this;
        r0 = r22;
        r21.zzab();
        r21.zzch();
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r22);
        r1 = r0.mName;
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1);
        r1 = r0.mOrigin;
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1);
        r1 = r0.mValue;
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r1);
        r1 = r21;
        r2 = r1.zzacw;
        r2 = r2.isEnabled();
        if (r2 != 0) goto L_0x0032;
    L_0x0024:
        r0 = r21.zzge();
        r0 = r0.zzis();
        r2 = "Conditional property not sent since Firebase Analytics is disabled";
        r0.log(r2);
        return;
    L_0x0032:
        r2 = new com.google.android.gms.internal.measurement.zzjx;
        r4 = r0.mName;
        r5 = r0.mTriggeredTimestamp;
        r7 = r0.mValue;
        r8 = r0.mOrigin;
        r3 = r2;
        r3.<init>(r4, r5, r7, r8);
        r9 = r21.zzgb();	 Catch:{ IllegalArgumentException -> 0x009c }
        r10 = r0.mTriggeredEventName;	 Catch:{ IllegalArgumentException -> 0x009c }
        r11 = r0.mTriggeredEventParams;	 Catch:{ IllegalArgumentException -> 0x009c }
        r12 = r0.mOrigin;	 Catch:{ IllegalArgumentException -> 0x009c }
        r13 = 0;	 Catch:{ IllegalArgumentException -> 0x009c }
        r15 = 1;	 Catch:{ IllegalArgumentException -> 0x009c }
        r16 = 0;	 Catch:{ IllegalArgumentException -> 0x009c }
        r14 = r9.zza(r10, r11, r12, r13, r15, r16);	 Catch:{ IllegalArgumentException -> 0x009c }
        r3 = r21.zzgb();	 Catch:{ IllegalArgumentException -> 0x009c }
        r4 = r0.mTimedOutEventName;	 Catch:{ IllegalArgumentException -> 0x009c }
        r5 = r0.mTimedOutEventParams;	 Catch:{ IllegalArgumentException -> 0x009c }
        r6 = r0.mOrigin;	 Catch:{ IllegalArgumentException -> 0x009c }
        r7 = 0;	 Catch:{ IllegalArgumentException -> 0x009c }
        r9 = 1;	 Catch:{ IllegalArgumentException -> 0x009c }
        r10 = 0;	 Catch:{ IllegalArgumentException -> 0x009c }
        r11 = r3.zza(r4, r5, r6, r7, r9, r10);	 Catch:{ IllegalArgumentException -> 0x009c }
        r3 = r21.zzgb();	 Catch:{ IllegalArgumentException -> 0x009c }
        r4 = r0.mExpiredEventName;	 Catch:{ IllegalArgumentException -> 0x009c }
        r5 = r0.mExpiredEventParams;	 Catch:{ IllegalArgumentException -> 0x009c }
        r6 = r0.mOrigin;	 Catch:{ IllegalArgumentException -> 0x009c }
        r7 = 0;	 Catch:{ IllegalArgumentException -> 0x009c }
        r9 = 1;	 Catch:{ IllegalArgumentException -> 0x009c }
        r10 = 0;	 Catch:{ IllegalArgumentException -> 0x009c }
        r17 = r3.zza(r4, r5, r6, r7, r9, r10);	 Catch:{ IllegalArgumentException -> 0x009c }
        r15 = new com.google.android.gms.internal.measurement.zzed;
        r4 = r0.mAppId;
        r5 = r0.mOrigin;
        r7 = r0.mCreationTimestamp;
        r10 = r0.mTriggerEventName;
        r12 = r0.mTriggerTimeout;
        r18 = r10;
        r9 = r0.mTimeToLive;
        r3 = r15;
        r6 = r2;
        r19 = r9;
        r0 = 0;
        r9 = r0;
        r10 = r18;
        r0 = r15;
        r15 = r19;
        r3.<init>(r4, r5, r6, r7, r9, r10, r11, r12, r14, r15, r17);
        r2 = r21.zzfx();
        r2.zzd(r0);
    L_0x009c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhk.zzb(com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty):void");
    }

    @android.support.annotation.WorkerThread
    private final void zzb(java.lang.String r28, java.lang.String r29, long r30, android.os.Bundle r32, boolean r33, boolean r34, boolean r35, java.lang.String r36) {
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
        r27 = this;
        r1 = r27;
        r8 = r28;
        r9 = r29;
        r10 = r32;
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28);
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r32);
        r27.zzab();
        r27.zzch();
        r0 = r1.zzacw;
        r0 = r0.isEnabled();
        if (r0 != 0) goto L_0x002d;
    L_0x001f:
        r0 = r27.zzge();
        r0 = r0.zzis();
        r2 = "Event not sent since app measurement is disabled";
        r0.log(r2);
        return;
    L_0x002d:
        r0 = r1.zzans;
        r12 = 0;
        r13 = 0;
        r14 = 1;
        if (r0 != 0) goto L_0x0070;
    L_0x0034:
        r1.zzans = r14;
        r0 = "com.google.android.gms.tagmanager.TagManagerService";	 Catch:{ ClassNotFoundException -> 0x0063 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0063 }
        r3 = "initialize";	 Catch:{ Exception -> 0x0054 }
        r4 = new java.lang.Class[r14];	 Catch:{ Exception -> 0x0054 }
        r5 = android.content.Context.class;	 Catch:{ Exception -> 0x0054 }
        r4[r13] = r5;	 Catch:{ Exception -> 0x0054 }
        r0 = r0.getDeclaredMethod(r3, r4);	 Catch:{ Exception -> 0x0054 }
        r3 = new java.lang.Object[r14];	 Catch:{ Exception -> 0x0054 }
        r4 = r27.getContext();	 Catch:{ Exception -> 0x0054 }
        r3[r13] = r4;	 Catch:{ Exception -> 0x0054 }
        r0.invoke(r12, r3);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0070;
    L_0x0054:
        r0 = move-exception;
        r3 = r27.zzge();	 Catch:{ ClassNotFoundException -> 0x0063 }
        r3 = r3.zzip();	 Catch:{ ClassNotFoundException -> 0x0063 }
        r4 = "Failed to invoke Tag Manager's initialize() method";	 Catch:{ ClassNotFoundException -> 0x0063 }
        r3.zzg(r4, r0);	 Catch:{ ClassNotFoundException -> 0x0063 }
        goto L_0x0070;
    L_0x0063:
        r0 = r27.zzge();
        r0 = r0.zzir();
        r3 = "Tag Manager is not found and thus will not be used";
        r0.log(r3);
    L_0x0070:
        r0 = 40;
        if (r35 == 0) goto L_0x00d6;
    L_0x0074:
        r3 = "_iap";
        r3 = r3.equals(r9);
        if (r3 != 0) goto L_0x00d6;
    L_0x007c:
        r3 = r1.zzacw;
        r3 = r3.zzgb();
        r4 = "event";
        r4 = r3.zzq(r4, r9);
        r5 = 2;
        if (r4 != 0) goto L_0x008c;
    L_0x008b:
        goto L_0x00a4;
    L_0x008c:
        r4 = "event";
        r6 = com.google.android.gms.measurement.AppMeasurement.Event.zzacx;
        r4 = r3.zza(r4, r6, r9);
        if (r4 != 0) goto L_0x009a;
    L_0x0096:
        r3 = 13;
        r5 = r3;
        goto L_0x00a4;
    L_0x009a:
        r4 = "event";
        r3 = r3.zza(r4, r0, r9);
        if (r3 != 0) goto L_0x00a3;
    L_0x00a2:
        goto L_0x00a4;
    L_0x00a3:
        r5 = r13;
    L_0x00a4:
        if (r5 == 0) goto L_0x00d6;
    L_0x00a6:
        r2 = r27.zzge();
        r2 = r2.zzio();
        r3 = "Invalid public event name. Event will not be logged (FE)";
        r4 = r27.zzga();
        r4 = r4.zzbj(r9);
        r2.zzg(r3, r4);
        r2 = r1.zzacw;
        r2.zzgb();
        r0 = com.google.android.gms.internal.measurement.zzka.zza(r9, r0, r14);
        if (r9 == 0) goto L_0x00ca;
    L_0x00c6:
        r13 = r29.length();
    L_0x00ca:
        r2 = r1.zzacw;
        r2 = r2.zzgb();
        r3 = "_ev";
        r2.zza(r5, r3, r0, r13);
        return;
    L_0x00d6:
        r3 = r27.zzfy();
        r15 = r3.zzkc();
        if (r15 == 0) goto L_0x00ea;
    L_0x00e0:
        r3 = "_sc";
        r3 = r10.containsKey(r3);
        if (r3 != 0) goto L_0x00ea;
    L_0x00e8:
        r15.zzaok = r14;
    L_0x00ea:
        if (r33 == 0) goto L_0x00f0;
    L_0x00ec:
        if (r35 == 0) goto L_0x00f0;
    L_0x00ee:
        r3 = r14;
        goto L_0x00f1;
    L_0x00f0:
        r3 = r13;
    L_0x00f1:
        com.google.android.gms.internal.measurement.zzif.zza(r15, r10, r3);
        r3 = "am";
        r16 = r3.equals(r8);
        r3 = com.google.android.gms.internal.measurement.zzka.zzci(r29);
        if (r33 == 0) goto L_0x0133;
    L_0x0100:
        r2 = r1.zzanq;
        if (r2 == 0) goto L_0x0133;
    L_0x0104:
        if (r3 != 0) goto L_0x0133;
    L_0x0106:
        if (r16 != 0) goto L_0x0133;
    L_0x0108:
        r0 = r27.zzge();
        r0 = r0.zzis();
        r2 = "Passing event to registered event handler (FE)";
        r3 = r27.zzga();
        r3 = r3.zzbj(r9);
        r4 = r27.zzga();
        r4 = r4.zzb(r10);
        r0.zze(r2, r3, r4);
        r2 = r1.zzanq;
        r3 = r28;
        r4 = r29;
        r5 = r32;
        r6 = r30;
        r2.interceptEvent(r3, r4, r5, r6);
        return;
    L_0x0133:
        r2 = r1.zzacw;
        r2 = r2.zzjv();
        if (r2 != 0) goto L_0x013c;
    L_0x013b:
        return;
    L_0x013c:
        r2 = r27.zzgb();
        r5 = r2.zzcd(r9);
        if (r5 == 0) goto L_0x0177;
    L_0x0146:
        r2 = r27.zzge();
        r2 = r2.zzio();
        r3 = "Invalid event name. Event will not be logged (FE)";
        r4 = r27.zzga();
        r4 = r4.zzbj(r9);
        r2.zzg(r3, r4);
        r27.zzgb();
        r7 = com.google.android.gms.internal.measurement.zzka.zza(r9, r0, r14);
        if (r9 == 0) goto L_0x0168;
    L_0x0164:
        r13 = r29.length();
    L_0x0168:
        r8 = r13;
        r0 = r1.zzacw;
        r3 = r0.zzgb();
        r6 = "_ev";
        r4 = r36;
        r3.zza(r4, r5, r6, r7, r8);
        return;
    L_0x0177:
        r0 = "_o";
        r2 = "_sn";
        r3 = "_sc";
        r4 = "_si";
        r0 = new java.lang.String[]{r0, r2, r3, r4};
        r0 = com.google.android.gms.common.util.CollectionUtils.listOf(r0);
        r2 = r27.zzgb();
        r7 = 1;
        r3 = r29;
        r4 = r32;
        r5 = r0;
        r6 = r35;
        r7 = r2.zza(r3, r4, r5, r6, r7);
        if (r7 == 0) goto L_0x01c9;
    L_0x0199:
        r2 = "_sc";
        r2 = r7.containsKey(r2);
        if (r2 == 0) goto L_0x01c9;
    L_0x01a1:
        r2 = "_si";
        r2 = r7.containsKey(r2);
        if (r2 != 0) goto L_0x01aa;
    L_0x01a9:
        goto L_0x01c9;
    L_0x01aa:
        r2 = "_sn";
        r2 = r7.getString(r2);
        r3 = "_sc";
        r3 = r7.getString(r3);
        r4 = "_si";
        r4 = r7.getLong(r4);
        r4 = java.lang.Long.valueOf(r4);
        r12 = new com.google.android.gms.internal.measurement.zzie;
        r4 = r4.longValue();
        r12.<init>(r2, r3, r4);
    L_0x01c9:
        if (r12 != 0) goto L_0x01cc;
    L_0x01cb:
        r12 = r15;
    L_0x01cc:
        r15 = new java.util.ArrayList;
        r15.<init>();
        r15.add(r7);
        r2 = r27.zzgb();
        r2 = r2.zzlc();
        r5 = r2.nextLong();
        r2 = r7.keySet();
        r3 = r32.size();
        r3 = new java.lang.String[r3];
        r2 = r2.toArray(r3);
        r10 = r2;
        r10 = (java.lang.String[]) r10;
        java.util.Arrays.sort(r10);
        r4 = r10.length;
        r2 = r13;
        r3 = r2;
    L_0x01f7:
        if (r3 >= r4) goto L_0x0292;
    L_0x01f9:
        r13 = r10[r3];
        r14 = r7.get(r13);
        r27.zzgb();
        r14 = com.google.android.gms.internal.measurement.zzka.zze(r14);
        if (r14 == 0) goto L_0x027d;
    L_0x0208:
        r17 = r2;
        r2 = r14.length;
        r7.putInt(r13, r2);
        r18 = r3;
        r2 = 0;
    L_0x0211:
        r3 = r14.length;
        if (r2 >= r3) goto L_0x026e;
    L_0x0214:
        r3 = r14[r2];
        r19 = r2;
        r2 = 1;
        com.google.android.gms.internal.measurement.zzif.zza(r12, r3, r2);
        r2 = r27.zzgb();
        r20 = "_ep";
        r21 = 0;
        r22 = r17;
        r23 = r19;
        r17 = r18;
        r18 = r3;
        r3 = r20;
        r19 = r4;
        r4 = r18;
        r24 = r5;
        r5 = r0;
        r6 = r35;
        r26 = r0;
        r0 = r7;
        r7 = r21;
        r2 = r2.zza(r3, r4, r5, r6, r7);
        r3 = "_en";
        r2.putString(r3, r9);
        r3 = "_eid";
        r4 = r24;
        r2.putLong(r3, r4);
        r3 = "_gn";
        r2.putString(r3, r13);
        r3 = "_ll";
        r6 = r14.length;
        r2.putInt(r3, r6);
        r3 = "_i";
        r6 = r23;
        r2.putInt(r3, r6);
        r15.add(r2);
        r2 = r6 + 1;
        r7 = r0;
        r5 = r4;
        r18 = r17;
        r4 = r19;
        r17 = r22;
        r0 = r26;
        goto L_0x0211;
    L_0x026e:
        r26 = r0;
        r19 = r4;
        r4 = r5;
        r0 = r7;
        r22 = r17;
        r17 = r18;
        r2 = r14.length;
        r13 = r22;
        r2 = r2 + r13;
        goto L_0x0286;
    L_0x027d:
        r26 = r0;
        r13 = r2;
        r17 = r3;
        r19 = r4;
        r4 = r5;
        r0 = r7;
    L_0x0286:
        r3 = r17 + 1;
        r7 = r0;
        r5 = r4;
        r4 = r19;
        r0 = r26;
        r13 = 0;
        r14 = 1;
        goto L_0x01f7;
    L_0x0292:
        r13 = r2;
        r4 = r5;
        r0 = r7;
        if (r13 == 0) goto L_0x02a1;
    L_0x0297:
        r2 = "_eid";
        r0.putLong(r2, r4);
        r2 = "_epc";
        r0.putInt(r2, r13);
    L_0x02a1:
        r0 = 0;
    L_0x02a2:
        r2 = r15.size();
        if (r0 >= r2) goto L_0x0325;
    L_0x02a8:
        r2 = r15.get(r0);
        r2 = (android.os.Bundle) r2;
        if (r0 == 0) goto L_0x02b2;
    L_0x02b0:
        r3 = 1;
        goto L_0x02b3;
    L_0x02b2:
        r3 = 0;
    L_0x02b3:
        if (r3 == 0) goto L_0x02b8;
    L_0x02b5:
        r3 = "_ep";
        goto L_0x02b9;
    L_0x02b8:
        r3 = r9;
    L_0x02b9:
        r4 = "_o";
        r2.putString(r4, r8);
        if (r34 == 0) goto L_0x02c8;
    L_0x02c0:
        r4 = r27.zzgb();
        r2 = r4.zzd(r2);
    L_0x02c8:
        r11 = r2;
        r2 = r27.zzge();
        r2 = r2.zzis();
        r4 = "Logging event (FE)";
        r5 = r27.zzga();
        r5 = r5.zzbj(r9);
        r6 = r27.zzga();
        r6 = r6.zzb(r11);
        r2.zze(r4, r5, r6);
        r12 = new com.google.android.gms.internal.measurement.zzeu;
        r4 = new com.google.android.gms.internal.measurement.zzer;
        r4.<init>(r11);
        r2 = r12;
        r5 = r28;
        r6 = r30;
        r2.<init>(r3, r4, r5, r6);
        r2 = r27.zzfx();
        r13 = r36;
        r2.zzb(r12, r13);
        if (r16 != 0) goto L_0x0321;
    L_0x0300:
        r2 = r1.zzanr;
        r12 = r2.iterator();
    L_0x0306:
        r2 = r12.hasNext();
        if (r2 == 0) goto L_0x0321;
    L_0x030c:
        r2 = r12.next();
        r2 = (com.google.android.gms.measurement.AppMeasurement.OnEventListener) r2;
        r5 = new android.os.Bundle;
        r5.<init>(r11);
        r3 = r28;
        r4 = r29;
        r6 = r30;
        r2.onEvent(r3, r4, r5, r6);
        goto L_0x0306;
    L_0x0321:
        r0 = r0 + 1;
        goto L_0x02a2;
    L_0x0325:
        r0 = r27.zzfy();
        r0 = r0.zzkc();
        if (r0 == 0) goto L_0x033f;
    L_0x032f:
        r0 = "_ae";
        r0 = r0.equals(r9);
        if (r0 == 0) goto L_0x033f;
    L_0x0337:
        r0 = r27.zzgc();
        r2 = 1;
        r0.zzl(r2);
    L_0x033f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhk.zzb(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    @android.support.annotation.WorkerThread
    private final void zzc(com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty r23) {
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
        r22 = this;
        r0 = r23;
        r22.zzab();
        r22.zzch();
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r23);
        r1 = r0.mName;
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1);
        r1 = r22;
        r2 = r1.zzacw;
        r2 = r2.isEnabled();
        if (r2 != 0) goto L_0x0028;
    L_0x001a:
        r0 = r22.zzge();
        r0 = r0.zzis();
        r2 = "Conditional property not cleared since Firebase Analytics is disabled";
        r0.log(r2);
        return;
    L_0x0028:
        r2 = new com.google.android.gms.internal.measurement.zzjx;
        r4 = r0.mName;
        r5 = 0;
        r7 = 0;
        r8 = 0;
        r3 = r2;
        r3.<init>(r4, r5, r7, r8);
        r9 = r22.zzgb();	 Catch:{ IllegalArgumentException -> 0x006f }
        r10 = r0.mExpiredEventName;	 Catch:{ IllegalArgumentException -> 0x006f }
        r11 = r0.mExpiredEventParams;	 Catch:{ IllegalArgumentException -> 0x006f }
        r12 = r0.mOrigin;	 Catch:{ IllegalArgumentException -> 0x006f }
        r13 = r0.mCreationTimestamp;	 Catch:{ IllegalArgumentException -> 0x006f }
        r15 = 1;	 Catch:{ IllegalArgumentException -> 0x006f }
        r16 = 0;	 Catch:{ IllegalArgumentException -> 0x006f }
        r17 = r9.zza(r10, r11, r12, r13, r15, r16);	 Catch:{ IllegalArgumentException -> 0x006f }
        r15 = new com.google.android.gms.internal.measurement.zzed;
        r4 = r0.mAppId;
        r5 = r0.mOrigin;
        r7 = r0.mCreationTimestamp;
        r9 = r0.mActive;
        r10 = r0.mTriggerEventName;
        r12 = r0.mTriggerTimeout;
        r14 = 0;
        r18 = r12;
        r11 = r0.mTimeToLive;
        r3 = r15;
        r6 = r2;
        r20 = r11;
        r0 = 0;
        r11 = r0;
        r12 = r18;
        r0 = r15;
        r15 = r20;
        r3.<init>(r4, r5, r6, r7, r9, r10, r11, r12, r14, r15, r17);
        r2 = r22.zzfx();
        r2.zzd(r0);
    L_0x006f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhk.zzc(com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty):void");
    }

    @VisibleForTesting
    private final List<ConditionalUserProperty> zzf(String str, String str2, String str3) {
        zzfi zzim;
        if (zzgd().zzjk()) {
            zzim = zzge().zzim();
            str2 = "Cannot get conditional user properties from analytics worker thread";
        } else {
            zzgd();
            if (zzgg.isMainThread()) {
                zzim = zzge().zzim();
                str2 = "Cannot get conditional user properties from main thread";
            } else {
                AtomicReference atomicReference = new AtomicReference();
                synchronized (atomicReference) {
                    this.zzacw.zzgd().zzc(new zzht(this, atomicReference, str, str2, str3));
                    try {
                        atomicReference.wait(5000);
                    } catch (InterruptedException e) {
                        zzge().zzip().zze("Interrupted waiting for get conditional user properties", str, e);
                    }
                }
                List<zzed> list = (List) atomicReference.get();
                if (list == null) {
                    zzge().zzip().zzg("Timed out waiting for get conditional user properties", str);
                    return Collections.emptyList();
                }
                List<ConditionalUserProperty> arrayList = new ArrayList(list.size());
                for (zzed com_google_android_gms_internal_measurement_zzed : list) {
                    ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
                    conditionalUserProperty.mAppId = str;
                    conditionalUserProperty.mOrigin = str2;
                    conditionalUserProperty.mCreationTimestamp = com_google_android_gms_internal_measurement_zzed.creationTimestamp;
                    conditionalUserProperty.mName = com_google_android_gms_internal_measurement_zzed.zzaep.name;
                    conditionalUserProperty.mValue = com_google_android_gms_internal_measurement_zzed.zzaep.getValue();
                    conditionalUserProperty.mActive = com_google_android_gms_internal_measurement_zzed.active;
                    conditionalUserProperty.mTriggerEventName = com_google_android_gms_internal_measurement_zzed.triggerEventName;
                    if (com_google_android_gms_internal_measurement_zzed.zzaeq != null) {
                        conditionalUserProperty.mTimedOutEventName = com_google_android_gms_internal_measurement_zzed.zzaeq.name;
                        if (com_google_android_gms_internal_measurement_zzed.zzaeq.zzafq != null) {
                            conditionalUserProperty.mTimedOutEventParams = com_google_android_gms_internal_measurement_zzed.zzaeq.zzafq.zzif();
                        }
                    }
                    conditionalUserProperty.mTriggerTimeout = com_google_android_gms_internal_measurement_zzed.triggerTimeout;
                    if (com_google_android_gms_internal_measurement_zzed.zzaer != null) {
                        conditionalUserProperty.mTriggeredEventName = com_google_android_gms_internal_measurement_zzed.zzaer.name;
                        if (com_google_android_gms_internal_measurement_zzed.zzaer.zzafq != null) {
                            conditionalUserProperty.mTriggeredEventParams = com_google_android_gms_internal_measurement_zzed.zzaer.zzafq.zzif();
                        }
                    }
                    conditionalUserProperty.mTriggeredTimestamp = com_google_android_gms_internal_measurement_zzed.zzaep.zzaqz;
                    conditionalUserProperty.mTimeToLive = com_google_android_gms_internal_measurement_zzed.timeToLive;
                    if (com_google_android_gms_internal_measurement_zzed.zzaes != null) {
                        conditionalUserProperty.mExpiredEventName = com_google_android_gms_internal_measurement_zzed.zzaes.name;
                        if (com_google_android_gms_internal_measurement_zzed.zzaes.zzafq != null) {
                            conditionalUserProperty.mExpiredEventParams = com_google_android_gms_internal_measurement_zzed.zzaes.zzafq.zzif();
                        }
                    }
                    arrayList.add(conditionalUserProperty);
                }
                return arrayList;
            }
        }
        zzim.log(str2);
        return Collections.emptyList();
    }

    @WorkerThread
    private final void zzi(boolean z) {
        zzab();
        zzch();
        zzge().zzis().zzg("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzgf().setMeasurementEnabled(z);
        if (!zzgg().zzaz(zzfv().zzah())) {
            zzfx().zzke();
        } else if (this.zzacw.isEnabled() && this.zzanu) {
            zzge().zzis().log("Recording app launch after enabling measurement for the first time (FE)");
            zzkb();
        } else {
            zzfx().zzke();
        }
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zza(null, str, str2, bundle);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zzfr();
        zza(str, str2, str3, bundle);
    }

    public final Task<String> getAppInstanceId() {
        try {
            String zzja = zzgf().zzja();
            return zzja != null ? Tasks.forResult(zzja) : Tasks.call(zzgd().zzjl(), new zzho(this));
        } catch (Exception e) {
            zzge().zzip().log("Failed to schedule task for getAppInstanceId");
            return Tasks.forException(e);
        }
    }

    public final List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return zzf(null, str, str2);
    }

    public final List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzfr();
        return zzf(str, str2, str3);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return zzb(null, str, str2, z);
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zzfr();
        return zzb(str, str2, str3, z);
    }

    public final void logEvent(String str, String str2, Bundle bundle) {
        boolean z;
        if (this.zzanq != null) {
            if (!zzka.zzci(str2)) {
                z = false;
                zza(str, str2, bundle, true, z, false, null);
            }
        }
        z = true;
        zza(str, str2, bundle, true, z, false, null);
    }

    public final void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        zzch();
        Preconditions.checkNotNull(onEventListener);
        if (!this.zzanr.add(onEventListener)) {
            zzge().zzip().log("OnEventListener already registered");
        }
    }

    public final void resetAnalyticsData() {
        zzgd().zzc(new zzhq(this, zzbt().currentTimeMillis()));
    }

    public final void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        ConditionalUserProperty conditionalUserProperty2 = new ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            zzge().zzip().log("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        zza(conditionalUserProperty2);
    }

    public final void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mAppId);
        zzfr();
        zza(new ConditionalUserProperty(conditionalUserProperty));
    }

    @WorkerThread
    public final void setEventInterceptor(EventInterceptor eventInterceptor) {
        zzab();
        zzch();
        if (!(eventInterceptor == null || eventInterceptor == this.zzanq)) {
            Preconditions.checkState(this.zzanq == null, "EventInterceptor already set.");
        }
        this.zzanq = eventInterceptor;
    }

    public final void setMeasurementEnabled(boolean z) {
        zzch();
        zzgd().zzc(new zzhz(this, z));
    }

    public final void setMinimumSessionDuration(long j) {
        zzgd().zzc(new zzia(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zzgd().zzc(new zzib(this, j));
    }

    public final void setUserProperty(String str, String str2, Object obj) {
        Preconditions.checkNotEmpty(str);
        long currentTimeMillis = zzbt().currentTimeMillis();
        int zzcf = zzgb().zzcf(str2);
        int i = 0;
        if (zzcf != 0) {
            zzgb();
            str = zzka.zza(str2, 24, true);
            if (str2 != null) {
                i = str2.length();
            }
            this.zzacw.zzgb().zza(zzcf, "_ev", str, i);
        } else if (obj != null) {
            zzcf = zzgb().zzi(str2, obj);
            if (zzcf != 0) {
                zzgb();
                str = zzka.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.zzacw.zzgb().zza(zzcf, "_ev", str, i);
                return;
            }
            Object zzj = zzgb().zzj(str2, obj);
            if (zzj != null) {
                zza(str, str2, currentTimeMillis, zzj);
            }
        } else {
            zza(str, str2, currentTimeMillis, null);
        }
    }

    public final void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        zzch();
        Preconditions.checkNotNull(onEventListener);
        if (!this.zzanr.remove(onEventListener)) {
            zzge().zzip().log("OnEventListener had not been registered");
        }
    }

    @WorkerThread
    final void zza(String str, String str2, Bundle bundle) {
        boolean z;
        String str3;
        String str4;
        zzab();
        if (this.zzanq != null) {
            if (!zzka.zzci(str2)) {
                z = false;
                str3 = str;
                str4 = str2;
                zzb(str3, str4, zzbt().currentTimeMillis(), bundle, true, z, false, null);
            }
        }
        z = true;
        str3 = str;
        str4 = str2;
        zzb(str3, str4, zzbt().currentTimeMillis(), bundle, true, z, false, null);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, j, bundle, false, true, true, null);
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        if (this.zzanq != null) {
            if (!zzka.zzci(str2)) {
                z = false;
                zza(str, str2, bundle, true, z, true, null);
            }
        }
        z = true;
        zza(str, str2, bundle, true, z, true, null);
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    @android.support.annotation.Nullable
    final java.lang.String zzae(long r4) {
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
        r0 = new java.util.concurrent.atomic.AtomicReference;
        r0.<init>();
        monitor-enter(r0);
        r1 = r3.zzgd();	 Catch:{ all -> 0x002d }
        r2 = new com.google.android.gms.internal.measurement.zzhp;	 Catch:{ all -> 0x002d }
        r2.<init>(r3, r0);	 Catch:{ all -> 0x002d }
        r1.zzc(r2);	 Catch:{ all -> 0x002d }
        r0.wait(r4);	 Catch:{ InterruptedException -> 0x001d }
        monitor-exit(r0);	 Catch:{ all -> 0x002d }
        r4 = r0.get();
        r4 = (java.lang.String) r4;
        return r4;
    L_0x001d:
        r4 = r3.zzge();	 Catch:{ all -> 0x002d }
        r4 = r4.zzip();	 Catch:{ all -> 0x002d }
        r5 = "Interrupted waiting for app instance id";	 Catch:{ all -> 0x002d }
        r4.log(r5);	 Catch:{ all -> 0x002d }
        r4 = 0;	 Catch:{ all -> 0x002d }
        monitor-exit(r0);	 Catch:{ all -> 0x002d }
        return r4;	 Catch:{ all -> 0x002d }
    L_0x002d:
        r4 = move-exception;	 Catch:{ all -> 0x002d }
        monitor-exit(r0);	 Catch:{ all -> 0x002d }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhk.zzae(long):java.lang.String");
    }

    final void zzbr(@Nullable String str) {
        this.zzant.set(str);
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
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

    public final String zzhm() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzgd().zza(atomicReference, 15000, "String test flag value", new zzhv(this, atomicReference));
    }

    public final List<zzjx> zzj(boolean z) {
        zzfi zzim;
        String str;
        zzch();
        zzge().zzis().log("Fetching user attributes (FE)");
        if (zzgd().zzjk()) {
            zzim = zzge().zzim();
            str = "Cannot get all user properties from analytics worker thread";
        } else {
            zzgd();
            if (zzgg.isMainThread()) {
                zzim = zzge().zzim();
                str = "Cannot get all user properties from main thread";
            } else {
                AtomicReference atomicReference = new AtomicReference();
                synchronized (atomicReference) {
                    this.zzacw.zzgd().zzc(new zzhn(this, atomicReference, z));
                    try {
                        atomicReference.wait(5000);
                    } catch (InterruptedException e) {
                        zzge().zzip().zzg("Interrupted waiting for get user properties", e);
                    }
                }
                List<zzjx> list = (List) atomicReference.get();
                if (list != null) {
                    return list;
                }
                zzim = zzge().zzip();
                str = "Timed out waiting for get user properties";
            }
        }
        zzim.log(str);
        return Collections.emptyList();
    }

    @Nullable
    public final String zzja() {
        return (String) this.zzant.get();
    }

    public final Boolean zzjx() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzgd().zza(atomicReference, 15000, "boolean test flag value", new zzhl(this, atomicReference));
    }

    public final Long zzjy() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzgd().zza(atomicReference, 15000, "long test flag value", new zzhw(this, atomicReference));
    }

    public final Integer zzjz() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzgd().zza(atomicReference, 15000, "int test flag value", new zzhx(this, atomicReference));
    }

    public final Double zzka() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzgd().zza(atomicReference, 15000, "double test flag value", new zzhy(this, atomicReference));
    }

    @WorkerThread
    public final void zzkb() {
        zzab();
        zzch();
        if (this.zzacw.zzjv()) {
            zzfx().zzkb();
            this.zzanu = false;
            String zzjd = zzgf().zzjd();
            if (!TextUtils.isEmpty(zzjd)) {
                zzfw().zzch();
                if (!zzjd.equals(VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzjd);
                    logEvent("auto", "_ou", bundle);
                }
            }
        }
    }
}
