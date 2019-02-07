package com.google.android.gms.auth.account;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.internal.auth.zzk;
import com.google.android.gms.internal.auth.zzu;

public class WorkAccount {
    public static final Api<NoOptions> API = new Api("WorkAccount.API", CLIENT_BUILDER, CLIENT_KEY);
    private static final AbstractClientBuilder<zzu, NoOptions> CLIENT_BUILDER = new zzi();
    private static final ClientKey<zzu> CLIENT_KEY = new ClientKey();
    @Deprecated
    public static final WorkAccountApi WorkAccountApi = new zzk();

    private WorkAccount() {
    }

    public static WorkAccountClient getClient(@NonNull Activity activity) {
        return new WorkAccountClient(activity);
    }

    public static WorkAccountClient getClient(@NonNull Context context) {
        return new WorkAccountClient(context);
    }
}
