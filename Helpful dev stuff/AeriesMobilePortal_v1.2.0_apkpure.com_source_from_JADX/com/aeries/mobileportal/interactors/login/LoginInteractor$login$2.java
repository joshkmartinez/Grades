package com.aeries.mobileportal.interactors.login;

import com.aeries.mobileportal.C0316R;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: LoginInteractor.kt */
final class LoginInteractor$login$2<T> implements Consumer<Throwable> {
    final /* synthetic */ boolean $hide500Error;
    final /* synthetic */ LoginCallback $loginCallback;
    final /* synthetic */ LoginInteractor this$0;

    LoginInteractor$login$2(LoginInteractor loginInteractor, LoginCallback loginCallback, boolean z) {
        this.this$0 = loginInteractor;
        this.$loginCallback = loginCallback;
        this.$hide500Error = z;
    }

    public final void accept(Throwable th) {
        th.printStackTrace();
        LoginCallback loginCallback = this.$loginCallback;
        if (this.$hide500Error) {
            th = new Throwable(this.this$0.getContext().getString(C0316R.string.wrong_username_or_password));
        }
        Intrinsics.checkExpressionValueIsNotNull(th, "if (hide500Error) Throwa…               else error");
        loginCallback.onLoginError(th);
    }
}
