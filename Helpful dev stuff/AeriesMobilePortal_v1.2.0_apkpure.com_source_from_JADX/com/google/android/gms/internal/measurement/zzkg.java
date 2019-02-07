package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkg extends zzaby<zzkg> {
    public Integer zzarz;
    public Boolean zzasa;
    public String zzasb;
    public String zzasc;
    public String zzasd;

    public zzkg() {
        this.zzarz = null;
        this.zzasa = null;
        this.zzasb = null;
        this.zzasc = null;
        this.zzasd = null;
        this.zzbww = null;
        this.zzbxh = -1;
    }

    private final com.google.android.gms.internal.measurement.zzkg zzd(com.google.android.gms.internal.measurement.zzabv r7) throws java.io.IOException {
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
        r6 = this;
    L_0x0000:
        r0 = r7.zzuw();
        if (r0 == 0) goto L_0x0075;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x0041;
    L_0x000a:
        r1 = 16;
        if (r0 == r1) goto L_0x0036;
    L_0x000e:
        r1 = 26;
        if (r0 == r1) goto L_0x002f;
    L_0x0012:
        r1 = 34;
        if (r0 == r1) goto L_0x0028;
    L_0x0016:
        r1 = 42;
        if (r0 == r1) goto L_0x0021;
    L_0x001a:
        r0 = super.zza(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0020:
        return r6;
    L_0x0021:
        r0 = r7.readString();
        r6.zzasd = r0;
        goto L_0x0000;
    L_0x0028:
        r0 = r7.readString();
        r6.zzasc = r0;
        goto L_0x0000;
    L_0x002f:
        r0 = r7.readString();
        r6.zzasb = r0;
        goto L_0x0000;
    L_0x0036:
        r0 = r7.zzux();
        r0 = java.lang.Boolean.valueOf(r0);
        r6.zzasa = r0;
        goto L_0x0000;
    L_0x0041:
        r1 = r7.getPosition();
        r2 = r7.zzuy();	 Catch:{ IllegalArgumentException -> 0x006e }
        if (r2 < 0) goto L_0x0055;	 Catch:{ IllegalArgumentException -> 0x006e }
    L_0x004b:
        r3 = 4;	 Catch:{ IllegalArgumentException -> 0x006e }
        if (r2 > r3) goto L_0x0055;	 Catch:{ IllegalArgumentException -> 0x006e }
    L_0x004e:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x006e }
        r6.zzarz = r2;	 Catch:{ IllegalArgumentException -> 0x006e }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x006e }
    L_0x0055:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x006e }
        r4 = 46;	 Catch:{ IllegalArgumentException -> 0x006e }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x006e }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x006e }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x006e }
        r2 = " is not a valid enum ComparisonType";	 Catch:{ IllegalArgumentException -> 0x006e }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x006e }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x006e }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x006e }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x006e }
    L_0x006e:
        r7.zzam(r1);
        r6.zza(r7, r0);
        goto L_0x0000;
    L_0x0075:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkg.zzd(com.google.android.gms.internal.measurement.zzabv):com.google.android.gms.internal.measurement.zzkg");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkg)) {
            return false;
        }
        zzkg com_google_android_gms_internal_measurement_zzkg = (zzkg) obj;
        if (this.zzarz == null) {
            if (com_google_android_gms_internal_measurement_zzkg.zzarz != null) {
                return false;
            }
        } else if (!this.zzarz.equals(com_google_android_gms_internal_measurement_zzkg.zzarz)) {
            return false;
        }
        if (this.zzasa == null) {
            if (com_google_android_gms_internal_measurement_zzkg.zzasa != null) {
                return false;
            }
        } else if (!this.zzasa.equals(com_google_android_gms_internal_measurement_zzkg.zzasa)) {
            return false;
        }
        if (this.zzasb == null) {
            if (com_google_android_gms_internal_measurement_zzkg.zzasb != null) {
                return false;
            }
        } else if (!this.zzasb.equals(com_google_android_gms_internal_measurement_zzkg.zzasb)) {
            return false;
        }
        if (this.zzasc == null) {
            if (com_google_android_gms_internal_measurement_zzkg.zzasc != null) {
                return false;
            }
        } else if (!this.zzasc.equals(com_google_android_gms_internal_measurement_zzkg.zzasc)) {
            return false;
        }
        if (this.zzasd == null) {
            if (com_google_android_gms_internal_measurement_zzkg.zzasd != null) {
                return false;
            }
        } else if (!this.zzasd.equals(com_google_android_gms_internal_measurement_zzkg.zzasd)) {
            return false;
        }
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                return this.zzbww.equals(com_google_android_gms_internal_measurement_zzkg.zzbww);
            }
        }
        if (com_google_android_gms_internal_measurement_zzkg.zzbww != null) {
            if (!com_google_android_gms_internal_measurement_zzkg.zzbww.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((527 + getClass().getName().hashCode()) * 31) + (this.zzarz == null ? 0 : this.zzarz.intValue())) * 31) + (this.zzasa == null ? 0 : this.zzasa.hashCode())) * 31) + (this.zzasb == null ? 0 : this.zzasb.hashCode())) * 31) + (this.zzasc == null ? 0 : this.zzasc.hashCode())) * 31) + (this.zzasd == null ? 0 : this.zzasd.hashCode())) * 31;
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                i = this.zzbww.hashCode();
            }
        }
        return hashCode + i;
    }

    protected final int zza() {
        int zza = super.zza();
        if (this.zzarz != null) {
            zza += zzabw.zzf(1, this.zzarz.intValue());
        }
        if (this.zzasa != null) {
            this.zzasa.booleanValue();
            zza += zzabw.zzaq(2) + 1;
        }
        if (this.zzasb != null) {
            zza += zzabw.zzc(3, this.zzasb);
        }
        if (this.zzasc != null) {
            zza += zzabw.zzc(4, this.zzasc);
        }
        return this.zzasd != null ? zza + zzabw.zzc(5, this.zzasd) : zza;
    }

    public final void zza(zzabw com_google_android_gms_internal_measurement_zzabw) throws IOException {
        if (this.zzarz != null) {
            com_google_android_gms_internal_measurement_zzabw.zze(1, this.zzarz.intValue());
        }
        if (this.zzasa != null) {
            com_google_android_gms_internal_measurement_zzabw.zza(2, this.zzasa.booleanValue());
        }
        if (this.zzasb != null) {
            com_google_android_gms_internal_measurement_zzabw.zzb(3, this.zzasb);
        }
        if (this.zzasc != null) {
            com_google_android_gms_internal_measurement_zzabw.zzb(4, this.zzasc);
        }
        if (this.zzasd != null) {
            com_google_android_gms_internal_measurement_zzabw.zzb(5, this.zzasd);
        }
        super.zza(com_google_android_gms_internal_measurement_zzabw);
    }

    public final /* synthetic */ zzace zzb(zzabv com_google_android_gms_internal_measurement_zzabv) throws IOException {
        return zzd(com_google_android_gms_internal_measurement_zzabv);
    }
}
