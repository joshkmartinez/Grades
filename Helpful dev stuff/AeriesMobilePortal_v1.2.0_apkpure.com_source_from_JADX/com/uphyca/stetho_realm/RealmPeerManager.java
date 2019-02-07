package com.uphyca.stetho_realm;

import android.database.sqlite.SQLiteException;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeerRegistrationListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.uphyca.stetho_realm.Database.AddDatabaseEvent;
import com.uphyca.stetho_realm.Database.DatabaseObject;
import io.realm.RealmConfiguration.Builder;
import io.realm.internal.SharedRealm;
import io.realm.internal.SharedRealm.Durability;
import io.realm.internal.Table;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public class RealmPeerManager extends ChromePeerManager {
    private static final Pattern SELECT_PATTERN = Pattern.compile("SELECT[ \\t]+rowid,[ \\t]+\\*[ \\t]+FROM \"([^\"]+)\"");
    private static final String TABLE_PREFIX = "class_";
    private byte[] defaultEncryptionKey;
    private Map<String, byte[]> encryptionKeys;
    private final String packageName;
    private final RealmFilesProvider realmFilesProvider;

    public interface ExecuteResultHandler<T> {
        T handleInsert(long j) throws SQLiteException;

        T handleRawQuery() throws SQLiteException;

        T handleSelect(Table table, boolean z) throws SQLiteException;

        T handleUpdateDelete(int i) throws SQLiteException;
    }

    class C09241 implements PeerRegistrationListener {
        public void onPeerUnregistered(JsonRpcPeer jsonRpcPeer) {
        }

        C09241() {
        }

        public void onPeerRegistered(JsonRpcPeer jsonRpcPeer) {
            RealmPeerManager.this.bootstrapNewPeer(jsonRpcPeer);
        }
    }

    public RealmPeerManager(String str, RealmFilesProvider realmFilesProvider, byte[] bArr, Map<String, byte[]> map) {
        this.packageName = str;
        this.realmFilesProvider = realmFilesProvider;
        this.defaultEncryptionKey = bArr;
        this.encryptionKeys = map;
        setListener(new C09241());
    }

    public List<String> getDatabaseTableNames(String str, boolean z) {
        List<String> arrayList = new ArrayList();
        str = openSharedRealm(str);
        int i = 0;
        while (true) {
            try {
                if (((long) i) >= str.size()) {
                    break;
                }
                String tableName = str.getTableName(i);
                if (z || tableName.startsWith(TABLE_PREFIX)) {
                    arrayList.add(tableName);
                }
                i++;
            } finally {
                str.close();
            }
        }
        return arrayList;
    }

    private void bootstrapNewPeer(JsonRpcPeer jsonRpcPeer) {
        for (File file : tidyDatabaseList(this.realmFilesProvider.getDatabaseFiles())) {
            DatabaseObject databaseObject = new DatabaseObject();
            databaseObject.id = file.getPath();
            databaseObject.name = file.getName();
            databaseObject.domain = this.packageName;
            databaseObject.version = "N/A";
            AddDatabaseEvent addDatabaseEvent = new AddDatabaseEvent();
            addDatabaseEvent.database = databaseObject;
            jsonRpcPeer.invokeMethod("Database.addDatabase", addDatabaseEvent, null);
        }
    }

    static List<File> tidyDatabaseList(List<File> list) {
        List<File> arrayList = new ArrayList();
        for (File add : list) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public <T> T executeSQL(String str, String str2, ExecuteResultHandler<T> executeResultHandler) {
        str = openSharedRealm(str);
        try {
            str2 = SELECT_PATTERN.matcher(str2.trim());
            if (str2.matches()) {
                str2 = executeResultHandler.handleSelect(str.getTable(str2.group(1)), true);
                return str2;
            }
            str.close();
            return null;
        } finally {
            str.close();
        }
    }

    private SharedRealm openSharedRealm(String str) {
        return openSharedRealm(str, null);
    }

    private SharedRealm openSharedRealm(String str, @Nullable Durability durability) {
        byte[] encryptionKey = getEncryptionKey(str);
        Builder builder = new Builder();
        str = new File(str).getAbsoluteFile();
        builder.directory(str.getParentFile());
        builder.name(str.getName());
        if (durability == Durability.MEM_ONLY) {
            builder.inMemory();
        }
        if (encryptionKey != null) {
            builder.encryptionKey(encryptionKey);
        }
        try {
            return SharedRealm.getInstance(builder.build());
        } catch (String str2) {
            if (durability == null) {
                builder.inMemory();
                return SharedRealm.getInstance(builder.build());
            }
            throw str2;
        }
    }

    private java.lang.Class<?> getRealmErrorClass() {
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
        r1 = this;
        r0 = "io.realm.exceptions.RealmError";	 Catch:{ ClassNotFoundException -> 0x0007 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uphyca.stetho_realm.RealmPeerManager.getRealmErrorClass():java.lang.Class<?>");
    }

    private byte[] getEncryptionKey(String str) {
        str = new File(str).getName();
        if (this.encryptionKeys.containsKey(str)) {
            return (byte[]) this.encryptionKeys.get(str);
        }
        return this.defaultEncryptionKey;
    }
}
