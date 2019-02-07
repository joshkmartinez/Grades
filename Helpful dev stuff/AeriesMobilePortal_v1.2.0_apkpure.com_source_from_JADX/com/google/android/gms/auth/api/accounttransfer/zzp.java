package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class zzp implements Creator<zzo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        ArrayList arrayList = null;
        zzr com_google_android_gms_auth_api_accounttransfer_zzr = arrayList;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    readHeader = 1;
                    break;
                case 2:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, zzu.CREATOR);
                    readHeader = 2;
                    break;
                case 3:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    readHeader = 3;
                    break;
                case 4:
                    com_google_android_gms_auth_api_accounttransfer_zzr = (zzr) SafeParcelReader.createParcelable(parcel, readHeader, zzr.CREATOR);
                    readHeader = 4;
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    continue;
            }
            hashSet.add(Integer.valueOf(readHeader));
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            return new zzo(hashSet, i, arrayList, i2, com_google_android_gms_auth_api_accounttransfer_zzr);
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Overread allowed size end=");
        stringBuilder.append(validateObjectHeader);
        throw new ParseException(stringBuilder.toString(), parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }
}
