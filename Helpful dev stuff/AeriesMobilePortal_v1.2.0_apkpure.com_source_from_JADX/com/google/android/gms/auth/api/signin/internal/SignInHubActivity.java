package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

@KeepName
public class SignInHubActivity extends FragmentActivity {
    private static boolean zzfg = false;
    private boolean zzfh = false;
    private SignInConfiguration zzfi;
    private boolean zzfj;
    private int zzfk;
    private Intent zzfl;

    private class zzd implements LoaderCallbacks<Void> {
        private final /* synthetic */ SignInHubActivity zzfm;

        private zzd(SignInHubActivity signInHubActivity) {
            this.zzfm = signInHubActivity;
        }

        public final Loader<Void> onCreateLoader(int i, Bundle bundle) {
            return new zzf(this.zzfm, GoogleApiClient.getAllClients());
        }

        public final /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
            this.zzfm.setResult(this.zzfm.zzfk, this.zzfm.zzfl);
            this.zzfm.finish();
        }

        public final void onLoaderReset(Loader<Void> loader) {
        }
    }

    private final void zzd(int i) {
        Parcelable status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        zzfg = false;
    }

    private final void zzu() {
        getSupportLoaderManager().initLoader(0, null, new zzd());
        zzfg = false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!this.zzfh) {
            setResult(0);
            if (i == 40962) {
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                    if (signInAccount != null && signInAccount.getGoogleSignInAccount() != null) {
                        Parcelable googleSignInAccount = signInAccount.getGoogleSignInAccount();
                        zzq.zze(this).zzd(this.zzfi.zzt(), googleSignInAccount);
                        intent.removeExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                        intent.putExtra("googleSignInAccount", googleSignInAccount);
                        this.zzfj = true;
                        this.zzfk = i2;
                        this.zzfl = intent;
                        zzu();
                        return;
                    } else if (intent.hasExtra("errorCode")) {
                        zzd(intent.getIntExtra("errorCode", 8));
                        return;
                    }
                }
                zzd(8);
            }
        }
    }

    protected void onCreate(android.os.Bundle r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        super.onCreate(r5);
        r0 = r4.getIntent();
        r1 = r0.getAction();
        r2 = "com.google.android.gms.auth.NO_IMPL";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0019;
    L_0x0013:
        r5 = 12500; // 0x30d4 float:1.7516E-41 double:6.176E-320;
        r4.zzd(r5);
        return;
    L_0x0019:
        r2 = "com.google.android.gms.auth.GOOGLE_SIGN_IN";
        r2 = r1.equals(r2);
        if (r2 != 0) goto L_0x004c;
    L_0x0021:
        r2 = "com.google.android.gms.auth.APPAUTH_SIGN_IN";
        r2 = r1.equals(r2);
        if (r2 != 0) goto L_0x004c;
    L_0x0029:
        r5 = "AuthSignInClient";
        r1 = "Unknown action: ";
        r0 = r0.getAction();
        r0 = java.lang.String.valueOf(r0);
        r2 = r0.length();
        if (r2 == 0) goto L_0x0040;
    L_0x003b:
        r0 = r1.concat(r0);
        goto L_0x0045;
    L_0x0040:
        r0 = new java.lang.String;
        r0.<init>(r1);
    L_0x0045:
        android.util.Log.e(r5, r0);
        r4.finish();
        return;
    L_0x004c:
        r2 = "config";
        r0 = r0.getBundleExtra(r2);
        r2 = "config";
        r0 = r0.getParcelable(r2);
        r0 = (com.google.android.gms.auth.api.signin.internal.SignInConfiguration) r0;
        r4.zzfi = r0;
        r0 = r4.zzfi;
        r2 = 0;
        if (r0 != 0) goto L_0x006f;
    L_0x0061:
        r5 = "AuthSignInClient";
        r0 = "Activity started with invalid configuration.";
        android.util.Log.e(r5, r0);
        r4.setResult(r2);
        r4.finish();
        return;
    L_0x006f:
        r0 = 1;
        if (r5 != 0) goto L_0x0074;
    L_0x0072:
        r3 = r0;
        goto L_0x0075;
    L_0x0074:
        r3 = r2;
    L_0x0075:
        if (r3 == 0) goto L_0x00bb;
    L_0x0077:
        r5 = zzfg;
        if (r5 == 0) goto L_0x0084;
    L_0x007b:
        r4.setResult(r2);
        r5 = 12502; // 0x30d6 float:1.7519E-41 double:6.177E-320;
        r4.zzd(r5);
        return;
    L_0x0084:
        zzfg = r0;
        r5 = new android.content.Intent;
        r5.<init>(r1);
        r2 = "com.google.android.gms.auth.GOOGLE_SIGN_IN";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0099;
    L_0x0093:
        r1 = "com.google.android.gms";
    L_0x0095:
        r5.setPackage(r1);
        goto L_0x009e;
    L_0x0099:
        r1 = r4.getPackageName();
        goto L_0x0095;
    L_0x009e:
        r1 = "config";
        r2 = r4.zzfi;
        r5.putExtra(r1, r2);
        r1 = 40962; // 0xa002 float:5.74E-41 double:2.0238E-319;
        r4.startActivityForResult(r5, r1);	 Catch:{ ActivityNotFoundException -> 0x00ac }
        return;
    L_0x00ac:
        r4.zzfh = r0;
        r5 = "AuthSignInClient";
        r0 = "Could not launch sign in Intent. Google Play Service is probably being updated...";
        android.util.Log.w(r5, r0);
        r5 = 17;
        r4.zzd(r5);
        return;
    L_0x00bb:
        r0 = "signingInGoogleApiClients";
        r0 = r5.getBoolean(r0);
        r4.zzfj = r0;
        r0 = r4.zzfj;
        if (r0 == 0) goto L_0x00dc;
    L_0x00c7:
        r0 = "signInResultCode";
        r0 = r5.getInt(r0);
        r4.zzfk = r0;
        r0 = "signInResultData";
        r5 = r5.getParcelable(r0);
        r5 = (android.content.Intent) r5;
        r4.zzfl = r5;
        r4.zzu();
    L_0x00dc:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.SignInHubActivity.onCreate(android.os.Bundle):void");
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.zzfj);
        if (this.zzfj) {
            bundle.putInt("signInResultCode", this.zzfk);
            bundle.putParcelable("signInResultData", this.zzfl);
        }
    }
}
