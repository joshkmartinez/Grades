package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzwy extends zzws<Boolean> {
    zzwy(zzxc com_google_android_gms_internal_measurement_zzxc, String str, Boolean bool) {
        super(com_google_android_gms_internal_measurement_zzxc, str, bool);
    }

    protected final /* synthetic */ Object zzey(String str) {
        if (zzwn.zzbmi.matcher(str).matches()) {
            return Boolean.valueOf(true);
        }
        if (zzwn.zzbmj.matcher(str).matches()) {
            return Boolean.valueOf(false);
        }
        String str2 = this.zzbnh;
        StringBuilder stringBuilder = new StringBuilder((28 + String.valueOf(str2).length()) + String.valueOf(str).length());
        stringBuilder.append("Invalid boolean value for ");
        stringBuilder.append(str2);
        stringBuilder.append(": ");
        stringBuilder.append(str);
        Log.e("PhenotypeFlag", stringBuilder.toString());
        return null;
    }
}
