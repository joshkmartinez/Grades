package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class zzap {
    private static final long zzct = TimeUnit.DAYS.toMillis(7);
    private final long timestamp;
    final String zzcu;
    private final String zzcv;

    private zzap(String str, String str2, long j) {
        this.zzcu = str;
        this.zzcv = str2;
        this.timestamp = j;
    }

    static String zza(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put(Param.TIMESTAMP, j);
            return jSONObject.toString();
        } catch (JSONException e) {
            str = String.valueOf(e);
            StringBuilder stringBuilder = new StringBuilder(24 + String.valueOf(str).length());
            stringBuilder.append("Failed to encode token: ");
            stringBuilder.append(str);
            Log.w("FirebaseInstanceId", stringBuilder.toString());
            return null;
        }
    }

    static zzap zzi(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new zzap(str, null, 0);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new zzap(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong(Param.TIMESTAMP));
        } catch (JSONException e) {
            str = String.valueOf(e);
            StringBuilder stringBuilder = new StringBuilder(23 + String.valueOf(str).length());
            stringBuilder.append("Failed to parse token: ");
            stringBuilder.append(str);
            Log.w("FirebaseInstanceId", stringBuilder.toString());
            return null;
        }
    }

    final boolean zzj(String str) {
        if (System.currentTimeMillis() <= this.timestamp + zzct) {
            if (str.equals(this.zzcv)) {
                return false;
            }
        }
        return true;
    }
}
