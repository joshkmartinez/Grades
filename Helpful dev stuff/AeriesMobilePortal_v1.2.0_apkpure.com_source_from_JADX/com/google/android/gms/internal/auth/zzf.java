package com.google.android.gms.internal.auth;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class zzf {
    private static final ClassLoader zzg = zzf.class.getClassLoader();

    private zzf() {
    }

    public static <T extends Parcelable> T zzd(Parcel parcel, Creator<T> creator) {
        return parcel.readInt() == 0 ? null : (Parcelable) creator.createFromParcel(parcel);
    }

    public static void zzd(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface == null ? null : iInterface.asBinder());
    }

    public static void zzd(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    public static void zzd(Parcel parcel, boolean z) {
        parcel.writeInt(z);
    }

    public static boolean zzd(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
