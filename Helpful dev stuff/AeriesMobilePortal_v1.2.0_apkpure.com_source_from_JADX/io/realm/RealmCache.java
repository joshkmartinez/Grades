package io.realm;

import io.realm.BaseRealm.InstanceCallback;
import io.realm.internal.Capabilities;
import io.realm.internal.ColumnIndices;
import io.realm.internal.ObjectServerFacade;
import io.realm.internal.RealmNotifier;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.Util;
import io.realm.internal.android.AndroidCapabilities;
import io.realm.internal.android.AndroidRealmNotifier;
import io.realm.internal.async.RealmAsyncTaskImpl;
import io.realm.log.RealmLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.LongCompanionObject;

final class RealmCache {
    private static final String ASYNC_CALLBACK_NULL_MSG = "The callback cannot be null.";
    private static final String ASYNC_NOT_ALLOWED_MSG = "Realm instances cannot be loaded asynchronously on a non-looper thread.";
    private static final String DIFFERENT_KEY_MESSAGE = "Wrong key used to decrypt Realm.";
    private static final int MAX_ENTRIES_IN_TYPED_COLUMN_INDICES_ARRAY = 4;
    private static final String WRONG_REALM_CLASS_MESSAGE = "The type of Realm class must be Realm or DynamicRealm.";
    private static final List<WeakReference<RealmCache>> cachesList = new LinkedList();
    private static final Collection<RealmCache> leakedCaches = new ConcurrentLinkedQueue();
    private RealmConfiguration configuration;
    private final AtomicBoolean isLeaked;
    private final String realmPath;
    private final EnumMap<RealmCacheType, RefAndCount> refAndCountMap;
    private final ColumnIndices[] typedColumnIndicesArray = new ColumnIndices[4];

    interface Callback0 {
        void onCall();
    }

    interface Callback {
        void onResult(int i);
    }

    private static class CreateRealmRunnable<T extends BaseRealm> implements Runnable {
        private final InstanceCallback<T> callback;
        private final CountDownLatch canReleaseBackgroundInstanceLatch = new CountDownLatch(1);
        private final RealmConfiguration configuration;
        private Future future;
        private final RealmNotifier notifier;
        private final Class<T> realmClass;

        class C09901 implements Runnable {
            C09901() {
            }

            public void run() {
                BaseRealm createRealmOrGetFromCache;
                if (CreateRealmRunnable.this.future != null) {
                    if (!CreateRealmRunnable.this.future.isCancelled()) {
                        Throwable th;
                        BaseRealm baseRealm = null;
                        try {
                            createRealmOrGetFromCache = RealmCache.createRealmOrGetFromCache(CreateRealmRunnable.this.configuration, CreateRealmRunnable.this.realmClass);
                            BaseRealm baseRealm2 = createRealmOrGetFromCache;
                            th = null;
                            baseRealm = baseRealm2;
                        } catch (Throwable th2) {
                            th = th2;
                        } finally {
                            createRealmOrGetFromCache = CreateRealmRunnable.this.canReleaseBackgroundInstanceLatch;
                            createRealmOrGetFromCache.countDown();
                        }
                        if (baseRealm != null) {
                            CreateRealmRunnable.this.callback.onSuccess(baseRealm);
                        } else {
                            CreateRealmRunnable.this.callback.onError(th);
                        }
                        return;
                    }
                }
                CreateRealmRunnable.this.canReleaseBackgroundInstanceLatch.countDown();
            }
        }

        CreateRealmRunnable(RealmNotifier realmNotifier, RealmConfiguration realmConfiguration, InstanceCallback<T> instanceCallback, Class<T> cls) {
            this.configuration = realmConfiguration;
            this.realmClass = cls;
            this.callback = instanceCallback;
            this.notifier = realmNotifier;
        }

        public void setFuture(Future future) {
            this.future = future;
        }

        public void run() {
            Throwable e;
            Throwable th;
            Throwable th2;
            BaseRealm createRealmOrGetFromCache;
            try {
                createRealmOrGetFromCache = RealmCache.createRealmOrGetFromCache(this.configuration, this.realmClass);
                try {
                    if (!this.notifier.post(new C09901())) {
                        this.canReleaseBackgroundInstanceLatch.countDown();
                    }
                    if (!this.canReleaseBackgroundInstanceLatch.await(2, TimeUnit.SECONDS)) {
                        RealmLog.warn("Timeout for creating Realm instance in foreground thread in `CreateRealmRunnable` ", new Object[0]);
                    }
                    if (createRealmOrGetFromCache != null) {
                        createRealmOrGetFromCache.close();
                    }
                } catch (InterruptedException e2) {
                    e = e2;
                    RealmLog.warn(e, "`CreateRealmRunnable` has been interrupted.", new Object[0]);
                    if (createRealmOrGetFromCache == null) {
                        return;
                    }
                    createRealmOrGetFromCache.close();
                } catch (Throwable th3) {
                    e = th3;
                    if (!ObjectServerFacade.getSyncFacadeIfPossible().wasDownloadInterrupted(e)) {
                        RealmLog.error(e, "`CreateRealmRunnable` failed.", new Object[0]);
                        this.notifier.post(new Runnable() {
                            public void run() {
                                CreateRealmRunnable.this.callback.onError(e);
                            }
                        });
                    }
                    if (createRealmOrGetFromCache != null) {
                        createRealmOrGetFromCache.close();
                    }
                }
            } catch (Throwable e3) {
                th = e3;
                createRealmOrGetFromCache = null;
                e = th;
                RealmLog.warn(e, "`CreateRealmRunnable` has been interrupted.", new Object[0]);
                if (createRealmOrGetFromCache == null) {
                    return;
                }
                createRealmOrGetFromCache.close();
            } catch (Throwable th4) {
                th2 = th4;
                if (createRealmOrGetFromCache != null) {
                    createRealmOrGetFromCache.close();
                }
                throw th2;
            }
        }
    }

    private enum RealmCacheType {
        TYPED_REALM,
        DYNAMIC_REALM;

        static RealmCacheType valueOf(Class<? extends BaseRealm> cls) {
            if (cls == Realm.class) {
                return TYPED_REALM;
            }
            if (cls == DynamicRealm.class) {
                return DYNAMIC_REALM;
            }
            throw new IllegalArgumentException(RealmCache.WRONG_REALM_CLASS_MESSAGE);
        }
    }

    private static class RefAndCount {
        private int globalCount;
        private final ThreadLocal<Integer> localCount;
        private final ThreadLocal<BaseRealm> localRealm;

        private RefAndCount() {
            this.localRealm = new ThreadLocal();
            this.localCount = new ThreadLocal();
            this.globalCount = 0;
        }
    }

    private RealmCache(String str) {
        int i = 0;
        this.isLeaked = new AtomicBoolean(false);
        this.realmPath = str;
        this.refAndCountMap = new EnumMap(RealmCacheType.class);
        str = RealmCacheType.values();
        int length = str.length;
        while (i < length) {
            this.refAndCountMap.put(str[i], new RefAndCount());
            i++;
        }
    }

    private static RealmCache getCache(String str, boolean z) {
        RealmCache realmCache;
        synchronized (cachesList) {
            Iterator it = cachesList.iterator();
            realmCache = null;
            while (it.hasNext()) {
                RealmCache realmCache2 = (RealmCache) ((WeakReference) it.next()).get();
                if (realmCache2 == null) {
                    it.remove();
                } else if (realmCache2.realmPath.equals(str)) {
                    realmCache = realmCache2;
                }
            }
            if (realmCache == null && z) {
                realmCache = new RealmCache(str);
                cachesList.add(new WeakReference(realmCache));
            }
        }
        return realmCache;
    }

    static <T extends BaseRealm> RealmAsyncTask createRealmOrGetFromCacheAsync(RealmConfiguration realmConfiguration, InstanceCallback<T> instanceCallback, Class<T> cls) {
        return getCache(realmConfiguration.getPath(), true).doCreateRealmOrGetFromCacheAsync(realmConfiguration, instanceCallback, cls);
    }

    private synchronized <T extends BaseRealm> RealmAsyncTask doCreateRealmOrGetFromCacheAsync(RealmConfiguration realmConfiguration, InstanceCallback<T> instanceCallback, Class<T> cls) {
        Capabilities androidCapabilities = new AndroidCapabilities();
        androidCapabilities.checkCanDeliverNotification(ASYNC_NOT_ALLOWED_MSG);
        if (instanceCallback != null) {
            Object createRealmRunnable = new CreateRealmRunnable(new AndroidRealmNotifier(null, androidCapabilities), realmConfiguration, instanceCallback, cls);
            realmConfiguration = BaseRealm.asyncTaskExecutor.submitTransaction(createRealmRunnable);
            createRealmRunnable.setFuture(realmConfiguration);
        } else {
            throw new IllegalArgumentException(ASYNC_CALLBACK_NULL_MSG);
        }
        return new RealmAsyncTaskImpl(realmConfiguration, BaseRealm.asyncTaskExecutor);
    }

    static <E extends BaseRealm> E createRealmOrGetFromCache(RealmConfiguration realmConfiguration, Class<E> cls) {
        return getCache(realmConfiguration.getPath(), true).doCreateRealmOrGetFromCache(realmConfiguration, cls);
    }

    private synchronized <E extends BaseRealm> E doCreateRealmOrGetFromCache(RealmConfiguration realmConfiguration, Class<E> cls) {
        RefAndCount refAndCount;
        refAndCount = (RefAndCount) this.refAndCountMap.get(RealmCacheType.valueOf((Class) cls));
        if (getTotalGlobalRefCount() == 0) {
            copyAssetFileIfNeeded(realmConfiguration);
            boolean realmExists = realmConfiguration.realmExists();
            SharedRealm instance;
            try {
                instance = SharedRealm.getInstance(realmConfiguration);
                if (!realmExists) {
                    ObjectServerFacade.getSyncFacadeIfPossible().downloadRemoteChanges(realmConfiguration);
                }
                if (Table.primaryKeyTableNeedsMigration(instance)) {
                    instance.beginTransaction();
                    if (Table.migratePrimaryKeyTableIfNeeded(instance)) {
                        instance.commitTransaction();
                    } else {
                        instance.cancelTransaction();
                    }
                }
                if (instance != null) {
                    instance.close();
                }
                this.configuration = realmConfiguration;
            } catch (Throwable th) {
                realmConfiguration = th;
                instance = null;
                if (instance != null) {
                    instance.close();
                }
                throw realmConfiguration;
            }
        }
        validateConfiguration(realmConfiguration);
        if (refAndCount.localRealm.get() == null) {
            if (cls == Realm.class) {
                realmConfiguration = Realm.createInstance(this);
            } else if (cls == DynamicRealm.class) {
                realmConfiguration = DynamicRealm.createInstance(this);
            } else {
                throw new IllegalArgumentException(WRONG_REALM_CLASS_MESSAGE);
            }
            refAndCount.localRealm.set(realmConfiguration);
            refAndCount.localCount.set(Integer.valueOf(0));
            if (cls == Realm.class && refAndCount.globalCount == null) {
                storeColumnIndices(this.typedColumnIndicesArray, realmConfiguration.schema.getImmutableColumnIndicies());
            }
            refAndCount.globalCount = refAndCount.globalCount + 1;
        }
        refAndCount.localCount.set(Integer.valueOf(((Integer) refAndCount.localCount.get()).intValue() + 1));
        return (BaseRealm) refAndCount.localRealm.get();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized void release(io.realm.BaseRealm r7) {
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = r7.getPath();	 Catch:{ all -> 0x00b5 }
        r1 = r6.refAndCountMap;	 Catch:{ all -> 0x00b5 }
        r2 = r7.getClass();	 Catch:{ all -> 0x00b5 }
        r2 = io.realm.RealmCache.RealmCacheType.valueOf(r2);	 Catch:{ all -> 0x00b5 }
        r1 = r1.get(r2);	 Catch:{ all -> 0x00b5 }
        r1 = (io.realm.RealmCache.RefAndCount) r1;	 Catch:{ all -> 0x00b5 }
        r2 = r1.localCount;	 Catch:{ all -> 0x00b5 }
        r2 = r2.get();	 Catch:{ all -> 0x00b5 }
        r2 = (java.lang.Integer) r2;	 Catch:{ all -> 0x00b5 }
        r3 = 0;
        if (r2 != 0) goto L_0x0026;
    L_0x0022:
        r2 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x00b5 }
    L_0x0026:
        r4 = r2.intValue();	 Catch:{ all -> 0x00b5 }
        r5 = 1;
        if (r4 > 0) goto L_0x003b;
    L_0x002d:
        r7 = "%s has been closed already. refCount is %s";
        r1 = 2;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x00b5 }
        r1[r3] = r0;	 Catch:{ all -> 0x00b5 }
        r1[r5] = r2;	 Catch:{ all -> 0x00b5 }
        io.realm.log.RealmLog.warn(r7, r1);	 Catch:{ all -> 0x00b5 }
        monitor-exit(r6);
        return;
    L_0x003b:
        r2 = r2.intValue();	 Catch:{ all -> 0x00b5 }
        r2 = r2 - r5;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x00b5 }
        r3 = r2.intValue();	 Catch:{ all -> 0x00b5 }
        if (r3 != 0) goto L_0x00ac;
    L_0x004a:
        r2 = r1.localCount;	 Catch:{ all -> 0x00b5 }
        r3 = 0;
        r2.set(r3);	 Catch:{ all -> 0x00b5 }
        r2 = r1.localRealm;	 Catch:{ all -> 0x00b5 }
        r2.set(r3);	 Catch:{ all -> 0x00b5 }
        r1.globalCount = r1.globalCount - 1;	 Catch:{ all -> 0x00b5 }
        r2 = r1.globalCount;	 Catch:{ all -> 0x00b5 }
        if (r2 < 0) goto L_0x0090;
    L_0x0062:
        r0 = r7 instanceof io.realm.Realm;	 Catch:{ all -> 0x00b5 }
        if (r0 == 0) goto L_0x0071;
    L_0x0066:
        r0 = r1.globalCount;	 Catch:{ all -> 0x00b5 }
        if (r0 != 0) goto L_0x0071;
    L_0x006c:
        r0 = r6.typedColumnIndicesArray;	 Catch:{ all -> 0x00b5 }
        java.util.Arrays.fill(r0, r3);	 Catch:{ all -> 0x00b5 }
    L_0x0071:
        r7.doClose();	 Catch:{ all -> 0x00b5 }
        r0 = r6.getTotalGlobalRefCount();	 Catch:{ all -> 0x00b5 }
        if (r0 != 0) goto L_0x00b3;
    L_0x007a:
        r6.configuration = r3;	 Catch:{ all -> 0x00b5 }
        r0 = r7.getConfiguration();	 Catch:{ all -> 0x00b5 }
        r0 = r0.isSyncConfiguration();	 Catch:{ all -> 0x00b5 }
        r0 = io.realm.internal.ObjectServerFacade.getFacade(r0);	 Catch:{ all -> 0x00b5 }
        r7 = r7.getConfiguration();	 Catch:{ all -> 0x00b5 }
        r0.realmClosed(r7);	 Catch:{ all -> 0x00b5 }
        goto L_0x00b3;
    L_0x0090:
        r7 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x00b5 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b5 }
        r1.<init>();	 Catch:{ all -> 0x00b5 }
        r2 = "Global reference counter of Realm";
        r1.append(r2);	 Catch:{ all -> 0x00b5 }
        r1.append(r0);	 Catch:{ all -> 0x00b5 }
        r0 = " got corrupted.";
        r1.append(r0);	 Catch:{ all -> 0x00b5 }
        r0 = r1.toString();	 Catch:{ all -> 0x00b5 }
        r7.<init>(r0);	 Catch:{ all -> 0x00b5 }
        throw r7;	 Catch:{ all -> 0x00b5 }
    L_0x00ac:
        r7 = r1.localCount;	 Catch:{ all -> 0x00b5 }
        r7.set(r2);	 Catch:{ all -> 0x00b5 }
    L_0x00b3:
        monitor-exit(r6);
        return;
    L_0x00b5:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.RealmCache.release(io.realm.BaseRealm):void");
    }

    private void validateConfiguration(RealmConfiguration realmConfiguration) {
        if (!this.configuration.equals(realmConfiguration)) {
            if (Arrays.equals(this.configuration.getEncryptionKey(), realmConfiguration.getEncryptionKey())) {
                RealmMigration migration = realmConfiguration.getMigration();
                RealmMigration migration2 = this.configuration.getMigration();
                StringBuilder stringBuilder;
                if (migration2 == null || migration == null || !migration2.getClass().equals(migration.getClass()) || migration.equals(migration2)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Configurations cannot be different if used to open the same file. \nCached configuration: \n");
                    stringBuilder.append(this.configuration);
                    stringBuilder.append("\n\nNew configuration: \n");
                    stringBuilder.append(realmConfiguration);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Configurations cannot be different if used to open the same file. The most likely cause is that equals() and hashCode() are not overridden in the migration class: ");
                stringBuilder.append(realmConfiguration.getMigration().getClass().getCanonicalName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            throw new IllegalArgumentException(DIFFERENT_KEY_MESSAGE);
        }
    }

    static void invokeWithGlobalRefCount(RealmConfiguration realmConfiguration, Callback callback) {
        synchronized (cachesList) {
            realmConfiguration = getCache(realmConfiguration.getPath(), false);
            if (realmConfiguration == null) {
                callback.onResult(0);
                return;
            }
            realmConfiguration.doInvokeWithGlobalRefCount(callback);
        }
    }

    private synchronized void doInvokeWithGlobalRefCount(Callback callback) {
        callback.onResult(getTotalGlobalRefCount());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized void updateSchemaCache(io.realm.Realm r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.refAndCountMap;	 Catch:{ all -> 0x0024 }
        r1 = io.realm.RealmCache.RealmCacheType.TYPED_REALM;	 Catch:{ all -> 0x0024 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0024 }
        r0 = (io.realm.RealmCache.RefAndCount) r0;	 Catch:{ all -> 0x0024 }
        r0 = r0.localRealm;	 Catch:{ all -> 0x0024 }
        r0 = r0.get();	 Catch:{ all -> 0x0024 }
        if (r0 != 0) goto L_0x0017;
    L_0x0015:
        monitor-exit(r2);
        return;
    L_0x0017:
        r0 = r2.typedColumnIndicesArray;	 Catch:{ all -> 0x0024 }
        r3 = r3.updateSchemaCache(r0);	 Catch:{ all -> 0x0024 }
        if (r3 == 0) goto L_0x0022;
    L_0x001f:
        storeColumnIndices(r0, r3);	 Catch:{ all -> 0x0024 }
    L_0x0022:
        monitor-exit(r2);
        return;
    L_0x0024:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.RealmCache.updateSchemaCache(io.realm.Realm):void");
    }

    synchronized void invokeWithLock(Callback0 callback0) {
        callback0.onCall();
    }

    private static void copyAssetFileIfNeeded(RealmConfiguration realmConfiguration) {
        if (realmConfiguration.hasAssetFile()) {
            copyFileIfNeeded(realmConfiguration.getAssetFilePath(), new File(realmConfiguration.getRealmDirectory(), realmConfiguration.getRealmFileName()));
        }
        String syncServerCertificateAssetName = ObjectServerFacade.getFacade(realmConfiguration.isSyncConfiguration()).getSyncServerCertificateAssetName(realmConfiguration);
        if (!Util.isEmptyString(syncServerCertificateAssetName)) {
            copyFileIfNeeded(syncServerCertificateAssetName, new File(ObjectServerFacade.getFacade(realmConfiguration.isSyncConfiguration()).getSyncServerCertificateFilePath(realmConfiguration)));
        }
    }

    private static void copyFileIfNeeded(java.lang.String r7, java.io.File r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r8.exists();
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = 0;
        r1 = io.realm.BaseRealm.applicationContext;	 Catch:{ IOException -> 0x0068, all -> 0x0064 }
        r1 = r1.getAssets();	 Catch:{ IOException -> 0x0068, all -> 0x0064 }
        r1 = r1.open(r7);	 Catch:{ IOException -> 0x0068, all -> 0x0064 }
        if (r1 == 0) goto L_0x0045;
    L_0x0014:
        r2 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0061, all -> 0x005e }
        r2.<init>(r8);	 Catch:{ IOException -> 0x0061, all -> 0x005e }
        r8 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r8 = new byte[r8];	 Catch:{ IOException -> 0x0043 }
    L_0x001d:
        r3 = r1.read(r8);	 Catch:{ IOException -> 0x0043 }
        r4 = -1;	 Catch:{ IOException -> 0x0043 }
        if (r3 <= r4) goto L_0x0029;	 Catch:{ IOException -> 0x0043 }
    L_0x0024:
        r4 = 0;	 Catch:{ IOException -> 0x0043 }
        r2.write(r8, r4, r3);	 Catch:{ IOException -> 0x0043 }
        goto L_0x001d;
    L_0x0029:
        if (r1 == 0) goto L_0x0030;
    L_0x002b:
        r1.close();	 Catch:{ IOException -> 0x002f }
        goto L_0x0030;
    L_0x002f:
        r0 = move-exception;
    L_0x0030:
        r2.close();	 Catch:{ IOException -> 0x0034 }
        goto L_0x0038;
    L_0x0034:
        r7 = move-exception;
        if (r0 != 0) goto L_0x0038;
    L_0x0037:
        r0 = r7;
    L_0x0038:
        if (r0 != 0) goto L_0x003b;
    L_0x003a:
        return;
    L_0x003b:
        r7 = new io.realm.exceptions.RealmFileException;
        r8 = io.realm.exceptions.RealmFileException.Kind.ACCESS_ERROR;
        r7.<init>(r8, r0);
        throw r7;
    L_0x0043:
        r8 = move-exception;
        goto L_0x006b;
    L_0x0045:
        r8 = new io.realm.exceptions.RealmFileException;	 Catch:{ IOException -> 0x0061, all -> 0x005e }
        r2 = io.realm.exceptions.RealmFileException.Kind.ACCESS_ERROR;	 Catch:{ IOException -> 0x0061, all -> 0x005e }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0061, all -> 0x005e }
        r3.<init>();	 Catch:{ IOException -> 0x0061, all -> 0x005e }
        r4 = "Invalid input stream to the asset file: ";	 Catch:{ IOException -> 0x0061, all -> 0x005e }
        r3.append(r4);	 Catch:{ IOException -> 0x0061, all -> 0x005e }
        r3.append(r7);	 Catch:{ IOException -> 0x0061, all -> 0x005e }
        r3 = r3.toString();	 Catch:{ IOException -> 0x0061, all -> 0x005e }
        r8.<init>(r2, r3);	 Catch:{ IOException -> 0x0061, all -> 0x005e }
        throw r8;	 Catch:{ IOException -> 0x0061, all -> 0x005e }
    L_0x005e:
        r7 = move-exception;
        r2 = r0;
        goto L_0x0085;
    L_0x0061:
        r8 = move-exception;
        r2 = r0;
        goto L_0x006b;
    L_0x0064:
        r7 = move-exception;
        r1 = r0;
        r2 = r1;
        goto L_0x0085;
    L_0x0068:
        r8 = move-exception;
        r1 = r0;
        r2 = r1;
    L_0x006b:
        r3 = new io.realm.exceptions.RealmFileException;	 Catch:{ all -> 0x0084 }
        r4 = io.realm.exceptions.RealmFileException.Kind.ACCESS_ERROR;	 Catch:{ all -> 0x0084 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0084 }
        r5.<init>();	 Catch:{ all -> 0x0084 }
        r6 = "Could not resolve the path to the asset file: ";	 Catch:{ all -> 0x0084 }
        r5.append(r6);	 Catch:{ all -> 0x0084 }
        r5.append(r7);	 Catch:{ all -> 0x0084 }
        r7 = r5.toString();	 Catch:{ all -> 0x0084 }
        r3.<init>(r4, r7, r8);	 Catch:{ all -> 0x0084 }
        throw r3;	 Catch:{ all -> 0x0084 }
    L_0x0084:
        r7 = move-exception;
    L_0x0085:
        if (r1 == 0) goto L_0x008c;
    L_0x0087:
        r1.close();	 Catch:{ IOException -> 0x008b }
        goto L_0x008c;
    L_0x008b:
        r0 = move-exception;
    L_0x008c:
        if (r2 == 0) goto L_0x0091;
    L_0x008e:
        r2.close();	 Catch:{ IOException -> 0x0091 }
    L_0x0091:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.RealmCache.copyFileIfNeeded(java.lang.String, java.io.File):void");
    }

    static int getLocalThreadCount(RealmConfiguration realmConfiguration) {
        realmConfiguration = getCache(realmConfiguration.getPath(), false);
        if (realmConfiguration == null) {
            return 0;
        }
        int i = 0;
        for (RefAndCount access$700 : realmConfiguration.refAndCountMap.values()) {
            Integer num = (Integer) access$700.localCount.get();
            i += num != null ? num.intValue() : 0;
        }
        return i;
    }

    static ColumnIndices findColumnIndices(ColumnIndices[] columnIndicesArr, long j) {
        for (int length = columnIndicesArr.length - 1; length >= 0; length--) {
            ColumnIndices columnIndices = columnIndicesArr[length];
            if (columnIndices != null && columnIndices.getSchemaVersion() == j) {
                return columnIndices;
            }
        }
        return null;
    }

    private static int storeColumnIndices(ColumnIndices[] columnIndicesArr, ColumnIndices columnIndices) {
        int i = -1;
        long j = LongCompanionObject.MAX_VALUE;
        for (int length = columnIndicesArr.length - 1; length >= 0; length--) {
            if (columnIndicesArr[length] == null) {
                columnIndicesArr[length] = columnIndices;
                return length;
            }
            ColumnIndices columnIndices2 = columnIndicesArr[length];
            if (columnIndices2.getSchemaVersion() <= j) {
                j = columnIndices2.getSchemaVersion();
                i = length;
            }
        }
        columnIndicesArr[i] = columnIndices;
        return i;
    }

    public RealmConfiguration getConfiguration() {
        return this.configuration;
    }

    public ColumnIndices[] getTypedColumnIndicesArray() {
        return this.typedColumnIndicesArray;
    }

    private int getTotalGlobalRefCount() {
        int i = 0;
        for (RefAndCount access$800 : this.refAndCountMap.values()) {
            i += access$800.globalCount;
        }
        return i;
    }

    void leak() {
        if (!this.isLeaked.getAndSet(true)) {
            leakedCaches.add(this);
        }
    }
}
