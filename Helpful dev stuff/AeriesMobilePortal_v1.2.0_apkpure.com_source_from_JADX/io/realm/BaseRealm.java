package io.realm;

import android.content.Context;
import android.os.Looper;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.CheckedRow;
import io.realm.internal.ColumnInfo;
import io.realm.internal.InvalidRow;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.SharedRealm.SchemaVersionListener;
import io.realm.internal.UncheckedRow;
import io.realm.internal.Util;
import io.realm.internal.async.RealmThreadPoolExecutor;
import io.realm.log.RealmLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;

abstract class BaseRealm implements Closeable {
    private static final String CLOSED_REALM_MESSAGE = "This Realm instance has already been closed, making it unusable.";
    private static final String INCORRECT_THREAD_CLOSE_MESSAGE = "Realm access from incorrect thread. Realm instance can only be closed on the thread it was created.";
    private static final String INCORRECT_THREAD_MESSAGE = "Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.";
    static final String LISTENER_NOT_ALLOWED_MESSAGE = "Listeners cannot be used on current thread.";
    private static final String NOT_IN_TRANSACTION_MESSAGE = "Changing Realm data can only be done from inside a transaction.";
    protected static final long UNVERSIONED = -1;
    static volatile Context applicationContext;
    static final RealmThreadPoolExecutor asyncTaskExecutor = RealmThreadPoolExecutor.newDefaultExecutor();
    public static final ThreadLocalRealmObjectContext objectContext = new ThreadLocalRealmObjectContext();
    protected final RealmConfiguration configuration;
    private RealmCache realmCache;
    protected final RealmSchema schema;
    protected SharedRealm sharedRealm;
    final long threadId;

    public static abstract class InstanceCallback<T extends BaseRealm> {
        public abstract void onSuccess(T t);

        public void onError(Throwable th) {
            throw new RealmException("Exception happens when initializing Realm in the background thread.", th);
        }
    }

    protected interface MigrationCallback {
        void migrationComplete();
    }

    public static final class RealmObjectContext {
        private boolean acceptDefaultValue;
        private ColumnInfo columnInfo;
        private List<String> excludeFields;
        private BaseRealm realm;
        private Row row;

        public void set(BaseRealm baseRealm, Row row, ColumnInfo columnInfo, boolean z, List<String> list) {
            this.realm = baseRealm;
            this.row = row;
            this.columnInfo = columnInfo;
            this.acceptDefaultValue = z;
            this.excludeFields = list;
        }

        BaseRealm getRealm() {
            return this.realm;
        }

        public Row getRow() {
            return this.row;
        }

        public ColumnInfo getColumnInfo() {
            return this.columnInfo;
        }

        public boolean getAcceptDefaultValue() {
            return this.acceptDefaultValue;
        }

        public List<String> getExcludeFields() {
            return this.excludeFields;
        }

        public void clear() {
            this.realm = null;
            this.row = null;
            this.columnInfo = null;
            this.acceptDefaultValue = false;
            this.excludeFields = null;
        }
    }

    static final class ThreadLocalRealmObjectContext extends ThreadLocal<RealmObjectContext> {
        ThreadLocalRealmObjectContext() {
        }

        protected RealmObjectContext initialValue() {
            return new RealmObjectContext();
        }
    }

    class C10371 implements SchemaVersionListener {
        C10371() {
        }

        public void onSchemaVersionChanged(long j) {
            if (BaseRealm.this.realmCache != null) {
                BaseRealm.this.realmCache.updateSchemaCache((Realm) BaseRealm.this);
            }
        }
    }

    class C10382 implements Callback0 {
        C10382() {
        }

        public void onCall() {
            if (BaseRealm.this.sharedRealm == null || BaseRealm.this.sharedRealm.isClosed()) {
                throw new IllegalStateException(BaseRealm.CLOSED_REALM_MESSAGE);
            }
            BaseRealm.this.sharedRealm.stopWaitForChange();
        }
    }

    class C10393 implements Callback {
        final /* synthetic */ RealmConfiguration val$configuration;
        final /* synthetic */ AtomicBoolean val$realmDeleted;

        C10393(RealmConfiguration realmConfiguration, AtomicBoolean atomicBoolean) {
            this.val$configuration = realmConfiguration;
            this.val$realmDeleted = atomicBoolean;
        }

        public void onResult(int i) {
            if (i == 0) {
                this.val$realmDeleted.set(Util.deleteRealm(this.val$configuration.getPath(), this.val$configuration.getRealmDirectory(), this.val$configuration.getRealmFileName()));
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("It's not allowed to delete the file associated with an open Realm. Remember to close() all the instances of the Realm before deleting its file: ");
            stringBuilder.append(this.val$configuration.getPath());
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    class C10404 implements Callback {
        final /* synthetic */ MigrationCallback val$callback;
        final /* synthetic */ RealmConfiguration val$configuration;
        final /* synthetic */ AtomicBoolean val$fileNotFound;
        final /* synthetic */ RealmMigration val$migration;

        C10404(RealmConfiguration realmConfiguration, AtomicBoolean atomicBoolean, RealmMigration realmMigration, MigrationCallback migrationCallback) {
            this.val$configuration = realmConfiguration;
            this.val$fileNotFound = atomicBoolean;
            this.val$migration = realmMigration;
            this.val$callback = migrationCallback;
        }

        public void onResult(int i) {
            DynamicRealm createInstance;
            if (i != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot migrate a Realm file that is already open: ");
                stringBuilder.append(this.val$configuration.getPath());
                throw new IllegalStateException(stringBuilder.toString());
            } else if (new File(this.val$configuration.getPath()).exists() == 0) {
                this.val$fileNotFound.set(true);
            } else {
                RealmMigration migration = this.val$migration == 0 ? this.val$configuration.getMigration() : this.val$migration;
                try {
                    createInstance = DynamicRealm.createInstance(this.val$configuration);
                    try {
                        createInstance.beginTransaction();
                        migration.migrate(createInstance, createInstance.getVersion(), this.val$configuration.getSchemaVersion());
                        createInstance.setVersion(this.val$configuration.getSchemaVersion());
                        createInstance.commitTransaction();
                        if (createInstance != null) {
                            createInstance.close();
                            this.val$callback.migrationComplete();
                        }
                    } catch (RuntimeException e) {
                        i = e;
                        if (createInstance != null) {
                            try {
                                createInstance.cancelTransaction();
                            } catch (Throwable th) {
                                i = th;
                                if (createInstance != null) {
                                    createInstance.close();
                                    this.val$callback.migrationComplete();
                                }
                                throw i;
                            }
                        }
                        throw i;
                    }
                } catch (RuntimeException e2) {
                    createInstance = null;
                    i = e2;
                    if (createInstance != null) {
                        createInstance.cancelTransaction();
                    }
                    throw i;
                } catch (Throwable th2) {
                    createInstance = null;
                    i = th2;
                    if (createInstance != null) {
                        createInstance.close();
                        this.val$callback.migrationComplete();
                    }
                    throw i;
                }
            }
        }
    }

    public abstract Observable asObservable();

    BaseRealm(RealmCache realmCache) {
        this(realmCache.getConfiguration());
        this.realmCache = realmCache;
    }

    BaseRealm(RealmConfiguration realmConfiguration) {
        this.threadId = Thread.currentThread().getId();
        this.configuration = realmConfiguration;
        SchemaVersionListener schemaVersionListener = null;
        this.realmCache = null;
        if (this instanceof Realm) {
            schemaVersionListener = new C10371();
        }
        this.sharedRealm = SharedRealm.getInstance(realmConfiguration, schemaVersionListener, true);
        this.schema = new RealmSchema(this);
    }

    public void setAutoRefresh(boolean z) {
        checkIfValid();
        this.sharedRealm.setAutoRefresh(z);
    }

    public boolean isAutoRefresh() {
        return this.sharedRealm.isAutoRefresh();
    }

    public void refresh() {
        checkIfValid();
        if (isInTransaction()) {
            throw new IllegalStateException("Cannot refresh a Realm instance inside a transaction.");
        }
        this.sharedRealm.refresh();
    }

    public boolean isInTransaction() {
        checkIfValid();
        return this.sharedRealm.isInTransaction();
    }

    protected <T extends BaseRealm> void addListener(RealmChangeListener<T> realmChangeListener) {
        if (realmChangeListener != null) {
            checkIfValid();
            this.sharedRealm.capabilities.checkCanDeliverNotification(LISTENER_NOT_ALLOWED_MESSAGE);
            this.sharedRealm.realmNotifier.addChangeListener(this, realmChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener should not be null");
    }

    protected <T extends BaseRealm> void removeListener(RealmChangeListener<T> realmChangeListener) {
        if (realmChangeListener != null) {
            checkIfValid();
            this.sharedRealm.capabilities.checkCanDeliverNotification(LISTENER_NOT_ALLOWED_MESSAGE);
            this.sharedRealm.realmNotifier.removeChangeListener(this, realmChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener should not be null");
    }

    protected void removeAllListeners() {
        checkIfValid();
        this.sharedRealm.capabilities.checkCanDeliverNotification("removeListener cannot be called on current thread.");
        this.sharedRealm.realmNotifier.removeChangeListeners(this);
    }

    public void writeCopyTo(File file) {
        writeEncryptedCopyTo(file, null);
    }

    public void writeEncryptedCopyTo(File file, byte[] bArr) {
        if (file != null) {
            checkIfValid();
            this.sharedRealm.writeCopy(file, bArr);
            return;
        }
        throw new IllegalArgumentException("The destination argument cannot be null");
    }

    public boolean waitForChange() {
        checkIfValid();
        if (isInTransaction()) {
            throw new IllegalStateException("Cannot wait for changes inside of a transaction.");
        } else if (Looper.myLooper() == null) {
            boolean waitForChange = this.sharedRealm.waitForChange();
            if (waitForChange) {
                this.sharedRealm.refresh();
            }
            return waitForChange;
        } else {
            throw new IllegalStateException("Cannot wait for changes inside a Looper thread. Use RealmChangeListeners instead.");
        }
    }

    public void stopWaitForChange() {
        if (this.realmCache != null) {
            this.realmCache.invokeWithLock(new C10382());
            return;
        }
        throw new IllegalStateException(CLOSED_REALM_MESSAGE);
    }

    public void beginTransaction() {
        beginTransaction(false);
    }

    void beginTransaction(boolean z) {
        checkIfValid();
        this.sharedRealm.beginTransaction(z);
    }

    public void commitTransaction() {
        checkIfValid();
        this.sharedRealm.commitTransaction();
    }

    public void cancelTransaction() {
        checkIfValid();
        this.sharedRealm.cancelTransaction();
    }

    protected void checkIfValid() {
        if (this.sharedRealm == null || this.sharedRealm.isClosed()) {
            throw new IllegalStateException(CLOSED_REALM_MESSAGE);
        } else if (this.threadId != Thread.currentThread().getId()) {
            throw new IllegalStateException(INCORRECT_THREAD_MESSAGE);
        }
    }

    protected void checkIfInTransaction() {
        if (!this.sharedRealm.isInTransaction()) {
            throw new IllegalStateException(NOT_IN_TRANSACTION_MESSAGE);
        }
    }

    protected void checkIfValidAndInTransaction() {
        if (!isInTransaction()) {
            throw new IllegalStateException(NOT_IN_TRANSACTION_MESSAGE);
        }
    }

    void checkNotInSync() {
        if (this.configuration.isSyncConfiguration()) {
            throw new IllegalArgumentException("You cannot perform changes to a schema. Please update app and restart.");
        }
    }

    public String getPath() {
        return this.configuration.getPath();
    }

    public RealmConfiguration getConfiguration() {
        return this.configuration;
    }

    public long getVersion() {
        return this.sharedRealm.getSchemaVersion();
    }

    public void close() {
        if (this.threadId != Thread.currentThread().getId()) {
            throw new IllegalStateException(INCORRECT_THREAD_CLOSE_MESSAGE);
        } else if (this.realmCache != null) {
            this.realmCache.release(this);
        } else {
            doClose();
        }
    }

    void doClose() {
        this.realmCache = null;
        if (this.sharedRealm != null) {
            this.sharedRealm.close();
            this.sharedRealm = null;
        }
        if (this.schema != null) {
            this.schema.close();
        }
    }

    public boolean isClosed() {
        if (this.threadId == Thread.currentThread().getId()) {
            if (this.sharedRealm != null) {
                if (!this.sharedRealm.isClosed()) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException(INCORRECT_THREAD_MESSAGE);
    }

    public boolean isEmpty() {
        checkIfValid();
        return this.sharedRealm.isEmpty();
    }

    void setVersion(long j) {
        this.sharedRealm.setSchemaVersion(j);
    }

    public RealmSchema getSchema() {
        return this.schema;
    }

    <E extends RealmModel> E get(Class<E> cls, String str, UncheckedRow uncheckedRow) {
        if ((str != null ? true : null) != null) {
            return new DynamicRealmObject(this, CheckedRow.getFromRow(uncheckedRow));
        }
        return this.configuration.getSchemaMediator().newInstance(cls, this, uncheckedRow, this.schema.getColumnInfo((Class) cls), false, Collections.emptyList());
    }

    <E extends RealmModel> E get(Class<E> cls, long j, boolean z, List<String> list) {
        return this.configuration.getSchemaMediator().newInstance(cls, this, this.schema.getTable((Class) cls).getUncheckedRow(j), this.schema.getColumnInfo((Class) cls), z, list);
    }

    <E extends RealmModel> E get(Class<E> cls, String str, long j) {
        Object obj = str != null ? 1 : null;
        str = obj != null ? this.schema.getTable(str) : this.schema.getTable((Class) cls);
        if (obj != null) {
            return new DynamicRealmObject(this, j != -1 ? str.getCheckedRow(j) : InvalidRow.INSTANCE);
        }
        return this.configuration.getSchemaMediator().newInstance(cls, this, j != -1 ? str.getUncheckedRow(j) : InvalidRow.INSTANCE, this.schema.getColumnInfo((Class) cls), false, Collections.emptyList());
    }

    public void deleteAll() {
        checkIfValid();
        for (RealmObjectSchema className : this.schema.getAll()) {
            this.schema.getTable(className.getClassName()).clear();
        }
    }

    static boolean deleteRealm(RealmConfiguration realmConfiguration) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        RealmCache.invokeWithGlobalRefCount(realmConfiguration, new C10393(realmConfiguration, atomicBoolean));
        return atomicBoolean.get();
    }

    static boolean compactRealm(RealmConfiguration realmConfiguration) {
        realmConfiguration = SharedRealm.getInstance(realmConfiguration);
        Boolean valueOf = Boolean.valueOf(realmConfiguration.compact());
        realmConfiguration.close();
        return valueOf.booleanValue();
    }

    protected static void migrateRealm(RealmConfiguration realmConfiguration, RealmMigration realmMigration, MigrationCallback migrationCallback, RealmMigrationNeededException realmMigrationNeededException) throws FileNotFoundException {
        if (realmConfiguration == null) {
            throw new IllegalArgumentException("RealmConfiguration must be provided");
        } else if (realmConfiguration.isSyncConfiguration()) {
            throw new IllegalArgumentException("Manual migrations are not supported for synced Realms");
        } else {
            if (realmMigration == null) {
                if (realmConfiguration.getMigration() == null) {
                    throw new RealmMigrationNeededException(realmConfiguration.getPath(), "RealmMigration must be provided", realmMigrationNeededException);
                }
            }
            realmMigrationNeededException = new AtomicBoolean(false);
            RealmCache.invokeWithGlobalRefCount(realmConfiguration, new C10404(realmConfiguration, realmMigrationNeededException, realmMigration, migrationCallback));
            if (realmMigrationNeededException.get() != null) {
                migrationCallback = new StringBuilder();
                migrationCallback.append("Cannot migrate a Realm file which doesn't exist: ");
                migrationCallback.append(realmConfiguration.getPath());
                throw new FileNotFoundException(migrationCallback.toString());
            }
        }
    }

    protected void finalize() throws Throwable {
        if (!(this.sharedRealm == null || this.sharedRealm.isClosed())) {
            RealmLog.warn("Remember to call close() on all Realm instances. Realm %s is being finalized without being closed, this can lead to running out of native memory.", this.configuration.getPath());
            if (this.realmCache != null) {
                this.realmCache.leak();
            }
        }
        super.finalize();
    }

    SharedRealm getSharedRealm() {
        return this.sharedRealm;
    }
}
