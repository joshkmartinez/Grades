package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzbg implements Creator<zzbf> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzbd com_google_android_gms_internal_location_zzbd = null;
        IBinder iBinder = com_google_android_gms_internal_location_zzbd;
        PendingIntent pendingIntent = iBinder;
        IBinder iBinder2 = pendingIntent;
        IBinder iBinder3 = iBinder2;
        int i = 1;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    com_google_android_gms_internal_location_zzbd = (zzbd) SafeParcelReader.createParcelable(parcel, readHeader, zzbd.CREATOR);
                    break;
                case 3:
                    iBinder = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) SafeParcelReader.createParcelable(parcel, readHeader, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 6:
                    iBinder3 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzbf(i, com_google_android_gms_internal_location_zzbd, iBinder, pendingIntent, iBinder2, iBinder3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbf[i];
    }
}
