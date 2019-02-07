package com.aeries.mobileportal.interactors.create_account;

import com.aeries.mobileportal.models.AccountTakenResponse;
import com.aeries.mobileportal.models.CreateAccountResponse;
import com.aeries.mobileportal.models.GenericServiceResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\u0017"}, d2 = {"Lcom/aeries/mobileportal/interactors/create_account/CreateAccountCallback;", "", "onAccountConfirmed", "", "genericServiceResponse", "Lcom/aeries/mobileportal/models/GenericServiceResponse;", "onAccountConfirmedError", "e", "", "onAccountCreated", "createAccountResponse", "Lcom/aeries/mobileportal/models/CreateAccountResponse;", "onAccountCreatedError", "onAccountDontRequirePassword", "accountTakenResponse", "Lcom/aeries/mobileportal/models/AccountTakenResponse;", "onAccountNotConfirmed", "error", "", "onAccountNotCreated", "onAccountRequirePassword", "onAccountTaken", "onAccountTakenError", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CreateAccountCallback.kt */
public interface CreateAccountCallback {
    void onAccountConfirmed(@NotNull GenericServiceResponse genericServiceResponse);

    void onAccountConfirmedError(@NotNull Throwable th);

    void onAccountCreated(@NotNull CreateAccountResponse createAccountResponse);

    void onAccountCreatedError(@NotNull Throwable th);

    void onAccountDontRequirePassword(@NotNull AccountTakenResponse accountTakenResponse);

    void onAccountNotConfirmed(@NotNull String str);

    void onAccountNotCreated(@NotNull String str);

    void onAccountRequirePassword(@NotNull AccountTakenResponse accountTakenResponse);

    void onAccountTaken(@NotNull String str);

    void onAccountTakenError(@NotNull Throwable th);
}
