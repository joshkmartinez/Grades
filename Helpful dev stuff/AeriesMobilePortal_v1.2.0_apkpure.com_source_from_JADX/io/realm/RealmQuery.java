package io.realm;

import io.realm.internal.Collection;
import io.realm.internal.LinkView;
import io.realm.internal.PendingRow;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SortDescriptor;
import io.realm.internal.Table;
import io.realm.internal.TableQuery;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

public class RealmQuery<E extends RealmModel> {
    private static final String ASYNC_QUERY_WRONG_THREAD_MESSAGE = "Async query cannot be created on current thread.";
    private static final String EMPTY_VALUES = "Non-empty 'values' must be provided.";
    private static final String TYPE_MISMATCH = "Field '%s': type mismatch - %s expected.";
    private String className;
    private Class<E> clazz;
    private LinkView linkView;
    private final TableQuery query;
    private final BaseRealm realm;
    private final RealmObjectSchema schema;
    private final Table table;

    public static <E extends RealmModel> RealmQuery<E> createQuery(Realm realm, Class<E> cls) {
        return new RealmQuery(realm, (Class) cls);
    }

    public static <E extends RealmModel> RealmQuery<E> createDynamicQuery(DynamicRealm dynamicRealm, String str) {
        return new RealmQuery((BaseRealm) dynamicRealm, str);
    }

    public static <E extends RealmModel> RealmQuery<E> createQueryFromResult(RealmResults<E> realmResults) {
        if (realmResults.classSpec == null) {
            return new RealmQuery((RealmResults) realmResults, realmResults.className);
        }
        return new RealmQuery((RealmResults) realmResults, realmResults.classSpec);
    }

    public static <E extends RealmModel> RealmQuery<E> createQueryFromList(RealmList<E> realmList) {
        if (realmList.clazz == null) {
            return new RealmQuery(realmList.realm, realmList.view, realmList.className);
        }
        return new RealmQuery(realmList.realm, realmList.view, realmList.clazz);
    }

    private RealmQuery(Realm realm, Class<E> cls) {
        this.realm = realm;
        this.clazz = cls;
        this.schema = realm.getSchema().getSchemaForClass((Class) cls);
        this.table = this.schema.getTable();
        this.linkView = null;
        this.query = this.table.where();
    }

    private RealmQuery(RealmResults<E> realmResults, Class<E> cls) {
        this.realm = realmResults.realm;
        this.clazz = cls;
        this.schema = this.realm.getSchema().getSchemaForClass((Class) cls);
        this.table = realmResults.getTable();
        this.linkView = null;
        this.query = realmResults.getCollection().where();
    }

    private RealmQuery(BaseRealm baseRealm, LinkView linkView, Class<E> cls) {
        this.realm = baseRealm;
        this.clazz = cls;
        this.schema = baseRealm.getSchema().getSchemaForClass((Class) cls);
        this.table = this.schema.getTable();
        this.linkView = linkView;
        this.query = linkView.where();
    }

    private RealmQuery(BaseRealm baseRealm, String str) {
        this.realm = baseRealm;
        this.className = str;
        this.schema = baseRealm.getSchema().getSchemaForClass(str);
        this.table = this.schema.getTable();
        this.query = this.table.where();
    }

    private RealmQuery(RealmResults<DynamicRealmObject> realmResults, String str) {
        this.realm = realmResults.realm;
        this.className = str;
        this.schema = this.realm.getSchema().getSchemaForClass(str);
        this.table = this.schema.getTable();
        this.query = realmResults.getCollection().where();
    }

    private RealmQuery(BaseRealm baseRealm, LinkView linkView, String str) {
        this.realm = baseRealm;
        this.className = str;
        this.schema = baseRealm.getSchema().getSchemaForClass(str);
        this.table = this.schema.getTable();
        this.linkView = linkView;
        this.query = linkView.where();
    }

    public boolean isValid() {
        boolean z = false;
        if (this.realm != null) {
            if (!this.realm.isClosed()) {
                if (this.linkView != null) {
                    return this.linkView.isAttached();
                }
                if (this.table != null && this.table.isValid()) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    public RealmQuery<E> isNull(String str) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, new RealmFieldType[0]);
        this.query.isNull(str.getColumnIndices(), str.getNativeTablePointers());
        return this;
    }

    public RealmQuery<E> isNotNull(String str) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, new RealmFieldType[0]);
        this.query.isNotNull(str.getColumnIndices(), str.getNativeTablePointers());
        return this;
    }

    public RealmQuery<E> equalTo(String str, String str2) {
        return equalTo(str, str2, Case.SENSITIVE);
    }

    public RealmQuery<E> equalTo(String str, String str2, Case caseR) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, str2, caseR);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, String str2, Case caseR) {
        str = this.schema.getColumnIndices(str, RealmFieldType.STRING);
        this.query.equalTo(str.getColumnIndices(), str.getNativeTablePointers(), str2, caseR);
        return this;
    }

    public RealmQuery<E> equalTo(String str, Byte b) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, b);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, Byte b) {
        str = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (b == null) {
            this.query.isNull(str.getColumnIndices(), str.getNativeTablePointers());
        } else {
            this.query.equalTo(str.getColumnIndices(), str.getNativeTablePointers(), (long) b.byteValue());
        }
        return this;
    }

    public RealmQuery<E> equalTo(String str, byte[] bArr) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.BINARY);
        if (bArr == null) {
            this.query.isNull(str.getColumnIndices(), str.getNativeTablePointers());
        } else {
            this.query.equalTo(str.getColumnIndices(), str.getNativeTablePointers(), bArr);
        }
        return this;
    }

    public RealmQuery<E> equalTo(String str, Short sh) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, sh);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, Short sh) {
        str = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (sh == null) {
            this.query.isNull(str.getColumnIndices(), str.getNativeTablePointers());
        } else {
            this.query.equalTo(str.getColumnIndices(), str.getNativeTablePointers(), (long) sh.shortValue());
        }
        return this;
    }

    public RealmQuery<E> equalTo(String str, Integer num) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, num);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, Integer num) {
        str = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (num == null) {
            this.query.isNull(str.getColumnIndices(), str.getNativeTablePointers());
        } else {
            this.query.equalTo(str.getColumnIndices(), str.getNativeTablePointers(), (long) num.intValue());
        }
        return this;
    }

    public RealmQuery<E> equalTo(String str, Long l) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, l);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, Long l) {
        str = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (l == null) {
            this.query.isNull(str.getColumnIndices(), str.getNativeTablePointers());
        } else {
            this.query.equalTo(str.getColumnIndices(), str.getNativeTablePointers(), l.longValue());
        }
        return this;
    }

    public RealmQuery<E> equalTo(String str, Double d) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, d);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, Double d) {
        str = this.schema.getColumnIndices(str, RealmFieldType.DOUBLE);
        if (d == null) {
            this.query.isNull(str.getColumnIndices(), str.getNativeTablePointers());
        } else {
            this.query.equalTo(str.getColumnIndices(), str.getNativeTablePointers(), d.doubleValue());
        }
        return this;
    }

    public RealmQuery<E> equalTo(String str, Float f) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, f);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, Float f) {
        str = this.schema.getColumnIndices(str, RealmFieldType.FLOAT);
        if (f == null) {
            this.query.isNull(str.getColumnIndices(), str.getNativeTablePointers());
        } else {
            this.query.equalTo(str.getColumnIndices(), str.getNativeTablePointers(), f.floatValue());
        }
        return this;
    }

    public RealmQuery<E> equalTo(String str, Boolean bool) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, bool);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, Boolean bool) {
        str = this.schema.getColumnIndices(str, RealmFieldType.BOOLEAN);
        if (bool == null) {
            this.query.isNull(str.getColumnIndices(), str.getNativeTablePointers());
        } else {
            this.query.equalTo(str.getColumnIndices(), str.getNativeTablePointers(), bool.booleanValue());
        }
        return this;
    }

    public RealmQuery<E> equalTo(String str, Date date) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, date);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, Date date) {
        str = this.schema.getColumnIndices(str, RealmFieldType.DATE);
        this.query.equalTo(str.getColumnIndices(), str.getNativeTablePointers(), date);
        return this;
    }

    public RealmQuery<E> in(String str, String[] strArr) {
        return in(str, strArr, Case.SENSITIVE);
    }

    public RealmQuery<E> in(String str, String[] strArr, Case caseR) {
        this.realm.checkIfValid();
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, strArr[0], caseR);
        for (int i = 1; i < strArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, strArr[i], caseR);
        }
        return endGroupWithoutThreadValidation();
    }

    public RealmQuery<E> in(String str, Byte[] bArr) {
        this.realm.checkIfValid();
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, bArr[0]);
        for (int i = 1; i < bArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, bArr[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    public RealmQuery<E> in(String str, Short[] shArr) {
        this.realm.checkIfValid();
        if (shArr == null || shArr.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, shArr[0]);
        for (int i = 1; i < shArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, shArr[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    public RealmQuery<E> in(String str, Integer[] numArr) {
        this.realm.checkIfValid();
        if (numArr == null || numArr.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, numArr[0]);
        for (int i = 1; i < numArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, numArr[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    public RealmQuery<E> in(String str, Long[] lArr) {
        this.realm.checkIfValid();
        if (lArr == null || lArr.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, lArr[0]);
        for (int i = 1; i < lArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, lArr[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    public RealmQuery<E> in(String str, Double[] dArr) {
        this.realm.checkIfValid();
        if (dArr == null || dArr.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, dArr[0]);
        for (int i = 1; i < dArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, dArr[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    public RealmQuery<E> in(String str, Float[] fArr) {
        this.realm.checkIfValid();
        if (fArr == null || fArr.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, fArr[0]);
        for (int i = 1; i < fArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, fArr[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    public RealmQuery<E> in(String str, Boolean[] boolArr) {
        this.realm.checkIfValid();
        if (boolArr == null || boolArr.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, boolArr[0]);
        for (int i = 1; i < boolArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, boolArr[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    public RealmQuery<E> in(String str, Date[] dateArr) {
        this.realm.checkIfValid();
        if (dateArr == null || dateArr.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(str, dateArr[0]);
        for (int i = 1; i < dateArr.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(str, dateArr[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    public RealmQuery<E> notEqualTo(String str, String str2) {
        return notEqualTo(str, str2, Case.SENSITIVE);
    }

    public RealmQuery<E> notEqualTo(String str, String str2, Case caseR) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.STRING);
        if (str.length() > 1) {
            if (!caseR.getValue()) {
                throw new IllegalArgumentException("Link queries cannot be case insensitive - coming soon.");
            }
        }
        this.query.notEqualTo(str.getColumnIndices(), str.getNativeTablePointers(), str2, caseR);
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, Byte b) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (b == null) {
            this.query.isNotNull(str.getColumnIndices(), str.getNativeTablePointers());
        } else {
            this.query.notEqualTo(str.getColumnIndices(), str.getNativeTablePointers(), (long) b.byteValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, byte[] bArr) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.BINARY);
        if (bArr == null) {
            this.query.isNotNull(str.getColumnIndices(), str.getNativeTablePointers());
        } else {
            this.query.notEqualTo(str.getColumnIndices(), str.getNativeTablePointers(), bArr);
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, Short sh) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (sh == null) {
            this.query.isNotNull(str.getColumnIndices(), str.getNativeTablePointers());
        } else {
            this.query.notEqualTo(str.getColumnIndices(), str.getNativeTablePointers(), (long) sh.shortValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, Integer num) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (num == null) {
            this.query.isNotNull(str.getColumnIndices(), str.getNativeTablePointers());
        } else {
            this.query.notEqualTo(str.getColumnIndices(), str.getNativeTablePointers(), (long) num.intValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, Long l) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (l == null) {
            this.query.isNotNull(str.getColumnIndices(), str.getNativeTablePointers());
        } else {
            this.query.notEqualTo(str.getColumnIndices(), str.getNativeTablePointers(), l.longValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, Double d) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.DOUBLE);
        if (d == null) {
            this.query.isNotNull(str.getColumnIndices(), str.getNativeTablePointers());
        } else {
            this.query.notEqualTo(str.getColumnIndices(), str.getNativeTablePointers(), d.doubleValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, Float f) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.FLOAT);
        if (f == null) {
            this.query.isNotNull(str.getColumnIndices(), str.getNativeTablePointers());
        } else {
            this.query.notEqualTo(str.getColumnIndices(), str.getNativeTablePointers(), f.floatValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, Boolean bool) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.BOOLEAN);
        if (bool == null) {
            this.query.isNotNull(str.getColumnIndices(), str.getNativeTablePointers());
        } else {
            this.query.equalTo(str.getColumnIndices(), str.getNativeTablePointers(), bool.booleanValue() ^ 1);
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, Date date) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.DATE);
        if (date == null) {
            this.query.isNotNull(str.getColumnIndices(), str.getNativeTablePointers());
        } else {
            this.query.notEqualTo(str.getColumnIndices(), str.getNativeTablePointers(), date);
        }
        return this;
    }

    public RealmQuery<E> greaterThan(String str, int i) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        this.query.greaterThan(str.getColumnIndices(), str.getNativeTablePointers(), (long) i);
        return this;
    }

    public RealmQuery<E> greaterThan(String str, long j) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        this.query.greaterThan(str.getColumnIndices(), str.getNativeTablePointers(), j);
        return this;
    }

    public RealmQuery<E> greaterThan(String str, double d) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.DOUBLE);
        this.query.greaterThan(str.getColumnIndices(), str.getNativeTablePointers(), d);
        return this;
    }

    public RealmQuery<E> greaterThan(String str, float f) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.FLOAT);
        this.query.greaterThan(str.getColumnIndices(), str.getNativeTablePointers(), f);
        return this;
    }

    public RealmQuery<E> greaterThan(String str, Date date) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.DATE);
        this.query.greaterThan(str.getColumnIndices(), str.getNativeTablePointers(), date);
        return this;
    }

    public RealmQuery<E> greaterThanOrEqualTo(String str, int i) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        this.query.greaterThanOrEqual(str.getColumnIndices(), str.getNativeTablePointers(), (long) i);
        return this;
    }

    public RealmQuery<E> greaterThanOrEqualTo(String str, long j) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        this.query.greaterThanOrEqual(str.getColumnIndices(), str.getNativeTablePointers(), j);
        return this;
    }

    public RealmQuery<E> greaterThanOrEqualTo(String str, double d) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.DOUBLE);
        this.query.greaterThanOrEqual(str.getColumnIndices(), str.getNativeTablePointers(), d);
        return this;
    }

    public RealmQuery<E> greaterThanOrEqualTo(String str, float f) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.FLOAT);
        this.query.greaterThanOrEqual(str.getColumnIndices(), str.getNativeTablePointers(), f);
        return this;
    }

    public RealmQuery<E> greaterThanOrEqualTo(String str, Date date) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.DATE);
        this.query.greaterThanOrEqual(str.getColumnIndices(), str.getNativeTablePointers(), date);
        return this;
    }

    public RealmQuery<E> lessThan(String str, int i) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        this.query.lessThan(str.getColumnIndices(), str.getNativeTablePointers(), (long) i);
        return this;
    }

    public RealmQuery<E> lessThan(String str, long j) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        this.query.lessThan(str.getColumnIndices(), str.getNativeTablePointers(), j);
        return this;
    }

    public RealmQuery<E> lessThan(String str, double d) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.DOUBLE);
        this.query.lessThan(str.getColumnIndices(), str.getNativeTablePointers(), d);
        return this;
    }

    public RealmQuery<E> lessThan(String str, float f) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.FLOAT);
        this.query.lessThan(str.getColumnIndices(), str.getNativeTablePointers(), f);
        return this;
    }

    public RealmQuery<E> lessThan(String str, Date date) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.DATE);
        this.query.lessThan(str.getColumnIndices(), str.getNativeTablePointers(), date);
        return this;
    }

    public RealmQuery<E> lessThanOrEqualTo(String str, int i) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        this.query.lessThanOrEqual(str.getColumnIndices(), str.getNativeTablePointers(), (long) i);
        return this;
    }

    public RealmQuery<E> lessThanOrEqualTo(String str, long j) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        this.query.lessThanOrEqual(str.getColumnIndices(), str.getNativeTablePointers(), j);
        return this;
    }

    public RealmQuery<E> lessThanOrEqualTo(String str, double d) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.DOUBLE);
        this.query.lessThanOrEqual(str.getColumnIndices(), str.getNativeTablePointers(), d);
        return this;
    }

    public RealmQuery<E> lessThanOrEqualTo(String str, float f) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.FLOAT);
        this.query.lessThanOrEqual(str.getColumnIndices(), str.getNativeTablePointers(), f);
        return this;
    }

    public RealmQuery<E> lessThanOrEqualTo(String str, Date date) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.DATE);
        this.query.lessThanOrEqual(str.getColumnIndices(), str.getNativeTablePointers(), date);
        return this;
    }

    public RealmQuery<E> between(String str, int i, int i2) {
        this.realm.checkIfValid();
        this.query.between(this.schema.getColumnIndices(str, RealmFieldType.INTEGER).getColumnIndices(), (long) i, (long) i2);
        return this;
    }

    public RealmQuery<E> between(String str, long j, long j2) {
        this.realm.checkIfValid();
        this.query.between(this.schema.getColumnIndices(str, RealmFieldType.INTEGER).getColumnIndices(), j, j2);
        return this;
    }

    public RealmQuery<E> between(String str, double d, double d2) {
        this.realm.checkIfValid();
        this.query.between(this.schema.getColumnIndices(str, RealmFieldType.DOUBLE).getColumnIndices(), d, d2);
        return this;
    }

    public RealmQuery<E> between(String str, float f, float f2) {
        this.realm.checkIfValid();
        this.query.between(this.schema.getColumnIndices(str, RealmFieldType.FLOAT).getColumnIndices(), f, f2);
        return this;
    }

    public RealmQuery<E> between(String str, Date date, Date date2) {
        this.realm.checkIfValid();
        this.query.between(this.schema.getColumnIndices(str, RealmFieldType.DATE).getColumnIndices(), date, date2);
        return this;
    }

    public RealmQuery<E> contains(String str, String str2) {
        return contains(str, str2, Case.SENSITIVE);
    }

    public RealmQuery<E> contains(String str, String str2, Case caseR) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.STRING);
        this.query.contains(str.getColumnIndices(), str.getNativeTablePointers(), str2, caseR);
        return this;
    }

    public RealmQuery<E> beginsWith(String str, String str2) {
        return beginsWith(str, str2, Case.SENSITIVE);
    }

    public RealmQuery<E> beginsWith(String str, String str2, Case caseR) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.STRING);
        this.query.beginsWith(str.getColumnIndices(), str.getNativeTablePointers(), str2, caseR);
        return this;
    }

    public RealmQuery<E> endsWith(String str, String str2) {
        return endsWith(str, str2, Case.SENSITIVE);
    }

    public RealmQuery<E> endsWith(String str, String str2, Case caseR) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.STRING);
        this.query.endsWith(str.getColumnIndices(), str.getNativeTablePointers(), str2, caseR);
        return this;
    }

    public RealmQuery<E> like(String str, String str2) {
        return like(str, str2, Case.SENSITIVE);
    }

    public RealmQuery<E> like(String str, String str2, Case caseR) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.STRING);
        this.query.like(str.getColumnIndices(), str.getNativeTablePointers(), str2, caseR);
        return this;
    }

    public RealmQuery<E> beginGroup() {
        this.realm.checkIfValid();
        return beginGroupWithoutThreadValidation();
    }

    private RealmQuery<E> beginGroupWithoutThreadValidation() {
        this.query.group();
        return this;
    }

    public RealmQuery<E> endGroup() {
        this.realm.checkIfValid();
        return endGroupWithoutThreadValidation();
    }

    private RealmQuery<E> endGroupWithoutThreadValidation() {
        this.query.endGroup();
        return this;
    }

    public RealmQuery<E> or() {
        this.realm.checkIfValid();
        return orWithoutThreadValidation();
    }

    private RealmQuery<E> orWithoutThreadValidation() {
        this.query.or();
        return this;
    }

    public RealmQuery<E> not() {
        this.realm.checkIfValid();
        this.query.not();
        return this;
    }

    public RealmQuery<E> isEmpty(String str) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.STRING, RealmFieldType.BINARY, RealmFieldType.LIST, RealmFieldType.LINKING_OBJECTS);
        this.query.isEmpty(str.getColumnIndices(), str.getNativeTablePointers());
        return this;
    }

    public RealmQuery<E> isNotEmpty(String str) {
        this.realm.checkIfValid();
        str = this.schema.getColumnIndices(str, RealmFieldType.STRING, RealmFieldType.BINARY, RealmFieldType.LIST, RealmFieldType.LINKING_OBJECTS);
        this.query.isNotEmpty(str.getColumnIndices(), str.getNativeTablePointers());
        return this;
    }

    public RealmResults<E> distinct(String str) {
        this.realm.checkIfValid();
        return createRealmResults(this.query, null, SortDescriptor.getInstanceForDistinct(getSchemaConnector(), this.query.getTable(), str), true);
    }

    public RealmResults<E> distinctAsync(String str) {
        this.realm.checkIfValid();
        this.realm.sharedRealm.capabilities.checkCanDeliverNotification(ASYNC_QUERY_WRONG_THREAD_MESSAGE);
        return createRealmResults(this.query, null, SortDescriptor.getInstanceForDistinct(getSchemaConnector(), this.query.getTable(), str), false);
    }

    public RealmResults<E> distinct(String str, String... strArr) {
        this.realm.checkIfValid();
        String[] strArr2 = new String[(strArr.length + 1)];
        strArr2[0] = str;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return createRealmResults(this.query, null, SortDescriptor.getInstanceForDistinct(getSchemaConnector(), this.table, strArr2), true);
    }

    public Number sum(String str) {
        this.realm.checkIfValid();
        long andCheckFieldIndex = this.schema.getAndCheckFieldIndex(str);
        switch (this.table.getColumnType(andCheckFieldIndex)) {
            case INTEGER:
                return Long.valueOf(this.query.sumInt(andCheckFieldIndex));
            case FLOAT:
                return Double.valueOf(this.query.sumFloat(andCheckFieldIndex));
            case DOUBLE:
                return Double.valueOf(this.query.sumDouble(andCheckFieldIndex));
            default:
                throw new IllegalArgumentException(String.format(Locale.US, TYPE_MISMATCH, new Object[]{str, "int, float or double"}));
        }
    }

    public double average(String str) {
        this.realm.checkIfValid();
        long andCheckFieldIndex = this.schema.getAndCheckFieldIndex(str);
        switch (this.table.getColumnType(andCheckFieldIndex)) {
            case INTEGER:
                return this.query.averageInt(andCheckFieldIndex);
            case FLOAT:
                return this.query.averageFloat(andCheckFieldIndex);
            case DOUBLE:
                return this.query.averageDouble(andCheckFieldIndex);
            default:
                throw new IllegalArgumentException(String.format(Locale.US, TYPE_MISMATCH, new Object[]{str, "int, float or double"}));
        }
    }

    public Number min(String str) {
        this.realm.checkIfValid();
        long andCheckFieldIndex = this.schema.getAndCheckFieldIndex(str);
        switch (this.table.getColumnType(andCheckFieldIndex)) {
            case INTEGER:
                return this.query.minimumInt(andCheckFieldIndex);
            case FLOAT:
                return this.query.minimumFloat(andCheckFieldIndex);
            case DOUBLE:
                return this.query.minimumDouble(andCheckFieldIndex);
            default:
                throw new IllegalArgumentException(String.format(Locale.US, TYPE_MISMATCH, new Object[]{str, "int, float or double"}));
        }
    }

    public Date minimumDate(String str) {
        this.realm.checkIfValid();
        return this.query.minimumDate(this.schema.getAndCheckFieldIndex(str));
    }

    public Number max(String str) {
        this.realm.checkIfValid();
        long andCheckFieldIndex = this.schema.getAndCheckFieldIndex(str);
        switch (this.table.getColumnType(andCheckFieldIndex)) {
            case INTEGER:
                return this.query.maximumInt(andCheckFieldIndex);
            case FLOAT:
                return this.query.maximumFloat(andCheckFieldIndex);
            case DOUBLE:
                return this.query.maximumDouble(andCheckFieldIndex);
            default:
                throw new IllegalArgumentException(String.format(Locale.US, TYPE_MISMATCH, new Object[]{str, "int, float or double"}));
        }
    }

    public Date maximumDate(String str) {
        this.realm.checkIfValid();
        return this.query.maximumDate(this.schema.getAndCheckFieldIndex(str));
    }

    public long count() {
        this.realm.checkIfValid();
        return this.query.count();
    }

    public RealmResults<E> findAll() {
        this.realm.checkIfValid();
        return createRealmResults(this.query, null, null, true);
    }

    public RealmResults<E> findAllAsync() {
        this.realm.checkIfValid();
        this.realm.sharedRealm.capabilities.checkCanDeliverNotification(ASYNC_QUERY_WRONG_THREAD_MESSAGE);
        return createRealmResults(this.query, null, null, false);
    }

    public RealmResults<E> findAllSorted(String str, Sort sort) {
        this.realm.checkIfValid();
        return createRealmResults(this.query, SortDescriptor.getInstanceForSort(getSchemaConnector(), this.query.getTable(), str, sort), null, true);
    }

    public RealmResults<E> findAllSortedAsync(String str, Sort sort) {
        this.realm.checkIfValid();
        this.realm.sharedRealm.capabilities.checkCanDeliverNotification(ASYNC_QUERY_WRONG_THREAD_MESSAGE);
        return createRealmResults(this.query, SortDescriptor.getInstanceForSort(getSchemaConnector(), this.query.getTable(), str, sort), null, false);
    }

    public RealmResults<E> findAllSorted(String str) {
        return findAllSorted(str, Sort.ASCENDING);
    }

    public RealmResults<E> findAllSortedAsync(String str) {
        return findAllSortedAsync(str, Sort.ASCENDING);
    }

    public RealmResults<E> findAllSorted(String[] strArr, Sort[] sortArr) {
        this.realm.checkIfValid();
        return createRealmResults(this.query, SortDescriptor.getInstanceForSort(getSchemaConnector(), this.query.getTable(), strArr, sortArr), null, true);
    }

    private boolean isDynamicQuery() {
        return this.className != null;
    }

    public RealmResults<E> findAllSortedAsync(String[] strArr, Sort[] sortArr) {
        this.realm.checkIfValid();
        this.realm.sharedRealm.capabilities.checkCanDeliverNotification(ASYNC_QUERY_WRONG_THREAD_MESSAGE);
        return createRealmResults(this.query, SortDescriptor.getInstanceForSort(getSchemaConnector(), this.query.getTable(), strArr, sortArr), null, false);
    }

    public RealmResults<E> findAllSorted(String str, Sort sort, String str2, Sort sort2) {
        return findAllSorted(new String[]{str, str2}, new Sort[]{sort, sort2});
    }

    public RealmResults<E> findAllSortedAsync(String str, Sort sort, String str2, Sort sort2) {
        return findAllSortedAsync(new String[]{str, str2}, new Sort[]{sort, sort2});
    }

    public E findFirst() {
        this.realm.checkIfValid();
        long sourceRowIndexForFirstObject = getSourceRowIndexForFirstObject();
        if (sourceRowIndexForFirstObject < 0) {
            return null;
        }
        return this.realm.get(this.clazz, this.className, sourceRowIndexForFirstObject);
    }

    public E findFirstAsync() {
        Row firstUncheckedRow;
        E dynamicRealmObject;
        this.realm.checkIfValid();
        this.realm.sharedRealm.capabilities.checkCanDeliverNotification(ASYNC_QUERY_WRONG_THREAD_MESSAGE);
        if (this.realm.isInTransaction()) {
            firstUncheckedRow = new Collection(this.realm.sharedRealm, this.query).firstUncheckedRow();
        } else {
            firstUncheckedRow = new PendingRow(this.realm.sharedRealm, this.query, null, isDynamicQuery());
        }
        if (isDynamicQuery()) {
            dynamicRealmObject = new DynamicRealmObject(this.realm, firstUncheckedRow);
        } else {
            dynamicRealmObject = this.realm.getConfiguration().getSchemaMediator().newInstance(this.clazz, this.realm, firstUncheckedRow, this.realm.getSchema().getColumnInfo(this.clazz), false, Collections.emptyList());
        }
        if (firstUncheckedRow instanceof PendingRow) {
            ((PendingRow) firstUncheckedRow).setFrontEnd(((RealmObjectProxy) dynamicRealmObject).realmGet$proxyState());
        }
        return dynamicRealmObject;
    }

    private RealmResults<E> createRealmResults(TableQuery tableQuery, SortDescriptor sortDescriptor, SortDescriptor sortDescriptor2, boolean z) {
        Collection collection = new Collection(this.realm.sharedRealm, tableQuery, sortDescriptor, sortDescriptor2);
        if (isDynamicQuery() != null) {
            tableQuery = new RealmResults(this.realm, collection, this.className);
        } else {
            tableQuery = new RealmResults(this.realm, collection, this.clazz);
        }
        if (z) {
            tableQuery.load();
        }
        return tableQuery;
    }

    private long getSourceRowIndexForFirstObject() {
        return this.query.find();
    }

    private SchemaConnector getSchemaConnector() {
        return new SchemaConnector(this.realm.getSchema());
    }
}
