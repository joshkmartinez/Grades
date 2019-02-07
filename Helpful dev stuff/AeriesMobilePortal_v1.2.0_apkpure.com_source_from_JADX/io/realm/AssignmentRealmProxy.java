package io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.aeries.mobileportal.models.Assignment;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.realm.BaseRealm.RealmObjectContext;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
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
import org.json.JSONException;
import org.json.JSONObject;

public class AssignmentRealmProxy extends Assignment implements RealmObjectProxy, AssignmentRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private AssignmentColumnInfo columnInfo;
    private ProxyState<Assignment> proxyState;

    static final class AssignmentColumnInfo extends ColumnInfo {
        long assignmentDescriptionIndex;
        long assignmentNumberIndex;
        long categoryIndex;
        long commentIndex;
        long dateAssignedIndex;
        long dateCompletedIndex;
        long dateDueIndex;
        long descriptionIndex;
        long gradebookNameIndex;
        long isExtraCreditIndex;
        long isGradedIndex;
        long isScoreValueACheckMarkIndex;
        long isScoreVisibleToParentsIndex;
        long markIndex;
        long maxScoreIndex;
        long numberCorrectIndex;
        long numberPossibleIndex;
        long percentIndex;
        long rubricAssignMentIndex;
        long scoreIndex;
        long typeIndex;

        AssignmentColumnInfo(SharedRealm sharedRealm, Table table) {
            super(21);
            this.assignmentNumberIndex = addColumnDetails(table, "assignmentNumber", RealmFieldType.INTEGER);
            this.descriptionIndex = addColumnDetails(table, "description", RealmFieldType.STRING);
            this.typeIndex = addColumnDetails(table, Param.TYPE, RealmFieldType.STRING);
            this.categoryIndex = addColumnDetails(table, "category", RealmFieldType.STRING);
            this.isGradedIndex = addColumnDetails(table, "isGraded", RealmFieldType.BOOLEAN);
            this.isExtraCreditIndex = addColumnDetails(table, "isExtraCredit", RealmFieldType.BOOLEAN);
            this.isScoreVisibleToParentsIndex = addColumnDetails(table, "isScoreVisibleToParents", RealmFieldType.BOOLEAN);
            this.isScoreValueACheckMarkIndex = addColumnDetails(table, "isScoreValueACheckMark", RealmFieldType.BOOLEAN);
            this.numberCorrectIndex = addColumnDetails(table, "numberCorrect", RealmFieldType.DOUBLE);
            this.numberPossibleIndex = addColumnDetails(table, "numberPossible", RealmFieldType.DOUBLE);
            this.markIndex = addColumnDetails(table, "mark", RealmFieldType.STRING);
            this.scoreIndex = addColumnDetails(table, FirebaseAnalytics.Param.SCORE, RealmFieldType.DOUBLE);
            this.maxScoreIndex = addColumnDetails(table, "maxScore", RealmFieldType.DOUBLE);
            this.percentIndex = addColumnDetails(table, "percent", RealmFieldType.DOUBLE);
            this.dateAssignedIndex = addColumnDetails(table, "dateAssigned", RealmFieldType.STRING);
            this.dateDueIndex = addColumnDetails(table, "dateDue", RealmFieldType.STRING);
            this.dateCompletedIndex = addColumnDetails(table, "dateCompleted", RealmFieldType.STRING);
            this.rubricAssignMentIndex = addColumnDetails(table, "rubricAssignMent", RealmFieldType.BOOLEAN);
            this.commentIndex = addColumnDetails(table, "comment", RealmFieldType.STRING);
            this.assignmentDescriptionIndex = addColumnDetails(table, "assignmentDescription", RealmFieldType.STRING);
            this.gradebookNameIndex = addColumnDetails(table, "gradebookName", RealmFieldType.STRING);
        }

        AssignmentColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        protected final ColumnInfo copy(boolean z) {
            return new AssignmentColumnInfo((ColumnInfo) this, z);
        }

        protected final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            AssignmentColumnInfo assignmentColumnInfo = (AssignmentColumnInfo) columnInfo;
            AssignmentColumnInfo assignmentColumnInfo2 = (AssignmentColumnInfo) columnInfo2;
            assignmentColumnInfo2.assignmentNumberIndex = assignmentColumnInfo.assignmentNumberIndex;
            assignmentColumnInfo2.descriptionIndex = assignmentColumnInfo.descriptionIndex;
            assignmentColumnInfo2.typeIndex = assignmentColumnInfo.typeIndex;
            assignmentColumnInfo2.categoryIndex = assignmentColumnInfo.categoryIndex;
            assignmentColumnInfo2.isGradedIndex = assignmentColumnInfo.isGradedIndex;
            assignmentColumnInfo2.isExtraCreditIndex = assignmentColumnInfo.isExtraCreditIndex;
            assignmentColumnInfo2.isScoreVisibleToParentsIndex = assignmentColumnInfo.isScoreVisibleToParentsIndex;
            assignmentColumnInfo2.isScoreValueACheckMarkIndex = assignmentColumnInfo.isScoreValueACheckMarkIndex;
            assignmentColumnInfo2.numberCorrectIndex = assignmentColumnInfo.numberCorrectIndex;
            assignmentColumnInfo2.numberPossibleIndex = assignmentColumnInfo.numberPossibleIndex;
            assignmentColumnInfo2.markIndex = assignmentColumnInfo.markIndex;
            assignmentColumnInfo2.scoreIndex = assignmentColumnInfo.scoreIndex;
            assignmentColumnInfo2.maxScoreIndex = assignmentColumnInfo.maxScoreIndex;
            assignmentColumnInfo2.percentIndex = assignmentColumnInfo.percentIndex;
            assignmentColumnInfo2.dateAssignedIndex = assignmentColumnInfo.dateAssignedIndex;
            assignmentColumnInfo2.dateDueIndex = assignmentColumnInfo.dateDueIndex;
            assignmentColumnInfo2.dateCompletedIndex = assignmentColumnInfo.dateCompletedIndex;
            assignmentColumnInfo2.rubricAssignMentIndex = assignmentColumnInfo.rubricAssignMentIndex;
            assignmentColumnInfo2.commentIndex = assignmentColumnInfo.commentIndex;
            assignmentColumnInfo2.assignmentDescriptionIndex = assignmentColumnInfo.assignmentDescriptionIndex;
            assignmentColumnInfo2.gradebookNameIndex = assignmentColumnInfo.gradebookNameIndex;
        }
    }

    public static String getTableName() {
        return "class_Assignment";
    }

    static {
        List arrayList = new ArrayList();
        arrayList.add("assignmentNumber");
        arrayList.add("description");
        arrayList.add(Param.TYPE);
        arrayList.add("category");
        arrayList.add("isGraded");
        arrayList.add("isExtraCredit");
        arrayList.add("isScoreVisibleToParents");
        arrayList.add("isScoreValueACheckMark");
        arrayList.add("numberCorrect");
        arrayList.add("numberPossible");
        arrayList.add("mark");
        arrayList.add(FirebaseAnalytics.Param.SCORE);
        arrayList.add("maxScore");
        arrayList.add("percent");
        arrayList.add("dateAssigned");
        arrayList.add("dateDue");
        arrayList.add("dateCompleted");
        arrayList.add("rubricAssignMent");
        arrayList.add("comment");
        arrayList.add("assignmentDescription");
        arrayList.add("gradebookName");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    AssignmentRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (AssignmentColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    public Integer realmGet$assignmentNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.assignmentNumberIndex)) {
            return null;
        }
        return Integer.valueOf((int) this.proxyState.getRow$realm().getLong(this.columnInfo.assignmentNumberIndex));
    }

    public void realmSet$assignmentNumber(Integer num) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (num == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.assignmentNumberIndex);
            } else {
                r0.proxyState.getRow$realm().setLong(r0.columnInfo.assignmentNumberIndex, (long) num.intValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (num == null) {
                row$realm.getTable().setNull(r0.columnInfo.assignmentNumberIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setLong(r0.columnInfo.assignmentNumberIndex, row$realm.getIndex(), (long) num.intValue(), true);
            }
        }
    }

    public String realmGet$description() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.descriptionIndex);
    }

    public void realmSet$description(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.descriptionIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.descriptionIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.descriptionIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.descriptionIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$type() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.typeIndex);
    }

    public void realmSet$type(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.typeIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.typeIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.typeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.typeIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$category() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.categoryIndex);
    }

    public void realmSet$category(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.categoryIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.categoryIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.categoryIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.categoryIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public boolean realmGet$isGraded() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isGradedIndex);
    }

    public void realmSet$isGraded(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isGradedIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isGradedIndex, row$realm.getIndex(), z, true);
        }
    }

    public boolean realmGet$isExtraCredit() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.isExtraCreditIndex);
    }

    public void realmSet$isExtraCredit(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.isExtraCreditIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.isExtraCreditIndex, row$realm.getIndex(), z, true);
        }
    }

    public Boolean realmGet$isScoreVisibleToParents() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.isScoreVisibleToParentsIndex)) {
            return null;
        }
        return Boolean.valueOf(this.proxyState.getRow$realm().getBoolean(this.columnInfo.isScoreVisibleToParentsIndex));
    }

    public void realmSet$isScoreVisibleToParents(Boolean bool) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (bool == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.isScoreVisibleToParentsIndex);
            } else {
                this.proxyState.getRow$realm().setBoolean(this.columnInfo.isScoreVisibleToParentsIndex, bool.booleanValue());
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (bool == null) {
                row$realm.getTable().setNull(this.columnInfo.isScoreVisibleToParentsIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setBoolean(this.columnInfo.isScoreVisibleToParentsIndex, row$realm.getIndex(), bool.booleanValue(), true);
            }
        }
    }

    public Boolean realmGet$isScoreValueACheckMark() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.isScoreValueACheckMarkIndex)) {
            return null;
        }
        return Boolean.valueOf(this.proxyState.getRow$realm().getBoolean(this.columnInfo.isScoreValueACheckMarkIndex));
    }

    public void realmSet$isScoreValueACheckMark(Boolean bool) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (bool == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.isScoreValueACheckMarkIndex);
            } else {
                this.proxyState.getRow$realm().setBoolean(this.columnInfo.isScoreValueACheckMarkIndex, bool.booleanValue());
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (bool == null) {
                row$realm.getTable().setNull(this.columnInfo.isScoreValueACheckMarkIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setBoolean(this.columnInfo.isScoreValueACheckMarkIndex, row$realm.getIndex(), bool.booleanValue(), true);
            }
        }
    }

    public Double realmGet$numberCorrect() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.numberCorrectIndex)) {
            return null;
        }
        return Double.valueOf(this.proxyState.getRow$realm().getDouble(this.columnInfo.numberCorrectIndex));
    }

    public void realmSet$numberCorrect(Double d) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (d == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.numberCorrectIndex);
            } else {
                r0.proxyState.getRow$realm().setDouble(r0.columnInfo.numberCorrectIndex, d.doubleValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (d == null) {
                row$realm.getTable().setNull(r0.columnInfo.numberCorrectIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setDouble(r0.columnInfo.numberCorrectIndex, row$realm.getIndex(), d.doubleValue(), true);
            }
        }
    }

    public Double realmGet$numberPossible() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.numberPossibleIndex)) {
            return null;
        }
        return Double.valueOf(this.proxyState.getRow$realm().getDouble(this.columnInfo.numberPossibleIndex));
    }

    public void realmSet$numberPossible(Double d) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (d == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.numberPossibleIndex);
            } else {
                r0.proxyState.getRow$realm().setDouble(r0.columnInfo.numberPossibleIndex, d.doubleValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (d == null) {
                row$realm.getTable().setNull(r0.columnInfo.numberPossibleIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setDouble(r0.columnInfo.numberPossibleIndex, row$realm.getIndex(), d.doubleValue(), true);
            }
        }
    }

    public String realmGet$mark() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.markIndex);
    }

    public void realmSet$mark(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.markIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.markIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.markIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.markIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public Double realmGet$score() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.scoreIndex)) {
            return null;
        }
        return Double.valueOf(this.proxyState.getRow$realm().getDouble(this.columnInfo.scoreIndex));
    }

    public void realmSet$score(Double d) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (d == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.scoreIndex);
            } else {
                r0.proxyState.getRow$realm().setDouble(r0.columnInfo.scoreIndex, d.doubleValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (d == null) {
                row$realm.getTable().setNull(r0.columnInfo.scoreIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setDouble(r0.columnInfo.scoreIndex, row$realm.getIndex(), d.doubleValue(), true);
            }
        }
    }

    public Double realmGet$maxScore() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.maxScoreIndex)) {
            return null;
        }
        return Double.valueOf(this.proxyState.getRow$realm().getDouble(this.columnInfo.maxScoreIndex));
    }

    public void realmSet$maxScore(Double d) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (d == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.maxScoreIndex);
            } else {
                r0.proxyState.getRow$realm().setDouble(r0.columnInfo.maxScoreIndex, d.doubleValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (d == null) {
                row$realm.getTable().setNull(r0.columnInfo.maxScoreIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setDouble(r0.columnInfo.maxScoreIndex, row$realm.getIndex(), d.doubleValue(), true);
            }
        }
    }

    public Double realmGet$percent() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.percentIndex)) {
            return null;
        }
        return Double.valueOf(this.proxyState.getRow$realm().getDouble(this.columnInfo.percentIndex));
    }

    public void realmSet$percent(Double d) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (d == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.percentIndex);
            } else {
                r0.proxyState.getRow$realm().setDouble(r0.columnInfo.percentIndex, d.doubleValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (d == null) {
                row$realm.getTable().setNull(r0.columnInfo.percentIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setDouble(r0.columnInfo.percentIndex, row$realm.getIndex(), d.doubleValue(), true);
            }
        }
    }

    public String realmGet$dateAssigned() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.dateAssignedIndex);
    }

    public void realmSet$dateAssigned(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.dateAssignedIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.dateAssignedIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.dateAssignedIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.dateAssignedIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$dateDue() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.dateDueIndex);
    }

    public void realmSet$dateDue(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.dateDueIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.dateDueIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.dateDueIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.dateDueIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$dateCompleted() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.dateCompletedIndex);
    }

    public void realmSet$dateCompleted(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.dateCompletedIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.dateCompletedIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.dateCompletedIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.dateCompletedIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public boolean realmGet$rubricAssignMent() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.rubricAssignMentIndex);
    }

    public void realmSet$rubricAssignMent(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.rubricAssignMentIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.rubricAssignMentIndex, row$realm.getIndex(), z, true);
        }
    }

    public String realmGet$comment() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.commentIndex);
    }

    public void realmSet$comment(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.commentIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.commentIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.commentIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.commentIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$assignmentDescription() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.assignmentDescriptionIndex);
    }

    public void realmSet$assignmentDescription(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.assignmentDescriptionIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.assignmentDescriptionIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.assignmentDescriptionIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.assignmentDescriptionIndex, row$realm.getIndex(), str, true);
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

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        Builder builder = new Builder("Assignment");
        Builder builder2 = builder;
        builder2.addProperty("assignmentNumber", RealmFieldType.INTEGER, false, false, false);
        builder2.addProperty("description", RealmFieldType.STRING, false, false, false);
        builder2.addProperty(Param.TYPE, RealmFieldType.STRING, false, false, false);
        builder2.addProperty("category", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("isGraded", RealmFieldType.BOOLEAN, false, false, true);
        builder2.addProperty("isExtraCredit", RealmFieldType.BOOLEAN, false, false, true);
        builder2.addProperty("isScoreVisibleToParents", RealmFieldType.BOOLEAN, false, false, false);
        builder2.addProperty("isScoreValueACheckMark", RealmFieldType.BOOLEAN, false, false, false);
        builder2.addProperty("numberCorrect", RealmFieldType.DOUBLE, false, false, false);
        builder2.addProperty("numberPossible", RealmFieldType.DOUBLE, false, false, false);
        builder2.addProperty("mark", RealmFieldType.STRING, false, false, false);
        builder2.addProperty(FirebaseAnalytics.Param.SCORE, RealmFieldType.DOUBLE, false, false, false);
        builder2.addProperty("maxScore", RealmFieldType.DOUBLE, false, false, false);
        builder2.addProperty("percent", RealmFieldType.DOUBLE, false, false, false);
        builder2.addProperty("dateAssigned", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("dateDue", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("dateCompleted", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("rubricAssignMent", RealmFieldType.BOOLEAN, false, false, true);
        builder2.addProperty("comment", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("assignmentDescription", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("gradebookName", RealmFieldType.STRING, false, false, false);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static AssignmentColumnInfo validateTable(SharedRealm sharedRealm, boolean z) {
        if (sharedRealm.hasTable("class_Assignment")) {
            Table table = sharedRealm.getTable("class_Assignment");
            long columnCount = table.getColumnCount();
            if (columnCount != 21) {
                StringBuilder stringBuilder;
                if (columnCount < 21) {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is less than expected - expected 21 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                } else if (z) {
                    RealmLog.debug("Field count is more than expected - expected 21 but was %1$d", Long.valueOf(columnCount));
                } else {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is more than expected - expected 21 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                }
            }
            z = new HashMap();
            for (long j = 0; j < columnCount; j++) {
                z.put(table.getColumnName(j), table.getColumnType(j));
            }
            AssignmentColumnInfo assignmentColumnInfo = new AssignmentColumnInfo(sharedRealm, table);
            if (table.hasPrimaryKey()) {
                sharedRealm = sharedRealm.getPath();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Primary Key defined for field ");
                stringBuilder2.append(table.getColumnName(table.getPrimaryKey()));
                stringBuilder2.append(" was removed.");
                throw new RealmMigrationNeededException(sharedRealm, stringBuilder2.toString());
            } else if (!z.containsKey("assignmentNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'assignmentNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("assignmentNumber") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'assignmentNumber' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentColumnInfo.assignmentNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'assignmentNumber' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'assignmentNumber' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("description")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'description' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("description") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'description' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentColumnInfo.descriptionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'description' is required. Either set @Required to field 'description' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey(Param.TYPE)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'type' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get(Param.TYPE) != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'type' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentColumnInfo.typeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'type' is required. Either set @Required to field 'type' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("category")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'category' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("category") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'category' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentColumnInfo.categoryIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'category' is required. Either set @Required to field 'category' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("isGraded")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isGraded' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("isGraded") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'isGraded' in existing Realm file.");
            } else if (table.isColumnNullable(assignmentColumnInfo.isGradedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isGraded' does support null values in the existing Realm file. Use corresponding boxed type for field 'isGraded' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("isExtraCredit")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isExtraCredit' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("isExtraCredit") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'isExtraCredit' in existing Realm file.");
            } else if (table.isColumnNullable(assignmentColumnInfo.isExtraCreditIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isExtraCredit' does support null values in the existing Realm file. Use corresponding boxed type for field 'isExtraCredit' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("isScoreVisibleToParents")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isScoreVisibleToParents' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("isScoreVisibleToParents") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'isScoreVisibleToParents' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentColumnInfo.isScoreVisibleToParentsIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isScoreVisibleToParents' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'isScoreVisibleToParents' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("isScoreValueACheckMark")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isScoreValueACheckMark' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("isScoreValueACheckMark") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'isScoreValueACheckMark' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentColumnInfo.isScoreValueACheckMarkIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isScoreValueACheckMark' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'isScoreValueACheckMark' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("numberCorrect")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'numberCorrect' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("numberCorrect") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'numberCorrect' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentColumnInfo.numberCorrectIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'numberCorrect' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'numberCorrect' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("numberPossible")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'numberPossible' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("numberPossible") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'numberPossible' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentColumnInfo.numberPossibleIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'numberPossible' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'numberPossible' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("mark")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mark' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("mark") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'mark' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentColumnInfo.markIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mark' is required. Either set @Required to field 'mark' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey(FirebaseAnalytics.Param.SCORE)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'score' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get(FirebaseAnalytics.Param.SCORE) != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'score' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentColumnInfo.scoreIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'score' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'score' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("maxScore")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'maxScore' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("maxScore") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'maxScore' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentColumnInfo.maxScoreIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'maxScore' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'maxScore' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("percent")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'percent' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("percent") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'percent' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentColumnInfo.percentIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'percent' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'percent' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("dateAssigned")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'dateAssigned' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("dateAssigned") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'dateAssigned' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentColumnInfo.dateAssignedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'dateAssigned' is required. Either set @Required to field 'dateAssigned' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("dateDue")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'dateDue' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("dateDue") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'dateDue' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentColumnInfo.dateDueIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'dateDue' is required. Either set @Required to field 'dateDue' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("dateCompleted")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'dateCompleted' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("dateCompleted") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'dateCompleted' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentColumnInfo.dateCompletedIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'dateCompleted' is required. Either set @Required to field 'dateCompleted' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("rubricAssignMent")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'rubricAssignMent' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("rubricAssignMent") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'rubricAssignMent' in existing Realm file.");
            } else if (table.isColumnNullable(assignmentColumnInfo.rubricAssignMentIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'rubricAssignMent' does support null values in the existing Realm file. Use corresponding boxed type for field 'rubricAssignMent' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("comment")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'comment' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("comment") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'comment' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentColumnInfo.commentIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'comment' is required. Either set @Required to field 'comment' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("assignmentDescription")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'assignmentDescription' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("assignmentDescription") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'assignmentDescription' in existing Realm file.");
            } else if (!table.isColumnNullable(assignmentColumnInfo.assignmentDescriptionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'assignmentDescription' is required. Either set @Required to field 'assignmentDescription' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("gradebookName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'gradebookName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("gradebookName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'gradebookName' in existing Realm file.");
            } else if (table.isColumnNullable(assignmentColumnInfo.gradebookNameIndex)) {
                return assignmentColumnInfo;
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'gradebookName' is required. Either set @Required to field 'gradebookName' or migrate using RealmObjectSchema.setNullable().");
            }
        }
        throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Assignment' class is missing from the schema for this Realm.");
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Assignment createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        Assignment assignment = (Assignment) realm.createObjectInternal(Assignment.class, true, Collections.emptyList());
        if (jSONObject.has("assignmentNumber")) {
            if (jSONObject.isNull("assignmentNumber")) {
                assignment.realmSet$assignmentNumber(null);
            } else {
                assignment.realmSet$assignmentNumber(Integer.valueOf(jSONObject.getInt("assignmentNumber")));
            }
        }
        if (jSONObject.has("description")) {
            if (jSONObject.isNull("description")) {
                assignment.realmSet$description(null);
            } else {
                assignment.realmSet$description(jSONObject.getString("description"));
            }
        }
        if (jSONObject.has(Param.TYPE)) {
            if (jSONObject.isNull(Param.TYPE)) {
                assignment.realmSet$type(null);
            } else {
                assignment.realmSet$type(jSONObject.getString(Param.TYPE));
            }
        }
        if (jSONObject.has("category")) {
            if (jSONObject.isNull("category")) {
                assignment.realmSet$category(null);
            } else {
                assignment.realmSet$category(jSONObject.getString("category"));
            }
        }
        if (jSONObject.has("isGraded")) {
            if (jSONObject.isNull("isGraded")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isGraded' to null.");
            }
            assignment.realmSet$isGraded(jSONObject.getBoolean("isGraded"));
        }
        if (jSONObject.has("isExtraCredit")) {
            if (jSONObject.isNull("isExtraCredit")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isExtraCredit' to null.");
            }
            assignment.realmSet$isExtraCredit(jSONObject.getBoolean("isExtraCredit"));
        }
        if (jSONObject.has("isScoreVisibleToParents")) {
            if (jSONObject.isNull("isScoreVisibleToParents")) {
                assignment.realmSet$isScoreVisibleToParents(null);
            } else {
                assignment.realmSet$isScoreVisibleToParents(Boolean.valueOf(jSONObject.getBoolean("isScoreVisibleToParents")));
            }
        }
        if (jSONObject.has("isScoreValueACheckMark")) {
            if (jSONObject.isNull("isScoreValueACheckMark")) {
                assignment.realmSet$isScoreValueACheckMark(null);
            } else {
                assignment.realmSet$isScoreValueACheckMark(Boolean.valueOf(jSONObject.getBoolean("isScoreValueACheckMark")));
            }
        }
        if (jSONObject.has("numberCorrect")) {
            if (jSONObject.isNull("numberCorrect")) {
                assignment.realmSet$numberCorrect(null);
            } else {
                assignment.realmSet$numberCorrect(Double.valueOf(jSONObject.getDouble("numberCorrect")));
            }
        }
        if (jSONObject.has("numberPossible")) {
            if (jSONObject.isNull("numberPossible")) {
                assignment.realmSet$numberPossible(null);
            } else {
                assignment.realmSet$numberPossible(Double.valueOf(jSONObject.getDouble("numberPossible")));
            }
        }
        if (jSONObject.has("mark")) {
            if (jSONObject.isNull("mark")) {
                assignment.realmSet$mark(null);
            } else {
                assignment.realmSet$mark(jSONObject.getString("mark"));
            }
        }
        if (jSONObject.has(FirebaseAnalytics.Param.SCORE)) {
            if (jSONObject.isNull(FirebaseAnalytics.Param.SCORE)) {
                assignment.realmSet$score(null);
            } else {
                assignment.realmSet$score(Double.valueOf(jSONObject.getDouble(FirebaseAnalytics.Param.SCORE)));
            }
        }
        if (jSONObject.has("maxScore")) {
            if (jSONObject.isNull("maxScore")) {
                assignment.realmSet$maxScore(null);
            } else {
                assignment.realmSet$maxScore(Double.valueOf(jSONObject.getDouble("maxScore")));
            }
        }
        if (jSONObject.has("percent")) {
            if (jSONObject.isNull("percent")) {
                assignment.realmSet$percent(null);
            } else {
                assignment.realmSet$percent(Double.valueOf(jSONObject.getDouble("percent")));
            }
        }
        if (jSONObject.has("dateAssigned")) {
            if (jSONObject.isNull("dateAssigned")) {
                assignment.realmSet$dateAssigned(null);
            } else {
                assignment.realmSet$dateAssigned(jSONObject.getString("dateAssigned"));
            }
        }
        if (jSONObject.has("dateDue")) {
            if (jSONObject.isNull("dateDue")) {
                assignment.realmSet$dateDue(null);
            } else {
                assignment.realmSet$dateDue(jSONObject.getString("dateDue"));
            }
        }
        if (jSONObject.has("dateCompleted")) {
            if (jSONObject.isNull("dateCompleted")) {
                assignment.realmSet$dateCompleted(null);
            } else {
                assignment.realmSet$dateCompleted(jSONObject.getString("dateCompleted"));
            }
        }
        if (jSONObject.has("rubricAssignMent")) {
            if (jSONObject.isNull("rubricAssignMent")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'rubricAssignMent' to null.");
            }
            assignment.realmSet$rubricAssignMent(jSONObject.getBoolean("rubricAssignMent"));
        }
        if (jSONObject.has("comment")) {
            if (jSONObject.isNull("comment")) {
                assignment.realmSet$comment(null);
            } else {
                assignment.realmSet$comment(jSONObject.getString("comment"));
            }
        }
        if (jSONObject.has("assignmentDescription")) {
            if (jSONObject.isNull("assignmentDescription")) {
                assignment.realmSet$assignmentDescription(null);
            } else {
                assignment.realmSet$assignmentDescription(jSONObject.getString("assignmentDescription"));
            }
        }
        if (jSONObject.has("gradebookName")) {
            if (jSONObject.isNull("gradebookName")) {
                assignment.realmSet$gradebookName(null);
            } else {
                assignment.realmSet$gradebookName(jSONObject.getString("gradebookName"));
            }
        }
        return assignment;
    }

    @TargetApi(11)
    public static Assignment createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RealmModel assignment = new Assignment();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("assignmentNumber")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentRealmProxyInterface) assignment).realmSet$assignmentNumber(null);
                } else {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$assignmentNumber(Integer.valueOf(jsonReader.nextInt()));
                }
            } else if (nextName.equals("description")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentRealmProxyInterface) assignment).realmSet$description(null);
                } else {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$description(jsonReader.nextString());
                }
            } else if (nextName.equals(Param.TYPE)) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentRealmProxyInterface) assignment).realmSet$type(null);
                } else {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$type(jsonReader.nextString());
                }
            } else if (nextName.equals("category")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentRealmProxyInterface) assignment).realmSet$category(null);
                } else {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$category(jsonReader.nextString());
                }
            } else if (nextName.equals("isGraded")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$isGraded(jsonReader.nextBoolean());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isGraded' to null.");
                }
            } else if (nextName.equals("isExtraCredit")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$isExtraCredit(jsonReader.nextBoolean());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isExtraCredit' to null.");
                }
            } else if (nextName.equals("isScoreVisibleToParents")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentRealmProxyInterface) assignment).realmSet$isScoreVisibleToParents(null);
                } else {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$isScoreVisibleToParents(Boolean.valueOf(jsonReader.nextBoolean()));
                }
            } else if (nextName.equals("isScoreValueACheckMark")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentRealmProxyInterface) assignment).realmSet$isScoreValueACheckMark(null);
                } else {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$isScoreValueACheckMark(Boolean.valueOf(jsonReader.nextBoolean()));
                }
            } else if (nextName.equals("numberCorrect")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentRealmProxyInterface) assignment).realmSet$numberCorrect(null);
                } else {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$numberCorrect(Double.valueOf(jsonReader.nextDouble()));
                }
            } else if (nextName.equals("numberPossible")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentRealmProxyInterface) assignment).realmSet$numberPossible(null);
                } else {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$numberPossible(Double.valueOf(jsonReader.nextDouble()));
                }
            } else if (nextName.equals("mark")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentRealmProxyInterface) assignment).realmSet$mark(null);
                } else {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$mark(jsonReader.nextString());
                }
            } else if (nextName.equals(FirebaseAnalytics.Param.SCORE)) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentRealmProxyInterface) assignment).realmSet$score(null);
                } else {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$score(Double.valueOf(jsonReader.nextDouble()));
                }
            } else if (nextName.equals("maxScore")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentRealmProxyInterface) assignment).realmSet$maxScore(null);
                } else {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$maxScore(Double.valueOf(jsonReader.nextDouble()));
                }
            } else if (nextName.equals("percent")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentRealmProxyInterface) assignment).realmSet$percent(null);
                } else {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$percent(Double.valueOf(jsonReader.nextDouble()));
                }
            } else if (nextName.equals("dateAssigned")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentRealmProxyInterface) assignment).realmSet$dateAssigned(null);
                } else {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$dateAssigned(jsonReader.nextString());
                }
            } else if (nextName.equals("dateDue")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentRealmProxyInterface) assignment).realmSet$dateDue(null);
                } else {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$dateDue(jsonReader.nextString());
                }
            } else if (nextName.equals("dateCompleted")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentRealmProxyInterface) assignment).realmSet$dateCompleted(null);
                } else {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$dateCompleted(jsonReader.nextString());
                }
            } else if (nextName.equals("rubricAssignMent")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$rubricAssignMent(jsonReader.nextBoolean());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'rubricAssignMent' to null.");
                }
            } else if (nextName.equals("comment")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentRealmProxyInterface) assignment).realmSet$comment(null);
                } else {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$comment(jsonReader.nextString());
                }
            } else if (nextName.equals("assignmentDescription")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((AssignmentRealmProxyInterface) assignment).realmSet$assignmentDescription(null);
                } else {
                    ((AssignmentRealmProxyInterface) assignment).realmSet$assignmentDescription(jsonReader.nextString());
                }
            } else if (!nextName.equals("gradebookName")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.skipValue();
                ((AssignmentRealmProxyInterface) assignment).realmSet$gradebookName(null);
            } else {
                ((AssignmentRealmProxyInterface) assignment).realmSet$gradebookName(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return (Assignment) realm.copyToRealm(assignment);
    }

    public static Assignment copyOrUpdate(Realm realm, Assignment assignment, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy;
        boolean z2 = assignment instanceof RealmObjectProxy;
        if (z2) {
            RealmObjectProxy realmObjectProxy2 = (RealmObjectProxy) assignment;
            if (realmObjectProxy2.realmGet$proxyState().getRealm$realm() != null) {
                if (realmObjectProxy2.realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                }
            }
        }
        if (z2) {
            realmObjectProxy = (RealmObjectProxy) assignment;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return assignment;
            }
        }
        RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectProxy = (RealmObjectProxy) map.get(assignment);
        if (realmObjectProxy != null) {
            return (Assignment) realmObjectProxy;
        }
        return copy(realm, assignment, z, map);
    }

    public static Assignment copy(Realm realm, Assignment assignment, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = (RealmObjectProxy) map.get(assignment);
        if (realmObjectProxy != null) {
            return (Assignment) realmObjectProxy;
        }
        Assignment assignment2 = (Assignment) realm.createObjectInternal(Assignment.class, false, Collections.emptyList());
        map.put(assignment, (RealmObjectProxy) assignment2);
        AssignmentRealmProxyInterface assignmentRealmProxyInterface = assignment;
        AssignmentRealmProxyInterface assignmentRealmProxyInterface2 = assignment2;
        assignmentRealmProxyInterface2.realmSet$assignmentNumber(assignmentRealmProxyInterface.realmGet$assignmentNumber());
        assignmentRealmProxyInterface2.realmSet$description(assignmentRealmProxyInterface.realmGet$description());
        assignmentRealmProxyInterface2.realmSet$type(assignmentRealmProxyInterface.realmGet$type());
        assignmentRealmProxyInterface2.realmSet$category(assignmentRealmProxyInterface.realmGet$category());
        assignmentRealmProxyInterface2.realmSet$isGraded(assignmentRealmProxyInterface.realmGet$isGraded());
        assignmentRealmProxyInterface2.realmSet$isExtraCredit(assignmentRealmProxyInterface.realmGet$isExtraCredit());
        assignmentRealmProxyInterface2.realmSet$isScoreVisibleToParents(assignmentRealmProxyInterface.realmGet$isScoreVisibleToParents());
        assignmentRealmProxyInterface2.realmSet$isScoreValueACheckMark(assignmentRealmProxyInterface.realmGet$isScoreValueACheckMark());
        assignmentRealmProxyInterface2.realmSet$numberCorrect(assignmentRealmProxyInterface.realmGet$numberCorrect());
        assignmentRealmProxyInterface2.realmSet$numberPossible(assignmentRealmProxyInterface.realmGet$numberPossible());
        assignmentRealmProxyInterface2.realmSet$mark(assignmentRealmProxyInterface.realmGet$mark());
        assignmentRealmProxyInterface2.realmSet$score(assignmentRealmProxyInterface.realmGet$score());
        assignmentRealmProxyInterface2.realmSet$maxScore(assignmentRealmProxyInterface.realmGet$maxScore());
        assignmentRealmProxyInterface2.realmSet$percent(assignmentRealmProxyInterface.realmGet$percent());
        assignmentRealmProxyInterface2.realmSet$dateAssigned(assignmentRealmProxyInterface.realmGet$dateAssigned());
        assignmentRealmProxyInterface2.realmSet$dateDue(assignmentRealmProxyInterface.realmGet$dateDue());
        assignmentRealmProxyInterface2.realmSet$dateCompleted(assignmentRealmProxyInterface.realmGet$dateCompleted());
        assignmentRealmProxyInterface2.realmSet$rubricAssignMent(assignmentRealmProxyInterface.realmGet$rubricAssignMent());
        assignmentRealmProxyInterface2.realmSet$comment(assignmentRealmProxyInterface.realmGet$comment());
        assignmentRealmProxyInterface2.realmSet$assignmentDescription(assignmentRealmProxyInterface.realmGet$assignmentDescription());
        assignmentRealmProxyInterface2.realmSet$gradebookName(assignmentRealmProxyInterface.realmGet$gradebookName());
        return assignment2;
    }

    public static long insert(Realm realm, Assignment assignment, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Assignment assignment2 = assignment;
        if (assignment2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) assignment2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(Assignment.class);
        long nativePtr = table.getNativePtr();
        AssignmentColumnInfo assignmentColumnInfo = (AssignmentColumnInfo) realm2.schema.getColumnInfo(Assignment.class);
        long createRow = OsObject.createRow(table);
        map.put(assignment2, Long.valueOf(createRow));
        AssignmentRealmProxyInterface assignmentRealmProxyInterface = assignment2;
        Number realmGet$assignmentNumber = assignmentRealmProxyInterface.realmGet$assignmentNumber();
        if (realmGet$assignmentNumber != null) {
            Table.nativeSetLong(nativePtr, assignmentColumnInfo.assignmentNumberIndex, createRow, realmGet$assignmentNumber.longValue(), false);
        }
        String realmGet$description = assignmentRealmProxyInterface.realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.descriptionIndex, createRow, realmGet$description, false);
        }
        realmGet$description = assignmentRealmProxyInterface.realmGet$type();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.typeIndex, createRow, realmGet$description, false);
        }
        realmGet$description = assignmentRealmProxyInterface.realmGet$category();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.categoryIndex, createRow, realmGet$description, false);
        }
        long j = nativePtr;
        long j2 = createRow;
        Table.nativeSetBoolean(j, assignmentColumnInfo.isGradedIndex, j2, assignmentRealmProxyInterface.realmGet$isGraded(), false);
        Table.nativeSetBoolean(j, assignmentColumnInfo.isExtraCreditIndex, j2, assignmentRealmProxyInterface.realmGet$isExtraCredit(), false);
        Boolean realmGet$isScoreVisibleToParents = assignmentRealmProxyInterface.realmGet$isScoreVisibleToParents();
        if (realmGet$isScoreVisibleToParents != null) {
            Table.nativeSetBoolean(nativePtr, assignmentColumnInfo.isScoreVisibleToParentsIndex, createRow, realmGet$isScoreVisibleToParents.booleanValue(), false);
        }
        realmGet$isScoreVisibleToParents = assignmentRealmProxyInterface.realmGet$isScoreValueACheckMark();
        if (realmGet$isScoreVisibleToParents != null) {
            Table.nativeSetBoolean(nativePtr, assignmentColumnInfo.isScoreValueACheckMarkIndex, createRow, realmGet$isScoreVisibleToParents.booleanValue(), false);
        }
        Double realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$numberCorrect();
        if (realmGet$numberCorrect != null) {
            Table.nativeSetDouble(nativePtr, assignmentColumnInfo.numberCorrectIndex, createRow, realmGet$numberCorrect.doubleValue(), false);
        }
        realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$numberPossible();
        if (realmGet$numberCorrect != null) {
            Table.nativeSetDouble(nativePtr, assignmentColumnInfo.numberPossibleIndex, createRow, realmGet$numberCorrect.doubleValue(), false);
        }
        realmGet$description = assignmentRealmProxyInterface.realmGet$mark();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.markIndex, createRow, realmGet$description, false);
        }
        realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$score();
        if (realmGet$numberCorrect != null) {
            Table.nativeSetDouble(nativePtr, assignmentColumnInfo.scoreIndex, createRow, realmGet$numberCorrect.doubleValue(), false);
        }
        realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$maxScore();
        if (realmGet$numberCorrect != null) {
            Table.nativeSetDouble(nativePtr, assignmentColumnInfo.maxScoreIndex, createRow, realmGet$numberCorrect.doubleValue(), false);
        }
        realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$percent();
        if (realmGet$numberCorrect != null) {
            Table.nativeSetDouble(nativePtr, assignmentColumnInfo.percentIndex, createRow, realmGet$numberCorrect.doubleValue(), false);
        }
        realmGet$description = assignmentRealmProxyInterface.realmGet$dateAssigned();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.dateAssignedIndex, createRow, realmGet$description, false);
        }
        realmGet$description = assignmentRealmProxyInterface.realmGet$dateDue();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.dateDueIndex, createRow, realmGet$description, false);
        }
        realmGet$description = assignmentRealmProxyInterface.realmGet$dateCompleted();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.dateCompletedIndex, createRow, realmGet$description, false);
        }
        Table.nativeSetBoolean(nativePtr, assignmentColumnInfo.rubricAssignMentIndex, createRow, assignmentRealmProxyInterface.realmGet$rubricAssignMent(), false);
        realmGet$description = assignmentRealmProxyInterface.realmGet$comment();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.commentIndex, createRow, realmGet$description, false);
        }
        realmGet$description = assignmentRealmProxyInterface.realmGet$assignmentDescription();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.assignmentDescriptionIndex, createRow, realmGet$description, false);
        }
        realmGet$description = assignmentRealmProxyInterface.realmGet$gradebookName();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.gradebookNameIndex, createRow, realmGet$description, false);
        }
        return createRow;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Table table = realm2.getTable(Assignment.class);
        long nativePtr = table.getNativePtr();
        AssignmentColumnInfo assignmentColumnInfo = (AssignmentColumnInfo) realm2.schema.getColumnInfo(Assignment.class);
        while (it.hasNext()) {
            Assignment assignment = (Assignment) it.next();
            if (!map2.containsKey(assignment)) {
                long j;
                if (assignment instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) assignment;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(assignment, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(assignment, Long.valueOf(createRow));
                AssignmentRealmProxyInterface assignmentRealmProxyInterface = assignment;
                Number realmGet$assignmentNumber = assignmentRealmProxyInterface.realmGet$assignmentNumber();
                if (realmGet$assignmentNumber != null) {
                    j = createRow;
                    Table.nativeSetLong(nativePtr, assignmentColumnInfo.assignmentNumberIndex, createRow, realmGet$assignmentNumber.longValue(), false);
                } else {
                    j = createRow;
                }
                String realmGet$description = assignmentRealmProxyInterface.realmGet$description();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.descriptionIndex, j, realmGet$description, false);
                }
                realmGet$description = assignmentRealmProxyInterface.realmGet$type();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.typeIndex, j, realmGet$description, false);
                }
                realmGet$description = assignmentRealmProxyInterface.realmGet$category();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.categoryIndex, j, realmGet$description, false);
                }
                long j2 = nativePtr;
                long j3 = j;
                Table.nativeSetBoolean(j2, assignmentColumnInfo.isGradedIndex, j3, assignmentRealmProxyInterface.realmGet$isGraded(), false);
                Table.nativeSetBoolean(j2, assignmentColumnInfo.isExtraCreditIndex, j3, assignmentRealmProxyInterface.realmGet$isExtraCredit(), false);
                Boolean realmGet$isScoreVisibleToParents = assignmentRealmProxyInterface.realmGet$isScoreVisibleToParents();
                if (realmGet$isScoreVisibleToParents != null) {
                    Table.nativeSetBoolean(nativePtr, assignmentColumnInfo.isScoreVisibleToParentsIndex, j, realmGet$isScoreVisibleToParents.booleanValue(), false);
                }
                realmGet$isScoreVisibleToParents = assignmentRealmProxyInterface.realmGet$isScoreValueACheckMark();
                if (realmGet$isScoreVisibleToParents != null) {
                    Table.nativeSetBoolean(nativePtr, assignmentColumnInfo.isScoreValueACheckMarkIndex, j, realmGet$isScoreVisibleToParents.booleanValue(), false);
                }
                Double realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$numberCorrect();
                if (realmGet$numberCorrect != null) {
                    Table.nativeSetDouble(nativePtr, assignmentColumnInfo.numberCorrectIndex, j, realmGet$numberCorrect.doubleValue(), false);
                }
                realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$numberPossible();
                if (realmGet$numberCorrect != null) {
                    Table.nativeSetDouble(nativePtr, assignmentColumnInfo.numberPossibleIndex, j, realmGet$numberCorrect.doubleValue(), false);
                }
                realmGet$description = assignmentRealmProxyInterface.realmGet$mark();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.markIndex, j, realmGet$description, false);
                }
                realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$score();
                if (realmGet$numberCorrect != null) {
                    Table.nativeSetDouble(nativePtr, assignmentColumnInfo.scoreIndex, j, realmGet$numberCorrect.doubleValue(), false);
                }
                realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$maxScore();
                if (realmGet$numberCorrect != null) {
                    Table.nativeSetDouble(nativePtr, assignmentColumnInfo.maxScoreIndex, j, realmGet$numberCorrect.doubleValue(), false);
                }
                realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$percent();
                if (realmGet$numberCorrect != null) {
                    Table.nativeSetDouble(nativePtr, assignmentColumnInfo.percentIndex, j, realmGet$numberCorrect.doubleValue(), false);
                }
                realmGet$description = assignmentRealmProxyInterface.realmGet$dateAssigned();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.dateAssignedIndex, j, realmGet$description, false);
                }
                realmGet$description = assignmentRealmProxyInterface.realmGet$dateDue();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.dateDueIndex, j, realmGet$description, false);
                }
                realmGet$description = assignmentRealmProxyInterface.realmGet$dateCompleted();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.dateCompletedIndex, j, realmGet$description, false);
                }
                Table.nativeSetBoolean(nativePtr, assignmentColumnInfo.rubricAssignMentIndex, j, assignmentRealmProxyInterface.realmGet$rubricAssignMent(), false);
                realmGet$description = assignmentRealmProxyInterface.realmGet$comment();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.commentIndex, j, realmGet$description, false);
                }
                realmGet$description = assignmentRealmProxyInterface.realmGet$assignmentDescription();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.assignmentDescriptionIndex, j, realmGet$description, false);
                }
                realmGet$description = assignmentRealmProxyInterface.realmGet$gradebookName();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.gradebookNameIndex, j, realmGet$description, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, Assignment assignment, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Assignment assignment2 = assignment;
        if (assignment2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) assignment2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(Assignment.class);
        long nativePtr = table.getNativePtr();
        AssignmentColumnInfo assignmentColumnInfo = (AssignmentColumnInfo) realm2.schema.getColumnInfo(Assignment.class);
        long createRow = OsObject.createRow(table);
        map.put(assignment2, Long.valueOf(createRow));
        AssignmentRealmProxyInterface assignmentRealmProxyInterface = assignment2;
        Number realmGet$assignmentNumber = assignmentRealmProxyInterface.realmGet$assignmentNumber();
        if (realmGet$assignmentNumber != null) {
            Table.nativeSetLong(nativePtr, assignmentColumnInfo.assignmentNumberIndex, createRow, realmGet$assignmentNumber.longValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.assignmentNumberIndex, createRow, false);
        }
        String realmGet$description = assignmentRealmProxyInterface.realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.descriptionIndex, createRow, realmGet$description, false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.descriptionIndex, createRow, false);
        }
        realmGet$description = assignmentRealmProxyInterface.realmGet$type();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.typeIndex, createRow, realmGet$description, false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.typeIndex, createRow, false);
        }
        realmGet$description = assignmentRealmProxyInterface.realmGet$category();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.categoryIndex, createRow, realmGet$description, false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.categoryIndex, createRow, false);
        }
        long j = nativePtr;
        long j2 = createRow;
        Table.nativeSetBoolean(j, assignmentColumnInfo.isGradedIndex, j2, assignmentRealmProxyInterface.realmGet$isGraded(), false);
        Table.nativeSetBoolean(j, assignmentColumnInfo.isExtraCreditIndex, j2, assignmentRealmProxyInterface.realmGet$isExtraCredit(), false);
        Boolean realmGet$isScoreVisibleToParents = assignmentRealmProxyInterface.realmGet$isScoreVisibleToParents();
        if (realmGet$isScoreVisibleToParents != null) {
            Table.nativeSetBoolean(nativePtr, assignmentColumnInfo.isScoreVisibleToParentsIndex, createRow, realmGet$isScoreVisibleToParents.booleanValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.isScoreVisibleToParentsIndex, createRow, false);
        }
        realmGet$isScoreVisibleToParents = assignmentRealmProxyInterface.realmGet$isScoreValueACheckMark();
        if (realmGet$isScoreVisibleToParents != null) {
            Table.nativeSetBoolean(nativePtr, assignmentColumnInfo.isScoreValueACheckMarkIndex, createRow, realmGet$isScoreVisibleToParents.booleanValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.isScoreValueACheckMarkIndex, createRow, false);
        }
        Double realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$numberCorrect();
        if (realmGet$numberCorrect != null) {
            Table.nativeSetDouble(nativePtr, assignmentColumnInfo.numberCorrectIndex, createRow, realmGet$numberCorrect.doubleValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.numberCorrectIndex, createRow, false);
        }
        realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$numberPossible();
        if (realmGet$numberCorrect != null) {
            Table.nativeSetDouble(nativePtr, assignmentColumnInfo.numberPossibleIndex, createRow, realmGet$numberCorrect.doubleValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.numberPossibleIndex, createRow, false);
        }
        realmGet$description = assignmentRealmProxyInterface.realmGet$mark();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.markIndex, createRow, realmGet$description, false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.markIndex, createRow, false);
        }
        realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$score();
        if (realmGet$numberCorrect != null) {
            Table.nativeSetDouble(nativePtr, assignmentColumnInfo.scoreIndex, createRow, realmGet$numberCorrect.doubleValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.scoreIndex, createRow, false);
        }
        realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$maxScore();
        if (realmGet$numberCorrect != null) {
            Table.nativeSetDouble(nativePtr, assignmentColumnInfo.maxScoreIndex, createRow, realmGet$numberCorrect.doubleValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.maxScoreIndex, createRow, false);
        }
        realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$percent();
        if (realmGet$numberCorrect != null) {
            Table.nativeSetDouble(nativePtr, assignmentColumnInfo.percentIndex, createRow, realmGet$numberCorrect.doubleValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.percentIndex, createRow, false);
        }
        realmGet$description = assignmentRealmProxyInterface.realmGet$dateAssigned();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.dateAssignedIndex, createRow, realmGet$description, false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.dateAssignedIndex, createRow, false);
        }
        realmGet$description = assignmentRealmProxyInterface.realmGet$dateDue();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.dateDueIndex, createRow, realmGet$description, false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.dateDueIndex, createRow, false);
        }
        realmGet$description = assignmentRealmProxyInterface.realmGet$dateCompleted();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.dateCompletedIndex, createRow, realmGet$description, false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.dateCompletedIndex, createRow, false);
        }
        Table.nativeSetBoolean(nativePtr, assignmentColumnInfo.rubricAssignMentIndex, createRow, assignmentRealmProxyInterface.realmGet$rubricAssignMent(), false);
        realmGet$description = assignmentRealmProxyInterface.realmGet$comment();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.commentIndex, createRow, realmGet$description, false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.commentIndex, createRow, false);
        }
        realmGet$description = assignmentRealmProxyInterface.realmGet$assignmentDescription();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.assignmentDescriptionIndex, createRow, realmGet$description, false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.assignmentDescriptionIndex, createRow, false);
        }
        realmGet$description = assignmentRealmProxyInterface.realmGet$gradebookName();
        if (realmGet$description != null) {
            Table.nativeSetString(nativePtr, assignmentColumnInfo.gradebookNameIndex, createRow, realmGet$description, false);
        } else {
            Table.nativeSetNull(nativePtr, assignmentColumnInfo.gradebookNameIndex, createRow, false);
        }
        return createRow;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Table table = realm2.getTable(Assignment.class);
        long nativePtr = table.getNativePtr();
        AssignmentColumnInfo assignmentColumnInfo = (AssignmentColumnInfo) realm2.schema.getColumnInfo(Assignment.class);
        while (it.hasNext()) {
            Assignment assignment = (Assignment) it.next();
            if (!map2.containsKey(assignment)) {
                long j;
                if (assignment instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) assignment;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(assignment, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(assignment, Long.valueOf(createRow));
                AssignmentRealmProxyInterface assignmentRealmProxyInterface = assignment;
                Number realmGet$assignmentNumber = assignmentRealmProxyInterface.realmGet$assignmentNumber();
                if (realmGet$assignmentNumber != null) {
                    j = createRow;
                    Table.nativeSetLong(nativePtr, assignmentColumnInfo.assignmentNumberIndex, createRow, realmGet$assignmentNumber.longValue(), false);
                } else {
                    j = createRow;
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.assignmentNumberIndex, j, false);
                }
                String realmGet$description = assignmentRealmProxyInterface.realmGet$description();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.descriptionIndex, j, realmGet$description, false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.descriptionIndex, j, false);
                }
                realmGet$description = assignmentRealmProxyInterface.realmGet$type();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.typeIndex, j, realmGet$description, false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.typeIndex, j, false);
                }
                realmGet$description = assignmentRealmProxyInterface.realmGet$category();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.categoryIndex, j, realmGet$description, false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.categoryIndex, j, false);
                }
                long j2 = nativePtr;
                long j3 = j;
                Table.nativeSetBoolean(j2, assignmentColumnInfo.isGradedIndex, j3, assignmentRealmProxyInterface.realmGet$isGraded(), false);
                Table.nativeSetBoolean(j2, assignmentColumnInfo.isExtraCreditIndex, j3, assignmentRealmProxyInterface.realmGet$isExtraCredit(), false);
                Boolean realmGet$isScoreVisibleToParents = assignmentRealmProxyInterface.realmGet$isScoreVisibleToParents();
                if (realmGet$isScoreVisibleToParents != null) {
                    Table.nativeSetBoolean(nativePtr, assignmentColumnInfo.isScoreVisibleToParentsIndex, j, realmGet$isScoreVisibleToParents.booleanValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.isScoreVisibleToParentsIndex, j, false);
                }
                realmGet$isScoreVisibleToParents = assignmentRealmProxyInterface.realmGet$isScoreValueACheckMark();
                if (realmGet$isScoreVisibleToParents != null) {
                    Table.nativeSetBoolean(nativePtr, assignmentColumnInfo.isScoreValueACheckMarkIndex, j, realmGet$isScoreVisibleToParents.booleanValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.isScoreValueACheckMarkIndex, j, false);
                }
                Double realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$numberCorrect();
                if (realmGet$numberCorrect != null) {
                    Table.nativeSetDouble(nativePtr, assignmentColumnInfo.numberCorrectIndex, j, realmGet$numberCorrect.doubleValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.numberCorrectIndex, j, false);
                }
                realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$numberPossible();
                if (realmGet$numberCorrect != null) {
                    Table.nativeSetDouble(nativePtr, assignmentColumnInfo.numberPossibleIndex, j, realmGet$numberCorrect.doubleValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.numberPossibleIndex, j, false);
                }
                realmGet$description = assignmentRealmProxyInterface.realmGet$mark();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.markIndex, j, realmGet$description, false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.markIndex, j, false);
                }
                realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$score();
                if (realmGet$numberCorrect != null) {
                    Table.nativeSetDouble(nativePtr, assignmentColumnInfo.scoreIndex, j, realmGet$numberCorrect.doubleValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.scoreIndex, j, false);
                }
                realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$maxScore();
                if (realmGet$numberCorrect != null) {
                    Table.nativeSetDouble(nativePtr, assignmentColumnInfo.maxScoreIndex, j, realmGet$numberCorrect.doubleValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.maxScoreIndex, j, false);
                }
                realmGet$numberCorrect = assignmentRealmProxyInterface.realmGet$percent();
                if (realmGet$numberCorrect != null) {
                    Table.nativeSetDouble(nativePtr, assignmentColumnInfo.percentIndex, j, realmGet$numberCorrect.doubleValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.percentIndex, j, false);
                }
                realmGet$description = assignmentRealmProxyInterface.realmGet$dateAssigned();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.dateAssignedIndex, j, realmGet$description, false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.dateAssignedIndex, j, false);
                }
                realmGet$description = assignmentRealmProxyInterface.realmGet$dateDue();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.dateDueIndex, j, realmGet$description, false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.dateDueIndex, j, false);
                }
                realmGet$description = assignmentRealmProxyInterface.realmGet$dateCompleted();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.dateCompletedIndex, j, realmGet$description, false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.dateCompletedIndex, j, false);
                }
                Table.nativeSetBoolean(nativePtr, assignmentColumnInfo.rubricAssignMentIndex, j, assignmentRealmProxyInterface.realmGet$rubricAssignMent(), false);
                realmGet$description = assignmentRealmProxyInterface.realmGet$comment();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.commentIndex, j, realmGet$description, false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.commentIndex, j, false);
                }
                realmGet$description = assignmentRealmProxyInterface.realmGet$assignmentDescription();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.assignmentDescriptionIndex, j, realmGet$description, false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.assignmentDescriptionIndex, j, false);
                }
                realmGet$description = assignmentRealmProxyInterface.realmGet$gradebookName();
                if (realmGet$description != null) {
                    Table.nativeSetString(nativePtr, assignmentColumnInfo.gradebookNameIndex, j, realmGet$description, false);
                } else {
                    Table.nativeSetNull(nativePtr, assignmentColumnInfo.gradebookNameIndex, j, false);
                }
            }
        }
    }

    public static Assignment createDetachedCopy(Assignment assignment, int i, int i2, Map<RealmModel, CacheData<RealmModel>> map) {
        if (i <= i2) {
            if (assignment != null) {
                CacheData cacheData = (CacheData) map.get(assignment);
                if (cacheData == null) {
                    i2 = new Assignment();
                    map.put(assignment, new CacheData(i, i2));
                } else if (i >= cacheData.minDepth) {
                    return cacheData.object;
                } else {
                    Assignment assignment2 = (Assignment) cacheData.object;
                    cacheData.minDepth = i;
                    i2 = assignment2;
                }
                AssignmentRealmProxyInterface assignmentRealmProxyInterface = (AssignmentRealmProxyInterface) i2;
                AssignmentRealmProxyInterface assignmentRealmProxyInterface2 = assignment;
                assignmentRealmProxyInterface.realmSet$assignmentNumber(assignmentRealmProxyInterface2.realmGet$assignmentNumber());
                assignmentRealmProxyInterface.realmSet$description(assignmentRealmProxyInterface2.realmGet$description());
                assignmentRealmProxyInterface.realmSet$type(assignmentRealmProxyInterface2.realmGet$type());
                assignmentRealmProxyInterface.realmSet$category(assignmentRealmProxyInterface2.realmGet$category());
                assignmentRealmProxyInterface.realmSet$isGraded(assignmentRealmProxyInterface2.realmGet$isGraded());
                assignmentRealmProxyInterface.realmSet$isExtraCredit(assignmentRealmProxyInterface2.realmGet$isExtraCredit());
                assignmentRealmProxyInterface.realmSet$isScoreVisibleToParents(assignmentRealmProxyInterface2.realmGet$isScoreVisibleToParents());
                assignmentRealmProxyInterface.realmSet$isScoreValueACheckMark(assignmentRealmProxyInterface2.realmGet$isScoreValueACheckMark());
                assignmentRealmProxyInterface.realmSet$numberCorrect(assignmentRealmProxyInterface2.realmGet$numberCorrect());
                assignmentRealmProxyInterface.realmSet$numberPossible(assignmentRealmProxyInterface2.realmGet$numberPossible());
                assignmentRealmProxyInterface.realmSet$mark(assignmentRealmProxyInterface2.realmGet$mark());
                assignmentRealmProxyInterface.realmSet$score(assignmentRealmProxyInterface2.realmGet$score());
                assignmentRealmProxyInterface.realmSet$maxScore(assignmentRealmProxyInterface2.realmGet$maxScore());
                assignmentRealmProxyInterface.realmSet$percent(assignmentRealmProxyInterface2.realmGet$percent());
                assignmentRealmProxyInterface.realmSet$dateAssigned(assignmentRealmProxyInterface2.realmGet$dateAssigned());
                assignmentRealmProxyInterface.realmSet$dateDue(assignmentRealmProxyInterface2.realmGet$dateDue());
                assignmentRealmProxyInterface.realmSet$dateCompleted(assignmentRealmProxyInterface2.realmGet$dateCompleted());
                assignmentRealmProxyInterface.realmSet$rubricAssignMent(assignmentRealmProxyInterface2.realmGet$rubricAssignMent());
                assignmentRealmProxyInterface.realmSet$comment(assignmentRealmProxyInterface2.realmGet$comment());
                assignmentRealmProxyInterface.realmSet$assignmentDescription(assignmentRealmProxyInterface2.realmGet$assignmentDescription());
                assignmentRealmProxyInterface.realmSet$gradebookName(assignmentRealmProxyInterface2.realmGet$gradebookName());
                return i2;
            }
        }
        return null;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Assignment = proxy[");
        stringBuilder.append("{assignmentNumber:");
        stringBuilder.append(realmGet$assignmentNumber() != null ? realmGet$assignmentNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description() != null ? realmGet$description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type() != null ? realmGet$type() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{category:");
        stringBuilder.append(realmGet$category() != null ? realmGet$category() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isGraded:");
        stringBuilder.append(realmGet$isGraded());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isExtraCredit:");
        stringBuilder.append(realmGet$isExtraCredit());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isScoreVisibleToParents:");
        stringBuilder.append(realmGet$isScoreVisibleToParents() != null ? realmGet$isScoreVisibleToParents() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isScoreValueACheckMark:");
        stringBuilder.append(realmGet$isScoreValueACheckMark() != null ? realmGet$isScoreValueACheckMark() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numberCorrect:");
        stringBuilder.append(realmGet$numberCorrect() != null ? realmGet$numberCorrect() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numberPossible:");
        stringBuilder.append(realmGet$numberPossible() != null ? realmGet$numberPossible() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mark:");
        stringBuilder.append(realmGet$mark() != null ? realmGet$mark() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{score:");
        stringBuilder.append(realmGet$score() != null ? realmGet$score() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{maxScore:");
        stringBuilder.append(realmGet$maxScore() != null ? realmGet$maxScore() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{percent:");
        stringBuilder.append(realmGet$percent() != null ? realmGet$percent() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{dateAssigned:");
        stringBuilder.append(realmGet$dateAssigned() != null ? realmGet$dateAssigned() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{dateDue:");
        stringBuilder.append(realmGet$dateDue() != null ? realmGet$dateDue() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{dateCompleted:");
        stringBuilder.append(realmGet$dateCompleted() != null ? realmGet$dateCompleted() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{rubricAssignMent:");
        stringBuilder.append(realmGet$rubricAssignMent());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{comment:");
        stringBuilder.append(realmGet$comment() != null ? realmGet$comment() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{assignmentDescription:");
        stringBuilder.append(realmGet$assignmentDescription() != null ? realmGet$assignmentDescription() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{gradebookName:");
        stringBuilder.append(realmGet$gradebookName() != null ? realmGet$gradebookName() : "null");
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
        r7 = (io.realm.AssignmentRealmProxy) r7;
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
        throw new UnsupportedOperationException("Method not decompiled: io.realm.AssignmentRealmProxy.equals(java.lang.Object):boolean");
    }
}
