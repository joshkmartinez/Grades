package com.aeries.mobileportal.interactors.create_account;

import com.aeries.mobileportal.models.CreateAccountResponse;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/aeries/mobileportal/models/CreateAccountResponse;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: CreateAccountInteractor.kt */
final class CreateAccountInteractor$createAccount$1<T> implements Consumer<CreateAccountResponse> {
    final /* synthetic */ CreateAccountCallback $callback;

    CreateAccountInteractor$createAccount$1(CreateAccountCallback createAccountCallback) {
        this.$callback = createAccountCallback;
    }

    public final void accept(CreateAccountResponse createAccountResponse) {
        if (Intrinsics.areEqual(createAccountResponse.getError(), (Object) "")) {
            CreateAccountCallback createAccountCallback = this.$callback;
            Intrinsics.checkExpressionValueIsNotNull(createAccountResponse, "it");
            createAccountCallback.onAccountCreated(createAccountResponse);
            return;
        }
        this.$callback.onAccountNotCreated(createAccountResponse.getError());
    }
}
