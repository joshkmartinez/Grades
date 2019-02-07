package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzal;

public interface zzao extends IInterface {
    Location zza(String str) throws RemoteException;

    void zza(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    void zza(PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException;

    void zza(Location location) throws RemoteException;

    void zza(zzaj com_google_android_gms_internal_location_zzaj) throws RemoteException;

    void zza(zzbf com_google_android_gms_internal_location_zzbf) throws RemoteException;

    void zza(zzo com_google_android_gms_internal_location_zzo) throws RemoteException;

    void zza(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException;

    void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzam com_google_android_gms_internal_location_zzam) throws RemoteException;

    void zza(LocationSettingsRequest locationSettingsRequest, zzaq com_google_android_gms_internal_location_zzaq, String str) throws RemoteException;

    void zza(zzal com_google_android_gms_location_zzal, zzam com_google_android_gms_internal_location_zzam) throws RemoteException;

    void zza(boolean z) throws RemoteException;

    LocationAvailability zzb(String str) throws RemoteException;

    void zzb(PendingIntent pendingIntent) throws RemoteException;
}