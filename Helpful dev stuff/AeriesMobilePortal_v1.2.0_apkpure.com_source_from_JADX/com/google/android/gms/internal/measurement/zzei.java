package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class zzei extends zzjq {
    private static final String[] zzaev = new String[]{"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"};
    private static final String[] zzaew = new String[]{Param.ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzaex = new String[]{"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;"};
    private static final String[] zzaey = new String[]{"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzaez = new String[]{"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzafa = new String[]{"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzel zzafb = new zzel(this, getContext(), "google_app_measurement.db");
    private final zzjm zzafc = new zzjm(zzbt());

    zzei(zzjr com_google_android_gms_internal_measurement_zzjr) {
        super(com_google_android_gms_internal_measurement_zzjr);
    }

    @WorkerThread
    private final long zza(String str, String[] strArr) {
        Object e;
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            try {
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e2) {
                e = e2;
                cursor = rawQuery;
                try {
                    zzge().zzim().zze("Database error", str, e);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    rawQuery = cursor;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            zzge().zzim().zze("Database error", str, e);
            throw e;
        }
    }

    @WorkerThread
    private final long zza(String str, String[] strArr, long j) {
        Object e;
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            try {
                if (rawQuery.moveToFirst()) {
                    j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = rawQuery;
                try {
                    zzge().zzim().zze("Database error", str, e);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = rawQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            zzge().zzim().zze("Database error", str, e);
            throw e;
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        switch (type) {
            case 0:
                zzge().zzim().log("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                zzge().zzim().log("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzge().zzim().zzg("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
        }
    }

    @WorkerThread
    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    static void zza(zzfg com_google_android_gms_internal_measurement_zzfg, SQLiteDatabase sQLiteDatabase) {
        if (com_google_android_gms_internal_measurement_zzfg != null) {
            File file = new File(sQLiteDatabase.getPath());
            if (!file.setReadable(false, false)) {
                com_google_android_gms_internal_measurement_zzfg.zzip().log("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                com_google_android_gms_internal_measurement_zzfg.zzip().log("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                com_google_android_gms_internal_measurement_zzfg.zzip().log("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                com_google_android_gms_internal_measurement_zzfg.zzip().log("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }

    @WorkerThread
    static void zza(zzfg com_google_android_gms_internal_measurement_zzfg, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        if (com_google_android_gms_internal_measurement_zzfg != null) {
            if (!zza(com_google_android_gms_internal_measurement_zzfg, sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            if (com_google_android_gms_internal_measurement_zzfg != null) {
                try {
                    Iterable zzb = zzb(sQLiteDatabase, str);
                    String[] split = str3.split(",");
                    int length = split.length;
                    int i = 0;
                    int i2 = 0;
                    while (i2 < length) {
                        String str4 = split[i2];
                        if (zzb.remove(str4)) {
                            i2++;
                        } else {
                            StringBuilder stringBuilder = new StringBuilder((35 + String.valueOf(str).length()) + String.valueOf(str4).length());
                            stringBuilder.append("Table ");
                            stringBuilder.append(str);
                            stringBuilder.append(" is missing required column: ");
                            stringBuilder.append(str4);
                            throw new SQLiteException(stringBuilder.toString());
                        }
                    }
                    if (strArr != null) {
                        while (i < strArr.length) {
                            if (!zzb.remove(strArr[i])) {
                                sQLiteDatabase.execSQL(strArr[i + 1]);
                            }
                            i += 2;
                        }
                    }
                    if (!zzb.isEmpty()) {
                        com_google_android_gms_internal_measurement_zzfg.zzip().zze("Table has extra columns. table, columns", str, TextUtils.join(", ", zzb));
                        return;
                    }
                    return;
                } catch (SQLiteException e) {
                    com_google_android_gms_internal_measurement_zzfg.zzim().zzg("Failed to verify columns on table that was just created", str);
                    throw e;
                }
            }
            throw new IllegalArgumentException("Monitor must not be null");
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }

    @WorkerThread
    private static boolean zza(zzfg com_google_android_gms_internal_measurement_zzfg, SQLiteDatabase sQLiteDatabase, String str) {
        Object obj;
        Throwable th;
        if (com_google_android_gms_internal_measurement_zzfg != null) {
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query != null) {
                        query.close();
                    }
                    return moveToFirst;
                } catch (SQLiteException e) {
                    SQLiteException sQLiteException = e;
                    cursor = query;
                    obj = sQLiteException;
                    try {
                        com_google_android_gms_internal_measurement_zzfg.zzip().zze("Error querying for table", str, obj);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                obj = e2;
                com_google_android_gms_internal_measurement_zzfg.zzip().zze("Error querying for table", str, obj);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzke com_google_android_gms_internal_measurement_zzke) {
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzke);
        if (TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzke.zzarq)) {
            zzge().zzip().zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzfg.zzbm(str), Integer.valueOf(i), String.valueOf(com_google_android_gms_internal_measurement_zzke.zzarp));
            return false;
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_measurement_zzke.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            com_google_android_gms_internal_measurement_zzke.zza(zzb);
            zzb.zzve();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", com_google_android_gms_internal_measurement_zzke.zzarp);
            contentValues.put("event_name", com_google_android_gms_internal_measurement_zzke.zzarq);
            contentValues.put(DataBufferSafeParcelable.DATA_FIELD, bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    zzge().zzim().zzg("Failed to insert event filter (got -1). appId", zzfg.zzbm(str));
                }
                return true;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing event filter. appId", zzfg.zzbm(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzge().zzim().zze("Configuration loss. Failed to serialize event filter. appId", zzfg.zzbm(str), e2);
            return false;
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzkh com_google_android_gms_internal_measurement_zzkh) {
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzkh);
        if (TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzkh.zzasf)) {
            zzge().zzip().zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzfg.zzbm(str), Integer.valueOf(i), String.valueOf(com_google_android_gms_internal_measurement_zzkh.zzarp));
            return false;
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_measurement_zzkh.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            com_google_android_gms_internal_measurement_zzkh.zza(zzb);
            zzb.zzve();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", com_google_android_gms_internal_measurement_zzkh.zzarp);
            contentValues.put("property_name", com_google_android_gms_internal_measurement_zzkh.zzasf);
            contentValues.put(DataBufferSafeParcelable.DATA_FIELD, bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                zzge().zzim().zzg("Failed to insert property filter (got -1). appId", zzfg.zzbm(str));
                return false;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing property filter. appId", zzfg.zzbm(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzge().zzim().zze("Configuration loss. Failed to serialize property filter. appId", zzfg.zzbm(str), e2);
            return false;
        }
    }

    private final boolean zza(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzch();
        zzab();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            if (zza("select count(1) from audience_filter_values where app_id=?", new String[]{str}) <= ((long) Math.max(0, Math.min(CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, zzgg().zzb(str, zzew.zzahn))))) {
                return false;
            }
            Iterable arrayList = new ArrayList();
            int i = 0;
            while (i < list.size()) {
                Integer num = (Integer) list.get(i);
                if (num != null) {
                    if (num instanceof Integer) {
                        arrayList.add(Integer.toString(num.intValue()));
                        i++;
                    }
                }
                return false;
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(join).length() + 2);
            stringBuilder.append("(");
            stringBuilder.append(join);
            stringBuilder.append(")");
            join = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder(140 + String.valueOf(join).length());
            stringBuilder2.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            stringBuilder2.append(join);
            stringBuilder2.append(" order by rowid desc limit -1 offset ?)");
            return writableDatabase.delete("audience_filter_values", stringBuilder2.toString(), new String[]{str, Integer.toString(r2)}) > 0;
        } catch (SQLiteException e) {
            zzge().zzim().zze("Database error querying filters. appId", zzfg.zzbm(str), e);
            return false;
        }
    }

    @WorkerThread
    private static Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
        Object hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder(22 + String.valueOf(str).length());
        stringBuilder.append("SELECT * FROM ");
        stringBuilder.append(str);
        stringBuilder.append(" LIMIT 0");
        Cursor rawQuery = sQLiteDatabase.rawQuery(stringBuilder.toString(), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    private final boolean zzhv() {
        return getContext().getDatabasePath("google_app_measurement.db").exists();
    }

    @WorkerThread
    public final void beginTransaction() {
        zzch();
        getWritableDatabase().beginTransaction();
    }

    @WorkerThread
    public final void endTransaction() {
        zzch();
        getWritableDatabase().endTransaction();
    }

    @WorkerThread
    @VisibleForTesting
    final SQLiteDatabase getWritableDatabase() {
        zzab();
        try {
            return this.zzafb.getWritableDatabase();
        } catch (SQLiteException e) {
            zzge().zzip().zzg("Error opening database", e);
            throw e;
        }
    }

    @WorkerThread
    public final void setTransactionSuccessful() {
        zzch();
        getWritableDatabase().setTransactionSuccessful();
    }

    public final long zza(zzkq com_google_android_gms_internal_measurement_zzkq) throws IOException {
        zzab();
        zzch();
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzkq);
        Preconditions.checkNotEmpty(com_google_android_gms_internal_measurement_zzkq.zzti);
        try {
            long j;
            Object obj = new byte[com_google_android_gms_internal_measurement_zzkq.zzvm()];
            zzabw zzb = zzabw.zzb(obj, 0, obj.length);
            com_google_android_gms_internal_measurement_zzkq.zza(zzb);
            zzb.zzve();
            zzhg zzgb = zzgb();
            Preconditions.checkNotNull(obj);
            zzgb.zzab();
            MessageDigest messageDigest = zzka.getMessageDigest("MD5");
            if (messageDigest == null) {
                zzgb.zzge().zzim().log("Failed to get MD5");
                j = 0;
            } else {
                j = zzka.zzc(messageDigest.digest(obj));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_google_android_gms_internal_measurement_zzkq.zzti);
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("metadata", obj);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return j;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing raw event metadata. appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzkq.zzti), e);
                throw e;
            }
        } catch (IOException e2) {
            zzge().zzim().zze("Data loss. Failed to serialize event metadata. appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzkq.zzti), e2);
            throw e2;
        }
    }

    public final Pair<zzkn, Long> zza(String str, Long l) {
        Cursor rawQuery;
        Object e;
        Throwable th;
        zzab();
        zzch();
        try {
            rawQuery = getWritableDatabase().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
            try {
                if (rawQuery.moveToFirst()) {
                    byte[] blob = rawQuery.getBlob(0);
                    Long valueOf = Long.valueOf(rawQuery.getLong(1));
                    zzabv zza = zzabv.zza(blob, 0, blob.length);
                    zzace com_google_android_gms_internal_measurement_zzkn = new zzkn();
                    try {
                        com_google_android_gms_internal_measurement_zzkn.zzb(zza);
                        Pair<zzkn, Long> create = Pair.create(com_google_android_gms_internal_measurement_zzkn, valueOf);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return create;
                    } catch (IOException e2) {
                        zzge().zzim().zzd("Failed to merge main event. appId, eventId", zzfg.zzbm(str), l, e2);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return null;
                    }
                }
                zzge().zzit().log("Main event not found");
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    zzge().zzim().zzg("Error selecting main event", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            rawQuery = null;
            zzge().zzim().zzg("Error selecting main event", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final zzej zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Object e;
        Throwable th;
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        String[] strArr = new String[]{str};
        zzej com_google_android_gms_internal_measurement_zzej = new zzej();
        Cursor cursor = null;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            SQLiteDatabase sQLiteDatabase = writableDatabase;
            Cursor query = sQLiteDatabase.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    if (query.getLong(0) == j) {
                        com_google_android_gms_internal_measurement_zzej.zzafe = query.getLong(1);
                        com_google_android_gms_internal_measurement_zzej.zzafd = query.getLong(2);
                        com_google_android_gms_internal_measurement_zzej.zzaff = query.getLong(3);
                        com_google_android_gms_internal_measurement_zzej.zzafg = query.getLong(4);
                        com_google_android_gms_internal_measurement_zzej.zzafh = query.getLong(5);
                    }
                    if (z) {
                        com_google_android_gms_internal_measurement_zzej.zzafe++;
                    }
                    if (z2) {
                        com_google_android_gms_internal_measurement_zzej.zzafd++;
                    }
                    if (z3) {
                        com_google_android_gms_internal_measurement_zzej.zzaff++;
                    }
                    if (z4) {
                        com_google_android_gms_internal_measurement_zzej.zzafg++;
                    }
                    if (z5) {
                        com_google_android_gms_internal_measurement_zzej.zzafh++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(com_google_android_gms_internal_measurement_zzej.zzafd));
                    contentValues.put("daily_events_count", Long.valueOf(com_google_android_gms_internal_measurement_zzej.zzafe));
                    contentValues.put("daily_conversions_count", Long.valueOf(com_google_android_gms_internal_measurement_zzej.zzaff));
                    contentValues.put("daily_error_events_count", Long.valueOf(com_google_android_gms_internal_measurement_zzej.zzafg));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(com_google_android_gms_internal_measurement_zzej.zzafh));
                    writableDatabase.update("apps", contentValues, "app_id=?", strArr);
                    if (query != null) {
                        query.close();
                    }
                    return com_google_android_gms_internal_measurement_zzej;
                }
                zzge().zzip().zzg("Not updating daily counts, app is not known. appId", zzfg.zzbm(str));
                if (query != null) {
                    query.close();
                }
                return com_google_android_gms_internal_measurement_zzej;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    zzge().zzim().zze("Error updating daily counts. appId", zzfg.zzbm(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return com_google_android_gms_internal_measurement_zzej;
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            zzge().zzim().zze("Error updating daily counts. appId", zzfg.zzbm(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return com_google_android_gms_internal_measurement_zzej;
        }
    }

    @WorkerThread
    public final void zza(zzdy com_google_android_gms_internal_measurement_zzdy) {
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzdy);
        zzab();
        zzch();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_internal_measurement_zzdy.zzah());
        contentValues.put("app_instance_id", com_google_android_gms_internal_measurement_zzdy.getAppInstanceId());
        contentValues.put("gmp_app_id", com_google_android_gms_internal_measurement_zzdy.getGmpAppId());
        contentValues.put("resettable_device_id_hash", com_google_android_gms_internal_measurement_zzdy.zzgi());
        contentValues.put("last_bundle_index", Long.valueOf(com_google_android_gms_internal_measurement_zzdy.zzgq()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(com_google_android_gms_internal_measurement_zzdy.zzgk()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(com_google_android_gms_internal_measurement_zzdy.zzgl()));
        contentValues.put("app_version", com_google_android_gms_internal_measurement_zzdy.zzag());
        contentValues.put("app_store", com_google_android_gms_internal_measurement_zzdy.zzgn());
        contentValues.put("gmp_version", Long.valueOf(com_google_android_gms_internal_measurement_zzdy.zzgo()));
        contentValues.put("dev_cert_hash", Long.valueOf(com_google_android_gms_internal_measurement_zzdy.zzgp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(com_google_android_gms_internal_measurement_zzdy.isMeasurementEnabled()));
        contentValues.put("day", Long.valueOf(com_google_android_gms_internal_measurement_zzdy.zzgu()));
        contentValues.put("daily_public_events_count", Long.valueOf(com_google_android_gms_internal_measurement_zzdy.zzgv()));
        contentValues.put("daily_events_count", Long.valueOf(com_google_android_gms_internal_measurement_zzdy.zzgw()));
        contentValues.put("daily_conversions_count", Long.valueOf(com_google_android_gms_internal_measurement_zzdy.zzgx()));
        contentValues.put("config_fetched_time", Long.valueOf(com_google_android_gms_internal_measurement_zzdy.zzgr()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(com_google_android_gms_internal_measurement_zzdy.zzgs()));
        contentValues.put("app_version_int", Long.valueOf(com_google_android_gms_internal_measurement_zzdy.zzgm()));
        contentValues.put("firebase_instance_id", com_google_android_gms_internal_measurement_zzdy.zzgj());
        contentValues.put("daily_error_events_count", Long.valueOf(com_google_android_gms_internal_measurement_zzdy.zzgz()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(com_google_android_gms_internal_measurement_zzdy.zzgy()));
        contentValues.put("health_monitor_sample", com_google_android_gms_internal_measurement_zzdy.zzha());
        contentValues.put("android_id", Long.valueOf(com_google_android_gms_internal_measurement_zzdy.zzhc()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(com_google_android_gms_internal_measurement_zzdy.zzhd()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(com_google_android_gms_internal_measurement_zzdy.zzhe()));
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (((long) writableDatabase.update("apps", contentValues, "app_id = ?", new String[]{com_google_android_gms_internal_measurement_zzdy.zzah()})) == 0 && writableDatabase.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update app (got -1). appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzdy.zzah()));
            }
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error storing app. appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzdy.zzah()), e);
        }
    }

    @WorkerThread
    public final void zza(zzeq com_google_android_gms_internal_measurement_zzeq) {
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzeq);
        zzab();
        zzch();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_internal_measurement_zzeq.zzti);
        contentValues.put("name", com_google_android_gms_internal_measurement_zzeq.name);
        contentValues.put("lifetime_count", Long.valueOf(com_google_android_gms_internal_measurement_zzeq.zzafr));
        contentValues.put("current_bundle_count", Long.valueOf(com_google_android_gms_internal_measurement_zzeq.zzafs));
        contentValues.put("last_fire_timestamp", Long.valueOf(com_google_android_gms_internal_measurement_zzeq.zzaft));
        contentValues.put("last_bundled_timestamp", Long.valueOf(com_google_android_gms_internal_measurement_zzeq.zzafu));
        contentValues.put("last_sampled_complex_event_id", com_google_android_gms_internal_measurement_zzeq.zzafv);
        contentValues.put("last_sampling_rate", com_google_android_gms_internal_measurement_zzeq.zzafw);
        Long valueOf = (com_google_android_gms_internal_measurement_zzeq.zzafx == null || !com_google_android_gms_internal_measurement_zzeq.zzafx.booleanValue()) ? null : Long.valueOf(1);
        contentValues.put("last_exempt_from_sampling", valueOf);
        try {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update event aggregates (got -1). appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzeq.zzti));
            }
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error storing event aggregates. appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzeq.zzti), e);
        }
    }

    @WorkerThread
    final void zza(String str, zzkd[] com_google_android_gms_internal_measurement_zzkdArr) {
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzkdArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            zzch();
            zzab();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase writableDatabase2 = getWritableDatabase();
            String[] strArr = new String[1];
            int i = 0;
            strArr[0] = str;
            writableDatabase2.delete("property_filters", "app_id=?", strArr);
            writableDatabase2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzkd com_google_android_gms_internal_measurement_zzkd : com_google_android_gms_internal_measurement_zzkdArr) {
                zzch();
                zzab();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzkd);
                Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzkd.zzarn);
                Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzkd.zzarm);
                if (com_google_android_gms_internal_measurement_zzkd.zzarl == null) {
                    zzge().zzip().zzg("Audience with no ID. appId", zzfg.zzbm(str));
                } else {
                    zzfi zzip;
                    String str2;
                    Object zzbm;
                    Object obj;
                    int i2;
                    int intValue = com_google_android_gms_internal_measurement_zzkd.zzarl.intValue();
                    for (zzke com_google_android_gms_internal_measurement_zzke : com_google_android_gms_internal_measurement_zzkd.zzarn) {
                        if (com_google_android_gms_internal_measurement_zzke.zzarp == null) {
                            zzip = zzge().zzip();
                            str2 = "Event filter with no ID. Audience definition ignored. appId, audienceId";
                            zzbm = zzfg.zzbm(str);
                            obj = com_google_android_gms_internal_measurement_zzkd.zzarl;
                            break;
                        }
                    }
                    for (zzkh com_google_android_gms_internal_measurement_zzkh : com_google_android_gms_internal_measurement_zzkd.zzarm) {
                        if (com_google_android_gms_internal_measurement_zzkh.zzarp == null) {
                            zzip = zzge().zzip();
                            str2 = "Property filter with no ID. Audience definition ignored. appId, audienceId";
                            zzbm = zzfg.zzbm(str);
                            obj = com_google_android_gms_internal_measurement_zzkd.zzarl;
                            zzip.zze(str2, zzbm, obj);
                            break;
                        }
                    }
                    for (zzke com_google_android_gms_internal_measurement_zzke2 : com_google_android_gms_internal_measurement_zzkd.zzarn) {
                        if (!zza(str, intValue, com_google_android_gms_internal_measurement_zzke2)) {
                            i2 = 0;
                            break;
                        }
                    }
                    i2 = 1;
                    if (i2 != 0) {
                        for (zzkh com_google_android_gms_internal_measurement_zzkh2 : com_google_android_gms_internal_measurement_zzkd.zzarm) {
                            if (!zza(str, intValue, com_google_android_gms_internal_measurement_zzkh2)) {
                                i2 = 0;
                                break;
                            }
                        }
                    }
                    if (i2 == 0) {
                        zzch();
                        zzab();
                        Preconditions.checkNotEmpty(str);
                        SQLiteDatabase writableDatabase3 = getWritableDatabase();
                        writableDatabase3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                        writableDatabase3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                    }
                }
            }
            List arrayList = new ArrayList();
            int length = com_google_android_gms_internal_measurement_zzkdArr.length;
            while (i < length) {
                arrayList.add(com_google_android_gms_internal_measurement_zzkdArr[i].zzarl);
                i++;
            }
            zza(str, arrayList);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @WorkerThread
    public final boolean zza(zzed com_google_android_gms_internal_measurement_zzed) {
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzed);
        zzab();
        zzch();
        if (zzh(com_google_android_gms_internal_measurement_zzed.packageName, com_google_android_gms_internal_measurement_zzed.zzaep.name) == null) {
            if (zza("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{com_google_android_gms_internal_measurement_zzed.packageName}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_internal_measurement_zzed.packageName);
        contentValues.put(Param.ORIGIN, com_google_android_gms_internal_measurement_zzed.origin);
        contentValues.put("name", com_google_android_gms_internal_measurement_zzed.zzaep.name);
        zza(contentValues, Param.VALUE, com_google_android_gms_internal_measurement_zzed.zzaep.getValue());
        contentValues.put("active", Boolean.valueOf(com_google_android_gms_internal_measurement_zzed.active));
        contentValues.put("trigger_event_name", com_google_android_gms_internal_measurement_zzed.triggerEventName);
        contentValues.put("trigger_timeout", Long.valueOf(com_google_android_gms_internal_measurement_zzed.triggerTimeout));
        zzgb();
        contentValues.put("timed_out_event", zzka.zza(com_google_android_gms_internal_measurement_zzed.zzaeq));
        contentValues.put("creation_timestamp", Long.valueOf(com_google_android_gms_internal_measurement_zzed.creationTimestamp));
        zzgb();
        contentValues.put("triggered_event", zzka.zza(com_google_android_gms_internal_measurement_zzed.zzaer));
        contentValues.put("triggered_timestamp", Long.valueOf(com_google_android_gms_internal_measurement_zzed.zzaep.zzaqz));
        contentValues.put("time_to_live", Long.valueOf(com_google_android_gms_internal_measurement_zzed.timeToLive));
        zzgb();
        contentValues.put("expired_event", zzka.zza(com_google_android_gms_internal_measurement_zzed.zzaes));
        try {
            if (getWritableDatabase().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update conditional user property (got -1)", zzfg.zzbm(com_google_android_gms_internal_measurement_zzed.packageName));
            }
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error storing conditional user property", zzfg.zzbm(com_google_android_gms_internal_measurement_zzed.packageName), e);
        }
        return true;
    }

    public final boolean zza(zzep com_google_android_gms_internal_measurement_zzep, long j, boolean z) {
        Object e;
        zzfi zzim;
        String str;
        zzab();
        zzch();
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzep);
        Preconditions.checkNotEmpty(com_google_android_gms_internal_measurement_zzep.zzti);
        zzace com_google_android_gms_internal_measurement_zzkn = new zzkn();
        com_google_android_gms_internal_measurement_zzkn.zzatc = Long.valueOf(com_google_android_gms_internal_measurement_zzep.zzafp);
        com_google_android_gms_internal_measurement_zzkn.zzata = new zzko[com_google_android_gms_internal_measurement_zzep.zzafq.size()];
        Iterator it = com_google_android_gms_internal_measurement_zzep.zzafq.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str2 = (String) it.next();
            zzko com_google_android_gms_internal_measurement_zzko = new zzko();
            int i2 = i + 1;
            com_google_android_gms_internal_measurement_zzkn.zzata[i] = com_google_android_gms_internal_measurement_zzko;
            com_google_android_gms_internal_measurement_zzko.name = str2;
            zzgb().zza(com_google_android_gms_internal_measurement_zzko, com_google_android_gms_internal_measurement_zzep.zzafq.get(str2));
            i = i2;
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_measurement_zzkn.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            com_google_android_gms_internal_measurement_zzkn.zza(zzb);
            zzb.zzve();
            zzge().zzit().zze("Saving event, name, data size", zzga().zzbj(com_google_android_gms_internal_measurement_zzep.name), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_google_android_gms_internal_measurement_zzep.zzti);
            contentValues.put("name", com_google_android_gms_internal_measurement_zzep.name);
            contentValues.put(AppMeasurement.Param.TIMESTAMP, Long.valueOf(com_google_android_gms_internal_measurement_zzep.timestamp));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put(DataBufferSafeParcelable.DATA_FIELD, bArr);
            contentValues.put("realtime", Integer.valueOf(z));
            try {
                if (getWritableDatabase().insert("raw_events", null, contentValues) != -1) {
                    return true;
                }
                zzge().zzim().zzg("Failed to insert raw event (got -1). appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzep.zzti));
                return false;
            } catch (SQLiteException e2) {
                e = e2;
                zzim = zzge().zzim();
                str = "Error storing raw event. appId";
                zzim.zze(str, zzfg.zzbm(com_google_android_gms_internal_measurement_zzep.zzti), e);
                return false;
            }
        } catch (IOException e3) {
            e = e3;
            zzim = zzge().zzim();
            str = "Data loss. Failed to serialize event params/data. appId";
            zzim.zze(str, zzfg.zzbm(com_google_android_gms_internal_measurement_zzep.zzti), e);
            return false;
        }
    }

    @WorkerThread
    public final boolean zza(zzjz com_google_android_gms_internal_measurement_zzjz) {
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzjz);
        zzab();
        zzch();
        if (zzh(com_google_android_gms_internal_measurement_zzjz.zzti, com_google_android_gms_internal_measurement_zzjz.name) == null) {
            if (zzka.zzcc(com_google_android_gms_internal_measurement_zzjz.name)) {
                if (zza("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{com_google_android_gms_internal_measurement_zzjz.zzti}) >= 25) {
                    return false;
                }
            }
            if (zza("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{com_google_android_gms_internal_measurement_zzjz.zzti, com_google_android_gms_internal_measurement_zzjz.origin}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_internal_measurement_zzjz.zzti);
        contentValues.put(Param.ORIGIN, com_google_android_gms_internal_measurement_zzjz.origin);
        contentValues.put("name", com_google_android_gms_internal_measurement_zzjz.name);
        contentValues.put("set_timestamp", Long.valueOf(com_google_android_gms_internal_measurement_zzjz.zzaqz));
        zza(contentValues, Param.VALUE, com_google_android_gms_internal_measurement_zzjz.value);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update user property (got -1). appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzjz.zzti));
            }
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error storing user property. appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzjz.zzti), e);
        }
        return true;
    }

    @WorkerThread
    public final boolean zza(zzkq com_google_android_gms_internal_measurement_zzkq, boolean z) {
        Object e;
        zzfi zzim;
        String str;
        zzab();
        zzch();
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzkq);
        Preconditions.checkNotEmpty(com_google_android_gms_internal_measurement_zzkq.zzti);
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzkq.zzatm);
        zzhp();
        long currentTimeMillis = zzbt().currentTimeMillis();
        if (com_google_android_gms_internal_measurement_zzkq.zzatm.longValue() < currentTimeMillis - zzef.zzhh() || com_google_android_gms_internal_measurement_zzkq.zzatm.longValue() > currentTimeMillis + zzef.zzhh()) {
            zzge().zzip().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzfg.zzbm(com_google_android_gms_internal_measurement_zzkq.zzti), Long.valueOf(currentTimeMillis), com_google_android_gms_internal_measurement_zzkq.zzatm);
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_measurement_zzkq.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            com_google_android_gms_internal_measurement_zzkq.zza(zzb);
            zzb.zzve();
            bArr = zzgb().zza(bArr);
            zzge().zzit().zzg("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_google_android_gms_internal_measurement_zzkq.zzti);
            contentValues.put("bundle_end_timestamp", com_google_android_gms_internal_measurement_zzkq.zzatm);
            contentValues.put(DataBufferSafeParcelable.DATA_FIELD, bArr);
            contentValues.put("has_realtime", Integer.valueOf(z));
            if (com_google_android_gms_internal_measurement_zzkq.zzauj != null) {
                contentValues.put("retry_count", com_google_android_gms_internal_measurement_zzkq.zzauj);
            }
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzge().zzim().zzg("Failed to insert bundle (got -1). appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzkq.zzti));
                return false;
            } catch (SQLiteException e2) {
                e = e2;
                zzim = zzge().zzim();
                str = "Error storing bundle. appId";
                zzim.zze(str, zzfg.zzbm(com_google_android_gms_internal_measurement_zzkq.zzti), e);
                return false;
            }
        } catch (IOException e3) {
            e = e3;
            zzim = zzge().zzim();
            str = "Data loss. Failed to serialize bundle. appId";
            zzim.zze(str, zzfg.zzbm(com_google_android_gms_internal_measurement_zzkq.zzti), e);
            return false;
        }
    }

    public final boolean zza(String str, Long l, long j, zzkn com_google_android_gms_internal_measurement_zzkn) {
        zzab();
        zzch();
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzkn);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_measurement_zzkn.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            com_google_android_gms_internal_measurement_zzkn.zza(zzb);
            zzb.zzve();
            zzge().zzit().zze("Saving complex main event, appId, data size", zzga().zzbj(str), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("event_id", l);
            contentValues.put("children_to_process", Long.valueOf(j));
            contentValues.put("main_event", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                    return true;
                }
                zzge().zzim().zzg("Failed to insert complex main event (got -1). appId", zzfg.zzbm(str));
                return false;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing complex main event. appId", zzfg.zzbm(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzge().zzim().zzd("Data loss. Failed to serialize event params/data. appId, eventId", zzfg.zzbm(str), l, e2);
            return false;
        }
    }

    public final String zzab(long j) {
        Object e;
        Throwable th;
        zzab();
        zzch();
        Cursor rawQuery;
        try {
            rawQuery = getWritableDatabase().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (rawQuery.moveToFirst()) {
                    String string = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return string;
                }
                zzge().zzit().log("No expired configs for apps with pending events");
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzge().zzim().zzg("Error selecting expired configs", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            zzge().zzim().zzg("Error selecting expired configs", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final List<Pair<zzkq, Long>> zzb(String str, int i, int i2) {
        Cursor query;
        Object e;
        zzfi zzim;
        String str2;
        Object zzbm;
        Object e2;
        Throwable th;
        zzab();
        zzch();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            query = getWritableDatabase().query("queue", new String[]{"rowid", DataBufferSafeParcelable.DATA_FIELD, "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (query.moveToFirst()) {
                    List<Pair<zzkq, Long>> arrayList = new ArrayList();
                    int i3 = 0;
                    do {
                        long j = query.getLong(0);
                        try {
                            byte[] zzb = zzgb().zzb(query.getBlob(1));
                            if (!arrayList.isEmpty() && zzb.length + i3 > i2) {
                                break;
                            }
                            zzabv zza = zzabv.zza(zzb, 0, zzb.length);
                            zzace com_google_android_gms_internal_measurement_zzkq = new zzkq();
                            try {
                                com_google_android_gms_internal_measurement_zzkq.zzb(zza);
                                if (!query.isNull(2)) {
                                    com_google_android_gms_internal_measurement_zzkq.zzauj = Integer.valueOf(query.getInt(2));
                                }
                                i3 += zzb.length;
                                arrayList.add(Pair.create(com_google_android_gms_internal_measurement_zzkq, Long.valueOf(j)));
                            } catch (IOException e3) {
                                e = e3;
                                zzim = zzge().zzim();
                                str2 = "Failed to merge queued bundle. appId";
                                zzbm = zzfg.zzbm(str);
                                zzim.zze(str2, zzbm, e);
                                if (query.moveToNext()) {
                                    break;
                                } else if (i3 > i2) {
                                }
                                if (query != null) {
                                    query.close();
                                }
                                return arrayList;
                            }
                            if (query.moveToNext()) {
                                break;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            zzim = zzge().zzim();
                            str2 = "Failed to unzip queued bundle. appId";
                            zzbm = zzfg.zzbm(str);
                            zzim.zze(str2, zzbm, e);
                            if (query.moveToNext()) {
                                break;
                            } else if (i3 > i2) {
                            }
                            if (query != null) {
                                query.close();
                            }
                            return arrayList;
                        }
                    } while (i3 > i2);
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                List<Pair<zzkq, Long>> emptyList = Collections.emptyList();
                if (query != null) {
                    query.close();
                }
                return emptyList;
            } catch (SQLiteException e5) {
                e2 = e5;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e6) {
            e2 = e6;
            try {
                zzge().zzim().zze("Error querying bundles. appId", zzfg.zzbm(str), e2);
                List<Pair<zzkq, Long>> emptyList2 = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList2;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.WorkerThread
    public final java.util.List<com.google.android.gms.internal.measurement.zzjz> zzb(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
        r21 = this;
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r22);
        r21.zzab();
        r21.zzch();
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
        r2 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0105, all -> 0x0101 }
        r3 = 3;
        r2.<init>(r3);	 Catch:{ SQLiteException -> 0x0105, all -> 0x0101 }
        r11 = r22;
        r2.add(r11);	 Catch:{ SQLiteException -> 0x00fd, all -> 0x0101 }
        r4 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x00fd, all -> 0x0101 }
        r5 = "app_id=?";
        r4.<init>(r5);	 Catch:{ SQLiteException -> 0x00fd, all -> 0x0101 }
        r5 = android.text.TextUtils.isEmpty(r23);	 Catch:{ SQLiteException -> 0x00fd, all -> 0x0101 }
        if (r5 != 0) goto L_0x0037;
    L_0x0027:
        r5 = r23;
        r2.add(r5);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r6 = " and origin=?";
        r4.append(r6);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        goto L_0x0039;
    L_0x0032:
        r0 = move-exception;
        r12 = r21;
        goto L_0x010c;
    L_0x0037:
        r5 = r23;
    L_0x0039:
        r6 = android.text.TextUtils.isEmpty(r24);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        if (r6 != 0) goto L_0x0051;
    L_0x003f:
        r6 = java.lang.String.valueOf(r24);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r7 = "*";
        r6 = r6.concat(r7);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r2.add(r6);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r6 = " and name glob ?";
        r4.append(r6);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
    L_0x0051:
        r6 = r2.size();	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r6 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r2 = r2.toArray(r6);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r16 = r2;
        r16 = (java.lang.String[]) r16;	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r12 = r21.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r13 = "user_attributes";
        r2 = "name";
        r6 = "set_timestamp";
        r7 = "value";
        r8 = "origin";
        r14 = new java.lang.String[]{r2, r6, r7, r8};	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r15 = r4.toString();	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r17 = 0;
        r18 = 0;
        r19 = "rowid";
        r20 = "1001";
        r2 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r4 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x00f9, all -> 0x00f5 }
        if (r4 != 0) goto L_0x008d;
    L_0x0087:
        if (r2 == 0) goto L_0x008c;
    L_0x0089:
        r2.close();
    L_0x008c:
        return r0;
    L_0x008d:
        r4 = r0.size();	 Catch:{ SQLiteException -> 0x00f9, all -> 0x00f5 }
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r4 < r6) goto L_0x00a9;
    L_0x0095:
        r3 = r21.zzge();	 Catch:{ SQLiteException -> 0x00f9, all -> 0x00f5 }
        r3 = r3.zzim();	 Catch:{ SQLiteException -> 0x00f9, all -> 0x00f5 }
        r4 = "Read more than the max allowed user properties, ignoring excess";
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ SQLiteException -> 0x00f9, all -> 0x00f5 }
        r3.zzg(r4, r6);	 Catch:{ SQLiteException -> 0x00f9, all -> 0x00f5 }
        r12 = r21;
        goto L_0x00eb;
    L_0x00a9:
        r4 = 0;
        r7 = r2.getString(r4);	 Catch:{ SQLiteException -> 0x00f9, all -> 0x00f5 }
        r4 = 1;
        r8 = r2.getLong(r4);	 Catch:{ SQLiteException -> 0x00f9, all -> 0x00f5 }
        r4 = 2;
        r12 = r21;
        r10 = r12.zza(r2, r4);	 Catch:{ SQLiteException -> 0x00f3 }
        r13 = r2.getString(r3);	 Catch:{ SQLiteException -> 0x00f3 }
        if (r10 != 0) goto L_0x00d7;
    L_0x00c0:
        r4 = r21.zzge();	 Catch:{ SQLiteException -> 0x00d4 }
        r4 = r4.zzim();	 Catch:{ SQLiteException -> 0x00d4 }
        r5 = "(2)Read invalid user property value, ignoring it";
        r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r22);	 Catch:{ SQLiteException -> 0x00d4 }
        r14 = r24;
        r4.zzd(r5, r6, r13, r14);	 Catch:{ SQLiteException -> 0x00d4 }
        goto L_0x00e5;
    L_0x00d4:
        r0 = move-exception;
        r5 = r13;
        goto L_0x010d;
    L_0x00d7:
        r14 = r24;
        r15 = new com.google.android.gms.internal.measurement.zzjz;	 Catch:{ SQLiteException -> 0x00d4 }
        r4 = r15;
        r5 = r22;
        r6 = r13;
        r4.<init>(r5, r6, r7, r8, r10);	 Catch:{ SQLiteException -> 0x00d4 }
        r0.add(r15);	 Catch:{ SQLiteException -> 0x00d4 }
    L_0x00e5:
        r4 = r2.moveToNext();	 Catch:{ SQLiteException -> 0x00d4 }
        if (r4 != 0) goto L_0x00f1;
    L_0x00eb:
        if (r2 == 0) goto L_0x00f0;
    L_0x00ed:
        r2.close();
    L_0x00f0:
        return r0;
    L_0x00f1:
        r5 = r13;
        goto L_0x008d;
    L_0x00f3:
        r0 = move-exception;
        goto L_0x010d;
    L_0x00f5:
        r0 = move-exception;
        r12 = r21;
        goto L_0x0125;
    L_0x00f9:
        r0 = move-exception;
        r12 = r21;
        goto L_0x010d;
    L_0x00fd:
        r0 = move-exception;
        r12 = r21;
        goto L_0x010a;
    L_0x0101:
        r0 = move-exception;
        r12 = r21;
        goto L_0x0126;
    L_0x0105:
        r0 = move-exception;
        r12 = r21;
        r11 = r22;
    L_0x010a:
        r5 = r23;
    L_0x010c:
        r2 = r1;
    L_0x010d:
        r3 = r21.zzge();	 Catch:{ all -> 0x0124 }
        r3 = r3.zzim();	 Catch:{ all -> 0x0124 }
        r4 = "(2)Error querying user properties";
        r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r22);	 Catch:{ all -> 0x0124 }
        r3.zzd(r4, r6, r5, r0);	 Catch:{ all -> 0x0124 }
        if (r2 == 0) goto L_0x0123;
    L_0x0120:
        r2.close();
    L_0x0123:
        return r1;
    L_0x0124:
        r0 = move-exception;
    L_0x0125:
        r1 = r2;
    L_0x0126:
        if (r1 == 0) goto L_0x012b;
    L_0x0128:
        r1.close();
    L_0x012b:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzb(java.lang.String, java.lang.String, java.lang.String):java.util.List<com.google.android.gms.internal.measurement.zzjz>");
    }

    public final List<zzed> zzb(String str, String[] strArr) {
        Object e;
        Throwable th;
        zzab();
        zzch();
        List<zzed> arrayList = new ArrayList();
        Cursor cursor = null;
        Cursor query;
        try {
            query = getWritableDatabase().query("conditional_properties", new String[]{"app_id", Param.ORIGIN, "name", Param.VALUE, "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
            try {
                if (query.moveToFirst()) {
                    do {
                        if (arrayList.size() >= 1000) {
                            zzge().zzim().zzg("Read more than the max allowed conditional properties, ignoring extra", Integer.valueOf(1000));
                            break;
                        }
                        boolean z = false;
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        String string3 = query.getString(2);
                        Object zza = zza(query, 3);
                        if (query.getInt(4) != 0) {
                            z = true;
                        }
                        String string4 = query.getString(5);
                        long j = query.getLong(6);
                        zzeu com_google_android_gms_internal_measurement_zzeu = (zzeu) zzgb().zza(query.getBlob(7), zzeu.CREATOR);
                        long j2 = query.getLong(8);
                        zzeu com_google_android_gms_internal_measurement_zzeu2 = (zzeu) zzgb().zza(query.getBlob(9), zzeu.CREATOR);
                        long j3 = query.getLong(10);
                        long j4 = query.getLong(11);
                        zzeu com_google_android_gms_internal_measurement_zzeu3 = (zzeu) zzgb().zza(query.getBlob(12), zzeu.CREATOR);
                        zzjx com_google_android_gms_internal_measurement_zzjx = new zzjx(string3, j3, zza, string2);
                        boolean z2 = z;
                        zzed com_google_android_gms_internal_measurement_zzed = r3;
                        zzed com_google_android_gms_internal_measurement_zzed2 = new zzed(string, string2, com_google_android_gms_internal_measurement_zzjx, j2, z2, string4, com_google_android_gms_internal_measurement_zzeu, j, com_google_android_gms_internal_measurement_zzeu2, j4, com_google_android_gms_internal_measurement_zzeu3);
                        arrayList.add(com_google_android_gms_internal_measurement_zzed);
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            try {
                zzge().zzim().zzg("Error querying conditional user property value", e);
                arrayList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
    }

    @WorkerThread
    public final List<zzjz> zzbb(String str) {
        Object e;
        Throwable th;
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        List<zzjz> arrayList = new ArrayList();
        Cursor query;
        try {
            query = getWritableDatabase().query("user_attributes", new String[]{"name", Param.ORIGIN, "set_timestamp", Param.VALUE}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str2 = string2;
                        long j = query.getLong(2);
                        Object zza = zza(query, 3);
                        if (zza == null) {
                            zzge().zzim().zzg("Read invalid user property value, ignoring it. appId", zzfg.zzbm(str));
                        } else {
                            arrayList.add(new zzjz(str, str2, string, j, zza));
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            try {
                zzge().zzim().zze("Error querying user properties. appId", zzfg.zzbm(str), e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final zzdy zzbc(String str) {
        Object e;
        Throwable th;
        zzei com_google_android_gms_internal_measurement_zzei;
        String str2 = str;
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        Cursor query;
        try {
            boolean z = true;
            query = getWritableDatabase().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "ssaid_reporting_enabled"}, "app_id=?", new String[]{str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    try {
                        boolean z2;
                        zzdy com_google_android_gms_internal_measurement_zzdy = new zzdy(this.zzajp.zzla(), str2);
                        com_google_android_gms_internal_measurement_zzdy.zzal(query.getString(0));
                        com_google_android_gms_internal_measurement_zzdy.zzam(query.getString(1));
                        com_google_android_gms_internal_measurement_zzdy.zzan(query.getString(2));
                        com_google_android_gms_internal_measurement_zzdy.zzr(query.getLong(3));
                        com_google_android_gms_internal_measurement_zzdy.zzm(query.getLong(4));
                        com_google_android_gms_internal_measurement_zzdy.zzn(query.getLong(5));
                        com_google_android_gms_internal_measurement_zzdy.setAppVersion(query.getString(6));
                        com_google_android_gms_internal_measurement_zzdy.zzap(query.getString(7));
                        com_google_android_gms_internal_measurement_zzdy.zzp(query.getLong(8));
                        com_google_android_gms_internal_measurement_zzdy.zzq(query.getLong(9));
                        if (!query.isNull(10)) {
                            if (query.getInt(10) == 0) {
                                z2 = false;
                                com_google_android_gms_internal_measurement_zzdy.setMeasurementEnabled(z2);
                                com_google_android_gms_internal_measurement_zzdy.zzu(query.getLong(11));
                                com_google_android_gms_internal_measurement_zzdy.zzv(query.getLong(12));
                                com_google_android_gms_internal_measurement_zzdy.zzw(query.getLong(13));
                                com_google_android_gms_internal_measurement_zzdy.zzx(query.getLong(14));
                                com_google_android_gms_internal_measurement_zzdy.zzs(query.getLong(15));
                                com_google_android_gms_internal_measurement_zzdy.zzt(query.getLong(16));
                                com_google_android_gms_internal_measurement_zzdy.zzo(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                                com_google_android_gms_internal_measurement_zzdy.zzao(query.getString(18));
                                com_google_android_gms_internal_measurement_zzdy.zzz(query.getLong(19));
                                com_google_android_gms_internal_measurement_zzdy.zzy(query.getLong(20));
                                com_google_android_gms_internal_measurement_zzdy.zzaq(query.getString(21));
                                com_google_android_gms_internal_measurement_zzdy.zzaa(query.isNull(22) ? 0 : query.getLong(22));
                                if (!query.isNull(23)) {
                                    if (query.getInt(23) != 0) {
                                        z2 = false;
                                        com_google_android_gms_internal_measurement_zzdy.zzd(z2);
                                        if (!query.isNull(24)) {
                                            if (query.getInt(24) == 0) {
                                                z = false;
                                            }
                                        }
                                        com_google_android_gms_internal_measurement_zzdy.zze(z);
                                        com_google_android_gms_internal_measurement_zzdy.zzgh();
                                        if (query.moveToNext()) {
                                            zzge().zzim().zzg("Got multiple records for app, expected one. appId", zzfg.zzbm(str));
                                        }
                                        if (query != null) {
                                            query.close();
                                        }
                                        return com_google_android_gms_internal_measurement_zzdy;
                                    }
                                }
                                z2 = true;
                                com_google_android_gms_internal_measurement_zzdy.zzd(z2);
                                if (query.isNull(24)) {
                                    if (query.getInt(24) == 0) {
                                        z = false;
                                    }
                                }
                                com_google_android_gms_internal_measurement_zzdy.zze(z);
                                com_google_android_gms_internal_measurement_zzdy.zzgh();
                                if (query.moveToNext()) {
                                    zzge().zzim().zzg("Got multiple records for app, expected one. appId", zzfg.zzbm(str));
                                }
                                if (query != null) {
                                    query.close();
                                }
                                return com_google_android_gms_internal_measurement_zzdy;
                            }
                        }
                        z2 = true;
                        com_google_android_gms_internal_measurement_zzdy.setMeasurementEnabled(z2);
                        com_google_android_gms_internal_measurement_zzdy.zzu(query.getLong(11));
                        com_google_android_gms_internal_measurement_zzdy.zzv(query.getLong(12));
                        com_google_android_gms_internal_measurement_zzdy.zzw(query.getLong(13));
                        com_google_android_gms_internal_measurement_zzdy.zzx(query.getLong(14));
                        com_google_android_gms_internal_measurement_zzdy.zzs(query.getLong(15));
                        com_google_android_gms_internal_measurement_zzdy.zzt(query.getLong(16));
                        if (query.isNull(17)) {
                        }
                        com_google_android_gms_internal_measurement_zzdy.zzo(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                        com_google_android_gms_internal_measurement_zzdy.zzao(query.getString(18));
                        com_google_android_gms_internal_measurement_zzdy.zzz(query.getLong(19));
                        com_google_android_gms_internal_measurement_zzdy.zzy(query.getLong(20));
                        com_google_android_gms_internal_measurement_zzdy.zzaq(query.getString(21));
                        if (query.isNull(22)) {
                        }
                        com_google_android_gms_internal_measurement_zzdy.zzaa(query.isNull(22) ? 0 : query.getLong(22));
                        if (query.isNull(23)) {
                            if (query.getInt(23) != 0) {
                                z2 = false;
                                com_google_android_gms_internal_measurement_zzdy.zzd(z2);
                                if (query.isNull(24)) {
                                    if (query.getInt(24) == 0) {
                                        z = false;
                                    }
                                }
                                com_google_android_gms_internal_measurement_zzdy.zze(z);
                                com_google_android_gms_internal_measurement_zzdy.zzgh();
                                if (query.moveToNext()) {
                                    zzge().zzim().zzg("Got multiple records for app, expected one. appId", zzfg.zzbm(str));
                                }
                                if (query != null) {
                                    query.close();
                                }
                                return com_google_android_gms_internal_measurement_zzdy;
                            }
                        }
                        z2 = true;
                        com_google_android_gms_internal_measurement_zzdy.zzd(z2);
                        if (query.isNull(24)) {
                            if (query.getInt(24) == 0) {
                                z = false;
                            }
                        }
                        com_google_android_gms_internal_measurement_zzdy.zze(z);
                        com_google_android_gms_internal_measurement_zzdy.zzgh();
                        if (query.moveToNext()) {
                            zzge().zzim().zzg("Got multiple records for app, expected one. appId", zzfg.zzbm(str));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return com_google_android_gms_internal_measurement_zzdy;
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            zzge().zzim().zze("Error querying app. appId", zzfg.zzbm(str), e);
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                com_google_android_gms_internal_measurement_zzei = this;
                zzge().zzim().zze("Error querying app. appId", zzfg.zzbm(str), e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                com_google_android_gms_internal_measurement_zzei = this;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            com_google_android_gms_internal_measurement_zzei = this;
            query = null;
            zzge().zzim().zze("Error querying app. appId", zzfg.zzbm(str), e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            com_google_android_gms_internal_measurement_zzei = this;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final long zzbd(String str) {
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String valueOf = String.valueOf(Math.max(0, Math.min(1000000, zzgg().zzb(str, zzew.zzagx))));
            return (long) writableDatabase.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error deleting over the limit events. appId", zzfg.zzbm(str), e);
            return 0;
        }
    }

    @WorkerThread
    public final byte[] zzbe(String str) {
        Object e;
        Throwable th;
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        Cursor query;
        try {
            query = getWritableDatabase().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    byte[] blob = query.getBlob(0);
                    if (query.moveToNext()) {
                        zzge().zzim().zzg("Got multiple records for app config, expected one. appId", zzfg.zzbm(str));
                    }
                    if (query != null) {
                        query.close();
                    }
                    return blob;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzge().zzim().zze("Error querying remote config. appId", zzfg.zzbm(str), e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            zzge().zzim().zze("Error querying remote config. appId", zzfg.zzbm(str), e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzkr> zzbf(java.lang.String r12) {
        /*
        r11 = this;
        r11.zzch();
        r11.zzab();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12);
        r0 = r11.getWritableDatabase();
        r8 = 0;
        r1 = "audience_filter_values";
        r2 = "audience_id";
        r3 = "current_results";
        r2 = new java.lang.String[]{r2, r3};	 Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
        r3 = "app_id=?";
        r9 = 1;
        r4 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
        r10 = 0;
        r4[r10] = r12;	 Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
        r1 = r0.moveToFirst();	 Catch:{ SQLiteException -> 0x0077 }
        if (r1 != 0) goto L_0x0033;
    L_0x002d:
        if (r0 == 0) goto L_0x0032;
    L_0x002f:
        r0.close();
    L_0x0032:
        return r8;
    L_0x0033:
        r1 = new android.support.v4.util.ArrayMap;	 Catch:{ SQLiteException -> 0x0077 }
        r1.<init>();	 Catch:{ SQLiteException -> 0x0077 }
    L_0x0038:
        r2 = r0.getInt(r10);	 Catch:{ SQLiteException -> 0x0077 }
        r3 = r0.getBlob(r9);	 Catch:{ SQLiteException -> 0x0077 }
        r4 = r3.length;	 Catch:{ SQLiteException -> 0x0077 }
        r3 = com.google.android.gms.internal.measurement.zzabv.zza(r3, r10, r4);	 Catch:{ SQLiteException -> 0x0077 }
        r4 = new com.google.android.gms.internal.measurement.zzkr;	 Catch:{ SQLiteException -> 0x0077 }
        r4.<init>();	 Catch:{ SQLiteException -> 0x0077 }
        r4.zzb(r3);	 Catch:{ IOException -> 0x0055 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ SQLiteException -> 0x0077 }
        r1.put(r2, r4);	 Catch:{ SQLiteException -> 0x0077 }
        goto L_0x006b;
    L_0x0055:
        r3 = move-exception;
        r4 = r11.zzge();	 Catch:{ SQLiteException -> 0x0077 }
        r4 = r4.zzim();	 Catch:{ SQLiteException -> 0x0077 }
        r5 = "Failed to merge filter results. appId, audienceId, error";
        r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r12);	 Catch:{ SQLiteException -> 0x0077 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ SQLiteException -> 0x0077 }
        r4.zzd(r5, r6, r2, r3);	 Catch:{ SQLiteException -> 0x0077 }
    L_0x006b:
        r2 = r0.moveToNext();	 Catch:{ SQLiteException -> 0x0077 }
        if (r2 != 0) goto L_0x0038;
    L_0x0071:
        if (r0 == 0) goto L_0x0076;
    L_0x0073:
        r0.close();
    L_0x0076:
        return r1;
    L_0x0077:
        r1 = move-exception;
        goto L_0x007e;
    L_0x0079:
        r12 = move-exception;
        r0 = r8;
        goto L_0x0096;
    L_0x007c:
        r1 = move-exception;
        r0 = r8;
    L_0x007e:
        r2 = r11.zzge();	 Catch:{ all -> 0x0095 }
        r2 = r2.zzim();	 Catch:{ all -> 0x0095 }
        r3 = "Database error querying filter results. appId";
        r12 = com.google.android.gms.internal.measurement.zzfg.zzbm(r12);	 Catch:{ all -> 0x0095 }
        r2.zze(r3, r12, r1);	 Catch:{ all -> 0x0095 }
        if (r0 == 0) goto L_0x0094;
    L_0x0091:
        r0.close();
    L_0x0094:
        return r8;
    L_0x0095:
        r12 = move-exception;
    L_0x0096:
        if (r0 == 0) goto L_0x009b;
    L_0x0098:
        r0.close();
    L_0x009b:
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzbf(java.lang.String):java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzkr>");
    }

    public final long zzbg(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    @WorkerThread
    public final List<zzed> zzc(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        List arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder stringBuilder = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            stringBuilder.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            stringBuilder.append(" and name glob ?");
        }
        return zzb(stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @WorkerThread
    @VisibleForTesting
    final void zzc(List<Long> list) {
        zzab();
        zzch();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzhv()) {
            String join = TextUtils.join(",", list);
            StringBuilder stringBuilder = new StringBuilder(2 + String.valueOf(join).length());
            stringBuilder.append("(");
            stringBuilder.append(join);
            stringBuilder.append(")");
            join = stringBuilder.toString();
            stringBuilder = new StringBuilder(80 + String.valueOf(join).length());
            stringBuilder.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            stringBuilder.append(join);
            stringBuilder.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zza(stringBuilder.toString(), null) > 0) {
                zzge().zzip().log("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                StringBuilder stringBuilder2 = new StringBuilder(127 + String.valueOf(join).length());
                stringBuilder2.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                stringBuilder2.append(join);
                stringBuilder2.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                writableDatabase.execSQL(stringBuilder2.toString());
            } catch (SQLiteException e) {
                zzge().zzim().zzg("Error incrementing retry count. error", e);
            }
        }
    }

    @WorkerThread
    public final zzeq zzf(String str, String str2) {
        Cursor cursor;
        Object e;
        Throwable th;
        String str3 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            r5 = new String[2];
            boolean z = false;
            r5[0] = str;
            r5[1] = str3;
            Cursor query = getWritableDatabase().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"}, "app_id=? and name=?", r5, null, null, null);
            try {
                if (query.moveToFirst()) {
                    Boolean bool;
                    long j = query.getLong(0);
                    long j2 = query.getLong(1);
                    long j3 = query.getLong(2);
                    long j4 = query.isNull(3) ? 0 : query.getLong(3);
                    Long valueOf = query.isNull(4) ? null : Long.valueOf(query.getLong(4));
                    Long valueOf2 = query.isNull(5) ? null : Long.valueOf(query.getLong(5));
                    if (query.isNull(6)) {
                        bool = null;
                    } else {
                        if (query.getLong(6) == 1) {
                            z = true;
                        }
                        bool = Boolean.valueOf(z);
                    }
                    zzeq com_google_android_gms_internal_measurement_zzeq = com_google_android_gms_internal_measurement_zzeq;
                    cursor = query;
                    try {
                        com_google_android_gms_internal_measurement_zzeq = new zzeq(str, str2, j, j2, j3, j4, valueOf, valueOf2, bool);
                        if (cursor.moveToNext()) {
                            zzge().zzim().zzg("Got multiple records for event aggregates, expected one. appId", zzfg.zzbm(str));
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return com_google_android_gms_internal_measurement_zzeq;
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            zzge().zzim().zzd("Error querying events. appId", zzfg.zzbm(str), zzga().zzbj(str2), e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
                zzge().zzim().zzd("Error querying events. appId", zzfg.zzbm(str), zzga().zzbj(str2), e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzge().zzim().zzd("Error querying events. appId", zzfg.zzbm(str), zzga().zzbj(str2), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final void zzg(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            zzge().zzit().zzg("Deleted user attribute rows", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzge().zzim().zzd("Error deleting user attribute. appId", zzfg.zzbm(str), zzga().zzbl(str2), e);
        }
    }

    @WorkerThread
    public final zzjz zzh(String str, String str2) {
        Cursor query;
        Object e;
        Throwable th;
        zzei com_google_android_gms_internal_measurement_zzei;
        String str3 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            query = getWritableDatabase().query("user_attributes", new String[]{"set_timestamp", Param.VALUE, Param.ORIGIN}, "app_id=? and name=?", new String[]{str, str3}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    long j = query.getLong(0);
                    try {
                        String str4 = str;
                        zzjz com_google_android_gms_internal_measurement_zzjz = new zzjz(str4, query.getString(2), str2, j, zza(query, 1));
                        if (query.moveToNext()) {
                            zzge().zzim().zzg("Got multiple records for user property, expected one. appId", zzfg.zzbm(str));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return com_google_android_gms_internal_measurement_zzjz;
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            zzge().zzim().zzd("Error querying user property. appId", zzfg.zzbm(str), zzga().zzbl(str3), e);
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                com_google_android_gms_internal_measurement_zzei = this;
                zzge().zzim().zzd("Error querying user property. appId", zzfg.zzbm(str), zzga().zzbl(str3), e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                com_google_android_gms_internal_measurement_zzei = this;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            com_google_android_gms_internal_measurement_zzei = this;
            query = null;
            zzge().zzim().zzd("Error querying user property. appId", zzfg.zzbm(str), zzga().zzbl(str3), e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            com_google_android_gms_internal_measurement_zzei = this;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    protected final boolean zzhf() {
        return false;
    }

    @WorkerThread
    public final String zzhn() {
        Object e;
        Throwable th;
        Cursor rawQuery;
        try {
            rawQuery = getWritableDatabase().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    String string = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return string;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzge().zzim().zzg("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            zzge().zzim().zzg("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    public final boolean zzho() {
        return zza("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    @WorkerThread
    final void zzhp() {
        zzab();
        zzch();
        if (zzhv()) {
            long j = zzgf().zzajx.get();
            long elapsedRealtime = zzbt().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > ((Long) zzew.zzahg.get()).longValue()) {
                zzgf().zzajx.set(elapsedRealtime);
                zzab();
                zzch();
                if (zzhv()) {
                    int delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzbt().currentTimeMillis()), String.valueOf(zzef.zzhh())});
                    if (delete > 0) {
                        zzge().zzit().zzg("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    @WorkerThread
    public final long zzhq() {
        return zza("select max(bundle_end_timestamp) from queue", null, 0);
    }

    @WorkerThread
    public final long zzhr() {
        return zza("select max(timestamp) from raw_events", null, 0);
    }

    public final boolean zzhs() {
        return zza("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzht() {
        return zza("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final long zzhu() {
        Object obj;
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return -1;
            } catch (SQLiteException e) {
                Cursor cursor2 = rawQuery;
                obj = e;
                cursor = cursor2;
                try {
                    zzge().zzim().zzg("Error querying raw events", obj);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = rawQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            obj = e2;
            zzge().zzim().zzg("Error querying raw events", obj);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        }
    }

    @WorkerThread
    public final zzed zzi(String str, String str2) {
        Cursor query;
        Object e;
        Throwable th;
        zzei com_google_android_gms_internal_measurement_zzei;
        String str3 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            query = getWritableDatabase().query("conditional_properties", new String[]{Param.ORIGIN, Param.VALUE, "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str3}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    String string = query.getString(0);
                    try {
                        Object zza = zza(query, 1);
                        boolean z = query.getInt(2) != 0;
                        String string2 = query.getString(3);
                        long j = query.getLong(4);
                        zzeu com_google_android_gms_internal_measurement_zzeu = (zzeu) zzgb().zza(query.getBlob(5), zzeu.CREATOR);
                        String str4 = str;
                        zzed com_google_android_gms_internal_measurement_zzed = new zzed(str4, string, new zzjx(str2, query.getLong(8), zza, string), query.getLong(6), z, string2, com_google_android_gms_internal_measurement_zzeu, j, (zzeu) zzgb().zza(query.getBlob(7), zzeu.CREATOR), query.getLong(9), (zzeu) zzgb().zza(query.getBlob(10), zzeu.CREATOR));
                        if (query.moveToNext()) {
                            zzge().zzim().zze("Got multiple records for conditional property, expected one", zzfg.zzbm(str), zzga().zzbl(str3));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return com_google_android_gms_internal_measurement_zzed;
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            zzge().zzim().zzd("Error querying conditional property", zzfg.zzbm(str), zzga().zzbl(str3), e);
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                com_google_android_gms_internal_measurement_zzei = this;
                zzge().zzim().zzd("Error querying conditional property", zzfg.zzbm(str), zzga().zzbl(str3), e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                com_google_android_gms_internal_measurement_zzei = this;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            com_google_android_gms_internal_measurement_zzei = this;
            query = null;
            zzge().zzim().zzd("Error querying conditional property", zzfg.zzbm(str), zzga().zzbl(str3), e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            com_google_android_gms_internal_measurement_zzei = this;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final int zzj(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            return getWritableDatabase().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzge().zzim().zzd("Error deleting conditional property", zzfg.zzbm(str), zzga().zzbl(str2), e);
            return 0;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzke>> zzk(java.lang.String r13, java.lang.String r14) {
        /*
        r12 = this;
        r12.zzch();
        r12.zzab();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13);
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14);
        r0 = new android.support.v4.util.ArrayMap;
        r0.<init>();
        r1 = r12.getWritableDatabase();
        r9 = 0;
        r2 = "event_filters";
        r3 = "audience_id";
        r4 = "data";
        r3 = new java.lang.String[]{r3, r4};	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r4 = "app_id=? AND event_name=?";
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r10 = 0;
        r5[r10] = r13;	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r11 = 1;
        r5[r11] = r14;	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r14 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r1 = r14.moveToFirst();	 Catch:{ SQLiteException -> 0x0091 }
        if (r1 != 0) goto L_0x0042;
    L_0x0038:
        r0 = java.util.Collections.emptyMap();	 Catch:{ SQLiteException -> 0x0091 }
        if (r14 == 0) goto L_0x0041;
    L_0x003e:
        r14.close();
    L_0x0041:
        return r0;
    L_0x0042:
        r1 = r14.getBlob(r11);	 Catch:{ SQLiteException -> 0x0091 }
        r2 = r1.length;	 Catch:{ SQLiteException -> 0x0091 }
        r1 = com.google.android.gms.internal.measurement.zzabv.zza(r1, r10, r2);	 Catch:{ SQLiteException -> 0x0091 }
        r2 = new com.google.android.gms.internal.measurement.zzke;	 Catch:{ SQLiteException -> 0x0091 }
        r2.<init>();	 Catch:{ SQLiteException -> 0x0091 }
        r2.zzb(r1);	 Catch:{ IOException -> 0x0073 }
        r1 = r14.getInt(r10);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = r0.get(r3);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = (java.util.List) r3;	 Catch:{ SQLiteException -> 0x0091 }
        if (r3 != 0) goto L_0x006f;
    L_0x0063:
        r3 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0091 }
        r3.<init>();	 Catch:{ SQLiteException -> 0x0091 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x0091 }
        r0.put(r1, r3);	 Catch:{ SQLiteException -> 0x0091 }
    L_0x006f:
        r3.add(r2);	 Catch:{ SQLiteException -> 0x0091 }
        goto L_0x0085;
    L_0x0073:
        r1 = move-exception;
        r2 = r12.zzge();	 Catch:{ SQLiteException -> 0x0091 }
        r2 = r2.zzim();	 Catch:{ SQLiteException -> 0x0091 }
        r3 = "Failed to merge filter. appId";
        r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r13);	 Catch:{ SQLiteException -> 0x0091 }
        r2.zze(r3, r4, r1);	 Catch:{ SQLiteException -> 0x0091 }
    L_0x0085:
        r1 = r14.moveToNext();	 Catch:{ SQLiteException -> 0x0091 }
        if (r1 != 0) goto L_0x0042;
    L_0x008b:
        if (r14 == 0) goto L_0x0090;
    L_0x008d:
        r14.close();
    L_0x0090:
        return r0;
    L_0x0091:
        r0 = move-exception;
        goto L_0x0098;
    L_0x0093:
        r13 = move-exception;
        r14 = r9;
        goto L_0x00b0;
    L_0x0096:
        r0 = move-exception;
        r14 = r9;
    L_0x0098:
        r1 = r12.zzge();	 Catch:{ all -> 0x00af }
        r1 = r1.zzim();	 Catch:{ all -> 0x00af }
        r2 = "Database error querying filters. appId";
        r13 = com.google.android.gms.internal.measurement.zzfg.zzbm(r13);	 Catch:{ all -> 0x00af }
        r1.zze(r2, r13, r0);	 Catch:{ all -> 0x00af }
        if (r14 == 0) goto L_0x00ae;
    L_0x00ab:
        r14.close();
    L_0x00ae:
        return r9;
    L_0x00af:
        r13 = move-exception;
    L_0x00b0:
        if (r14 == 0) goto L_0x00b5;
    L_0x00b2:
        r14.close();
    L_0x00b5:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzk(java.lang.String, java.lang.String):java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzke>>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzkh>> zzl(java.lang.String r13, java.lang.String r14) {
        /*
        r12 = this;
        r12.zzch();
        r12.zzab();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13);
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14);
        r0 = new android.support.v4.util.ArrayMap;
        r0.<init>();
        r1 = r12.getWritableDatabase();
        r9 = 0;
        r2 = "property_filters";
        r3 = "audience_id";
        r4 = "data";
        r3 = new java.lang.String[]{r3, r4};	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r4 = "app_id=? AND property_name=?";
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r10 = 0;
        r5[r10] = r13;	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r11 = 1;
        r5[r11] = r14;	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r14 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r1 = r14.moveToFirst();	 Catch:{ SQLiteException -> 0x0091 }
        if (r1 != 0) goto L_0x0042;
    L_0x0038:
        r0 = java.util.Collections.emptyMap();	 Catch:{ SQLiteException -> 0x0091 }
        if (r14 == 0) goto L_0x0041;
    L_0x003e:
        r14.close();
    L_0x0041:
        return r0;
    L_0x0042:
        r1 = r14.getBlob(r11);	 Catch:{ SQLiteException -> 0x0091 }
        r2 = r1.length;	 Catch:{ SQLiteException -> 0x0091 }
        r1 = com.google.android.gms.internal.measurement.zzabv.zza(r1, r10, r2);	 Catch:{ SQLiteException -> 0x0091 }
        r2 = new com.google.android.gms.internal.measurement.zzkh;	 Catch:{ SQLiteException -> 0x0091 }
        r2.<init>();	 Catch:{ SQLiteException -> 0x0091 }
        r2.zzb(r1);	 Catch:{ IOException -> 0x0073 }
        r1 = r14.getInt(r10);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = r0.get(r3);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = (java.util.List) r3;	 Catch:{ SQLiteException -> 0x0091 }
        if (r3 != 0) goto L_0x006f;
    L_0x0063:
        r3 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0091 }
        r3.<init>();	 Catch:{ SQLiteException -> 0x0091 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x0091 }
        r0.put(r1, r3);	 Catch:{ SQLiteException -> 0x0091 }
    L_0x006f:
        r3.add(r2);	 Catch:{ SQLiteException -> 0x0091 }
        goto L_0x0085;
    L_0x0073:
        r1 = move-exception;
        r2 = r12.zzge();	 Catch:{ SQLiteException -> 0x0091 }
        r2 = r2.zzim();	 Catch:{ SQLiteException -> 0x0091 }
        r3 = "Failed to merge filter";
        r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r13);	 Catch:{ SQLiteException -> 0x0091 }
        r2.zze(r3, r4, r1);	 Catch:{ SQLiteException -> 0x0091 }
    L_0x0085:
        r1 = r14.moveToNext();	 Catch:{ SQLiteException -> 0x0091 }
        if (r1 != 0) goto L_0x0042;
    L_0x008b:
        if (r14 == 0) goto L_0x0090;
    L_0x008d:
        r14.close();
    L_0x0090:
        return r0;
    L_0x0091:
        r0 = move-exception;
        goto L_0x0098;
    L_0x0093:
        r13 = move-exception;
        r14 = r9;
        goto L_0x00b0;
    L_0x0096:
        r0 = move-exception;
        r14 = r9;
    L_0x0098:
        r1 = r12.zzge();	 Catch:{ all -> 0x00af }
        r1 = r1.zzim();	 Catch:{ all -> 0x00af }
        r2 = "Database error querying filters. appId";
        r13 = com.google.android.gms.internal.measurement.zzfg.zzbm(r13);	 Catch:{ all -> 0x00af }
        r1.zze(r2, r13, r0);	 Catch:{ all -> 0x00af }
        if (r14 == 0) goto L_0x00ae;
    L_0x00ab:
        r14.close();
    L_0x00ae:
        return r9;
    L_0x00af:
        r13 = move-exception;
    L_0x00b0:
        if (r14 == 0) goto L_0x00b5;
    L_0x00b2:
        r14.close();
    L_0x00b5:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzl(java.lang.String, java.lang.String):java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzkh>>");
    }

    @WorkerThread
    @VisibleForTesting
    protected final long zzm(String str, String str2) {
        Object e;
        Throwable th;
        zzei com_google_android_gms_internal_measurement_zzei;
        String str3 = str;
        String str4 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        long zza;
        try {
            ContentValues contentValues;
            StringBuilder stringBuilder = new StringBuilder(32 + String.valueOf(str2).length());
            stringBuilder.append("select ");
            stringBuilder.append(str4);
            stringBuilder.append(" from app2 where app_id=?");
            try {
                zza = zza(stringBuilder.toString(), new String[]{str3}, -1);
                if (zza == -1) {
                    contentValues = new ContentValues();
                    contentValues.put("app_id", str3);
                    contentValues.put("first_open_count", Integer.valueOf(0));
                    contentValues.put("previous_install_count", Integer.valueOf(0));
                    if (writableDatabase.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzge().zzim().zze("Failed to insert column (got -1). appId", zzfg.zzbm(str), str4);
                        writableDatabase.endTransaction();
                        return -1;
                    }
                    zza = 0;
                }
            } catch (SQLiteException e2) {
                e = e2;
                zza = 0;
                try {
                    zzge().zzim().zzd("Error inserting column. appId", zzfg.zzbm(str), str4, e);
                    writableDatabase.endTransaction();
                    return zza;
                } catch (Throwable th2) {
                    th = th2;
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            try {
                contentValues = new ContentValues();
                contentValues.put("app_id", str3);
                contentValues.put(str4, Long.valueOf(zza + 1));
                if (((long) writableDatabase.update("app2", contentValues, "app_id = ?", new String[]{str3})) == 0) {
                    zzge().zzim().zze("Failed to update column (got 0). appId", zzfg.zzbm(str), str4);
                    writableDatabase.endTransaction();
                    return -1;
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return zza;
            } catch (SQLiteException e3) {
                e = e3;
                zzge().zzim().zzd("Error inserting column. appId", zzfg.zzbm(str), str4, e);
                writableDatabase.endTransaction();
                return zza;
            }
        } catch (SQLiteException e4) {
            e = e4;
            com_google_android_gms_internal_measurement_zzei = this;
            zza = 0;
            zzge().zzim().zzd("Error inserting column. appId", zzfg.zzbm(str), str4, e);
            writableDatabase.endTransaction();
            return zza;
        } catch (Throwable th3) {
            th = th3;
            com_google_android_gms_internal_measurement_zzei = this;
            writableDatabase.endTransaction();
            throw th;
        }
    }
}
