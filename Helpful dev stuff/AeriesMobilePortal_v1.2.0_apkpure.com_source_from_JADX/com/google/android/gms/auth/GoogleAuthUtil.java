package com.google.android.gms.auth;

import android.accounts.Account;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.List;

public final class GoogleAuthUtil extends zzg {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    private static final String KEY_ANDROID_PACKAGE_NAME = zzg.KEY_ANDROID_PACKAGE_NAME;
    private static final String KEY_CALLER_UID = zzg.KEY_CALLER_UID;
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";

    private GoogleAuthUtil() {
    }

    public static void clearToken(Context context, String str) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        zzg.clearToken(context, str);
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int i, String str) throws GoogleAuthException, IOException {
        return zzg.getAccountChangeEvents(context, i, str);
    }

    public static String getAccountId(Context context, String str) throws GoogleAuthException, IOException {
        return zzg.getAccountId(context, str);
    }

    public static String getToken(Context context, Account account, String str) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zzg.getToken(context, account, str);
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zzg.getToken(context, account, str, bundle);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zzg.getToken(context, str, str2);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zzg.getToken(context, str, str2, bundle);
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("handle_notification", true);
        return zzd(context, account, str, bundle).zze();
    }

    public static java.lang.String getTokenWithNotification(android.content.Context r2, android.accounts.Account r3, java.lang.String r4, android.os.Bundle r5, android.content.Intent r6) throws java.io.IOException, com.google.android.gms.auth.UserRecoverableNotifiedException, com.google.android.gms.auth.GoogleAuthException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        if (r6 == 0) goto L_0x002c;
    L_0x0002:
        r0 = 1;
        r1 = r6.toUri(r0);
        android.content.Intent.parseUri(r1, r0);	 Catch:{ URISyntaxException -> 0x0024 }
        if (r5 != 0) goto L_0x0011;
    L_0x000c:
        r5 = new android.os.Bundle;
        r5.<init>();
    L_0x0011:
        r1 = "callback_intent";
        r5.putParcelable(r1, r6);
        r6 = "handle_notification";
        r5.putBoolean(r6, r0);
        r2 = zzd(r2, r3, r4, r5);
        r2 = r2.zze();
        return r2;
    L_0x0024:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().";
        r2.<init>(r3);
        throw r2;
    L_0x002c:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Callback cannot be null.";
        r2.<init>(r3);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.GoogleAuthUtil.getTokenWithNotification(android.content.Context, android.accounts.Account, java.lang.String, android.os.Bundle, android.content.Intent):java.lang.String");
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle, String str2, Bundle bundle2) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        Preconditions.checkNotEmpty(str2, "Authority cannot be empty or null.");
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        ContentResolver.validateSyncExtrasBundle(bundle2);
        bundle.putString("authority", str2);
        bundle.putBundle("sync_extras", bundle2);
        bundle.putBoolean("handle_notification", true);
        return zzd(context, account, str, bundle).zze();
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle);
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle, Intent intent) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, intent);
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle, String str3, Bundle bundle2) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, str3, bundle2);
    }

    @RequiresPermission("android.permission.MANAGE_ACCOUNTS")
    @Deprecated
    public static void invalidateToken(Context context, String str) {
        zzg.invalidateToken(context, str);
    }

    @TargetApi(23)
    public static Bundle removeAccount(Context context, Account account) throws GoogleAuthException, IOException {
        return zzg.removeAccount(context, account);
    }

    @TargetApi(26)
    public static Boolean requestGoogleAccountsAccess(Context context) throws GoogleAuthException, IOException {
        return zzg.requestGoogleAccountsAccess(context);
    }

    private static TokenData zzd(Context context, Account account, String str, Bundle bundle) throws IOException, GoogleAuthException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            TokenData zze = zzg.zze(context, account, str, bundle);
            GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
            return zze;
        } catch (Throwable e) {
            GooglePlayServicesUtil.showErrorNotification(e.getConnectionStatusCode(), context);
            Log.w("GoogleAuthUtil", "Error when getting token", e);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        } catch (Throwable e2) {
            GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
            Log.w("GoogleAuthUtil", "Error when getting token", e2);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        }
    }
}
