package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

public final class zzaw {
    public static PendingIntent zzd(Context context, @Nullable AuthCredentialsOptions authCredentialsOptions, HintRequest hintRequest) {
        Preconditions.checkNotNull(context, "context must not be null");
        Preconditions.checkNotNull(hintRequest, "request must not be null");
        SafeParcelable zzg = (authCredentialsOptions == null || authCredentialsOptions.zzg() == null) ? PasswordSpecification.zzdg : authCredentialsOptions.zzg();
        Intent putExtra = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("com.google.android.gms.credentials.hintRequestVersion", 2).putExtra("com.google.android.gms.credentials.RequestType", "Hints").putExtra("com.google.android.gms.credentials.ClaimedCallingPackage", null);
        SafeParcelableSerializer.serializeToIntentExtra(zzg, putExtra, "com.google.android.gms.credentials.PasswordSpecification");
        SafeParcelableSerializer.serializeToIntentExtra(hintRequest, putExtra, "com.google.android.gms.credentials.HintRequest");
        return PendingIntent.getActivity(context, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, putExtra, 134217728);
    }
}
