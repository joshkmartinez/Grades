package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzad implements Creator<zzac> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzx[] com_google_android_gms_internal_vision_zzxArr = null;
        zzn com_google_android_gms_internal_vision_zzn = com_google_android_gms_internal_vision_zzxArr;
        zzn com_google_android_gms_internal_vision_zzn2 = com_google_android_gms_internal_vision_zzn;
        String str = com_google_android_gms_internal_vision_zzn2;
        String str2 = str;
        float f = 0.0f;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    com_google_android_gms_internal_vision_zzxArr = (zzx[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzx.CREATOR);
                    break;
                case 3:
                    com_google_android_gms_internal_vision_zzn = (zzn) SafeParcelReader.createParcelable(parcel, readHeader, zzn.CREATOR);
                    break;
                case 4:
                    com_google_android_gms_internal_vision_zzn2 = (zzn) SafeParcelReader.createParcelable(parcel, readHeader, zzn.CREATOR);
                    break;
                case 5:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    f = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 7:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzac(com_google_android_gms_internal_vision_zzxArr, com_google_android_gms_internal_vision_zzn, com_google_android_gms_internal_vision_zzn2, str, f, str2, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzac[i];
    }
}
