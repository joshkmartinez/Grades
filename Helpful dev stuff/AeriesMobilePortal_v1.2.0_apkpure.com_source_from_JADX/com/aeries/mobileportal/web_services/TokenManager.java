package com.aeries.mobileportal.web_services;

import android.content.Context;
import android.content.Intent;
import com.aeries.mobileportal.models.RefreshToken;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.views.activities.AuthErrorActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007J\u0006\u0010\u0013\u001a\u00020\u0014J\n\u0010\u0015\u001a\u00020\u0016*\u00020\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/aeries/mobileportal/web_services/TokenManager;", "", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "tokenProvider", "Lcom/aeries/mobileportal/web_services/TokenProvider;", "context", "Landroid/content/Context;", "(Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;Lcom/aeries/mobileportal/web_services/TokenProvider;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getTokenProvider", "()Lcom/aeries/mobileportal/web_services/TokenProvider;", "getUserRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "getNewToken", "", "oldToken", "refreshToken", "startAuthErrorActivity", "", "isValid", "", "Lcom/aeries/mobileportal/models/RefreshToken;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: TokenManager.kt */
public final class TokenManager {
    @NotNull
    private final Context context;
    @NotNull
    private final TokenProvider tokenProvider;
    @NotNull
    private final UserRepository userRepository;

    public TokenManager(@NotNull UserRepository userRepository, @NotNull TokenProvider tokenProvider, @NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(tokenProvider, "tokenProvider");
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
        this.context = context;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final TokenProvider getTokenProvider() {
        return this.tokenProvider;
    }

    @NotNull
    public final UserRepository getUserRepository() {
        return this.userRepository;
    }

    @Nullable
    public final String getNewToken(@Nullable String str) {
        ObjectRef objectRef = new ObjectRef();
        objectRef.element = null;
        if (Intrinsics.areEqual(this.userRepository.getUserName(), (Object) "") && Intrinsics.areEqual(this.userRepository.getGoogleAccount(), (Object) "")) {
            return null;
        }
        this.tokenProvider.performSyncAuthCall(new TokenManager$getNewToken$1(this, objectRef, str));
        return objectRef.element;
    }

    @Nullable
    public final synchronized String refreshToken(@Nullable String str) {
        ObjectRef objectRef;
        objectRef = new ObjectRef();
        objectRef.element = (String) null;
        this.tokenProvider.performAuthRefresh(str, new TokenManager$refreshToken$1(objectRef), new TokenManager$refreshToken$2(this));
        return objectRef.element;
    }

    public final void startAuthErrorActivity() {
        Intent intent = new Intent(this.context, AuthErrorActivity.class);
        intent.setFlags(805306368);
        this.context.startActivity(intent);
    }

    public final boolean isValid(@NotNull RefreshToken refreshToken) {
        Intrinsics.checkParameterIsNotNull(refreshToken, "$receiver");
        String accessToken = refreshToken.getAccessToken();
        if (accessToken == null) {
            Intrinsics.throwNpe();
        }
        if (((CharSequence) accessToken).length() == 0) {
            return false;
        }
        refreshToken = refreshToken.getRefreshToken();
        if (refreshToken == null) {
            Intrinsics.throwNpe();
        }
        return (((CharSequence) refreshToken).length() == null ? 1 : null) == null;
    }
}
