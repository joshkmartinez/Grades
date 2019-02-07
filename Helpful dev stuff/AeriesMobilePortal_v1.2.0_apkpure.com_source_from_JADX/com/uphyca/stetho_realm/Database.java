package com.uphyca.stetho_realm;

import android.database.sqlite.SQLiteException;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.uphyca.stetho_realm.RealmPeerManager.ExecuteResultHandler;
import io.realm.internal.LinkView;
import io.realm.internal.Row;
import io.realm.internal.Table;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class Database implements ChromeDevtoolsDomain {
    private static final String NULL = "[null]";
    private final boolean ascendingOrder;
    private DateFormat dateTimeFormatter;
    private final long limit;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final RealmPeerManager realmPeerManager;
    private final boolean withMetaTables;

    public static class AddDatabaseEvent {
        @JsonProperty(required = true)
        public DatabaseObject database;
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

    private static class ExecuteSQLRequest {
        @JsonProperty(required = true)
        public String databaseId;
        @JsonProperty(required = true)
        public String query;

        private ExecuteSQLRequest() {
        }
    }

    private static class GetDatabaseTableNamesRequest {
        @JsonProperty(required = true)
        public String databaseId;

        private GetDatabaseTableNamesRequest() {
        }
    }

    static class RowFetcher {
        private static RowFetcher sInstance = new RowFetcher();

        static RowFetcher getInstance() {
            return sInstance;
        }

        RowFetcher() {
        }

        Row getRow(Table table, long j) {
            return table.getCheckedRow(j);
        }
    }

    static class RowWrapper {
        private final Row row;

        static RowWrapper wrap(Row row) {
            return new RowWrapper(row);
        }

        RowWrapper(Row row) {
            this.row = row;
        }

        long getIndex() {
            return this.row.getIndex();
        }

        StethoRealmFieldType getColumnType(long j) {
            j = this.row.getColumnType(j).name();
            if (j.equals("INTEGER")) {
                return StethoRealmFieldType.INTEGER;
            }
            if (j.equals("BOOLEAN")) {
                return StethoRealmFieldType.BOOLEAN;
            }
            if (j.equals("STRING")) {
                return StethoRealmFieldType.STRING;
            }
            if (j.equals("BINARY")) {
                return StethoRealmFieldType.BINARY;
            }
            if (j.equals("UNSUPPORTED_TABLE")) {
                return StethoRealmFieldType.UNSUPPORTED_TABLE;
            }
            if (j.equals("UNSUPPORTED_MIXED")) {
                return StethoRealmFieldType.UNSUPPORTED_MIXED;
            }
            if (j.equals("UNSUPPORTED_DATE")) {
                return StethoRealmFieldType.OLD_DATE;
            }
            if (j.equals("DATE")) {
                return StethoRealmFieldType.DATE;
            }
            if (j.equals("FLOAT")) {
                return StethoRealmFieldType.FLOAT;
            }
            if (j.equals("DOUBLE")) {
                return StethoRealmFieldType.DOUBLE;
            }
            if (j.equals("OBJECT")) {
                return StethoRealmFieldType.OBJECT;
            }
            if (j.equals("LIST") != null) {
                return StethoRealmFieldType.LIST;
            }
            return StethoRealmFieldType.UNKNOWN;
        }

        boolean isNull(long j) {
            return this.row.isNull(j);
        }

        boolean isNullLink(long j) {
            return this.row.isNullLink(j);
        }

        long getLong(long j) {
            return this.row.getLong(j);
        }

        boolean getBoolean(long j) {
            return this.row.getBoolean(j);
        }

        float getFloat(long j) {
            return this.row.getFloat(j);
        }

        double getDouble(long j) {
            return this.row.getDouble(j);
        }

        Date getDate(long j) {
            return this.row.getDate(j);
        }

        String getString(long j) {
            return this.row.getString(j);
        }

        byte[] getBinaryByteArray(long j) {
            return this.row.getBinaryByteArray(j);
        }

        long getLink(long j) {
            return this.row.getLink(j);
        }

        LinkView getLinkList(long j) {
            return this.row.getLinkList(j);
        }
    }

    private enum StethoRealmFieldType {
        INTEGER(0),
        BOOLEAN(1),
        STRING(2),
        BINARY(4),
        UNSUPPORTED_TABLE(5),
        UNSUPPORTED_MIXED(6),
        OLD_DATE(7),
        DATE(8),
        FLOAT(9),
        DOUBLE(10),
        OBJECT(12),
        LIST(13),
        UNKNOWN(-1);
        
        private final int nativeValue;

        private StethoRealmFieldType(int i) {
            this.nativeValue = i;
        }

        public int getValue() {
            return this.nativeValue;
        }
    }

    class C09231 implements ExecuteResultHandler<ExecuteSQLResponse> {
        C09231() {
        }

        public ExecuteSQLResponse handleRawQuery() throws SQLiteException {
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.columnNames = Collections.singletonList(Param.SUCCESS);
            executeSQLResponse.values = Collections.singletonList("true");
            return executeSQLResponse;
        }

        public ExecuteSQLResponse handleSelect(Table table, boolean z) throws SQLiteException {
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            List arrayList = new ArrayList();
            if (z) {
                arrayList.add("<index>");
            }
            int i = 0;
            while (true) {
                long j = (long) i;
                if (j < table.getColumnCount()) {
                    arrayList.add(table.getColumnName(j));
                    i++;
                } else {
                    executeSQLResponse.columnNames = arrayList;
                    executeSQLResponse.values = Database.this.flattenRows(table, Database.this.limit, z);
                    return executeSQLResponse;
                }
            }
        }

        public ExecuteSQLResponse handleInsert(long j) throws SQLiteException {
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.columnNames = Collections.singletonList("ID of last inserted row");
            executeSQLResponse.values = Collections.singletonList(Long.valueOf(j));
            return executeSQLResponse;
        }

        public ExecuteSQLResponse handleUpdateDelete(int i) throws SQLiteException {
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.columnNames = Collections.singletonList("Modified rows");
            executeSQLResponse.values = Collections.singletonList(Integer.valueOf(i));
            return executeSQLResponse;
        }
    }

    private static class ExecuteSQLResponse implements JsonRpcResult {
        @JsonProperty
        public List<String> columnNames;
        @JsonProperty
        public Error sqlError;
        @JsonProperty
        public List<Object> values;

        private ExecuteSQLResponse() {
        }
    }

    private static class GetDatabaseTableNamesResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<String> tableNames;

        private GetDatabaseTableNamesResponse() {
        }
    }

    Database(String str, RealmFilesProvider realmFilesProvider, boolean z, long j, boolean z2, byte[] bArr, Map<String, byte[]> map) {
        this.realmPeerManager = new RealmPeerManager(str, realmFilesProvider, bArr, map);
        this.withMetaTables = z;
        this.limit = j;
        this.ascendingOrder = z2;
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.realmPeerManager.addPeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.realmPeerManager.removePeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getDatabaseTableNames(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        GetDatabaseTableNamesRequest getDatabaseTableNamesRequest = (GetDatabaseTableNamesRequest) this.objectMapper.convertValue(jSONObject, GetDatabaseTableNamesRequest.class);
        jSONObject = new GetDatabaseTableNamesResponse();
        jSONObject.tableNames = this.realmPeerManager.getDatabaseTableNames(getDatabaseTableNamesRequest.databaseId, this.withMetaTables);
        return jSONObject;
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult executeSQL(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        ExecuteSQLRequest executeSQLRequest = (ExecuteSQLRequest) this.objectMapper.convertValue(jSONObject, ExecuteSQLRequest.class);
        try {
            return (JsonRpcResult) this.realmPeerManager.executeSQL(executeSQLRequest.databaseId, executeSQLRequest.query, new C09231());
        } catch (JsonRpcPeer jsonRpcPeer2) {
            jSONObject = new Error();
            jSONObject.code = 0;
            jSONObject.message = jsonRpcPeer2.getMessage();
            jsonRpcPeer2 = new ExecuteSQLResponse();
            jsonRpcPeer2.sqlError = jSONObject;
            return jsonRpcPeer2;
        }
    }

    private List<Object> flattenRows(Table table, long j, boolean z) {
        Table table2;
        long j2;
        Database database = this;
        long j3 = 0;
        Util.throwIfNot(j >= 0);
        List<Object> arrayList = new ArrayList();
        long columnCount = table.getColumnCount();
        RowFetcher instance = RowFetcher.getInstance();
        long size = table.size();
        while (j3 < j && j3 < size) {
            long j4;
            if (database.ascendingOrder) {
                table2 = table;
                j4 = j3;
            } else {
                table2 = table;
                j4 = (size - j3) - 1;
            }
            RowWrapper wrap = RowWrapper.wrap(instance.getRow(table2, j4));
            if (z) {
                j2 = columnCount;
                arrayList.add(Long.valueOf(wrap.getIndex()));
            } else {
                j2 = columnCount;
            }
            int i = 0;
            while (true) {
                columnCount = (long) i;
                if (columnCount < j2) {
                    RowFetcher rowFetcher = instance;
                    switch (wrap.getColumnType(columnCount)) {
                        case INTEGER:
                            if (!wrap.isNull(columnCount)) {
                                arrayList.add(Long.valueOf(wrap.getLong(columnCount)));
                                break;
                            }
                            arrayList.add(NULL);
                            break;
                        case BOOLEAN:
                            if (!wrap.isNull(columnCount)) {
                                arrayList.add(Boolean.valueOf(wrap.getBoolean(columnCount)));
                                break;
                            }
                            arrayList.add(NULL);
                            break;
                        case STRING:
                            if (!wrap.isNull(columnCount)) {
                                arrayList.add(wrap.getString(columnCount));
                                break;
                            }
                            arrayList.add(NULL);
                            break;
                        case BINARY:
                            if (!wrap.isNull(columnCount)) {
                                arrayList.add(wrap.getBinaryByteArray(columnCount));
                                break;
                            }
                            arrayList.add(NULL);
                            break;
                        case FLOAT:
                            if (!wrap.isNull(columnCount)) {
                                float f = wrap.getFloat(columnCount);
                                if (!Float.isNaN(f)) {
                                    if (f != Float.POSITIVE_INFINITY) {
                                        if (f != Float.NEGATIVE_INFINITY) {
                                            arrayList.add(Float.valueOf(f));
                                            break;
                                        }
                                        arrayList.add("-Infinity");
                                        break;
                                    }
                                    arrayList.add("Infinity");
                                    break;
                                }
                                arrayList.add("NaN");
                                break;
                            }
                            arrayList.add(NULL);
                            break;
                        case DOUBLE:
                            if (!wrap.isNull(columnCount)) {
                                double d = wrap.getDouble(columnCount);
                                if (!Double.isNaN(d)) {
                                    if (d != Double.POSITIVE_INFINITY) {
                                        if (d != Double.NEGATIVE_INFINITY) {
                                            arrayList.add(Double.valueOf(d));
                                            break;
                                        }
                                        arrayList.add("-Infinity");
                                        break;
                                    }
                                    arrayList.add("Infinity");
                                    break;
                                }
                                arrayList.add("NaN");
                                break;
                            }
                            arrayList.add(NULL);
                            break;
                        case OLD_DATE:
                        case DATE:
                            if (!wrap.isNull(columnCount)) {
                                arrayList.add(formatDate(wrap.getDate(columnCount)));
                                break;
                            }
                            arrayList.add(NULL);
                            break;
                        case OBJECT:
                            if (!wrap.isNullLink(columnCount)) {
                                arrayList.add(Long.valueOf(wrap.getLink(columnCount)));
                                break;
                            }
                            arrayList.add(NULL);
                            break;
                        case LIST:
                            arrayList.add(formatList(wrap.getLinkList(columnCount)));
                            break;
                        default:
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("unknown column type: ");
                            stringBuilder.append(wrap.getColumnType(columnCount));
                            arrayList.add(stringBuilder.toString());
                            break;
                    }
                    i++;
                    instance = rowFetcher;
                } else {
                    j3++;
                    columnCount = j2;
                    instance = instance;
                }
            }
        }
        table2 = table;
        j2 = columnCount;
        if (j < table.size()) {
            for (int i2 = 0; ((long) i2) < j2; i2++) {
                arrayList.add("{truncated}");
            }
        }
        return arrayList;
    }

    private String formatDate(Date date) {
        if (this.dateTimeFormatter == null) {
            this.dateTimeFormatter = SimpleDateFormat.getDateTimeInstance(1, 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.dateTimeFormatter.format(date));
        stringBuilder.append(" (");
        stringBuilder.append(date.getTime());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    private String formatList(LinkView linkView) {
        StringBuilder stringBuilder = new StringBuilder(linkView.getTargetTable().getName());
        stringBuilder.append("{");
        long size = linkView.size();
        for (long j = 0; j < size; j++) {
            stringBuilder.append(linkView.getTargetRowIndex(j));
            stringBuilder.append(',');
        }
        if (size != 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
