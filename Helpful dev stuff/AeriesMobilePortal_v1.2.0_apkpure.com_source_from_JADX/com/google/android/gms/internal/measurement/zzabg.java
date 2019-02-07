package com.google.android.gms.internal.measurement;

final class zzabg {
    static String zza(zzyw com_google_android_gms_internal_measurement_zzyw) {
        zzabi com_google_android_gms_internal_measurement_zzabh = new zzabh(com_google_android_gms_internal_measurement_zzyw);
        StringBuilder stringBuilder = new StringBuilder(com_google_android_gms_internal_measurement_zzabh.size());
        for (int i = 0; i < com_google_android_gms_internal_measurement_zzabh.size(); i++) {
            String str;
            byte zzae = com_google_android_gms_internal_measurement_zzabh.zzae(i);
            if (zzae == (byte) 34) {
                str = "\\\"";
            } else if (zzae == (byte) 39) {
                str = "\\'";
            } else if (zzae != (byte) 92) {
                switch (zzae) {
                    case (byte) 7:
                        str = "\\a";
                        break;
                    case (byte) 8:
                        str = "\\b";
                        break;
                    case (byte) 9:
                        str = "\\t";
                        break;
                    case (byte) 10:
                        str = "\\n";
                        break;
                    case (byte) 11:
                        str = "\\v";
                        break;
                    case (byte) 12:
                        str = "\\f";
                        break;
                    case (byte) 13:
                        str = "\\r";
                        break;
                    default:
                        char c;
                        if (zzae < (byte) 32 || zzae > (byte) 126) {
                            stringBuilder.append('\\');
                            stringBuilder.append((char) (((zzae >>> 6) & 3) + 48));
                            stringBuilder.append((char) (((zzae >>> 3) & 7) + 48));
                            c = (char) (48 + (zzae & 7));
                        } else {
                            c = (char) zzae;
                        }
                        stringBuilder.append(c);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
