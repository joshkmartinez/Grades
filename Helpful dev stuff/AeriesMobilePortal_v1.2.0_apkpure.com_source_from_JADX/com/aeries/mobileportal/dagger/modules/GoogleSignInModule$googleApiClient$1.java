package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.aeries.mobileportal.C0316R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/google/android/gms/common/ConnectionResult;", "onConnectionFailed"}, k = 3, mv = {1, 1, 10})
/* compiled from: GoogleSignInModule.kt */
final class GoogleSignInModule$googleApiClient$1 implements OnConnectionFailedListener {
    final /* synthetic */ Context $context;

    GoogleSignInModule$googleApiClient$1(Context context) {
        this.$context = context;
    }

    public final void onConnectionFailed(@NotNull ConnectionResult connectionResult) {
        Intrinsics.checkParameterIsNotNull(connectionResult, "it");
        String str = "GOOGLE_CONNECTION_FAIL";
        String errorMessage = connectionResult.getErrorMessage();
        if (errorMessage == null) {
            errorMessage = "Google sign connection failed";
        }
        Log.d(str, errorMessage);
        if (connectionResult.getErrorCode() == 2) {
            Toast.makeText(this.$context, C0316R.string.update_google_services, 1).show();
        }
    }
}
