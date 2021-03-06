package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;

public class FirebaseInfo {
    static final String FIREBASE_FEATURE_SWITCH = "com.crashlytics.useFirebaseAppId";
    static final String GOOGLE_APP_ID = "google_app_id";

    protected String getApiKeyFromFirebaseAppId(Context context) {
        int resourcesIdentifier = CommonUtils.getResourcesIdentifier(context, GOOGLE_APP_ID, "string");
        if (resourcesIdentifier == 0) {
            return null;
        }
        Fabric.getLogger().mo2301d(Fabric.TAG, "Generating Crashlytics ApiKey from google_app_id in Strings");
        return createApiKeyFromFirebaseAppId(context.getResources().getString(resourcesIdentifier));
    }

    protected String createApiKeyFromFirebaseAppId(String str) {
        return CommonUtils.sha256(str).substring(0, 40);
    }

    public boolean isFirebaseCrashlyticsEnabled(Context context) {
        boolean z = false;
        if (CommonUtils.getBooleanResourceValue(context, FIREBASE_FEATURE_SWITCH, false)) {
            return true;
        }
        boolean z2 = CommonUtils.getResourcesIdentifier(context, GOOGLE_APP_ID, "string") != 0;
        if (TextUtils.isEmpty(new ApiKey().getApiKeyFromManifest(context))) {
            if (TextUtils.isEmpty(new ApiKey().getApiKeyFromStrings(context)) != null) {
                context = null;
                if (z2 && r5 == null) {
                    z = true;
                }
                return z;
            }
        }
        context = 1;
        z = true;
        return z;
    }
}
