package io.realm;

import io.realm.BaseRealm.InstanceCallback;
import io.realm.exceptions.RealmException;
import io.realm.internal.CheckedRow;
import io.realm.internal.OsObject;
import io.realm.internal.Table;
import io.realm.log.RealmLog;
import java.io.File;
import java.util.Locale;
import rx.Observable;

public class DynamicRealm extends BaseRealm {

    public interface Transaction {
        void execute(DynamicRealm dynamicRealm);
    }

    public static abstract class Callback extends InstanceCallback<DynamicRealm> {
        public abstract void onSuccess(DynamicRealm dynamicRealm);

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

    private DynamicRealm(RealmCache realmCache) {
        super(realmCache);
    }

    private DynamicRealm(RealmConfiguration realmConfiguration) {
        super(realmConfiguration);
    }

    public static DynamicRealm getInstance(RealmConfiguration realmConfiguration) {
        if (realmConfiguration != null) {
            return (DynamicRealm) RealmCache.createRealmOrGetFromCache(realmConfiguration, DynamicRealm.class);
        }
        throw new IllegalArgumentException("A non-null RealmConfiguration must be provided");
    }

    public static RealmAsyncTask getInstanceAsync(RealmConfiguration realmConfiguration, Callback callback) {
        if (realmConfiguration != null) {
            return RealmCache.createRealmOrGetFromCacheAsync(realmConfiguration, callback, DynamicRealm.class);
        }
        throw new IllegalArgumentException("A non-null RealmConfiguration must be provided");
    }

    public DynamicRealmObject createObject(String str) {
        checkIfValid();
        Table table = this.schema.getTable(str);
        if (!table.hasPrimaryKey()) {
            return new DynamicRealmObject(this, CheckedRow.getFromRow(OsObject.create(table)));
        }
        throw new RealmException(String.format(Locale.US, "'%s' has a primary key, use 'createObject(String, Object)' instead.", new Object[]{str}));
    }

    public DynamicRealmObject createObject(String str, Object obj) {
        return new DynamicRealmObject(this, CheckedRow.getFromRow(OsObject.createWithPrimaryKey(this.schema.getTable(str), obj)));
    }

    public RealmQuery<DynamicRealmObject> where(String str) {
        checkIfValid();
        if (this.sharedRealm.hasTable(Table.getTableNameForClass(str))) {
            return RealmQuery.createDynamicQuery(this, str);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Class does not exist in the Realm and cannot be queried: ");
        stringBuilder.append(str);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void addChangeListener(RealmChangeListener<DynamicRealm> realmChangeListener) {
        addListener(realmChangeListener);
    }

    public void removeChangeListener(RealmChangeListener<DynamicRealm> realmChangeListener) {
        removeListener(realmChangeListener);
    }

    public void removeAllChangeListeners() {
        removeAllListeners();
    }

    public void delete(String str) {
        checkIfValid();
        checkIfInTransaction();
        this.schema.getTable(str).clear();
    }

    public void executeTransaction(Transaction transaction) {
        if (transaction != null) {
            beginTransaction();
            try {
                transaction.execute(this);
                commitTransaction();
                return;
            } catch (Transaction transaction2) {
                if (isInTransaction()) {
                    cancelTransaction();
                } else {
                    RealmLog.warn("Could not cancel transaction, not currently in a transaction.", new Object[0]);
                }
                throw transaction2;
            }
        }
        throw new IllegalArgumentException("Transaction should not be null");
    }

    static DynamicRealm createInstance(RealmCache realmCache) {
        return new DynamicRealm(realmCache);
    }

    static DynamicRealm createInstance(RealmConfiguration realmConfiguration) {
        return new DynamicRealm(realmConfiguration);
    }

    public Observable<DynamicRealm> asObservable() {
        return this.configuration.getRxFactory().from(this);
    }
}
