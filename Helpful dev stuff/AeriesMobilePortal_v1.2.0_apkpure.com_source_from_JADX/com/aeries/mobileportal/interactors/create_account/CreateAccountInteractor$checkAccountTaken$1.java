package com.aeries.mobileportal.interactors.create_account;

import com.aeries.mobileportal.models.AccountTakenResponse;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/aeries/mobileportal/models/AccountTakenResponse;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: CreateAccountInteractor.kt */
final class CreateAccountInteractor$checkAccountTaken$1<T> implements Consumer<AccountTakenResponse> {
    final /* synthetic */ CreateAccountCallback $callback;

    CreateAccountInteractor$checkAccountTaken$1(CreateAccountCallback createAccountCallback) {
        this.$callback = createAccountCallback;
    }

    public final void accept(AccountTakenResponse accountTakenResponse) {
        if (!Intrinsics.areEqual(accountTakenResponse.getError(), (Object) "")) {
            this.$callback.onAccountTaken(accountTakenResponse.getError());
        } else if (Intrinsics.areEqual(accountTakenResponse.getRequirePassword(), Boolean.valueOf(true))) {
            r0 = this.$callback;
            Intrinsics.checkExpressionValueIsNotNull(accountTakenResponse, "it");
            r0.onAccountRequirePassword(accountTakenResponse);
        } else {
            r0 = this.$callback;
            Intrinsics.checkExpressionValueIsNotNull(accountTakenResponse, "it");
            r0.onAccountDontRequirePassword(accountTakenResponse);
        }
    }
}
