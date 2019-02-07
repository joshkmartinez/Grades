package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import java.util.HashSet;
import java.util.Set;

public final class zzv implements Creator<zzu> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        zzw com_google_android_gms_auth_api_accounttransfer_zzw = null;
        String str = com_google_android_gms_auth_api_accounttransfer_zzw;
        String str2 = str;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    readHeader = 1;
                    break;
                case 2:
                    com_google_android_gms_auth_api_accounttransfer_zzw = (zzw) SafeParcelReader.createParcelable(parcel, readHeader, zzw.CREATOR);
                    readHeader = 2;
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    readHeader = 3;
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    readHeader = 4;
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    continue;
            }
            hashSet.add(Integer.valueOf(readHeader));
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            return new zzu(hashSet, i, com_google_android_gms_auth_api_accounttransfer_zzw, str, str2);
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Overread allowed size end=");
        stringBuilder.append(validateObjectHeader);
        throw new ParseException(stringBuilder.toString(), parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzu[i];
    }
}
