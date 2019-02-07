package com.aeries.mobileportal.views.activities;

import android.accounts.AccountManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/accounts/AccountManager;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: LoginActivity.kt */
final class LoginActivity$accountManager$2 extends Lambda implements Function0<AccountManager> {
    final /* synthetic */ LoginActivity this$0;

    LoginActivity$accountManager$2(LoginActivity loginActivity) {
        this.this$0 = loginActivity;
        super(0);
    }

    public final AccountManager invoke() {
        return AccountManager.get(this.this$0);
    }
}
