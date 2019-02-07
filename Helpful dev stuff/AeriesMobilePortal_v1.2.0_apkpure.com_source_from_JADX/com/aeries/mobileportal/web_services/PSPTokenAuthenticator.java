package com.aeries.mobileportal.web_services;

import io.fabric.sdk.android.services.network.HttpRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/aeries/mobileportal/web_services/PSPTokenAuthenticator;", "Lokhttp3/Authenticator;", "tokenManager", "Lcom/aeries/mobileportal/web_services/TokenManager;", "(Lcom/aeries/mobileportal/web_services/TokenManager;)V", "AUTHORIZATION", "", "getTokenManager", "()Lcom/aeries/mobileportal/web_services/TokenManager;", "authenticate", "Lokhttp3/Request;", "route", "Lokhttp3/Route;", "response", "Lokhttp3/Response;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: PSPTokenAuthenticator.kt */
public final class PSPTokenAuthenticator implements Authenticator {
    private final String AUTHORIZATION = HttpRequest.HEADER_AUTHORIZATION;
    @NotNull
    private final TokenManager tokenManager;

    public PSPTokenAuthenticator(@NotNull TokenManager tokenManager) {
        Intrinsics.checkParameterIsNotNull(tokenManager, "tokenManager");
        this.tokenManager = tokenManager;
    }

    @NotNull
    public final TokenManager getTokenManager() {
        return this.tokenManager;
    }

    @Nullable
    public Request authenticate(@Nullable Route route, @Nullable Response response) {
        if (response == null) {
            Intrinsics.throwNpe();
        }
        route = response.request();
        Intrinsics.checkExpressionValueIsNotNull(route, "response!!.request()");
        response = this.tokenManager.getNewToken(route.header(this.AUTHORIZATION));
        if (response != null) {
            return route.newBuilder().header(this.AUTHORIZATION, response).build();
        }
        this.tokenManager.startAuthErrorActivity();
        return null;
    }
}
