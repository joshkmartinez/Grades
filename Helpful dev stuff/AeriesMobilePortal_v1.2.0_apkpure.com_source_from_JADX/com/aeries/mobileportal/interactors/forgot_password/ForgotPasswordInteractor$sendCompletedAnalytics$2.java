package com.aeries.mobileportal.interactors.forgot_password;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: ForgotPasswordInteractor.kt */
final class ForgotPasswordInteractor$sendCompletedAnalytics$2<T> implements Consumer<Throwable> {
    public static final ForgotPasswordInteractor$sendCompletedAnalytics$2 INSTANCE = new ForgotPasswordInteractor$sendCompletedAnalytics$2();

    ForgotPasswordInteractor$sendCompletedAnalytics$2() {
    }

    public final void accept(Throwable th) {
        th.printStackTrace();
    }
}
