package com.aeries.mobileportal;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.aeries.mobileportal.models.RefreshUser;
import com.aeries.mobileportal.views.activities.AuthenticationActivity;
import com.google.android.gms.auth.zzg;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JG\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0010\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0015J&\u0010\u0016\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0018\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J0\u0010\u0019\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u0010H\u0016J3\u0010\u001b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00172\u0010\u0010\u0011\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0010\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u001cJ0\u0010\u001d\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/aeries/mobileportal/PSPAuthenticator;", "Landroid/accounts/AbstractAccountAuthenticator;", "context", "Landroid/content/Context;", "listener", "Lcom/aeries/mobileportal/PSPAuthenticator$PSPAuthenticatorListener;", "(Landroid/content/Context;Lcom/aeries/mobileportal/PSPAuthenticator$PSPAuthenticatorListener;)V", "getContext", "()Landroid/content/Context;", "getListener", "()Lcom/aeries/mobileportal/PSPAuthenticator$PSPAuthenticatorListener;", "addAccount", "Landroid/os/Bundle;", "p0", "Landroid/accounts/AccountAuthenticatorResponse;", "p1", "", "p2", "p3", "", "p4", "(Landroid/accounts/AccountAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;", "confirmCredentials", "Landroid/accounts/Account;", "editProperties", "getAuthToken", "getAuthTokenLabel", "hasFeatures", "(Landroid/accounts/AccountAuthenticatorResponse;Landroid/accounts/Account;[Ljava/lang/String;)Landroid/os/Bundle;", "updateCredentials", "PSPAuthenticatorListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: PSPAuthenticator.kt */
public final class PSPAuthenticator extends AbstractAccountAuthenticator {
    @NotNull
    private final Context context;
    @NotNull
    private final PSPAuthenticatorListener listener;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/PSPAuthenticator$PSPAuthenticatorListener;", "", "getToken", "", "password", "refreshToken", "", "refreshUser", "Lcom/aeries/mobileportal/models/RefreshUser;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: PSPAuthenticator.kt */
    public interface PSPAuthenticatorListener {
        @Nullable
        String getToken(@NotNull String str);

        void refreshToken(@NotNull RefreshUser refreshUser);
    }

    public PSPAuthenticator(@NotNull Context context, @NotNull PSPAuthenticatorListener pSPAuthenticatorListener) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(pSPAuthenticatorListener, CastExtraArgs.LISTENER);
        super(context);
        this.context = context;
        this.listener = pSPAuthenticatorListener;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final PSPAuthenticatorListener getListener() {
        return this.listener;
    }

    @NotNull
    public String getAuthTokenLabel(@Nullable String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("An operation is not implemented: ");
        stringBuilder.append("not implemented");
        throw ((Throwable) new NotImplementedError(stringBuilder.toString()));
    }

    @NotNull
    public Bundle confirmCredentials(@Nullable AccountAuthenticatorResponse accountAuthenticatorResponse, @Nullable Account account, @Nullable Bundle bundle) {
        account = new StringBuilder();
        account.append("An operation is not implemented: ");
        account.append("not implemented");
        throw ((Throwable) new NotImplementedError(account.toString()));
    }

    @NotNull
    public Bundle updateCredentials(@Nullable AccountAuthenticatorResponse accountAuthenticatorResponse, @Nullable Account account, @Nullable String str, @Nullable Bundle bundle) {
        account = new StringBuilder();
        account.append("An operation is not implemented: ");
        account.append("not implemented");
        throw ((Throwable) new NotImplementedError(account.toString()));
    }

    @NotNull
    public Bundle getAuthToken(@Nullable AccountAuthenticatorResponse accountAuthenticatorResponse, @Nullable Account account, @Nullable String str, @Nullable Bundle bundle) {
        String str2 = null;
        if (this.context.getPackageManager().checkSignatures(BuildConfig.APPLICATION_ID, bundle != null ? bundle.getString(zzg.KEY_ANDROID_PACKAGE_NAME) : null) >= null) {
            bundle = AccountManager.get(this.context);
            String peekAuthToken = bundle.peekAuthToken(account, str);
            if (TextUtils.isEmpty(peekAuthToken)) {
                bundle = bundle.getPassword(account);
                if (!(bundle == null || account == null)) {
                    Log.d("PSP_AUTHENTICATOR", "Access token requested by authenticator");
                }
                PSPAuthenticatorListener pSPAuthenticatorListener = this.listener;
                Intrinsics.checkExpressionValueIsNotNull(bundle, "password");
                peekAuthToken = pSPAuthenticatorListener.getToken(bundle);
            }
            if (TextUtils.isEmpty(peekAuthToken) == null) {
                accountAuthenticatorResponse = new Bundle();
                accountAuthenticatorResponse.putString("authAccount", account != null ? account.name : null);
                str = "accountType";
                if (account != null) {
                    str2 = account.type;
                }
                accountAuthenticatorResponse.putString(str, str2);
                accountAuthenticatorResponse.putString("authtoken", peekAuthToken);
                return accountAuthenticatorResponse;
            }
            bundle = new Intent(this.context, AuthenticationActivity.class);
            bundle.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
            accountAuthenticatorResponse = AuthenticationActivity.Companion.getACCOUNT_TYPE();
            if (account != null) {
                str2 = account.type;
            }
            bundle.putExtra(accountAuthenticatorResponse, str2);
            bundle.putExtra(AuthenticationActivity.Companion.getAUTH_TYPE(), str);
            accountAuthenticatorResponse = new Bundle();
            accountAuthenticatorResponse.putParcelable("intent", bundle);
            return accountAuthenticatorResponse;
        }
        accountAuthenticatorResponse = Bundle.EMPTY;
        Intrinsics.checkExpressionValueIsNotNull(accountAuthenticatorResponse, "Bundle.EMPTY");
        return accountAuthenticatorResponse;
    }

    @NotNull
    public Bundle hasFeatures(@Nullable AccountAuthenticatorResponse accountAuthenticatorResponse, @Nullable Account account, @Nullable String[] strArr) {
        account = new StringBuilder();
        account.append("An operation is not implemented: ");
        account.append("not implemented");
        throw ((Throwable) new NotImplementedError(account.toString()));
    }

    @NotNull
    public Bundle editProperties(@Nullable AccountAuthenticatorResponse accountAuthenticatorResponse, @Nullable String str) {
        return new Bundle();
    }

    @NotNull
    public Bundle addAccount(@Nullable AccountAuthenticatorResponse accountAuthenticatorResponse, @Nullable String str, @Nullable String str2, @Nullable String[] strArr, @Nullable Bundle bundle) {
        strArr = new Intent(this.context, AuthenticationActivity.class);
        strArr.putExtra(AuthenticationActivity.Companion.getACCOUNT_TYPE(), str);
        strArr.putExtra(AuthenticationActivity.Companion.getAUTH_TYPE(), str2);
        strArr.putExtra(AuthenticationActivity.Companion.getADDING_NEW_ACC(), true);
        strArr.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        accountAuthenticatorResponse = new Bundle();
        accountAuthenticatorResponse.putParcelable("intent", (Parcelable) strArr);
        return accountAuthenticatorResponse;
    }
}
