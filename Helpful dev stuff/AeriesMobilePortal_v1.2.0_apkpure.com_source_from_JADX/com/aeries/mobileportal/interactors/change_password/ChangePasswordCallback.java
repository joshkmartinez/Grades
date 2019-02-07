package com.aeries.mobileportal.interactors.change_password;

import com.aeries.mobileportal.models.AccountTakenRequest;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/aeries/mobileportal/interactors/change_password/ChangePasswordCallback;", "", "onPasswordChangedError", "", "e", "", "onPasswordChangedFail", "error", "", "onPasswordChangedSuccess", "onUsernameRetrieved", "accountTakenRequest", "Lcom/aeries/mobileportal/models/AccountTakenRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ChangePasswordCallback.kt */
public interface ChangePasswordCallback {
    void onPasswordChangedError(@NotNull Throwable th);

    void onPasswordChangedFail(@NotNull String str);

    void onPasswordChangedSuccess();

    void onUsernameRetrieved(@NotNull AccountTakenRequest accountTakenRequest);
}
