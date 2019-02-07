package io.realm.internal;

import android.content.Context;
import io.realm.RealmConfiguration;

public class ObjectServerFacade {
    private static final ObjectServerFacade nonSyncFacade = new ObjectServerFacade();
    private static ObjectServerFacade syncFacade;

    public void downloadRemoteChanges(RealmConfiguration realmConfiguration) {
    }

    public String getSyncServerCertificateAssetName(RealmConfiguration realmConfiguration) {
        return null;
    }

    public String getSyncServerCertificateFilePath(RealmConfiguration realmConfiguration) {
        return null;
    }

    public void init(Context context) {
    }

    public void realmClosed(RealmConfiguration realmConfiguration) {
    }

    public boolean wasDownloadInterrupted(Throwable th) {
        return false;
    }

    public void wrapObjectStoreSessionIfRequired(RealmConfiguration realmConfiguration) {
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new io.realm.internal.ObjectServerFacade;
        r0.<init>();
        nonSyncFacade = r0;
        r0 = "io.realm.internal.SyncObjectServerFacade";	 Catch:{ ClassNotFoundException -> 0x0047, InstantiationException -> 0x003e, IllegalAccessException -> 0x0035, NoSuchMethodException -> 0x002c, InvocationTargetException -> 0x001f }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0047, InstantiationException -> 0x003e, IllegalAccessException -> 0x0035, NoSuchMethodException -> 0x002c, InvocationTargetException -> 0x001f }
        r1 = 0;	 Catch:{ ClassNotFoundException -> 0x0047, InstantiationException -> 0x003e, IllegalAccessException -> 0x0035, NoSuchMethodException -> 0x002c, InvocationTargetException -> 0x001f }
        r2 = new java.lang.Class[r1];	 Catch:{ ClassNotFoundException -> 0x0047, InstantiationException -> 0x003e, IllegalAccessException -> 0x0035, NoSuchMethodException -> 0x002c, InvocationTargetException -> 0x001f }
        r0 = r0.getDeclaredConstructor(r2);	 Catch:{ ClassNotFoundException -> 0x0047, InstantiationException -> 0x003e, IllegalAccessException -> 0x0035, NoSuchMethodException -> 0x002c, InvocationTargetException -> 0x001f }
        r1 = new java.lang.Object[r1];	 Catch:{ ClassNotFoundException -> 0x0047, InstantiationException -> 0x003e, IllegalAccessException -> 0x0035, NoSuchMethodException -> 0x002c, InvocationTargetException -> 0x001f }
        r0 = r0.newInstance(r1);	 Catch:{ ClassNotFoundException -> 0x0047, InstantiationException -> 0x003e, IllegalAccessException -> 0x0035, NoSuchMethodException -> 0x002c, InvocationTargetException -> 0x001f }
        r0 = (io.realm.internal.ObjectServerFacade) r0;	 Catch:{ ClassNotFoundException -> 0x0047, InstantiationException -> 0x003e, IllegalAccessException -> 0x0035, NoSuchMethodException -> 0x002c, InvocationTargetException -> 0x001f }
        syncFacade = r0;	 Catch:{ ClassNotFoundException -> 0x0047, InstantiationException -> 0x003e, IllegalAccessException -> 0x0035, NoSuchMethodException -> 0x002c, InvocationTargetException -> 0x001f }
        goto L_0x0047;
    L_0x001f:
        r0 = move-exception;
        r1 = new io.realm.exceptions.RealmException;
        r0 = r0.getTargetException();
        r2 = "Failed to init SyncObjectServerFacade";
        r1.<init>(r2, r0);
        throw r1;
    L_0x002c:
        r0 = move-exception;
        r1 = new io.realm.exceptions.RealmException;
        r2 = "Failed to init SyncObjectServerFacade";
        r1.<init>(r2, r0);
        throw r1;
    L_0x0035:
        r0 = move-exception;
        r1 = new io.realm.exceptions.RealmException;
        r2 = "Failed to init SyncObjectServerFacade";
        r1.<init>(r2, r0);
        throw r1;
    L_0x003e:
        r0 = move-exception;
        r1 = new io.realm.exceptions.RealmException;
        r2 = "Failed to init SyncObjectServerFacade";
        r1.<init>(r2, r0);
        throw r1;
    L_0x0047:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.internal.ObjectServerFacade.<clinit>():void");
    }

    public Object[] getUserAndServerUrl(RealmConfiguration realmConfiguration) {
        return new Object[6];
    }

    public static ObjectServerFacade getFacade(boolean z) {
        if (z) {
            return syncFacade;
        }
        return nonSyncFacade;
    }

    public static ObjectServerFacade getSyncFacadeIfPossible() {
        if (syncFacade != null) {
            return syncFacade;
        }
        return nonSyncFacade;
    }
}
