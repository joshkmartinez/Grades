package com.uphyca.stetho_realm;

import android.content.Context;
import com.facebook.stetho.InspectorModulesProvider;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.module.Database;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RealmInspectorModulesProvider implements InspectorModulesProvider {
    private static final boolean DEFAULT_ASCENDING_ORDER = true;
    private static final Pattern DEFAULT_DATABASE_NAME_PATTERN = Pattern.compile(".+\\.realm");
    private static final long DEFAULT_LIMIT = 250;
    private static final int ENCRYPTION_KEY_LENGTH = 64;
    private final boolean ascendingOrder;
    private final InspectorModulesProvider baseProvider;
    private final Pattern databaseNamePattern;
    private byte[] defaultEncryptionKey;
    private Map<String, byte[]> encryptionKeys;
    private File folder;
    private final long limit;
    private final String packageName;
    private final boolean withMetaTables;

    public static class ProviderBuilder {
        private final Context applicationContext;
        private boolean ascendingOrder = true;
        private InspectorModulesProvider baseProvider;
        private Pattern databaseNamePattern;
        private byte[] defaultEncryptionKey;
        private Map<String, byte[]> encryptionKeys;
        private File folder;
        private long limit = RealmInspectorModulesProvider.DEFAULT_LIMIT;
        private boolean withMetaTables;

        public ProviderBuilder(Context context) {
            this.applicationContext = context.getApplicationContext();
            this.folder = this.applicationContext.getFilesDir();
        }

        public ProviderBuilder baseProvider(InspectorModulesProvider inspectorModulesProvider) {
            this.baseProvider = inspectorModulesProvider;
            return this;
        }

        public ProviderBuilder withMetaTables() {
            this.withMetaTables = true;
            return this;
        }

        public ProviderBuilder withLimit(long j) {
            this.limit = j;
            return this;
        }

        public ProviderBuilder withFolder(File file) {
            this.folder = file;
            return this;
        }

        public ProviderBuilder withDescendingOrder() {
            this.ascendingOrder = false;
            return this;
        }

        public ProviderBuilder databaseNamePattern(Pattern pattern) {
            this.databaseNamePattern = pattern;
            return this;
        }

        public ProviderBuilder withDefaultEncryptionKey(byte[] bArr) {
            if (bArr == null) {
                this.defaultEncryptionKey = null;
            } else if (bArr.length == 64) {
                this.defaultEncryptionKey = (byte[]) bArr.clone();
            } else {
                throw new IllegalArgumentException(String.format("The provided key must be %s bytes. Yours was: %s", new Object[]{Integer.valueOf(64), Integer.valueOf(bArr.length)}));
            }
            return this;
        }

        public ProviderBuilder withEncryptionKey(String str, byte[] bArr) {
            if (this.encryptionKeys == null) {
                this.encryptionKeys = new HashMap();
            }
            if (bArr == null) {
                this.encryptionKeys.put(str, null);
            } else if (bArr.length == 64) {
                this.encryptionKeys.put(str, bArr.clone());
            } else {
                throw new IllegalArgumentException(String.format("The provided key must be %s bytes. Yours was: %s", new Object[]{Integer.valueOf(64), Integer.valueOf(bArr.length)}));
            }
            return this;
        }

        public RealmInspectorModulesProvider build() {
            InspectorModulesProvider inspectorModulesProvider;
            if (this.baseProvider != null) {
                inspectorModulesProvider = this.baseProvider;
            } else {
                inspectorModulesProvider = Stetho.defaultInspectorModulesProvider(this.applicationContext);
            }
            return new RealmInspectorModulesProvider(this.applicationContext.getPackageName(), inspectorModulesProvider, this.folder, this.withMetaTables, this.databaseNamePattern, this.limit, this.ascendingOrder, this.defaultEncryptionKey, this.encryptionKeys);
        }
    }

    @Deprecated
    public static RealmInspectorModulesProvider wrap(Context context, InspectorModulesProvider inspectorModulesProvider) {
        return wrap(context, inspectorModulesProvider, false);
    }

    @Deprecated
    public static RealmInspectorModulesProvider wrap(Context context, InspectorModulesProvider inspectorModulesProvider, boolean z) {
        return wrap(context, inspectorModulesProvider, z, null);
    }

    @Deprecated
    public static RealmInspectorModulesProvider wrap(Context context, InspectorModulesProvider inspectorModulesProvider, boolean z, Pattern pattern) {
        return new RealmInspectorModulesProvider(context.getPackageName(), inspectorModulesProvider, context.getFilesDir(), z, pattern, DEFAULT_LIMIT, true, null, null);
    }

    private RealmInspectorModulesProvider(String str, InspectorModulesProvider inspectorModulesProvider, File file, boolean z, Pattern pattern, long j, boolean z2, byte[] bArr, Map<String, byte[]> map) {
        this.packageName = str;
        this.baseProvider = inspectorModulesProvider;
        this.folder = file;
        this.withMetaTables = z;
        if (pattern == null) {
            this.databaseNamePattern = DEFAULT_DATABASE_NAME_PATTERN;
        } else {
            this.databaseNamePattern = pattern;
        }
        this.limit = j;
        this.ascendingOrder = z2;
        this.defaultEncryptionKey = bArr;
        if (map == null) {
            map = Collections.emptyMap();
        }
        this.encryptionKeys = map;
    }

    public Iterable<ChromeDevtoolsDomain> get() {
        Iterable arrayList = new ArrayList();
        for (ChromeDevtoolsDomain chromeDevtoolsDomain : this.baseProvider.get()) {
            if (!(chromeDevtoolsDomain instanceof Database)) {
                arrayList.add(chromeDevtoolsDomain);
            }
        }
        arrayList.add(new Database(this.packageName, new RealmFilesProvider(this.folder, this.databaseNamePattern), this.withMetaTables, this.limit, this.ascendingOrder, this.defaultEncryptionKey, this.encryptionKeys));
        return arrayList;
    }

    public static ProviderBuilder builder(Context context) {
        return new ProviderBuilder(context);
    }
}
