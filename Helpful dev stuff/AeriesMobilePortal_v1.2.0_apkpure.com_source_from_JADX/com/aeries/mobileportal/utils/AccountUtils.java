package com.aeries.mobileportal.utils;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/utils/AccountUtils;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AccountUtils.kt */
public final class AccountUtils {
    public static final Companion Companion = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/utils/AccountUtils$Companion;", "", "()V", "getAccount", "Landroid/accounts/Account;", "accountManager", "Landroid/accounts/AccountManager;", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AccountUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final Account getAccount(@NotNull AccountManager accountManager, @NotNull UserRepository userRepository) {
            int i;
            Intrinsics.checkParameterIsNotNull(accountManager, "accountManager");
            Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
            Object accountName = StringUtils.Companion.getAccountName(userRepository);
            Object accounts = accountManager.getAccounts();
            Intrinsics.checkExpressionValueIsNotNull(accounts, "accountManager.accounts");
            int i2 = 0;
            for (Account account : accounts) {
                if (Intrinsics.areEqual(account.name, accountName)) {
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                return null;
            }
            accountManager = accountManager.getAccounts();
            Intrinsics.checkExpressionValueIsNotNull(accountManager, "accountManager.accounts");
            i = accountManager.length;
            while (i2 < i) {
                Account account2 = accountManager[i2];
                if (Intrinsics.areEqual(account2.name, accountName)) {
                    return account2;
                }
                i2++;
            }
            throw ((Throwable) new NoSuchElementException("Array contains no element matching the predicate."));
        }
    }
}
