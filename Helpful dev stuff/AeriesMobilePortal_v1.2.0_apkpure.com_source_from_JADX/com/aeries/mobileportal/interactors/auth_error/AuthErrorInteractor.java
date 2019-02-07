package com.aeries.mobileportal.interactors.auth_error;

import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/interactors/auth_error/AuthErrorInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "tokenRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "(Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;)V", "getTokenRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "deleteToken", "", "callback", "Lcom/aeries/mobileportal/interactors/auth_error/AuthErrorCallback;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AuthErrorInteractor.kt */
public final class AuthErrorInteractor extends BaseInteractor {
    @NotNull
    private final TokenRepository tokenRepository;

    public AuthErrorInteractor(@NotNull TokenRepository tokenRepository) {
        Intrinsics.checkParameterIsNotNull(tokenRepository, "tokenRepository");
        this.tokenRepository = tokenRepository;
    }

    @NotNull
    public final TokenRepository getTokenRepository() {
        return this.tokenRepository;
    }

    public final void deleteToken(@NotNull AuthErrorCallback authErrorCallback) {
        Intrinsics.checkParameterIsNotNull(authErrorCallback, "callback");
        this.tokenRepository.deleteAccessToken();
        authErrorCallback.onTokenDeleted();
    }
}
