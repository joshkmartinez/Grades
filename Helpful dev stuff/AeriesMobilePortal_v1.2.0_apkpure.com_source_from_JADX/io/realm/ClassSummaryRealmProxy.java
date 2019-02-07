package io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.aeries.mobileportal.models.ClassSummary;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
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

public class ClassSummaryRealmProxy extends ClassSummary implements RealmObjectProxy, ClassSummaryRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private ClassSummaryColumnInfo columnInfo;
    private ProxyState<ClassSummary> proxyState;

    static final class ClassSummaryColumnInfo extends ColumnInfo {
        long averageIndex;
        long courseNumberIndex;
        long courseTitleIndex;
        long currentMarkIndex;
        long doingRubricIndex;
        long gradeBookNameIndex;
        long gradeBookNumberIndex;
        long hideScoresIndex;
        long lastUpdatedIndex;
        long missingAssignmentIndex;
        long percentIndex;
        long periodIndex;
        long roomNumberIndex;
        long schoolCodeIndex;
        long schoolNameIndex;
        long sectionNumberIndex;
        long showPeriodIndex;
        long studentIDIndex;
        long teacherNameIndex;
        long teacherNumberIndex;
        long termCodeIndex;
        long termIndex;

        ClassSummaryColumnInfo(SharedRealm sharedRealm, Table table) {
            super(22);
            this.periodIndex = addColumnDetails(table, "period", RealmFieldType.INTEGER);
            this.schoolCodeIndex = addColumnDetails(table, "schoolCode", RealmFieldType.INTEGER);
            this.studentIDIndex = addColumnDetails(table, "studentID", RealmFieldType.INTEGER);
            this.showPeriodIndex = addColumnDetails(table, "showPeriod", RealmFieldType.BOOLEAN);
            this.hideScoresIndex = addColumnDetails(table, "hideScores", RealmFieldType.BOOLEAN);
            this.schoolNameIndex = addColumnDetails(table, "schoolName", RealmFieldType.STRING);
            this.sectionNumberIndex = addColumnDetails(table, "sectionNumber", RealmFieldType.INTEGER);
            this.gradeBookNumberIndex = addColumnDetails(table, "gradeBookNumber", RealmFieldType.INTEGER);
            this.gradeBookNameIndex = addColumnDetails(table, "gradeBookName", RealmFieldType.STRING);
            this.doingRubricIndex = addColumnDetails(table, "doingRubric", RealmFieldType.BOOLEAN);
            this.courseNumberIndex = addColumnDetails(table, "courseNumber", RealmFieldType.STRING);
            this.courseTitleIndex = addColumnDetails(table, "courseTitle", RealmFieldType.STRING);
            this.teacherNumberIndex = addColumnDetails(table, "teacherNumber", RealmFieldType.INTEGER);
            this.teacherNameIndex = addColumnDetails(table, "teacherName", RealmFieldType.STRING);
            this.roomNumberIndex = addColumnDetails(table, "roomNumber", RealmFieldType.STRING);
            this.currentMarkIndex = addColumnDetails(table, "currentMark", RealmFieldType.STRING);
            this.percentIndex = addColumnDetails(table, "percent", RealmFieldType.DOUBLE);
            this.averageIndex = addColumnDetails(table, "average", RealmFieldType.STRING);
            this.missingAssignmentIndex = addColumnDetails(table, "missingAssignment", RealmFieldType.INTEGER);
            this.termIndex = addColumnDetails(table, Param.TERM, RealmFieldType.STRING);
            this.termCodeIndex = addColumnDetails(table, "termCode", RealmFieldType.STRING);
            this.lastUpdatedIndex = addColumnDetails(table, "lastUpdated", RealmFieldType.STRING);
        }

        ClassSummaryColumnInfo(ColumnInfo columnInfo, boolean z) {
            super(columnInfo, z);
            copy(columnInfo, this);
        }

        protected final ColumnInfo copy(boolean z) {
            return new ClassSummaryColumnInfo((ColumnInfo) this, z);
        }

        protected final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            ClassSummaryColumnInfo classSummaryColumnInfo = (ClassSummaryColumnInfo) columnInfo;
            ClassSummaryColumnInfo classSummaryColumnInfo2 = (ClassSummaryColumnInfo) columnInfo2;
            classSummaryColumnInfo2.periodIndex = classSummaryColumnInfo.periodIndex;
            classSummaryColumnInfo2.schoolCodeIndex = classSummaryColumnInfo.schoolCodeIndex;
            classSummaryColumnInfo2.studentIDIndex = classSummaryColumnInfo.studentIDIndex;
            classSummaryColumnInfo2.showPeriodIndex = classSummaryColumnInfo.showPeriodIndex;
            classSummaryColumnInfo2.hideScoresIndex = classSummaryColumnInfo.hideScoresIndex;
            classSummaryColumnInfo2.schoolNameIndex = classSummaryColumnInfo.schoolNameIndex;
            classSummaryColumnInfo2.sectionNumberIndex = classSummaryColumnInfo.sectionNumberIndex;
            classSummaryColumnInfo2.gradeBookNumberIndex = classSummaryColumnInfo.gradeBookNumberIndex;
            classSummaryColumnInfo2.gradeBookNameIndex = classSummaryColumnInfo.gradeBookNameIndex;
            classSummaryColumnInfo2.doingRubricIndex = classSummaryColumnInfo.doingRubricIndex;
            classSummaryColumnInfo2.courseNumberIndex = classSummaryColumnInfo.courseNumberIndex;
            classSummaryColumnInfo2.courseTitleIndex = classSummaryColumnInfo.courseTitleIndex;
            classSummaryColumnInfo2.teacherNumberIndex = classSummaryColumnInfo.teacherNumberIndex;
            classSummaryColumnInfo2.teacherNameIndex = classSummaryColumnInfo.teacherNameIndex;
            classSummaryColumnInfo2.roomNumberIndex = classSummaryColumnInfo.roomNumberIndex;
            classSummaryColumnInfo2.currentMarkIndex = classSummaryColumnInfo.currentMarkIndex;
            classSummaryColumnInfo2.percentIndex = classSummaryColumnInfo.percentIndex;
            classSummaryColumnInfo2.averageIndex = classSummaryColumnInfo.averageIndex;
            classSummaryColumnInfo2.missingAssignmentIndex = classSummaryColumnInfo.missingAssignmentIndex;
            classSummaryColumnInfo2.termIndex = classSummaryColumnInfo.termIndex;
            classSummaryColumnInfo2.termCodeIndex = classSummaryColumnInfo.termCodeIndex;
            classSummaryColumnInfo2.lastUpdatedIndex = classSummaryColumnInfo.lastUpdatedIndex;
        }
    }

    public static String getTableName() {
        return "class_ClassSummary";
    }

    static {
        List arrayList = new ArrayList();
        arrayList.add("period");
        arrayList.add("schoolCode");
        arrayList.add("studentID");
        arrayList.add("showPeriod");
        arrayList.add("hideScores");
        arrayList.add("schoolName");
        arrayList.add("sectionNumber");
        arrayList.add("gradeBookNumber");
        arrayList.add("gradeBookName");
        arrayList.add("doingRubric");
        arrayList.add("courseNumber");
        arrayList.add("courseTitle");
        arrayList.add("teacherNumber");
        arrayList.add("teacherName");
        arrayList.add("roomNumber");
        arrayList.add("currentMark");
        arrayList.add("percent");
        arrayList.add("average");
        arrayList.add("missingAssignment");
        arrayList.add(Param.TERM);
        arrayList.add("termCode");
        arrayList.add("lastUpdated");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    ClassSummaryRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (ClassSummaryColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
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

    public Integer realmGet$schoolCode() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.schoolCodeIndex)) {
            return null;
        }
        return Integer.valueOf((int) this.proxyState.getRow$realm().getLong(this.columnInfo.schoolCodeIndex));
    }

    public void realmSet$schoolCode(Integer num) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (num == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.schoolCodeIndex);
            } else {
                r0.proxyState.getRow$realm().setLong(r0.columnInfo.schoolCodeIndex, (long) num.intValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (num == null) {
                row$realm.getTable().setNull(r0.columnInfo.schoolCodeIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setLong(r0.columnInfo.schoolCodeIndex, row$realm.getIndex(), (long) num.intValue(), true);
            }
        }
    }

    public Integer realmGet$studentID() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.studentIDIndex)) {
            return null;
        }
        return Integer.valueOf((int) this.proxyState.getRow$realm().getLong(this.columnInfo.studentIDIndex));
    }

    public void realmSet$studentID(Integer num) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (num == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.studentIDIndex);
            } else {
                r0.proxyState.getRow$realm().setLong(r0.columnInfo.studentIDIndex, (long) num.intValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (num == null) {
                row$realm.getTable().setNull(r0.columnInfo.studentIDIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setLong(r0.columnInfo.studentIDIndex, row$realm.getIndex(), (long) num.intValue(), true);
            }
        }
    }

    public boolean realmGet$showPeriod() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.showPeriodIndex);
    }

    public void realmSet$showPeriod(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.showPeriodIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.showPeriodIndex, row$realm.getIndex(), z, true);
        }
    }

    public boolean realmGet$hideScores() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.hideScoresIndex);
    }

    public void realmSet$hideScores(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.hideScoresIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.hideScoresIndex, row$realm.getIndex(), z, true);
        }
    }

    public String realmGet$schoolName() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.schoolNameIndex);
    }

    public void realmSet$schoolName(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.schoolNameIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.schoolNameIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.schoolNameIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.schoolNameIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public Integer realmGet$sectionNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.sectionNumberIndex)) {
            return null;
        }
        return Integer.valueOf((int) this.proxyState.getRow$realm().getLong(this.columnInfo.sectionNumberIndex));
    }

    public void realmSet$sectionNumber(Integer num) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (num == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.sectionNumberIndex);
            } else {
                r0.proxyState.getRow$realm().setLong(r0.columnInfo.sectionNumberIndex, (long) num.intValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (num == null) {
                row$realm.getTable().setNull(r0.columnInfo.sectionNumberIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setLong(r0.columnInfo.sectionNumberIndex, row$realm.getIndex(), (long) num.intValue(), true);
            }
        }
    }

    public Integer realmGet$gradeBookNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.gradeBookNumberIndex)) {
            return null;
        }
        return Integer.valueOf((int) this.proxyState.getRow$realm().getLong(this.columnInfo.gradeBookNumberIndex));
    }

    public void realmSet$gradeBookNumber(Integer num) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (num == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.gradeBookNumberIndex);
            } else {
                r0.proxyState.getRow$realm().setLong(r0.columnInfo.gradeBookNumberIndex, (long) num.intValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (num == null) {
                row$realm.getTable().setNull(r0.columnInfo.gradeBookNumberIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setLong(r0.columnInfo.gradeBookNumberIndex, row$realm.getIndex(), (long) num.intValue(), true);
            }
        }
    }

    public String realmGet$gradeBookName() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.gradeBookNameIndex);
    }

    public void realmSet$gradeBookName(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.gradeBookNameIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.gradeBookNameIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.gradeBookNameIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.gradeBookNameIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public boolean realmGet$doingRubric() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getBoolean(this.columnInfo.doingRubricIndex);
    }

    public void realmSet$doingRubric(boolean z) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setBoolean(this.columnInfo.doingRubricIndex, z);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setBoolean(this.columnInfo.doingRubricIndex, row$realm.getIndex(), z, true);
        }
    }

    public String realmGet$courseNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.courseNumberIndex);
    }

    public void realmSet$courseNumber(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.courseNumberIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.courseNumberIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.courseNumberIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.courseNumberIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$courseTitle() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.courseTitleIndex);
    }

    public void realmSet$courseTitle(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.courseTitleIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.courseTitleIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.courseTitleIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.courseTitleIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public Integer realmGet$teacherNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.teacherNumberIndex)) {
            return null;
        }
        return Integer.valueOf((int) this.proxyState.getRow$realm().getLong(this.columnInfo.teacherNumberIndex));
    }

    public void realmSet$teacherNumber(Integer num) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (num == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.teacherNumberIndex);
            } else {
                r0.proxyState.getRow$realm().setLong(r0.columnInfo.teacherNumberIndex, (long) num.intValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (num == null) {
                row$realm.getTable().setNull(r0.columnInfo.teacherNumberIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setLong(r0.columnInfo.teacherNumberIndex, row$realm.getIndex(), (long) num.intValue(), true);
            }
        }
    }

    public String realmGet$teacherName() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.teacherNameIndex);
    }

    public void realmSet$teacherName(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.teacherNameIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.teacherNameIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.teacherNameIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.teacherNameIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$roomNumber() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.roomNumberIndex);
    }

    public void realmSet$roomNumber(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.roomNumberIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.roomNumberIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.roomNumberIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.roomNumberIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public String realmGet$currentMark() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.currentMarkIndex);
    }

    public void realmSet$currentMark(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.currentMarkIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.currentMarkIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.currentMarkIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.currentMarkIndex, row$realm.getIndex(), str, true);
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

    public String realmGet$average() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.averageIndex);
    }

    public void realmSet$average(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.averageIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.averageIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.averageIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.averageIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    public Integer realmGet$missingAssignment() {
        this.proxyState.getRealm$realm().checkIfValid();
        if (this.proxyState.getRow$realm().isNull(this.columnInfo.missingAssignmentIndex)) {
            return null;
        }
        return Integer.valueOf((int) this.proxyState.getRow$realm().getLong(this.columnInfo.missingAssignmentIndex));
    }

    public void realmSet$missingAssignment(Integer num) {
        if (!this.proxyState.isUnderConstruction()) {
            r0.proxyState.getRealm$realm().checkIfValid();
            if (num == null) {
                r0.proxyState.getRow$realm().setNull(r0.columnInfo.missingAssignmentIndex);
            } else {
                r0.proxyState.getRow$realm().setLong(r0.columnInfo.missingAssignmentIndex, (long) num.intValue());
            }
        } else if (r0.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = r0.proxyState.getRow$realm();
            if (num == null) {
                row$realm.getTable().setNull(r0.columnInfo.missingAssignmentIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setLong(r0.columnInfo.missingAssignmentIndex, row$realm.getIndex(), (long) num.intValue(), true);
            }
        }
    }

    public String realmGet$term() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.termIndex);
    }

    public void realmSet$term(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.termIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.termIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.termIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.termIndex, row$realm.getIndex(), str, true);
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

    public String realmGet$lastUpdated() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.lastUpdatedIndex);
    }

    public void realmSet$lastUpdated(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.lastUpdatedIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.lastUpdatedIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.lastUpdatedIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.lastUpdatedIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        Builder builder = new Builder("ClassSummary");
        Builder builder2 = builder;
        builder2.addProperty("period", RealmFieldType.INTEGER, false, false, false);
        builder2.addProperty("schoolCode", RealmFieldType.INTEGER, false, false, false);
        builder2.addProperty("studentID", RealmFieldType.INTEGER, false, false, false);
        builder2.addProperty("showPeriod", RealmFieldType.BOOLEAN, false, false, true);
        builder2.addProperty("hideScores", RealmFieldType.BOOLEAN, false, false, true);
        builder2.addProperty("schoolName", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("sectionNumber", RealmFieldType.INTEGER, false, false, false);
        builder2.addProperty("gradeBookNumber", RealmFieldType.INTEGER, false, false, false);
        builder2.addProperty("gradeBookName", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("doingRubric", RealmFieldType.BOOLEAN, false, false, true);
        builder2.addProperty("courseNumber", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("courseTitle", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("teacherNumber", RealmFieldType.INTEGER, false, false, false);
        builder2.addProperty("teacherName", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("roomNumber", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("currentMark", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("percent", RealmFieldType.DOUBLE, false, false, false);
        builder2.addProperty("average", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("missingAssignment", RealmFieldType.INTEGER, false, false, false);
        builder2.addProperty(Param.TERM, RealmFieldType.STRING, false, false, false);
        builder2.addProperty("termCode", RealmFieldType.STRING, false, false, false);
        builder2.addProperty("lastUpdated", RealmFieldType.STRING, false, false, false);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ClassSummaryColumnInfo validateTable(SharedRealm sharedRealm, boolean z) {
        if (sharedRealm.hasTable("class_ClassSummary")) {
            Table table = sharedRealm.getTable("class_ClassSummary");
            long columnCount = table.getColumnCount();
            if (columnCount != 22) {
                StringBuilder stringBuilder;
                if (columnCount < 22) {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is less than expected - expected 22 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                } else if (z) {
                    RealmLog.debug("Field count is more than expected - expected 22 but was %1$d", Long.valueOf(columnCount));
                } else {
                    sharedRealm = sharedRealm.getPath();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Field count is more than expected - expected 22 but was ");
                    stringBuilder.append(columnCount);
                    throw new RealmMigrationNeededException(sharedRealm, stringBuilder.toString());
                }
            }
            z = new HashMap();
            for (long j = 0; j < columnCount; j++) {
                z.put(table.getColumnName(j), table.getColumnType(j));
            }
            ClassSummaryColumnInfo classSummaryColumnInfo = new ClassSummaryColumnInfo(sharedRealm, table);
            if (table.hasPrimaryKey()) {
                sharedRealm = sharedRealm.getPath();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Primary Key defined for field ");
                stringBuilder2.append(table.getColumnName(table.getPrimaryKey()));
                stringBuilder2.append(" was removed.");
                throw new RealmMigrationNeededException(sharedRealm, stringBuilder2.toString());
            } else if (!z.containsKey("period")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'period' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("period") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'period' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.periodIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'period' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'period' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("schoolCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'schoolCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("schoolCode") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'schoolCode' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.schoolCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'schoolCode' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'schoolCode' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("studentID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'studentID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("studentID") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'studentID' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.studentIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'studentID' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'studentID' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("showPeriod")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'showPeriod' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("showPeriod") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'showPeriod' in existing Realm file.");
            } else if (table.isColumnNullable(classSummaryColumnInfo.showPeriodIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'showPeriod' does support null values in the existing Realm file. Use corresponding boxed type for field 'showPeriod' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("hideScores")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'hideScores' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("hideScores") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'hideScores' in existing Realm file.");
            } else if (table.isColumnNullable(classSummaryColumnInfo.hideScoresIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'hideScores' does support null values in the existing Realm file. Use corresponding boxed type for field 'hideScores' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("schoolName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'schoolName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("schoolName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'schoolName' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.schoolNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'schoolName' is required. Either set @Required to field 'schoolName' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("sectionNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'sectionNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("sectionNumber") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'sectionNumber' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.sectionNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'sectionNumber' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'sectionNumber' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("gradeBookNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'gradeBookNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("gradeBookNumber") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'gradeBookNumber' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.gradeBookNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'gradeBookNumber' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'gradeBookNumber' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("gradeBookName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'gradeBookName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("gradeBookName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'gradeBookName' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.gradeBookNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'gradeBookName' is required. Either set @Required to field 'gradeBookName' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("doingRubric")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'doingRubric' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("doingRubric") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'doingRubric' in existing Realm file.");
            } else if (table.isColumnNullable(classSummaryColumnInfo.doingRubricIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'doingRubric' does support null values in the existing Realm file. Use corresponding boxed type for field 'doingRubric' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("courseNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'courseNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("courseNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'courseNumber' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.courseNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'courseNumber' is required. Either set @Required to field 'courseNumber' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("courseTitle")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'courseTitle' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("courseTitle") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'courseTitle' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.courseTitleIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'courseTitle' is required. Either set @Required to field 'courseTitle' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("teacherNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'teacherNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("teacherNumber") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'teacherNumber' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.teacherNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'teacherNumber' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'teacherNumber' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("teacherName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'teacherName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("teacherName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'teacherName' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.teacherNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'teacherName' is required. Either set @Required to field 'teacherName' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("roomNumber")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'roomNumber' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("roomNumber") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'roomNumber' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.roomNumberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'roomNumber' is required. Either set @Required to field 'roomNumber' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("currentMark")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'currentMark' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("currentMark") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'currentMark' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.currentMarkIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'currentMark' is required. Either set @Required to field 'currentMark' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("percent")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'percent' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("percent") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'percent' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.percentIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'percent' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'percent' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("average")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'average' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("average") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'average' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.averageIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'average' is required. Either set @Required to field 'average' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("missingAssignment")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'missingAssignment' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("missingAssignment") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'missingAssignment' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.missingAssignmentIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'missingAssignment' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'missingAssignment' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey(Param.TERM)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'term' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get(Param.TERM) != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'term' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.termIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'term' is required. Either set @Required to field 'term' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("termCode")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'termCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("termCode") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'termCode' in existing Realm file.");
            } else if (!table.isColumnNullable(classSummaryColumnInfo.termCodeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'termCode' is required. Either set @Required to field 'termCode' or migrate using RealmObjectSchema.setNullable().");
            } else if (!z.containsKey("lastUpdated")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'lastUpdated' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (z.get("lastUpdated") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'lastUpdated' in existing Realm file.");
            } else if (table.isColumnNullable(classSummaryColumnInfo.lastUpdatedIndex)) {
                return classSummaryColumnInfo;
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'lastUpdated' is required. Either set @Required to field 'lastUpdated' or migrate using RealmObjectSchema.setNullable().");
            }
        }
        throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'ClassSummary' class is missing from the schema for this Realm.");
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static ClassSummary createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) throws JSONException {
        ClassSummary classSummary = (ClassSummary) realm.createObjectInternal(ClassSummary.class, true, Collections.emptyList());
        if (jSONObject.has("period")) {
            if (jSONObject.isNull("period")) {
                classSummary.realmSet$period(null);
            } else {
                classSummary.realmSet$period(Integer.valueOf(jSONObject.getInt("period")));
            }
        }
        if (jSONObject.has("schoolCode")) {
            if (jSONObject.isNull("schoolCode")) {
                classSummary.realmSet$schoolCode(null);
            } else {
                classSummary.realmSet$schoolCode(Integer.valueOf(jSONObject.getInt("schoolCode")));
            }
        }
        if (jSONObject.has("studentID")) {
            if (jSONObject.isNull("studentID")) {
                classSummary.realmSet$studentID(null);
            } else {
                classSummary.realmSet$studentID(Integer.valueOf(jSONObject.getInt("studentID")));
            }
        }
        if (jSONObject.has("showPeriod")) {
            if (jSONObject.isNull("showPeriod")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'showPeriod' to null.");
            }
            classSummary.realmSet$showPeriod(jSONObject.getBoolean("showPeriod"));
        }
        if (jSONObject.has("hideScores")) {
            if (jSONObject.isNull("hideScores")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'hideScores' to null.");
            }
            classSummary.realmSet$hideScores(jSONObject.getBoolean("hideScores"));
        }
        if (jSONObject.has("schoolName")) {
            if (jSONObject.isNull("schoolName")) {
                classSummary.realmSet$schoolName(null);
            } else {
                classSummary.realmSet$schoolName(jSONObject.getString("schoolName"));
            }
        }
        if (jSONObject.has("sectionNumber")) {
            if (jSONObject.isNull("sectionNumber")) {
                classSummary.realmSet$sectionNumber(null);
            } else {
                classSummary.realmSet$sectionNumber(Integer.valueOf(jSONObject.getInt("sectionNumber")));
            }
        }
        if (jSONObject.has("gradeBookNumber")) {
            if (jSONObject.isNull("gradeBookNumber")) {
                classSummary.realmSet$gradeBookNumber(null);
            } else {
                classSummary.realmSet$gradeBookNumber(Integer.valueOf(jSONObject.getInt("gradeBookNumber")));
            }
        }
        if (jSONObject.has("gradeBookName")) {
            if (jSONObject.isNull("gradeBookName")) {
                classSummary.realmSet$gradeBookName(null);
            } else {
                classSummary.realmSet$gradeBookName(jSONObject.getString("gradeBookName"));
            }
        }
        if (jSONObject.has("doingRubric")) {
            if (jSONObject.isNull("doingRubric")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'doingRubric' to null.");
            }
            classSummary.realmSet$doingRubric(jSONObject.getBoolean("doingRubric"));
        }
        if (jSONObject.has("courseNumber")) {
            if (jSONObject.isNull("courseNumber")) {
                classSummary.realmSet$courseNumber(null);
            } else {
                classSummary.realmSet$courseNumber(jSONObject.getString("courseNumber"));
            }
        }
        if (jSONObject.has("courseTitle")) {
            if (jSONObject.isNull("courseTitle")) {
                classSummary.realmSet$courseTitle(null);
            } else {
                classSummary.realmSet$courseTitle(jSONObject.getString("courseTitle"));
            }
        }
        if (jSONObject.has("teacherNumber")) {
            if (jSONObject.isNull("teacherNumber")) {
                classSummary.realmSet$teacherNumber(null);
            } else {
                classSummary.realmSet$teacherNumber(Integer.valueOf(jSONObject.getInt("teacherNumber")));
            }
        }
        if (jSONObject.has("teacherName")) {
            if (jSONObject.isNull("teacherName")) {
                classSummary.realmSet$teacherName(null);
            } else {
                classSummary.realmSet$teacherName(jSONObject.getString("teacherName"));
            }
        }
        if (jSONObject.has("roomNumber")) {
            if (jSONObject.isNull("roomNumber")) {
                classSummary.realmSet$roomNumber(null);
            } else {
                classSummary.realmSet$roomNumber(jSONObject.getString("roomNumber"));
            }
        }
        if (jSONObject.has("currentMark")) {
            if (jSONObject.isNull("currentMark")) {
                classSummary.realmSet$currentMark(null);
            } else {
                classSummary.realmSet$currentMark(jSONObject.getString("currentMark"));
            }
        }
        if (jSONObject.has("percent")) {
            if (jSONObject.isNull("percent")) {
                classSummary.realmSet$percent(null);
            } else {
                classSummary.realmSet$percent(Double.valueOf(jSONObject.getDouble("percent")));
            }
        }
        if (jSONObject.has("average")) {
            if (jSONObject.isNull("average")) {
                classSummary.realmSet$average(null);
            } else {
                classSummary.realmSet$average(jSONObject.getString("average"));
            }
        }
        if (jSONObject.has("missingAssignment")) {
            if (jSONObject.isNull("missingAssignment")) {
                classSummary.realmSet$missingAssignment(null);
            } else {
                classSummary.realmSet$missingAssignment(Integer.valueOf(jSONObject.getInt("missingAssignment")));
            }
        }
        if (jSONObject.has(Param.TERM)) {
            if (jSONObject.isNull(Param.TERM)) {
                classSummary.realmSet$term(null);
            } else {
                classSummary.realmSet$term(jSONObject.getString(Param.TERM));
            }
        }
        if (jSONObject.has("termCode")) {
            if (jSONObject.isNull("termCode")) {
                classSummary.realmSet$termCode(null);
            } else {
                classSummary.realmSet$termCode(jSONObject.getString("termCode"));
            }
        }
        if (jSONObject.has("lastUpdated")) {
            if (jSONObject.isNull("lastUpdated")) {
                classSummary.realmSet$lastUpdated(null);
            } else {
                classSummary.realmSet$lastUpdated(jSONObject.getString("lastUpdated"));
            }
        }
        return classSummary;
    }

    @TargetApi(11)
    public static ClassSummary createUsingJsonStream(Realm realm, JsonReader jsonReader) throws IOException {
        RealmModel classSummary = new ClassSummary();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("period")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$period(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$period(Integer.valueOf(jsonReader.nextInt()));
                }
            } else if (nextName.equals("schoolCode")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$schoolCode(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$schoolCode(Integer.valueOf(jsonReader.nextInt()));
                }
            } else if (nextName.equals("studentID")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$studentID(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$studentID(Integer.valueOf(jsonReader.nextInt()));
                }
            } else if (nextName.equals("showPeriod")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$showPeriod(jsonReader.nextBoolean());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'showPeriod' to null.");
                }
            } else if (nextName.equals("hideScores")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$hideScores(jsonReader.nextBoolean());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'hideScores' to null.");
                }
            } else if (nextName.equals("schoolName")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$schoolName(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$schoolName(jsonReader.nextString());
                }
            } else if (nextName.equals("sectionNumber")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$sectionNumber(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$sectionNumber(Integer.valueOf(jsonReader.nextInt()));
                }
            } else if (nextName.equals("gradeBookNumber")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$gradeBookNumber(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$gradeBookNumber(Integer.valueOf(jsonReader.nextInt()));
                }
            } else if (nextName.equals("gradeBookName")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$gradeBookName(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$gradeBookName(jsonReader.nextString());
                }
            } else if (nextName.equals("doingRubric")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$doingRubric(jsonReader.nextBoolean());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'doingRubric' to null.");
                }
            } else if (nextName.equals("courseNumber")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$courseNumber(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$courseNumber(jsonReader.nextString());
                }
            } else if (nextName.equals("courseTitle")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$courseTitle(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$courseTitle(jsonReader.nextString());
                }
            } else if (nextName.equals("teacherNumber")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$teacherNumber(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$teacherNumber(Integer.valueOf(jsonReader.nextInt()));
                }
            } else if (nextName.equals("teacherName")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$teacherName(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$teacherName(jsonReader.nextString());
                }
            } else if (nextName.equals("roomNumber")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$roomNumber(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$roomNumber(jsonReader.nextString());
                }
            } else if (nextName.equals("currentMark")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$currentMark(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$currentMark(jsonReader.nextString());
                }
            } else if (nextName.equals("percent")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$percent(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$percent(Double.valueOf(jsonReader.nextDouble()));
                }
            } else if (nextName.equals("average")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$average(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$average(jsonReader.nextString());
                }
            } else if (nextName.equals("missingAssignment")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$missingAssignment(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$missingAssignment(Integer.valueOf(jsonReader.nextInt()));
                }
            } else if (nextName.equals(Param.TERM)) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$term(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$term(jsonReader.nextString());
                }
            } else if (nextName.equals("termCode")) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$termCode(null);
                } else {
                    ((ClassSummaryRealmProxyInterface) classSummary).realmSet$termCode(jsonReader.nextString());
                }
            } else if (!nextName.equals("lastUpdated")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.skipValue();
                ((ClassSummaryRealmProxyInterface) classSummary).realmSet$lastUpdated(null);
            } else {
                ((ClassSummaryRealmProxyInterface) classSummary).realmSet$lastUpdated(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return (ClassSummary) realm.copyToRealm(classSummary);
    }

    public static ClassSummary copyOrUpdate(Realm realm, ClassSummary classSummary, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy;
        boolean z2 = classSummary instanceof RealmObjectProxy;
        if (z2) {
            RealmObjectProxy realmObjectProxy2 = (RealmObjectProxy) classSummary;
            if (realmObjectProxy2.realmGet$proxyState().getRealm$realm() != null) {
                if (realmObjectProxy2.realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
                    throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
                }
            }
        }
        if (z2) {
            realmObjectProxy = (RealmObjectProxy) classSummary;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return classSummary;
            }
        }
        RealmObjectContext realmObjectContext = (RealmObjectContext) BaseRealm.objectContext.get();
        realmObjectProxy = (RealmObjectProxy) map.get(classSummary);
        if (realmObjectProxy != null) {
            return (ClassSummary) realmObjectProxy;
        }
        return copy(realm, classSummary, z, map);
    }

    public static ClassSummary copy(Realm realm, ClassSummary classSummary, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = (RealmObjectProxy) map.get(classSummary);
        if (realmObjectProxy != null) {
            return (ClassSummary) realmObjectProxy;
        }
        ClassSummary classSummary2 = (ClassSummary) realm.createObjectInternal(ClassSummary.class, false, Collections.emptyList());
        map.put(classSummary, (RealmObjectProxy) classSummary2);
        ClassSummaryRealmProxyInterface classSummaryRealmProxyInterface = classSummary;
        ClassSummaryRealmProxyInterface classSummaryRealmProxyInterface2 = classSummary2;
        classSummaryRealmProxyInterface2.realmSet$period(classSummaryRealmProxyInterface.realmGet$period());
        classSummaryRealmProxyInterface2.realmSet$schoolCode(classSummaryRealmProxyInterface.realmGet$schoolCode());
        classSummaryRealmProxyInterface2.realmSet$studentID(classSummaryRealmProxyInterface.realmGet$studentID());
        classSummaryRealmProxyInterface2.realmSet$showPeriod(classSummaryRealmProxyInterface.realmGet$showPeriod());
        classSummaryRealmProxyInterface2.realmSet$hideScores(classSummaryRealmProxyInterface.realmGet$hideScores());
        classSummaryRealmProxyInterface2.realmSet$schoolName(classSummaryRealmProxyInterface.realmGet$schoolName());
        classSummaryRealmProxyInterface2.realmSet$sectionNumber(classSummaryRealmProxyInterface.realmGet$sectionNumber());
        classSummaryRealmProxyInterface2.realmSet$gradeBookNumber(classSummaryRealmProxyInterface.realmGet$gradeBookNumber());
        classSummaryRealmProxyInterface2.realmSet$gradeBookName(classSummaryRealmProxyInterface.realmGet$gradeBookName());
        classSummaryRealmProxyInterface2.realmSet$doingRubric(classSummaryRealmProxyInterface.realmGet$doingRubric());
        classSummaryRealmProxyInterface2.realmSet$courseNumber(classSummaryRealmProxyInterface.realmGet$courseNumber());
        classSummaryRealmProxyInterface2.realmSet$courseTitle(classSummaryRealmProxyInterface.realmGet$courseTitle());
        classSummaryRealmProxyInterface2.realmSet$teacherNumber(classSummaryRealmProxyInterface.realmGet$teacherNumber());
        classSummaryRealmProxyInterface2.realmSet$teacherName(classSummaryRealmProxyInterface.realmGet$teacherName());
        classSummaryRealmProxyInterface2.realmSet$roomNumber(classSummaryRealmProxyInterface.realmGet$roomNumber());
        classSummaryRealmProxyInterface2.realmSet$currentMark(classSummaryRealmProxyInterface.realmGet$currentMark());
        classSummaryRealmProxyInterface2.realmSet$percent(classSummaryRealmProxyInterface.realmGet$percent());
        classSummaryRealmProxyInterface2.realmSet$average(classSummaryRealmProxyInterface.realmGet$average());
        classSummaryRealmProxyInterface2.realmSet$missingAssignment(classSummaryRealmProxyInterface.realmGet$missingAssignment());
        classSummaryRealmProxyInterface2.realmSet$term(classSummaryRealmProxyInterface.realmGet$term());
        classSummaryRealmProxyInterface2.realmSet$termCode(classSummaryRealmProxyInterface.realmGet$termCode());
        classSummaryRealmProxyInterface2.realmSet$lastUpdated(classSummaryRealmProxyInterface.realmGet$lastUpdated());
        return classSummary2;
    }

    public static long insert(Realm realm, ClassSummary classSummary, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        ClassSummary classSummary2 = classSummary;
        if (classSummary2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) classSummary2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(ClassSummary.class);
        long nativePtr = table.getNativePtr();
        ClassSummaryColumnInfo classSummaryColumnInfo = (ClassSummaryColumnInfo) realm2.schema.getColumnInfo(ClassSummary.class);
        long createRow = OsObject.createRow(table);
        map.put(classSummary2, Long.valueOf(createRow));
        ClassSummaryRealmProxyInterface classSummaryRealmProxyInterface = classSummary2;
        Number realmGet$period = classSummaryRealmProxyInterface.realmGet$period();
        if (realmGet$period != null) {
            Table.nativeSetLong(nativePtr, classSummaryColumnInfo.periodIndex, createRow, realmGet$period.longValue(), false);
        }
        realmGet$period = classSummaryRealmProxyInterface.realmGet$schoolCode();
        if (realmGet$period != null) {
            Table.nativeSetLong(nativePtr, classSummaryColumnInfo.schoolCodeIndex, createRow, realmGet$period.longValue(), false);
        }
        realmGet$period = classSummaryRealmProxyInterface.realmGet$studentID();
        if (realmGet$period != null) {
            Table.nativeSetLong(nativePtr, classSummaryColumnInfo.studentIDIndex, createRow, realmGet$period.longValue(), false);
        }
        long j = nativePtr;
        long j2 = createRow;
        Table.nativeSetBoolean(j, classSummaryColumnInfo.showPeriodIndex, j2, classSummaryRealmProxyInterface.realmGet$showPeriod(), false);
        Table.nativeSetBoolean(j, classSummaryColumnInfo.hideScoresIndex, j2, classSummaryRealmProxyInterface.realmGet$hideScores(), false);
        String realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$schoolName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.schoolNameIndex, createRow, realmGet$schoolName, false);
        }
        realmGet$period = classSummaryRealmProxyInterface.realmGet$sectionNumber();
        if (realmGet$period != null) {
            Table.nativeSetLong(nativePtr, classSummaryColumnInfo.sectionNumberIndex, createRow, realmGet$period.longValue(), false);
        }
        realmGet$period = classSummaryRealmProxyInterface.realmGet$gradeBookNumber();
        if (realmGet$period != null) {
            Table.nativeSetLong(nativePtr, classSummaryColumnInfo.gradeBookNumberIndex, createRow, realmGet$period.longValue(), false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$gradeBookName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.gradeBookNameIndex, createRow, realmGet$schoolName, false);
        }
        Table.nativeSetBoolean(nativePtr, classSummaryColumnInfo.doingRubricIndex, createRow, classSummaryRealmProxyInterface.realmGet$doingRubric(), false);
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$courseNumber();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.courseNumberIndex, createRow, realmGet$schoolName, false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$courseTitle();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.courseTitleIndex, createRow, realmGet$schoolName, false);
        }
        realmGet$period = classSummaryRealmProxyInterface.realmGet$teacherNumber();
        if (realmGet$period != null) {
            Table.nativeSetLong(nativePtr, classSummaryColumnInfo.teacherNumberIndex, createRow, realmGet$period.longValue(), false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$teacherName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.teacherNameIndex, createRow, realmGet$schoolName, false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$roomNumber();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.roomNumberIndex, createRow, realmGet$schoolName, false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$currentMark();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.currentMarkIndex, createRow, realmGet$schoolName, false);
        }
        Double realmGet$percent = classSummaryRealmProxyInterface.realmGet$percent();
        if (realmGet$percent != null) {
            Table.nativeSetDouble(nativePtr, classSummaryColumnInfo.percentIndex, createRow, realmGet$percent.doubleValue(), false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$average();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.averageIndex, createRow, realmGet$schoolName, false);
        }
        realmGet$period = classSummaryRealmProxyInterface.realmGet$missingAssignment();
        if (realmGet$period != null) {
            Table.nativeSetLong(nativePtr, classSummaryColumnInfo.missingAssignmentIndex, createRow, realmGet$period.longValue(), false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$term();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.termIndex, createRow, realmGet$schoolName, false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$termCode();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.termCodeIndex, createRow, realmGet$schoolName, false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$lastUpdated();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.lastUpdatedIndex, createRow, realmGet$schoolName, false);
        }
        return createRow;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Table table = realm2.getTable(ClassSummary.class);
        long nativePtr = table.getNativePtr();
        ClassSummaryColumnInfo classSummaryColumnInfo = (ClassSummaryColumnInfo) realm2.schema.getColumnInfo(ClassSummary.class);
        while (it.hasNext()) {
            ClassSummary classSummary = (ClassSummary) it.next();
            if (!map2.containsKey(classSummary)) {
                long j;
                if (classSummary instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) classSummary;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(classSummary, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(classSummary, Long.valueOf(createRow));
                ClassSummaryRealmProxyInterface classSummaryRealmProxyInterface = classSummary;
                Number realmGet$period = classSummaryRealmProxyInterface.realmGet$period();
                if (realmGet$period != null) {
                    j = createRow;
                    Table.nativeSetLong(nativePtr, classSummaryColumnInfo.periodIndex, createRow, realmGet$period.longValue(), false);
                } else {
                    j = createRow;
                }
                realmGet$period = classSummaryRealmProxyInterface.realmGet$schoolCode();
                if (realmGet$period != null) {
                    Table.nativeSetLong(nativePtr, classSummaryColumnInfo.schoolCodeIndex, j, realmGet$period.longValue(), false);
                }
                realmGet$period = classSummaryRealmProxyInterface.realmGet$studentID();
                if (realmGet$period != null) {
                    Table.nativeSetLong(nativePtr, classSummaryColumnInfo.studentIDIndex, j, realmGet$period.longValue(), false);
                }
                long j2 = nativePtr;
                long j3 = j;
                Table.nativeSetBoolean(j2, classSummaryColumnInfo.showPeriodIndex, j3, classSummaryRealmProxyInterface.realmGet$showPeriod(), false);
                Table.nativeSetBoolean(j2, classSummaryColumnInfo.hideScoresIndex, j3, classSummaryRealmProxyInterface.realmGet$hideScores(), false);
                String realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$schoolName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.schoolNameIndex, j, realmGet$schoolName, false);
                }
                realmGet$period = classSummaryRealmProxyInterface.realmGet$sectionNumber();
                if (realmGet$period != null) {
                    Table.nativeSetLong(nativePtr, classSummaryColumnInfo.sectionNumberIndex, j, realmGet$period.longValue(), false);
                }
                realmGet$period = classSummaryRealmProxyInterface.realmGet$gradeBookNumber();
                if (realmGet$period != null) {
                    Table.nativeSetLong(nativePtr, classSummaryColumnInfo.gradeBookNumberIndex, j, realmGet$period.longValue(), false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$gradeBookName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.gradeBookNameIndex, j, realmGet$schoolName, false);
                }
                Table.nativeSetBoolean(nativePtr, classSummaryColumnInfo.doingRubricIndex, j, classSummaryRealmProxyInterface.realmGet$doingRubric(), false);
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$courseNumber();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.courseNumberIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$courseTitle();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.courseTitleIndex, j, realmGet$schoolName, false);
                }
                realmGet$period = classSummaryRealmProxyInterface.realmGet$teacherNumber();
                if (realmGet$period != null) {
                    Table.nativeSetLong(nativePtr, classSummaryColumnInfo.teacherNumberIndex, j, realmGet$period.longValue(), false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$teacherName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.teacherNameIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$roomNumber();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.roomNumberIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$currentMark();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.currentMarkIndex, j, realmGet$schoolName, false);
                }
                Double realmGet$percent = classSummaryRealmProxyInterface.realmGet$percent();
                if (realmGet$percent != null) {
                    Table.nativeSetDouble(nativePtr, classSummaryColumnInfo.percentIndex, j, realmGet$percent.doubleValue(), false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$average();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.averageIndex, j, realmGet$schoolName, false);
                }
                realmGet$period = classSummaryRealmProxyInterface.realmGet$missingAssignment();
                if (realmGet$period != null) {
                    Table.nativeSetLong(nativePtr, classSummaryColumnInfo.missingAssignmentIndex, j, realmGet$period.longValue(), false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$term();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.termIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$termCode();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.termCodeIndex, j, realmGet$schoolName, false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$lastUpdated();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.lastUpdatedIndex, j, realmGet$schoolName, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, ClassSummary classSummary, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        ClassSummary classSummary2 = classSummary;
        if (classSummary2 instanceof RealmObjectProxy) {
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) classSummary2;
            if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
            }
        }
        Table table = realm2.getTable(ClassSummary.class);
        long nativePtr = table.getNativePtr();
        ClassSummaryColumnInfo classSummaryColumnInfo = (ClassSummaryColumnInfo) realm2.schema.getColumnInfo(ClassSummary.class);
        long createRow = OsObject.createRow(table);
        map.put(classSummary2, Long.valueOf(createRow));
        ClassSummaryRealmProxyInterface classSummaryRealmProxyInterface = classSummary2;
        Number realmGet$period = classSummaryRealmProxyInterface.realmGet$period();
        if (realmGet$period != null) {
            Table.nativeSetLong(nativePtr, classSummaryColumnInfo.periodIndex, createRow, realmGet$period.longValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.periodIndex, createRow, false);
        }
        realmGet$period = classSummaryRealmProxyInterface.realmGet$schoolCode();
        if (realmGet$period != null) {
            Table.nativeSetLong(nativePtr, classSummaryColumnInfo.schoolCodeIndex, createRow, realmGet$period.longValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.schoolCodeIndex, createRow, false);
        }
        realmGet$period = classSummaryRealmProxyInterface.realmGet$studentID();
        if (realmGet$period != null) {
            Table.nativeSetLong(nativePtr, classSummaryColumnInfo.studentIDIndex, createRow, realmGet$period.longValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.studentIDIndex, createRow, false);
        }
        long j = nativePtr;
        long j2 = createRow;
        Table.nativeSetBoolean(j, classSummaryColumnInfo.showPeriodIndex, j2, classSummaryRealmProxyInterface.realmGet$showPeriod(), false);
        Table.nativeSetBoolean(j, classSummaryColumnInfo.hideScoresIndex, j2, classSummaryRealmProxyInterface.realmGet$hideScores(), false);
        String realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$schoolName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.schoolNameIndex, createRow, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.schoolNameIndex, createRow, false);
        }
        realmGet$period = classSummaryRealmProxyInterface.realmGet$sectionNumber();
        if (realmGet$period != null) {
            Table.nativeSetLong(nativePtr, classSummaryColumnInfo.sectionNumberIndex, createRow, realmGet$period.longValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.sectionNumberIndex, createRow, false);
        }
        realmGet$period = classSummaryRealmProxyInterface.realmGet$gradeBookNumber();
        if (realmGet$period != null) {
            Table.nativeSetLong(nativePtr, classSummaryColumnInfo.gradeBookNumberIndex, createRow, realmGet$period.longValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.gradeBookNumberIndex, createRow, false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$gradeBookName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.gradeBookNameIndex, createRow, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.gradeBookNameIndex, createRow, false);
        }
        Table.nativeSetBoolean(nativePtr, classSummaryColumnInfo.doingRubricIndex, createRow, classSummaryRealmProxyInterface.realmGet$doingRubric(), false);
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$courseNumber();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.courseNumberIndex, createRow, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.courseNumberIndex, createRow, false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$courseTitle();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.courseTitleIndex, createRow, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.courseTitleIndex, createRow, false);
        }
        realmGet$period = classSummaryRealmProxyInterface.realmGet$teacherNumber();
        if (realmGet$period != null) {
            Table.nativeSetLong(nativePtr, classSummaryColumnInfo.teacherNumberIndex, createRow, realmGet$period.longValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.teacherNumberIndex, createRow, false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$teacherName();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.teacherNameIndex, createRow, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.teacherNameIndex, createRow, false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$roomNumber();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.roomNumberIndex, createRow, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.roomNumberIndex, createRow, false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$currentMark();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.currentMarkIndex, createRow, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.currentMarkIndex, createRow, false);
        }
        Double realmGet$percent = classSummaryRealmProxyInterface.realmGet$percent();
        if (realmGet$percent != null) {
            Table.nativeSetDouble(nativePtr, classSummaryColumnInfo.percentIndex, createRow, realmGet$percent.doubleValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.percentIndex, createRow, false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$average();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.averageIndex, createRow, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.averageIndex, createRow, false);
        }
        realmGet$period = classSummaryRealmProxyInterface.realmGet$missingAssignment();
        if (realmGet$period != null) {
            Table.nativeSetLong(nativePtr, classSummaryColumnInfo.missingAssignmentIndex, createRow, realmGet$period.longValue(), false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.missingAssignmentIndex, createRow, false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$term();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.termIndex, createRow, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.termIndex, createRow, false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$termCode();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.termCodeIndex, createRow, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.termCodeIndex, createRow, false);
        }
        realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$lastUpdated();
        if (realmGet$schoolName != null) {
            Table.nativeSetString(nativePtr, classSummaryColumnInfo.lastUpdatedIndex, createRow, realmGet$schoolName, false);
        } else {
            Table.nativeSetNull(nativePtr, classSummaryColumnInfo.lastUpdatedIndex, createRow, false);
        }
        return createRow;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Realm realm2 = realm;
        Map<RealmModel, Long> map2 = map;
        Table table = realm2.getTable(ClassSummary.class);
        long nativePtr = table.getNativePtr();
        ClassSummaryColumnInfo classSummaryColumnInfo = (ClassSummaryColumnInfo) realm2.schema.getColumnInfo(ClassSummary.class);
        while (it.hasNext()) {
            ClassSummary classSummary = (ClassSummary) it.next();
            if (!map2.containsKey(classSummary)) {
                long j;
                if (classSummary instanceof RealmObjectProxy) {
                    RealmObjectProxy realmObjectProxy = (RealmObjectProxy) classSummary;
                    if (realmObjectProxy.realmGet$proxyState().getRealm$realm() != null && realmObjectProxy.realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                        map2.put(classSummary, Long.valueOf(realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex()));
                    }
                }
                long createRow = OsObject.createRow(table);
                map2.put(classSummary, Long.valueOf(createRow));
                ClassSummaryRealmProxyInterface classSummaryRealmProxyInterface = classSummary;
                Number realmGet$period = classSummaryRealmProxyInterface.realmGet$period();
                if (realmGet$period != null) {
                    j = createRow;
                    Table.nativeSetLong(nativePtr, classSummaryColumnInfo.periodIndex, createRow, realmGet$period.longValue(), false);
                } else {
                    j = createRow;
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.periodIndex, j, false);
                }
                realmGet$period = classSummaryRealmProxyInterface.realmGet$schoolCode();
                if (realmGet$period != null) {
                    Table.nativeSetLong(nativePtr, classSummaryColumnInfo.schoolCodeIndex, j, realmGet$period.longValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.schoolCodeIndex, j, false);
                }
                realmGet$period = classSummaryRealmProxyInterface.realmGet$studentID();
                if (realmGet$period != null) {
                    Table.nativeSetLong(nativePtr, classSummaryColumnInfo.studentIDIndex, j, realmGet$period.longValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.studentIDIndex, j, false);
                }
                long j2 = nativePtr;
                long j3 = j;
                Table.nativeSetBoolean(j2, classSummaryColumnInfo.showPeriodIndex, j3, classSummaryRealmProxyInterface.realmGet$showPeriod(), false);
                Table.nativeSetBoolean(j2, classSummaryColumnInfo.hideScoresIndex, j3, classSummaryRealmProxyInterface.realmGet$hideScores(), false);
                String realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$schoolName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.schoolNameIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.schoolNameIndex, j, false);
                }
                realmGet$period = classSummaryRealmProxyInterface.realmGet$sectionNumber();
                if (realmGet$period != null) {
                    Table.nativeSetLong(nativePtr, classSummaryColumnInfo.sectionNumberIndex, j, realmGet$period.longValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.sectionNumberIndex, j, false);
                }
                realmGet$period = classSummaryRealmProxyInterface.realmGet$gradeBookNumber();
                if (realmGet$period != null) {
                    Table.nativeSetLong(nativePtr, classSummaryColumnInfo.gradeBookNumberIndex, j, realmGet$period.longValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.gradeBookNumberIndex, j, false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$gradeBookName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.gradeBookNameIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.gradeBookNameIndex, j, false);
                }
                Table.nativeSetBoolean(nativePtr, classSummaryColumnInfo.doingRubricIndex, j, classSummaryRealmProxyInterface.realmGet$doingRubric(), false);
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$courseNumber();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.courseNumberIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.courseNumberIndex, j, false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$courseTitle();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.courseTitleIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.courseTitleIndex, j, false);
                }
                realmGet$period = classSummaryRealmProxyInterface.realmGet$teacherNumber();
                if (realmGet$period != null) {
                    Table.nativeSetLong(nativePtr, classSummaryColumnInfo.teacherNumberIndex, j, realmGet$period.longValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.teacherNumberIndex, j, false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$teacherName();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.teacherNameIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.teacherNameIndex, j, false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$roomNumber();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.roomNumberIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.roomNumberIndex, j, false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$currentMark();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.currentMarkIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.currentMarkIndex, j, false);
                }
                Double realmGet$percent = classSummaryRealmProxyInterface.realmGet$percent();
                if (realmGet$percent != null) {
                    Table.nativeSetDouble(nativePtr, classSummaryColumnInfo.percentIndex, j, realmGet$percent.doubleValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.percentIndex, j, false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$average();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.averageIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.averageIndex, j, false);
                }
                realmGet$period = classSummaryRealmProxyInterface.realmGet$missingAssignment();
                if (realmGet$period != null) {
                    Table.nativeSetLong(nativePtr, classSummaryColumnInfo.missingAssignmentIndex, j, realmGet$period.longValue(), false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.missingAssignmentIndex, j, false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$term();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.termIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.termIndex, j, false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$termCode();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.termCodeIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.termCodeIndex, j, false);
                }
                realmGet$schoolName = classSummaryRealmProxyInterface.realmGet$lastUpdated();
                if (realmGet$schoolName != null) {
                    Table.nativeSetString(nativePtr, classSummaryColumnInfo.lastUpdatedIndex, j, realmGet$schoolName, false);
                } else {
                    Table.nativeSetNull(nativePtr, classSummaryColumnInfo.lastUpdatedIndex, j, false);
                }
            }
        }
    }

    public static ClassSummary createDetachedCopy(ClassSummary classSummary, int i, int i2, Map<RealmModel, CacheData<RealmModel>> map) {
        if (i <= i2) {
            if (classSummary != null) {
                CacheData cacheData = (CacheData) map.get(classSummary);
                if (cacheData == null) {
                    i2 = new ClassSummary();
                    map.put(classSummary, new CacheData(i, i2));
                } else if (i >= cacheData.minDepth) {
                    return cacheData.object;
                } else {
                    ClassSummary classSummary2 = (ClassSummary) cacheData.object;
                    cacheData.minDepth = i;
                    i2 = classSummary2;
                }
                ClassSummaryRealmProxyInterface classSummaryRealmProxyInterface = (ClassSummaryRealmProxyInterface) i2;
                ClassSummaryRealmProxyInterface classSummaryRealmProxyInterface2 = classSummary;
                classSummaryRealmProxyInterface.realmSet$period(classSummaryRealmProxyInterface2.realmGet$period());
                classSummaryRealmProxyInterface.realmSet$schoolCode(classSummaryRealmProxyInterface2.realmGet$schoolCode());
                classSummaryRealmProxyInterface.realmSet$studentID(classSummaryRealmProxyInterface2.realmGet$studentID());
                classSummaryRealmProxyInterface.realmSet$showPeriod(classSummaryRealmProxyInterface2.realmGet$showPeriod());
                classSummaryRealmProxyInterface.realmSet$hideScores(classSummaryRealmProxyInterface2.realmGet$hideScores());
                classSummaryRealmProxyInterface.realmSet$schoolName(classSummaryRealmProxyInterface2.realmGet$schoolName());
                classSummaryRealmProxyInterface.realmSet$sectionNumber(classSummaryRealmProxyInterface2.realmGet$sectionNumber());
                classSummaryRealmProxyInterface.realmSet$gradeBookNumber(classSummaryRealmProxyInterface2.realmGet$gradeBookNumber());
                classSummaryRealmProxyInterface.realmSet$gradeBookName(classSummaryRealmProxyInterface2.realmGet$gradeBookName());
                classSummaryRealmProxyInterface.realmSet$doingRubric(classSummaryRealmProxyInterface2.realmGet$doingRubric());
                classSummaryRealmProxyInterface.realmSet$courseNumber(classSummaryRealmProxyInterface2.realmGet$courseNumber());
                classSummaryRealmProxyInterface.realmSet$courseTitle(classSummaryRealmProxyInterface2.realmGet$courseTitle());
                classSummaryRealmProxyInterface.realmSet$teacherNumber(classSummaryRealmProxyInterface2.realmGet$teacherNumber());
                classSummaryRealmProxyInterface.realmSet$teacherName(classSummaryRealmProxyInterface2.realmGet$teacherName());
                classSummaryRealmProxyInterface.realmSet$roomNumber(classSummaryRealmProxyInterface2.realmGet$roomNumber());
                classSummaryRealmProxyInterface.realmSet$currentMark(classSummaryRealmProxyInterface2.realmGet$currentMark());
                classSummaryRealmProxyInterface.realmSet$percent(classSummaryRealmProxyInterface2.realmGet$percent());
                classSummaryRealmProxyInterface.realmSet$average(classSummaryRealmProxyInterface2.realmGet$average());
                classSummaryRealmProxyInterface.realmSet$missingAssignment(classSummaryRealmProxyInterface2.realmGet$missingAssignment());
                classSummaryRealmProxyInterface.realmSet$term(classSummaryRealmProxyInterface2.realmGet$term());
                classSummaryRealmProxyInterface.realmSet$termCode(classSummaryRealmProxyInterface2.realmGet$termCode());
                classSummaryRealmProxyInterface.realmSet$lastUpdated(classSummaryRealmProxyInterface2.realmGet$lastUpdated());
                return i2;
            }
        }
        return null;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ClassSummary = proxy[");
        stringBuilder.append("{period:");
        stringBuilder.append(realmGet$period() != null ? realmGet$period() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{schoolCode:");
        stringBuilder.append(realmGet$schoolCode() != null ? realmGet$schoolCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{studentID:");
        stringBuilder.append(realmGet$studentID() != null ? realmGet$studentID() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{showPeriod:");
        stringBuilder.append(realmGet$showPeriod());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{hideScores:");
        stringBuilder.append(realmGet$hideScores());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{schoolName:");
        stringBuilder.append(realmGet$schoolName() != null ? realmGet$schoolName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sectionNumber:");
        stringBuilder.append(realmGet$sectionNumber() != null ? realmGet$sectionNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{gradeBookNumber:");
        stringBuilder.append(realmGet$gradeBookNumber() != null ? realmGet$gradeBookNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{gradeBookName:");
        stringBuilder.append(realmGet$gradeBookName() != null ? realmGet$gradeBookName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{doingRubric:");
        stringBuilder.append(realmGet$doingRubric());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{courseNumber:");
        stringBuilder.append(realmGet$courseNumber() != null ? realmGet$courseNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{courseTitle:");
        stringBuilder.append(realmGet$courseTitle() != null ? realmGet$courseTitle() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{teacherNumber:");
        stringBuilder.append(realmGet$teacherNumber() != null ? realmGet$teacherNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{teacherName:");
        stringBuilder.append(realmGet$teacherName() != null ? realmGet$teacherName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{roomNumber:");
        stringBuilder.append(realmGet$roomNumber() != null ? realmGet$roomNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{currentMark:");
        stringBuilder.append(realmGet$currentMark() != null ? realmGet$currentMark() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{percent:");
        stringBuilder.append(realmGet$percent() != null ? realmGet$percent() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{average:");
        stringBuilder.append(realmGet$average() != null ? realmGet$average() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{missingAssignment:");
        stringBuilder.append(realmGet$missingAssignment() != null ? realmGet$missingAssignment() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{term:");
        stringBuilder.append(realmGet$term() != null ? realmGet$term() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{termCode:");
        stringBuilder.append(realmGet$termCode() != null ? realmGet$termCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lastUpdated:");
        stringBuilder.append(realmGet$lastUpdated() != null ? realmGet$lastUpdated() : "null");
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
        r7 = (io.realm.ClassSummaryRealmProxy) r7;
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
        throw new UnsupportedOperationException("Method not decompiled: io.realm.ClassSummaryRealmProxy.equals(java.lang.Object):boolean");
    }
}
