package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzcg<MessageType extends zzcg<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzas<MessageType, BuilderType> {
    private static Map<Object, zzcg<?, ?>> zzjr = new ConcurrentHashMap();
    protected zzey zzjp = zzey.zzea();
    private int zzjq = -1;

    public enum zzg {
        public static final int zzkd = 1;
        public static final int zzke = 2;
        public static final int zzkf = 3;
        public static final int zzkg = 4;
        public static final int zzkh = 5;
        public static final int zzki = 6;
        public static final int zzkj = 7;
        private static final /* synthetic */ int[] zzkk = new int[]{zzkd, zzke, zzkf, zzkg, zzkh, zzki, zzkj};
        public static final int zzkl = 1;
        public static final int zzkm = 2;
        private static final /* synthetic */ int[] zzkn = new int[]{zzkl, zzkm};
        public static final int zzko = 1;
        public static final int zzkp = 2;
        private static final /* synthetic */ int[] zzkq = new int[]{zzko, zzkp};

        public static int[] m55x126d66cb() {
            return (int[]) zzkk.clone();
        }
    }

    public static class zzb<T extends zzcg<T, ?>> extends zzau<T> {
        private T zzjs;

        public zzb(T t) {
            this.zzjs = t;
        }
    }

    static final class zze implements zzca<zze> {
        final int number = 66321687;
        private final zzck<?> zzjw = null;
        final zzfl zzjx;
        final boolean zzjy;
        final boolean zzjz;

        zze(zzck<?> com_google_android_gms_internal_clearcut_zzck_, int i, zzfl com_google_android_gms_internal_clearcut_zzfl, boolean z, boolean z2) {
            this.zzjx = com_google_android_gms_internal_clearcut_zzfl;
            this.zzjy = false;
            this.zzjz = false;
        }

        public final /* synthetic */ int compareTo(Object obj) {
            return this.number - ((zze) obj).number;
        }

        public final zzdp zza(zzdp com_google_android_gms_internal_clearcut_zzdp, zzdo com_google_android_gms_internal_clearcut_zzdo) {
            return ((zza) com_google_android_gms_internal_clearcut_zzdp).zza((zzcg) com_google_android_gms_internal_clearcut_zzdo);
        }

        public final zzdv zza(zzdv com_google_android_gms_internal_clearcut_zzdv, zzdv com_google_android_gms_internal_clearcut_zzdv2) {
            throw new UnsupportedOperationException();
        }

        public final zzfl zzau() {
            return this.zzjx;
        }

        public final zzfq zzav() {
            return this.zzjx.zzek();
        }

        public final boolean zzaw() {
            return false;
        }

        public final boolean zzax() {
            return false;
        }

        public final int zzc() {
            return this.number;
        }
    }

    public static class zzf<ContainingType extends zzdo, Type> extends zzbr<ContainingType, Type> {
        private final Type zzdu;
        private final ContainingType zzka;
        private final zzdo zzkb;
        private final zze zzkc;

        zzf(ContainingType containingType, Type type, zzdo com_google_android_gms_internal_clearcut_zzdo, zze com_google_android_gms_internal_clearcut_zzcg_zze, Class cls) {
            if (containingType != null) {
                if (com_google_android_gms_internal_clearcut_zzcg_zze.zzjx == zzfl.MESSAGE) {
                    if (com_google_android_gms_internal_clearcut_zzdo == null) {
                        throw new IllegalArgumentException("Null messageDefaultInstance");
                    }
                }
                this.zzka = containingType;
                this.zzdu = type;
                this.zzkb = com_google_android_gms_internal_clearcut_zzdo;
                this.zzkc = com_google_android_gms_internal_clearcut_zzcg_zze;
                return;
            }
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
    }

    public static abstract class zza<MessageType extends zzcg<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzat<MessageType, BuilderType> {
        private final MessageType zzjs;
        protected MessageType zzjt;
        protected boolean zzju = false;

        protected zza(MessageType messageType) {
            this.zzjs = messageType;
            this.zzjt = (zzcg) messageType.zza(zzg.zzkg, null, null);
        }

        private static void zza(MessageType messageType, MessageType messageType2) {
            zzea.zzcm().zzp(messageType).zzc(messageType, messageType2);
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza com_google_android_gms_internal_clearcut_zzcg_zza = (zza) this.zzjs.zza(zzg.zzkh, null, null);
            com_google_android_gms_internal_clearcut_zzcg_zza.zza((zzcg) zzbi());
            return com_google_android_gms_internal_clearcut_zzcg_zza;
        }

        public final boolean isInitialized() {
            return zzcg.zza(this.zzjt, false);
        }

        protected final /* synthetic */ zzat zza(zzas com_google_android_gms_internal_clearcut_zzas) {
            return zza((zzcg) com_google_android_gms_internal_clearcut_zzas);
        }

        public final BuilderType zza(MessageType messageType) {
            zzbf();
            zza(this.zzjt, messageType);
            return this;
        }

        public final /* synthetic */ zzdo zzbe() {
            return this.zzjs;
        }

        protected void zzbf() {
            if (this.zzju) {
                zzcg com_google_android_gms_internal_clearcut_zzcg = (zzcg) this.zzjt.zza(zzg.zzkg, null, null);
                zza(com_google_android_gms_internal_clearcut_zzcg, this.zzjt);
                this.zzjt = com_google_android_gms_internal_clearcut_zzcg;
                this.zzju = false;
            }
        }

        public MessageType zzbg() {
            if (this.zzju) {
                return this.zzjt;
            }
            zzcg com_google_android_gms_internal_clearcut_zzcg = this.zzjt;
            zzea.zzcm().zzp(com_google_android_gms_internal_clearcut_zzcg).zzc(com_google_android_gms_internal_clearcut_zzcg);
            this.zzju = true;
            return this.zzjt;
        }

        public final MessageType zzbh() {
            zzcg com_google_android_gms_internal_clearcut_zzcg = (zzcg) zzbi();
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) com_google_android_gms_internal_clearcut_zzcg.zza(zzg.zzkd, null, null)).byteValue();
            boolean z = true;
            if (byteValue != (byte) 1) {
                if (byteValue == (byte) 0) {
                    z = false;
                } else {
                    z = zzea.zzcm().zzp(com_google_android_gms_internal_clearcut_zzcg).zzo(com_google_android_gms_internal_clearcut_zzcg);
                    if (booleanValue) {
                        com_google_android_gms_internal_clearcut_zzcg.zza(zzg.zzke, z ? com_google_android_gms_internal_clearcut_zzcg : null, null);
                    }
                }
            }
            if (z) {
                return com_google_android_gms_internal_clearcut_zzcg;
            }
            throw new zzew(com_google_android_gms_internal_clearcut_zzcg);
        }

        public /* synthetic */ zzdo zzbi() {
            return zzbg();
        }

        public final /* synthetic */ zzdo zzbj() {
            zzcg com_google_android_gms_internal_clearcut_zzcg = (zzcg) zzbi();
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) com_google_android_gms_internal_clearcut_zzcg.zza(zzg.zzkd, null, null)).byteValue();
            boolean z = true;
            if (byteValue != (byte) 1) {
                if (byteValue == (byte) 0) {
                    z = false;
                } else {
                    z = zzea.zzcm().zzp(com_google_android_gms_internal_clearcut_zzcg).zzo(com_google_android_gms_internal_clearcut_zzcg);
                    if (booleanValue) {
                        com_google_android_gms_internal_clearcut_zzcg.zza(zzg.zzke, z ? com_google_android_gms_internal_clearcut_zzcg : null, null);
                    }
                }
            }
            if (z) {
                return com_google_android_gms_internal_clearcut_zzcg;
            }
            throw new zzew(com_google_android_gms_internal_clearcut_zzcg);
        }

        public final /* synthetic */ zzat zzt() {
            return (zza) clone();
        }
    }

    public static abstract class zzc<MessageType extends zzd<MessageType, BuilderType>, BuilderType extends zzc<MessageType, BuilderType>> extends zza<MessageType, BuilderType> implements zzdq {
        protected zzc(MessageType messageType) {
            super(messageType);
        }

        protected final void zzbf() {
            if (this.zzju) {
                super.zzbf();
                ((zzd) this.zzjt).zzjv = (zzby) ((zzd) this.zzjt).zzjv.clone();
            }
        }

        public final /* synthetic */ zzcg zzbg() {
            return (zzd) zzbi();
        }

        public final /* synthetic */ zzdo zzbi() {
            zzcg com_google_android_gms_internal_clearcut_zzcg;
            if (this.zzju) {
                com_google_android_gms_internal_clearcut_zzcg = this.zzjt;
            } else {
                ((zzd) this.zzjt).zzjv.zzv();
                com_google_android_gms_internal_clearcut_zzcg = super.zzbg();
            }
            return (zzd) com_google_android_gms_internal_clearcut_zzcg;
        }
    }

    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType extends zzc<MessageType, BuilderType>> extends zzcg<MessageType, BuilderType> implements zzdq {
        protected zzby<zze> zzjv = zzby.zzar();
    }

    public static <ContainingType extends zzdo, Type> zzf<ContainingType, Type> zza(ContainingType containingType, Type type, zzdo com_google_android_gms_internal_clearcut_zzdo, zzck<?> com_google_android_gms_internal_clearcut_zzck_, int i, zzfl com_google_android_gms_internal_clearcut_zzfl, Class cls) {
        return new zzf(containingType, type, com_google_android_gms_internal_clearcut_zzdo, new zze(null, 66321687, com_google_android_gms_internal_clearcut_zzfl, false, false), cls);
    }

    private static <T extends com.google.android.gms.internal.clearcut.zzcg<T, ?>> T zza(T r6, byte[] r7) throws com.google.android.gms.internal.clearcut.zzco {
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
        r0 = com.google.android.gms.internal.clearcut.zzcg.zzg.zzkg;
        r1 = 0;
        r6 = r6.zza(r0, r1, r1);
        r6 = (com.google.android.gms.internal.clearcut.zzcg) r6;
        r0 = com.google.android.gms.internal.clearcut.zzea.zzcm();	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r0 = r0.zzp(r6);	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r3 = 0;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r4 = r7.length;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r5 = new com.google.android.gms.internal.clearcut.zzay;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r5.<init>();	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r1 = r6;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r2 = r7;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r0.zza(r1, r2, r3, r4, r5);	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r7 = com.google.android.gms.internal.clearcut.zzea.zzcm();	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r7 = r7.zzp(r6);	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r7.zzc(r6);	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r7 = r6.zzex;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        if (r7 != 0) goto L_0x002d;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
    L_0x002c:
        return r6;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
    L_0x002d:
        r7 = new java.lang.RuntimeException;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        r7.<init>();	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
        throw r7;	 Catch:{ IOException -> 0x003c, IndexOutOfBoundsException -> 0x0033 }
    L_0x0033:
        r7 = com.google.android.gms.internal.clearcut.zzco.zzbl();
        r6 = r7.zzg(r6);
        throw r6;
    L_0x003c:
        r7 = move-exception;
        r0 = r7.getCause();
        r0 = r0 instanceof com.google.android.gms.internal.clearcut.zzco;
        if (r0 == 0) goto L_0x004c;
    L_0x0045:
        r6 = r7.getCause();
        r6 = (com.google.android.gms.internal.clearcut.zzco) r6;
        throw r6;
    L_0x004c:
        r0 = new com.google.android.gms.internal.clearcut.zzco;
        r7 = r7.getMessage();
        r0.<init>(r7);
        r6 = r0.zzg(r6);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzcg.zza(com.google.android.gms.internal.clearcut.zzcg, byte[]):T");
    }

    protected static Object zza(zzdo com_google_android_gms_internal_clearcut_zzdo, String str, Object[] objArr) {
        return new zzec(com_google_android_gms_internal_clearcut_zzdo, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        Throwable e;
        try {
            return method.invoke(obj, objArr);
        } catch (Throwable e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            e2 = e3.getCause();
            if (e2 instanceof RuntimeException) {
                throw ((RuntimeException) e2);
            } else if (e2 instanceof Error) {
                throw ((Error) e2);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", e2);
            }
        }
    }

    protected static <T extends zzcg<?, ?>> void zza(Class<T> cls, T t) {
        zzjr.put(cls, t);
    }

    protected static final <T extends zzcg<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzg.zzkd, null, null)).byteValue();
        return byteValue == (byte) 1 ? true : byteValue == (byte) 0 ? false : zzea.zzcm().zzp(t).zzo(t);
    }

    protected static zzcl zzaz() {
        return zzch.zzbk();
    }

    protected static <T extends zzcg<T, ?>> T zzb(T t, byte[] bArr) throws zzco {
        t = zza((zzcg) t, bArr);
        if (t != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) t.zza(zzg.zzkd, null, null)).byteValue();
            boolean z = true;
            if (byteValue != (byte) 1) {
                if (byteValue == (byte) 0) {
                    z = false;
                } else {
                    z = zzea.zzcm().zzp(t).zzo(t);
                    if (booleanValue) {
                        t.zza(zzg.zzke, z ? t : null, null);
                    }
                }
            }
            if (!z) {
                throw new zzco(new zzew(t).getMessage()).zzg(t);
            }
        }
        return t;
    }

    protected static zzcm zzba() {
        return zzdc.zzbx();
    }

    protected static <E> zzcn<E> zzbb() {
        return zzeb.zzcn();
    }

    static <T extends zzcg<?, ?>> T zzc(Class<T> cls) {
        T t = (zzcg) zzjr.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzcg) zzjr.get(cls);
            } catch (Throwable e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        String str = "Unable to get default instance for: ";
        String valueOf = String.valueOf(cls.getName());
        throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !((zzcg) zza(zzg.zzki, null, null)).getClass().isInstance(obj) ? false : zzea.zzcm().zzp(this).equals(this, (zzcg) obj);
    }

    public int hashCode() {
        if (this.zzex != 0) {
            return this.zzex;
        }
        this.zzex = zzea.zzcm().zzp(this).hashCode(this);
        return this.zzex;
    }

    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zza(zzg.zzkd, null, null)).byteValue();
        if (byteValue == (byte) 1) {
            return true;
        }
        if (byteValue == (byte) 0) {
            return false;
        }
        boolean zzo = zzea.zzcm().zzp(this).zzo(this);
        if (booleanValue) {
            zza(zzg.zzke, zzo ? this : null, null);
        }
        return zzo;
    }

    public String toString() {
        return zzdr.zza(this, super.toString());
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    public final int zzas() {
        if (this.zzjq == -1) {
            this.zzjq = zzea.zzcm().zzp(this).zzm(this);
        }
        return this.zzjq;
    }

    public final void zzb(zzbn com_google_android_gms_internal_clearcut_zzbn) throws IOException {
        zzea.zzcm().zze(getClass()).zza(this, zzbp.zza(com_google_android_gms_internal_clearcut_zzbn));
    }

    public final /* synthetic */ zzdp zzbc() {
        zza com_google_android_gms_internal_clearcut_zzcg_zza = (zza) zza(zzg.zzkh, null, null);
        com_google_android_gms_internal_clearcut_zzcg_zza.zza(this);
        return com_google_android_gms_internal_clearcut_zzcg_zza;
    }

    public final /* synthetic */ zzdp zzbd() {
        return (zza) zza(zzg.zzkh, null, null);
    }

    public final /* synthetic */ zzdo zzbe() {
        return (zzcg) zza(zzg.zzki, null, null);
    }

    final void zzf(int i) {
        this.zzjq = i;
    }

    final int zzs() {
        return this.zzjq;
    }
}
