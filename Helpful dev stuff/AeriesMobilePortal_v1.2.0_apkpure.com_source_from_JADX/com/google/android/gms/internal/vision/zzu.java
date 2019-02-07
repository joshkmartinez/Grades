package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzu implements Creator<zzt> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        boolean z = i;
        int i2 = z;
        int i3 = i2;
        zzac[] com_google_android_gms_internal_vision_zzacArr = null;
        zzn com_google_android_gms_internal_vision_zzn = com_google_android_gms_internal_vision_zzacArr;
        zzn com_google_android_gms_internal_vision_zzn2 = com_google_android_gms_internal_vision_zzn;
        zzn com_google_android_gms_internal_vision_zzn3 = com_google_android_gms_internal_vision_zzn2;
        String str = com_google_android_gms_internal_vision_zzn3;
        String str2 = str;
        float f = 0.0f;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    com_google_android_gms_internal_vision_zzacArr = (zzac[]) SafeParcelReader.createTypedArray(parcel2, readHeader, zzac.CREATOR);
                    break;
                case 3:
                    com_google_android_gms_internal_vision_zzn = (zzn) SafeParcelReader.createParcelable(parcel2, readHeader, zzn.CREATOR);
                    break;
                case 4:
                    com_google_android_gms_internal_vision_zzn2 = (zzn) SafeParcelReader.createParcelable(parcel2, readHeader, zzn.CREATOR);
                    break;
                case 5:
                    com_google_android_gms_internal_vision_zzn3 = (zzn) SafeParcelReader.createParcelable(parcel2, readHeader, zzn.CREATOR);
                    break;
                case 6:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 7:
                    f = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 8:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 9:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 10:
                    z = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 11:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 12:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzt(com_google_android_gms_internal_vision_zzacArr, com_google_android_gms_internal_vision_zzn, com_google_android_gms_internal_vision_zzn2, com_google_android_gms_internal_vision_zzn3, str, f, str2, i, z, i2, i3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzt[i];
    }
}
