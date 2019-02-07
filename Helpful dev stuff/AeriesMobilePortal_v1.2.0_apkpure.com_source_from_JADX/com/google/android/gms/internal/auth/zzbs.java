package com.google.android.gms.internal.auth;

import android.util.Log;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;

public abstract class zzbs extends FastSafeParcelableJsonResponse {
    private static String zzhq = "AUTH";

    public byte[] toByteArray() {
        try {
            return toString().getBytes("UTF-8");
        } catch (Throwable e) {
            Log.e(zzhq, "Error serializing object.", e);
            return null;
        }
    }
}
