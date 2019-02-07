package io.realm;

import android.content.Context;
import io.realm.Realm.Transaction;
import io.realm.annotations.RealmModule;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmFileException;
import io.realm.exceptions.RealmFileException.Kind;
import io.realm.internal.RealmCore;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.SharedRealm.Durability;
import io.realm.internal.Util;
import io.realm.internal.modules.CompositeMediator;
import io.realm.internal.modules.FilterableMediator;
import io.realm.rx.RealmObservableFactory;
import io.realm.rx.RxObservableFactory;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class RealmConfiguration {
    private static final Object DEFAULT_MODULE = Realm.getDefaultModule();
    protected static final RealmProxyMediator DEFAULT_MODULE_MEDIATOR;
    public static final String DEFAULT_REALM_NAME = "default.realm";
    public static final int KEY_LENGTH = 64;
    private static Boolean rxJavaAvailable;
    private final String assetFilePath;
    private final String canonicalPath;
    private final CompactOnLaunchCallback compactOnLaunch;
    private final boolean deleteRealmIfMigrationNeeded;
    private final Durability durability;
    private final Transaction initialDataTransaction;
    private final byte[] key;
    private final RealmMigration migration;
    private final boolean readOnly;
    private final File realmDirectory;
    private final String realmFileName;
    private final RxObservableFactory rxObservableFactory;
    private final RealmProxyMediator schemaMediator;
    private final long schemaVersion;

    public static class Builder {
        private String assetFilePath;
        private CompactOnLaunchCallback compactOnLaunch;
        private HashSet<Class<? extends RealmModel>> debugSchema;
        private boolean deleteRealmIfMigrationNeeded;
        private File directory;
        private Durability durability;
        private String fileName;
        private Transaction initialDataTransaction;
        private byte[] key;
        private RealmMigration migration;
        private HashSet<Object> modules;
        private boolean readOnly;
        private RxObservableFactory rxFactory;
        private long schemaVersion;

        public Builder() {
            this(BaseRealm.applicationContext);
        }

        Builder(Context context) {
            this.modules = new HashSet();
            this.debugSchema = new HashSet();
            if (context != null) {
                RealmCore.loadLibrary(context);
                initializeBuilder(context);
                return;
            }
            throw new IllegalStateException("Call `Realm.init(Context)` before creating a RealmConfiguration");
        }

        private void initializeBuilder(Context context) {
            this.directory = context.getFilesDir();
            this.fileName = "default.realm";
            this.key = null;
            this.schemaVersion = 0;
            this.migration = null;
            this.deleteRealmIfMigrationNeeded = false;
            this.durability = Durability.FULL;
            this.readOnly = false;
            this.compactOnLaunch = null;
            if (RealmConfiguration.DEFAULT_MODULE != null) {
                this.modules.add(RealmConfiguration.DEFAULT_MODULE);
            }
        }

        public Builder name(String str) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("A non-empty filename must be provided");
            }
            this.fileName = str;
            return this;
        }

        public Builder directory(File file) {
            if (file == null) {
                throw new IllegalArgumentException("Non-null 'dir' required.");
            } else if (file.isFile()) {
                r1 = new StringBuilder();
                r1.append("'dir' is a file, not a directory: ");
                r1.append(file.getAbsolutePath());
                r1.append(".");
                throw new IllegalArgumentException(r1.toString());
            } else {
                if (!file.exists()) {
                    if (!file.mkdirs()) {
                        r1 = new StringBuilder();
                        r1.append("Could not create the specified directory: ");
                        r1.append(file.getAbsolutePath());
                        r1.append(".");
                        throw new IllegalArgumentException(r1.toString());
                    }
                }
                if (file.canWrite()) {
                    this.directory = file;
                    return this;
                }
                r1 = new StringBuilder();
                r1.append("Realm directory is not writable: ");
                r1.append(file.getAbsolutePath());
                r1.append(".");
                throw new IllegalArgumentException(r1.toString());
            }
        }

        public Builder encryptionKey(byte[] bArr) {
            if (bArr == null) {
                throw new IllegalArgumentException("A non-null key must be provided");
            } else if (bArr.length == 64) {
                this.key = Arrays.copyOf(bArr, bArr.length);
                return this;
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "The provided key must be %s bytes. Yours was: %s", new Object[]{Integer.valueOf(64), Integer.valueOf(bArr.length)}));
            }
        }

        public Builder schemaVersion(long j) {
            if (j >= 0) {
                this.schemaVersion = j;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Realm schema version numbers must be 0 (zero) or higher. Yours was: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public Builder migration(RealmMigration realmMigration) {
            if (realmMigration != null) {
                this.migration = realmMigration;
                return this;
            }
            throw new IllegalArgumentException("A non-null migration must be provided");
        }

        public Builder deleteRealmIfMigrationNeeded() {
            if (this.assetFilePath != null) {
                if (this.assetFilePath.length() != 0) {
                    throw new IllegalStateException("Realm cannot clear its schema when previously configured to use an asset file by calling assetFile().");
                }
            }
            this.deleteRealmIfMigrationNeeded = true;
            return this;
        }

        public Builder inMemory() {
            if (Util.isEmptyString(this.assetFilePath)) {
                this.durability = Durability.MEM_ONLY;
                return this;
            }
            throw new RealmException("Realm can not use in-memory configuration if asset file is present.");
        }

        public Builder modules(Object obj, Object... objArr) {
            this.modules.clear();
            addModule(obj);
            if (objArr != null) {
                for (Object addModule : objArr) {
                    addModule(addModule);
                }
            }
            return this;
        }

        public Builder rxFactory(RxObservableFactory rxObservableFactory) {
            this.rxFactory = rxObservableFactory;
            return this;
        }

        public Builder initialData(Transaction transaction) {
            this.initialDataTransaction = transaction;
            return this;
        }

        public Builder assetFile(String str) {
            if (Util.isEmptyString(str)) {
                throw new IllegalArgumentException("A non-empty asset file path must be provided");
            } else if (this.durability == Durability.MEM_ONLY) {
                throw new RealmException("Realm can not use in-memory configuration if asset file is present.");
            } else if (this.deleteRealmIfMigrationNeeded) {
                throw new IllegalStateException("Realm cannot use an asset file when previously configured to clear its schema in migration by calling deleteRealmIfMigrationNeeded().");
            } else {
                this.assetFilePath = str;
                return this;
            }
        }

        public Builder readOnly() {
            this.readOnly = true;
            return this;
        }

        public Builder compactOnLaunch() {
            return compactOnLaunch(new DefaultCompactOnLaunchCallback());
        }

        public Builder compactOnLaunch(CompactOnLaunchCallback compactOnLaunchCallback) {
            if (compactOnLaunchCallback != null) {
                this.compactOnLaunch = compactOnLaunchCallback;
                return this;
            }
            throw new IllegalArgumentException("A non-null compactOnLaunch must be provided");
        }

        private void addModule(Object obj) {
            if (obj != null) {
                checkModule(obj);
                this.modules.add(obj);
            }
        }

        Builder schema(Class<? extends RealmModel> cls, Class<? extends RealmModel>... clsArr) {
            if (cls != null) {
                this.modules.clear();
                this.modules.add(RealmConfiguration.DEFAULT_MODULE_MEDIATOR);
                this.debugSchema.add(cls);
                if (clsArr != null) {
                    Collections.addAll(this.debugSchema, clsArr);
                }
                return this;
            }
            throw new IllegalArgumentException("A non-null class must be provided");
        }

        public RealmConfiguration build() {
            if (this.readOnly) {
                if (r0.initialDataTransaction != null) {
                    throw new IllegalStateException("This Realm is marked as read-only. Read-only Realms cannot use initialData(Realm.Transaction).");
                } else if (r0.assetFilePath == null) {
                    throw new IllegalStateException("Only Realms provided using 'assetFile(path)' can be marked read-only. No such Realm was provided.");
                } else if (r0.deleteRealmIfMigrationNeeded) {
                    throw new IllegalStateException("'deleteRealmIfMigrationNeeded()' and read-only Realms cannot be combined");
                } else if (r0.compactOnLaunch != null) {
                    throw new IllegalStateException("'compactOnLaunch()' and read-only Realms cannot be combined");
                }
            }
            if (r0.rxFactory == null && RealmConfiguration.isRxJavaAvailable()) {
                r0.rxFactory = new RealmObservableFactory();
            }
            File file = r0.directory;
            String str = r0.fileName;
            String canonicalPath = RealmConfiguration.getCanonicalPath(new File(r0.directory, r0.fileName));
            String str2 = r0.assetFilePath;
            byte[] bArr = r0.key;
            long j = r0.schemaVersion;
            RealmMigration realmMigration = r0.migration;
            boolean z = r0.deleteRealmIfMigrationNeeded;
            Durability durability = r0.durability;
            RealmProxyMediator createSchemaMediator = RealmConfiguration.createSchemaMediator(r0.modules, r0.debugSchema);
            RxObservableFactory rxObservableFactory = r0.rxFactory;
            Transaction transaction = r0.initialDataTransaction;
            Transaction transaction2 = transaction;
            return new RealmConfiguration(file, str, canonicalPath, str2, bArr, j, realmMigration, z, durability, createSchemaMediator, rxObservableFactory, transaction2, r0.readOnly, r0.compactOnLaunch);
        }

        private void checkModule(Object obj) {
            if (!obj.getClass().isAnnotationPresent(RealmModule.class)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(obj.getClass().getCanonicalName());
                stringBuilder.append(" is not a RealmModule. Add @RealmModule to the class definition.");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    boolean isSyncConfiguration() {
        return false;
    }

    static {
        if (DEFAULT_MODULE != null) {
            RealmProxyMediator moduleMediator = getModuleMediator(DEFAULT_MODULE.getClass().getCanonicalName());
            if (moduleMediator.transformerApplied()) {
                DEFAULT_MODULE_MEDIATOR = moduleMediator;
                return;
            }
            throw new ExceptionInInitializerError("RealmTransformer doesn't seem to be applied. Please update the project configuration to use the Realm Gradle plugin. See https://realm.io/news/android-installation-change/");
        }
        DEFAULT_MODULE_MEDIATOR = null;
    }

    protected RealmConfiguration(File file, String str, String str2, String str3, byte[] bArr, long j, RealmMigration realmMigration, boolean z, Durability durability, RealmProxyMediator realmProxyMediator, RxObservableFactory rxObservableFactory, Transaction transaction, boolean z2, CompactOnLaunchCallback compactOnLaunchCallback) {
        this.realmDirectory = file;
        this.realmFileName = str;
        this.canonicalPath = str2;
        this.assetFilePath = str3;
        this.key = bArr;
        this.schemaVersion = j;
        this.migration = realmMigration;
        this.deleteRealmIfMigrationNeeded = z;
        this.durability = durability;
        this.schemaMediator = realmProxyMediator;
        this.rxObservableFactory = rxObservableFactory;
        this.initialDataTransaction = transaction;
        this.readOnly = z2;
        this.compactOnLaunch = compactOnLaunchCallback;
    }

    public File getRealmDirectory() {
        return this.realmDirectory;
    }

    public String getRealmFileName() {
        return this.realmFileName;
    }

    public byte[] getEncryptionKey() {
        return this.key == null ? null : Arrays.copyOf(this.key, this.key.length);
    }

    public long getSchemaVersion() {
        return this.schemaVersion;
    }

    public RealmMigration getMigration() {
        return this.migration;
    }

    public boolean shouldDeleteRealmIfMigrationNeeded() {
        return this.deleteRealmIfMigrationNeeded;
    }

    public Durability getDurability() {
        return this.durability;
    }

    RealmProxyMediator getSchemaMediator() {
        return this.schemaMediator;
    }

    Transaction getInitialDataTransaction() {
        return this.initialDataTransaction;
    }

    boolean hasAssetFile() {
        return Util.isEmptyString(this.assetFilePath) ^ 1;
    }

    String getAssetFilePath() {
        return this.assetFilePath;
    }

    public CompactOnLaunchCallback getCompactOnLaunchCallback() {
        return this.compactOnLaunch;
    }

    public Set<Class<? extends RealmModel>> getRealmObjectClasses() {
        return this.schemaMediator.getModelClasses();
    }

    public String getPath() {
        return this.canonicalPath;
    }

    boolean realmExists() {
        return new File(this.canonicalPath).exists();
    }

    public RxObservableFactory getRxFactory() {
        if (this.rxObservableFactory != null) {
            return this.rxObservableFactory;
        }
        throw new UnsupportedOperationException("RxJava seems to be missing from the classpath. Remember to add it as a compile dependency. See https://realm.io/docs/java/latest/#rxjava for more details.");
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
        r6 = this;
        if (r6 != r7) goto L_0x0004;
    L_0x0002:
        r7 = 1;
        return r7;
    L_0x0004:
        r0 = 0;
        if (r7 == 0) goto L_0x00bc;
    L_0x0007:
        r1 = r6.getClass();
        r2 = r7.getClass();
        if (r1 == r2) goto L_0x0013;
    L_0x0011:
        goto L_0x00bc;
    L_0x0013:
        r7 = (io.realm.RealmConfiguration) r7;
        r1 = r6.schemaVersion;
        r3 = r7.schemaVersion;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x001e;
    L_0x001d:
        return r0;
    L_0x001e:
        r1 = r6.deleteRealmIfMigrationNeeded;
        r2 = r7.deleteRealmIfMigrationNeeded;
        if (r1 == r2) goto L_0x0025;
    L_0x0024:
        return r0;
    L_0x0025:
        r1 = r6.realmDirectory;
        r2 = r7.realmDirectory;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0030;
    L_0x002f:
        return r0;
    L_0x0030:
        r1 = r6.realmFileName;
        r2 = r7.realmFileName;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x003b;
    L_0x003a:
        return r0;
    L_0x003b:
        r1 = r6.canonicalPath;
        r2 = r7.canonicalPath;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0046;
    L_0x0045:
        return r0;
    L_0x0046:
        r1 = r6.key;
        r2 = r7.key;
        r1 = java.util.Arrays.equals(r1, r2);
        if (r1 != 0) goto L_0x0051;
    L_0x0050:
        return r0;
    L_0x0051:
        r1 = r6.durability;
        r2 = r7.durability;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x005c;
    L_0x005b:
        return r0;
    L_0x005c:
        r1 = r6.migration;
        if (r1 == 0) goto L_0x006b;
    L_0x0060:
        r1 = r6.migration;
        r2 = r7.migration;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0070;
    L_0x006a:
        goto L_0x006f;
    L_0x006b:
        r1 = r7.migration;
        if (r1 == 0) goto L_0x0070;
    L_0x006f:
        return r0;
    L_0x0070:
        r1 = r6.rxObservableFactory;
        if (r1 == 0) goto L_0x007f;
    L_0x0074:
        r1 = r6.rxObservableFactory;
        r2 = r7.rxObservableFactory;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0084;
    L_0x007e:
        goto L_0x0083;
    L_0x007f:
        r1 = r7.rxObservableFactory;
        if (r1 == 0) goto L_0x0084;
    L_0x0083:
        return r0;
    L_0x0084:
        r1 = r6.initialDataTransaction;
        if (r1 == 0) goto L_0x0093;
    L_0x0088:
        r1 = r6.initialDataTransaction;
        r2 = r7.initialDataTransaction;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0098;
    L_0x0092:
        goto L_0x0097;
    L_0x0093:
        r1 = r7.initialDataTransaction;
        if (r1 == 0) goto L_0x0098;
    L_0x0097:
        return r0;
    L_0x0098:
        r1 = r6.readOnly;
        r2 = r7.readOnly;
        if (r1 == r2) goto L_0x009f;
    L_0x009e:
        return r0;
    L_0x009f:
        r1 = r6.compactOnLaunch;
        if (r1 == 0) goto L_0x00ae;
    L_0x00a3:
        r1 = r6.compactOnLaunch;
        r2 = r7.compactOnLaunch;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00b3;
    L_0x00ad:
        goto L_0x00b2;
    L_0x00ae:
        r1 = r7.compactOnLaunch;
        if (r1 == 0) goto L_0x00b3;
    L_0x00b2:
        return r0;
    L_0x00b3:
        r0 = r6.schemaMediator;
        r7 = r7.schemaMediator;
        r7 = r0.equals(r7);
        return r7;
    L_0x00bc:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.RealmConfiguration.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = 31 * ((((((((((((((((((((((this.realmDirectory.hashCode() * 31) + this.realmFileName.hashCode()) * 31) + this.canonicalPath.hashCode()) * 31) + (this.key != null ? Arrays.hashCode(this.key) : 0)) * 31) + ((int) this.schemaVersion)) * 31) + (this.migration != null ? this.migration.hashCode() : 0)) * 31) + this.deleteRealmIfMigrationNeeded) * 31) + this.schemaMediator.hashCode()) * 31) + this.durability.hashCode()) * 31) + (this.rxObservableFactory != null ? this.rxObservableFactory.hashCode() : 0)) * 31) + (this.initialDataTransaction != null ? this.initialDataTransaction.hashCode() : 0)) * 31) + this.readOnly);
        if (this.compactOnLaunch != null) {
            i = this.compactOnLaunch.hashCode();
        }
        return hashCode + i;
    }

    protected static RealmProxyMediator createSchemaMediator(Set<Object> set, Set<Class<? extends RealmModel>> set2) {
        if (set2.size() > 0) {
            return new FilterableMediator(DEFAULT_MODULE_MEDIATOR, set2);
        }
        if (set.size() == 1) {
            return getModuleMediator(set.iterator().next().getClass().getCanonicalName());
        }
        set2 = new RealmProxyMediator[set.size()];
        int i = 0;
        for (Object obj : set) {
            set2[i] = getModuleMediator(obj.getClass().getCanonicalName());
            i++;
        }
        return new CompositeMediator(set2);
    }

    private static RealmProxyMediator getModuleMediator(String str) {
        StringBuilder stringBuilder;
        str = str.split("\\.");
        str = str[str.length - 1];
        str = String.format(Locale.US, "io.realm.%s%s", new Object[]{str, "Mediator"});
        try {
            Constructor constructor = Class.forName(str).getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return (RealmProxyMediator) constructor.newInstance(new Object[0]);
        } catch (Throwable e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not find ");
            stringBuilder.append(str);
            throw new RealmException(stringBuilder.toString(), e);
        } catch (Throwable e2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not create an instance of ");
            stringBuilder.append(str);
            throw new RealmException(stringBuilder.toString(), e2);
        } catch (Throwable e22) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not create an instance of ");
            stringBuilder.append(str);
            throw new RealmException(stringBuilder.toString(), e22);
        } catch (Throwable e222) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not create an instance of ");
            stringBuilder.append(str);
            throw new RealmException(stringBuilder.toString(), e222);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("realmDirectory: ");
        stringBuilder.append(this.realmDirectory.toString());
        stringBuilder.append("\n");
        stringBuilder.append("realmFileName : ");
        stringBuilder.append(this.realmFileName);
        stringBuilder.append("\n");
        stringBuilder.append("canonicalPath: ");
        stringBuilder.append(this.canonicalPath);
        stringBuilder.append("\n");
        stringBuilder.append("key: ");
        stringBuilder.append("[length: ");
        stringBuilder.append(this.key == null ? 0 : 64);
        stringBuilder.append("]");
        stringBuilder.append("\n");
        stringBuilder.append("schemaVersion: ");
        stringBuilder.append(Long.toString(this.schemaVersion));
        stringBuilder.append("\n");
        stringBuilder.append("migration: ");
        stringBuilder.append(this.migration);
        stringBuilder.append("\n");
        stringBuilder.append("deleteRealmIfMigrationNeeded: ");
        stringBuilder.append(this.deleteRealmIfMigrationNeeded);
        stringBuilder.append("\n");
        stringBuilder.append("durability: ");
        stringBuilder.append(this.durability);
        stringBuilder.append("\n");
        stringBuilder.append("schemaMediator: ");
        stringBuilder.append(this.schemaMediator);
        stringBuilder.append("\n");
        stringBuilder.append("readOnly: ");
        stringBuilder.append(this.readOnly);
        stringBuilder.append("\n");
        stringBuilder.append("compactOnLaunch: ");
        stringBuilder.append(this.compactOnLaunch);
        return stringBuilder.toString();
    }

    static synchronized boolean isRxJavaAvailable() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = io.realm.RealmConfiguration.class;
        monitor-enter(r0);
        r1 = rxJavaAvailable;	 Catch:{ all -> 0x0023 }
        if (r1 != 0) goto L_0x001b;
    L_0x0007:
        r1 = "rx.Observable";	 Catch:{ ClassNotFoundException -> 0x0014 }
        java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0014 }
        r1 = 1;	 Catch:{ ClassNotFoundException -> 0x0014 }
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ ClassNotFoundException -> 0x0014 }
        rxJavaAvailable = r1;	 Catch:{ ClassNotFoundException -> 0x0014 }
        goto L_0x001b;
    L_0x0014:
        r1 = 0;
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ all -> 0x0023 }
        rxJavaAvailable = r1;	 Catch:{ all -> 0x0023 }
    L_0x001b:
        r1 = rxJavaAvailable;	 Catch:{ all -> 0x0023 }
        r1 = r1.booleanValue();	 Catch:{ all -> 0x0023 }
        monitor-exit(r0);
        return r1;
    L_0x0023:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.RealmConfiguration.isRxJavaAvailable():boolean");
    }

    protected static String getCanonicalPath(File file) {
        try {
            return file.getCanonicalPath();
        } catch (Throwable e) {
            Kind kind = Kind.ACCESS_ERROR;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not resolve the canonical path to the Realm file: ");
            stringBuilder.append(file.getAbsolutePath());
            throw new RealmFileException(kind, stringBuilder.toString(), e);
        }
    }
}
