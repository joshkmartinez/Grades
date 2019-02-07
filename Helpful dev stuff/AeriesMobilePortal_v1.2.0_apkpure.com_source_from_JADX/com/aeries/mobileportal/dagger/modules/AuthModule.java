package com.aeries.mobileportal.dagger.modules;

import android.accounts.AccountManager;
import android.content.Context;
import com.aeries.mobileportal.dagger.scopes.PSPApplicationScope;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/AuthModule;", "", "()V", "accManager", "Landroid/accounts/AccountManager;", "context", "Landroid/content/Context;", "tokenProvider", "Lcom/aeries/mobileportal/web_services/TokenProvider;", "accountManager", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "tokenRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: AuthModule.kt */
public final class AuthModule {
    @NotNull
    @PSPApplicationScope
    @Provides
    public final AccountManager accManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        context = AccountManager.get(context);
        Intrinsics.checkExpressionValueIsNotNull(context, "AccountManager.get(context)");
        return context;
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final TokenProvider tokenProvider(@NotNull AccountManager accountManager, @NotNull UserRepository userRepository, @NotNull TokenRepository tokenRepository) {
        Intrinsics.checkParameterIsNotNull(accountManager, "accountManager");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(tokenRepository, "tokenRepository");
        return new TokenProvider(accountManager, userRepository, tokenRepository);
    }
}
