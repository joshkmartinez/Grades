package com.facebook.stetho.inspector.protocol.module;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.ObjectIdMapper;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError.ErrorCode;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver.ExecuteResultHandler;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import org.json.JSONObject;

@TargetApi(11)
public class Database implements ChromeDevtoolsDomain {
    private static final int MAX_BLOB_LENGTH = 512;
    private static final int MAX_EXECUTE_RESULTS = 250;
    private static final String UNKNOWN_BLOB_LABEL = "{blob}";
    private final ChromePeerManager mChromePeerManager = new ChromePeerManager();
    private List<DatabaseDriver2> mDatabaseDrivers = new ArrayList();
    private final ObjectMapper mObjectMapper;
    private final DatabasePeerRegistrationListener mPeerListener = new DatabasePeerRegistrationListener(this.mDatabaseDrivers);

    public static class AddDatabaseEvent {
        @JsonProperty(required = true)
        public DatabaseObject database;
    }

    private static class DatabaseDescriptorHolder {
        public final DatabaseDescriptor descriptor;
        public final DatabaseDriver2 driver;

        public DatabaseDescriptorHolder(DatabaseDriver2 databaseDriver2, DatabaseDescriptor databaseDescriptor) {
            this.driver = databaseDriver2;
            this.descriptor = databaseDescriptor;
        }
    }

    public static class DatabaseObject {
        @JsonProperty(required = true)
        public String domain;
        @JsonProperty(required = true)
        public String id;
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public String version;
    }

    public static class Error {
        @JsonProperty(required = true)
        public int code;
        @JsonProperty(required = true)
        public String message;
    }

    public static class ExecuteSQLRequest {
        @JsonProperty(required = true)
        public String databaseId;
        @JsonProperty(required = true)
        public String query;
    }

    private static class GetDatabaseTableNamesRequest {
        @JsonProperty(required = true)
        public String databaseId;

        private GetDatabaseTableNamesRequest() {
        }
    }

    class C08671 implements ExecuteResultHandler<ExecuteSQLResponse> {
        C08671() {
        }

        public ExecuteSQLResponse handleRawQuery() throws SQLiteException {
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.columnNames = Collections.singletonList(Param.SUCCESS);
            executeSQLResponse.values = Collections.singletonList("true");
            return executeSQLResponse;
        }

        public ExecuteSQLResponse handleSelect(Cursor cursor) throws SQLiteException {
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.columnNames = Arrays.asList(cursor.getColumnNames());
            executeSQLResponse.values = Database.flattenRows(cursor, 250);
            return executeSQLResponse;
        }

        public ExecuteSQLResponse handleInsert(long j) throws SQLiteException {
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.columnNames = Collections.singletonList("ID of last inserted row");
            executeSQLResponse.values = Collections.singletonList(String.valueOf(j));
            return executeSQLResponse;
        }

        public ExecuteSQLResponse handleUpdateDelete(int i) throws SQLiteException {
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.columnNames = Collections.singletonList("Modified rows");
            executeSQLResponse.values = Collections.singletonList(String.valueOf(i));
            return executeSQLResponse;
        }
    }

    @Deprecated
    public static abstract class DatabaseDriver extends BaseDatabaseDriver<String> {
        public DatabaseDriver(Context context) {
            super(context);
        }
    }

    public static class ExecuteSQLResponse implements JsonRpcResult {
        @JsonProperty
        public List<String> columnNames;
        @JsonProperty
        public Error sqlError;
        @JsonProperty
        public List<String> values;
    }

    private static class GetDatabaseTableNamesResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<String> tableNames;

        private GetDatabaseTableNamesResponse() {
        }
    }

    @ThreadSafe
    private static class DatabasePeerRegistrationListener extends PeersRegisteredListener {
        private final List<DatabaseDriver2> mDatabaseDrivers;
        @GuardedBy("this")
        private final SparseArray<DatabaseDescriptorHolder> mDatabaseHolders;
        @GuardedBy("this")
        private final ObjectIdMapper mDatabaseIdMapper;

        private DatabasePeerRegistrationListener(List<DatabaseDriver2> list) {
            this.mDatabaseHolders = new SparseArray();
            this.mDatabaseIdMapper = new ObjectIdMapper();
            this.mDatabaseDrivers = list;
        }

        public DatabaseDescriptorHolder getDatabaseDescriptorHolder(String str) {
            return (DatabaseDescriptorHolder) this.mDatabaseHolders.get(Integer.parseInt(str));
        }

        protected synchronized void onFirstPeerRegistered() {
            for (DatabaseDriver2 databaseDriver2 : this.mDatabaseDrivers) {
                for (DatabaseDescriptor databaseDescriptor : databaseDriver2.getDatabaseNames()) {
                    if (this.mDatabaseIdMapper.getIdForObject(databaseDescriptor) == null) {
                        this.mDatabaseHolders.put(Integer.valueOf(this.mDatabaseIdMapper.putObject(databaseDescriptor)).intValue(), new DatabaseDescriptorHolder(databaseDriver2, databaseDescriptor));
                    }
                }
            }
        }

        protected synchronized void onLastPeerUnregistered() {
            this.mDatabaseIdMapper.clear();
            this.mDatabaseHolders.clear();
        }

        protected synchronized void onPeerAdded(JsonRpcPeer jsonRpcPeer) {
            int size = this.mDatabaseHolders.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.mDatabaseHolders.keyAt(i);
                DatabaseDescriptorHolder databaseDescriptorHolder = (DatabaseDescriptorHolder) this.mDatabaseHolders.valueAt(i);
                DatabaseObject databaseObject = new DatabaseObject();
                databaseObject.id = String.valueOf(keyAt);
                databaseObject.name = databaseDescriptorHolder.descriptor.name();
                databaseObject.domain = databaseDescriptorHolder.driver.getContext().getPackageName();
                databaseObject.version = "N/A";
                AddDatabaseEvent addDatabaseEvent = new AddDatabaseEvent();
                addDatabaseEvent.database = databaseObject;
                jsonRpcPeer.invokeMethod("Database.addDatabase", addDatabaseEvent, null);
            }
        }

        protected synchronized void onPeerRemoved(JsonRpcPeer jsonRpcPeer) {
        }
    }

    public Database() {
        this.mChromePeerManager.setListener(this.mPeerListener);
        this.mObjectMapper = new ObjectMapper();
    }

    public void add(DatabaseDriver2 databaseDriver2) {
        this.mDatabaseDrivers.add(databaseDriver2);
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mChromePeerManager.addPeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mChromePeerManager.removePeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getDatabaseTableNames(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws JsonRpcException {
        jsonRpcPeer = this.mPeerListener.getDatabaseDescriptorHolder(((GetDatabaseTableNamesRequest) this.mObjectMapper.convertValue(jSONObject, GetDatabaseTableNamesRequest.class)).databaseId);
        try {
            JsonRpcResult getDatabaseTableNamesResponse = new GetDatabaseTableNamesResponse();
            getDatabaseTableNamesResponse.tableNames = jsonRpcPeer.driver.getTableNames(jsonRpcPeer.descriptor);
            return getDatabaseTableNamesResponse;
        } catch (JsonRpcPeer jsonRpcPeer2) {
            throw new JsonRpcException(new JsonRpcError(ErrorCode.INVALID_REQUEST, jsonRpcPeer2.toString(), null));
        }
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult executeSQL(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        ExecuteSQLRequest executeSQLRequest = (ExecuteSQLRequest) this.mObjectMapper.convertValue(jSONObject, ExecuteSQLRequest.class);
        jSONObject = this.mPeerListener.getDatabaseDescriptorHolder(executeSQLRequest.databaseId);
        try {
            return jSONObject.driver.executeSQL(jSONObject.descriptor, executeSQLRequest.query, new C08671());
        } catch (JSONObject jSONObject2) {
            LogUtil.m20e(jSONObject2, "Exception executing: %s", executeSQLRequest.query);
            jsonRpcPeer = new Error();
            jsonRpcPeer.code = 0;
            jsonRpcPeer.message = jSONObject2.getMessage();
            jSONObject2 = new ExecuteSQLResponse();
            jSONObject2.sqlError = jsonRpcPeer;
            return jSONObject2;
        }
    }

    private static ArrayList<String> flattenRows(Cursor cursor, int i) {
        int i2 = 0;
        Util.throwIfNot(i >= 0);
        ArrayList<String> arrayList = new ArrayList();
        int columnCount = cursor.getColumnCount();
        for (int i3 = 0; i3 < i && cursor.moveToNext(); i3++) {
            for (int i4 = 0; i4 < columnCount; i4++) {
                int type = cursor.getType(i4);
                if (type != 4) {
                    switch (type) {
                        case 0:
                            arrayList.add(null);
                            break;
                        case 1:
                            arrayList.add(String.valueOf(cursor.getLong(i4)));
                            break;
                        case 2:
                            arrayList.add(String.valueOf(cursor.getDouble(i4)));
                            break;
                        default:
                            arrayList.add(cursor.getString(i4));
                            break;
                    }
                }
                arrayList.add(blobToString(cursor.getBlob(i4)));
            }
        }
        if (cursor.isAfterLast() == null) {
            while (i2 < columnCount) {
                arrayList.add("{truncated}");
                i2++;
            }
        }
        return arrayList;
    }

    private static java.lang.String blobToString(byte[] r2) {
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
        r0 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        r1 = r2.length;
        if (r1 > r0) goto L_0x0013;
    L_0x0005:
        r0 = fastIsAscii(r2);
        if (r0 == 0) goto L_0x0013;
    L_0x000b:
        r0 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        r1 = "US-ASCII";	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        r0.<init>(r2, r1);	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        return r0;
    L_0x0013:
        r2 = "{blob}";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.inspector.protocol.module.Database.blobToString(byte[]):java.lang.String");
    }

    private static boolean fastIsAscii(byte[] bArr) {
        for (byte b : bArr) {
            if ((b & -128) != 0) {
                return false;
            }
        }
        return 1;
    }
}
