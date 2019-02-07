package com.google.android.gms.auth.account;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;

final class zzj implements ResultConverter<AddAccountResult, Account> {
    zzj(WorkAccountClient workAccountClient) {
    }

    public final /* synthetic */ Object convert(Result result) {
        return ((AddAccountResult) result).getAccount();
    }
}
