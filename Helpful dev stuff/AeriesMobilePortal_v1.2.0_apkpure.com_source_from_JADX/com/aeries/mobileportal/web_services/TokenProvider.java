package com.aeries.mobileportal.web_services;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.utils.StringUtils;
import com.aeries.mobileportal.views.activities.AuthenticationActivity;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.DeferredKt;
import kotlinx.coroutines.experimental.android.HandlerContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J)\u0010\u0011\u001a\u00020\u00102!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00100\u0013JC\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u00142#\u0010\u001a\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00100\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001cJ+\u0010\u001d\u001a\u00020\u00102#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00100\u0013J\u0006\u0010\u001e\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/aeries/mobileportal/web_services/TokenProvider;", "", "accountManager", "Landroid/accounts/AccountManager;", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "tokenRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "(Landroid/accounts/AccountManager;Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;)V", "getAccountManager", "()Landroid/accounts/AccountManager;", "getTokenRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "getUserRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "invalidateToken", "", "performAuthCall", "call", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "token", "performAuthRefresh", "oldToken", "refreshSuccess", "refreshError", "Lkotlin/Function0;", "performSyncAuthCall", "provideToken", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: TokenProvider.kt */
public final class TokenProvider {
    @NotNull
    private final AccountManager accountManager;
    @NotNull
    private final TokenRepository tokenRepository;
    @NotNull
    private final UserRepository userRepository;

    public TokenProvider(@NotNull AccountManager accountManager, @NotNull UserRepository userRepository, @NotNull TokenRepository tokenRepository) {
        Intrinsics.checkParameterIsNotNull(accountManager, "accountManager");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(tokenRepository, "tokenRepository");
        this.accountManager = accountManager;
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    @NotNull
    public final AccountManager getAccountManager() {
        return this.accountManager;
    }

    @NotNull
    public final TokenRepository getTokenRepository() {
        return this.tokenRepository;
    }

    @NotNull
    public final UserRepository getUserRepository() {
        return this.userRepository;
    }

    public final void performAuthCall(@NotNull Function1<? super String, Unit> function1) {
        int length;
        int i;
        Intrinsics.checkParameterIsNotNull(function1, NotificationCompat.CATEGORY_CALL);
        Object accountName = StringUtils.Companion.getAccountName(this.userRepository);
        Object accounts = this.accountManager.getAccounts();
        Intrinsics.checkExpressionValueIsNotNull(accounts, "accountManager.accounts");
        int i2 = 0;
        for (Account account : accounts) {
            Account account2;
            if (Intrinsics.areEqual(account2.name, accountName)) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i != 0) {
            accounts = this.accountManager.getAccounts();
            Intrinsics.checkExpressionValueIsNotNull(accounts, "accountManager.accounts");
            length = accounts.length;
            while (i2 < length) {
                account2 = accounts[i2];
                if (Intrinsics.areEqual(account2.name, accountName)) {
                    DeferredKt.async$default(HandlerContextKt.getUI(), null, new TokenProvider$performAuthCall$2(this.accountManager.getAuthToken(account2, AuthenticationActivity.Companion.getAUTH_TYPE(), null, false, null, null), function1, null), 2, null);
                    return;
                }
                i2++;
            }
            throw ((Throwable) new NoSuchElementException("Array contains no element matching the predicate."));
        }
        function1.invoke(this.tokenRepository.getAccessToken());
    }

    public final void performSyncAuthCall(@NotNull Function1<? super String, Unit> function1) {
        int length;
        int i;
        Intrinsics.checkParameterIsNotNull(function1, NotificationCompat.CATEGORY_CALL);
        Object accountName = StringUtils.Companion.getAccountName(this.userRepository);
        Object accounts = this.accountManager.getAccounts();
        Intrinsics.checkExpressionValueIsNotNull(accounts, "accountManager.accounts");
        int i2 = 0;
        for (Account account : accounts) {
            if (Intrinsics.areEqual(account.name, accountName)) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i != 0) {
            accounts = this.accountManager.getAccounts();
            Intrinsics.checkExpressionValueIsNotNull(accounts, "accountManager.accounts");
            length = accounts.length;
            while (i2 < length) {
                Account account2 = accounts[i2];
                if (Intrinsics.areEqual(account2.name, accountName)) {
                    AccountManagerFuture authToken = this.accountManager.getAuthToken(account2, AuthenticationActivity.Companion.getAUTH_TYPE(), null, false, null, null);
                    Intrinsics.checkExpressionValueIsNotNull(authToken, "tokenBundle");
                    accountName = ((Bundle) authToken.getResult()).get("authtoken");
                    if (!(accountName instanceof String)) {
                        accountName = null;
                    }
                    function1.invoke((String) accountName);
                    return;
                }
                i2++;
            }
            throw ((Throwable) new NoSuchElementException("Array contains no element matching the predicate."));
        }
        function1.invoke(null);
    }

    public final void performAuthRefresh(@Nullable String str, @NotNull Function1<? super String, Unit> function1, @NotNull Function0<Unit> function0) {
        int i;
        Intrinsics.checkParameterIsNotNull(function1, "refreshSuccess");
        Intrinsics.checkParameterIsNotNull(function0, "refreshError");
        Object accountName = StringUtils.Companion.getAccountName(this.userRepository);
        Object accounts = this.accountManager.getAccounts();
        Intrinsics.checkExpressionValueIsNotNull(accounts, "accountManager.accounts");
        int i2 = 0;
        for (Account account : accounts) {
            Account account2;
            if (Intrinsics.areEqual(account2.name, accountName)) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i != 0) {
            function0 = this.accountManager.getAccounts();
            Intrinsics.checkExpressionValueIsNotNull(function0, "accountManager.accounts");
            i = function0.length;
            while (i2 < i) {
                Account account3 = function0[i2];
                if (Intrinsics.areEqual(account3.name, accountName)) {
                    account2 = account3;
                    break;
                }
                i2++;
            }
            account2 = null;
            this.accountManager.invalidateAuthToken(AuthenticationActivity.Companion.getACCOUNT_TYPE(), str);
            str = this.accountManager.getAuthToken(account2, AuthenticationActivity.Companion.getAUTH_TYPE(), null, false, null, null);
            Intrinsics.checkExpressionValueIsNotNull(str, "tokenBundle");
            str = ((Bundle) str.getResult()).get("authtoken");
            if ((str instanceof String) == null) {
                str = null;
            }
            function1.invoke(str);
            return;
        }
        function0.invoke();
    }

    public final void invalidateToken() {
        int length;
        int i;
        Object accountName = StringUtils.Companion.getAccountName(this.userRepository);
        this.tokenRepository.deleteAccessToken();
        Object accounts = this.accountManager.getAccounts();
        Intrinsics.checkExpressionValueIsNotNull(accounts, "accountManager.accounts");
        int i2 = 0;
        for (Account account : accounts) {
            if (Intrinsics.areEqual(account.name, accountName)) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i != 0) {
            Account account2;
            accounts = this.accountManager.getAccounts();
            Intrinsics.checkExpressionValueIsNotNull(accounts, "accountManager.accounts");
            length = accounts.length;
            while (i2 < length) {
                account2 = accounts[i2];
                if (Intrinsics.areEqual(account2.name, accountName)) {
                    break;
                }
                i2++;
            }
            account2 = null;
            this.accountManager.setAuthToken(account2, AuthenticationActivity.Companion.getAUTH_TYPE(), "");
        }
    }

    @NotNull
    public final String provideToken() {
        int length;
        int i;
        Object accountName = StringUtils.Companion.getAccountName(this.userRepository);
        Object accounts = this.accountManager.getAccounts();
        Intrinsics.checkExpressionValueIsNotNull(accounts, "accountManager.accounts");
        int i2 = 0;
        for (Account account : accounts) {
            Account account2;
            if (Intrinsics.areEqual(account2.name, accountName)) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i == 0) {
            return this.tokenRepository.getAccessToken();
        }
        Account account3;
        accounts = this.accountManager.getAccounts();
        Intrinsics.checkExpressionValueIsNotNull(accounts, "accountManager.accounts");
        length = accounts.length;
        while (i2 < length) {
            account2 = accounts[i2];
            if (Intrinsics.areEqual(account2.name, accountName)) {
                account3 = account2;
                break;
            }
            i2++;
        }
        account3 = null;
        AccountManagerFuture authToken = this.accountManager.getAuthToken(account3, AuthenticationActivity.Companion.getAUTH_TYPE(), null, false, null, null);
        Intrinsics.checkExpressionValueIsNotNull(authToken, "tokenBundle");
        accountName = ((Bundle) authToken.getResult()).get("authtoken");
        if (!(accountName instanceof String)) {
            accountName = null;
        }
        String str = (String) accountName;
        if (str != null) {
            return str;
        }
        return "";
    }
}
