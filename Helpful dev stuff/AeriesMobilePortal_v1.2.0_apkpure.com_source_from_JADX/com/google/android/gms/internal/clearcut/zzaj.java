package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Log;

final class zzaj extends zzae<Boolean> {
    zzaj(zzao com_google_android_gms_internal_clearcut_zzao, String str, Boolean bool) {
        super(com_google_android_gms_internal_clearcut_zzao, str, bool);
    }

    private final Boolean zzb(SharedPreferences sharedPreferences) {
        try {
            return Boolean.valueOf(sharedPreferences.getBoolean(this.zzds, false));
        } catch (Throwable e) {
            String str = "PhenotypeFlag";
            String str2 = "Invalid boolean value in SharedPreferences for ";
            String valueOf = String.valueOf(this.zzds);
            Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
            return null;
        }
    }

    protected final /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
        return zzb(sharedPreferences);
    }

    protected final /* synthetic */ Object zzb(String str) {
        if (zzy.zzcr.matcher(str).matches()) {
            return Boolean.valueOf(true);
        }
        if (zzy.zzcs.matcher(str).matches()) {
            return Boolean.valueOf(false);
        }
        String str2 = this.zzds;
        StringBuilder stringBuilder = new StringBuilder((28 + String.valueOf(str2).length()) + String.valueOf(str).length());
        stringBuilder.append("Invalid boolean value for ");
        stringBuilder.append(str2);
        stringBuilder.append(": ");
        stringBuilder.append(str);
        Log.e("PhenotypeFlag", stringBuilder.toString());
        return null;
    }
}
