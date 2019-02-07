package com.aeries.mobileportal.interactors.login;

import com.aeries.mobileportal.models.AuthenticationData;
import com.aeries.mobileportal.models.User;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/aeries/mobileportal/models/AuthenticationData;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: LoginInteractor.kt */
final class LoginInteractor$getAuthToken$1<T> implements Consumer<AuthenticationData> {
    final /* synthetic */ LoginCallback $callback;
    final /* synthetic */ User $user;
    final /* synthetic */ LoginInteractor this$0;

    LoginInteractor$getAuthToken$1(LoginInteractor loginInteractor, User user, LoginCallback loginCallback) {
        this.this$0 = loginInteractor;
        this.$user = user;
        this.$callback = loginCallback;
    }

    public final void accept(AuthenticationData authenticationData) {
        LoginInteractor loginInteractor = this.this$0;
        User user = this.$user;
        Intrinsics.checkExpressionValueIsNotNull(authenticationData, "it");
        loginInteractor.addAccountToManager(user, authenticationData);
        this.$callback.onAuthTokenSuccess(authenticationData);
    }
}
