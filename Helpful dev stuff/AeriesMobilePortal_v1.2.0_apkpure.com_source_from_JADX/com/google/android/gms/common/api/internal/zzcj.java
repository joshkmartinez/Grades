package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

final class zzcj extends Handler {
    private final /* synthetic */ zzch zzml;

    public zzcj(zzch com_google_android_gms_common_api_internal_zzch, Looper looper) {
        this.zzml = com_google_android_gms_common_api_internal_zzch;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                PendingResult pendingResult = (PendingResult) message.obj;
                synchronized (this.zzml.zzfa) {
                    if (pendingResult == null) {
                        this.zzml.zzme.zzd(new Status(13, "Transform returned null"));
                    } else if (pendingResult instanceof zzbx) {
                        this.zzml.zzme.zzd(((zzbx) pendingResult).getStatus());
                    } else {
                        this.zzml.zzme.zza(pendingResult);
                    }
                }
                return;
            case 1:
                RuntimeException runtimeException = (RuntimeException) message.obj;
                String str = "Runtime exception on the transformation worker thread: ";
                String valueOf = String.valueOf(runtimeException.getMessage());
                Log.e("TransformedResultImpl", valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                throw runtimeException;
            default:
                int i = message.what;
                StringBuilder stringBuilder = new StringBuilder(70);
                stringBuilder.append("TransformationResultHandler received unknown message type: ");
                stringBuilder.append(i);
                Log.e("TransformedResultImpl", stringBuilder.toString());
                return;
        }
    }
}
