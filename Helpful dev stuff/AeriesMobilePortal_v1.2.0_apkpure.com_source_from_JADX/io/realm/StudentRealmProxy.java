package io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.aeries.mobileportal.models.Demographics;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.models.ViewPermission;
import io.realm.BaseRealm.RealmObjectContext;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsObjectSchemaInfo.Builder;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmObjectProxy.CacheData;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StudentRealmProxy extends Student implements RealmObjectProxy, StudentRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private StudentColumnInfo columnInfo;
    private ProxyState<Student> proxyState;
    private RealmList<ViewPermission> viewsRealmList;

    static final class StudentColumnInfo extends ColumnInfo {
        long demographicsIndex;
        long studentIDIndex;
        long viewsIndex;

        StudentColumnInfo(SharedRealm sharedRealm, Table table) {
            super(3);
            this.demographicsIndex = addColumnDetails(table, "demographics", RealmFieldType.OBJECT);
            this.viewsIndex = addColumnDetails(table, "views", RealmFieldType.LIST);
            this.studentIDIndex = addColumnDetails(table, "studentID", RealmFieldType.INTEGER);
        }

        StudentColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        protected final ColumnInfo copy(boolean z) {
            return new StudentColumnInfo((ColumnInfo) this, z);
        }

        protected final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            StudentColumnInfo studentColumnInfo = (StudentColumnInfo) columnInfo;
            StudentColumnInfo studentColumnInfo2 = (StudentColumnInfo) columnInfo2;
            studentColumnInfo2.demographicsIndex = studentColumnInfo.demographicsIndex;
            studentColumnInfo2.viewsIndex = studentColumnInfo.viewsIndex;
            studentColumnInfo2.studentIDIndex = studentColumnInfo.studentIDIndex;
        }
    }

    public static String getTableName() {
        return "class_Student";
    }

    static {
        List arrayList = new ArrayList();
        arrayList.add("demographics");
        arrayList.add("views");
        arrayList.add("studentID");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    StudentRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (StudentColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public Demographics realmGet$demographics() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNullLink(this.columnInfo.demographicsIndex)) {
            return null;
        }
        return (Demographics) this.proxyState.getRealm$realm().get(Demographics.class, this.proxyState.getRow$realm().getLink(this.columnInfo.demographicsIndex), false, Collections.emptyList());
    }

    public void realmSet$demographics(Demographics demographics) {
        RealmObjectProxy realmObjectProxy;
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (demographics == null) {
                this.proxyState.getRow$realm().nullifyLink(this.columnInfo.demographicsIndex);
            } else if (RealmObject.isManaged(demographics) && RealmObject.isValid(demographics)) {
                realmObjectProxy = (RealmObjectProxy) demographics;
                if (realmObjectProxy.realmGet$proxyState().getRealm$realm() == this.proxyState.getRealm$realm()) {
                    this.proxyState.getRow$realm().setLink(this.columnInfo.demographicsIndex, realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex());
                    return;
                }
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            } else {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm() && !this.proxyState.getExcludeFields$realm().contains("demographics")) {
            if (!(demographics == null || RealmObject.isManaged(demographics))) {
                demographics = (Demographics) ((Realm) this.proxyState.getRealm$realm()).copyToRealm((RealmModel) demographics);
            }
            Row row$realm = this.proxyState.getRow$realm();
            if (demographics == null) {
                row$realm.nullifyLink(this.columnInfo.demographicsIndex);
            } else if (RealmObject.isValid(demographics)) {
                realmObjectProxy = (RealmObjectProxy) demographics;
                if (realmObjectProxy.realmGet$proxyState().getRealm$realm() == this.proxyState.getRealm$realm()) {
                    row$realm.getTable().setLink(this.columnInfo.demographicsIndex, row$realm.getIndex(), realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex(), true);
                    return;
                }
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            } else {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
        }
    }

    public RealmList<ViewPermission> realmGet$views() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.viewsRealmList != null) {
            return this.viewsRealmList;
        }
        this.viewsRealmList = new RealmList(ViewPermission.class, this.proxyState.getRow$realm().getLinkList(this.columnInfo.viewsIndex), this.proxyState.getRealm$realm());
        return this.viewsRealmList;
    }

    public void realmSet$views(RealmList<ViewPermission> realmList) {
        if (this.proxyState.isUnderConstruction()) {
            if (!this.proxyState.getAcceptDefaultValue$realm() || this.proxyState.getExcludeFields$realm().contains("views")) {
                return;
            }
            if (!(realmList == null || realmList.isManaged())) {
                Realm realm = (Realm) this.proxyState.getRealm$realm();
                RealmList<ViewPermission> realmList2 = new RealmList();
                realmList = realmList.iterator();
                while (realmList.hasNext()) {
                    RealmModel realmModel = (ViewPermission) realmList.next();
                    if (realmModel != null) {
                        if (!RealmObject.isManaged(realmModel)) {
                            realmList2.add(realm.copyToRealm(realmModel));
                        }
                    }
                    realmList2.add(realmModel);
                }
                realmList = realmList2;
            }
        }
        this.proxyState.getRealm$realm().checkIfValid();
        LinkView linkList = this.proxyState.getRow$realm().getLinkList(this.columnInfo.viewsIndex);
        linkList.clear();
        if (realmList != null) {
            realmList = realmList.iterator();
            while (realmList.hasNext()) {
                RealmModel realmModel2 = (RealmModel) realmList.next();
                if (RealmObject.isManaged(realmModel2) && RealmObject.isValid(realmModel2)) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) realmModel2;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() == this.proxyState.getRealm$realm()) {
                        linkList.add(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex());
                    } else {
                        throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
                    }
                }
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
        }
    }

    public int realmGet$studentID() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.studentIDIndex);
    }

    public void realmSet$studentID(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.studentIDIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.studentIDIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        Builder builder = new Builder("Student");
        builder.addLinkedProperty("demographics", RealmFieldType.OBJECT, "Demographics");
        builder.addLinkedProperty("views", RealmFieldType.LIST, "ViewPermission");
        builder.addProperty("studentID", RealmFieldType.INTEGER, false, false, true);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static StudentColumnInfo validateTable(SharedRealm sharedRealm, boolean z) {
        if (sharedRealm.hasTable("class_Student")) {
            Table table = sharedRealm.getTable("class_Student");
            long columnCount = table.getColumnCount();
            if (columnCount != 3) {
                StringBuilder stringBuilder;
                if (columnCount < 3) {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is less than expected - expected 3 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                } else if (z) {
                    RealmLog.debug("Field count is more than expected - expected 3 but was %1$d", Long.valueOf(columnCount));
                } else {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is more than expected - expected 3 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                }
            }
            z = new HashMap();
            for (long j = 0; j < columnCount; j++) {
                z.put(table.getColumnName(j), table.getColumnType(j));
            }
            StudentColumnInfo studentColumnInfo = new StudentColumnInfo(sharedRealm, table);
            if (table.hasPrimaryKey()) {
                sharedRealm = sharedRealm.getPath();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Primary Key defined for field ");
                stringBuilder2.append(table.getColumnName(table.getPrimaryKey()));
                stringBuilder2.append(" was removed.");
                throw new RealmMigrationNeededException(sharedRealm, stringBuilder2.toString());
            } else if (!z.containsKey("demographics")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'demographics' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("demographics") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Demographics' for field 'demographics'");
            } else if (sharedRealm.hasTable("class_Demographics")) {
                Table table2 = sharedRealm.getTable("class_Demographics");
                StringBuilder stringBuilder3;
                if (!table.getLinkTarget(studentColumnInfo.demographicsIndex).hasSameSchema(table2)) {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Invalid RealmObject for field 'demographics': '");
                    stringBuilder3.append(table.getLinkTarget(studentColumnInfo.demographicsIndex).getName());
                    stringBuilder3.append("' expected - was '");
                    stringBuilder3.append(table2.getName());
                    stringBuilder3.append("'");
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder3.toString());
                } else if (!z.containsKey("views")) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'views'");
                } else if (z.get("views") != RealmFieldType.LIST) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'ViewPermission' for field 'views'");
                } else if (sharedRealm.hasTable("class_ViewPermission")) {
                    table2 = sharedRealm.getTable("class_ViewPermission");
                    if (!table.getLinkTarget(studentColumnInfo.viewsIndex).hasSameSchema(table2)) {
                        sharedRealm = sharedRealm.getPath();
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("Invalid RealmList type for field 'views': '");
                        stringBuilder3.append(table.getLinkTarget(studentColumnInfo.viewsIndex).getName());
                        stringBuilder3.append("' expected - was '");
                        stringBuilder3.append(table2.getName());
                        stringBuilder3.append("'");
                        throw new RealmMigrationNeededException(sharedRealm, stringBuilder3.toString());
                    } else if (!z.containsKey("studentID")) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'studentID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (z.get("studentID") != RealmFieldType.INTEGER) {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'studentID' in existing Realm file.");
                    } else if (!table.isColumnNullable(studentColumnInfo.studentIDIndex)) {
                        return studentColumnInfo;
                    } else {
                        throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'studentID' does support null values in the existing Realm file. Use corresponding boxed type for field 'studentID' or migrate using RealmObjectSchema.setNullable().");
                    }
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_ViewPermission' for field 'views'");
                }
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_Demographics' for field 'demographics'");
            }
        }
        throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Student' class is missing from the schema for this Realm.");
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Student createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        List arrayList = new ArrayList(2);
        if (jSONObject.has("demographics")) {
            arrayList.add("demographics");
        }
        if (jSONObject.has("views")) {
            arrayList.add("views");
        }
        Student student = (Student) realm.createObjectInternal(Student.class, true, arrayList);
        if (jSONObject.has("demographics")) {
            if (jSONObject.isNull("demographics")) {
                student.realmSet$demographics(null);
            } else {
                student.realmSet$demographics(DemographicsRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject.getJSONObject("demographics"), z));
            }
        }
        if (jSONObject.has("views")) {
            if (jSONObject.isNull("views")) {
                student.realmSet$views(null);
            } else {
                StudentRealmProxyInterface studentRealmProxyInterface = student;
                studentRealmProxyInterface.realmGet$views().clear();
                JSONArray jSONArray = jSONObject.getJSONArray("views");
                for (int i = 0; i < jSONArray.length(); i++) {
                    studentRealmProxyInterface.realmGet$views().add(ViewPermissionRealmProxy.createOrUpdateUsingJsonObject(realm, jSONArray.getJSONObject(i), z));
                }
            }
        }
        if (jSONObject.has("studentID") != null) {
            if (jSONObject.isNull("studentID") == null) {
                student.realmSet$studentID(jSONObject.getInt("studentID"));
            } else {
                throw new IllegalArgumentException("Trying to set non-nullable field 'studentID' to null.");
            }
        }
        return student;
    }

    @TargetApi(11)
    public static Student createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RealmModel student = new Student();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("demographics")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((StudentRealmProxyInterface) student).realmSet$demographics(null);
                } else {
                    ((StudentRealmProxyInterface) student).realmSet$demographics(DemographicsRealmProxy.createUsingJsonStream(realm, jsonReader));
                }
            } else if (nextName.equals("views")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((StudentRealmProxyInterface) student).realmSet$views(null);
                } else {
                    StudentRealmProxyInterface studentRealmProxyInterface = (StudentRealmProxyInterface) student;
                    studentRealmProxyInterface.realmSet$views(new RealmList());
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        studentRealmProxyInterface.realmGet$views().add(ViewPermissionRealmProxy.createUsingJsonStream(realm, jsonReader));
                    }
                    jsonReader.endArray();
                }
            } else if (!nextName.equals("studentID")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                ((StudentRealmProxyInterface) student).realmSet$studentID(jsonReader.nextInt());
            } else {
                jsonReader.skipValue();
                throw new IllegalArgumentException("Trying to set non-nullable field 'studentID' to null.");
            }
        }
        jsonReader.endObject();
        return (Student) realm.copyToRealm(student);
    }

    public static Student copyOrUpdate(Realm realm, Student student, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy;
        boolean z2 = student instanceof RealmObjectProxy;
        if (z2) {
            RealmObjectProxy realmObjectProxy2 = (RealmObjectProxy) student;
            if (realmObjectProxy2.realmGet$proxyState().getRealm$realm() != null) {
                if (realmObjectProxy2.realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                }
            }
        }
        if (z2) {
            realmObjectProxy = (RealmObjectProxy) student;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return student;
            }
        }
        RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectProxy = (RealmObjectProxy) map.get(student);
        if (realmObjectProxy != null) {
            return (Student) realmObjectProxy;
        }
        return copy(realm, student, z, map);
    }

    public static Student copy(Realm realm, Student student, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = (RealmObjectProxy) map.get(student);
        if (realmObjectProxy != null) {
            return (Student) realmObjectProxy;
        }
        int i = 0;
        Student student2 = (Student) realm.createObjectInternal(Student.class, false, Collections.emptyList());
        map.put(student, (RealmObjectProxy) student2);
        StudentRealmProxyInterface studentRealmProxyInterface = student;
        StudentRealmProxyInterface studentRealmProxyInterface2 = student2;
        Demographics realmGet$demographics = studentRealmProxyInterface.realmGet$demographics();
        if (realmGet$demographics == null) {
            studentRealmProxyInterface2.realmSet$demographics(null);
        } else {
            Demographics demographics = (Demographics) map.get(realmGet$demographics);
            if (demographics != null) {
                studentRealmProxyInterface2.realmSet$demographics(demographics);
            } else {
                studentRealmProxyInterface2.realmSet$demographics(DemographicsRealmProxy.copyOrUpdate(realm, realmGet$demographics, z, map));
            }
        }
        RealmList realmGet$views = studentRealmProxyInterface.realmGet$views();
        if (realmGet$views != null) {
            RealmList realmGet$views2 = studentRealmProxyInterface2.realmGet$views();
            while (i < realmGet$views.size()) {
                ViewPermission viewPermission = (ViewPermission) realmGet$views.get(i);
                RealmModel realmModel = (ViewPermission) map.get(viewPermission);
                if (realmModel != null) {
                    realmGet$views2.add(realmModel);
                } else {
                    realmGet$views2.add(ViewPermissionRealmProxy.copyOrUpdate(realm, viewPermission, z, map));
                }
                i++;
            }
        }
        studentRealmProxyInterface2.realmSet$studentID(studentRealmProxyInterface.realmGet$studentID());
        return student2;
    }

    public static long insert(Realm realm, Student student, Map<RealmModel, Long> map) {
        long j;
        Realm realm2 = realm;
        Student student2 = student;
        Map map2 = map;
        if (student2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) student2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(Student.class);
        long nativePtr = table.getNativePtr();
        StudentColumnInfo studentColumnInfo = (StudentColumnInfo) realm2.schema.getColumnInfo(Student.class);
        long createRow = OsObject.createRow(table);
        map2.put(student2, Long.valueOf(createRow));
        StudentRealmProxyInterface studentRealmProxyInterface = student2;
        Demographics realmGet$demographics = studentRealmProxyInterface.realmGet$demographics();
        if (realmGet$demographics != null) {
            Long l = (Long) map2.get(realmGet$demographics);
            if (l == null) {
                l = Long.valueOf(DemographicsRealmProxy.insert(realm2, realmGet$demographics, map2));
            }
            j = createRow;
            Table.nativeSetLink(nativePtr, studentColumnInfo.demographicsIndex, createRow, l.longValue(), false);
        } else {
            j = createRow;
        }
        RealmList realmGet$views = studentRealmProxyInterface.realmGet$views();
        if (realmGet$views != null) {
            long nativeGetLinkView = Table.nativeGetLinkView(nativePtr, studentColumnInfo.viewsIndex, j);
            Iterator it = realmGet$views.iterator();
            while (it.hasNext()) {
                ViewPermission viewPermission = (ViewPermission) it.next();
                Long l2 = (Long) map2.get(viewPermission);
                if (l2 == null) {
                    l2 = Long.valueOf(ViewPermissionRealmProxy.insert(realm2, viewPermission, map2));
                }
                LinkView.nativeAdd(nativeGetLinkView, l2.longValue());
            }
        }
        Table.nativeSetLong(nativePtr, studentColumnInfo.studentIDIndex, j, (long) studentRealmProxyInterface.realmGet$studentID(), false);
        return j;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map map2 = map;
        Table table = realm2.getTable(Student.class);
        long nativePtr = table.getNativePtr();
        StudentColumnInfo studentColumnInfo = (StudentColumnInfo) realm2.schema.getColumnInfo(Student.class);
        while (it.hasNext()) {
            Student student = (Student) it.next();
            if (!map2.containsKey(student)) {
                long j;
                if (student instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) student;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(student, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(student, Long.valueOf(createRow));
                StudentRealmProxyInterface studentRealmProxyInterface = student;
                Demographics realmGet$demographics = studentRealmProxyInterface.realmGet$demographics();
                if (realmGet$demographics != null) {
                    Long l = (Long) map2.get(realmGet$demographics);
                    if (l == null) {
                        l = Long.valueOf(DemographicsRealmProxy.insert(realm2, realmGet$demographics, map2));
                    }
                    j = createRow;
                    table.setLink(studentColumnInfo.demographicsIndex, createRow, l.longValue(), false);
                } else {
                    j = createRow;
                }
                RealmList realmGet$views = studentRealmProxyInterface.realmGet$views();
                if (realmGet$views != null) {
                    long nativeGetLinkView = Table.nativeGetLinkView(nativePtr, studentColumnInfo.viewsIndex, j);
                    Iterator it2 = realmGet$views.iterator();
                    while (it2.hasNext()) {
                        ViewPermission viewPermission = (ViewPermission) it2.next();
                        Long l2 = (Long) map2.get(viewPermission);
                        if (l2 == null) {
                            l2 = Long.valueOf(ViewPermissionRealmProxy.insert(realm2, viewPermission, map2));
                        }
                        LinkView.nativeAdd(nativeGetLinkView, l2.longValue());
                    }
                }
                Table.nativeSetLong(nativePtr, studentColumnInfo.studentIDIndex, j, (long) studentRealmProxyInterface.realmGet$studentID(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, Student student, Map<RealmModel, Long> map) {
        long j;
        Realm realm2 = realm;
        Student student2 = student;
        Map map2 = map;
        if (student2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) student2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(Student.class);
        long nativePtr = table.getNativePtr();
        StudentColumnInfo studentColumnInfo = (StudentColumnInfo) realm2.schema.getColumnInfo(Student.class);
        long createRow = OsObject.createRow(table);
        map2.put(student2, Long.valueOf(createRow));
        StudentRealmProxyInterface studentRealmProxyInterface = student2;
        Demographics realmGet$demographics = studentRealmProxyInterface.realmGet$demographics();
        if (realmGet$demographics != null) {
            Long l = (Long) map2.get(realmGet$demographics);
            if (l == null) {
                l = Long.valueOf(DemographicsRealmProxy.insertOrUpdate(realm2, realmGet$demographics, map2));
            }
            j = createRow;
            Table.nativeSetLink(nativePtr, studentColumnInfo.demographicsIndex, createRow, l.longValue(), false);
        } else {
            j = createRow;
            Table.nativeNullifyLink(nativePtr, studentColumnInfo.demographicsIndex, j);
        }
        long nativeGetLinkView = Table.nativeGetLinkView(nativePtr, studentColumnInfo.viewsIndex, j);
        LinkView.nativeClear(nativeGetLinkView);
        RealmList realmGet$views = studentRealmProxyInterface.realmGet$views();
        if (realmGet$views != null) {
            Iterator it = realmGet$views.iterator();
            while (it.hasNext()) {
                ViewPermission viewPermission = (ViewPermission) it.next();
                Long l2 = (Long) map2.get(viewPermission);
                if (l2 == null) {
                    l2 = Long.valueOf(ViewPermissionRealmProxy.insertOrUpdate(realm2, viewPermission, map2));
                }
                LinkView.nativeAdd(nativeGetLinkView, l2.longValue());
            }
        }
        Table.nativeSetLong(nativePtr, studentColumnInfo.studentIDIndex, j, (long) studentRealmProxyInterface.realmGet$studentID(), false);
        return j;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map map2 = map;
        Table table = realm2.getTable(Student.class);
        long nativePtr = table.getNativePtr();
        StudentColumnInfo studentColumnInfo = (StudentColumnInfo) realm2.schema.getColumnInfo(Student.class);
        while (it.hasNext()) {
            Student student = (Student) it.next();
            if (!map2.containsKey(student)) {
                long j;
                if (student instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) student;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(student, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(student, Long.valueOf(createRow));
                StudentRealmProxyInterface studentRealmProxyInterface = student;
                Demographics realmGet$demographics = studentRealmProxyInterface.realmGet$demographics();
                if (realmGet$demographics != null) {
                    Long l = (Long) map2.get(realmGet$demographics);
                    if (l == null) {
                        l = Long.valueOf(DemographicsRealmProxy.insertOrUpdate(realm2, realmGet$demographics, map2));
                    }
                    j = createRow;
                    Table.nativeSetLink(nativePtr, studentColumnInfo.demographicsIndex, createRow, l.longValue(), false);
                } else {
                    j = createRow;
                    Table.nativeNullifyLink(nativePtr, studentColumnInfo.demographicsIndex, j);
                }
                long nativeGetLinkView = Table.nativeGetLinkView(nativePtr, studentColumnInfo.viewsIndex, j);
                LinkView.nativeClear(nativeGetLinkView);
                RealmList realmGet$views = studentRealmProxyInterface.realmGet$views();
                if (realmGet$views != null) {
                    Iterator it2 = realmGet$views.iterator();
                    while (it2.hasNext()) {
                        ViewPermission viewPermission = (ViewPermission) it2.next();
                        Long l2 = (Long) map2.get(viewPermission);
                        if (l2 == null) {
                            l2 = Long.valueOf(ViewPermissionRealmProxy.insertOrUpdate(realm2, viewPermission, map2));
                        }
                        LinkView.nativeAdd(nativeGetLinkView, l2.longValue());
                    }
                }
                Table.nativeSetLong(nativePtr, studentColumnInfo.studentIDIndex, j, (long) studentRealmProxyInterface.realmGet$studentID(), false);
            }
        }
    }

    public static Student createDetachedCopy(Student student, int i, int i2, Map<RealmModel, CacheData<RealmModel>> map) {
        if (i <= i2) {
            if (student != null) {
                Student student2;
                CacheData cacheData = (CacheData) map.get(student);
                if (cacheData == null) {
                    student2 = new Student();
                    map.put(student, new CacheData(i, student2));
                } else if (i >= cacheData.minDepth) {
                    return cacheData.object;
                } else {
                    Student student3 = (Student) cacheData.object;
                    cacheData.minDepth = i;
                    student2 = student3;
                }
                StudentRealmProxyInterface studentRealmProxyInterface = student2;
                StudentRealmProxyInterface studentRealmProxyInterface2 = student;
                int i3 = i + 1;
                studentRealmProxyInterface.realmSet$demographics(DemographicsRealmProxy.createDetachedCopy(studentRealmProxyInterface2.realmGet$demographics(), i3, i2, map));
                if (i == i2) {
                    studentRealmProxyInterface.realmSet$views(null);
                } else {
                    i = studentRealmProxyInterface2.realmGet$views();
                    RealmList realmList = new RealmList();
                    studentRealmProxyInterface.realmSet$views(realmList);
                    int size = i.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        realmList.add(ViewPermissionRealmProxy.createDetachedCopy((ViewPermission) i.get(i4), i3, i2, map));
                    }
                }
                studentRealmProxyInterface.realmSet$studentID(studentRealmProxyInterface2.realmGet$studentID());
                return student2;
            }
        }
        return null;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Student = proxy[");
        stringBuilder.append("{demographics:");
        stringBuilder.append(realmGet$demographics() != null ? "Demographics" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{views:");
        stringBuilder.append("RealmList<ViewPermission>[");
        stringBuilder.append(realmGet$views().size());
        stringBuilder.append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{studentID:");
        stringBuilder.append(realmGet$studentID());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public int hashCode() {
        String path = this.proxyState.getRealm$realm().getPath();
        String name = this.proxyState.getRow$realm().getTable().getName();
        long index = this.proxyState.getRow$realm().getIndex();
        int i = 0;
        int hashCode = (527 + (path != null ? path.hashCode() : 0)) * 31;
        if (name != null) {
            i = name.hashCode();
        }
        return (31 * (hashCode + i)) + ((int) (index ^ (index >>> 32)));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
        r6 = this;
        r0 = 1;
        if (r6 != r7) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        if (r7 == 0) goto L_0x0076;
    L_0x0007:
        r2 = r6.getClass();
        r3 = r7.getClass();
        if (r2 == r3) goto L_0x0012;
    L_0x0011:
        goto L_0x0076;
    L_0x0012:
        r7 = (io.realm.StudentRealmProxy) r7;
        r2 = r6.proxyState;
        r2 = r2.getRealm$realm();
        r2 = r2.getPath();
        r3 = r7.proxyState;
        r3 = r3.getRealm$realm();
        r3 = r3.getPath();
        if (r2 == 0) goto L_0x0031;
    L_0x002a:
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0034;
    L_0x0030:
        goto L_0x0033;
    L_0x0031:
        if (r3 == 0) goto L_0x0034;
    L_0x0033:
        return r1;
    L_0x0034:
        r2 = r6.proxyState;
        r2 = r2.getRow$realm();
        r2 = r2.getTable();
        r2 = r2.getName();
        r3 = r7.proxyState;
        r3 = r3.getRow$realm();
        r3 = r3.getTable();
        r3 = r3.getName();
        if (r2 == 0) goto L_0x0059;
    L_0x0052:
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x005c;
    L_0x0058:
        goto L_0x005b;
    L_0x0059:
        if (r3 == 0) goto L_0x005c;
    L_0x005b:
        return r1;
    L_0x005c:
        r2 = r6.proxyState;
        r2 = r2.getRow$realm();
        r2 = r2.getIndex();
        r7 = r7.proxyState;
        r7 = r7.getRow$realm();
        r4 = r7.getIndex();
        r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r7 == 0) goto L_0x0075;
    L_0x0074:
        return r1;
    L_0x0075:
        return r0;
    L_0x0076:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.StudentRealmProxy.equals(java.lang.Object):boolean");
    }
}
