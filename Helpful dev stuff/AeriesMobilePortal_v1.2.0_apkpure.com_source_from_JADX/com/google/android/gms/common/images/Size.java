package com.google.android.gms.common.images;

public final class Size {
    private final int zzps;
    private final int zzpt;

    public Size(int i, int i2) {
        this.zzps = i;
        this.zzpt = i2;
    }

    public static com.google.android.gms.common.images.Size parseSize(java.lang.String r3) throws java.lang.NumberFormatException {
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
        if (r3 == 0) goto L_0x0035;
    L_0x0002:
        r0 = 42;
        r0 = r3.indexOf(r0);
        if (r0 >= 0) goto L_0x0010;
    L_0x000a:
        r0 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r0 = r3.indexOf(r0);
    L_0x0010:
        if (r0 < 0) goto L_0x0030;
    L_0x0012:
        r1 = new com.google.android.gms.common.images.Size;	 Catch:{ NumberFormatException -> 0x002b }
        r2 = 0;	 Catch:{ NumberFormatException -> 0x002b }
        r2 = r3.substring(r2, r0);	 Catch:{ NumberFormatException -> 0x002b }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ NumberFormatException -> 0x002b }
        r0 = r0 + 1;	 Catch:{ NumberFormatException -> 0x002b }
        r0 = r3.substring(r0);	 Catch:{ NumberFormatException -> 0x002b }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x002b }
        r1.<init>(r2, r0);	 Catch:{ NumberFormatException -> 0x002b }
        return r1;
    L_0x002b:
        r3 = zzi(r3);
        throw r3;
    L_0x0030:
        r3 = zzi(r3);
        throw r3;
    L_0x0035:
        r3 = new java.lang.IllegalArgumentException;
        r0 = "string must not be null";
        r3.<init>(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.images.Size.parseSize(java.lang.String):com.google.android.gms.common.images.Size");
    }

    private static NumberFormatException zzi(String str) {
        StringBuilder stringBuilder = new StringBuilder(16 + String.valueOf(str).length());
        stringBuilder.append("Invalid Size: \"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        throw new NumberFormatException(stringBuilder.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.zzps == size.zzps && this.zzpt == size.zzpt;
        }
    }

    public final int getHeight() {
        return this.zzpt;
    }

    public final int getWidth() {
        return this.zzps;
    }

    public final int hashCode() {
        return this.zzpt ^ ((this.zzps << 16) | (this.zzps >>> 16));
    }

    public final String toString() {
        int i = this.zzps;
        int i2 = this.zzpt;
        StringBuilder stringBuilder = new StringBuilder(23);
        stringBuilder.append(i);
        stringBuilder.append("x");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }
}
