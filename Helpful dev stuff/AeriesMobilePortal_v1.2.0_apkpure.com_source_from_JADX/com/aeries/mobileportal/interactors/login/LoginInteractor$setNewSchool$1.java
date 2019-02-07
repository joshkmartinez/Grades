package com.aeries.mobileportal.interactors.login;

import com.aeries.mobileportal.models.AccountSettings;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/aeries/mobileportal/models/AccountSettings;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: LoginInteractor.kt */
final class LoginInteractor$setNewSchool$1<T> implements Consumer<AccountSettings> {
    final /* synthetic */ LoginCallback $callback;
    final /* synthetic */ LoginInteractor this$0;

    LoginInteractor$setNewSchool$1(LoginInteractor loginInteractor, LoginCallback loginCallback) {
        this.this$0 = loginInteractor;
        this.$callback = loginCallback;
    }

    public final void accept(AccountSettings accountSettings) {
        if (Intrinsics.areEqual(accountSettings.getStatus(), Param.SUCCESS)) {
            LoginInteractor loginInteractor = this.this$0;
            Intrinsics.checkExpressionValueIsNotNull(accountSettings, "it");
            loginInteractor.setAccountSettings(accountSettings);
            this.$callback.onPermissionsRetrieved(accountSettings.getDisableCreateAccount(), accountSettings.getDisableParentChangePassword(), accountSettings.getDisableStudentChangePassword());
            return;
        }
        this.$callback.onPermissionsFail();
    }
}
