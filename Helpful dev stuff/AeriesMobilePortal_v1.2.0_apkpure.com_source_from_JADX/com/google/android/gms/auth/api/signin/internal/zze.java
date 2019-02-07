package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class zze implements Runnable {
    private static final Logger zzer = new Logger("RevokeAccessOperation", new String[0]);
    private final StatusPendingResult zzes = new StatusPendingResult(null);
    private final String zzz;

    private zze(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzz = str;
    }

    public static PendingResult<Status> zzg(String str) {
        if (str == null) {
            return PendingResults.immediateFailedResult(new Status(4), null);
        }
        Object com_google_android_gms_auth_api_signin_internal_zze = new zze(str);
        new Thread(com_google_android_gms_auth_api_signin_internal_zze).start();
        return com_google_android_gms_auth_api_signin_internal_zze.zzes;
    }

    public final void run() {
        String valueOf;
        Logger logger;
        String valueOf2;
        Result result = Status.RESULT_INTERNAL_ERROR;
        try {
            String valueOf3 = String.valueOf("https://accounts.google.com/o/oauth2/revoke?token=");
            valueOf = String.valueOf(this.zzz);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(valueOf.length() != 0 ? valueOf3.concat(valueOf) : new String(valueOf3)).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", HttpRequest.CONTENT_TYPE_FORM);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                result = Status.RESULT_SUCCESS;
            } else {
                zzer.m47e("Unable to revoke access!", new Object[0]);
            }
            logger = zzer;
            StringBuilder stringBuilder = new StringBuilder(26);
            stringBuilder.append("Response Code: ");
            stringBuilder.append(responseCode);
            logger.m45d(stringBuilder.toString(), new Object[0]);
        } catch (IOException e) {
            logger = zzer;
            valueOf = "IOException when revoking access: ";
            valueOf2 = String.valueOf(e.toString());
            if (valueOf2.length() == 0) {
                valueOf2 = new String(valueOf);
                logger.m47e(valueOf2, new Object[0]);
                this.zzes.setResult(result);
            }
            valueOf2 = valueOf.concat(valueOf2);
            logger.m47e(valueOf2, new Object[0]);
            this.zzes.setResult(result);
        } catch (Exception e2) {
            logger = zzer;
            valueOf = "Exception when revoking access: ";
            valueOf2 = String.valueOf(e2.toString());
            if (valueOf2.length() != 0) {
                valueOf2 = valueOf.concat(valueOf2);
                logger.m47e(valueOf2, new Object[0]);
                this.zzes.setResult(result);
            }
            valueOf2 = new String(valueOf);
            logger.m47e(valueOf2, new Object[0]);
            this.zzes.setResult(result);
        }
        this.zzes.setResult(result);
    }
}
