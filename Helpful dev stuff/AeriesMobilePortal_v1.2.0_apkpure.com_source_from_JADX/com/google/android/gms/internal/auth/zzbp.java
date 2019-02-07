package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyResponse;

final class zzbp extends zzbg {
    private final /* synthetic */ zzbo zzed;

    zzbp(zzbo com_google_android_gms_internal_auth_zzbo) {
        this.zzed = com_google_android_gms_internal_auth_zzbo;
    }

    public final void zzd(ProxyResponse proxyResponse) {
        this.zzed.setResult(new zzbq(proxyResponse));
    }
}
