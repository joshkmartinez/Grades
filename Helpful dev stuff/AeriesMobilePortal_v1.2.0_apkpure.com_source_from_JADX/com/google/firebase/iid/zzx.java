package com.google.firebase.iid;

final /* synthetic */ class zzx implements Runnable {
    private final zzu zzbo;

    zzx(zzu com_google_firebase_iid_zzu) {
        this.zzbo = com_google_firebase_iid_zzu;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r8 = this;
        r0 = r8.zzbo;
    L_0x0002:
        monitor-enter(r0);
        r1 = r0.state;	 Catch:{ all -> 0x00af }
        r2 = 2;
        if (r1 == r2) goto L_0x000a;
    L_0x0008:
        monitor-exit(r0);	 Catch:{ all -> 0x00af }
        return;
    L_0x000a:
        r1 = r0.zzbl;	 Catch:{ all -> 0x00af }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x00af }
        if (r1 == 0) goto L_0x0017;
    L_0x0012:
        r0.zzu();	 Catch:{ all -> 0x00af }
        monitor-exit(r0);	 Catch:{ all -> 0x00af }
        return;
    L_0x0017:
        r1 = r0.zzbl;	 Catch:{ all -> 0x00af }
        r1 = r1.poll();	 Catch:{ all -> 0x00af }
        r1 = (com.google.firebase.iid.zzab) r1;	 Catch:{ all -> 0x00af }
        r3 = r0.zzbm;	 Catch:{ all -> 0x00af }
        r4 = r1.zzbr;	 Catch:{ all -> 0x00af }
        r3.put(r4, r1);	 Catch:{ all -> 0x00af }
        r3 = r0.zzbn;	 Catch:{ all -> 0x00af }
        r3 = r3.zzbg;	 Catch:{ all -> 0x00af }
        r4 = new com.google.firebase.iid.zzy;	 Catch:{ all -> 0x00af }
        r4.<init>(r0, r1);	 Catch:{ all -> 0x00af }
        r5 = 30;
        r7 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ all -> 0x00af }
        r3.schedule(r4, r5, r7);	 Catch:{ all -> 0x00af }
        monitor-exit(r0);	 Catch:{ all -> 0x00af }
        r3 = "MessengerIpcClient";
        r4 = 3;
        r3 = android.util.Log.isLoggable(r3, r4);
        if (r3 == 0) goto L_0x0067;
    L_0x0042:
        r3 = "MessengerIpcClient";
        r4 = java.lang.String.valueOf(r1);
        r5 = 8;
        r6 = java.lang.String.valueOf(r4);
        r6 = r6.length();
        r5 = r5 + r6;
        r6 = new java.lang.StringBuilder;
        r6.<init>(r5);
        r5 = "Sending ";
        r6.append(r5);
        r6.append(r4);
        r4 = r6.toString();
        android.util.Log.d(r3, r4);
    L_0x0067:
        r3 = r0.zzbn;
        r3 = r3.zzz;
        r4 = r0.zzbj;
        r5 = android.os.Message.obtain();
        r6 = r1.what;
        r5.what = r6;
        r6 = r1.zzbr;
        r5.arg1 = r6;
        r5.replyTo = r4;
        r4 = new android.os.Bundle;
        r4.<init>();
        r6 = "oneWay";
        r7 = r1.zzw();
        r4.putBoolean(r6, r7);
        r6 = "pkg";
        r3 = r3.getPackageName();
        r4.putString(r6, r3);
        r3 = "data";
        r1 = r1.zzbt;
        r4.putBundle(r3, r1);
        r5.setData(r4);
        r1 = r0.zzbk;	 Catch:{ RemoteException -> 0x00a5 }
        r1.send(r5);	 Catch:{ RemoteException -> 0x00a5 }
        goto L_0x0002;
    L_0x00a5:
        r1 = move-exception;
        r1 = r1.getMessage();
        r0.zza(r2, r1);
        goto L_0x0002;
    L_0x00af:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00af }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzx.run():void");
    }
}
