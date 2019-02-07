package io.realm;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.JsonReader;
import io.realm.BaseRealm.InstanceCallback;
import io.realm.RealmConfiguration.Builder;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmFileException;
import io.realm.exceptions.RealmFileException.Kind;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnIndices;
import io.realm.internal.ObjectServerFacade;
import io.realm.internal.OsObject;
import io.realm.internal.RealmCore;
import io.realm.internal.RealmNotifier;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmObjectProxy.CacheData;
import io.realm.internal.SharedRealm;
import io.realm.internal.SharedRealm.VersionID;
import io.realm.internal.Table;
import io.realm.internal.async.RealmAsyncTaskImpl;
import io.realm.internal.util.Pair;
import io.realm.log.RealmLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;

public class Realm extends BaseRealm {
    public static final String DEFAULT_REALM_NAME = "default.realm";
    private static final String NULL_CONFIG_MSG = "A non-null RealmConfiguration must be provided";
    private static RealmConfiguration defaultConfiguration;
    private static final Object defaultConfigurationLock = new Object();

    public interface Transaction {

        public static class Callback {
            public void onError(Exception exception) {
            }

            public void onSuccess() {
            }
        }

        public interface OnError {
            void onError(Throwable th);
        }

        public interface OnSuccess {
            void onSuccess();
        }

        void execute(Realm realm);
    }

    class C10412 implements MigrationCallback {
        public void migrationComplete() {
        }

        C10412() {
        }
    }

    class C10423 implements MigrationCallback {
        public void migrationComplete() {
        }

        C10423() {
        }
    }

    class C10434 implements Callback {
        final /* synthetic */ AtomicInteger val$globalCount;

        C10434(AtomicInteger atomicInteger) {
            this.val$globalCount = atomicInteger;
        }

        public void onResult(int i) {
            this.val$globalCount.set(i);
        }
    }

    public static abstract class Callback extends InstanceCallback<Realm> {
        public abstract void onSuccess(Realm realm);

        public void onError(Throwable th) {
            super.onError(th);
        }
    }

    public /* bridge */ /* synthetic */ void beginTransaction() {
        super.beginTransaction();
    }

    public /* bridge */ /* synthetic */ void cancelTransaction() {
        super.cancelTransaction();
    }

    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    public /* bridge */ /* synthetic */ void commitTransaction() {
        super.commitTransaction();
    }

    public /* bridge */ /* synthetic */ void deleteAll() {
        super.deleteAll();
    }

    public /* bridge */ /* synthetic */ RealmConfiguration getConfiguration() {
        return super.getConfiguration();
    }

    public /* bridge */ /* synthetic */ String getPath() {
        return super.getPath();
    }

    public /* bridge */ /* synthetic */ RealmSchema getSchema() {
        return super.getSchema();
    }

    public /* bridge */ /* synthetic */ long getVersion() {
        return super.getVersion();
    }

    public /* bridge */ /* synthetic */ boolean isAutoRefresh() {
        return super.isAutoRefresh();
    }

    public /* bridge */ /* synthetic */ boolean isClosed() {
        return super.isClosed();
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public /* bridge */ /* synthetic */ boolean isInTransaction() {
        return super.isInTransaction();
    }

    public /* bridge */ /* synthetic */ void refresh() {
        super.refresh();
    }

    public /* bridge */ /* synthetic */ void setAutoRefresh(boolean z) {
        super.setAutoRefresh(z);
    }

    public /* bridge */ /* synthetic */ void stopWaitForChange() {
        super.stopWaitForChange();
    }

    public /* bridge */ /* synthetic */ boolean waitForChange() {
        return super.waitForChange();
    }

    public /* bridge */ /* synthetic */ void writeCopyTo(File file) {
        super.writeCopyTo(file);
    }

    public /* bridge */ /* synthetic */ void writeEncryptedCopyTo(File file, byte[] bArr) {
        super.writeEncryptedCopyTo(file, bArr);
    }

    private Realm(RealmCache realmCache) {
        super(realmCache);
    }

    public Observable<Realm> asObservable() {
        return this.configuration.getRxFactory().from(this);
    }

    public static synchronized void init(Context context) {
        synchronized (Realm.class) {
            if (BaseRealm.applicationContext == null) {
                if (context != null) {
                    checkFilesDirAvailable(context);
                    RealmCore.loadLibrary(context);
                    setDefaultConfiguration(new Builder(context).build());
                    ObjectServerFacade.getSyncFacadeIfPossible().init(context);
                    BaseRealm.applicationContext = context.getApplicationContext();
                    SharedRealm.initialize(new File(context.getFilesDir(), ".realm.temp"));
                } else {
                    throw new IllegalArgumentException("Non-null context required.");
                }
            }
        }
    }

    private static void checkFilesDirAvailable(android.content.Context r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r10.getFilesDir();
        if (r0 == 0) goto L_0x0010;
    L_0x0006:
        r1 = r0.exists();
        if (r1 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0.mkdirs();	 Catch:{ SecurityException -> 0x0010 }
    L_0x0010:
        if (r0 == 0) goto L_0x0018;
    L_0x0012:
        r0 = r0.exists();
        if (r0 != 0) goto L_0x0047;
    L_0x0018:
        r0 = 5;
        r0 = new long[r0];
        r0 = {1, 2, 5, 10, 16};
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r3 = 0;
        r5 = -1;
    L_0x0023:
        r6 = r10.getFilesDir();
        if (r6 == 0) goto L_0x0033;
    L_0x0029:
        r6 = r10.getFilesDir();
        r6 = r6.exists();
        if (r6 != 0) goto L_0x0047;
    L_0x0033:
        r5 = r5 + 1;
        r6 = r0.length;
        r6 = r6 + -1;
        r6 = java.lang.Math.min(r5, r6);
        r6 = r0[r6];
        android.os.SystemClock.sleep(r6);
        r8 = r3 + r6;
        r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1));
        if (r3 <= 0) goto L_0x0078;
    L_0x0047:
        r0 = r10.getFilesDir();
        if (r0 == 0) goto L_0x0058;
    L_0x004d:
        r0 = r10.getFilesDir();
        r0 = r0.exists();
        if (r0 == 0) goto L_0x0058;
    L_0x0057:
        return;
    L_0x0058:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Context.getFilesDir() returns ";
        r1.append(r2);
        r10 = r10.getFilesDir();
        r1.append(r10);
        r10 = " which is not an existing directory. See https://issuetracker.google.com/issues/36918154";
        r1.append(r10);
        r10 = r1.toString();
        r0.<init>(r10);
        throw r0;
    L_0x0078:
        r3 = r8;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.Realm.checkFilesDirAvailable(android.content.Context):void");
    }

    public static Realm getDefaultInstance() {
        RealmConfiguration defaultConfiguration = getDefaultConfiguration();
        if (defaultConfiguration != null) {
            return (Realm) RealmCache.createRealmOrGetFromCache(defaultConfiguration, Realm.class);
        }
        if (BaseRealm.applicationContext == null) {
            throw new IllegalStateException("Call `Realm.init(Context)` before calling this method.");
        }
        throw new IllegalStateException("Set default configuration by using `Realm.setDefaultConfiguration(RealmConfiguration)`.");
    }

    public static Realm getInstance(RealmConfiguration realmConfiguration) {
        if (realmConfiguration != null) {
            return (Realm) RealmCache.createRealmOrGetFromCache(realmConfiguration, Realm.class);
        }
        throw new IllegalArgumentException(NULL_CONFIG_MSG);
    }

    public static RealmAsyncTask getInstanceAsync(RealmConfiguration realmConfiguration, Callback callback) {
        if (realmConfiguration != null) {
            return RealmCache.createRealmOrGetFromCacheAsync(realmConfiguration, callback, Realm.class);
        }
        throw new IllegalArgumentException(NULL_CONFIG_MSG);
    }

    public static void setDefaultConfiguration(RealmConfiguration realmConfiguration) {
        if (realmConfiguration != null) {
            synchronized (defaultConfigurationLock) {
                defaultConfiguration = realmConfiguration;
            }
            return;
        }
        throw new IllegalArgumentException(NULL_CONFIG_MSG);
    }

    public static RealmConfiguration getDefaultConfiguration() {
        RealmConfiguration realmConfiguration;
        synchronized (defaultConfigurationLock) {
            realmConfiguration = defaultConfiguration;
        }
        return realmConfiguration;
    }

    public static void removeDefaultConfiguration() {
        synchronized (defaultConfigurationLock) {
            defaultConfiguration = null;
        }
    }

    static Realm createInstance(RealmCache realmCache) {
        RealmConfiguration configuration = realmCache.getConfiguration();
        try {
            return createAndValidateFromCache(realmCache);
        } catch (RealmMigrationNeededException e) {
            if (configuration.shouldDeleteRealmIfMigrationNeeded()) {
                deleteRealm(configuration);
            } else {
                try {
                    if (configuration.getMigration() != null) {
                        migrateRealm(configuration, e);
                    }
                } catch (Throwable e2) {
                    throw new RealmFileException(Kind.NOT_FOUND, e2);
                }
            }
            return createAndValidateFromCache(realmCache);
        }
    }

    private static Realm createAndValidateFromCache(RealmCache realmCache) {
        Realm realm = new Realm(realmCache);
        RealmConfiguration realmConfiguration = realm.configuration;
        long version = realm.getVersion();
        long schemaVersion = realmConfiguration.getSchemaVersion();
        realmCache = RealmCache.findColumnIndices(realmCache.getTypedColumnIndicesArray(), schemaVersion);
        if (realmCache != null) {
            realm.schema.setInitialColumnIndices(realmCache);
        } else {
            if (realmConfiguration.isSyncConfiguration() == null && version != -1) {
                if (version < schemaVersion) {
                    realm.doClose();
                    throw new RealmMigrationNeededException(realmConfiguration.getPath(), String.format(Locale.US, "Realm on disk need to migrate from v%s to v%s", new Object[]{Long.valueOf(version), Long.valueOf(schemaVersion)}));
                } else if (schemaVersion < version) {
                    realm.doClose();
                    throw new IllegalArgumentException(String.format(Locale.US, "Realm on disk is newer than the one specified: v%s vs. v%s", new Object[]{Long.valueOf(version), Long.valueOf(schemaVersion)}));
                }
            }
            try {
                initializeRealm(realm);
            } catch (RealmCache realmCache2) {
                realm.doClose();
                throw realmCache2;
            }
        }
        return realm;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void initializeRealm(io.realm.Realm r16) {
        /*
        r1 = r16;
        r2 = 0;
        r0 = 1;
        r1.beginTransaction(r0);	 Catch:{ Exception -> 0x00c5 }
        r3 = r16.getConfiguration();	 Catch:{ Exception -> 0x00c5 }
        r4 = r16.getVersion();	 Catch:{ Exception -> 0x00c5 }
        r6 = -1;
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 != 0) goto L_0x0017;
    L_0x0015:
        r6 = r0;
        goto L_0x0018;
    L_0x0017:
        r6 = r2;
    L_0x0018:
        r7 = r3.getSchemaVersion();	 Catch:{ Exception -> 0x00c5 }
        r9 = r3.getSchemaMediator();	 Catch:{ Exception -> 0x00c5 }
        r10 = r9.getModelClasses();	 Catch:{ Exception -> 0x00c5 }
        r11 = r3.isSyncConfiguration();	 Catch:{ Exception -> 0x00c5 }
        if (r11 == 0) goto L_0x0044;
    L_0x002a:
        r11 = r3.isReadOnly();	 Catch:{ Exception -> 0x00c5 }
        if (r11 != 0) goto L_0x0067;
    L_0x0030:
        r11 = new io.realm.internal.OsSchemaInfo;	 Catch:{ Exception -> 0x00c5 }
        r12 = r9.getExpectedObjectSchemaInfoMap();	 Catch:{ Exception -> 0x00c5 }
        r12 = r12.values();	 Catch:{ Exception -> 0x00c5 }
        r11.<init>(r12);	 Catch:{ Exception -> 0x00c5 }
        r12 = r1.sharedRealm;	 Catch:{ Exception -> 0x00c5 }
        r12.updateSchema(r11, r7);	 Catch:{ Exception -> 0x00c5 }
    L_0x0042:
        r11 = r0;
        goto L_0x0068;
    L_0x0044:
        if (r6 == 0) goto L_0x0067;
    L_0x0046:
        r11 = r3.isReadOnly();	 Catch:{ Exception -> 0x00c5 }
        if (r11 != 0) goto L_0x005f;
    L_0x004c:
        r11 = new io.realm.internal.OsSchemaInfo;	 Catch:{ Exception -> 0x00c5 }
        r12 = r9.getExpectedObjectSchemaInfoMap();	 Catch:{ Exception -> 0x00c5 }
        r12 = r12.values();	 Catch:{ Exception -> 0x00c5 }
        r11.<init>(r12);	 Catch:{ Exception -> 0x00c5 }
        r12 = r1.sharedRealm;	 Catch:{ Exception -> 0x00c5 }
        r12.updateSchema(r11, r7);	 Catch:{ Exception -> 0x00c5 }
        goto L_0x0042;
    L_0x005f:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ Exception -> 0x00c5 }
        r3 = "Cannot create the Realm schema in a read-only file.";
        r0.<init>(r3);	 Catch:{ Exception -> 0x00c5 }
        throw r0;	 Catch:{ Exception -> 0x00c5 }
    L_0x0067:
        r11 = r2;
    L_0x0068:
        r0 = new java.util.HashMap;	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
        r12 = r10.size();	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
        r0.<init>(r12);	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
        r10 = r10.iterator();	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
    L_0x0075:
        r12 = r10.hasNext();	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
        if (r12 == 0) goto L_0x009b;
    L_0x007b:
        r12 = r10.next();	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
        r12 = (java.lang.Class) r12;	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
        r13 = r9.getTableName(r12);	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
        r13 = io.realm.internal.Table.getClassNameForTable(r13);	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
        r13 = io.realm.internal.util.Pair.create(r12, r13);	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
        r14 = r1.sharedRealm;	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
        r15 = r3.isSyncConfiguration();	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
        r12 = r9.validateTable(r12, r14, r15);	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
        r0.put(r13, r12);	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
        goto L_0x0075;
    L_0x009b:
        r9 = r16.getSchema();	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
        if (r6 == 0) goto L_0x00a2;
    L_0x00a1:
        r4 = r7;
    L_0x00a2:
        r9.setInitialColumnIndices(r4, r0);	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
        r0 = r3.getInitialDataTransaction();	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
        if (r0 == 0) goto L_0x00b0;
    L_0x00ab:
        if (r6 == 0) goto L_0x00b0;
    L_0x00ad:
        r0.execute(r1);	 Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
    L_0x00b0:
        if (r11 == 0) goto L_0x00b6;
    L_0x00b2:
        r16.commitTransaction();
        goto L_0x00bf;
    L_0x00b6:
        r0 = r16.isInTransaction();
        if (r0 == 0) goto L_0x00bf;
    L_0x00bc:
        r16.cancelTransaction();
    L_0x00bf:
        return;
    L_0x00c0:
        r0 = move-exception;
        r2 = r11;
        goto L_0x00c7;
    L_0x00c3:
        r0 = move-exception;
        goto L_0x00c7;
    L_0x00c5:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x00c3 }
    L_0x00c7:
        if (r2 != 0) goto L_0x00d3;
    L_0x00c9:
        r2 = r16.isInTransaction();
        if (r2 == 0) goto L_0x00d6;
    L_0x00cf:
        r16.cancelTransaction();
        goto L_0x00d6;
    L_0x00d3:
        r16.commitTransaction();
    L_0x00d6:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.Realm.initializeRealm(io.realm.Realm):void");
    }

    public <E extends RealmModel> void createAllFromJson(Class<E> cls, JSONArray jSONArray) {
        if (cls != null) {
            if (jSONArray != null) {
                checkIfValid();
                int i = 0;
                while (i < jSONArray.length()) {
                    try {
                        this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(cls, this, jSONArray.getJSONObject(i), false);
                        i++;
                    } catch (Class<E> cls2) {
                        throw new RealmException("Could not map JSON", cls2);
                    }
                }
            }
        }
    }

    public <E extends RealmModel> void createOrUpdateAllFromJson(Class<E> cls, JSONArray jSONArray) {
        if (cls != null) {
            if (jSONArray != null) {
                checkIfValid();
                checkHasPrimaryKey(cls);
                int i = 0;
                while (i < jSONArray.length()) {
                    try {
                        this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(cls, this, jSONArray.getJSONObject(i), true);
                        i++;
                    } catch (Class<E> cls2) {
                        throw new RealmException("Could not map JSON", cls2);
                    }
                }
            }
        }
    }

    public <E extends RealmModel> void createAllFromJson(Class<E> cls, String str) {
        if (!(cls == null || str == null)) {
            if (str.length() != 0) {
                try {
                    createAllFromJson((Class) cls, new JSONArray(str));
                } catch (Class<E> cls2) {
                    throw new RealmException("Could not create JSON array from string", cls2);
                }
            }
        }
    }

    public <E extends RealmModel> void createOrUpdateAllFromJson(Class<E> cls, String str) {
        if (!(cls == null || str == null)) {
            if (str.length() != 0) {
                checkIfValid();
                checkHasPrimaryKey(cls);
                try {
                    createOrUpdateAllFromJson((Class) cls, new JSONArray(str));
                } catch (Class<E> cls2) {
                    throw new RealmException("Could not create JSON array from string", cls2);
                }
            }
        }
    }

    @TargetApi(11)
    public <E extends RealmModel> void createAllFromJson(Class<E> cls, InputStream inputStream) throws IOException {
        if (cls != null) {
            if (inputStream != null) {
                checkIfValid();
                JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
                try {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext() != null) {
                        this.configuration.getSchemaMediator().createUsingJsonStream(cls, this, jsonReader);
                    }
                    jsonReader.endArray();
                } finally {
                    jsonReader.close();
                }
            }
        }
    }

    @TargetApi(11)
    public <E extends RealmModel> void createOrUpdateAllFromJson(Class<E> cls, InputStream inputStream) {
        if (cls != null) {
            if (inputStream != null) {
                checkIfValid();
                checkHasPrimaryKey(cls);
                InputStream inputStream2 = null;
                try {
                    inputStream = getFullStringScanner(inputStream);
                    try {
                        JSONArray jSONArray = new JSONArray(inputStream.next());
                        for (int i = 0; i < jSONArray.length(); i++) {
                            this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(cls, this, jSONArray.getJSONObject(i), true);
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (JSONException e) {
                        cls = e;
                        inputStream2 = inputStream;
                        try {
                            throw new RealmException("Failed to read JSON", cls);
                        } catch (Throwable th) {
                            cls = th;
                            inputStream = inputStream2;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw cls;
                        }
                    } catch (Throwable th2) {
                        cls = th2;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw cls;
                    }
                } catch (JSONException e2) {
                    cls = e2;
                    throw new RealmException("Failed to read JSON", cls);
                }
            }
        }
    }

    public <E extends RealmModel> E createObjectFromJson(Class<E> cls, JSONObject jSONObject) {
        if (cls != null) {
            if (jSONObject != null) {
                checkIfValid();
                try {
                    return this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(cls, this, jSONObject, false);
                } catch (Class<E> cls2) {
                    throw new RealmException("Could not map JSON", cls2);
                }
            }
        }
        return null;
    }

    public <E extends RealmModel> E createOrUpdateObjectFromJson(Class<E> cls, JSONObject jSONObject) {
        if (cls != null) {
            if (jSONObject != null) {
                checkIfValid();
                checkHasPrimaryKey(cls);
                try {
                    return this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(cls, this, jSONObject, true);
                } catch (Class<E> cls2) {
                    throw new RealmException("Could not map JSON", cls2);
                }
            }
        }
        return null;
    }

    public <E extends RealmModel> E createObjectFromJson(Class<E> cls, String str) {
        if (!(cls == null || str == null)) {
            if (str.length() != 0) {
                try {
                    return createObjectFromJson((Class) cls, new JSONObject(str));
                } catch (Class<E> cls2) {
                    throw new RealmException("Could not create Json object from string", cls2);
                }
            }
        }
        return null;
    }

    public <E extends RealmModel> E createOrUpdateObjectFromJson(Class<E> cls, String str) {
        if (!(cls == null || str == null)) {
            if (str.length() != 0) {
                checkIfValid();
                checkHasPrimaryKey(cls);
                try {
                    return createOrUpdateObjectFromJson((Class) cls, new JSONObject(str));
                } catch (Class<E> cls2) {
                    throw new RealmException("Could not create Json object from string", cls2);
                }
            }
        }
        return null;
    }

    @TargetApi(11)
    public <E extends RealmModel> E createObjectFromJson(Class<E> cls, InputStream inputStream) throws IOException {
        E e = null;
        if (cls != null) {
            if (inputStream != null) {
                checkIfValid();
                if (this.schema.getTable((Class) cls).hasPrimaryKey()) {
                    try {
                        inputStream = getFullStringScanner(inputStream);
                        try {
                            cls = this.configuration.getSchemaMediator().createOrUpdateUsingJsonObject(cls, this, new JSONObject(inputStream.next()), false);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (JSONException e2) {
                            cls = e2;
                            e = inputStream;
                            try {
                                throw new RealmException("Failed to read JSON", cls);
                            } catch (Throwable th) {
                                cls = th;
                                inputStream = e;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw cls;
                            }
                        } catch (Throwable th2) {
                            cls = th2;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw cls;
                        }
                    } catch (JSONException e3) {
                        cls = e3;
                        throw new RealmException("Failed to read JSON", cls);
                    }
                }
                JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
                try {
                    cls = this.configuration.getSchemaMediator().createUsingJsonStream(cls, this, jsonReader);
                } finally {
                    jsonReader.close();
                }
                return cls;
            }
        }
        return null;
    }

    @TargetApi(11)
    public <E extends RealmModel> E createOrUpdateObjectFromJson(Class<E> cls, InputStream inputStream) {
        Scanner scanner = null;
        if (cls != null) {
            if (inputStream != null) {
                checkIfValid();
                checkHasPrimaryKey(cls);
                try {
                    inputStream = getFullStringScanner(inputStream);
                    try {
                        cls = createOrUpdateObjectFromJson((Class) cls, new JSONObject(inputStream.next()));
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return cls;
                    } catch (JSONException e) {
                        cls = e;
                        scanner = inputStream;
                        try {
                            throw new RealmException("Failed to read JSON", cls);
                        } catch (Throwable th) {
                            cls = th;
                            if (scanner != null) {
                                scanner.close();
                            }
                            throw cls;
                        }
                    } catch (Throwable th2) {
                        cls = th2;
                        scanner = inputStream;
                        if (scanner != null) {
                            scanner.close();
                        }
                        throw cls;
                    }
                } catch (JSONException e2) {
                    cls = e2;
                    throw new RealmException("Failed to read JSON", cls);
                }
            }
        }
        return null;
    }

    private Scanner getFullStringScanner(InputStream inputStream) {
        return new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
    }

    public <E extends RealmModel> E createObject(Class<E> cls) {
        checkIfValid();
        return createObjectInternal(cls, true, Collections.emptyList());
    }

    <E extends RealmModel> E createObjectInternal(Class<E> cls, boolean z, List<String> list) {
        Table table = this.schema.getTable((Class) cls);
        if (!table.hasPrimaryKey()) {
            return this.configuration.getSchemaMediator().newInstance(cls, this, OsObject.create(table), this.schema.getColumnInfo((Class) cls), z, list);
        }
        throw new RealmException(String.format(Locale.US, "'%s' has a primary key, use 'createObject(Class<E>, Object)' instead.", new Object[]{table.getClassName()}));
    }

    public <E extends RealmModel> E createObject(Class<E> cls, Object obj) {
        checkIfValid();
        return createObjectInternal(cls, obj, true, Collections.emptyList());
    }

    <E extends RealmModel> E createObjectInternal(Class<E> cls, Object obj, boolean z, List<String> list) {
        return this.configuration.getSchemaMediator().newInstance(cls, this, OsObject.createWithPrimaryKey(this.schema.getTable((Class) cls), obj), this.schema.getColumnInfo((Class) cls), z, list);
    }

    public <E extends RealmModel> E copyToRealm(E e) {
        checkNotNullObject(e);
        return copyOrUpdate(e, false, new HashMap());
    }

    public <E extends RealmModel> E copyToRealmOrUpdate(E e) {
        checkNotNullObject(e);
        checkHasPrimaryKey(e.getClass());
        return copyOrUpdate(e, true, new HashMap());
    }

    public <E extends RealmModel> List<E> copyToRealm(Iterable<E> iterable) {
        if (iterable == null) {
            return new ArrayList();
        }
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (E e : iterable) {
            checkNotNullObject(e);
            arrayList.add(copyOrUpdate(e, false, hashMap));
        }
        return arrayList;
    }

    public void insert(Collection<? extends RealmModel> collection) {
        checkIfValidAndInTransaction();
        if (collection == null) {
            throw new IllegalArgumentException("Null objects cannot be inserted into Realm.");
        } else if (!collection.isEmpty()) {
            this.configuration.getSchemaMediator().insert(this, collection);
        }
    }

    public void insert(RealmModel realmModel) {
        checkIfValidAndInTransaction();
        if (realmModel != null) {
            this.configuration.getSchemaMediator().insert(this, realmModel, new HashMap());
            return;
        }
        throw new IllegalArgumentException("Null object cannot be inserted into Realm.");
    }

    public void insertOrUpdate(Collection<? extends RealmModel> collection) {
        checkIfValidAndInTransaction();
        if (collection == null) {
            throw new IllegalArgumentException("Null objects cannot be inserted into Realm.");
        } else if (!collection.isEmpty()) {
            this.configuration.getSchemaMediator().insertOrUpdate(this, collection);
        }
    }

    public void insertOrUpdate(RealmModel realmModel) {
        checkIfValidAndInTransaction();
        if (realmModel != null) {
            this.configuration.getSchemaMediator().insertOrUpdate(this, realmModel, new HashMap());
            return;
        }
        throw new IllegalArgumentException("Null object cannot be inserted into Realm.");
    }

    public <E extends RealmModel> List<E> copyToRealmOrUpdate(Iterable<E> iterable) {
        if (iterable == null) {
            return new ArrayList(0);
        }
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (E e : iterable) {
            checkNotNullObject(e);
            arrayList.add(copyOrUpdate(e, true, hashMap));
        }
        return arrayList;
    }

    public <E extends RealmModel> List<E> copyFromRealm(Iterable<E> iterable) {
        return copyFromRealm((Iterable) iterable, Integer.MAX_VALUE);
    }

    public <E extends RealmModel> List<E> copyFromRealm(Iterable<E> iterable, int i) {
        checkMaxDepth(i);
        if (iterable == null) {
            return new ArrayList(0);
        }
        List arrayList = new ArrayList();
        Map hashMap = new HashMap();
        for (E e : iterable) {
            checkValidObjectForDetach(e);
            arrayList.add(createDetachedCopy(e, i, hashMap));
        }
        return arrayList;
    }

    public <E extends RealmModel> E copyFromRealm(E e) {
        return copyFromRealm((RealmModel) e, Integer.MAX_VALUE);
    }

    public <E extends RealmModel> E copyFromRealm(E e, int i) {
        checkMaxDepth(i);
        checkValidObjectForDetach(e);
        return createDetachedCopy(e, i, new HashMap());
    }

    public <E extends RealmModel> RealmQuery<E> where(Class<E> cls) {
        checkIfValid();
        return RealmQuery.createQuery(this, cls);
    }

    public void addChangeListener(RealmChangeListener<Realm> realmChangeListener) {
        addListener(realmChangeListener);
    }

    public void removeChangeListener(RealmChangeListener<Realm> realmChangeListener) {
        removeListener(realmChangeListener);
    }

    public void removeAllChangeListeners() {
        removeAllListeners();
    }

    public void executeTransaction(Transaction transaction) {
        if (transaction != null) {
            beginTransaction();
            try {
                transaction.execute(this);
                commitTransaction();
            } catch (Throwable th) {
                if (isInTransaction()) {
                    cancelTransaction();
                } else {
                    RealmLog.warn("Could not cancel transaction, not currently in a transaction.", new Object[0]);
                }
            }
        } else {
            throw new IllegalArgumentException("Transaction should not be null");
        }
    }

    public RealmAsyncTask executeTransactionAsync(Transaction transaction) {
        return executeTransactionAsync(transaction, null, null);
    }

    public RealmAsyncTask executeTransactionAsync(Transaction transaction, OnSuccess onSuccess) {
        if (onSuccess != null) {
            return executeTransactionAsync(transaction, onSuccess, null);
        }
        throw new IllegalArgumentException("onSuccess callback can't be null");
    }

    public RealmAsyncTask executeTransactionAsync(Transaction transaction, OnError onError) {
        if (onError != null) {
            return executeTransactionAsync(transaction, null, onError);
        }
        throw new IllegalArgumentException("onError callback can't be null");
    }

    public RealmAsyncTask executeTransactionAsync(Transaction transaction, OnSuccess onSuccess, OnError onError) {
        checkIfValid();
        if (transaction != null) {
            final boolean canDeliverNotification = this.sharedRealm.capabilities.canDeliverNotification();
            if (!(onSuccess == null && onError == null)) {
                this.sharedRealm.capabilities.checkCanDeliverNotification("Callback cannot be delivered on current thread.");
            }
            final RealmConfiguration configuration = getConfiguration();
            final RealmNotifier realmNotifier = this.sharedRealm.realmNotifier;
            final Transaction transaction2 = transaction;
            final OnSuccess onSuccess2 = onSuccess;
            final OnError onError2 = onError;
            return new RealmAsyncTaskImpl(asyncTaskExecutor.submitTransaction(new Runnable() {
                public void run() {
                    if (!Thread.currentThread().isInterrupted()) {
                        Realm instance = Realm.getInstance(configuration);
                        instance.beginTransaction();
                        Throwable th = null;
                        VersionID versionID;
                        try {
                            transaction2.execute(instance);
                            if (Thread.currentThread().isInterrupted()) {
                                try {
                                    if (instance.isInTransaction()) {
                                        instance.cancelTransaction();
                                    }
                                    instance.close();
                                } catch (Throwable th2) {
                                    instance.close();
                                }
                            } else {
                                instance.commitTransaction();
                                versionID = instance.sharedRealm.getVersionID();
                                try {
                                    if (instance.isInTransaction()) {
                                        instance.cancelTransaction();
                                    }
                                    instance.close();
                                    if (canDeliverNotification) {
                                        if (versionID != null && onSuccess2 != null) {
                                            realmNotifier.post(new Runnable() {

                                                class C09851 implements Runnable {
                                                    C09851() {
                                                    }

                                                    public void run() {
                                                        onSuccess2.onSuccess();
                                                    }
                                                }

                                                public void run() {
                                                    if (Realm.this.isClosed()) {
                                                        onSuccess2.onSuccess();
                                                        return;
                                                    }
                                                    if (Realm.this.sharedRealm.getVersionID().compareTo(versionID) < 0) {
                                                        Realm.this.sharedRealm.realmNotifier.addTransactionCallback(new C09851());
                                                    } else {
                                                        onSuccess2.onSuccess();
                                                    }
                                                }
                                            });
                                        } else if (th != null) {
                                            realmNotifier.post(new Runnable() {
                                                public void run() {
                                                    if (onError2 != null) {
                                                        onError2.onError(th);
                                                    } else {
                                                        throw new RealmException("Async transaction failed", th);
                                                    }
                                                }
                                            });
                                        }
                                    } else if (th != null) {
                                        throw new RealmException("Async transaction failed", th);
                                    }
                                } catch (Throwable th3) {
                                    instance.close();
                                }
                            }
                        } catch (Throwable th4) {
                            instance.close();
                        }
                    }
                }
            }), asyncTaskExecutor);
        }
        throw new IllegalArgumentException("Transaction should not be null");
    }

    public void delete(Class<? extends RealmModel> cls) {
        checkIfValid();
        this.schema.getTable((Class) cls).clear();
    }

    private <E extends RealmModel> E copyOrUpdate(E e, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        checkIfValid();
        return this.configuration.getSchemaMediator().copyOrUpdate(this, e, z, map);
    }

    private <E extends RealmModel> E createDetachedCopy(E e, int i, Map<RealmModel, CacheData<RealmModel>> map) {
        checkIfValid();
        return this.configuration.getSchemaMediator().createDetachedCopy(e, i, map);
    }

    private <E extends RealmModel> void checkNotNullObject(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Null objects cannot be copied into Realm.");
        }
    }

    private void checkHasPrimaryKey(Class<? extends RealmModel> cls) {
        if (!this.schema.getTable((Class) cls).hasPrimaryKey()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("A RealmObject with no @PrimaryKey cannot be updated: ");
            stringBuilder.append(cls.toString());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private void checkMaxDepth(int i) {
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("maxDepth must be > 0. It was: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private <E extends RealmModel> void checkValidObjectForDetach(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Null objects cannot be copied from Realm.");
        } else if (!RealmObject.isManaged(e) || !RealmObject.isValid(e)) {
            throw new IllegalArgumentException("Only valid managed objects can be copied from Realm.");
        } else if ((e instanceof DynamicRealmObject) != null) {
            throw new IllegalArgumentException("DynamicRealmObject cannot be copied from Realm.");
        }
    }

    public static void migrateRealm(RealmConfiguration realmConfiguration) throws FileNotFoundException {
        migrateRealm(realmConfiguration, (RealmMigration) null);
    }

    private static void migrateRealm(RealmConfiguration realmConfiguration, RealmMigrationNeededException realmMigrationNeededException) throws FileNotFoundException {
        BaseRealm.migrateRealm(realmConfiguration, null, new C10412(), realmMigrationNeededException);
    }

    public static void migrateRealm(RealmConfiguration realmConfiguration, RealmMigration realmMigration) throws FileNotFoundException {
        BaseRealm.migrateRealm(realmConfiguration, realmMigration, new C10423(), null);
    }

    public static boolean deleteRealm(RealmConfiguration realmConfiguration) {
        return BaseRealm.deleteRealm(realmConfiguration);
    }

    public static boolean compactRealm(RealmConfiguration realmConfiguration) {
        if (!realmConfiguration.isSyncConfiguration()) {
            return BaseRealm.compactRealm(realmConfiguration);
        }
        throw new UnsupportedOperationException("Compacting is not supported yet on synced Realms. See https://github.com/realm/realm-core/issues/2345");
    }

    Table getTable(Class<? extends RealmModel> cls) {
        return this.schema.getTable((Class) cls);
    }

    ColumnIndices updateSchemaCache(ColumnIndices[] columnIndicesArr) {
        long schemaVersion = this.sharedRealm.getSchemaVersion();
        ColumnIndices columnIndices = null;
        if (schemaVersion == this.schema.getSchemaVersion()) {
            return null;
        }
        columnIndicesArr = RealmCache.findColumnIndices(columnIndicesArr, schemaVersion);
        if (columnIndicesArr == null) {
            columnIndicesArr = getConfiguration().getSchemaMediator();
            Set<Class> modelClasses = columnIndicesArr.getModelClasses();
            Map hashMap = new HashMap(modelClasses.size());
            try {
                for (Class cls : modelClasses) {
                    hashMap.put(Pair.create(cls, Table.getClassNameForTable(columnIndicesArr.getTableName(cls))), columnIndicesArr.validateTable(cls, this.sharedRealm, true));
                }
                columnIndices = new ColumnIndices(schemaVersion, hashMap);
                columnIndicesArr = columnIndices;
            } catch (ColumnIndices[] columnIndicesArr2) {
                throw columnIndicesArr2;
            }
        }
        this.schema.updateColumnIndices(columnIndicesArr2);
        return columnIndices;
    }

    public static java.lang.Object getDefaultModule() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "io.realm.DefaultRealmModule";
        r1 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0060, InvocationTargetException -> 0x0048, InstantiationException -> 0x0030, IllegalAccessException -> 0x0018 }
        r1 = r1.getDeclaredConstructors();	 Catch:{ ClassNotFoundException -> 0x0060, InvocationTargetException -> 0x0048, InstantiationException -> 0x0030, IllegalAccessException -> 0x0018 }
        r2 = 0;	 Catch:{ ClassNotFoundException -> 0x0060, InvocationTargetException -> 0x0048, InstantiationException -> 0x0030, IllegalAccessException -> 0x0018 }
        r1 = r1[r2];	 Catch:{ ClassNotFoundException -> 0x0060, InvocationTargetException -> 0x0048, InstantiationException -> 0x0030, IllegalAccessException -> 0x0018 }
        r3 = 1;	 Catch:{ ClassNotFoundException -> 0x0060, InvocationTargetException -> 0x0048, InstantiationException -> 0x0030, IllegalAccessException -> 0x0018 }
        r1.setAccessible(r3);	 Catch:{ ClassNotFoundException -> 0x0060, InvocationTargetException -> 0x0048, InstantiationException -> 0x0030, IllegalAccessException -> 0x0018 }
        r2 = new java.lang.Object[r2];	 Catch:{ ClassNotFoundException -> 0x0060, InvocationTargetException -> 0x0048, InstantiationException -> 0x0030, IllegalAccessException -> 0x0018 }
        r1 = r1.newInstance(r2);	 Catch:{ ClassNotFoundException -> 0x0060, InvocationTargetException -> 0x0048, InstantiationException -> 0x0030, IllegalAccessException -> 0x0018 }
        return r1;
    L_0x0018:
        r1 = move-exception;
        r2 = new io.realm.exceptions.RealmException;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Could not create an instance of ";
        r3.append(r4);
        r3.append(r0);
        r0 = r3.toString();
        r2.<init>(r0, r1);
        throw r2;
    L_0x0030:
        r1 = move-exception;
        r2 = new io.realm.exceptions.RealmException;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Could not create an instance of ";
        r3.append(r4);
        r3.append(r0);
        r0 = r3.toString();
        r2.<init>(r0, r1);
        throw r2;
    L_0x0048:
        r1 = move-exception;
        r2 = new io.realm.exceptions.RealmException;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Could not create an instance of ";
        r3.append(r4);
        r3.append(r0);
        r0 = r3.toString();
        r2.<init>(r0, r1);
        throw r2;
    L_0x0060:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.Realm.getDefaultModule():java.lang.Object");
    }

    public static int getGlobalInstanceCount(RealmConfiguration realmConfiguration) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        RealmCache.invokeWithGlobalRefCount(realmConfiguration, new C10434(atomicInteger));
        return atomicInteger.get();
    }

    public static int getLocalInstanceCount(RealmConfiguration realmConfiguration) {
        return RealmCache.getLocalThreadCount(realmConfiguration);
    }
}
