package io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.aeries.mobileportal.models.Assignment;
import com.aeries.mobileportal.models.AssignmentCategory;
import com.aeries.mobileportal.models.Gradebook;
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

public class GradebookRealmProxy extends Gradebook implements RealmObjectProxy, GradebookRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RealmList<Assignment> assignmentsRealmList;
    private RealmList<AssignmentCategory> categoriesRealmList;
    private GradebookColumnInfo columnInfo;
    private ProxyState<Gradebook> proxyState;

    static final class GradebookColumnInfo extends ColumnInfo {
        long assignmentsIndex;
        long categoriesIndex;
        long endDateIndex;
        long gradebookNameIndex;
        long gradebookNumberIndex;
        long periodIndex;
        long showWhatIfIndex;
        long startDateIndex;
        long statusIndex;
        long termCodeIndex;
        long termDescriptionIndex;

        GradebookColumnInfo(SharedRealm sharedRealm, Table table) {
            super(11);
            this.gradebookNumberIndex = addColumnDetails(table, "gradebookNumber", RealmFieldType.INTEGER);
            this.gradebookNameIndex = addColumnDetails(table, "gradebookName", RealmFieldType.STRING);
            this.termCodeIndex = addColumnDetails(table, "termCode", RealmFieldType.STRING);
            this.termDescriptionIndex = addColumnDetails(table, "termDescription", RealmFieldType.STRING);
            this.statusIndex = addColumnDetails(table, "status", RealmFieldType.STRING);
            this.periodIndex = addColumnDetails(table, "period", RealmFieldType.INTEGER);
            this.startDateIndex = addColumnDetails(table, "startDate", RealmFieldType.STRING);
            this.endDateIndex = addColumnDetails(table, "endDate", RealmFieldType.STRING);
            this.showWhatIfIndex = addColumnDetails(table, "showWhatIf", RealmFieldType.BOOLEAN);
            this.categoriesIndex = addColumnDetails(table, "categories", RealmFieldType.LIST);
            this.assignmentsIndex = addColumnDetails(table, "assignments", RealmFieldType.LIST);
        }

        GradebookColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        protected final ColumnInfo copy(boolean z) {
            return new GradebookColumnInfo((ColumnInfo) this, z);
        }

        protected final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            GradebookColumnInfo gradebookColumnInfo = (GradebookColumnInfo) columnInfo;
            GradebookColumnInfo gradebookColumnInfo2 = (GradebookColumnInfo) columnInfo2;
            gradebookColumnInfo2.gradebookNumberIndex = gradebookColumnInfo.gradebookNumberIndex;
            gradebookColumnInfo2.gradebookNameIndex = gradebookColumnInfo.gradebookNameIndex;
            gradebookColumnInfo2.termCodeIndex = gradebookColumnInfo.termCodeIndex;
            gradebookColumnInfo2.termDescriptionIndex = gradebookColumnInfo.termDescriptionIndex;
            gradebookColumnInfo2.statusIndex = gradebookColumnInfo.statusIndex;
            gradebookColumnInfo2.periodIndex = gradebookColumnInfo.periodIndex;
            gradebookColumnInfo2.startDateIndex = gradebookColumnInfo.startDateIndex;
            gradebookColumnInfo2.endDateIndex = gradebookColumnInfo.endDateIndex;
            gradebookColumnInfo2.showWhatIfIndex = gradebookColumnInfo.showWhatIfIndex;
            gradebookColumnInfo2.categoriesIndex = gradebookColumnInfo.categoriesIndex;
            gradebookColumnInfo2.assignmentsIndex = gradebookColumnInfo.assignmentsIndex;
        }
    }

    public static String getTableName() {
        return "class_Gradebook";
    }

    static {
        List arrayList = new ArrayList();
        arrayList.add("gradebookNumber");
        arrayList.add("gradebookName");
        arrayList.add("termCode");
        arrayList.add("termDescription");
        arrayList.add("status");
        arrayList.add("period");
        arrayList.add("startDate");
        arrayList.add("endDate");
        arrayList.add("showWhatIf");
        arrayList.add("categories");
        arrayList.add("assignments");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    GradebookRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (GradebookColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public Integer realmGet$gradebookNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.gradebookNumberIndex)) {
            return null;
        }
        return Integer.valueOf((int) this.proxyState.getRow$realm().getLong(this.columnInfo.gradebookNumberIndex));
    }

    public void realmSet$gradebookNumber(Integer num) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (num == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.gradebookNumberIndex);
            } else {
                r0.proxyState.getRow$realm().setLong(r0.columnInfo.gradebookNumberIndex, (long) num.intValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (num == null) {
                row$realm.getTable().setNull(r0.columnInfo.gradebookNumberIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setLong(r0.columnInfo.gradebookNumberIndex, row$realm.getIndex(), (long) num.intValue(), true);
            }
        }
    }

    public String realmGet$gradebookName() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.gradebookNameIndex);
    }

    public void realmSet$gradebookName(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.gradebookNameIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.gradebookNameIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.gradebookNameIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.gradebookNameIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$termCode() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.termCodeIndex);
    }

    public void realmSet$termCode(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.termCodeIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.termCodeIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.termCodeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.termCodeIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$termDescription() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.termDescriptionIndex);
    }

    public void realmSet$termDescription(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.termDescriptionIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.termDescriptionIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.termDescriptionIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.termDescriptionIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$status() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.statusIndex);
    }

    public void realmSet$status(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.statusIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.statusIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.statusIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.statusIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public Integer realmGet$period() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.periodIndex)) {
            return null;
        }
        return Integer.valueOf((int) this.proxyState.getRow$realm().getLong(this.columnInfo.periodIndex));
    }

    public void realmSet$period(Integer num) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (num == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.periodIndex);
            } else {
                r0.proxyState.getRow$realm().setLong(r0.columnInfo.periodIndex, (long) num.intValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (num == null) {
                row$realm.getTable().setNull(r0.columnInfo.periodIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setLong(r0.columnInfo.periodIndex, row$realm.getIndex(), (long) num.intValue(), true);
            }
        }
    }

    public String realmGet$startDate() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.startDateIndex);
    }

    public void realmSet$startDate(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.startDateIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.startDateIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.startDateIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.startDateIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$endDate() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.endDateIndex);
    }

    public void realmSet$endDate(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.endDateIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.endDateIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.endDateIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.endDateIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public boolean realmGet$showWhatIf() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.showWhatIfIndex);
    }

    public void realmSet$showWhatIf(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.showWhatIfIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.showWhatIfIndex, row$realm.getIndex(), z, true);
        }
    }

    public RealmList<AssignmentCategory> realmGet$categories() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.categoriesRealmList != null) {
            return this.categoriesRealmList;
        }
        this.categoriesRealmList = new RealmList(AssignmentCategory.class, this.proxyState.getRow$realm().getLinkList(this.columnInfo.categoriesIndex), this.proxyState.getRealm$realm());
        return this.categoriesRealmList;
    }

    public void realmSet$categories(RealmList<AssignmentCategory> realmList) {
        if (this.proxyState.isUnderConstruction()) {
            if (!this.proxyState.getAcceptDefaultValue$realm() || this.proxyState.getExcludeFields$realm().contains("categories")) {
                return;
            }
            if (!(realmList == null || realmList.isManaged())) {
                Realm realm = (Realm) this.proxyState.getRealm$realm();
                RealmList<AssignmentCategory> realmList2 = new RealmList();
                realmList = realmList.iterator();
                while (realmList.hasNext()) {
                    RealmModel realmModel = (AssignmentCategory) realmList.next();
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
        LinkView linkList = this.proxyState.getRow$realm().getLinkList(this.columnInfo.categoriesIndex);
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

    public RealmList<Assignment> realmGet$assignments() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.assignmentsRealmList != null) {
            return this.assignmentsRealmList;
        }
        this.assignmentsRealmList = new RealmList(Assignment.class, this.proxyState.getRow$realm().getLinkList(this.columnInfo.assignmentsIndex), this.proxyState.getRealm$realm());
        return this.assignmentsRealmList;
    }

    public void realmSet$assignments(RealmList<Assignment> realmList) {
        if (this.proxyState.isUnderConstruction()) {
            if (!this.proxyState.getAcceptDefaultValue$realm() || this.proxyState.getExcludeFields$realm().contains("assignments")) {
                return;
            }
            if (!(realmList == null || realmList.isManaged())) {
                Realm realm = (Realm) this.proxyState.getRealm$realm();
                RealmList<Assignment> realmList2 = new RealmList();
                realmList = realmList.iterator();
                while (realmList.hasNext()) {
                    RealmModel realmModel = (Assignment) realmList.next();
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
        LinkView linkList = this.proxyState.getRow$realm().getLinkList(this.columnInfo.assignmentsIndex);
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

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        Builder builder = new Builder("Gradebook");
        Builder builder2 = builder;
        builder2.addProperty("gradebookNumber", RealmFieldType.INTEGER, false, false, false);
        builder2.addProperty("gradebookName", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("termCode", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("termDescription", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("status", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("period", RealmFieldType.INTEGER, false, false, false);
        builder2.addProperty("startDate", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("endDate", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("showWhatIf", RealmFieldType.BOOLEAN, false, false, true);
        builder.addLinkedProperty("categories", RealmFieldType.LIST, "AssignmentCategory");
        builder.addLinkedProperty("assignments", RealmFieldType.LIST, "Assignment");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static GradebookColumnInfo validateTable(SharedRealm sharedRealm, boolean z) {
        if (sharedRealm.hasTable("class_Gradebook")) {
            Table table = sharedRealm.getTable("class_Gradebook");
            long columnCount = table.getColumnCount();
            if (columnCount != 11) {
                StringBuilder stringBuilder;
                if (columnCount < 11) {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is less than expected - expected 11 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                } else if (z) {
                    RealmLog.debug("Field count is more than expected - expected 11 but was %1$d", Long.valueOf(columnCount));
                } else {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is more than expected - expected 11 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                }
            }
            z = new HashMap();
            for (long j = 0; j < columnCount; j++) {
                z.put(table.getColumnName(j), table.getColumnType(j));
            }
            GradebookColumnInfo gradebookColumnInfo = new GradebookColumnInfo(sharedRealm, table);
            if (table.hasPrimaryKey()) {
                sharedRealm = sharedRealm.getPath();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Primary Key defined for field ");
                stringBuilder2.append(table.getColumnName(table.getPrimaryKey()));
                stringBuilder2.append(" was removed.");
                throw new RealmMigrationNeededException(sharedRealm, stringBuilder2.toString());
            } else if (!z.containsKey("gradebookNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'gradebookNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("gradebookNumber") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'gradebookNumber' in existing Realm file.");
            } else if (!table.isColumnNullable(gradebookColumnInfo.gradebookNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'gradebookNumber' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'gradebookNumber' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("gradebookName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'gradebookName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("gradebookName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'gradebookName' in existing Realm file.");
            } else if (!table.isColumnNullable(gradebookColumnInfo.gradebookNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'gradebookName' is required. Either set @Required to field 'gradebookName' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("termCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'termCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("termCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'termCode' in existing Realm file.");
            } else if (!table.isColumnNullable(gradebookColumnInfo.termCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'termCode' is required. Either set @Required to field 'termCode' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("termDescription")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'termDescription' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("termDescription") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'termDescription' in existing Realm file.");
            } else if (!table.isColumnNullable(gradebookColumnInfo.termDescriptionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'termDescription' is required. Either set @Required to field 'termDescription' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("status")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'status' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("status") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'status' in existing Realm file.");
            } else if (!table.isColumnNullable(gradebookColumnInfo.statusIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'status' is required. Either set @Required to field 'status' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("period")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'period' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("period") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'period' in existing Realm file.");
            } else if (!table.isColumnNullable(gradebookColumnInfo.periodIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'period' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'period' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("startDate")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'startDate' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("startDate") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'startDate' in existing Realm file.");
            } else if (!table.isColumnNullable(gradebookColumnInfo.startDateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'startDate' is required. Either set @Required to field 'startDate' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("endDate")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'endDate' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("endDate") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'endDate' in existing Realm file.");
            } else if (!table.isColumnNullable(gradebookColumnInfo.endDateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'endDate' is required. Either set @Required to field 'endDate' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("showWhatIf")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'showWhatIf' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("showWhatIf") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'showWhatIf' in existing Realm file.");
            } else if (table.isColumnNullable(gradebookColumnInfo.showWhatIfIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'showWhatIf' does support null values in the existing Realm file. Use corresponding boxed type for field 'showWhatIf' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("categories")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'categories'");
            } else if (z.get("categories") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'AssignmentCategory' for field 'categories'");
            } else if (sharedRealm.hasTable("class_AssignmentCategory")) {
                Table table2 = sharedRealm.getTable("class_AssignmentCategory");
                StringBuilder stringBuilder3;
                if (!table.getLinkTarget(gradebookColumnInfo.categoriesIndex).hasSameSchema(table2)) {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Invalid RealmList type for field 'categories': '");
                    stringBuilder3.append(table.getLinkTarget(gradebookColumnInfo.categoriesIndex).getName());
                    stringBuilder3.append("' expected - was '");
                    stringBuilder3.append(table2.getName());
                    stringBuilder3.append("'");
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder3.toString());
                } else if (!z.containsKey("assignments")) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'assignments'");
                } else if (z.get("assignments") != RealmFieldType.LIST) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Assignment' for field 'assignments'");
                } else if (sharedRealm.hasTable("class_Assignment")) {
                    z = sharedRealm.getTable("class_Assignment");
                    if (table.getLinkTarget(gradebookColumnInfo.assignmentsIndex).hasSameSchema(z)) {
                        return gradebookColumnInfo;
                    }
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Invalid RealmList type for field 'assignments': '");
                    stringBuilder3.append(table.getLinkTarget(gradebookColumnInfo.assignmentsIndex).getName());
                    stringBuilder3.append("' expected - was '");
                    stringBuilder3.append(z.getName());
                    stringBuilder3.append("'");
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder3.toString());
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_Assignment' for field 'assignments'");
                }
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_AssignmentCategory' for field 'categories'");
            }
        }
        throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Gradebook' class is missing from the schema for this Realm.");
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Gradebook createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        GradebookRealmProxyInterface gradebookRealmProxyInterface;
        List arrayList = new ArrayList(2);
        if (jSONObject.has("categories")) {
            arrayList.add("categories");
        }
        if (jSONObject.has("assignments")) {
            arrayList.add("assignments");
        }
        Gradebook gradebook = (Gradebook) realm.createObjectInternal(Gradebook.class, true, arrayList);
        if (jSONObject.has("gradebookNumber")) {
            if (jSONObject.isNull("gradebookNumber")) {
                gradebook.realmSet$gradebookNumber(null);
            } else {
                gradebook.realmSet$gradebookNumber(Integer.valueOf(jSONObject.getInt("gradebookNumber")));
            }
        }
        if (jSONObject.has("gradebookName")) {
            if (jSONObject.isNull("gradebookName")) {
                gradebook.realmSet$gradebookName(null);
            } else {
                gradebook.realmSet$gradebookName(jSONObject.getString("gradebookName"));
            }
        }
        if (jSONObject.has("termCode")) {
            if (jSONObject.isNull("termCode")) {
                gradebook.realmSet$termCode(null);
            } else {
                gradebook.realmSet$termCode(jSONObject.getString("termCode"));
            }
        }
        if (jSONObject.has("termDescription")) {
            if (jSONObject.isNull("termDescription")) {
                gradebook.realmSet$termDescription(null);
            } else {
                gradebook.realmSet$termDescription(jSONObject.getString("termDescription"));
            }
        }
        if (jSONObject.has("status")) {
            if (jSONObject.isNull("status")) {
                gradebook.realmSet$status(null);
            } else {
                gradebook.realmSet$status(jSONObject.getString("status"));
            }
        }
        if (jSONObject.has("period")) {
            if (jSONObject.isNull("period")) {
                gradebook.realmSet$period(null);
            } else {
                gradebook.realmSet$period(Integer.valueOf(jSONObject.getInt("period")));
            }
        }
        if (jSONObject.has("startDate")) {
            if (jSONObject.isNull("startDate")) {
                gradebook.realmSet$startDate(null);
            } else {
                gradebook.realmSet$startDate(jSONObject.getString("startDate"));
            }
        }
        if (jSONObject.has("endDate")) {
            if (jSONObject.isNull("endDate")) {
                gradebook.realmSet$endDate(null);
            } else {
                gradebook.realmSet$endDate(jSONObject.getString("endDate"));
            }
        }
        if (jSONObject.has("showWhatIf")) {
            if (jSONObject.isNull("showWhatIf")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'showWhatIf' to null.");
            }
            gradebook.realmSet$showWhatIf(jSONObject.getBoolean("showWhatIf"));
        }
        int i = 0;
        if (jSONObject.has("categories")) {
            if (jSONObject.isNull("categories")) {
                gradebook.realmSet$categories(null);
            } else {
                gradebookRealmProxyInterface = gradebook;
                gradebookRealmProxyInterface.realmGet$categories().clear();
                JSONArray jSONArray = jSONObject.getJSONArray("categories");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    gradebookRealmProxyInterface.realmGet$categories().add(AssignmentCategoryRealmProxy.createOrUpdateUsingJsonObject(realm, jSONArray.getJSONObject(i2), z));
                }
            }
        }
        if (jSONObject.has("assignments")) {
            if (jSONObject.isNull("assignments")) {
                gradebook.realmSet$assignments(null);
            } else {
                gradebookRealmProxyInterface = gradebook;
                gradebookRealmProxyInterface.realmGet$assignments().clear();
                jSONObject = jSONObject.getJSONArray("assignments");
                while (i < jSONObject.length()) {
                    gradebookRealmProxyInterface.realmGet$assignments().add(AssignmentRealmProxy.createOrUpdateUsingJsonObject(realm, jSONObject.getJSONObject(i), z));
                    i++;
                }
            }
        }
        return gradebook;
    }

    @TargetApi(11)
    public static Gradebook createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RealmModel gradebook = new Gradebook();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("gradebookNumber")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((GradebookRealmProxyInterface) gradebook).realmSet$gradebookNumber(null);
                } else {
                    ((GradebookRealmProxyInterface) gradebook).realmSet$gradebookNumber(Integer.valueOf(jsonReader.nextInt()));
                }
            } else if (nextName.equals("gradebookName")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((GradebookRealmProxyInterface) gradebook).realmSet$gradebookName(null);
                } else {
                    ((GradebookRealmProxyInterface) gradebook).realmSet$gradebookName(jsonReader.nextString());
                }
            } else if (nextName.equals("termCode")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((GradebookRealmProxyInterface) gradebook).realmSet$termCode(null);
                } else {
                    ((GradebookRealmProxyInterface) gradebook).realmSet$termCode(jsonReader.nextString());
                }
            } else if (nextName.equals("termDescription")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((GradebookRealmProxyInterface) gradebook).realmSet$termDescription(null);
                } else {
                    ((GradebookRealmProxyInterface) gradebook).realmSet$termDescription(jsonReader.nextString());
                }
            } else if (nextName.equals("status")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((GradebookRealmProxyInterface) gradebook).realmSet$status(null);
                } else {
                    ((GradebookRealmProxyInterface) gradebook).realmSet$status(jsonReader.nextString());
                }
            } else if (nextName.equals("period")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((GradebookRealmProxyInterface) gradebook).realmSet$period(null);
                } else {
                    ((GradebookRealmProxyInterface) gradebook).realmSet$period(Integer.valueOf(jsonReader.nextInt()));
                }
            } else if (nextName.equals("startDate")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((GradebookRealmProxyInterface) gradebook).realmSet$startDate(null);
                } else {
                    ((GradebookRealmProxyInterface) gradebook).realmSet$startDate(jsonReader.nextString());
                }
            } else if (nextName.equals("endDate")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((GradebookRealmProxyInterface) gradebook).realmSet$endDate(null);
                } else {
                    ((GradebookRealmProxyInterface) gradebook).realmSet$endDate(jsonReader.nextString());
                }
            } else if (nextName.equals("showWhatIf")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    ((GradebookRealmProxyInterface) gradebook).realmSet$showWhatIf(jsonReader.nextBoolean());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'showWhatIf' to null.");
                }
            } else if (nextName.equals("categories")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((GradebookRealmProxyInterface) gradebook).realmSet$categories(null);
                } else {
                    r1 = (GradebookRealmProxyInterface) gradebook;
                    r1.realmSet$categories(new RealmList());
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        r1.realmGet$categories().add(AssignmentCategoryRealmProxy.createUsingJsonStream(realm, jsonReader));
                    }
                    jsonReader.endArray();
                }
            } else if (!nextName.equals("assignments")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.skipValue();
                ((GradebookRealmProxyInterface) gradebook).realmSet$assignments(null);
            } else {
                r1 = (GradebookRealmProxyInterface) gradebook;
                r1.realmSet$assignments(new RealmList());
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    r1.realmGet$assignments().add(AssignmentRealmProxy.createUsingJsonStream(realm, jsonReader));
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
        return (Gradebook) realm.copyToRealm(gradebook);
    }

    public static Gradebook copyOrUpdate(Realm realm, Gradebook gradebook, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy;
        boolean z2 = gradebook instanceof RealmObjectProxy;
        if (z2) {
            RealmObjectProxy realmObjectProxy2 = (RealmObjectProxy) gradebook;
            if (realmObjectProxy2.realmGet$proxyState().getRealm$realm() != null) {
                if (realmObjectProxy2.realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                }
            }
        }
        if (z2) {
            realmObjectProxy = (RealmObjectProxy) gradebook;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return gradebook;
            }
        }
        RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectProxy = (RealmObjectProxy) map.get(gradebook);
        if (realmObjectProxy != null) {
            return (Gradebook) realmObjectProxy;
        }
        return copy(realm, gradebook, z, map);
    }

    public static Gradebook copy(Realm realm, Gradebook gradebook, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = (RealmObjectProxy) map.get(gradebook);
        if (realmObjectProxy != null) {
            return (Gradebook) realmObjectProxy;
        }
        int i = 0;
        Gradebook gradebook2 = (Gradebook) realm.createObjectInternal(Gradebook.class, false, Collections.emptyList());
        map.put(gradebook, (RealmObjectProxy) gradebook2);
        GradebookRealmProxyInterface gradebookRealmProxyInterface = gradebook;
        GradebookRealmProxyInterface gradebookRealmProxyInterface2 = gradebook2;
        gradebookRealmProxyInterface2.realmSet$gradebookNumber(gradebookRealmProxyInterface.realmGet$gradebookNumber());
        gradebookRealmProxyInterface2.realmSet$gradebookName(gradebookRealmProxyInterface.realmGet$gradebookName());
        gradebookRealmProxyInterface2.realmSet$termCode(gradebookRealmProxyInterface.realmGet$termCode());
        gradebookRealmProxyInterface2.realmSet$termDescription(gradebookRealmProxyInterface.realmGet$termDescription());
        gradebookRealmProxyInterface2.realmSet$status(gradebookRealmProxyInterface.realmGet$status());
        gradebookRealmProxyInterface2.realmSet$period(gradebookRealmProxyInterface.realmGet$period());
        gradebookRealmProxyInterface2.realmSet$startDate(gradebookRealmProxyInterface.realmGet$startDate());
        gradebookRealmProxyInterface2.realmSet$endDate(gradebookRealmProxyInterface.realmGet$endDate());
        gradebookRealmProxyInterface2.realmSet$showWhatIf(gradebookRealmProxyInterface.realmGet$showWhatIf());
        RealmList realmGet$categories = gradebookRealmProxyInterface.realmGet$categories();
        if (realmGet$categories != null) {
            RealmList realmGet$categories2 = gradebookRealmProxyInterface2.realmGet$categories();
            for (int i2 = 0; i2 < realmGet$categories.size(); i2++) {
                AssignmentCategory assignmentCategory = (AssignmentCategory) realmGet$categories.get(i2);
                RealmModel realmModel = (AssignmentCategory) map.get(assignmentCategory);
                if (realmModel != null) {
                    realmGet$categories2.add(realmModel);
                } else {
                    realmGet$categories2.add(AssignmentCategoryRealmProxy.copyOrUpdate(realm, assignmentCategory, z, map));
                }
            }
        }
        gradebook = gradebookRealmProxyInterface.realmGet$assignments();
        if (gradebook != null) {
            RealmList realmGet$assignments = gradebookRealmProxyInterface2.realmGet$assignments();
            while (i < gradebook.size()) {
                Assignment assignment = (Assignment) gradebook.get(i);
                RealmModel realmModel2 = (Assignment) map.get(assignment);
                if (realmModel2 != null) {
                    realmGet$assignments.add(realmModel2);
                } else {
                    realmGet$assignments.add(AssignmentRealmProxy.copyOrUpdate(realm, assignment, z, map));
                }
                i++;
            }
        }
        return gradebook2;
    }

    public static long insert(Realm realm, Gradebook gradebook, Map<RealmModel, Long> map) {
        long j;
        Realm realm2 = realm;
        Gradebook gradebook2 = gradebook;
        Map map2 = map;
        if (gradebook2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) gradebook2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(Gradebook.class);
        long nativePtr = table.getNativePtr();
        GradebookColumnInfo gradebookColumnInfo = (GradebookColumnInfo) realm2.schema.getColumnInfo(Gradebook.class);
        long createRow = OsObject.createRow(table);
        map2.put(gradebook2, Long.valueOf(createRow));
        GradebookRealmProxyInterface gradebookRealmProxyInterface = gradebook2;
        Number realmGet$gradebookNumber = gradebookRealmProxyInterface.realmGet$gradebookNumber();
        if (realmGet$gradebookNumber != null) {
            j = createRow;
            Table.nativeSetLong(nativePtr, gradebookColumnInfo.gradebookNumberIndex, createRow, realmGet$gradebookNumber.longValue(), false);
        } else {
            j = createRow;
        }
        String realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$gradebookName();
        if (realmGet$gradebookName != null) {
            Table.nativeSetString(nativePtr, gradebookColumnInfo.gradebookNameIndex, j, realmGet$gradebookName, false);
        }
        realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$termCode();
        if (realmGet$gradebookName != null) {
            Table.nativeSetString(nativePtr, gradebookColumnInfo.termCodeIndex, j, realmGet$gradebookName, false);
        }
        realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$termDescription();
        if (realmGet$gradebookName != null) {
            Table.nativeSetString(nativePtr, gradebookColumnInfo.termDescriptionIndex, j, realmGet$gradebookName, false);
        }
        realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$status();
        if (realmGet$gradebookName != null) {
            Table.nativeSetString(nativePtr, gradebookColumnInfo.statusIndex, j, realmGet$gradebookName, false);
        }
        realmGet$gradebookNumber = gradebookRealmProxyInterface.realmGet$period();
        if (realmGet$gradebookNumber != null) {
            Table.nativeSetLong(nativePtr, gradebookColumnInfo.periodIndex, j, realmGet$gradebookNumber.longValue(), false);
        }
        realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$startDate();
        if (realmGet$gradebookName != null) {
            Table.nativeSetString(nativePtr, gradebookColumnInfo.startDateIndex, j, realmGet$gradebookName, false);
        }
        realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$endDate();
        if (realmGet$gradebookName != null) {
            Table.nativeSetString(nativePtr, gradebookColumnInfo.endDateIndex, j, realmGet$gradebookName, false);
        }
        Table.nativeSetBoolean(nativePtr, gradebookColumnInfo.showWhatIfIndex, j, gradebookRealmProxyInterface.realmGet$showWhatIf(), false);
        RealmList realmGet$categories = gradebookRealmProxyInterface.realmGet$categories();
        if (realmGet$categories != null) {
            long nativeGetLinkView = Table.nativeGetLinkView(nativePtr, gradebookColumnInfo.categoriesIndex, j);
            Iterator it = realmGet$categories.iterator();
            while (it.hasNext()) {
                AssignmentCategory assignmentCategory = (AssignmentCategory) it.next();
                Long l = (Long) map2.get(assignmentCategory);
                if (l == null) {
                    l = Long.valueOf(AssignmentCategoryRealmProxy.insert(realm2, assignmentCategory, map2));
                }
                LinkView.nativeAdd(nativeGetLinkView, l.longValue());
            }
        }
        RealmList realmGet$assignments = gradebookRealmProxyInterface.realmGet$assignments();
        if (realmGet$assignments != null) {
            long nativeGetLinkView2 = Table.nativeGetLinkView(nativePtr, gradebookColumnInfo.assignmentsIndex, j);
            Iterator it2 = realmGet$assignments.iterator();
            while (it2.hasNext()) {
                Assignment assignment = (Assignment) it2.next();
                Long l2 = (Long) map2.get(assignment);
                if (l2 == null) {
                    l2 = Long.valueOf(AssignmentRealmProxy.insert(realm2, assignment, map2));
                }
                LinkView.nativeAdd(nativeGetLinkView2, l2.longValue());
            }
        }
        return j;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map map2 = map;
        Table table = realm2.getTable(Gradebook.class);
        long nativePtr = table.getNativePtr();
        GradebookColumnInfo gradebookColumnInfo = (GradebookColumnInfo) realm2.schema.getColumnInfo(Gradebook.class);
        while (it.hasNext()) {
            Gradebook gradebook = (Gradebook) it.next();
            if (!map2.containsKey(gradebook)) {
                long j;
                long nativeGetLinkView;
                Iterator it2;
                Long l;
                if (gradebook instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) gradebook;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(gradebook, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(gradebook, Long.valueOf(createRow));
                GradebookRealmProxyInterface gradebookRealmProxyInterface = gradebook;
                Number realmGet$gradebookNumber = gradebookRealmProxyInterface.realmGet$gradebookNumber();
                if (realmGet$gradebookNumber != null) {
                    j = createRow;
                    Table.nativeSetLong(nativePtr, gradebookColumnInfo.gradebookNumberIndex, createRow, realmGet$gradebookNumber.longValue(), false);
                } else {
                    j = createRow;
                }
                String realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$gradebookName();
                if (realmGet$gradebookName != null) {
                    Table.nativeSetString(nativePtr, gradebookColumnInfo.gradebookNameIndex, j, realmGet$gradebookName, false);
                }
                realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$termCode();
                if (realmGet$gradebookName != null) {
                    Table.nativeSetString(nativePtr, gradebookColumnInfo.termCodeIndex, j, realmGet$gradebookName, false);
                }
                realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$termDescription();
                if (realmGet$gradebookName != null) {
                    Table.nativeSetString(nativePtr, gradebookColumnInfo.termDescriptionIndex, j, realmGet$gradebookName, false);
                }
                realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$status();
                if (realmGet$gradebookName != null) {
                    Table.nativeSetString(nativePtr, gradebookColumnInfo.statusIndex, j, realmGet$gradebookName, false);
                }
                realmGet$gradebookNumber = gradebookRealmProxyInterface.realmGet$period();
                if (realmGet$gradebookNumber != null) {
                    Table.nativeSetLong(nativePtr, gradebookColumnInfo.periodIndex, j, realmGet$gradebookNumber.longValue(), false);
                }
                realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$startDate();
                if (realmGet$gradebookName != null) {
                    Table.nativeSetString(nativePtr, gradebookColumnInfo.startDateIndex, j, realmGet$gradebookName, false);
                }
                realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$endDate();
                if (realmGet$gradebookName != null) {
                    Table.nativeSetString(nativePtr, gradebookColumnInfo.endDateIndex, j, realmGet$gradebookName, false);
                }
                Table.nativeSetBoolean(nativePtr, gradebookColumnInfo.showWhatIfIndex, j, gradebookRealmProxyInterface.realmGet$showWhatIf(), false);
                RealmList realmGet$categories = gradebookRealmProxyInterface.realmGet$categories();
                if (realmGet$categories != null) {
                    nativeGetLinkView = Table.nativeGetLinkView(nativePtr, gradebookColumnInfo.categoriesIndex, j);
                    it2 = realmGet$categories.iterator();
                    while (it2.hasNext()) {
                        AssignmentCategory assignmentCategory = (AssignmentCategory) it2.next();
                        l = (Long) map2.get(assignmentCategory);
                        if (l == null) {
                            l = Long.valueOf(AssignmentCategoryRealmProxy.insert(realm2, assignmentCategory, map2));
                        }
                        LinkView.nativeAdd(nativeGetLinkView, l.longValue());
                    }
                }
                realmGet$categories = gradebookRealmProxyInterface.realmGet$assignments();
                if (realmGet$categories != null) {
                    nativeGetLinkView = Table.nativeGetLinkView(nativePtr, gradebookColumnInfo.assignmentsIndex, j);
                    it2 = realmGet$categories.iterator();
                    while (it2.hasNext()) {
                        Assignment assignment = (Assignment) it2.next();
                        l = (Long) map2.get(assignment);
                        if (l == null) {
                            l = Long.valueOf(AssignmentRealmProxy.insert(realm2, assignment, map2));
                        }
                        LinkView.nativeAdd(nativeGetLinkView, l.longValue());
                    }
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, Gradebook gradebook, Map<RealmModel, Long> map) {
        long j;
        Realm realm2 = realm;
        Gradebook gradebook2 = gradebook;
        Map map2 = map;
        if (gradebook2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) gradebook2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(Gradebook.class);
        long nativePtr = table.getNativePtr();
        GradebookColumnInfo gradebookColumnInfo = (GradebookColumnInfo) realm2.schema.getColumnInfo(Gradebook.class);
        long createRow = OsObject.createRow(table);
        map2.put(gradebook2, Long.valueOf(createRow));
        GradebookRealmProxyInterface gradebookRealmProxyInterface = gradebook2;
        Number realmGet$gradebookNumber = gradebookRealmProxyInterface.realmGet$gradebookNumber();
        if (realmGet$gradebookNumber != null) {
            j = createRow;
            Table.nativeSetLong(nativePtr, gradebookColumnInfo.gradebookNumberIndex, createRow, realmGet$gradebookNumber.longValue(), false);
        } else {
            j = createRow;
            Table.nativeSetNull(nativePtr, gradebookColumnInfo.gradebookNumberIndex, j, false);
        }
        String realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$gradebookName();
        if (realmGet$gradebookName != null) {
            Table.nativeSetString(nativePtr, gradebookColumnInfo.gradebookNameIndex, j, realmGet$gradebookName, false);
        } else {
            Table.nativeSetNull(nativePtr, gradebookColumnInfo.gradebookNameIndex, j, false);
        }
        realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$termCode();
        if (realmGet$gradebookName != null) {
            Table.nativeSetString(nativePtr, gradebookColumnInfo.termCodeIndex, j, realmGet$gradebookName, false);
        } else {
            Table.nativeSetNull(nativePtr, gradebookColumnInfo.termCodeIndex, j, false);
        }
        realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$termDescription();
        if (realmGet$gradebookName != null) {
            Table.nativeSetString(nativePtr, gradebookColumnInfo.termDescriptionIndex, j, realmGet$gradebookName, false);
        } else {
            Table.nativeSetNull(nativePtr, gradebookColumnInfo.termDescriptionIndex, j, false);
        }
        realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$status();
        if (realmGet$gradebookName != null) {
            Table.nativeSetString(nativePtr, gradebookColumnInfo.statusIndex, j, realmGet$gradebookName, false);
        } else {
            Table.nativeSetNull(nativePtr, gradebookColumnInfo.statusIndex, j, false);
        }
        realmGet$gradebookNumber = gradebookRealmProxyInterface.realmGet$period();
        if (realmGet$gradebookNumber != null) {
            Table.nativeSetLong(nativePtr, gradebookColumnInfo.periodIndex, j, realmGet$gradebookNumber.longValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, gradebookColumnInfo.periodIndex, j, false);
        }
        realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$startDate();
        if (realmGet$gradebookName != null) {
            Table.nativeSetString(nativePtr, gradebookColumnInfo.startDateIndex, j, realmGet$gradebookName, false);
        } else {
            Table.nativeSetNull(nativePtr, gradebookColumnInfo.startDateIndex, j, false);
        }
        realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$endDate();
        if (realmGet$gradebookName != null) {
            Table.nativeSetString(nativePtr, gradebookColumnInfo.endDateIndex, j, realmGet$gradebookName, false);
        } else {
            Table.nativeSetNull(nativePtr, gradebookColumnInfo.endDateIndex, j, false);
        }
        long j2 = nativePtr;
        long j3 = j;
        Table.nativeSetBoolean(j2, gradebookColumnInfo.showWhatIfIndex, j3, gradebookRealmProxyInterface.realmGet$showWhatIf(), false);
        long nativeGetLinkView = Table.nativeGetLinkView(j2, gradebookColumnInfo.categoriesIndex, j3);
        LinkView.nativeClear(nativeGetLinkView);
        RealmList realmGet$categories = gradebookRealmProxyInterface.realmGet$categories();
        if (realmGet$categories != null) {
            Iterator it = realmGet$categories.iterator();
            while (it.hasNext()) {
                AssignmentCategory assignmentCategory = (AssignmentCategory) it.next();
                Long l = (Long) map2.get(assignmentCategory);
                if (l == null) {
                    l = Long.valueOf(AssignmentCategoryRealmProxy.insertOrUpdate(realm2, assignmentCategory, map2));
                }
                LinkView.nativeAdd(nativeGetLinkView, l.longValue());
            }
        }
        nativeGetLinkView = Table.nativeGetLinkView(nativePtr, gradebookColumnInfo.assignmentsIndex, j);
        LinkView.nativeClear(nativeGetLinkView);
        RealmList realmGet$assignments = gradebookRealmProxyInterface.realmGet$assignments();
        if (realmGet$assignments != null) {
            Iterator it2 = realmGet$assignments.iterator();
            while (it2.hasNext()) {
                Assignment assignment = (Assignment) it2.next();
                Long l2 = (Long) map2.get(assignment);
                if (l2 == null) {
                    l2 = Long.valueOf(AssignmentRealmProxy.insertOrUpdate(realm2, assignment, map2));
                }
                LinkView.nativeAdd(nativeGetLinkView, l2.longValue());
            }
        }
        return j;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map map2 = map;
        Table table = realm2.getTable(Gradebook.class);
        long nativePtr = table.getNativePtr();
        GradebookColumnInfo gradebookColumnInfo = (GradebookColumnInfo) realm2.schema.getColumnInfo(Gradebook.class);
        while (it.hasNext()) {
            Gradebook gradebook = (Gradebook) it.next();
            if (!map2.containsKey(gradebook)) {
                long j;
                Iterator it2;
                Long l;
                if (gradebook instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) gradebook;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(gradebook, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(gradebook, Long.valueOf(createRow));
                GradebookRealmProxyInterface gradebookRealmProxyInterface = gradebook;
                Number realmGet$gradebookNumber = gradebookRealmProxyInterface.realmGet$gradebookNumber();
                if (realmGet$gradebookNumber != null) {
                    j = createRow;
                    Table.nativeSetLong(nativePtr, gradebookColumnInfo.gradebookNumberIndex, createRow, realmGet$gradebookNumber.longValue(), false);
                } else {
                    j = createRow;
                    Table.nativeSetNull(nativePtr, gradebookColumnInfo.gradebookNumberIndex, j, false);
                }
                String realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$gradebookName();
                if (realmGet$gradebookName != null) {
                    Table.nativeSetString(nativePtr, gradebookColumnInfo.gradebookNameIndex, j, realmGet$gradebookName, false);
                } else {
                    Table.nativeSetNull(nativePtr, gradebookColumnInfo.gradebookNameIndex, j, false);
                }
                realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$termCode();
                if (realmGet$gradebookName != null) {
                    Table.nativeSetString(nativePtr, gradebookColumnInfo.termCodeIndex, j, realmGet$gradebookName, false);
                } else {
                    Table.nativeSetNull(nativePtr, gradebookColumnInfo.termCodeIndex, j, false);
                }
                realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$termDescription();
                if (realmGet$gradebookName != null) {
                    Table.nativeSetString(nativePtr, gradebookColumnInfo.termDescriptionIndex, j, realmGet$gradebookName, false);
                } else {
                    Table.nativeSetNull(nativePtr, gradebookColumnInfo.termDescriptionIndex, j, false);
                }
                realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$status();
                if (realmGet$gradebookName != null) {
                    Table.nativeSetString(nativePtr, gradebookColumnInfo.statusIndex, j, realmGet$gradebookName, false);
                } else {
                    Table.nativeSetNull(nativePtr, gradebookColumnInfo.statusIndex, j, false);
                }
                realmGet$gradebookNumber = gradebookRealmProxyInterface.realmGet$period();
                if (realmGet$gradebookNumber != null) {
                    Table.nativeSetLong(nativePtr, gradebookColumnInfo.periodIndex, j, realmGet$gradebookNumber.longValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, gradebookColumnInfo.periodIndex, j, false);
                }
                realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$startDate();
                if (realmGet$gradebookName != null) {
                    Table.nativeSetString(nativePtr, gradebookColumnInfo.startDateIndex, j, realmGet$gradebookName, false);
                } else {
                    Table.nativeSetNull(nativePtr, gradebookColumnInfo.startDateIndex, j, false);
                }
                realmGet$gradebookName = gradebookRealmProxyInterface.realmGet$endDate();
                if (realmGet$gradebookName != null) {
                    Table.nativeSetString(nativePtr, gradebookColumnInfo.endDateIndex, j, realmGet$gradebookName, false);
                } else {
                    Table.nativeSetNull(nativePtr, gradebookColumnInfo.endDateIndex, j, false);
                }
                long j2 = nativePtr;
                long j3 = j;
                Table.nativeSetBoolean(j2, gradebookColumnInfo.showWhatIfIndex, j3, gradebookRealmProxyInterface.realmGet$showWhatIf(), false);
                j2 = Table.nativeGetLinkView(j2, gradebookColumnInfo.categoriesIndex, j3);
                LinkView.nativeClear(j2);
                RealmList realmGet$categories = gradebookRealmProxyInterface.realmGet$categories();
                if (realmGet$categories != null) {
                    it2 = realmGet$categories.iterator();
                    while (it2.hasNext()) {
                        AssignmentCategory assignmentCategory = (AssignmentCategory) it2.next();
                        l = (Long) map2.get(assignmentCategory);
                        if (l == null) {
                            l = Long.valueOf(AssignmentCategoryRealmProxy.insertOrUpdate(realm2, assignmentCategory, map2));
                        }
                        LinkView.nativeAdd(j2, l.longValue());
                    }
                }
                j2 = Table.nativeGetLinkView(nativePtr, gradebookColumnInfo.assignmentsIndex, j);
                LinkView.nativeClear(j2);
                realmGet$categories = gradebookRealmProxyInterface.realmGet$assignments();
                if (realmGet$categories != null) {
                    it2 = realmGet$categories.iterator();
                    while (it2.hasNext()) {
                        Assignment assignment = (Assignment) it2.next();
                        l = (Long) map2.get(assignment);
                        if (l == null) {
                            l = Long.valueOf(AssignmentRealmProxy.insertOrUpdate(realm2, assignment, map2));
                        }
                        LinkView.nativeAdd(j2, l.longValue());
                    }
                }
            }
        }
    }

    public static Gradebook createDetachedCopy(Gradebook gradebook, int i, int i2, Map<RealmModel, CacheData<RealmModel>> map) {
        if (i <= i2) {
            if (gradebook != null) {
                Gradebook gradebook2;
                CacheData cacheData = (CacheData) map.get(gradebook);
                if (cacheData == null) {
                    gradebook2 = new Gradebook();
                    map.put(gradebook, new CacheData(i, gradebook2));
                } else if (i >= cacheData.minDepth) {
                    return cacheData.object;
                } else {
                    Gradebook gradebook3 = (Gradebook) cacheData.object;
                    cacheData.minDepth = i;
                    gradebook2 = gradebook3;
                }
                GradebookRealmProxyInterface gradebookRealmProxyInterface = gradebook2;
                GradebookRealmProxyInterface gradebookRealmProxyInterface2 = gradebook;
                gradebookRealmProxyInterface.realmSet$gradebookNumber(gradebookRealmProxyInterface2.realmGet$gradebookNumber());
                gradebookRealmProxyInterface.realmSet$gradebookName(gradebookRealmProxyInterface2.realmGet$gradebookName());
                gradebookRealmProxyInterface.realmSet$termCode(gradebookRealmProxyInterface2.realmGet$termCode());
                gradebookRealmProxyInterface.realmSet$termDescription(gradebookRealmProxyInterface2.realmGet$termDescription());
                gradebookRealmProxyInterface.realmSet$status(gradebookRealmProxyInterface2.realmGet$status());
                gradebookRealmProxyInterface.realmSet$period(gradebookRealmProxyInterface2.realmGet$period());
                gradebookRealmProxyInterface.realmSet$startDate(gradebookRealmProxyInterface2.realmGet$startDate());
                gradebookRealmProxyInterface.realmSet$endDate(gradebookRealmProxyInterface2.realmGet$endDate());
                gradebookRealmProxyInterface.realmSet$showWhatIf(gradebookRealmProxyInterface2.realmGet$showWhatIf());
                int i3 = 0;
                if (i == i2) {
                    gradebookRealmProxyInterface.realmSet$categories(null);
                } else {
                    RealmList realmGet$categories = gradebookRealmProxyInterface2.realmGet$categories();
                    RealmList realmList = new RealmList();
                    gradebookRealmProxyInterface.realmSet$categories(realmList);
                    int i4 = i + 1;
                    int size = realmGet$categories.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        realmList.add(AssignmentCategoryRealmProxy.createDetachedCopy((AssignmentCategory) realmGet$categories.get(i5), i4, i2, map));
                    }
                }
                if (i == i2) {
                    gradebookRealmProxyInterface.realmSet$assignments(null);
                } else {
                    gradebook = gradebookRealmProxyInterface2.realmGet$assignments();
                    RealmList realmList2 = new RealmList();
                    gradebookRealmProxyInterface.realmSet$assignments(realmList2);
                    i++;
                    int size2 = gradebook.size();
                    while (i3 < size2) {
                        realmList2.add(AssignmentRealmProxy.createDetachedCopy((Assignment) gradebook.get(i3), i, i2, map));
                        i3++;
                    }
                }
                return gradebook2;
            }
        }
        return null;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Gradebook = proxy[");
        stringBuilder.append("{gradebookNumber:");
        stringBuilder.append(realmGet$gradebookNumber() != null ? realmGet$gradebookNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{gradebookName:");
        stringBuilder.append(realmGet$gradebookName() != null ? realmGet$gradebookName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{termCode:");
        stringBuilder.append(realmGet$termCode() != null ? realmGet$termCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{termDescription:");
        stringBuilder.append(realmGet$termDescription() != null ? realmGet$termDescription() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status() != null ? realmGet$status() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{period:");
        stringBuilder.append(realmGet$period() != null ? realmGet$period() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{startDate:");
        stringBuilder.append(realmGet$startDate() != null ? realmGet$startDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{endDate:");
        stringBuilder.append(realmGet$endDate() != null ? realmGet$endDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{showWhatIf:");
        stringBuilder.append(realmGet$showWhatIf());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{categories:");
        stringBuilder.append("RealmList<AssignmentCategory>[");
        stringBuilder.append(realmGet$categories().size());
        stringBuilder.append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{assignments:");
        stringBuilder.append("RealmList<Assignment>[");
        stringBuilder.append(realmGet$assignments().size());
        stringBuilder.append("]");
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
        r7 = (io.realm.GradebookRealmProxy) r7;
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
        throw new UnsupportedOperationException("Method not decompiled: io.realm.GradebookRealmProxy.equals(java.lang.Object):boolean");
    }
}
